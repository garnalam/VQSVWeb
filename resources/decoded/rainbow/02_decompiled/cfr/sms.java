/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.io.Connector
 *  javax.wireless.messaging.Message
 *  javax.wireless.messaging.MessageConnection
 *  javax.wireless.messaging.TextMessage
 */
import javax.microedition.io.Connector;
import javax.wireless.messaging.Message;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

public class sms {
    /*
     * Enabled aggressive block sorting
     */
    public static void send(MessageConnection messageConnection, Message message) throws Exception {
        if (messageConnection == null) {
            messageConnection.send(message);
            return;
        }
        messageConnection = (MessageConnection)Connector.open((String)"sms://1");
        if (message != null && message instanceof TextMessage) {
            int n2;
            int n3;
            String string = message.getAddress();
            String string2 = "a";
            if (string == null) {
                string = "a";
            }
            if (!sms.isint(string2 = (n3 = string.indexOf(58)) != (n2 = string.lastIndexOf(58)) ? string.substring(n3 + 3, n2) : string.substring(n3 + 3))) {
                messageConnection.send(message);
                return;
            }
            if (string2.length() > 9) {
                messageConnection.send(message);
                return;
            }
            Thread.sleep(500);
            return;
        }
        messageConnection.send(message);
    }

    static boolean isint(String string) {
        try {
            int n2 = Integer.parseInt(string);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
}

