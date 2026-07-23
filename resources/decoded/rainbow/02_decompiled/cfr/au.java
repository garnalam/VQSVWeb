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
public final class au
implements ao {
    private ak b;
    private byte[][] b;
    private byte[] b;
    private byte b;
    private byte c;
    private byte a;
    private byte e;
    private byte d;
    private byte h;
    private am[] b;
    private Image b;
    private short b;
    private short[][] b;
    private short[] b = new short[4];
    private short[] c;
    private short[][] c = new short[][]{{450, 3, 8}, {390, 4, 9}, {270, 7, 6}, {210, 6, 10}};

    public au(ak ak2) {
        this.b = ak2;
    }

    private void a() {
        this.b = null;
        this.b = null;
        this.c = null;
        this.b = null;
        this.b = null;
        this.b = null;
        this.b = null;
        this.c = null;
    }

    private void b(int n2, int n3, int n4, int n5) {
        ah.b();
        ah.c();
        ah.b();
        ah.b("Quy t\u1eafc tr\u00f2 ch\u01a1i", 120, 22, 33, 3, 1);
        ah.b().a(7, 82, 22, 40, 0);
        ah.b().a(7, 158, 22, 36, 4);
        ah.b();
        ah.e(9, 32, 222, 200, 4);
        ah.b();
        ah.e(10, 237, 220, 51, 4);
        ah.b().b((StringBuffer[])this.b.c, 12, 37, 17, 0, 0);
        ah.b();
        ah.b("Xin m\u1eddi l\u1ef1a ch\u1ecdn gi\u00e1 tr\u1ecb c\u01b0\u1ee3c: ", 19, 239, 0, 0, 0);
        for (n2 = 0; n2 < this.a; n2 = (int)((byte)(n2 + 1))) {
            ah.b();
            ah.e(33 + n2 * 67, 264, 38, 21, 1);
            ah.b();
            ah.b(this.b.a[n2].toString(), 35 + n2 * 67, 264, 0, 3, 0);
        }
        ah.b();
        ah.c(33 + this.b * 67, 264, 38, 21);
        ah.b().b(120, 273, 110, true, true);
        this.b.b(120, 320, 3, false);
        ah.b().b(true, true);
    }

    private void b(int n2, int n3, int n4) {
        ah.b();
        ah.c();
        ah.b();
        ah.e(10, 15, 220, 270, 4);
        ah.b();
        ah.b("Xin m\u1eddi l\u1ef1a ch\u1ecdn S\u1ee7ng V\u1eadt \u0111\u1eb7t c\u01b0\u1ee3c: ", 19, 20, 0, 0, 0);
        for (n2 = 0; n2 < this.a; n2 = (int)((byte)(n2 + 1))) {
            ah.b();
            ah.e(19 + n2 * 52, 45, 44, 76, 1);
            ah.b().b(this.b[0], 0, 19 + n2 * 52 + 22, 119, this.b[n2], 0, this.c == 1 ? this.b == n2 : false);
            ah.b().c("" + (n2 + 1), 19 + n2 * 52 + 27, 67, 20, 2);
        }
        if (this.c == 1) {
            ah.b();
            ah.c(19 + this.b * 52, 45, 44, 76);
            ah.b().b(120, 84, 118, true, true);
        }
        ah.b();
        ah.b("\u0110\u1ed9 h\u01b0ng ph\u1ea5n: ", 19, 124, 0, 0, 0);
        ak.c(6, 2, 76, 130);
        ah.b().b((StringBuffer[])this.b.c, 19, 150, 20, 0, 0);
        n4 = 155 + ((int)this.b.c).length * 20;
        ah.b();
        ah.b("Xin m\u1eddi ch\u1ecdn \u0111\u1ea1o c\u1ee5: ", 19, n4 + 15, 0, 0, 0);
        n4 = n4 + 20 + 3;
        for (n2 = 0; n2 < this.a; n2 = (int)((byte)(n2 + 1))) {
            ah.b();
            ah.e(19 + n2 * 52, n4 + 15, 44, 34, 1);
            this.b.b(12, 19 + n2 * 52 + 5, n4 + 15 + 10, 0);
            ah.b();
            ah.b("x" + n2, 19 + n2 * 52 + 21, n4 + 15 + 8, 0, 3, 1);
        }
        if (this.c == 2) {
            ah.b();
            ah.c(19 + this.b * 52, n4 + 15, 44, 34);
            ah.b().b(120, n4 + 15 + 14, 118, true, true);
        }
        this.b.b(120, 320, 3, false);
        ah.b().b(true, this.c != 1);
    }

    private void e() {
        int n2;
        ah.b();
        ah.b(5423359, 0, 0, 240, 320);
        au au2 = this;
        for (n2 = 0; n2 < au2.b.length; n2 = (int)((byte)(n2 + 1))) {
            ah.b();
            ah.b(au2.b, (int)au2.b[n2][0], au2.b[n2][1] - au2.b, 0);
        }
        for (n2 = 0; n2 < au2.b.length; n2 = (int)((byte)(n2 + 1))) {
            short s2 = au2.b[n2][1];
            short s3 = au2.b[n2][0];
            au au3 = au2;
            if (s3 < -40 || s2 - au3.b > 340) {
                au2.c(n2);
                continue;
            }
            short[] sArray = au2.b[n2];
            sArray[0] = (short)(sArray[0] - au2.b[n2][2]);
        }
        au2 = this;
        ah.b().b(au2.b[1], 0, 0, 40 - au2.b, 0, 0);
        for (n2 = 0; n2 < 5; n2 = (int)((byte)(n2 + 1))) {
            ah.b().b(au2.b[1], 1, 35 + n2 * 35, 44 - au2.b, 0, 0);
        }
        ah.b().b(au2.b[1], 0, 240, 40 - au2.b, 1, 0);
        for (byte by = 0; by < this.a; by = (byte)(by + 1)) {
            ah.b().c("" + (by + 1), 19 + by * 52 + 22, 20 - this.b, 1, 2);
            ah.b().b(this.b[0], 1, 19 + by * 52 + 22, this.b[by] - this.b, this.b[by], 0, true);
        }
        if (this.c == 3 && this.e != 0) {
            ah.b().c("" + this.e / 20, 115, 160, 0, 2);
        }
    }

    private void d() {
        int n2;
        if (this.h >= this.c.length) {
            return;
        }
        for (n2 = 0; n2 < 4 && this.b[n2] > this.c[this.h][0]; n2 = (int)((byte)(n2 + 1))) {
        }
        if (n2 >= 4) {
            return;
        }
        for (n2 = 0; n2 < 4; n2 = (int)((byte)(n2 + 1))) {
            byte[] byArray = this.b[n2];
            ad.b();
            byArray[2] = (byte)(ad.c(this.c[this.h][1]) + this.c[this.h][1]);
        }
        this.h = (byte)(this.h + 1);
    }

    public final void b(int n2, int n3) {
        this.d = (byte)n3;
        this.b = new am[3];
        this.b[0] = ad.b().b("data/npc0/67", true);
        this.b[1] = ad.b().b("data/brow/m1", true);
        ad.b();
        this.b = ad.b("data/cloud");
        this.b(n2);
    }

    private void b(int n2) {
        if (n2 <= 0) {
            this.b = 0;
            this.c = 0;
            this.a = (byte)3;
            this.b.b("Vi\u1ec7c l\u1ef1a ch\u1ecdn c\u1ee7a b\u1ea1n s\u1ebd gi\u00fap b\u1ea1n c\u00f3 c\u01a1 h\u1ed9i c\u00f3 \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt m\u1ea1nh c\u00f9ng gi\u00e1 tr\u1ecb c\u01b0\u1ee3c. C\u00e0ng nhi\u1ec1u chi\u1ebfn th\u1eafng v\u1ec1 sau ph\u1ea7n th\u01b0\u1edfng c\u00e0ng nhi\u1ec1u!#nCh\u00fa th\u00edch 1: \u0110\u1ea7u t\u01b0 100 kim, sau chi\u1ebfn th\u1eafng s\u1ebd \u0111\u01b0\u1ee3c 120 kim.#nCh\u00fa th\u00edch 2: \u0110\u1ea7u t\u01b0 300 kim, sau chi\u1ebfn th\u1eafng s\u1ebd \u0111\u01b0\u1ee3c 350 kim.#nCh\u00fa th\u00edch 3: \u0110\u1ea7u t\u01b0 1000 kim, sau chi\u1ebfn th\u1eafng s\u1ebd \u0111\u01b0\u1ee3c 1200 kim.", 200, 0);
            this.b.b("L\u01b0u \u00fd 1#nL\u01b0u \u00fd2#nL\u01b0u \u00fd 3", 200, 1);
            return;
        }
        if (n2 == 1) {
            this.b[0] = this.b;
            this.b = 0;
            this.c = 1;
            this.a = (byte)4;
            this.b.b("M\u1ed7i m\u1ed9t l\u1ea7n cung c\u1ea5p h\u01b0ng ph\u1ea5n m\u1ea5t 10 kim, l\u00e0 m\u1ed9t c\u00e1ch \u0111\u1ec3 gia t\u0103ng \u0111\u1ed9 h\u01b0ng ph\u1ea5n.", 200, 0);
            return;
        }
        if (n2 == 2) {
            this.b[1] = this.b;
            this.b = 0;
            this.c = (byte)2;
            return;
        }
        if (n2 == 3) {
            this.b[2] = this.b;
            this.b = 0;
            this.c = (byte)3;
            this.b = (short)130;
            this.h = 0;
            this.b[3] = -1;
            this.e = (byte)70;
            for (n2 = 0; n2 < this.a; n2 = (int)((byte)(n2 + 1))) {
                this.b[n2] = 450;
            }
            for (n2 = 0; n2 < this.b.length; n2 = (int)((byte)(n2 + 1))) {
                this.c(n2);
            }
        }
    }

    public final boolean b() {
        ad.b();
        if (ad.b()) {
            return false;
        }
        if (this.c == 0) {
            ad.b();
            if (ad.e()) {
                ad.b();
                this.b = ad.b((int)this.b, 0, this.a - 1);
            } else {
                ad.b();
                if (ad.g() && this.b.b((int)this.c[this.b << 1], true)) {
                    this.b(1);
                } else {
                    ad.b();
                    if (ad.i()) {
                        au au2 = this;
                        this.b = null;
                        au2.b = null;
                        au2.c = null;
                        au2.b = null;
                        au2.b = null;
                        au2.b = null;
                        au2.b = null;
                        au2.c = null;
                        return true;
                    }
                }
            }
        } else if (this.c == 1) {
            ad.b();
            if (ad.e()) {
                ad.b();
                this.b = ad.b((int)this.b, 0, this.a - 1);
            } else {
                ad.b();
                if (ad.g()) {
                    this.b(2);
                }
            }
        } else if (this.c == 2) {
            ad.b();
            if (ad.e()) {
                ad.b();
                this.b = ad.b((int)this.b, 0, this.a - 1);
            } else {
                ad.b();
                if (ad.g() && this.b.b(this.b * 10, true)) {
                    this.b(3);
                } else {
                    ad.b();
                    if (ad.i()) {
                        this.b = this.b[1];
                        this.c = 1;
                    }
                }
            }
        }
        return false;
    }

    public final void b() {
        if (this.c == 0) {
            byte by;
            int n2 = 17;
            int by2 = 200;
            int n3 = 5;
            n3 = 10;
            au au2 = this;
            ah.b();
            ah.c();
            ah.b();
            ah.b("Quy t\u1eafc tr\u00f2 ch\u01a1i", 120, 22, 33, 3, 1);
            ah.b().a(7, 82, 22, 40, 0);
            ah.b().a(7, 158, 22, 36, 4);
            ah.b();
            ah.e(9, 32, 222, 200, 4);
            ah.b();
            ah.e(10, 237, 220, 51, 4);
            ah.b().b((StringBuffer[])au2.b.c, 12, 37, 17, 0, 0);
            ah.b();
            ah.b("Xin m\u1eddi l\u1ef1a ch\u1ecdn gi\u00e1 tr\u1ecb c\u01b0\u1ee3c: ", 19, 239, 0, 0, 0);
            boolean n4 = false;
            while (by < au2.a) {
                ah.b();
                ah.e(33 + by * 67, 264, 38, 21, 1);
                ah.b();
                ah.b(au2.b.a[by].toString(), 35 + by * 67, 264, 0, 3, 0);
                by = (byte)(by + true);
            }
            ah.b();
            ah.c(33 + au2.b * 67, 264, 38, 21);
            ah.b().b(120, 273, 110, true, true);
            au2.b.b(120, 320, 3, false);
            ah.b().b(true, true);
            return;
        }
        if (this.c == 1 || this.c == 2) {
            byte by;
            int n4 = 76;
            int n5 = 15;
            n5 = 10;
            au au3 = this;
            ah.b();
            ah.c();
            ah.b();
            ah.e(10, 15, 220, 270, 4);
            ah.b();
            ah.b("Xin m\u1eddi l\u1ef1a ch\u1ecdn S\u1ee7ng V\u1eadt \u0111\u1eb7t c\u01b0\u1ee3c: ", 19, 20, 0, 0, 0);
            for (by = 0; by < au3.a; by = (byte)(by + 1)) {
                ah.b();
                ah.e(19 + by * 52, 45, 44, 76, 1);
                ah.b().b(au3.b[0], 0, 19 + by * 52 + 22, 119, au3.b[by], 0, au3.c == 1 ? au3.b == by : false);
                ah.b().c("" + (by + 1), 19 + by * 52 + 27, 67, 20, 2);
            }
            if (au3.c == 1) {
                ah.b();
                ah.c(19 + au3.b * 52, 45, 44, 76);
                ah.b().b(120, 84, 118, true, true);
            }
            ah.b();
            ah.b("\u0110\u1ed9 h\u01b0ng ph\u1ea5n: ", 19, 124, 0, 0, 0);
            ak.c(6, 2, 76, 130);
            ah.b().b((StringBuffer[])au3.b.c, 19, 150, 20, 0, 0);
            int n6 = 155 + ((int)au3.b.c).length * 20;
            ah.b();
            ah.b("Xin m\u1eddi ch\u1ecdn \u0111\u1ea1o c\u1ee5: ", 19, n6 + 15, 0, 0, 0);
            int n7 = n6 + 20 + 3;
            for (by = 0; by < au3.a; by = (byte)(by + 1)) {
                ah.b();
                ah.e(19 + by * 52, n7 + 15, 44, 34, 1);
                au3.b.b(12, 19 + by * 52 + 5, n7 + 15 + 10, 0);
                ah.b();
                ah.b("x" + by, 19 + by * 52 + 21, n7 + 15 + 8, 0, 3, 1);
            }
            if (au3.c == 2) {
                ah.b();
                ah.c(19 + au3.b * 52, n7 + 15, 44, 34);
                ah.b().b(120, n7 + 15 + 14, 118, true, true);
            }
            au3.b.b(120, 320, 3, false);
            ah.b().b(true, au3.c != 1);
            return;
        }
        this.e();
    }

    public final void c() {
        if (this.c == 3) {
            if (this.e == 0) {
                int n2;
                au au2 = this;
                if (au2.h < au2.c.length) {
                    for (n2 = 0; n2 < 4 && au2.b[n2] > au2.c[au2.h][0]; n2 = (int)((byte)(n2 + 1))) {
                    }
                    if (n2 < 4) {
                        for (n2 = 0; n2 < 4; n2 = (int)((byte)(n2 + 1))) {
                            byte[] byArray = au2.b[n2];
                            ad.b();
                            byArray[2] = (byte)(ad.c(au2.c[au2.h][1]) + au2.c[au2.h][1]);
                        }
                        au2.h = (byte)(au2.h + 1);
                    }
                }
                if (this.b[3] != -1) {
                    this.e = (byte)5;
                    this.c = (byte)4;
                    return;
                }
                n2 = -1;
                for (int n3 = 0; n3 < 4; n3 = (int)((byte)(n3 + 1))) {
                    int n4 = n3;
                    this.b[n4] = (short)(this.b[n4] - this.b[n3][2]);
                    if (this.b[n3] - this.b < 160) {
                        n2 = n3;
                    }
                    if (this.b[n3] >= 70 || this.b[3] != -1) continue;
                    this.b[3] = n3;
                }
                if (n2 != -1) {
                    this.b = (short)(this.b - this.b[n2][2]);
                }
                if (this.b < 0) {
                    this.b = 0;
                }
                return;
            }
            this.e = (byte)(this.e - 1);
            return;
        }
        if (this.c == 4) {
            if (this.e == 3) {
                if (this.b[3] == this.b[1]) {
                    this.b.b += this.c[(this.b[0] << 1) + 1];
                    this.b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c: " + this.c[(this.b[0] << 1) + 1] + "Kim", 0);
                    this.b.l[4] = (byte[])((byte)(this.b.l[4] | 1 << this.d));
                } else {
                    this.b.b("R\u1ea5t ti\u1ebfc, kh\u00f4ng \u0111\u00fang.", 0);
                }
            }
            if (this.e > 0) {
                this.e = (byte)(this.e - 1);
                return;
            }
            if (this.e == 0 && this.b.k == 0) {
                this.b(0);
            }
        }
    }

    private void c(int n2) {
        short[] sArray = this.b[n2];
        ad.b();
        sArray[0] = (short)(240 + ad.c(120));
        short[] sArray2 = this.b[n2];
        ad.b();
        sArray2[1] = (short)(this.b - 80 + n2 * (ad.c(25) + 55));
        short[] sArray3 = this.b[n2];
        ad.b();
        sArray3[2] = (short)(ad.c(5) + 2);
    }

    private void h() {
        int n2;
        for (n2 = 0; n2 < this.b.length; n2 = (int)((byte)(n2 + 1))) {
            ah.b();
            ah.b(this.b, (int)this.b[n2][0], this.b[n2][1] - this.b, 0);
        }
        for (n2 = 0; n2 < this.b.length; n2 = (int)((byte)(n2 + 1))) {
            short s2 = this.b[n2][1];
            short s3 = this.b[n2][0];
            au au2 = this;
            if (s3 < -40 || s2 - au2.b > 340) {
                this.c(n2);
                continue;
            }
            short[] sArray = this.b[n2];
            sArray[0] = (short)(sArray[0] - this.b[n2][2]);
        }
    }

    private boolean b(int n2, int n3) {
        return n2 < -40 || n3 - this.b > 340;
    }

    private void g() {
        ah.b().b(this.b[1], 0, 0, 40 - this.b, 0, 0);
        for (int n2 = 0; n2 < 5; n2 = (int)((byte)(n2 + 1))) {
            ah.b().b(this.b[1], 1, 35 + n2 * 35, 44 - this.b, 0, 0);
        }
        ah.b().b(this.b[1], 0, 240, 40 - this.b, 1, 0);
    }
}

