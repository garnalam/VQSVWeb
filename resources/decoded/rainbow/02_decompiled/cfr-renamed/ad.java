/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Font
 *  javax.microedition.lcdui.Image
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;

public final class ad {
    private static ad var_ad_b;
    public int var_int_b;
    private static an var_an_b;
    public static int var_int_c;
    public static int a;
    private static Random var_java_util_Random_b;
    public static Font var_javax_microedition_lcdui_Font_b;
    public static boolean var_boolean_b;
    public static int e;
    private static byte var_byte_b;
    private static byte var_byte_c;

    public ad() {
        byte[] byArray = new byte[]{0, 6, 3, 5, 2, 7, 1, 4};
        var_ad_b = this;
    }

    public static ad ad_b() {
        if (var_ad_b == null) {
            var_ad_b = new ad();
        }
        return var_ad_b;
    }

    public static byte[] byte_arr_b(int n2, byte[] byArray, int n3) {
        try {
            if (var_an_b == null) {
                var_an_b = an.b("pk5_caihong", true);
            }
            if (var_an_b.int_b() == 0) {
                ad.b(true);
            }
            if (n3 != 0) {
                if (n3 == 1) {
                    return var_an_b.byte_arr_b(n2);
                }
                if (n3 == 2) {
                    var_an_b.b(n2, byArray, 0, byArray.length);
                } else if (n3 == 3) {
                    ad.b(false);
                } else if (n3 == 4) {
                    if (var_an_b != null) {
                        var_an_b.void_b();
                        var_an_b = null;
                    }
                } else if (n3 == 5) {
                    if (var_an_b.c() > 15360) {
                        return null;
                    }
                    return new byte[]{1};
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private static void b(boolean bl) {
        byte[] byArray = new byte[140];
        byte[] byArray2 = byArray;
        byArray[0] = -1;
        byte[] byArray3 = new byte[280];
        for (int i2 = 0; i2 < 82; ++i2) {
            if (!bl && i2 == 4) continue;
            if (i2 != 11) {
                if (bl) {
                    var_an_b.int_b(byArray2, 0, byArray2.length);
                    continue;
                }
                var_an_b.b(i2 + 1, byArray2, 0, byArray2.length);
                continue;
            }
            if (bl) {
                var_an_b.int_b(byArray3, 0, byArray3.length);
                continue;
            }
            var_an_b.b(i2 + 1, byArray3, 0, byArray3.length);
        }
    }

    public static byte[] b(short[][] sArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(sArray.length);
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            if (sArray[i2] == null) {
                byteArrayOutputStream.write(0);
                continue;
            }
            byteArrayOutputStream.write(sArray[i2].length);
            for (int i3 = 0; i3 < sArray[i2].length; ++i3) {
                byteArrayOutputStream.write(sArray[i2][i3] & 0xFF);
                byteArrayOutputStream.write(sArray[i2][i3] >> 8 & 0xFF);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final short[][] short_arr_arr_b() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ad.byte_arr_b(11, null, 1));
        short[][] sArrayArray = new short[byteArrayInputStream.read()][];
        for (int i2 = 0; i2 < sArrayArray.length; ++i2) {
            int n2 = byteArrayInputStream.read();
            if (n2 == 0) continue;
            sArrayArray[i2] = new short[n2];
            for (n2 = 0; n2 < sArrayArray[i2].length; ++n2) {
                sArrayArray[i2][n2] = (short)(byteArrayInputStream.read() | byteArrayInputStream.read() << 8);
            }
        }
        return sArrayArray;
    }

    public static long long_b(byte[] byArray) {
        int n2 = 0;
        int n3 = byArray.length;
        block6: for (int i2 = 0; i2 < n3; ++i2) {
            switch (n3) {
                case 1: {
                    n2 += (byte)((byArray[i2] & 0xFF) << (i2 << 3));
                    continue block6;
                }
                case 2: {
                    n2 += (short)((byArray[i2] & 0xFF) << (i2 << 3));
                    continue block6;
                }
                case 4: {
                    n2 += (byArray[i2] & 0xFF) << (i2 << 3);
                    continue block6;
                }
                case 8: {
                    n2 = (int)((long)n2 + (long)((byArray[i2] & 0xFF) << (i2 << 3)));
                }
            }
        }
        return n2;
    }

    private static int b(byte by) {
        if (by < 0) {
            return by + 256;
        }
        return by;
    }

    private static int b(short s2) {
        if (s2 < 0) {
            return s2 + 65536;
        }
        return s2;
    }

    public static int int_b(byte[] byArray, int n2) {
        return (byArray[n2] & 0xFF) << 24 | (byArray[n2 + 1] & 0xFF) << 16 | (byArray[n2 + 2] & 0xFF) << 8 | byArray[n2 + 3] & 0xFF;
    }

    public static void void_b(int n2, byte[] byArray, int n3) {
        byArray[n3] = (byte)(n2 >>> 24);
        byArray[n3 + 1] = (byte)(n2 >> 16);
        byArray[n3 + 2] = (byte)(n2 >> 8);
        byArray[n3 + 3] = (byte)n2;
    }

    public static short short_b(byte[] byArray, int n2) {
        return (short)((byArray[n2] & 0xFF) << 8 | byArray[n2 + 1] & 0xFF);
    }

    public static void c(int n2, byte[] byArray, int n3) {
        byArray[n3] = (byte)(n2 >> 8);
        byArray[n3 + 1] = (byte)n2;
    }

    private static void void_b(byte[] byArray, int n2) {
        byArray[ad.var_int_c++] = (byte)(n2 >> 8);
        byArray[ad.var_int_c++] = (byte)n2;
    }

    public static short[] short_arr_b(byte[] byArray) {
        var_int_c = 0;
        int n2 = byArray.length >> 1;
        short[] sArray = new short[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            sArray[i2] = ad.c(byArray, 2);
        }
        return sArray;
    }

    public static byte[] b(short[] sArray) {
        var_int_c = 0;
        int n2 = sArray.length;
        byte[] byArray = new byte[n2 << 1];
        for (int i2 = 0; i2 < n2; ++i2) {
            short s2 = sArray[i2];
            byte[] byArray2 = byArray;
            byArray[ad.var_int_c++] = (byte)(s2 >> 8);
            byArray2[ad.var_int_c++] = (byte)s2;
        }
        return byArray;
    }

    private static short c(byte[] byArray, int n2) {
        if (n2 == 0) {
            return byArray[var_int_c++];
        }
        if (n2 == 1) {
            return (short)(byArray[var_int_c++] + 100);
        }
        if (n2 == 2) {
            return (short)((byArray[var_int_c++] & 0xFF) << 8 | byArray[var_int_c++] & 0xFF);
        }
        return (short)(byArray[var_int_c++] & 0xFF | (byArray[var_int_c++] & 0xFF) << 8);
    }

    public final byte[] byte_arr_b(String string, int n2) {
        byte[] byArray = null;
        try {
            DataInputStream dataInputStream = new DataInputStream(this.getClass().getResourceAsStream("/" + string));
            if (n2 >= 0) {
                dataInputStream.readByte();
                for (int n3 = 0; n3 < n2; n3 = (int)((byte)(n3 + 1))) {
                    dataInputStream.skip(ad.b(dataInputStream.readShort()));
                }
            }
            byArray = new byte[ad.b(dataInputStream.readShort())];
            dataInputStream.read(byArray);
            dataInputStream.close();
        }
        catch (Exception exception) {
            Object var4_6 = null;
            exception.printStackTrace();
        }
        return byArray;
    }

    private static short[] short_arr_b(byte[] byArray, int n2) {
        short[] sArray = new short[ad.c(byArray, n2)];
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            sArray[i2] = ad.c(byArray, n2 == 2 ? 2 : -1);
        }
        return sArray;
    }

    public final short[][] short_arr_arr_b(byte[] byArray, int n2) {
        short[][] sArrayArray = new short[ad.c(byArray, n2)][];
        for (int i2 = 0; i2 < sArrayArray.length; ++i2) {
            int n3 = n2;
            byte[] byArray2 = byArray;
            short[] sArray = new short[ad.c(byArray, n3)];
            for (int i3 = 0; i3 < sArray.length; ++i3) {
                sArray[i3] = ad.c(byArray2, n3 == 2 ? 2 : -1);
            }
            sArrayArray[i2] = sArray;
        }
        return sArrayArray;
    }

    public final short[][][] short_arr_arr_arr_b(byte[] byArray, int n2) {
        short[][][] sArrayArray = new short[ad.c(byArray, 2)][][];
        for (int i2 = 0; i2 < sArrayArray.length; ++i2) {
            sArrayArray[i2] = this.short_arr_arr_b(byArray, 2);
        }
        return sArrayArray;
    }

    public static byte[] byte_arr_b(byte[] byArray) {
        byte[] byArray2 = new byte[ad.b(byArray[var_int_c++])];
        for (int i2 = 0; i2 < byArray2.length; ++i2) {
            byArray2[i2] = byArray[var_int_c++];
        }
        return byArray2;
    }

    public final byte[][] byte_arr_arr_b(byte[] byArray) {
        byte[][] byArrayArray = new byte[ad.b(byArray[var_int_c++])][];
        for (int i2 = 0; i2 < byArrayArray.length; ++i2) {
            byArrayArray[i2] = ad.byte_arr_b(byArray);
        }
        return byArrayArray;
    }

    private byte[][][] byte_arr_arr_arr_b(byte[] byArray) {
        byte[][][] byArrayArray = new byte[ad.b(byArray[var_int_c++])][][];
        for (int i2 = 0; i2 < byArrayArray.length; ++i2) {
            byArrayArray[i2] = this.byte_arr_arr_b(byArray);
        }
        return byArrayArray;
    }

    public static StringBuffer[] java_lang_StringBuffer_arr_b(byte[] byArray) {
        StringBuffer[] stringBufferArray = new StringBuffer[ad.b(byArray[var_int_c++])];
        for (int n2 = 0; n2 < stringBufferArray.length; n2 = (int)((byte)(n2 + 1))) {
            short s2 = byArray[var_int_c];
            if (s2 < 0) {
                s2 = (short)(s2 + 256);
            }
            stringBufferArray[n2] = new StringBuffer(ad.java_lang_String_b(byArray, var_int_c + 1, (int)s2));
            var_int_c += 1 + (s2 << 1);
        }
        return stringBufferArray;
    }

    public final StringBuffer[][] java_lang_StringBuffer_arr_arr_b(byte[] byArray) {
        StringBuffer[][] stringBufferArray = new StringBuffer[byArray[var_int_c++]][];
        for (int n2 = 0; n2 < stringBufferArray.length; n2 = (int)((byte)(n2 + 1))) {
            stringBufferArray[n2] = ad.java_lang_StringBuffer_arr_b(byArray);
        }
        return stringBufferArray;
    }

    public static String java_lang_String_b(byte[] byArray, int n2, int n3) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < n3; ++i2) {
            stringBuffer.append((char)(byArray[n2 + (i2 << 1)] << 8 | 0xFF & byArray[n2 + (i2 << 1) + 1]));
        }
        return stringBuffer.toString();
    }

    private static StringBuffer[] c(String string, int n2) {
        StringBuffer[] stringBufferArray = new StringBuffer[30];
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer(string);
        int n3 = string.length();
        byte by = 0;
        String string2 = "#0";
        byte by2 = (byte)u.b("#0");
        int n4 = -1;
        boolean bl = false;
        String string3 = "";
        for (int i2 = 0; i2 < n3; ++i2) {
            if (stringBuffer2.charAt(0) == '#') {
                if (stringBuffer2.charAt(1) == 'n') {
                    bl = true;
                } else {
                    string3 = "#" + stringBuffer2.charAt(1);
                    stringBuffer.append(string3);
                    by = (byte)(by + 1);
                }
                stringBuffer2.deleteCharAt(0);
                stringBuffer2.deleteCharAt(0);
                ++i2;
            } else {
                stringBuffer.append(stringBuffer2.charAt(0));
                if (n2 != 0 && u.b(string2 = stringBuffer.toString()) <= n2 + by2 * by) {
                    stringBuffer2.deleteCharAt(0);
                } else if (n2 != 0) {
                    --i2;
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    bl = true;
                } else {
                    stringBuffer2.deleteCharAt(0);
                }
                if (i2 == n3 - 1 && !bl) {
                    bl = true;
                }
            }
            if (!bl) continue;
            n4 = (byte)(n4 + 1);
            by = (byte)(string3.length() != 0 ? 1 : 0);
            bl = false;
            stringBufferArray[n4] = stringBuffer;
            stringBuffer = new StringBuffer();
            stringBuffer.append(string3);
        }
        StringBuffer[] stringBufferArray2 = new StringBuffer[n4 + 1];
        System.arraycopy(stringBufferArray, 0, stringBufferArray2, 0, n4 + 1);
        return stringBufferArray2;
    }

    public static String[] java_lang_String_arr_b(byte[] object) {
        try {
            int n2;
            int n3;
            Serializable serializable = new StringBuffer("");
            int n4 = 2;
            while (n4 < ((byte[])object).length) {
                if ((n3 = object[n4++]) < 0) {
                    n3 += 256;
                }
                if ((n2 = object[n4++]) < 0) {
                    n2 += 256;
                }
                n3 = (char)(n3 + (n2 << 8));
                ((StringBuffer)serializable).append((char)n3);
            }
            object = ((StringBuffer)serializable).toString();
            serializable = new Vector();
            n3 = 0;
            n2 = 0;
            for (n4 = 0; n4 < ((String)object).length(); ++n4) {
                if (((String)object).charAt(n4) == '\n' || n4 == ((String)object).length()) {
                    String string = ((String)object).substring(n3, n2);
                    ((Vector)serializable).addElement(string);
                    n3 = n2 + 1;
                }
                ++n2;
            }
            object = new String[((Vector)serializable).size()];
            for (n4 = 0; n4 < ((Vector)serializable).size(); ++n4) {
                String string = (String)((Vector)serializable).elementAt(n4);
                object[n4] = string;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return object;
    }

    public static Image[] b(int n2, String string) {
        Image[] imageArray = new Image[n2];
        for (int n3 = 0; n3 < imageArray.length; n3 = (int)((short)(n3 + 1))) {
            imageArray[n3] = ad.javax_microedition_lcdui_Image_b(string + n3);
        }
        return imageArray;
    }

    public static Image javax_microedition_lcdui_Image_b(String string) {
        try {
            return Image.createImage((String)("/" + string + ".png"));
        }
        catch (Exception exception) {
            return null;
        }
    }

    public final am b(String string, boolean bl) {
        byte[] byArray = this.byte_arr_b(string + ".data", -1);
        var_int_c = 0;
        if (bl) {
            return am.am_b(ad.javax_microedition_lcdui_Image_b(string), this.byte_arr_arr_b(byArray), this.byte_arr_arr_arr_b(byArray), this.byte_arr_arr_arr_b(byArray));
        }
        return am.am_b(ad.javax_microedition_lcdui_Image_b(string), this.short_arr_arr_b(byArray, 2), this.short_arr_arr_arr_b(byArray, 2), this.short_arr_arr_arr_b(byArray, 2));
    }

    public final void b(am am2, String string, boolean bl) {
        byte[] byArray = this.byte_arr_b(string + ".data", -1);
        var_int_c = 0;
        am2.void_b();
        if (bl) {
            am2.void_b(ad.javax_microedition_lcdui_Image_b(string), this.byte_arr_arr_b(byArray), this.byte_arr_arr_arr_b(byArray), this.byte_arr_arr_arr_b(byArray));
            return;
        }
        am2.void_b(ad.javax_microedition_lcdui_Image_b(string), this.short_arr_arr_b(byArray, 2), this.short_arr_arr_arr_b(byArray, 2), this.short_arr_arr_arr_b(byArray, 2));
    }

    public static boolean b(StringBuffer stringBuffer, String string) {
        return stringBuffer.toString().equals(string);
    }

    public static boolean b(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        return n2 < n6 + n8 && n2 + n4 > n6 && n3 < n7 + n9 && n3 + n5 > n7;
    }

    public static String java_lang_String_b(int n2) {
        return n2 / 10 + "." + n2 % 10;
    }

    public static int int_b(int n2) {
        if (n2 > 0) {
            int n3;
            n2 *= 10000;
            int n4 = 10000;
            while ((n4 = n2 / n4 + n4 >> 1) < (n3 = n4)) {
            }
            return n3 / 100;
        }
        return 0;
    }

    public static int c(int n2) {
        return (var_java_util_Random_b.nextInt() & Integer.MAX_VALUE) % n2;
    }

    public static int a(int n2) {
        if (n2 > 0) {
            return n2;
        }
        return -n2;
    }

    public static short short_b(int n2, int n3, int n4) {
        if (n4 <= 0) {
            n4 = 1;
        }
        return (short)(n2 * n3 / n4);
    }

    public static int int_b(String string) {
        return u.b(string);
    }

    public static short b(int n2, int n3, boolean bl) {
        n2 = n2 / n3 != 0 ? (n2 -= n2 / n3) : (bl && n2 > 0 ? --n2 : (bl && n2 < 0 ? ++n2 : 0));
        return (short)n2;
    }

    public static short c(int n2, int n3, int n4) {
        return (short)((n2 -= (62 - n2) / 2) < 0 ? 0 : n2);
    }

    public static short b(int n2, int n3, int n4, boolean bl) {
        n2 = n2 > n3 && n2 - n4 > n3 ? (n2 -= n4) : (n2 < n3 && n2 + n4 < n3 ? (n2 += n4) : (bl && n2 > n3 ? --n2 : (bl && n2 < n3 ? ++n2 : n3)));
        return (short)n2;
    }

    public static byte byte_b(int n2, int n3, int n4) {
        if (n4 == 0) {
            return (byte)n2;
        }
        if (ad.a(e) % 2 == 1 && --n2 < n3) {
            n2 = n4;
        } else if (ad.a(e) % 2 == 0 && ++n2 > n4) {
            n2 = n3;
        }
        return (byte)n2;
    }

    public static void b(byte[] byArray, int n2, int n3, int n4) {
        if (n3 == 0) {
            return;
        }
        byArray[0] = ad.byte_b((int)byArray[0], n2, n3 - 1);
        if (byArray[1] - 1 == byArray[0]) {
            byArray[1] = (byte)(byArray[1] - 1);
            return;
        }
        if (byArray[1] + n4 == byArray[0]) {
            byArray[1] = (byte)(byArray[1] + 1);
            return;
        }
        if (byArray[0] == n3 - 1) {
            byArray[1] = (byte)(n3 - n2 < n4 ? n2 : n3 - n4);
            return;
        }
        if (byArray[0] == n2) {
            byArray[1] = (byte)n2;
        }
    }

    public static void void_b(byte[] byArray, int n2, int n3) {
        if (byArray[0] < n2) {
            byArray[1] = (byte)(byArray[0] - n3 + 1);
        } else {
            byArray[0] = (byte)(n2 - 1);
            byArray[1] = (byte)(n2 - n3);
        }
        if (byArray[0] < 0) {
            byArray[0] = 0;
        }
        if (byArray[1] < 0) {
            byArray[1] = 0;
        }
    }

    public static void void_b() {
        if (var_byte_b > 0) {
            var_byte_b = (byte)(var_byte_b - 1);
        }
    }

    public static boolean boolean_b() {
        if (var_byte_b == 0) {
            var_byte_b = var_byte_c;
            if (var_byte_c > 1) {
                var_byte_c = (byte)(var_byte_c - 1);
            }
            return false;
        }
        return true;
    }

    public static void void_c() {
        var_boolean_b = false;
        var_byte_b = 0;
        var_byte_c = (byte)10;
    }

    public static boolean boolean_c() {
        return e == -1 || e == -2;
    }

    public static boolean a() {
        return e == -1;
    }

    public static boolean e() {
        return e == -3 || e == -4;
    }

    public static boolean d() {
        return e == -3;
    }

    public static boolean h() {
        return e == -4;
    }

    public static boolean g() {
        return e == -6 || e == 53 || e == -5;
    }

    public static boolean f() {
        return e == -6;
    }

    public static boolean i() {
        return e == -7;
    }

    public static boolean j() {
        return e == 48;
    }

    public static boolean k() {
        return e == 49;
    }

    public static boolean l() {
        return e == 51;
    }

    public static boolean m() {
        return e == 57;
    }

    static {
        var_java_util_Random_b = new Random();
        var_javax_microedition_lcdui_Font_b = Font.getFont((int)0, (int)0, (int)8);
        var_byte_b = 0;
        var_byte_c = (byte)10;
    }

    /*
     * Unable to fully structure code
     */
    public static StringBuffer[] java_lang_StringBuffer_arr_b(String var0, int var1_1) {
        var2_2 = new StringBuffer[50];
        var3_3 = var0.length();
        var4_4 = var1_1 - u.var_int_b;
        var5_5 = 0;
        var6_6 = 0;
        var7_7 = new StringBuffer();
        var8_8 = 0;
        while (var8_8 < var3_3) {
            var9_10 = var0.charAt(var8_8);
            if (var9_10 != '#') ** GOTO lbl18
            if ((var9_10 = var0.charAt(++var8_8)) != 'n') {
                var7_7.append('#');
                var7_7.append(var9_10);
            } else {
                var9_10 = '\n';
lbl18:
                // 2 sources

                var10_11 = u.b(var9_10);
                if (var9_10 == '\n' || (var5_5 += var10_11) > var1_1 || var9_10 == ' ' && var5_5 > var4_4) {
                    var2_2[var6_6++] = var7_7;
                    var7_7 = new StringBuffer();
                    if (var9_10 != ' ' && var9_10 != '\n') {
                        var5_5 = var10_11;
                        var7_7.append(var9_10);
                    } else {
                        var5_5 = 0;
                    }
                } else {
                    var7_7.append(var9_10);
                }
            }
            ++var8_8;
        }
        if (var7_7.length() > 0) {
            var2_2[var6_6++] = var7_7;
        }
        var8_9 = new StringBuffer[var6_6];
        System.arraycopy(var2_2, 0, var8_9, 0, var6_6);
        return var8_9;
    }
}

