/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Image;

public final class ab
implements ao {
    private ak var_ak_b;
    private byte var_byte_b;
    private byte var_byte_c;
    private byte var_byte_a;
    private byte var_byte_e;
    private short var_short_b;
    private short var_short_c;
    private short var_short_a;
    private short var_short_e;
    private short d;
    private short[][] var_short_arr_arr_b = new short[][]{{9, 1, 10, 2, 11, 4, 27, 8, 2, -10}, {50, 100, 150, 200}, {60, 40, 30, 10}, {8, 6, 13, 3, 20, 5, 30, 10}};
    private short[][] var_short_arr_arr_c = new short[][]{{10, 20, 60, 10, 220}, {13, 40, 60, 12, 170}, {10, 40, 60, 10, 120}};
    private short[] var_short_arr_b = new short[]{150, 200, 300, 450};
    private short[][] var_short_arr_arr_a = new short[40][7];
    private short[] var_short_arr_c = new short[]{0, 275, 67, 10, 0};
    private short h;
    private am[] var_am_arr_b;
    private Image var_javax_microedition_lcdui_Image_b;
    private am var_am_b;
    private byte[] var_byte_arr_b = new byte[]{20, 15, 10, 5};

    public ab(ak ak2) {
        this.var_ak_b = ak2;
        this.d = (short)240;
    }

    private void a() {
        this.var_short_arr_arr_b = null;
        this.var_short_arr_b = null;
        this.var_am_arr_b = null;
        this.var_javax_microedition_lcdui_Image_b = null;
        this.var_short_arr_arr_c = null;
    }

    public final void void_b(int n2, int n3) {
        this.var_byte_e = (byte)n3;
        this.var_am_arr_b = new am[2];
        this.var_am_arr_b[0] = ad.ad_b().b("data/npc2/38", true);
        ad.ad_b();
        this.var_javax_microedition_lcdui_Image_b = ad.javax_microedition_lcdui_Image_b("data/brow/m0");
        byte[] byArray = ad.ad_b().byte_arr_b("data/gamee.data", -1);
        ad.ad_b();
        ad.var_int_c = 0;
        ad.ad_b();
        this.var_am_b = am.am_b(ad.javax_microedition_lcdui_Image_b("data/map/5"), ad.ad_b().short_arr_arr_b(byArray, 2), ad.ad_b().short_arr_arr_arr_b(byArray, 2), ad.ad_b().short_arr_arr_arr_b(byArray, 2));
        this.void_b(n2);
    }

    private void void_b(int n2) {
        if (n2 <= 0) {
            this.var_byte_b = 0;
            this.var_byte_c = (byte)10;
            this.var_ak_b.b("Trong m\u1ed9t th\u1eddi gian gi\u1edbi h\u1ea1n c\u00e0ng nhi\u1ec1u b\u00f3ng v\u00e0o h\u1ed9p c\u00e0ng t\u1ed1t. S\u1ed1 \u0111i\u1ec3m b\u00f3ng \u0111\u1ea1t \u0111\u01b0\u1ee3c s\u1ebd \u0111\u01b0\u1ee3c t\u00ednh l\u00e0m c\u0103n c\u1ee9 \u0111\u1ed5i l\u1ea5y kim ti\u1ec1n.", 200, 0);
            return;
        }
        if (n2 == 1) {
            this.var_byte_b = 1;
            this.h = 0;
            this.var_byte_a = 0;
            this.var_short_b = this.var_short_arr_arr_b[1][this.var_byte_e];
            this.b(true);
            for (n2 = 0; n2 < this.var_short_arr_arr_a.length; n2 = (int)((byte)(n2 + 1))) {
                this.var_short_arr_arr_a[n2][5] = -1;
            }
        }
    }

    public final boolean boolean_b() {
        if (this.var_byte_b == 0) {
            ad.ad_b();
            if (ad.g() && this.var_ak_b.boolean_b((int)this.var_short_arr_b[this.var_byte_e], true)) {
                this.void_b(1);
            } else {
                ad.ad_b();
                if (ad.i()) {
                    ab ab2 = this;
                    this.var_short_arr_arr_b = null;
                    ab2.var_short_arr_b = null;
                    ab2.var_am_arr_b = null;
                    ab2.var_javax_microedition_lcdui_Image_b = null;
                    ab2.var_short_arr_arr_c = null;
                    return true;
                }
            }
        } else if (this.var_byte_b == 1) {
            ad.ad_b();
            if (ad.d()) {
                this.var_short_arr_c[0] = (short)(this.var_short_arr_c[0] - 10);
                if (this.var_short_arr_c[0] < 0) {
                    this.var_short_arr_c[0] = 0;
                }
            } else {
                ad.ad_b();
                if (ad.h()) {
                    this.var_short_arr_c[0] = (short)(this.var_short_arr_c[0] + 10);
                    if (this.var_short_arr_c[0] + this.var_short_arr_c[2] > this.d - 20) {
                        this.var_short_arr_c[0] = (short)(this.d - this.var_short_arr_c[2] - 20);
                    }
                }
            }
        }
        return false;
    }

    public final void void_b() {
        if (this.var_byte_b == 0) {
            int n2 = 20 * this.var_byte_c;
            int n3 = 2;
            n3 = 10;
            ab ab2 = this;
            ah.ah_b();
            ah.c();
            ah.ah_b();
            ah.b("Quy t\u1eafc tr\u00f2 ch\u01a1i", 120, 22, 33, 3, 1);
            ah.ah_b().a(7, 82, 22, 40, 0);
            ah.ah_b().a(7, 158, 22, 36, 4);
            ah.ah_b();
            ah.e(10, 27, 220, n2, 4);
            ah.ah_b();
            ah.e(10, n2 + 32, 220, 60, 4);
            ah.ah_b().b((StringBuffer[])ab2.var_ak_b.var_int_c, 19, 32, 20, 0, 0);
            int n4 = 42 + ((int)ab2.var_ak_b.var_int_c).length * 20;
            ah.ah_b();
            ah.b("\u0110i\u1ec3m c\u1ee7a c\u00e1c ch\u1ee7ng lo\u1ea1i b\u00f3ng kh\u00e1c nhau: ", 19, n4, 0, 0, 0);
            n4 += 40;
            for (int i2 = 0; i2 < ab2.var_short_arr_arr_b[0].length; i2 += 2) {
                ab2.var_ak_b.void_b((int)ab2.var_short_arr_arr_b[0][i2], 38 + (i2 % 4 == 2 ? 76 : 0), n4 + (i2 >> 2) * 25, 0);
                ah.ah_b();
                ah.b((ab2.var_short_arr_arr_b[0][i2 + 1] < 0 ? "" : "+") + ab2.var_short_arr_arr_b[0][i2 + 1], 38 + (i2 % 4 == 2 ? 76 : 0) + 16, n4 + (i2 >> 2) * 25 - 4, 0, 0, 1);
            }
            ah.ah_b();
            ah.b("Ph\u00ed c\u1ea7n \u0111\u1ec3 tham gia: " + ab2.var_short_arr_b[ab2.var_byte_e] + "Kim", 19, n2 + 52, 0, 0, 1);
            ab2.var_ak_b.void_b(120, 320, 3, false);
            ah.ah_b().b(true, true);
            return;
        }
        this.e();
    }

    private void b(int n2, int n3, int n4) {
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.b("Quy t\u1eafc tr\u00f2 ch\u01a1i", 120, 22, 33, 3, 1);
        ah.ah_b().a(7, 82, 22, 40, 0);
        ah.ah_b().a(7, 158, 22, 36, 4);
        ah.ah_b();
        ah.e(10, 27, 220, n4, 4);
        ah.ah_b();
        ah.e(10, n4 + 32, 220, 60, 4);
        ah.ah_b().b((StringBuffer[])this.var_ak_b.var_int_c, 19, 32, 20, 0, 0);
        n3 = 42 + ((int)this.var_ak_b.var_int_c).length * 20;
        ah.ah_b();
        ah.b("\u0110i\u1ec3m c\u1ee7a c\u00e1c ch\u1ee7ng lo\u1ea1i b\u00f3ng kh\u00e1c nhau: ", 19, n3, 0, 0, 0);
        n3 += 40;
        for (n2 = 0; n2 < this.var_short_arr_arr_b[0].length; n2 += 2) {
            this.var_ak_b.void_b((int)this.var_short_arr_arr_b[0][n2], 38 + (n2 % 4 == 2 ? 76 : 0), n3 + (n2 >> 2) * 25, 0);
            ah.ah_b();
            ah.b((this.var_short_arr_arr_b[0][n2 + 1] < 0 ? "" : "+") + this.var_short_arr_arr_b[0][n2 + 1], 38 + (n2 % 4 == 2 ? 76 : 0) + 16, n3 + (n2 >> 2) * 25 - 4, 0, 0, 1);
        }
        ah.ah_b();
        ah.b("Ph\u00ed c\u1ea7n \u0111\u1ec3 tham gia: " + this.var_short_arr_b[this.var_byte_e] + "Kim", 19, n4 + 52, 0, 0, 1);
        this.var_ak_b.void_b(120, 320, 3, false);
        ah.ah_b().b(true, true);
    }

    private void e() {
        int n2;
        ah.ah_b();
        ah.b(5423359, 0, 0, 240, 320);
        ah.ah_b().b(this.var_am_b, 0, this.d / 2, 160, 0);
        ah.ah_b();
        ah.b("\u0110i\u1ec3m: " + this.h, 0, 0, 20, 3, 1);
        ah.ah_b();
        ah.b("T\u1ed5ng s\u1ed1 b\u00f3ng: " + this.var_short_b, (int)this.d, 0, 24, 3, 1);
        ah.ah_b();
        ah.b(this.var_javax_microedition_lcdui_Image_b, (int)this.d, 305, 40);
        for (n2 = 0; n2 < this.var_short_arr_arr_a.length; n2 = (int)((byte)(n2 + 1))) {
            if (this.var_short_arr_arr_a[n2][5] == -1) continue;
            this.var_ak_b.void_b((int)this.var_short_arr_arr_b[0][this.var_short_arr_arr_a[n2][6] << 1], (int)this.var_short_arr_arr_a[n2][0], (int)this.var_short_arr_arr_a[n2][1], 0);
        }
        for (n2 = 0; n2 < 2; n2 = (int)((byte)(n2 + 1))) {
            ah.ah_b().b(this.var_am_arr_b[0], this.var_short_arr_c[4] == 0 ? 3 : 4, this.var_short_arr_c[0] + n2 * 30 + 20, this.var_short_arr_c[1] + 25, 0);
        }
    }

    private void void_c(int n2) {
        this.var_short_arr_arr_a[this.var_byte_a][0] = -20;
        this.var_short_arr_arr_a[this.var_byte_a][1] = this.var_short_arr_arr_c[n2][4];
        this.var_short_arr_arr_a[this.var_byte_a][2] = (short)(this.var_short_arr_arr_c[n2][1] / this.var_short_arr_arr_c[n2][0]);
        this.var_short_arr_arr_a[this.var_byte_a][4] = this.var_short_arr_arr_c[n2][0];
        this.var_short_arr_arr_a[this.var_byte_a][5] = (short)n2;
        this.var_short_arr_arr_a[this.var_byte_a][3] = this.var_short_arr_arr_c[n2][3];
        short[] sArray = this.var_short_arr_arr_a[this.var_byte_a];
        ad.ad_b();
        sArray[6] = (short)ad.c(this.var_short_arr_arr_b[0].length >> 1);
        this.var_byte_a = (byte)(this.var_byte_a + 1);
        if (this.var_byte_a >= this.var_short_arr_arr_a.length) {
            this.var_byte_a = 0;
        }
    }

    private void b(boolean bl) {
        this.var_short_a = (short)(bl ? 10 : this.var_short_arr_arr_b[2][this.var_byte_e]);
        this.var_short_e = this.var_byte_arr_b[this.var_byte_e];
        ad.ad_b();
        this.var_short_c = (short)(ad.c(this.var_short_arr_arr_b[3][this.var_byte_e << 1]) + this.var_short_arr_arr_b[3][(this.var_byte_e << 1) + 1]);
    }

    private void a(int n2) {
        if (this.var_short_arr_arr_a[n2][4] > 0 && this.var_short_arr_arr_a[n2][3] > 1) {
            short[] sArray = this.var_short_arr_arr_a[n2];
            sArray[3] = (short)(sArray[3] - 1);
            return;
        }
        if (this.var_short_arr_arr_a[n2][4] == 0) {
            this.var_short_arr_arr_a[n2][3] = 0;
            return;
        }
        if (this.var_short_arr_arr_a[n2][4] < 0 && this.var_short_arr_arr_a[n2][3] > -this.var_short_arr_arr_c[this.var_short_arr_arr_a[n2][5]][3]) {
            short[] sArray = this.var_short_arr_arr_a[n2];
            sArray[3] = (short)(sArray[3] - 1);
        }
    }

    private boolean boolean_b(int n2) {
        boolean bl = this.var_short_arr_arr_a[n2][1] > 330;
        ad.ad_b();
        if (ad.b(this.d - 10, 280, 20, 10, this.var_short_arr_arr_a[n2][0], this.var_short_arr_arr_a[n2][1], 16, 16) || this.var_short_arr_arr_a[n2][0] > this.d && this.var_short_arr_arr_a[n2][1] < this.var_short_arr_c[1]) {
            bl = true;
            this.h = (short)(this.h + this.var_short_arr_arr_b[0][(this.var_short_arr_arr_a[n2][6] << 1) + 1]);
        }
        return bl;
    }

    private boolean boolean_c(int n2) {
        ad.ad_b();
        return ad.b(this.var_short_arr_c[0], this.var_short_arr_c[1], this.var_short_arr_c[2], this.var_short_arr_c[3], this.var_short_arr_arr_a[n2][0], this.var_short_arr_arr_a[n2][1], 16, 16);
    }

    public final void c() {
        if (this.var_byte_b == 1) {
            ab ab2;
            int n2;
            if (this.var_short_b > 0) {
                if (this.var_short_a > 0) {
                    this.var_short_a = (short)(this.var_short_a - 1);
                } else if (this.var_short_e > 0) {
                    this.var_short_e = (short)(this.var_short_e - 1);
                } else if (this.var_short_c > 0) {
                    this.var_short_e = this.var_byte_arr_b[this.var_byte_e];
                    ad.ad_b();
                    n2 = ad.c(this.var_short_arr_arr_c.length);
                    ab2 = this;
                    ab2.var_short_arr_arr_a[ab2.var_byte_a][0] = -20;
                    ab2.var_short_arr_arr_a[ab2.var_byte_a][1] = ab2.var_short_arr_arr_c[n2][4];
                    ab2.var_short_arr_arr_a[ab2.var_byte_a][2] = (short)(ab2.var_short_arr_arr_c[n2][1] / ab2.var_short_arr_arr_c[n2][0]);
                    ab2.var_short_arr_arr_a[ab2.var_byte_a][4] = ab2.var_short_arr_arr_c[n2][0];
                    ab2.var_short_arr_arr_a[ab2.var_byte_a][5] = (short)n2;
                    ab2.var_short_arr_arr_a[ab2.var_byte_a][3] = ab2.var_short_arr_arr_c[n2][3];
                    short[] sArray = ab2.var_short_arr_arr_a[ab2.var_byte_a];
                    ad.ad_b();
                    sArray[6] = (short)ad.c(ab2.var_short_arr_arr_b[0].length >> 1);
                    ab2.var_byte_a = (byte)(ab2.var_byte_a + 1);
                    if (ab2.var_byte_a >= ab2.var_short_arr_arr_a.length) {
                        ab2.var_byte_a = 0;
                    }
                    this.var_short_c = (short)(this.var_short_c - 1);
                    this.var_short_b = (short)(this.var_short_b - 1);
                } else if (this.var_short_c == 0) {
                    this.b(false);
                }
            }
            if (this.var_short_arr_c[4] > 0) {
                this.var_short_arr_c[4] = (short)(this.var_short_arr_c[4] - 1);
            }
            boolean bl = true;
            for (int n3 = 0; n3 < this.var_short_arr_arr_a.length; n3 = (int)((byte)(n3 + 1))) {
                if (this.var_short_arr_arr_a[n3][5] == -1) continue;
                bl = false;
                short[] sArray = this.var_short_arr_arr_a[n3];
                sArray[0] = (short)(sArray[0] + this.var_short_arr_arr_a[n3][2]);
                short[] sArray2 = this.var_short_arr_arr_a[n3];
                sArray2[1] = (short)(sArray2[1] - this.var_short_arr_arr_a[n3][3]);
                n2 = n3;
                ab2 = this;
                if (ab2.var_short_arr_arr_a[n2][4] > 0 && ab2.var_short_arr_arr_a[n2][3] > 1) {
                    short[] sArray3 = ab2.var_short_arr_arr_a[n2];
                    sArray3[3] = (short)(sArray3[3] - 1);
                } else if (ab2.var_short_arr_arr_a[n2][4] == 0) {
                    ab2.var_short_arr_arr_a[n2][3] = 0;
                } else if (ab2.var_short_arr_arr_a[n2][4] < 0 && ab2.var_short_arr_arr_a[n2][3] > -ab2.var_short_arr_arr_c[ab2.var_short_arr_arr_a[n2][5]][3]) {
                    short[] sArray4 = ab2.var_short_arr_arr_a[n2];
                    sArray4[3] = (short)(sArray4[3] - 1);
                }
                short[] sArray5 = this.var_short_arr_arr_a[n3];
                sArray5[4] = (short)(sArray5[4] - 1);
                n2 = n3;
                ab2 = this;
                boolean bl2 = ab2.var_short_arr_arr_a[n2][1] > 330;
                ad.ad_b();
                if (ad.b(ab2.d - 10, 280, 20, 10, ab2.var_short_arr_arr_a[n2][0], ab2.var_short_arr_arr_a[n2][1], 16, 16) || ab2.var_short_arr_arr_a[n2][0] > ab2.d && ab2.var_short_arr_arr_a[n2][1] < ab2.var_short_arr_c[1]) {
                    bl2 = true;
                    ab2.h = (short)(ab2.h + ab2.var_short_arr_arr_b[0][(ab2.var_short_arr_arr_a[n2][6] << 1) + 1]);
                }
                if (bl2) {
                    this.var_short_arr_arr_a[n3][5] = -1;
                    continue;
                }
                n2 = n3;
                ab2 = this;
                ad.ad_b();
                if (!ad.b(ab2.var_short_arr_c[0], ab2.var_short_arr_c[1], ab2.var_short_arr_c[2], ab2.var_short_arr_c[3], ab2.var_short_arr_arr_a[n2][0], ab2.var_short_arr_arr_a[n2][1], 16, 16)) continue;
                this.var_short_arr_arr_a[n3][4] = this.var_short_arr_arr_c[this.var_short_arr_arr_a[n3][5]][0];
                this.var_short_arr_c[4] = 1;
                this.var_short_arr_arr_a[n3][3] = this.var_short_arr_arr_c[this.var_short_arr_arr_a[n3][5]][3];
            }
            if (this.var_short_b <= 0 && bl) {
                this.h = (short)(this.h * 15 / 10);
                this.var_ak_b.var_int_b += this.h;
                this.var_ak_b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c: " + this.h + "Kim", 0);
                if (this.h > 0) {
                    this.var_ak_b.var_byte_arr_arr_l[6] = (byte[])((byte)(this.var_ak_b.var_byte_arr_arr_l[6] | 1 << this.var_byte_e));
                }
                this.var_byte_b = (byte)2;
            }
            return;
        }
        if (this.var_byte_b == 2 && this.var_ak_b.var_byte_k == 0) {
            this.void_b(0);
        }
    }
}

