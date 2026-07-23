/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import java.io.DataInputStream;
import java.util.Hashtable;
import javax.microedition.lcdui.Graphics;

public final class u {
    public static byte var_byte_b;
    private static byte[][] var_byte_arr_arr_b;
    private static int[] var_int_arr_b;
    private static int[] var_int_arr_c;
    private static Hashtable var_java_util_Hashtable_b;
    public static int var_int_b;
    private static String var_java_lang_String_b;
    private static int var_int_c;
    private static char var_char_b;
    private static int a;

    static {
        if (var_byte_arr_arr_b == null) {
            var_java_util_Hashtable_b = new Hashtable();
            DataInputStream dataInputStream = new DataInputStream("".getClass().getResourceAsStream("/font.bin"));
            try {
                String string = dataInputStream.readUTF();
                byte by = var_byte_b = dataInputStream.readByte();
                int n2 = string.length();
                var_int_arr_b = new int[n2];
                var_int_arr_c = new int[n2];
                int n3 = 0;
                int n4 = 0;
                while (n4 < n2) {
                    u.var_int_arr_b[n4] = dataInputStream.readByte();
                    u.var_int_arr_c[n4] = n3;
                    n3 += var_int_arr_b[n4];
                    var_java_util_Hashtable_b.put(new Integer(string.charAt(n4)), new Integer(n4));
                    ++n4;
                }
                var_byte_arr_arr_b = new byte[by][n3];
                n4 = 7;
                byte by2 = 0;
                n2 = 0;
                while (n2 < by) {
                    int n5 = 0;
                    while (n5 < n3) {
                        if (++n4 >= 8) {
                            n4 = 0;
                            by2 = dataInputStream.readByte();
                        }
                        if (by2 & true) {
                            u.var_byte_arr_arr_b[n2][n5] = 1;
                        }
                        by2 = (byte)(by2 >> 1);
                        ++n5;
                    }
                    ++n2;
                }
                dataInputStream.close();
            }
            catch (Exception exception) {
                Exception exception2 = exception;
                exception.printStackTrace();
            }
        }
        var_int_b = u.b("nhung1");
    }

    private static void b() {
        if (var_byte_arr_arr_b != null) {
            return;
        }
        var_java_util_Hashtable_b = new Hashtable();
        DataInputStream dataInputStream = new DataInputStream("".getClass().getResourceAsStream("/font.bin"));
        try {
            String string = dataInputStream.readUTF();
            byte by = var_byte_b = dataInputStream.readByte();
            int n2 = string.length();
            var_int_arr_b = new int[n2];
            var_int_arr_c = new int[n2];
            int n3 = 0;
            int n4 = 0;
            while (n4 < n2) {
                u.var_int_arr_b[n4] = dataInputStream.readByte();
                u.var_int_arr_c[n4] = n3;
                n3 += var_int_arr_b[n4];
                var_java_util_Hashtable_b.put(new Integer(string.charAt(n4)), new Integer(n4));
                ++n4;
            }
            var_byte_arr_arr_b = new byte[by][n3];
            n4 = 7;
            byte by2 = 0;
            n2 = 0;
            while (n2 < by) {
                int n5 = 0;
                while (n5 < n3) {
                    if (++n4 >= 8) {
                        n4 = 0;
                        by2 = dataInputStream.readByte();
                    }
                    if (by2 & true) {
                        u.var_byte_arr_arr_b[n2][n5] = 1;
                    }
                    by2 = (byte)(by2 >> 1);
                    ++n5;
                }
                ++n2;
            }
            dataInputStream.close();
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static int b(String string) {
        if (string == var_java_lang_String_b) {
            return var_int_c;
        }
        var_java_lang_String_b = string;
        var_int_c = u.b(string, 0, string.length() - 1);
        return var_int_c;
    }

    private static int b(String string, int n2, int n3) {
        n2 = 0;
        int n4 = 0;
        while (n4 <= n3) {
            Integer n5 = new Integer(string.charAt(n4));
            try {
                n2 += var_int_arr_b[(Integer)var_java_util_Hashtable_b.get(n5)];
            }
            catch (Exception exception) {}
            ++n4;
        }
        return n2;
    }

    private static int b(short[] sArray) {
        return u.b(sArray, 0, sArray.length - 1);
    }

    private static int b(short[] sArray, int n2, int n3) {
        n2 = 0;
        int n4 = 0;
        while (n4 <= n3) {
            Integer n5 = new Integer(sArray[n4]);
            try {
                n2 += var_int_arr_b[(Integer)var_java_util_Hashtable_b.get(n5)];
            }
            catch (Exception exception) {}
            ++n4;
        }
        return n2;
    }

    public static int b(char c2) {
        if (c2 == var_char_b) {
            return a;
        }
        try {
            var_char_b = c2;
            a = var_int_arr_b[(Integer)var_java_util_Hashtable_b.get(new Integer(c2))];
            return a;
        }
        catch (Exception exception) {
            a = 0;
            return 0;
        }
    }

    private static void b(Graphics graphics, String string, int n2, int n3, int n4, int n5, int n6, byte by) {
        int n7;
        int n8 = n7 = u.b(string);
        n7 = n4;
        n2 -= (n7 & 1) != 0 ? n8 >> 1 : ((n7 & 8) != 0 ? n8 : 0);
        n8 = var_byte_b;
        n7 = n4;
        n3 -= (n7 & 2) != 0 ? n8 >> 1 : ((n7 & 0x20) != 0 ? n8 : ((n7 & 0x40) != 0 ? n8 >> 1 : 0));
        switch (by) {
            case 0: {
                u.b(graphics, string, n2, n3, n5);
                return;
            }
            case 1: {
                int n9 = n2;
                int n10 = n3;
                n3 = n6;
                n2 = n5;
                int n11 = n10;
                int n12 = n9;
                String string2 = string;
                Graphics graphics2 = graphics;
                n4 = string2.length();
                n5 = graphics2.getColor();
                n6 = 0;
                while (n6 < n4) {
                    n12 += u.b(graphics2, string2.charAt(n6), n12, n11, n2, n3);
                    ++n6;
                }
                graphics2.setColor(n5);
                return;
            }
            case 2: {
                u.b(graphics, string, n2, n3);
            }
        }
    }

    public static final void b(Graphics graphics, String string, int n2, int n3, int n4) {
        int n5 = graphics.getColor();
        graphics.setColor(n4);
        u.b(graphics, string, n2, n3);
        graphics.setColor(n5);
    }

    private static void b(Graphics graphics, short[] object, int n2, int n3, int n4) {
        int n5 = graphics.getColor();
        graphics.setColor(n4);
        n4 = n3;
        n3 = n2;
        short[] sArray = object;
        object = graphics;
        int n6 = sArray.length;
        int n7 = 0;
        while (n7 < n6) {
            n3 += u.b((Graphics)object, (char)sArray[n7], n3, n4);
            ++n7;
        }
        graphics.setColor(n5);
    }

    private static int b(Graphics graphics, String string, int n2, int n3) {
        int n4 = string.length();
        int n5 = 0;
        while (n5 < n4) {
            n2 += u.b(graphics, string.charAt(n5), n2, n3);
            ++n5;
        }
        return n2;
    }

    private static int b(Graphics graphics, short[] sArray, int n2, int n3) {
        int n4 = sArray.length;
        int n5 = 0;
        while (n5 < n4) {
            n2 += u.b(graphics, (char)sArray[n5], n2, n3);
            ++n5;
        }
        return n2;
    }

    private static int b(Graphics graphics, int n2, String string, int n3, int n4) {
        if (n2 > string.length()) {
            n2 = string.length();
        }
        int n5 = 0;
        while (n5 < n2) {
            n3 += u.b(graphics, string.charAt(n5), n3, n4);
            ++n5;
        }
        return n3;
    }

    public static final void c(Graphics graphics, String string, int n2, int n3, int n4) {
        int n5 = n2;
        int n6 = n3;
        if ((n4 & 1) != 0) {
            n5 = n2 - u.b(string) / 2;
        } else if ((n4 & 8) != 0) {
            n5 = n2 - u.b(string);
        }
        n6 = (n4 & 2) != 0 ? n3 - (var_byte_b / 2 + 2) : ((n4 & 0x20) != 0 ? n3 - (var_byte_b + 4) : (n6 += 4));
        n2 = string.length();
        n3 = 0;
        while (n3 < n2) {
            n5 += u.b(graphics, string.charAt(n3), n5, n6);
            ++n3;
        }
    }

    public static final void b(Graphics graphics, String string, int n2, int n3, int n4, int n5, int n6) {
        int n7 = n2;
        int n8 = n3;
        if ((n4 & 1) != 0) {
            n7 = n2 - u.b(string) / 2;
        } else if ((n4 & 8) != 0) {
            n7 = n2 - u.b(string);
        }
        n8 = (n4 & 2) != 0 ? n3 - (var_byte_b / 2 + 2) : ((n4 & 0x20) != 0 ? n3 - (var_byte_b + 4) : (n8 += 4));
        n2 = string.length();
        n3 = 0;
        while (n3 < n2) {
            n7 += u.b(graphics, string.charAt(n3), n7, n8, n5, n6);
            ++n3;
        }
    }

    private static void b(Graphics graphics, String string, int n2, int n3, int n4, int n5) {
        int n6 = string.length();
        int n7 = graphics.getColor();
        int n8 = 0;
        while (n8 < n6) {
            n2 += u.b(graphics, string.charAt(n8), n2, n3, n4, n5);
            ++n8;
        }
        graphics.setColor(n7);
    }

    private static void b(Graphics graphics, short[] sArray, int n2, int n3, int n4, int n5) {
        int n6 = sArray.length;
        int n7 = graphics.getColor();
        int n8 = 0;
        while (n8 < n6) {
            n2 += u.b(graphics, (char)sArray[n8], n2, n3, n4, n5);
            ++n8;
        }
        graphics.setColor(n7);
    }

    private static final int b(int n2, int n3) {
        if ((n2 & 1) != 0) {
            return n3 >> 1;
        }
        if ((n2 & 8) != 0) {
            return n3;
        }
        return 0;
    }

    private static final int c(int n2, int n3) {
        if ((n2 & 2) != 0) {
            return n3 >> 1;
        }
        if ((n2 & 0x20) != 0) {
            return n3;
        }
        if ((n2 & 0x40) != 0) {
            return n3 >> 1;
        }
        return 0;
    }

    private static int b(Graphics graphics, char c2, int n2, int n3, int n4, int n5) {
        Integer n6 = new Integer(c2);
        try {
            int n7 = (Integer)var_java_util_Hashtable_b.get(n6);
            int n8 = var_int_arr_b[n7];
            n7 = var_int_arr_c[n7];
            int n9 = var_byte_b;
            int n10 = 0;
            while (n10 < n9) {
                byte[] byArray = var_byte_arr_arr_b[n10];
                int n11 = 0;
                while (n11 < n8) {
                    if (byArray[n11 + n7] != 0) {
                        graphics.setColor(n4);
                        graphics.drawLine(n2 + n11, n3 + n10, n2 + n11, n3 + n10);
                        graphics.setColor(n5);
                        graphics.drawLine(n2 + n11 + 1, n3 + n10, n2 + n11, n3 + n10 + 1);
                    }
                    ++n11;
                }
                ++n10;
            }
            return n8;
        }
        catch (Exception exception) {
            return 0;
        }
    }

    private static int b(Graphics graphics, char c2, int n2, int n3) {
        Integer n4 = new Integer(c2);
        try {
            int n5 = (Integer)var_java_util_Hashtable_b.get(n4);
            int n6 = var_int_arr_b[n5];
            n5 = var_int_arr_c[n5];
            int n7 = var_byte_b;
            int n8 = 0;
            while (n8 < n7) {
                byte[] byArray = var_byte_arr_arr_b[n8];
                int n9 = 0;
                while (n9 < n6) {
                    if (byArray[n9 + n5] != 0) {
                        graphics.drawLine(n2 + n9, n3 + n8, n2 + n9, n3 + n8);
                    }
                    ++n9;
                }
                ++n8;
            }
            return n6;
        }
        catch (Exception exception) {
            return 0;
        }
    }

    public static String[] b(String string, int n2) {
        String[] stringArray = new String[50];
        int n3 = string.length();
        int n4 = n2 - var_int_b;
        int n5 = 0;
        int n6 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int n7 = 0;
        while (n7 < n3) {
            char c2 = string.charAt(n7);
            int n8 = u.b(c2);
            if ((n5 += n8) > n2 || c2 == ' ' && n5 > n4) {
                stringArray[n6++] = stringBuffer.toString();
                stringBuffer = new StringBuffer();
                if (c2 != ' ') {
                    n5 = n8;
                    stringBuffer.append(c2);
                } else {
                    n5 = 0;
                }
            } else {
                stringBuffer.append(c2);
            }
            ++n7;
        }
        if (stringBuffer.length() > 0) {
            stringArray[n6++] = stringBuffer.toString();
        }
        String[] stringArray2 = new String[n6];
        System.arraycopy(stringArray, 0, stringArray2, 0, n6);
        return stringArray2;
    }

    private static String[] b(short[] sArray, int n2) {
        String[] stringArray = new String[50];
        int n3 = sArray.length;
        int n4 = n2 - var_int_b;
        int n5 = 0;
        int n6 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int n7 = 0;
        while (n7 < n3) {
            char c2 = (char)sArray[n7];
            int n8 = u.b(c2);
            if ((n5 += n8) > n2 || c2 == ' ' && n5 > n4) {
                stringArray[n6++] = stringBuffer.toString();
                stringBuffer = new StringBuffer();
                if (c2 != ' ') {
                    n5 = n8;
                    stringBuffer.append(c2);
                } else {
                    n5 = 0;
                }
            } else {
                stringBuffer.append(c2);
            }
            ++n7;
        }
        if (stringBuffer.length() > 0) {
            stringArray[n6++] = stringBuffer.toString();
        }
        String[] stringArray2 = new String[n6];
        System.arraycopy(stringArray, 0, stringArray2, 0, n6);
        return stringArray2;
    }

    private static String[] b(short[][] sArray, int n2) {
        String[] stringArray = new String[50];
        int n3 = n2 - var_int_b;
        int n4 = 0;
        int n5 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int n6 = 0;
        while (n6 < sArray.length) {
            int n7 = sArray[n6].length;
            int n8 = 0;
            while (n8 <= n7) {
                char c2 = n8 == n7 ? (char)' ' : (char)sArray[n6][n8];
                int n9 = u.b(c2);
                if ((n4 += n9) > n2 || c2 == ' ' && n4 > n3) {
                    stringArray[n5++] = stringBuffer.toString();
                    stringBuffer = new StringBuffer();
                    if (c2 != ' ') {
                        n4 = n9;
                        stringBuffer.append(c2);
                    } else {
                        n4 = 0;
                    }
                } else {
                    stringBuffer.append(c2);
                }
                ++n8;
            }
            ++n6;
        }
        if (stringBuffer.length() > 0) {
            stringArray[n5++] = stringBuffer.toString();
        }
        String[] stringArray2 = new String[n5];
        System.arraycopy(stringArray, 0, stringArray2, 0, n5);
        return stringArray2;
    }

    private static void b(Graphics graphics, String string, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl) {
        int n8 = n6 == 17 ? n2 + n4 / 2 : n2;
        int n9 = graphics.getClipX();
        int n10 = graphics.getClipY();
        int n11 = graphics.getClipWidth();
        int n12 = graphics.getClipHeight();
        int n13 = 0;
        if (bl) {
            n13 = u.b(string);
        }
        if (bl && n13 > n4 + 3) {
            int n14 = n13 - n4 + 30;
            n13 = (int)Math.abs(System.currentTimeMillis() / 30L % (long)(2 * n14) - (long)n14);
            n8 = (n6 & 1) != 0 ? (n8 += n13 - n14 / 2) : ((n6 & 8) != 0 ? (n8 += n13 - 15) : (n8 -= n13 - 15));
        } else if ((n6 & 1) != 0) {
            if (n13 == 0) {
                n13 = u.b(string);
            }
            n8 -= n13 / 2;
        }
        graphics.setClip(n2, n3, n4, n5 + 4);
        u.b(graphics, string, n8, n3, n7);
        graphics.setClip(n9, n10, n11, n12);
    }

    private static void b(Graphics graphics, short[] object, int n2, int n3, int n4, int n5, int n6, int n7, boolean n8) {
        int n9 = n6 == 17 ? n2 + n4 / 2 : n2;
        int n10 = graphics.getClipX();
        int n11 = graphics.getClipY();
        int n12 = graphics.getClipWidth();
        int n13 = graphics.getClipHeight();
        int n14 = 0;
        if (n8 != 0) {
            n14 = u.b(object);
        }
        if (n8 != 0 && n14 > n4 + 3) {
            n8 = n14 - n4 + 30;
            n14 = (int)Math.abs(System.currentTimeMillis() / 30L % (long)(2 * n8) - (long)n8);
            n9 = (n6 & 1) != 0 ? (n9 += n14 - n8 / 2) : ((n6 & 8) != 0 ? (n9 += n14 - 15) : (n9 -= n14 - 15));
        } else if ((n6 & 1) != 0) {
            if (n14 == 0) {
                n14 = u.b(object);
            }
            n9 -= n14 / 2;
        }
        graphics.setClip(n2, n3, n4, n5 + 4);
        Graphics graphics2 = graphics;
        n5 = n7;
        n4 = n3;
        n3 = n9;
        short[] sArray = object;
        object = graphics2;
        n6 = graphics2.getColor();
        object.setColor(n5);
        n5 = n4;
        n4 = n3;
        short[] sArray2 = sArray;
        sArray = object;
        n7 = sArray2.length;
        n8 = 0;
        while (n8 < n7) {
            n4 += u.b((Graphics)sArray, (char)sArray2[n8], n4, n5);
            ++n8;
        }
        object.setColor(n6);
        graphics.setClip(n10, n11, n12, n13);
    }

    private static void b(Graphics graphics, Object stringArray, int n2, int n3, int n4, int n5, int n6, int n7) {
        stringArray = stringArray instanceof short[] ? u.b((short[])stringArray, n4) : u.b((short[][])stringArray, n4);
        int n8 = stringArray.length;
        int n9 = n8 * 10;
        int n10 = graphics.getClipX();
        int n11 = graphics.getClipY();
        int n12 = graphics.getClipWidth();
        int n13 = graphics.getClipHeight();
        if (n5 < n9) {
            graphics.setClip(n2, n3, n4, n5);
            n3 = (int)((long)n3 - (System.currentTimeMillis() / 50L % (long)(3 * n5) - (long)n5));
        } else if (n6 == 17) {
            n3 += (n5 - n9) / 2;
        }
        if (n6 == 17) {
            n2 += n4 / 2;
        }
        n4 = 0;
        while (n4 < n8) {
            u.b(graphics, stringArray[n4], n2 - (n6 == 17 ? u.b(stringArray[n4]) / 2 : 0), n3 + n4 * 10, n7);
            ++n4;
        }
        if (n5 < n9) {
            graphics.setClip(n10, n11, n12, n13);
        }
    }

    private static void b(Graphics graphics, Object stringArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        stringArray = stringArray instanceof short[] ? u.b((short[])stringArray, n4) : u.b((short[][])stringArray, n4);
        int n9 = stringArray.length;
        int n10 = n9 * 10;
        int n11 = graphics.getClipX();
        int n12 = graphics.getClipY();
        int n13 = graphics.getClipWidth();
        int n14 = graphics.getClipHeight();
        if (n5 < n10) {
            graphics.setClip(n2, n3, n4, n5);
            n3 = (int)((long)n3 - (System.currentTimeMillis() / 50L % (long)(3 * n5) - (long)n5));
        } else if (n6 == 17) {
            n3 += (n5 - n10) / 2;
        }
        if (n6 == 17) {
            n2 += n4 / 2;
        }
        n4 = 0;
        int n15 = graphics.getColor();
        graphics.setColor(n7);
        n7 = 0;
        while (n7 < n9) {
            int n16 = stringArray[n7].length();
            int n17 = n3 + n7 * 10;
            int n18 = n2 - (n6 == 17 ? u.b(stringArray[n7]) / 2 : 0);
            String string = stringArray[n7];
            int n19 = n8 - n4;
            Graphics graphics2 = graphics;
            if (n19 > string.length()) {
                n19 = string.length();
            }
            int n20 = 0;
            while (n20 < n19) {
                n18 += u.b(graphics2, string.charAt(n20), n18, n17);
                ++n20;
            }
            if ((n4 += n16) >= n8) break;
            ++n7;
        }
        graphics.setColor(n15);
        if (n5 < n10) {
            graphics.setClip(n11, n12, n13, n14);
        }
    }

    private static short[] b(int n2, char c2) {
        String string = String.valueOf(n2);
        int n3 = string.length();
        short[] sArray = new short[n3 + 1];
        int n4 = 0;
        while (n4 < n3) {
            sArray[n4] = (short)string.charAt(n4);
            ++n4;
        }
        sArray[n3] = (short)c2;
        return sArray;
    }
}

