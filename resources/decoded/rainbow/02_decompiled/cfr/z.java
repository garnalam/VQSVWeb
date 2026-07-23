/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class z {
    public al[] b;
    public byte b;
    public byte c;
    public byte a;
    public byte e;
    public byte d = 1;
    public byte h;
    public byte g;
    public byte f = (byte)-1;
    public byte[] b;
    public byte[] c;
    public byte i;
    public byte[] a;
    public short b;
    public short c;
    public short[][] b;
    public boolean b = false;

    public z(al[] alArray) {
        this.c = new byte[4];
        this.a = new byte[6];
        this.b = new short[3][5];
        this.b = alArray;
    }

    public final al b() {
        return this.b[this.b];
    }

    public final void b() {
        for (int n2 = 0; n2 < this.b.length; n2 = (int)((byte)(n2 + 1))) {
            this.b[n2][1] = 0;
        }
    }

    public final void b(int n2, int n3, int n4) {
        this.b[n4][0] = (short)n3;
        short[] sArray = this.b[n4];
        sArray[1] = (short)(sArray[1] + n2);
        this.b[n4][2] = 0;
        this.b[n4][3] = 0;
        this.b[n4][4] = 0;
    }
}

