/*
 * Decompiled with CFR 0.152.
 */
public final class al {
    public byte[] var_byte_arr_b;
    public short[] var_short_arr_b;
    public byte var_byte_b;
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
                        this.var_short_arr_b = new short[8];
                        this.var_byte_arr_b = new byte[18];
                        this.var_byte_arr_b[0] = (byte)n2;
                        this.var_byte_arr_b[2] = (byte)n3;
                        byArray = ak2.var_byte_arr_arr_d[n2];
                        this.var_byte_arr_b[3] = byArray[6];
                        this.var_byte_arr_b[4] = byArray[5];
                        this.var_byte_arr_b[5] = byArray[12];
                        this.var_byte_arr_b[8] = 25;
                        this.var_byte_arr_b[9] = -1;
                        this.var_byte_arr_b[10] = -1;
                        this.var_byte_arr_b[11] = -1;
                        this.var_byte_arr_b[12] = -1;
                        this.var_byte_arr_b[13] = -1;
                        this.var_byte_arr_b[14] = -1;
                        this.var_byte_arr_b[15] = -1;
                        if (n4 != -1) break block7;
                        this.var_byte_arr_b[16] = (byte)((this.var_byte_arr_b[3] << 1) + 4);
                        this.var_byte_arr_b[17] = 2;
                        break block8;
                    }
                    if (n4 != 0) break block9;
                    int n7 = (this.var_byte_arr_b[3] << 1) + 3;
                    ad.ad_b();
                    this.var_byte_arr_b[16] = (byte)(n7 + ad.c(2));
                    byArray2 = this.var_byte_arr_b;
                    n6 = 17;
                    ad.ad_b();
                    n5 = ad.c(3);
                    break block10;
                }
                if (n4 != 1) break block8;
                int n8 = (this.var_byte_arr_b[3] << 1) + 3;
                ad.ad_b();
                this.var_byte_arr_b[16] = (byte)(n8 + (ad.c(100) < 70 ? 1 : 0));
                byArray2 = this.var_byte_arr_b;
                n6 = 17;
                ad.ad_b();
                if (ad.c(100) < 70) {
                    n5 = 2;
                } else {
                    ad.ad_b();
                    n5 = ad.c(2);
                }
            }
            byArray2[n6] = (byte)n5;
        }
        this.var_byte_arr_b[6] = (byte)(this.var_byte_arr_b[4] > 3 ? 120 : 100);
        this.var_short_arr_b[2] = (short)(byArray[0] + byArray[7] * n3 / 10);
        this.var_short_arr_b[3] = (short)(byArray[1] + byArray[8] * n3 / 10);
        this.var_short_arr_b[1] = this.var_short_arr_b[3];
        this.var_short_arr_b[0] = this.var_short_arr_b[2];
        this.var_short_arr_b[4] = 0;
        this.b(byArray);
        if (this.var_byte_arr_b[3] != -1) {
            ak2.a(this);
        }
        if (ak2.var_byte_arr_arr_k[n2] == false) {
            ak2.var_byte_arr_arr_k[n2] = (byte[])true;
            ak2.var_byte_arr_arr_k[102] = (byte[])((byte)(ak2.var_byte_arr_arr_k[102] + true));
            ak2.b("S\u1ee7ng V\u1eadt minh h\u1ecda \u0111\u00e3 \u0111\u1ed5i m\u1edbi", 0);
        }
        this.var_byte_b = (byte)7;
        this.c = 0;
    }

    public al() {
    }

    public final void b(byte[] byArray) {
        this.var_short_arr_b[5] = (short)(byArray[2] + byArray[9] * this.var_byte_arr_b[2] / 10);
        this.var_short_arr_b[6] = (short)(byArray[3] + byArray[10] * this.var_byte_arr_b[2] / 10);
        this.var_short_arr_b[7] = (short)(byArray[4] + byArray[11] * this.var_byte_arr_b[2] / 10);
    }

    public final boolean boolean_b(int n2) {
        return this.var_byte_b == n2;
    }

    public final boolean c(int n2) {
        return this.var_byte_b == n2 && this.c != 0;
    }

    public final boolean a(int n2) {
        return this.var_byte_arr_b[14] == n2 || this.var_byte_arr_b[15] == n2;
    }

    public final boolean e(int n2) {
        return this.var_byte_arr_b[16] == n2 || this.var_byte_arr_b[17] == n2;
    }

    public final void b(ak ak2, int n2) {
        if (n2 >= 0) {
            this.var_byte_arr_b[5] = (byte)n2;
        } else if (n2 == -1) {
            ad.ad_b();
            this.var_byte_arr_b[5] = (byte)ad.c(this.var_byte_arr_b[5] + 1);
        }
        this.b(ak2);
    }

    public final void b(ak ak2) {
        if (this.e(2)) {
            this.var_short_arr_b[2] = (short)(this.var_short_arr_b[2] + this.var_short_arr_b[2] * ak2.var_byte_arr_a[2] / 100);
        } else if (this.e(1)) {
            this.var_short_arr_b[2] = (short)(this.var_short_arr_b[2] + this.var_short_arr_b[2] * ak2.var_byte_arr_a[1] / 100);
        }
        if (this.var_short_arr_b[2] <= 0) {
            this.var_short_arr_b[2] = 1;
        }
        this.var_short_arr_b[0] = this.var_short_arr_b[2];
    }

    public final void b(int n2, int n3, int n4) {
        this.var_byte_arr_b[16] = (byte)((this.var_byte_arr_b[3] << 1) + 4);
        this.var_byte_arr_b[17] = 2;
        this.var_byte_arr_b[14] = (byte)n2;
        this.var_byte_arr_b[15] = (byte)n3;
        this.var_byte_arr_b[6] = (byte)n4;
    }

    public final void void_b(int n2) {
        this.var_byte_arr_b[16] = 4;
        this.var_byte_arr_b[17] = 10;
        this.var_byte_arr_b[9] = 4;
        this.var_byte_arr_b[10] = 9;
        this.var_byte_arr_b[11] = 14;
        this.var_byte_arr_b[12] = 19;
        this.var_byte_arr_b[13] = 24;
        this.var_byte_arr_b[14] = 30;
        this.var_byte_arr_b[15] = 48;
        this.var_byte_arr_b[6] = (byte)n2;
    }

    public final void b(ak ak2, int n2, int n3) {
        this.var_byte_arr_b[0] = (byte)n2;
        byte[] byArray = ak2.var_byte_arr_arr_d[n2];
        this.var_byte_arr_b[4] = byArray[5];
        this.var_byte_arr_b[5] = (byte)(this.var_byte_arr_b[5] - n3);
        this.b(byArray);
        this.var_short_arr_b[2] = (short)(byArray[0] + byArray[7] * this.var_byte_arr_b[2] / 10);
        this.var_short_arr_b[3] = (short)(byArray[1] + byArray[8] * this.var_byte_arr_b[2] / 10);
        this.b(ak2);
        this.var_short_arr_b[1] = this.var_short_arr_b[3];
        if (ak2.var_byte_arr_arr_k[n2] != 2) {
            if (ak2.var_byte_arr_arr_k[n2] == false) {
                ak2.var_byte_arr_arr_k[102] = (byte[])((byte)(ak2.var_byte_arr_arr_k[102] + true));
            }
            ak2.g();
            ak2.var_byte_arr_arr_k[n2] = (byte[])2;
        }
    }
}

