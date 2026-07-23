/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nokia.mid.ui.DirectGraphics
 *  com.nokia.mid.ui.DirectUtils
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class as {
    public static ag var_ag_b;
    public static Image var_javax_microedition_lcdui_Image_b;
    public static Graphics var_javax_microedition_lcdui_Graphics_b;
    public static Graphics var_javax_microedition_lcdui_Graphics_c;
    private static DirectGraphics var_com_nokia_mid_ui_DirectGraphics_b;
    public StringBuffer[] var_java_lang_StringBuffer_arr_c;
    public StringBuffer[] var_java_lang_StringBuffer_arr_a;
    public StringBuffer[] e;
    public StringBuffer[] var_java_lang_StringBuffer_arr_d;
    public int var_int_g;
    public String var_java_lang_String_b;
    public int var_int_f;
    private byte var_byte_b;
    public StringBuffer[] var_java_lang_StringBuffer_arr_h;
    public byte o;
    public byte q;
    public byte[] var_byte_arr_d;
    public byte[] var_byte_arr_h;
    public byte[] var_byte_arr_g;
    public String var_java_lang_String_c;
    public String[] var_java_lang_String_arr_c;
    public byte s;
    public byte r;
    public byte t;
    public byte u;
    public byte v;
    public byte[] var_byte_arr_f;
    public byte[] i;
    public byte[][] var_byte_arr_arr_h;
    public short var_short_c;
    public short var_short_a;
    public byte[][][] var_byte_arr_arr_arr_b;
    public byte[] j;
    public byte w;
    public byte x;
    public byte[] k;
    public byte y;
    public byte z;
    public al var_al_b;
    public al[] var_al_arr_b;
    public al[] var_al_arr_c;
    public byte[] l;
    public byte[] m;
    public byte[] n;
    public byte[] p;
    public byte[][] var_byte_arr_arr_g;

    public as() {
        byte[] byArray = new byte[]{20, 36, 40, 24, 24, 40, 36, 20};
        short[] sArray = new short[]{0, 90, 180, 270, 8192, 8282, 8372, 8462};
        this.var_int_g = 120;
        this.var_java_lang_String_b = "";
        this.var_int_f = 240;
        this.var_byte_b = 0;
        this.o = 0;
        this.q = 0;
        this.var_byte_arr_d = new byte[]{0, 0, 0, 0};
        this.var_byte_arr_f = new byte[4];
        this.i = new byte[4];
        this.var_byte_arr_arr_h = new byte[2][2];
        this.w = (byte)3;
        this.x = (byte)10;
    }

    public static void c(Graphics graphics) {
        var_javax_microedition_lcdui_Graphics_c = graphics;
        DirectUtils.getDirectGraphics((Graphics)graphics);
    }

    public static void n() {
        var_javax_microedition_lcdui_Image_b = Image.createImage((int)260, (int)340);
        var_javax_microedition_lcdui_Graphics_b = var_javax_microedition_lcdui_Image_b.getGraphics();
    }

    public final void b(String string, int n2, int n3) {
        if (n3 == 0) {
            ad.ad_b();
            this.var_java_lang_StringBuffer_arr_c = ad.java_lang_StringBuffer_arr_b(string, n2);
            return;
        }
        if (n3 == 1) {
            ad.ad_b();
            this.var_java_lang_StringBuffer_arr_a = ad.java_lang_StringBuffer_arr_b(string, n2);
            return;
        }
        if (n3 == 2) {
            ad.ad_b();
            this.e = ad.java_lang_StringBuffer_arr_b(string, n2);
            return;
        }
        if (n3 == 3) {
            ad.ad_b();
            this.var_java_lang_StringBuffer_arr_d = ad.java_lang_StringBuffer_arr_b(string, n2);
        }
    }

    public static short short_b(String string) {
        int n2 = 0;
        byte by = 0;
        byte by2 = (byte)string.indexOf("#", 0);
        if (by2 == 0) {
            by2 = 1;
        }
        while (by2 != -1) {
            by = (byte)(by + by2);
            by2 = (byte)string.indexOf("#", (int)by);
            n2 = (byte)(n2 + 1);
        }
        ad.ad_b();
        return (short)(ad.int_b("#1") * n2);
    }

    public static void a(int n2, int n3, int n4, int n5) {
        ah.ah_b();
        ah.b("Nh\u1ea5n n\u00fat 0 \u0111\u1ec3 ti\u1ebfp t\u1ee5c", 120, 296, 33, 0, 0);
    }

    public static void c(String string, int n2) {
        ah.ah_b();
        ah.b("Nh\u1ea5n n\u00fat 0" + string, 120, 310, 33, 0, 0);
    }

    public final void b(String string, int n2, int n3, int n4, int n5, int n6, int n7) {
        ad.ad_b();
        short s2 = (short)(ad.int_b(string) - as.short_b(string));
        n2 = s2;
        if (s2 > 206) {
            this.var_int_g -= 2;
            if (this.var_int_g + n2 < 11) {
                this.var_int_g = 160;
            }
        } else {
            this.var_int_g = 11;
        }
        var_javax_microedition_lcdui_Graphics_c.clipRect(11, 278, 206, 25);
        ah.ah_b();
        ah.b(string, this.var_int_g, 278, 0, 1);
        var_javax_microedition_lcdui_Graphics_c.setClip(0, 0, 240, 320);
    }

    public final void b(String string, int n2, int n3, int n4, int n5, int n6) {
        ad.ad_b();
        n6 = (short)ad.int_b(string);
        this.var_int_f -= 2;
        if (this.var_int_f + n6 < n3 << 1) {
            this.var_int_f = 241;
        }
        var_javax_microedition_lcdui_Graphics_c.clipRect(n3, n2, 240 - (n3 << 1), 25);
        ah.ah_b();
        ah.b(string, this.var_int_f, n2, 0, n4, n5);
        var_javax_microedition_lcdui_Graphics_c.setClip(0, 0, 240, 320);
    }

    private void void_b(int n2, int n3) {
        ah.ah_b().a(40, n2, n3 + (this.var_byte_b % 3 == 0 ? 1 : 0), 0, 0);
        byte by = this.var_byte_b;
        this.var_byte_b = (byte)(by + 1);
        if (by > 100) {
            this.var_byte_b = 0;
        }
    }

    public final void b(StringBuffer[] stringBufferArray, int n2, int n3, int n4) {
        if (n4 != 0) {
            ah.ah_b();
            ah.a(n3 + -5, n2, 250, 20 * stringBufferArray.length + 12);
            if (n4 == 2) {
                int n5 = n2 + 20 * stringBufferArray.length + 4;
                int n6 = n3 + 120;
                as as2 = this;
                ah.ah_b().a(40, n6, n5 + (as2.var_byte_b % 3 == 0 ? 1 : 0), 0, 0);
                byte by = as2.var_byte_b;
                as2.var_byte_b = (byte)(by + 1);
                if (by > 100) {
                    as2.var_byte_b = 0;
                }
            }
        }
        for (n4 = 0; n4 < stringBufferArray.length; n4 = (int)((byte)(n4 + 1))) {
            ah.ah_b();
            ah.b(stringBufferArray[n4].toString(), n3 + 19, n2 + 4 + n4 * 20, -1, 1);
        }
    }

    public static void c(String stringArray, int n2, int n3) {
        stringArray = u.b((String)stringArray, 240);
        n3 = stringArray.length;
        ah.ah_b();
        ah.d(-5, n2, 250, 20 * (n3 + 1) + 8, 3);
        int n4 = 0;
        while (n4 < n3) {
            ah.b(stringArray[n4], 120, n2 + 5 + n4 * 20, 17, 13, 0);
            ++n4;
        }
    }

    public static void b(String stringArray, int n2, int n3, int n4, int n5) {
        stringArray = u.b((String)stringArray, (n4 + 2) * 13);
        n4 = stringArray.length;
        int n6 = 0;
        while (n6 < n4) {
            ah.b(stringArray[n6], n2, n3 + n6 * 15, 17, n5, 0);
            ++n6;
        }
    }

    public final void b(StringBuffer[] stringBufferArray, int n2, int n3, int n4, int n5) {
        n4 = (byte)(n2 * this.q);
        for (n3 = (int)(v82860); n3 < n4 + n2 && n3 < stringBufferArray.length; n3 = (int)((byte)(n3 + 1))) {
            ah.ah_b();
            ah.b(stringBufferArray[n3].toString(), 120, 10 + (n3 - n4) * 22, 17, 3, 0);
        }
        if (stringBufferArray.length > n2) {
            this.o = (byte)(stringBufferArray.length / n2 + (stringBufferArray.length % n2 != 0 ? 1 : 0));
            ah.ah_b();
            ah.b(this.q + 1 + "/" + this.o, 120, 318, 33, 3, 0);
            ah.ah_b().b(120, 308, 57, true, true);
            return;
        }
        this.o = 1;
    }

    public final void b(Graphics graphics, int n2, int n3, int n4, boolean bl, boolean bl2) {
        n3 = 0;
        graphics.setColor(0);
        if (!bl) {
            n4 = (short)(2 << this.var_byte_arr_d[0]);
            n3 = 9;
            while (n3 >= 0) {
                if (12 - n4 > 0) {
                    graphics.fillRect(0, n2 + n3 * 12 + (n4 < 2 ? 0 : n4), 240, 12 - (n4 < 2 ? 0 : n4));
                }
                n3 = (byte)(n3 - 1);
                n4 = (short)(n4 / 2);
            }
            if (bl2 && this.var_byte_arr_d[0] < 12) {
                this.var_byte_arr_d[0] = (byte)(this.var_byte_arr_d[0] + 1);
                return;
            }
            if (!bl2 && this.var_byte_arr_d[0] > 0) {
                this.var_byte_arr_d[0] = (byte)(this.var_byte_arr_d[0] - 1);
                return;
            }
        } else {
            n4 = (short)(2 << this.var_byte_arr_d[1]);
            while (bl && n3 < 10) {
                if (12 - n4 > 0) {
                    graphics.fillRect(0, n2 + n3 * 12, 240, 12 - (n4 < 2 ? 0 : n4));
                }
                n3 = (byte)(n3 + 1);
                n4 = (short)(n4 / 2);
            }
            if (bl2 && this.var_byte_arr_d[1] < 12) {
                this.var_byte_arr_d[1] = (byte)(this.var_byte_arr_d[1] + 1);
                return;
            }
            if (!bl2 && this.var_byte_arr_d[1] > 0) {
                this.var_byte_arr_d[1] = (byte)(this.var_byte_arr_d[1] - 1);
            }
        }
    }

    public static String java_lang_String_b(String string) {
        ad.ad_b();
        ad.var_int_c = 0;
        ad.ad_b();
        return ad.java_lang_StringBuffer_arr_b(ad.ad_b().byte_arr_b(string, -1))[0].toString();
    }

    public static byte[] byte_arr_b(int n2) {
        return ad.ad_b().byte_arr_b("4", n2);
    }

    public static void b(Object[] objectArray, int n2, int n3, int n4, int n5, int n6, int n7) {
        for (n6 = 0; n6 < objectArray.length; n6 = (int)((byte)(n6 + 1))) {
            ah.ah_b();
            ah.d(n2, n3 + n6 * (n5 + 28), n4, 28, n6 == n7 ? 1 : 0);
            ah.ah_b();
            ah.b(objectArray[n6].toString(), n2 + (n4 >> 1), n3 + 2 + n6 * (n5 + 28), 17, n6 == n7 ? 0 : 3, 1);
        }
    }

    public final void e(int n2, int n3, int n4, int n5) {
        ah.ah_b();
        ah.b(63, 40, 124, 200);
        ah.ah_b();
        ah.h(72, 71, 106, 180 - 3 * this.var_java_lang_String_arr_c.length - 5, 0);
        ah.ah_b().b(this.var_java_lang_String_arr_c.length, 71, 73, 108, 1, 27, -1, this.v, 4, 2);
        ah.ah_b();
        ah.b(this.var_java_lang_String_arr_c, 71, 73, 108, 26, this.v, 0, 3, 0);
        if (this.u == 1) {
            ah.ah_b();
            ah.b(136, 104, (int)ai.ai_b().var_byte_b, this.v == 1);
        }
        ah.ah_b();
        ah.h(125 + (this.u == 0 ? -40 : 0), 44, 40, 24, 4);
        ah.ah_b();
        ah.b("Menu", 106, 45, 17, this.u == 0 ? 0 : 1, 0);
        ah.ah_b();
        ah.b("H\u1ec7 th\u1ed1ng", 144, 45, 17, this.u == 0 ? 1 : 0, 0);
        ah.ah_b().b(125, 52, 57, true, true);
    }

    private static void b(ByteArrayOutputStream byteArrayOutputStream, al al2) {
        byteArrayOutputStream.write(al2.var_byte_arr_b);
        short s2 = 0;
        for (int i2 = 0; i2 < 5; ++i2) {
            s2 = al2.var_short_arr_b[i2];
            byteArrayOutputStream.write((byte)s2);
            byteArrayOutputStream.write((byte)(s2 >> 8));
        }
    }

    private void b(ByteArrayInputStream byteArrayInputStream, al al2, byte[][] byArray) {
        al2.var_byte_arr_b = new byte[18];
        al2.var_short_arr_b = new short[8];
        byteArrayInputStream.read(al2.var_byte_arr_b);
        this.var_byte_arr_g = new byte[10];
        byteArrayInputStream.read(this.var_byte_arr_g);
        for (int i2 = 0; i2 < 5; ++i2) {
            al2.var_short_arr_b[i2] = (short)((this.var_byte_arr_g[1 + (i2 << 1)] & 0xFF) << 8 | this.var_byte_arr_g[0 + (i2 << 1)] & 0xFF);
        }
        al2.b(byArray[al2.var_byte_arr_b[0]]);
        this.var_byte_arr_g = null;
    }

    public final void j(int n2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int n3;
            if (n2 == 0) {
                byteArrayOutputStream.write(this.z);
                for (n3 = 0; n3 < this.z; ++n3) {
                    as.b(byteArrayOutputStream, this.var_al_arr_c[n3]);
                }
                ad.ad_b();
                ad.byte_arr_b(8, byteArrayOutputStream.toByteArray(), 2);
            } else {
                byteArrayOutputStream.write(this.y);
                while (n3 < this.y) {
                    as.b(byteArrayOutputStream, this.var_al_arr_b[n3]);
                    ++n3;
                }
                ad.ad_b();
                ad.byte_arr_b(9, byteArrayOutputStream.toByteArray(), 2);
            }
            byteArrayOutputStream.close();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public final void b(int n2, byte[][] byArray) {
        ad.ad_b();
        this.var_byte_arr_h = ad.byte_arr_b(n2 + 8, null, 1);
        try {
            int n3;
            ByteArrayInputStream byteArrayInputStream;
            if (n2 == 0) {
                this.var_al_arr_c = new al[95];
                if (this.var_byte_arr_h[0] == -1) {
                    this.z = 0;
                    return;
                }
                byteArrayInputStream = new ByteArrayInputStream(this.var_byte_arr_h);
                this.z = (byte)byteArrayInputStream.read();
                for (n3 = 0; n3 < this.z; ++n3) {
                    this.var_al_arr_c[n3] = new al();
                    this.b(byteArrayInputStream, this.var_al_arr_c[n3], byArray);
                }
            } else {
                this.var_al_arr_b = new al[5];
                if (this.var_byte_arr_h[0] == -1) {
                    this.y = 0;
                    return;
                }
                byteArrayInputStream = new ByteArrayInputStream(this.var_byte_arr_h);
                this.y = (byte)byteArrayInputStream.read();
                while (n3 < this.y) {
                    this.var_al_arr_b[n3] = new al();
                    this.b(byteArrayInputStream, this.var_al_arr_b[n3], byArray);
                    ++n3;
                }
            }
            byteArrayInputStream.close();
            this.var_byte_arr_h = null;
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public final void p() {
        ad.ad_b();
        ad.byte_arr_b(6, this.k, 2);
    }

    public final void o() {
        ad.ad_b();
        this.var_byte_arr_h = ad.byte_arr_b(6, null, 1);
        if (this.var_byte_arr_h[0] == -1) {
            this.k = new byte[105];
            for (int i2 = 0; i2 < this.k.length; ++i2) {
                this.k[i2] = 0;
            }
        } else {
            this.k = this.var_byte_arr_h;
        }
        this.var_byte_arr_h = null;
    }

    public final void q() {
        ad.ad_b();
        this.var_byte_arr_h = ad.byte_arr_b(10, null, 1);
        if (this.var_byte_arr_h[0] == -1) {
            this.a(true);
            this.t();
        } else {
            this.l = this.var_byte_arr_h;
            this.a(false);
        }
        this.var_byte_arr_h = null;
    }

    public final void a(boolean bl) {
        if (bl) {
            this.w = (byte)3;
            this.x = (byte)10;
            return;
        }
        if (this.l[3] == 2) {
            this.w = (byte)4;
            this.x = (byte)20;
            return;
        }
        if (this.l[3] == 3) {
            this.w = (byte)5;
            this.x = (byte)40;
            return;
        }
        if (this.l[3] == 4) {
            this.w = (byte)5;
            this.x = (byte)80;
            return;
        }
        if (this.l[3] == 5) {
            this.w = (byte)5;
            this.x = (byte)95;
        }
    }

    public final byte byte_b(boolean bl) {
        switch (this.l[3]) {
            case 1: {
                if (bl && this.k[103] > 4) {
                    this.l[3] = 2;
                    break;
                }
                return 5;
            }
            case 2: {
                if (bl && this.k[103] > 9) {
                    this.l[3] = 3;
                    break;
                }
                return 10;
            }
            case 3: {
                if (bl && this.k[103] > 14) {
                    this.l[3] = 4;
                    break;
                }
                return 15;
            }
            case 4: {
                if (bl && this.k[103] > 29) {
                    this.l[3] = 5;
                    break;
                }
                return 30;
            }
        }
        return -1;
    }

    public final void s() {
        int n2;
        int n3 = 0;
        for (n2 = 0; n2 < 4; ++n2) {
            n3 += this.j[n2];
        }
        this.var_byte_arr_h = new byte[this.var_byte_arr_arr_arr_b.length + (n3 << 1)];
        n3 = 0;
        for (n2 = 0; n2 < 4; ++n2) {
            this.var_byte_arr_h[n2] = this.j[n2];
        }
        for (n2 = 0; n2 < this.var_byte_arr_arr_arr_b.length; ++n2) {
            int n4 = 0;
            while (n4 < this.j[n2]) {
                this.var_byte_arr_h[(n3 << 1) + 4] = this.var_byte_arr_arr_arr_b[n2][n4][0];
                this.var_byte_arr_h[(n3 << 1) + 4 + 1] = this.var_byte_arr_arr_arr_b[n2][n4][1];
                ++n4;
                ++n3;
            }
        }
        ad.ad_b();
        ad.byte_arr_b(4, this.var_byte_arr_h, 2);
        this.var_byte_arr_h = null;
    }

    public final void r() {
        ad.ad_b();
        this.var_byte_arr_h = ad.byte_arr_b(4, null, 1);
        this.var_byte_arr_g = new byte[]{16, 19, 23, 12};
        this.j = new byte[4];
        int n2 = 0;
        int n3 = 0;
        if (this.var_byte_arr_h[0] != -1) {
            for (n2 = 0; n2 < 4; ++n2) {
                this.j[n2] = this.var_byte_arr_h[n2];
            }
        }
        this.var_byte_arr_arr_arr_b = new byte[this.j.length][][];
        int n4 = 0;
        for (n2 = 0; n2 < this.var_byte_arr_arr_arr_b.length; ++n2) {
            this.var_byte_arr_arr_arr_b[n2] = new byte[this.var_byte_arr_g[n2]][2];
            n3 = 0;
            while (n3 < this.j[n2]) {
                this.var_byte_arr_arr_arr_b[n2][n3][0] = this.var_byte_arr_h[(n4 << 1) + 4];
                this.var_byte_arr_arr_arr_b[n2][n3][1] = this.var_byte_arr_h[(n4 << 1) + 4 + 1];
                ++n3;
                ++n4;
            }
        }
        this.var_byte_arr_h = null;
        this.var_byte_arr_g = null;
    }

    public final void t() {
        this.l = null;
        this.l = new byte[]{-1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public final void u() {
        ad.ad_b();
        this.m = ad.byte_arr_b(5, null, 1);
        if (this.m[0] == -1) {
            this.m = null;
            this.m = new byte[]{-3, 0, 0, 0, 0, 0, 0};
        }
        if (this.m[0] == 10) {
            this.l[2] = (byte)(this.l[2] | 8);
        }
    }

    public final void v() {
        ad.ad_b();
        this.n = ad.byte_arr_b(3, null, 1);
        if (this.n[0] == -1) {
            this.n = null;
            this.n = new byte[]{-2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10};
        }
    }

    public final byte byte_c(int n2) {
        return this.n[n2 * 5];
    }

    public final byte byte_a(int n2) {
        return this.var_byte_arr_arr_g[0][this.byte_c(n2)];
    }

    public final byte byte_e(int n2) {
        return this.var_byte_arr_arr_g[1][this.byte_c(n2)];
    }

    public final short short_b(int n2, int n3) {
        ad.ad_b();
        return ad.short_b(this.n, n2 * 5 + n3);
    }

    public final boolean boolean_c(int n2) {
        for (int n3 = 0; n3 < this.n.length; n3 = (int)((byte)(n3 + 5))) {
            if (this.n[n3] != -2) continue;
            this.n[n3] = (byte)n2;
            ad.ad_b();
            ad.c(0, this.n, n3 + 1);
            ad.ad_b();
            ad.c(200, this.n, n3 + 3);
            return true;
        }
        return false;
    }

    public final void k(int n2) {
        this.n[n2 * 5] = -2;
    }

    public final void l(int n2) {
        n2 = n2 / 10 <= 0 ? 1 : n2 / 10;
        for (int n3 = 0; n3 < 5; n3 = (int)((byte)(n3 + 1))) {
            if (this.byte_c(n3) == -2) continue;
            ad.ad_b();
            ad.c(this.short_b(n3, 1) + n2, this.n, n3 * 5 + 1);
            if (this.short_b(n3, 1) <= this.short_b(n3, 3)) continue;
            ad.ad_b();
            ad.c((int)this.short_b(n3, 3), this.n, n3 * 5 + 1);
        }
    }
}

