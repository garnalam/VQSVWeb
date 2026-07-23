/*
 * Decompiled with CFR 0.152.
 */
public final class ac
extends Thread {
    private ak b;

    public ac(ak ak2, int n2) {
        this.b = ak2;
        this.b.var_byte_e = (byte)n2;
        new Thread(this).start();
    }

    public final void run() {
        try {
            this.b.var_byte_a = 0;
            if (this.b.var_byte_e == 0) {
                this.b.var_at_b.a();
                ak ak2 = this.b;
                ad.ad_b();
                this.b.var_byte_arr_h = ad.byte_arr_b(4, null, 1);
                ak2.var_byte_arr_g = new byte[]{16, 19, 23, 12};
                ((as)ak2).j = new byte[4];
                int n2 = 0;
                int n3 = 0;
                if (ak2.var_byte_arr_h[0] != -1) {
                    for (n2 = 0; n2 < 4; ++n2) {
                        ((as)ak2).j[n2] = ak2.var_byte_arr_h[n2];
                    }
                }
                ak2.var_byte_arr_arr_arr_b = new byte[((as)ak2).j.length][][];
                int n4 = 0;
                for (n2 = 0; n2 < ak2.var_byte_arr_arr_arr_b.length; ++n2) {
                    ak2.var_byte_arr_arr_arr_b[n2] = new byte[ak2.var_byte_arr_g[n2]][2];
                    n3 = 0;
                    while (n3 < ((as)ak2).j[n2]) {
                        ak2.var_byte_arr_arr_arr_b[n2][n3][0] = ak2.var_byte_arr_h[(n4 << 1) + 4];
                        ak2.var_byte_arr_arr_arr_b[n2][n3][1] = ak2.var_byte_arr_h[(n4 << 1) + 4 + 1];
                        ++n3;
                        ++n4;
                    }
                }
                ak2.var_byte_arr_h = null;
                ak2.var_byte_arr_g = null;
                this.b.b(0, this.b.var_byte_arr_arr_d);
                this.b.b(1, this.b.var_byte_arr_arr_d);
                ak2 = this.b;
                ad.ad_b();
                this.b.var_byte_arr_h = ad.byte_arr_b(6, null, 1);
                if (ak2.var_byte_arr_h[0] == -1) {
                    ((as)ak2).k = new byte[105];
                    for (n2 = 0; n2 < ((as)ak2).k.length; ++n2) {
                        ((as)ak2).k[n2] = 0;
                    }
                } else {
                    ((as)ak2).k = ak2.var_byte_arr_h;
                }
                ak2.var_byte_arr_h = null;
            } else if (this.b.var_byte_e == 1) {
                this.b.m();
            }
            this.b.var_byte_a = (byte)-1;
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }
}

