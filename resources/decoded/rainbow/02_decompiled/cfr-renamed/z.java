/*
 * Decompiled with CFR 0.152.
 */
public final class z {
    public al[] var_al_arr_b;
    public byte var_byte_b;
    public byte var_byte_c;
    public byte var_byte_a;
    public byte e;
    public byte d = 1;
    public byte h;
    public byte g;
    public byte f = (byte)-1;
    public byte[] var_byte_arr_b = new byte[10];
    public byte[] var_byte_arr_c = new byte[4];
    public byte i;
    public byte[] var_byte_arr_a = new byte[6];
    public short var_short_b;
    public short var_short_c;
    public short[][] var_short_arr_arr_b = new short[3][5];
    public boolean var_boolean_b = false;

    public z(al[] alArray) {
        this.var_al_arr_b = alArray;
    }

    public final al al_b() {
        return this.var_al_arr_b[this.var_byte_b];
    }

    public final void void_b() {
        for (int n2 = 0; n2 < this.var_short_arr_arr_b.length; n2 = (int)((byte)(n2 + 1))) {
            this.var_short_arr_arr_b[n2][1] = 0;
        }
    }

    public final void b(int n2, int n3, int n4) {
        this.var_short_arr_arr_b[n4][0] = (short)n3;
        short[] sArray = this.var_short_arr_arr_b[n4];
        sArray[1] = (short)(sArray[1] + n2);
        this.var_short_arr_arr_b[n4][2] = 0;
        this.var_short_arr_arr_b[n4][3] = 0;
        this.var_short_arr_arr_b[n4][4] = 0;
    }
}

