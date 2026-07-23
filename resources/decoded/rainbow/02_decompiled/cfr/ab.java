/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Image;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ab
implements ao {
    private ak b;
    private byte b;
    private byte c;
    private byte a;
    private byte e;
    private short b;
    private short c;
    private short a;
    private short e;
    private short d;
    private short[][] b;
    private short[][] c;
    private short[] b;
    private short[][] a;
    private short[] c;
    private short h;
    private am[] b;
    private Image b;
    private am b;
    private byte[] b = new short[][]{{9, 1, 10, 2, 11, 4, 27, 8, 2, -10}, {50, 100, 150, 200}, {60, 40, 30, 10}, {8, 6, 13, 3, 20, 5, 30, 10}};

    public ab(ak ak2) {
        this.c = new short[][]{{10, 20, 60, 10, 220}, {13, 40, 60, 12, 170}, {10, 40, 60, 10, 120}};
        this.b = new short[]{150, 200, 300, 450};
        this.a = new short[40][7];
        this.c = new short[]{0, 275, 67, 10, 0};
        this.b = new byte[]{20, 15, 10, 5};
        this.b = ak2;
        this.d = (short)240;
    }

    private void a() {
        this.b = null;
        this.b = null;
        this.b = null;
        this.b = null;
        this.c = null;
    }

    public final void b(int n2, int n3) {
        this.e = (byte)n3;
        this.b = new am[2];
        this.b[0] = ad.b().b("data/npc2/38", true);
        ad.b();
        this.b = ad.b("data/brow/m0");
        byte[] byArray = ad.b().b("data/gamee.data", -1);
        ad.b();
        ad.c = 0;
        ad.b();
        this.b = am.b(ad.b("data/map/5"), ad.b().b(byArray, 2), ad.b().b(byArray, 2), ad.b().b(byArray, 2));
        this.b(n2);
    }

    private void b(int n2) {
        if (n2 <= 0) {
            this.b = 0;
            this.c = (byte)10;
            this.b.b("Trong m\u1ed9t th\u1eddi gian gi\u1edbi h\u1ea1n c\u00e0ng nhi\u1ec1u b\u00f3ng v\u00e0o h\u1ed9p c\u00e0ng t\u1ed1t. S\u1ed1 \u0111i\u1ec3m b\u00f3ng \u0111\u1ea1t \u0111\u01b0\u1ee3c s\u1ebd \u0111\u01b0\u1ee3c t\u00ednh l\u00e0m c\u0103n c\u1ee9 \u0111\u1ed5i l\u1ea5y kim ti\u1ec1n.", 200, 0);
            return;
        }
        if (n2 == 1) {
            this.b = 1;
            this.h = 0;
            this.a = 0;
            this.b = this.b[1][this.e];
            this.b(true);
            for (n2 = 0; n2 < this.a.length; n2 = (int)((byte)(n2 + 1))) {
                this.a[n2][5] = -1;
            }
        }
    }

    public final boolean b() {
        if (this.b == 0) {
            ad.b();
            if (ad.g() && this.b.b((int)this.b[this.e], true)) {
                this.b(1);
            } else {
                ad.b();
                if (ad.i()) {
                    ab ab2 = this;
                    this.b = null;
                    ab2.b = null;
                    ab2.b = null;
                    ab2.b = null;
                    ab2.c = null;
                    return true;
                }
            }
        } else if (this.b == 1) {
            ad.b();
            if (ad.d()) {
                this.c[0] = (short)(this.c[0] - 10);
                if (this.c[0] < 0) {
                    this.c[0] = 0;
                }
            } else {
                ad.b();
                if (ad.h()) {
                    this.c[0] = (short)(this.c[0] + 10);
                    if (this.c[0] + this.c[2] > this.d - 20) {
                        this.c[0] = (short)(this.d - this.c[2] - 20);
                    }
                }
            }
        }
        return false;
    }

    public final void b() {
        if (this.b == 0) {
            int n2 = 20 * this.c;
            int n3 = 2;
            n3 = 10;
            ab ab2 = this;
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
            ah.b().b((StringBuffer[])ab2.b.c, 19, 32, 20, 0, 0);
            int n4 = 42 + ((int)ab2.b.c).length * 20;
            ah.b();
            ah.b("\u0110i\u1ec3m c\u1ee7a c\u00e1c ch\u1ee7ng lo\u1ea1i b\u00f3ng kh\u00e1c nhau: ", 19, n4, 0, 0, 0);
            n4 += 40;
            for (int i2 = 0; i2 < ab2.b[0].length; i2 += 2) {
                ab2.b.b((int)ab2.b[0][i2], 38 + (i2 % 4 == 2 ? 76 : 0), n4 + (i2 >> 2) * 25, 0);
                ah.b();
                ah.b((ab2.b[0][i2 + 1] < 0 ? "" : "+") + ab2.b[0][i2 + 1], 38 + (i2 % 4 == 2 ? 76 : 0) + 16, n4 + (i2 >> 2) * 25 - 4, 0, 0, 1);
            }
            ah.b();
            ah.b("Ph\u00ed c\u1ea7n \u0111\u1ec3 tham gia: " + ab2.b[ab2.e] + "Kim", 19, n2 + 52, 0, 0, 1);
            ab2.b.b(120, 320, 3, false);
            ah.b().b(true, true);
            return;
        }
        this.e();
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
        n3 = 42 + ((int)this.b.c).length * 20;
        ah.b();
        ah.b("\u0110i\u1ec3m c\u1ee7a c\u00e1c ch\u1ee7ng lo\u1ea1i b\u00f3ng kh\u00e1c nhau: ", 19, n3, 0, 0, 0);
        n3 += 40;
        for (n2 = 0; n2 < this.b[0].length; n2 += 2) {
            this.b.b((int)this.b[0][n2], 38 + (n2 % 4 == 2 ? 76 : 0), n3 + (n2 >> 2) * 25, 0);
            ah.b();
            ah.b((this.b[0][n2 + 1] < 0 ? "" : "+") + this.b[0][n2 + 1], 38 + (n2 % 4 == 2 ? 76 : 0) + 16, n3 + (n2 >> 2) * 25 - 4, 0, 0, 1);
        }
        ah.b();
        ah.b("Ph\u00ed c\u1ea7n \u0111\u1ec3 tham gia: " + this.b[this.e] + "Kim", 19, n4 + 52, 0, 0, 1);
        this.b.b(120, 320, 3, false);
        ah.b().b(true, true);
    }

    private void e() {
        int n2;
        ah.b();
        ah.b(5423359, 0, 0, 240, 320);
        ah.b().b(this.b, 0, this.d / 2, 160, 0);
        ah.b();
        ah.b("\u0110i\u1ec3m: " + this.h, 0, 0, 20, 3, 1);
        ah.b();
        ah.b("T\u1ed5ng s\u1ed1 b\u00f3ng: " + this.b, (int)this.d, 0, 24, 3, 1);
        ah.b();
        ah.b(this.b, (int)this.d, 305, 40);
        for (n2 = 0; n2 < this.a.length; n2 = (int)((byte)(n2 + 1))) {
            if (this.a[n2][5] == -1) continue;
            this.b.b((int)this.b[0][this.a[n2][6] << 1], (int)this.a[n2][0], (int)this.a[n2][1], 0);
        }
        for (n2 = 0; n2 < 2; n2 = (int)((byte)(n2 + 1))) {
            ah.b().b(this.b[0], this.c[4] == 0 ? 3 : 4, this.c[0] + n2 * 30 + 20, this.c[1] + 25, 0);
        }
    }

    private void c(int n2) {
        this.a[this.a][0] = -20;
        this.a[this.a][1] = this.c[n2][4];
        this.a[this.a][2] = (short)(this.c[n2][1] / this.c[n2][0]);
        this.a[this.a][4] = this.c[n2][0];
        this.a[this.a][5] = (short)n2;
        this.a[this.a][3] = this.c[n2][3];
        short[] sArray = this.a[this.a];
        ad.b();
        sArray[6] = (short)ad.c(this.b[0].length >> 1);
        this.a = (byte)(this.a + 1);
        if (this.a >= this.a.length) {
            this.a = 0;
        }
    }

    private void b(boolean bl) {
        this.a = (short)(bl ? 10 : this.b[2][this.e]);
        this.e = this.b[this.e];
        ad.b();
        this.c = (short)(ad.c(this.b[3][this.e << 1]) + this.b[3][(this.e << 1) + 1]);
    }

    private void a(int n2) {
        if (this.a[n2][4] > 0 && this.a[n2][3] > 1) {
            short[] sArray = this.a[n2];
            sArray[3] = (short)(sArray[3] - 1);
            return;
        }
        if (this.a[n2][4] == 0) {
            this.a[n2][3] = 0;
            return;
        }
        if (this.a[n2][4] < 0 && this.a[n2][3] > -this.c[this.a[n2][5]][3]) {
            short[] sArray = this.a[n2];
            sArray[3] = (short)(sArray[3] - 1);
        }
    }

    private boolean b(int n2) {
        boolean bl = this.a[n2][1] > 330;
        ad.b();
        if (ad.b(this.d - 10, 280, 20, 10, this.a[n2][0], this.a[n2][1], 16, 16) || this.a[n2][0] > this.d && this.a[n2][1] < this.c[1]) {
            bl = true;
            this.h = (short)(this.h + this.b[0][(this.a[n2][6] << 1) + 1]);
        }
        return bl;
    }

    private boolean c(int n2) {
        ad.b();
        return ad.b(this.c[0], this.c[1], this.c[2], this.c[3], this.a[n2][0], this.a[n2][1], 16, 16);
    }

    public final void c() {
        if (this.b == 1) {
            ab ab2;
            int n2;
            if (this.b > 0) {
                if (this.a > 0) {
                    this.a = (short)(this.a - 1);
                } else if (this.e > 0) {
                    this.e = (short)(this.e - 1);
                } else if (this.c > 0) {
                    this.e = this.b[this.e];
                    ad.b();
                    n2 = ad.c(this.c.length);
                    ab2 = this;
                    ab2.a[ab2.a][0] = -20;
                    ab2.a[ab2.a][1] = ab2.c[n2][4];
                    ab2.a[ab2.a][2] = (short)(ab2.c[n2][1] / ab2.c[n2][0]);
                    ab2.a[ab2.a][4] = ab2.c[n2][0];
                    ab2.a[ab2.a][5] = (short)n2;
                    ab2.a[ab2.a][3] = ab2.c[n2][3];
                    short[] sArray = ab2.a[ab2.a];
                    ad.b();
                    sArray[6] = (short)ad.c(ab2.b[0].length >> 1);
                    ab2.a = (byte)(ab2.a + 1);
                    if (ab2.a >= ab2.a.length) {
                        ab2.a = 0;
                    }
                    this.c = (short)(this.c - 1);
                    this.b = (short)(this.b - 1);
                } else if (this.c == 0) {
                    this.b(false);
                }
            }
            if (this.c[4] > 0) {
                this.c[4] = (short)(this.c[4] - 1);
            }
            boolean bl = true;
            for (int n3 = 0; n3 < this.a.length; n3 = (int)((byte)(n3 + 1))) {
                if (this.a[n3][5] == -1) continue;
                bl = false;
                short[] sArray = this.a[n3];
                sArray[0] = (short)(sArray[0] + this.a[n3][2]);
                short[] sArray2 = this.a[n3];
                sArray2[1] = (short)(sArray2[1] - this.a[n3][3]);
                n2 = n3;
                ab2 = this;
                if (ab2.a[n2][4] > 0 && ab2.a[n2][3] > 1) {
                    short[] sArray3 = ab2.a[n2];
                    sArray3[3] = (short)(sArray3[3] - 1);
                } else if (ab2.a[n2][4] == 0) {
                    ab2.a[n2][3] = 0;
                } else if (ab2.a[n2][4] < 0 && ab2.a[n2][3] > -ab2.c[ab2.a[n2][5]][3]) {
                    short[] sArray4 = ab2.a[n2];
                    sArray4[3] = (short)(sArray4[3] - 1);
                }
                short[] sArray5 = this.a[n3];
                sArray5[4] = (short)(sArray5[4] - 1);
                n2 = n3;
                ab2 = this;
                boolean bl2 = ab2.a[n2][1] > 330;
                ad.b();
                if (ad.b(ab2.d - 10, 280, 20, 10, ab2.a[n2][0], ab2.a[n2][1], 16, 16) || ab2.a[n2][0] > ab2.d && ab2.a[n2][1] < ab2.c[1]) {
                    bl2 = true;
                    ab2.h = (short)(ab2.h + ab2.b[0][(ab2.a[n2][6] << 1) + 1]);
                }
                if (bl2) {
                    this.a[n3][5] = -1;
                    continue;
                }
                n2 = n3;
                ab2 = this;
                ad.b();
                if (!ad.b(ab2.c[0], ab2.c[1], ab2.c[2], ab2.c[3], ab2.a[n2][0], ab2.a[n2][1], 16, 16)) continue;
                this.a[n3][4] = this.c[this.a[n3][5]][0];
                this.c[4] = 1;
                this.a[n3][3] = this.c[this.a[n3][5]][3];
            }
            if (this.b <= 0 && bl) {
                this.h = (short)(this.h * 15 / 10);
                this.b.b += this.h;
                this.b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c: " + this.h + "Kim", 0);
                if (this.h > 0) {
                    this.b.l[6] = (byte[])((byte)(this.b.l[6] | 1 << this.e));
                }
                this.b = (byte)2;
            }
            return;
        }
        if (this.b == 2 && this.b.k == 0) {
            this.b(0);
        }
    }
}

