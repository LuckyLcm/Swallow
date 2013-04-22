package cn.swallowserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author Chen Haoming
 */
public class Writer extends HandlerTread {

    private static final transient Logger log = LoggerFactory.getLogger (Writer.class);

    Writer (Server server) {
        super (server);
    }

    @Override
    protected void preRunning () {

    }

    @Override
    protected void running () {
        SocketChannel channel = getQueue().poll ();
        ByteBuffer buffer = getBuffer ();
        buffer.clear ();
        byte[] allBytesRead = new byte[0];

        try {
            int len = channel.read (buffer);
            if (len > 0) {
                buffer.flip ();
                byte[] bytes = Arrays.copyOf (buffer.array (), len);
                byte[] temBytes = allBytesRead;
                allBytesRead = new byte[temBytes.length + bytes.length];
                System.arraycopy (temBytes, 0, allBytesRead, 0, temBytes.length);
                System.arraycopy (bytes, 0, allBytesRead, temBytes.length, bytes.length);
            }
        } catch (IOException e) {
            log.error ("Exception occurred when reading from SocketChannel:{}\nMessage:", channel, e.getMessage ());
            return;
        }

        String msg = Charset.forName (getServer ().getEncoding ()).decode (ByteBuffer.wrap (allBytesRead)).toString ();
        buffer.clear ();
        log.debug ("Read message: {}", msg);
        // todo: deal with msg;
    }

    @Override
    protected void postRunning () {

    }
}
