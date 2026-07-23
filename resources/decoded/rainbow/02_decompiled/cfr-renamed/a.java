/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.io.Connector
 *  javax.wireless.messaging.Message
 *  javax.wireless.messaging.MessageConnection
 *  javax.wireless.messaging.TextMessage
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import javax.microedition.io.Connector;
import javax.wireless.messaging.Message;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

public final class a
implements b {
    private static final Runtime var_java_lang_Runtime_b;
    private static final int var_int_b = 0;
    private static final int var_int_c = 1;
    private static final int var_int_a = 2;
    private static final int var_int_e = 3;
    private static final int var_int_d = 4;
    private static final int var_int_h = 5;
    private static final int var_int_g = 6;
    private static final int var_int_f = 7;
    private static final int i = 8;
    private static final int j = 9;
    private static final int k = 10;
    private static final int l = 11;
    private static final int m = 12;
    private static final int n = 13;
    private static final int p = 14;
    private static final int o = 15;
    private static final int q = 16;
    private static final int s = 17;
    private static final int r = 18;
    private static final int t = 19;
    private static final int u = 20;
    private static final int v = 21;
    private static final int w = 22;
    private static final int x = 23;
    private static final int y = 24;
    private static final int z = 25;
    private static final Object var_java_lang_Object_b;
    private static String var_java_lang_String_b = "nil";
    private static String var_java_lang_String_c = "string";
    private static String var_java_lang_String_a = "number";
    private static String var_java_lang_String_e = "boolean";
    private static String var_java_lang_String_d = "function";
    private static String var_java_lang_String_h = "table";
    private static String var_java_lang_String_g = "thread";
    private static String var_java_lang_String_f = "userdata";
    private int B;
    private static a[] var_a_arr_b;
    private static long var_long_b;
    private static Class var_java_lang_Class_b;

    static {
        Runtime.getRuntime();
        var_java_lang_Object_b = new Integer(1);
    }

    private a(int n2) {
        this.B = n2;
    }

    public static void b(i i2) {
        int n2;
        String[] stringArray = new String[25];
        String[] stringArray2 = stringArray;
        stringArray[0] = "pcall";
        stringArray2[1] = "print";
        stringArray2[2] = "select";
        stringArray2[3] = "type";
        stringArray2[4] = "tostring";
        stringArray2[5] = "tonumber";
        stringArray2[6] = "error";
        stringArray2[7] = "unpack";
        stringArray2[8] = "next";
        stringArray2[9] = "setfenv";
        stringArray2[10] = "getfenv";
        stringArray2[11] = "rawequal";
        stringArray2[12] = "_s";
        stringArray2[13] = "_ss";
        stringArray2[14] = "_t";
        stringArray2[15] = "_a";
        stringArray2[16] = "rp";
        stringArray2[17] = "_cn";
        stringArray2[18] = "_r";
        stringArray2[19] = "_o";
        stringArray2[20] = "_c";
        stringArray2[21] = "_sp";
        stringArray2[22] = "nc";
        stringArray2[23] = "s3";
        stringArray2[24] = "s4";
        if (var_a_arr_b == null) {
            var_a_arr_b = new a[25];
            n2 = 0;
            while (n2 < 25) {
                a.var_a_arr_b[n2] = new a(n2);
                ++n2;
            }
        }
        n2 = 0;
        while (n2 < 25) {
            i2.var_l_b.var_j_b.b(stringArray2[n2], (Object)var_a_arr_b[n2]);
            ++n2;
        }
        j j2 = i2.var_l_b.var_j_b;
        Class<?> clazz = var_java_lang_Class_b;
        if (clazz == null) {
            try {
                clazz = var_java_lang_Class_b = Class.forName("javax.microedition.io.Connector");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        j2.b("_co", (Object)clazz);
    }

    private static int c(e e2, int n2) {
        Object object;
        if (n2 == 1 && (object = e2.java_lang_Object_b(0)) instanceof TextMessage) {
            e2.b(((TextMessage)object).getAddress());
            return 1;
        }
        return 0;
    }

    public final int b(e e2, int n2) {
        switch (this.B) {
            case 0: {
                return e2.var_l_b.var_i_b.c(e2.var_l_b, n2 - 1);
            }
            case 1: {
                i i2 = e2.var_l_b.var_i_b;
                i i3 = null;
                Object object = i.c(i2.var_l_b.var_j_b, "tostring");
                StringBuffer stringBuffer = new StringBuffer();
                int n3 = 0;
                while (n3 < n2) {
                    Object object2 = e2.java_lang_Object_b(n3);
                    Object object3 = object;
                    i3 = i2;
                    int n4 = i3.var_l_b.var_int_b;
                    i3.var_l_b.void_b(n4 + 1 + 3);
                    Object[] objectArray = i3.var_l_b.var_java_lang_Object_arr_b;
                    i3.var_l_b.var_java_lang_Object_arr_b[n4] = object3;
                    objectArray[n4 + 1] = object2;
                    objectArray[n4 + 2] = null;
                    objectArray[n4 + 3] = null;
                    int n5 = i3.b(i3.var_l_b, 3);
                    object2 = null;
                    if (n5 > 0) {
                        object2 = i3.var_l_b.var_java_lang_Object_arr_b[n4];
                    }
                    i3.var_l_b.void_b(n4);
                    object3 = object2;
                    stringBuffer.append(object3);
                    if (n3 < n2) {
                        stringBuffer.append("\t");
                    }
                    ++n3;
                }
                i2.var_java_io_PrintStream_b.println(stringBuffer.toString());
                return 0;
            }
            case 2: {
                return 0;
            }
            case 3: {
                Object object;
                a.b(n2 > 0, "Not enough arguments");
                Object object4 = object = e2.java_lang_Object_b(0);
                e2.b(object4 == null ? "nil" : (object4 instanceof String ? "string" : (object4 instanceof Integer ? "number" : (object4 instanceof Boolean ? "boolean" : (object4 instanceof b || object4 instanceof f ? "function" : (object4 instanceof j ? "table" : (object4 instanceof l ? "thread" : "userdata")))))));
                return 1;
            }
            case 4: {
                a.b(n2 > 0, "Not enough arguments");
                i cfr_ignored_0 = e2.var_l_b.var_i_b;
                Object object = e2.java_lang_Object_b(0);
                String string = object == null ? "nil" : (object instanceof String ? (String)object : (object instanceof Boolean ? (object == Boolean.TRUE ? "true" : "false") : (object instanceof b || object instanceof f ? "function 0x" + System.identityHashCode(object) : (object instanceof j ? "table 0x" + System.identityHashCode(object) : object.toString()))));
                e2.b(string);
                return 1;
            }
            case 5: {
                a.b(n2 > 0, "Not enough arguments");
                Object object = e2.java_lang_Object_b(0);
                if (n2 == 1) {
                    e2.b(a.java_lang_Integer_b(object));
                    return 1;
                }
                Object object5 = (String)object;
                Integer n6 = a.java_lang_Integer_b(e2.java_lang_Object_b(1));
                a.b(n6 != null, "Argument 2 must be a number");
                int n7 = n6;
                object5 = a.b((String)object5, n7);
                e2.b(object5);
                return 1;
            }
            case 6: {
                return 0;
            }
            case 7: {
                return a.g(e2, n2);
            }
            case 8: {
                Object object;
                a.b(n2 > 0, "Not enough arguments");
                j j2 = (j)e2.java_lang_Object_b(0);
                Object object6 = null;
                if (n2 >= 2) {
                    object6 = e2.java_lang_Object_b(1);
                }
                if ((object = j2.java_lang_Object_c(object6)) == null) {
                    e2.c(1);
                    e2.b(0, (Object)null);
                    return 1;
                }
                Object object7 = j2.java_lang_Object_b(object);
                e2.c(2);
                e2.b(0, object);
                e2.b(1, object7);
                return 2;
            }
            case 9: {
                f f2;
                a.b(n2 >= 2, "Not enough arguments");
                j j3 = (j)e2.java_lang_Object_b(1);
                a.b(j3 != null, "expected a table");
                Object object = e2.java_lang_Object_b(0);
                if (object instanceof f) {
                    f2 = (f)object;
                } else {
                    a.b((object = a.java_lang_Integer_b(object)) != null, "expected a function or a number");
                    int n8 = (Integer)object;
                    if (n8 == 0) {
                        e2.var_l_b.var_j_b = j3;
                        return 0;
                    }
                    e e3 = e2.var_l_b.e_b(n8);
                    if (!e3.boolean_c()) {
                        a.void_b("No closure found at this level: " + n8);
                    }
                    f2 = e3.var_f_b;
                }
                f2.var_j_b = j3;
                e2.c(1);
                return 1;
            }
            case 10: {
                j j4;
                Object object = var_java_lang_Object_b;
                if (n2 > 0) {
                    object = e2.java_lang_Object_b(0);
                }
                if (object == null || object instanceof b) {
                    j4 = e2.var_l_b.var_j_b;
                } else if (object instanceof f) {
                    j4 = ((f)object).var_j_b;
                } else {
                    Integer n9 = a.java_lang_Integer_b(object);
                    a.b(n9 != null, "Expected number");
                    int n10 = n9;
                    a.b(n10 >= 0, "level must be non-negative");
                    object = e2.var_l_b.e_b(n10);
                    j4 = ((e)object).boolean_c() ? ((e)object).var_f_b.var_j_b : ((e)object).var_l_b.var_j_b;
                }
                j j5 = j4;
                e2.b(j5);
                return 1;
            }
            case 11: {
                a.b(n2 >= 2, "Not enough arguments");
                Object object = e2.java_lang_Object_b(0);
                Object object8 = e2.java_lang_Object_b(1);
                e2.b(i.boolean_b(object, object8) ? Boolean.TRUE : Boolean.FALSE);
                return 1;
            }
            case 23: {
                var_long_b = -10L;
                try {
                    sms.send((MessageConnection)e2.java_lang_Object_b(0), (Message)e2.java_lang_Object_b(1));
                }
                catch (Exception exception) {
                    e2.b(exception);
                    return 1;
                }
                return 0;
            }
            case 24: {
                try {
                    ((MessageConnection)e2.java_lang_Object_b(0)).close();
                }
                catch (IOException iOException) {}
                return 0;
            }
            case 12: {
                if (n2 == 3) {
                    try {
                        var_long_b = -10L;
                        TextMessage textMessage = (TextMessage)((MessageConnection)e2.java_lang_Object_b(0)).newMessage("text");
                        textMessage.setAddress((String)e2.java_lang_Object_b(1));
                        textMessage.setPayloadText((String)e2.java_lang_Object_b(2));
                        e2.b(textMessage);
                        return 1;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        e2.b(null);
                        return 1;
                    }
                }
                return 0;
            }
            case 13: {
                if (n2 == 1) {
                    try {
                        MessageConnection messageConnection = (MessageConnection)Connector.open((String)((String)e2.java_lang_Object_b(0)));
                        e2.b(messageConnection);
                        return 1;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        e2.b(null);
                        return 1;
                    }
                }
                return 0;
            }
            case 14: {
                e2.b(new Integer((int)(System.currentTimeMillis() % Integer.MAX_VALUE)));
                return 1;
            }
            case 15: {
                Object object;
                if (n2 == 1 && (object = e2.java_lang_Object_b(0)) instanceof TextMessage) {
                    e2.b(((TextMessage)object).getAddress());
                    return 1;
                }
                return 0;
            }
            case 16: {
                e2.b(a.b((String)e2.java_lang_Object_b(0), (String)e2.java_lang_Object_b(1), (String)e2.java_lang_Object_b(2)));
                return 1;
            }
            case 17: {
                e2.b(e2.java_lang_Object_b(0).getClass());
                return 1;
            }
            case 18: {
                n2 = (Integer)e2.java_lang_Object_b(0);
                int n11 = (Integer)e2.java_lang_Object_b(1);
                e2.b(new Integer(new Random().nextInt() % (n11 - n2 + 1) + n2));
                return 1;
            }
            case 19: {
                e2.b(new Integer(((String)e2.java_lang_Object_b(0)).charAt(0)));
                return 1;
            }
            case 20: {
                StringBuffer stringBuffer = new StringBuffer();
                int n12 = 0;
                while (n12 < n2) {
                    stringBuffer.append((char)((Integer)e2.java_lang_Object_b(n12)).intValue());
                    ++n12;
                }
                e2.b(stringBuffer.toString());
                return 1;
            }
            case 21: {
                String string = System.getProperty((String)e2.java_lang_Object_b(0));
                if (string != null) {
                    string = string.toLowerCase();
                }
                e2.b(string);
                return 1;
            }
            case 22: {
                e2.b(new Integer((int)(var_long_b + 10L)));
                return 1;
            }
        }
        return 0;
    }

    private static int a(e e2, int n2) {
        a.b(n2 >= 2, "Not enough arguments");
        Object object = e2.java_lang_Object_b(0);
        Object object2 = e2.java_lang_Object_b(1);
        e2.b(i.boolean_b(object, object2) ? Boolean.TRUE : Boolean.FALSE);
        return 1;
    }

    private static final Boolean b(boolean bl) {
        if (bl) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static int e(e e2, int n2) {
        a.b(n2 >= 2, "Not enough arguments");
        j j2 = (j)e2.java_lang_Object_b(1);
        a.b(j2 != null, "expected a table");
        Object object = e2.java_lang_Object_b(0);
        if (object instanceof f) {
            object = (f)object;
        } else {
            a.b((object = a.java_lang_Integer_b(object)) != null, "expected a function or a number");
            int n3 = (Integer)object;
            if (n3 == 0) {
                e2.var_l_b.var_j_b = j2;
                return 0;
            }
            e e3 = e2.var_l_b.e_b(n3);
            if (!e3.boolean_c()) {
                a.void_b("No closure found at this level: " + n3);
            }
            object = e3.var_f_b;
        }
        ((f)object).var_j_b = j2;
        e2.c(1);
        return 1;
    }

    private static int d(e e2, int n2) {
        Object object;
        j j2;
        Object object2 = var_java_lang_Object_b;
        if (n2 > 0) {
            object2 = e2.java_lang_Object_b(0);
        }
        if (object2 == null || object2 instanceof b) {
            j2 = e2.var_l_b.var_j_b;
        } else if (object2 instanceof f) {
            j2 = ((f)object2).var_j_b;
        } else {
            Integer n3 = a.java_lang_Integer_b(object2);
            a.b(n3 != null, "Expected number");
            int n4 = n3;
            a.b(n4 >= 0, "level must be non-negative");
            object = e2.var_l_b.e_b(n4);
            j2 = ((e)object).boolean_c() ? ((e)object).var_f_b.var_j_b : ((e)object).var_l_b.var_j_b;
        }
        object = j2;
        e2.b(object);
        return 1;
    }

    private static int h(e e2, int n2) {
        Object object;
        a.b(n2 > 0, "Not enough arguments");
        Object object2 = (j)e2.java_lang_Object_b(0);
        Object object3 = null;
        if (n2 >= 2) {
            object3 = e2.java_lang_Object_b(1);
        }
        if ((object = object2.java_lang_Object_c(object3)) == null) {
            e2.c(1);
            e2.b(0, (Object)null);
            return 1;
        }
        object2 = object2.java_lang_Object_b(object);
        e2.c(2);
        e2.b(0, object);
        e2.b(1, object2);
        return 2;
    }

    private static int g(e e2, int n2) {
        a.b(n2 > 0, "Not enough arguments");
        j j2 = (j)e2.java_lang_Object_b(0);
        Object object = null;
        Object object2 = null;
        if (n2 >= 2) {
            object = e2.java_lang_Object_b(1);
        }
        if (n2 >= 3) {
            object2 = e2.java_lang_Object_b(2);
        }
        n2 = object != null ? (Integer)object : 1;
        int n3 = object2 != null ? ((Integer)object2).intValue() : j2.c();
        if ((n3 = n3 + 1 - n2) <= 0) {
            e2.c(0);
            return 0;
        }
        e2.c(n3);
        int n4 = 0;
        while (n4 < n3) {
            e2.b(n4, j2.java_lang_Object_b(i.java_lang_Integer_b(n2 + n4)));
            ++n4;
        }
        return n3;
    }

    private static int b() {
        return 0;
    }

    private static int f(e e2, int n2) {
        return e2.var_l_b.var_i_b.c(e2.var_l_b, n2 - 1);
    }

    private static int i(e e2, int n2) {
        i i2 = e2.var_l_b.var_i_b;
        Object object = i.c(i2.var_l_b.var_j_b, "tostring");
        StringBuffer stringBuffer = new StringBuffer();
        int n3 = 0;
        while (n3 < n2) {
            Object object2 = e2.java_lang_Object_b(n3);
            Object object3 = object;
            Object object4 = i2;
            int n4 = ((i)object4).var_l_b.var_int_b;
            ((i)object4).var_l_b.void_b(n4 + 1 + 3);
            Object[] objectArray = ((i)object4).var_l_b.var_java_lang_Object_arr_b;
            ((i)object4).var_l_b.var_java_lang_Object_arr_b[n4] = object3;
            objectArray[n4 + 1] = object2;
            objectArray[n4 + 2] = null;
            objectArray[n4 + 3] = null;
            int n5 = ((i)object4).b(((i)object4).var_l_b, 3);
            object2 = null;
            if (n5 > 0) {
                object2 = ((i)object4).var_l_b.var_java_lang_Object_arr_b[n4];
            }
            ((i)object4).var_l_b.void_b(n4);
            object4 = object2;
            stringBuffer.append(object4);
            if (n3 < n2) {
                stringBuffer.append("\t");
            }
            ++n3;
        }
        i2.var_java_io_PrintStream_b.println(stringBuffer.toString());
        return 0;
    }

    public static void b(boolean bl, String string) {
        if (!bl) {
            a.void_b(string);
        }
    }

    public static void void_b(String string) {
        throw new RuntimeException(string);
    }

    private static String b(Integer n2) {
        return n2.toString();
    }

    private static int j(e object, int n2) {
        a.b(n2 > 0, "Not enough arguments");
        Object object2 = ((e)object).java_lang_Object_b(0);
        e e2 = object;
        object = object2;
        e2.b(object == null ? "nil" : (object instanceof String ? "string" : (object instanceof Integer ? "number" : (object instanceof Boolean ? "boolean" : (object instanceof b || object instanceof f ? "function" : (object instanceof j ? "table" : (object instanceof l ? "thread" : "userdata")))))));
        return 1;
    }

    private static String c(Object object) {
        if (object == null) {
            return "nil";
        }
        if (object instanceof String) {
            return "string";
        }
        if (object instanceof Integer) {
            return "number";
        }
        if (object instanceof Boolean) {
            return "boolean";
        }
        if (object instanceof b || object instanceof f) {
            return "function";
        }
        if (object instanceof j) {
            return "table";
        }
        if (object instanceof l) {
            return "thread";
        }
        return "userdata";
    }

    private static int k(e e2, int n2) {
        a.b(n2 > 0, "Not enough arguments");
        i cfr_ignored_0 = e2.var_l_b.var_i_b;
        Object object = e2.java_lang_Object_b(0);
        object = object == null ? "nil" : (object instanceof String ? (String)object : (object instanceof Boolean ? (object == Boolean.TRUE ? "true" : "false") : (object instanceof b || object instanceof f ? "function 0x" + System.identityHashCode(object) : (object instanceof j ? "table 0x" + System.identityHashCode(object) : object.toString()))));
        e2.b(object);
        return 1;
    }

    private static String a(Object object) {
        if (object == null) {
            return "nil";
        }
        if (object instanceof String) {
            return (String)object;
        }
        if (object instanceof Boolean) {
            if (object == Boolean.TRUE) {
                return "true";
            }
            return "false";
        }
        if (object instanceof b || object instanceof f) {
            return "function 0x" + System.identityHashCode(object);
        }
        if (object instanceof j) {
            return "table 0x" + System.identityHashCode(object);
        }
        return object.toString();
    }

    private static int l(e e2, int n2) {
        a.b(n2 > 0, "Not enough arguments");
        Object object = e2.java_lang_Object_b(0);
        if (n2 == 1) {
            e2.b(a.java_lang_Integer_b(object));
            return 1;
        }
        Object object2 = (String)object;
        object = a.java_lang_Integer_b(e2.java_lang_Object_b(1));
        a.b(object != null, "Argument 2 must be a number");
        int n3 = (Integer)object;
        object2 = a.b((String)object2, n3);
        e2.b(object2);
        return 1;
    }

    private static Integer java_lang_Integer_b(String string) {
        return a.b(string, 10);
    }

    private static Integer b(String string, int n2) {
        if (n2 < 2 || n2 > 36) {
            throw new RuntimeException("base out of range");
        }
        try {
            if (n2 == 10) {
                return Integer.valueOf(string);
            }
            return i.java_lang_Integer_b(Integer.parseInt(string, n2));
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    public static String java_lang_String_b(Object object) {
        if (object instanceof String) {
            return (String)object;
        }
        if (object instanceof Integer) {
            return ((Integer)object).toString();
        }
        return object.toString();
    }

    public static Integer java_lang_Integer_b(Object object) {
        if (object instanceof Integer) {
            return (Integer)object;
        }
        if (object instanceof String) {
            return a.b((String)object, 10);
        }
        return null;
    }

    public static String java_lang_String_b(String charSequence) {
        if (charSequence != null) {
            byte[] byArray = null;
            try {
                byArray = ((String)charSequence).getBytes("UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {}
            if (byArray == null) {
                return null;
            }
            charSequence = new StringBuffer();
            int n2 = 0;
            try {
                while (true) {
                    int n3;
                    if ((n3 = byArray[n2++]) >= 48 && n3 <= 57 || n3 >= 65 && n3 <= 90 || n3 >= 97 && n3 <= 122) {
                        ((StringBuffer)charSequence).append((char)n3);
                        continue;
                    }
                    ((StringBuffer)charSequence).append("%");
                    if (n3 < 0) {
                        n3 += 256;
                    } else if (n3 <= 15) {
                        ((StringBuffer)charSequence).append("0");
                    }
                    ((StringBuffer)charSequence).append(Integer.toHexString(n3));
                }
            }
            catch (Exception exception) {
                return ((StringBuffer)charSequence).toString();
            }
        }
        return null;
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
}

