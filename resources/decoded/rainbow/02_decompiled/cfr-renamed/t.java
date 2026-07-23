/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Font
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class t
implements ao {
    private ak var_ak_b;
    private Image[] var_javax_microedition_lcdui_Image_arr_b;
    private am[] var_am_arr_b;
    private int var_int_b;
    private int[][] var_int_arr_arr_b;
    private byte var_byte_b;
    private byte c;
    private byte a;
    private byte e;
    private byte d;
    private byte h;
    private byte g;
    private byte f;
    private byte i;
    private byte[] var_byte_arr_b;
    private byte j;
    private byte k;
    private byte[][] var_byte_arr_arr_b;

    public t(ak ak2) {
        this.var_byte_b = 0;
        this.a = 0;
        this.e = 0;
        this.d = 0;
        this.h = 0;
        this.g = (byte)20;
        this.f = 0;
        this.var_ak_b = ak2;
    }

    public final void void_b() {
        ah.ah_b();
        ah.c();
        ah.ah_b().a(7, 44, 22, 40, 0);
        ah.ah_b().a(7, 196, 22, 36, 4);
        if (this.a == 0) {
            t t2 = this;
            ah.ah_b();
            ah.b("Quy t\u1eafc tr\u00f2 ch\u01a1i", 120, 4, 17, 3, 1);
            int n2 = 24 * t2.var_ak_b.var_byte_d;
            ah.ah_b();
            ah.e(2, 28, 236, n2, 4);
            ah.ah_b().b((StringBuffer[])t2.var_ak_b.var_int_c, 21, 32, 24, 0, 0);
            int n3 = 28 + (n2 + 5);
            n2 = 320 - n3 - 20;
            ah.ah_b();
            ah.e(2, n3, 236, n2, 4);
            ah.ah_b().b(true, true);
            ah.ah_b();
            ah.b("Ph\u00ed c\u1ea7n \u0111\u1ec3 tham gia: " + t2.var_int_b + "Kim", 21, n3 + 4, 0, 0, 0);
            t2.var_ak_b.void_b(120, 320, 3, false);
            return;
        }
        this.a();
    }

    private void a() {
        ah.ah_b();
        ah.e(2, 27, 236, 316, 4);
        ah.ah_b();
        ah.e(4, 51, 232, 275, 4);
        ah.ah_b();
        ah.b("S\u1ed1 l\u1ea7n th\u1eafng: " + this.d + "/" + this.var_byte_arr_arr_b[3][this.k], 120, 4, 17, 3, 1);
        if (this.a == 1) {
            int n2;
            ah.var_javax_microedition_lcdui_Graphics_b.setClip(0, 65, 240, 100);
            for (n2 = 0; n2 < this.var_int_arr_arr_b.length; ++n2) {
                if (this.var_int_arr_arr_b[n2][1] == -1) continue;
                this.b(n2, this.var_int_arr_arr_b[n2][1], this.var_int_arr_arr_b[n2][2], 165 + (this.c < 40 ? (byte)0 : this.var_byte_b));
            }
            ah.var_javax_microedition_lcdui_Graphics_b.setClip(0, 0, 240, 320);
            if (this.c >= 20) {
                for (n2 = 0; n2 < this.var_int_arr_arr_b.length; ++n2) {
                    ah.ah_b();
                    ah.b(this.var_javax_microedition_lcdui_Image_arr_b[1], this.var_int_arr_arr_b[n2][2], this.var_int_arr_arr_b[n2][3], 17);
                }
            }
        } else if (this.a == 2) {
            for (int i2 = 0; i2 < this.var_int_arr_arr_b.length; ++i2) {
                ah.ah_b();
                ah.b(this.var_javax_microedition_lcdui_Image_arr_b[1], this.var_int_arr_arr_b[i2][2], this.var_int_arr_arr_b[i2][3], 17);
            }
        } else {
            if (this.a == 3) {
                for (int i3 = 0; i3 < this.var_int_arr_arr_b.length; ++i3) {
                    ah.ah_b();
                    ah.b(this.var_javax_microedition_lcdui_Image_arr_b[1], this.var_int_arr_arr_b[i3][2], this.var_int_arr_arr_b[i3][3], 17);
                }
                ah.ah_b();
                ah.b(this.var_javax_microedition_lcdui_Image_arr_b[0], this.var_int_arr_arr_b[this.var_ak_b.u][2] - 1, this.var_int_arr_arr_b[this.var_ak_b.u][3] - (this.c % 4 <= 2 ? 5 : 0), 17);
                this.c = (byte)(this.c + 1);
                if (this.c > 20) {
                    this.c = 0;
                }
                this.b(this.var_int_arr_arr_b[this.var_ak_b.v][0], this.var_int_arr_arr_b[this.var_ak_b.v][1], this.var_byte_arr_arr_b[0][1] + 100, 135);
                ah.ah_b();
                ah.b("Xin cho bi\u1ebft" + this.var_ak_b.java_lang_String_e(this.var_int_arr_arr_b[this.var_ak_b.v][1]) + "Tr\u01b0\u1eddng h\u1ee3p h\u1ed9p", 120, 252, 17, 0, 0);
                return;
            }
            if (this.a == 4) {
                this.b(this.var_int_arr_arr_b[this.var_ak_b.v][0], this.var_int_arr_arr_b[this.var_ak_b.v][1], this.var_byte_arr_arr_b[0][1] + 100, 135);
                ah.ah_b();
                ah.b(this.var_javax_microedition_lcdui_Image_arr_b[1], this.var_int_arr_arr_b[this.var_ak_b.u][2], this.var_int_arr_arr_b[this.var_ak_b.u][3], 17);
                if (this.var_int_arr_arr_b[this.var_ak_b.u][1] != -1) {
                    this.b(this.var_int_arr_arr_b[this.var_ak_b.u][0], this.var_int_arr_arr_b[this.var_ak_b.u][1], this.var_int_arr_arr_b[this.var_ak_b.u][2], this.var_int_arr_arr_b[this.var_ak_b.u][3] + 35);
                }
                if (this.i > 0) {
                    ah.ah_b();
                    ah.b("B\u1ea1n r\u1ea5t l\u1ee3i h\u1ea1i \u0111\u1ea5y!", 120, 252, 17, 0, 0);
                    return;
                }
                ah.ah_b();
                ah.b("C\u00f3 khi l\u1ea7n sau c\u00f3 th\u1ec3 l\u00e0m \u0111\u01b0\u1ee3c.", 120, 252, 17, 0, 0);
            }
        }
    }

    private void e() {
        ah.ah_b();
        ah.b("Quy t\u1eafc tr\u00f2 ch\u01a1i", 120, 4, 17, 3, 1);
        int n2 = 24 * this.var_ak_b.var_byte_d;
        ah.ah_b();
        ah.e(2, 28, 236, n2, 4);
        ah.ah_b().b((StringBuffer[])this.var_ak_b.var_int_c, 21, 32, 24, 0, 0);
        int n3 = 28 + (n2 + 5);
        n2 = 320 - n3 - 20;
        ah.ah_b();
        ah.e(2, n3, 236, n2, 4);
        ah.ah_b().b(true, true);
        ah.ah_b();
        ah.b("Ph\u00ed c\u1ea7n \u0111\u1ec3 tham gia: " + this.var_int_b + "Kim", 21, n3 + 4, 0, 0, 0);
        this.var_ak_b.void_b(120, 320, 3, false);
    }

    private void b(int n2, int n3, int n4, int n5) {
        ah.ah_b().b(this.var_am_arr_b[n2], this.var_am_arr_b[n2].c(this.var_ak_b.var_byte_arr_arr_e[n3][1] * 3, 0, 0), n4, n5, 0);
    }

    public final void c() {
        if (this.a == 1) {
            if (this.c < 20) {
                this.c = (byte)(this.c + 1);
                return;
            }
            if (this.var_int_arr_arr_b[0][3] < 150) {
                for (int n2 = 0; n2 < 3; n2 = (int)((byte)(n2 + 1))) {
                    int[] nArray = this.var_int_arr_arr_b[n2];
                    nArray[3] = nArray[3] + 25;
                }
            } else {
                this.c = (byte)(this.c + 1);
                if (this.c >= 40) {
                    if (this.var_byte_b < 40) {
                        this.var_byte_b = (byte)(this.var_byte_b + 5);
                        return;
                    }
                    this.a = (byte)2;
                    this.c = 0;
                    return;
                }
            }
        } else {
            if (this.a == 2) {
                if (this.c <= 0) {
                    if (this.h < this.g) {
                        this.c = 1;
                        this.h = (byte)(this.h + 1);
                        ad.ad_b();
                        this.var_byte_arr_b[0] = (byte)ad.c(3);
                        do {
                            ad.ad_b();
                            this.var_byte_arr_b[1] = (byte)ad.c(3);
                        } while (this.var_byte_arr_b[1] == this.var_byte_arr_b[0]);
                        if (this.var_int_arr_arr_b[this.var_byte_arr_b[1]][2] < this.var_int_arr_arr_b[this.var_byte_arr_b[0]][2]) {
                            this.e = this.var_byte_arr_b[1];
                            this.var_byte_arr_b[1] = this.var_byte_arr_b[0];
                            this.var_byte_arr_b[0] = this.e;
                        }
                        ad.ad_b();
                        this.e = (byte)(ad.a(this.var_int_arr_arr_b[this.var_byte_arr_b[1]][2] - this.var_int_arr_arr_b[this.var_byte_arr_b[0]][2]) / 2);
                        this.f = (byte)((this.e << 1) / this.var_byte_arr_arr_b[1][this.k]);
                        return;
                    }
                    this.c = 0;
                    this.a = (byte)3;
                    do {
                        ad.ad_b();
                        this.var_ak_b.v = (byte[])((byte)ad.c(this.var_int_arr_arr_b.length));
                    } while (this.var_int_arr_arr_b[this.var_ak_b.v][1] == -1);
                    return;
                }
                if (this.c > this.f) {
                    int n3;
                    this.c = 0;
                    int[] nArray = new int[4];
                    for (n3 = 0; n3 < this.var_int_arr_arr_b.length; n3 = (int)((byte)(n3 + 1))) {
                        for (int n4 = 0; n4 < this.var_int_arr_arr_b.length; n4 = (int)((byte)(n4 + 1))) {
                            if (this.var_int_arr_arr_b[n4][2] <= this.var_int_arr_arr_b[n3][2]) continue;
                            System.arraycopy(this.var_int_arr_arr_b[n3], 0, nArray, 0, nArray.length);
                            System.arraycopy(this.var_int_arr_arr_b[n4], 0, this.var_int_arr_arr_b[n3], 0, this.var_int_arr_arr_b[n4].length);
                            System.arraycopy(nArray, 0, this.var_int_arr_arr_b[n4], 0, nArray.length);
                        }
                    }
                    for (n3 = 0; n3 < 3; n3 = (int)((byte)(n3 + 1))) {
                        this.var_int_arr_arr_b[n3][2] = this.var_byte_arr_arr_b[0][n3] + 100;
                        this.var_int_arr_arr_b[n3][3] = 150;
                    }
                    return;
                }
                this.c = (byte)(this.c + 1);
                int[] nArray = this.var_int_arr_arr_b[this.var_byte_arr_b[0]];
                nArray[2] = nArray[2] + (this.e << 1) / this.f;
                int n5 = (this.e << 1) / this.f * this.c;
                int[] nArray2 = this.var_int_arr_arr_b[this.var_byte_arr_b[0]];
                ad.ad_b();
                nArray2[3] = 150 - ad.int_b(this.e * this.e - (n5 - this.e) * (n5 - this.e));
                int[] nArray3 = this.var_int_arr_arr_b[this.var_byte_arr_b[1]];
                nArray3[2] = nArray3[2] - (this.e << 1) / this.f;
                int[] nArray4 = this.var_int_arr_arr_b[this.var_byte_arr_b[1]];
                ad.ad_b();
                nArray4[3] = 150 + ad.int_b(this.e * this.e - (n5 - this.e) * (n5 - this.e));
                return;
            }
            if (this.a == 4 && (this.var_ak_b.u == 2 && this.var_int_arr_arr_b[this.var_ak_b.u][2] > this.var_byte_arr_arr_b[0][1] + 100 || this.var_ak_b.u == false && this.var_int_arr_arr_b[this.var_ak_b.u][2] < this.var_byte_arr_arr_b[0][1] + 100)) {
                int[] nArray = this.var_int_arr_arr_b[this.var_ak_b.u];
                nArray[2] = nArray[2] + (this.var_byte_arr_arr_b[0][1] - this.var_byte_arr_arr_b[0][this.var_ak_b.u]) / 7;
            }
        }
    }

    public final boolean boolean_b() {
        ad.ad_b();
        if (ad.boolean_b()) {
            return false;
        }
        if (this.a == 0) {
            ad.ad_b();
            if (ad.boolean_c()) {
                ad.ad_b();
                this.var_ak_b.v = (byte[])ad.byte_b((int)this.var_ak_b.v, 0, (int)this.j);
                if (this.var_ak_b.v < 0) {
                    this.var_ak_b.v = (byte[])false;
                }
            } else {
                ad.ad_b();
                if (ad.i()) {
                    ad.ad_b();
                    ad.void_c();
                    this.var_ak_b.var_int_c = (int)null;
                    this.var_javax_microedition_lcdui_Image_arr_b = null;
                    this.var_byte_arr_b = null;
                    this.var_byte_arr_arr_b = null;
                    this.var_int_arr_arr_b = null;
                    this.var_am_arr_b = null;
                    return true;
                }
                ad.ad_b();
                if (ad.g()) {
                    ad.ad_b();
                    ad.void_c();
                    if (this.var_ak_b.boolean_b(this.var_int_b, true)) {
                        this.void_b(1, this.k);
                    }
                }
            }
        } else if (this.a == 3) {
            ad.ad_b();
            if (ad.e()) {
                ad.ad_b();
                this.var_ak_b.u = (byte[])ad.byte_b((int)this.var_ak_b.u, 0, this.var_int_arr_arr_b.length - 1);
            } else {
                ad.ad_b();
                if (ad.g()) {
                    ad.ad_b();
                    ad.void_c();
                    this.a = (byte)4;
                    this.i = (byte)(this.var_ak_b.u == this.var_ak_b.v ? 1 : -1);
                }
            }
        } else if (this.a == 4) {
            ad.ad_b();
            if (ad.g()) {
                ad.ad_b();
                ad.void_c();
                if (this.i == 1) {
                    int n2;
                    t t2 = this;
                    t2.d = (byte)(t2.d + 1);
                    if (t2.d >= t2.var_byte_arr_arr_b[3][t2.k]) {
                        int n3 = t2.var_int_b + t2.k * t2.k * 150 + (2 - t2.k) * 25;
                        t2.var_ak_b.var_int_b += n3;
                        t2.var_ak_b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c kim ti\u1ec1n: " + n3, 0);
                        t2.var_ak_b.var_byte_arr_arr_l[10] = (byte[])((byte)(t2.var_ak_b.var_byte_arr_arr_l[10] | 1 << t2.k));
                        if (t2.k == 2 && t2.var_ak_b.var_byte_arr_arr_l[11] < 3) {
                            t2.var_ak_b.var_byte_arr_arr_l[11] = (byte[])((byte)(t2.var_ak_b.var_byte_arr_arr_l[11] + true));
                        }
                        n2 = 2;
                    } else {
                        n2 = 3;
                    }
                    this.i = (byte)n2;
                    if (this.i == 3) {
                        this.void_b(1, this.k);
                    }
                } else if (this.i == -1 || this.i == 2 && this.var_ak_b.var_byte_k == 0) {
                    if (this.i == 2 && this.var_ak_b.var_byte_arr_arr_l[11] == 3) {
                        this.var_ak_b.var_byte_arr_arr_l[11] = (byte[])4;
                        this.var_ak_b.byte_b(83, 25, 0, -1);
                    } else if (this.i == -1 && this.var_ak_b.var_byte_arr_arr_l[11] < 3) {
                        this.var_ak_b.var_byte_arr_arr_l[11] = (byte[])false;
                    }
                    this.void_b(0, this.k);
                }
            }
        }
        return false;
    }

    private byte byte_b() {
        this.d = (byte)(this.d + 1);
        if (this.d >= this.var_byte_arr_arr_b[3][this.k]) {
            int n2 = this.var_int_b + this.k * this.k * 150 + (2 - this.k) * 25;
            this.var_ak_b.var_int_b += n2;
            this.var_ak_b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c kim ti\u1ec1n: " + n2, 0);
            this.var_ak_b.var_byte_arr_arr_l[10] = (byte[])((byte)(this.var_ak_b.var_byte_arr_arr_l[10] | 1 << this.k));
            if (this.k == 2 && this.var_ak_b.var_byte_arr_arr_l[11] < 3) {
                this.var_ak_b.var_byte_arr_arr_l[11] = (byte[])((byte)(this.var_ak_b.var_byte_arr_arr_l[11] + true));
            }
            return 2;
        }
        return 3;
    }

    public final void void_b(int n2, int n3) {
        byte by;
        int n4;
        this.var_ak_b.b(ak.java_lang_String_b("data/gamed.d"), 183, 0);
        this.k = (byte)n3;
        this.var_javax_microedition_lcdui_Image_arr_b = new Image[2];
        ad.ad_b();
        this.var_javax_microedition_lcdui_Image_arr_b[0] = ad.javax_microedition_lcdui_Image_b("data/brow/m2");
        ad.ad_b();
        this.var_javax_microedition_lcdui_Image_arr_b[1] = ad.javax_microedition_lcdui_Image_b("data/brow/m3");
        this.var_byte_arr_b = new byte[2];
        this.var_byte_arr_arr_b = new byte[][]{{-60, 17, 90}, {8, 13, 20, 30}, {1, 2, 3, 3}, {6, 4, 2, 2}, {83, 30, 55}};
        this.var_int_arr_arr_b = new int[3][4];
        this.var_am_arr_b = new am[3];
        n3 = n2;
        t t2 = this;
        if (n3 <= 0) {
            t2.i = 0;
            t2.var_ak_b.v = (byte[])false;
            t2.var_ak_b.u = (byte[])false;
            t2.d = 0;
            t2.a = 0;
            t2.var_ak_b.var_byte_j = 0;
            t2.var_ak_b.var_byte_d = (byte)9;
            t2.var_int_b = t2.k * 200 + 200;
            t2.j = (byte)(((int)t2.var_ak_b.var_int_c).length - t2.var_ak_b.var_byte_d);
            return;
        }
        t2.c = 0;
        t2.a = 1;
        t t3 = t2;
        byte[] byArray = new byte[3];
        for (n4 = 0; n4 < byArray.length; n4 = (int)((byte)(n4 + 1))) {
            byArray[n4] = -1;
        }
        for (n4 = 0; n4 < t3.var_byte_arr_arr_b[2][t3.k]; n4 = (int)((byte)(n4 + 1))) {
            byte[] byArray2 = t3.var_byte_arr_arr_b[4];
            ad.ad_b();
            byArray[n4] = byArray2[ad.c(t3.var_byte_arr_arr_b[4].length)];
            by = 0;
            while (by < n4) {
                if (byArray[by] == byArray[n4]) {
                    byte[] byArray3 = t3.var_byte_arr_arr_b[4];
                    ad.ad_b();
                    byArray[n4] = byArray3[ad.c(t3.var_byte_arr_arr_b[4].length)];
                    by = 0;
                    continue;
                }
                by = (byte)(by + 1);
            }
        }
        ad.ad_b();
        n4 = (byte)ad.c(2);
        by = byArray[byArray.length - 1];
        byArray[byArray.length - 1] = byArray[n4];
        byArray[n4] = by;
        for (n4 = 0; n4 < 3; n4 = (int)((byte)(n4 + 1))) {
            if (byArray[n4] == -1) continue;
            by = t3.var_ak_b.var_byte_arr_arr_e[byArray[n4]][0];
            t3.var_am_arr_b[n4] = ad.ad_b().b("data/npc2/" + by, t3.var_ak_b.boolean_b((int)by));
        }
        byte[] byArray4 = byArray;
        for (int n5 = 0; n5 < 3; n5 = (int)((byte)(n5 + 1))) {
            t2.var_int_arr_arr_b[n5][0] = n5;
            t2.var_int_arr_arr_b[n5][1] = byArray4[n5];
            t2.var_int_arr_arr_b[n5][2] = t2.var_byte_arr_arr_b[0][n5] + 100;
            t2.var_int_arr_arr_b[n5][3] = 0;
        }
        ad.ad_b();
        t2.g = (byte)(ad.c(2 + t2.k) + 2 + t2.k);
        t2.h = 0;
        t2.var_byte_b = 0;
    }

    private void b(int n2) {
        byte by;
        int n3;
        t t2;
        if (n2 <= 0) {
            this.i = 0;
            this.var_ak_b.v = (byte[])false;
            this.var_ak_b.u = (byte[])false;
            this.d = 0;
            this.a = 0;
            this.var_ak_b.var_byte_j = 0;
            this.var_ak_b.var_byte_d = (byte)9;
            this.var_int_b = this.k * 200 + 200;
            this.j = (byte)(((int)this.var_ak_b.var_int_c).length - this.var_ak_b.var_byte_d);
            return;
        }
        this.c = 0;
        this.a = 1;
        t t3 = t2 = this;
        byte[] byArray = new byte[3];
        for (n3 = 0; n3 < byArray.length; n3 = (int)((byte)(n3 + 1))) {
            byArray[n3] = -1;
        }
        for (n3 = 0; n3 < t3.var_byte_arr_arr_b[2][t3.k]; n3 = (int)((byte)(n3 + 1))) {
            byte[] byArray2 = t3.var_byte_arr_arr_b[4];
            ad.ad_b();
            byArray[n3] = byArray2[ad.c(t3.var_byte_arr_arr_b[4].length)];
            by = 0;
            while (by < n3) {
                if (byArray[by] == byArray[n3]) {
                    byte[] byArray3 = t3.var_byte_arr_arr_b[4];
                    ad.ad_b();
                    byArray[n3] = byArray3[ad.c(t3.var_byte_arr_arr_b[4].length)];
                    by = 0;
                    continue;
                }
                by = (byte)(by + 1);
            }
        }
        ad.ad_b();
        n3 = (byte)ad.c(2);
        by = byArray[byArray.length - 1];
        byArray[byArray.length - 1] = byArray[n3];
        byArray[n3] = by;
        for (n3 = 0; n3 < 3; n3 = (int)((byte)(n3 + 1))) {
            if (byArray[n3] == -1) continue;
            by = t3.var_ak_b.var_byte_arr_arr_e[byArray[n3]][0];
            t3.var_am_arr_b[n3] = ad.ad_b().b("data/npc2/" + by, t3.var_ak_b.boolean_b((int)by));
        }
        byte[] byArray4 = byArray;
        for (int n4 = 0; n4 < 3; n4 = (int)((byte)(n4 + 1))) {
            t2.var_int_arr_arr_b[n4][0] = n4;
            t2.var_int_arr_arr_b[n4][1] = byArray4[n4];
            t2.var_int_arr_arr_b[n4][2] = t2.var_byte_arr_arr_b[0][n4] + 100;
            t2.var_int_arr_arr_b[n4][3] = 0;
        }
        ad.ad_b();
        t2.g = (byte)(ad.c(2 + t2.k) + 2 + t2.k);
        t2.h = 0;
        t2.var_byte_b = 0;
    }

    private void d() {
        byte by;
        int n2;
        t t2 = this;
        byte[] byArray = new byte[3];
        for (n2 = 0; n2 < byArray.length; n2 = (int)((byte)(n2 + 1))) {
            byArray[n2] = -1;
        }
        for (n2 = 0; n2 < t2.var_byte_arr_arr_b[2][t2.k]; n2 = (int)((byte)(n2 + 1))) {
            byte[] byArray2 = t2.var_byte_arr_arr_b[4];
            ad.ad_b();
            byArray[n2] = byArray2[ad.c(t2.var_byte_arr_arr_b[4].length)];
            by = 0;
            while (by < n2) {
                if (byArray[by] == byArray[n2]) {
                    byte[] byArray3 = t2.var_byte_arr_arr_b[4];
                    ad.ad_b();
                    byArray[n2] = byArray3[ad.c(t2.var_byte_arr_arr_b[4].length)];
                    by = 0;
                    continue;
                }
                by = (byte)(by + 1);
            }
        }
        ad.ad_b();
        n2 = (byte)ad.c(2);
        by = byArray[byArray.length - 1];
        byArray[byArray.length - 1] = byArray[n2];
        byArray[n2] = by;
        for (n2 = 0; n2 < 3; n2 = (int)((byte)(n2 + 1))) {
            if (byArray[n2] == -1) continue;
            by = t2.var_ak_b.var_byte_arr_arr_e[byArray[n2]][0];
            t2.var_am_arr_b[n2] = ad.ad_b().b("data/npc2/" + by, t2.var_ak_b.boolean_b((int)by));
        }
        byte[] byArray4 = byArray;
        for (int n3 = 0; n3 < 3; n3 = (int)((byte)(n3 + 1))) {
            this.var_int_arr_arr_b[n3][0] = n3;
            this.var_int_arr_arr_b[n3][1] = byArray4[n3];
            this.var_int_arr_arr_b[n3][2] = this.var_byte_arr_arr_b[0][n3] + 100;
            this.var_int_arr_arr_b[n3][3] = 0;
        }
        ad.ad_b();
        this.g = (byte)(ad.c(2 + this.k) + 2 + this.k);
        this.h = 0;
        this.var_byte_b = 0;
    }

    private byte[] byte_arr_b() {
        byte by;
        int n2;
        byte[] byArray = new byte[3];
        for (n2 = 0; n2 < byArray.length; n2 = (int)((byte)(n2 + 1))) {
            byArray[n2] = -1;
        }
        for (n2 = 0; n2 < this.var_byte_arr_arr_b[2][this.k]; n2 = (int)((byte)(n2 + 1))) {
            byte[] byArray2 = this.var_byte_arr_arr_b[4];
            ad.ad_b();
            byArray[n2] = byArray2[ad.c(this.var_byte_arr_arr_b[4].length)];
            by = 0;
            while (by < n2) {
                if (byArray[by] == byArray[n2]) {
                    byte[] byArray3 = this.var_byte_arr_arr_b[4];
                    ad.ad_b();
                    byArray[n2] = byArray3[ad.c(this.var_byte_arr_arr_b[4].length)];
                    by = 0;
                    continue;
                }
                by = (byte)(by + 1);
            }
        }
        ad.ad_b();
        n2 = (byte)ad.c(2);
        by = byArray[byArray.length - 1];
        byArray[byArray.length - 1] = byArray[n2];
        byArray[n2] = by;
        for (n2 = 0; n2 < 3; n2 = (int)((byte)(n2 + 1))) {
            if (byArray[n2] == -1) continue;
            by = this.var_ak_b.var_byte_arr_arr_e[byArray[n2]][0];
            this.var_am_arr_b[n2] = ad.ad_b().b("data/npc2/" + by, this.var_ak_b.boolean_b((int)by));
        }
        return byArray;
    }

    public t() {
    }

    private static int b(String string, int n2) {
        int n3 = 0;
        int n4 = 0;
        while (n4 < string.length()) {
            char c2 = string.charAt(n4);
            if (c2 == '\n') {
                return n4 + 1;
            }
            if ((n3 += u.b(c2)) > n2) {
                return n4;
            }
            ++n4;
        }
        return 0;
    }

    public static int b(String string) {
        return u.b(string);
    }

    public static int[] b(Graphics graphics, String string, Font font, int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8 = 0;
        n5 = 0;
        while (true) {
            int n9;
            block6: {
                int n10 = n2;
                String string2 = string;
                int n11 = 0;
                int n12 = 0;
                while (n12 < string2.length()) {
                    char c2 = string2.charAt(n12);
                    if (c2 == '\n') {
                        n9 = n12 + 1;
                        break block6;
                    }
                    if ((n11 += u.b(c2)) > n10) {
                        n9 = n12;
                        break block6;
                    }
                    ++n12;
                }
                n9 = n7 = 0;
            }
            if (n9 == 0) break;
            String string3 = string.charAt(n7 - 1) == '\n' ? string.substring(0, n7 - 1) : string.substring(0, n7);
            if (n8 >= n4 && n6 < n3) {
                u.b(graphics, string3, 5, n6, 0);
                n6 = n6 + u.var_byte_b + 5;
            }
            if (n6 >= n3) {
                ++n5;
            }
            ++n8;
            string = string.substring(n7, string.length());
        }
        u.b(graphics, string, 5, n6, 0);
        return new int[]{n6, n5};
    }
}

