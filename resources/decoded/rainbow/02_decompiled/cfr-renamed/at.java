/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class at {
    private static Graphics var_javax_microedition_lcdui_Graphics_b;
    private int var_int_c;
    private int var_int_a;
    private short var_short_b;
    private short var_short_c;
    private short var_short_a;
    private short var_short_e;
    private short var_short_d;
    private short var_short_h;
    private short var_short_g;
    private short var_short_f;
    public aj[][] var_aj_arr_arr_b = new aj[3][];
    private static aj var_aj_c;
    private byte var_byte_i;
    private byte var_byte_j = (byte)-1;
    private byte var_byte_k;
    private byte var_byte_l;
    private byte var_byte_m;
    private byte var_byte_n = 0;
    private short var_short_i;
    private short var_short_j = (short)4;
    private byte[] var_byte_arr_b;
    private byte[][] var_byte_arr_arr_c;
    private byte[][] var_byte_arr_arr_a;
    private byte var_byte_p = 0;
    private byte var_byte_o;
    private byte q;
    private byte[][] var_byte_arr_arr_e = new byte[70][];
    private byte[][] var_byte_arr_arr_d;
    private int var_int_e;
    public byte var_byte_b = (byte)-1;
    public byte var_byte_c = (byte)-1;
    public byte var_byte_a = 0;
    private byte s = 0;
    public byte var_byte_e = 0;
    public byte var_byte_d = (byte)-1;
    private short[] var_short_arr_b;
    private short[][] var_short_arr_arr_b;
    private short[] var_short_arr_c;
    private StringBuffer[] var_java_lang_StringBuffer_arr_b;
    private ak var_ak_b;
    private String[] var_java_lang_String_arr_b;
    private String[] var_java_lang_String_arr_c;
    private byte r = (byte)-1;
    private byte[] var_byte_arr_c;
    private byte t = (byte)-2;
    private boolean var_boolean_c = false;
    private byte u = 0;
    public byte var_byte_h = (byte)-1;
    private byte v;
    private byte w;
    public byte var_byte_g;
    private String var_java_lang_String_b;
    public boolean var_boolean_b = false;
    private byte x = 0;
    private byte y;
    private byte z;
    private byte[][] var_byte_arr_arr_h = new byte[][]{{0, 0}, {0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private byte B = 0;
    private byte A = (byte)-1;
    private boolean var_boolean_a = false;
    private byte C;
    private byte D = (byte)-1;
    private byte F = 0;
    private boolean var_boolean_e = false;
    private byte[][] var_byte_arr_arr_g;
    private byte[][] var_byte_arr_arr_f;
    private byte G = (byte)-1;
    private byte H;
    private byte I;
    private short var_short_k;
    private short var_short_l;
    private short var_short_m = (short)300;
    private boolean var_boolean_d = false;
    private StringBuffer[][] var_java_lang_StringBuffer_arr_arr_b;
    private byte[] var_byte_arr_a;
    private byte[] var_byte_arr_e;
    private short[][] var_short_arr_arr_c = null;
    public Image[] var_javax_microedition_lcdui_Image_arr_b = null;
    private int var_int_d = 0;
    private short[] var_short_arr_a = null;
    private short[] var_short_arr_e = null;
    private short[][] var_short_arr_arr_a = null;
    public byte var_byte_f = 0;
    private int var_int_h = 0;
    private int var_int_g = 0;
    private Image var_javax_microedition_lcdui_Image_b = null;
    private boolean var_boolean_h = false;
    private byte E = (byte)-1;
    private short var_short_n = 0;
    private am var_am_b;
    private byte J;
    private byte K;
    private Image var_javax_microedition_lcdui_Image_c;
    public static am[][] var_am_arr_arr_b;
    private byte[] var_byte_arr_d;
    private short var_short_p;
    private short var_short_o = 0;
    private boolean var_boolean_g = false;
    private byte L = 0;
    public aj var_aj_b;
    private Image var_javax_microedition_lcdui_Image_a;
    private short[][] var_short_arr_arr_e;
    private byte M = (byte)-1;
    public byte[][] var_byte_arr_arr_b;
    public static int var_int_b;

    public final void void_b(int n2, int n3) {
        if (n2 == 0) {
            this.var_byte_e = 0;
            ad.ad_b();
            this.var_short_j = (short)(ad.c(30) + 1);
            this.var_short_i = (short)((this.var_short_j - 15) * (this.var_short_j - 15));
            ad.ad_b();
            if (this.var_short_i > ad.c(50)) {
                ad.ad_b();
                int n4 = 17 + ad.c(9);
                ad.ad_b();
                this.var_short_j = (byte)(n4 - ad.c(7));
            }
            this.var_short_j = (short)(this.var_short_j << 2);
            this.var_short_i = 0;
            this.r = (byte)-1;
            return;
        }
        if (n2 == 1) {
            this.var_byte_e = 1;
            this.var_short_j = (short)(200 * (n3 - 14 + 1));
            this.var_short_j = (short)(this.var_short_j << 2);
            this.var_short_i = 0;
            this.r = (byte)100;
        }
    }

    public at(ak object) {
        this.var_ak_b = object;
        System.gc();
        object = this;
        at at2 = object;
        if (at2.var_am_b == null) {
            at2.var_am_b = ad.ad_b().b("data/face/brow", true);
        }
        at.var_am_arr_arr_b[0] = new am[100];
        at.var_am_arr_arr_b[1] = new am[5];
        at.var_am_arr_arr_b[2] = new am[60];
        if (null == var_am_arr_arr_b[1][0]) {
            at.var_am_arr_arr_b[1][0] = new am();
            ((at)object).var_aj_b = new aj(8);
            ((at)object).var_aj_b.var_byte_arr_b[4] = 1;
            ((at)object).g();
        }
        if (((at)object).var_javax_microedition_lcdui_Image_c == null) {
            ad.ad_b();
            ((at)object).var_javax_microedition_lcdui_Image_c = ad.javax_microedition_lcdui_Image_b("data/shadow");
        }
    }

    private void j() {
        ad.ad_b();
        this.var_java_lang_String_arr_c = ad.java_lang_String_arr_b(at.b(ak.byte_arr_b(1), (int)this.var_byte_a));
        ad.ad_b();
        this.var_java_lang_String_arr_b = ad.java_lang_String_arr_b(at.b(ak.byte_arr_b(2), (int)this.var_byte_a));
    }

    public final void void_b() {
        ad.ad_b();
        byte[] byArray = ad.byte_arr_b(2, null, 1);
        if (byArray[0] == -1) {
            byte[] byArray2 = new byte[]{58, 9, 16, 2, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, -1};
            byArray = byArray2;
            ad.ad_b();
            ad.byte_arr_b(2, byArray2, 2);
            this.var_short_arr_arr_b = new short[70][];
            ad.ad_b();
            ad.ad_b();
            ad.byte_arr_b(11, ad.b(this.var_short_arr_arr_b), 2);
        } else {
            this.var_short_arr_arr_b = ad.ad_b().short_arr_arr_b();
        }
        this.var_byte_a = byArray[0];
        this.var_byte_l = byArray[5];
        this.var_byte_m = byArray[6];
        this.var_aj_b.b(byArray[1], byArray[2], 0, 0);
        this.var_aj_b.n = byArray[3];
        this.var_aj_b.b(false);
        ad.ad_b();
        this.var_ak_b.var_int_b = ad.int_b(byArray, 7);
        ad.ad_b();
        this.var_ak_b.var_int_c = ad.int_b(byArray, 11);
        this.var_byte_c = byArray[15];
    }

    private void k() {
        byte[] byArray = new byte[16];
        byte[] byArray2 = byArray;
        byArray[0] = this.var_byte_a;
        byArray2[5] = this.var_byte_l;
        byArray2[6] = this.var_byte_m;
        byArray2[1] = (byte)(this.var_aj_b.var_short_b / 20);
        byArray2[2] = (byte)(this.var_aj_b.var_short_c / 20);
        byArray2[3] = this.var_aj_b.n;
        ad.ad_b();
        ad.void_b(this.var_ak_b.var_int_b, byArray2, 7);
        ad.ad_b();
        ad.void_b(this.var_ak_b.var_int_c, byArray2, 11);
        byArray2[15] = this.var_byte_c;
        ad.ad_b();
        ad.byte_arr_b(2, byArray2, 2);
    }

    public final void void_c() {
        at at2 = this;
        byte[] byArray = new byte[16];
        byte[] byArray2 = byArray;
        byArray[0] = at2.var_byte_a;
        byArray2[5] = at2.var_byte_l;
        byArray2[6] = at2.var_byte_m;
        byArray2[1] = (byte)(at2.var_aj_b.var_short_b / 20);
        byArray2[2] = (byte)(at2.var_aj_b.var_short_c / 20);
        byArray2[3] = at2.var_aj_b.n;
        ad.ad_b();
        ad.void_b(at2.var_ak_b.var_int_b, byArray2, 7);
        ad.ad_b();
        ad.void_b(at2.var_ak_b.var_int_c, byArray2, 11);
        byArray2[15] = at2.var_byte_c;
        ad.ad_b();
        ad.byte_arr_b(2, byArray2, 2);
        this.o();
        for (int i2 = 0; i2 < this.var_short_arr_b.length / 2; ++i2) {
            if (this.var_byte_arr_b[i2] != 1) continue;
            this.var_byte_arr_b[i2] = 0;
            ad.ad_b();
            ad.byte_arr_b(i2 + 13, this.var_byte_arr_arr_e[i2], 2);
        }
        ad.ad_b();
        ad.ad_b();
        ad.byte_arr_b(12, ad.b(this.var_short_arr_b), 2);
        ad.ad_b();
        ad.ad_b();
        ad.byte_arr_b(11, ad.b(this.var_short_arr_arr_b), 2);
        ad.ad_b();
        ad.byte_arr_b(1, this.var_byte_arr_b, 2);
        ad.ad_b();
        ad.byte_arr_b(7, this.var_byte_arr_a, 2);
        ad.ad_b();
        ad.byte_arr_b(5, (byte[])this.var_ak_b.var_byte_arr_arr_m, 2);
        ad.ad_b();
        ad.byte_arr_b(1, null, 4);
    }

    private static byte[] b(byte[] byArray, int n2) {
        int n3 = 1;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = (byArray[n3++] & 0xFF) << 8 | byArray[n3++] & 0xFF;
            n3 += n4;
        }
        byte[] byArray2 = new byte[(byArray[n3++] & 0xFF) << 8 | byArray[n3++] & 0xFF];
        System.arraycopy(byArray, n3, byArray2, 0, byArray2.length);
        return byArray2;
    }

    private void l() {
        int n2;
        byte[] byArray = ad.ad_b().byte_arr_b("event", (int)this.var_byte_a);
        int n3 = 0;
        if (byArray.length == 1) {
            this.var_int_e = 0;
            return;
        }
        ++n3;
        this.var_int_e = byArray[0];
        if (this.var_short_arr_b[this.var_byte_a << 1] <= 0) {
            this.var_short_arr_arr_b[this.var_byte_a] = null;
            this.var_short_arr_arr_b[this.var_byte_a] = new short[this.var_int_e];
        } else {
            for (n2 = 0; n2 < this.var_int_e; n2 = (int)((byte)(n2 + 1))) {
                if (!this.boolean_b((int)this.var_byte_a, n2)) continue;
                this.var_short_arr_arr_b[this.var_byte_a][n2] = 24224;
            }
        }
        this.var_short_arr_c = this.var_short_arr_arr_b[this.var_byte_a];
        this.var_byte_arr_arr_d = new byte[this.var_int_e][];
        short s2 = 0;
        for (n2 = 0; n2 < this.var_int_e; n2 = (int)((byte)(n2 + 1))) {
            s2 = (short)(byArray[n3++] << 8 | byArray[n3++] & 0xFF);
            this.var_byte_arr_arr_d[n2] = new byte[s2];
            System.arraycopy(byArray, n3, this.var_byte_arr_arr_d[n2], 0, this.var_byte_arr_arr_d[n2].length);
            n3 += s2;
        }
    }

    private void m() {
        at at2 = this;
        if (at2.var_am_b == null) {
            at2.var_am_b = ad.ad_b().b("data/face/brow", true);
        }
        at.var_am_arr_arr_b[0] = new am[100];
        at.var_am_arr_arr_b[1] = new am[5];
        at.var_am_arr_arr_b[2] = new am[60];
        if (null == var_am_arr_arr_b[1][0]) {
            at.var_am_arr_arr_b[1][0] = new am();
            this.var_aj_b = new aj(8);
            this.var_aj_b.var_byte_arr_b[4] = 1;
            this.g();
        }
        if (this.var_javax_microedition_lcdui_Image_c == null) {
            ad.ad_b();
            this.var_javax_microedition_lcdui_Image_c = ad.javax_microedition_lcdui_Image_b("data/shadow");
        }
    }

    private static void n() {
        at.var_am_arr_arr_b[0] = new am[100];
        at.var_am_arr_arr_b[1] = new am[5];
        at.var_am_arr_arr_b[2] = new am[60];
    }

    public final void a() {
        this.var_aj_b.n = (byte)4;
        this.var_byte_j = (byte)-1;
        ak ak2 = this.var_ak_b;
        ad.ad_b();
        ((as)this.var_ak_b).m = ad.byte_arr_b(5, null, 1);
        if (((as)ak2).m[0] == -1) {
            ((as)ak2).m = null;
            ((as)ak2).m = new byte[]{-3, 0, 0, 0, 0, 0, 0};
        }
        if (((as)ak2).m[0] == 10) {
            ((as)ak2).l[2] = (byte)(((as)ak2).l[2] | 8);
        }
        ak2 = this.var_ak_b;
        ad.ad_b();
        ((as)this.var_ak_b).n = ad.byte_arr_b(3, null, 1);
        if (((as)ak2).n[0] == -1) {
            ((as)ak2).n = null;
            ((as)ak2).n = new byte[]{-2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10};
        }
        this.void_b(0, 0);
        ad.ad_b();
        ad.ad_b();
        this.var_short_arr_b = ad.short_arr_b(ad.byte_arr_b(12, null, 1));
        ad.ad_b();
        this.var_byte_arr_b = ad.byte_arr_b(1, null, 1);
        for (int n2 = 0; n2 < this.var_byte_arr_b.length; n2 = (int)((short)(n2 + 1))) {
            if (this.var_byte_arr_b[n2] != 1) continue;
            ad.ad_b();
            this.var_byte_arr_arr_e[n2] = ad.byte_arr_b(n2 + 13, null, 1);
        }
        System.gc();
        this.var_ak_b.var_byte_a = (byte)33;
        this.p();
        this.var_ak_b.var_byte_a = (byte)35;
        this.s();
        this.var_ak_b.var_byte_a = (byte)37;
        this.l();
        this.var_ak_b.var_byte_a = (byte)39;
        this.j();
        this.var_ak_b.var_byte_a = (byte)40;
        ad.ad_b();
        ad.byte_arr_b(1, null, 4);
        this.var_ak_b.c((int)this.var_byte_a, true);
        at at2 = this;
        ad.ad_b();
        byte[] byArray = ad.byte_arr_b(7, null, 1);
        at2.var_byte_arr_a = (byte[])(byArray[0] == -1 ? null : byArray);
        if (at2.var_byte_arr_a == null) {
            at2.var_byte_arr_a = new byte[20];
        }
        this.V();
    }

    private void p() {
        byte by;
        int n2;
        ad.ad_b();
        ad.var_int_c = 0;
        ad.ad_b();
        ad.a = 0;
        byte[] byArray = at.b(ak.byte_arr_b(0), (int)this.var_byte_a);
        Object object = byArray;
        ad.ad_b();
        byte[] byArray2 = new byte[byArray[ad.var_int_c++]];
        for (n2 = 0; n2 < byArray2.length; ++n2) {
            ad.ad_b();
            byArray2[n2] = object[ad.var_int_c++];
        }
        this.var_byte_arr_c = byArray2;
        if (this.var_short_arr_b[this.var_byte_a << 1] > 0 && this.var_byte_arr_arr_e[this.var_byte_a] == null) {
            ad.ad_b();
            this.var_byte_arr_arr_e[this.var_byte_a] = ad.byte_arr_b(13 + this.var_byte_a, null, 1);
        }
        this.var_aj_arr_arr_b[0] = this.aj_arr_b(byArray);
        this.var_aj_arr_arr_b[1] = this.aj_arr_b(byArray);
        this.var_aj_arr_arr_b[2] = this.aj_arr_b(byArray);
        this.var_byte_arr_arr_a = this.byte_arr_arr_b(byArray);
        this.var_byte_arr_arr_c = this.byte_arr_arr_b(byArray);
        this.var_byte_arr_d = null;
        this.var_byte_arr_d = new byte[this.var_aj_arr_arr_b[0].length + 1 + this.var_byte_arr_arr_a.length];
        object = this;
        int n3 = 0;
        byte[][] byArrayArray = new byte[3][];
        byte[][] byArrayArray2 = byArrayArray;
        byArrayArray[0] = new byte[100];
        byArrayArray2[1] = new byte[5];
        byArrayArray2[2] = new byte[60];
        ((at)object).var_ak_b.void_e(0);
        for (by = (byte)(((at)object).var_aj_arr_arr_b.length - 1); by >= 0; by = (byte)(by - 1)) {
            for (n2 = (int)((byte)(((at)object).var_aj_arr_arr_b[by].length - 1)); n2 >= 0; n2 = (int)((byte)(n2 - 1))) {
                byArrayArray2[((at)object).var_aj_arr_arr_b[by][n2].var_byte_arr_b[3] - 1][((at)object).var_aj_arr_arr_b[by][n2].var_byte_arr_b[2]] = 1;
                if (by != 0) continue;
                ((at)object).var_byte_arr_d[n2 + 1] = n2;
                if (((at)object).var_aj_arr_arr_b[by][n2].var_byte_arr_b[8] != 1) continue;
                int n4 = n3;
                n3 = (byte)(n3 + 1);
                ((at)object).var_ak_b.var_byte_p[n4] = n2;
            }
        }
        ((at)object).var_ak_b.void_e(1);
        ((at)object).var_byte_arr_d[0] = -1;
        for (by = (byte)(((at)object).var_byte_arr_arr_a.length + ((at)object).var_aj_arr_arr_b[0].length); by > ((at)object).var_aj_arr_arr_b[0].length; by = (byte)(by - 1)) {
            ((at)object).var_byte_arr_d[by] = (byte)(-2 - by + ((at)object).var_aj_arr_arr_b[0].length + 1);
        }
        super.b(100, 0, byArrayArray2[0]);
        super.b(5, 1, byArrayArray2[1]);
        super.b(60, 2, byArrayArray2[2]);
        for (n2 = (int)((byte)(((at)object).var_aj_arr_arr_b[0].length - 1)); n2 >= 0; n2 = (int)((byte)(n2 - 1))) {
            ((at)object).var_aj_arr_arr_b[0][n2].b(var_am_arr_arr_b[((at)object).var_aj_arr_arr_b[0][n2].var_byte_arr_b[3] - 1][((at)object).var_aj_arr_arr_b[0][n2].var_byte_arr_b[2]].int_b());
        }
    }

    private aj[] aj_arr_b(byte[] byArray) {
        int n2;
        int n3;
        ad.ad_b();
        aj[] ajArray = new aj[byArray[ad.var_int_c++]];
        for (n3 = 0; n3 < ajArray.length; ++n3) {
            ad.ad_b();
            ajArray[n3] = new aj(byArray[ad.var_int_c++]);
            for (n2 = 0; n2 < ajArray[n3].var_byte_arr_b.length; ++n2) {
                byte[] byArray2 = ajArray[n3].var_byte_arr_b;
                ad.ad_b();
                byArray2[n2] = byArray[ad.var_int_c++];
            }
            ajArray[n3].void_b();
        }
        if (this.var_short_arr_b[this.var_byte_a << 1] > 0) {
            for (n3 = 0; n3 < ajArray.length; ++n3) {
                if (ajArray[n3].var_byte_arr_b[9] != 1) continue;
                for (n2 = 0; n2 < ajArray[n3].var_byte_arr_b.length; ++n2) {
                    byte[] byArray3 = ajArray[n3].var_byte_arr_b;
                    byte[] byArray4 = this.var_byte_arr_arr_e[this.var_byte_a];
                    ad.ad_b();
                    byArray3[n2] = byArray4[ad.a++];
                }
                ajArray[n3].void_b();
            }
        }
        return ajArray;
    }

    private byte[][] byte_arr_arr_b(byte[] byArray) {
        byte[][] byArrayArray;
        if (this.var_short_arr_b[this.var_byte_a << 1] > 0) {
            byArray = this.var_byte_arr_arr_e[this.var_byte_a];
            ad.ad_b();
            byArrayArray = new byte[byArray[ad.a++]][];
            for (int i2 = 0; i2 < byArrayArray.length; ++i2) {
                ad.ad_b();
                byArrayArray[i2] = new byte[byArray[ad.a++]];
                for (int i3 = 0; i3 < byArrayArray[i2].length; ++i3) {
                    byte[] byArray2 = byArrayArray[i2];
                    ad.ad_b();
                    byArray2[i3] = byArray[ad.a++];
                }
            }
        } else {
            ad.ad_b();
            byArrayArray = new byte[byArray[ad.var_int_c++]][];
            for (int i4 = 0; i4 < byArrayArray.length; ++i4) {
                ad.ad_b();
                byArrayArray[i4] = new byte[byArray[ad.var_int_c++]];
                for (int i5 = 0; i5 < byArrayArray[i4].length; ++i5) {
                    byte[] byArray3 = byArrayArray[i4];
                    ad.ad_b();
                    byArray3[i5] = byArray[ad.var_int_c++];
                }
            }
        }
        return byArrayArray;
    }

    private byte byte_b(int n2) {
        return (byte)((this.var_byte_arr_c[n2] & 0xFF) >> 6);
    }

    private byte byte_c(int n2) {
        return (byte)(this.var_byte_arr_c[n2] & 0x3F);
    }

    private static byte[] byte_arr_b(byte[] byArray) {
        ad.ad_b();
        byte[] byArray2 = new byte[byArray[ad.var_int_c++]];
        for (int i2 = 0; i2 < byArray2.length; ++i2) {
            ad.ad_b();
            byArray2[i2] = byArray[ad.var_int_c++];
        }
        return byArray2;
    }

    private void o() {
        this.var_byte_arr_arr_e[this.var_byte_a] = null;
        at at2 = this;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        at.b(byteArrayOutputStream, at2.var_aj_arr_arr_b[0]);
        at.b(byteArrayOutputStream, at2.var_aj_arr_arr_b[1]);
        at.b(byteArrayOutputStream, at2.var_aj_arr_arr_b[2]);
        at.b(byteArrayOutputStream, at2.var_byte_arr_arr_a);
        at.b(byteArrayOutputStream, at2.var_byte_arr_arr_c);
        this.var_byte_arr_arr_e[this.var_byte_a] = byteArrayOutputStream.toByteArray();
        this.var_short_arr_b[this.var_byte_a << 1] = 1;
        this.var_byte_arr_b[this.var_byte_a] = 1;
    }

    private void q() {
        this.var_int_c = at.b(this.var_aj_b.byte_b(), this.var_short_b, 12, 6, 240, 20);
        this.var_int_a = at.b(this.var_aj_b.byte_c(), this.var_short_c, 16, 8, 320, 20);
        this.var_short_d = (short)110;
        this.var_short_h = (short)(this.var_short_b * 20 - 120 - 10);
        this.var_short_g = (short)150;
        this.var_short_f = (short)(this.var_short_c * 20 - 160 - 10);
    }

    private void s() {
        at at2;
        at at3 = at2 = this;
        ad.ad_b();
        ad.var_int_c = 0;
        byte[] byArray = ad.ad_b().byte_arr_b("data/map/area.dat", -1);
        ad.ad_b();
        byte[] byArray2 = ad.byte_arr_b(byArray);
        byte[][] byArray3 = ad.ad_b().byte_arr_arr_b(byArray);
        if (at3.var_javax_microedition_lcdui_Image_arr_b == null || byArray2[at3.var_byte_l] != byArray2[at3.var_byte_a]) {
            ad.ad_b();
            ad.var_int_c = 0;
            at3.var_short_arr_arr_c = ad.ad_b().short_arr_arr_b(ad.ad_b().byte_arr_b("data/map/" + byArray2[at3.var_byte_a] + ".data", -1), 1);
            at3.var_javax_microedition_lcdui_Image_arr_b = null;
            at3.var_javax_microedition_lcdui_Image_arr_b = new Image[byArray3[byArray2[at3.var_byte_a]].length];
            for (int n2 = 0; n2 < byArray3[byArray2[at3.var_byte_a]].length; n2 = (int)((byte)(n2 + 1))) {
                Image[] imageArray = at3.var_javax_microedition_lcdui_Image_arr_b;
                ad.ad_b();
                imageArray[n2] = ad.javax_microedition_lcdui_Image_b("data/map/" + byArray3[byArray2[at3.var_byte_a]][n2]);
            }
        }
        at2.l(at2.var_byte_a);
        at2 = this;
        this.var_int_c = at.b(at2.var_aj_b.byte_b(), at2.var_short_b, 12, 6, 240, 20);
        at2.var_int_a = at.b(at2.var_aj_b.byte_c(), at2.var_short_c, 16, 8, 320, 20);
        at2.var_short_d = (short)110;
        at2.var_short_h = (short)(at2.var_short_b * 20 - 120 - 10);
        at2.var_short_g = (short)150;
        at2.var_short_f = (short)(at2.var_short_c * 20 - 160 - 10);
    }

    private byte b(byte[][] byArray) {
        byte by;
        if (byArray[this.var_byte_k][3] == -1) {
            by = this.var_byte_a;
            this.var_byte_a = this.var_byte_l;
            this.var_byte_l = by;
            this.var_byte_m = this.var_byte_k;
            by = -1;
        } else {
            by = this.var_byte_a;
            this.var_byte_a = byArray[this.var_byte_k][4];
            this.var_byte_l = by;
            this.var_byte_m = this.var_byte_k;
            by = byArray[this.var_byte_k][3];
        }
        return by;
    }

    private void r() {
        this.o();
        this.var_byte_arr_b[this.var_byte_a] = 1;
        ad.ad_b();
        ad.byte_arr_b(1, this.var_byte_arr_b, 2);
    }

    private void t() {
        this.var_byte_f = 0;
        this.var_ak_b.void_b(2);
        at at2 = this;
        at2.o();
        at2.var_byte_arr_b[at2.var_byte_a] = 1;
        ad.ad_b();
        ad.byte_arr_b(1, at2.var_byte_arr_b, 2);
        byte by = this.var_byte_m;
        if (this.t != -2) {
            this.var_byte_l = this.var_byte_a;
            this.var_byte_a = this.u;
            this.u = 0;
            this.var_byte_m = this.t;
        }
        this.var_ak_b.void_b(5);
        if (this.t == -2) {
            int n2;
            byte[][] byArray = this.var_byte_arr_arr_c;
            at2 = this;
            if (byArray[at2.var_byte_k][3] == -1) {
                n2 = at2.var_byte_a;
                at2.var_byte_a = at2.var_byte_l;
                at2.var_byte_l = n2;
                at2.var_byte_m = at2.var_byte_k;
                n2 = -1;
            } else {
                n2 = at2.var_byte_a;
                at2.var_byte_a = byArray[at2.var_byte_k][4];
                at2.var_byte_l = n2;
                at2.var_byte_m = at2.var_byte_k;
                n2 = byArray[at2.var_byte_k][3];
            }
            this.t = (byte)n2;
        }
        this.var_ak_b.void_b(false);
        this.var_ak_b.void_b(8);
        this.p();
        this.var_ak_b.void_b(10);
        if (this.t == -1) {
            this.t = by;
        }
        if (!this.var_boolean_c) {
            byte[][] byArray = this.var_byte_arr_arr_c;
            byte by2 = this.t;
            at2 = this;
            this.var_aj_b.n = (byte)(((byArray[by2][2] - 1) / 2 << 1) + 1 + byArray[by2][2] % 2);
            at2.var_aj_b.b(byArray[by2][0], byArray[by2][1], 0, 0);
        }
        this.l();
        this.var_ak_b.void_b(15);
        this.j();
        this.s();
        this.var_ak_b.void_b(20);
        if (!(this.var_boolean_c || this.var_byte_arr_arr_c[this.t][5] != 1 && this.var_byte_arr_arr_c[this.t][5] != 2)) {
            this.var_aj_b.var_byte_b = (byte)(20 / this.var_aj_b.g);
            this.var_aj_b.e = (byte)(this.var_byte_arr_arr_h[this.var_aj_b.n][0] * this.var_aj_b.g);
            this.var_aj_b.d = (byte)(this.var_byte_arr_arr_h[this.var_aj_b.n][1] * this.var_aj_b.g);
            this.var_aj_b.b(true);
        } else {
            this.var_aj_b.b(false);
        }
        this.var_ak_b.var_byte_g = 0;
        boolean bl = false;
        at2 = this;
        ai.ai_b().b(at2.var_ak_b.var_byte_arr_e[at2.var_byte_a]);
        ai.ai_b().b(false);
        this.t = (byte)-2;
        this.var_ak_b.c((int)this.var_byte_a, true);
        this.var_ak_b.var_byte_l = (byte)25;
        this.var_byte_j = (byte)-1;
        ad.ad_b();
        ad.byte_arr_b(1, null, 4);
        this.V();
        this.var_boolean_c = false;
        this.var_aj_b.var_byte_a = (byte)9;
        if (this.M == -1) {
            this.var_aj_b.var_byte_a = 0;
            this.var_aj_b.c(-1, -1);
            this.var_aj_b.g = this.byte_b();
        }
        this.D = (byte)-1;
    }

    private void void_b(int n2, int n3, int n4, int n5) {
        int n6 = n2;
        n2 = 0;
        int n7 = n6;
        at at2 = this;
        this.var_aj_b.var_byte_a = (byte)5;
        at2.u = (byte)n7;
        at2.t = 0;
        at2.C();
        this.var_boolean_c = true;
        this.var_aj_b.b(n3, n4, 0, 0);
        this.var_aj_b.n = (byte)n5;
    }

    private void void_c(int n2, int n3) {
        this.var_aj_b.var_byte_a = (byte)5;
        this.u = (byte)n2;
        this.t = 0;
        this.C();
    }

    private void b(byte by, byte[][] byArray) {
        this.var_aj_b.n = (byte)(((byArray[by][2] - 1) / 2 << 1) + 1 + byArray[by][2] % 2);
        this.var_aj_b.b(byArray[by][0], byArray[by][1], 0, 0);
    }

    private static int b(int n2, int n3, int n4, int n5, int n6, int n7) {
        n2 = n3 <= n4 ? n6 - n3 * 20 >> 1 : (n2 + 1 <= n5 ? 0 : (n2 >= n3 - n5 ? n6 - n3 * 20 : n6 / 2 - n2 * 20 - 10));
        return n2;
    }

    private boolean b(int n2, boolean bl, boolean bl2) {
        if (n2 == 2) {
            this.var_byte_h = (byte)(!bl ? 1 : 0);
            return true;
        }
        if (bl2 && bl) {
            return true;
        }
        return !bl2 && n2 == 1;
    }

    private void void_b(int n2, int n3, int n4, int n5, boolean bl) {
        if (this.b(n5, bl, true)) {
            int n6 = n2;
            this.var_short_arr_c[n6] = (short)(this.var_short_arr_c[n6] + n3);
            this.void_c(n4);
            return;
        }
        if (this.b(n5, bl, false)) {
            this.c(n2, false);
        }
    }

    private boolean boolean_b(int n2, int n3) {
        return (this.var_short_arr_b[(n2 << 1) + 1] & 1 << n3) != 0;
    }

    private void void_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            int n4 = (n2 << 1) + 1;
            this.var_short_arr_b[n4] = (short)(this.var_short_arr_b[n4] ^ 1 << n3);
        }
        if (n2 == this.var_byte_a) {
            this.var_short_arr_c[n3] = 0;
            return;
        }
        if (null != this.var_short_arr_arr_b[n2]) {
            this.var_short_arr_arr_b[n2][n3] = 0;
        }
    }

    private void e(int n2, int n3) {
        if (!this.boolean_b(n2, n3)) {
            int n4 = (n2 << 1) + 1;
            this.var_short_arr_b[n4] = (short)(this.var_short_arr_b[n4] | 1 << n3);
        }
        if (n2 == this.var_byte_a) {
            this.var_short_arr_c[n3] = 24224;
            return;
        }
        if (null != this.var_short_arr_arr_b[n2]) {
            this.var_short_arr_arr_b[n2][n3] = 24224;
        }
    }

    private void c(int n2, boolean bl) {
        if (bl) {
            this.var_aj_b.var_byte_a = 0;
        }
        this.var_byte_o = 0;
        this.q = 0;
        this.var_byte_g = 0;
        this.var_short_arr_c[n2] = 0;
    }

    private void void_c(int n2) {
        if ((n2 & 0x1000) != 0) {
            this.var_byte_o = 0;
            this.q = 0;
        }
        if ((n2 & 0x100) != 0) {
            this.var_byte_g = 0;
        }
        if ((n2 & 0x10) != 0) {
            this.var_byte_p = 1;
        }
        if ((n2 & 1) != 0) {
            this.var_aj_b.var_byte_a = 0;
        }
    }

    /*
     * WARNING - void declaration
     */
    private void u() {
        boolean bl = false;
        Object object = w.var_java_lang_Object_b;
        int n2 = 0;
        while (this.var_byte_arr_arr_d != null && n2 < this.var_byte_arr_arr_d.length) {
            if (this.var_byte_arr_arr_d[n2] != null && this.var_short_arr_c[n2] < this.var_byte_arr_arr_d[n2].length) {
                block60: do {
                    this.var_byte_p = 0;
                    if (this.var_short_arr_c[n2] >= this.var_byte_arr_arr_d[n2].length) {
                        int n3 = (this.var_byte_a << 1) + 1;
                        short[] sArray = this.var_short_arr_b;
                        this.var_short_arr_b[n3] = (short)(sArray[n3] | 1 << n2);
                        break;
                    }
                    switch (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2]]) {
                        case 41: {
                            int n4 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
                            if (n4 == -1) {
                                this.var_aj_b.b(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3], this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4], 0, 0);
                                this.var_aj_b.var_byte_b = (byte)-1;
                                if (this.var_byte_j == -1) {
                                    this.var_int_c = at.b(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3], this.var_short_b, 12, 6, 240, 20);
                                    this.var_int_a = at.b(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4], this.var_short_c, 16, 8, 320, 20);
                                }
                            } else {
                                this.var_byte_o = this.byte_b(n4);
                                this.q = this.byte_c(n4);
                                this.var_aj_arr_arr_b[this.var_byte_o][this.q].var_byte_arr_b[0] = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                                this.var_aj_arr_arr_b[this.var_byte_o][this.q].var_byte_arr_b[1] = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4];
                                this.var_aj_arr_arr_b[this.var_byte_o][this.q].void_b();
                            }
                            int object2 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[object2] = (short)(sArray[object2] + 5);
                            this.void_c(4112);
                            break;
                        }
                        case 15: {
                            this.c(n2, this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] == 0);
                            break;
                        }
                        case 4: {
                            boolean bl2 = ((as)this.var_ak_b).k[103] >= this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
                            this.void_b(n2, 4, 16, (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3], bl2);
                            break;
                        }
                        case 24: {
                            this.p(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2]);
                            int n6 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[n6] = (short)(sArray[n6] + 3);
                            this.void_c(16);
                            break;
                        }
                        case 25: {
                            this.var_ak_b.var_byte_n = (byte)(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] + 1);
                            int n7 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[n7] = (short)(sArray[n7] + 3);
                            break;
                        }
                        case 50: {
                            if (this.var_aj_b.var_byte_a == 24 || this.var_aj_b.var_byte_a == 25) {
                                int n8 = n2;
                                short[] sArray = this.var_short_arr_c;
                                this.var_short_arr_c[n8] = (short)(sArray[n8] + 3);
                                this.void_c(0);
                                if (this.var_aj_b.var_byte_a == 24) {
                                    this.var_ak_b.b("Ho\u00e0n th\u00e0nh ti\u1ebfn \u0111\u1ed9 l\u01b0u", 1);
                                    this.var_ak_b.a();
                                }
                                this.var_aj_b.var_byte_a = 0;
                                break;
                            }
                            if (this.var_aj_b.var_byte_b != -1 || this.var_aj_b.var_byte_a == 23) continue block60;
                            this.var_aj_b.var_byte_a = (byte)23;
                            break;
                        }
                        case 29: {
                            int n9 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
                            var_aj_c = n9 == -1 ? this.var_aj_b : this.var_aj_arr_arr_b[this.byte_b(n9)][this.byte_c(n9)];
                            var_aj_c.b(false, (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4]);
                            at.var_aj_c.var_byte_arr_b[7] = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                            at.var_aj_c.o = 0;
                            int n10 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[n10] = (short)(sArray[n10] + 5);
                            this.void_c(4096);
                            break;
                        }
                        case 30: {
                            this.var_aj_b.var_byte_a = (byte)10;
                            int n11 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
                            var_aj_c = n11 == -1 ? this.var_aj_b : this.var_aj_arr_arr_b[this.byte_b(n11)][this.byte_c(n11)];
                            var_aj_c.c(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3], this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4]);
                            at.var_aj_c.g = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 5];
                            at.var_aj_c.var_boolean_b = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 6] == 0;
                            var_aj_c.b(false, 127);
                            int sArray = n2;
                            short[] sArray2 = this.var_short_arr_c;
                            this.var_short_arr_c[sArray] = (short)(sArray2[sArray] + 7);
                            this.void_c(16);
                            break;
                        }
                        case 42: {
                            this.var_byte_o = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
                            this.q = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                            v.v_b().b(this.var_ak_b, this.var_byte_o, -1, this.q);
                            int n13 = n2;
                            short[] sArray3 = this.var_short_arr_c;
                            this.var_short_arr_c[n13] = (short)(sArray3[n13] + 4);
                            this.void_c(4113);
                            break;
                        }
                        case 18: {
                            this.f(n2);
                            break;
                        }
                        case 49: {
                            if (this.var_ak_b.var_byte_m + 2 == 0) {
                                this.var_aj_b.var_byte_a = (byte)10;
                                this.var_ak_b.var_byte_m = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
                                this.var_ak_b.var_int_d = this.var_int_c + this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3] * 20 + 10;
                                this.var_ak_b.var_int_h = this.var_int_a + this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4] * 20 + 20;
                                this.var_ak_b.void_g(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] / 5);
                                break;
                            }
                            if (this.var_ak_b.var_byte_m != -1) break;
                            this.var_ak_b.var_byte_m = (byte)-2;
                            sArray = n2;
                            short[] n14 = this.var_short_arr_c;
                            this.var_short_arr_c[sArray] = (short)(n14[sArray] + 5);
                            this.void_c(16);
                            break;
                        }
                        case 26: {
                            this.void_a(n2);
                            break;
                        }
                        case 39: {
                            this.var_byte_o = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
                            this.q = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                            if ((((as)this.var_ak_b).l[4 + (this.var_byte_o << 1)] & 1 << this.q) == 0) break;
                            int n15 = n2;
                            short[] sArray4 = this.var_short_arr_c;
                            this.var_short_arr_c[n15] = (short)(sArray4[n15] + 4);
                            this.void_c(4113);
                            break;
                        }
                        case 27: {
                            if (this.var_byte_g == 0) {
                                this.q = this.var_ak_b.byte_c((int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2], this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3]);
                                if (this.q != -1) {
                                    this.var_byte_o = this.var_ak_b.byte_b((int)this.q);
                                    this.var_byte_g = 1;
                                    break;
                                }
                                this.c(n2, false);
                                break;
                            }
                            if (this.var_ak_b.var_byte_k != 0) break;
                            if (this.var_byte_o == -1) {
                                this.c(n2, false);
                                break;
                            }
                            int n16 = n2;
                            short[] sArray5 = this.var_short_arr_c;
                            this.var_short_arr_c[n16] = (short)(sArray5[n16] + (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 1] + 2));
                            this.void_c(4368);
                            break;
                        }
                        case 32: {
                            this.g(n2);
                            break;
                        }
                        case 46: {
                            ai.ai_b().b(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2]);
                            ai.ai_b().b(false);
                            int n17 = n2;
                            short[] sArray6 = this.var_short_arr_c;
                            this.var_short_arr_c[n17] = (short)(sArray6[n17] + 3);
                            this.void_c(16);
                            break;
                        }
                        case 47: {
                            this.var_aj_b.var_byte_a = (byte)10;
                            this.var_byte_n = (byte)(this.var_byte_n + 1);
                            if (this.var_byte_n != this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2]) break;
                            this.var_byte_n = 0;
                            int n18 = n2;
                            short[] sArray7 = this.var_short_arr_c;
                            this.var_short_arr_c[n18] = (short)(sArray7[n18] + 3);
                            this.void_c(17);
                            break;
                        }
                        case 35: {
                            int exception = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
                            if (exception == -1) {
                                this.var_aj_b.var_byte_arr_b[4] = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                                switch (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3]) {
                                    case 0: 
                                    case 2: {
                                        this.var_aj_b.var_byte_a = 0;
                                        break;
                                    }
                                    case 1: 
                                    case 3: {
                                        this.var_aj_b.var_byte_a = (byte)10;
                                    }
                                }
                            } else {
                                this.var_byte_o = this.byte_b(exception);
                                this.q = this.byte_c(exception);
                                this.var_aj_arr_arr_b[this.var_byte_o][this.q].var_byte_arr_b[4] = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                            }
                            int n19 = n2;
                            short[] sArray8 = this.var_short_arr_c;
                            this.var_short_arr_c[n19] = (short)(sArray8[n19] + 4);
                            this.void_c(4112);
                            break;
                        }
                        case 52: {
                            this.var_aj_b.var_byte_a = (byte)10;
                            this.x = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
                            int byArray = n2;
                            short[] n35 = this.var_short_arr_c;
                            this.var_short_arr_c[byArray] = (short)(n35[byArray] + 3);
                            this.void_c(16);
                            break;
                        }
                        case 16: {
                            this.h(n2);
                            break;
                        }
                        case 28: {
                            if (object != null) {
                                var_int_b = 4987;
                                af.b = 4987;
                                try {
                                    ((Runnable)object).run();
                                    var_int_b = 0;
                                    this.var_short_arr_c = new short[var_int_b];
                                    return;
                                }
                                catch (Exception n20) {
                                    var_int_b = 0;
                                    if (!(n20 instanceof IOException)) {
                                        this.var_short_arr_c = new short[var_int_b];
                                        return;
                                    }
                                    object = null;
                                }
                            }
                            this.i(n2);
                            break;
                        }
                        case 53: {
                            if (!this.boolean_b((int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2])) break;
                            int n21 = n2;
                            short[] n37 = this.var_short_arr_c;
                            this.var_short_arr_c[n21] = (short)(n37[n21] + 3);
                            this.void_c(16);
                            break;
                        }
                        case 19: {
                            ad.void_b();
                            ad.var_int_c = 0;
                            byte[] n22 = ad.ad_b().byte_arr_b("data/battle/boss.d", -1);
                            Object n40 = ad.ad_b().byte_arr_arr_b(n22);
                            int n23 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 1] >> 1;
                            this.var_ak_b.var_byte_arr_arr_b = new byte[n23][5];
                            this.q = 0;
                            while (this.q < n23) {
                                this.var_byte_o = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2 + (this.q << 1)];
                                this.var_ak_b.var_byte_arr_arr_b[this.q][0] = n40[this.var_byte_o][0];
                                this.var_ak_b.var_byte_arr_arr_b[this.q][1] = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3 + (this.q << 1)];
                                this.var_ak_b.var_byte_arr_arr_b[this.q][2] = n40[this.var_byte_o][1];
                                this.var_ak_b.var_byte_arr_arr_b[this.q][3] = n40[this.var_byte_o][2];
                                this.var_ak_b.var_byte_arr_arr_b[this.q][4] = n40[this.var_byte_o][3];
                                this.q = (byte)(this.q + 1);
                            }
                            ai.ai_b().b(6);
                            ai.ai_b().b(false);
                            this.var_ak_b.f(3);
                            this.var_ak_b.l();
                            int n24 = n2;
                            n40 = this.var_short_arr_c;
                            this.var_short_arr_c[n24] = (short)(n40[n24] + (2 + this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 1]));
                            break;
                        }
                        case 13: {
                            if (this.var_byte_g == 0) {
                                this.var_byte_g = 1;
                                if (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3] == 0) {
                                    this.var_byte_arr_a[14] = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
                                    if (this.var_byte_arr_a[14] == -1) break;
                                    this.var_ak_b.b("#4 C\u1eadp nh\u1eadt nhi\u1ec7m v\u1ee5 ch\u00ednh #0 \u0111\u00e3 \u0111\u1ed5i m\u1edbi, Nh\u1ea5n #71 n\u00fat #0 \u0111\u1ec3 xem b\u1ea3ng nhi\u1ec7m v\u1ee5 th\u1ef1c thi.", -1);
                                    break;
                                }
                                this.a((int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2], this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3] == 2);
                                if (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3] != 2) break;
                                this.var_ak_b.b("#4 Nhi\u1ec7m v\u1ee5 ph\u1ee5 #0 \u0111\u00e3 \u0111\u1ed5i m\u1edbi, nh\u1ea5n #73 n\u00fat #0 \u0111\u1ec3 xem b\u1ea3ng nhi\u1ec7m v\u1ee5 th\u1ef1c thi.", -1);
                                break;
                            }
                            if (this.var_ak_b.var_byte_k != 0) break;
                            int n25 = n2;
                            short[] sArray9 = this.var_short_arr_c;
                            this.var_short_arr_c[n25] = (short)(sArray9[n25] + 4);
                            this.void_c(272);
                            break;
                        }
                        case 23: {
                            this.var_byte_o = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
                            this.q = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                            int n26 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[n26] = (short)(sArray[n26] + 4);
                            this.void_a((int)this.var_byte_o, (int)this.q);
                            this.void_c(4112);
                            break;
                        }
                        case 17: {
                            this.var_byte_o = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
                            this.q = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                            int n27 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[n27] = (short)(sArray[n27] + 4);
                            this.e(this.var_byte_o, (int)this.q);
                            this.void_c(4112);
                            break;
                        }
                        case 37: {
                            this.var_aj_b.var_byte_a = (byte)10;
                            int bl3 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
                            var_aj_c = bl3 == -1 ? this.var_aj_b : this.var_aj_arr_arr_b[this.byte_b(bl3)][this.byte_c(bl3)];
                            var_aj_c.b(true, (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 6]);
                            var_aj_c.c(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3], this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4]);
                            at.var_aj_c.var_byte_arr_b[7] = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 5];
                            if (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 5] < 0) {
                                at.var_aj_c.n = (byte)4;
                            }
                            at.var_aj_c.g = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 7];
                            int by = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[by] = (short)(sArray[by] + 8);
                            this.void_c(16);
                            break;
                        }
                        case 22: {
                            this.void_b((int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2], (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3], (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4], (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 5]);
                            int bl4 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[bl4] = (short)(sArray[bl4] + 6);
                            this.void_c(16);
                            break;
                        }
                        case 36: {
                            int bl5 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
                            this.var_byte_o = this.byte_b(bl5);
                            this.q = this.byte_c(bl5);
                            this.var_aj_arr_arr_b[this.var_byte_o][this.q].var_byte_arr_b[5] = (byte)(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3] + 1);
                            int bl6 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[bl6] = (short)(sArray[bl6] + 4);
                            this.void_c(4112);
                            break;
                        }
                        case 2: {
                            this.var_byte_o = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
                            this.q = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                            this.void_b(n2, 5, 4112, (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4], this.boolean_b((int)this.var_byte_o, (int)this.q));
                            break;
                        }
                        case 45: {
                            this.void_d(n2);
                            break;
                        }
                        case 48: {
                            this.var_aj_b.var_byte_a = (byte)10;
                            this.L = (byte)(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] << 1);
                            int n28 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[n28] = (short)(sArray[n28] + 3);
                            this.void_c(16);
                            break;
                        }
                        case 38: {
                            this.void_e(n2);
                            break;
                        }
                        case 6: {
                            ad.void_b();
                            boolean n29 = ad.b(this.var_aj_b.var_short_b, this.var_aj_b.var_short_c, 19, 19, this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] * 20, this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3] * 20, (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4] - this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] + 1) * 20, (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 5] - this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3] + 1) * 20);
                            this.void_b(n2, 7, 16, (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 6], n29);
                            break;
                        }
                        case 5: {
                            void n33;
                            byte n30 = this.var_ak_b.byte_b(-2, (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2], true);
                            if (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3] == 0) {
                                boolean n31 = n30 == 0;
                            } else {
                                boolean n32 = n30 >= this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                            }
                            this.void_b(n2, 5, 16, (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4], (boolean)n33);
                            break;
                        }
                        case 1: {
                            int n34 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
                            if (n34 == -1) break;
                            this.var_byte_o = this.byte_b(n34);
                            this.q = this.byte_c(n34);
                            boolean n39 = this.var_aj_b.var_byte_a == 2 && this.var_byte_k == this.q;
                            this.void_b(n2, 4, 16, (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3], n39);
                            break;
                        }
                        case 3: {
                            boolean n41 = this.var_ak_b.var_int_b >= this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] * 100;
                            this.void_b(n2, 4, 16, (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3], n41);
                            break;
                        }
                        case 8: {
                            boolean bl2 = this.var_ak_b.byte_b((int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2], (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3]) != -1;
                            this.void_b(n2, 5, 16, (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4], bl2);
                            break;
                        }
                        case 12: {
                            this.j(n2);
                            break;
                        }
                        case 11: {
                            int n3 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
                            this.var_byte_o = this.byte_b(n3);
                            this.q = this.byte_c(n3);
                            if (this.var_aj_arr_arr_b[this.var_byte_o][this.q].var_byte_arr_b[8] == this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3]) {
                                int n4 = n2;
                                short[] sArray = this.var_short_arr_c;
                                this.var_short_arr_c[n4] = (short)(sArray[n4] + 4);
                                this.void_c(16);
                                break;
                            }
                            this.c(n2, false);
                            break;
                        }
                        case 40: {
                            int n5 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
                            if (n5 == -1) {
                                ad.void_b();
                                this.var_aj_b.var_byte_arr_b[7] = (byte)ad.a(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3]);
                                if (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3] < 0) {
                                    this.var_aj_b.n = (byte)4;
                                }
                            } else {
                                var_aj_c = this.var_aj_arr_arr_b[this.byte_b(n5)][this.byte_c(n5)];
                                at.var_aj_c.var_byte_arr_b[7] = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                                var_aj_c.b(var_am_arr_arr_b[at.var_aj_c.var_byte_arr_b[3] - 1][at.var_aj_c.var_byte_arr_b[2]].int_b());
                            }
                            int n6 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[n6] = (short)(sArray[n6] + 4);
                            this.void_c(16);
                            break;
                        }
                        case 43: {
                            int n7 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
                            this.var_byte_o = this.byte_b(n7);
                            this.q = this.byte_c(n7);
                            this.var_aj_arr_arr_b[this.var_byte_o][this.q].var_byte_arr_b[8] = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                            int n8 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[n8] = (short)(sArray[n8] + 4);
                            this.void_c(16);
                            break;
                        }
                        case 21: {
                            if (this.var_byte_g == 0) {
                                this.var_byte_g = 1;
                                int n9 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] * 100;
                                if (n9 < 0) {
                                    ad.void_b();
                                    if (this.var_ak_b.var_int_b < ad.a(n9)) {
                                        this.var_ak_b.b("Kim ti\u1ec1n kh\u00f4ng \u0111\u1ee7!", 0);
                                        this.var_byte_g = (byte)2;
                                    }
                                }
                                if (this.var_byte_g != 1) break;
                                this.var_ak_b.var_int_b += n9;
                                ad.void_b();
                                this.var_ak_b.b(String.valueOf(n9 < 0 ? "M\u1ea5t \u0111i: " : "\u0110\u1ea1t \u0111\u01b0\u1ee3c: ") + ad.a(n9) + " Kim", 0);
                                break;
                            }
                            if (this.var_ak_b.var_byte_k != 0) break;
                            if (this.var_byte_g == 2) {
                                this.c(n2, true);
                                break;
                            }
                            int n10 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[n10] = (short)(sArray[n10] + 3);
                            this.void_c(272);
                            break;
                        }
                        case 33: {
                            this.var_byte_c = (byte)(this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1);
                            this.g();
                            int n11 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[n11] = (short)(sArray[n11] + 3);
                            this.void_c(16);
                            break;
                        }
                        case 51: {
                            short[] sArray;
                            int n12 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4] & 0xFF | (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3] & 0xFF) << 8;
                            switch (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2]) {
                                case 0: {
                                    if (this.var_byte_g == 0) {
                                        ad.void_b();
                                        this.var_ak_b.b(ad.java_lang_String_b(this.var_byte_arr_arr_d[n2], this.var_short_arr_c[n2] + 5, n12), -1);
                                        this.var_byte_g = 1;
                                        break;
                                    }
                                    if (this.var_ak_b.var_byte_k != 0) break;
                                    int n13 = n2;
                                    short[] sArray2 = sArray = this.var_short_arr_c;
                                    int n14 = n13;
                                    sArray2[n14] = (short)(sArray2[n14] + ((n12 << 1) + 5));
                                    this.void_c(272);
                                    break;
                                }
                                case 1: 
                                case 2: {
                                    if (this.var_byte_g == 0) {
                                        this.var_aj_b.var_byte_a = (byte)22;
                                        this.z = 0;
                                        this.y = 0;
                                        ad.void_b();
                                        this.var_ak_b.b(ad.java_lang_String_b(this.var_byte_arr_arr_d[n2], this.var_short_arr_c[n2] + 5, n12), 202, 3);
                                        this.var_byte_g = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
                                        break;
                                    }
                                    if (this.var_byte_g != 3) break;
                                    int n15 = n2;
                                    short[] sArray3 = sArray = this.var_short_arr_c;
                                    int n16 = n15;
                                    sArray3[n16] = (short)(sArray3[n16] + ((n12 << 1) + 5));
                                    this.void_c(272);
                                    this.var_ak_b.var_java_lang_StringBuffer_arr_d = null;
                                    this.y = (byte)-1;
                                }
                            }
                            continue block60;
                        }
                        case 31: {
                            int n17 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
                            if (n17 == -1) {
                                this.var_aj_b.n = this.var_byte_o = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                                this.var_aj_b.b(false);
                            } else {
                                this.var_byte_o = this.byte_b(n17);
                                if (this.var_byte_o == 0) {
                                    this.q = this.byte_c(n17);
                                    this.var_aj_arr_arr_b[this.var_byte_o][this.q].n = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
                                    this.var_aj_arr_arr_b[this.var_byte_o][this.q].b(false);
                                }
                            }
                            int n18 = n2;
                            short[] sArray = this.var_short_arr_c;
                            this.var_short_arr_c[n18] = (short)(sArray[n18] + 4);
                            this.void_c(4112);
                            break;
                        }
                        case 44: {
                            byte by = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
                            if (by == 0) {
                                boolean bl3 = ((as)this.var_ak_b).m[6] == 10;
                                this.void_b(n2, 3, 16, 2, bl3);
                                break;
                            }
                            if (by == 1) {
                                ar.b(this.var_ak_b).b(2, true);
                                int n19 = n2;
                                short[] sArray = this.var_short_arr_c;
                                this.var_short_arr_c[n19] = (short)(sArray[n19] + 3);
                                this.void_c(0);
                                break;
                            }
                            if (by != 2) break;
                            this.void_b(n2, 3, 16, 2, ar.b((ak)this.var_ak_b).var_boolean_c);
                        }
                    }
                } while (this.var_byte_p == 1);
            }
            ++n2;
        }
    }

    private void void_a(int n2) {
        this.var_boolean_b = false;
        if (this.var_ak_b.byte_b((int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2], (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3], (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4], -1) == -1) {
            this.var_ak_b.b("S\u1ee7ng V\u1eadt \u0111\u00e3 \u0111\u1ee7, kh\u00f4ng th\u1ec3 \u0111o\u1ea1t S\u1ee7ng V\u1eadt m\u1edbi, h\u00e3y l\u01b0u tr\u1eef \u0111\u1ec3 c\u00f3 ch\u1ed7 tr\u1ed1ng b\u1eaft S\u1ee7ng V\u1eadt m\u1edbi.", -1);
            this.var_boolean_b = true;
            this.var_ak_b.var_byte_f = (byte)6;
            this.var_ak_b.var_byte_c = 1;
            this.var_ak_b.d();
            return;
        }
        int n3 = n2;
        this.var_short_arr_c[n3] = (short)(this.var_short_arr_c[n3] + (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 1] + 2));
        this.void_c(4368);
    }

    public static void e() {
        ak.var_int_a = -10;
    }

    private void void_e(int n2) {
        int n3 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
        var_aj_c = n3 == -1 ? this.var_aj_b : this.var_aj_arr_arr_b[this.byte_b(n3)][this.byte_c(n3)];
        if (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4] == 0) {
            at.var_aj_c.j = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
            at.var_aj_c.f = 0;
            at.var_aj_c.i = 0;
        } else if (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4] == 1) {
            at.var_aj_c.var_byte_arr_b[6] = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
        } else if (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4] == 2) {
            at.var_aj_c.j = (byte)-1;
            at.var_aj_c.var_byte_arr_b[6] = 0;
        }
        int n4 = n2;
        this.var_short_arr_c[n4] = (short)(this.var_short_arr_c[n4] + 5);
        this.void_c(4112);
    }

    private void void_d(int n2) {
        int n3;
        this.var_aj_b.var_byte_a = (byte)10;
        int n4 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1;
        if (n4 == -1) {
            n4 = this.var_aj_b.byte_b();
            n3 = this.var_aj_b.byte_c();
            this.var_byte_j = (byte)-1;
        } else {
            this.var_byte_o = this.byte_b(n4);
            this.q = this.byte_c(n4);
            this.var_byte_j = this.var_byte_o == 0 ? this.q : (byte)0;
            n4 = this.var_aj_arr_arr_b[this.var_byte_o][this.q].var_byte_arr_b[0];
            n3 = this.var_aj_arr_arr_b[this.var_byte_o][this.q].var_byte_arr_b[1];
        }
        n4 = at.b(n4, this.var_short_b, 12, 6, 240, 20) - this.var_int_c;
        n3 = at.b(n3, this.var_short_c, 16, 8, 320, 20) - this.var_int_a;
        ad.ad_b();
        if (ad.a(n3) < 10) {
            ad.ad_b();
            if (ad.a(n4) < 10) {
                int n5 = n2;
                this.var_short_arr_c[n5] = (short)(this.var_short_arr_c[n5] + 3);
                this.void_c(4112);
                return;
            }
        }
        ad.ad_b();
        if (ad.a(n4) >= 10) {
            ad.ad_b();
            this.var_int_c += n4 / ad.a(n4) * 10;
        }
        ad.ad_b();
        if (ad.a(n3) >= 10) {
            ad.ad_b();
            this.var_int_a += n3 / ad.a(n3) * 10;
        }
    }

    private void h(int n2) {
        byte by = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
        if (by == 4) {
            if (this.s == 0 && this.var_aj_b.var_byte_a != 16) {
                this.var_aj_b.var_byte_a = (byte)16;
                this.s = 1;
                this.var_ak_b.var_java_lang_String_arr_c = new String[]{"H\u1ed3i ph\u1ee5c", "Kh\u00f4ng h\u1ed3i ph\u1ee5c"};
                this.var_ak_b.var_byte_h = 0;
                this.var_ak_b.var_int_e = 0;
                for (n2 = 0; n2 < this.var_ak_b.y; n2 = (int)((byte)(n2 + 1))) {
                    this.var_ak_b.var_int_e += 40 + 20 * this.var_ak_b.var_byte_b[n2].var_byte_arr_b[4];
                }
                return;
            }
            if (this.var_aj_b.var_byte_a == 0) {
                if (this.s == 1 && this.var_ak_b.var_byte_h == 0) {
                    this.s = (byte)2;
                    if (!this.var_ak_b.boolean_b() && this.var_ak_b.boolean_b(this.var_ak_b.var_int_e, true)) {
                        this.var_ak_b.c(true);
                        return;
                    }
                } else if (this.var_ak_b.var_byte_k == 0) {
                    this.s = 0;
                    int n3 = n2;
                    this.var_short_arr_c[n3] = (short)(this.var_short_arr_c[n3] + 4);
                    this.void_c(0);
                    return;
                }
            }
        } else {
            if (by < 3) {
                this.var_ak_b.void_b((int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2], (int)by);
            } else if (by == 3) {
                this.var_ak_b.void_c(0);
            } else if (by == 5) {
                this.var_ak_b.void_a(0);
            } else if (by == 6) {
                this.var_ak_b.var_byte_c = (byte)4;
                this.var_ak_b.var_byte_h = (byte)-1;
            } else if (by == 7) {
                this.var_ak_b.var_byte_c = 1;
            }
            int n4 = n2;
            this.var_short_arr_c[n4] = (short)(this.var_short_arr_c[n4] + 4);
            this.void_c(16);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void g(int n2) {
        byte by = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
        if (by <= 1) {
            if (this.var_byte_g < 2) {
                if (by == 0) {
                    if (this.var_ak_b.var_byte_m == -2) {
                        if (this.var_ak_b.var_byte_arr_arr_l[3] == 5) {
                            this.var_ak_b.var_byte_m = (byte)-2;
                            this.var_byte_g = (byte)2;
                            this.var_ak_b.b("Hi\u1ec7n t\u1ea1i \u0111\u1eb3ng c\u1ea5p hu\u1ea5n luy\u1ec7n s\u1ef1 c\u1ee7a b\u1ea1n \u0111\u00e3 \u0111\u1ea1t t\u1edbi h\u1ea1n m\u1ee9c cao nh\u1ea5t!", 0);
                            return;
                        }
                        this.var_ak_b.var_int_e = this.var_ak_b.byte_b(true);
                        if (this.var_ak_b.var_int_e == -1) {
                            this.var_aj_b.var_byte_a = (byte)10;
                            this.var_ak_b.var_byte_m = (byte)28;
                            this.var_ak_b.var_int_d = this.var_int_c + this.var_aj_b.var_short_b + 10;
                            this.var_ak_b.var_int_h = this.var_int_a + this.var_aj_b.var_short_c + 19;
                            this.var_ak_b.void_g(this.var_ak_b.var_byte_m / 5);
                            this.var_ak_b.a(false);
                            return;
                        }
                        this.var_byte_g = (byte)2;
                        return;
                    }
                    if (this.var_ak_b.var_byte_m != -1) return;
                    this.var_ak_b.var_byte_m = (byte)-2;
                    this.var_byte_g = (byte)2;
                    if (this.var_ak_b.var_byte_arr_arr_l[3] > 3) {
                        this.var_ak_b.b("Ch\u00fac m\u1eebng b\u1ea1n \u0111\u00e3 \u0111\u01b0\u1ee3c n\u00e2ng c\u1ea5p hu\u1ea5n luy\u1ec7n s\u01b0 b\u1eadc #7" + (int)this.var_ak_b.var_byte_arr_arr_l[3] + "#0, B\u1ea1n c\u00f3 th\u1ec3 l\u01b0u tr\u1eef S\u1ee7ng V\u1eadt t\u1ea1i c\u1eeda h\u00e0ng #7 b\u1ea1o t\u0103ng \u0111\u1ebfn" + this.var_ak_b.x, -1);
                        return;
                    }
                    this.var_ak_b.b("Ch\u00fac m\u1eebng b\u1ea1n \u0111\u00e3 \u0111\u01b0\u1ee3c n\u00e2ng c\u1ea5p hu\u1ea5n luy\u1ec7n s\u01b0 b\u1eadc #7" + (int)this.var_ak_b.var_byte_arr_arr_l[3] + "#0, B\u1ea1n c\u00f3 th\u1ec3 mang theo s\u1ed1 l\u01b0\u1ee3ng S\u1ee7ng V\u1eadt t\u00f9y \u00fd #7 b\u1ea1o t\u0103ng \u0111\u1ebfn" + (int)this.var_ak_b.w + "#0, B\u1ea1n c\u00f3 th\u1ec3 l\u01b0u tr\u1eef S\u1ee7ng V\u1eadt t\u1ea1i c\u1eeda h\u00e0ng #7 b\u1ea1o t\u0103ng \u0111\u1ebfn" + this.var_ak_b.x, -1);
                    return;
                }
                if (by != 1) return;
                if (this.var_byte_g == 0 && this.var_ak_b.var_byte_arr_arr_k[104] == false) {
                    this.var_ak_b.var_int_e = 0;
                    this.var_byte_g = (byte)3;
                    this.var_ak_b.b("B\u1ea1n kh\u00f4ng c\u1ea7n ph\u1ea3i b\u1eaft \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt m\u1edbi. B\u1eaft ch\u00fang kh\u00f4ng ph\u1ea3i l\u00e0 c\u00e1ch duy nh\u1ea5t. C\u00f3 nh\u1eefng S\u1ee7ng V\u1eadt c\u1ea7n th\u00f4ng qua ti\u1ebfn h\u00f3a m\u1edbi c\u00f3 th\u1ec3 c\u00f3 \u0111\u01b0\u1ee3c.", -1);
                    return;
                }
                if (this.var_byte_g != 0) return;
                this.var_byte_g = (byte)3;
                this.var_ak_b.var_int_e = (int)this.var_ak_b.var_byte_arr_arr_k[104];
                this.var_ak_b.var_byte_arr_arr_k[104] = (byte[])false;
                this.var_ak_b.b("B\u1eaft \u0111\u01b0\u1ee3c" + this.var_ak_b.var_int_e + "S\u1ee7ng V\u1eadt m\u1edbi, l\u00e0 c\u00e1c hu\u1ea5n luy\u1ec7n s\u01b0 trong V\u01b0\u01a1ng Qu\u1ed1c th\u01b0\u1edfng cho b\u1ea1n" + this.var_ak_b.var_int_e + "Huy ch\u01b0\u01a1ng, hy v\u1ecdng kh\u00f4ng ng\u1eebng c\u1ed1 g\u1eafng gia t\u0103ng s\u1ed1 huy ch\u01b0\u01a1ng.", -1);
                this.var_ak_b.var_int_c += this.var_ak_b.var_int_e;
                return;
            }
            if (this.var_ak_b.var_byte_k != 0) return;
            if (this.var_byte_g == 2) {
                if (this.var_ak_b.var_byte_arr_arr_l[3] == 5) {
                    this.var_ak_b.b("Hi\u1ec7n t\u1ea1i \u0111\u1eb3ng c\u1ea5p hu\u1ea5n luy\u1ec7n s\u1ef1 c\u1ee7a b\u1ea1n \u0111\u00e3 \u0111\u1ea1t t\u1edbi h\u1ea1n m\u1ee9c cao nh\u1ea5t!", 0);
                } else {
                    this.var_ak_b.var_int_e = (byte)(this.var_ak_b.byte_b(false) - this.var_ak_b.var_byte_arr_arr_k[103]);
                    if (this.var_ak_b.var_int_e <= 0) {
                        this.var_ak_b.var_int_e = 0;
                    }
                    this.var_ak_b.b("\u0110\u1eb3ng c\u1ea5p hi\u1ec7n t\u1ea1i c\u1ee7a hu\u1ea5n luy\u1ec7n s\u01b0 #7" + (int)this.var_ak_b.var_byte_arr_arr_l[3] + "#0 C\u1ea7n n\u1eafm b\u1eaft kho\u1ea3ng n\u00e2ng c\u1ea5p k\u1ebf ti\u1ebfp #7" + this.var_ak_b.var_int_e + "#0 Kh\u00f4ng c\u00f3 S\u1ee7ng V\u1eadt, c\u1ed1 g\u1eafng l\u1ea5y \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt m\u1edbi.", -1);
                }
                this.var_byte_g = (byte)4;
                return;
            }
            if (this.var_byte_g == 3 && this.var_ak_b.var_int_e > 0) {
                this.var_ak_b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c: huy ch\u01b0\u01a1ng x" + this.var_ak_b.var_int_e, 0);
                this.var_byte_g = (byte)4;
                return;
            }
        }
        int n3 = n2;
        this.var_short_arr_c[n3] = (short)(this.var_short_arr_c[n3] + 3);
        this.void_c(4368);
    }

    private void f(int n2) {
        int n3 = 0;
        if (this.var_byte_g == 0) {
            this.var_byte_o = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2];
            this.q = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3];
            if (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 3] >= 0) {
                n3 = this.var_ak_b.byte_e(this.var_byte_o, this.q);
            } else {
                byte by = this.var_ak_b.byte_b(-2, (int)this.var_byte_o, true);
                ad.ad_b();
                if (by >= ad.a(this.q)) {
                    ad.ad_b();
                    this.var_ak_b.void_c((int)this.var_byte_o, ad.a(this.q));
                } else {
                    n3 = -1;
                    this.var_ak_b.b("\u0110\u1ea1o c\u1ee5 kh\u00f4ng \u0111\u1ee7!", 0);
                }
            }
            if (n3 != -1) {
                StringBuffer stringBuffer = new StringBuffer().append(this.q >= 0 ? "\u0110\u1ea1t \u0111\u01b0\u1ee3c: " : "M\u1ea5t \u0111i: ").append(this.var_ak_b.java_lang_String_c(this.var_byte_o)).append("x");
                ad.ad_b();
                this.var_ak_b.b(stringBuffer.append(ad.a(this.q)).toString(), 0);
            }
            this.var_byte_g = 1;
            return;
        }
        if (this.var_ak_b.var_byte_k == 0) {
            int n4 = n2;
            this.var_short_arr_c[n4] = (short)(this.var_short_arr_c[n4] + 4);
            this.void_c(4368);
        }
    }

    private void i(int n2) {
        int n3 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 5] & 0xFF | (this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 4] & 0xFF) << 8;
        this.D = (byte)-1;
        if (this.var_byte_g == 0) {
            int n4;
            this.var_byte_g = 1;
            if (this.var_byte_c == 1) {
                this.g();
            }
            if ((n4 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2] - 1) == -1) {
                this.var_java_lang_String_b = "T\u1eafc K\u1ef3";
                this.q = 0;
            } else {
                this.var_byte_o = this.byte_b(n4);
                this.q = this.byte_c(n4);
                this.var_java_lang_String_b = this.var_java_lang_String_arr_c[this.q];
                if (this.var_java_lang_String_b.equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng")) {
                    this.var_java_lang_String_b = null;
                }
                this.q = this.var_aj_arr_arr_b[this.var_byte_o][this.q].var_byte_arr_b[2];
            }
            this.c(this.var_java_lang_String_b);
            ad.void_b();
            ad.ad_b();
            this.var_java_lang_StringBuffer_arr_b = ad.java_lang_StringBuffer_arr_b(ad.java_lang_String_b(this.var_byte_arr_arr_d[n2], this.var_short_arr_c[n2] + 6, n3), 220);
            this.var_byte_d = 0;
            this.var_aj_b.var_byte_a = 1;
            this.var_boolean_a = false;
            return;
        }
        if (this.var_byte_g == 2) {
            short[] sArray;
            short[] sArray2 = sArray = this.var_short_arr_c;
            int n5 = n2;
            sArray2[n5] = (short)(sArray2[n5] + ((n3 << 1) + 6));
            this.void_c(4369);
        }
    }

    private void j(int n2) {
        if (this.var_aj_b.var_byte_a != 12 && this.var_aj_b.var_byte_a != 13 && this.var_aj_b.var_byte_a != 14) {
            this.w = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 1];
            this.v = 0;
            this.var_ak_b.var_int_c = (int)null;
            this.var_ak_b.var_int_c = (int)new String[this.w];
            for (byte by = 0; by < this.w; by = (byte)(by + 1)) {
                int n3 = this.var_ak_b.var_int_c;
                ad.ad_b();
                n3[by] = ad.java_lang_String_b(this.var_byte_arr_arr_d[n2], this.var_short_arr_c[n2] + 2 + this.v + 1, (int)this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2 + this.v]);
                this.v = (byte)(this.v + ((this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + 2 + this.v] << 1) + 1));
            }
            if (this.var_byte_h != -1) {
                this.var_byte_p = 1;
                this.var_ak_b.s = (byte[])this.var_byte_h;
                this.var_aj_b.var_byte_a = (byte)13;
                this.var_ak_b.var_int_c = (int)null;
                this.var_byte_h = (byte)-1;
                return;
            }
            this.var_ak_b.s = (byte[])false;
            this.var_aj_b.var_byte_a = (byte)12;
            return;
        }
        if (this.var_aj_b.var_byte_a == 13) {
            this.v = (byte)(this.v + 2);
            short s2 = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + this.v + (this.var_ak_b.s << 1)];
            byte by = this.var_byte_arr_arr_d[n2][this.var_short_arr_c[n2] + this.v + (this.var_ak_b.s << 1) + 1];
            s2 = (short)((s2 & 0xFF) << 8 | by & 0xFF);
            int n4 = n2;
            this.var_short_arr_c[n4] = (short)(this.var_short_arr_c[n4] + (this.v + (this.w << 1) + s2));
            this.void_c(17);
            return;
        }
        if (this.var_aj_b.var_byte_a == 14) {
            this.c(n2, true);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void d() {
        if (this.var_aj_b.var_byte_a != 9 && this.var_aj_b.var_byte_a != 6) {
            this.u();
        }
        if (this.var_aj_b.var_byte_a == 5 && this.var_aj_b.var_byte_b <= 0) {
            this.C();
            this.var_aj_b.var_byte_a = (byte)6;
        }
        if (this.var_aj_b.var_byte_a == 6) {
            this.var_ak_b.var_byte_a = 1;
            var1_1 = this;
            this.var_byte_f = 0;
            var1_1.var_ak_b.void_b(2);
            var3_3 = var1_1;
            var3_3.o();
            var3_3.var_byte_arr_b[var3_3.var_byte_a] = 1;
            ad.ad_b();
            ad.byte_arr_b(1, var3_3.var_byte_arr_b, 2);
            var2_5 = var1_1.var_byte_m;
            if (var1_1.t != -2) {
                var1_1.var_byte_l = var1_1.var_byte_a;
                var1_1.var_byte_a = var1_1.u;
                var1_1.u = 0;
                var1_1.var_byte_m = var1_1.t;
            }
            var1_1.var_ak_b.void_b(5);
            if (var1_1.t == -2) {
                var4_7 = var1_1.var_byte_arr_arr_c;
                var3_3 = var1_1;
                if (var4_7[var3_3.var_byte_k][3] == -1) {
                    var5_13 = var3_3.var_byte_a;
                    var3_3.var_byte_a = var3_3.var_byte_l;
                    var3_3.var_byte_l = var5_13;
                    var3_3.var_byte_m = var3_3.var_byte_k;
                    var5_13 = -1;
                } else {
                    var5_13 = var3_3.var_byte_a;
                    var3_3.var_byte_a = var4_7[var3_3.var_byte_k][4];
                    var3_3.var_byte_l = var5_13;
                    var3_3.var_byte_m = var3_3.var_byte_k;
                    var5_13 = var4_7[var3_3.var_byte_k][3];
                }
                var1_1.t = (byte)var5_13;
            }
            var1_1.var_ak_b.void_b(false);
            var1_1.var_ak_b.void_b(8);
            var1_1.p();
            var1_1.var_ak_b.void_b(10);
            if (var1_1.t == -1) {
                var1_1.t = var2_5;
            }
            if (!var1_1.var_boolean_c) {
                var5_14 = var1_1.var_byte_arr_arr_c;
                var4_8 = var1_1.t;
                var3_3 = var1_1;
                var1_1.var_aj_b.n = (byte)(((var5_14[var4_8][2] - 1) / 2 << 1) + 1 + var5_14[var4_8][2] % 2);
                var3_3.var_aj_b.b(var5_14[var4_8][0], var5_14[var4_8][1], 0, 0);
            }
            var1_1.l();
            var1_1.var_ak_b.void_b(15);
            var1_1.j();
            var1_1.s();
            var1_1.var_ak_b.void_b(20);
            if (!(var1_1.var_boolean_c || var1_1.var_byte_arr_arr_c[var1_1.t][5] != 1 && var1_1.var_byte_arr_arr_c[var1_1.t][5] != 2)) {
                var1_1.var_aj_b.var_byte_b = (byte)(20 / var1_1.var_aj_b.g);
                var1_1.var_aj_b.e = (byte)(var1_1.var_byte_arr_arr_h[var1_1.var_aj_b.n][0] * var1_1.var_aj_b.g);
                var1_1.var_aj_b.d = (byte)(var1_1.var_byte_arr_arr_h[var1_1.var_aj_b.n][1] * var1_1.var_aj_b.g);
                var1_1.var_aj_b.b(true);
            } else {
                var1_1.var_aj_b.b(false);
            }
            var1_1.var_ak_b.var_byte_g = 0;
            var4_9 = false;
            var3_3 = var1_1;
            ai.ai_b().b(var3_3.var_ak_b.var_byte_arr_e[var3_3.var_byte_a]);
            ai.ai_b().b(false);
            var1_1.t = (byte)-2;
            var1_1.var_ak_b.c((int)var1_1.var_byte_a, true);
            var1_1.var_ak_b.var_byte_l = (byte)25;
            var1_1.var_byte_j = (byte)-1;
            ad.ad_b();
            ad.byte_arr_b(1, null, 4);
            var1_1.V();
            var1_1.var_boolean_c = false;
            var1_1.var_aj_b.var_byte_a = (byte)9;
            if (var1_1.M == -1) {
                var1_1.var_aj_b.var_byte_a = 0;
                var1_1.var_aj_b.c(-1, -1);
                var1_1.var_aj_b.g = var1_1.byte_b();
            }
            var1_1.D = (byte)-1;
            return;
        }
        if (this.var_aj_b.var_byte_a == 2 && this.var_byte_g == 0) {
            if ((this.var_aj_arr_arr_b[0][this.var_byte_k].var_byte_arr_b[4] == 1 || this.var_aj_arr_arr_b[0][this.var_byte_k].var_byte_arr_b[4] == 3) && this.var_aj_arr_arr_b[0][this.var_byte_k].var_byte_arr_b[5] > 0) {
                this.var_java_lang_String_b = this.var_java_lang_String_arr_c[this.var_byte_k];
                if (this.var_java_lang_String_b.equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng")) {
                    this.var_java_lang_String_b = null;
                }
                this.c(this.var_java_lang_String_b);
                ad.ad_b();
                this.var_java_lang_StringBuffer_arr_b = ad.java_lang_StringBuffer_arr_b(this.var_java_lang_String_arr_b[this.var_aj_arr_arr_b[0][this.var_byte_k].var_byte_arr_b[5] - 1], 220);
                this.var_byte_d = 0;
                this.var_aj_b.var_byte_a = 1;
            } else {
                this.var_aj_b.var_byte_a = 0;
            }
        } else if (this.var_aj_b.var_byte_a == 8 && this.var_aj_b.var_byte_b == -1) {
            if (this.var_ak_b.var_byte_b == 0) {
                v0 = this.var_ak_b.var_java_lang_String_arr_b;
                ad.ad_b();
                this.var_ak_b.b(v0[ad.c(3)], 0);
                ak.var_byte_b.repaint();
                this.var_ak_b.f(4);
                this.var_ak_b.k();
            } else {
                this.var_aj_b.var_byte_a = 0;
            }
        }
        var1_2 = this;
        if (var1_2.var_aj_b.k != -1 || var1_2.var_aj_b.l != -1) {
            var1_2.b(var1_2.var_aj_b, false);
        } else {
            var4_10 = var1_2;
            if (var4_10.M != -1 && var4_10.var_aj_b.k == -1 && var4_10.var_aj_b.l == -1) {
                var4_10.var_aj_b.var_byte_a = (byte)9;
                v1 = (byte)(var4_10.var_ak_b.s + 2);
                var4_10.var_ak_b.s = (byte[])v1;
                if (v1 >= var4_10.var_byte_arr_arr_b[var4_10.M].length) {
                    var4_10.M = (byte)-1;
                    var4_10.var_aj_b.var_byte_a = 0;
                    var4_10.var_byte_c = (byte)-1;
                    var4_10.g();
                } else {
                    var4_10.C = at.b(var4_10.var_byte_arr_arr_c, (int)var4_10.var_aj_b.var_short_b, (int)var4_10.var_aj_b.var_short_c);
                    if (var4_10.C != -1) {
                        var4_10.var_aj_b.var_byte_a = (byte)5;
                        var4_10.var_byte_k = var4_10.C;
                    }
                    var4_10.var_aj_b.c(var4_10.var_byte_arr_arr_b[var4_10.M][var4_10.var_ak_b.s], var4_10.var_byte_arr_arr_b[var4_10.M][var4_10.var_ak_b.s + true]);
                }
            }
        }
        var1_2.void_b(var1_2.var_aj_b, -1);
        for (var3_4 = 0; var3_4 < 3; var3_4 = (int)((byte)(var3_4 + 2))) {
            for (var2_6 = 0; var2_6 < var1_2.var_aj_arr_arr_b[var3_4].length; var2_6 = (int)((byte)(var2_6 + 1))) {
                block45: {
                    block43: {
                        block48: {
                            block46: {
                                block47: {
                                    block44: {
                                        if (var1_2.var_aj_arr_arr_b[var3_4][var2_6].var_byte_arr_b[4] != 1 && var1_2.var_aj_arr_arr_b[var3_4][var2_6].var_byte_arr_b[4] != 2) continue;
                                        if (var1_2.var_aj_arr_arr_b[var3_4][var2_6].var_byte_arr_b[8] < 5) break block43;
                                        var6_16 = var2_6;
                                        var5_15 = var1_2.var_aj_arr_arr_b[var3_4][var2_6];
                                        var4_11 = var1_2;
                                        if (var4_11.var_aj_b.var_byte_a != 1 || var4_11.var_byte_k != var6_16) break block44;
                                        v2 = var5_15.var_byte_arr_b;
                                        ad.ad_b();
                                        v2[7] = (byte)(ad.a(var5_15.var_byte_arr_b[7]) / 3 * 3 + (var4_11.var_aj_b.n < 4 ? var4_11.var_aj_b.n - 1 : var4_11.var_aj_b.n - 2));
                                        if (var4_11.var_aj_b.n == 3) {
                                            var5_15.var_byte_arr_b[7] = -var5_15.var_byte_arr_b[7];
                                        } else {
                                            var5_15.n = (byte)3;
                                        }
                                        break block45;
                                    }
                                    var7_18 = 10;
                                    var6_17 = var5_15;
                                    if (var6_17.m != 0) break block46;
                                    if (var6_17.var_byte_b != -1) break block47;
                                    ad.ad_b();
                                    var6_17.var_boolean_c = ad.c(100) < 50;
                                    ad.ad_b();
                                    if (ad.c(100) >= 50) ** GOTO lbl-1000
                                    ad.ad_b();
                                    var6_17.m = (byte)(-(ad.c(10) + 20));
                                    var6_17.b(false);
                                    v3 = false;
                                    break block48;
                                }
                                v3 = false;
                                break block48;
                            }
                            if (var6_17.m < 0) {
                                var6_17.m = (byte)(var6_17.m + 1);
                                v3 = false;
                            } else lbl-1000:
                            // 2 sources

                            {
                                v3 = true;
                            }
                        }
                        if (v3) {
                            if (var5_15.var_boolean_c) {
                                var4_12 = var4_11.var_ak_b.var_byte_arr_b[var5_15.var_byte_arr_b[8] - 5 << 1];
                                var7_19 = var5_15;
                                var6_17 = var4_11;
                                if (var7_19.m == 0) {
                                    ad.ad_b();
                                    var7_19.n = (byte)(ad.c(100) < 50 ? 3 : 4);
                                    var4_12 = var7_19.n == 3 ? (short)(var7_19.var_short_b - var7_19.var_byte_arr_b[0] * 20) : (short)((var4_12 + var7_19.var_byte_arr_b[0]) * 20 - var7_19.var_short_b);
                                    if (var4_12 <= 20) {
                                        var7_19.m = (byte)(var4_12 / var7_19.g);
                                    } else {
                                        ad.ad_b();
                                        var7_19.m = (byte)(ad.c((var4_12 - 20) / var7_19.g + 1) + 20 / var7_19.g);
                                    }
                                } else if (var7_19.m > 0 && var7_19.var_byte_b <= 0) {
                                    if (super.b(var7_19, (int)(var7_19.n == 3 ? -var7_19.g : var7_19.g), 0)) {
                                        var7_19.b(var7_19.n == 3 ? -var7_19.g : var7_19.g, 0);
                                        var7_19.m = (byte)(var7_19.m - 1);
                                        var7_19.var_byte_b = 1;
                                        var7_19.b(true);
                                    } else {
                                        var7_19.m = (byte)-20;
                                        var7_19.var_byte_b = (byte)-1;
                                        var7_19.b(false);
                                    }
                                }
                            } else {
                                var4_11.a(var5_15, (int)var4_11.var_ak_b.var_byte_arr_b[(var5_15.var_byte_arr_b[8] - 5 << 1) + 1]);
                            }
                        }
                        break block45;
                    }
                    if (var1_2.var_aj_arr_arr_b[var3_4][var2_6].k != -1 || var1_2.var_aj_arr_arr_b[var3_4][var2_6].l != -1) {
                        var1_2.b(var1_2.var_aj_arr_arr_b[var3_4][var2_6], true);
                    }
                }
                var1_2.void_b(var1_2.var_aj_arr_arr_b[var3_4][var2_6], var2_6);
            }
        }
        var1_2.i();
    }

    public final void b(Graphics object) {
        var_javax_microedition_lcdui_Graphics_b = object;
        if (this.var_aj_b.var_byte_a == 6) {
            this.var_ak_b.b(false, (int)this.var_ak_b.var_byte_g, 30, 282, 180);
            return;
        }
        if (this.var_aj_b.var_byte_a == 17) {
            at at2 = this;
            ah.ah_b();
            ah.c();
            ah.ah_b();
            ah.b(1, 2, 238, 318);
            ah.ah_b();
            ah.h(6, 28, 228, 233, 1);
            ah.ah_b();
            ah.h(6, 266, 228, 48, 2);
            ah.ah_b().b(false, true);
            ah.ah_b();
            ah.b("\u0110\u1ecba \u0111\u1ed3 tr\u00f2 ch\u01a1i", 120, 4, 17, 1, 2);
            if (at2.G == -1) {
                ah.ah_b();
                ah.b("Kh\u00f4ng c\u00f3 \u0111\u1ecba \u0111\u1ed3 khu v\u1ef1c!", 120, 268, 17, 3, 0);
                return;
            }
            ak.b("V\u1ecb tr\u00ed nh\u00e2n v\u1eadt hi\u1ec7n t\u1ea1i: " + at2.var_ak_b.java_lang_String_a(at2.H), 120, 268, 10, 3);
            var_javax_microedition_lcdui_Graphics_b.setClip(6, 28, 228, 233);
            int n2 = 120 - at2.var_byte_arr_arr_g[at2.I][0] * 13 - (at2.var_boolean_e ? at2.var_byte_arr_arr_g[at2.I][6] * 13 / 2 : 25);
            ad.ad_b();
            at2.var_short_k = ad.b(at2.var_short_k, n2, 10, false);
            n2 = at2.var_short_m / 2 - (at2.var_byte_arr_arr_g[at2.I][1] << 3) - (at2.var_boolean_e ? (at2.var_byte_arr_arr_g[at2.I][7] << 3) / 2 : 15);
            ad.ad_b();
            at2.var_short_l = ad.b(at2.var_short_l, n2, 10, false);
            for (int n3 = 0; n3 < at2.var_byte_arr_arr_f[at2.G].length; n3 = (int)((byte)(n3 + 1))) {
                byte by = at2.var_byte_arr_arr_f[at2.G][n3];
                if (by < 0 || at2.var_byte_arr_arr_g[by].length <= 0 || !at2.var_boolean_e && by == at2.H) continue;
                at2.b((byte)13, (byte)8, (int)by, false);
            }
            if (!at2.var_boolean_e) {
                at2.b((byte)13, (byte)8, (int)at2.H, false);
            }
            at2.b((byte)13, (byte)8, (int)at2.I, true);
            var_javax_microedition_lcdui_Graphics_b.setClip(0, 0, 240, 320);
            return;
        }
        if (this.var_aj_b.var_byte_a == 18) {
            this.J();
            return;
        }
        ah.ah_b();
        ah.b(this.var_int_d, 0, 0, 240, 320);
        at at3 = this;
        if (at3.var_int_a + at3.var_short_c * 20 < 320 && at3.var_short_c > 16) {
            at3.var_int_a = 320 - at3.var_short_c * 20;
        } else if (at3.var_int_a > 0 && at3.var_short_c > 16) {
            at3.var_int_a = 0;
        } else if (at3.var_int_c > 0 && at3.var_short_b > 12) {
            at3.var_int_c = 0;
        } else if (at3.var_int_c + at3.var_short_b * 20 < 240 && at3.var_short_b > 12) {
            at3.var_int_c = 240 - at3.var_short_b * 20;
        }
        if (this.x > 0) {
            this.x = (byte)(this.x - 1);
            object.translate(this.x % 2, this.x % 2);
        }
        byte by = ak.var_byte_b;
        at3 = this;
        short s2 = at3.var_short_a;
        short s3 = at3.var_short_e;
        if (at3.var_int_c >= 0) {
            at3.var_short_a = 0;
            at3.var_int_h = at3.var_int_c;
        } else {
            at3.var_short_a = (short)(-at3.var_int_c / 20);
            at3.var_int_h = at3.var_int_c % 20;
        }
        if (at3.var_int_a >= 0) {
            at3.var_short_e = 0;
            at3.var_int_g = at3.var_int_a;
        } else {
            at3.var_short_e = (short)(-at3.var_int_a / 20);
            at3.var_int_g = at3.var_int_a % 20;
        }
        int n4 = at3.var_short_a * 20;
        int n5 = at3.var_short_e * 20;
        if (at3.var_byte_f == 0) {
            at3.var_byte_f = 1;
            at3.b(at3.var_short_arr_a, at3.var_javax_microedition_lcdui_Image_arr_b, n4, n5, at3.var_short_arr_arr_c, (Graphics)by, 0, 0, 260, 340, true);
        } else if (at3.var_short_a != s2 || at3.var_short_e != s3) {
            by.setClip(0, 0, 260, 340);
            by.copyArea(0, 0, 260, 340, (s2 - at3.var_short_a) * 20, (s3 - at3.var_short_e) * 20, 20);
            if (at3.var_short_a < s2) {
                at3.b(at3.var_short_arr_a, at3.var_javax_microedition_lcdui_Image_arr_b, n4, n5, at3.var_short_arr_arr_c, (Graphics)by, 0, 0, (s2 - at3.var_short_a) * 20, 340, true);
            } else if (at3.var_short_a > s2) {
                at3.b(at3.var_short_arr_a, at3.var_javax_microedition_lcdui_Image_arr_b, n4, n5, at3.var_short_arr_arr_c, (Graphics)by, 260 + (s2 - at3.var_short_a) * 20, 0, 260, 340, true);
            }
            if (at3.var_short_e < s3) {
                at3.b(at3.var_short_arr_a, at3.var_javax_microedition_lcdui_Image_arr_b, n4, n5, at3.var_short_arr_arr_c, (Graphics)by, 0, 0, 260, (s3 - at3.var_short_e) * 20, true);
            } else if (at3.var_short_e > s3) {
                at3.b(at3.var_short_arr_a, at3.var_javax_microedition_lcdui_Image_arr_b, n4, n5, at3.var_short_arr_arr_c, (Graphics)by, 0, 340 + (s3 - at3.var_short_e) * 20, 260, 340, true);
            }
        }
        var_javax_microedition_lcdui_Graphics_b.drawImage((Image)ak.var_byte_b, at3.var_int_h, at3.var_int_g, 20);
        this.b(this.var_aj_arr_arr_b[2]);
        this.c(this.var_aj_arr_arr_b[0]);
        this.b(this.var_short_arr_e, this.var_javax_microedition_lcdui_Image_arr_b, -this.var_int_c, -this.var_int_a, this.var_short_arr_arr_c, (Graphics)object, 0, 0, 240, 320, false);
        this.b(this.var_aj_arr_arr_b[1]);
        this.a((Graphics)object);
        this.b((Graphics)object, 223, 0, 16);
        this.Q();
        this.m(4);
        this.W();
        if (this.var_ak_b.var_byte_m >= 0 && this.var_ak_b.boolean_b(this.var_ak_b.var_byte_m / 5 > 5 ? 5 : this.var_ak_b.var_byte_m / 5, this.var_ak_b.var_byte_m / 5 > 5 ? 5 : this.var_ak_b.var_byte_m / 5, this.var_ak_b.var_byte_m / 5 >= 5 ? this.var_ak_b.var_byte_m - 25 : this.var_ak_b.var_byte_m % 5, this.var_ak_b.var_int_d, this.var_ak_b.var_int_h + 16, 0)) {
            if (this.var_aj_b.var_byte_a == 21) {
                this.var_ak_b.var_byte_m = (byte)-2;
                this.g();
            } else {
                this.var_ak_b.var_byte_m = (byte)-1;
            }
            this.var_aj_b.var_byte_a = 0;
        }
        object.translate(-object.getTranslateX(), -object.getTranslateY());
        this.var_ak_b.i(this.var_aj_b.var_byte_a);
        if (this.var_aj_b.var_byte_a == 19) {
            at3 = this;
            ak cfr_ignored_0 = at3.var_ak_b;
            ak.c("B\u1ea1n c\u00f3 mu\u1ed1n l\u01b0u c\u00e1c b\u00e0n kh\u00f4ng?", 260, 0);
            ah.ah_b().b(true, true);
            return;
        }
        if (this.var_ak_b.var_byte_arr_arr_l[2] > 0) {
            ah.ah_b();
            ah.b("9: T\u1ecda K\u1ef5", 120, 312, 33, 0, 2);
        }
        this.var_ak_b.i();
        this.U();
        if (this.var_ak_b.var_byte_c == 4) {
            object = new byte[]{4, 25, 56};
            ah.ah_b();
            ah.a(0, 260, 240, 60);
            ak.b(this.var_ak_b.java_lang_String_b((int)object[this.var_ak_b.s]), 120, 272, 10, 3);
        } else if (this.var_aj_b.var_byte_a == 16) {
            ah.ah_b();
            ah.a(0, 240, 240, 80);
            ak.b("B\u1ea1n c\u00f3 mu\u1ed1n h\u1ed3i ph\u1ee5c t\u1ea5t c\u1ea3 S\u1ee7ng V\u1eadt kh\u00f4ng?", 120, 244, 10, 3);
            ak.b((Object[])this.var_ak_b.var_int_c, 82, 140, 76, -1, 0, this.var_ak_b.var_byte_h);
            ak.b("Kim ng\u1ea1ch c\u1ea7n thi\u1ebft: " + this.var_ak_b.var_int_e, 120, 264, 10, 3);
            this.var_ak_b.void_b(120, 300, 3, false);
        }
        if (this.var_aj_b.var_byte_a == 23) {
            ah.ah_b();
            ah.a(0, 280, 240, 40);
            ah.ah_b();
            ah.b("B\u1ea1n c\u00f3 mu\u1ed1n l\u01b0u tr\u1eef ti\u1ebfn \u0111\u1ed9 kh\u00f4ng?", 120, 284, 17, 3, 0);
            ah.ah_b().b(true, true);
        } else if (this.var_aj_b.var_byte_a == 12) {
            ak.b((Object[])this.var_ak_b.var_int_c, 63, 160 - 20 * (((int)this.var_ak_b.var_int_c).length >> 1), 114, 0, 0, (int)this.var_ak_b.s);
        }
        if (this.var_byte_d >= 0) {
            this.b(this.var_java_lang_String_b);
        }
        this.var_ak_b.f();
        if (this.var_aj_b.var_byte_a == 20) {
            this.w();
        }
    }

    private void v() {
        if (this.var_int_a + this.var_short_c * 20 < 320 && this.var_short_c > 16) {
            this.var_int_a = 320 - this.var_short_c * 20;
            return;
        }
        if (this.var_int_a > 0 && this.var_short_c > 16) {
            this.var_int_a = 0;
            return;
        }
        if (this.var_int_c > 0 && this.var_short_b > 12) {
            this.var_int_c = 0;
            return;
        }
        if (this.var_int_c + this.var_short_b * 20 < 240 && this.var_short_b > 12) {
            this.var_int_c = 240 - this.var_short_b * 20;
        }
    }

    private void b(Graphics graphics, int n2, int n3, int n4) {
        if (this.r > 0) {
            graphics.setColor(0x3C3B3B);
            graphics.drawRect(224, 0, 14, 16);
            graphics.drawRect(223, 1, 16, 14);
            graphics.setColor(0xCCCCCC);
            graphics.drawRect(225, 1, 12, 14);
            graphics.drawRect(224, 2, 14, 12);
            ah.ah_b();
            ah.b(0xFFFFFF, 225, 2, 13, 13);
            ah.ah_b().a(67, 231, 8, 3, 0);
            if (this.r % 12 < 6) {
                ah.ah_b();
                ah.c(0xEE0000, 238, 0, 223, 15);
                ah.ah_b();
                ah.c(0, 239, 0, 223, 16);
                ah.ah_b();
                ah.c(0xEE0000, 239, 1, 224, 16);
            }
            if ((this.r = (byte)(this.r - 1)) < 2) {
                this.r = (byte)100;
            }
        }
    }

    public final void b(Graphics graphics, int n2, boolean bl) {
        graphics.setColor(0xFFFFFF);
        byte by = 0;
        byte by2 = (byte)(this.y - 5 > 0 ? this.y - 5 : 0);
        while (bl ? by < ((byte)this.var_ak_b.var_byte_d).length : by <= this.y && by < ((byte)this.var_ak_b.var_byte_d).length) {
            if (!bl) {
                if (this.y == by) {
                    graphics.setClip(0, n2 + (by - by2) * 24, this.z << 1, 24);
                }
                ah.ah_b();
                ah.b(this.var_ak_b.var_byte_d[by].toString(), 19, n2 + (by - by2) * 24, 0, 0);
                graphics.setClip(0, 0, 240, 320);
            } else {
                ad.ad_b();
                short s2 = (short)(ad.int_b(this.var_ak_b.var_byte_d[by].toString()) - ak.short_b(this.var_ak_b.var_byte_d[by].toString()));
                ah.ah_b();
                ah.b(this.var_ak_b.var_byte_d[by].toString(), 240 - s2 >> 1, n2 + by * 24, 0, 0);
            }
            by = (byte)(by + 1);
        }
        if (!bl) {
            graphics.setColor(0);
            graphics.fillRect(0, 0, 240, 40);
            graphics.fillRect(0, 280, 240, 40);
        }
        if (this.y == ((byte)this.var_ak_b.var_byte_d).length) {
            int n3 = 0;
            n3 = 33;
            n3 = 296;
            n3 = 120;
            ah.ah_b();
            ah.b("Nh\u1ea5n n\u00fat 0 \u0111\u1ec3 ti\u1ebfp t\u1ee5c", 120, 296, 33, 0, 0);
            return;
        }
        if (!bl && (this.z = (byte)(this.z + 4)) >= 120) {
            this.z = 0;
            this.y = (byte)(this.y + 1);
            return;
        }
        if (bl) {
            this.y = (byte)((byte)this.var_ak_b.var_byte_d).length;
        }
    }

    public final void h() {
        block94: {
            block96: {
                block97: {
                    block92: {
                        block95: {
                            block93: {
                                block87: {
                                    block88: {
                                        at at2;
                                        block91: {
                                            block90: {
                                                block89: {
                                                    block82: {
                                                        block83: {
                                                            at at3;
                                                            block86: {
                                                                block85: {
                                                                    block84: {
                                                                        if (this.var_aj_b.var_byte_a != 17) break block82;
                                                                        at3 = this;
                                                                        ad.ad_b();
                                                                        ad.void_c();
                                                                        ad.ad_b();
                                                                        if (ad.g()) break block83;
                                                                        ad.ad_b();
                                                                        if (ad.i()) break block84;
                                                                        ad.ad_b();
                                                                        if (!ad.j()) break block85;
                                                                    }
                                                                    at3.var_aj_b.var_byte_a = 0;
                                                                    at3.var_byte_arr_arr_f = null;
                                                                    at3.var_byte_arr_arr_g = null;
                                                                    return;
                                                                }
                                                                ad.ad_b();
                                                                if (ad.e()) break block86;
                                                                ad.ad_b();
                                                                if (!ad.boolean_c()) break block83;
                                                            }
                                                            if (at3.var_byte_arr_arr_g[at3.I].length >= 6) {
                                                                byte[] byArray = at3.var_byte_arr_arr_g[at3.I];
                                                                ad.ad_b();
                                                                ad.ad_b();
                                                                if (byArray[ad.a(ad.e) + 1] != -1) {
                                                                    byte[] byArray2 = at3.var_byte_arr_arr_g[at3.I];
                                                                    ad.ad_b();
                                                                    ad.ad_b();
                                                                    at3.I = byArray2[ad.a(ad.e) + 1];
                                                                }
                                                            }
                                                        }
                                                        return;
                                                    }
                                                    if (this.var_aj_b.var_byte_a != 18) break block87;
                                                    at2 = this;
                                                    ad.ad_b();
                                                    if (ad.boolean_b()) break block88;
                                                    ad.ad_b();
                                                    if (ad.e()) break block89;
                                                    ad.ad_b();
                                                    if (ad.k() && at2.var_ak_b.s == true) break block89;
                                                    ad.ad_b();
                                                    if (!ad.l() || at2.var_ak_b.s != false) break block90;
                                                }
                                                at2.var_ak_b.s = (byte[])((byte)(at2.var_ak_b.s ^ 1));
                                                at2.b((int)at2.var_ak_b.s, at2.var_boolean_d);
                                                return;
                                            }
                                            ad.ad_b();
                                            if (ad.boolean_c()) {
                                                byte by = at2.var_ak_b.s == false ? (byte)(at2.var_byte_arr_a[14] + 1 > at2.var_java_lang_StringBuffer_arr_arr_b.length ? at2.var_java_lang_StringBuffer_arr_arr_b.length : at2.var_byte_arr_a[14] + 1) : (byte)at2.var_byte_arr_e.length;
                                                ad.ad_b();
                                                ad.b((byte[])at2.var_ak_b.var_byte_h[0], 0, (int)by, at2.var_ak_b.var_byte_d);
                                                if (at2.var_ak_b.s == false) {
                                                    at2.var_ak_b.b(at2.var_java_lang_StringBuffer_arr_arr_b[at2.var_ak_b.var_byte_h[0][0]][1].toString(), 202, 0);
                                                    return;
                                                }
                                                if (at2.var_byte_arr_e.length > 0) {
                                                    at2.var_ak_b.b(at2.var_java_lang_StringBuffer_arr_arr_b[at2.var_byte_arr_e[at2.var_ak_b.var_byte_h[0][0]]][1].toString(), 202, 0);
                                                    return;
                                                }
                                                at2.var_ak_b.var_int_c = (int)null;
                                                return;
                                            }
                                            ad.ad_b();
                                            if (ad.i()) break block91;
                                            ad.ad_b();
                                            if (ad.k()) break block91;
                                            ad.ad_b();
                                            if (!ad.l()) break block88;
                                        }
                                        at2.var_aj_b.var_byte_a = 0;
                                        if (at2.var_boolean_d) {
                                            at2.var_ak_b.void_b(0);
                                            ak.var_int_a = 97;
                                        } else {
                                            ak.var_int_a = -10;
                                        }
                                        at2.var_byte_arr_e = null;
                                        at2.var_java_lang_StringBuffer_arr_arr_b = null;
                                        at2.var_ak_b.var_int_c = (int)null;
                                        ad.ad_b();
                                        ad.void_c();
                                    }
                                    return;
                                }
                                if (this.var_aj_b.var_byte_a == 12) {
                                    at at4 = this;
                                    ad.ad_b();
                                    if (!ad.boolean_b()) {
                                        ad.ad_b();
                                        if (ad.g()) {
                                            at4.var_aj_b.var_byte_a = (byte)13;
                                            return;
                                        }
                                        ad.ad_b();
                                        if (ad.boolean_c()) {
                                            ak ak2 = at4.var_ak_b;
                                            ad.ad_b();
                                            ak2.s = (byte[])ad.byte_b((int)at4.var_ak_b.s, 0, ((int)at4.var_ak_b.var_int_c).length - 1);
                                        }
                                    }
                                    return;
                                }
                                if (this.var_aj_b.var_byte_a == 19) {
                                    at at5 = this;
                                    ad.ad_b();
                                    if (ad.f()) {
                                        at5.var_aj_b.var_byte_a = 0;
                                        at5.var_byte_g = (byte)2;
                                        return;
                                    }
                                    ad.ad_b();
                                    if (ad.i()) {
                                        at5.var_aj_b.var_byte_a = 0;
                                        at5.var_byte_g = (byte)3;
                                    }
                                    return;
                                }
                                if (this.var_aj_b.var_byte_a == 22 && this.y >= 0 && this.y == ((byte)this.var_ak_b.var_byte_d).length) {
                                    ad.ad_b();
                                    if (ad.j()) {
                                        this.var_byte_g = (byte)3;
                                        this.y = (byte)-1;
                                        ad.ad_b();
                                        ad.void_c();
                                        return;
                                    }
                                }
                                if (this.var_aj_b.var_byte_a != 16) break block92;
                                ad.ad_b();
                                if (ad.boolean_b()) {
                                    return;
                                }
                                ad.ad_b();
                                if (!ad.boolean_c()) break block93;
                                this.var_ak_b.var_byte_h = (byte)(this.var_ak_b.var_byte_h ^ 1);
                                break block94;
                            }
                            ad.ad_b();
                            if (ad.g()) break block95;
                            ad.ad_b();
                            if (!ad.i()) break block94;
                        }
                        ad.ad_b();
                        if (ad.i()) {
                            this.var_ak_b.var_byte_h = 1;
                        }
                        this.var_aj_b.var_byte_a = 0;
                        return;
                    }
                    if (this.var_aj_b.var_byte_a == 10) {
                        ad.ad_b();
                        ad.void_c();
                        return;
                    }
                    if (this.var_aj_b.var_byte_a == 23) {
                        ad.ad_b();
                        if (ad.i()) {
                            this.var_aj_b.var_byte_a = (byte)25;
                        } else {
                            ad.ad_b();
                            if (ad.g()) {
                                this.var_aj_b.var_byte_a = (byte)24;
                            }
                        }
                        ad.ad_b();
                        ad.void_c();
                        return;
                    }
                    if (this.var_aj_b.var_byte_a == 11) {
                        ad.ad_b();
                        if (ad.g()) {
                            this.var_ak_b.var_byte_k = 0;
                        }
                        if (this.var_ak_b.var_byte_k == 0) {
                            this.var_aj_b.var_byte_a = 0;
                        }
                        return;
                    }
                    if (this.var_aj_b.var_byte_a != 20) break block94;
                    at at6 = this;
                    ad.ad_b();
                    if (ad.boolean_b()) break block96;
                    ad.ad_b();
                    if (ad.e()) {
                        ad.ad_b();
                        at6.B = ad.byte_b((int)at6.B, 0, 4);
                        return;
                    }
                    ad.ad_b();
                    if (ad.g()) {
                        if (!at6.boolean_c(at6.B)) {
                            at6.var_ak_b.b("Kh\u00f4ng gi\u00e0nh \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt c\u01b0\u1ee1i", 0);
                        } else if (at6.B == 4) {
                            at6.var_ak_b.b("Ch\u1ec9 s\u1eed d\u1ee5ng \u0111\u01b0\u1ee3c khi \u1edf trong n\u01b0\u1edbc", 0);
                        } else {
                            at6.var_byte_c = at6.var_byte_c == at6.B ? (byte)-1 : at6.B;
                            if (at6.var_byte_c == 3 && at6.var_ak_b.var_byte_arr_arr_m[0] == false) {
                                ar.b(at6.var_ak_b).b(1, true);
                                at6.var_byte_c = (byte)-1;
                            } else {
                                if (at6.var_byte_c == 3 && at6.var_ak_b.var_byte_arr_arr_m[0] < 0) {
                                    at6.var_ak_b.var_byte_arr_arr_m[0] = (byte[])((byte)(at6.var_ak_b.var_byte_arr_arr_m[0] + true));
                                    at6.var_ak_b.b("D\u1ecb th\u00fa kh\u00f4ng ch\u1ec9 c\u00f3 kh\u1ea3 n\u0103ng ch\u1ea1y tr\u1ed1n nhanh m\u00e0 c\u00f2n c\u00f3 th\u1ec3 kh\u00f4ng g\u1eb7p \u0111\u1ecbch, b\u1ea1n c\u00f3 3 l\u1ea7n c\u01b0\u1ee1i th\u1eed tr\u01b0\u1edbc khi mua!", -1);
                                }
                                at6.var_ak_b.var_byte_m = (byte)13;
                                at6.var_ak_b.var_int_d = at6.var_int_c + at6.var_aj_b.var_short_b + 10;
                                at6.var_ak_b.var_int_h = at6.var_int_a + at6.var_aj_b.var_short_c + 19;
                                at6.var_ak_b.void_g(at6.var_ak_b.var_byte_m / 5);
                                at6.var_aj_b.var_byte_a = (byte)21;
                            }
                        }
                        ad.ad_b();
                        ad.void_c();
                        return;
                    }
                    ad.ad_b();
                    if (ad.i()) break block97;
                    ad.ad_b();
                    if (!ad.m()) break block96;
                }
                at6.var_aj_b.var_byte_a = 0;
                ad.ad_b();
                ad.void_c();
            }
            return;
        }
        if (this.var_aj_b.var_byte_a == 1) {
            ad.ad_b();
            if (ad.g()) {
                if (this.var_byte_d + 2 >= this.var_java_lang_StringBuffer_arr_b.length) {
                    this.var_byte_d = (byte)-1;
                    this.var_java_lang_StringBuffer_arr_b = null;
                    if (this.var_byte_g == 0) {
                        this.var_aj_b.var_byte_a = 0;
                    } else {
                        this.var_byte_g = (byte)2;
                    }
                    if (this.var_boolean_a) {
                        this.var_aj_arr_arr_b[0][this.var_byte_k].var_byte_arr_b[7] = this.A;
                        if (this.var_aj_arr_arr_b[0][this.var_byte_k].var_byte_arr_b[7] >= 0) {
                            this.var_aj_arr_arr_b[0][this.var_byte_k].n = (byte)3;
                        }
                        this.var_boolean_a = false;
                    }
                    return;
                }
                this.var_byte_d = (byte)(this.var_byte_d + 2);
                ad.ad_b();
                ad.void_c();
            }
        }
        if (this.var_aj_b.var_byte_b > 0) {
            return;
        }
        if (this.var_aj_b.var_byte_a == 0 && ak.var_int_a != 98) {
            ad.ad_b();
            if (ad.f()) {
                this.var_ak_b.void_d(0);
            } else {
                ad.ad_b();
                if (ad.i()) {
                    ar.b(this.var_ak_b).b(0, true);
                }
            }
        }
        if (this.var_aj_b.var_byte_a != 0) {
            return;
        }
        ad.ad_b();
        this.var_byte_i = (byte)(-ad.e);
        at at7 = this;
        switch (at7.var_byte_i) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                if (at7.var_aj_b.n != at7.var_byte_i) {
                    byte by = at7.var_byte_i;
                    at at8 = at7;
                    at7.var_aj_b.n = by;
                    at8.var_aj_b.b(true);
                }
                at7.d(at7.var_byte_arr_arr_h[at7.var_byte_i][0] * at7.var_aj_b.g, at7.var_byte_arr_arr_h[at7.var_byte_i][1] * at7.var_aj_b.g);
                return;
            }
            case -53: 
            case 5: {
                at7.byte_b(at7.var_aj_b.var_short_b, (int)at7.var_aj_b.var_short_c, at7.var_byte_arr_arr_h[at7.var_aj_b.n][0] * at7.var_aj_b.g, at7.var_byte_arr_arr_h[at7.var_aj_b.n][1] * at7.var_aj_b.g);
                return;
            }
            case -57: {
                boolean bl;
                ad.ad_b();
                ad.void_c();
                if (at7.var_ak_b.var_byte_arr_arr_l[2] <= 0) break;
                at at9 = at7;
                if (at9.boolean_b((int)at9.var_aj_b.var_short_b, (int)at9.var_aj_b.var_short_c, (int)at9.var_byte_c)) {
                    at9.var_ak_b.b("Kh\u00f4ng th\u1ec3 thay T\u1ecda K\u1ef5", 0);
                    bl = false;
                } else {
                    at9.var_aj_b.var_byte_a = (byte)20;
                    at9.var_ak_b.s = (byte[])false;
                    at9.var_ak_b.r = (byte[])false;
                    at9.var_ak_b.b("Ng\u1ed3i xu\u1ed1ng T\u1ecda K\u1ef5#nTh\u1ef1c V\u1eadt T\u1ecda K\u1ef5#nKim Lo\u1ea1i T\u1ecda K\u1ef5#nPhi H\u00e0nh T\u1ecda K\u1ef5#nD\u00e3 th\u00fa T\u1ecda K\u1ef5#nH\u1ea3i D\u01b0\u01a1ng T\u1ecda K\u1ef5#nKh\u00f4ng T\u1ecda K\u1ef5", 240, 0);
                    bl = true;
                }
                return;
            }
            case -55: {
                return;
            }
            case -51: {
                at7.b(1, false);
                return;
            }
            case -49: {
                at7.b(0, false);
                return;
            }
            case -48: {
                at7.G();
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void w() {
        ad.ad_b();
        this.var_ak_b.s = (byte[])((byte)ad.b((int)this.var_ak_b.s, 52, 8, false));
        ah.ah_b();
        ah.h(0, 320 - this.var_ak_b.s, 76, 24, 2);
        ah.ah_b();
        ah.b(0, 344 - this.var_ak_b.s, 240, 28);
        for (var1_1 = 0; var1_1 < 5; var1_1 = (byte)(var1_1 + 1)) {
            block4: {
                if (this.boolean_c(var1_1)) break block4;
                var3_3 = 6;
                v0 = var1_1 + 70;
                ** GOTO lbl21
            }
            var3_3 = (byte)(var1_1 == this.B);
            if (var1_1 == this.var_byte_c) {
                var2_2 = (byte)69;
            } else {
                v0 = var1_1 == this.B ? var1_1 + 5 : (int)var1_1;
lbl21:
                // 2 sources

                var2_2 = (byte)v0;
            }
            ah.ah_b();
            ah.d(32 + var1_1 * 240 / 6, 348 - this.var_ak_b.s, 20, 20, var3_3);
            ah.ah_b().a(var2_2, 32 + var1_1 * 240 / 6 + 10, 348 - this.var_ak_b.s + 18, 33, 0);
        }
        var2_2 = this.B == this.var_byte_c ? 0 : (byte)(this.boolean_c(this.B) != false ? this.B + 1 : 6);
        ah.ah_b();
        ah.b(this.var_ak_b.var_int_c[var2_2].toString(), 38, 320 - this.var_ak_b.s, 17, 1, 2);
        ah.ah_b();
        ah.c(31 + this.B * 240 / 6 + this.var_ak_b.r / 3, 347 - this.var_ak_b.s + this.var_ak_b.r / 3, 22 - (this.var_ak_b.r / 3 << 1), 22 - (this.var_ak_b.r / 3 << 1));
        v1 = this.var_ak_b;
        v1.r = (byte[])((byte)(v1.r + true));
        if (v1.r > 4) {
            this.var_ak_b.r = (byte[])false;
        }
        ah.ah_b().b(true, true);
    }

    private void x() {
        block14: {
            block13: {
                ad.ad_b();
                if (ad.boolean_b()) {
                    return;
                }
                ad.ad_b();
                if (ad.e()) {
                    ad.ad_b();
                    this.B = ad.byte_b((int)this.B, 0, 4);
                    return;
                }
                ad.ad_b();
                if (ad.g()) {
                    if (!this.boolean_c(this.B)) {
                        this.var_ak_b.b("Kh\u00f4ng gi\u00e0nh \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt c\u01b0\u1ee1i", 0);
                    } else if (this.B == 4) {
                        this.var_ak_b.b("Ch\u1ec9 s\u1eed d\u1ee5ng \u0111\u01b0\u1ee3c khi \u1edf trong n\u01b0\u1edbc", 0);
                    } else {
                        this.var_byte_c = this.var_byte_c == this.B ? (byte)-1 : this.B;
                        if (this.var_byte_c == 3 && this.var_ak_b.var_byte_arr_arr_m[0] == false) {
                            ar.b(this.var_ak_b).b(1, true);
                            this.var_byte_c = (byte)-1;
                        } else {
                            if (this.var_byte_c == 3 && this.var_ak_b.var_byte_arr_arr_m[0] < 0) {
                                this.var_ak_b.var_byte_arr_arr_m[0] = (byte[])((byte)(this.var_ak_b.var_byte_arr_arr_m[0] + true));
                                this.var_ak_b.b("D\u1ecb th\u00fa kh\u00f4ng ch\u1ec9 c\u00f3 kh\u1ea3 n\u0103ng ch\u1ea1y tr\u1ed1n nhanh m\u00e0 c\u00f2n c\u00f3 th\u1ec3 kh\u00f4ng g\u1eb7p \u0111\u1ecbch, b\u1ea1n c\u00f3 3 l\u1ea7n c\u01b0\u1ee1i th\u1eed tr\u01b0\u1edbc khi mua!", -1);
                            }
                            this.var_ak_b.var_byte_m = (byte)13;
                            this.var_ak_b.var_int_d = this.var_int_c + this.var_aj_b.var_short_b + 10;
                            this.var_ak_b.var_int_h = this.var_int_a + this.var_aj_b.var_short_c + 19;
                            this.var_ak_b.void_g(this.var_ak_b.var_byte_m / 5);
                            this.var_aj_b.var_byte_a = (byte)21;
                        }
                    }
                    ad.ad_b();
                    ad.void_c();
                    return;
                }
                ad.ad_b();
                if (ad.i()) break block13;
                ad.ad_b();
                if (!ad.m()) break block14;
            }
            this.var_aj_b.var_byte_a = 0;
            ad.ad_b();
            ad.void_c();
        }
    }

    /*
     * Unable to fully structure code
     */
    private boolean boolean_b() {
        block11: {
            block12: {
                block8: {
                    block10: {
                        block9: {
                            block7: {
                                var4_1 = this.var_byte_c;
                                var3_2 = this.var_aj_b.var_short_c;
                                var2_3 = this.var_aj_b.var_short_b;
                                var1_4 = this;
                                if (var4_1 != 0) break block7;
                                var4_1 = 3;
                                break block8;
                            }
                            if (var4_1 != 2) break block9;
                            var4_1 = 4;
                            break block8;
                        }
                        if (var4_1 == 4) break block10;
                        v0 = false;
                        break block11;
                    }
                    var4_1 = 2;
                }
                var5_5 = 0;
                if (var2_3 % 20 != 0) {
                    var5_5 = 1;
                }
                if (var3_2 % 20 != 0) {
                    var5_5 = (byte)(var5_5 + 1);
                }
                v1 = (byte)(1 << var5_5);
                var5_5 = v1;
                if (v1 != 4 || var1_4.var_short_arr_arr_a[(var2_3 + 19) / 20][var3_2 / 20] != var4_1) break block12;
                v0 = true;
                break block11;
            }
            if (var5_5 <= 1) ** GOTO lbl-1000
            if (var2_3 % 20 != 0 && var1_4.var_short_arr_arr_a[(var2_3 + 19) / 20][(var3_2 + 19) / 20] == var4_1) {
                v0 = true;
            } else if (var3_2 % 20 != 0 && var1_4.var_short_arr_arr_a[var2_3 / 20][var3_2 / 20] == var4_1) {
                v0 = true;
            } else lbl-1000:
            // 2 sources

            {
                v0 = var1_4.var_short_arr_arr_a[var2_3 / 20][var3_2 / 20] == var4_1;
            }
        }
        if (v0) {
            this.var_ak_b.b("Kh\u00f4ng th\u1ec3 thay T\u1ecda K\u1ef5", 0);
            return false;
        }
        this.var_aj_b.var_byte_a = (byte)20;
        this.var_ak_b.s = (byte[])false;
        this.var_ak_b.r = (byte[])false;
        this.var_ak_b.b("Ng\u1ed3i xu\u1ed1ng T\u1ecda K\u1ef5#nTh\u1ef1c V\u1eadt T\u1ecda K\u1ef5#nKim Lo\u1ea1i T\u1ecda K\u1ef5#nPhi H\u00e0nh T\u1ecda K\u1ef5#nD\u00e3 th\u00fa T\u1ecda K\u1ef5#nH\u1ea3i D\u01b0\u01a1ng T\u1ecda K\u1ef5#nKh\u00f4ng T\u1ecda K\u1ef5", 240, 0);
        return true;
    }

    private boolean boolean_c(int n2) {
        return (this.var_ak_b.var_byte_arr_arr_l[2] & 1 << n2) != 0;
    }

    public final void void_b(int n2) {
        if (n2 != 13 && n2 != 34 && n2 != 49 && n2 != 66 && n2 != 82) {
            return;
        }
        n2 = n2 == 13 ? 0 : (n2 == 34 ? 1 : (n2 == 49 ? 2 : (n2 == 66 ? 3 : 4)));
        this.var_ak_b.var_byte_arr_arr_l[2] = (byte[])((byte)(this.var_ak_b.var_byte_arr_arr_l[2] | 1 << n2));
    }

    public final void g() {
        this.var_ak_b.var_byte_b = (byte)(this.var_byte_c == 3 ? 1 : 0);
        this.var_aj_b.g = this.byte_b();
        ad.ad_b().b(var_am_arr_arr_b[1][0], "data/npc1/" + (this.var_byte_c == -1 ? "0" : "r" + this.var_byte_c), this.var_byte_c == -1);
        this.var_aj_b.b(false);
    }

    private byte byte_b() {
        if (this.var_byte_c == 0) {
            return 6;
        }
        if (this.var_byte_c == 1) {
            return 6;
        }
        if (this.var_byte_c == 2) {
            return 10;
        }
        if (this.var_byte_c == 4) {
            return 5;
        }
        if (this.var_byte_c == 3) {
            return 10;
        }
        return 5;
    }

    /*
     * Unable to fully structure code
     */
    private void y() {
        switch (this.var_byte_i) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                if (this.var_aj_b.n != this.var_byte_i) {
                    var2_1 = this.var_byte_i;
                    var1_3 = this;
                    this.var_aj_b.n = (byte)var2_1;
                    var1_3.var_aj_b.b(true);
                }
                var3_5 = this.var_byte_arr_arr_h[this.var_byte_i][1] * this.var_aj_b.g;
                var2_1 = this.var_byte_arr_arr_h[this.var_byte_i][0] * this.var_aj_b.g;
                var1_3 = this;
                this.var_aj_b.e = (byte)var2_1;
                var1_3.var_aj_b.d = (byte)var3_5;
                if (var1_3.var_aj_b.var_short_b + var1_3.var_aj_b.e < 0 || var1_3.var_aj_b.var_short_b + var1_3.var_aj_b.e + 19 >= var1_3.var_short_b * 20 || var1_3.var_aj_b.var_short_c + var1_3.var_aj_b.d < 0 || var1_3.var_aj_b.var_short_c + var1_3.var_aj_b.d + 19 >= var1_3.var_short_c * 20) ** GOTO lbl93
                var1_3.F = var1_3.byte_c(var1_3.var_aj_b.var_short_b, var1_3.var_aj_b.var_short_c, var1_3.var_aj_b.e, var1_3.var_aj_b.d);
                if (var1_3.F == 0) {
                    var1_3.S();
                    return;
                }
                if (var1_3.boolean_a(var1_3.D)) {
                    var1_3.S();
                    return;
                }
                if (var1_3.D == -1) ** GOTO lbl40
                var4_7 = var1_3;
                if (var4_7.D < 0) ** GOTO lbl-1000
                if (var4_7.var_aj_b.e == 0) ** GOTO lbl31
                ad.ad_b();
                var5_9 = 20 - ad.a(var4_7.var_aj_b.var_short_c - var4_7.var_aj_arr_arr_b[0][var4_7.D].var_short_c);
                if (var5_9 <= 0 || var5_9 >= 11) ** GOTO lbl-1000
                v0 = true;
                ** GOTO lbl39
lbl31:
                // 1 sources

                if (var4_7.var_aj_b.d == 0) ** GOTO lbl-1000
                ad.ad_b();
                var5_9 = 20 - ad.a(var4_7.var_aj_b.var_short_b - var4_7.var_aj_arr_arr_b[0][var4_7.D].var_short_b);
                if (var5_9 > 0 && var5_9 < 11) {
                    v0 = true;
                } else lbl-1000:
                // 4 sources

                {
                    v0 = false;
                }
lbl39:
                // 3 sources

                if (!v0) ** GOTO lbl88
lbl40:
                // 2 sources

                var5_9 = var1_3.F;
                var4_7 = var1_3;
                var6_11 = 0;
                var2_1 = 0;
                var3_5 = (byte)(var4_7.var_aj_b.var_short_b / 20);
                var7_13 = var4_7.var_aj_b.var_short_c / 20;
                if (var4_7.var_aj_b.e == 0) {
                    var6_11 = var4_7.byte_c((var3_5 - (var4_7.var_aj_b.var_short_b % 20 != 0 ? 0 : 1)) * 20, (var7_13 + (var4_7.var_aj_b.d >= 0 ? 1 : -1)) * 20, 0, 0);
                    var2_1 = var4_7.byte_c((var3_5 + 1) * 20, (var7_13 + (var4_7.var_aj_b.d >= 0 ? 1 : -1)) * 20, 0, 0);
                } else if (var4_7.var_aj_b.d == 0) {
                    var6_11 = var4_7.byte_c((var3_5 + (var4_7.var_aj_b.e >= 0 ? 1 : -1)) * 20, (var7_13 - (var4_7.var_aj_b.var_short_c % 20 != 0 ? 0 : 1)) * 20, 0, 0);
                    var2_1 = var4_7.byte_c((var3_5 + (var4_7.var_aj_b.e >= 0 ? 1 : -1)) * 20, (var7_13 + 1) * 20, 0, 0);
                }
                if (var6_11 == 1 && var2_1 == 1) ** GOTO lbl-1000
                if (var6_11 == 0 && var4_7.byte_c((var4_7.var_aj_b.e == 0 ? var3_5 - (var4_7.var_aj_b.var_short_b % 20 != 0 ? 0 : 1) : var3_5) * 20, (var4_7.var_aj_b.d == 0 ? var7_13 - (var4_7.var_aj_b.var_short_c % 20 != 0 ? 0 : 1) : var7_13) * 20, 0, 0) == 0) {
                    v1 = -1;
                } else if (var2_1 == 0 && var4_7.byte_c((var4_7.var_aj_b.e == 0 ? var3_5 + (var4_7.var_aj_b.var_short_b % 20 != 0 ? 0 : 1) : var3_5) * 20, (var4_7.var_aj_b.d == 0 ? var7_13 + (var4_7.var_aj_b.var_short_c % 20 != 0 ? 0 : 1) : var7_13) * 20, 0, 0) == 0) {
                    v1 = -2;
                } else lbl-1000:
                // 2 sources

                {
                    v1 = var1_3.F = var5_9;
                }
                if (var1_3.F == -1) {
                    var1_3.b((byte)3, (byte)1, (int)(-var1_3.var_aj_b.g));
                    return;
                }
                if (var1_3.F == -2) {
                    var1_3.b((byte)4, (byte)2, (int)var1_3.var_aj_b.g);
                    return;
                }
                var4_7 = var1_3;
                var1_3.C = var4_7.byte_b(var4_7.var_aj_b.var_short_b, (int)var4_7.var_aj_b.var_short_c, (int)var4_7.var_aj_b.e, (int)var4_7.var_aj_b.d, true);
                if (var4_7.C != 2) ** GOTO lbl72
                if (!var4_7.boolean_e(4)) ** GOTO lbl-1000
                ** GOTO lbl98
lbl72:
                // 1 sources

                if (var4_7.C != 3) ** GOTO lbl75
                if (!var4_7.boolean_e(0)) ** GOTO lbl-1000
                ** GOTO lbl98
lbl75:
                // 1 sources

                if (var4_7.C != 4) ** GOTO lbl78
                if (!var4_7.boolean_e(2)) ** GOTO lbl-1000
                ** GOTO lbl98
lbl78:
                // 1 sources

                if (var4_7.C == 0 && var4_7.var_byte_c == 4) {
                    var4_7.var_byte_c = var4_7.var_byte_c != 3 && var4_7.boolean_c(3) != false ? (byte)3 : (byte)-1;
                    var4_7.g();
                    var4_7.S();
                } else lbl-1000:
                // 4 sources

                {
                    ad.ad_b();
                    ad.void_c();
                    var4_7.C();
                    return;
lbl88:
                    // 1 sources

                    ad.ad_b();
                    ad.void_c();
                    var1_3.C();
                    return;
lbl93:
                    // 1 sources

                    var1_3.C();
                    var1_3.C = at.b(var1_3.var_byte_arr_arr_c, (int)var1_3.var_aj_b.var_short_b, (int)var1_3.var_aj_b.var_short_c);
                    if (var1_3.C != -1 && var1_3.var_byte_arr_arr_c[var1_3.C][5] == 0 && var1_3.var_byte_i == var1_3.var_byte_arr_arr_c[var1_3.C][2]) {
                        var1_3.var_aj_b.var_byte_a = (byte)5;
                        var1_3.var_byte_k = var1_3.C;
                    }
                }
lbl98:
                // 7 sources

                return;
            }
            case -53: 
            case 5: {
                var5_10 = this.var_byte_arr_arr_h[this.var_aj_b.n][1] * this.var_aj_b.g;
                var4_8 = this.var_byte_arr_arr_h[this.var_aj_b.n][0] * this.var_aj_b.g;
                var3_6 = this.var_aj_b.var_short_c;
                var2_2 = this.var_aj_b.var_short_b;
                var1_4 = this;
                if (var2_2 + var4_8 < 0 || var2_2 + var4_8 >= var1_4.var_short_b * 20 || var3_6 + var5_10 < 0 || var3_6 + var5_10 >= var1_4.var_short_c * 20) {
                    v2 = 0;
                } else {
                    var6_12 = at.b(var1_4.var_aj_arr_arr_b[0], var2_2 + var4_8, var3_6 + var5_10);
                    if (var1_4.var_aj_b.var_byte_a == 0 && var6_12 != -1) {
                        if (var1_4.var_byte_c == 1 && var1_4.var_aj_arr_arr_b[0][var6_12].var_byte_arr_b[8] == 4) {
                            var1_4.var_aj_arr_arr_b[0][var6_12].var_byte_arr_b[8] = -4;
                            var1_4.var_aj_arr_arr_b[0][var6_12].var_byte_arr_b[7] = (byte)(var1_4.var_aj_arr_arr_b[0][var6_12].var_byte_arr_b[7] + 1);
                            var1_4.var_aj_arr_arr_b[0][var6_12].o = 0;
                            var1_4.var_aj_arr_arr_b[0][var6_12].p = 0;
                        } else if (var1_4.var_aj_arr_arr_b[0][var6_12].var_byte_arr_b[8] != -4) {
                            var1_4.var_aj_b.var_byte_a = (byte)2;
                            var1_4.var_byte_k = var6_12;
                            if (var1_4.var_aj_arr_arr_b[0][var6_12].var_byte_arr_b[8] != 2 && var1_4.var_aj_arr_arr_b[0][var6_12].var_byte_arr_b[8] != 3 && !var1_4.var_java_lang_String_arr_c[var6_12].equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng")) {
                                var1_4.var_boolean_a = true;
                                var1_4.A = var1_4.var_aj_arr_arr_b[0][var6_12].var_byte_arr_b[7];
                                v3 = var1_4.var_aj_arr_arr_b[0][var6_12].var_byte_arr_b;
                                ad.ad_b();
                                v3[7] = (byte)(ad.a(var1_4.A) / 3 * 3 + (var1_4.var_aj_b.n < 4 ? var1_4.var_aj_b.n - 1 : var1_4.var_aj_b.n - 2));
                                if (var1_4.var_aj_b.n == 3) {
                                    var1_4.var_aj_arr_arr_b[0][var6_12].var_byte_arr_b[7] = -var1_4.var_aj_arr_arr_b[0][var6_12].var_byte_arr_b[7];
                                } else {
                                    var1_4.var_aj_arr_arr_b[0][var6_12].n = (byte)3;
                                }
                            } else {
                                var1_4.var_boolean_a = false;
                            }
                        }
                        v2 = 9;
                    } else {
                        var6_12 = at.b(var1_4.var_byte_arr_arr_a, var2_2 + var4_8, var3_6 + var5_10);
                        if (var6_12 != -1 && var1_4.var_byte_arr_arr_a[var6_12][2] != -1) {
                            ad.ad_b();
                            ad.void_c();
                            var1_4.var_byte_k = var6_12;
                            var1_4.z();
                            v2 = 0;
                        } else {
                            v2 = -1;
                        }
                    }
                }
                return;
            }
            case -57: {
                ad.ad_b();
                ad.void_c();
                if (this.var_ak_b.var_byte_arr_arr_l[2] <= 0) break;
                this.boolean_b();
                return;
            }
            case -55: {
                return;
            }
            case -51: {
                this.b(1, false);
                return;
            }
            case -49: {
                this.b(0, false);
                return;
            }
            case -48: {
                this.G();
            }
        }
    }

    private void k(int n2) {
        this.var_aj_b.n = (byte)n2;
        this.var_aj_b.b(true);
    }

    private void void_c(int n2, int n3, int n4, int n5) {
        if (n4 > 0 && n2 >= this.var_short_d && n2 < this.var_short_h || n4 < 0 && n2 > this.var_short_d && n2 <= this.var_short_h) {
            this.var_int_c -= n4;
        }
        if (n5 > 0 && n3 >= this.var_short_g && n3 < this.var_short_f || n5 < 0 && n3 > this.var_short_g && n3 <= this.var_short_f) {
            this.var_int_a -= n5;
        }
    }

    private void void_b(aj aj2, int n2) {
        if (aj2.var_byte_b > 0) {
            if (this.var_byte_j == n2) {
                byte by = aj2.d;
                byte by2 = aj2.e;
                short s2 = aj2.var_short_c;
                short s3 = aj2.var_short_b;
                at at2 = this;
                if (by2 > 0 && s3 >= at2.var_short_d && s3 < at2.var_short_h || by2 < 0 && s3 > at2.var_short_d && s3 <= at2.var_short_h) {
                    at2.var_int_c -= by2;
                }
                if (by > 0 && s2 >= at2.var_short_g && s2 < at2.var_short_f || by < 0 && s2 > at2.var_short_g && s2 <= at2.var_short_f) {
                    at2.var_int_a -= by;
                }
            }
            aj2.var_short_b = (short)(aj2.var_short_b + aj2.e);
            aj2.var_short_c = (short)(aj2.var_short_c + aj2.d);
            aj2.var_byte_b = (byte)(aj2.var_byte_b - 1);
            return;
        }
        if (aj2.var_byte_b != -1) {
            aj2.var_byte_b = (byte)-1;
            aj2.b(false);
        }
    }

    private static byte b(aj[] ajArray, int n2, int n3) {
        for (byte by = (byte)(ajArray.length - 1); by >= 0; by = (byte)(by - 1)) {
            ad.ad_b();
            if (!ad.b(n2, n3, 19, 19, ajArray[by].var_short_b, ajArray[by].var_short_c, 20, 20) || ajArray[by].var_byte_arr_b[4] != 1 && ajArray[by].var_byte_arr_b[4] != 3) continue;
            return by;
        }
        return -1;
    }

    private static byte b(byte[][] byArray, int n2, int n3) {
        for (byte by = (byte)(byArray.length - 1); by >= 0; by = (byte)(by - 1)) {
            ad.ad_b();
            if (!ad.b(n2, n3, 19, 19, byArray[by][0] * 20, byArray[by][1] * 20, 20, 20)) continue;
            return by;
        }
        return -1;
    }

    private byte byte_b(int n2, int n3, int n4, int n5) {
        if (n2 + n4 < 0 || n2 + n4 >= this.var_short_b * 20 || n3 + n5 < 0 || n3 + n5 >= this.var_short_c * 20) {
            return 0;
        }
        byte by = at.b(this.var_aj_arr_arr_b[0], n2 + n4, n3 + n5);
        if (this.var_aj_b.var_byte_a == 0 && by != -1) {
            if (this.var_byte_c == 1 && this.var_aj_arr_arr_b[0][by].var_byte_arr_b[8] == 4) {
                this.var_aj_arr_arr_b[0][by].var_byte_arr_b[8] = -4;
                this.var_aj_arr_arr_b[0][by].var_byte_arr_b[7] = (byte)(this.var_aj_arr_arr_b[0][by].var_byte_arr_b[7] + 1);
                this.var_aj_arr_arr_b[0][by].o = 0;
                this.var_aj_arr_arr_b[0][by].p = 0;
            } else if (this.var_aj_arr_arr_b[0][by].var_byte_arr_b[8] != -4) {
                this.var_aj_b.var_byte_a = (byte)2;
                this.var_byte_k = by;
                if (this.var_aj_arr_arr_b[0][by].var_byte_arr_b[8] != 2 && this.var_aj_arr_arr_b[0][by].var_byte_arr_b[8] != 3 && !this.var_java_lang_String_arr_c[by].equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng")) {
                    this.var_boolean_a = true;
                    this.A = this.var_aj_arr_arr_b[0][by].var_byte_arr_b[7];
                    byte[] byArray = this.var_aj_arr_arr_b[0][by].var_byte_arr_b;
                    ad.ad_b();
                    byArray[7] = (byte)(ad.a(this.A) / 3 * 3 + (this.var_aj_b.n < 4 ? this.var_aj_b.n - 1 : this.var_aj_b.n - 2));
                    if (this.var_aj_b.n == 3) {
                        this.var_aj_arr_arr_b[0][by].var_byte_arr_b[7] = -this.var_aj_arr_arr_b[0][by].var_byte_arr_b[7];
                    } else {
                        this.var_aj_arr_arr_b[0][by].n = (byte)3;
                    }
                } else {
                    this.var_boolean_a = false;
                }
            }
            return 9;
        }
        by = at.b(this.var_byte_arr_arr_a, n2 + n4, n3 + n5);
        if (by != -1 && this.var_byte_arr_arr_a[by][2] != -1) {
            ad.ad_b();
            ad.void_c();
            this.var_byte_k = by;
            at at2 = this;
            if (at2.var_byte_arr_arr_a[at2.var_byte_k][2] == 2) {
                at2.var_ak_b.b("B\u1ea3o r\u01b0\u01a1ng n\u00e0y tr\u1ed1ng kh\u00f4ng.", 0);
            } else {
                byte by2 = (byte)(at2.var_byte_arr_arr_a[at2.var_byte_k][3] - 2);
                n3 = by2;
                if (by2 == -2) {
                    at2.var_ak_b.var_int_b += at2.var_byte_arr_arr_a[at2.var_byte_k][4] * 100;
                    at2.var_ak_b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c kim ti\u1ec1n: " + at2.var_byte_arr_arr_a[at2.var_byte_k][4] * 100 + "Kim", 0);
                } else if (n3 == -1) {
                    at2.var_ak_b.var_int_c += at2.var_byte_arr_arr_a[at2.var_byte_k][4];
                    at2.var_ak_b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c huy ch\u01b0\u01a1ng: " + at2.var_byte_arr_arr_a[at2.var_byte_k][4] + "Huy ch\u01b0\u01a1ng", 0);
                } else {
                    at2.var_ak_b.byte_a(n3, at2.var_byte_arr_arr_a[at2.var_byte_k][4]);
                }
                at2.var_byte_arr_arr_a[at2.var_byte_k][2] = 2;
            }
            return 0;
        }
        return -1;
    }

    private void z() {
        if (this.var_byte_arr_arr_a[this.var_byte_k][2] == 2) {
            this.var_ak_b.b("B\u1ea3o r\u01b0\u01a1ng n\u00e0y tr\u1ed1ng kh\u00f4ng.", 0);
            return;
        }
        byte by = (byte)(this.var_byte_arr_arr_a[this.var_byte_k][3] - 2);
        if (by == -2) {
            this.var_ak_b.var_int_b += this.var_byte_arr_arr_a[this.var_byte_k][4] * 100;
            this.var_ak_b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c kim ti\u1ec1n: " + this.var_byte_arr_arr_a[this.var_byte_k][4] * 100 + "Kim", 0);
        } else if (by == -1) {
            this.var_ak_b.var_int_c += this.var_byte_arr_arr_a[this.var_byte_k][4];
            this.var_ak_b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c huy ch\u01b0\u01a1ng: " + this.var_byte_arr_arr_a[this.var_byte_k][4] + "Huy ch\u01b0\u01a1ng", 0);
        } else {
            this.var_ak_b.byte_a(by, this.var_byte_arr_arr_a[this.var_byte_k][4]);
        }
        this.var_byte_arr_arr_a[this.var_byte_k][2] = 2;
    }

    private byte byte_c(int n2, int n3, int n4, int n5) {
        this.D = (byte)-1;
        this.C = at.b(this.var_byte_arr_arr_a, n2 + n4, n3 + n5);
        if (this.C != -1) {
            this.D = (byte)-2;
            return 1;
        }
        if (n2 + n4 < 0 || n2 + n4 >= this.var_short_b * 20 || n3 + n5 < 0 || n3 + n5 >= this.var_short_c * 20) {
            return 1;
        }
        this.C = at.b(this.var_aj_arr_arr_b[0], n2 + n4, n3 + n5);
        if (this.C != -1) {
            if (!this.var_java_lang_String_arr_c[this.C].equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng") || this.var_aj_arr_arr_b[0][this.C].var_byte_arr_b[5] > 0) {
                this.D = this.C;
            }
            return 1;
        }
        this.C = at.b(this.var_byte_arr_arr_c, n2 + n4, n3 + n5);
        if (this.C != -1 && (this.var_byte_arr_arr_c[this.C][5] == 2 || this.var_byte_i == this.var_byte_arr_arr_c[this.C][2])) {
            this.var_aj_b.var_byte_a = (byte)5;
            this.var_byte_k = this.C;
            return 0;
        }
        return this.byte_b(n2, n3, n4, n5, false);
    }

    private byte byte_b(int n2, int n3, int n4, int n5, boolean bl) {
        int n6 = 0;
        int n7 = 1;
        if (n4 == 0 && n2 % 20 != 0 || n5 == 0 && n3 % 20 != 0) {
            n7 = 2;
        }
        while (n6 < n7) {
            byte by;
            byte by2;
            if (n5 == 0) {
                by2 = (byte)((n3 + n6 * 20) / 20);
                by = (byte)(n4 >= 0 ? (n2 + n4 + 19) / 20 : (n2 + n4) / 20);
            } else {
                by = (byte)((n2 + n6 * 20) / 20);
                by2 = (byte)(n5 >= 0 ? (n3 + n5 + 19) / 20 : (n3 + n5) / 20);
            }
            if (bl) {
                if (this.var_short_arr_arr_a[by][by2] != 0) {
                    return (byte)this.var_short_arr_arr_a[by][by2];
                }
            } else {
                byte by3 = by2;
                by2 = by;
                at at2 = this;
                boolean bl2 = at2.var_short_arr_arr_a[by2][by3] == 1 ? true : (at2.var_byte_c == 0 ? at2.var_short_arr_arr_a[by2][by3] == 2 || at2.var_short_arr_arr_a[by2][by3] == 4 : (at2.var_byte_c == 2 ? at2.var_short_arr_arr_a[by2][by3] == 3 || at2.var_short_arr_arr_a[by2][by3] == 2 : (at2.var_byte_c == 4 ? at2.var_short_arr_arr_a[by2][by3] != 2 : at2.var_short_arr_arr_a[by2][by3] == 2 || at2.var_short_arr_arr_a[by2][by3] == 3 || at2.var_short_arr_arr_a[by2][by3] == 4)));
                if (bl2) {
                    return 1;
                }
            }
            n6 = (byte)(n6 + 1);
        }
        return 0;
    }

    private boolean boolean_b(int n2, int n3, int n4) {
        if (n4 == 0) {
            n4 = 3;
        } else if (n4 == 2) {
            n4 = 4;
        } else if (n4 == 4) {
            n4 = 2;
        } else {
            return false;
        }
        int n5 = 0;
        if (n2 % 20 != 0) {
            n5 = 1;
        }
        if (n3 % 20 != 0) {
            n5 = (byte)(n5 + 1);
        }
        byte by = (byte)(1 << n5);
        n5 = by;
        if (by == 4 && this.var_short_arr_arr_a[(n2 + 19) / 20][n3 / 20] == n4) {
            return true;
        }
        if (n5 > 1) {
            if (n2 % 20 != 0 && this.var_short_arr_arr_a[(n2 + 19) / 20][(n3 + 19) / 20] == n4) {
                return true;
            }
            if (n3 % 20 != 0 && this.var_short_arr_arr_a[n2 / 20][n3 / 20] == n4) {
                return true;
            }
        }
        return this.var_short_arr_arr_a[n2 / 20][n3 / 20] == n4;
    }

    private boolean boolean_c(int n2, int n3) {
        if (this.var_short_arr_arr_a[n2][n3] == 1) {
            return true;
        }
        if (this.var_byte_c == 0) {
            return this.var_short_arr_arr_a[n2][n3] == 2 || this.var_short_arr_arr_a[n2][n3] == 4;
        }
        if (this.var_byte_c == 2) {
            return this.var_short_arr_arr_a[n2][n3] == 3 || this.var_short_arr_arr_a[n2][n3] == 2;
        }
        if (this.var_byte_c == 4) {
            return this.var_short_arr_arr_a[n2][n3] != 2;
        }
        return this.var_short_arr_arr_a[n2][n3] == 2 || this.var_short_arr_arr_a[n2][n3] == 3 || this.var_short_arr_arr_a[n2][n3] == 4;
    }

    private void B() {
        if (this.var_short_i < this.var_short_j) {
            if (this.var_short_arr_arr_a[this.var_aj_b.byte_b()][this.var_aj_b.byte_c()] != 7) {
                this.var_short_i = (short)(this.var_short_i + 1);
                return;
            }
        } else {
            if (this.var_ak_b.var_byte_arr_c.length > 1 && this.var_ak_b.var_byte_b == 0) {
                this.var_aj_b.var_byte_b = 0;
                this.var_aj_b.var_byte_a = (byte)8;
            }
            this.void_b(0, 0);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void d(int var1_1, int var2_4) {
        block24: {
            block28: {
                block25: {
                    block27: {
                        block26: {
                            this.var_aj_b.e = (byte)var1_1;
                            this.var_aj_b.d = (byte)var2_4;
                            if (this.var_aj_b.var_short_b + this.var_aj_b.e < 0 || this.var_aj_b.var_short_b + this.var_aj_b.e + 19 >= this.var_short_b * 20 || this.var_aj_b.var_short_c + this.var_aj_b.d < 0 || this.var_aj_b.var_short_c + this.var_aj_b.d + 19 >= this.var_short_c * 20) break block24;
                            this.F = this.byte_c(this.var_aj_b.var_short_b, this.var_aj_b.var_short_c, this.var_aj_b.e, this.var_aj_b.d);
                            if (this.F == 0) {
                                this.S();
                                return;
                            }
                            if (this.boolean_a(this.D)) {
                                this.S();
                                return;
                            }
                            if (this.D == -1) break block25;
                            var1_2 = this;
                            if (var1_2.D < 0) ** GOTO lbl-1000
                            if (var1_2.var_aj_b.e == 0) break block26;
                            ad.ad_b();
                            v0 = (byte)(20 - ad.a(var1_2.var_aj_b.var_short_c - var1_2.var_aj_arr_arr_b[0][var1_2.D].var_short_c));
                            var2_4 = v0;
                            if (v0 <= 0 || var2_4 >= 11) ** GOTO lbl-1000
                            v1 = true;
                            break block27;
                        }
                        if (var1_2.var_aj_b.d == 0) ** GOTO lbl-1000
                        ad.ad_b();
                        v2 = (byte)(20 - ad.a(var1_2.var_aj_b.var_short_b - var1_2.var_aj_arr_arr_b[0][var1_2.D].var_short_b));
                        var2_4 = v2;
                        if (v2 > 0 && var2_4 < 11) {
                            v1 = true;
                        } else lbl-1000:
                        // 4 sources

                        {
                            v1 = false;
                        }
                    }
                    if (!v1) break block28;
                }
                var2_4 = this.F;
                var1_3 = this;
                var3_5 = 0;
                var4_6 = 0;
                var5_7 = var1_3.var_aj_b.var_short_b / 20;
                var6_8 = var1_3.var_aj_b.var_short_c / 20;
                if (var1_3.var_aj_b.e == 0) {
                    var3_5 = var1_3.byte_c((var5_7 - (var1_3.var_aj_b.var_short_b % 20 != 0 ? 0 : 1)) * 20, (var6_8 + (var1_3.var_aj_b.d >= 0 ? 1 : -1)) * 20, 0, 0);
                    var4_6 = var1_3.byte_c((var5_7 + 1) * 20, (var6_8 + (var1_3.var_aj_b.d >= 0 ? 1 : -1)) * 20, 0, 0);
                } else if (var1_3.var_aj_b.d == 0) {
                    var3_5 = var1_3.byte_c((var5_7 + (var1_3.var_aj_b.e >= 0 ? 1 : -1)) * 20, (var6_8 - (var1_3.var_aj_b.var_short_c % 20 != 0 ? 0 : 1)) * 20, 0, 0);
                    var4_6 = var1_3.byte_c((var5_7 + (var1_3.var_aj_b.e >= 0 ? 1 : -1)) * 20, (var6_8 + 1) * 20, 0, 0);
                }
                if (var3_5 == 1 && var4_6 == true) ** GOTO lbl-1000
                if (var3_5 == 0 && var1_3.byte_c((var1_3.var_aj_b.e == 0 ? var5_7 - (var1_3.var_aj_b.var_short_b % 20 != 0 ? 0 : 1) : var5_7) * 20, (var1_3.var_aj_b.d == 0 ? var6_8 - (var1_3.var_aj_b.var_short_c % 20 != 0 ? 0 : 1) : var6_8) * 20, 0, 0) == 0) {
                    v3 = -1;
                } else if (var4_6 == 0 && var1_3.byte_c((var1_3.var_aj_b.e == 0 ? var5_7 + (var1_3.var_aj_b.var_short_b % 20 != 0 ? 0 : 1) : var5_7) * 20, (var1_3.var_aj_b.d == 0 ? var6_8 + (var1_3.var_aj_b.var_short_c % 20 != 0 ? 0 : 1) : var6_8) * 20, 0, 0) == 0) {
                    v3 = -2;
                } else lbl-1000:
                // 2 sources

                {
                    v3 = var2_4;
                }
                this.F = (byte)v3;
                if (this.F == -1) {
                    this.b((byte)3, (byte)1, (int)(-this.var_aj_b.g));
                    return;
                }
                if (this.F == -2) {
                    this.b((byte)4, (byte)2, (int)this.var_aj_b.g);
                    return;
                }
                var1_3 = this;
                this.C = var1_3.byte_b(var1_3.var_aj_b.var_short_b, (int)var1_3.var_aj_b.var_short_c, (int)var1_3.var_aj_b.e, (int)var1_3.var_aj_b.d, true);
                if (var1_3.C == 2) {
                    if (var1_3.boolean_e(4)) {
                        return;
                    }
                } else if (var1_3.C == 3) {
                    if (var1_3.boolean_e(0)) {
                        return;
                    }
                } else if (var1_3.C == 4) {
                    if (var1_3.boolean_e(2)) {
                        return;
                    }
                } else if (var1_3.C == 0 && var1_3.var_byte_c == 4) {
                    var1_3.var_byte_c = var1_3.var_byte_c != 3 && var1_3.boolean_c(3) != false ? (byte)3 : (byte)-1;
                    var1_3.g();
                    var1_3.S();
                    return;
                }
                ad.ad_b();
                ad.void_c();
                var1_3.C();
                return;
            }
            ad.ad_b();
            ad.void_c();
            this.C();
            return;
        }
        this.C();
        this.C = at.b(this.var_byte_arr_arr_c, (int)this.var_aj_b.var_short_b, (int)this.var_aj_b.var_short_c);
        if (this.C != -1 && this.var_byte_arr_arr_c[this.C][5] == 0 && this.var_byte_i == this.var_byte_arr_arr_c[this.C][2]) {
            this.var_aj_b.var_byte_a = (byte)5;
            this.var_byte_k = this.C;
        }
    }

    private boolean boolean_c() {
        if (this.D < 0) {
            return false;
        }
        if (this.var_aj_b.e != 0) {
            ad.ad_b();
            byte by = (byte)(20 - ad.a(this.var_aj_b.var_short_c - this.var_aj_arr_arr_b[0][this.D].var_short_c));
            if (by > 0 && by < 11) {
                return true;
            }
        } else if (this.var_aj_b.d != 0) {
            ad.ad_b();
            byte by = (byte)(20 - ad.a(this.var_aj_b.var_short_b - this.var_aj_arr_arr_b[0][this.D].var_short_b));
            if (by > 0 && by < 11) {
                return true;
            }
        }
        return false;
    }

    private void b(byte by, byte by2, int n2) {
        if (this.var_aj_b.e == 0) {
            this.var_aj_b.n = by;
        } else if (this.var_aj_b.d == 0) {
            this.var_aj_b.n = by2;
        }
        this.var_aj_b.e = (byte)(this.var_aj_b.e != 0 ? 0 : n2);
        this.var_aj_b.d = (byte)(this.var_aj_b.d != 0 ? 0 : n2);
        this.boolean_a(this.D);
        this.S();
    }

    private boolean boolean_a(int n2) {
        if (n2 >= 0) {
            byte by = (byte)(this.var_aj_arr_arr_b[0][n2].var_short_b + 20 - this.var_aj_b.var_short_b);
            byte by2 = (byte)(this.var_aj_arr_arr_b[0][n2].var_short_b - this.var_aj_b.var_short_b - 20);
            byte by3 = (byte)(this.var_aj_arr_arr_b[0][n2].var_short_c + 20 - this.var_aj_b.var_short_c);
            n2 = (byte)(this.var_aj_arr_arr_b[0][n2].var_short_c - this.var_aj_b.var_short_c - 20);
            if (this.var_aj_b.e < 0 && by != 0) {
                this.var_aj_b.e = by < this.var_aj_b.e ? this.var_aj_b.e : by;
                return true;
            }
            if (this.var_aj_b.e > 0 && by2 != 0) {
                this.var_aj_b.e = by2 < this.var_aj_b.e ? by2 : this.var_aj_b.e;
                return true;
            }
            if (this.var_aj_b.d < 0 && by3 != 0) {
                this.var_aj_b.d = by3 < this.var_aj_b.d ? this.var_aj_b.d : by3;
                return true;
            }
            if (this.var_aj_b.d > 0 && n2 != 0) {
                this.var_aj_b.d = (byte)(n2 < this.var_aj_b.d ? n2 : (int)this.var_aj_b.d);
                return true;
            }
        } else {
            byte by = this.var_aj_b.a();
            byte by4 = (byte)(20 - this.var_aj_b.a());
            byte by5 = this.var_aj_b.e();
            n2 = (byte)(20 - this.var_aj_b.e());
            if (this.var_aj_b.e != 0 && by != 0) {
                byte by6;
                aj aj2;
                if (this.var_aj_b.e < 0) {
                    aj2 = this.var_aj_b;
                    by6 = -by < this.var_aj_b.e ? this.var_aj_b.e : -by;
                } else {
                    aj2 = this.var_aj_b;
                    by6 = by4 < this.var_aj_b.e ? by4 : this.var_aj_b.e;
                }
                aj2.e = by6;
                return true;
            }
            if (this.var_aj_b.d != 0 && by5 != 0) {
                byte by7;
                aj aj3;
                if (this.var_aj_b.d < 0) {
                    aj3 = this.var_aj_b;
                    by7 = -by5 < this.var_aj_b.d ? this.var_aj_b.d : -by5;
                } else {
                    aj3 = this.var_aj_b;
                    by7 = (byte)(n2 < this.var_aj_b.d ? n2 : (byte)this.var_aj_b.d);
                }
                aj3.d = by7;
                return true;
            }
        }
        return false;
    }

    private void A() {
        this.C = this.byte_b(this.var_aj_b.var_short_b, (int)this.var_aj_b.var_short_c, (int)this.var_aj_b.e, (int)this.var_aj_b.d, true);
        if (this.C == 2) {
            if (this.boolean_e(4)) {
                return;
            }
        } else if (this.C == 3) {
            if (this.boolean_e(0)) {
                return;
            }
        } else if (this.C == 4) {
            if (this.boolean_e(2)) {
                return;
            }
        } else if (this.C == 0 && this.var_byte_c == 4) {
            this.var_byte_c = this.var_byte_c != 3 && this.boolean_c(3) ? (byte)3 : (byte)-1;
            this.g();
            this.S();
            return;
        }
        ad.ad_b();
        ad.void_c();
        this.C();
    }

    private boolean boolean_e(int n2) {
        if (this.var_byte_c != n2 && this.boolean_c(n2)) {
            this.var_byte_c = (byte)n2;
            this.g();
            return true;
        }
        if (!this.boolean_c(n2)) {
            this.var_ak_b.b("Kh\u00f4ng c\u00f3" + this.var_ak_b.var_java_lang_StringBuffer_arr_b[n2] + "T\u1ecda K\u1ef5, Kh\u00f4ng th\u1ec3 \u0111i qua", -1);
        }
        return false;
    }

    private void C() {
        this.var_aj_b.e = 0;
        this.var_aj_b.d = 0;
        this.var_aj_b.var_byte_b = (byte)-1;
        this.var_aj_b.b(false);
    }

    private byte b(byte by) {
        byte by2 = 0;
        byte by3 = 0;
        int n2 = this.var_aj_b.var_short_b / 20;
        int n3 = this.var_aj_b.var_short_c / 20;
        if (this.var_aj_b.e == 0) {
            by2 = this.byte_c((n2 - (this.var_aj_b.var_short_b % 20 != 0 ? (byte)0 : 1)) * 20, (n3 + (this.var_aj_b.d >= 0 ? 1 : -1)) * 20, 0, 0);
            by3 = this.byte_c((n2 + 1) * 20, (n3 + (this.var_aj_b.d >= 0 ? 1 : -1)) * 20, 0, 0);
        } else if (this.var_aj_b.d == 0) {
            by2 = this.byte_c((n2 + (this.var_aj_b.e >= 0 ? 1 : -1)) * 20, (n3 - (this.var_aj_b.var_short_c % 20 != 0 ? (byte)0 : 1)) * 20, 0, 0);
            by3 = this.byte_c((n2 + (this.var_aj_b.e >= 0 ? 1 : -1)) * 20, (n3 + 1) * 20, 0, 0);
        }
        if (by2 == 1 && by3 == 1) {
            return by;
        }
        if (by2 == 0 && this.byte_c((this.var_aj_b.e == 0 ? n2 - (this.var_aj_b.var_short_b % 20 != 0 ? (byte)0 : 1) : n2) * 20, (this.var_aj_b.d == 0 ? n3 - (this.var_aj_b.var_short_c % 20 != 0 ? (byte)0 : 1) : n3) * 20, 0, 0) == 0) {
            return -1;
        }
        if (by3 == 0 && this.byte_c((this.var_aj_b.e == 0 ? n2 + (this.var_aj_b.var_short_b % 20 != 0 ? 0 : 1) : n2) * 20, (this.var_aj_b.d == 0 ? n3 + (this.var_aj_b.var_short_c % 20 != 0 ? 0 : 1) : n3) * 20, 0, 0) == 0) {
            return -2;
        }
        return by;
    }

    private void b(String string) {
        int n2 = 0;
        ah.ah_b();
        ah.a(4, 265, 236, 55);
        if (string != null) {
            int n3 = 33;
            n3 = 265;
            int n4 = this.var_boolean_h ? 190 : 50;
            at at2 = this;
            if (at2.var_javax_microedition_lcdui_Image_b != null) {
                ah.ah_b();
                ah.b(at2.var_javax_microedition_lcdui_Image_b, n4 + at2.var_short_n, 265, 33);
            }
            ad.ad_b();
            at2.var_short_n = ad.b(at2.var_short_n, 0, 20, false);
            ah.ah_b();
            ad.ad_b();
            ah.a(0, 241, ad.int_b(string) + 16, 28);
            ah.ah_b();
            ah.b(string, 8, 243, 0, 9, 1);
        }
        while (n2 < 2 && this.var_byte_d + n2 < this.var_java_lang_StringBuffer_arr_b.length) {
            ah.ah_b();
            ah.b(this.var_java_lang_StringBuffer_arr_b[this.var_byte_d + n2].toString(), 10, 270 + n2 * 20, -1, 1);
            n2 = (byte)(n2 + 1);
        }
    }

    public final void f() {
        this.var_aj_arr_arr_b[0] = null;
        this.var_byte_arr_arr_a = null;
        this.var_byte_arr_arr_c = null;
        this.var_byte_arr_arr_d = null;
        this.var_javax_microedition_lcdui_Image_arr_b = null;
        this.var_short_arr_arr_c = null;
    }

    private byte[] byte_arr_b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        at.b(byteArrayOutputStream, this.var_aj_arr_arr_b[0]);
        at.b(byteArrayOutputStream, this.var_aj_arr_arr_b[1]);
        at.b(byteArrayOutputStream, this.var_aj_arr_arr_b[2]);
        at.b(byteArrayOutputStream, this.var_byte_arr_arr_a);
        at.b(byteArrayOutputStream, this.var_byte_arr_arr_c);
        return byteArrayOutputStream.toByteArray();
    }

    private static void b(ByteArrayOutputStream byteArrayOutputStream, aj[] ajArray) {
        try {
            for (int i2 = 0; i2 < ajArray.length; ++i2) {
                if (ajArray[i2].var_byte_arr_b[9] != 1) continue;
                byteArrayOutputStream.write(ajArray[i2].var_byte_arr_b);
            }
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    private static void b(ByteArrayOutputStream byteArrayOutputStream, byte[][] byArray) {
        try {
            byteArrayOutputStream.write(byArray.length);
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                byteArrayOutputStream.write(byArray[i2].length);
                byteArrayOutputStream.write(byArray[i2]);
            }
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    private void D() {
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.b(1, 2, 238, 318);
        ah.ah_b();
        ah.h(6, 28, 228, 233, 1);
        ah.ah_b();
        ah.h(6, 266, 228, 48, 2);
        ah.ah_b().b(false, true);
        ah.ah_b();
        ah.b("\u0110\u1ecba \u0111\u1ed3 tr\u00f2 ch\u01a1i", 120, 4, 17, 1, 2);
        if (this.G == -1) {
            ah.ah_b();
            ah.b("Kh\u00f4ng c\u00f3 \u0111\u1ecba \u0111\u1ed3 khu v\u1ef1c!", 120, 268, 17, 3, 0);
            return;
        }
        ak.b("V\u1ecb tr\u00ed nh\u00e2n v\u1eadt hi\u1ec7n t\u1ea1i: " + this.var_ak_b.java_lang_String_a(this.H), 120, 268, 10, 3);
        var_javax_microedition_lcdui_Graphics_b.setClip(6, 28, 228, 233);
        int n2 = 120 - this.var_byte_arr_arr_g[this.I][0] * 13 - (this.var_boolean_e ? this.var_byte_arr_arr_g[this.I][6] * 13 / 2 : 25);
        ad.ad_b();
        this.var_short_k = ad.b(this.var_short_k, n2, 10, false);
        n2 = this.var_short_m / 2 - (this.var_byte_arr_arr_g[this.I][1] << 3) - (this.var_boolean_e ? (this.var_byte_arr_arr_g[this.I][7] << 3) / 2 : 15);
        ad.ad_b();
        this.var_short_l = ad.b(this.var_short_l, n2, 10, false);
        for (int n3 = 0; n3 < this.var_byte_arr_arr_f[this.G].length; n3 = (int)((byte)(n3 + 1))) {
            n2 = this.var_byte_arr_arr_f[this.G][n3];
            if (n2 < 0 || this.var_byte_arr_arr_g[n2].length <= 0 || !this.var_boolean_e && n2 == this.H) continue;
            this.b((byte)13, (byte)8, n2, false);
        }
        if (!this.var_boolean_e) {
            this.b((byte)13, (byte)8, (int)this.H, false);
        }
        this.b((byte)13, (byte)8, (int)this.I, true);
        var_javax_microedition_lcdui_Graphics_b.setClip(0, 0, 240, 320);
    }

    private void b(byte by, byte by2, int n2, boolean bl) {
        by = (byte)78;
        by2 = (byte)48;
        if (this.var_boolean_e) {
            by = (byte)(this.var_byte_arr_arr_g[n2][6] * 13);
            by2 = (byte)(this.var_byte_arr_arr_g[n2][7] << 3);
        }
        if (bl) {
            ah.ah_b().c(12352252, this.var_byte_arr_arr_g[n2][0] * 13 + this.var_short_k, (this.var_byte_arr_arr_g[n2][1] << 3) + this.var_short_l, by, by2, 5);
            return;
        }
        if (n2 == this.H) {
            ah.ah_b();
            ah.h(this.var_byte_arr_arr_g[n2][0] * 13 + this.var_short_k, (this.var_byte_arr_arr_g[n2][1] << 3) + this.var_short_l, by, by2, 4);
        } else {
            ah.ah_b();
            ah.d(this.var_byte_arr_arr_g[n2][0] * 13 + this.var_short_k, (this.var_byte_arr_arr_g[n2][1] << 3) + this.var_short_l, by, by2, 2);
        }
        if (this.var_boolean_e) {
            ak.b(this.var_ak_b.java_lang_String_a(n2), this.var_byte_arr_arr_g[n2][0] * 13 + this.var_short_k + (by >> 1) + 19, (this.var_byte_arr_arr_g[n2][1] << 3) + this.var_short_l + (by2 >> 1) - 20, 4, n2 == this.H ? 0 : 3);
        } else {
            ak.b(this.var_ak_b.java_lang_String_a(n2), this.var_byte_arr_arr_g[n2][0] * 13 + this.var_short_k + (by >> 1), (this.var_byte_arr_arr_g[n2][1] << 3) + this.var_short_l + (by2 >> 1) - 20, 4, n2 == this.H ? 0 : 3);
        }
        if (n2 == this.H) {
            ah.ah_b().a(67, this.var_byte_arr_arr_g[n2][0] * 13 + this.var_short_k + (by >> 1), (this.var_byte_arr_arr_g[n2][1] << 3) + this.var_short_l + (by2 >> 1), 3, 0);
        }
    }

    private void F() {
        block12: {
            block11: {
                block10: {
                    block9: {
                        ad.ad_b();
                        ad.void_c();
                        ad.ad_b();
                        if (ad.g()) {
                            return;
                        }
                        ad.ad_b();
                        if (ad.i()) break block9;
                        ad.ad_b();
                        if (!ad.j()) break block10;
                    }
                    this.var_aj_b.var_byte_a = 0;
                    this.var_byte_arr_arr_f = null;
                    this.var_byte_arr_arr_g = null;
                    return;
                }
                ad.ad_b();
                if (ad.e()) break block11;
                ad.ad_b();
                if (!ad.boolean_c()) break block12;
            }
            if (this.var_byte_arr_arr_g[this.I].length >= 6) {
                byte[] byArray = this.var_byte_arr_arr_g[this.I];
                ad.ad_b();
                ad.ad_b();
                if (byArray[ad.a(ad.e) + 1] != -1) {
                    byte[] byArray2 = this.var_byte_arr_arr_g[this.I];
                    ad.ad_b();
                    ad.ad_b();
                    this.I = byArray2[ad.a(ad.e) + 1];
                }
            }
        }
    }

    private void G() {
        ad.ad_b();
        ad.void_c();
        byte[] byArray = ad.ad_b().byte_arr_b("data/map.d", -1);
        ad.ad_b();
        ad.var_int_c = 0;
        this.var_byte_arr_arr_f = ad.ad_b().byte_arr_arr_b(byArray);
        this.var_byte_arr_arr_g = ad.ad_b().byte_arr_arr_b(byArray);
        this.var_aj_b.var_byte_a = (byte)17;
        this.G = (byte)-1;
        this.H = (byte)-1;
        this.I = 0;
        for (int n2 = 0; n2 < this.var_byte_arr_arr_f.length; n2 = (int)((byte)(n2 + 1))) {
            for (int n3 = 0; n3 < this.var_byte_arr_arr_f[n2].length; n3 = (int)((byte)(n3 + 1))) {
                if (this.var_byte_a != this.var_byte_arr_arr_f[n2][n3]) continue;
                this.I = this.var_byte_a;
                if (this.var_byte_arr_arr_g[this.I].length <= 0) continue;
                this.H = this.I;
                this.G = (byte)n2;
                this.var_boolean_e = this.var_byte_arr_arr_f[this.G][0] >= 0;
                return;
            }
        }
    }

    private void H() {
        ak.c("B\u1ea1n c\u00f3 mu\u1ed1n l\u01b0u c\u00e1c b\u00e0n kh\u00f4ng?", 260, 0);
        ah.ah_b().b(true, true);
    }

    private void I() {
        ad.ad_b();
        if (ad.f()) {
            this.var_aj_b.var_byte_a = 0;
            this.var_byte_g = (byte)2;
            return;
        }
        ad.ad_b();
        if (ad.i()) {
            this.var_aj_b.var_byte_a = 0;
            this.var_byte_g = (byte)3;
        }
    }

    private void E() {
        ad.ad_b();
        byte[] byArray = ad.byte_arr_b(7, null, 1);
        this.var_byte_arr_a = (byte[])(byArray[0] == -1 ? null : byArray);
        if (this.var_byte_arr_a == null) {
            this.var_byte_arr_a = new byte[20];
        }
    }

    public final void b(int n2, boolean bl) {
        if (this.var_aj_b.var_byte_a != 18 && this.var_aj_b.var_byte_a != 0) {
            return;
        }
        ad.ad_b();
        ad.void_c();
        this.var_boolean_d = bl;
        ak.var_int_a = -10;
        this.var_aj_b.var_byte_a = (byte)18;
        this.var_ak_b.s = (byte[])((byte)n2);
        this.var_ak_b.var_byte_h[0][1] = false;
        this.var_ak_b.var_byte_h[0][0] = false;
        ad.ad_b();
        ad.var_int_c = 0;
        byte[] byArray = ad.ad_b().byte_arr_b("data/mission" + n2 + ".t", -1);
        this.var_java_lang_StringBuffer_arr_arr_b = ad.ad_b().java_lang_StringBuffer_arr_arr_b(byArray);
        this.var_ak_b.var_byte_d = (byte)6;
        this.var_ak_b.var_int_c = (int)null;
        if (n2 == 1) {
            int n3 = 0;
            byte[] byArray2 = new byte[50];
            for (n2 = 0; n2 < this.var_java_lang_StringBuffer_arr_arr_b.length; n2 = (int)((byte)(n2 + 1))) {
                int n4 = n2;
                at at2 = this;
                byte by = (byte)(n4 / 8);
                if (!((at2.var_byte_arr_a[by] & 1 << (n4 = (int)((byte)(n4 % 8)))) != 0)) continue;
                int n5 = n3;
                n3 = (byte)(n3 + 1);
                byArray2[n5] = n2;
            }
            this.var_byte_arr_e = null;
            this.var_byte_arr_e = new byte[n3];
            System.arraycopy(byArray2, 0, this.var_byte_arr_e, 0, this.var_byte_arr_e.length);
            if (this.var_byte_arr_e.length > 0) {
                this.var_ak_b.b(this.var_java_lang_StringBuffer_arr_arr_b[this.var_byte_arr_e[this.var_ak_b.var_byte_h[0][0]]][1].toString(), 202, 0);
            }
            return;
        }
        this.var_ak_b.var_byte_h[0][0] = this.var_byte_arr_a[14];
        this.var_ak_b.var_byte_h[0][1] = this.var_byte_arr_a[14] >= this.var_ak_b.var_byte_d ? (byte)(this.var_ak_b.var_byte_h[0][0] - this.var_ak_b.var_byte_d + true) : (byte)0;
        this.var_ak_b.b(this.var_java_lang_StringBuffer_arr_arr_b[this.var_ak_b.var_byte_h[0][0]][1].toString(), 202, 0);
    }

    private void a(int n2, boolean bl) {
        byte by = (byte)(n2 / 8);
        n2 = (byte)(n2 % 8);
        if (bl) {
            byte by2 = by;
            this.var_byte_arr_a[by2] = (byte)(this.var_byte_arr_a[by2] | 1 << n2);
            return;
        }
        if ((this.var_byte_arr_a[by] & 1 << n2) != 0) {
            byte by3 = by;
            this.var_byte_arr_a[by3] = (byte)(this.var_byte_arr_a[by3] ^ 1 << n2);
            this.var_byte_arr_a[15] = (byte)(this.var_byte_arr_a[15] + 1);
        }
    }

    private boolean boolean_d(int n2) {
        byte by = (byte)(n2 / 8);
        return (this.var_byte_arr_a[by] & 1 << (n2 = (int)((byte)(n2 % 8)))) != 0;
    }

    private void J() {
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.b(1, 6, 238, 314);
        ah.ah_b();
        ah.h(8, 35, 214, this.var_ak_b.var_byte_d * 24 + 10, 1);
        ah.ah_b();
        ah.h(8, 53 + this.var_ak_b.var_byte_d * 24, 224, 100, 2);
        int n2 = this.var_ak_b.s == false ? this.var_byte_arr_a[14] + 1 : this.var_byte_arr_e.length;
        void var3_2 = this.var_ak_b.var_byte_h[0];
        byte by = this.var_ak_b.var_byte_d;
        int n3 = 24;
        n3 = 214;
        n3 = 41;
        n3 = 8;
        at at2 = this;
        ah.ah_b().b(by, 8, 41, 214, 6, 24, -1, (int)(var3_2[0] - var3_2[1]), 4, 2);
        for (byte by2 = var3_2[1]; by2 < var3_2[1] + by; by2 = (byte)(by2 + true)) {
            if (by2 >= n2) continue;
            String string = at2.var_ak_b.s == false ? by2 + 1 + ", " + at2.var_java_lang_StringBuffer_arr_arr_b[by2][0].toString() : by2 + 1 + ", " + at2.var_java_lang_StringBuffer_arr_arr_b[at2.var_byte_arr_e[by2]][0].toString();
            ah.ah_b();
            ah.b(string, 16, 41 + (by2 - var3_2[1]) * 23, 0, by2 < at2.var_byte_arr_a[14] ? -1 : (var3_2[0] == by2 ? 0 : 3), 0);
            if (at2.var_ak_b.s != false || by2 == n2 - 1) continue;
            ah.ah_b();
            ah.b("Ho\u00e0n th\u00e0nh", 214, 41 + (by2 - var3_2[1]) * 23, 24, by2 < at2.var_byte_arr_a[14] ? -1 : (var3_2[0] == by2 ? 0 : 3), 0);
        }
        ah.ah_b().b(226, 41, by * 24, (int)var3_2[0], n2, true);
        for (int n4 = 0; null != this.var_ak_b.var_int_c && n4 < ((int)this.var_ak_b.var_int_c).length; n4 = (int)((byte)(n4 + 1))) {
            ah.ah_b();
            ah.b(this.var_ak_b.var_int_c[n4].toString(), 19, 55 + this.var_ak_b.var_byte_d * 24 + n4 * 20, 3, 0);
        }
        ah.ah_b();
        ah.h(this.var_ak_b.s == false ? 25 : 140, 9, 76, 24, 4);
        ah.ah_b();
        ah.b("C\u1eadp nh\u1eadt nhi\u1ec7m v\u1ee5 ch\u00ednh", 63, 9, 17, this.var_ak_b.s == false ? 0 : 1, 0);
        ah.ah_b();
        ah.b("Nhi\u1ec7m v\u1ee5 ph\u1ee5", 177, 9, 17, this.var_ak_b.s == true ? 0 : 1, 0);
        ah.ah_b().b(120, 18, 114, true, true);
        ah.ah_b();
        StringBuffer stringBuffer = new StringBuffer().append(this.var_ak_b.s == false ? "M\u1ee9c \u0111\u1ed9 ho\u00e0n th\u00e0nh nhi\u1ec7m v\u1ee5 ch\u00ednh: " : "M\u1ee9c \u0111\u1ed9 ho\u00e0n th\u00e0nh nhi\u1ec7m v\u1ee5 ph\u1ee5: ");
        ad.ad_b();
        ah.b(stringBuffer.append(ad.java_lang_String_b(this.var_byte_arr_a[this.var_ak_b.s == false ? 14 : 15] * 1000 / (this.var_ak_b.s == false ? this.var_java_lang_StringBuffer_arr_arr_b.length - 1 : this.var_java_lang_StringBuffer_arr_arr_b.length))).append("%").toString(), 120, 317, 33, 0, 1);
        ah.ah_b().b(false, true);
    }

    private void b(int n2, int n3, int n4, int n5, int n6, byte[] byArray, int n7) {
        ah.ah_b().b(n6, 8, 41, 214, 6, 24, -1, byArray[0] - byArray[1], 4, 2);
        for (n2 = byArray[1]; n2 < byArray[1] + n6; n2 = (int)((byte)(n2 + 1))) {
            if (n2 >= n7) continue;
            String string = this.var_ak_b.s == false ? n2 + 1 + ", " + this.var_java_lang_StringBuffer_arr_arr_b[n2][0].toString() : n2 + 1 + ", " + this.var_java_lang_StringBuffer_arr_arr_b[this.var_byte_arr_e[n2]][0].toString();
            ah.ah_b();
            ah.b(string, 16, 41 + (n2 - byArray[1]) * 23, 0, n2 < this.var_byte_arr_a[14] ? -1 : (byArray[0] == n2 ? 0 : 3), 0);
            if (this.var_ak_b.s != false || n2 == n7 - 1) continue;
            ah.ah_b();
            ah.b("Ho\u00e0n th\u00e0nh", 214, 41 + (n2 - byArray[1]) * 23, 24, n2 < this.var_byte_arr_a[14] ? -1 : (byArray[0] == n2 ? 0 : 3), 0);
        }
        ah.ah_b().b(226, 41, n6 * 24, (int)byArray[0], n7, true);
    }

    private void K() {
        block15: {
            block14: {
                block13: {
                    block12: {
                        ad.ad_b();
                        if (ad.boolean_b()) {
                            return;
                        }
                        ad.ad_b();
                        if (ad.e()) break block12;
                        ad.ad_b();
                        if (ad.k() && this.var_ak_b.s == true) break block12;
                        ad.ad_b();
                        if (!ad.l() || this.var_ak_b.s != false) break block13;
                    }
                    this.var_ak_b.s = (byte[])((byte)(this.var_ak_b.s ^ 1));
                    this.b((int)this.var_ak_b.s, this.var_boolean_d);
                    return;
                }
                ad.ad_b();
                if (ad.boolean_c()) {
                    byte by = this.var_ak_b.s == false ? (byte)(this.var_byte_arr_a[14] + 1 > this.var_java_lang_StringBuffer_arr_arr_b.length ? this.var_java_lang_StringBuffer_arr_arr_b.length : this.var_byte_arr_a[14] + 1) : (byte)this.var_byte_arr_e.length;
                    ad.ad_b();
                    ad.b((byte[])this.var_ak_b.var_byte_h[0], 0, (int)by, this.var_ak_b.var_byte_d);
                    if (this.var_ak_b.s == false) {
                        this.var_ak_b.b(this.var_java_lang_StringBuffer_arr_arr_b[this.var_ak_b.var_byte_h[0][0]][1].toString(), 202, 0);
                        return;
                    }
                    if (this.var_byte_arr_e.length > 0) {
                        this.var_ak_b.b(this.var_java_lang_StringBuffer_arr_arr_b[this.var_byte_arr_e[this.var_ak_b.var_byte_h[0][0]]][1].toString(), 202, 0);
                        return;
                    }
                    this.var_ak_b.var_int_c = (int)null;
                    return;
                }
                ad.ad_b();
                if (ad.i()) break block14;
                ad.ad_b();
                if (ad.k()) break block14;
                ad.ad_b();
                if (!ad.l()) break block15;
            }
            this.var_aj_b.var_byte_a = 0;
            if (this.var_boolean_d) {
                this.var_ak_b.void_b(0);
                ak.var_int_a = 97;
            } else {
                ak.var_int_a = -10;
            }
            this.var_byte_arr_e = null;
            this.var_java_lang_StringBuffer_arr_arr_b = null;
            this.var_ak_b.var_int_c = (int)null;
            ad.ad_b();
            ad.void_c();
        }
    }

    private void L() {
        at at2 = this;
        ad.ad_b();
        ad.var_int_c = 0;
        byte[] byArray = ad.ad_b().byte_arr_b("data/map/area.dat", -1);
        ad.ad_b();
        byte[] byArray2 = ad.byte_arr_b(byArray);
        byte[][] byArray3 = ad.ad_b().byte_arr_arr_b(byArray);
        if (at2.var_javax_microedition_lcdui_Image_arr_b == null || byArray2[at2.var_byte_l] != byArray2[at2.var_byte_a]) {
            ad.ad_b();
            ad.var_int_c = 0;
            at2.var_short_arr_arr_c = ad.ad_b().short_arr_arr_b(ad.ad_b().byte_arr_b("data/map/" + byArray2[at2.var_byte_a] + ".data", -1), 1);
            at2.var_javax_microedition_lcdui_Image_arr_b = null;
            at2.var_javax_microedition_lcdui_Image_arr_b = new Image[byArray3[byArray2[at2.var_byte_a]].length];
            for (int n2 = 0; n2 < byArray3[byArray2[at2.var_byte_a]].length; n2 = (int)((byte)(n2 + 1))) {
                Image[] imageArray = at2.var_javax_microedition_lcdui_Image_arr_b;
                ad.ad_b();
                imageArray[n2] = ad.javax_microedition_lcdui_Image_b("data/map/" + byArray3[byArray2[at2.var_byte_a]][n2]);
            }
        }
        this.l(this.var_byte_a);
    }

    private void M() {
        ad.ad_b();
        ad.var_int_c = 0;
        byte[] byArray = ad.ad_b().byte_arr_b("data/map/area.dat", -1);
        ad.ad_b();
        byte[] byArray2 = ad.byte_arr_b(byArray);
        byte[][] byArray3 = ad.ad_b().byte_arr_arr_b(byArray);
        if (this.var_javax_microedition_lcdui_Image_arr_b != null && byArray2[this.var_byte_l] == byArray2[this.var_byte_a]) {
            return;
        }
        ad.ad_b();
        ad.var_int_c = 0;
        this.var_short_arr_arr_c = ad.ad_b().short_arr_arr_b(ad.ad_b().byte_arr_b("data/map/" + byArray2[this.var_byte_a] + ".data", -1), 1);
        this.var_javax_microedition_lcdui_Image_arr_b = null;
        this.var_javax_microedition_lcdui_Image_arr_b = new Image[byArray3[byArray2[this.var_byte_a]].length];
        for (int n2 = 0; n2 < byArray3[byArray2[this.var_byte_a]].length; n2 = (int)((byte)(n2 + 1))) {
            ad.ad_b();
            this.var_javax_microedition_lcdui_Image_arr_b[n2] = ad.javax_microedition_lcdui_Image_b("data/map/" + byArray3[byArray2[this.var_byte_a]][n2]);
        }
    }

    private void l(int n2) {
        int n3 = 0;
        byte[] byArray = new byte[2];
        byte[] byArray2 = new byte[4];
        byte by = 0;
        this.var_short_arr_a = null;
        this.var_short_arr_e = null;
        this.var_short_arr_arr_a = null;
        int n4 = 0;
        try {
            DataInputStream dataInputStream = new DataInputStream(this.getClass().getResourceAsStream("/data/map/" + n2 + ".mid"));
            dataInputStream.skip(2L);
            dataInputStream.read(byArray2);
            ad.ad_b();
            this.var_int_d = (int)ad.long_b(byArray2);
            byte[] byArray3 = new byte[dataInputStream.readByte()];
            dataInputStream.read(byArray3);
            dataInputStream.read(byArray3);
            ad.ad_b();
            this.var_short_b = (byte)ad.long_b(byArray3);
            dataInputStream.read(byArray3);
            ad.ad_b();
            this.var_short_c = (byte)ad.long_b(byArray3);
            this.var_short_arr_arr_a = new short[this.var_short_b][this.var_short_c];
            for (int n5 = 0; n5 < 3; n5 = (int)((byte)(n5 + 1))) {
                by = dataInputStream.readByte();
                if (by == -1) continue;
                dataInputStream.read(byArray2);
                ad.ad_b();
                n3 = (int)ad.long_b(byArray2) * 3;
                switch (by) {
                    case 1: {
                        this.var_short_arr_a = new short[n3];
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        this.var_short_arr_e = new short[n3];
                    }
                }
                n4 = 0;
                while (n4 < n3) {
                    dataInputStream.read(byArray3);
                    ad.ad_b();
                    n2 = (short)ad.long_b(byArray3);
                    dataInputStream.read(byArray3);
                    long l2 = this.var_short_c - 1;
                    ad.ad_b();
                    short s2 = (short)(l2 - ad.long_b(byArray3));
                    dataInputStream.read(byArray);
                    ad.ad_b();
                    short s3 = (short)ad.long_b(byArray);
                    switch (by) {
                        case 1: {
                            int n6 = n4;
                            n4 = (short)(n4 + 1);
                            this.var_short_arr_a[n6] = (short)n2;
                            int n7 = n4;
                            n4 = (short)(n4 + 1);
                            this.var_short_arr_a[n7] = s2;
                            int n8 = n4;
                            n4 = (short)(n4 + 1);
                            this.var_short_arr_a[n8] = s3;
                            break;
                        }
                        case 2: {
                            n4 = (short)(n4 + 3);
                            this.var_short_arr_arr_a[n2][s2] = (short)(s3 >> 3);
                            break;
                        }
                        case 3: {
                            int n9 = n4;
                            n4 = (short)(n4 + 1);
                            this.var_short_arr_e[n9] = (short)n2;
                            int n10 = n4;
                            n4 = (short)(n4 + 1);
                            this.var_short_arr_e[n10] = s2;
                            int n11 = n4;
                            n4 = (short)(n4 + 1);
                            this.var_short_arr_e[n11] = s3;
                        }
                    }
                }
            }
            dataInputStream.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void c(Graphics graphics) {
        short s2 = this.var_short_a;
        short s3 = this.var_short_e;
        if (this.var_int_c >= 0) {
            this.var_short_a = 0;
            this.var_int_h = this.var_int_c;
        } else {
            this.var_short_a = (short)(-this.var_int_c / 20);
            this.var_int_h = this.var_int_c % 20;
        }
        if (this.var_int_a >= 0) {
            this.var_short_e = 0;
            this.var_int_g = this.var_int_a;
        } else {
            this.var_short_e = (short)(-this.var_int_a / 20);
            this.var_int_g = this.var_int_a % 20;
        }
        int n2 = this.var_short_a * 20;
        int n3 = this.var_short_e * 20;
        if (this.var_byte_f == 0) {
            this.var_byte_f = 1;
            this.b(this.var_short_arr_a, this.var_javax_microedition_lcdui_Image_arr_b, n2, n3, this.var_short_arr_arr_c, graphics, 0, 0, 260, 340, true);
        } else if (this.var_short_a != s2 || this.var_short_e != s3) {
            graphics.setClip(0, 0, 260, 340);
            graphics.copyArea(0, 0, 260, 340, (s2 - this.var_short_a) * 20, (s3 - this.var_short_e) * 20, 20);
            if (this.var_short_a < s2) {
                this.b(this.var_short_arr_a, this.var_javax_microedition_lcdui_Image_arr_b, n2, n3, this.var_short_arr_arr_c, graphics, 0, 0, (s2 - this.var_short_a) * 20, 340, true);
            } else if (this.var_short_a > s2) {
                this.b(this.var_short_arr_a, this.var_javax_microedition_lcdui_Image_arr_b, n2, n3, this.var_short_arr_arr_c, graphics, 260 + (s2 - this.var_short_a) * 20, 0, 260, 340, true);
            }
            if (this.var_short_e < s3) {
                this.b(this.var_short_arr_a, this.var_javax_microedition_lcdui_Image_arr_b, n2, n3, this.var_short_arr_arr_c, graphics, 0, 0, 260, (s3 - this.var_short_e) * 20, true);
            } else if (this.var_short_e > s3) {
                this.b(this.var_short_arr_a, this.var_javax_microedition_lcdui_Image_arr_b, n2, n3, this.var_short_arr_arr_c, graphics, 0, 340 + (s3 - this.var_short_e) * 20, 260, 340, true);
            }
        }
        var_javax_microedition_lcdui_Graphics_b.drawImage((Image)ak.var_byte_b, this.var_int_h, this.var_int_g, 20);
    }

    private void b(short[] sArray, Image[] imageArray, int n2, int n3, short[][] sArray2, Graphics graphics, int n4, int n5, int n6, int n7, boolean bl) {
        if (sArray == null) {
            return;
        }
        n3 -= 20;
        if (bl) {
            graphics.setClip(n4, n5, n6 - n4, n7 - n5);
            graphics.setColor(this.var_int_d);
            graphics.fillRect(n4, n5, n6 - n4, n7 - n5);
        }
        boolean bl2 = false;
        int n8 = 0;
        n8 = 0;
        short s2 = 0;
        for (int i2 = 0; i2 < sArray.length; i2 += 3) {
            if (sArray[i2 + 2] < 0) continue;
            int n9 = sArray[i2 + 2] >> 3;
            n8 = sArray[i2 + 2] & 3;
            int n10 = sArray[i2] * 20 - n2;
            int n11 = sArray[i2 + 1] * 20 - n3;
            if (n8 % 2 == 1) {
                n8 = sArray2[n9][4];
                s2 = sArray2[n9][3];
            } else {
                n8 = sArray2[n9][3];
                s2 = sArray2[n9][4];
            }
            if (n10 + n8 < n4 || n10 > n6 || n11 < n5 || n11 - s2 > n7) continue;
            ah.ah_b();
            ah.b(imageArray[sArray2[n9][0]], sArray2[n9][1], sArray2[n9][2], sArray2[n9][3], sArray2[n9][4], n10, n11, 36, sArray[i2 + 2] & 7, graphics);
        }
    }

    private void N() {
        ad.ad_b();
        if (ad.boolean_b()) {
            return;
        }
        ad.ad_b();
        if (ad.g()) {
            this.var_aj_b.var_byte_a = (byte)13;
            return;
        }
        ad.ad_b();
        if (ad.boolean_c()) {
            ad.ad_b();
            this.var_ak_b.s = (byte[])ad.byte_b((int)this.var_ak_b.s, 0, ((int)this.var_ak_b.var_int_c).length - 1);
        }
    }

    private void void_b(int n2, int n3, int n4) {
        if (this.var_javax_microedition_lcdui_Image_b != null) {
            ah.ah_b();
            ah.b(this.var_javax_microedition_lcdui_Image_b, n2 + this.var_short_n, 265, 33);
        }
        ad.ad_b();
        this.var_short_n = ad.b(this.var_short_n, 0, 20, false);
    }

    private void c(String object) {
        if (object == null) {
            return;
        }
        int n2 = -1;
        this.var_boolean_h = true;
        if (((String)object).equals("T\u1eafc K\u1ef3")) {
            n2 = 0;
            this.var_boolean_h = false;
        } else if (((String)object).equals("Angel") || ((String)object).equals("N\u1eef nh\u00e2n t\u00f3c xanh")) {
            n2 = 1;
        } else if (((String)object).equals("Qu\u1ef7 V\u01b0\u01a1ng \u0110\u1ecba Ph\u1ee7")) {
            n2 = 2;
        } else if (((String)object).equals("Hi\u1ec7u tr\u01b0\u1edfng Jieqi")) {
            n2 = 3;
        } else if (((String)object).equals("General") || ((String)object).equals("Hi\u1ec3u tr\u01b0\u1edfng General")) {
            n2 = 4;
        } else if (((String)object).equals("Nam nh\u00e2n \u0110\u00f4ng Ph\u01b0\u01a1ng th\u1ea7n b\u00ed")) {
            n2 = 5;
        } else if (((String)object).equals("Nam Cung V\u00e2n")) {
            n2 = 6;
        }
        if (n2 >= 0) {
            if (this.var_javax_microedition_lcdui_Image_b == null || this.E != n2) {
                this.var_short_n = (short)(this.var_boolean_h ? 50 : -50);
                this.E = (byte)n2;
                this.var_javax_microedition_lcdui_Image_b = null;
                ad.ad_b();
                this.var_javax_microedition_lcdui_Image_b = ad.javax_microedition_lcdui_Image_b("data/face/" + n2);
                return;
            }
        } else {
            object = this;
            this.var_javax_microedition_lcdui_Image_b = null;
        }
    }

    private void O() {
        this.var_javax_microedition_lcdui_Image_b = null;
    }

    private void P() {
        if (this.var_am_b == null) {
            this.var_am_b = ad.ad_b().b("data/face/brow", true);
        }
    }

    private void m(int n2) {
        if (this.D < 0 || this.var_aj_b.var_byte_a != 0 || this.var_aj_arr_arr_b[0][this.D].var_byte_arr_b[6] != 0) {
            return;
        }
        ah.ah_b().b(this.var_am_b, this.var_am_b.c(4, this.J, 0), this.var_int_c + this.var_aj_arr_arr_b[0][this.D].var_short_b + 10, this.var_int_a + this.var_aj_arr_arr_b[0][this.D].var_short_c - 16 - 10, 0);
        this.K = (byte)(this.K + 1);
        if (this.K > this.var_am_b.c(4, this.J, 1)) {
            this.J = (byte)(this.J + 1);
            if (this.J >= this.var_am_b.b(4)) {
                this.J = 0;
            }
            this.K = 0;
        }
    }

    private void Q() {
        for (int n2 = 0; n2 < this.var_byte_arr_d.length; n2 = (int)((byte)(n2 + 1))) {
            byte by = this.var_byte_arr_d[n2];
            if (by < -1) continue;
            var_aj_c = by == -1 ? this.var_aj_b : this.var_aj_arr_arr_b[0][by];
            if (at.var_aj_c.var_byte_arr_b[4] != 1 && at.var_aj_c.var_byte_arr_b[4] != 2 || at.var_aj_c.j < 0 && at.var_aj_c.var_byte_arr_b[6] == 0 || by >= 0 && !this.boolean_a((int)at.var_aj_c.var_short_b, (int)at.var_aj_c.var_short_c)) continue;
            if (at.var_aj_c.var_byte_arr_b[6] != 0) {
                at.var_aj_c.j = at.var_aj_c.var_byte_arr_b[6];
            }
            if (at.var_aj_c.f >= this.var_am_b.b(at.var_aj_c.j)) {
                if (at.var_aj_c.var_byte_arr_b[6] != 0) {
                    at.var_aj_c.f = 0;
                } else {
                    at.var_aj_c.j = (byte)-1;
                    continue;
                }
            }
            ah.ah_b().b(this.var_am_b, this.var_am_b.c(at.var_aj_c.j, at.var_aj_c.f, 0), this.var_int_c + at.var_aj_c.var_short_b + 14, this.var_int_a + at.var_aj_c.var_short_c - 15 - 10, 0);
            at.var_aj_c.i = (byte)(at.var_aj_c.i + 1);
            if (at.var_aj_c.i <= this.var_am_b.c(at.var_aj_c.j, at.var_aj_c.f, 1)) continue;
            at.var_aj_c.f = (byte)(at.var_aj_c.f + 1);
            at.var_aj_c.i = 0;
        }
    }

    private void b(String string, int n2, int n3) {
        at.var_am_arr_arr_b[n3][n2] = ad.ad_b().b("data/npc" + n3 + "/" + string, n3 == 2 ? this.var_ak_b.boolean_b(Integer.parseInt(string)) : true);
    }

    private void R() {
        byte by;
        byte by2;
        int n2 = 0;
        byte[][] byArrayArray = new byte[3][];
        byte[][] byArrayArray2 = byArrayArray;
        byArrayArray[0] = new byte[100];
        byArrayArray2[1] = new byte[5];
        byArrayArray2[2] = new byte[60];
        this.var_ak_b.void_e(0);
        for (by2 = (byte)(this.var_aj_arr_arr_b.length - 1); by2 >= 0; by2 = (byte)(by2 - 1)) {
            for (by = (byte)(this.var_aj_arr_arr_b[by2].length - 1); by >= 0; by = (byte)(by - 1)) {
                byArrayArray2[this.var_aj_arr_arr_b[by2][by].var_byte_arr_b[3] - 1][this.var_aj_arr_arr_b[by2][by].var_byte_arr_b[2]] = 1;
                if (by2 != 0) continue;
                this.var_byte_arr_d[by + 1] = by;
                if (this.var_aj_arr_arr_b[by2][by].var_byte_arr_b[8] != 1) continue;
                int n3 = n2;
                n2 = (byte)(n2 + 1);
                this.var_ak_b.var_byte_p[n3] = by;
            }
        }
        this.var_ak_b.void_e(1);
        this.var_byte_arr_d[0] = -1;
        for (by2 = (byte)(this.var_byte_arr_arr_a.length + this.var_aj_arr_arr_b[0].length); by2 > this.var_aj_arr_arr_b[0].length; by2 = (byte)(by2 - 1)) {
            this.var_byte_arr_d[by2] = (byte)(-2 - by2 + this.var_aj_arr_arr_b[0].length + 1);
        }
        this.b(100, 0, byArrayArray2[0]);
        this.b(5, 1, byArrayArray2[1]);
        this.b(60, 2, byArrayArray2[2]);
        for (by = (byte)(this.var_aj_arr_arr_b[0].length - 1); by >= 0; by = (byte)(by - 1)) {
            this.var_aj_arr_arr_b[0][by].b(var_am_arr_arr_b[this.var_aj_arr_arr_b[0][by].var_byte_arr_b[3] - 1][this.var_aj_arr_arr_b[0][by].var_byte_arr_b[2]].int_b());
        }
    }

    private void b(int n2, int n3, byte[] byArray) {
        --n2;
        while (n2 > 0) {
            if (byArray[n2] != 0) {
                if (null == var_am_arr_arr_b[n3][n2]) {
                    int n4 = n3;
                    int n5 = n2;
                    String string = "" + n2;
                    at at2 = this;
                    at.var_am_arr_arr_b[n4][n5] = ad.ad_b().b("data/npc" + n4 + "/" + string, n4 == 2 ? at2.var_ak_b.boolean_b(Integer.parseInt(string)) : true);
                }
            } else {
                at.var_am_arr_arr_b[n3][n2] = null;
            }
            --n2;
        }
    }

    private boolean boolean_a(int n2, int n3) {
        return this.var_int_c + n2 >= -80 && this.var_int_c + n2 <= 300 && this.var_int_a + n3 >= -80 && this.var_int_a + n3 <= 380;
    }

    private void b(aj[] ajArray) {
        if (ajArray == null) {
            return;
        }
        for (int n2 = 0; n2 < ajArray.length; n2 = (int)((byte)(n2 + 1))) {
            if ((ajArray[n2].var_byte_arr_b[4] == 1 || ajArray[n2].var_byte_arr_b[4] == 2) && this.boolean_a((int)ajArray[n2].var_short_b, (int)ajArray[n2].var_short_c)) {
                this.void_b(ajArray, n2);
            }
            at.c(ajArray, n2);
        }
    }

    private void c(aj[] ajArray) {
        if (ajArray == null) {
            return;
        }
        for (int n2 = 0; n2 < this.var_byte_arr_d.length; n2 = (int)((byte)(n2 + 1))) {
            byte by = this.var_byte_arr_d[n2];
            if (by == -1) {
                if (this.var_aj_b.var_byte_arr_b[4] != 1 && this.var_aj_b.var_byte_arr_b[4] != 2) continue;
                this.b(this.var_aj_b, 0, this.var_int_c + this.var_aj_b.var_short_b + 10, this.var_int_a + this.var_aj_b.var_short_c + 19, this.var_aj_b.var_byte_arr_b[7]);
                continue;
            }
            if (by < -1) {
                ad.ad_b();
                by = (byte)(ad.a(by) - 2);
                if (!this.boolean_a(this.var_byte_arr_arr_a[by][0] * 20, this.var_byte_arr_arr_a[by][1] * 20)) continue;
                ah.ah_b().a(this.var_byte_arr_arr_a[by][2] == 2 ? 55 : 54, this.var_int_c + this.var_byte_arr_arr_a[by][0] * 20 + 10, this.var_int_a + this.var_byte_arr_arr_a[by][1] * 20 + 20, 33, 0);
                continue;
            }
            if ((ajArray[by].var_byte_arr_b[4] == 1 || ajArray[by].var_byte_arr_b[4] == 2) && this.boolean_a((int)ajArray[by].var_short_b, (int)ajArray[by].var_short_c)) {
                if (ajArray[by].var_byte_arr_b[8] != 3 && !this.var_java_lang_String_arr_c[by].equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng")) {
                    var_javax_microedition_lcdui_Graphics_b.drawImage(this.var_javax_microedition_lcdui_Image_c, this.var_int_c + ajArray[by].var_short_b + 10, this.var_int_a + ajArray[by].var_short_c + 20, 33);
                }
                this.void_b(ajArray, (int)by);
            }
            at.c(ajArray, by);
        }
    }

    private void void_b(aj[] ajArray, int n2) {
        byte by;
        byte by2;
        byte by3;
        byte by4;
        do {
            by4 = (byte)(ajArray[n2].var_byte_arr_b[3] - 1);
            by3 = ajArray[n2].var_byte_arr_b[2];
            by2 = ajArray[n2].var_byte_arr_b[7];
            by = ajArray[n2].o;
            if (by2 < 0) {
                ajArray[n2].n = (byte)4;
                by2 = -by2;
            }
            if (ajArray[n2].o < var_am_arr_arr_b[by4][by3].b(by2)) break;
            ajArray[n2].o = 0;
            by = 0;
            if (ajArray[n2].var_byte_arr_b[8] != -4) continue;
            ajArray[n2].var_byte_arr_b[8] = 0;
            ajArray[n2].var_byte_arr_b[4] = 0;
            return;
        } while (!ajArray[n2].var_boolean_a && at.boolean_b(ajArray, n2));
        ah.ah_b().b(var_am_arr_arr_b[by4][by3], var_am_arr_arr_b[by4][by3].c(by2, by, 0), this.var_int_c + ajArray[n2].var_short_b + 10, this.var_int_a + ajArray[n2].var_short_c + 19, ajArray[n2].n == 4 ? 1 : 0);
    }

    private static void c(aj[] ajArray, int n2) {
        byte by = (byte)(ajArray[n2].var_byte_arr_b[3] - 1);
        byte by2 = ajArray[n2].var_byte_arr_b[2];
        ad.ad_b();
        byte by3 = (byte)ad.a(ajArray[n2].var_byte_arr_b[7]);
        if (ajArray[n2].o >= var_am_arr_arr_b[by][by2].b(by3)) {
            ajArray[n2].o = 0;
            at.boolean_b(ajArray, n2);
        }
        if ((ajArray[n2].p = (byte)(ajArray[n2].p + 1)) >= var_am_arr_arr_b[by][by2].c(by3, ajArray[n2].o, 1)) {
            ajArray[n2].o = (byte)(ajArray[n2].o + 1);
            ajArray[n2].p = 0;
        }
    }

    private static boolean boolean_b(aj[] ajArray, int n2) {
        if (ajArray[n2].h != 127) {
            ajArray[n2].var_byte_arr_b[7] = ajArray[n2].h;
            ajArray[n2].h = (byte)127;
            return true;
        }
        return false;
    }

    public final void b(aj aj2, int n2, int n3, int n4, int n5) {
        if (aj2.o >= var_am_arr_arr_b[1][0].b(n5)) {
            aj2.o = 0;
        }
        if (this.var_byte_c != 2 && this.var_byte_c != 4) {
            ah.ah_b();
            ah.b(this.var_javax_microedition_lcdui_Image_c, n3, n4, 33);
        }
        ah.ah_b().b(var_am_arr_arr_b[1][0], var_am_arr_arr_b[1][0].c(n5, aj2.o, 0), n3, n4, aj2.n == 4 ? 1 : 0);
        aj2.p = (byte)(aj2.p + 1);
        if (aj2.p > var_am_arr_arr_b[1][0].c(n5, aj2.o, 1)) {
            aj2.o = (byte)(aj2.o + 1);
            aj2.p = 0;
        }
    }

    public final void i() {
        if (this.var_aj_arr_arr_b == null) {
            return;
        }
        short s2 = 0;
        for (int n2 = 1; n2 < this.var_byte_arr_d.length; n2 = (int)((byte)(n2 + 1))) {
            short s3;
            for (int n3 = n2; n3 > 0 && (s2 = this.short_b(n3)) <= (s3 = this.short_b(n3 - 1)); n3 = (int)((byte)(n3 - 1))) {
                if (s2 == s3 && (s2 != s3 || this.var_byte_arr_d[n3 - 1] != -1)) continue;
                s2 = this.var_byte_arr_d[n3];
                this.var_byte_arr_d[n3] = this.var_byte_arr_d[n3 - 1];
                this.var_byte_arr_d[n3 - 1] = s2;
            }
        }
    }

    private short short_b(int n2) {
        if (this.var_byte_arr_d[n2] == -1) {
            n2 = (short)(this.var_aj_b.var_short_c + this.var_byte_arr_arr_h[this.var_aj_b.n][1] * this.var_aj_b.g);
        } else if (this.var_byte_arr_d[n2] < -1) {
            ad.ad_b();
            n2 = (short)(this.var_byte_arr_arr_a[ad.a(this.var_byte_arr_d[n2]) - 2][1] * 20);
        } else {
            n2 = this.var_aj_arr_arr_b[0][this.var_byte_arr_d[n2]].var_short_c;
        }
        return (short)n2;
    }

    private void S() {
        this.var_aj_b.var_byte_b = this.var_aj_b.var_byte_c;
        this.var_aj_b.b(true);
        if (this.var_aj_b.var_byte_a == 0 && this.var_ak_b.var_byte_arr_c.length > 0) {
            at at2 = this;
            if (at2.var_short_i < at2.var_short_j) {
                if (at2.var_short_arr_arr_a[at2.var_aj_b.byte_b()][at2.var_aj_b.byte_c()] != 7) {
                    at2.var_short_i = (short)(at2.var_short_i + 1);
                    return;
                }
            } else {
                if (at2.var_ak_b.var_byte_arr_c.length > 1 && at2.var_ak_b.var_byte_b == 0) {
                    at2.var_aj_b.var_byte_b = 0;
                    at2.var_aj_b.var_byte_a = (byte)8;
                }
                at2.void_b(0, 0);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void T() {
        if (this.var_aj_b.k != -1 || this.var_aj_b.l != -1) {
            this.b(this.var_aj_b, false);
        } else {
            var3_1 = this;
            if (var3_1.M != -1 && var3_1.var_aj_b.k == -1 && var3_1.var_aj_b.l == -1) {
                var3_1.var_aj_b.var_byte_a = (byte)9;
                v0 = (byte)(var3_1.var_ak_b.s + 2);
                var3_1.var_ak_b.s = (byte[])v0;
                if (v0 >= var3_1.var_byte_arr_arr_b[var3_1.M].length) {
                    var3_1.M = (byte)-1;
                    var3_1.var_aj_b.var_byte_a = 0;
                    var3_1.var_byte_c = (byte)-1;
                    var3_1.g();
                } else {
                    var3_1.C = at.b(var3_1.var_byte_arr_arr_c, (int)var3_1.var_aj_b.var_short_b, (int)var3_1.var_aj_b.var_short_c);
                    if (var3_1.C != -1) {
                        var3_1.var_aj_b.var_byte_a = (byte)5;
                        var3_1.var_byte_k = var3_1.C;
                    }
                    var3_1.var_aj_b.c(var3_1.var_byte_arr_arr_b[var3_1.M][var3_1.var_ak_b.s], var3_1.var_byte_arr_arr_b[var3_1.M][var3_1.var_ak_b.s + true]);
                }
            }
        }
        this.void_b(this.var_aj_b, -1);
        for (var2_4 = 0; var2_4 < 3; var2_4 = (int)((byte)(var2_4 + 2))) {
            for (var1_5 = 0; var1_5 < this.var_aj_arr_arr_b[var2_4].length; var1_5 = (int)((byte)(var1_5 + 1))) {
                block32: {
                    block30: {
                        block35: {
                            block33: {
                                block34: {
                                    block31: {
                                        if (this.var_aj_arr_arr_b[var2_4][var1_5].var_byte_arr_b[4] != 1 && this.var_aj_arr_arr_b[var2_4][var1_5].var_byte_arr_b[4] != 2) continue;
                                        if (this.var_aj_arr_arr_b[var2_4][var1_5].var_byte_arr_b[8] < 5) break block30;
                                        var5_7 = var1_5;
                                        var4_6 = this.var_aj_arr_arr_b[var2_4][var1_5];
                                        var3_1 = this;
                                        if (var3_1.var_aj_b.var_byte_a != 1 || var3_1.var_byte_k != var5_7) break block31;
                                        v1 = var4_6.var_byte_arr_b;
                                        ad.ad_b();
                                        v1[7] = (byte)(ad.a(var4_6.var_byte_arr_b[7]) / 3 * 3 + (var3_1.var_aj_b.n < 4 ? var3_1.var_aj_b.n - 1 : var3_1.var_aj_b.n - 2));
                                        if (var3_1.var_aj_b.n == 3) {
                                            var4_6.var_byte_arr_b[7] = -var4_6.var_byte_arr_b[7];
                                        } else {
                                            var4_6.n = (byte)3;
                                        }
                                        break block32;
                                    }
                                    var6_9 = 10;
                                    var5_8 = var4_6;
                                    if (var5_8.m != 0) break block33;
                                    if (var5_8.var_byte_b != -1) break block34;
                                    ad.ad_b();
                                    var5_8.var_boolean_c = ad.c(100) < 50;
                                    ad.ad_b();
                                    if (ad.c(100) >= 50) ** GOTO lbl-1000
                                    ad.ad_b();
                                    var5_8.m = (byte)(-(ad.c(10) + 20));
                                    var5_8.b(false);
                                    v2 = false;
                                    break block35;
                                }
                                v2 = false;
                                break block35;
                            }
                            if (var5_8.m < 0) {
                                var5_8.m = (byte)(var5_8.m + 1);
                                v2 = false;
                            } else lbl-1000:
                            // 2 sources

                            {
                                v2 = true;
                            }
                        }
                        if (v2) {
                            if (var4_6.var_boolean_c) {
                                var3_2 = var3_1.var_ak_b.var_byte_arr_b[var4_6.var_byte_arr_b[8] - 5 << 1];
                                var6_10 = var4_6;
                                var5_8 = var3_1;
                                if (var6_10.m == 0) {
                                    ad.ad_b();
                                    var6_10.n = (byte)(ad.c(100) < 50 ? 3 : 4);
                                    var3_2 = var6_10.n == 3 ? (short)(var6_10.var_short_b - var6_10.var_byte_arr_b[0] * 20) : (short)((var3_2 + var6_10.var_byte_arr_b[0]) * 20 - var6_10.var_short_b);
                                    if (var3_2 <= 20) {
                                        var6_10.m = (byte)(var3_2 / var6_10.g);
                                    } else {
                                        ad.ad_b();
                                        var6_10.m = (byte)(ad.c((var3_2 - 20) / var6_10.g + 1) + 20 / var6_10.g);
                                    }
                                } else if (var6_10.m > 0 && var6_10.var_byte_b <= 0) {
                                    if (super.b(var6_10, (int)(var6_10.n == 3 ? -var6_10.g : var6_10.g), 0)) {
                                        var6_10.b(var6_10.n == 3 ? -var6_10.g : var6_10.g, 0);
                                        var6_10.m = (byte)(var6_10.m - 1);
                                        var6_10.var_byte_b = 1;
                                        var6_10.b(true);
                                    } else {
                                        var6_10.m = (byte)-20;
                                        var6_10.var_byte_b = (byte)-1;
                                        var6_10.b(false);
                                    }
                                }
                            } else {
                                var3_3 = var3_1.var_ak_b.var_byte_arr_b[(var4_6.var_byte_arr_b[8] - 5 << 1) + 1];
                                var6_11 = var4_6;
                                var5_8 = var3_1;
                                if (var6_11.m == 0 && var6_11.var_byte_b == -1) {
                                    ad.ad_b();
                                    var6_11.n = (byte)(ad.c(100) < 50 ? 1 : 2);
                                    var3_3 = var6_11.n == 1 ? (short)(var6_11.var_short_c - var6_11.var_byte_arr_b[1] * 20) : (short)((var3_3 + var6_11.var_byte_arr_b[1]) * 20 - var6_11.var_short_c);
                                    if (var3_3 <= 20) {
                                        var6_11.m = (byte)(var3_3 / var6_11.g);
                                    } else {
                                        ad.ad_b();
                                        var6_11.m = (byte)(ad.c((var3_3 - 20) / var6_11.g + 1) + 20 / var6_11.g);
                                    }
                                } else if (var6_11.m > 0 && var6_11.var_byte_b <= 0) {
                                    if (super.b(var6_11, 0, (int)(var6_11.n == 1 ? -var6_11.g : var6_11.g))) {
                                        var6_11.b(0, (int)(var6_11.n == 1 ? -var6_11.g : var6_11.g));
                                        var6_11.m = (byte)(var6_11.m - 1);
                                        var6_11.var_byte_b = 1;
                                        var6_11.b(true);
                                    } else {
                                        var6_11.m = (byte)-20;
                                        var6_11.var_byte_b = (byte)-1;
                                        var6_11.b(false);
                                    }
                                }
                            }
                        }
                        break block32;
                    }
                    if (this.var_aj_arr_arr_b[var2_4][var1_5].k != -1 || this.var_aj_arr_arr_b[var2_4][var1_5].l != -1) {
                        this.b(this.var_aj_arr_arr_b[var2_4][var1_5], true);
                    }
                }
                this.void_b(this.var_aj_arr_arr_b[var2_4][var1_5], var1_5);
            }
        }
        this.i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void c(aj aj2, int n2) {
        if (this.var_aj_b.var_byte_a == 1 && this.var_byte_k == n2) {
            byte[] byArray = aj2.var_byte_arr_b;
            ad.ad_b();
            byArray[7] = (byte)(ad.a(aj2.var_byte_arr_b[7]) / 3 * 3 + (this.var_aj_b.n < 4 ? this.var_aj_b.n - 1 : this.var_aj_b.n - 2));
            if (this.var_aj_b.n == 3) {
                aj2.var_byte_arr_b[7] = -aj2.var_byte_arr_b[7];
                return;
            }
            aj2.n = (byte)3;
            return;
        }
        int n3 = 10;
        Object object = aj2;
        if (((aj)object).m == 0) {
            if (((aj)object).var_byte_b != -1) return;
            ad.ad_b();
            ((aj)object).var_boolean_c = ad.c(100) < 50;
            ad.ad_b();
            if (ad.c(100) < 50) {
                ad.ad_b();
                ((aj)object).m = (byte)(-(ad.c(10) + 20));
                ((aj)object).b(false);
                return;
            }
        } else if (((aj)object).m < 0) {
            ((aj)object).m = (byte)(((aj)object).m + 1);
            return;
        }
        boolean bl = true;
        if (!bl) return;
        if (aj2.var_boolean_c) {
            short s2 = this.var_ak_b.var_byte_arr_b[aj2.var_byte_arr_b[8] - 5 << 1];
            aj aj3 = aj2;
            object = this;
            if (aj3.m == 0) {
                ad.ad_b();
                aj3.n = (byte)(ad.c(100) < 50 ? 3 : 4);
                s2 = aj3.n == 3 ? (short)(aj3.var_short_b - aj3.var_byte_arr_b[0] * 20) : (short)((s2 + aj3.var_byte_arr_b[0]) * 20 - aj3.var_short_b);
                if (s2 <= 20) {
                    aj3.m = (byte)(s2 / aj3.g);
                    return;
                }
                ad.ad_b();
                aj3.m = (byte)(ad.c((s2 - 20) / aj3.g + 1) + 20 / aj3.g);
                return;
            }
            if (aj3.m <= 0) return;
            if (aj3.var_byte_b > 0) return;
            if (super.b(aj3, (int)(aj3.n == 3 ? -aj3.g : aj3.g), 0)) {
                aj3.b(aj3.n == 3 ? -aj3.g : aj3.g, 0);
                aj3.m = (byte)(aj3.m - 1);
                aj3.var_byte_b = 1;
                aj3.b(true);
                return;
            }
            aj3.m = (byte)-20;
            aj3.var_byte_b = (byte)-1;
            aj3.b(false);
            return;
        }
        short s3 = this.var_ak_b.var_byte_arr_b[(aj2.var_byte_arr_b[8] - 5 << 1) + 1];
        aj aj4 = aj2;
        object = this;
        if (aj4.m == 0 && aj4.var_byte_b == -1) {
            ad.ad_b();
            aj4.n = (byte)(ad.c(100) < 50 ? 1 : 2);
            s3 = aj4.n == 1 ? (short)(aj4.var_short_c - aj4.var_byte_arr_b[1] * 20) : (short)((s3 + aj4.var_byte_arr_b[1]) * 20 - aj4.var_short_c);
            if (s3 <= 20) {
                aj4.m = (byte)(s3 / aj4.g);
                return;
            }
            ad.ad_b();
            aj4.m = (byte)(ad.c((s3 - 20) / aj4.g + 1) + 20 / aj4.g);
            return;
        }
        if (aj4.m <= 0) return;
        if (aj4.var_byte_b > 0) return;
        if (super.b(aj4, 0, (int)(aj4.n == 1 ? -aj4.g : aj4.g))) {
            aj4.b(0, (int)(aj4.n == 1 ? -aj4.g : aj4.g));
            aj4.m = (byte)(aj4.m - 1);
            aj4.var_byte_b = 1;
            aj4.b(true);
            return;
        }
        aj4.m = (byte)-20;
        aj4.var_byte_b = (byte)-1;
        aj4.b(false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean boolean_b(aj aj2, int n2) {
        if (aj2.m == 0) {
            if (aj2.var_byte_b != -1) return false;
            ad.ad_b();
            aj2.var_boolean_c = ad.c(100) < 50;
            ad.ad_b();
            if (ad.c(100) >= 50) return true;
            ad.ad_b();
            aj2.m = (byte)(-(ad.c(10) + 20));
            aj2.b(false);
            return false;
        }
        if (aj2.m >= 0) return true;
        aj2.m = (byte)(aj2.m + 1);
        return false;
    }

    private boolean b(aj aj2, int n2, int n3) {
        block3: {
            block2: {
                if (this.byte_b(aj2.var_short_b, (int)aj2.var_short_c, n2, n3, false) == 1) break block2;
                ad.ad_b();
                if (!ad.b(aj2.var_short_b + n2, aj2.var_short_c + n3, 19, 19, this.var_aj_b.var_short_b, this.var_aj_b.var_short_c, 19, 19)) break block3;
            }
            return false;
        }
        return true;
    }

    private void a(aj aj2, int n2) {
        if (aj2.m == 0 && aj2.var_byte_b == -1) {
            ad.ad_b();
            aj2.n = (byte)(ad.c(100) < 50 ? 1 : 2);
            n2 = aj2.n == 1 ? (int)((short)(aj2.var_short_c - aj2.var_byte_arr_b[1] * 20)) : (int)((short)((n2 + aj2.var_byte_arr_b[1]) * 20 - aj2.var_short_c));
            if (n2 <= 20) {
                aj2.m = (byte)(n2 / aj2.g);
                return;
            }
            ad.ad_b();
            aj2.m = (byte)(ad.c((n2 - 20) / aj2.g + 1) + 20 / aj2.g);
            return;
        }
        if (aj2.m > 0 && aj2.var_byte_b <= 0) {
            if (this.b(aj2, 0, (int)(aj2.n == 1 ? -aj2.g : aj2.g))) {
                aj2.b(0, (int)(aj2.n == 1 ? -aj2.g : aj2.g));
                aj2.m = (byte)(aj2.m - 1);
                aj2.var_byte_b = 1;
                aj2.b(true);
                return;
            }
            aj2.m = (byte)-20;
            aj2.var_byte_b = (byte)-1;
            aj2.b(false);
        }
    }

    private void e(aj aj2, int n2) {
        if (aj2.m == 0) {
            ad.ad_b();
            aj2.n = (byte)(ad.c(100) < 50 ? 3 : 4);
            n2 = aj2.n == 3 ? (int)((short)(aj2.var_short_b - aj2.var_byte_arr_b[0] * 20)) : (int)((short)((n2 + aj2.var_byte_arr_b[0]) * 20 - aj2.var_short_b));
            if (n2 <= 20) {
                aj2.m = (byte)(n2 / aj2.g);
                return;
            }
            ad.ad_b();
            aj2.m = (byte)(ad.c((n2 - 20) / aj2.g + 1) + 20 / aj2.g);
            return;
        }
        if (aj2.m > 0 && aj2.var_byte_b <= 0) {
            if (this.b(aj2, (int)(aj2.n == 3 ? -aj2.g : aj2.g), 0)) {
                aj2.b(aj2.n == 3 ? -aj2.g : aj2.g, 0);
                aj2.m = (byte)(aj2.m - 1);
                aj2.var_byte_b = 1;
                aj2.b(true);
                return;
            }
            aj2.m = (byte)-20;
            aj2.var_byte_b = (byte)-1;
            aj2.b(false);
        }
    }

    private void b(aj aj2, boolean bl) {
        boolean bl2 = aj2.var_boolean_b;
        short s2 = (short)(aj2.k * 20);
        short s3 = (short)(aj2.l * 20);
        if (aj2.var_short_b == s2 && aj2.var_short_c == s3) {
            if (aj2.var_byte_b == -1) {
                aj2.l = (byte)-1;
                aj2.k = (byte)-1;
                if (bl) {
                    aj aj3 = aj2;
                    aj3.var_byte_arr_b[0] = aj3.byte_b();
                    aj3.var_byte_arr_b[1] = aj3.byte_c();
                } else {
                    aj2.g = this.byte_b();
                }
                if (aj2.var_boolean_a) {
                    aj2.var_byte_arr_b[7] = aj2.h;
                    aj2.n = (byte)(aj2.h < 0 ? 4 : 3);
                    aj2.b(false, 127);
                    return;
                }
            }
        } else if (aj2.var_byte_b <= 0) {
            if (bl2) {
                bl2 = aj2.var_short_b != s2;
            } else {
                boolean bl3 = bl2 = aj2.var_short_c == s3;
            }
            if (bl2) {
                int n2;
                aj aj4;
                if (aj2.var_short_b > s2 && aj2.var_short_b - aj2.g < s2 || aj2.var_short_b < s2 && aj2.var_short_b + aj2.g > s2) {
                    aj4 = aj2;
                    n2 = s2 - aj2.var_short_b;
                } else {
                    aj4 = aj2;
                    n2 = aj2.var_short_b > s2 ? (int)(-aj2.g) : aj2.g;
                }
                aj4.b(n2, 0);
                if (!aj2.var_boolean_a) {
                    aj2.n = (byte)(aj2.var_short_b > s2 ? 3 : 4);
                }
            } else {
                int n3;
                int n4;
                aj aj5;
                if (aj2.var_short_c > s3 && aj2.var_short_c - aj2.g < s3 || aj2.var_short_c < s3 && aj2.var_short_c + aj2.g > s3) {
                    aj5 = aj2;
                    n4 = 0;
                    n3 = s3 - aj2.var_short_c;
                } else {
                    aj5 = aj2;
                    n4 = 0;
                    n3 = aj2.var_short_c > s3 ? (int)(-aj2.g) : aj2.g;
                }
                aj5.b(n4, n3);
                if (!aj2.var_boolean_a) {
                    aj2.n = (byte)(aj2.var_short_c > s3 ? 1 : 2);
                }
            }
            aj2.var_byte_b = aj2.var_byte_c;
            aj2.b(true);
        }
    }

    private void U() {
        if (this.L > 0) {
            byte by = this.L;
            this.L = (byte)(by - 1);
            if (by % 2 == 0) {
                ah.ah_b();
                ah.b(0xFFFFFF, 0, 0, 240, 320);
            }
        }
        if (this.var_boolean_g) {
            var_javax_microedition_lcdui_Graphics_b.setColor(0);
            var_javax_microedition_lcdui_Graphics_b.fillRect(0, this.var_short_p - 176 - this.var_short_o, 240, 176);
            var_javax_microedition_lcdui_Graphics_b.fillRect(0, 320 - this.var_short_p + this.var_short_o, 240, 176);
        }
        if (this.var_aj_b.var_byte_a == 22) {
            this.b(var_javax_microedition_lcdui_Graphics_b, this.var_byte_g == 2 ? 320 - ((byte)this.var_ak_b.var_byte_d).length * 24 >> 1 : 45, this.var_byte_g == 2);
        }
    }

    public final boolean boolean_b(int n2) {
        this.var_aj_b.var_byte_a = (byte)10;
        switch (n2) {
            case 0: 
            case 1: 
            case 2: {
                this.var_short_o = 0;
                this.var_short_p = (short)(n2 == 1 ? 176 : 0);
                this.var_boolean_g = n2 == 1;
                return true;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                this.var_boolean_g = true;
                if (this.var_short_o == 0) {
                    if (n2 == 6 || n2 == 5) {
                        this.var_short_o = (short)-40;
                        this.var_short_p = (short)(n2 == 5 ? 40 : 0);
                    } else {
                        this.var_short_p = this.var_short_o = (short)(n2 == 4 ? 176 : 40);
                    }
                }
                ad.ad_b();
                this.var_short_o = ad.b(this.var_short_o, 0, 12, false);
                if (this.var_short_o != 0) break;
                this.var_boolean_g = n2 != 6;
                return true;
            }
        }
        return false;
    }

    private void V() {
        if (this.var_byte_a == 24 || this.var_byte_a == 25 || this.var_byte_a == 26 || this.var_byte_a == 49 || this.var_byte_a == 50) {
            if (this.var_javax_microedition_lcdui_Image_a == null) {
                ad.ad_b();
                this.var_javax_microedition_lcdui_Image_a = ad.javax_microedition_lcdui_Image_b("data/cloud");
                this.var_short_arr_arr_e = null;
                this.var_short_arr_arr_e = new short[4][3];
            }
            for (int n2 = 0; n2 < this.var_short_arr_arr_e.length; n2 = (int)((byte)(n2 + 1))) {
                this.n(n2);
            }
            return;
        }
        this.var_short_arr_arr_e = null;
        this.var_javax_microedition_lcdui_Image_a = null;
    }

    private void W() {
        int n2;
        if (this.var_javax_microedition_lcdui_Image_a == null) {
            return;
        }
        for (n2 = 0; n2 < this.var_short_arr_arr_e.length; n2 = (int)((byte)(n2 + 1))) {
            ah.ah_b();
            ah.b(this.var_javax_microedition_lcdui_Image_a, this.var_int_c + this.var_short_arr_arr_e[n2][0], this.var_int_a + this.var_short_arr_arr_e[n2][1], 0);
        }
        for (n2 = 0; n2 < this.var_short_arr_arr_e.length; n2 = (int)((byte)(n2 + 1))) {
            if (!this.boolean_a((int)this.var_short_arr_arr_e[n2][0], (int)this.var_short_arr_arr_e[n2][1])) {
                this.n(n2);
                continue;
            }
            short[] sArray = this.var_short_arr_arr_e[n2];
            sArray[0] = (short)(sArray[0] - this.var_short_arr_arr_e[n2][2]);
        }
    }

    private void n(int n2) {
        short[] sArray = this.var_short_arr_arr_e[n2];
        ad.ad_b();
        sArray[0] = (short)(this.var_short_a * 20 + 240 + ad.c(120));
        short[] sArray2 = this.var_short_arr_arr_e[n2];
        ad.ad_b();
        sArray2[1] = (short)(this.var_short_e * 20 + 20 + 2 + n2 * (ad.c(25) + 55));
        short[] sArray3 = this.var_short_arr_arr_e[n2];
        ad.ad_b();
        sArray3[2] = (short)(ad.c(3) + 1);
    }

    private void a(Graphics graphics) {
        graphics.setColor(0);
        for (int n2 = 0; n2 < this.var_ak_b.var_byte_arr_arr_c.length; n2 = (int)((byte)(n2 + 1))) {
            ad.ad_b();
            if (ad.b(this.var_aj_b.var_short_b, this.var_aj_b.var_short_c, 19, 19, this.var_ak_b.var_byte_arr_arr_c[n2][0] * 20, this.var_ak_b.var_byte_arr_arr_c[n2][1] * 20, (this.var_ak_b.var_byte_arr_arr_c[n2][2] - this.var_ak_b.var_byte_arr_arr_c[n2][0] + 1) * 20, (this.var_ak_b.var_byte_arr_arr_c[n2][3] - this.var_ak_b.var_byte_arr_arr_c[n2][1] + 1) * 20)) continue;
            for (int n3 = 4; n3 < this.var_ak_b.var_byte_arr_arr_c[n2].length; n3 = (int)((byte)(n3 + 4))) {
                graphics.fillRect(this.var_int_c + this.var_ak_b.var_byte_arr_arr_c[n2][n3] * 20, this.var_int_a + this.var_ak_b.var_byte_arr_arr_c[n2][n3 + 1] * 20, (this.var_ak_b.var_byte_arr_arr_c[n2][n3 + 2] - this.var_ak_b.var_byte_arr_arr_c[n2][n3] + 1) * 20, (this.var_ak_b.var_byte_arr_arr_c[n2][n3 + 3] - this.var_ak_b.var_byte_arr_arr_c[n2][n3 + 1] + 1) * 20);
            }
        }
    }

    private void p(int n2) {
        this.var_aj_b.var_byte_a = (byte)9;
        this.var_byte_c = (byte)5;
        this.g();
        this.M = (byte)n2;
        this.var_ak_b.s = (byte[])false;
        this.var_aj_b.c(this.var_byte_arr_arr_b[this.M][this.var_ak_b.s], this.var_byte_arr_arr_b[this.M][this.var_ak_b.s + true]);
    }

    private void X() {
        if (this.M == -1 || this.var_aj_b.k != -1 || this.var_aj_b.l != -1) {
            return;
        }
        this.var_aj_b.var_byte_a = (byte)9;
        byte by = (byte)(this.var_ak_b.s + 2);
        this.var_ak_b.s = (byte[])by;
        if (by >= this.var_byte_arr_arr_b[this.M].length) {
            this.M = (byte)-1;
            this.var_aj_b.var_byte_a = 0;
            this.var_byte_c = (byte)-1;
            this.g();
            return;
        }
        this.C = at.b(this.var_byte_arr_arr_c, (int)this.var_aj_b.var_short_b, (int)this.var_aj_b.var_short_c);
        if (this.C != -1) {
            this.var_aj_b.var_byte_a = (byte)5;
            this.var_byte_k = this.C;
        }
        this.var_aj_b.c(this.var_byte_arr_arr_b[this.M][this.var_ak_b.s], this.var_byte_arr_arr_b[this.M][this.var_ak_b.s + true]);
    }

    private void b(boolean bl) {
        ai.ai_b().b(this.var_ak_b.var_byte_arr_e[this.var_byte_a]);
        ai.ai_b().b(false);
    }

    static {
        var_am_arr_arr_b = new am[3][];
    }
}

