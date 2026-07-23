/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Image;

public final class au
implements ao {
    private ak var_ak_b;
    private byte[][] var_byte_arr_arr_b = new byte[4][3];
    private byte[] var_byte_arr_b = new byte[]{0, 0, 0, -1};
    private byte var_byte_b;
    private byte var_byte_c;
    private byte a;
    private byte e;
    private byte d;
    private byte h;
    private am[] var_am_arr_b;
    private Image var_javax_microedition_lcdui_Image_b;
    private short var_short_b;
    private short[][] var_short_arr_arr_b = new short[10][3];
    private short[] var_short_arr_b = new short[4];
    private short[] var_short_arr_c = new short[]{100, 120, 300, 350, 1000, 1200};
    private short[][] var_short_arr_arr_c = new short[][]{{450, 3, 8}, {390, 4, 9}, {270, 7, 6}, {210, 6, 10}};

    public au(ak ak2) {
        this.var_ak_b = ak2;
    }

    private void a() {
        this.var_am_arr_b = null;
        this.var_byte_arr_b = null;
        this.var_short_arr_c = null;
        this.var_byte_arr_arr_b = null;
        this.var_short_arr_b = null;
        this.var_javax_microedition_lcdui_Image_b = null;
        this.var_short_arr_arr_b = null;
        this.var_short_arr_arr_c = null;
    }

    private void b(int n2, int n3, int n4, int n5) {
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.b("Quy t\u1eafc tr\u00f2 ch\u01a1i", 120, 22, 33, 3, 1);
        ah.ah_b().a(7, 82, 22, 40, 0);
        ah.ah_b().a(7, 158, 22, 36, 4);
        ah.ah_b();
        ah.e(9, 32, 222, 200, 4);
        ah.ah_b();
        ah.e(10, 237, 220, 51, 4);
        ah.ah_b().b((StringBuffer[])this.var_ak_b.var_int_c, 12, 37, 17, 0, 0);
        ah.ah_b();
        ah.b("Xin m\u1eddi l\u1ef1a ch\u1ecdn gi\u00e1 tr\u1ecb c\u01b0\u1ee3c: ", 19, 239, 0, 0, 0);
        for (n2 = 0; n2 < this.a; n2 = (int)((byte)(n2 + 1))) {
            ah.ah_b();
            ah.e(33 + n2 * 67, 264, 38, 21, 1);
            ah.ah_b();
            ah.b(this.var_ak_b.var_byte_a[n2].toString(), 35 + n2 * 67, 264, 0, 3, 0);
        }
        ah.ah_b();
        ah.c(33 + this.var_byte_b * 67, 264, 38, 21);
        ah.ah_b().b(120, 273, 110, true, true);
        this.var_ak_b.void_b(120, 320, 3, false);
        ah.ah_b().b(true, true);
    }

    private void b(int n2, int n3, int n4) {
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.e(10, 15, 220, 270, 4);
        ah.ah_b();
        ah.b("Xin m\u1eddi l\u1ef1a ch\u1ecdn S\u1ee7ng V\u1eadt \u0111\u1eb7t c\u01b0\u1ee3c: ", 19, 20, 0, 0, 0);
        for (n2 = 0; n2 < this.a; n2 = (int)((byte)(n2 + 1))) {
            ah.ah_b();
            ah.e(19 + n2 * 52, 45, 44, 76, 1);
            ah.ah_b().b(this.var_am_arr_b[0], 0, 19 + n2 * 52 + 22, 119, this.var_byte_arr_arr_b[n2], 0, this.var_byte_c == 1 ? this.var_byte_b == n2 : false);
            ah.ah_b().c("" + (n2 + 1), 19 + n2 * 52 + 27, 67, 20, 2);
        }
        if (this.var_byte_c == 1) {
            ah.ah_b();
            ah.c(19 + this.var_byte_b * 52, 45, 44, 76);
            ah.ah_b().b(120, 84, 118, true, true);
        }
        ah.ah_b();
        ah.b("\u0110\u1ed9 h\u01b0ng ph\u1ea5n: ", 19, 124, 0, 0, 0);
        ak.c(6, 2, 76, 130);
        ah.ah_b().b((StringBuffer[])this.var_ak_b.var_int_c, 19, 150, 20, 0, 0);
        n4 = 155 + ((int)this.var_ak_b.var_int_c).length * 20;
        ah.ah_b();
        ah.b("Xin m\u1eddi ch\u1ecdn \u0111\u1ea1o c\u1ee5: ", 19, n4 + 15, 0, 0, 0);
        n4 = n4 + 20 + 3;
        for (n2 = 0; n2 < this.a; n2 = (int)((byte)(n2 + 1))) {
            ah.ah_b();
            ah.e(19 + n2 * 52, n4 + 15, 44, 34, 1);
            this.var_ak_b.void_b(12, 19 + n2 * 52 + 5, n4 + 15 + 10, 0);
            ah.ah_b();
            ah.b("x" + n2, 19 + n2 * 52 + 21, n4 + 15 + 8, 0, 3, 1);
        }
        if (this.var_byte_c == 2) {
            ah.ah_b();
            ah.c(19 + this.var_byte_b * 52, n4 + 15, 44, 34);
            ah.ah_b().b(120, n4 + 15 + 14, 118, true, true);
        }
        this.var_ak_b.void_b(120, 320, 3, false);
        ah.ah_b().b(true, this.var_byte_c != 1);
    }

    private void e() {
        int n2;
        ah.ah_b();
        ah.b(5423359, 0, 0, 240, 320);
        au au2 = this;
        for (n2 = 0; n2 < au2.var_short_arr_arr_b.length; n2 = (int)((byte)(n2 + 1))) {
            ah.ah_b();
            ah.b(au2.var_javax_microedition_lcdui_Image_b, (int)au2.var_short_arr_arr_b[n2][0], au2.var_short_arr_arr_b[n2][1] - au2.var_short_b, 0);
        }
        for (n2 = 0; n2 < au2.var_short_arr_arr_b.length; n2 = (int)((byte)(n2 + 1))) {
            short s2 = au2.var_short_arr_arr_b[n2][1];
            short s3 = au2.var_short_arr_arr_b[n2][0];
            au au3 = au2;
            if (s3 < -40 || s2 - au3.var_short_b > 340) {
                au2.c(n2);
                continue;
            }
            short[] sArray = au2.var_short_arr_arr_b[n2];
            sArray[0] = (short)(sArray[0] - au2.var_short_arr_arr_b[n2][2]);
        }
        au2 = this;
        ah.ah_b().b(au2.var_am_arr_b[1], 0, 0, 40 - au2.var_short_b, 0, 0);
        for (n2 = 0; n2 < 5; n2 = (int)((byte)(n2 + 1))) {
            ah.ah_b().b(au2.var_am_arr_b[1], 1, 35 + n2 * 35, 44 - au2.var_short_b, 0, 0);
        }
        ah.ah_b().b(au2.var_am_arr_b[1], 0, 240, 40 - au2.var_short_b, 1, 0);
        for (byte by = 0; by < this.a; by = (byte)(by + 1)) {
            ah.ah_b().c("" + (by + 1), 19 + by * 52 + 22, 20 - this.var_short_b, 1, 2);
            ah.ah_b().b(this.var_am_arr_b[0], 1, 19 + by * 52 + 22, this.var_short_arr_b[by] - this.var_short_b, this.var_byte_arr_arr_b[by], 0, true);
        }
        if (this.var_byte_c == 3 && this.e != 0) {
            ah.ah_b().c("" + this.e / 20, 115, 160, 0, 2);
        }
    }

    private void d() {
        int n2;
        if (this.h >= this.var_short_arr_arr_c.length) {
            return;
        }
        for (n2 = 0; n2 < 4 && this.var_short_arr_b[n2] > this.var_short_arr_arr_c[this.h][0]; n2 = (int)((byte)(n2 + 1))) {
        }
        if (n2 >= 4) {
            return;
        }
        for (n2 = 0; n2 < 4; n2 = (int)((byte)(n2 + 1))) {
            byte[] byArray = this.var_byte_arr_arr_b[n2];
            ad.ad_b();
            byArray[2] = (byte)(ad.c(this.var_short_arr_arr_c[this.h][1]) + this.var_short_arr_arr_c[this.h][1]);
        }
        this.h = (byte)(this.h + 1);
    }

    public final void void_b(int n2, int n3) {
        this.d = (byte)n3;
        this.var_am_arr_b = new am[3];
        this.var_am_arr_b[0] = ad.ad_b().b("data/npc0/67", true);
        this.var_am_arr_b[1] = ad.ad_b().b("data/brow/m1", true);
        ad.ad_b();
        this.var_javax_microedition_lcdui_Image_b = ad.javax_microedition_lcdui_Image_b("data/cloud");
        this.b(n2);
    }

    private void b(int n2) {
        if (n2 <= 0) {
            this.var_byte_b = 0;
            this.var_byte_c = 0;
            this.a = (byte)3;
            this.var_ak_b.b("Vi\u1ec7c l\u1ef1a ch\u1ecdn c\u1ee7a b\u1ea1n s\u1ebd gi\u00fap b\u1ea1n c\u00f3 c\u01a1 h\u1ed9i c\u00f3 \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt m\u1ea1nh c\u00f9ng gi\u00e1 tr\u1ecb c\u01b0\u1ee3c. C\u00e0ng nhi\u1ec1u chi\u1ebfn th\u1eafng v\u1ec1 sau ph\u1ea7n th\u01b0\u1edfng c\u00e0ng nhi\u1ec1u!#nCh\u00fa th\u00edch 1: \u0110\u1ea7u t\u01b0 100 kim, sau chi\u1ebfn th\u1eafng s\u1ebd \u0111\u01b0\u1ee3c 120 kim.#nCh\u00fa th\u00edch 2: \u0110\u1ea7u t\u01b0 300 kim, sau chi\u1ebfn th\u1eafng s\u1ebd \u0111\u01b0\u1ee3c 350 kim.#nCh\u00fa th\u00edch 3: \u0110\u1ea7u t\u01b0 1000 kim, sau chi\u1ebfn th\u1eafng s\u1ebd \u0111\u01b0\u1ee3c 1200 kim.", 200, 0);
            this.var_ak_b.b("L\u01b0u \u00fd 1#nL\u01b0u \u00fd2#nL\u01b0u \u00fd 3", 200, 1);
            return;
        }
        if (n2 == 1) {
            this.var_byte_arr_b[0] = this.var_byte_b;
            this.var_byte_b = 0;
            this.var_byte_c = 1;
            this.a = (byte)4;
            this.var_ak_b.b("M\u1ed7i m\u1ed9t l\u1ea7n cung c\u1ea5p h\u01b0ng ph\u1ea5n m\u1ea5t 10 kim, l\u00e0 m\u1ed9t c\u00e1ch \u0111\u1ec3 gia t\u0103ng \u0111\u1ed9 h\u01b0ng ph\u1ea5n.", 200, 0);
            return;
        }
        if (n2 == 2) {
            this.var_byte_arr_b[1] = this.var_byte_b;
            this.var_byte_b = 0;
            this.var_byte_c = (byte)2;
            return;
        }
        if (n2 == 3) {
            this.var_byte_arr_b[2] = this.var_byte_b;
            this.var_byte_b = 0;
            this.var_byte_c = (byte)3;
            this.var_short_b = (short)130;
            this.h = 0;
            this.var_byte_arr_b[3] = -1;
            this.e = (byte)70;
            for (n2 = 0; n2 < this.a; n2 = (int)((byte)(n2 + 1))) {
                this.var_short_arr_b[n2] = 450;
            }
            for (n2 = 0; n2 < this.var_short_arr_arr_b.length; n2 = (int)((byte)(n2 + 1))) {
                this.c(n2);
            }
        }
    }

    public final boolean boolean_b() {
        ad.ad_b();
        if (ad.boolean_b()) {
            return false;
        }
        if (this.var_byte_c == 0) {
            ad.ad_b();
            if (ad.e()) {
                ad.ad_b();
                this.var_byte_b = ad.byte_b((int)this.var_byte_b, 0, this.a - 1);
            } else {
                ad.ad_b();
                if (ad.g() && this.var_ak_b.boolean_b((int)this.var_short_arr_c[this.var_byte_b << 1], true)) {
                    this.b(1);
                } else {
                    ad.ad_b();
                    if (ad.i()) {
                        au au2 = this;
                        this.var_am_arr_b = null;
                        au2.var_byte_arr_b = null;
                        au2.var_short_arr_c = null;
                        au2.var_byte_arr_arr_b = null;
                        au2.var_short_arr_b = null;
                        au2.var_javax_microedition_lcdui_Image_b = null;
                        au2.var_short_arr_arr_b = null;
                        au2.var_short_arr_arr_c = null;
                        return true;
                    }
                }
            }
        } else if (this.var_byte_c == 1) {
            ad.ad_b();
            if (ad.e()) {
                ad.ad_b();
                this.var_byte_b = ad.byte_b((int)this.var_byte_b, 0, this.a - 1);
            } else {
                ad.ad_b();
                if (ad.g()) {
                    this.b(2);
                }
            }
        } else if (this.var_byte_c == 2) {
            ad.ad_b();
            if (ad.e()) {
                ad.ad_b();
                this.var_byte_b = ad.byte_b((int)this.var_byte_b, 0, this.a - 1);
            } else {
                ad.ad_b();
                if (ad.g() && this.var_ak_b.boolean_b(this.var_byte_b * 10, true)) {
                    this.b(3);
                } else {
                    ad.ad_b();
                    if (ad.i()) {
                        this.var_byte_b = this.var_byte_arr_b[1];
                        this.var_byte_c = 1;
                    }
                }
            }
        }
        return false;
    }

    public final void void_b() {
        if (this.var_byte_c == 0) {
            byte by;
            int n2 = 17;
            int by2 = 200;
            int n3 = 5;
            n3 = 10;
            au au2 = this;
            ah.ah_b();
            ah.c();
            ah.ah_b();
            ah.b("Quy t\u1eafc tr\u00f2 ch\u01a1i", 120, 22, 33, 3, 1);
            ah.ah_b().a(7, 82, 22, 40, 0);
            ah.ah_b().a(7, 158, 22, 36, 4);
            ah.ah_b();
            ah.e(9, 32, 222, 200, 4);
            ah.ah_b();
            ah.e(10, 237, 220, 51, 4);
            ah.ah_b().b((StringBuffer[])au2.var_ak_b.var_int_c, 12, 37, 17, 0, 0);
            ah.ah_b();
            ah.b("Xin m\u1eddi l\u1ef1a ch\u1ecdn gi\u00e1 tr\u1ecb c\u01b0\u1ee3c: ", 19, 239, 0, 0, 0);
            boolean n4 = false;
            while (by < au2.a) {
                ah.ah_b();
                ah.e(33 + by * 67, 264, 38, 21, 1);
                ah.ah_b();
                ah.b(au2.var_ak_b.var_byte_a[by].toString(), 35 + by * 67, 264, 0, 3, 0);
                by = (byte)(by + true);
            }
            ah.ah_b();
            ah.c(33 + au2.var_byte_b * 67, 264, 38, 21);
            ah.ah_b().b(120, 273, 110, true, true);
            au2.var_ak_b.void_b(120, 320, 3, false);
            ah.ah_b().b(true, true);
            return;
        }
        if (this.var_byte_c == 1 || this.var_byte_c == 2) {
            byte by;
            int n4 = 76;
            int n5 = 15;
            n5 = 10;
            au au3 = this;
            ah.ah_b();
            ah.c();
            ah.ah_b();
            ah.e(10, 15, 220, 270, 4);
            ah.ah_b();
            ah.b("Xin m\u1eddi l\u1ef1a ch\u1ecdn S\u1ee7ng V\u1eadt \u0111\u1eb7t c\u01b0\u1ee3c: ", 19, 20, 0, 0, 0);
            for (by = 0; by < au3.a; by = (byte)(by + 1)) {
                ah.ah_b();
                ah.e(19 + by * 52, 45, 44, 76, 1);
                ah.ah_b().b(au3.var_am_arr_b[0], 0, 19 + by * 52 + 22, 119, au3.var_byte_arr_arr_b[by], 0, au3.var_byte_c == 1 ? au3.var_byte_b == by : false);
                ah.ah_b().c("" + (by + 1), 19 + by * 52 + 27, 67, 20, 2);
            }
            if (au3.var_byte_c == 1) {
                ah.ah_b();
                ah.c(19 + au3.var_byte_b * 52, 45, 44, 76);
                ah.ah_b().b(120, 84, 118, true, true);
            }
            ah.ah_b();
            ah.b("\u0110\u1ed9 h\u01b0ng ph\u1ea5n: ", 19, 124, 0, 0, 0);
            ak.c(6, 2, 76, 130);
            ah.ah_b().b((StringBuffer[])au3.var_ak_b.var_int_c, 19, 150, 20, 0, 0);
            int n6 = 155 + ((int)au3.var_ak_b.var_int_c).length * 20;
            ah.ah_b();
            ah.b("Xin m\u1eddi ch\u1ecdn \u0111\u1ea1o c\u1ee5: ", 19, n6 + 15, 0, 0, 0);
            int n7 = n6 + 20 + 3;
            for (by = 0; by < au3.a; by = (byte)(by + 1)) {
                ah.ah_b();
                ah.e(19 + by * 52, n7 + 15, 44, 34, 1);
                au3.var_ak_b.void_b(12, 19 + by * 52 + 5, n7 + 15 + 10, 0);
                ah.ah_b();
                ah.b("x" + by, 19 + by * 52 + 21, n7 + 15 + 8, 0, 3, 1);
            }
            if (au3.var_byte_c == 2) {
                ah.ah_b();
                ah.c(19 + au3.var_byte_b * 52, n7 + 15, 44, 34);
                ah.ah_b().b(120, n7 + 15 + 14, 118, true, true);
            }
            au3.var_ak_b.void_b(120, 320, 3, false);
            ah.ah_b().b(true, au3.var_byte_c != 1);
            return;
        }
        this.e();
    }

    public final void c() {
        if (this.var_byte_c == 3) {
            if (this.e == 0) {
                int n2;
                au au2 = this;
                if (au2.h < au2.var_short_arr_arr_c.length) {
                    for (n2 = 0; n2 < 4 && au2.var_short_arr_b[n2] > au2.var_short_arr_arr_c[au2.h][0]; n2 = (int)((byte)(n2 + 1))) {
                    }
                    if (n2 < 4) {
                        for (n2 = 0; n2 < 4; n2 = (int)((byte)(n2 + 1))) {
                            byte[] byArray = au2.var_byte_arr_arr_b[n2];
                            ad.ad_b();
                            byArray[2] = (byte)(ad.c(au2.var_short_arr_arr_c[au2.h][1]) + au2.var_short_arr_arr_c[au2.h][1]);
                        }
                        au2.h = (byte)(au2.h + 1);
                    }
                }
                if (this.var_byte_arr_b[3] != -1) {
                    this.e = (byte)5;
                    this.var_byte_c = (byte)4;
                    return;
                }
                n2 = -1;
                for (int n3 = 0; n3 < 4; n3 = (int)((byte)(n3 + 1))) {
                    int n4 = n3;
                    this.var_short_arr_b[n4] = (short)(this.var_short_arr_b[n4] - this.var_byte_arr_arr_b[n3][2]);
                    if (this.var_short_arr_b[n3] - this.var_short_b < 160) {
                        n2 = n3;
                    }
                    if (this.var_short_arr_b[n3] >= 70 || this.var_byte_arr_b[3] != -1) continue;
                    this.var_byte_arr_b[3] = n3;
                }
                if (n2 != -1) {
                    this.var_short_b = (short)(this.var_short_b - this.var_byte_arr_arr_b[n2][2]);
                }
                if (this.var_short_b < 0) {
                    this.var_short_b = 0;
                }
                return;
            }
            this.e = (byte)(this.e - 1);
            return;
        }
        if (this.var_byte_c == 4) {
            if (this.e == 3) {
                if (this.var_byte_arr_b[3] == this.var_byte_arr_b[1]) {
                    this.var_ak_b.var_int_b += this.var_short_arr_c[(this.var_byte_arr_b[0] << 1) + 1];
                    this.var_ak_b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c: " + this.var_short_arr_c[(this.var_byte_arr_b[0] << 1) + 1] + "Kim", 0);
                    this.var_ak_b.var_byte_arr_arr_l[4] = (byte[])((byte)(this.var_ak_b.var_byte_arr_arr_l[4] | 1 << this.d));
                } else {
                    this.var_ak_b.b("R\u1ea5t ti\u1ebfc, kh\u00f4ng \u0111\u00fang.", 0);
                }
            }
            if (this.e > 0) {
                this.e = (byte)(this.e - 1);
                return;
            }
            if (this.e == 0 && this.var_ak_b.var_byte_k == 0) {
                this.b(0);
            }
        }
    }

    private void c(int n2) {
        short[] sArray = this.var_short_arr_arr_b[n2];
        ad.ad_b();
        sArray[0] = (short)(240 + ad.c(120));
        short[] sArray2 = this.var_short_arr_arr_b[n2];
        ad.ad_b();
        sArray2[1] = (short)(this.var_short_b - 80 + n2 * (ad.c(25) + 55));
        short[] sArray3 = this.var_short_arr_arr_b[n2];
        ad.ad_b();
        sArray3[2] = (short)(ad.c(5) + 2);
    }

    private void h() {
        int n2;
        for (n2 = 0; n2 < this.var_short_arr_arr_b.length; n2 = (int)((byte)(n2 + 1))) {
            ah.ah_b();
            ah.b(this.var_javax_microedition_lcdui_Image_b, (int)this.var_short_arr_arr_b[n2][0], this.var_short_arr_arr_b[n2][1] - this.var_short_b, 0);
        }
        for (n2 = 0; n2 < this.var_short_arr_arr_b.length; n2 = (int)((byte)(n2 + 1))) {
            short s2 = this.var_short_arr_arr_b[n2][1];
            short s3 = this.var_short_arr_arr_b[n2][0];
            au au2 = this;
            if (s3 < -40 || s2 - au2.var_short_b > 340) {
                this.c(n2);
                continue;
            }
            short[] sArray = this.var_short_arr_arr_b[n2];
            sArray[0] = (short)(sArray[0] - this.var_short_arr_arr_b[n2][2]);
        }
    }

    private boolean boolean_b(int n2, int n3) {
        return n2 < -40 || n3 - this.var_short_b > 340;
    }

    private void g() {
        ah.ah_b().b(this.var_am_arr_b[1], 0, 0, 40 - this.var_short_b, 0, 0);
        for (int n2 = 0; n2 < 5; n2 = (int)((byte)(n2 + 1))) {
            ah.ah_b().b(this.var_am_arr_b[1], 1, 35 + n2 * 35, 44 - this.var_short_b, 0, 0);
        }
        ah.ah_b().b(this.var_am_arr_b[1], 0, 240, 40 - this.var_short_b, 1, 0);
    }
}

