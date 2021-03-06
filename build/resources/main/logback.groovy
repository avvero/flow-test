//
// Built on Wed Oct 07 09:44:43 UTC 2015 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport
import ch.qos.logback.classic.AsyncAppender
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import com.avvero.flow.support.logback.MarkerSocketAppender

import static ch.qos.logback.classic.Level.TRACE

appender("SOCKET", MarkerSocketAppender) {
    remoteHost = "localhost"
    port = 4561
    queueSize = Integer.MAX_VALUE
    marker = "test"
}

appender("stdout", ConsoleAppender) {
    target = "System.out"
    encoder(PatternLayoutEncoder) {
        charset = java.nio.charset.StandardCharsets.UTF_8
        pattern = "%d{yyyy-MM-dd HH:mm:ss} %5p \\(%mdc{userLogin},%mdc{sessionId}\\) %t %c{0}:%M:%L - %m%n"
    }
}


logger("com", TRACE, ["file", "stdout", "SOCKET"])
root(TRACE, ["SOCKET", "stdout"])