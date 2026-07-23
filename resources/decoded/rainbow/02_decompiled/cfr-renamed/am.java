/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Image;

public final class am {
    public Image var_javax_microedition_lcdui_Image_b;
    private boolean var_boolean_b = true;
    private byte[][] var_byte_arr_arr_b = null;
    private byte[][][] var_byte_arr_arr_arr_b = null;
    private byte[][][] var_byte_arr_arr_arr_c = null;
    private short[][] var_short_arr_arr_b = null;
    private short[][][] var_short_arr_arr_arr_b = null;
    private short[][][] var_short_arr_arr_arr_c = null;

    public am() {
        this.void_b();
    }

    public final void void_b() {
        this.var_javax_microedition_lcdui_Image_b = null;
        this.var_byte_arr_arr_b = null;
        this.var_byte_arr_arr_arr_b = null;
        this.var_byte_arr_arr_arr_c = null;
        this.var_short_arr_arr_b = null;
        this.var_short_arr_arr_arr_b = null;
        this.var_short_arr_arr_arr_c = null;
    }

    public static am am_b(Image image, byte[][] byArray, byte[][][] byArray2, byte[][][] byArray3) {
        am am2 = new am();
        new am().var_boolean_b = true;
        am2.var_javax_microedition_lcdui_Image_b = image;
        am2.var_byte_arr_arr_b = byArray;
        am2.var_byte_arr_arr_arr_b = byArray2;
        am2.var_byte_arr_arr_arr_c = byArray3;
        return am2;
    }

    public final void void_b(Image image, byte[][] byArray, byte[][][] byArray2, byte[][][] byArray3) {
        this.void_b();
        this.var_boolean_b = true;
        this.var_javax_microedition_lcdui_Image_b = image;
        this.var_byte_arr_arr_b = byArray;
        this.var_byte_arr_arr_arr_b = byArray2;
        this.var_byte_arr_arr_arr_c = byArray3;
    }

    public static am am_b(Image image, short[][] sArray, short[][][] sArray2, short[][][] sArray3) {
        am am2 = new am();
        new am().var_boolean_b = false;
        am2.var_javax_microedition_lcdui_Image_b = image;
        am2.var_short_arr_arr_b = sArray;
        am2.var_short_arr_arr_arr_b = sArray2;
        am2.var_short_arr_arr_arr_c = sArray3;
        return am2;
    }

    public final void void_b(Image image, short[][] sArray, short[][][] sArray2, short[][][] sArray3) {
        this.void_b();
        this.var_boolean_b = false;
        this.var_javax_microedition_lcdui_Image_b = image;
        this.var_short_arr_arr_b = sArray;
        this.var_short_arr_arr_arr_b = sArray2;
        this.var_short_arr_arr_arr_c = sArray3;
    }

    public final int b(int n2, int n3) {
        if (this.var_boolean_b) {
            return this.var_byte_arr_arr_b[n2][n3];
        }
        return this.var_short_arr_arr_b[n2][n3];
    }

    public final int b(int n2, int n3, int n4) {
        if (this.var_boolean_b) {
            return this.var_byte_arr_arr_arr_b[n2][n3][n4];
        }
        return this.var_short_arr_arr_arr_b[n2][n3][n4];
    }

    public final int c(int n2, int n3, int n4) {
        if (this.var_boolean_b) {
            return this.var_byte_arr_arr_arr_c[n2][n3][n4];
        }
        return this.var_short_arr_arr_arr_c[n2][n3][n4];
    }

    public final int b(int n2) {
        if (this.var_boolean_b) {
            return this.var_byte_arr_arr_arr_c[n2].length;
        }
        return this.var_short_arr_arr_arr_c[n2].length;
    }

    public final int int_b() {
        if (this.var_boolean_b) {
            return this.var_byte_arr_arr_arr_c.length;
        }
        return this.var_short_arr_arr_arr_c.length;
    }

    public final int c(int n2) {
        if (this.var_boolean_b) {
            return this.var_byte_arr_arr_arr_b[n2].length;
        }
        return this.var_short_arr_arr_arr_b[n2].length;
    }
}

