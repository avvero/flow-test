import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.AutoFlushingObjectWriter;
import ch.qos.logback.core.net.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 * @author fxdev-belyaev-ay
 */
public class Robot2 {

    private static int X = 100;
    private static int T = 10;

    private static final Logger log = LoggerFactory.getLogger(Robot2.class);

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < T; i++) {
            new Thread(getRunButchTread(i)).start();
        }
    }

    public static void sendButch(int n) throws IOException {
        Socket socket = new Socket("localhost", 4561);
        for (int i = 0; i < X; i++) {

            ObjectWriter objectWriter = new AutoFlushingObjectWriter(new ObjectOutputStream(socket.getOutputStream()), CoreConstants.OOS_RESET_FREQUENCY);
//            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            Serializable serializableEvent = "Thread "+ n + " - connection " + i;
            objectWriter.write(serializableEvent);
//            out.flush();

            System.out.println(serializableEvent);
        }
//        socket.close();
        System.in.read();
    }

    public static final Runnable getRunButchTread(int n){
        return new Runnable(){
            @Override
            public void run() {
                try {
                    sendButch(n);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

}
