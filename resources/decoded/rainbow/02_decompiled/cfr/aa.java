/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class aa
implements ao {
    private ak b;
    private short b;
    private short c;
    private short a;
    private short e;
    private short d;
    private short h;
    private short g;
    private short f;
    private int b;
    private byte[][] b;
    private byte[][] c;
    private byte b;
    private byte c;
    private byte a;
    private byte e = (short)30;
    private byte d = (short)40;
    private byte h = (short)4;
    private byte g = (short)120;
    private byte f = (short)145;
    private byte i;
    private byte[][] a;

    public aa(ak ak2) {
        this.b = (byte)3;
        this.c = (byte)3;
        this.a = new byte[][]{{3, 4}, {3, 6}, {4, 6}, {5, 6}};
        this.b = ak2;
    }

    public final void b(int n2, int n3) {
        byte by;
        int n4;
        this.b.b(ak.b("data/gamec.d"), 183, 0);
        this.a = (byte)n3;
        this.b = null;
        this.b = new byte[this.a[this.a][0]][this.a[this.a][1]];
        this.c = null;
        this.c = new byte[this.a[this.a][0]][this.a[this.a][1]];
        this.d = (byte)9;
        n3 = n2;
        aa aa2 = this;
        this.b.d = (byte)9;
        aa2.b = (short)100;
        aa2.b = (byte)((aa2.a << 1) + 4);
        aa2.c = (byte)(aa2.a[aa2.a][0] * aa2.a[aa2.a][1] / 2);
        if (n3 <= 0) {
            aa2.i = 0;
            aa2.e = 0;
            aa2.b = aa2.a * 200 + 200;
            return;
        }
        aa2.c = (short)(-((aa2.e + aa2.h) * aa2.a[aa2.a][1]) >> 1);
        aa2.a = (short)(-((aa2.d + aa2.h) * aa2.a[aa2.a][0]) >> 1);
        aa2.i = 0;
        aa2.f = 0;
        aa2.e = 1;
        byte[] byArray = new byte[aa2.c];
        for (n3 = 0; n3 < aa2.c.length; n3 = (int)((byte)(n3 + 1))) {
            for (n4 = 0; n4 < aa2.c[n3].length; n4 = (int)((byte)(n4 + 1))) {
                aa2.c[n3][n4] = 2;
                aa2.b[n3][n4] = 0;
            }
        }
        n3 = 0;
        while (n3 < byArray.length) {
            ad.b();
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
                    ad.b();
                } while (aa2.b[(by = (byte)ad.c(aa2.a[aa2.a][0] * aa2.a[aa2.a][1])) / aa2.a[aa2.a][1]][by % aa2.a[aa2.a][1]] != 0);
                aa2.b[by / aa2.a[aa2.a][1]][by % aa2.a[aa2.a][1]] = byArray[n3];
            }
        }
    }

    private void b(int n2) {
        byte by;
        int n3;
        this.b.d = (byte)9;
        this.b = (short)100;
        this.b = (byte)((this.a << 1) + 4);
        this.c = (byte)(this.a[this.a][0] * this.a[this.a][1] / 2);
        if (n2 <= 0) {
            this.i = 0;
            this.e = 0;
            this.b = this.a * 200 + 200;
            return;
        }
        this.c = (short)(-((this.e + this.h) * this.a[this.a][1]) >> 1);
        this.a = (short)(-((this.d + this.h) * this.a[this.a][0]) >> 1);
        this.i = 0;
        this.f = 0;
        this.e = 1;
        byte[] byArray = new byte[this.c];
        for (n2 = 0; n2 < this.c.length; n2 = (int)((byte)(n2 + 1))) {
            for (n3 = 0; n3 < this.c[n2].length; n3 = (int)((byte)(n3 + 1))) {
                this.c[n2][n3] = 2;
                this.b[n2][n3] = 0;
            }
        }
        n2 = 0;
        while (n2 < byArray.length) {
            ad.b();
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
                    ad.b();
                } while (this.b[(by = (byte)ad.c(this.a[this.a][0] * this.a[this.a][1])) / this.a[this.a][1]][by % this.a[this.a][1]] != 0);
                this.b[by / this.a[this.a][1]][by % this.a[this.a][1]] = byArray[n2];
            }
        }
    }

    private void a() {
        this.b = null;
        this.c = null;
        this.a = null;
    }

    public final boolean b() {
        ad.b();
        if (ad.b()) {
            return false;
        }
        if (this.e == 0) {
            ad.b();
            if (ad.c()) {
                ad.b();
                this.i = ad.b((int)this.i, 0, (int)this.d);
                if (this.i < 0) {
                    this.i = 0;
                }
            } else {
                ad.b();
                if (ad.i()) {
                    ad.b();
                    ad.c();
                    aa aa2 = this;
                    this.b = null;
                    aa2.c = null;
                    aa2.a = null;
                    return true;
                }
                ad.b();
                if (ad.g()) {
                    ad.b();
                    ad.c();
                    if (this.b.b(this.b, true)) {
                        this.b(1, this.a);
                    }
                }
            }
        } else if (this.e < 3) {
            ad.b();
            if (ad.c()) {
                ad.b();
                this.i = ad.b((int)this.i, 0, this.b.length - 1);
            } else {
                ad.b();
                if (ad.e()) {
                    ad.b();
                    this.f = ad.b((int)this.f, 0, this.b[this.i].length - 1);
                } else {
                    ad.b();
                    if (ad.g()) {
                        ad.b();
                        ad.c();
                        if (this.e == 0) {
                            this.b(0, this.a);
                        } else if (this.c[this.i][this.f] == 0) {
                            byte[] byArray = this.c[this.i];
                            byte by = this.f;
                            byArray[by] = (byte)(byArray[by] + 1);
                            this.e = (byte)(this.e + 1);
                            if (this.e == 2) {
                                this.h = this.f;
                                this.g = this.i;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void b() {
        if (this.e == 0) {
            int n2 = 20 * this.d;
            int n3 = 2;
            n3 = 10;
            aa aa2 = this;
            ah.b();
            ah.c();
            ah.b();
            ah.b("Quy t\u1eafc tr\u00f2 ch\u01a1i", 120, 22, 33, 3, 1);
            ah.b().a(7, 82, 22, 40, 0);
            ah.b().a(7, 158, 22, 36, 4);
            ah.b();
            ah.e(10, 27, 220, n2, 4);
            ah.b();
            ah.e(10, n2 + 32, 220, 60, 4);
            ah.b().b((StringBuffer[])aa2.b.c, 19, 32, 20, 0, 0);
            ah.b();
            ah.b("Ph\u00ed c\u1ea7n \u0111\u1ec3 tham gia: " + aa2.b + "Kim", 19, n2 + 52, 0, 0, 1);
            aa2.b.b(120, 320, 3, false);
            ah.b().b(true, true);
            return;
        }
        this.c(10, 2, 20 * (this.d + 3));
    }

    public final void c() {
        if (this.b <= 0) {
            if (this.b == 0) {
                this.b = (byte)-1;
                this.b.b("Tr\u00f2 ch\u01a1i th\u1ea5t b\u1ea1i!!!", -1);
                return;
            }
            if (this.b == -1 && this.b.k == 0) {
                this.b(0, this.a);
                return;
            }
        } else if (this.c <= 0) {
            if (this.c == 0) {
                this.c = (byte)-1;
                this.b.b += this.b * 125 + 100;
                this.b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c kim ti\u1ec1n: " + (this.b * 125 + 100), -1);
                this.b.l[8] = (byte[])((byte)(this.b.l[8] | 1 << this.a));
                return;
            }
            if (this.c == -1 && this.b.k == 0) {
                this.b(0, this.a);
                return;
            }
        } else if (this.e >= 3) {
            this.e = (byte)(this.e + 1);
            if (this.e > 10) {
                this.e = 1;
                return;
            }
            if (this.e == 10) {
                if (this.b[this.i][this.f] != this.b[this.g][this.h]) {
                    this.c[this.i][this.f] = 3;
                    this.c[this.g][this.h] = 3;
                    this.b = (byte)(this.b - 1);
                    return;
                }
                this.c = (byte)(this.c - 1);
                return;
            }
        } else if (this.b > 0 && (this.b = (short)(this.b - 1)) == 0) {
            for (int n2 = 0; n2 < this.c.length; n2 = (int)((byte)(n2 + 1))) {
                for (int n3 = 0; n3 < this.c[n2].length; n3 = (int)((byte)(n3 + 1))) {
                    this.c[n2][n3] = 3;
                }
            }
        }
    }

    private void b(int n2, int n3, int n4) {
        ah.b();
        ah.c();
        ah.b();
        ah.b("Quy t\u1eafc tr\u00f2 ch\u01a1i", 120, 22, 33, 3, 1);
        ah.b().a(7, 82, 22, 40, 0);
        ah.b().a(7, 158, 22, 36, 4);
        ah.b();
        ah.e(10, 27, 220, n4, 4);
        ah.b();
        ah.e(10, n4 + 32, 220, 60, 4);
        ah.b().b((StringBuffer[])this.b.c, 19, 32, 20, 0, 0);
        ah.b();
        ah.b("Ph\u00ed c\u1ea7n \u0111\u1ec3 tham gia: " + this.b + "Kim", 19, n4 + 52, 0, 0, 1);
        this.b.b(120, 320, 3, false);
        ah.b().b(true, true);
    }

    private void c(int n2, int n3, int n4) {
        ah.b();
        ah.c();
        ah.b().a(7, 82, 22, 40, 0);
        ah.b().a(7, 158, 22, 36, 4);
        ah.b();
        ah.e(10, 27, 220, n4, 4);
        ah.b();
        ah.e(10, n4 + 32, 220, 40, 4);
        for (n2 = 0; n2 < this.b.length; ++n2) {
            for (n3 = 0; n3 < this.b[n2].length; ++n3) {
                byte by = this.c[n2][n3] == 3 ? (byte)1 : this.c[n2][n3];
                int n5 = this.f + this.a + n2 * (this.d + this.h);
                int n6 = this.g + this.c + n3 * (this.e + this.h);
                int n7 = n3;
                int n8 = n2;
                aa aa2 = this;
                if (by == 0) {
                    ah.b();
                    ah.e(n6, n5, aa2.e, aa2.d, 1);
                    ah.b().a(25, n6 + (aa2.e >> 1), n5 + (aa2.d >> 1), 3, 0);
                    continue;
                }
                if (by == 1) {
                    ah.b();
                    ah.e(n6 + (aa2.e >> 1) - 2, n5 - 3, 5, aa2.d + 6, 1);
                    byte[] byArray = aa2.c[n8];
                    int n9 = n7;
                    byArray[n9] = (byte)(byArray[n9] + 1);
                    if (byArray[n9] <= 3) continue;
                    aa2.c[n8][n7] = 0;
                    continue;
                }
                ah.b();
                ah.e(n6, n5, aa2.e, aa2.d, 5);
                aa2.b.b((int)aa2.b[n8][n7], n6 + (aa2.e >> 1), n5 + (aa2.d >> 1), 3);
                ah.b().c("" + aa2.b[n8][n7], n6 + aa2.e, n5 + aa2.d, 40, 0);
            }
        }
        ah.b().c(15400191, this.g + this.c + this.f * (this.e + this.h), this.f + this.a + this.i * (this.d + this.h), this.e, this.d, 3);
        if (this.b > 0) {
            ah.b().c("" + this.b / 10, 130, 24, 36, 2);
            return;
        }
        ah.b();
        ah.b("B\u1eaft \u0111\u1ea7u tr\u00f2 ch\u01a1i", 120, 4, 17, 3, 0);
        ah.b();
        ah.b("S\u1ed1 l\u1ea7n c\u00f3 th\u1ec3 sai: " + (this.b < 0 ? 0 : this.b - 1) + "L\u1ea7n", 120, 287, 17, 0, 0);
    }

    private void b(int n2, int n3, int n4, int n5, int n6) {
        if (n6 == 0) {
            ah.b();
            ah.e(n4, n5, this.e, this.d, 1);
            ah.b().a(25, n4 + (this.e >> 1), n5 + (this.d >> 1), 3, 0);
            return;
        }
        if (n6 == 1) {
            ah.b();
            ah.e(n4 + (this.e >> 1) - 2, n5 - 3, 5, this.d + 6, 1);
            byte[] byArray = this.c[n2];
            int n7 = n3;
            byArray[n7] = (byte)(byArray[n7] + 1);
            if (byArray[n7] > 3) {
                this.c[n2][n3] = 0;
            }
            return;
        }
        ah.b();
        ah.e(n4, n5, this.e, this.d, 5);
        this.b.b((int)this.b[n2][n3], n4 + (this.e >> 1), n5 + (this.d >> 1), 3);
        ah.b().c("" + this.b[n2][n3], n4 + this.e, n5 + this.d, 40, 0);
    }
}

