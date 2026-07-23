/*
 * Decompiled with CFR 0.152.
 */
public final class aj {
    public short var_short_b;
    public short var_short_c;
    public boolean var_boolean_b = true;
    public boolean var_boolean_c = false;
    public boolean var_boolean_a = false;
    private byte q = 0;
    public byte var_byte_b = (byte)-1;
    public byte var_byte_c = 1;
    public byte var_byte_a;
    public byte e;
    public byte d;
    public byte h = (byte)127;
    public byte g = (byte)5;
    public byte f;
    public byte i;
    public byte j = (byte)-1;
    public byte k = (byte)-1;
    public byte l = (byte)-1;
    public byte m;
    public byte n = (byte)3;
    public byte[] var_byte_arr_b;
    public byte p = 0;
    public byte o = 0;

    public aj() {
    }

    public aj(int n2) {
        this.var_byte_arr_b = new byte[n2];
    }

    public final void void_b() {
        this.b(this.var_byte_arr_b[0], this.var_byte_arr_b[1], 0, 0);
    }

    public final void void_c() {
        this.var_byte_arr_b[0] = this.byte_b();
        this.var_byte_arr_b[1] = this.byte_c();
    }

    public final void b(boolean bl) {
        if (this.var_boolean_a) {
            return;
        }
        this.var_byte_arr_b[7] = this.n == 2 ? (bl ? 3 : 0) : (this.n == 1 ? (bl ? 4 : 1) : (bl ? 5 : 2));
        this.var_byte_arr_b[7] = (byte)(this.var_byte_arr_b[7] + this.q * 6);
    }

    public final void b(int n2) {
        this.q = (byte)(this.var_byte_arr_b[7] / 6);
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
        this.var_boolean_a = bl;
        this.h = (byte)n2;
    }

    public final void b(int n2, int n3, int n4, int n5) {
        this.var_short_b = (short)(n2 * 20);
        this.var_short_c = (short)(n3 * 20);
    }

    public final byte byte_b() {
        return (byte)(this.var_short_b / 20);
    }

    public final byte byte_c() {
        return (byte)(this.var_short_c / 20);
    }

    public final byte a() {
        return (byte)(this.var_short_b % 20);
    }

    public final byte e() {
        return (byte)(this.var_short_c % 20);
    }
}

