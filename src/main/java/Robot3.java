import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.net.SocketAppender;
import ch.qos.logback.classic.spi.LoggingEvent;
import com.avvero.flow.support.logback.StreamPerEventSocketAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 * @author fxdev-belyaev-ay
 */
public class Robot3 {

    private static int X = 5;
    private static int T = 10;

    private static final Logger log = LoggerFactory.getLogger(Robot3.class);

    public static void main(String[] args) throws IOException {
        LoggerContext context = new LoggerContext();

        StreamPerEventSocketAppender socketAppender = new StreamPerEventSocketAppender();
        socketAppender.setPort(4561);
        socketAppender.setRemoteHost("localhost");
        socketAppender.setContext(context);
        socketAppender.setQueueSize(1);

        socketAppender.start();

//        socketAppender.addInfo("Info");

        for (int i = 0; i < X; i++) {
            LoggingEvent event = new LoggingEvent();
            event.setLevel(Level.INFO);
            socketAppender.doAppend(event);
//            socketAppender.addInfo("Info");
        }
    }
}
