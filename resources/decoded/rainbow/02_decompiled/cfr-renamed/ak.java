/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class ak
extends as {
    public byte var_byte_b = 0;
    public at var_at_b;
    public int var_int_b = 1000;
    public int var_int_c = 10;
    public byte var_byte_c = 1;
    private byte B;
    public byte var_byte_a;
    public byte var_byte_e = 0;
    private byte A;
    public byte var_byte_d;
    public byte var_byte_h = (byte)-1;
    public byte var_byte_g;
    public byte var_byte_f = 0;
    public static int var_int_a;
    private byte C = 0;
    private byte D;
    private byte F;
    private boolean var_boolean_b;
    private byte G = 0;
    private Image[] var_javax_microedition_lcdui_Image_arr_b;
    private byte[][] var_byte_arr_arr_f;
    private short[][] var_short_arr_arr_c;
    public byte var_byte_i;
    public byte var_byte_j = 0;
    private Image var_javax_microedition_lcdui_Image_c;
    private byte[][] var_byte_arr_arr_i;
    private byte H = (byte)8;
    private byte I = 0;
    private byte[][] var_byte_arr_arr_j = new byte[][]{{15, 14, 10, 6, 3, 1}, {23, 23, 22, 21, 20, 18}, {15, 18, 20, 21, 22, 23}, {0, 0, 1, 5, 9, 12}, {0, 1, 3, 6, 11, 14}, {15, 18, 20, 21, 22, 23}, {23, 23, 22, 21, 20, 18}, {15, 14, 10, 6, 3, 1}};
    private byte[][] var_byte_arr_arr_k;
    public int var_int_e = 0;
    private byte E;
    private byte J = 0;
    private byte[][] var_byte_arr_arr_l;
    private byte[] var_byte_arr_o = new byte[]{100, 120};
    public byte var_byte_k;
    private byte K;
    private short var_short_e;
    public short var_short_b;
    public byte var_byte_l;
    private byte L;
    private Image[] var_javax_microedition_lcdui_Image_arr_c;
    private Image[] var_javax_microedition_lcdui_Image_arr_a;
    private short var_short_d;
    private short var_short_h;
    private short var_short_g;
    private String var_java_lang_String_a;
    private byte[] var_byte_arr_q = new byte[]{-6, -4, -3, -2, -1, 0, 1, 2, 3, 4, 8, -3, 2, -1, 1, 1};
    private byte[][] var_byte_arr_arr_m = new byte[][]{{2, 3}, {3, 4}, {4, 0}, {0, 1}, {1, 2}};
    private int var_int_i = 0;
    private short var_short_f;
    public byte var_byte_m = (byte)-2;
    public int var_int_d = 0;
    public int var_int_h = 0;
    private am[] var_am_arr_b = new am[2];
    private am[] var_am_arr_c = new am[6];
    private short[] var_short_arr_b = new short[6];
    private short[] var_short_arr_c = new short[6];
    public byte var_byte_n = 0;
    public byte[][] var_byte_arr_arr_b;
    private boolean[] var_boolean_arr_b = new boolean[]{true, true, true, true, true};
    private byte[] s = new byte[2];
    private byte[] r = new byte[2];
    public String[] var_java_lang_String_arr_b = new String[]{"K\u1ebb \u0111\u1ecbch xu\u1ea5t hi\u1ec7n, chi\u1ebfn \u0111\u1ea5u!", "Th\u1eddi \u0111i\u1ec3m th\u1eed th\u00e1ch, hu\u1ea5n luy\u1ec7n s\u01b0!", "Nhi\u1ec7t t\u00ecnh thu th\u1eadp S\u1ee7ng V\u1eadt!"};
    public byte[] var_byte_arr_b;
    public byte[][] var_byte_arr_arr_c;
    public byte[] var_byte_arr_c;
    private byte M = 0;
    private byte N = 0;
    public byte[][] var_byte_arr_arr_a;
    private byte[] t;
    public short[][] var_short_arr_arr_b;
    public z var_z_b;
    private z var_z_c;
    private z var_z_a;
    private z var_z_e;
    public byte var_byte_p;
    public byte[] var_byte_arr_a;
    public byte[][] var_byte_arr_arr_e;
    private byte[] u;
    public byte[] var_byte_arr_e;
    private byte[] v;
    public byte[][] var_byte_arr_arr_d;
    private StringBuffer[] var_java_lang_StringBuffer_arr_g;
    private StringBuffer[] var_java_lang_StringBuffer_arr_f;
    private StringBuffer[] var_java_lang_StringBuffer_arr_i;
    private StringBuffer[] var_java_lang_StringBuffer_arr_j;
    private StringBuffer[] var_java_lang_StringBuffer_arr_k;
    private StringBuffer[] var_java_lang_StringBuffer_arr_l;
    private StringBuffer[] var_java_lang_StringBuffer_arr_m;
    private StringBuffer[] var_java_lang_StringBuffer_arr_n;
    private StringBuffer[] var_java_lang_StringBuffer_arr_p;
    public StringBuffer[] var_java_lang_StringBuffer_arr_b;
    private byte[] w = new byte[9];
    private byte[][] var_byte_arr_arr_n;
    private byte[][] var_byte_arr_arr_p;
    private byte[][] var_byte_arr_arr_o;
    private byte[][] var_byte_arr_arr_q;
    private Image[] var_javax_microedition_lcdui_Image_arr_e;
    private byte O = (byte)-124;

    public ak(ag object) {
        Object object2;
        var_byte_b = (byte)object;
        this.var_at_b = null;
        this.var_at_b = new at(this);
        object = this;
        if (((ak)object).var_javax_microedition_lcdui_Image_arr_c == null) {
            Image[] imageArray = ((ak)object).var_javax_microedition_lcdui_Image_arr_c = new Image[2];
            ad.ad_b();
            imageArray[0] = ad.javax_microedition_lcdui_Image_b("data/ball");
            Image[] imageArray2 = ((ak)object).var_javax_microedition_lcdui_Image_arr_c;
            ad.ad_b();
            imageArray2[1] = ad.javax_microedition_lcdui_Image_b("data/ll");
            object2 = object;
            ad.ad_b();
            ((ak)object).var_javax_microedition_lcdui_Image_c = ad.javax_microedition_lcdui_Image_b("data/item");
            ad.ad_b();
            ad.var_int_c = 0;
            ((ak)object2).var_byte_arr_arr_i = ad.ad_b().byte_arr_arr_b(ad.ad_b().byte_arr_b("data/item_m.d", -1));
        }
        if (((ak)object).var_javax_microedition_lcdui_Image_arr_a == null) {
            ((ak)object).var_javax_microedition_lcdui_Image_arr_a = new Image[5];
            for (int n2 = 0; n2 < ((ak)object).var_javax_microedition_lcdui_Image_arr_a.length; n2 = (int)((byte)(n2 + 1))) {
                Image[] imageArray = ((ak)object).var_javax_microedition_lcdui_Image_arr_a;
                ad.ad_b();
                imageArray[n2] = ad.javax_microedition_lcdui_Image_b("data/battle/" + n2);
            }
        }
        object2 = object;
        if (((ak)object2).var_javax_microedition_lcdui_Image_arr_e == null) {
            ad.ad_b();
            ((ak)object2).var_javax_microedition_lcdui_Image_arr_e = ad.b(2, "data/brow/i");
        }
        ah.ah_b().void_b();
        this.q();
    }

    public final void void_b() {
        ak.var_byte_b.var_javax_microedition_lcdui_Image_b = null;
        this.void_b(true);
        this.var_byte_b = (byte)null;
        this.var_int_c = (int)null;
        System.gc();
        var_byte_b.a();
        var_byte_b.e();
        this.var_java_lang_String_arr_c = new String[]{"Ch\u01a1i ti\u1ebfp", "Ch\u01a1i m\u1edbi", "\u00c2m l\u01b0\u1ee3ng     ", "Tr\u1ee3 gi\u00fap tr\u00f2 ch\u01a1i", "Gi\u1edbi thi\u1ec7u", "Tho\u00e1t"};
        byte by = (byte)(this.var_byte_arr_arr_l[0] == -1 ? 1 : 0);
        this.v = (byte[])by;
        this.u = (byte[])by;
    }

    public final void void_b(int n2) {
        if (n2 != 0) {
            this.var_byte_g = (byte)n2;
        } else {
            var_int_a = -10;
        }
        var_byte_b.d();
    }

    public final void void_b(boolean bl) {
        if (this.var_at_b != null) {
            this.var_at_b.f();
        }
        if (null != this.var_am_arr_b[0]) {
            this.var_am_arr_b[0].void_b();
        }
        if (null != this.var_am_arr_b[1]) {
            this.var_am_arr_b[1].void_b();
        }
        if (bl) {
            ak ak2 = this;
            this.var_byte_arr_arr_p = null;
            ak2.var_byte_arr_arr_d = null;
            ak2.var_byte_arr_arr_n = null;
            ak2.var_java_lang_StringBuffer_arr_g = null;
            ak2.var_java_lang_StringBuffer_arr_m = null;
            ak2.var_java_lang_StringBuffer_arr_n = null;
            ak2.var_java_lang_StringBuffer_arr_j = null;
            ak2.var_java_lang_StringBuffer_arr_f = null;
            ak2.var_java_lang_StringBuffer_arr_i = null;
        }
    }

    public final void void_c() {
        this.d(true);
        this.var_at_b.i();
        this.var_byte_d = (byte)2;
        this.var_byte_l = (byte)25;
        if (this.var_at_b.var_byte_b != -2) {
            this.var_at_b.var_byte_c = this.var_at_b.var_byte_b;
            this.var_at_b.var_byte_b = (byte)-2;
            this.var_at_b.g();
        }
    }

    public final void a() {
        int n2;
        this.var_at_b.void_c();
        this.j(0);
        this.j(1);
        ak ak2 = this;
        int n3 = 0;
        for (n2 = 0; n2 < 4; ++n2) {
            n3 += ((as)ak2).j[n2];
        }
        ak2.var_byte_arr_h = new byte[ak2.var_byte_arr_arr_arr_b.length + (n3 << 1)];
        n3 = 0;
        for (n2 = 0; n2 < 4; ++n2) {
            ak2.var_byte_arr_h[n2] = ((as)ak2).j[n2];
        }
        for (n2 = 0; n2 < ak2.var_byte_arr_arr_arr_b.length; ++n2) {
            int n4 = 0;
            while (n4 < ((as)ak2).j[n2]) {
                ak2.var_byte_arr_h[(n3 << 1) + 4] = ak2.var_byte_arr_arr_arr_b[n2][n4][0];
                ak2.var_byte_arr_h[(n3 << 1) + 4 + 1] = ak2.var_byte_arr_arr_arr_b[n2][n4][1];
                ++n4;
                ++n3;
            }
        }
        ad.ad_b();
        ad.byte_arr_b(4, ak2.var_byte_arr_h, 2);
        ak2.var_byte_arr_h = null;
        ak2 = this;
        ad.ad_b();
        ad.byte_arr_b(6, ((as)ak2).k, 2);
        this.var_byte_arr_arr_l[0] = (byte[])this.var_at_b.var_byte_a;
        ad.ad_b();
        ad.byte_arr_b(10, (byte[])this.var_byte_arr_arr_l, 2);
        ad.ad_b();
        ad.byte_arr_b(3, (byte[])this.var_byte_n, 2);
        ad.ad_b();
        ad.byte_arr_b(0, null, 4);
    }

    public final void e() {
        switch (var_int_a) {
            case -10: {
                this.var_at_b.d();
                return;
            }
            case -50: {
                ak ak2 = this;
                switch (ak2.C) {
                    case 0: {
                        if (ak2.var_z_b.f != 2 || ak2.var_z_b.f != 2) break;
                        if (ak2.var_byte_c == -2) {
                            ak2.v(0);
                            ak2.var_z_b.d = 0;
                            ak2.var_z_c.d = 0;
                        }
                        ak2.var_byte_c = (byte)-1;
                        ak2.at();
                        if (ak2.D == -3 || ak2.D == -2) {
                            ak2.C = ak2.D;
                            ak2.D = 0;
                            ak2.b(ak2.var_z_c, ak2.var_z_c.al_b(), ak2.var_z_b.al_b());
                        } else {
                            byte by = ak2.var_byte_f;
                            ak ak3 = ak2;
                            var_int_a = -31;
                            ak3.C = (byte)(by == 1 ? 2 : 1);
                            ak3.v(by);
                            if (by == 1) {
                                ak3.c(ak3.var_z_b.al_b());
                            }
                            ak3.b(ak3.var_z_b, ak3.var_z_b.al_b(), ak3.var_z_c.al_b());
                            ak3.b(ak3.var_z_c, ak3.var_z_c.al_b(), ak3.var_z_b.al_b());
                        }
                        if (ak2.M != 0) break;
                        ak2.M = 1;
                        byte by = (byte)(ak2.var_z_b.al_b().var_byte_arr_b[6] - 99);
                        if ((byte)(by > 1 ? 20 : by / 20 * 20) >= 0) break;
                        ak2.b("\u0110\u1ed9 h\u01b0ng ph\u1ea5n gi\u1ea3m, l\u1ef1c c\u00f4ng k\u00edch gi\u1ea3m, c\u1ea7n b\u1ed5 sung k\u1ecbp th\u1eddi!", -1);
                    }
                }
                return;
            }
            case -31: {
                this.an();
                return;
            }
            case -19: {
                if (this.var_short_d == 0 && this.var_byte_g == 0) {
                    void var1_2 = this.var_byte_b[this.u][this.var_byte_h[0][0]][0];
                    this.void_c((int)var1_2, 1);
                    byte[] byArray = new byte[]{1, 3, 14};
                    short s2 = (short)((short)(50 + byArray[var1_2 - 9] * 30 - this.var_z_c.al_b().var_byte_arr_b[2] + 60 / this.var_z_c.al_b().var_byte_arr_b[2] - this.var_z_c.al_b().var_short_arr_b[0] * 100 / this.var_z_c.al_b().var_short_arr_b[2]) * (7 - 2 * (this.var_z_c.al_b().var_byte_arr_b[5] - 1)) / 10);
                    if (this.var_z_c.al_b().boolean_b(3)) {
                        s2 = (short)(s2 + 30);
                    }
                    if (this.z == this.x && this.y == this.w) {
                        this.b("C\u00f3 th\u1ec3 mang theo S\u1ee7ng V\u1eadt \u0111\u00e3 \u0111\u1ea1t t\u1edbi h\u1ea1n m\u1ee9c cao nh\u1ea5t!", -1);
                        this.var_z_c.d = 1;
                        this.var_z_b.d = 0;
                        var_int_a = -31;
                        this.C = (byte)9;
                        return;
                    }
                    ad.ad_b();
                    if (ad.c(100) < s2) {
                        this.var_z_c.var_byte_c = (byte)2;
                        this.var_z_c.e = 1;
                        this.b("T\u00f3m \u0111\u01b0\u1ee3c" + this.java_lang_String_e(this.var_z_c.al_b().var_byte_arr_b[0]) + "Th\u00e0nh c\u00f4ng!", 0);
                        if (this.b(this.var_z_c.al_b(), -1, false) == 0) {
                            this.var_byte_b[this.y - 1].var_byte_arr_b[1] = (byte)(this.y - 1);
                        }
                        var_int_a = -31;
                        this.g(false);
                        return;
                    }
                    this.var_byte_g = 1;
                    StringBuffer stringBuffer = new StringBuffer("Kh\u00f4ng b\u1ecb b\u1eaft" + this.java_lang_String_e(this.var_z_c.al_b().var_byte_arr_b[0]));
                    if (this.var_z_b.al_b().a(41) || this.var_z_c.al_b().boolean_b(4) || this.var_z_c.al_b().boolean_b(3)) {
                        this.var_z_c.d = 1;
                        this.var_z_b.d = 0;
                        var_int_a = -31;
                        this.C = (byte)9;
                    } else {
                        String[] stringArray = new String[]{"Kh\u00f3c, ch\u1ea1y tr\u1ed1n!", "Li\u1ec1u m\u1ea1ng ch\u1ea1y tr\u1ed1n!", "Nh\u00ecn ch\u1eb1m ch\u1eb1m... \u0111\u00e0o t\u1ea9u!"};
                        StringBuffer stringBuffer2 = new StringBuffer("#n").append(this.java_lang_String_e(this.var_z_c.al_b().var_byte_arr_b[0]));
                        ad.ad_b();
                        stringBuffer.append(stringBuffer2.append(stringArray[ad.c(3)]).toString());
                    }
                    this.b(stringBuffer.toString(), -1);
                    return;
                }
                if (this.var_byte_g != 1 || this.var_byte_k != 0) break;
                this.ae();
                this.ah();
                this.O();
                return;
            }
            case -86: 
            case -15: {
                if (this.var_byte_g == 0) {
                    byte by;
                    if (this.var_byte_arr_arr_a[this.var_z_b.al_b().var_byte_arr_b[1]][0] == 1) {
                        this.var_byte_arr_arr_a[this.var_z_b.al_b().var_byte_arr_b[1]][0] = 0;
                        this.var_byte_g = 1;
                        this.var_short_b = (short)52;
                        this.void_b((int)this.var_z_b.var_byte_b, true);
                        this.b("Sinh m\u1ec7nh: +" + this.var_short_arr_arr_b[this.var_z_b.var_byte_b][0] + "#npow" + ": +" + this.var_short_arr_arr_b[this.var_z_b.var_byte_b][1], 240, 0);
                        this.b("S\u1ee9c m\u1ea1nh: +" + this.var_short_arr_arr_b[this.var_z_b.var_byte_b][3] + "#nPh\u00f2ng ng\u1ef1" + ": +" + this.var_short_arr_arr_b[this.var_z_b.var_byte_b][4] + "#nNhanh nh\u1eb9n" + ": +" + this.var_short_arr_arr_b[this.var_z_b.var_byte_b][5], 240, 1);
                        this.b(2, (int)this.var_byte_arr_arr_e[this.var_z_b.al_b().var_byte_arr_b[0]][0], 1);
                    } else {
                        this.var_z_b.var_byte_b = (byte)(this.var_z_b.var_byte_b + 1);
                    }
                    if (this.var_z_b.var_byte_b < this.y) break;
                    boolean bl = false;
                    StringBuffer stringBuffer = new StringBuffer("");
                    for (by = 0; by < this.y; by = (byte)(by + 1)) {
                        if (this.var_byte_b[by].var_byte_arr_b[5] <= 0 || !this.var_boolean_arr_b[by] || ak.b(this.var_byte_b[by].var_byte_arr_b[4], this.var_byte_b[by].var_byte_arr_b[2]) != -1) continue;
                        ad.ad_b();
                        if (!ad.b(stringBuffer, "")) {
                            stringBuffer.append(", ");
                        }
                        stringBuffer.append(this.java_lang_String_e(this.var_byte_b[by].var_byte_arr_b[0]));
                        this.var_boolean_arr_b[by] = false;
                        bl = true;
                    }
                    if (bl) {
                        stringBuffer.append("C\u00f3 th\u1ec3 ti\u1ebfn h\u00f3a");
                    }
                    StringBuffer stringBuffer3 = new StringBuffer("");
                    bl = false;
                    for (by = 0; by < 5; by = (byte)(by + 1)) {
                        if (this.byte_c(by) == -2 || this.short_b((int)by, 1) != this.short_b((int)by, 3)) continue;
                        ad.ad_b();
                        if (!ad.b(stringBuffer3, "")) {
                            stringBuffer3.append(", ");
                        }
                        stringBuffer3.append(this.var_java_lang_StringBuffer_arr_b[this.var_byte_arr_arr_d[this.byte_a(by)][6]] + "Tr\u1ee9ng S\u1ee7ng V\u1eadt");
                        bl = true;
                    }
                    if (bl) {
                        stringBuffer3.append("Kinh nghi\u1ec7m \u0111\u00e3 \u0111\u1ee7, c\u00f3 th\u1ec3 \u1ea5p tr\u1ee9ng.");
                        ad.ad_b();
                        if (!ad.b(stringBuffer, "")) {
                            stringBuffer.append("#n");
                        }
                        stringBuffer.append(stringBuffer3.toString());
                    }
                    ad.ad_b();
                    if (!ad.b(stringBuffer, "")) {
                        this.b(stringBuffer.toString(), -1);
                    }
                    this.ah();
                    this.O();
                    return;
                }
                if (this.var_byte_g != 1) break;
                ad.ad_b();
                this.var_short_b = ad.b((int)this.var_short_b, 4, true);
                return;
            }
            case -87: {
                return;
            }
            case -11: {
                this.d(false);
                return;
            }
            case -30: {
                if (this.var_byte_a != -1 || (this.var_byte_g = (byte)(this.var_byte_g + 1)) < 8) break;
                ak ak4 = this;
                var_int_a = -50;
                ak4.C = 0;
                ak4.var_short_e = (short)63;
                ak4.v(1);
                return;
            }
            case 100: {
                if (this.var_byte_g == 1 && !this.var_boolean_b) {
                    this.a();
                    this.var_boolean_b = true;
                    return;
                }
                if (this.var_byte_g != 1 || !this.var_boolean_b || (this.G = (byte)(this.G + 1)) <= 10) break;
                this.var_byte_g = 0;
                this.G = 0;
                this.d(true);
                return;
            }
            case 35: {
                this.J = (byte)(this.J + 1);
                if (this.J > 50) {
                    this.J = 0;
                    this.E = 1;
                }
                if (this.t != 2 || this.var_byte_g != -1 || this.var_short_b != 0) break;
                this.J();
                return;
            }
            case 69: {
                v.v_b().c();
                return;
            }
            case -20: {
                ar.b(this).c();
                return;
            }
            case -21: {
                ar.b(this).d();
            }
        }
    }

    public final void b(Graphics object) {
        switch (var_int_a) {
            case -10: {
                this.var_at_b.b((Graphics)object);
                break;
            }
            case -50: {
                this.ak();
                this.b(true, 227);
                this.b((Graphics)object, 0, 124, 10, false, this.var_byte_d[2] == false);
                this.b((Graphics)object, 116, 124, 10, true, this.var_byte_d[3] == false);
                object = this;
                switch (((ak)object).C) {
                    case 0: {
                        if (((ak)object).F > 2) {
                            if (((ak)object).var_byte_d[2] == false && ((ak)object).var_z_c.f == -1 && ((ak)object).var_byte_d[0] == 12) {
                                ((ak)object).var_z_c.f = 0;
                            } else if (((ak)object).var_z_c.f == 0 || ((ak)object).var_z_c.f == 2) {
                                super.b(0, 0, ((ak)object).var_byte_arr_arr_e[((ak)object).var_z_c.al_b().var_byte_arr_b[0]][1] * 3 + ((ak)object).var_z_c.var_byte_c, 177 + ((ak)object).var_short_e, 97, false, 0);
                                ad.ad_b();
                                ((ak)object).var_short_e = ad.b(((ak)object).var_short_e, 0, 4, false);
                                if (((ak)object).var_short_e == 0) {
                                    ((ak)object).var_z_c.f = (byte)2;
                                }
                            }
                        } else if (((ak)object).F < 2) {
                            super.b(((ak)object).var_z_c, ((ak)object).var_z_c.al_b(), 0, 177, 97);
                        }
                        super.b(((ak)object).var_z_b, ((ak)object).var_z_b.al_b(), 1, 46, 206);
                    }
                }
                break;
            }
            case -31: {
                this.ak();
                object = this;
                ((ak)object).aq();
                Object object2 = object;
                ah.ah_b();
                ah.a(137, 199, 103, 28);
                ah.ah_b().a(((ak)object2).var_z_b.al_b().var_byte_arr_b[3] + 5, 148, 213, 3, 0);
                ah.ah_b();
                ah.b(((ak)object2).java_lang_String_e(((ak)object2).var_z_b.al_b().var_byte_arr_b[0]).toString(), 198, 200, 17, 4, 2);
                ah.ah_b();
                ah.d(176, 184, 62, 14, 4);
                ah.ah_b().a(34, 178, 185, 0, 0);
                ah.ah_b().c(100 + ((ak)object2).var_z_b.var_byte_arr_b[0] + "%", 234, 197, 1, 1);
                super.ap();
                object2 = object;
                ah.ah_b();
                ah.a(0, 0, 103, 28);
                if (((ak)object2).var_z_c.al_b().var_byte_arr_b[3] != -1) {
                    ah.ah_b().a(((ak)object2).var_z_c.al_b().var_byte_arr_b[3] + 5, 11, 14, 3, 0);
                }
                ah.ah_b();
                ah.b(((ak)object2).java_lang_String_e(((ak)object2).var_z_c.al_b().var_byte_arr_b[0]).toString(), 61, 1, 17, 4, 2);
                ah.ah_b();
                ah.b(((ak)object2).var_z_c.al_b().var_byte_arr_b[2] + "\u0110\u1eb3ng c\u1ea5p", 105, 1, 0, 0, 2);
                ah.ah_b();
                ah.d(2, 29, 62, 14, 4);
                ah.ah_b().a(34, 4, 30, 0, 0);
                ah.ah_b().c(100 + ((ak)object2).var_z_c.var_byte_arr_b[0] + "%", 60, 42, 1, 1);
                ah.ah_b().a(((ak)object2).var_byte_arr_arr_k[((ak)object2).var_z_c.al_b().var_byte_arr_b[0]] == 2 ? 25 : 26, 66, 29, 0, 0);
                this.b(this.C != 2, 227);
                this.am();
                break;
            }
            case -19: {
                this.ak();
                this.b(true, 227);
                this.aq();
                this.ap();
                if (this.var_short_h < 17) {
                    this.var_short_g = (short)(this.var_short_g + this.var_short_h);
                    ad.ad_b();
                    this.var_short_h = ad.b(this.var_short_h, 17, 2, false);
                }
                ad.ad_b();
                this.var_short_d = ad.b(this.var_short_d, 0, 8, false);
                ah.ah_b();
                ah.b(this.var_javax_microedition_lcdui_Image_arr_c[0], 177 - this.var_short_d, (int)this.var_short_g, 33);
                break;
            }
            case -15: {
                object = this;
                if (((ak)object).var_byte_g != 1) break;
                ((ak)object).void_b(0, (int)((ak)object).var_z_b.var_byte_b, false);
                break;
            }
            case -32: {
                break;
            }
            case 97: {
                ah.ah_b();
                ah.d(-2, 0, 244, 28, 0);
                ah.ah_b();
                ah.b("\u0110\u1eb3ng c\u1ea5p hu\u1ea5n luy\u1ec7n s\u01b0: " + (int)this.var_byte_arr_arr_l[3], 120, 2, 17, 1, 2);
                int n2 = 200;
                n2 = 124;
                n2 = 40;
                int n3 = 63;
                Object object3 = this;
                ah.ah_b();
                ah.b(63, 40, 124, 200);
                ah.ah_b();
                ah.h(72, 71, 106, 180 - 3 * ((as)object3).var_java_lang_String_arr_c.length - 5, 0);
                ah.ah_b().b(((as)object3).var_java_lang_String_arr_c.length, 71, 73, 108, 1, 27, -1, ((as)object3).v, 4, 2);
                ah.ah_b();
                ah.b(((as)object3).var_java_lang_String_arr_c, 71, 73, 108, 26, ((as)object3).v, 0, 3, 0);
                if (((as)object3).u == 1) {
                    ah.ah_b();
                    ah.b(136, 104, (int)ai.ai_b().var_byte_b, ((as)object3).v == 1);
                }
                ah.ah_b();
                ah.h(125 + (((as)object3).u == 0 ? -40 : 0), 44, 40, 24, 4);
                ah.ah_b();
                ah.b("Menu", 106, 45, 17, ((as)object3).u == 0 ? 0 : 1, 0);
                ah.ah_b();
                ah.b("H\u1ec7 th\u1ed1ng", 144, 45, 17, ((as)object3).u == 0 ? 1 : 0, 0);
                ah.ah_b().b(125, 52, 57, true, true);
                ah.ah_b();
                ah.d(-2, 292, 244, 28, 0);
                this.b((String)this.var_byte_b, 294, 16, 3, 0, 2);
                if (this.var_byte_j != 0) {
                    object3 = "B\u1ea1n c\u00f3 mu\u1ed1n l\u01b0u tr\u1eef tr\u00f2 ch\u01a1i kh\u00f4ng?";
                    if (this.var_byte_j == 2) {
                        object3 = "B\u1ea1n c\u00f3 mu\u1ed1n ch\u01a1i ti\u1ebfp kh\u00f4ng?";
                    } else if (this.var_byte_j == 3) {
                        object3 = "N\u1ebfu kh\u00f4ng l\u01b0u tr\u1eef s\u1ebd m\u1ea5t d\u1eef li\u1ec7u, b\u1ea1n c\u00f3 mu\u1ed1n ti\u1ebfp t\u1ee5c kh\u00f4ng?";
                    }
                    ak.c((String)object3, 60, 0);
                }
                ah.ah_b().b(true, true);
                break;
            }
            case 61: {
                ag.h();
                ak.c("B\u1ea1n mu\u1ed1n ti\u1ebfp t\u1ee5c tr\u00f2 ch\u01a1i kh\u00f4ng?", 280, 0);
                ak.b((Object[])this.var_int_c, 82, 120, 76, 2, 0, this.var_byte_h);
                break;
            }
            case 60: {
                ag.h();
                ak.c("Th\u1ea5t b\u1ea1i, gi\u1ea5c m\u1ed9ng hu\u1ea5n luy\u1ec7n s\u01b0 kh\u00f4ng th\u1ec3 th\u1ef1c hi\u1ec7n!", 160, 0);
                break;
            }
            case 98: {
                ag.h();
                ah.ah_b();
                ah.h(-5, 260, 250, 60, 3);
                ak.b("Tr\u00f2 ch\u01a1i t\u1ea1m d\u1eebng, Nh\u1ea5n n\u00fat 0 \u0111\u1ec3 quay l\u1ea1i.", 120, 278, 11, 3);
                break;
            }
            case -11: {
                break;
            }
            case -30: {
                object = this;
                ak.b(0, 0, 240, 320, 1 + ((ak)object).var_byte_g, 6, 1, 2, 0xFFFFFF, 0x494949);
                break;
            }
            case 100: {
                this.var_byte_g = 1;
                if (!this.var_boolean_b) {
                    ak.c("L\u01b0u tr\u1eef trong tr\u00f2 ch\u01a1i", 20, 0);
                    break;
                }
                if (!this.var_boolean_b) break;
                ak.c("L\u01b0u tr\u1eef tr\u00f2 ch\u01a1i th\u00e0nh c\u00f4ng!", 20, 0);
                break;
            }
            case 52: {
                break;
            }
            case 51: {
                this.var_at_b.b((Graphics)object, 30, true);
                int n4 = 310;
                object = "K\u1ebft th\u00fac";
                ah.ah_b();
                ah.b("Nh\u1ea5n n\u00fat 0" + (String)object, 120, 310, 33, 0, 0);
                break;
            }
            case 25: {
                this.d(0, 0, 240, 320);
                break;
            }
            case 18: {
                this.w();
                break;
            }
            case 68: {
                this.G();
                break;
            }
            case 67: {
                this.n(this.byte_c());
                break;
            }
            case 35: {
                if (this.t == false) {
                    this.b((al[])(this.var_byte_f == 6 ? this.var_int_c : (int)this.var_byte_b));
                    break;
                }
                if (this.t == true) {
                    this.d((al)(this.var_byte_f == 6 ? this.var_int_c[this.v] : this.var_byte_b[this.v]));
                    break;
                }
                if (this.t != 2) break;
                this.void_b(1, (int)this.v, false);
                break;
            }
            case 65: {
                this.A();
                break;
            }
            case 66: {
                this.C();
                break;
            }
            case 69: {
                v.v_b().void_b();
                break;
            }
            case -20: {
                ar.b(this).void_b();
                break;
            }
            case -21: {
                ar.b(this).e();
            }
        }
        if (this.var_byte_k != 0) {
            this.f();
        }
    }

    private boolean b(z z2, al al2, al al3, int n2) {
        if (al3.var_byte_b != 7) {
            return false;
        }
        byte by = this.var_byte_arr_arr_n[n2][3];
        byte by2 = this.var_byte_arr_arr_n[n2][2];
        if (by2 == 0) {
            return false;
        }
        if (by == 0) {
            if (al3.e(5)) {
                by2 = (byte)(by2 + this.var_byte_arr_a[5]);
            } else if (al3.e(6)) {
                by2 = (byte)(by2 + this.var_byte_arr_a[6]);
            }
        } else if (by == 4) {
            if (al3.e(7)) {
                by2 = (byte)(by2 + this.var_byte_arr_a[7]);
            } else if (al3.e(8)) {
                by2 = (byte)(by2 + this.var_byte_arr_a[8]);
            }
        } else if (by == 2 || by == 5) {
            if (al3.e(11)) {
                by2 = (byte)(by2 + this.var_byte_arr_a[11]);
            } else if (al3.e(12)) {
                by2 = (byte)(by2 + this.var_byte_arr_a[12]);
            }
        }
        ad.ad_b();
        if (ad.c(100) < by2) {
            al3.var_byte_b = by;
            if (by == 3 || by == 4 || by == 5) {
                al3.c = (byte)4;
            } else if (by == 2) {
                al3.c = (byte)(al2.a(32) ? 5 : 4);
            } else if (by == 0) {
                al3.c = (byte)2;
            } else if (by == 6) {
                if (al3.var_byte_arr_b[3] == -1) {
                    al3.var_byte_b = (byte)7;
                    this.b("\u0110\u00e3 \u0111\u00f3ng b\u0103ng, t\u1ea1i Qu\u1ef7 V\u01b0\u01a1ng \u0110\u1ecba Ph\u1ee7 kh\u00f4ng c\u00f3 t\u00e1c d\u1ee5ng", -1);
                } else {
                    al3.c = (byte)4;
                }
            }
            if (by == 5) {
                z2.h = (byte)(n2 + (al2.a(31) ? this.var_byte_arr_arr_n[31][0] : 1));
            }
            return true;
        }
        return false;
    }

    private static void b(int n2, al al2) {
        if ((n2 += al2.var_short_arr_b[1]) > al2.var_short_arr_b[3]) {
            al2.var_short_arr_b[1] = al2.var_short_arr_b[3];
            return;
        }
        al2.var_short_arr_b[1] = (short)n2;
    }

    private static void c(int n2, al al2) {
        if ((n2 += al2.var_short_arr_b[0]) >= al2.var_short_arr_b[2]) {
            al2.var_short_arr_b[0] = al2.var_short_arr_b[2];
            return;
        }
        al2.var_short_arr_b[0] = (short)n2;
    }

    private void b(al al2, int n2, int n3) {
        if (al2.var_byte_b >= 0 && al2.var_byte_b < 7 && al2.c > 0) {
            ah.ah_b();
            ah.b(this.var_javax_microedition_lcdui_Image_arr_b[al2.var_byte_b], n2, n3, 40);
            ah.ah_b().c("" + al2.c, n2, n3, 40, 0);
        }
    }

    private static void e(al al2) {
        if (al2.c > 0) {
            al2.c = (byte)(al2.c - 1);
        }
        if (al2.c == 0) {
            al2.var_byte_b = (byte)7;
        }
    }

    public final void void_b(int n2, int n3) {
        this.var_java_lang_String_arr_c = n3 != 1 ? new String[]{"\u0110\u1ea1o c\u1ee5", "Kho\u00e1ng th\u1ea1ch", "Huy ch\u01b0\u01a1ng"} : new String[]{"\u0110\u1ea1o c\u1ee5", "Tr\u1ee3 gi\u00fap", "V\u00f2ng"};
        this.s = (byte[])((byte)n2);
        this.r = (byte[])((byte)n3);
        this.var_byte_h[0][0] = false;
        this.var_byte_h[0][1] = false;
        var_int_a = 18;
        this.H = (byte)7;
        this.var_byte_j = 0;
        this.var_byte_h = (byte)-1;
        byte[] byArray = ad.ad_b().byte_arr_b("data/shop.d", -1);
        ad.ad_b();
        ad.var_int_c = 0;
        this.var_byte_arr_arr_f = ad.ad_b().byte_arr_arr_b(byArray);
        this.var_short_arr_arr_c = ad.ad_b().short_arr_arr_b(byArray, 0);
    }

    private short short_b(int n2, int n3, boolean bl) {
        if (bl) {
            int n4 = n2 = n2 == 2 ? this.var_short_arr_arr_c[1][n3] : this.var_short_arr_arr_c[0][this.var_byte_arr_arr_f[this.s][n3]];
            if (this.var_byte_c == -1) {
                n2 = (short)(n2 * 12 / 10);
            }
        } else {
            n2 = (short)(this.var_short_arr_arr_c[0][n3] / 5);
        }
        return (short)n2;
    }

    private int int_b(int n2, int n3, boolean bl) {
        if (bl) {
            n2 = n2 == 2 ? this.var_int_c / this.var_int_e : this.var_int_b / this.var_int_e;
            if ((n3 = 99 - this.byte_b(-2, (int)this.var_byte_arr_arr_f[this.s][n3], true)) < 0) {
                n3 = 0;
            }
            if (n2 > n3) {
                return n3;
            }
            return n2;
        }
        return (int)this.var_byte_b[this.s][n3][1];
    }

    private void w() {
        int n2;
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.b(1, 2, 238, 318);
        if (this.r == false) {
            ah.ah_b();
            ah.h(97, 6, 46, 23, 4);
            ah.ah_b();
            ah.b((String)this.var_int_c[this.s], 120, 7, 17, 0, 0);
        } else {
            ah.ah_b();
            ah.h(26 + this.s * 67, 6, 50, 23, 4);
            for (n2 = 0; n2 < 3; n2 = (int)((byte)(n2 + 1))) {
                ah.ah_b();
                ah.b((String)this.var_int_c[n2], 36 + n2 * 67, 5, 0, this.s == n2 ? 0 : 4, 0);
            }
            ah.ah_b().b(120, 15, 118, true, true);
        }
        ah.ah_b();
        ah.h(6, 32, 214, this.H * 25 + 6, 1);
        ah.ah_b();
        ah.h(6, 32 + 25 * this.H + 16, 228, 75, 2);
        n2 = (byte)(this.r == true ? this.var_byte_j[this.s] : this.var_byte_arr_arr_f[this.s].length);
        this.b(10, 35, 214, this.H, (byte[])this.var_byte_h[0], (int)this.s, n2, this.r == true ? 2 : 1);
        ah.ah_b().b(225, 37, this.H * 25 - 6, (int)this.var_byte_h[0][0], n2, true);
        if (n2 > 0) {
            n2 = this.r == true ? this.var_byte_b[this.s][this.var_byte_h[0][0]][0] : this.var_byte_arr_arr_f[this.s][this.var_byte_h[0][0]];
            ak.b(this.var_java_lang_StringBuffer_arr_f[n2].toString(), 120, 32 + 25 * this.H + 18, 12, 3);
        }
        this.void_b(120, 318, 0, this.r != true && this.s == 2);
        if (this.var_byte_h != -1) {
            if (this.var_byte_j == 1 && this.r != true && this.var_byte_arr_arr_f[this.s][this.var_byte_h[0][0]] >= 35 && this.u[this.var_byte_arr_arr_f[this.s][this.var_byte_h[0][0]] - 35] > this.var_byte_arr_arr_l[3]) {
                ah.ah_b();
                ah.a(-5, 120, 250, 88);
                ak.b("Y\u00eau c\u1ea7u hu\u1ea5n luy\u1ec7n s\u01b0" + this.u[this.var_byte_arr_arr_f[this.s][this.var_byte_h[0][0]] - 35] + "T\u00ecm hi\u1ec3u v\u1ec1 \u0111\u1eb3ng c\u1ea5p m\u1edbi!", 120, 140, 12, 3);
                ak.c("B\u1ea1n c\u00f3 mu\u1ed1n mua s\u1eafm kh\u00f4ng?", 180, 0);
            } else {
                int n3 = n2;
                int n4 = this.r == true ? 1 : (this.s == 2 ? 16 : 17);
                n2 = 40;
                n2 = 76;
                n2 = 160;
                n2 = 120;
                int n5 = n3;
                ak ak2 = this;
                ah.ah_b();
                ah.a(44, 120, 152, 80);
                int n6 = 120 + ((n4 & 0x10) != 0 ? 2 : 12);
                ah.ah_b();
                ah.b("S\u1ed1 l\u01b0\u1ee3ng: " + ak2.var_byte_h + "/" + ak2.A, 120, n6, 17, 3, 0);
                StringBuffer stringBuffer = new StringBuffer();
                if ((n4 & 0x10) != 0) {
                    stringBuffer.append("C\u1ea7n: ");
                } else {
                    stringBuffer.append("\u0110\u1ea1t \u0111\u01b0\u1ee3c: ");
                }
                stringBuffer.append(ak2.var_int_e * ak2.var_byte_h);
                if ((n4 & 1) != 0) {
                    stringBuffer.append("Kim");
                } else {
                    stringBuffer.append("Huy ch\u01b0\u01a1ng");
                }
                ah.ah_b();
                ah.b(stringBuffer.toString(), 120, n6 + 20 + 4, 17, 6, 0);
                if ((n4 & 0x10) != 0) {
                    ah.ah_b();
                    ah.b("Hi\u1ec7n t\u1ea1i: " + ak2.byte_b(-2, n5, true), 120, n6 + 48, 17, 3, 0);
                }
                ah.ah_b().b(120, 158, 76, true, ak2.r != 2);
                if (ak2.var_byte_j == 1) {
                    ak.c("C\u00f3 hay kh\u00f4ng" + ((n4 & 0x10) != 0 ? "Mua" : "B\u00e1n \u0111i") + "?", 180, 0);
                }
            }
        }
        ah.ah_b().b(true, true);
    }

    private void void_b(int n2, int n3, int n4, int n5, int n6, int n7) {
        ah.ah_b();
        ah.a(44, 120, 152, 80);
        n3 = 120 + ((n7 & 0x10) != 0 ? 2 : 12);
        ah.ah_b();
        ah.b("S\u1ed1 l\u01b0\u1ee3ng: " + this.var_byte_h + "/" + this.A, 120, n3, 17, 3, 0);
        StringBuffer stringBuffer = new StringBuffer();
        if ((n7 & 0x10) != 0) {
            stringBuffer.append("C\u1ea7n: ");
        } else {
            stringBuffer.append("\u0110\u1ea1t \u0111\u01b0\u1ee3c: ");
        }
        stringBuffer.append(this.var_int_e * this.var_byte_h);
        if ((n7 & 1) != 0) {
            stringBuffer.append("Kim");
        } else {
            stringBuffer.append("Huy ch\u01b0\u01a1ng");
        }
        ah.ah_b();
        ah.b(stringBuffer.toString(), 120, n3 + 20 + 4, 17, 6, 0);
        if ((n7 & 0x10) != 0) {
            ah.ah_b();
            ah.b("Hi\u1ec7n t\u1ea1i: " + this.byte_b(-2, n2, true), 120, n3 + 48, 17, 3, 0);
        }
        ah.ah_b().b(120, 158, 76, true, this.r != 2);
        if (this.var_byte_j == 1) {
            ak.c("C\u00f3 hay kh\u00f4ng" + ((n7 & 0x10) != 0 ? "Mua" : "B\u00e1n \u0111i") + "?", 180, 0);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void x() {
        block24: {
            block25: {
                block26: {
                    block28: {
                        block32: {
                            block30: {
                                block31: {
                                    block29: {
                                        block27: {
                                            block23: {
                                                ad.ad_b();
                                                if (ad.boolean_b()) {
                                                    return;
                                                }
                                                if (this.var_byte_h != -1) break block23;
                                                ad.ad_b();
                                                if (ad.e() && this.r != false) {
                                                    ad.ad_b();
                                                    this.s = (byte[])ad.byte_b((int)this.s, 0, 2);
                                                    this.var_byte_h[0][0] = false;
                                                    this.var_byte_h[0][1] = false;
                                                    return;
                                                }
                                                ad.ad_b();
                                                if (ad.boolean_c()) {
                                                    ad.ad_b();
                                                    ad.b((byte[])this.var_byte_h[0], 0, this.r == true ? this.var_byte_j[this.s] : this.var_byte_arr_arr_f[this.s].length, this.H);
                                                    return;
                                                }
                                                ad.ad_b();
                                                if (ad.g()) {
                                                    this.var_byte_h = 1;
                                                    this.var_int_e = this.short_b((int)this.s, (int)(this.r != true ? this.var_byte_h[0][0] : this.var_byte_b[this.s][this.var_byte_h[0][0]][0]), this.r != true);
                                                    var4_1 = this.r != true;
                                                    var3_3 = this.var_byte_h[0][0];
                                                    var2_5 /* !! */  = this.s;
                                                    var1_7 = this;
                                                    if (var4_1) {
                                                        var2_5 /* !! */  = (byte[])(var2_5 /* !! */  == 2 ? var1_7.var_int_c / var1_7.var_int_e : var1_7.var_int_b / var1_7.var_int_e);
                                                        var1_8 = 99 - var1_7.byte_b(-2, (int)var1_7.var_byte_arr_arr_f[var1_7.s][var3_3], true);
                                                        if (var1_8 < 0) {
                                                            var1_8 = 0;
                                                        }
                                                        v0 /* !! */  = var2_5 /* !! */  > var1_8 ? var1_8 : (int)var2_5 /* !! */ ;
                                                    } else {
                                                        v0 /* !! */  = var1_7.var_byte_b[var1_7.s][var3_3][1];
                                                    }
                                                    this.A = (byte)v0 /* !! */ ;
                                                    return;
                                                }
                                                ad.ad_b();
                                                if (ad.i()) {
                                                    this.var_byte_arr_arr_f = null;
                                                    this.var_short_arr_arr_c = null;
                                                    if (this.var_byte_c == -1) {
                                                        this.at();
                                                        return;
                                                    }
                                                    this.O();
                                                    return;
                                                }
                                                break block24;
                                            }
                                            if (this.var_byte_j == 0) {
                                                ad.ad_b();
                                                if (ad.e()) {
                                                    ad.ad_b();
                                                    this.var_byte_h = ad.byte_b((int)this.var_byte_h, 1, (int)this.A);
                                                    return;
                                                }
                                            }
                                            ad.ad_b();
                                            if (!ad.g()) break block25;
                                            if (this.var_byte_j != 1) break block26;
                                            if (this.r != true) break block27;
                                            this.var_int_b += this.var_int_e * this.var_byte_h;
                                            this.void_c((int)this.var_byte_b[this.s][this.var_byte_h[0][0]][0], this.var_byte_h);
                                            if (this.var_byte_h[0][0] >= this.var_byte_j[this.s]) {
                                                v1 = this.var_byte_h[0];
                                                v1[0] = (byte)(v1[0] - true);
                                                if (v1[0] < 0) {
                                                    this.var_byte_h[0][0] = false;
                                                }
                                                v2 = this.var_byte_h[0];
                                                v2[1] = (byte)(v2[1] - true);
                                                if (v2[1] < 0) {
                                                    this.var_byte_h[0][1] = false;
                                                }
                                            }
                                            this.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c kim ti\u1ec1n: " + this.var_int_e * this.var_byte_h, -1);
                                            break block28;
                                        }
                                        var4_2 = this.s != 2;
                                        var3_4 = this.var_byte_h;
                                        var1_9 = this;
                                        var2_6 = this.var_byte_arr_arr_f[this.s][this.var_byte_h[0][0]];
                                        if (var1_9.byte_b(-2, (int)var2_6, true) + var3_4 <= 99) break block29;
                                        var1_9.b("S\u1ed1 l\u01b0\u1ee3ng \u0111\u00e3 \u0111\u1ea1t gi\u1edbi h\u1ea1n t\u1ed1i \u0111a", 0);
                                        ** GOTO lbl108
                                    }
                                    if (!var4_2) break block30;
                                    if (var1_9.var_int_b < var1_9.var_int_e * var3_4) break block31;
                                    var1_9.var_int_b -= var1_9.var_int_e * var3_4;
                                    v3 = true;
                                    break block32;
                                }
                                if (var1_9.var_int_b < var1_9.var_int_e * var3_4) {
                                    var1_9.b("Kim ti\u1ec1n kh\u00f4ng \u0111\u1ee7!", 0);
                                } else {
                                    var1_9.b("Kho\u1ea3ng chi\u1ebfm ch\u1ed7 kh\u00f4ng \u0111\u1ee7.", 0);
                                }
                                ** GOTO lbl108
                            }
                            if (var1_9.var_int_c >= var1_9.var_int_e * var3_4) {
                                var1_9.var_int_c -= var1_9.var_int_e * var3_4;
                                v3 = true;
                            } else {
                                if (var1_9.var_int_c < var1_9.var_int_e * var3_4) {
                                    var1_9.b("Huy ch\u01b0\u01a1ng kh\u00f4ng \u0111\u1ee7!", 0);
                                } else {
                                    var1_9.b("Kho\u1ea3ng chi\u1ebfm ch\u1ed7 kh\u00f4ng \u0111\u1ee7.", 0);
                                }
lbl108:
                                // 5 sources

                                v3 = false;
                            }
                        }
                        if (v3 && this.byte_e(this.var_byte_arr_arr_f[this.s][this.var_byte_h[0][0]], this.var_byte_h) != -1) {
                            this.b("Mua th\u00e0nh c\u00f4ng", -1);
                        }
                    }
                    this.var_byte_j = 0;
                    this.var_byte_h = (byte)-1;
                    return;
                }
                this.var_byte_j = 1;
                return;
            }
            ad.ad_b();
            if (ad.i()) {
                if (this.var_byte_j == 0) {
                    this.var_byte_h = (byte)-1;
                    return;
                }
                this.var_byte_j = 0;
            }
        }
    }

    private boolean boolean_b(int n2, int n3, boolean bl) {
        if (this.byte_b(-2, n2, true) + n3 > 99) {
            this.b("S\u1ed1 l\u01b0\u1ee3ng \u0111\u00e3 \u0111\u1ea1t gi\u1edbi h\u1ea1n t\u1ed1i \u0111a", 0);
            return false;
        }
        if (bl) {
            if (this.var_int_b >= this.var_int_e * n3) {
                this.var_int_b -= this.var_int_e * n3;
                return true;
            }
            if (this.var_int_b < this.var_int_e * n3) {
                this.b("Kim ti\u1ec1n kh\u00f4ng \u0111\u1ee7!", 0);
            } else {
                this.b("Kho\u1ea3ng chi\u1ebfm ch\u1ed7 kh\u00f4ng \u0111\u1ee7.", 0);
            }
        } else {
            if (this.var_int_c >= this.var_int_e * n3) {
                this.var_int_c -= this.var_int_e * n3;
                return true;
            }
            if (this.var_int_c < this.var_int_e * n3) {
                this.b("Huy ch\u01b0\u01a1ng kh\u00f4ng \u0111\u1ee7!", 0);
            } else {
                this.b("Kho\u1ea3ng chi\u1ebfm ch\u1ed7 kh\u00f4ng \u0111\u1ee7.", 0);
            }
        }
        return false;
    }

    public final boolean boolean_b(int n2, boolean bl) {
        if (this.var_int_b >= n2) {
            this.var_int_b -= n2;
            return true;
        }
        this.b("Kim ti\u1ec1n kh\u00f4ng \u0111\u1ee7!", 0);
        return false;
    }

    private void d(int n2, int n3, int n4, int n5) {
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.b(1, 3, 238, 317);
        ah.ah_b();
        ah.h(5, 34, 217, 26 * this.H, 1);
        ah.ah_b();
        ah.h(5, 40 + 26 * this.H, 230, 75, 2);
        if (n2 == 0) {
            ah.ah_b();
            ah.h(92, 8, 54, 23, 4);
            ah.ah_b();
            ah.b((String)this.var_int_c[n2], 120, 9, 17, 0, 0);
        } else {
            ah.ah_b();
            ah.h(0 + (this.u + true) * 240 / 5 - 22, 8, 46, 23, 4);
            for (n2 = (int)((byte)(((int)this.var_int_c).length - 1)); n2 >= 0; n2 = (int)((byte)(n2 - 1))) {
                ah.ah_b();
                ah.b((String)this.var_int_c[n2], 0 + (n2 + 1) * 240 / 5 - 14, 9, 0, this.u == n2 ? 0 : 1, 0);
            }
            ah.ah_b().b(120, 16, 116, true, true);
        }
        this.b(9, 37, 217, this.H, (byte[])this.var_byte_h[0], (int)this.u, (int)this.var_byte_j[this.u], 0);
        ah.ah_b().b(225, 37, this.H * 26 - 6, (int)this.var_byte_h[0][0], (int)this.var_byte_j[this.u], true);
        if (this.var_byte_j[this.u] > 0) {
            ak.b(this.var_java_lang_StringBuffer_arr_f[this.var_byte_b[this.u][this.var_byte_h[0][0]][0]].toString(), 120, 42 + 26 * this.H, 12, 3);
        }
        this.void_b(120, 318, 0, this.u == 2);
        ah.ah_b().b(this.var_byte_j[this.u] > 0, true);
        if (this.var_byte_h != -1) {
            ak.b((Object[])this.var_int_c, 93, 50, 57, 2, 0, this.var_byte_h);
        }
    }

    public final void void_b(int n2, int n3, int n4, boolean bl) {
        String string = (bl ? this.var_int_c : this.var_int_b) + (bl ? "Huy ch\u01b0\u01a1ng" : "Kim");
        ah ah2 = ah.ah_b();
        int n5 = bl ? 53 : 52;
        ad.ad_b();
        ah2.a(n5, n2 - (ad.int_b(string) >> 1) - 1, n3, 40, 0);
        ah.ah_b();
        ah.b(string, n2 + 4, n3 - 1, 33, n4, 1);
    }

    private void b(int n2, int n3, int n4, int n5, byte[] byArray, int n6, int n7, int n8) {
        int n9 = n3 + 2;
        String string = null;
        ah.ah_b().b(n5, n2 - 4, n3, n4, 4, 26, -1, byArray[0] - byArray[1], 4, 2);
        for (byte by = byArray[1]; by < byArray[1] + n5; by = (byte)(by + 1)) {
            if (by >= n7) continue;
            if (n8 == 0 || n8 == 2) {
                this.void_b((int)this.var_byte_b[n6][by][0], n2 + 3, n3 + 4 + (by - byArray[1]) * 25, 0);
                ah.ah_b();
                ah.b(this.java_lang_String_c((int)this.var_byte_b[n6][by][0]), n2 + 21, n9 + 1 + (by - byArray[1]) * 25, 0, byArray[0] == by ? 0 : 3, 0);
                string = n8 == 2 ? this.short_b(n6, (int)this.var_byte_b[n6][by][0], false) + "Kim" : "x" + (int)this.var_byte_b[n6][by][1];
                ah.ah_b();
                ah.b(string, n2 + n4 - 12, n9 + 1 + (by - byArray[1]) * 25, 24, byArray[0] == by ? 0 : 3, 0);
                continue;
            }
            this.void_b((int)this.var_byte_arr_arr_f[n6][by], n2 + 2, n3 + 4 + (by - byArray[1]) * 25, 0);
            byte by2 = (byte)(byArray[0] == by ? 0 : 3);
            ah.ah_b();
            ah.b(this.java_lang_String_c(this.var_byte_arr_arr_f[n6][by]), n2 + 20, n9 + (by - byArray[1]) * 25, 0, (int)by2, 0);
            string = n6 == 2 ? "Huy ch\u01b0\u01a1ng" : "Kim";
            ah.ah_b();
            ah.b(this.short_b(n6, (int)by, true) + string, n2 + n4 - 12, n9 + 1 + (by - byArray[1]) * 25, 24, (int)by2, 0);
        }
    }

    private void y() {
        ad.ad_b();
        this.var_javax_microedition_lcdui_Image_c = ad.javax_microedition_lcdui_Image_b("data/item");
        ad.ad_b();
        ad.var_int_c = 0;
        this.var_byte_arr_arr_i = ad.ad_b().byte_arr_arr_b(ad.ad_b().byte_arr_b("data/item_m.d", -1));
    }

    public final void void_b(int n2, int n3, int n4, int n5) {
        if (n2 >= 58) {
            n2 = 40 + this.var_byte_arr_arr_d[this.var_byte_g[0][n2 - 58]][6];
        } else if (n2 >= 35) {
            n2 = 34 + this.u[n2 - 35];
        }
        ah.ah_b();
        ah.b(this.var_javax_microedition_lcdui_Image_c, this.var_byte_arr_arr_i[n2][0], this.var_byte_arr_arr_i[n2][1], this.var_byte_arr_arr_i[n2][2], this.var_byte_arr_arr_i[n2][3], n3, n4, n5, 0, (Graphics)var_int_c);
    }

    /*
     * Unable to fully structure code
     */
    private void void_a(int var1_1, int var2_2) {
        var3_4 = "Quay l\u1ea1i";
        var2_2 = this.var_byte_b[var1_1][var2_2][0];
        if (var1_1 != 0 && var2_2 != 32 && var2_2 != 33) ** GOTO lbl-1000
        var4_5 = var2_2;
        var2_3 = this;
        v0 = var2_3.var_byte_c == -1 ? var4_5 != 14 && var4_5 != 15 : var4_5 != 9 && var4_5 != 10 && var4_5 != 11 && var4_5 != 8;
        if (v0) {
            var3_4 = "S\u1eed d\u1ee5ng#nQuay l\u1ea1i";
        } else if (var1_1 == 2) {
            var3_4 = "H\u1ecdc#nQuay l\u1ea1i";
        } else if (this.var_byte_c == 2 && var1_1 == 3) {
            var3_4 = "\u1ea4p tr\u1ee9ng#nQuay l\u1ea1i";
        }
        this.b(var3_4, 240, 0);
        this.var_byte_h = 0;
    }

    private boolean boolean_a(int n2) {
        if (this.var_byte_c == -1) {
            return n2 != 14 && n2 != 15;
        }
        return n2 != 9 && n2 != 10 && n2 != 11 && n2 != 8;
    }

    /*
     * Unable to fully structure code
     */
    private void z() {
        block24: {
            block26: {
                block25: {
                    ad.ad_b();
                    if (ad.boolean_c()) {
                        ad.ad_b();
                        this.var_byte_h = ad.byte_b((int)this.var_byte_h, 0, ((int)this.var_int_c).length - 1);
                    }
                    ad.ad_b();
                    if (!ad.g()) break block24;
                    var1_1 = this.var_byte_b[this.u][this.var_byte_h[0][0]][0];
                    ad.ad_b();
                    if (!ad.b((StringBuffer)this.var_int_c[this.var_byte_h], "S\u1eed d\u1ee5ng")) break block25;
                    switch (var1_1) {
                        case 9: 
                        case 10: 
                        case 11: {
                            if (this.F == 4 || this.F == 1) {
                                var1_2 = this;
                                ak.var_int_a = -19;
                                var1_2.var_short_d = (short)151;
                                var1_2.var_short_h = (short)-20;
                                var1_2.var_short_g = (short)146;
                                var1_2.var_byte_g = 0;
                                break;
                            }
                            this.b("Tr\u01b0\u1eddng h\u1ee3p \u0111\u1eb7c bi\u1ec7t, kh\u00f4ng th\u1ec3 b\u1eaft \u0111\u01b0\u1ee3c!", 1);
                            ad.ad_b().var_int_b = 400;
                            break;
                        }
                        case 14: 
                        case 15: {
                            this.var_byte_h = (byte)-1;
                            if (this.var_at_b.var_byte_e == 0) {
                                this.var_at_b.void_b(1, var1_1);
                                this.b("S\u1eed d\u1ee5ng" + this.java_lang_String_c(var1_1) + ", \u0110\u00e3 l\u1ea5y \u0111\u01b0\u1ee3c" + "Tr\u00e1nh n\u00e9 qu\u00e1i v\u1eadt c\u00f3 hi\u1ec7u qu\u1ea3", 1);
                                this.void_c(var1_1, 1);
                                break;
                            }
                            if (this.var_at_b.var_byte_e == 1) {
                                this.b("C\u00f3 \u0111\u01b0\u1ee3c tr\u00e1nh n\u00e9 qu\u00e1i v\u1eadt hi\u1ec7u qu\u1ea3", 0);
                                break;
                            }
                            break block26;
                        }
                        case 32: 
                        case 33: {
                            if (this.byte_b(-2, var1_1 == 32 ? 33 : 32, true) <= 0) ** GOTO lbl76
                            this.void_c(32, 1);
                            this.void_c(33, 1);
                            var1_1 = 3;
                            var2_3 = 1;
                            var3_4 = -1;
                            ad.ad_b();
                            var4_5 = (byte)ad.c(100);
                            if (var4_5 < 70) {
                                var1_1 = 0;
                            } else if (var4_5 < 85) {
                                var1_1 = 1;
                            } else if (var4_5 < 95) {
                                var1_1 = 2;
                            }
                            ad.ad_b();
                            var4_5 = (byte)ad.c(100);
                            while (var2_3 < this.var_byte_arr_arr_l[var1_1].length) {
                                if (var4_5 < this.var_byte_arr_arr_l[var1_1][var2_3]) {
                                    var3_4 = this.var_byte_arr_arr_l[var1_1][var2_3 - 1];
                                    break;
                                }
                                var2_3 = (byte)(var2_3 + 2);
                            }
                            if (var3_4 == 34 && this.byte_b(-2, var3_4, true) > 0 || var3_4 == -1 || this.byte_b(-2, var3_4, true) >= 99) {
                                var3_4 = -1;
                            }
                            if (var3_4 == -1) ** GOTO lbl74
                            this.byte_e(var3_4, 1);
                            v0 = this;
                            v1 = new StringBuffer("\u0110\u1ea1t \u0111\u01b0\u1ee3c: ").append(this.java_lang_String_c(var3_4));
                            v2 = "x1";
                            ** GOTO lbl79
lbl74:
                            // 1 sources

                            this.b("B\u1ea3o r\u01b0\u01a1ng n\u00e0y tr\u1ed1ng kh\u00f4ng.", 0);
                            ** GOTO lbl80
lbl76:
                            // 1 sources

                            v0 = this;
                            v1 = new StringBuffer("Kh\u00f4ng c\u00f3");
                            v2 = var1_1 == 32 ? "Ch\u00eca n\u00fat, c\u00f3 th\u1ec3 mua \u0111\u01b0\u1ee3c \u1edf c\u1eeda h\u00e0ng." : "B\u1ea3o r\u01b0\u01a1ng, sau tr\u1eadn chi\u1ebfn s\u1ebd c\u00f3 c\u01a1 h\u1ed9i \u0111\u1ea1t \u0111\u01b0\u1ee3c b\u1ea3o r\u01b0\u01a1ng.";
lbl79:
                            // 2 sources

                            v0.b(v1.append(v2).toString(), 0);
lbl80:
                            // 2 sources

                            this.var_byte_h = (byte)-1;
                            break;
                        }
                        default: {
                            this.d();
                            this.var_byte_f = (byte)15;
                            break;
                        }
                    }
                    break block26;
                }
                ad.ad_b();
                if (ad.b((StringBuffer)this.var_int_c[this.var_byte_h], "H\u1ecdc")) {
                    this.var_byte_f = (byte)13;
                    this.var_byte_p = (byte)(var1_1 - 9);
                    this.d();
                } else {
                    ad.ad_b();
                    if (ad.b((StringBuffer)this.var_int_c[this.var_byte_h], "\u1ea4p tr\u1ee9ng")) {
                        if (this.boolean_c(var1_1 - 58)) {
                            this.void_c(var1_1, 1);
                            this.var_byte_f[this.u] = this.var_byte_h[0][0];
                            this.var_byte_i[this.u] = this.var_byte_h[0][1];
                        } else {
                            this.b("Kh\u00f4ng c\u00f3 n\u01a1i th\u00edch h\u1ee3p \u0111\u1ec3 \u1ea5p tr\u1ee9ng", 0);
                        }
                        this.var_byte_h = (byte)-1;
                    } else {
                        this.var_byte_h = (byte)-1;
                    }
                }
            }
            ad.ad_b();
            ad.void_b((byte[])this.var_byte_h[0], (int)this.var_byte_j[this.u], (int)this.H);
            return;
        }
        ad.ad_b();
        if (ad.i()) {
            this.var_byte_h = (byte)-1;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void B() {
        block39: {
            block40: {
                block42: {
                    block41: {
                        block37: {
                            block38: {
                                ad.ad_b();
                                if (ad.boolean_b()) {
                                    return;
                                }
                                if (this.var_byte_h != -1) break block37;
                                ad.ad_b();
                                if (!ad.g() || this.var_byte_j[this.u] <= 0) break block38;
                                var3_1 = this.var_byte_h[0][0];
                                var2_4 = this.u;
                                var1_6 = this;
                                var4_8 = "Quay l\u1ea1i";
                                var5_10 = var1_6.var_byte_b[var2_4][var3_1][0];
                                if (var2_4 != false && var5_10 != 32 && var5_10 != 33) ** GOTO lbl-1000
                                var3_1 = var5_10;
                                var6_12 = var1_6;
                                v0 = var6_12.var_byte_c == -1 ? var3_1 != 14 && var3_1 != 15 : var3_1 != 9 && var3_1 != 10 && var3_1 != 11 && var3_1 != 8;
                                if (v0) {
                                    var4_8 = "S\u1eed d\u1ee5ng#nQuay l\u1ea1i";
                                } else if (var2_4 == 2) {
                                    var4_8 = "H\u1ecdc#nQuay l\u1ea1i";
                                } else if (var1_6.var_byte_c == 2 && var2_4 == 3) {
                                    var4_8 = "\u1ea4p tr\u1ee9ng#nQuay l\u1ea1i";
                                }
                                var1_6.b(var4_8, 240, 0);
                                var1_6.var_byte_h = 0;
                                return;
                            }
                            ad.ad_b();
                            if (ad.e()) {
                                ad.ad_b();
                                this.u = (byte[])ad.byte_b((int)this.u, 0, ((int)this.var_int_c).length - 1);
                                this.var_byte_h[0][1] = this.var_byte_i[this.u];
                                this.var_byte_h[0][0] = this.var_byte_f[this.u];
                                return;
                            }
                            ad.ad_b();
                            if (ad.i()) {
                                if (this.var_byte_f == 9) {
                                    this.var_byte_f = (byte)5;
                                    this.v = (byte[])false;
                                    this.v = (byte[])false;
                                    this.d();
                                    return;
                                }
                                if (this.var_byte_c == -1) {
                                    this.var_byte_f = 1;
                                    this.at();
                                    this.b(2, (int)this.var_byte_arr_arr_e[this.var_byte_b[0].var_byte_arr_b[0]][0], 1);
                                    this.var_byte_arr_arr_l = null;
                                    return;
                                }
                                if (this.var_byte_c == 2) {
                                    ak.var_int_a = -10;
                                    ak.var_byte_b.d();
                                    this.void_a(0);
                                    return;
                                }
                                this.void_b(0);
                                this.void_d(2);
                                this.var_byte_arr_arr_l = null;
                                return;
                            }
                            ad.ad_b();
                            if (ad.boolean_c()) {
                                if (this.var_byte_j[this.u] > 0) {
                                    ad.ad_b();
                                    ad.b((byte[])this.var_byte_h[0], 0, (int)this.var_byte_j[this.u], this.H);
                                }
                                this.var_byte_f[this.u] = this.var_byte_h[0][0];
                                this.var_byte_i[this.u] = this.var_byte_h[0][1];
                                return;
                            }
                            break block39;
                        }
                        var1_7 = this;
                        ad.ad_b();
                        if (ad.boolean_c()) {
                            ad.ad_b();
                            var1_7.var_byte_h = ad.byte_b((int)var1_7.var_byte_h, 0, ((int)var1_7.var_int_c).length - 1);
                        }
                        ad.ad_b();
                        if (!ad.g()) break block40;
                        var2_5 = var1_7.var_byte_b[var1_7.u][var1_7.var_byte_h[0][0]][0];
                        ad.ad_b();
                        if (!ad.b((StringBuffer)var1_7.var_int_c[var1_7.var_byte_h], "S\u1eed d\u1ee5ng")) break block41;
                        switch (var2_5) {
                            case 9: 
                            case 10: 
                            case 11: {
                                if (var1_7.F == 4 || var1_7.F == 1) {
                                    var3_2 = var1_7;
                                    ak.var_int_a = -19;
                                    var3_2.var_short_d = (short)151;
                                    var3_2.var_short_h = (short)-20;
                                    var3_2.var_short_g = (short)146;
                                    var3_2.var_byte_g = 0;
                                    break;
                                }
                                var1_7.b("Tr\u01b0\u1eddng h\u1ee3p \u0111\u1eb7c bi\u1ec7t, kh\u00f4ng th\u1ec3 b\u1eaft \u0111\u01b0\u1ee3c!", 1);
                                ad.ad_b().var_int_b = 400;
                                break;
                            }
                            case 14: 
                            case 15: {
                                var1_7.var_byte_h = (byte)-1;
                                if (var1_7.var_at_b.var_byte_e == 0) {
                                    var1_7.var_at_b.void_b(1, (int)var2_5);
                                    var1_7.b("S\u1eed d\u1ee5ng" + var1_7.java_lang_String_c((int)var2_5) + ", \u0110\u00e3 l\u1ea5y \u0111\u01b0\u1ee3c" + "Tr\u00e1nh n\u00e9 qu\u00e1i v\u1eadt c\u00f3 hi\u1ec7u qu\u1ea3", 1);
                                    var1_7.void_c((int)var2_5, 1);
                                    break;
                                }
                                if (var1_7.var_at_b.var_byte_e == 1) {
                                    var1_7.b("C\u00f3 \u0111\u01b0\u1ee3c tr\u00e1nh n\u00e9 qu\u00e1i v\u1eadt hi\u1ec7u qu\u1ea3", 0);
                                    break;
                                }
                                break block42;
                            }
                            case 32: 
                            case 33: {
                                if (var1_7.byte_b(-2, var2_5 == 32 ? 33 : 32, true) <= 0) ** GOTO lbl151
                                var1_7.void_c(32, 1);
                                var1_7.void_c(33, 1);
                                var3_3 = 3;
                                var4_9 = 1;
                                var5_11 = -1;
                                ad.ad_b();
                                var6_13 = (byte)ad.c(100);
                                if (var6_13 < 70) {
                                    var3_3 = 0;
                                } else if (var6_13 < 85) {
                                    var3_3 = 1;
                                } else if (var6_13 < 95) {
                                    var3_3 = 2;
                                }
                                ad.ad_b();
                                var6_13 = (byte)ad.c(100);
                                while (var4_9 < var1_7.var_byte_arr_arr_l[var3_3].length) {
                                    if (var6_13 < var1_7.var_byte_arr_arr_l[var3_3][var4_9]) {
                                        var5_11 = var1_7.var_byte_arr_arr_l[var3_3][var4_9 - 1];
                                        break;
                                    }
                                    var4_9 = (byte)(var4_9 + 2);
                                }
                                if (var5_11 == 34 && var1_7.byte_b(-2, var5_11, true) > 0 || var5_11 == -1 || var1_7.byte_b(-2, var5_11, true) >= 99) {
                                    var5_11 = -1;
                                }
                                if (var5_11 == -1) ** GOTO lbl149
                                var1_7.byte_e(var5_11, 1);
                                v1 = var1_7;
                                v2 = new StringBuffer("\u0110\u1ea1t \u0111\u01b0\u1ee3c: ").append(var1_7.java_lang_String_c(var5_11));
                                v3 = "x1";
                                ** GOTO lbl154
lbl149:
                                // 1 sources

                                var1_7.b("B\u1ea3o r\u01b0\u01a1ng n\u00e0y tr\u1ed1ng kh\u00f4ng.", 0);
                                ** GOTO lbl155
lbl151:
                                // 1 sources

                                v1 = var1_7;
                                v2 = new StringBuffer("Kh\u00f4ng c\u00f3");
                                v3 = var2_5 == 32 ? "Ch\u00eca n\u00fat, c\u00f3 th\u1ec3 mua \u0111\u01b0\u1ee3c \u1edf c\u1eeda h\u00e0ng." : "B\u1ea3o r\u01b0\u01a1ng, sau tr\u1eadn chi\u1ebfn s\u1ebd c\u00f3 c\u01a1 h\u1ed9i \u0111\u1ea1t \u0111\u01b0\u1ee3c b\u1ea3o r\u01b0\u01a1ng.";
lbl154:
                                // 2 sources

                                v1.b(v2.append(v3).toString(), 0);
lbl155:
                                // 2 sources

                                var1_7.var_byte_h = (byte)-1;
                                break;
                            }
                            default: {
                                var1_7.d();
                                var1_7.var_byte_f = (byte)15;
                                break;
                            }
                        }
                        break block42;
                    }
                    ad.ad_b();
                    if (ad.b((StringBuffer)var1_7.var_int_c[var1_7.var_byte_h], "H\u1ecdc")) {
                        var1_7.var_byte_f = (byte)13;
                        var1_7.var_byte_p = (byte)(var2_5 - 9);
                        var1_7.d();
                    } else {
                        ad.ad_b();
                        if (ad.b((StringBuffer)var1_7.var_int_c[var1_7.var_byte_h], "\u1ea4p tr\u1ee9ng")) {
                            if (var1_7.boolean_c((int)(var2_5 - 58))) {
                                var1_7.void_c((int)var2_5, 1);
                                var1_7.var_byte_f[var1_7.u] = var1_7.var_byte_h[0][0];
                                var1_7.var_byte_i[var1_7.u] = var1_7.var_byte_h[0][1];
                            } else {
                                var1_7.b("Kh\u00f4ng c\u00f3 n\u01a1i th\u00edch h\u1ee3p \u0111\u1ec3 \u1ea5p tr\u1ee9ng", 0);
                            }
                            var1_7.var_byte_h = (byte)-1;
                        } else {
                            var1_7.var_byte_h = (byte)-1;
                        }
                    }
                }
                ad.ad_b();
                ad.void_b((byte[])var1_7.var_byte_h[0], (int)var1_7.var_byte_j[var1_7.u], (int)var1_7.H);
                return;
            }
            ad.ad_b();
            if (ad.i()) {
                var1_7.var_byte_h = (byte)-1;
            }
        }
    }

    public final void void_c(int n2) {
        var_int_a = 65;
        this.b("L\u01b0u tr\u1eef#nCh\u1ecdn#nB\u1ecf", 240, 3);
        this.var_byte_h = (byte)n2;
    }

    private void A() {
        ah.ah_b();
        ah.b(74, 112, 92, 136);
        ak.b((Object[])this.var_byte_d, 97, 140, 46, 2, 0, this.var_byte_h);
        ah.ah_b();
        ah.b("L\u01b0u tr\u1eef S\u1ee7ng V\u1eadt", 120, 114, 17, 1, 1);
        ah.ah_b().b(true, true);
    }

    public final void void_a(int n2) {
        var_int_a = 66;
        this.var_byte_f = (byte)16;
        this.b("Tra x\u00e9t \u1ea5p tr\u1ee9ng#nL\u1ef1a ch\u1ecdn tr\u1ee9ng#nB\u1ecf", 240, 3);
        this.var_byte_h = 0;
        this.var_byte_g = (byte)-2;
    }

    private void C() {
        if (this.var_byte_f == 16) {
            ak.b((Object[])this.var_byte_d, 63, 160 - 20 * (((byte)this.var_byte_d).length >> 1), 114, 1, 0, this.var_byte_h);
            return;
        }
        ah.ah_b();
        ah.c();
        this.b(this.L, 1, 108, 0, 222);
        ah.ah_b();
        ah.b(this.var_byte_h + 1 + "/5", 10, 106, 36, 0, 2);
        ah.ah_b();
        ah.b(this.byte_c(this.var_byte_h) == -2 ? "V\u1ecb tr\u00ed n\u00e0y hi\u1ec7n v\u1eabn c\u00f2n tr\u1ed1ng" : this.var_java_lang_StringBuffer_arr_b[this.var_byte_arr_arr_d[this.byte_a(this.var_byte_h)][6]] + "Tr\u1ee9ng S\u1ee7ng V\u1eadt", 20, 110, 0, 1, 0);
        if (this.byte_c(this.var_byte_h) != -2) {
            if (this.var_byte_g < 2 && this.b(1, 1, (int)this.E, 177, 97, this.var_byte_g != 1, 0)) {
                this.b(2, (int)this.var_byte_arr_arr_e[this.byte_a(this.var_byte_h)][0], 1);
                this.var_byte_g = (byte)2;
            } else if (this.var_byte_g > 1 && this.var_byte_g < 14) {
                this.b(this.var_byte_arr_arr_e[this.byte_a(this.var_byte_h)][1], 1, 177, 97, 80, 77, 15, this.var_byte_g - 2, 0);
                this.var_byte_g = (byte)(this.var_byte_g + 1);
                if (this.var_byte_g == 14) {
                    this.var_byte_g = (byte)-1;
                }
                this.E = (byte)(this.var_byte_arr_arr_e[this.byte_a(this.var_byte_h)][1] * 3);
            }
            if (this.var_byte_g != -1) {
                this.var_int_c = (int)(this.short_b((int)this.var_byte_h, 1) + "/" + this.short_b((int)this.var_byte_h, 3));
                ah.ah_b();
                ad.ad_b();
                short s2 = ad.short_b((int)this.short_b((int)this.var_byte_h, 1), 178, (int)this.short_b((int)this.var_byte_h, 3));
                ad.ad_b();
                ah.b(20, 148, 180, (int)s2, (int)ad.short_b((int)this.short_b((int)this.var_byte_h, 1), 178, (int)this.short_b((int)this.var_byte_h, 3)), 2);
                ah.ah_b().c((String)this.var_int_c, 20 + (180 - 8 * this.var_int_c.length() >> 1), 154, 0, 0);
                ah.ah_b();
                ah.b(this.short_b((int)this.var_byte_h, 1) == this.short_b((int)this.var_byte_h, 3) ? "\u1ea4p tr\u1ee9ng xong" : "\u0110ang \u1ea5p tr\u1ee9ng...", 110, 154, 17, 3, 1);
                ah.ah_b();
                ah.b("T\u00e0i li\u1ec7u c\u1ea7n \u0111\u1ec3 th\u1ef1c hi\u1ec7n \u1ea5p tr\u1ee9ng", 110, 188, 17, 3, 1);
                this.h(this.byte_a(this.var_byte_h), 25, 214, 23);
            } else {
                ah.ah_b();
                ah.b((Object[])this.var_int_c, 26, 150, 0, 3, 25, 3, 0);
                ah.ah_b();
                ah.b((Object[])this.var_byte_a, 126, 150, 0, 3, 25, 3, 0);
                ah.ah_b();
                ah.b("\u0110\u1eb3ng c\u1ea5p: ", 58, 233, 0, 3, 1);
                ak.b(this.var_byte_arr_arr_d[this.byte_a(this.var_byte_h)][5], 99, 238, 0);
            }
            if (this.short_b((int)this.var_byte_h, 1) == this.short_b((int)this.var_byte_h, 3)) {
                ah.ah_b();
                ah.b("Nh\u1ea5n n\u00fat 5 ho\u00e0n th\u00e0nh \u1ea5p tr\u1ee9ng", 20, 279, 0, 0, 0);
            }
        }
        if (this.var_byte_g == -2) {
            ah.ah_b().b(120, 120, 114, true, true);
        }
        ah.ah_b().b(false, this.var_byte_g != -1);
    }

    private void D() {
        ad.ad_b();
        if (ad.boolean_b()) {
            return;
        }
        if (this.var_byte_f == 16) {
            ad.ad_b();
            if (ad.boolean_c()) {
                ad.ad_b();
                this.var_byte_h = ad.byte_b((int)this.var_byte_h, 0, ((byte)this.var_byte_d).length - 1);
                return;
            }
            ad.ad_b();
            if (ad.g()) {
                ad.ad_b();
                if (ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "Tra x\u00e9t \u1ea5p tr\u1ee9ng")) {
                    this.var_byte_f = (byte)17;
                    this.var_byte_h = 0;
                    this.b(0, 56, 1);
                    if (this.byte_c(this.var_byte_h) == -2) {
                        this.L = this.var_byte_h;
                        return;
                    }
                    this.L = this.var_byte_arr_arr_d[this.byte_a(this.var_byte_h)][6];
                    this.E = (byte)(this.L + 23);
                    return;
                }
                ad.ad_b();
                if (ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "L\u1ef1a ch\u1ecdn tr\u1ee9ng")) {
                    this.var_byte_c = (byte)2;
                    this.p(3);
                    return;
                }
                ad.ad_b();
                if (ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "B\u1ecf")) {
                    this.F();
                    return;
                }
            } else {
                ad.ad_b();
                if (ad.i()) {
                    this.F();
                    return;
                }
            }
        } else {
            if (this.var_byte_g == -2) {
                ad.ad_b();
                if (ad.e()) {
                    ad.ad_b();
                    this.var_byte_h = ad.byte_b((int)this.var_byte_h, 0, 4);
                    if (this.byte_c(this.var_byte_h) == -2) {
                        this.L = this.var_byte_h;
                        return;
                    }
                    this.L = this.var_byte_arr_arr_d[this.byte_a(this.var_byte_h)][6];
                    this.E = (byte)(this.L + 23);
                    return;
                }
            }
            ad.ad_b();
            if (ad.g()) {
                if (this.byte_c(this.var_byte_h) == -2) {
                    return;
                }
                if (this.var_byte_g == -2 && this.short_b((int)this.var_byte_h, 1) == this.short_b((int)this.var_byte_h, 3)) {
                    if (this.z == this.x && this.y == this.w) {
                        this.b("S\u1ee7ng V\u1eadt \u0111\u00e3 \u0111\u1ea7y", 0);
                        return;
                    }
                    if (this.byte_d(this.byte_a(this.var_byte_h)) == 0) {
                        this.E = (byte)(this.L + 28);
                        this.var_byte_g = 1;
                        boolean bl = true;
                        byte by = this.byte_a(this.var_byte_h);
                        ak ak2 = this;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Sinh m\u1ec7nh: " + (ak2.var_byte_arr_arr_d[by][0] + ak2.var_byte_arr_arr_d[by][7] / 10) + "#n");
                        stringBuffer.append("N\u0103ng l\u01b0\u1ee3ng: " + (ak2.var_byte_arr_arr_d[by][1] + ak2.var_byte_arr_arr_d[by][8] / 10) + "#n");
                        stringBuffer.append("Ti\u1ebfn h\u00f3a: " + ak2.var_byte_arr_arr_d[by][12]);
                        ak2.b(stringBuffer.toString(), 240, 0);
                        stringBuffer.delete(0, stringBuffer.length());
                        stringBuffer.append("S\u1ee9c m\u1ea1nh: " + (ak2.var_byte_arr_arr_d[by][3] + ak2.var_byte_arr_arr_d[by][10] / 10) + "#n");
                        stringBuffer.append("Ph\u00f2ng ng\u1ef1: " + (ak2.var_byte_arr_arr_d[by][4] + ak2.var_byte_arr_arr_d[by][11] / 10) + "#n");
                        stringBuffer.append("Nhanh nh\u1eb9n: " + (ak2.var_byte_arr_arr_d[by][4] + ak2.var_byte_arr_arr_d[by][11] / 10));
                        ak2.b(stringBuffer.toString(), 240, 1);
                        this.void_b(this.byte_a(this.var_byte_h));
                        return;
                    }
                    this.b("T\u00e0i li\u1ec7u kh\u00f4ng \u0111\u1ee7, kh\u00f4ng th\u1ec3 \u1ea5p tr\u1ee9ng", 0);
                    return;
                }
                if (this.var_byte_g == -1) {
                    this.var_byte_g = (byte)-2;
                    byte by = this.var_byte_h;
                    ak ak3 = this;
                    this.byte_b((int)this.byte_a(this.var_byte_h), (int)ak3.var_byte_arr_arr_g[1][ak3.byte_c(by)], -2, -1);
                    by = this.var_byte_h;
                    ak3 = this;
                    ((as)ak3).n[by * 5] = -2;
                    this.b(0, 56, 1);
                    return;
                }
            } else if (this.var_byte_g == -2) {
                ad.ad_b();
                if (ad.i()) {
                    this.F();
                }
            }
        }
    }

    private void F() {
        var_int_a = -10;
        this.var_am_arr_b[1] = null;
        this.void_e(1);
    }

    private void void_e(int n2, int n3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Sinh m\u1ec7nh: " + (this.var_byte_arr_arr_d[n2][0] + this.var_byte_arr_arr_d[n2][7] / 10) + "#n");
        stringBuffer.append("N\u0103ng l\u01b0\u1ee3ng: " + (this.var_byte_arr_arr_d[n2][1] + this.var_byte_arr_arr_d[n2][8] / 10) + "#n");
        stringBuffer.append("Ti\u1ebfn h\u00f3a: " + this.var_byte_arr_arr_d[n2][12]);
        this.b(stringBuffer.toString(), 240, 0);
        stringBuffer.delete(0, stringBuffer.length());
        stringBuffer.append("S\u1ee9c m\u1ea1nh: " + (this.var_byte_arr_arr_d[n2][3] + this.var_byte_arr_arr_d[n2][10] / 10) + "#n");
        stringBuffer.append("Ph\u00f2ng ng\u1ef1: " + (this.var_byte_arr_arr_d[n2][4] + this.var_byte_arr_arr_d[n2][11] / 10) + "#n");
        stringBuffer.append("Nhanh nh\u1eb9n: " + (this.var_byte_arr_arr_d[n2][4] + this.var_byte_arr_arr_d[n2][11] / 10));
        this.b(stringBuffer.toString(), 240, 1);
    }

    public final void void_e(int n2) {
        int n3;
        if (this.var_byte_p == null) {
            this.var_byte_p = (byte)new byte[5];
        }
        if (n2 == 0) {
            for (n3 = 0; n3 < ((byte)this.var_byte_p).length; n3 = (int)((byte)(n3 + 1))) {
                this.var_byte_p[n3] = -1;
            }
        } else {
            while (n3 < ((byte)this.var_byte_p).length) {
                if (this.var_byte_p[n3] != -1) {
                    if (this.byte_c(n3) != -2) {
                        this.var_at_b.var_aj_arr_arr_b[0][this.var_byte_p[n3]].var_byte_arr_b[4] = 1;
                        this.var_at_b.var_aj_arr_arr_b[0][this.var_byte_p[n3]].var_byte_arr_b[7] = (byte)(17 + this.var_byte_arr_arr_d[this.byte_a(n3)][6]);
                    } else {
                        this.var_at_b.var_aj_arr_arr_b[0][this.var_byte_p[n3]].var_byte_arr_b[4] = 0;
                    }
                }
                n3 = (byte)(n3 + 1);
            }
        }
    }

    private void G() {
        ah.ah_b();
        ah.c();
        int n2 = 25;
        n2 = 24;
        ah.ah_b();
        ah.b(0, 0, 25, 24, 270);
        var_int_c.fillRect(0, 0, 240, 25);
        var_int_c.fillRect(0, 295, 240, 25);
        var_int_c.fillRect(0, 23, 240, 25);
        ah.ah_b();
        ah.b(15400191, 2, 25, 20, 270);
        var_int_c.fillRect(0, 2, 240, 21);
        var_int_c.fillRect(0, 297, 240, 21);
        var_int_c.fillRect(24, 25, 240, 21);
        ah.ah_b();
        ah.b(5422575, -25, 141, 50, 70, 270, 180);
        ah.ah_b().a(31, 2, 176, 36, 0);
        ah.ah_b().a(31, 2, 176, 0, 6);
        ah.ah_b().a(68, 0, 0, 0, 0);
        ah.ah_b().a(68, 0, 320, 36, 6);
        ah.ah_b();
        StringBuffer stringBuffer = new StringBuffer("T\u00ecm ra m\u1ee9c \u0111\u1ed9");
        ad.ad_b();
        ah.b(stringBuffer.append(ad.java_lang_String_b((int)(this.var_byte_arr_arr_k[102] * 1000 / 102))).append("%").toString(), 228, 25, 24, 3, 1);
        ah.ah_b();
        ah.b(this.var_java_lang_StringBuffer_arr_b[this.s].toString(), 28, 25, 0, 1, 2);
        ah.ah_b();
        ah.b("Ch\u1ee7ng lo\u1ea1i \u0111o\u1ea1t \u0111\u01b0\u1ee3c " + (int)this.var_byte_arr_arr_k[103] + "/100", 120, 317, 33, 3, 1);
        for (n2 = 0; n2 < 5; n2 = (int)((byte)(n2 + 1))) {
            ah.ah_b().a(n2 + (this.s == n2 ? 5 : 0), 214 * (n2 + 1) / 6 + 18, 12, 6, 0);
        }
        this.b(32, 44, 190, 24, (int)this.H, (int)this.A, (byte[])this.var_byte_h[0]);
        this.b(32, 44, 190, 24, (int)this.H, (int)this.A, (byte[])this.var_byte_h[0]);
        ah.ah_b().b(130, 12, 101, true, true);
        ah.ah_b().b(this.var_byte_arr_arr_k[this.byte_c()] != false, true);
    }

    private static void d(int n2, int n3) {
        ah.ah_b();
        ah.b(0, 0, 25, 24, 270);
        var_int_c.fillRect(0, 0, 240, 25);
        var_int_c.fillRect(0, 295, 240, 25);
        var_int_c.fillRect(0, 23, 240, 25);
        ah.ah_b();
        ah.b(15400191, 2, 25, 20, 270);
        var_int_c.fillRect(0, 2, 240, 21);
        var_int_c.fillRect(0, 297, 240, 21);
        var_int_c.fillRect(24, 25, 240, 21);
        ah.ah_b();
        ah.b(5422575, -25, 141, 50, 70, 270, 180);
        ah.ah_b().a(31, 2, 176, 36, 0);
        ah.ah_b().a(31, 2, 176, 0, 6);
        ah.ah_b().a(68, 0, 0, 0, 0);
        ah.ah_b().a(68, 0, 320, 36, 6);
    }

    private void b(int n2, int n3, int n4, int n5, int n6, int n7, byte[] byArray) {
        ah.ah_b();
        ah.h(53, 44 + this.var_byte_a / 8 + byArray[0] * 24 - 2, 169, 26, 4);
        var_int_c.setClip(0, 68, 240, (n6 - 2) * 24);
        n2 = 0;
        n3 = byArray[1];
        while (n2 < n6) {
            if (n3 >= this.A) {
                n3 = 0;
            }
            n4 = n2 == byArray[0] - 1 ? 15 : (n2 == byArray[0] ? 23 : (n2 == byArray[0] + 1 ? 15 : 0));
            if (this.var_int_c < 6) {
                if (this.r == false && n2 > byArray[0] - 3 && n2 < byArray[0] + 2) {
                    n4 = this.var_byte_arr_arr_j[n2 - byArray[0] + 2][this.var_int_c];
                } else if (this.r == true && n2 > byArray[0] - 2 && n2 < byArray[0] + 3) {
                    n4 = this.var_byte_arr_arr_j[n2 - byArray[0] + 5][this.var_int_c];
                }
            }
            ah.ah_b().a(this.var_byte_arr_arr_k[this.var_byte_arr_arr_k[this.s][n3]] == 2 ? 25 : 48, n4 + 32 - 12, 44 - this.var_byte_a + n2 * 24 + 4, 24, 0);
            n5 = (byte)(byArray[0] == n2 && this.var_byte_a == 0 ? 0 : (this.var_byte_arr_arr_k[this.var_byte_arr_arr_k[this.s][n3]] != false ? 3 : -1));
            ah.ah_b();
            ah.b((this.I + n3 + 1 < 10 ? "0" : "") + (this.I + n3 + 1) + " " + (this.var_byte_arr_arr_k[this.var_byte_arr_arr_k[this.s][n3]] != false ? this.java_lang_String_e(this.var_byte_arr_arr_k[this.s][n3]) : "Lo\u1ea1i th\u00fa ch\u01b0a bi\u1ebft"), n4 + 32, 44 - this.var_byte_a + n2 * 24, 0, n5, 0);
            ah.ah_b();
            byte by = this.var_byte_arr_arr_o[this.var_byte_arr_arr_k[this.s][n3]][0];
            ah.b(by == -1 ? "Nhi\u1ec7m v\u1ee5" : (by == -2 ? "Ti\u1ebfn h\u00f3a" : (by == -3 ? "D\u1ecb ho\u00e1" : (by == -4 ? "\u0110\u1ea5u tr\u01b0\u1eddng" : (by == -5 ? "\u1ea4p tr\u1ee9ng" : "T\u00f3m \u0111\u01b0\u1ee3c")))), n4 + 32 + 152, 44 - this.var_byte_a + n2 * 24, 24, n5, 0);
            n2 = (byte)(n2 + 1);
            n3 = (byte)(n3 + 1);
        }
        ah.ah_b();
        ah.b((this.I + this.byte_b() + 1 < 10 ? "0" : "") + (this.I + this.byte_b() + 1), 1, 44 + byArray[0] * 24 + 1, 0, 0, 2);
        ad.ad_b();
        this.var_byte_a = (byte)ad.b(this.var_byte_a, 0, 4, false);
        ad.ad_b();
        this.var_int_c = ad.b(this.var_int_c, 6, 1, false);
        ah.ah_b().b(227, 74, (n6 - 2) * 23 - 4, (int)byArray[1], n7, false);
        var_int_c.setClip(0, 0, 240, 320);
    }

    private static String java_lang_String_d(int n2) {
        if (n2 == -1) {
            return "Nhi\u1ec7m v\u1ee5";
        }
        if (n2 == -2) {
            return "Ti\u1ebfn h\u00f3a";
        }
        if (n2 == -3) {
            return "D\u1ecb ho\u00e1";
        }
        if (n2 == -4) {
            return "\u0110\u1ea5u tr\u01b0\u1eddng";
        }
        if (n2 == -5) {
            return "\u1ea4p tr\u1ee9ng";
        }
        return "T\u00f3m \u0111\u01b0\u1ee3c";
    }

    private byte byte_b() {
        byte by = (byte)(this.var_byte_h[0][0] + this.var_byte_h[0][1]);
        if (by >= this.A) {
            by = (byte)(by - this.A);
        }
        return by;
    }

    private byte byte_c() {
        return this.var_byte_arr_arr_k[this.s][this.byte_b()];
    }

    private void H() {
        ad.ad_b();
        if (ad.boolean_b()) {
            return;
        }
        ad.ad_b();
        if (ad.g()) {
            if (this.var_byte_arr_arr_k[this.byte_c()] != false) {
                byte by = this.byte_c();
                ak ak2 = this;
                var_int_a = 67;
                ak2.b(2, (int)ak2.var_byte_arr_arr_e[by][0], 1);
                return;
            }
        } else {
            ad.ad_b();
            if (ad.i()) {
                this.var_int_c = (int)null;
                this.var_byte_arr_arr_k = null;
                this.void_b(0);
                this.void_d(3);
                return;
            }
            ad.ad_b();
            if (ad.e()) {
                ad.ad_b();
                this.s = (byte[])ad.byte_b((int)this.s, 0, 4);
                this.I = 0;
                if (this.s > 0) {
                    for (int n2 = 0; n2 < this.s; n2 = (int)((byte)(n2 + 1))) {
                        this.I = (byte)(this.I + this.var_byte_arr_arr_k[n2].length);
                    }
                }
                this.A = (byte)this.var_byte_arr_arr_k[this.s].length;
                this.var_byte_h[0][1] = (byte)(this.A - this.var_byte_h[0][0]);
                return;
            }
            ad.ad_b();
            if (ad.boolean_c()) {
                void v0 = this.var_byte_h[0];
                ad.ad_b();
                v0[1] = ad.byte_b((int)this.var_byte_h[0][1], 0, this.A - 1);
                ad.ad_b();
                this.var_byte_a = (byte)(ad.a() ? 24 : -24);
                this.var_int_c = 0;
                ad.ad_b();
                this.r = (byte[])((byte)(ad.a() ? 1 : 0));
            }
        }
    }

    private void e(boolean bl) {
        var_int_a = 68;
        if (this.var_byte_arr_arr_k == null) {
            byte[] byArray = ad.ad_b().byte_arr_b("data/book.d", -1);
            ad.ad_b();
            ad.var_int_c = 0;
            this.var_byte_arr_arr_k = ad.ad_b().byte_arr_arr_b(byArray);
        }
        if (bl) {
            this.I = 0;
            this.s = (byte[])false;
            this.r = (byte[])false;
            this.var_int_c = 6;
            this.var_byte_a = 0;
            this.A = (byte)this.var_byte_arr_arr_k[this.s].length;
            this.var_byte_h[0][0] = 5;
            this.var_byte_h[0][1] = (byte)(this.A - this.var_byte_h[0][0]);
        }
        this.H = (byte)11;
    }

    private void m(int n2) {
        var_int_a = 67;
        this.b(2, (int)this.var_byte_arr_arr_e[n2][0], 1);
    }

    private void n(int n2) {
        int n3;
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.b(1, 2, 238, 318);
        ah.ah_b();
        ah.h(24, 6, 184, 24, 4);
        ah.ah_b();
        ah.h(12, 35, 100, 90, 1);
        ah.ah_b();
        ah.h(43, 129, 187, 96, 1);
        ah.ah_b();
        ah.h(12, 129, 23, 96, 3);
        ah.ah_b();
        ah.h(12, 235, 218, 82, 2);
        ah.ah_b().b(false, true);
        ah.ah_b().a((int)(this.s + 5), 14, 37, 0, 0);
        ah.ah_b();
        ah.b(this.java_lang_String_e(n2) + "(" + (this.var_byte_arr_arr_k[n2] == 2 ? "\u0110o\u1ea1t \u0111\u01b0\u1ee3c" : "Kh\u00f4ng b\u1eaft \u0111\u01b0\u1ee3c") + ")", 120, 6, 17, 0, 0);
        if (this.b(1, 1, this.var_byte_arr_arr_e[n2][1] * 3 + this.E, 62, 115, this.E != 1, 0)) {
            this.E = 0;
        }
        ah.ah_b();
        ah.b("Ph\u00e1t hi\u1ec7n \u0111\u1ecba \u0111i\u1ec3m", 117, 35, 0, 1, 1);
        if (this.var_byte_arr_arr_o[n2][0] >= 0) {
            for (n3 = 0; n3 < this.var_byte_arr_arr_o[n2].length; n3 = (int)((byte)(n3 + 1))) {
                ah.ah_b();
                ah.b(this.var_java_lang_StringBuffer_arr_g[this.var_byte_arr_arr_o[n2][n3]].toString(), 117, 35 + 20 * (n3 + 1), 0, 1, 0);
            }
        } else {
            ah.ah_b();
            ah.b("Kh\u00f4ng bi\u1ebft", 117, 55, 0, 1, 0);
        }
        ah.ah_b();
        ah.b("Ti\u1ebfn", 23, 145, 17, 3, 1);
        ah.ah_b();
        ah.b("C\u1ee7a", 23, 177, 17, 3, 1);
        ah.ah_b().b(3, 43, 135, 187, 3, 28, 0, -1, 4, 2);
        n3 = 2;
        int n4 = 0;
        while (n3 < 7) {
            ah.ah_b();
            ah.b("T\u00e0i li\u1ec7u: " + (this.var_byte_arr_arr_q[n2].length == 0 || n3 >= this.var_byte_arr_arr_q[n2].length ? "" : this.java_lang_String_c(this.var_byte_arr_arr_q[n2][n3]) + " x" + this.var_byte_arr_arr_q[n2][n3 + 1]), 49, 137 + n4 * 28, 0, 3, 0);
            n3 = (byte)(n3 + 2);
            n4 = (byte)(n4 + 1);
        }
        ak.b(this.java_lang_String_b(n2), 120, 236, 12, 3);
        this.J = (byte)(this.J + 1);
        if (this.J > 50) {
            this.J = 0;
            this.E = 1;
        }
    }

    private void b(al[] alArray) {
        int n2;
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.b(1, 2, 238, 318);
        ah.ah_b();
        ah.h(6, 11, 118, 116, 1);
        if (this.A != 0) {
            ak.b(alArray[this.var_byte_h[0][0]], 36, 5, 74, 2, 2, (int)alArray[this.var_byte_h[0][0]].var_short_arr_b[4]);
            ah.ah_b().c(alArray[this.var_byte_h[0][0]].var_byte_arr_b[2] + "\u0110\u1eb3ng c\u1ea5p", 8, 15, 0, 0);
            ah.ah_b().a(alArray[this.var_byte_h[0][0]].var_byte_arr_b[3] + 5, 15, 16, 17, 0);
            if (this.b(1, 1, this.var_byte_arr_arr_e[alArray[this.var_byte_h[0][0]].var_byte_arr_b[0]][1] * 3 + this.E, 61, 111, this.E != 1, 0)) {
                this.E = 0;
            }
        }
        ah.ah_b();
        ah.h(6, 143, 228, 172, 1);
        ah.ah_b();
        ah.e(14, 153, 212, 28, 3);
        ah.ah_b();
        ah.e(14, 269, 212, 28, 3);
        if (this.A != 0) {
            this.b(this.java_lang_String_b((int)alArray[this.var_byte_h[0][0]].var_byte_arr_b[0]), 271, 14, 0, 1, 2);
            int n3 = 129;
            n3 = 8;
            al al2 = alArray[this.var_byte_h[0][0]];
            ak ak2 = this;
            byte by = al2.var_byte_arr_b[4];
            n2 = (byte)(ak2.var_byte_arr_o[by < 4 ? 0 : 1] / 20);
            byte by2 = (byte)(al2.var_byte_arr_b[6] / 20);
            ak.c(n2, by2, 8, 129);
            ah.ah_b();
            ah.b(this.var_java_lang_StringBuffer_arr_b[alArray[this.var_byte_h[0][0]].var_byte_arr_b[3]].toString(), 31, 155, 0, 0, 1);
            if (alArray[this.var_byte_h[0][0]].var_byte_arr_b[5] == 0) {
                ah.ah_b();
                ah.b("Kh\u00f4ng th\u1ec3 ti\u1ebfn h\u00f3a", 121, 155, 0, 0, 1);
            } else {
                ah.ah_b();
                ah.b("C\u00f3 th\u1ec3 ti\u1ebfn h\u00f3a" + alArray[this.var_byte_h[0][0]].var_byte_arr_b[5] + "L\u1ea7n", 121, 155, 0, 0, 1);
            }
        }
        n2 = 143;
        n2 = 6;
        al[] alArray2 = alArray;
        ak ak3 = this;
        ah.ah_b();
        ah.b((Object[])ak3.var_int_c, 24, 187, 0, 3, 23, 3, 0);
        ah.ah_b();
        ah.b((Object[])ak3.var_byte_a, 141, 187, 0, 3, 23, 3, 0);
        if (ak3.A != 0) {
            ah.ah_b();
            ah.b((Object[])ak3.var_byte_e, 179, 187, 0, 3, 23, -1, 0);
            ak.b(alArray2[ak3.var_byte_h[0][0]], 64, 199, 48, 0, 0, (int)alArray2[ak3.var_byte_h[0][0]].var_short_arr_b[0]);
            ak.b(alArray2[ak3.var_byte_h[0][0]], 64, 222, 48, 1, 0, (int)alArray2[ak3.var_byte_h[0][0]].var_short_arr_b[1]);
            ak.b(alArray2[ak3.var_byte_h[0][0]].var_byte_arr_b[4], 64, 236, 0);
        }
        if (this.A != 0) {
            this.b(alArray, 183, 13, (int)this.H, (int)this.A, (byte[])this.var_byte_h[0]);
        }
        ah.ah_b().b(223, 12, 122, (int)this.var_byte_h[0][0], (int)this.A, true);
        ah.ah_b().c(this.A + "/" + (this.var_byte_f == 6 ? this.x : (byte)this.w), 200, 12, 0, 0);
        if (this.var_byte_h != -1) {
            ak.b((Object[])this.var_byte_d, 101, 30, 57, 2, 0, this.var_byte_h);
            if (this.var_byte_j == 1) {
                ak.c((String)this.var_byte_b, 140, 0);
            }
        }
        ah.ah_b().b(this.A != 0, true);
    }

    private void b(al[] alArray, short s2, short s3) {
        ah.ah_b();
        ah.b((Object[])this.var_int_c, 24, 187, 0, 3, 23, 3, 0);
        ah.ah_b();
        ah.b((Object[])this.var_byte_a, 141, 187, 0, 3, 23, 3, 0);
        if (this.A != 0) {
            ah.ah_b();
            ah.b((Object[])this.var_byte_e, 179, 187, 0, 3, 23, -1, 0);
            ak.b(alArray[this.var_byte_h[0][0]], 64, 199, 48, 0, 0, (int)alArray[this.var_byte_h[0][0]].var_short_arr_b[0]);
            ak.b(alArray[this.var_byte_h[0][0]], 64, 222, 48, 1, 0, (int)alArray[this.var_byte_h[0][0]].var_short_arr_b[1]);
            ak.b(alArray[this.var_byte_h[0][0]].var_byte_arr_b[4], 64, 236, 0);
        }
    }

    private void b(al[] alArray, int n2, int n3, int n4, int n5, byte[] byArray) {
        n2 = byArray[1];
        if (this.var_byte_f != 6) {
            ah.ah_b().a(34, 140, 15, 24, 0);
        }
        while (n2 < byArray[1] + n4 && n2 < n5) {
            if (byArray[0] == n2) {
                ah.ah_b();
                ah.e(145, 13 + (n2 - byArray[1]) * 24, 76, 21, 1);
            }
            ah.ah_b();
            ah.b(this.java_lang_String_e(alArray[n2].var_byte_arr_b[0]).toString(), 183, 13 + (n2 - byArray[1]) * 24, 17, byArray[0] == n2 ? 0 : 1, 1);
            n2 = (byte)(n2 + 1);
        }
    }

    private void b(int n2, int n3, int n4, int n5, int n6, byte[] byArray) {
        ah.ah_b().b(5, n2, n3, n4, 3, n5, 0, byArray[0] - byArray[1], 4, 2);
        for (n6 = byArray[1]; n6 < byArray[1] + 5 && n6 < this.w[8]; n6 = (int)((byte)(n6 + 1))) {
            ah.ah_b().a(this.w[n6] > 25 ? 50 : 51, n2 + 8, n3 + 8 + (n6 - byArray[1]) * n5, 0, 0);
            ah.ah_b();
            ah.b(this.java_lang_String_b(this.w[n6]).toString(), n2 + 21, n3 + 1 + (n6 - byArray[1]) * n5, 0, byArray[0] == n6 ? 0 : 3, 0);
            ah.ah_b();
            ah.b(this.w[n6] <= 30 ? this.var_byte_arr_arr_n[this.w[n6]][1] + "pow" : "B\u1ecb \u0111\u1ed9ng", n2 + n4 - 8, n3 + 1 + (n6 - byArray[1]) * n5, 24, byArray[0] == n6 ? 0 : 3, 0);
        }
    }

    private void b(al al2, int n2, int n3, int n4, int n5, int n6, byte[] byArray) {
        ah.ah_b().b(5, 8, 140, 211, 3, 26, 0, byArray[0] - byArray[1], 4, 2);
        for (n2 = 0; n2 < 2; n2 = (int)((byte)(n2 + 1))) {
            if (n2 > 0 && al2.var_byte_arr_b[n2 + 16] <= 0) continue;
            ah.ah_b().a(49, 16, 148 + (n2 - this.var_byte_h[0][1]) * 26, 0, 0);
            ah.ah_b();
            n4 = al2.var_byte_arr_b[n2 + 16];
            ak ak2 = this;
            if (n4 <= 0) {
                n4 = 0;
            }
            ah.b(ak2.var_java_lang_StringBuffer_arr_k[n4].toString(), 29, 141 + (n2 - this.var_byte_h[0][1]) * 26, 0, byArray[0] == n2 ? 0 : 3, 0);
        }
    }

    private void d(al al2) {
        ah.ah_b();
        ah.c();
        this.b(this.L, 1, 108, 0, 216);
        ah.ah_b();
        ah.h(120 + (this.var_byte_h == 0 ? -92 : 15), 111, 76, 22, 4);
        ah.ah_b();
        ah.b("K\u1ef9 n\u0103ng b\u00ecnh th\u01b0\u1eddng", 101, 111, 24, this.var_byte_h == 0 ? 0 : 1, 0);
        ah.ah_b();
        ah.b("N\u0103ng l\u1ef1c k\u1ef9 n\u0103ng", 139, 111, 0, this.var_byte_h == 0 ? 1 : 0, 0);
        if (this.b(1, 1, this.var_byte_arr_arr_e[al2.var_byte_arr_b[0]][1] * 3 + this.E, 177 - this.var_int_c, 97 - this.var_byte_a, this.E != 1, 0)) {
            this.E = 0;
        }
        ad.ad_b();
        this.var_int_c = ad.b(this.var_int_c, 3, false);
        ad.ad_b();
        this.var_byte_a = (byte)ad.b((int)this.var_byte_a, 3, false);
        if (this.var_byte_h == 0) {
            this.b(8, 140, 211, 26, 5, (byte[])this.var_byte_h[0]);
            if (this.w[this.var_byte_h[0][0]] != -1) {
                this.b(this.var_java_lang_StringBuffer_arr_m[this.w[this.var_byte_h[0][0]]].toString(), 11, 278, 23, 0, 1, 2);
            }
        } else {
            void var4_2 = this.var_byte_h[0];
            int n2 = 5;
            n2 = 26;
            n2 = 211;
            n2 = 140;
            n2 = 8;
            al al3 = al2;
            ak ak2 = this;
            ah.ah_b().b(5, 8, 140, 211, 3, 26, 0, (int)(var4_2[0] - var4_2[1]), 4, 2);
            for (int n3 = 0; n3 < 2; n3 = (int)((byte)(n3 + 1))) {
                if (n3 > 0 && al3.var_byte_arr_b[n3 + 16] <= 0) continue;
                ah.ah_b().a(49, 16, 148 + (n3 - ak2.var_byte_h[0][1]) * 26, 0, 0);
                ah.ah_b();
                byte by = al3.var_byte_arr_b[n3 + 16];
                ak ak3 = ak2;
                if (by <= 0) {
                    by = 0;
                }
                ah.b(ak3.var_java_lang_StringBuffer_arr_k[by].toString(), 29, 141 + (n3 - ak2.var_byte_h[0][1]) * 26, 0, var4_2[0] == n3 ? 0 : 3, 0);
            }
            if (al2.var_byte_arr_b[16 + this.var_byte_h[0][0]] > 0) {
                this.b(this.var_java_lang_StringBuffer_arr_l[al2.var_byte_arr_b[16 + this.var_byte_h[0][0]]].toString(), 11, 278, 23, 0, 1, 2);
            }
        }
        ah.ah_b().b(225, 141, 158, (int)this.var_byte_h[0][0], this.var_byte_h == 0 ? this.w[8] : (al2.var_byte_arr_b[16 + this.var_byte_h[0][0]] > 0 ? 2 : 1), true);
        if (this.var_byte_f != 13) {
            ah.ah_b().b(120, 120, 114, true, true);
        }
        ah.ah_b().b(this.var_byte_f == 13, true);
    }

    private void b(int n2, int n3, int n4, int n5, int n6) {
        ah.ah_b();
        ah.b(this.var_javax_microedition_lcdui_Image_arr_a[n2], 0, 0, 0);
        ah.ah_b();
        ah.b(1, 108, 238, 212);
        ah.ah_b();
        ah.h(6, n5 + 135, n6, 176 - n5, 1);
        ah.ah_b();
        ah.e(8, 278, n6 - 4, 24, 3);
    }

    private void I() {
        ad.ad_b();
        if (ad.g() && this.var_byte_f == 13) {
            if (this.w[this.var_byte_h[0][0]] <= 25) {
                this.b("K\u1ef9 n\u0103ng c\u00f3 th\u1ec3 thay th\u1ebf!", 0);
                return;
            }
            if (this.w[this.var_byte_h[0][0]] == this.var_byte_b[this.v].var_byte_arr_b[14]) {
                this.var_byte_b[this.v].var_byte_arr_b[14] = this.var_byte_p;
            } else {
                this.var_byte_b[this.v].var_byte_arr_b[15] = this.var_byte_p;
            }
            this.g((al)this.var_byte_b[this.v]);
            return;
        }
        ad.ad_b();
        if (ad.i()) {
            this.var_byte_h[0][1] = this.u;
            this.var_byte_h[0][0] = this.v;
            this.t = (byte[])false;
            this.var_byte_h = (byte)-1;
            return;
        }
        ad.ad_b();
        if (ad.e() && this.var_byte_f != 13) {
            this.var_byte_h = (byte)(this.var_byte_h ^ 1);
            this.var_byte_h[0][0] = false;
            this.var_byte_h[0][1] = false;
            return;
        }
        ad.ad_b();
        if (ad.boolean_c()) {
            this.var_byte_g = (byte)120;
            if (this.var_byte_h == 0) {
                ad.ad_b();
                ad.b((byte[])this.var_byte_h[0], 0, (int)this.w[8], 5);
                return;
            }
            if (this.var_byte_f == 6) {
                if (this.var_int_c[this.v].var_byte_arr_b[17] > 0) {
                    void v0 = this.var_byte_h[0];
                    v0[0] = (byte)(v0[0] ^ 1);
                    return;
                }
            } else if (this.var_byte_b[this.v].var_byte_arr_b[17] > 0) {
                void v1 = this.var_byte_h[0];
                v1[0] = (byte)(v1[0] ^ 1);
            }
        }
    }

    public final void void_b(int n2, int n3, boolean bl) {
        ah.ah_b();
        ah.c();
        this.b(this.L, 1, 108, 5, 223);
        if (n2 == 1 && this.var_byte_g > 0) {
            if (this.var_byte_g == 1 && this.boolean_b(5, 5, 6, 177, 97, 0)) {
                this.b(2, (int)this.var_byte_arr_arr_e[this.var_byte_b[n3].var_byte_arr_b[0]][0], 1);
                this.var_byte_g = (byte)2;
            } else if (this.var_byte_g > 1 && this.var_byte_g < 14) {
                this.b(this.var_byte_arr_arr_e[this.var_byte_b[n3].var_byte_arr_b[0]][1], 1, 177, 97, 80, 77, 15, this.var_byte_g - 2, 0);
                this.var_byte_g = (byte)(this.var_byte_g + 1);
                if (this.var_byte_g == 14) {
                    this.var_byte_g = (byte)-1;
                    this.b("Ti\u1ebfn h\u00f3a th\u00e0nh " + this.java_lang_String_e(this.var_byte_b[n3].var_byte_arr_b[0]), 0);
                }
            }
        } else {
            this.b(1, 1, this.var_byte_arr_arr_e[this.var_byte_b[n3].var_byte_arr_b[0]][1] * 3, 177 - this.var_int_c, 97 - this.var_byte_a, true, 0);
        }
        if (n2 == 1 && this.var_byte_h == 1) {
            this.h(this.var_byte_b[n3].var_byte_arr_b[0], 26, 150, 23);
        } else {
            ah.ah_b();
            ah.b((Object[])this.var_byte_a, 26, 150, 0, 3, 25, 3, 0);
            ah.ah_b();
            ah.b((Object[])this.var_int_c, 126, 150, 0, 3, 25, 3, 0);
        }
        if (n2 == 0) {
            this.var_byte_a = 0;
            this.var_int_c = 0;
            ah.ah_b();
            ah.b(this.java_lang_String_e(this.var_byte_b[n3].var_byte_arr_b[0]) + "L\u00ean t\u1edbi" + this.var_byte_b[n3].var_byte_arr_b[2] + "\u0110\u1eb3ng c\u1ea5p", 232, 112, 24, 1, 0);
            ah.ah_b();
            ah.b(this.var_javax_microedition_lcdui_Image_arr_c[1], 1 - this.var_short_b, 104, 36);
            if (this.var_byte_arr_arr_a[bl ? n3 : this.var_byte_b[n3].var_byte_arr_b[1]][1] != -1) {
                ah.ah_b();
                ah.b("T\u1eadp \u0111\u01b0\u1ee3c k\u1ef9 n\u0103ng: " + this.java_lang_String_b(this.var_byte_arr_arr_a[bl ? n3 : this.var_byte_b[n3].var_byte_arr_b[1]][1]), 120, 280, 17, 9, 0);
            }
        } else if (n2 == 1) {
            ah.ah_b();
            ah.h(120 + (this.var_byte_h == 0 ? -92 : 15), 114, 76, 22, 4);
            ah.ah_b();
            ah.b("Thu\u1ed9c t\u00ednh c\u01a1 b\u1ea3n", 67, 113, 17, this.var_byte_h == 0 ? 0 : 1, 0);
            ah.ah_b();
            ah.b("Ti\u1ebfn h\u00f3a t\u01b0 li\u1ec7u s\u1ed1ng", 173, 113, 17, this.var_byte_h == 0 ? 1 : 0, 0);
            ah.ah_b().b(120, 123, 114, true, true);
            ad.ad_b();
            this.var_int_c = ad.b(this.var_int_c, 3, false);
            ad.ad_b();
            this.var_byte_a = (byte)ad.b((int)this.var_byte_a, 3, false);
            ah.ah_b();
            ah.b("B\u1ea1n c\u00f3 mu\u1ed1n x\u00e1c \u0111\u1ecbnh s\u1ef1 ti\u1ebfn h\u00f3a c\u1ee7a c\u00e1c S\u1ee7ng V\u1eadt kh\u00f4ng?", 120, 278, 17, 0, 1);
        }
        ah.ah_b().b(true, true);
    }

    private void E() {
        ad.ad_b();
        if (ad.g() && this.var_byte_g == 0) {
            byte by = this.var_byte_b[this.v].var_byte_arr_b[4];
            byte by2 = this.var_byte_b[this.v].var_byte_arr_b[2];
            byte by3 = this.var_byte_b[this.v].var_byte_arr_b[0];
            byte by4 = this.byte_d(by3);
            if (ak.b(by, by2) != -1) {
                by4 = ak.b(by, by2);
            }
            if (by4 == 0) {
                this.var_byte_b[this.v].b(this, (int)this.var_byte_arr_arr_q[by3][1], 1);
            } else if (by4 > 0) {
                this.var_byte_b[this.v].b(this, (int)this.var_byte_arr_arr_q[by3][0], (int)this.var_byte_b[this.v].var_byte_arr_b[5]);
            } else if (by4 == -1) {
                this.b("T\u00e0i li\u1ec7u kh\u00f4ng \u0111\u1ee7, kh\u00f4ng th\u1ec3 ti\u1ebfn h\u00f3a!", 0);
                this.var_byte_h = 1;
            } else if (by4 == -2) {
                this.b("\u0110\u1eb3ng c\u1ea5p kh\u00f4ng \u0111\u1ea1t t\u1edbi 15 c\u1ea5p, kh\u00f4ng th\u1ec3 ti\u1ebfn h\u00f3a!", 0);
            } else if (by4 == -3) {
                this.b("\u0110\u1eb3ng c\u1ea5p kh\u00f4ng \u0111\u1ea1t t\u1edbi 25 c\u1ea5p, kh\u00f4ng th\u1ec3 ti\u1ebfn h\u00f3a!", 0);
            } else {
                this.b("\u0110\u1eb3ng c\u1ea5p kh\u00f4ng \u0111\u1ea1t t\u1edbi 30 c\u1ea5p, kh\u00f4ng th\u1ec3 ti\u1ebfn h\u00f3a!", 0);
            }
            if (by4 >= 0) {
                this.var_byte_g = 1;
                this.void_g(6);
                this.i((al)this.var_byte_b[this.v]);
                this.var_byte_h = 0;
                this.void_b(by3);
                if (by4 > 0) {
                    this.void_c(34, 1);
                }
            }
            return;
        }
        ad.ad_b();
        if (ad.i()) {
            this.J();
            this.i((al)this.var_byte_b[this.v]);
            return;
        }
        ad.ad_b();
        if (ad.e()) {
            if (this.var_byte_g > 0) {
                return;
            }
            this.var_byte_h = (byte)(this.var_byte_h ^ 1);
        }
    }

    private void void_b(byte by) {
        byte by2;
        int n2 = 2;
        do {
            this.void_c((int)this.var_byte_arr_arr_q[by][n2], this.var_byte_arr_arr_q[by][n2 + 1]);
            by2 = (byte)(n2 + 2);
            n2 = by2;
        } while (by2 < this.var_byte_arr_arr_q[by].length - 1);
    }

    private static byte b(byte by, byte by2) {
        int n2 = -1;
        if (by == 1 && by2 < 15) {
            n2 = -2;
        } else if (by == 2 && by2 < 25) {
            n2 = -3;
        } else if (by == 3 && by2 < 30) {
            n2 = -4;
        }
        return (byte)n2;
    }

    private void J() {
        this.var_byte_h[0][1] = this.u;
        this.var_byte_h[0][0] = this.v;
        this.t = (byte[])false;
        this.var_byte_h = (byte)-1;
        this.b("Sinh m\u1ec7nh#nN\u0103ng l\u01b0\u1ee3ng#n\u0110\u1eb3ng c\u1ea5p", 240, 0);
        this.b("S\u1ee9c m\u1ea1nh#nPh\u00f2ng ng\u1ef1#nNhanh nh\u1eb9n", 240, 1);
    }

    private void h(int n2, int n3, int n4, int n5) {
        n5 = 2;
        int n6 = 0;
        do {
            ah.ah_b();
            ah.b(this.java_lang_String_c(this.var_byte_arr_arr_q[n2][n5]) + "(" + this.byte_b(-2, (int)this.var_byte_arr_arr_q[n2][n5], true) + "/" + this.var_byte_arr_arr_q[n2][n5 + 1] + ")", n3, n4 + n6 * 23, 0, 3, 0);
            n5 = (byte)(n5 + 2);
            n6 = (byte)(n6 + 1);
        } while (n5 < this.var_byte_arr_arr_q[n2].length - 1);
        if (this.var_byte_arr_arr_q[n2][0] > 0) {
            byte by = this.byte_b(-2, 34, true);
            n5 = by;
            if (by > 0) {
                ah.ah_b();
                ah.b(this.java_lang_String_c(34) + "(" + n5 + "/1" + ")", n3, n4 + n6 * 23, 0, -1, 0);
            }
        }
    }

    private byte byte_d(int n2) {
        byte by;
        int n3 = 2;
        byte by2 = this.var_byte_arr_arr_q[n2][0];
        do {
            if (this.byte_b(-2, (int)this.var_byte_arr_arr_q[n2][n3], true) < this.var_byte_arr_arr_q[n2][n3 + 1]) {
                return -1;
            }
            by = (byte)(n3 + 2);
            n3 = by;
        } while (by < this.var_byte_arr_arr_q[n2].length - 1);
        if (by2 > 0 && this.byte_b(-2, 34, true) <= 0) {
            by2 = 0;
        }
        return by2;
    }

    private void c(al[] object) {
        if (this.var_byte_h == -1) {
            ad.ad_b();
            if (ad.g() && this.A != 0) {
                if (this.var_byte_c == 1) {
                    if (this.var_byte_f == 15) {
                        this.U();
                        return;
                    }
                    if (this.var_byte_f == 13) {
                        al al2 = object[this.var_byte_h[0][0]];
                        object = this;
                        if (((ak)object).var_byte_p + 9 >= 35 && ((ak)object).u[((ak)object).var_byte_p + 9 - 35] > ((ak)object).var_byte_arr_arr_l[3]) {
                            ((ak)object).b("Y\u00eau c\u1ea7u hu\u1ea5n luy\u1ec7n s\u01b0" + ((ak)object).u[((ak)object).var_byte_p + 9 - 35] + "T\u00ecm hi\u1ec3u v\u1ec1 \u0111\u1eb3ng c\u1ea5p m\u1edbi!", 0);
                            return;
                        }
                        if (al2.a(((ak)object).var_byte_p)) {
                            ((ak)object).b(((ak)object).java_lang_String_e(al2.var_byte_arr_b[0]) + "C\u00f3 \u0111\u01b0\u1ee3c k\u1ef9 n\u0103ng", 0);
                            return;
                        }
                        if (al2.var_byte_arr_b[14] != -1 && al2.var_byte_arr_b[15] != -1) {
                            ((ak)object).c(al2);
                            ((ak)object).L = al2.var_byte_arr_b[3];
                            super.h(1, 0);
                            ((ak)object).b("Vui l\u00f2ng l\u1ef1a ch\u1ecdn k\u1ef9 n\u0103ng mu\u1ed1n thay \u0111\u1ed5i!", -1);
                            return;
                        }
                        if (al2.var_byte_arr_b[14] == -1) {
                            al2.var_byte_arr_b[14] = ((ak)object).var_byte_p;
                        } else {
                            al2.var_byte_arr_b[15] = ((ak)object).var_byte_p;
                        }
                        super.g(al2);
                        return;
                    }
                    StringBuffer stringBuffer = new StringBuffer("N\u0103ng l\u1ef1c#nK\u1ef9 n\u0103ng");
                    if (this.var_byte_f == 4) {
                        if (object[this.var_byte_h[0][0]].var_byte_arr_b[5] > 0) {
                            stringBuffer.append("#nTi\u1ebfn h\u00f3a");
                        }
                        if (this.A > 1) {
                            stringBuffer.append("#nL\u01b0u tr\u1eef#nB\u00e1n th\u00fa");
                        }
                    } else if (this.var_byte_f == 6) {
                        if (!this.var_at_b.var_boolean_b) {
                            stringBuffer.append("#nCh\u1ecdn#nB\u00e1n th\u00fa");
                        } else {
                            stringBuffer.append("#nB\u00e1n th\u00fa");
                        }
                    } else {
                        if (this.var_byte_h[0][0] != false) {
                            stringBuffer.append("#nTham chi\u1ebfn");
                        }
                        if (object[this.var_byte_h[0][0]].var_byte_arr_b[5] > 0) {
                            stringBuffer.append("#nTi\u1ebfn h\u00f3a");
                        }
                        if (this.A > 1) {
                            stringBuffer.append("#nPh\u00f3ng sinh");
                        }
                    }
                    this.b(stringBuffer.toString(), 240, 3);
                    this.var_byte_h = 0;
                    return;
                }
                if (this.var_byte_c < 0) {
                    if (this.var_byte_f == 15) {
                        this.U();
                        return;
                    }
                    if (this.var_byte_h[0][0] != false) {
                        this.b("Tham chi\u1ebfn#nK\u1ef9 n\u0103ng", 240, 3);
                    } else {
                        this.b("K\u1ef9 n\u0103ng", 240, 3);
                    }
                    this.var_byte_h = 0;
                    return;
                }
            } else {
                ad.ad_b();
                if (ad.i()) {
                    if (this.var_byte_f == 13) {
                        this.p(2);
                        return;
                    }
                    if (this.var_byte_c == 1) {
                        if (this.var_byte_f == 15) {
                            this.p(0);
                            this.var_byte_f = (byte)3;
                            return;
                        }
                        if (this.var_byte_f == 6 || this.var_byte_f == 4) {
                            if (!this.var_at_b.var_boolean_b) {
                                this.void_b(0);
                                this.void_c(this.var_byte_f == 6 ? 1 : 0);
                                return;
                            }
                            ak ak2 = this;
                            ak2.var_at_b.e();
                            return;
                        }
                        this.void_b(0);
                        this.void_d(1);
                        return;
                    }
                    if (this.var_byte_c == -2) {
                        if (object[0].var_short_arr_b[0] > 0) {
                            if (this.var_byte_h[0][0] != false) {
                                this.b(2, (int)this.var_byte_arr_arr_e[object[0].var_byte_arr_b[0]][0], 1);
                            }
                            this.at();
                        } else {
                            this.b("S\u1ee7ng V\u1eadt ph\u00eda tr\u01b0\u1edbc kh\u00f4ng th\u1ec3 tham chi\u1ebfn", 0);
                        }
                        this.var_byte_c = (byte)-1;
                        return;
                    }
                    if (this.var_byte_c == -1) {
                        if (this.var_byte_f == 15) {
                            this.p(0);
                            return;
                        }
                        this.b("S\u1ee7ng V\u1eadt ph\u00eda tr\u01b0\u1edbc kh\u00f4ng th\u1ec3 tham chi\u1ebfn", 0);
                        return;
                    }
                } else {
                    ad.ad_b();
                    if (ad.boolean_c() && this.A != 0) {
                        ad.ad_b();
                        ad.b((byte[])this.var_byte_h[0], 0, (int)this.A, this.H);
                        this.b(2, (int)this.var_byte_arr_arr_e[object[this.var_byte_h[0][0]].var_byte_arr_b[0]][0], 1);
                        this.i((al)object[this.var_byte_h[0][0]]);
                        this.var_byte_f = (byte)120;
                        return;
                    }
                }
            }
        } else {
            this.P();
        }
    }

    private void h(al al2) {
        if (this.var_byte_p + 9 >= 35 && this.u[this.var_byte_p + 9 - 35] > this.var_byte_arr_arr_l[3]) {
            this.b("Y\u00eau c\u1ea7u hu\u1ea5n luy\u1ec7n s\u01b0" + this.u[this.var_byte_p + 9 - 35] + "T\u00ecm hi\u1ec3u v\u1ec1 \u0111\u1eb3ng c\u1ea5p m\u1edbi!", 0);
            return;
        }
        if (al2.a(this.var_byte_p)) {
            this.b(this.java_lang_String_e(al2.var_byte_arr_b[0]) + "C\u00f3 \u0111\u01b0\u1ee3c k\u1ef9 n\u0103ng", 0);
            return;
        }
        if (al2.var_byte_arr_b[14] != -1 && al2.var_byte_arr_b[15] != -1) {
            this.c(al2);
            this.L = al2.var_byte_arr_b[3];
            this.h(1, 0);
            this.b("Vui l\u00f2ng l\u1ef1a ch\u1ecdn k\u1ef9 n\u0103ng mu\u1ed1n thay \u0111\u1ed5i!", -1);
            return;
        }
        if (al2.var_byte_arr_b[14] == -1) {
            al2.var_byte_arr_b[14] = this.var_byte_p;
        } else {
            al2.var_byte_arr_b[15] = this.var_byte_p;
        }
        this.g(al2);
    }

    private void g(al al2) {
        this.b(this.java_lang_String_e(al2.var_byte_arr_b[0]) + "T\u1eadp \u0111\u01b0\u1ee3c k\u1ef9 n\u0103ng: " + this.java_lang_String_b(this.var_byte_p), 0);
        this.p(2);
        this.void_c(this.var_byte_p + 35 - 25 - 1, 1);
        ad.ad_b();
        ad.void_b((byte[])this.var_byte_h[0], (int)this.var_byte_j[this.u], (int)this.H);
    }

    private void f(al al2) {
        this.var_int_e = 100 + al2.var_byte_arr_b[2] * (al2.var_byte_arr_b[4] * 5);
    }

    private void K() {
        if (this.z >= this.x) {
            this.b("S\u1ee7ng V\u1eadt \u0111\u00e3 \u0111\u1ea7y", 0);
            return;
        }
        if (!this.boolean_d((int)this.var_byte_h[0][0])) {
            this.b("Ph\u1ea3i mang theo m\u1ed9t S\u1ee7ng V\u1eadt c\u00f3 th\u1ec3 tham chi\u1ebfn!", 0);
            return;
        }
        this.var_int_c[this.z] = this.var_byte_b[this.var_byte_h[0][0]];
        this.z = (byte)(this.z + 1);
        this.L();
    }

    private void L() {
        byte by;
        for (by = this.var_byte_h[0][0]; by < this.y - 1; by = (byte)(by + 1)) {
            this.var_byte_b[by] = this.var_byte_b[by + 1];
            this.var_boolean_arr_b[by] = this.var_boolean_arr_b[by + 1];
        }
        for (by = this.y; by < ((byte)this.var_byte_b).length; by = (byte)(by + 1)) {
            this.var_boolean_arr_b[by] = true;
        }
        this.y = (byte)(this.y - 1);
        if (this.var_byte_h[0][0] == this.y) {
            void v0 = this.var_byte_h[0];
            v0[0] = (byte)(v0[0] - true);
        }
        this.b(2, (int)this.var_byte_arr_arr_e[this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]][0], 1);
        this.i((al)this.var_byte_b[this.var_byte_h[0][0]]);
        this.var_byte_f = (byte)120;
        this.A = this.y;
        this.var_byte_h = (byte)-1;
        ad.ad_b();
        ad.void_b((byte[])this.var_byte_h[0], (int)this.A, (int)this.H);
    }

    private static void void_b(al al2, al al3) {
        al al4 = new al();
        new al().var_byte_arr_b = al2.var_byte_arr_b;
        al4.var_byte_b = al2.var_byte_b;
        al4.var_short_arr_b = al2.var_short_arr_b;
        al2.var_byte_arr_b = al3.var_byte_arr_b;
        al2.var_byte_b = al3.var_byte_b;
        al2.var_short_arr_b = al3.var_short_arr_b;
        al3.var_byte_arr_b = al4.var_byte_arr_b;
        al3.var_byte_b = al4.var_byte_b;
        al3.var_short_arr_b = al4.var_short_arr_b;
    }

    private void M() {
        if (this.y < this.w) {
            this.var_byte_b[this.y] = this.var_int_c[this.var_byte_h[0][0]];
            this.var_boolean_arr_b[this.y] = true;
            this.y = (byte)(this.y + 1);
            this.N();
            return;
        }
        this.b("C\u00f3 th\u1ec3 mang theo S\u1ee7ng V\u1eadt \u0111\u00e3 \u0111\u1ea1t t\u1edbi h\u1ea1n m\u1ee9c cao nh\u1ea5t!", 1);
    }

    private void N() {
        for (byte by = this.var_byte_h[0][0]; by < this.z - 1; by = (byte)(by + true)) {
            this.var_int_c[by] = this.var_int_c[by + true];
        }
        this.A = this.z = (byte)(this.z - 1);
        if (this.var_byte_h[0][0] == this.z) {
            void v0 = this.var_byte_h[0];
            v0[0] = (byte)(v0[0] - true);
        }
        if (this.A > 0) {
            this.b(2, (int)this.var_byte_arr_arr_e[this.var_int_c[this.var_byte_h[0][0]].var_byte_arr_b[0]][0], 1);
            this.i((al)this.var_int_c[this.var_byte_h[0][0]]);
        }
        this.var_byte_f = (byte)120;
        this.var_byte_h = (byte)-1;
        ad.ad_b();
        ad.void_b((byte[])this.var_byte_h[0], (int)this.A, (int)this.H);
    }

    public final void d() {
        var_int_a = 35;
        this.t = (byte[])false;
        this.v = (byte[])false;
        this.u = (byte[])false;
        this.A = this.var_byte_f == 6 ? this.z : this.y;
        this.var_byte_h[0][1] = false;
        this.var_byte_h[0][0] = false;
        this.var_byte_h = (byte)-1;
        this.H = (byte)5;
        this.E = 0;
        this.b("Sinh m\u1ec7nh#nN\u0103ng l\u01b0\u1ee3ng#n\u0110\u1eb3ng c\u1ea5p", 240, 0);
        this.b("S\u1ee9c m\u1ea1nh#nPh\u00f2ng ng\u1ef1#nNhanh nh\u1eb9n", 240, 1);
        byte by = this.var_byte_b = this.var_byte_f == 6 ? this.var_int_c[this.var_byte_h[0][0]] : this.var_byte_b[this.var_byte_h[0][0]];
        if (this.A != 0) {
            this.i((al)this.var_byte_b);
            this.b(2, (int)this.var_byte_arr_arr_e[this.var_byte_b.var_byte_arr_b[0]][0], 1);
        }
    }

    private void i(al al2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(al2.var_short_arr_b[6] + "#n");
        stringBuffer.append(al2.var_short_arr_b[7] + "#n");
        stringBuffer.append(al2.var_short_arr_b[5]);
        this.b(stringBuffer.toString(), 240, 2);
    }

    private void O() {
        this.var_byte_g = 0;
        this.var_byte_h = (byte)-1;
        System.gc();
        var_int_a = -11;
    }

    private void p(int n2) {
        this.var_byte_f = (byte)15;
        this.H = (byte)7;
        var_int_a = 25;
        this.var_byte_h = (byte)-1;
        if (this.var_byte_c == 1) {
            this.var_java_lang_String_arr_c = new String[]{"\u0110\u1ea1o c\u1ee5", "Tr\u1ee3 gi\u00fap", "V\u00f2ng", "\u1ea4p tr\u1ee9ng"};
        } else if (this.var_byte_c == -1) {
            this.var_java_lang_String_arr_c = new String[]{"\u0110\u1ea1o c\u1ee5"};
        } else if (this.var_byte_c == 2) {
            this.var_java_lang_String_arr_c = new String[]{"\u1ea4p tr\u1ee9ng"};
        }
        this.u = (byte[])((byte)n2);
        this.v = (byte[])false;
        this.var_byte_h[0][1] = this.var_byte_i[this.u];
        this.var_byte_h[0][0] = this.var_byte_f[this.u];
        ad.ad_b();
        ad.void_b((byte[])this.var_byte_h[0], (int)this.var_byte_j[this.u], (int)this.H);
        this.var_byte_arr_arr_l = null;
        ad.ad_b();
        ad.var_int_c = 0;
        this.var_byte_arr_arr_l = ad.ad_b().byte_arr_arr_b(ad.ad_b().byte_arr_b("data/box.d", -1));
    }

    /*
     * Enabled aggressive block sorting
     */
    private void P() {
        block39: {
            block36: {
                block38: {
                    block37: {
                        if (this.var_byte_j == 0) {
                            ad.ad_b();
                            if (ad.boolean_c()) {
                                ad.ad_b();
                                this.var_byte_h = ad.byte_b((int)this.var_byte_h, 0, ((byte)this.var_byte_d).length - 1);
                                return;
                            }
                        }
                        ad.ad_b();
                        if (!ad.g()) break block36;
                        ad.ad_b();
                        if (ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "K\u1ef9 n\u0103ng")) break block37;
                        ad.ad_b();
                        if (!ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "N\u0103ng l\u1ef1c")) break block38;
                    }
                    this.c((al)(this.var_byte_f == 6 ? this.var_int_c[this.var_byte_h[0][0]] : this.var_byte_b[this.var_byte_h[0][0]]));
                    if (this.var_byte_c > 0) {
                        this.L = this.var_byte_f == 6 ? this.var_int_c[this.var_byte_h[0][0]].var_byte_arr_b[3] : this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[3];
                    } else if (this.var_byte_c < 0 && this.var_z_b != null) {
                        this.L = this.var_z_b.i;
                    }
                    ad.ad_b();
                    this.h(1, ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "K\u1ef9 n\u0103ng") ? 0 : 1);
                    return;
                }
                ad.ad_b();
                if (ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "Tham chi\u1ebfn")) {
                    if (this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[0] > 0) {
                        if (this.var_byte_c < 0) {
                            for (byte by = 1; by <= this.t[0] && this.t[by] != this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[1]; by = (byte)(by + 1)) {
                                if (by != this.t[0]) continue;
                                this.t[0] = (byte)(this.t[0] + 1);
                                this.t[this.t[0]] = this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[1];
                            }
                            this.c((al)this.var_byte_b[this.var_byte_h[0][0]]);
                        }
                        ak.void_b((al)this.var_byte_b[this.var_byte_h[0][0]], (al)this.var_byte_b[0]);
                        this.b(2, (int)this.var_byte_arr_arr_e[this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]][0], 1);
                        this.i((al)this.var_byte_b[this.var_byte_h[0][0]]);
                        if (this.var_byte_c < 0) {
                            this.aa();
                            var_int_a = -50;
                            this.C = 0;
                            if (this.var_byte_c == -1) {
                                this.var_z_b.d = 1;
                                this.var_z_c.d = 1;
                            }
                            this.var_z_b.e = 0;
                            this.M = 0;
                        }
                        this.N = 0;
                    } else {
                        this.b("S\u1ee7ng V\u1eadt ph\u00eda tr\u01b0\u1edbc kh\u00f4ng th\u1ec3 tham chi\u1ebfn", 0);
                    }
                    this.var_byte_h = (byte)-1;
                    return;
                }
                ad.ad_b();
                if (ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "Ti\u1ebfn h\u00f3a")) {
                    void var2_4 = this.var_byte_b[this.var_byte_h[0][0]];
                    ak ak2 = this;
                    byte by = (byte)(var2_4.var_byte_arr_b[0] + 1);
                    byte by2 = var2_4.var_byte_arr_b[2];
                    boolean bl = false;
                    if (ak2.var_byte_arr_arr_q[var2_4.var_byte_arr_b[0]][0] > 0 && ak2.byte_b(-2, 34, true) > 0) {
                        by = ak2.var_byte_arr_arr_q[var2_4.var_byte_arr_b[0]][0];
                        bl = true;
                    }
                    ak2.var_short_arr_arr_b = null;
                    ak2.var_short_arr_arr_b = new short[1][6];
                    ak2.var_short_arr_arr_b[0][0] = (short)(ak2.short_b((al)var2_4, ak2.var_byte_arr_arr_d[by][0] + ak2.var_byte_arr_arr_d[by][7] * by2 / 10) - var2_4.var_short_arr_b[2]);
                    ak2.var_short_arr_arr_b[0][1] = (short)(ak2.var_byte_arr_arr_d[by][1] + ak2.var_byte_arr_arr_d[by][8] * by2 / 10 - var2_4.var_short_arr_b[3]);
                    ak2.var_short_arr_arr_b[0][2] = (short)(-(bl ? var2_4.var_byte_arr_b[5] : 1));
                    ak2.var_short_arr_arr_b[0][3] = (byte)(ak2.var_byte_arr_arr_d[by][3] + ak2.var_byte_arr_arr_d[by][10] * by2 / 10 - var2_4.var_short_arr_b[6]);
                    ak2.var_short_arr_arr_b[0][4] = (byte)(ak2.var_byte_arr_arr_d[by][4] + ak2.var_byte_arr_arr_d[by][11] * by2 / 10 - var2_4.var_short_arr_b[7]);
                    ak2.var_short_arr_arr_b[0][5] = (byte)(ak2.var_byte_arr_arr_d[by][2] + ak2.var_byte_arr_arr_d[by][9] * by2 / 10 - var2_4.var_short_arr_b[5]);
                    ak2.b("Sinh m\u1ec7nh: +" + ak2.var_short_arr_arr_b[0][0] + "#npow" + ": +" + ak2.var_short_arr_arr_b[0][1] + "#nTi\u1ebfn h\u00f3a" + ": " + ak2.var_short_arr_arr_b[0][2], 240, 0);
                    ak2.b("S\u1ee9c m\u1ea1nh: +" + ak2.var_short_arr_arr_b[0][3] + "#nPh\u00f2ng ng\u1ef1" + ": +" + ak2.var_short_arr_arr_b[0][4] + "#nNhanh nh\u1eb9n" + ": +" + ak2.var_short_arr_arr_b[0][5], 240, 1);
                    ak2.var_short_arr_arr_b = null;
                    this.L = this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[3];
                    this.var_byte_g = 0;
                    this.h(2, 0);
                    return;
                }
                ad.ad_b();
                if (ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "Ph\u00f3ng sinh")) {
                    if (!this.boolean_d((int)this.var_byte_h[0][0])) {
                        this.b("Ph\u1ea3i mang theo m\u1ed9t S\u1ee7ng V\u1eadt c\u00f3 th\u1ec3 tham chi\u1ebfn!", 0);
                        return;
                    }
                    if (this.var_byte_j != 1) {
                        this.var_byte_j = 1;
                        this.var_byte_b = (byte)"Ph\u00f3ng sinh S\u1ee7ng V\u1eadt s\u1ebd bi\u1ebfn m\u1ea5t, b\u1ea1n c\u00f3 mu\u1ed1n ti\u1ebfp t\u1ee5c kh\u00f4ng?";
                        return;
                    }
                    this.var_byte_j = 0;
                    this.byte_b((int)this.var_byte_h[0][0]);
                    if (this.var_byte_h[0][0] == this.y) {
                        void v0 = this.var_byte_h[0];
                        v0[0] = (byte)(v0[0] - true);
                    }
                    this.b(2, (int)this.var_byte_arr_arr_e[this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]][0], 1);
                    this.i((al)this.var_byte_b[this.var_byte_h[0][0]]);
                    this.var_byte_f = (byte)120;
                    this.A = this.y;
                    break block39;
                } else {
                    ad.ad_b();
                    if (ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "L\u01b0u tr\u1eef")) {
                        if (var_int_a == 35) {
                            this.K();
                            return;
                        }
                        this.var_byte_f = (byte)4;
                        this.var_byte_c = 1;
                        this.d();
                        return;
                    }
                    ad.ad_b();
                    if (ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "Ch\u1ecdn")) {
                        if (var_int_a == 35) {
                            this.M();
                            return;
                        }
                        this.var_byte_f = (byte)6;
                        this.var_byte_c = 1;
                        this.d();
                        return;
                    }
                    ad.ad_b();
                    if (ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "B\u00e1n th\u00fa")) {
                        if (this.var_byte_j == 1) {
                            this.var_byte_j = 0;
                            this.var_int_b += this.var_int_e;
                            this.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c kim ti\u1ec1n: " + this.var_int_e, 0);
                            if (this.var_byte_f == 6) {
                                this.N();
                                return;
                            }
                            this.L();
                            return;
                        }
                        if (this.var_byte_f == 4 && !this.boolean_d((int)this.var_byte_h[0][0])) {
                            this.b("Ph\u1ea3i mang theo m\u1ed9t S\u1ee7ng V\u1eadt c\u00f3 th\u1ec3 tham chi\u1ebfn!", 0);
                            return;
                        }
                        this.var_byte_j = 1;
                        void var2_5 = this.var_byte_f == 4 ? this.var_byte_b[this.var_byte_h[0][0]] : this.var_int_c[this.var_byte_h[0][0]];
                        ak ak3 = this;
                        this.var_int_e = 100 + var2_5.var_byte_arr_b[2] * (var2_5.var_byte_arr_b[4] * 5);
                        this.var_byte_b = (byte)("\u0110\u1ea1t \u0111\u01b0\u1ee3c kim ti\u1ec1n: " + this.var_int_e + ", B\u1ea1n c\u00f3 mu\u1ed1n b\u00e1n \u0111i kh\u00f4ng?");
                        return;
                    }
                    ad.ad_b();
                    if (!ad.b((StringBuffer)this.var_byte_d[this.var_byte_h], "B\u1ecf")) return;
                    this.d(false);
                    return;
                }
            }
            ad.ad_b();
            if (!ad.i()) return;
            if (this.var_byte_j != 0) {
                this.var_byte_j = 0;
                return;
            }
            if (var_int_a == 65) {
                this.d(false);
                return;
            }
        }
        this.var_byte_h = (byte)-1;
    }

    private void h(int n2, int n3) {
        this.u = this.var_byte_h[0][1];
        this.v = this.var_byte_h[0][0];
        this.t = (byte[])((byte)n2);
        this.var_byte_h[0][0] = false;
        this.var_byte_h[0][1] = false;
        this.var_byte_h = (byte)n3;
        this.var_int_c = 116;
        this.var_byte_a = (byte)-14;
    }

    private void j(al al2) {
        byte by = (byte)(al2.var_byte_arr_b[0] + 1);
        byte by2 = al2.var_byte_arr_b[2];
        boolean bl = false;
        if (this.var_byte_arr_arr_q[al2.var_byte_arr_b[0]][0] > 0 && this.byte_b(-2, 34, true) > 0) {
            by = this.var_byte_arr_arr_q[al2.var_byte_arr_b[0]][0];
            bl = true;
        }
        this.var_short_arr_arr_b = null;
        this.var_short_arr_arr_b = new short[1][6];
        this.var_short_arr_arr_b[0][0] = (short)(this.short_b(al2, this.var_byte_arr_arr_d[by][0] + this.var_byte_arr_arr_d[by][7] * by2 / 10) - al2.var_short_arr_b[2]);
        this.var_short_arr_arr_b[0][1] = (short)(this.var_byte_arr_arr_d[by][1] + this.var_byte_arr_arr_d[by][8] * by2 / 10 - al2.var_short_arr_b[3]);
        this.var_short_arr_arr_b[0][2] = (short)(-(bl ? al2.var_byte_arr_b[5] : 1));
        this.var_short_arr_arr_b[0][3] = (byte)(this.var_byte_arr_arr_d[by][3] + this.var_byte_arr_arr_d[by][10] * by2 / 10 - al2.var_short_arr_b[6]);
        this.var_short_arr_arr_b[0][4] = (byte)(this.var_byte_arr_arr_d[by][4] + this.var_byte_arr_arr_d[by][11] * by2 / 10 - al2.var_short_arr_b[7]);
        this.var_short_arr_arr_b[0][5] = (byte)(this.var_byte_arr_arr_d[by][2] + this.var_byte_arr_arr_d[by][9] * by2 / 10 - al2.var_short_arr_b[5]);
        this.b("Sinh m\u1ec7nh: +" + this.var_short_arr_arr_b[0][0] + "#npow" + ": +" + this.var_short_arr_arr_b[0][1] + "#nTi\u1ebfn h\u00f3a" + ": " + this.var_short_arr_arr_b[0][2], 240, 0);
        this.b("S\u1ee9c m\u1ea1nh: +" + this.var_short_arr_arr_b[0][3] + "#nPh\u00f2ng ng\u1ef1" + ": +" + this.var_short_arr_arr_b[0][4] + "#nNhanh nh\u1eb9n" + ": +" + this.var_short_arr_arr_b[0][5], 240, 1);
        this.var_short_arr_arr_b = null;
    }

    private void c(al al2, int n2, int n3) {
        n2 = al2.var_byte_arr_b[4];
        n2 = (byte)(this.var_byte_arr_o[n2 < 4 ? 0 : 1] / 20);
        byte by = (byte)(al2.var_byte_arr_b[6] / 20);
        ak.c(n2, by, 8, 129);
    }

    public static void c(int n2, int n3, int n4, int n5) {
        for (int n6 = 0; n6 < n2; n6 = (int)((byte)(n6 + 1))) {
            ah.ah_b().a(n6 > n3 ? 22 : 21, n4 + n6 * 14, n5, 0, 0);
        }
    }

    private static void b(byte by, int n2, int n3, int n4) {
        for (n4 = 0; n4 < 5; n4 = (int)((byte)(n4 + 1))) {
            ah.ah_b().a(by > n4 ? 23 : 24, n2 + n4 * 14, n3, 0, 0);
        }
    }

    private void Q() {
        ad.ad_b();
        if (ad.g()) {
            if (this.var_byte_h == 1) {
                var_int_a = 0;
                this.var_int_c = (int)null;
                this.void_b();
            } else if (this.var_byte_h == 0) {
                this.R();
            }
            this.var_byte_h = (byte)-1;
        } else {
            ad.ad_b();
            if (ad.boolean_c()) {
                this.var_byte_h = (byte)(this.var_byte_h ^ 1);
            }
        }
        ad.ad_b();
        ad.void_c();
    }

    public final void h() {
        block89: {
            block88: {
                if (var_int_a == 98) {
                    ad.ad_b();
                    if (ad.j()) {
                        this.void_b(0);
                        var_int_a = ak.var_byte_b.var_int_c;
                        ai.ai_b().b(true);
                    }
                    ad.ad_b();
                    ad.void_c();
                    return;
                }
                if (this.var_byte_k > 0) {
                    ad.ad_b();
                    ad.void_c();
                    return;
                }
                if (this.var_byte_k < 0) {
                    if (this.var_short_b == 0) {
                        ad.ad_b();
                        if (ad.g()) {
                            this.var_byte_k = 0;
                        }
                    }
                    ad.ad_b();
                    ad.void_c();
                    return;
                }
                switch (var_int_a) {
                    case -10: {
                        this.var_at_b.h();
                        break;
                    }
                    case -31: {
                        ak ak2 = this;
                        ad.ad_b();
                        if (!ad.boolean_b()) {
                            switch (ak2.C) {
                                case 2: {
                                    ad.ad_b();
                                    if (ad.e()) {
                                        ad.ad_b();
                                        ak2.s = (byte[])ad.byte_b((int)ak2.s, 0, ((int)ak2.var_int_c).length - 1);
                                        break;
                                    }
                                    ad.ad_b();
                                    if (!ad.g()) break;
                                    if (ak2.s == false) {
                                        if (ak2.var_z_b.al_b().var_byte_arr_b[6] == 0) {
                                            ak2.b("\u0110\u1ed9 trung th\u00e0nh c\u1ee7a S\u1ee7ng V\u1eadt 0, c\u1ea7n b\u1ed5 sung ngay!", -1);
                                            break;
                                        }
                                        ak2.C = (byte)3;
                                        while (ak2.w[ak2.N] > 30) {
                                            ak2.N = (byte)(ak2.N + 1);
                                        }
                                        ak2.var_byte_h[0][0] = ak2.N;
                                        ak2.var_byte_h[0][1] = (byte)(ak2.var_byte_h[0][0] - 4);
                                        if (ak2.var_byte_h[0][1] > 0) break;
                                        ak2.var_byte_h[0][1] = false;
                                        break;
                                    }
                                    if (ak2.s == true) {
                                        if (ak2.var_z_b.al_b().var_byte_b == 4) {
                                            ak2.b("Ph\u1ea1m vi giam c\u1ea7m kh\u00f4ng th\u1ec3 s\u1eed d\u1ee5ng \u0111\u1ea1o c\u1ee5!", -1);
                                            break;
                                        }
                                        ak2.p(0);
                                        break;
                                    }
                                    if (ak2.s == 2) {
                                        if (ak2.var_z_b.al_b().var_byte_b == 4) {
                                            ak2.b("Ph\u1ea1m vi giam c\u1ea7m kh\u00f4ng th\u1ec3 \u0111\u1ed5i S\u1ee7ng V\u1eadt!", -1);
                                            break;
                                        }
                                        ak2.var_byte_c = (byte)-2;
                                        ak2.d();
                                        break;
                                    }
                                    if (ak2.s == 3) {
                                        ak2.void_b(0, 0);
                                        break;
                                    }
                                    if (ak2.s != 4) break;
                                    if (ak2.F == 4) {
                                        short s2 = (short)(ak2.var_z_b.al_b().var_byte_arr_b[2] - ak2.var_z_c.al_b().var_byte_arr_b[2] + 60);
                                        int n2 = 0;
                                        ad.ad_b();
                                        if (ad.c(100) >= s2) {
                                            n2 = 1;
                                        }
                                        if (ak2.var_z_b.al_b().a(42)) {
                                            n2 = 0;
                                        } else if (ak2.var_z_b.al_b().boolean_b(3) || ak2.var_z_b.al_b().boolean_b(4)) {
                                            n2 = 2;
                                        }
                                        if (n2 == 0) {
                                            ak2.ae();
                                            ak2.ah();
                                            ak2.O();
                                            break;
                                        }
                                        if (n2 == 1) {
                                            ak2.b("Ch\u1ea1y tr\u1ed1n th\u1ea5t b\u1ea1i!", 1);
                                            ak2.var_z_b.d = 0;
                                            ak2.var_z_c.d = 1;
                                            ak2.C = (byte)9;
                                            break;
                                        }
                                        ak2.b("G\u1eb7p qu\u00e1i" + (ak2.var_z_b.al_b().boolean_b(4) ? "Ph\u1ea1m vi giam c\u1ea7m" : "\u0110i\u1ec7n ma") + ", Kh\u00f4ng th\u1ec3 ch\u1ea1y tr\u1ed1n!", 1);
                                        break;
                                    }
                                    ak2.b("Kh\u00f4ng th\u1ec3 ch\u1ea1y tr\u1ed1n!", 0);
                                    break;
                                }
                                case 3: {
                                    ad.ad_b();
                                    if (ad.boolean_c()) {
                                        ad.ad_b();
                                        ad.b((byte[])ak2.var_byte_h[0], 0, (int)ak2.w[8], 5);
                                        ak2.N = ak2.var_byte_h[0][0];
                                        break;
                                    }
                                    ad.ad_b();
                                    if (ad.g()) {
                                        if (ak2.w[ak2.var_byte_h[0][0]] > 30) {
                                            ak2.b("K\u1ef9 n\u0103ng b\u1ecb \u0111\u1ed9ng kh\u00f4ng th\u1ec3 s\u1eed d\u1ee5ng!", -1);
                                            break;
                                        }
                                        if (ak2.var_z_b.al_b().var_byte_b == 6 && ak2.int_b((int)ak2.w[ak2.var_byte_h[0][0]]) > 3) {
                                            ak2.b("\u0110\u00e3 \u0111\u00f3ng b\u0103ng, kh\u00f4ng th\u1ec3 s\u1eed d\u1ee5ng h\u01a1n 4 k\u1ef9 n\u0103ng", -1);
                                            break;
                                        }
                                        if (ak2.var_z_b.al_b().var_short_arr_b[1] >= ak2.int_b(ak2.var_z_b.al_b(), (int)ak2.w[ak2.var_byte_h[0][0]])) {
                                            ak2.var_z_b.var_byte_a = ak2.w[ak2.var_byte_h[0][0]];
                                            ak2.C = (byte)9;
                                            break;
                                        }
                                        ak2.b("Gi\u00e1 tr\u1ecb k\u1ef9 n\u0103ng c\u1ea7n ch\u01b0a \u0111\u1ee7!", -1);
                                        break;
                                    }
                                    ad.ad_b();
                                    if (!ad.i()) break;
                                    ak2.C = (byte)2;
                                    break;
                                }
                                case 5: {
                                    ad.ad_b();
                                    if (ad.boolean_c()) {
                                        ad.ad_b();
                                        ad.b((byte[])ak2.var_byte_h[0], 0, 6, ak2.w[8]);
                                        break;
                                    }
                                    ad.ad_b();
                                    if (ad.g()) break;
                                    ad.ad_b();
                                    if (!ad.i()) break;
                                    ak2.C = (byte)2;
                                    break;
                                }
                                case 4: {
                                    ad.ad_b();
                                    if (ad.boolean_c()) {
                                        ad.ad_b();
                                        ad.b((byte[])ak2.var_byte_h[0], 0, 6, ak2.w[8]);
                                        break;
                                    }
                                    ad.ad_b();
                                    if (ad.g()) break;
                                    ad.ad_b();
                                    if (!ad.i()) break;
                                    ak2.C = (byte)2;
                                }
                            }
                        }
                        break;
                    }
                    case -15: {
                        ad.ad_b();
                        if (ad.boolean_b()) {
                            return;
                        }
                        if (this.var_byte_g != 1 || this.var_short_b != 0) break;
                        this.var_byte_g = 0;
                        break;
                    }
                    case 61: {
                        ak ak3 = this;
                        ad.ad_b();
                        if (ad.g()) {
                            if (ak3.var_byte_h == 1) {
                                var_int_a = 0;
                                ak3.var_int_c = (int)null;
                                ak3.void_b();
                            } else if (ak3.var_byte_h == 0) {
                                ak3.R();
                            }
                            ak3.var_byte_h = (byte)-1;
                        } else {
                            ad.ad_b();
                            if (ad.boolean_c()) {
                                ak3.var_byte_h = (byte)(ak3.var_byte_h ^ 1);
                            }
                        }
                        ad.ad_b();
                        ad.void_c();
                        break;
                    }
                    case 60: {
                        ad.ad_b();
                        ad.void_c();
                        var_int_a = 61;
                        this.var_java_lang_String_arr_c = new String[]{"Ti\u1ebfp t\u1ee5c", "Bu\u00f4ng tha"};
                        this.var_byte_h = 0;
                        break;
                    }
                    case 67: {
                        ad.ad_b();
                        if (!ad.i()) break;
                        this.e(false);
                        ad.ad_b();
                        ad.void_c();
                        break;
                    }
                    case 68: {
                        this.H();
                        break;
                    }
                    case 97: {
                        ad.ad_b();
                        if (ad.boolean_b()) {
                            return;
                        }
                        ad.ad_b();
                        if (ad.g()) {
                            if (this.u == false) {
                                if (this.v == false) {
                                    if (this.var_byte_j == 1) {
                                        var_int_a = 100;
                                        this.var_byte_g = 0;
                                        this.var_byte_j = 0;
                                        break;
                                    }
                                    this.var_byte_j = 1;
                                    break;
                                }
                                if (this.v == true) {
                                    this.d();
                                    break;
                                }
                                if (this.v == 2) {
                                    this.p(0);
                                    break;
                                }
                                if (this.v == 3) {
                                    this.e(true);
                                    break;
                                }
                                if (this.v == 4) {
                                    this.var_at_b.b(0, true);
                                    break;
                                }
                                if (this.v != 5) break;
                                this.d(true);
                                this.var_int_c = (int)null;
                                break;
                            }
                            if (this.v == false) {
                                if (this.var_byte_j == 2) {
                                    this.R();
                                    break;
                                }
                                this.var_byte_j = (byte)2;
                                break;
                            }
                            if (this.v == true) {
                                ai.ai_b().a(0);
                                break;
                            }
                            if (this.v == 2) {
                                var_byte_b.b(1);
                                break;
                            }
                            if (this.v != 3) break;
                            if (this.var_byte_j == 3) {
                                var_int_a = 0;
                                this.var_int_c = (int)null;
                                this.void_b();
                                this.var_byte_j = 0;
                                break;
                            }
                            this.var_byte_j = (byte)3;
                            break;
                        }
                        ad.ad_b();
                        if (ad.i()) {
                            if (this.var_byte_j == 0) {
                                this.var_int_c = (int)null;
                                this.d(true);
                                break;
                            }
                            this.void_b(0);
                            var_int_a = 97;
                            this.var_byte_j = 0;
                            break;
                        }
                        if (this.var_byte_j != 0) break;
                        ad.ad_b();
                        if (ad.e()) {
                            this.u = (byte[])((byte)(this.u ^ 1));
                            this.v = (byte[])false;
                            this.void_h((int)this.u);
                            break;
                        }
                        ad.ad_b();
                        if (!ad.boolean_c()) break;
                        ad.ad_b();
                        this.v = (byte[])ad.byte_b((int)this.v, 0, ((int)this.var_int_c).length - 1);
                        break;
                    }
                    case 52: {
                        break;
                    }
                    case 51: {
                        ad.ad_b();
                        if (!ad.j()) break;
                        this.var_at_b.var_aj_b.var_byte_a = 0;
                        this.var_at_b.var_byte_g = (byte)2;
                        ad.ad_b();
                        ad.void_c();
                        this.var_at_b.var_byte_d = (byte)-1;
                        this.O();
                        break;
                    }
                    case 50: {
                        break;
                    }
                    case 35: {
                        ad.ad_b();
                        if (ad.boolean_b()) {
                            return;
                        }
                        if (this.t == false) {
                            this.c((al[])(this.var_byte_f == 6 ? this.var_int_c : (int)this.var_byte_b));
                            break;
                        }
                        if (this.t == true) {
                            this.I();
                            break;
                        }
                        if (this.t != 2) break;
                        this.E();
                        break;
                    }
                    case 65: {
                        ad.ad_b();
                        if (ad.boolean_b()) {
                            return;
                        }
                        this.P();
                        break;
                    }
                    case 66: {
                        this.D();
                        break;
                    }
                    case 25: {
                        this.B();
                        break;
                    }
                    case 18: {
                        this.x();
                        break;
                    }
                    case 69: {
                        v.v_b().a();
                        break;
                    }
                    case -20: {
                        ar.b(this).a();
                        break;
                    }
                    case -21: {
                        ar.b(this).h();
                    }
                }
                ad.ad_b();
                if (ad.g()) break block88;
                ad.ad_b();
                if (!ad.i()) break block89;
            }
            ad.ad_b();
            ad.void_c();
        }
    }

    private void R() {
        this.var_at_b.var_byte_f = 0;
        this.var_byte_j = 0;
        this.var_at_b.var_javax_microedition_lcdui_Image_arr_b = null;
        System.gc();
        var_byte_b.g();
    }

    private static void b(al al2, int n2, int n3, int n4, int n5, int n6, int n7) {
        short s2;
        short s3;
        if (n5 < 2) {
            s3 = al2.var_short_arr_b[n5 + 0];
            s2 = al2.var_short_arr_b[n5 + 2];
        } else {
            if (n7 == 0) {
                n7 = al2.var_short_arr_b[4];
            }
            s3 = (short)n7;
            s2 = ak.short_b(al2);
        }
        ah.ah_b();
        ad.ad_b();
        short s4 = ad.short_b(n7, n4 - 2, (int)s2);
        ad.ad_b();
        ah.b(n2, n3, n4, (int)s4, (int)ad.short_b((int)s3, n4 - 2, (int)s2), n5);
        if (n6 != 2) {
            String string = s3 + "/" + s2;
            ah.ah_b().c(string, n2 + (n4 - 8 * string.length() >> 1), n3 + (n6 == 1 ? 5 : 0), 0, 0);
        }
    }

    private static short short_b(al al2) {
        return (short)(210 * al2.var_byte_arr_b[2] / 10 - 2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean boolean_b(int n2, int n3) {
        if (n3 == 0) {
            byte by = this.var_byte_b[n2].var_byte_arr_b[2];
            ad.ad_b();
            n3 = (byte)(by - ad.a);
            int n4 = 0;
            ad.ad_b();
            ad.var_int_c = this.var_short_f;
            if (this.var_byte_b[n2].a(36)) {
                n4 = 100;
            }
            if (this.var_byte_b[n2].a(37)) {
                n4 = (short)(n4 + 200);
            }
            if (n3 < 0) {
                n3 = 0;
            } else if (n3 > 4) {
                n3 = 5;
            }
            ad.ad_b();
            ad.ad_b();
            ad.var_int_c = (short)(ad.var_int_c * (9 - 2 * n3) * (n4 + 100) / 1000);
            ad.ad_b();
            if (ad.var_int_c <= 0) {
                ad.ad_b();
                ad.ad_b();
                ad.var_int_c = ad.c(6) + 5;
            }
            if (this.F == 3 || this.F == 0) {
                ad.ad_b();
                ad.ad_b();
                ad.var_int_c = (short)(ad.var_int_c * 3 / 2);
            }
            short[] sArray = this.var_short_arr_arr_b[n2];
            ad.ad_b();
            sArray[2] = (short)ad.var_int_c;
            return true;
        }
        if (n3 != 1) {
            if (n3 != 2) return true;
            ad.ad_b();
            if (ad.var_int_c < 0) return false;
            this.void_b(n2, false);
            this.a((al)this.var_byte_b[n2]);
            this.var_byte_arr_arr_a[this.var_byte_b[n2].var_byte_arr_b[1]][0] = 1;
            this.var_byte_arr_arr_a[this.var_byte_b[n2].var_byte_arr_b[1]][1] = this.var_byte_p;
            this.var_byte_b[n2].var_short_arr_b[4] = 0;
            return true;
        }
        if (this.var_byte_b[n2].var_byte_arr_b[2] < 60) {
            ad.ad_b();
            if (ad.var_int_c > 0) {
                n3 = ak.short_b((al)this.var_byte_b[n2]);
                short s2 = this.var_byte_b[n2].var_short_arr_b[4];
                ad.ad_b();
                short s3 = (short)(s2 + ad.var_int_c);
                if (s3 >= n3) {
                    this.var_z_b.var_short_c = this.var_byte_b[n2].var_short_arr_b[4];
                    this.var_byte_b[n2].var_short_arr_b[4] = n3;
                    ad.ad_b();
                    ad.var_int_c = (short)(s3 - n3);
                    return true;
                }
                this.var_z_b.var_short_c = this.var_byte_b[n2].var_short_arr_b[4];
                short s4 = this.var_byte_b[n2].var_short_arr_b[4];
                ad.ad_b();
                this.var_byte_b[n2].var_short_arr_b[4] = (short)(s4 + ad.var_int_c);
                ad.ad_b();
                ad.var_int_c = -1;
                return true;
            }
        }
        ad.ad_b();
        ad.var_int_c = -1;
        this.var_short_arr_arr_b[n2][2] = 0;
        return true;
    }

    public final void void_b(int n2, boolean bl) {
        if (bl) {
            byte by = (byte)this.var_short_arr_arr_b[n2][6];
            byte[] byArray = this.var_byte_arr_arr_d[this.var_byte_b[n2].var_byte_arr_b[0]];
            short s2 = (short)(byArray[0] + byArray[7] * by / 10);
            s2 = this.short_b((al)this.var_byte_b[n2], (int)s2);
            this.var_short_arr_arr_b[n2][0] = (short)(this.var_byte_b[n2].var_short_arr_b[2] - s2);
            s2 = (short)(byArray[1] + byArray[8] * by / 10);
            this.var_short_arr_arr_b[n2][1] = (short)(this.var_byte_b[n2].var_short_arr_b[3] - s2);
            s2 = (short)(byArray[3] + byArray[10] * by / 10);
            this.var_short_arr_arr_b[n2][3] = (short)(this.var_byte_b[n2].var_short_arr_b[6] - s2);
            s2 = (short)(byArray[4] + byArray[11] * by / 10);
            this.var_short_arr_arr_b[n2][4] = (short)(this.var_byte_b[n2].var_short_arr_b[7] - s2);
            s2 = (short)(byArray[2] + byArray[9] * by / 10);
            this.var_short_arr_arr_b[n2][5] = (short)(this.var_byte_b[n2].var_short_arr_b[5] - s2);
            return;
        }
        byte by = this.var_byte_b[n2].var_byte_arr_b[2] = (byte)(this.var_byte_b[n2].var_byte_arr_b[2] + 1);
        byte[] byArray = this.var_byte_arr_arr_d[this.var_byte_b[n2].var_byte_arr_b[0]];
        this.var_byte_b[n2].var_short_arr_b[2] = (short)(byArray[0] + byArray[7] * by / 10);
        this.var_byte_b[n2].var_short_arr_b[3] = (short)(byArray[1] + byArray[8] * by / 10);
        this.var_byte_b[n2].var_short_arr_b[6] = (byte)(byArray[3] + byArray[10] * by / 10);
        this.var_byte_b[n2].var_short_arr_b[7] = (byte)(byArray[4] + byArray[11] * by / 10);
        this.var_byte_b[n2].var_short_arr_b[5] = (byte)(byArray[2] + byArray[9] * by / 10);
        this.var_byte_b[n2].b(this);
        ak.void_b((al)this.var_byte_b[n2]);
    }

    private short short_b(al al2, int n2) {
        if (al2.e(2)) {
            n2 += n2 * this.var_byte_arr_a[2] / 100;
        } else if (al2.e(1)) {
            n2 += n2 * this.var_byte_arr_a[1] / 100;
        }
        return (short)n2;
    }

    private void S() {
        if (this.var_byte_g == 1) {
            this.void_b(0, (int)this.var_z_b.var_byte_b, false);
        }
    }

    public final byte byte_b(int n2) {
        int n3;
        byte by = this.var_byte_b[n2].var_byte_arr_b[0];
        int n4 = n2;
        ak ak2 = this;
        if (ak2.y > 1) {
            ak2.var_byte_b[n4] = null;
            for (n4 = (int)((byte)n4); n4 < ak2.y - 1; n4 = (int)((byte)(n4 + 1))) {
                ak2.var_byte_b[n4] = ak2.var_byte_b[n4 + 1];
                ak2.var_boolean_arr_b[n4] = ak2.var_boolean_arr_b[n4 + 1];
            }
            for (n4 = (int)ak2.y; n4 < ((byte)ak2.var_byte_b).length; n4 = (int)((byte)(n4 + 1))) {
                ak2.var_boolean_arr_b[n4] = true;
            }
            ak2.y = (byte)(ak2.y - 1);
            n3 = 1;
        } else {
            n3 = -1;
        }
        if (n3 != -1) {
            this.b("M\u1ea5t S\u1ee7ng V\u1eadt: " + this.java_lang_String_e(by), 0);
            return 1;
        }
        this.b("Ph\u1ea3i mang theo m\u1ed9t S\u1ee7ng V\u1eadt c\u00f3 th\u1ec3 tham chi\u1ebfn!", 0);
        return -1;
    }

    private byte byte_h(int n2) {
        if (this.y > 1) {
            this.var_byte_b[n2] = null;
            for (n2 = (int)((byte)n2); n2 < this.y - 1; n2 = (int)((byte)(n2 + 1))) {
                this.var_byte_b[n2] = this.var_byte_b[n2 + 1];
                this.var_boolean_arr_b[n2] = this.var_boolean_arr_b[n2 + 1];
            }
            for (n2 = (int)this.y; n2 < ((byte)this.var_byte_b).length; n2 = (int)((byte)(n2 + 1))) {
                this.var_boolean_arr_b[n2] = true;
            }
            this.y = (byte)(this.y - 1);
            return 1;
        }
        return -1;
    }

    public static void void_b(al al2) {
        al2.var_byte_b = (byte)7;
        al2.var_short_arr_b[1] = al2.var_short_arr_b[3];
        al2.var_short_arr_b[0] = al2.var_short_arr_b[2];
    }

    public final boolean boolean_b() {
        for (byte by = 0; by < this.y; by = (byte)(by + 1)) {
            if (this.var_byte_b[by].var_short_arr_b[1] >= this.var_byte_b[by].var_short_arr_b[3] && this.var_byte_b[by].var_short_arr_b[0] >= this.var_byte_b[by].var_short_arr_b[2]) continue;
            return false;
        }
        this.b("S\u1ee7ng V\u1eadt kh\u00f4ng c\u1ea7n h\u1ed3i ph\u1ee5c!", -1);
        return true;
    }

    public final void c(boolean bl) {
        for (byte by = 0; by < this.y; by = (byte)(by + 1)) {
            ak.void_b((al)this.var_byte_b[by]);
        }
        if (bl) {
            this.b("S\u1ee7ng V\u1eadt b\u1ea1n mang theo \u0111\u00e3 h\u1ed3i ph\u1ee5c.", 0);
        }
    }

    public final byte byte_b(int n2, int n3) {
        for (byte by = 0; by < this.y; by = (byte)(by + 1)) {
            if (this.var_byte_b[by].var_byte_arr_b[0] != n2 || this.var_byte_b[by].var_byte_arr_b[2] < n3) continue;
            return by;
        }
        return -1;
    }

    public final byte byte_c(int n2, int n3) {
        byte by = -1;
        for (byte by2 = (byte)(this.y - 1); by2 >= 0; by2 = (byte)(by2 - 1)) {
            if (this.var_byte_b[by2].var_byte_arr_b[0] != n2 || this.var_byte_b[by2].var_byte_arr_b[2] < n3 || by != -1 && this.var_byte_b[by2].var_byte_arr_b[2] >= this.var_byte_b[by].var_byte_arr_b[2]) continue;
            by = by2;
        }
        return by;
    }

    public final byte byte_b(int n2, int n3, int n4, int n5) {
        al al2 = new al(this, n2, n3, -1);
        if (this.z == this.x && this.y == this.w) {
            this.b("S\u1ee7ng V\u1eadt \u0111\u00e3 \u0111\u1ea7y", 0);
            return -1;
        }
        if (this.b(al2, n4, true) != 1) {
            this.b("C\u00f3 \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt: " + this.java_lang_String_e((byte)n2), 0);
        } else {
            this.b("Mang theo \u0111\u00e3 \u0111\u1ee7, " + this.java_lang_String_e(al2.var_byte_arr_b[0]) + "\u0110\u00e3 chuy\u1ec3n", 0);
        }
        return 1;
    }

    private byte b(al al2, int n2, boolean bl) {
        if (this.var_byte_arr_arr_k[al2.var_byte_arr_b[0]] != 2) {
            this.var_byte_arr_arr_k[al2.var_byte_arr_b[0]] = (byte[])2;
            this.g();
            this.var_at_b.void_b((int)al2.var_byte_arr_b[0]);
        }
        if (this.y < this.w) {
            this.var_byte_b[this.y] = al2;
            if (bl) {
                this.var_byte_b[this.y].b(this, n2);
            }
            this.y = (byte)(this.y + 1);
            return 0;
        }
        if (this.z < this.x) {
            this.b("Mang theo \u0111\u00e3 \u0111\u1ee7, " + this.java_lang_String_e(al2.var_byte_arr_b[0]) + "\u0110\u00e3 chuy\u1ec3n", 0);
            this.var_int_c[this.z] = al2;
            if (bl) {
                this.var_int_c[this.z].b(this, n2);
            }
            this.z = (byte)(this.z + 1);
            return 1;
        }
        return -1;
    }

    public final void g() {
        this.var_byte_arr_arr_k[104] = (byte[])((byte)(this.var_byte_arr_arr_k[104] + true));
        this.var_byte_arr_arr_k[103] = (byte[])((byte)(this.var_byte_arr_arr_k[103] + true));
        if (this.var_byte_arr_arr_k[103] == 102) {
            this.b("Ch\u00fac m\u1eebng b\u1ea1n \u0111\u00e3 thu th\u1eadp \u0111\u1ee7 t\u1ea5t c\u1ea3 c\u00e1c S\u1ee7ng V\u1eadt", 0);
            var_byte_b.d();
            ad.ad_b().var_int_b = 600;
        }
    }

    private static byte byte_g(int n2) {
        if (n2 < 16) {
            return 0;
        }
        if (n2 < 35) {
            return 1;
        }
        if (n2 < 58) {
            return 2;
        }
        return 3;
    }

    public final byte byte_b(int n2, int n3, boolean bl) {
        byte by = 0;
        if (n2 == -2) {
            n2 = ak.byte_g(n3);
        }
        while (by < this.var_byte_j[n2]) {
            if (this.var_byte_b[n2][by][0] == n3) {
                if (bl) {
                    return (byte)this.var_byte_b[n2][by][1];
                }
                return by;
            }
            by = (byte)(by + 1);
        }
        return (byte)(bl ? 0 : -1);
    }

    public final byte byte_a(int n2, int n3) {
        if (this.byte_e(n2, n3) == 1) {
            this.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c: \u201c" + this.java_lang_String_c((byte)n2) + "\u201dx" + n3, 0);
            return 1;
        }
        return -1;
    }

    public final byte byte_e(int n2, int n3) {
        byte by = ak.byte_g(n2);
        byte by2 = this.byte_b((int)by, n2, false);
        if (by2 != -1) {
            void v0 = this.var_byte_b[by][by2];
            v0[1] = (byte)(v0[1] + n3);
            if (v0[1] > 99) {
                this.var_byte_b[by][by2][1] = 99;
                this.b(this.java_lang_String_c((int)this.var_byte_b[by][by2][0]) + "S\u1ed1 l\u01b0\u1ee3ng \u0111\u00e3 \u0111\u1ea1t gi\u1edbi h\u1ea1n t\u1ed1i \u0111a", 0);
                return -1;
            }
        } else {
            this.var_byte_b[by][this.var_byte_j[by]][0] = (byte)n2;
            this.var_byte_b[by][this.var_byte_j[by]][1] = (byte)n3;
            byte by3 = this.var_byte_j;
            byte by4 = by;
            by3[by4] = (byte)(by3[by4] + true);
        }
        return 1;
    }

    public final void void_c(int n2, int n3) {
        int n4 = ak.byte_g(n2);
        byte by = this.byte_b(n4, n2, false);
        n2 = by;
        if (by != -1) {
            if (this.var_byte_b[n4][n2][1] >= n3) {
                void v1 = this.var_byte_b[n4][n2];
                v1[1] = (byte)(v1[1] - n3);
            }
            if (this.var_byte_b[n4][n2][1] == false) {
                int n5 = n4;
                n4 = n2;
                n3 = n5;
                ak ak2 = this;
                while (n4 < ak2.var_byte_j[n3] - true) {
                    ak2.var_byte_b[n3][n4] = ak2.var_byte_b[n3][n4 + 1];
                    ++n4;
                }
                byte by2 = ak2.var_byte_j;
                int n6 = n3;
                by2[n6] = (byte)(by2[n6] - true);
                ak2.var_byte_b[n3][ak2.var_byte_j[n3]] = null;
                ak2.var_byte_b[n3][ak2.var_byte_j[n3]] = new byte[2];
            }
        }
    }

    private void g(int n2, int n3) {
        while (n3 < this.var_byte_j[n2] - true) {
            this.var_byte_b[n2][n3] = this.var_byte_b[n2][n3 + 1];
            ++n3;
        }
        byte by = this.var_byte_j;
        int n4 = n2;
        by[n4] = (byte)(by[n4] - true);
        this.var_byte_b[n2][this.var_byte_j[n2]] = null;
        this.var_byte_b[n2][this.var_byte_j[n2]] = new byte[2];
    }

    private void f(int n2, int n3) {
        var_byte_b.d();
        ad.ad_b().var_int_b = 200;
        if (this.var_byte_c == -1) {
            this.var_z_b.d = 0;
            this.at();
            this.C = (byte)9;
            this.b(2, (int)this.var_byte_arr_arr_e[this.var_byte_b[0].var_byte_arr_b[0]][0], 1);
        } else {
            this.p(0);
        }
        this.void_c((int)this.var_byte_b[0][n3][0], 1);
    }

    private void o(int n2) {
        if (this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[1] < this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[3] && this.var_byte_b[0].var_short_arr_b[0] > 0) {
            ak.b(n2 * this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[3] / 100, (al)this.var_byte_b[this.var_byte_h[0][0]]);
            this.f(0, (int)this.var_byte_f[0]);
            return;
        }
        if (this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[1] <= 0) {
            this.b(this.java_lang_String_e(this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]) + "\u0110\u00e3 ch\u1ebft, kh\u00f4ng th\u1ec3 s\u1eed d\u1ee5ng!", 0);
            return;
        }
        this.b(this.java_lang_String_e(this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]) + "Kh\u00f4ng c\u1ea7n s\u1eed d\u1ee5ng \u0111\u1ea1o c\u1ee5 n\u00e0y", 0);
    }

    private void i(int n2, int n3) {
        if (this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[0] < this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[2] && this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[0] > 0) {
            n2 = n2 * this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[2] / 100;
            ak.c(n3 + n2, (al)this.var_byte_b[this.var_byte_h[0][0]]);
            this.f(0, (int)this.var_byte_f[0]);
            return;
        }
        if (this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[0] <= 0) {
            this.b(this.java_lang_String_e(this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]) + "\u0110\u00e3 ch\u1ebft, kh\u00f4ng th\u1ec3 s\u1eed d\u1ee5ng!", 0);
            return;
        }
        this.b(this.java_lang_String_e(this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]) + "Kh\u00f4ng c\u1ea7n s\u1eed d\u1ee5ng \u0111\u1ea1o c\u1ee5 n\u00e0y", 0);
    }

    private void q(int n2) {
        boolean bl = false;
        boolean bl2 = false;
        if (this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[0] <= 0) {
            this.b(this.java_lang_String_e(this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]) + "\u0110\u00e3 ch\u1ebft, kh\u00f4ng th\u1ec3 s\u1eed d\u1ee5ng!", 0);
            return;
        }
        if (this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[1] < this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[3] && this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[0] > 0) {
            ak.b(n2 * this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[3] / 100, (al)this.var_byte_b[this.var_byte_h[0][0]]);
            bl = true;
        }
        if (this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[0] < this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[2] && this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[0] > 0) {
            ak.c(n2 * this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[2] / 100, (al)this.var_byte_b[this.var_byte_h[0][0]]);
            bl2 = true;
        }
        if (bl2 || bl) {
            this.f(0, (int)this.var_byte_f[0]);
            return;
        }
        this.b(this.java_lang_String_e(this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]) + "Kh\u00f4ng c\u1ea7n s\u1eed d\u1ee5ng \u0111\u1ea1o c\u1ee5 n\u00e0y", 0);
    }

    private void T() {
        if (this.var_byte_b[this.var_byte_h[0][0]].var_byte_b != 7) {
            this.var_byte_b[this.var_byte_h[0][0]].var_byte_b = (byte)7;
            this.f(0, (int)this.var_byte_f[0]);
            return;
        }
        this.b(this.java_lang_String_e(this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]) + "Kh\u00f4ng c\u00f3 b\u1ea5t th\u01b0\u1eddng!", 0);
    }

    private void s(int n2) {
        if (this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[0] <= 0) {
            ak.b(30 * this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[3] / 100, (al)this.var_byte_b[this.var_byte_h[0][0]]);
            ak.c(30 * this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[2] / 100, (al)this.var_byte_b[this.var_byte_h[0][0]]);
            this.var_byte_b[this.var_byte_h[0][0]].var_byte_b = (byte)7;
            this.f(0, (int)this.var_byte_f[0]);
            return;
        }
        this.b(this.java_lang_String_e(this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]) + "Kh\u00f4ng ch\u1ebft!", 0);
    }

    private void r(int n2) {
        byte by = this.var_byte_arr_o[this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[4] / 4];
        if (this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[6] < by && this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[0] > 0) {
            this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[6] = n2 == -1 ? by : (this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[6] + n2 > by ? by : (byte)(this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[6] + n2));
            this.f(0, (int)this.var_byte_f[0]);
            if (this.var_byte_c == -1) {
                this.b(this.var_z_b, this.var_z_b.al_b(), this.var_z_c.al_b());
                return;
            }
        } else if (this.var_byte_b[this.var_byte_h[0][0]].var_short_arr_b[0] > 0) {
            this.b(this.java_lang_String_e(this.var_byte_b[this.var_byte_h[0][0]].var_byte_arr_b[0]) + "\u0110\u1ed9 h\u01b0ng ph\u1ea5n \u0111\u00e3 \u0111\u1ee7", 0);
        }
    }

    private void U() {
        switch (this.var_byte_b[0][this.var_byte_f[0]][0]) {
            case 5: {
                this.q(50);
                return;
            }
            case 6: {
                this.q(100);
                return;
            }
            case 13: {
                this.r(-1);
                return;
            }
            case 12: {
                this.r(30);
                return;
            }
            case 7: {
                int n2 = 30;
                ak ak2 = this;
                if (ak2.var_byte_b[ak2.var_byte_h[0][0]].var_short_arr_b[0] <= 0) {
                    ak.b(30 * ak2.var_byte_b[ak2.var_byte_h[0][0]].var_short_arr_b[3] / 100, (al)ak2.var_byte_b[ak2.var_byte_h[0][0]]);
                    ak.c(30 * ak2.var_byte_b[ak2.var_byte_h[0][0]].var_short_arr_b[2] / 100, (al)ak2.var_byte_b[ak2.var_byte_h[0][0]]);
                    ak2.var_byte_b[ak2.var_byte_h[0][0]].var_byte_b = (byte)7;
                    ak2.f(0, (int)ak2.var_byte_f[0]);
                    return;
                }
                ak2.b(ak2.java_lang_String_e(ak2.var_byte_b[ak2.var_byte_h[0][0]].var_byte_arr_b[0]) + "Kh\u00f4ng ch\u1ebft!", 0);
                return;
            }
            case 4: {
                this.o(100);
                return;
            }
            case 3: {
                this.o(50);
                return;
            }
            case 2: {
                this.i(100, 0);
                return;
            }
            case 0: {
                this.i(35, 30);
                return;
            }
            case 1: {
                this.i(65, 30);
                return;
            }
            case 8: {
                this.T();
            }
        }
    }

    public final void void_d(int n2) {
        var_int_a = 97;
        this.u = (byte[])false;
        this.v = (byte[])((byte)n2);
        this.void_h(0);
        ai.ai_b().c();
        this.var_byte_k = 0;
        this.var_byte_c = 1;
        this.var_byte_f = (byte)3;
        this.var_byte_j = 0;
        this.var_byte_b = (byte)"Kim Lo\u1ea1i kh\u1eafc D\u00e3 Th\u00fa, D\u00e3 Th\u00fa kh\u1eafc Th\u1ef1c V\u1eadt, Th\u1ef1c V\u1eadt kh\u1eafc Phi H\u00e0nh, Phi H\u00e0nh kh\u1eafc H\u1ea3i D\u01b0\u01a1ng, H\u1ea3i D\u01b0\u01a1ng kh\u1eafc Kim Lo\u1ea1i";
    }

    public final void void_h(int n2) {
        if (n2 == 0) {
            this.var_java_lang_String_arr_c = new String[]{"L\u01b0u tr\u1eef tr\u00f2 ch\u01a1i", "Tra x\u00e9t S\u1ee7ng V\u1eadt", "H\u00e0nh trang c\u1ee7a nh\u00e2n v\u1eadt", "S\u1ee7ng V\u1eadt minh h\u1ecda", "Tra x\u00e9t nhi\u1ec7m v\u1ee5", "Quay l\u1ea1i tr\u00f2 ch\u01a1i"};
            return;
        }
        this.var_java_lang_String_arr_c = new String[]{"Ch\u01a1i ti\u1ebfp", "\u00c2m l\u01b0\u1ee3ng     ", "Tr\u1ee3 gi\u00fap tr\u00f2 ch\u01a1i", "V\u1ec1 menu ch\u00ednh"};
    }

    private void d(boolean bl) {
        this.v = (byte[])false;
        this.u = (byte[])false;
        this.var_byte_h[0][1] = false;
        this.var_byte_f = 0;
        this.var_byte_c = 0;
        ak.var_byte_b.var_int_b = 30;
        this.var_at_b.var_aj_b.var_byte_a = 0;
        ai.ai_b().b(this.var_byte_arr_e[this.var_at_b.var_byte_a]);
        ai.ai_b().b(bl);
        var_int_a = -10;
        this.var_byte_a = 0;
        this.var_boolean_b = false;
    }

    public final String java_lang_String_b(int n2) {
        return this.var_java_lang_StringBuffer_arr_p[n2].toString();
    }

    public final String java_lang_String_c(int n2) {
        return this.var_java_lang_StringBuffer_arr_i[n2].toString();
    }

    public final String java_lang_String_a(int n2) {
        return this.var_java_lang_StringBuffer_arr_g[n2].toString();
    }

    public final String java_lang_String_e(int n2) {
        return this.var_java_lang_StringBuffer_arr_j[n2].toString();
    }

    private String java_lang_String_b(byte by) {
        return this.var_java_lang_StringBuffer_arr_n[by].toString();
    }

    private String java_lang_String_h(int n2) {
        if (n2 <= 0) {
            n2 = 0;
        }
        return this.var_java_lang_StringBuffer_arr_k[n2].toString();
    }

    public final void b(String string, int n2) {
        ad.ad_b();
        this.var_byte_h = (byte)ad.java_lang_StringBuffer_arr_b(string, 202);
        this.var_short_b = (short)240;
        this.K = 0;
        if (n2 == 0) {
            this.var_byte_k = (byte)15;
            return;
        }
        if (n2 == -1) {
            this.var_byte_k = (byte)-1;
            return;
        }
        if (n2 == 1) {
            this.var_byte_k = (byte)15;
            this.K = 1;
        }
    }

    public final void f() {
        if (this.var_byte_k > 0 && var_int_a != 98) {
            this.b((StringBuffer[])this.var_byte_h, this.K == 0 ? 160 - (((byte)this.var_byte_h).length >> 1) * 20 - 12 : 262, (int)this.var_short_b, 1);
            if (this.var_short_b == 0) {
                this.var_byte_k = (byte)(this.var_byte_k - 1);
                return;
            }
            ad.ad_b();
            this.var_short_b = ad.b((int)this.var_short_b, 3, true);
            return;
        }
        if (this.var_byte_k < 0 && var_int_a != 98) {
            this.b((StringBuffer[])this.var_byte_h, 160 - (((byte)this.var_byte_h).length >> 1) * 20 - 12, (int)this.var_short_b, 2);
            if (this.var_short_b != 0) {
                ad.ad_b();
                this.var_short_b = ad.b((int)this.var_short_b, 3, true);
            }
        }
    }

    public final void i() {
        if (this.var_byte_l == -20) {
            return;
        }
        ad.ad_b();
        short s2 = (short)(ad.int_b(this.var_java_lang_StringBuffer_arr_g[this.var_at_b.var_byte_a].toString()) + 8);
        ah.ah_b();
        ah.a(120 - (s2 >> 1), this.var_byte_l > 0 ? (byte)0 : this.var_byte_l, s2, 26);
        ah.ah_b();
        ah.b(this.var_java_lang_StringBuffer_arr_g[this.var_at_b.var_byte_a].toString(), 120, 1 + (this.var_byte_l > 0 ? (byte)0 : this.var_byte_l), 17, 4, 2);
        this.var_byte_l = (byte)(this.var_byte_l - 1);
    }

    private void V() {
        ak ak2;
        if (this.var_javax_microedition_lcdui_Image_arr_c == null) {
            this.var_javax_microedition_lcdui_Image_arr_c = new Image[2];
            ad.ad_b();
            this.var_javax_microedition_lcdui_Image_arr_c[0] = ad.javax_microedition_lcdui_Image_b("data/ball");
            ad.ad_b();
            this.var_javax_microedition_lcdui_Image_arr_c[1] = ad.javax_microedition_lcdui_Image_b("data/ll");
            ak2 = this;
            ad.ad_b();
            this.var_javax_microedition_lcdui_Image_c = ad.javax_microedition_lcdui_Image_b("data/item");
            ad.ad_b();
            ad.var_int_c = 0;
            ak2.var_byte_arr_arr_i = ad.ad_b().byte_arr_arr_b(ad.ad_b().byte_arr_b("data/item_m.d", -1));
        }
        if (this.var_javax_microedition_lcdui_Image_arr_a == null) {
            this.var_javax_microedition_lcdui_Image_arr_a = new Image[5];
            for (int n2 = 0; n2 < this.var_javax_microedition_lcdui_Image_arr_a.length; n2 = (int)((byte)(n2 + 1))) {
                ad.ad_b();
                this.var_javax_microedition_lcdui_Image_arr_a[n2] = ad.javax_microedition_lcdui_Image_b("data/battle/" + n2);
            }
        }
        ak2 = this;
        if (ak2.var_javax_microedition_lcdui_Image_arr_e == null) {
            ad.ad_b();
            ak2.var_javax_microedition_lcdui_Image_arr_e = ad.b(2, "data/brow/i");
        }
    }

    public final void j() {
        byte[] byArray = ad.ad_b().byte_arr_b("data/data.d", -1);
        ad.ad_b();
        ad.var_int_c = 0;
        this.var_byte_arr_arr_p = ad.ad_b().byte_arr_arr_b(byArray);
        this.var_byte_arr_arr_d = ad.ad_b().byte_arr_arr_b(byArray);
        this.var_byte_arr_arr_n = ad.ad_b().byte_arr_arr_b(byArray);
        ad.ad_b();
        this.var_java_lang_StringBuffer_arr_m = ad.java_lang_StringBuffer_arr_b(byArray);
        ad.ad_b();
        this.var_java_lang_StringBuffer_arr_n = ad.java_lang_StringBuffer_arr_b(byArray);
        ad.ad_b();
        this.var_java_lang_StringBuffer_arr_b = ad.java_lang_StringBuffer_arr_b(byArray);
        ad.ad_b();
        this.var_java_lang_StringBuffer_arr_j = ad.java_lang_StringBuffer_arr_b(byArray);
        ad.ad_b();
        this.var_java_lang_StringBuffer_arr_f = ad.java_lang_StringBuffer_arr_b(byArray);
        ad.ad_b();
        this.var_java_lang_StringBuffer_arr_i = ad.java_lang_StringBuffer_arr_b(byArray);
        ad.ad_b();
        this.var_java_lang_StringBuffer_arr_g = ad.java_lang_StringBuffer_arr_b(byArray);
        ad.ad_b();
        this.var_java_lang_StringBuffer_arr_k = ad.java_lang_StringBuffer_arr_b(byArray);
        ad.ad_b();
        this.var_java_lang_StringBuffer_arr_l = ad.java_lang_StringBuffer_arr_b(byArray);
        this.var_byte_arr_arr_o = ad.ad_b().byte_arr_arr_b(byArray);
        this.var_byte_arr_arr_e = ad.ad_b().byte_arr_arr_b(byArray);
        this.var_byte_arr_arr_q = ad.ad_b().byte_arr_arr_b(byArray);
        ad.ad_b();
        this.var_java_lang_StringBuffer_arr_p = ad.java_lang_StringBuffer_arr_b(byArray);
        ad.ad_b();
        this.var_byte_arr_a = ad.byte_arr_b(byArray);
        ad.ad_b();
        this.u = ad.byte_arr_b(byArray);
        ad.ad_b();
        this.var_byte_arr_e = ad.byte_arr_b(byArray);
        ad.ad_b();
        this.v = ad.byte_arr_b(byArray);
        this.var_at_b.var_byte_arr_arr_b = ad.ad_b().byte_arr_arr_b(byArray);
        this.var_byte_g = (byte)ad.ad_b().byte_arr_arr_b(byArray);
    }

    private void W() {
        this.var_byte_arr_arr_p = null;
        this.var_byte_arr_arr_d = null;
        this.var_byte_arr_arr_n = null;
        this.var_java_lang_StringBuffer_arr_g = null;
        this.var_java_lang_StringBuffer_arr_m = null;
        this.var_java_lang_StringBuffer_arr_n = null;
        this.var_java_lang_StringBuffer_arr_j = null;
        this.var_java_lang_StringBuffer_arr_f = null;
        this.var_java_lang_StringBuffer_arr_i = null;
    }

    public final boolean boolean_b(int n2) {
        for (int n3 = 0; n3 < this.v.length; n3 = (int)((byte)(n3 + 1))) {
            if (this.v[n3] != n2) continue;
            return false;
        }
        return true;
    }

    private void X() {
        var_int_a = -19;
        this.var_short_d = (short)151;
        this.var_short_h = (short)-20;
        this.var_short_g = (short)146;
        this.var_byte_g = 0;
    }

    private void b(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        n6 = 1;
        n7 = (short)(2 << n9);
        while (n6 < 15) {
            var_int_c.clipRect(n4 - n6 * 5, n5 - 77, 5 - n7 <= 0 ? 5 : n7, 97);
            this.b(n3, n3, n2 * 3, n4, n5, true, n10);
            var_int_c.setClip(0, 0, 240, 320);
            var_int_c.clipRect(n4 + (n6 - 1) * 5, n5 - 77, 5 - n7 <= 0 ? 5 : n7, 97);
            this.b(n3, n3, n2 * 3, n4, n5, true, n10);
            var_int_c.setClip(0, 0, 240, 320);
            n6 = (byte)(n6 + 1);
            n7 = (short)(n7 / 2);
        }
    }

    private void Y() {
        var_int_a = -50;
        this.C = 0;
        this.var_short_e = (short)63;
        this.v(1);
    }

    private void Z() {
        this.var_short_e = (short)63;
        this.var_z_c.var_byte_arr_c[0] = 83;
        this.var_z_c.var_byte_arr_c[1] = 60;
        this.var_z_c.var_byte_arr_c[2] = 0;
        this.b(this.var_z_c, this.var_z_c.al_b(), 0);
        this.b(this.var_z_b, this.var_z_b.al_b(), this.var_z_c.al_b());
        this.b(this.var_z_c, this.var_z_c.al_b(), this.var_z_b.al_b());
    }

    private void aa() {
        this.var_z_b.var_byte_arr_c[0] = -66;
        this.var_z_b.var_byte_arr_c[1] = 60;
        this.var_z_b.var_byte_arr_c[2] = 0;
        this.b(this.var_z_b, this.var_z_b.al_b(), 1);
        this.b(this.var_z_b, this.var_z_b.al_b(), this.var_z_c.al_b());
        this.b(this.var_z_c, this.var_z_c.al_b(), this.var_z_b.al_b());
    }

    private void b(z z2, al al2, int n2) {
        z2.f = (byte)-1;
        this.b(2, (int)this.var_byte_arr_arr_e[al2.var_byte_arr_b[0]][0], n2);
        if (al2.a(al2.var_byte_arr_b[3] + 43)) {
            if (z2.i != al2.var_byte_arr_b[3]) {
                this.var_byte_d[n2 + 2] = true;
            }
        } else if (this.var_byte_arr_c.length != 0 && z2.i != this.var_byte_arr_c[0]) {
            this.var_byte_d[n2 + 2] = true;
        }
        z2.var_byte_c = 0;
        z2.e = 0;
        z2.var_short_b = al2.var_short_arr_b[0];
    }

    private void b(z object, al object2, int n2, int n3, int n4) {
        if (((z)object).f == 0) {
            ah.ah_b();
            ah.b(this.var_javax_microedition_lcdui_Image_arr_c[0], n3 + ((z)object).var_byte_arr_c[0], n4 - ((z)object).var_byte_arr_c[1], 33);
        } else if (((z)object).f == 1) {
            this.b(this.var_byte_arr_arr_e[((al)object2).var_byte_arr_b[0]][1], n2, n3, n4, 80, 77, 15, ((z)object).var_byte_arr_c[2], n2);
        } else if (((z)object).f == 2) {
            this.b(n2, n2, this.var_byte_arr_arr_e[((al)object2).var_byte_arr_b[0]][1] * 3, n3, n4, true, n2);
        }
        n3 = n2;
        al al2 = object2;
        object2 = object;
        object = this;
        if (((ak)object).var_byte_d[n3 + 2] == false && ((z)object2).f == -1 && ((ak)object).var_byte_d[n3] == 12) {
            ((z)object2).f = 0;
        } else if (((ak)object).var_byte_d[n3 + 2] == true && ((ak)object).var_byte_d[n3] == false) {
            ((ak)object).var_byte_d[n3 + 2] = false;
            super.b((z)object2, al2);
        }
        if (((z)object2).f == 0) {
            byte[] byArray = ((z)object2).var_byte_arr_c;
            ad.ad_b();
            byArray[0] = (byte)ad.b(((z)object2).var_byte_arr_c[0], 0, 6, false);
            byte[] byArray2 = ((z)object2).var_byte_arr_c;
            ad.ad_b();
            byArray2[1] = (byte)ad.c((int)((z)object2).var_byte_arr_c[1], 62, 2);
            if (((z)object2).var_byte_arr_c[0] == 0 && ((z)object2).var_byte_arr_c[1] == 0) {
                ((z)object2).f = 1;
                return;
            }
        } else if (((z)object2).f == 1) {
            if (((z)object2).var_byte_arr_c[2] < 12) {
                ((z)object2).var_byte_arr_c[2] = (byte)(((z)object2).var_byte_arr_c[2] + 1);
                return;
            }
            ((z)object2).f = (byte)2;
        }
    }

    private void c(z z2, al al2, int n2) {
        if (this.var_byte_d[n2 + 2] == false && z2.f == -1 && this.var_byte_d[n2] == 12) {
            z2.f = 0;
        } else if (this.var_byte_d[n2 + 2] == true && this.var_byte_d[n2] == false) {
            this.var_byte_d[n2 + 2] = false;
            this.b(z2, al2);
        }
        if (z2.f == 0) {
            byte[] byArray = z2.var_byte_arr_c;
            ad.ad_b();
            byArray[0] = (byte)ad.b(z2.var_byte_arr_c[0], 0, 6, false);
            byte[] byArray2 = z2.var_byte_arr_c;
            ad.ad_b();
            byArray2[1] = (byte)ad.c((int)z2.var_byte_arr_c[1], 62, 2);
            if (z2.var_byte_arr_c[0] == 0 && z2.var_byte_arr_c[1] == 0) {
                z2.f = 1;
                return;
            }
        } else if (z2.f == 1) {
            if (z2.var_byte_arr_c[2] < 12) {
                z2.var_byte_arr_c[2] = (byte)(z2.var_byte_arr_c[2] + 1);
                return;
            }
            z2.f = (byte)2;
        }
    }

    private void ab() {
        switch (this.C) {
            case 0: {
                if (this.F > 2) {
                    if (this.var_byte_d[2] == false && this.var_z_c.f == -1 && this.var_byte_d[0] == 12) {
                        this.var_z_c.f = 0;
                    } else if (this.var_z_c.f == 0 || this.var_z_c.f == 2) {
                        this.b(0, 0, this.var_byte_arr_arr_e[this.var_z_c.al_b().var_byte_arr_b[0]][1] * 3 + this.var_z_c.var_byte_c, 177 + this.var_short_e, 97, false, 0);
                        ad.ad_b();
                        this.var_short_e = ad.b(this.var_short_e, 0, 4, false);
                        if (this.var_short_e == 0) {
                            this.var_z_c.f = (byte)2;
                        }
                    }
                } else if (this.F < 2) {
                    this.b(this.var_z_c, this.var_z_c.al_b(), 0, 177, 97);
                }
                this.b(this.var_z_b, this.var_z_b.al_b(), 1, 46, 206);
            }
        }
    }

    private void ac() {
        switch (this.C) {
            case 0: {
                if (this.var_z_b.f != 2 || this.var_z_b.f != 2) break;
                if (this.var_byte_c == -2) {
                    this.v(0);
                    this.var_z_b.d = 0;
                    this.var_z_c.d = 0;
                }
                this.var_byte_c = (byte)-1;
                this.at();
                if (this.D == -3 || this.D == -2) {
                    this.C = this.D;
                    this.D = 0;
                    this.b(this.var_z_c, this.var_z_c.al_b(), this.var_z_b.al_b());
                } else {
                    byte by = this.var_byte_f;
                    ak ak2 = this;
                    var_int_a = -31;
                    ak2.C = (byte)(by == 1 ? 2 : 1);
                    ak2.v(by);
                    if (by == 1) {
                        ak2.c(ak2.var_z_b.al_b());
                    }
                    ak2.b(ak2.var_z_b, ak2.var_z_b.al_b(), ak2.var_z_c.al_b());
                    ak2.b(ak2.var_z_c, ak2.var_z_c.al_b(), ak2.var_z_b.al_b());
                }
                if (this.M != 0) break;
                this.M = 1;
                byte by = (byte)(this.var_z_b.al_b().var_byte_arr_b[6] - 99);
                if ((byte)(by > 1 ? 20 : by / 20 * 20) >= 0) break;
                this.b("\u0110\u1ed9 h\u01b0ng ph\u1ea5n gi\u1ea3m, l\u1ef1c c\u00f4ng k\u00edch gi\u1ea3m, c\u1ea7n b\u1ed5 sung k\u1ecbp th\u1eddi!", -1);
            }
        }
    }

    private void b(z object, al al2, al al3) {
        int n2;
        ((z)object).var_byte_arr_b[1] = 0;
        byte by = (byte)(al2.var_byte_arr_b[6] - 99);
        ((z)object).var_byte_arr_b[1] = (byte)(((z)object).var_byte_arr_b[1] + (by > 1 ? 20 : by / 20 * 20));
        if (al2.var_byte_arr_b[3] != -1 && ((z)object).i != al2.var_byte_arr_b[3]) {
            ((z)object).var_byte_arr_b[1] = (byte)(((z)object).var_byte_arr_b[1] + (((z)object).i == al2.var_byte_arr_b[3] ? 0 : -20));
        }
        byte by2 = ((z)object).var_byte_arr_b[1];
        object = this;
        if (al2.var_byte_arr_b[3] == -1) {
            n2 = 30;
        } else if (((ak)object).var_byte_arr_arr_m[al2.var_byte_arr_b[3]][0] == al3.var_byte_arr_b[3]) {
            n2 = 30;
        } else {
            byte cfr_ignored_0 = ((ak)object).var_byte_arr_arr_m[al2.var_byte_arr_b[3]][1];
            byte cfr_ignored_1 = al3.var_byte_arr_b[3];
            n2 = 0;
        }
        ((z)object).var_byte_arr_b[1] = (byte)(by2 + n2);
    }

    private boolean b(z z2, z z3, int n2, int n3) {
        boolean bl = true;
        this.var_java_lang_String_a = "";
        for (int n4 = 0; n4 < z2.var_short_arr_arr_b.length; n4 = (int)((byte)(n4 + 1))) {
            if (z2.var_short_arr_arr_b[n4][4] >= this.var_byte_arr_q.length) continue;
            bl = false;
            if (z2.var_short_arr_arr_b[n4][0] == -1) {
                this.var_java_lang_String_a = "N\u00e9 tr\u00e1nh";
            } else if (z2.var_short_arr_arr_b[n4][0] == -2) {
                this.var_java_lang_String_a = "\u0110\u1ed9 trung th\u00e0nh gi\u1ea3m b\u1edbt";
            } else {
                StringBuffer stringBuffer = new StringBuffer().append(z2.var_short_arr_arr_b[n4][1] >= 0 ? "-" : "+");
                ad.ad_b();
                this.var_java_lang_String_a = stringBuffer.append(ad.a(z2.var_short_arr_arr_b[n4][1])).toString();
            }
            if (z2.var_short_arr_arr_b[n4][0] > 0 && z2.var_short_arr_arr_b[n4][0] < 4) {
                if (z2.var_short_arr_arr_b[n4][0] == 2) {
                    ah.ah_b().a(32, n2 + z2.var_short_arr_arr_b[n4][2] + (this.var_java_lang_String_a.length() >> 1) * 14 + 15, n3 + z2.var_short_arr_arr_b[n4][3] + 8, 40, 0);
                    ah.ah_b().a(33, n2 + z2.var_short_arr_arr_b[n4][2] + (this.var_java_lang_String_a.length() >> 1) * 14 + 15, n3 + z2.var_short_arr_arr_b[n4][3] + 8, 36, 0);
                }
                ah.ah_b().c(this.var_java_lang_String_a, n2 + z2.var_short_arr_arr_b[n4][2], n3 + z2.var_short_arr_arr_b[n4][3], 0, z2.var_short_arr_arr_b[n4][0] == 2 ? 2 : 1);
            } else if (z2.var_short_arr_arr_b[n4][0] < 0 || z2.var_short_arr_arr_b[n4][0] == 4) {
                ah.ah_b();
                ah.b(this.var_java_lang_String_a, n2 + z2.var_short_arr_arr_b[n4][2], n3 + z2.var_short_arr_arr_b[n4][3], 0, z2.var_short_arr_arr_b[n4][0] == 4 ? 1 : 0, 2);
            }
            if (n4 == 0) {
                short[] sArray = z2.var_short_arr_arr_b[n4];
                sArray[2] = (short)(sArray[2] + (this.var_byte_f == 1 ? 1 : -1));
                short[] sArray2 = z2.var_short_arr_arr_b[n4];
                sArray2[3] = (short)(sArray2[3] + this.var_byte_arr_q[z2.var_short_arr_arr_b[n4][4]]);
            } else if (n4 == 1) {
                short[] sArray = z2.var_short_arr_arr_b[n4];
                sArray[2] = (short)(sArray[2] + (this.var_byte_f == 1 ? 1 : -1));
                short[] sArray3 = z2.var_short_arr_arr_b[n4];
                sArray3[3] = (short)(sArray3[3] + this.var_byte_arr_q[z2.var_short_arr_arr_b[n4][4]]);
            } else if (n4 == 2) {
                short[] sArray = z2.var_short_arr_arr_b[n4];
                sArray[3] = (short)(sArray[3] - z2.var_short_arr_arr_b[n4][4] / 3);
            }
            short[] sArray = z2.var_short_arr_arr_b[n4];
            sArray[4] = (short)(sArray[4] + 1);
            if (sArray[4] != 1) continue;
            if (z2.var_short_arr_arr_b[n4][0] == 4) {
                z2.al_b().var_short_arr_b[1] = (short)(z2.al_b().var_short_arr_b[1] - z2.var_short_arr_arr_b[n4][1]);
                continue;
            }
            if (z2.var_short_arr_arr_b[n4][0] == -2 && this.var_byte_f == 0 && !z2.al_b().a(40)) {
                z2.al_b().var_byte_arr_b[6] = (byte)(z2.al_b().var_byte_arr_b[6] - z2.var_short_arr_arr_b[n4][1]);
                this.b(z2, z2.al_b(), z3.al_b());
                continue;
            }
            if (z2.var_short_arr_arr_b[n4][0] <= 0) continue;
            z2.al_b().var_short_arr_b[0] = (short)(z2.al_b().var_short_arr_b[0] - z2.var_short_arr_arr_b[n4][1]);
        }
        ak.k(z2.al_b());
        return bl;
    }

    private static void k(al al2) {
        if (al2.var_short_arr_b[0] < 0) {
            al2.var_short_arr_b[0] = 0;
        } else if (al2.var_short_arr_b[0] > al2.var_short_arr_b[2]) {
            al2.var_short_arr_b[0] = al2.var_short_arr_b[2];
        }
        if (al2.var_short_arr_b[1] < 0) {
            al2.var_short_arr_b[1] = 0;
            return;
        }
        if (al2.var_short_arr_b[1] > al2.var_short_arr_b[3]) {
            al2.var_short_arr_b[1] = al2.var_short_arr_b[3];
        }
    }

    /*
     * Unable to fully structure code
     */
    private void b(z var1_1, z var2_3, al var3_4, al var4_5, int var5_6) {
        block11: {
            var6_7 = var3_4.var_byte_arr_b[2];
            var7_8 = var4_5.var_byte_arr_b[2];
            var8_9 = 0;
            var9_10 = var3_4.var_short_arr_b[6];
            var10_11 = var4_5.var_short_arr_b[7];
            var5_6 = this.var_byte_arr_arr_n[var5_6][0];
            var7_8 = var6_7 - var7_8;
            var11_12 = 100;
            var5_6 = var9_10 * var5_6 * (1000 - var10_11 * 5) / 10000 - var10_11 / 10 - var6_7 / (var5_6 << 1) + 6 - (var6_7 - 1) / 10;
            if (var7_8 > 10) {
                var7_8 = 10;
            } else if (var7_8 < -10) {
                var7_8 = -10;
            }
            var5_6 = var5_6 * ((var7_8 << 2) + 100) / 100;
            if (var4_5.var_byte_b == 0) {
                var8_9 = -30;
            }
            var5_6 = var5_6 * (var1_1.var_byte_arr_b[1] + var8_9 + 100) / 100;
            var1_2 = 1;
            if (!var3_4.e(9)) break block11;
            ad.ad_b();
            if (ad.c(100) < this.var_byte_arr_a[9]) ** GOTO lbl-1000
        }
        if (var4_5.a(48)) {
            ad.ad_b();
            ** if (ad.c((int)100) >= this.var_byte_arr_arr_n[48][0]) goto lbl-1000
        }
        ** GOTO lbl-1000
lbl-1000:
        // 2 sources

        {
            var5_6 >>= 1;
            ** GOTO lbl38
        }
lbl-1000:
        // 2 sources

        {
            if (var3_4.e(10)) {
                ad.ad_b();
                if (ad.c(100) < this.var_byte_arr_a[10]) {
                    var5_6 = var5_6 * 15 / 10;
                    var1_2 = 2;
                }
            }
        }
lbl38:
        // 6 sources

        if (var4_5.var_byte_arr_b[3] == 1 && var4_5.a(33)) {
            var11_12 = this.var_byte_arr_arr_n[33][0];
        }
        if ((var5_6 = var5_6 * var11_12 / 100) <= 0) {
            var5_6 = 1;
        }
        var2_3.b(var5_6, var1_2, 0);
    }

    private byte byte_b(al al2, al al3) {
        if (al2.var_byte_arr_b[3] == -1) {
            return 30;
        }
        if (this.var_byte_arr_arr_m[al2.var_byte_arr_b[3]][0] == al3.var_byte_arr_b[3]) {
            return 30;
        }
        if (this.var_byte_arr_arr_m[al2.var_byte_arr_b[3]][1] == al3.var_byte_arr_b[3]) {
            return 0;
        }
        return 0;
    }

    /*
     * Unable to fully structure code
     */
    private void c(z var1_1, z var2_2, al var3_3, al var4_4, int var5_5) {
        block47: {
            block43: {
                block46: {
                    block45: {
                        block44: {
                            var1_1.void_b();
                            var2_2.void_b();
                            this.var_int_i = var3_3.var_short_arr_b[5] - var4_4.var_short_arr_b[5];
                            this.var_int_i = 92 + this.var_int_i / 2 + var1_1.g;
                            ad.ad_b();
                            var6_6 = (byte)ad.c(100);
                            var1_1.g = 0;
                            if (var5_5 > 26 && var5_5 < 30) {
                                switch (var5_5) {
                                    case 27: 
                                    case 28: {
                                        var1_1.b(-this.var_byte_arr_arr_n[var5_5][0] * 10, 1, 1);
                                        return;
                                    }
                                    case 29: {
                                        var2_2.b(var3_3.var_short_arr_b[6] * this.var_byte_arr_arr_n[var5_5][0] + var3_3.var_short_arr_b[1], 1, 0);
                                        var1_1.b(var3_3.var_short_arr_b[1], 4, 2);
                                    }
                                }
                                return;
                            }
                            if (var6_6 >= this.var_int_i && (this.var_byte_f != 1 || var3_3.var_byte_arr_b[2] >= 11)) break block43;
                            var10_10 = var5_5;
                            var9_11 = var4_4;
                            var8_13 = var3_3;
                            var7_14 = var2_2;
                            var6_7 = var1_1;
                            var1_1 = this;
                            var11_15 = var8_13.var_byte_arr_b[2];
                            var12_16 = var9_11.var_byte_arr_b[2];
                            var13_17 = 0;
                            var14_18 = var8_13.var_short_arr_b[6];
                            var15_19 = var9_11.var_short_arr_b[7];
                            var10_10 = var1_1.var_byte_arr_arr_n[var10_10][0];
                            var12_16 = var11_15 - var12_16;
                            var16_20 = 100;
                            var11_15 = var14_18 * var10_10 * (1000 - var15_19 * 5) / 10000 - var15_19 / 10 - var11_15 / (var10_10 << 1) + 6 - (var11_15 - 1) / 10;
                            if (var12_16 > 10) {
                                var12_16 = 10;
                            } else if (var12_16 < -10) {
                                var12_16 = -10;
                            }
                            var11_15 = var11_15 * ((var12_16 << 2) + 100) / 100;
                            if (var9_11.var_byte_b == 0) {
                                var13_17 = -30;
                            }
                            var11_15 = var11_15 * (var6_7.var_byte_arr_b[1] + var13_17 + 100) / 100;
                            var6_8 = 1;
                            if (!var8_13.e(9)) break block44;
                            ad.ad_b();
                            if (ad.c(100) < var1_1.var_byte_arr_a[9]) ** GOTO lbl-1000
                        }
                        if (var9_11.a(48)) {
                            ad.ad_b();
                            ** if (ad.c((int)100) >= var1_1.var_byte_arr_arr_n[48][0]) goto lbl-1000
                        }
                        ** GOTO lbl-1000
lbl-1000:
                        // 2 sources

                        {
                            var11_15 >>= 1;
                            ** GOTO lbl62
                        }
lbl-1000:
                        // 2 sources

                        {
                            if (var8_13.e(10)) {
                                ad.ad_b();
                                if (ad.c(100) < var1_1.var_byte_arr_a[10]) {
                                    var11_15 = var11_15 * 15 / 10;
                                    var6_8 = 2;
                                }
                            }
                        }
lbl62:
                        // 6 sources

                        if (var9_11.var_byte_arr_b[3] == 1 && var9_11.a(33)) {
                            var16_20 = var1_1.var_byte_arr_arr_n[33][0];
                        }
                        if ((var11_15 = var11_15 * var16_20 / 100) <= 0) {
                            var11_15 = 1;
                        }
                        var7_14.b(var11_15, var6_8, 0);
                        if (var5_5 != 26 || var2_2.al_b().a(40)) break block45;
                        ad.ad_b();
                        if (ad.c(100) >= this.var_byte_arr_arr_n[var5_5][2]) break block45;
                        var2_2.b(this.var_byte_arr_arr_n[var5_5][3] * var2_2.al_b().var_byte_arr_b[6] / 100, -2, 2);
                        break block46;
                    }
                    if (var5_5 >= 25 && var5_5 != 30) break block46;
                    var9_12 = var5_5;
                    var8_13 = var4_4;
                    var7_14 = var3_3;
                    var6_9 = var2_2;
                    var1_1 = this;
                    if (var8_13.var_byte_b != 7) ** GOTO lbl-1000
                    var10_10 = var1_1.var_byte_arr_arr_n[var9_12][3];
                    var11_15 = var1_1.var_byte_arr_arr_n[var9_12][2];
                    if (var11_15 == 0) ** GOTO lbl-1000
                    if (var10_10 == 0) {
                        if (var8_13.e(5)) {
                            var11_15 = (byte)(var11_15 + var1_1.var_byte_arr_a[5]);
                        } else if (var8_13.e(6)) {
                            var11_15 = (byte)(var11_15 + var1_1.var_byte_arr_a[6]);
                        }
                    } else if (var10_10 == 4) {
                        if (var8_13.e(7)) {
                            var11_15 = (byte)(var11_15 + var1_1.var_byte_arr_a[7]);
                        } else if (var8_13.e(8)) {
                            var11_15 = (byte)(var11_15 + var1_1.var_byte_arr_a[8]);
                        }
                    } else if (var10_10 == 2 || var10_10 == 5) {
                        if (var8_13.e(11)) {
                            var11_15 = (byte)(var11_15 + var1_1.var_byte_arr_a[11]);
                        } else if (var8_13.e(12)) {
                            var11_15 = (byte)(var11_15 + var1_1.var_byte_arr_a[12]);
                        }
                    }
                    ad.ad_b();
                    if (ad.c(100) < var11_15) {
                        var8_13.var_byte_b = (byte)var10_10;
                        if (var10_10 == 3 || var10_10 == 4 || var10_10 == 5) {
                            var8_13.c = (byte)4;
                        } else if (var10_10 == 2) {
                            var8_13.c = (byte)(var7_14.a(32) != false ? 5 : 4);
                        } else if (var10_10 == 0) {
                            var8_13.c = (byte)2;
                        } else if (var10_10 == 6) {
                            if (var8_13.var_byte_arr_b[3] == -1) {
                                var8_13.var_byte_b = (byte)7;
                                var1_1.b("\u0110\u00e3 \u0111\u00f3ng b\u0103ng, t\u1ea1i Qu\u1ef7 V\u01b0\u01a1ng \u0110\u1ecba Ph\u1ee7 kh\u00f4ng c\u00f3 t\u00e1c d\u1ee5ng", -1);
                            } else {
                                var8_13.c = (byte)4;
                            }
                        }
                        if (var10_10 == 5) {
                            var6_9.h = (byte)(var9_12 + (var7_14.a(31) != false ? var1_1.var_byte_arr_arr_n[31][0] : 1));
                        }
                        v0 = true;
                    } else lbl-1000:
                    // 3 sources

                    {
                        v0 = false;
                    }
                }
                if (var3_3.var_byte_arr_b[3] == 2 && var3_3.a(34)) {
                    var2_2.b(var4_4.var_short_arr_b[3] * this.var_byte_arr_arr_n[34][0] / 100, 4, 2);
                    return;
                }
                break block47;
            }
            var2_2.b(0, -1, 2);
            var1_1.g = (byte)20;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void ad() {
        block44: {
            block42: {
                block45: {
                    block48: {
                        block47: {
                            block46: {
                                block43: {
                                    if (this.var_z_a.var_boolean_b || this.var_z_e.var_boolean_b) break block42;
                                    var6_1 = this.var_z_a.var_byte_a;
                                    var5_2 = this.var_z_e.al_b();
                                    var4_3 = this.var_z_a.al_b();
                                    var3_4 = this.var_z_e;
                                    var2_5 = this.var_z_a;
                                    var1_6 = this;
                                    var2_5.void_b();
                                    var3_4.void_b();
                                    var1_6.var_int_i = var4_3.var_short_arr_b[5] - var5_2.var_short_arr_b[5];
                                    var1_6.var_int_i = 92 + var1_6.var_int_i / 2 + var2_5.g;
                                    ad.ad_b();
                                    var7_7 = (byte)ad.c(100);
                                    var2_5.g = 0;
                                    if (var6_1 <= 26 || var6_1 >= 30) break block43;
                                    switch (var6_1) {
                                        case 27: 
                                        case 28: {
                                            var2_5.b(-var1_6.var_byte_arr_arr_n[var6_1][0] * 10, 1, 1);
                                            break;
                                        }
                                        case 29: {
                                            var3_4.b(var4_3.var_short_arr_b[6] * var1_6.var_byte_arr_arr_n[var6_1][0] + var4_3.var_short_arr_b[1], 1, 0);
                                            var2_5.b(var4_3.var_short_arr_b[1], 4, 2);
                                        }
                                    }
                                    break block44;
                                }
                                if (var7_7 >= var1_6.var_int_i && (var1_6.var_byte_f != 1 || var4_3.var_byte_arr_b[2] >= 11)) break block45;
                                var11_11 = var6_1;
                                var10_12 = var5_2;
                                var9_14 = var4_3;
                                var8_15 = var3_4;
                                var7_8 = var2_5;
                                var2_5 = var1_6;
                                var12_16 = var9_14.var_byte_arr_b[2];
                                var13_17 = var10_12.var_byte_arr_b[2];
                                var14_18 = 0;
                                var15_19 = var9_14.var_short_arr_b[6];
                                var16_20 = var10_12.var_short_arr_b[7];
                                var11_11 = var2_5.var_byte_arr_arr_n[var11_11][0];
                                var13_17 = var12_16 - var13_17;
                                var17_21 = 100;
                                var12_16 = var15_19 * var11_11 * (1000 - var16_20 * 5) / 10000 - var16_20 / 10 - var12_16 / (var11_11 << 1) + 6 - (var12_16 - 1) / 10;
                                if (var13_17 > 10) {
                                    var13_17 = 10;
                                } else if (var13_17 < -10) {
                                    var13_17 = -10;
                                }
                                var12_16 = var12_16 * ((var13_17 << 2) + 100) / 100;
                                if (var10_12.var_byte_b == 0) {
                                    var14_18 = -30;
                                }
                                var12_16 = var12_16 * (var7_8.var_byte_arr_b[1] + var14_18 + 100) / 100;
                                var7_9 = 1;
                                if (!var9_14.e(9)) break block46;
                                ad.ad_b();
                                if (ad.c(100) < var2_5.var_byte_arr_a[9]) ** GOTO lbl-1000
                            }
                            if (var10_12.a(48)) {
                                ad.ad_b();
                                ** if (ad.c((int)100) >= var2_5.var_byte_arr_arr_n[48][0]) goto lbl-1000
                            }
                            ** GOTO lbl-1000
lbl-1000:
                            // 2 sources

                            {
                                var12_16 >>= 1;
                                ** GOTO lbl70
                            }
lbl-1000:
                            // 2 sources

                            {
                                if (var9_14.e(10)) {
                                    ad.ad_b();
                                    if (ad.c(100) < var2_5.var_byte_arr_a[10]) {
                                        var12_16 = var12_16 * 15 / 10;
                                        var7_9 = 2;
                                    }
                                }
                            }
lbl70:
                            // 6 sources

                            if (var10_12.var_byte_arr_b[3] == 1 && var10_12.a(33)) {
                                var17_21 = var2_5.var_byte_arr_arr_n[33][0];
                            }
                            if ((var12_16 = var12_16 * var17_21 / 100) <= 0) {
                                var12_16 = 1;
                            }
                            var8_15.b(var12_16, var7_9, 0);
                            if (var6_1 != 26 || var3_4.al_b().a(40)) break block47;
                            ad.ad_b();
                            if (ad.c(100) >= var1_6.var_byte_arr_arr_n[var6_1][2]) break block47;
                            var3_4.b(var1_6.var_byte_arr_arr_n[var6_1][3] * var3_4.al_b().var_byte_arr_b[6] / 100, -2, 2);
                            break block48;
                        }
                        if (var6_1 >= 25 && var6_1 != 30) break block48;
                        var10_13 = var6_1;
                        var9_14 = var5_2;
                        var8_15 = var4_3;
                        var7_10 = var3_4;
                        var2_5 = var1_6;
                        if (var9_14.var_byte_b != 7) ** GOTO lbl-1000
                        var11_11 = var2_5.var_byte_arr_arr_n[var10_13][3];
                        var12_16 = var2_5.var_byte_arr_arr_n[var10_13][2];
                        if (var12_16 == 0) ** GOTO lbl-1000
                        if (var11_11 == 0) {
                            if (var9_14.e(5)) {
                                var12_16 = (byte)(var12_16 + var2_5.var_byte_arr_a[5]);
                            } else if (var9_14.e(6)) {
                                var12_16 = (byte)(var12_16 + var2_5.var_byte_arr_a[6]);
                            }
                        } else if (var11_11 == 4) {
                            if (var9_14.e(7)) {
                                var12_16 = (byte)(var12_16 + var2_5.var_byte_arr_a[7]);
                            } else if (var9_14.e(8)) {
                                var12_16 = (byte)(var12_16 + var2_5.var_byte_arr_a[8]);
                            }
                        } else if (var11_11 == 2 || var11_11 == 5) {
                            if (var9_14.e(11)) {
                                var12_16 = (byte)(var12_16 + var2_5.var_byte_arr_a[11]);
                            } else if (var9_14.e(12)) {
                                var12_16 = (byte)(var12_16 + var2_5.var_byte_arr_a[12]);
                            }
                        }
                        ad.ad_b();
                        if (ad.c(100) < var12_16) {
                            var9_14.var_byte_b = var11_11;
                            if (var11_11 == 3 || var11_11 == 4 || var11_11 == 5) {
                                var9_14.c = (byte)4;
                            } else if (var11_11 == 2) {
                                var9_14.c = (byte)(var8_15.a(32) != false ? 5 : 4);
                            } else if (var11_11 == 0) {
                                var9_14.c = (byte)2;
                            } else if (var11_11 == 6) {
                                if (var9_14.var_byte_arr_b[3] == -1) {
                                    var9_14.var_byte_b = (byte)7;
                                    var2_5.b("\u0110\u00e3 \u0111\u00f3ng b\u0103ng, t\u1ea1i Qu\u1ef7 V\u01b0\u01a1ng \u0110\u1ecba Ph\u1ee7 kh\u00f4ng c\u00f3 t\u00e1c d\u1ee5ng", -1);
                                } else {
                                    var9_14.c = (byte)4;
                                }
                            }
                            if (var11_11 == 5) {
                                var7_10.h = (byte)(var10_13 + (var8_15.a(31) != false ? var2_5.var_byte_arr_arr_n[31][0] : 1));
                            }
                            v0 = true;
                        } else lbl-1000:
                        // 3 sources

                        {
                            v0 = false;
                        }
                    }
                    if (var4_3.var_byte_arr_b[3] == 2 && var4_3.a(34)) {
                        var3_4.b(var5_2.var_short_arr_b[3] * var1_6.var_byte_arr_arr_n[34][0] / 100, 4, 2);
                    }
                    break block44;
                }
                var3_4.b(0, -1, 2);
                var2_5.g = (byte)20;
                break block44;
            }
            this.var_z_a.var_boolean_b = false;
            this.var_z_e.var_boolean_b = false;
        }
        this.C = (byte)-2;
    }

    private void h(boolean bl) {
        this.var_short_f = 0;
        ad.ad_b();
        ad.a = this.var_z_c.var_al_arr_b[0].var_byte_arr_b[2];
        for (int n2 = 0; n2 < this.var_z_c.var_al_arr_b.length; n2 = (int)((byte)(n2 + 1))) {
            this.var_short_f = (short)(this.var_short_f + (3 * this.var_z_c.var_al_arr_b[n2].var_byte_arr_b[2] + 80));
            byte by = this.var_z_c.var_al_arr_b[n2].var_byte_arr_b[2];
            ad.ad_b();
            if (by <= ad.a) continue;
            ad.ad_b();
            ad.a = this.var_z_c.var_al_arr_b[n2].var_byte_arr_b[2];
        }
        this.var_short_f = (short)(this.var_short_f * (56 / this.t[0] - 2 * (this.t[0] - 1) + 44) / 100);
        if (!bl) {
            this.var_short_f = (short)(this.var_short_f / 2);
        }
    }

    private void ae() {
        if (this.y > 1) {
            for (int n2 = 0; n2 < this.y - 1; n2 = (int)((byte)(n2 + 1))) {
                for (byte by = (byte)(n2 + 1); by < this.y; by = (byte)(by + 1)) {
                    if (this.var_byte_b[n2].var_byte_arr_b[1] <= this.var_byte_b[by].var_byte_arr_b[1]) continue;
                    ak.void_b((al)this.var_byte_b[n2], (al)this.var_byte_b[by]);
                }
            }
        }
    }

    private void af() {
        this.C = (byte)-4;
        this.r = (byte[])-1;
        StringBuffer stringBuffer = new StringBuffer();
        ad.ad_b();
        if (ad.c(100) < 50 && this.byte_b(-2, 32, true) < 99) {
            this.byte_e(32, 1);
            stringBuffer.append("\u0110\u1ea1t \u0111\u01b0\u1ee3c: " + this.java_lang_String_c(32) + "x1");
        }
        this.b(stringBuffer.toString(), 10000, 0);
    }

    private void g(boolean bl) {
        this.C = (byte)-5;
        this.t = (byte[])false;
        this.var_byte_g = 0;
        this.var_z_b.var_byte_b = this.var_byte_b[this.var_z_b.var_byte_b].var_byte_arr_b[1];
        this.var_short_arr_arr_b[this.var_z_b.var_byte_b][2] = -2;
        this.ae();
        boolean bl2 = bl;
        ak ak2 = this;
        ak2.var_short_f = 0;
        ad.ad_b();
        ad.a = ak2.var_z_c.var_al_arr_b[0].var_byte_arr_b[2];
        for (int n2 = 0; n2 < ak2.var_z_c.var_al_arr_b.length; n2 = (int)((byte)(n2 + 1))) {
            ak2.var_short_f = (short)(ak2.var_short_f + (3 * ak2.var_z_c.var_al_arr_b[n2].var_byte_arr_b[2] + 80));
            byte by = ak2.var_z_c.var_al_arr_b[n2].var_byte_arr_b[2];
            ad.ad_b();
            if (by <= ad.a) continue;
            ad.ad_b();
            ad.a = ak2.var_z_c.var_al_arr_b[n2].var_byte_arr_b[2];
        }
        ak2.var_short_f = (short)(ak2.var_short_f * (56 / ak2.t[0] - 2 * (ak2.t[0] - 1) + 44) / 100);
        if (!bl2) {
            ak2.var_short_f = (short)(ak2.var_short_f / 2);
        }
    }

    private void ag() {
        var_int_a = -15;
        this.var_byte_g = 0;
        this.var_z_b.var_byte_b = 0;
        this.var_byte_f = (byte)3;
        this.var_byte_c = 1;
        this.L = this.var_z_b.i;
        this.var_am_arr_b[0].void_b();
    }

    private void ah() {
        this.var_short_arr_arr_b = null;
        this.var_javax_microedition_lcdui_Image_arr_b = null;
        this.var_byte_arr_arr_a = null;
        this.var_z_b = null;
        this.var_z_c = null;
    }

    private static void ai() {
        var_int_a = 60;
    }

    /*
     * Unable to fully structure code
     */
    private void b(z var1_1) {
        block46: {
            block49: {
                block47: {
                    block50: {
                        block53: {
                            block52: {
                                block51: {
                                    block48: {
                                        if (var1_1.var_byte_c != 0) {
                                            return;
                                        }
                                        var2_2 = var1_1.var_byte_a / 5;
                                        var3_4 = (byte)(var1_1.var_byte_a % 5);
                                        if (var2_2 > 5) {
                                            var2_2 = 5;
                                        }
                                        if (var2_2 == 5) {
                                            var3_4 = (byte)(var1_1.var_byte_a - 25);
                                        }
                                        if (!this.boolean_b(var2_2, var2_2, (int)var3_4, ak.c(this.var_byte_f, (int)var1_1.var_byte_a, true), ak.c(this.var_byte_f, (int)var1_1.var_byte_a, false), this.var_byte_f ^ 1)) break block46;
                                        if (this.var_byte_f == 1) {
                                            var1_1.al_b().var_short_arr_b[1] = (short)(var1_1.al_b().var_short_arr_b[1] - this.int_b(var1_1.al_b(), (int)var1_1.var_byte_a));
                                            ak.k(var1_1.al_b());
                                        }
                                        var1_1 = this;
                                        if (var1_1.var_z_a.var_boolean_b || var1_1.var_z_e.var_boolean_b) break block47;
                                        var7_6 = var1_1.var_z_a.var_byte_a;
                                        var6_7 = var1_1.var_z_e.al_b();
                                        var5_8 = var1_1.var_z_a.al_b();
                                        var4_9 = var1_1.var_z_e;
                                        var3_5 = var1_1.var_z_a;
                                        var2_3 = var1_1;
                                        var3_5.void_b();
                                        var4_9.void_b();
                                        var2_3.var_int_i = var5_8.var_short_arr_b[5] - var6_7.var_short_arr_b[5];
                                        var2_3.var_int_i = 92 + var2_3.var_int_i / 2 + var3_5.g;
                                        ad.ad_b();
                                        var8_10 = (byte)ad.c(100);
                                        var3_5.g = 0;
                                        if (var7_6 <= 26 || var7_6 >= 30) break block48;
                                        switch (var7_6) {
                                            case 27: 
                                            case 28: {
                                                var3_5.b(-var2_3.var_byte_arr_arr_n[var7_6][0] * 10, 1, 1);
                                                break;
                                            }
                                            case 29: {
                                                var4_9.b(var5_8.var_short_arr_b[6] * var2_3.var_byte_arr_arr_n[var7_6][0] + var5_8.var_short_arr_b[1], 1, 0);
                                                var3_5.b(var5_8.var_short_arr_b[1], 4, 2);
                                            }
                                        }
                                        break block49;
                                    }
                                    if (var8_10 >= var2_3.var_int_i && (var2_3.var_byte_f != 1 || var5_8.var_byte_arr_b[2] >= 11)) break block50;
                                    var12_14 = var7_6;
                                    var11_15 = var6_7;
                                    var10_17 = var5_8;
                                    var9_18 = var4_9;
                                    var8_11 = var3_5;
                                    var3_5 = var2_3;
                                    var13_19 = var10_17.var_byte_arr_b[2];
                                    var14_20 = var11_15.var_byte_arr_b[2];
                                    var15_21 = 0;
                                    var16_22 = var10_17.var_short_arr_b[6];
                                    var17_23 = var11_15.var_short_arr_b[7];
                                    var12_14 = var3_5.var_byte_arr_arr_n[var12_14][0];
                                    var14_20 = var13_19 - var14_20;
                                    var18_24 = 100;
                                    var13_19 = var16_22 * var12_14 * (1000 - var17_23 * 5) / 10000 - var17_23 / 10 - var13_19 / (var12_14 << 1) + 6 - (var13_19 - 1) / 10;
                                    if (var14_20 > 10) {
                                        var14_20 = 10;
                                    } else if (var14_20 < -10) {
                                        var14_20 = -10;
                                    }
                                    var13_19 = var13_19 * ((var14_20 << 2) + 100) / 100;
                                    if (var11_15.var_byte_b == 0) {
                                        var15_21 = -30;
                                    }
                                    var13_19 = var13_19 * (var8_11.var_byte_arr_b[1] + var15_21 + 100) / 100;
                                    var8_12 = 1;
                                    if (!var10_17.e(9)) break block51;
                                    ad.ad_b();
                                    if (ad.c(100) < var3_5.var_byte_arr_a[9]) ** GOTO lbl-1000
                                }
                                if (var11_15.a(48)) {
                                    ad.ad_b();
                                    ** if (ad.c((int)100) >= var3_5.var_byte_arr_arr_n[48][0]) goto lbl-1000
                                }
                                ** GOTO lbl-1000
lbl-1000:
                                // 2 sources

                                {
                                    var13_19 >>= 1;
                                    ** GOTO lbl83
                                }
lbl-1000:
                                // 2 sources

                                {
                                    if (var10_17.e(10)) {
                                        ad.ad_b();
                                        if (ad.c(100) < var3_5.var_byte_arr_a[10]) {
                                            var13_19 = var13_19 * 15 / 10;
                                            var8_12 = 2;
                                        }
                                    }
                                }
lbl83:
                                // 6 sources

                                if (var11_15.var_byte_arr_b[3] == 1 && var11_15.a(33)) {
                                    var18_24 = var3_5.var_byte_arr_arr_n[33][0];
                                }
                                if ((var13_19 = var13_19 * var18_24 / 100) <= 0) {
                                    var13_19 = 1;
                                }
                                var9_18.b(var13_19, var8_12, 0);
                                if (var7_6 != 26 || var4_9.al_b().a(40)) break block52;
                                ad.ad_b();
                                if (ad.c(100) >= var2_3.var_byte_arr_arr_n[var7_6][2]) break block52;
                                var4_9.b(var2_3.var_byte_arr_arr_n[var7_6][3] * var4_9.al_b().var_byte_arr_b[6] / 100, -2, 2);
                                break block53;
                            }
                            if (var7_6 >= 25 && var7_6 != 30) break block53;
                            var11_16 = var7_6;
                            var10_17 = var6_7;
                            var9_18 = var5_8;
                            var8_13 = var4_9;
                            var3_5 = var2_3;
                            if (var10_17.var_byte_b != 7) ** GOTO lbl-1000
                            var12_14 = var3_5.var_byte_arr_arr_n[var11_16][3];
                            var13_19 = var3_5.var_byte_arr_arr_n[var11_16][2];
                            if (var13_19 == 0) ** GOTO lbl-1000
                            if (var12_14 == 0) {
                                if (var10_17.e(5)) {
                                    var13_19 = (byte)(var13_19 + var3_5.var_byte_arr_a[5]);
                                } else if (var10_17.e(6)) {
                                    var13_19 = (byte)(var13_19 + var3_5.var_byte_arr_a[6]);
                                }
                            } else if (var12_14 == 4) {
                                if (var10_17.e(7)) {
                                    var13_19 = (byte)(var13_19 + var3_5.var_byte_arr_a[7]);
                                } else if (var10_17.e(8)) {
                                    var13_19 = (byte)(var13_19 + var3_5.var_byte_arr_a[8]);
                                }
                            } else if (var12_14 == 2 || var12_14 == 5) {
                                if (var10_17.e(11)) {
                                    var13_19 = (byte)(var13_19 + var3_5.var_byte_arr_a[11]);
                                } else if (var10_17.e(12)) {
                                    var13_19 = (byte)(var13_19 + var3_5.var_byte_arr_a[12]);
                                }
                            }
                            ad.ad_b();
                            if (ad.c(100) < var13_19) {
                                var10_17.var_byte_b = var12_14;
                                if (var12_14 == 3 || var12_14 == 4 || var12_14 == 5) {
                                    var10_17.c = (byte)4;
                                } else if (var12_14 == 2) {
                                    var10_17.c = (byte)(var9_18.a(32) != false ? 5 : 4);
                                } else if (var12_14 == 0) {
                                    var10_17.c = (byte)2;
                                } else if (var12_14 == 6) {
                                    if (var10_17.var_byte_arr_b[3] == -1) {
                                        var10_17.var_byte_b = (byte)7;
                                        var3_5.b("\u0110\u00e3 \u0111\u00f3ng b\u0103ng, t\u1ea1i Qu\u1ef7 V\u01b0\u01a1ng \u0110\u1ecba Ph\u1ee7 kh\u00f4ng c\u00f3 t\u00e1c d\u1ee5ng", -1);
                                    } else {
                                        var10_17.c = (byte)4;
                                    }
                                }
                                if (var12_14 == 5) {
                                    var8_13.h = (byte)(var11_16 + (var9_18.a(31) != false ? var3_5.var_byte_arr_arr_n[31][0] : 1));
                                }
                                v0 = true;
                            } else lbl-1000:
                            // 3 sources

                            {
                                v0 = false;
                            }
                        }
                        if (var5_8.var_byte_arr_b[3] == 2 && var5_8.a(34)) {
                            var4_9.b(var6_7.var_short_arr_b[3] * var2_3.var_byte_arr_arr_n[34][0] / 100, 4, 2);
                        }
                        break block49;
                    }
                    var4_9.b(0, -1, 2);
                    var3_5.g = (byte)20;
                    break block49;
                }
                var1_1.var_z_a.var_boolean_b = false;
                var1_1.var_z_e.var_boolean_b = false;
            }
            var1_1.C = (byte)-2;
        }
    }

    private static boolean boolean_e(int n2) {
        return n2 == 27 || n2 == 28;
    }

    private static int c(int n2, int n3, boolean bl) {
        int n4 = 46;
        int n5 = 206;
        if (n2 == 1 && !ak.boolean_e(n3) || n2 == 0 && ak.boolean_e(n3)) {
            n4 = 177;
            n5 = 97;
        }
        if (bl) {
            return n4;
        }
        return n5;
    }

    private void aj() {
        int n2 = 0x494949;
        n2 = 0xFFFFFF;
        n2 = 2;
        n2 = 1;
        int n3 = 6;
        int n4 = 1 + this.var_byte_g;
        n2 = 320;
        n2 = 240;
        n2 = 0;
        n2 = 0;
        var_int_c.setColor(0x494949);
        int n5 = 1;
        n2 = 320;
        while (n2 > 0) {
            var_int_c.fillRect(0, n2 - n4, 240, n4);
            n2 = n2 - n4 - n5;
            if (--n4 > 0) continue;
            if (n5 < --n3) {
                ++n5;
            }
            n4 = 1;
        }
    }

    private static void b(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        var_int_c.setColor(0x494949);
        n2 = 1;
        n3 = 320;
        while (n3 > 0) {
            var_int_c.fillRect(0, n3 - n6, 240, n6);
            n3 = n3 - n6 - n2;
            if (--n6 > 0) continue;
            if (n2 < --n7) {
                ++n2;
            }
            n6 = 1;
        }
    }

    private void ak() {
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.d(-2, 108, 244, 11, 0);
        ah.ah_b();
        ah.b(this.var_javax_microedition_lcdui_Image_arr_a[this.var_z_c.i], 0, 0, 0);
        ah.ah_b();
        ah.b(this.var_javax_microedition_lcdui_Image_arr_a[this.var_z_b.i], 0, 119, 0, 8192);
    }

    private void al() {
        this.aq();
        ak ak2 = this;
        ah.ah_b();
        ah.a(137, 199, 103, 28);
        ah.ah_b().a(ak2.var_z_b.al_b().var_byte_arr_b[3] + 5, 148, 213, 3, 0);
        ah.ah_b();
        ah.b(ak2.java_lang_String_e(ak2.var_z_b.al_b().var_byte_arr_b[0]).toString(), 198, 200, 17, 4, 2);
        ah.ah_b();
        ah.d(176, 184, 62, 14, 4);
        ah.ah_b().a(34, 178, 185, 0, 0);
        ah.ah_b().c(100 + ak2.var_z_b.var_byte_arr_b[0] + "%", 234, 197, 1, 1);
        this.ap();
        ak2 = this;
        ah.ah_b();
        ah.a(0, 0, 103, 28);
        if (ak2.var_z_c.al_b().var_byte_arr_b[3] != -1) {
            ah.ah_b().a(ak2.var_z_c.al_b().var_byte_arr_b[3] + 5, 11, 14, 3, 0);
        }
        ah.ah_b();
        ah.b(ak2.java_lang_String_e(ak2.var_z_c.al_b().var_byte_arr_b[0]).toString(), 61, 1, 17, 4, 2);
        ah.ah_b();
        ah.b(ak2.var_z_c.al_b().var_byte_arr_b[2] + "\u0110\u1eb3ng c\u1ea5p", 105, 1, 0, 0, 2);
        ah.ah_b();
        ah.d(2, 29, 62, 14, 4);
        ah.ah_b().a(34, 4, 30, 0, 0);
        ah.ah_b().c(100 + ak2.var_z_c.var_byte_arr_b[0] + "%", 60, 42, 1, 1);
        ah.ah_b().a(ak2.var_byte_arr_arr_k[ak2.var_z_c.al_b().var_byte_arr_b[0]] == 2 ? 25 : 26, 66, 29, 0, 0);
    }

    private void am() {
        switch (this.C) {
            case -1: {
                this.b(this.var_z_a);
                return;
            }
            case 2: {
                return;
            }
            case 3: {
                ah.ah_b();
                ah.d(25, 45, 190, 136, 0);
                ah.ah_b().b(196, 55, 116, (int)this.var_byte_h[0][0], (int)this.w[8], false);
                this.b(35, 55, 152, 23, 5, (byte[])this.var_byte_h[0]);
                ak.b(this.var_java_lang_StringBuffer_arr_m[this.w[this.var_byte_h[0][0]]].toString(), 120, 244, 12, 0);
                ah.ah_b().b(true, true);
                return;
            }
            case 5: {
                return;
            }
            case 4: {
                return;
            }
            case -2: {
                if (!this.b(this.var_z_e, this.var_z_a, ak.c(this.var_byte_f, (int)this.var_z_a.var_byte_a, true) - 15, ak.c(this.var_byte_f, (int)this.var_z_a.var_byte_a, false) - 34) || !this.b(this.var_z_a, this.var_z_e, ak.c(this.var_byte_f ^ 1, 25, true) - 15, ak.c(this.var_byte_f ^ 1, 25, false) - 34) || !this.b(this.var_z_a, this.var_z_e, (int)this.var_byte_f)) break;
                this.C = (byte)-3;
                this.var_z_a.void_b();
                z z2 = this.var_z_a;
                ak ak2 = this;
                short s2 = 0;
                if (z2.al_b().c(2)) {
                    s2 = (short)(z2.al_b().var_short_arr_b[0] / 10);
                } else if (z2.al_b().c(5)) {
                    s2 = (short)(z2.h * z2.h + 4);
                }
                if (z2.al_b().a(3)) {
                    s2 = (short)(s2 + s2 * ak2.var_byte_arr_a[3] / 100);
                }
                if (s2 != 0) {
                    z2.b(s2, 1, 0);
                }
                z2 = this.var_z_a;
                ak2 = this;
                if (z2.al_b().var_short_arr_b[0] <= 0) {
                    return;
                }
                if (z2.al_b().e(4)) {
                    z2.b(-z2.al_b().var_short_arr_b[2] * ak2.var_byte_arr_a[4] / 100, 1, 1);
                }
                return;
            }
            case -3: {
                if (!this.b(this.var_z_a, this.var_z_e, ak.c(this.var_byte_f ^ 1, 25, true) - 15, ak.c(this.var_byte_f ^ 1, 25, false) - 34) || !this.b(this.var_z_e, this.var_z_a, this.var_byte_f ^ 1)) break;
                this.C = (byte)9;
                al al2 = this.var_z_e.al_b();
                if (al2.c > 0) {
                    al2.c = (byte)(al2.c - 1);
                }
                if (al2.c == 0) {
                    al2.var_byte_b = (byte)7;
                }
                return;
            }
            case -5: {
                if (this.var_short_arr_arr_b[this.var_z_b.var_byte_b][2] >= 0) {
                    String string = this.java_lang_String_e(this.var_byte_b[this.var_z_b.var_byte_b].var_byte_arr_b[0]) + "L\u1ea5y \u0111\u01b0\u1ee3c kinh nghi\u1ec7m: ";
                    ah.ah_b();
                    ah.b(string, 4, 273, 36, 1, 0);
                    ah ah2 = ah.ah_b();
                    String string2 = "" + this.var_short_arr_arr_b[this.var_z_b.var_byte_b][2];
                    ad.ad_b();
                    ah2.c(string2, ad.int_b(string) + 4, 268, 0, 1);
                    return;
                }
                if (this.var_short_arr_arr_b[this.var_z_b.var_byte_b][2] != -1) break;
                ah.ah_b();
                ah.b("S\u1ee7ng V\u1eadt c\u1ee7a b\u1ea1n kh\u00f4ng th\u1ec3 c\u00f3 \u0111\u01b0\u1ee3c kinh nghi\u1ec7m", 4, 252, 36, 7, 0);
                ad.ad_b().var_int_b = 600;
            }
        }
    }

    private void c(z z2) {
        short s2 = 0;
        if (z2.al_b().c(2)) {
            s2 = (short)(z2.al_b().var_short_arr_b[0] / 10);
        } else if (z2.al_b().c(5)) {
            s2 = (short)(z2.h * z2.h + 4);
        }
        if (z2.al_b().a(3)) {
            s2 = (short)(s2 + s2 * this.var_byte_arr_a[3] / 100);
        }
        if (s2 != 0) {
            z2.b(s2, 1, 0);
        }
    }

    private void a(z z2) {
        if (z2.al_b().var_short_arr_b[0] <= 0) {
            return;
        }
        if (z2.al_b().e(4)) {
            z2.b(-z2.al_b().var_short_arr_b[2] * this.var_byte_arr_a[4] / 100, 1, 1);
        }
    }

    private boolean boolean_c() {
        for (byte by = 1; by < this.y; by = (byte)(by + 1)) {
            if (this.var_byte_b[by].var_short_arr_b[0] <= 0) continue;
            this.v(1);
            this.d();
            return true;
        }
        return false;
    }

    private boolean boolean_d(int n2) {
        for (byte by = 0; by < this.y; by = (byte)(by + 1)) {
            if (by == n2 || this.var_byte_b[by].var_short_arr_b[0] <= 0) continue;
            return true;
        }
        return false;
    }

    private static boolean b(z z2, int n2) {
        byte by;
        int n3 = 0;
        byte by2 = z2.var_byte_b;
        do {
            if ((z2.var_byte_b = (byte)(z2.var_byte_b + 1)) >= n2) {
                z2.var_byte_b = 0;
            }
            by = (byte)(n3 + 1);
            n3 = by;
        } while (by <= n2 && (by2 == z2.var_byte_b || z2.al_b().var_short_arr_b[0] <= 0));
        if (n3 > n2) {
            z2.var_byte_b = by2;
        }
        return n3 <= n2;
    }

    private void an() {
        byte[] byArray = this.var_z_b.var_byte_arr_b;
        ad.ad_b();
        byArray[0] = (byte)ad.b(this.var_z_b.var_byte_arr_b[0], (int)this.var_z_b.var_byte_arr_b[1], 1, false);
        byte[] byArray2 = this.var_z_c.var_byte_arr_b;
        ad.ad_b();
        byArray2[0] = (byte)ad.b(this.var_z_c.var_byte_arr_b[0], (int)this.var_z_c.var_byte_arr_b[1], 1, false);
        switch (this.C) {
            case 1: {
                Object object = this.var_z_c.al_b();
                if (!((al)object).c(0)) {
                    int n2;
                    object = this;
                    ad.ad_b();
                    byte by = (byte)ad.c(100);
                    for (n2 = 5; n2 >= 0 && ((ak)object).var_z_c.al_b().var_byte_arr_b[n2 + 8] == -1; n2 = (int)((byte)(n2 - 1))) {
                    }
                    n2 = (byte)(n2 + 1);
                    if (((ak)object).F == 4) {
                        switch (n2) {
                            case 1: {
                                ((ak)object).var_z_c.var_byte_a = 0;
                                break;
                            }
                            case 2: {
                                if (by < 65) {
                                    ((ak)object).var_z_c.var_byte_a = 1;
                                    break;
                                }
                                ((ak)object).var_z_c.var_byte_a = 0;
                                break;
                            }
                            case 3: {
                                if (by < 45) {
                                    ((ak)object).var_z_c.var_byte_a = (byte)2;
                                    break;
                                }
                                if (by > 75) {
                                    ((ak)object).var_z_c.var_byte_a = 1;
                                    break;
                                }
                                ((ak)object).var_z_c.var_byte_a = 0;
                                break;
                            }
                            default: {
                                if (by < 45) {
                                    ((ak)object).var_z_c.var_byte_a = (byte)(n2 - 1);
                                    break;
                                }
                                if (by < 75) {
                                    ((ak)object).var_z_c.var_byte_a = (byte)(n2 - 2);
                                    break;
                                }
                                if (by < 95) {
                                    ((ak)object).var_z_c.var_byte_a = (byte)(n2 - 3);
                                    break;
                                }
                                ((ak)object).var_z_c.var_byte_a = (byte)(n2 - 4);
                                break;
                            }
                        }
                    } else {
                        int n3;
                        ad.ad_b();
                        byte by2 = (byte)ad.c(100);
                        block23: for (n3 = 0; n3 < 2; n3 = (int)((byte)(n3 + 1))) {
                            switch (((ak)object).var_z_c.al_b().var_byte_arr_b[n3 + 14]) {
                                case 27: {
                                    if (!ak.boolean_b(((ak)object).var_z_c.al_b(), 50) || by2 >= 30) continue block23;
                                    break;
                                }
                                case 28: {
                                    if (!ak.boolean_b(((ak)object).var_z_c.al_b(), 30) || by2 >= 30) continue block23;
                                    break;
                                }
                                default: {
                                    continue block23;
                                }
                            }
                            ((ak)object).var_z_c.var_byte_a = (byte)(n3 + 6);
                            break;
                        }
                        if (n3 > 1) {
                            switch (n2) {
                                case 1: {
                                    ((ak)object).var_z_c.var_byte_a = 0;
                                    break;
                                }
                                case 2: {
                                    if (by < 20) {
                                        ((ak)object).var_z_c.var_byte_a = 0;
                                        break;
                                    }
                                    ((ak)object).var_z_c.var_byte_a = 1;
                                    break;
                                }
                                case 3: {
                                    if (by < 5) {
                                        ((ak)object).var_z_c.var_byte_a = 0;
                                        break;
                                    }
                                    if (by > 40) {
                                        ((ak)object).var_z_c.var_byte_a = (byte)2;
                                        break;
                                    }
                                    ((ak)object).var_z_c.var_byte_a = 1;
                                    break;
                                }
                                case 4: {
                                    if (by < 15) {
                                        ((ak)object).var_z_c.var_byte_a = 1;
                                        break;
                                    }
                                    if (by < 40) {
                                        ((ak)object).var_z_c.var_byte_a = (byte)2;
                                        break;
                                    }
                                    ((ak)object).var_z_c.var_byte_a = (byte)3;
                                    break;
                                }
                                default: {
                                    ((ak)object).var_z_c.var_byte_a = by < 60 ? (byte)(n2 - 1) : (by < 85 ? (byte)(n2 - 2) : (by < 95 ? (byte)(n2 - 3) : (byte)(n2 - 4)));
                                }
                            }
                        }
                    }
                    ((ak)object).var_z_c.var_byte_a = ((ak)object).var_z_c.al_b().var_byte_arr_b[((ak)object).var_z_c.var_byte_a + 8];
                    if (this.var_z_c.al_b().var_byte_b == 6 && this.int_b((int)this.var_z_c.var_byte_a) > 3) {
                        return;
                    }
                    this.e(this.var_z_c);
                    return;
                }
                this.var_z_c.d = 0;
                this.C = (byte)-2;
                return;
            }
            case 9: {
                if (this.var_z_b.d == 0 && this.var_z_c.d == 0) {
                    this.var_z_b.d = 1;
                    this.var_z_c.d = 1;
                    if (this.var_z_b.al_b().c(0)) {
                        this.var_z_b.d = 0;
                        this.b("Th\u1ea1ch H\u00f3a c\u00f3 hi\u1ec7u qu\u1ea3 kh\u00f4ng th\u1ec3 h\u00e0nh \u0111\u1ed9ng, th\u01b0\u01a1ng t\u1ed5n gi\u1ea3m b\u1edbt 30%", -1);
                    } else {
                        this.v(1);
                        this.at();
                        String string = "";
                        if (this.var_z_b.al_b().c(2)) {
                            string = "T\u00ea li\u1ec7t c\u00f3 hi\u1ec7u qu\u1ea3, m\u00e1u gi\u1ea3m b\u1edbt 10%";
                        } else if (this.var_z_b.al_b().c(3)) {
                            string = "M\u1ecb Ho\u1eb7c c\u00f3 hi\u1ec7u qu\u1ea3, kh\u00f4ng th\u1ec3 tr\u1ed1n ch\u1ea1y, gia t\u0103ng t\u1ef7 l\u1ec7 b\u1eaft \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt";
                        } else if (this.var_z_b.al_b().c(4)) {
                            string = "Giam c\u1ea7m hi\u1ec7u qu\u1ea3, kh\u00f4ng th\u1ec3 tr\u1ed1n ch\u1ea1y, kh\u00f4ng th\u1ec3 \u0111\u1ed5i S\u1ee7ng V\u1eadt, kh\u00f4ng th\u1ec3 s\u1eed d\u1ee5ng \u0111\u1ea1o c\u1ee5";
                        } else if (this.var_z_b.al_b().c(5)) {
                            string = "H\u1ee7 th\u1ef1c c\u00f3 hi\u1ec7u qu\u1ea3, m\u1ed7i hi\u1ec7p b\u1ecb th\u01b0\u01a1ng t\u1ed5n nh\u1ea5t \u0111\u1ecbnh";
                        }
                        if (!string.equals("")) {
                            this.b(string, -1);
                        }
                        return;
                    }
                }
                if (this.var_z_b.d != 0 && this.var_z_c.d != 0) {
                    this.v(this.var_z_b.al_b().var_short_arr_b[5] >= this.var_z_c.al_b().var_short_arr_b[5] ? 1 : 0);
                } else {
                    this.v(this.var_z_b.d != 0 ? 1 : 0);
                }
                if (this.var_byte_f == 1) {
                    this.var_z_b.d = 0;
                    if (this.var_z_b.al_b().var_byte_arr_b[6] < 41) {
                        ad.ad_b();
                        if (ad.c(100) < 25) {
                            this.b("\u0110\u1ed9 trung th\u00e0nh q\u00faa th\u1ea5p, S\u1ee7ng V\u1eadt kh\u00f4ng tu\u00e2n theo m\u1ec7nh l\u1ec7nh ch\u1ee7 nh\u00e2n", -1);
                            return;
                        }
                    }
                    if (this.var_z_b.al_b().c(0)) {
                        this.b("Th\u1ea1ch H\u00f3a c\u00f3 hi\u1ec7u qu\u1ea3 kh\u00f4ng th\u1ec3 h\u00e0nh \u0111\u1ed9ng, th\u01b0\u01a1ng t\u1ed5n gi\u1ea3m b\u1edbt 30%", -1);
                        return;
                    }
                    this.e(this.var_z_b);
                    return;
                }
                if (this.var_byte_k != 0) break;
                this.var_z_c.d = 0;
                if (this.var_z_c.al_b().c(0)) break;
                this.C = 1;
                return;
            }
            case -3: {
                return;
            }
            case -5: {
                if (this.var_byte_g == 0 && this.t >= this.t[0]) {
                    ak ak2 = this;
                    var_int_a = -15;
                    ak2.var_byte_g = 0;
                    ak2.var_z_b.var_byte_b = 0;
                    ak2.var_byte_f = (byte)3;
                    ak2.var_byte_c = 1;
                    ak2.L = ak2.var_z_b.i;
                    ak2.var_am_arr_b[0].void_b();
                    int n4 = this.var_short_f;
                    ak2 = this;
                    n4 = n4 / 10 <= 0 ? 1 : n4 / 10;
                    for (int n5 = 0; n5 < 5; n5 = (int)((byte)(n5 + 1))) {
                        if (ak2.byte_c(n5) == -2) continue;
                        ad.ad_b();
                        ad.c(ak2.short_b(n5, 1) + n4, ((as)ak2).n, n5 * 5 + 1);
                        if (ak2.short_b(n5, 1) <= ak2.short_b(n5, 3)) continue;
                        ad.ad_b();
                        ad.c((int)ak2.short_b(n5, 3), ((as)ak2).n, n5 * 5 + 1);
                    }
                    return;
                }
                byte by = this.t[this.t + true];
                if (this.var_byte_g == 0) {
                    if (this.var_byte_b[by].var_short_arr_b[0] > 0) {
                        if (!this.var_byte_b[by].a(40)) {
                            this.var_byte_b[by].var_byte_arr_b[6] = (byte)(this.var_byte_b[by].var_byte_arr_b[6] - 1);
                        }
                        this.var_z_b.var_byte_b = by;
                        this.var_z_b.var_short_b = this.var_byte_b[by].var_short_arr_b[0];
                        this.var_z_b.var_short_c = this.var_byte_b[by].var_short_arr_b[4];
                        this.b(2, (int)this.var_byte_arr_arr_e[this.var_byte_b[by].var_byte_arr_b[0]][0], 1);
                        if (this.boolean_b((int)by, 0)) {
                            this.var_byte_g = 1;
                        }
                    } else {
                        this.t = (byte[])((byte)(this.t + true));
                    }
                } else if (this.var_byte_g == 1) {
                    this.boolean_b((int)by, 1);
                    this.var_byte_g = (byte)2;
                } else if (this.var_byte_g == 2 && this.var_z_b.var_short_c == this.var_byte_b[by].var_short_arr_b[4]) {
                    this.var_byte_g = !this.boolean_b((int)by, 2) ? (byte)15 : (byte)1;
                } else if (this.var_byte_g > 2 && this.var_byte_g < 21 & this.var_z_b.var_short_c == this.var_byte_b[by].var_short_arr_b[4] && (this.var_byte_g = (byte)(this.var_byte_g - 1)) == 3) {
                    this.var_byte_g = 0;
                    this.t = (byte[])((byte)(this.t + true));
                }
                ad.ad_b();
                this.var_z_b.var_short_c = ad.b(this.var_z_b.var_short_c, (int)this.var_byte_b[by].var_short_arr_b[4], 8, false);
                return;
            }
            case -4: {
                if (this.var_byte_k != 0) break;
                byte by = (byte)(this.r + true);
                this.r = (byte[])by;
                if (by >= ((int)this.var_int_c).length) {
                    this.var_int_c = (int)null;
                    this.g(true);
                    return;
                }
                this.b(this.var_int_c[this.r].toString(), 0);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean b(z object, z object2, int n2) {
        if (((z)object2).al_b().var_short_arr_b[0] > 0) {
            return true;
        }
        if (((z)object2).e != 1) {
            if (((z)object2).var_byte_c == 2) return false;
            ((z)object2).var_byte_c = (byte)2;
            this.s[this.var_byte_f] = 0;
            this.r[this.var_byte_f] = 0;
            if (((z)object2).al_b().a(40)) return false;
            ((z)object2).al_b().var_byte_arr_b[6] = (byte)(((z)object2).al_b().var_byte_arr_b[6] - 10);
            return false;
        }
        if (((z)object2).al_b().a(38)) {
            ad.ad_b();
            if (ad.c(100) < this.var_byte_arr_arr_n[38][1]) {
                Object object3 = object2;
                object2 = object;
                object = this;
                ((z)object3).void_b();
                ((z)object3).b(-((z)object3).al_b().var_short_arr_b[2] * ((ak)object).var_byte_arr_arr_n[38][0] / 100, 1, 1);
                ((z)object3).var_byte_a = (byte)28;
                ((z)object3).e = 0;
                ((z)object3).var_byte_c = 0;
                ((z)object3).var_boolean_b = true;
                ((z)object3).d = 0;
                ((ak)object).C = (byte)-1;
                ((ak)object).void_g(5);
                super.b((z)object3, ((z)object3).al_b(), ((z)object2).al_b());
                super.v(((ak)object).var_byte_f ^ 1);
                return false;
            }
        }
        if (n2 == 0) {
            this.var_z_c.d = 1;
            object = this;
        } else {
            byte by;
            if (n2 != 1) return false;
            int n3 = this.var_z_c.var_al_arr_b.length;
            object = this.var_z_c;
            n2 = 0;
            byte by2 = ((z)object).var_byte_b;
            do {
                if ((((z)object).var_byte_b = (byte)(((z)object).var_byte_b + 1)) >= n3) {
                    ((z)object).var_byte_b = 0;
                }
                by = (byte)(n2 + 1);
                n2 = by;
            } while (by <= n3 && (by2 == ((z)object).var_byte_b || ((z)object).al_b().var_short_arr_b[0] <= 0));
            if (n2 > n3) {
                ((z)object).var_byte_b = by2;
            }
            if (n2 <= n3) {
                this.Z();
                this.var_z_c.d = 0;
                var_int_a = -50;
                this.D = this.C;
                this.C = 0;
                return false;
            }
            object = this;
            this.C = (byte)-4;
            ((ak)object).r = (byte[])-1;
            StringBuffer stringBuffer = new StringBuffer();
            ad.ad_b();
            if (ad.c(100) < 50 && ((ak)object).byte_b(-2, 32, true) < 99) {
                ((ak)object).byte_e(32, 1);
                stringBuffer.append("\u0110\u1ea1t \u0111\u01b0\u1ee3c: " + ((ak)object).java_lang_String_c(32) + "x1");
            }
            ((as)object).b(stringBuffer.toString(), 10000, 0);
            if (this.var_byte_n == 2) {
                this.var_at_b.var_byte_h = 0;
            }
            this.var_byte_n = 0;
            return false;
        }
        for (byte by = 1; by < ((ak)object).y; by = (byte)(by + 1)) {
            if (((ak)object).var_byte_b[by].var_short_arr_b[0] <= 0) continue;
            super.v(1);
            ((ak)object).d();
            return false;
        }
        boolean bl = false;
        if (bl) {
            return false;
        }
        if (this.var_byte_n != 0) {
            if (this.var_byte_n == 2) {
                this.var_at_b.var_byte_h = 1;
            }
            this.var_byte_n = 0;
            this.ae();
            this.ah();
            this.O();
            this.c(false);
            return false;
        }
        if (ar.b((ak)this).var_boolean_b) {
            ar.b(this).b(3, true);
            return false;
        }
        ar.b((ak)this).var_boolean_b = true;
        var_int_a = 60;
        return false;
    }

    private void b(z z2, z z3) {
        z3.void_b();
        z3.b(-z3.al_b().var_short_arr_b[2] * this.var_byte_arr_arr_n[38][0] / 100, 1, 1);
        z3.var_byte_a = (byte)28;
        z3.e = 0;
        z3.var_byte_c = 0;
        z3.var_boolean_b = true;
        z3.d = 0;
        this.C = (byte)-1;
        this.void_g(5);
        this.b(z3, z3.al_b(), z2.al_b());
        this.v(this.var_byte_f ^ 1);
    }

    private void e(z z2) {
        z2.var_byte_c = 1;
        this.s[this.var_byte_f] = 0;
        this.r[this.var_byte_f] = 0;
        this.C = (byte)-1;
        this.void_g(z2.var_byte_a / 5);
    }

    public final void void_g(int n2) {
        if (n2 > 5) {
            n2 = 5;
        }
        int n3 = n2;
        ak ak2 = this;
        if (null == ak2.var_am_arr_c[n3]) {
            String string = "data/battle/s" + n3;
            ak2.var_am_arr_c[n3] = ad.ad_b().b(string, false);
        }
        this.var_short_arr_b[n2] = 0;
        this.var_short_arr_c[n2] = 0;
    }

    private void ao() {
        ad.ad_b();
        if (ad.boolean_b()) {
            return;
        }
        switch (this.C) {
            case 2: {
                ad.ad_b();
                if (ad.e()) {
                    ad.ad_b();
                    this.s = (byte[])ad.byte_b((int)this.s, 0, ((int)this.var_int_c).length - 1);
                    return;
                }
                ad.ad_b();
                if (!ad.g()) break;
                if (this.s == false) {
                    if (this.var_z_b.al_b().var_byte_arr_b[6] == 0) {
                        this.b("\u0110\u1ed9 trung th\u00e0nh c\u1ee7a S\u1ee7ng V\u1eadt 0, c\u1ea7n b\u1ed5 sung ngay!", -1);
                        return;
                    }
                    this.C = (byte)3;
                    while (this.w[this.N] > 30) {
                        this.N = (byte)(this.N + 1);
                    }
                    this.var_byte_h[0][0] = this.N;
                    this.var_byte_h[0][1] = (byte)(this.var_byte_h[0][0] - 4);
                    if (this.var_byte_h[0][1] > 0) break;
                    this.var_byte_h[0][1] = false;
                    return;
                }
                if (this.s == true) {
                    if (this.var_z_b.al_b().var_byte_b == 4) {
                        this.b("Ph\u1ea1m vi giam c\u1ea7m kh\u00f4ng th\u1ec3 s\u1eed d\u1ee5ng \u0111\u1ea1o c\u1ee5!", -1);
                        return;
                    }
                    this.p(0);
                    return;
                }
                if (this.s == 2) {
                    if (this.var_z_b.al_b().var_byte_b == 4) {
                        this.b("Ph\u1ea1m vi giam c\u1ea7m kh\u00f4ng th\u1ec3 \u0111\u1ed5i S\u1ee7ng V\u1eadt!", -1);
                        return;
                    }
                    this.var_byte_c = (byte)-2;
                    this.d();
                    return;
                }
                if (this.s == 3) {
                    this.void_b(0, 0);
                    return;
                }
                if (this.s != 4) break;
                if (this.F == 4) {
                    short s2 = (short)(this.var_z_b.al_b().var_byte_arr_b[2] - this.var_z_c.al_b().var_byte_arr_b[2] + 60);
                    int n2 = 0;
                    ad.ad_b();
                    if (ad.c(100) >= s2) {
                        n2 = 1;
                    }
                    if (this.var_z_b.al_b().a(42)) {
                        n2 = 0;
                    } else if (this.var_z_b.al_b().boolean_b(3) || this.var_z_b.al_b().boolean_b(4)) {
                        n2 = 2;
                    }
                    if (n2 == 0) {
                        this.ae();
                        this.ah();
                        this.O();
                        return;
                    }
                    if (n2 == 1) {
                        this.b("Ch\u1ea1y tr\u1ed1n th\u1ea5t b\u1ea1i!", 1);
                        this.var_z_b.d = 0;
                        this.var_z_c.d = 1;
                        this.C = (byte)9;
                        return;
                    }
                    this.b("G\u1eb7p qu\u00e1i" + (this.var_z_b.al_b().boolean_b(4) ? "Ph\u1ea1m vi giam c\u1ea7m" : "\u0110i\u1ec7n ma") + ", Kh\u00f4ng th\u1ec3 ch\u1ea1y tr\u1ed1n!", 1);
                    return;
                }
                this.b("Kh\u00f4ng th\u1ec3 ch\u1ea1y tr\u1ed1n!", 0);
                return;
            }
            case 3: {
                ad.ad_b();
                if (ad.boolean_c()) {
                    ad.ad_b();
                    ad.b((byte[])this.var_byte_h[0], 0, (int)this.w[8], 5);
                    this.N = this.var_byte_h[0][0];
                    return;
                }
                ad.ad_b();
                if (ad.g()) {
                    if (this.w[this.var_byte_h[0][0]] > 30) {
                        this.b("K\u1ef9 n\u0103ng b\u1ecb \u0111\u1ed9ng kh\u00f4ng th\u1ec3 s\u1eed d\u1ee5ng!", -1);
                        return;
                    }
                    if (this.var_z_b.al_b().var_byte_b == 6 && this.int_b((int)this.w[this.var_byte_h[0][0]]) > 3) {
                        this.b("\u0110\u00e3 \u0111\u00f3ng b\u0103ng, kh\u00f4ng th\u1ec3 s\u1eed d\u1ee5ng h\u01a1n 4 k\u1ef9 n\u0103ng", -1);
                        return;
                    }
                    if (this.var_z_b.al_b().var_short_arr_b[1] >= this.int_b(this.var_z_b.al_b(), (int)this.w[this.var_byte_h[0][0]])) {
                        this.var_z_b.var_byte_a = this.w[this.var_byte_h[0][0]];
                        this.C = (byte)9;
                        return;
                    }
                    this.b("Gi\u00e1 tr\u1ecb k\u1ef9 n\u0103ng c\u1ea7n ch\u01b0a \u0111\u1ee7!", -1);
                    return;
                }
                ad.ad_b();
                if (!ad.i()) break;
                this.C = (byte)2;
                return;
            }
            case 5: {
                ad.ad_b();
                if (ad.boolean_c()) {
                    ad.ad_b();
                    ad.b((byte[])this.var_byte_h[0], 0, 6, this.w[8]);
                    return;
                }
                ad.ad_b();
                if (ad.g()) {
                    return;
                }
                ad.ad_b();
                if (!ad.i()) break;
                this.C = (byte)2;
                return;
            }
            case 4: {
                ad.ad_b();
                if (ad.boolean_c()) {
                    ad.ad_b();
                    ad.b((byte[])this.var_byte_h[0], 0, 6, this.w[8]);
                    return;
                }
                ad.ad_b();
                if (ad.g()) {
                    return;
                }
                ad.ad_b();
                if (!ad.i()) break;
                this.C = (byte)2;
            }
        }
    }

    private void void_b(al al2, int n2) {
        ah.ah_b();
        ah.d(-2, n2, 244, 10, 0);
        ak.b(al2, 37, n2 + 3, 195, 2, 2, (int)(this.C != -5 ? al2.var_short_arr_b[4] : this.var_z_b.var_short_c));
        ah.ah_b().c(al2.var_byte_arr_b[2] + "\u0110\u1eb3ng c\u1ea5p", 6, n2 + 9, 0, 0);
    }

    private void b(boolean n2, int n3) {
        ah.ah_b();
        ah.b(1, 242, 238, 74);
        int n4 = 227;
        al al2 = this.var_z_b.al_b();
        ak ak2 = this;
        ah.ah_b();
        ah.d(-2, n4, 244, 10, 0);
        ak.b(al2, 37, n4 + 3, 195, 2, 2, (int)(ak2.C != -5 ? al2.var_short_arr_b[4] : ak2.var_z_b.var_short_c));
        ah.ah_b().c(al2.var_byte_arr_b[2] + "\u0110\u1eb3ng c\u1ea5p", 6, n4 + 9, 0, 0);
        if (n2 != 0) {
            return;
        }
        ah.ah_b();
        ah.b("Mu\u1ed1n l\u00e0m g\u00ec?", 6, 247, 0, 0, 0);
        for (n2 = 0; n2 < ((int)this.var_int_c).length; n2 = (int)((byte)(n2 + 1))) {
            ah.ah_b();
            ah.h(5 + n2 * 45, 273, 43, 22, this.s == n2 ? 4 : 1);
            ah.ah_b();
            ah.b((String)this.var_int_c[n2], 8 + n2 * 45, 274, 0, this.s == n2 ? 0 : 3, 0);
        }
    }

    private void ap() {
        this.b(this.var_z_c.al_b(), 235, 21);
        if (this.var_z_c.al_b().var_short_arr_b[0] <= 0 && this.var_z_c.e == 1) {
            return;
        }
        if (this.b(0, 0, this.var_byte_arr_arr_e[this.var_z_c.al_b().var_byte_arr_b[0]][1] * 3 + this.var_z_c.var_byte_c, 177 + (this.var_z_c.var_byte_arr_a[0] != 0 ? 3 : 0), 97 + (this.var_z_c.var_byte_arr_a[0] != 0 ? -3 : 0), this.var_z_c.var_byte_c == 0, 0)) {
            if (this.var_z_c.al_b().var_short_arr_b[0] <= 0) {
                this.var_z_c.var_byte_c = (byte)2;
                this.var_z_c.e = 1;
            } else if (this.var_z_c.e != 1) {
                this.var_z_c.var_byte_c = 0;
            }
        }
        byte[] byArray = this.var_z_c.var_byte_arr_a;
        ad.ad_b();
        byArray[0] = (byte)ad.b(this.var_z_c.var_byte_arr_a[0], 0, 1, true);
        ak.b(this.var_z_c.al_b(), 152, 97, 50, 0, 1, (int)this.var_z_c.var_short_b);
        ad.ad_b();
        this.var_z_c.var_short_b = ad.b(this.var_z_c.var_short_b, (int)this.var_z_c.al_b().var_short_arr_b[0], this.var_z_c.var_short_b < this.var_z_c.al_b().var_short_arr_b[0] ? 20 : 6, true);
    }

    private void aq() {
        this.b(this.var_z_b.al_b(), 21, 138);
        if (this.b(1, 1, this.var_byte_arr_arr_e[this.var_z_b.al_b().var_byte_arr_b[0]][1] * 3 + this.var_z_b.var_byte_c, 46 + (this.var_z_b.var_byte_arr_a[0] != 0 ? -3 : 0), 206 + (this.var_z_b.var_byte_arr_a[0] != 0 ? 3 : 0), this.var_z_b.var_byte_c == 0, 1)) {
            if (this.var_z_b.al_b().var_short_arr_b[0] <= 0) {
                this.var_z_b.var_byte_c = (byte)2;
                this.var_z_b.e = 1;
            } else {
                this.var_z_b.var_byte_c = 0;
            }
        }
        byte[] byArray = this.var_z_b.var_byte_arr_a;
        ad.ad_b();
        byArray[0] = (byte)ad.b(this.var_z_b.var_byte_arr_a[0], 0, 1, true);
        ak.b(this.var_z_b.al_b(), 21, 207, 50, 0, 1, (int)this.var_z_b.var_short_b);
        ak.b(this.var_z_b.al_b(), 21, 212, 50, 1, 2, (int)this.var_z_b.al_b().var_short_arr_b[1]);
        ad.ad_b();
        this.var_z_b.var_short_b = ad.b(this.var_z_b.var_short_b, (int)this.var_z_b.al_b().var_short_arr_b[0], this.var_z_b.var_short_b < this.var_z_b.al_b().var_short_arr_b[0] ? 20 : 6, true);
    }

    private void ar() {
        ah.ah_b();
        ah.a(0, 0, 103, 28);
        if (this.var_z_c.al_b().var_byte_arr_b[3] != -1) {
            ah.ah_b().a(this.var_z_c.al_b().var_byte_arr_b[3] + 5, 11, 14, 3, 0);
        }
        ah.ah_b();
        ah.b(this.java_lang_String_e(this.var_z_c.al_b().var_byte_arr_b[0]).toString(), 61, 1, 17, 4, 2);
        ah.ah_b();
        ah.b(this.var_z_c.al_b().var_byte_arr_b[2] + "\u0110\u1eb3ng c\u1ea5p", 105, 1, 0, 0, 2);
        ah.ah_b();
        ah.d(2, 29, 62, 14, 4);
        ah.ah_b().a(34, 4, 30, 0, 0);
        ah.ah_b().c(100 + this.var_z_c.var_byte_arr_b[0] + "%", 60, 42, 1, 1);
        ah.ah_b().a(this.var_byte_arr_arr_k[this.var_z_c.al_b().var_byte_arr_b[0]] == 2 ? 25 : 26, 66, 29, 0, 0);
    }

    private void as() {
        ah.ah_b();
        ah.a(137, 199, 103, 28);
        ah.ah_b().a(this.var_z_b.al_b().var_byte_arr_b[3] + 5, 148, 213, 3, 0);
        ah.ah_b();
        ah.b(this.java_lang_String_e(this.var_z_b.al_b().var_byte_arr_b[0]).toString(), 198, 200, 17, 4, 2);
        ah.ah_b();
        ah.d(176, 184, 62, 14, 4);
        ah.ah_b().a(34, 178, 185, 0, 0);
        ah.ah_b().c(100 + this.var_z_b.var_byte_arr_b[0] + "%", 234, 197, 1, 1);
    }

    public final boolean boolean_b(int n2, int n3, int n4, int n5, int n6, int n7) {
        if (this.var_short_arr_b[n2] >= this.var_am_arr_c[n3].b(n4)) {
            this.var_short_arr_b[n2] = 0;
            return true;
        }
        short s2 = (short)this.var_am_arr_c[n3].c(n4, this.var_short_arr_b[n2], 0);
        while (this.var_z_e != null && s2 < 2) {
            if (s2 == 0) {
                this.var_z_e.var_byte_arr_a[0] = 2;
            }
            this.var_short_arr_c[n2] = 0;
            int n8 = n2;
            this.var_short_arr_b[n8] = (short)(this.var_short_arr_b[n8] + 1);
            if (this.var_short_arr_b[n8] >= this.var_am_arr_c[n3].b(n4)) {
                this.var_short_arr_b[n2] = 0;
                return true;
            }
            s2 = (short)this.var_am_arr_c[n3].c(n4, this.var_short_arr_b[n2], 0);
        }
        ah.ah_b().b(this.var_am_arr_c[n3], (int)s2, n5, n6, n7);
        int n9 = n2;
        n2 = 1;
        n5 = n4;
        n4 = n3;
        n3 = n9;
        ak ak2 = this;
        int n10 = n3;
        ak2.var_short_arr_c[n10] = (short)(ak2.var_short_arr_c[n10] + 1);
        if (ak2.var_short_arr_c[n10] >= ak2.var_am_arr_c[n4].c(n5, ak2.var_short_arr_b[n3], 1)) {
            int n11 = n3;
            ak2.var_short_arr_b[n11] = (short)(ak2.var_short_arr_b[n11] + 1);
            ak2.var_short_arr_c[n3] = 0;
        }
        return false;
    }

    private boolean boolean_b(int n2, int n3, int n4, boolean bl) {
        int n5 = n2;
        this.var_short_arr_c[n5] = (short)(this.var_short_arr_c[n5] + 1);
        if (this.var_short_arr_c[n5] >= this.var_am_arr_c[n3].c(n4, this.var_short_arr_b[n2], 1)) {
            int n6 = n2;
            this.var_short_arr_b[n6] = (short)(this.var_short_arr_b[n6] + 1);
            this.var_short_arr_c[n2] = 0;
        }
        return false;
    }

    private boolean b(int n2, int n3, int n4, int n5, int n6, boolean bl, int n7) {
        if (this.s[n2] >= this.var_am_arr_b[n3].b(n4)) {
            this.s[n2] = 0;
        }
        ah.ah_b().b(this.var_am_arr_b[n3], this.var_am_arr_b[n3].c(n4, this.s[n2], 0), n5, n6, n7);
        n6 = bl ? 1 : 0;
        n5 = n4;
        n4 = n3;
        n3 = n2;
        ak ak2 = this;
        int n8 = n3;
        ak2.r[n8] = (byte)(ak2.r[n8] + 1);
        if (ak2.r[n8] >= ak2.var_am_arr_b[n4].c(n5, ak2.s[n3], 1)) {
            int n9 = n3;
            ak2.s[n9] = (byte)(ak2.s[n9] + 1);
            ak2.r[n3] = 0;
            if (n6 == 0 && ak2.s[n3] >= ak2.var_am_arr_b[n4].b(n5)) {
                int n10 = n3;
                ak2.s[n10] = (byte)(ak2.s[n10] - 1);
                return true;
            }
        }
        return false;
    }

    private boolean c(int n2, int n3, int n4, boolean bl) {
        int n5 = n2;
        this.r[n5] = (byte)(this.r[n5] + 1);
        if (this.r[n5] >= this.var_am_arr_b[n3].c(n4, this.s[n2], 1)) {
            int n6 = n2;
            this.s[n6] = (byte)(this.s[n6] + 1);
            this.r[n2] = 0;
            if (!bl && this.s[n2] >= this.var_am_arr_b[n3].b(n4)) {
                int n7 = n2;
                this.s[n7] = (byte)(this.s[n7] - 1);
                return true;
            }
        }
        return false;
    }

    public final void c(al al2) {
        int n2;
        byte by = 0;
        this.w[8] = 0;
        for (n2 = 7; n2 >= 0; n2 = (int)((byte)(n2 - 1))) {
            this.w[n2] = al2.var_byte_arr_b[n2 + 8];
            if (this.w[n2] == -1) continue;
            this.w[8] = (byte)(this.w[8] + 1);
        }
        for (n2 = 1; n2 < 8; n2 = (int)((byte)(n2 + 1))) {
            for (int n3 = n2; n3 > 0 && this.w[n3] > this.w[n3 - 1]; n3 = (int)((byte)(n3 - 1))) {
                by = this.w[n3];
                this.w[n3] = this.w[n3 - 1];
                this.w[n3 - 1] = by;
            }
        }
    }

    private void t(int n2) {
        if (null != this.var_am_arr_c[n2]) {
            return;
        }
        String string = "data/battle/s" + n2;
        this.var_am_arr_c[n2] = ad.ad_b().b(string, false);
    }

    public final void b(int n2, int n3, int n4) {
        String string = "data/npc" + n2 + "/" + n3;
        boolean bl = true;
        if (n2 == 2) {
            bl = this.boolean_b(n3);
        }
        if (null == this.var_am_arr_b[n4]) {
            this.var_am_arr_b[n4] = ad.ad_b().b(string, bl);
            return;
        }
        ad.ad_b().b(this.var_am_arr_b[n4], string, bl);
    }

    public final void k() {
        this.var_byte_arr_arr_b = null;
        this.var_byte_arr_arr_b = new byte[1][2];
        boolean bl = false;
        int n2 = -1;
        byte[] byArray = this.var_byte_arr_arr_b[0];
        ak ak2 = this;
        ad.ad_b();
        if (ad.c(100) < 5 && ak2.var_byte_arr_c.length > 6) {
            n2 = 6;
        } else {
            byte[] byArray2 = ak2.var_byte_arr_c;
            ad.ad_b();
            n2 = byArray2[ad.c(ak2.var_byte_arr_c.length > 6 ? 3 : ak2.var_byte_arr_c.length - 3) + 3];
        }
        ad.ad_b();
        byArray[1] = (byte)(ad.c(ak2.var_byte_arr_c[2] + 1) + ak2.var_byte_arr_c[1]);
        byArray[0] = (byte)n2;
        ai.ai_b().b(6);
        ai.ai_b().b(true);
        this.l();
    }

    private void at() {
        this.var_java_lang_String_arr_c = new String[]{"C\u00f4ng k\u00edch", "\u0110\u1ea1o c\u1ee5", "S\u1ee7ng V\u1eadt", "C\u1eeda h\u00e0ng", "Ch\u1ea1y tr\u1ed1n"};
        var_int_a = -31;
        this.C = (byte)(this.var_byte_f == 1 ? 2 : 1);
    }

    private void u(int n2) {
        var_int_a = -31;
        this.C = (byte)(n2 == 1 ? 2 : 1);
        this.v(n2);
        if (n2 == 1) {
            this.c(this.var_z_b.al_b());
        }
        this.b(this.var_z_b, this.var_z_b.al_b(), this.var_z_c.al_b());
        this.b(this.var_z_c, this.var_z_c.al_b(), this.var_z_b.al_b());
    }

    public final void f(int n2) {
        this.F = (byte)n2;
    }

    private void au() {
        al[] alArray = new al[this.var_byte_arr_arr_b.length];
        for (int i2 = 0; i2 < this.var_byte_arr_arr_b.length; ++i2) {
            alArray[i2] = new al(this, this.var_byte_arr_arr_b[i2][0], this.var_byte_arr_arr_b[i2][1], this.var_byte_b[0].a(39) ? 1 : 0);
            if (this.F == 3 || this.F == 0) {
                al al2;
                byte by;
                if (alArray[i2].var_byte_arr_b[3] == -1) {
                    by = this.var_byte_arr_arr_b[i2][4];
                    al2 = alArray[i2];
                    al2.var_byte_arr_b[16] = 4;
                    al2.var_byte_arr_b[17] = 10;
                    al2.var_byte_arr_b[9] = 4;
                    al2.var_byte_arr_b[10] = 9;
                    al2.var_byte_arr_b[11] = 14;
                    al2.var_byte_arr_b[12] = 19;
                    al2.var_byte_arr_b[13] = 24;
                    al2.var_byte_arr_b[14] = 30;
                    al2.var_byte_arr_b[15] = 48;
                    al2.var_byte_arr_b[6] = by;
                } else {
                    byte by2 = this.var_byte_arr_arr_b[i2][4];
                    byte by3 = this.var_byte_arr_arr_b[i2][3];
                    by = this.var_byte_arr_arr_b[i2][2];
                    al2 = alArray[i2];
                    al2.var_byte_arr_b[16] = (byte)((al2.var_byte_arr_b[3] << 1) + 4);
                    al2.var_byte_arr_b[17] = 2;
                    al2.var_byte_arr_b[14] = by;
                    al2.var_byte_arr_b[15] = by3;
                    al2.var_byte_arr_b[6] = by2;
                }
                alArray[i2].b(this);
                continue;
            }
            alArray[i2].b(this, -1);
        }
        this.var_byte_arr_arr_b = null;
        this.var_z_c = new z(alArray);
    }

    public final void c(int n2, boolean bl) {
        ad.ad_b();
        ad.var_int_c = 0;
        byte[] byArray = ad.ad_b().byte_arr_b("data/map/" + "m" + n2 + ".d", -1);
        ad.ad_b();
        this.var_byte_arr_c = ad.byte_arr_b(byArray);
        ad.ad_b();
        this.var_byte_arr_b = ad.byte_arr_b(byArray);
        this.var_byte_arr_arr_c = ad.ad_b().byte_arr_arr_b(byArray);
    }

    private void b(byte[] byArray, int n2, int n3) {
        ad.ad_b();
        if (ad.c(100) < 5 && this.var_byte_arr_c.length > 6) {
            n2 = 6;
        } else {
            ad.ad_b();
            n2 = this.var_byte_arr_c[ad.c(this.var_byte_arr_c.length > 6 ? 3 : this.var_byte_arr_c.length - 3) + 3];
        }
        ad.ad_b();
        byArray[1] = (byte)(ad.c(this.var_byte_arr_c[2] + 1) + this.var_byte_arr_c[1]);
        byArray[0] = (byte)n2;
    }

    private void v(int n2) {
        this.var_byte_f = (byte)n2;
        this.var_z_a = this.var_byte_f == 1 ? this.var_z_b : this.var_z_c;
        this.var_z_e = this.var_byte_f == 1 ? this.var_z_c : this.var_z_b;
    }

    public final void l() {
        byte by;
        this.M = 0;
        this.N = 0;
        this.var_byte_g = 0;
        this.s = (byte[])false;
        this.t = null;
        this.t = new byte[this.w + true];
        this.var_byte_arr_arr_a = null;
        this.var_byte_arr_arr_a = new byte[this.w][2];
        this.var_short_arr_arr_b = null;
        this.var_short_arr_arr_b = new short[((byte)this.var_byte_b).length][7];
        this.var_z_b = new z((al[])this.var_byte_b);
        ak ak2 = this;
        al[] alArray = new al[ak2.var_byte_arr_arr_b.length];
        for (int i2 = 0; i2 < ak2.var_byte_arr_arr_b.length; ++i2) {
            alArray[i2] = new al(ak2, ak2.var_byte_arr_arr_b[i2][0], ak2.var_byte_arr_arr_b[i2][1], ak2.var_byte_b[0].a(39) ? 1 : 0);
            if (ak2.F == 3 || ak2.F == 0) {
                al al2;
                byte by2;
                if (alArray[i2].var_byte_arr_b[3] == -1) {
                    by2 = ak2.var_byte_arr_arr_b[i2][4];
                    al2 = alArray[i2];
                    al2.var_byte_arr_b[16] = 4;
                    al2.var_byte_arr_b[17] = 10;
                    al2.var_byte_arr_b[9] = 4;
                    al2.var_byte_arr_b[10] = 9;
                    al2.var_byte_arr_b[11] = 14;
                    al2.var_byte_arr_b[12] = 19;
                    al2.var_byte_arr_b[13] = 24;
                    al2.var_byte_arr_b[14] = 30;
                    al2.var_byte_arr_b[15] = 48;
                    al2.var_byte_arr_b[6] = by2;
                } else {
                    byte by3 = ak2.var_byte_arr_arr_b[i2][4];
                    byte by4 = ak2.var_byte_arr_arr_b[i2][3];
                    by2 = ak2.var_byte_arr_arr_b[i2][2];
                    al2 = alArray[i2];
                    al2.var_byte_arr_b[16] = (byte)((al2.var_byte_arr_b[3] << 1) + 4);
                    al2.var_byte_arr_b[17] = 2;
                    al2.var_byte_arr_b[14] = by2;
                    al2.var_byte_arr_b[15] = by4;
                    al2.var_byte_arr_b[6] = by3;
                }
                alArray[i2].b(ak2);
                continue;
            }
            alArray[i2].b(ak2, -1);
        }
        ak2.var_byte_arr_arr_b = null;
        ak2.var_z_c = new z(alArray);
        for (by = 0; by < this.y; by = (byte)(by + 1)) {
            this.var_byte_b[by].var_byte_b = (byte)7;
            this.var_byte_b[by].c = 0;
            this.var_byte_b[by].var_byte_arr_b[1] = by;
            this.var_short_arr_arr_b[by][6] = this.var_byte_b[by].var_byte_arr_b[2];
        }
        for (by = 0; by < this.y; by = (byte)(by + 1)) {
            if (this.var_byte_b[by].var_short_arr_b[0] <= 0) continue;
            this.t[0] = (byte)(this.t[0] + 1);
            this.t[this.t[0]] = this.var_byte_b[by].var_byte_arr_b[1];
            if (by == 0) break;
            ak.void_b((al)this.var_byte_b[by], (al)this.var_byte_b[0]);
            break;
        }
        if (this.var_javax_microedition_lcdui_Image_arr_b == null) {
            ad.ad_b();
            this.var_javax_microedition_lcdui_Image_arr_b = ad.b(7, "data/brow/e");
        }
        this.var_at_b.var_aj_b.var_byte_a = (byte)15;
        var_int_a = -30;
        this.var_byte_c = (byte)-1;
        new ac(this, 1);
    }

    public final void m() {
        System.gc();
        this.var_byte_d[3] = false;
        this.var_byte_d[2] = false;
        this.var_byte_d[1] = false;
        this.var_byte_d[0] = false;
        this.b(this.var_z_c, this.var_z_c.al_b());
        this.b(this.var_z_b, this.var_z_b.al_b());
        this.Z();
        this.aa();
    }

    private void b(z z2, al al2) {
        if (this.var_byte_arr_c.length != 0) {
            z2.i = this.var_byte_arr_c[0];
        }
        for (int n2 = 0; n2 < 5; n2 = (int)((byte)(n2 + 1))) {
            if (!al2.a(n2 + 43)) continue;
            z2.i = (byte)n2;
            return;
        }
    }

    private static boolean boolean_b(al al2) {
        return !al2.c(0);
    }

    private void av() {
        int n2;
        ad.ad_b();
        byte by = (byte)ad.c(100);
        for (n2 = 5; n2 >= 0 && this.var_z_c.al_b().var_byte_arr_b[n2 + 8] == -1; n2 = (int)((byte)(n2 - 1))) {
        }
        n2 = (byte)(n2 + 1);
        if (this.F == 4) {
            switch (n2) {
                case 1: {
                    this.var_z_c.var_byte_a = 0;
                    break;
                }
                case 2: {
                    if (by < 65) {
                        this.var_z_c.var_byte_a = 1;
                        break;
                    }
                    this.var_z_c.var_byte_a = 0;
                    break;
                }
                case 3: {
                    if (by < 45) {
                        this.var_z_c.var_byte_a = (byte)2;
                        break;
                    }
                    if (by > 75) {
                        this.var_z_c.var_byte_a = 1;
                        break;
                    }
                    this.var_z_c.var_byte_a = 0;
                    break;
                }
                default: {
                    if (by < 45) {
                        this.var_z_c.var_byte_a = (byte)(n2 - 1);
                        break;
                    }
                    if (by < 75) {
                        this.var_z_c.var_byte_a = (byte)(n2 - 2);
                        break;
                    }
                    if (by < 95) {
                        this.var_z_c.var_byte_a = (byte)(n2 - 3);
                        break;
                    }
                    this.var_z_c.var_byte_a = (byte)(n2 - 4);
                    break;
                }
            }
        } else {
            int n3;
            ad.ad_b();
            byte by2 = (byte)ad.c(100);
            block16: for (n3 = 0; n3 < 2; n3 = (int)((byte)(n3 + 1))) {
                switch (this.var_z_c.al_b().var_byte_arr_b[n3 + 14]) {
                    case 27: {
                        if (!ak.boolean_b(this.var_z_c.al_b(), 50) || by2 >= 30) continue block16;
                        break;
                    }
                    case 28: {
                        if (!ak.boolean_b(this.var_z_c.al_b(), 30) || by2 >= 30) continue block16;
                        break;
                    }
                    default: {
                        continue block16;
                    }
                }
                this.var_z_c.var_byte_a = (byte)(n3 + 6);
                break;
            }
            if (n3 > 1) {
                switch (n2) {
                    case 1: {
                        this.var_z_c.var_byte_a = 0;
                        break;
                    }
                    case 2: {
                        if (by < 20) {
                            this.var_z_c.var_byte_a = 0;
                            break;
                        }
                        this.var_z_c.var_byte_a = 1;
                        break;
                    }
                    case 3: {
                        if (by < 5) {
                            this.var_z_c.var_byte_a = 0;
                            break;
                        }
                        if (by > 40) {
                            this.var_z_c.var_byte_a = (byte)2;
                            break;
                        }
                        this.var_z_c.var_byte_a = 1;
                        break;
                    }
                    case 4: {
                        if (by < 15) {
                            this.var_z_c.var_byte_a = 1;
                            break;
                        }
                        if (by < 40) {
                            this.var_z_c.var_byte_a = (byte)2;
                            break;
                        }
                        this.var_z_c.var_byte_a = (byte)3;
                        break;
                    }
                    default: {
                        this.var_z_c.var_byte_a = by < 60 ? (byte)(n2 - 1) : (by < 85 ? (byte)(n2 - 2) : (by < 95 ? (byte)(n2 - 3) : (byte)(n2 - 4)));
                    }
                }
            }
        }
        this.var_z_c.var_byte_a = this.var_z_c.al_b().var_byte_arr_b[this.var_z_c.var_byte_a + 8];
    }

    private static boolean boolean_b(al al2, int n2) {
        return al2.var_short_arr_b[0] < al2.var_byte_arr_b[2] * n2 / 100;
    }

    private void j(int n2, int n3) {
        this.var_byte_p = (byte)(n2 == 0 ? 25 : this.var_byte_arr_arr_p[n2 - 1][n3]);
    }

    private int int_b(int n2) {
        if (n2 == 25) {
            return 0;
        }
        if (n2 < 25) {
            return n2 % 5 + 1;
        }
        return this.u[n2 - 25 - 1];
    }

    private int int_b(al al2, int n2) {
        byte by = this.var_byte_arr_arr_n[n2][1];
        if (al2.var_byte_arr_b[3] == 4 && al2.a(35)) {
            return by * this.var_byte_arr_arr_n[n2][0] / 100;
        }
        return by;
    }

    public final void a(al al2) {
        byte[] byArray = new byte[]{0, 7, 14, 21, 28, 35};
        this.var_byte_p = (byte)-1;
        for (int n2 = 0; n2 < byArray.length; n2 = (int)((byte)(n2 + 1))) {
            if (al2.var_byte_arr_b[n2 + 8] != -1 || al2.var_byte_arr_b[2] < byArray[n2]) continue;
            byte by = al2.var_byte_arr_b[3];
            int n3 = n2;
            ak ak2 = this;
            al2.var_byte_arr_b[n2 + 8] = this.var_byte_p = (byte)(n3 == 0 ? 25 : ak2.var_byte_arr_arr_p[n3 - 1][by]);
        }
    }

    public final void b(boolean bl, int n2, int n3, int n4, int n5) {
        if (bl) {
            ah.ah_b();
            ah.b(5422575, 0, 0, 240, 320);
        }
        var_int_c.setColor(0);
        var_int_c.fillRect(30, 283, 180, 5);
        var_int_c.fillRect(31, 282, 178, 7);
        var_int_c.setColor(15400191);
        var_int_c.fillRect(32, 283, n2 * 176 / 60, 5);
        var_int_c.fillRect(31, 284, n2 * 178 / 60, 3);
        if (bl && null != at.var_am_arr_arr_b[1][0].var_javax_microedition_lcdui_Image_b) {
            this.var_at_b.b(this.var_at_b.var_aj_b, 0, 30 + n2 * 176 / 60, 292, 5);
        }
    }

    private void aw() {
        if (this.var_javax_microedition_lcdui_Image_arr_e != null) {
            return;
        }
        ad.ad_b();
        this.var_javax_microedition_lcdui_Image_arr_e = ad.b(2, "data/brow/i");
    }

    /*
     * Unable to fully structure code
     */
    public final void i(int var1_1) {
        ah.ah_b();
        ah.b(this.var_javax_microedition_lcdui_Image_arr_e[0], (int)this.O, 320, 36);
        ah.ah_b();
        ah.b(this.var_javax_microedition_lcdui_Image_arr_e[1], 240 - this.O, 320, 40);
        if (var1_1 != 0) ** GOTO lbl-1000
        ad.ad_b();
        if (!ad.var_boolean_b && this.var_byte_k == 0) {
            v0 = 1;
        } else lbl-1000:
        // 2 sources

        {
            v0 = 0;
        }
        var1_1 = v0;
        ad.ad_b();
        this.O = (byte)ad.b(this.O, var1_1 != 0 ? 0 : -124, var1_1 != 0 ? 4 : 10, false);
    }

    static {
        var_int_a = 1;
    }
}

