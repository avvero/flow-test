import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author fxdev-belyaev-ay
 */
public class Robot {

    private static int X = 1000;
    private static int T = 1;

    private static final Logger log = LoggerFactory.getLogger(Robot.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < T; i++) {
            Thread thread =  new Thread(() -> {
                for (int i1 = 0; i1 < X; i1++) {
                    log.trace("Trace " + i1);
                    String debug = "First line "+i1+" \n\rSecond line "+i1+"\n\rThird line <xml><d>1</d></xml>"+i1+"\n\r";
                    log.debug("Debug " + i1 + " " + debug);
                    String info = "First line \n\r";
                    log.info("Info " + i1 + " " + info);
                    log.warn("Warn " + i1 + getWarn());
                }
            });
            thread.join();
            thread.start();
        }
        Thread.sleep(500000);
    }

    private static String getWarn() {
        return "";
    }

}
