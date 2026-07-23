/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.io.Connector
 *  javax.microedition.io.HttpConnection
 */
import java.io.InputStream;
import java.util.Hashtable;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

public final class p
extends r
implements d,
j {
    private static final Hashtable var_java_util_Hashtable_b;
    private static final byte var_byte_b = 0;
    private static final byte c = 1;
    private j var_j_b;

    static {
        var_java_util_Hashtable_b = new Hashtable<String, Byte>(4);
        var_java_util_Hashtable_b.put("d", new Byte(0));
        var_java_util_Hashtable_b.put("get", new Byte(1));
    }

    private static void b(i i2) {
        m m2 = new m(new n());
        i2.var_l_b.var_j_b.b("Secure", (Object)m2);
    }

    private void b(e e2, String string, Object object) {
        try {
            Object object2;
            Object object3;
            Object object4;
            string = (HttpConnection)Connector.open((String)string);
            if (this.var_j_b != null) {
                string.setRequestMethod("POST");
                object4 = null;
                object3 = "";
                while ((object4 = this.var_j_b.java_lang_Object_c(object4)) != null) {
                    object2 = this.var_j_b.java_lang_Object_b(object4);
                    if (object2 == null) continue;
                    object3 = String.valueOf(object3) + "&" + object4.toString() + "=" + a.java_lang_String_b(object2.toString());
                }
                if (!"".equals(object3)) {
                    string.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    string.setRequestProperty("Content-Length", String.valueOf(((String)object3).length()));
                    string.openOutputStream().write(((String)object3).getBytes());
                }
            } else {
                string.setRequestMethod("GET");
            }
            if (string.getResponseCode() == 200) {
                Object[] objectArray;
                this.var_j_b = null;
                object4 = new i();
                object3 = string.openDataInputStream();
                e2 = null;
                object2 = h.b((InputStream)object3, ((i)object4).var_l_b.var_j_b);
                if (object == null) {
                    objectArray = null;
                } else {
                    Object[] objectArray2 = new Object[1];
                    objectArray = objectArray2;
                    objectArray2[0] = object;
                }
                e2 = objectArray;
                ((i)object4).java_lang_Object_arr_b(object2, (Object[])e2);
                ((InputStream)object3).close();
                return;
            }
            if (string.getResponseCode() == 301 || string.getResponseCode() == 302) {
                object4 = string.getHeaderField("location");
                this.b(e2, (String)object4, object);
                string.close();
                return;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final void b(Object object, Object object2) {
        if ((object = var_java_util_Hashtable_b.get(object)) instanceof Byte && (Byte)object == 0) {
            this.var_j_b = (j)object2;
        }
    }

    public final Object java_lang_Object_b(Object object) {
        if ((object = var_java_util_Hashtable_b.get(object)) == null) {
            return null;
        }
        if (object instanceof Byte) {
            byte by = (Byte)object;
            if (by == 0) {
                return this.var_j_b;
            }
            return new c(this, by);
        }
        return object;
    }

    public final int b() {
        return 0;
    }
}

