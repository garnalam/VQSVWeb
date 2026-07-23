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
public final class am {
    public Image b;
    private boolean b;
    private byte[][] b;
    private byte[][][] b;
    private byte[][][] c;
    private short[][] b;
    private short[][][] b = null;
    private short[][][] c = null;

    public am() {
        this.b();
    }

    public final void b() {
        this.b = null;
        this.b = null;
        this.b = null;
        this.c = null;
        this.b = null;
        this.b = null;
        this.c = null;
    }

    public static am b(Image image, byte[][] byArray, byte[][][] byArray2, byte[][][] byArray3) {
        am am2 = new am();
        new am().b = true;
        am2.b = image;
        am2.b = byArray;
        am2.b = byArray2;
        am2.c = byArray3;
        return am2;
    }

    public final void b(Image image, byte[][] byArray, byte[][][] byArray2, byte[][][] byArray3) {
        this.b();
        this.b = true;
        this.b = image;
        this.b = byArray;
        this.b = byArray2;
        this.c = byArray3;
    }

    public static am b(Image image, short[][] sArray, short[][][] sArray2, short[][][] sArray3) {
        am am2 = new am();
        new am().b = false;
        am2.b = image;
        am2.b = sArray;
        am2.b = sArray2;
        am2.c = sArray3;
        return am2;
    }

    public final void b(Image image, short[][] sArray, short[][][] sArray2, short[][][] sArray3) {
        this.b();
        this.b = false;
        this.b = image;
        this.b = sArray;
        this.b = sArray2;
        this.c = sArray3;
    }

    public final int b(int n2, int n3) {
        if (this.b) {
            return this.b[n2][n3];
        }
        return this.b[n2][n3];
    }

    public final int b(int n2, int n3, int n4) {
        if (this.b) {
            return this.b[n2][n3][n4];
        }
        return this.b[n2][n3][n4];
    }

    public final int c(int n2, int n3, int n4) {
        if (this.b) {
            return this.c[n2][n3][n4];
        }
        return this.c[n2][n3][n4];
    }

    public final int b(int n2) {
        if (this.b) {
            return this.c[n2].length;
        }
        return this.c[n2].length;
    }

    public final int b() {
        if (this.b) {
            return this.c.length;
        }
        return this.c.length;
    }

    public final int c(int n2) {
        if (this.b) {
            return this.b[n2].length;
        }
        return this.b[n2].length;
    }
}

