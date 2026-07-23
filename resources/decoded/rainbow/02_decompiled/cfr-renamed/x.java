/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Vector;

public final class x {
    private static final Random b = new Random();

    public static y y_b(String stringArray, String stringArray2, String string, String string2, int n2) {
        int n3;
        int n4 = n2;
        String string3 = string2;
        String string4 = string;
        String[] stringArray3 = stringArray2;
        Object object = stringArray;
        if (stringArray == null || stringArray3 == null || ((String)object).length() != 3 || stringArray3.length() != 3 || !x.boolean_b((String)object) || !x.boolean_b((String)stringArray3)) {
            throw new IllegalArgumentException("ID tr\u00f2 ch\u01a1i, nh\u00e0 cung c\u1ea5p kh\u00f4ng h\u1ee3p l\u1ec7!");
        }
        if (!(string4 == null || string4.length() == 2 && x.boolean_b(string4))) {
            throw new IllegalArgumentException("ID ho\u1ea1t \u0111\u1ed9ng kh\u00f4ng h\u1ee3p l\u1ec7!");
        }
        if (!(string3 == null || string3.length() == 3 && x.boolean_b(string3))) {
            throw new IllegalArgumentException("ID c\u1ea5u h\u00ecnh kh\u00f4ng h\u1ee3p l\u1ec7!");
        }
        if (n4 <= 0 || n4 > 30) {
            throw new IllegalArgumentException("S\u1ed1 ti\u1ec1n thanh to\u00e1n kh\u00f4ng h\u1ee3p l\u1ec7!");
        }
        if (n4 % 2 != 0) {
            throw new IllegalArgumentException("S\u1ed1 ti\u1ec1n thanh to\u00e1n kh\u00f4ng h\u1ee3p l\u1ec7!");
        }
        object = new y();
        string2 = string2 == null ? "000" : string2;
        string = string == null ? "00" : string;
        stringArray3 = x.java_lang_String_arr_b((String)stringArray, (String)stringArray2, string, string2, n2);
        ((y)object).var_java_lang_String_a = stringArray3[0];
        ((y)object).var_java_lang_String_e = stringArray3[1];
        ((y)object).var_int_c = n3 = Integer.parseInt(stringArray3[2]);
        ((y)object).d = stringArray3[3];
        ((y)object).var_int_b = n2 / n3;
        if ("1".equals(stringArray3[4])) {
            stringArray = x.c((String)stringArray, (String)stringArray2, string, string2, n2);
            ((y)object).var_java_lang_String_b = stringArray[0];
            ((y)object).var_java_lang_String_c = stringArray[1];
        } else if ("2".equals(stringArray3[4])) {
            ((y)object).var_java_lang_String_b = stringArray3[5];
            ((y)object).var_java_lang_String_c = ((y)object).var_java_lang_String_e;
            ((y)object).var_boolean_b = true;
        }
        return object;
    }

    private static String[] java_lang_String_arr_b(String stringArray, String stringArray2, String object, String string, int n2) {
        try {
            int n3;
            String string2;
            String[] stringArray3;
            String string3 = x.b();
            String[] stringArray4 = x.java_lang_String_b(string3, "DJSMSCode3");
            boolean bl = false;
            Object object2 = null;
            int n4 = 0;
            if (stringArray4 != null && stringArray4.length() != 0) {
                int n5;
                stringArray4 = x.java_lang_String_b((String)stringArray4);
                Object var10_18 = null;
                int n6 = 0;
                stringArray4 = x.java_lang_String_arr_b((String)stringArray4, ";");
                object2 = stringArray4;
                int n7 = stringArray4.length;
                n6 = 0;
                while (n6 < n7) {
                    n5 = n6 + 1;
                    while (n5 < n7) {
                        stringArray3 = object2[n5];
                        string2 = object2[n6];
                        int n8 = stringArray3.indexOf("|");
                        int n9 = string2.indexOf("|");
                        int n10 = -1;
                        n3 = -1;
                        if (n8 > 0) {
                            n10 = Integer.parseInt(stringArray3.substring(n8 + 1));
                        }
                        if (n9 > 0) {
                            n3 = Integer.parseInt(string2.substring(n9 + 1));
                        }
                        if (n10 < n3) {
                            object2[n5] = string2;
                            object2[n6] = stringArray3;
                        }
                        ++n5;
                    }
                    ++n6;
                }
                object2 = new Vector();
                n5 = stringArray4.length - 1;
                while (n5 >= 0) {
                    n6 = stringArray4[n5].indexOf("|");
                    if (n6 > 0) {
                        String string4 = stringArray4[n5].substring(0, n6);
                        if ((n6 = Integer.parseInt(stringArray4[n5].substring(n6 + 1))) > 0 && n2 >= n6 && n2 % n6 == 0 && (n4 == 0 || n4 > 0 && n4 == n6)) {
                            bl = true;
                            n4 = n6;
                            ((Vector)object2).addElement(string4);
                        }
                    }
                    --n5;
                }
            }
            if (bl && n4 > 2) {
                stringArray4 = (String)((Vector)object2).elementAt(x.b(((Vector)object2).size()));
                return x.b(string3, (String)stringArray4, String.valueOf(n4), (String)stringArray, (String)stringArray2, (String)object, string);
            }
            stringArray4 = x.java_lang_String_b(string3, "DJSMSCode1");
            Object object3 = x.java_lang_String_b(string3, "DJSMSCode2");
            if (bl && n4 == 2 && (object3 == null || ((String)object3).length() == 0 || System.currentTimeMillis() % 10L < 5L)) {
                String string5 = (String)((Vector)object2).elementAt(x.b(((Vector)object2).size()));
                return x.b(string3, string5, String.valueOf(n4), (String)stringArray, (String)stringArray2, (String)object, string);
            }
            if (object3 != null && ((String)object3).length() > 0 && (stringArray4 == null || stringArray4.length() == 0 || System.currentTimeMillis() % 10L < 8L)) {
                string2 = string;
                stringArray3 = object;
                String[] stringArray5 = stringArray2;
                String[] stringArray6 = stringArray;
                object2 = string3;
                object3 = x.java_lang_String_b((String)object3);
                String string6 = x.java_lang_String_b(x.java_lang_String_b((String)object2, "DJSMSDest2"));
                String string7 = x.java_lang_String_b((String)object2, "DJSMSDesc2");
                String string8 = x.java_lang_String_b((String)object2, "DJSMSShortCode2");
                n3 = "1".equals(string8);
                if (((String)object3).indexOf(59) > 0) {
                    stringArray = x.java_lang_String_arr_b((String)object3, ";");
                    stringArray2 = x.java_lang_String_arr_b(string6, ";");
                    object = x.java_lang_String_arr_b(string7, ";");
                    int n11 = (int)(System.currentTimeMillis() % (long)stringArray.length);
                    if (string8 != null && string8.length() > 0) {
                        String[] stringArray7 = x.java_lang_String_arr_b(string8, ";");
                        n3 = "1".equals(stringArray7[n11]) ? 1 : 0;
                    }
                    object3 = stringArray[n11];
                    string6 = stringArray2[n11];
                    string7 = object[n11];
                }
                int n12 = ((String)object3).indexOf(124);
                boolean bl2 = string6.toUpperCase().startsWith("X");
                object = bl2 ? ((String)object3).substring(0, n12) : (n3 != 0 ? ((String)object3).substring(0, n12) + x.b((String)stringArray6, (String)stringArray5, ((String)object3).substring(n12 + 1)) : ((String)object3).substring(0, n12) + (String)stringArray6 + (String)stringArray5 + (String)stringArray3 + string2 + ((String)object3).substring(n12 + 1));
                return new String[]{bl2 ? string6.substring(1) : string6, object, "2", string7, bl2 ? "1" : "0"};
            }
            if (stringArray4 != null && stringArray4.length() > 0) {
                string2 = string;
                stringArray3 = object;
                String[] stringArray8 = stringArray2;
                String[] stringArray9 = stringArray;
                object3 = stringArray4;
                object2 = string3;
                object3 = x.java_lang_String_b((String)object3);
                String string9 = x.java_lang_String_b(x.java_lang_String_b((String)object2, "DJSMSDest1"));
                String string10 = x.java_lang_String_b((String)object2, "DJSMSDesc1");
                String string11 = x.java_lang_String_b((String)object2, "DJSMSShortCode1");
                n3 = "1".equals(string11);
                if (((String)object3).indexOf(59) > 0) {
                    stringArray = x.java_lang_String_arr_b((String)object3, ";");
                    stringArray2 = x.java_lang_String_arr_b(string9, ";");
                    object = x.java_lang_String_arr_b(string10, ";");
                    int n13 = (int)(System.currentTimeMillis() % (long)stringArray.length);
                    if (string11 != null && string11.length() > 0) {
                        String[] stringArray10 = x.java_lang_String_arr_b(string11, ";");
                        n3 = "1".equals(stringArray10[n13]) ? 1 : 0;
                    }
                    object3 = stringArray[n13];
                    string9 = stringArray2[n13];
                    string10 = object[n13];
                }
                boolean bl3 = string9.toUpperCase().startsWith("X");
                int n14 = ((String)object3).indexOf(124);
                object = bl3 ? ((String)object3).substring(0, n14) : (n3 != 0 ? ((String)object3).substring(0, n14) + x.b((String)stringArray9, (String)stringArray8, ((String)object3).substring(n14 + 1)) : ((String)object3).substring(0, n14) + (String)stringArray9 + (String)stringArray8 + (String)stringArray3 + string2 + ((String)object3).substring(n14 + 1));
                return new String[]{bl3 ? string9.substring(1) : string9, object, "1", string10, bl3 ? "1" : "0"};
            }
            throw new IllegalArgumentException("Ph\u1ea3i cung c\u1ea5p \u00edt nh\u1ea5t m\u1ed9t m\u00e3 ph\u00ed!");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            throw new IllegalArgumentException("Kh\u00f4ng t\u00ecm th\u1ea5y m\u00e3 ph\u00ed!");
        }
    }

    private static String[] b(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        String string8 = x.java_lang_String_b(x.java_lang_String_b(string, "DJSMSDest3"));
        String string9 = x.java_lang_String_b(string, "DJSMSDesc3");
        StringBuffer stringBuffer = new StringBuffer();
        String string10 = "#MONEY#";
        int n2 = string9.indexOf(string10);
        if (n2 != -1) {
            stringBuffer.append(string9.substring(0, n2));
            stringBuffer.append(string3);
            stringBuffer.append(string9.substring(n2 + string10.length()));
            string9 = stringBuffer.toString();
        }
        boolean bl = "1".equals(x.java_lang_String_b(string, "DJSMSShortCode3"));
        string10 = x.java_lang_String_b(x.java_lang_String_b(string, "DJSMSChan3"));
        string2 = bl ? string2 + x.b(string4, string5, string10) : string2 + string4 + string5 + string6 + string7 + string10;
        string = x.java_lang_String_b(x.java_lang_String_b(string, "DJSMSFree3"));
        return new String[]{string8, string2, string3, string9, "2", string};
    }

    private static boolean boolean_b(String string) {
        try {
            Integer.parseInt(string);
        }
        catch (Exception exception) {
            return false;
        }
        return true;
    }

    private static void void_b(String string, String string2, String string3, String string4, int n2) {
        if (string == null || string2 == null || string.length() != 3 || string2.length() != 3 || !x.boolean_b(string) || !x.boolean_b(string2)) {
            throw new IllegalArgumentException("ID tr\u00f2 ch\u01a1i, nh\u00e0 cung c\u1ea5p kh\u00f4ng h\u1ee3p l\u1ec7!");
        }
        if (!(string3 == null || string3.length() == 2 && x.boolean_b(string3))) {
            throw new IllegalArgumentException("ID ho\u1ea1t \u0111\u1ed9ng kh\u00f4ng h\u1ee3p l\u1ec7!");
        }
        if (!(string4 == null || string4.length() == 3 && x.boolean_b(string4))) {
            throw new IllegalArgumentException("ID c\u1ea5u h\u00ecnh kh\u00f4ng h\u1ee3p l\u1ec7!");
        }
        if (n2 <= 0 || n2 > 30) {
            throw new IllegalArgumentException("S\u1ed1 ti\u1ec1n thanh to\u00e1n kh\u00f4ng h\u1ee3p l\u1ec7!");
        }
        if (n2 % 2 != 0) {
            throw new IllegalArgumentException("S\u1ed1 ti\u1ec1n thanh to\u00e1n kh\u00f4ng h\u1ee3p l\u1ec7!");
        }
    }

    private static String b() {
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        try {
            inputStream = new Object().getClass().getResourceAsStream("/dcn.bin");
            byte[] byArray = new byte[512];
            int n2 = 0;
            while ((n2 = inputStream.read(byArray)) > 0) {
                stringBuffer.append(new String(byArray, 0, n2, "UTF-8"));
            }
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return stringBuffer.toString().replace('\r', ' ');
    }

    private static String java_lang_String_b(String string, String string2) {
        int n2 = string.indexOf("\n");
        int n3 = 0;
        String string3 = null;
        while (n2 > 0) {
            string3 = string.substring(n3, n2).trim();
            if (string3.startsWith(string2)) {
                return string3.substring(string3.indexOf(58) + 1);
            }
            n3 = n2 + 1;
            if ((n2 = string.indexOf("\n", n3)) != -1 || n3 >= string.length()) continue;
            n2 = string.length();
        }
        return null;
    }

    private static String[] java_lang_String_arr_b(String objectArray, String string) {
        Vector<String> vector = new Vector<String>();
        int n2 = string.length();
        int n3 = 0;
        while (objectArray.indexOf(string, n3) >= n3) {
            int n4 = objectArray.indexOf(string, n3);
            if (n4 == n3) {
                vector.addElement("");
            } else {
                vector.addElement(objectArray.substring(n3, n4));
            }
            n3 = n4 + n2;
        }
        if (n3 < objectArray.length()) {
            vector.addElement(objectArray.substring(n3));
        } else {
            vector.addElement("");
        }
        objectArray = new String[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    private static String java_lang_String_b(String object) {
        byte[] byArray = ((String)object).substring(0, ((String)object).length() - 1).getBytes();
        object = byArray;
        byte[] byArray2 = new byte[byArray.length];
        int n2 = 0;
        while (n2 < ((Object)object).length) {
            Object object2 = object[n2];
            if (object2 >= 48 && object2 <= 57) {
                object2 = (byte)(object2 + (object2 <= 50 ? 7 : -3));
            } else if (object2 >= 65 && object2 <= 90) {
                object2 = (byte)(object2 + (object2 <= 67 ? 23 : -3));
            }
            byArray2[n2] = (byte)object2;
            ++n2;
        }
        return new String(byArray2);
    }

    private static String b(String object, String string, String string2) {
        int n2;
        int n3 = Integer.parseInt((String)object + string + string2);
        if (n3 > 916132831) {
            throw new IllegalArgumentException("cpId:" + (String)object + "gameId:" + string + "channelId:" + string2 + ", too large! unsupports!@_@");
        }
        object = new byte[200];
        int n4 = 0;
        while (true) {
            int n5;
            n2 = (n5 = n3 % 62) >= 10 && n5 < 36 ? (int)(n5 - 10 + 65) : (n5 >= 36 && n5 < 62 ? (int)(n5 - 36 + 97) : (int)(n5 + 48));
            object[n4++] = n2;
            if (n3 < 62) break;
            n3 = (n3 - n5) / 62;
        }
        String string3 = new String(x.b((byte[])object));
        n2 = 5 - string3.length();
        if (n2 == 0) {
            return string3;
        }
        object = new StringBuffer();
        n4 = 0;
        while (n4 < n2) {
            ((StringBuffer)object).append('0');
            ++n4;
        }
        ((StringBuffer)object).append(string3);
        return ((StringBuffer)object).toString();
    }

    private static int b(int n2) {
        int n3 = b.nextInt();
        if (n3 < 0) {
            n3 = -n3;
        }
        return n3 % n2;
    }

    private static byte[] b(byte[] byArray) {
        int n2;
        byte[] byArray2 = new byte[byArray.length];
        int n3 = 0;
        int n4 = 0;
        while (n4 < byArray.length) {
            n2 = byArray[n4];
            if (n2 > 0) {
                ++n3;
            }
            byArray2[byArray.length - n4 - 1] = n2;
            ++n4;
        }
        byte[] byArray3 = new byte[n3];
        n2 = 0;
        while (n2 < n3) {
            byArray3[n2] = byArray2[byArray2.length - n3 + n2];
            ++n2;
        }
        return byArray3;
    }

    private static String[] c(String string, String string2, String string3, String string4, int n2) {
        try {
            Object object;
            String string5 = x.b();
            String string6 = x.java_lang_String_b(x.java_lang_String_b(string5, "DJFreeCode"));
            string5 = x.java_lang_String_b(x.java_lang_String_b(string5, "DJFreeDest"));
            if (string6.indexOf(59) > 0) {
                String[] stringArray = x.java_lang_String_arr_b(string6, ";");
                object = x.java_lang_String_arr_b(string5, ";");
                int n3 = (int)(System.currentTimeMillis() % (long)stringArray.length);
                string6 = stringArray[n3];
                string5 = object[n3];
            }
            int n4 = string6.indexOf(124);
            object = string6.substring(0, n4) + string + string2 + string3 + string4 + string6.substring(n4 + 1) + "-" + n2;
            return new String[]{string5, object};
        }
        catch (Exception exception) {
            exception.printStackTrace();
            throw new IllegalArgumentException("Kh\u00f4ng t\u00ecm Th\u1ea5y m\u00e3 mi\u1ec5n ph\u00ed!");
        }
    }

    private static String[] b(String stringArray, String string, String string2, String string3, String string4, String string5) {
        Object object;
        string = x.java_lang_String_b(string);
        String string6 = x.java_lang_String_b(x.java_lang_String_b((String)stringArray, "DJSMSDest1"));
        String string7 = x.java_lang_String_b((String)stringArray, "DJSMSDesc1");
        stringArray = x.java_lang_String_b((String)stringArray, "DJSMSShortCode1");
        boolean bl = "1".equals(stringArray);
        if (string.indexOf(59) > 0) {
            String[] stringArray2 = x.java_lang_String_arr_b(string, ";");
            String[] stringArray3 = x.java_lang_String_arr_b(string6, ";");
            object = x.java_lang_String_arr_b(string7, ";");
            int n2 = (int)(System.currentTimeMillis() % (long)stringArray2.length);
            if (stringArray != null && stringArray.length() > 0) {
                stringArray = x.java_lang_String_arr_b((String)stringArray, ";");
                bl = "1".equals(stringArray[n2]);
            }
            string = stringArray2[n2];
            string6 = stringArray3[n2];
            string7 = object[n2];
        }
        boolean bl2 = string6.toUpperCase().startsWith("X");
        int n3 = string.indexOf(124);
        object = bl2 ? string.substring(0, n3) : (bl ? string.substring(0, n3) + x.b(string2, string3, string.substring(n3 + 1)) : string.substring(0, n3) + string2 + string3 + string4 + string5 + string.substring(n3 + 1));
        return new String[]{bl2 ? string6.substring(1) : string6, object, "1", string7, bl2 ? "1" : "0"};
    }

    private static String[] c(String stringArray, String string, String string2, String string3, String string4, String string5) {
        Object object;
        string = x.java_lang_String_b(string);
        String string6 = x.java_lang_String_b(x.java_lang_String_b((String)stringArray, "DJSMSDest2"));
        String string7 = x.java_lang_String_b((String)stringArray, "DJSMSDesc2");
        stringArray = x.java_lang_String_b((String)stringArray, "DJSMSShortCode2");
        boolean bl = "1".equals(stringArray);
        if (string.indexOf(59) > 0) {
            String[] stringArray2 = x.java_lang_String_arr_b(string, ";");
            String[] stringArray3 = x.java_lang_String_arr_b(string6, ";");
            object = x.java_lang_String_arr_b(string7, ";");
            int n2 = (int)(System.currentTimeMillis() % (long)stringArray2.length);
            if (stringArray != null && stringArray.length() > 0) {
                stringArray = x.java_lang_String_arr_b((String)stringArray, ";");
                bl = "1".equals(stringArray[n2]);
            }
            string = stringArray2[n2];
            string6 = stringArray3[n2];
            string7 = object[n2];
        }
        int n3 = string.indexOf(124);
        boolean bl2 = string6.toUpperCase().startsWith("X");
        object = bl2 ? string.substring(0, n3) : (bl ? string.substring(0, n3) + x.b(string2, string3, string.substring(n3 + 1)) : string.substring(0, n3) + string2 + string3 + string4 + string5 + string.substring(n3 + 1));
        return new String[]{bl2 ? string6.substring(1) : string6, object, "2", string7, bl2 ? "1" : "0"};
    }

    private static void b(String[] stringArray) {
        int n2 = stringArray.length;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = n3 + 1;
            while (n4 < n2) {
                String string = stringArray[n4];
                String string2 = stringArray[n3];
                int n5 = string.indexOf("|");
                int n6 = string2.indexOf("|");
                int n7 = -1;
                int n8 = -1;
                if (n5 > 0) {
                    n7 = Integer.parseInt(string.substring(n5 + 1));
                }
                if (n6 > 0) {
                    n8 = Integer.parseInt(string2.substring(n6 + 1));
                }
                if (n7 < n8) {
                    stringArray[n4] = string2;
                    stringArray[n3] = string;
                }
                ++n4;
            }
            ++n3;
        }
    }
}

