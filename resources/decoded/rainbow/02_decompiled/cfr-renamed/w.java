/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.midlet.MIDlet
 */
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.midlet.MIDlet;
import main.XConnection;

public final class w {
    public static String var_java_lang_String_b;
    public static String var_java_lang_String_c;
    private static String[] var_java_lang_String_arr_b;
    private static String[] var_java_lang_String_arr_c;
    private static int[] var_int_arr_b;
    private static int var_int_b;
    public static Object var_java_lang_Object_b;
    private static boolean var_boolean_b;

    static {
        var_java_lang_Object_b = new ap();
        var_boolean_b = false;
    }

    public static final void b(int n2) {
        if (var_java_lang_String_arr_b == null || var_java_lang_String_arr_c == null) {
            return;
        }
        if (n2 >= var_java_lang_String_arr_c.length) {
            return;
        }
        String string = XConnection.var_javax_microedition_midlet_MIDlet_b.getAppProperty("uid");
        if (string == null) {
            string = "0";
        }
        string = w.b(var_java_lang_String_arr_c[n2], "%1", string);
        String string2 = XConnection.var_javax_microedition_midlet_MIDlet_b.getAppProperty("Term");
        if (string2 == null) {
            string2 = "";
        }
        string = w.b(string, "%2", string2);
        string2 = XConnection.var_javax_microedition_midlet_MIDlet_b.getAppProperty("RefCode");
        if (string2 == null) {
            string2 = "";
        }
        string = w.b(string, "%cp", string2);
        string = string.trim();
        string = w.b(string, "  ", " ");
        var_java_lang_String_b = var_java_lang_String_arr_b[n2];
        var_java_lang_String_c = string;
    }

    private static byte b(byte by) {
        return (byte)(by <= 57 ? by - 48 : by + 10 - 97);
    }

    private static byte[] byte_arr_b(byte[] byArray) {
        int n2 = byArray.length;
        int n3 = n2 / 2;
        byte[] byArray2 = new byte[n3];
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            int n6 = n5;
            byArray2[n6] = (byte)(byArray2[n6] | w.b(byArray[n4]));
            int n7 = n5++;
            byArray2[n7] = (byte)(byArray2[n7] | w.b(byArray[n4 + 1]) << 4);
            n4 += 2;
        }
        return byArray2;
    }

    private static String b(String string, String string2, String string3) {
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = string.indexOf(string2);
        int n3 = 0;
        int n4 = string2.length();
        while (n2 != -1) {
            stringBuffer.append(string.substring(n3, n2)).append(string3);
            n3 = n2 + n4;
            n2 = string.indexOf(string2, n3);
        }
        stringBuffer.append(string.substring(n3, string.length()));
        return stringBuffer.toString();
    }

    private static void b(byte[] byArray, byte[] byArray2) {
        int n2 = byArray.length;
        int n3 = byArray2.length;
        int n4 = 0;
        while (n4 < n2) {
            int n5 = n3 - n4 % 3;
            int n6 = 0;
            while (n6 < n5) {
                byArray[n4] = (byte)(byArray2[n6] ^ byArray[n4]);
                ++n6;
            }
            ++n4;
        }
    }

    private static String java_lang_String_b(byte[] byArray) {
        String string;
        try {
            string = new String(byArray, "utf-8");
        }
        catch (Exception exception) {
            try {
                string = new String(byArray, "UTF-8");
            }
            catch (Exception exception2) {
                string = new String(byArray);
            }
        }
        return string;
    }

    private static String[] b(String string, String string2) {
        int n2;
        if (string == null) {
            System.out.println(" split. aStr == null");
            return null;
        }
        if (string.length() <= 0 || string2 == null) {
            return new String[]{string};
        }
        if (string2.length() <= 0) {
            return new String[]{string};
        }
        String[] stringArray = null;
        String string3 = string;
        int[] nArray = new int[string3.length()];
        int[] nArray2 = new int[string3.length()];
        int n3 = 0;
        boolean bl = false;
        int n4 = 0;
        int n5 = 0;
        do {
            n2 = 0;
            n5 = n4 + string2.length();
            if (n5 <= string3.length() && string3.substring(n4, n5).equals(string2)) {
                n2 = 1;
            }
            if (n2 != 0) {
                if (bl) {
                    bl = false;
                    nArray2[n3++] = n4;
                }
                n4 = n5;
                continue;
            }
            if (!bl) {
                bl = true;
                nArray[n3] = n4;
            }
            ++n4;
        } while (n4 < string3.length());
        if (bl) {
            nArray2[n3++] = string3.length();
        }
        if (n3 > 0) {
            stringArray = new String[n3];
            n2 = 0;
            while (n2 < n3) {
                stringArray[n2] = string.substring(nArray[n2], nArray2[n2]);
                ++n2;
            }
        }
        return stringArray;
    }

    public static void b(MIDlet object) {
        Object object2;
        int n2;
        if (at.var_int_b + 3 == 4990) {
            throw new IOException();
        }
        if (var_boolean_b) {
            return;
        }
        var_boolean_b = true;
        object = object.getAppProperty("sr");
        String[] stringArray = null;
        if (object == null) {
            try {
                stringArray = new DataInputStream("".getClass().getResourceAsStream("/l2.bin"));
                n2 = stringArray.available();
                object = new byte[n2];
                stringArray.read((byte[])object);
                stringArray.close();
                object2 = w.java_lang_String_b((byte[])object);
                stringArray = w.b((String)object2, String.valueOf('\n'));
                object = stringArray[0].trim().getBytes();
            }
            catch (Exception exception) {
                stringArray = exception;
                exception.printStackTrace();
                return;
            }
        } else {
            object = object.getBytes();
        }
        stringArray = (String[])new byte[6];
        n2 = ((MIDlet)object).length;
        System.arraycopy(object, 0, stringArray, 0, 3);
        System.arraycopy(object, n2 - 3, stringArray, 3, 3);
        object2 = new byte[n2 - 6];
        System.arraycopy(object, 3, object2, 0, n2 - 6);
        byte[] byArray = w.byte_arr_b((byte[])object2);
        object2 = byArray;
        w.b(byArray, (byte[])stringArray);
        object = new byte[]{1, 2, 5, 7, 4};
        n2 = ((Object)object2).length - 5;
        int n3 = 0;
        while (n3 < n2) {
            Object object3 = object;
            int n4 = n3 % 5;
            object3[n4] = (MIDlet)((byte)(object3[n4] ^ object2[n3]));
            ++n3;
        }
        n3 = 0;
        while (n3 < 5) {
            if (object[n3] != object2[n2 + n3]) {
                return;
            }
            ++n3;
        }
        object = object2;
        object2 = new byte[n2];
        System.arraycopy(object, 0, object2, 0, n2);
        object = w.java_lang_String_b((byte[])object2);
        String[] stringArray2 = w.b((String)object, "|");
        n2 = Integer.parseInt(stringArray2[0]);
        var_java_lang_String_arr_b = new String[n2];
        var_java_lang_String_arr_c = new String[n2];
        var_int_arr_b = new int[n2];
        int n5 = 0;
        while (n5 < n2) {
            w.var_java_lang_String_arr_b[n5] = stringArray2[n5 + 1];
            w.var_int_arr_b[n5] = Integer.parseInt(stringArray2[n5 + n2 + 1]);
            w.var_java_lang_String_arr_c[n5] = stringArray2[n5 + n2 + n2 + 1];
            ++n5;
        }
    }
}

