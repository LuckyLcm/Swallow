package cn.swallowserver.dispatcher;


import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;
import cn.swallowserver.nio.NIOSession;
import cn.swallowserver.session.Session;
import junit.framework.TestCase;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.internal.ReturnDefaultValueAction;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertSame;

/**
 * @author ICMLucky
 */
@RunWith (JMock.class)
public class DispatchTaskTest {

    private JUnit4Mockery jUnit4Mockery = new JUnit4Mockery ();

    @Test
    public void testRun () {
        System.out.println ("yes");
    }


}
