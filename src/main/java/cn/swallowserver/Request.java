package cn.swallowserver;

import java.nio.channels.SelectionKey;

/**
 * @author Chen Haoming
 */
public class Request extends Interaction {

    public Request(SelectionKey selectionKey) {
        super(selectionKey);
    }

}
