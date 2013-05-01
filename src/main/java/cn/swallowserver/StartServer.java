package cn.swallowserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *  @author Chen Haoming
 *
 *  It's the Entrance of the whole server. So it only holds an "main" method.
 */
public class StartServer {

    private static final transient Logger log = LoggerFactory.getLogger(StartServer.class);

    public static void main(String[] args) {
        ApplicationContext appCtx = new FileSystemXmlApplicationContext("classpath*:swallow.xml");
        ThreadTemplate swallowserver = (ThreadTemplate) appCtx.getBean("swallowserver");
        swallowserver.start();
    }
}
