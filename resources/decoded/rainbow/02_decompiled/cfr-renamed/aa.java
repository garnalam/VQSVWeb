/*
 * Decompiled with CFR 0.152.
 */
public final class aa
implements ao {
    private ak var_ak_b;
    private short var_short_b;
    private short var_short_c;
    private short var_short_a;
    private short var_short_e = (short)30;
    private short var_short_d = (short)40;
    private short var_short_h = (short)4;
    private short var_short_g = (short)120;
    private short var_short_f = (short)145;
    private int var_int_b;
    private byte[][] var_byte_arr_arr_b;
    private byte[][] var_byte_arr_arr_c;
    private byte var_byte_b = (byte)3;
    private byte var_byte_c = (byte)3;
    private byte var_byte_a;
    private byte var_byte_e;
    private byte var_byte_d;
    private byte var_byte_h;
    private byte var_byte_g;
    private byte var_byte_f;
    private byte i;
    private byte[][] var_byte_arr_arr_a = new byte[][]{{3, 4}, {3, 6}, {4, 6}, {5, 6}};

    public aa(ak ak2) {
        this.var_ak_b = ak2;
    }

    public final void void_b(int n2, int n3) {
        byte by;
        int n4;
        this.var_ak_b.b(ak.java_lang_String_b("data/gamec.d"), 183, 0);
        this.var_byte_a = (byte)n3;
        this.var_byte_arr_arr_b = null;
        this.var_byte_arr_arr_b = new byte[this.var_byte_arr_arr_a[this.var_byte_a][0]][this.var_byte_arr_arr_a[this.var_byte_a][1]];
        this.var_byte_arr_arr_c = null;
        this.var_byte_arr_arr_c = new byte[this.var_byte_arr_arr_a[this.var_byte_a][0]][this.var_byte_arr_arr_a[this.var_byte_a][1]];
        this.var_byte_d = (byte)9;
        n3 = n2;
        aa aa2 = this;
        this.var_ak_b.var_byte_d = (byte)9;
        aa2.var_short_b = (short)100;
        aa2.var_byte_b = (byte)((aa2.var_byte_a << 1) + 4);
        aa2.var_byte_c = (byte)(aa2.var_byte_arr_arr_a[aa2.var_byte_a][0] * aa2.var_byte_arr_arr_a[aa2.var_byte_a][1] / 2);
        if (n3 <= 0) {
            aa2.i = 0;
            aa2.var_byte_e = 0;
            aa2.var_int_b = aa2.var_byte_a * 200 + 200;
            return;
        }
        aa2.var_short_c = (short)(-((aa2.var_short_e + aa2.var_short_h) * aa2.var_byte_arr_arr_a[aa2.var_byte_a][1]) >> 1);
        aa2.var_short_a = (short)(-((aa2.var_short_d + aa2.var_short_h) * aa2.var_byte_arr_arr_a[aa2.var_byte_a][0]) >> 1);
        aa2.i = 0;
        aa2.var_byte_f = 0;
        aa2.var_byte_e = 1;
        byte[] byArray = new byte[aa2.var_byte_c];
        for (n3 = 0; n3 < aa2.var_byte_arr_arr_c.length; n3 = (int)((byte)(n3 + 1))) {
            for (n4 = 0; n4 < aa2.var_byte_arr_arr_c[n3].length; n4 = (int)((byte)(n4 + 1))) {
                aa2.var_byte_arr_arr_c[n3][n4] = 2;
                aa2.var_byte_arr_arr_b[n3][n4] = 0;
            }
        }
        n3 = 0;
        while (n3 < byArray.length) {
            ad.ad_b();
            by = (byte)(ad.c(35) + 1);
            for (n4 = (int)((byte)(byArray.length - 1)); n4 >= 0 && byArray[n4] != by; n4 = (int)((byte)(n4 - 1))) {
            }
            if (n4 != -1) continue;
            byArray[n3] = by;
            n3 = (byte)(n3 + 1);
        }
        for (n3 = 0; n3 < byArray.length; n3 = (int)((byte)(n3 + 1))) {
            for (n4 = 0; n4 < 2; n4 = (int)((byte)(n4 + 1))) {
                do {
                    ad.ad_b();
                } while (aa2.var_byte_arr_arr_b[(by = (byte)ad.c(aa2.var_byte_arr_arr_a[aa2.var_byte_a][0] * aa2.var_byte_arr_arr_a[aa2.var_byte_a][1])) / aa2.var_byte_arr_arr_a[aa2.var_byte_a][1]][by % aa2.var_byte_arr_arr_a[aa2.var_byte_a][1]] != 0);
                aa2.var_byte_arr_arr_b[by / aa2.var_byte_arr_arr_a[aa2.var_byte_a][1]][by % aa2.var_byte_arr_arr_a[aa2.var_byte_a][1]] = byArray[n3];
            }
        }
    }

    private void b(int n2) {
        byte by;
        int n3;
        this.var_ak_b.var_byte_d = (byte)9;
        this.var_short_b = (short)100;
        this.var_byte_b = (byte)((this.var_byte_a << 1) + 4);
        this.var_byte_c = (byte)(this.var_byte_arr_arr_a[this.var_byte_a][0] * this.var_byte_arr_arr_a[this.var_byte_a][1] / 2);
        if (n2 <= 0) {
            this.i = 0;
            this.var_byte_e = 0;
            this.var_int_b = this.var_byte_a * 200 + 200;
            return;
        }
        this.var_short_c = (short)(-((this.var_short_e + this.var_short_h) * this.var_byte_arr_arr_a[this.var_byte_a][1]) >> 1);
        this.var_short_a = (short)(-((this.var_short_d + this.var_short_h) * this.var_byte_arr_arr_a[this.var_byte_a][0]) >> 1);
        this.i = 0;
        this.var_byte_f = 0;
        this.var_byte_e = 1;
        byte[] byArray = new byte[this.var_byte_c];
        for (n2 = 0; n2 < this.var_byte_arr_arr_c.length; n2 = (int)((byte)(n2 + 1))) {
            for (n3 = 0; n3 < this.var_byte_arr_arr_c[n2].length; n3 = (int)((byte)(n3 + 1))) {
                this.var_byte_arr_arr_c[n2][n3] = 2;
                this.var_byte_arr_arr_b[n2][n3] = 0;
            }
        }
        n2 = 0;
        while (n2 < byArray.length) {
            ad.ad_b();
            by = (byte)(ad.c(35) + 1);
            for (n3 = (int)((byte)(byArray.length - 1)); n3 >= 0 && byArray[n3] != by; n3 = (int)((byte)(n3 - 1))) {
            }
            if (n3 != -1) continue;
            byArray[n2] = by;
            n2 = (byte)(n2 + 1);
        }
        for (n2 = 0; n2 < byArray.length; n2 = (int)((byte)(n2 + 1))) {
            for (n3 = 0; n3 < 2; n3 = (int)((byte)(n3 + 1))) {
                do {
                    ad.ad_b();
                } while (this.var_byte_arr_arr_b[(by = (byte)ad.c(this.var_byte_arr_arr_a[this.var_byte_a][0] * this.var_byte_arr_arr_a[this.var_byte_a][1])) / this.var_byte_arr_arr_a[this.var_byte_a][1]][by % this.var_byte_arr_arr_a[this.var_byte_a][1]] != 0);
                this.var_byte_arr_arr_b[by / this.var_byte_arr_arr_a[this.var_byte_a][1]][by % this.var_byte_arr_arr_a[this.var_byte_a][1]] = byArray[n2];
            }
        }
    }

    private void a() {
        this.var_byte_arr_arr_b = null;
        this.var_byte_arr_arr_c = null;
        this.var_byte_arr_arr_a = null;
    }

    public final boolean boolean_b() {
        ad.ad_b();
        if (ad.boolean_b()) {
            return false;
        }
        if (this.var_byte_e == 0) {
            ad.ad_b();
            if (ad.boolean_c()) {
                ad.ad_b();
                this.i = ad.byte_b((int)this.i, 0, (int)this.var_byte_d);
                if (this.i < 0) {
                    this.i = 0;
                }
            } else {
                ad.ad_b();
                if (ad.i()) {
                    ad.ad_b();
                    ad.void_c();
                    aa aa2 = this;
                    this.var_byte_arr_arr_b = null;
                    aa2.var_byte_arr_arr_c = null;
                    aa2.var_byte_arr_arr_a = null;
                    return true;
                }
                ad.ad_b();
                if (ad.g()) {
                    ad.ad_b();
                    ad.void_c();
                    if (this.var_ak_b.boolean_b(this.var_int_b, true)) {
                        this.void_b(1, this.var_byte_a);
                    }
                }
            }
        } else if (this.var_byte_e < 3) {
            ad.ad_b();
            if (ad.boolean_c()) {
                ad.ad_b();
                this.i = ad.byte_b((int)this.i, 0, this.var_byte_arr_arr_b.length - 1);
            } else {
                ad.ad_b();
                if (ad.e()) {
                    ad.ad_b();
                    this.var_byte_f = ad.byte_b((int)this.var_byte_f, 0, this.var_byte_arr_arr_b[this.i].length - 1);
                } else {
                    ad.ad_b();
                    if (ad.g()) {
                        ad.ad_b();
                        ad.void_c();
                        if (this.var_byte_e == 0) {
                            this.void_b(0, this.var_byte_a);
                        } else if (this.var_byte_arr_arr_c[this.i][this.var_byte_f] == 0) {
                            byte[] byArray = this.var_byte_arr_arr_c[this.i];
                            byte by = this.var_byte_f;
                            byArray[by] = (byte)(byArray[by] + 1);
                            this.var_byte_e = (byte)(this.var_byte_e + 1);
                            if (this.var_byte_e == 2) {
                                this.var_byte_h = this.var_byte_f;
                                this.var_byte_g = this.i;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void void_b() {
        if (this.var_byte_e == 0) {
            int n2 = 20 * this.var_byte_d;
            int n3 = 2;
            n3 = 10;
            aa aa2 = this;
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
            ah.ah_b().b((StringBuffer[])aa2.var_ak_b.var_int_c, 19, 32, 20, 0, 0);
            ah.ah_b();
            ah.b("Ph\u00ed c\u1ea7n \u0111\u1ec3 tham gia: " + aa2.var_int_b + "Kim", 19, n2 + 52, 0, 0, 1);
            aa2.var_ak_b.void_b(120, 320, 3, false);
            ah.ah_b().b(true, true);
            return;
        }
        this.c(10, 2, 20 * (this.var_byte_d + 3));
    }

    public final void c() {
        if (this.var_byte_b <= 0) {
            if (this.var_byte_b == 0) {
                this.var_byte_b = (byte)-1;
                this.var_ak_b.b("Tr\u00f2 ch\u01a1i th\u1ea5t b\u1ea1i!!!", -1);
                return;
            }
            if (this.var_byte_b == -1 && this.var_ak_b.var_byte_k == 0) {
                this.void_b(0, this.var_byte_a);
                return;
            }
        } else if (this.var_byte_c <= 0) {
            if (this.var_byte_c == 0) {
                this.var_byte_c = (byte)-1;
                this.var_ak_b.var_int_b += this.var_byte_b * 125 + 100;
                this.var_ak_b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c kim ti\u1ec1n: " + (this.var_byte_b * 125 + 100), -1);
                this.var_ak_b.var_byte_arr_arr_l[8] = (byte[])((byte)(this.var_ak_b.var_byte_arr_arr_l[8] | 1 << this.var_byte_a));
                return;
            }
            if (this.var_byte_c == -1 && this.var_ak_b.var_byte_k == 0) {
                this.void_b(0, this.var_byte_a);
                return;
            }
        } else if (this.var_byte_e >= 3) {
            this.var_byte_e = (byte)(this.var_byte_e + 1);
            if (this.var_byte_e > 10) {
                this.var_byte_e = 1;
                return;
            }
            if (this.var_byte_e == 10) {
                if (this.var_byte_arr_arr_b[this.i][this.var_byte_f] != this.var_byte_arr_arr_b[this.var_byte_g][this.var_byte_h]) {
                    this.var_byte_arr_arr_c[this.i][this.var_byte_f] = 3;
                    this.var_byte_arr_arr_c[this.var_byte_g][this.var_byte_h] = 3;
                    this.var_byte_b = (byte)(this.var_byte_b - 1);
                    return;
                }
                this.var_byte_c = (byte)(this.var_byte_c - 1);
                return;
            }
        } else if (this.var_short_b > 0 && (this.var_short_b = (short)(this.var_short_b - 1)) == 0) {
            for (int n2 = 0; n2 < this.var_byte_arr_arr_c.length; n2 = (int)((byte)(n2 + 1))) {
                for (int n3 = 0; n3 < this.var_byte_arr_arr_c[n2].length; n3 = (int)((byte)(n3 + 1))) {
                    this.var_byte_arr_arr_c[n2][n3] = 3;
                }
            }
        }
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
        ah.ah_b();
        ah.b("Ph\u00ed c\u1ea7n \u0111\u1ec3 tham gia: " + this.var_int_b + "Kim", 19, n4 + 52, 0, 0, 1);
        this.var_ak_b.void_b(120, 320, 3, false);
        ah.ah_b().b(true, true);
    }

    private void c(int n2, int n3, int n4) {
        ah.ah_b();
        ah.c();
        ah.ah_b().a(7, 82, 22, 40, 0);
        ah.ah_b().a(7, 158, 22, 36, 4);
        ah.ah_b();
        ah.e(10, 27, 220, n4, 4);
        ah.ah_b();
        ah.e(10, n4 + 32, 220, 40, 4);
        for (n2 = 0; n2 < this.var_byte_arr_arr_b.length; ++n2) {
            for (n3 = 0; n3 < this.var_byte_arr_arr_b[n2].length; ++n3) {
                byte by = this.var_byte_arr_arr_c[n2][n3] == 3 ? (byte)1 : this.var_byte_arr_arr_c[n2][n3];
                int n5 = this.var_short_f + this.var_short_a + n2 * (this.var_short_d + this.var_short_h);
                int n6 = this.var_short_g + this.var_short_c + n3 * (this.var_short_e + this.var_short_h);
                int n7 = n3;
                int n8 = n2;
                aa aa2 = this;
                if (by == 0) {
                    ah.ah_b();
                    ah.e(n6, n5, aa2.var_short_e, aa2.var_short_d, 1);
                    ah.ah_b().a(25, n6 + (aa2.var_short_e >> 1), n5 + (aa2.var_short_d >> 1), 3, 0);
                    continue;
                }
                if (by == 1) {
                    ah.ah_b();
                    ah.e(n6 + (aa2.var_short_e >> 1) - 2, n5 - 3, 5, aa2.var_short_d + 6, 1);
                    byte[] byArray = aa2.var_byte_arr_arr_c[n8];
                    int n9 = n7;
                    byArray[n9] = (byte)(byArray[n9] + 1);
                    if (byArray[n9] <= 3) continue;
                    aa2.var_byte_arr_arr_c[n8][n7] = 0;
                    continue;
                }
                ah.ah_b();
                ah.e(n6, n5, aa2.var_short_e, aa2.var_short_d, 5);
                aa2.var_ak_b.void_b((int)aa2.var_byte_arr_arr_b[n8][n7], n6 + (aa2.var_short_e >> 1), n5 + (aa2.var_short_d >> 1), 3);
                ah.ah_b().c("" + aa2.var_byte_arr_arr_b[n8][n7], n6 + aa2.var_short_e, n5 + aa2.var_short_d, 40, 0);
            }
        }
        ah.ah_b().c(15400191, this.var_short_g + this.var_short_c + this.var_byte_f * (this.var_short_e + this.var_short_h), this.var_short_f + this.var_short_a + this.i * (this.var_short_d + this.var_short_h), this.var_short_e, this.var_short_d, 3);
        if (this.var_short_b > 0) {
            ah.ah_b().c("" + this.var_short_b / 10, 130, 24, 36, 2);
            return;
        }
        ah.ah_b();
        ah.b("B\u1eaft \u0111\u1ea7u tr\u00f2 ch\u01a1i", 120, 4, 17, 3, 0);
        ah.ah_b();
        ah.b("S\u1ed1 l\u1ea7n c\u00f3 th\u1ec3 sai: " + (this.var_byte_b < 0 ? 0 : this.var_byte_b - 1) + "L\u1ea7n", 120, 287, 17, 0, 0);
    }

    private void b(int n2, int n3, int n4, int n5, int n6) {
        if (n6 == 0) {
            ah.ah_b();
            ah.e(n4, n5, this.var_short_e, this.var_short_d, 1);
            ah.ah_b().a(25, n4 + (this.var_short_e >> 1), n5 + (this.var_short_d >> 1), 3, 0);
            return;
        }
        if (n6 == 1) {
            ah.ah_b();
            ah.e(n4 + (this.var_short_e >> 1) - 2, n5 - 3, 5, this.var_short_d + 6, 1);
            byte[] byArray = this.var_byte_arr_arr_c[n2];
            int n7 = n3;
            byArray[n7] = (byte)(byArray[n7] + 1);
            if (byArray[n7] > 3) {
                this.var_byte_arr_arr_c[n2][n3] = 0;
            }
            return;
        }
        ah.ah_b();
        ah.e(n4, n5, this.var_short_e, this.var_short_d, 5);
        this.var_ak_b.void_b((int)this.var_byte_arr_arr_b[n2][n3], n4 + (this.var_short_e >> 1), n5 + (this.var_short_d >> 1), 3);
        ah.ah_b().c("" + this.var_byte_arr_arr_b[n2][n3], n4 + this.var_short_e, n5 + this.var_short_d, 40, 0);
    }
}

