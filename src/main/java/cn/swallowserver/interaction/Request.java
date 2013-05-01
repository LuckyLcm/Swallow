package cn.swallowserver.interaction;

/**
 * @author Chen Haoming
 */
public interface Request extends Interaction {

    /**
     *
     * @return Byte array of original message sent by remote client.
     */
    byte[] getOriginalMessage();

    /**
     *
     * @return <code>String</code> message encoded from <code>getOriginalMessage()</code>
     */
    String getMessage();

    RequestContext getRequestContext();
}
