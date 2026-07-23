/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class al {
    public byte[] b;
    public short[] b;
    public byte b;
    public byte c;

    public al(ak ak2, int n2, int n3, int n4) {
        byte[] byArray;
        block8: {
            int n5;
            block10: {
                int n6;
                byte[] byArray2;
                block9: {
                    block7: {
                        this.b = new short[8];
                        this.b = new byte[18];
                        this.b[0] = (byte)n2;
                        this.b[2] = (byte)n3;
                        byArray = ak2.d[n2];
                        this.b[3] = byArray[6];
                        this.b[4] = byArray[5];
                        this.b[5] = byArray[12];
                        this.b[8] = 25;
                        this.b[9] = -1;
                        this.b[10] = -1;
                        this.b[11] = -1;
                        this.b[12] = -1;
                        this.b[13] = -1;
                        this.b[14] = -1;
                        this.b[15] = -1;
                        if (n4 != -1) break block7;
                        this.b[16] = (byte)((this.b[3] << 1) + 4);
                        this.b[17] = 2;
                        break block8;
                    }
                    if (n4 != 0) break block9;
                    int n7 = (this.b[3] << 1) + 3;
                    ad.b();
                    this.b[16] = (byte)(n7 + ad.c(2));
                    byArray2 = this.b;
                    n6 = 17;
                    ad.b();
                    n5 = ad.c(3);
                    break block10;
                }
                if (n4 != 1) break block8;
                int n8 = (this.b[3] << 1) + 3;
                ad.b();
                this.b[16] = (byte)(n8 + (ad.c(100) < 70 ? 1 : 0));
                byArray2 = this.b;
                n6 = 17;
                ad.b();
                if (ad.c(100) < 70) {
                    n5 = 2;
                } else {
                    ad.b();
                    n5 = ad.c(2);
                }
            }
            byArray2[n6] = (byte)n5;
        }
        this.b[6] = (byte)(this.b[4] > 3 ? 120 : 100);
        this.b[2] = (short)(byArray[0] + byArray[7] * n3 / 10);
        this.b[3] = (short)(byArray[1] + byArray[8] * n3 / 10);
        this.b[1] = this.b[3];
        this.b[0] = this.b[2];
        this.b[4] = 0;
        this.b(byArray);
        if (this.b[3] != -1) {
            ak2.a(this);
        }
        if (ak2.k[n2] == false) {
            ak2.k[n2] = (byte[])true;
            ak2.k[102] = (byte[])((byte)(ak2.k[102] + true));
            ak2.b("S\u1ee7ng V\u1eadt minh h\u1ecda \u0111\u00e3 \u0111\u1ed5i m\u1edbi", 0);
        }
        this.b = (byte)7;
        this.c = 0;
    }

    public al() {
    }

    public final void b(byte[] byArray) {
        this.b[5] = (short)(byArray[2] + byArray[9] * this.b[2] / 10);
        this.b[6] = (short)(byArray[3] + byArray[10] * this.b[2] / 10);
        this.b[7] = (short)(byArray[4] + byArray[11] * this.b[2] / 10);
    }

    public final boolean b(int n2) {
        return this.b == n2;
    }

    public final boolean c(int n2) {
        return this.b == n2 && this.c != 0;
    }

    public final boolean a(int n2) {
        return this.b[14] == n2 || this.b[15] == n2;
    }

    public final boolean e(int n2) {
        return this.b[16] == n2 || this.b[17] == n2;
    }

    public final void b(ak ak2, int n2) {
        if (n2 >= 0) {
            this.b[5] = (byte)n2;
        } else if (n2 == -1) {
            ad.b();
            this.b[5] = (byte)ad.c(this.b[5] + 1);
        }
        this.b(ak2);
    }

    public final void b(ak ak2) {
        if (this.e(2)) {
            this.b[2] = (short)(this.b[2] + this.b[2] * ak2.a[2] / 100);
        } else if (this.e(1)) {
            this.b[2] = (short)(this.b[2] + this.b[2] * ak2.a[1] / 100);
        }
        if (this.b[2] <= 0) {
            this.b[2] = 1;
        }
        this.b[0] = this.b[2];
    }

    public final void b(int n2, int n3, int n4) {
        this.b[16] = (byte)((this.b[3] << 1) + 4);
        this.b[17] = 2;
        this.b[14] = (byte)n2;
        this.b[15] = (byte)n3;
        this.b[6] = (byte)n4;
    }

    public final void b(int n2) {
        this.b[16] = 4;
        this.b[17] = 10;
        this.b[9] = 4;
        this.b[10] = 9;
        this.b[11] = 14;
        this.b[12] = 19;
        this.b[13] = 24;
        this.b[14] = 30;
        this.b[15] = 48;
        this.b[6] = (byte)n2;
    }

    public final void b(ak ak2, int n2, int n3) {
        this.b[0] = (byte)n2;
        byte[] byArray = ak2.d[n2];
        this.b[4] = byArray[5];
        this.b[5] = (byte)(this.b[5] - n3);
        this.b(byArray);
        this.b[2] = (short)(byArray[0] + byArray[7] * this.b[2] / 10);
        this.b[3] = (short)(byArray[1] + byArray[8] * this.b[2] / 10);
        this.b(ak2);
        this.b[1] = this.b[3];
        if (ak2.k[n2] != 2) {
            if (ak2.k[n2] == false) {
                ak2.k[102] = (byte[])((byte)(ak2.k[102] + true));
            }
            ak2.g();
            ak2.k[n2] = (byte[])2;
        }
    }
}

