import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author fxdev-belyaev-ay
 */
public class Robot {

    private static int X = 1000;
    private static int T = 10;

    private static final Logger log = LoggerFactory.getLogger(Robot.class);

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < T; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < X; i1++) {
                    log.trace("Trace " + i1);
//                        log.debug("Debug " + i);
//                        log.info("Info " + i);
//                        log.warn("Warn " + i);
//                        log.error("Error " + i);
                }
            }).start();
        }
        System.in.read();
    }

}
