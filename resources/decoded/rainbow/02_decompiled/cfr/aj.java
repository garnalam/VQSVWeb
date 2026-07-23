/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class aj {
    public short b;
    public short c;
    public boolean b;
    public boolean c;
    public boolean a;
    private byte q = 0;
    public byte b;
    public byte c = 1;
    public byte a = false;
    public byte e;
    public byte d;
    public byte h;
    public byte g;
    public byte f;
    public byte i;
    public byte j;
    public byte k;
    public byte l;
    public byte m;
    public byte n;
    public byte[] b = (byte)-1;
    public byte p = 0;
    public byte o = 0;

    public aj() {
        this.h = (byte)127;
        this.g = (byte)5;
        this.j = (byte)-1;
        this.k = (byte)-1;
        this.l = (byte)-1;
        this.n = (byte)3;
    }

    public aj(int n2) {
        this.h = (byte)127;
        this.g = (byte)5;
        this.j = (byte)-1;
        this.k = (byte)-1;
        this.l = (byte)-1;
        this.n = (byte)3;
        this.b = new byte[n2];
    }

    public final void b() {
        this.b(this.b[0], this.b[1], 0, 0);
    }

    public final void c() {
        this.b[0] = this.b();
        this.b[1] = this.c();
    }

    public final void b(boolean bl) {
        if (this.a) {
            return;
        }
        this.b[7] = this.n == 2 ? (bl ? 3 : 0) : (this.n == 1 ? (bl ? 4 : 1) : (bl ? 5 : 2));
        this.b[7] = (byte)(this.b[7] + this.q * 6);
    }

    public final void b(int n2) {
        this.q = (byte)(this.b[7] / 6);
        if ((this.q + 1) * 6 > n2) {
            this.q = 0;
        }
    }

    public final void b(int n2, int n3) {
        this.e = (byte)n2;
        this.d = (byte)n3;
    }

    public final void c(int n2, int n3) {
        this.k = (byte)n2;
        this.l = (byte)n3;
    }

    public final void b(boolean bl, int n2) {
        this.a = bl;
        this.h = (byte)n2;
    }

    public final void b(int n2, int n3, int n4, int n5) {
        this.b = (short)(n2 * 20);
        this.c = (short)(n3 * 20);
    }

    public final byte b() {
        return (byte)(this.b / 20);
    }

    public final byte c() {
        return (byte)(this.c / 20);
    }

    public final byte a() {
        return (byte)(this.b % 20);
    }

    public final byte e() {
        return (byte)(this.c % 20);
    }
}

