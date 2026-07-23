/*
 * Decompiled with CFR 0.152.
 */
public final class ac
extends Thread {
    private ak b;

    public ac(ak ak2, int n2) {
        this.b = ak2;
        this.b.e = (byte)n2;
        new Thread(this).start();
    }

    public final void run() {
        try {
            this.b.a = 0;
            if (this.b.e == 0) {
                this.b.b.a();
                ak ak2 = this.b;
                ad.b();
                ((as)this.b).h = ad.b(4, null, 1);
                ((as)ak2).g = new byte[]{16, 19, 23, 12};
                ((as)ak2).j = new byte[4];
                int n2 = 0;
                int n3 = 0;
                if (((as)ak2).h[0] != -1) {
                    for (n2 = 0; n2 < 4; ++n2) {
                        ((as)ak2).j[n2] = ((as)ak2).h[n2];
                    }
                }
                ((as)ak2).b = new byte[((as)ak2).j.length][][];
                int n4 = 0;
                for (n2 = 0; n2 < ((as)ak2).b.length; ++n2) {
                    ((as)ak2).b[n2] = new byte[((as)ak2).g[n2]][2];
                    n3 = 0;
                    while (n3 < ((as)ak2).j[n2]) {
                        ((as)ak2).b[n2][n3][0] = ((as)ak2).h[(n4 << 1) + 4];
                        ((as)ak2).b[n2][n3][1] = ((as)ak2).h[(n4 << 1) + 4 + 1];
                        ++n3;
                        ++n4;
                    }
                }
                ((as)ak2).h = null;
                ((as)ak2).g = null;
                this.b.b(0, this.b.d);
                this.b.b(1, this.b.d);
                ak2 = this.b;
                ad.b();
                ((as)this.b).h = ad.b(6, null, 1);
                if (((as)ak2).h[0] == -1) {
                    ((as)ak2).k = new byte[105];
                    for (n2 = 0; n2 < ((as)ak2).k.length; ++n2) {
                        ((as)ak2).k[n2] = 0;
                    }
                } else {
                    ((as)ak2).k = ((as)ak2).h;
                }
                ((as)ak2).h = null;
            } else if (this.b.e == 1) {
                this.b.m();
            }
            this.b.a = (byte)-1;
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }
}

