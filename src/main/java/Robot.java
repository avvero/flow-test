import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fxdev-belyaev-ay
 */
public class Robot {

    private static int X = 1000;

    private static final Logger log = LoggerFactory.getLogger(Robot.class);

    public static void main(String[] args) {
        for (int i = 0; i < X; i++) {
            log.trace("Trace " + i);
            log.debug("Debug " + i);
            log.info("Info " + i);
            log.warn("Warn " + i);
            log.error("Error " + i);
        }
    }

}
