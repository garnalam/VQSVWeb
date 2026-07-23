/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.midlet.MIDlet
 */
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

public final class ar {
    private static ar var_ar_b;
    private ak var_ak_b;
    private String[][] var_java_lang_String_arr_arr_b;
    public boolean var_boolean_b;
    public boolean var_boolean_c;
    private StringBuffer[] var_java_lang_StringBuffer_arr_b;
    private int var_int_b;
    private byte[][] var_byte_arr_arr_b;
    private byte[] var_byte_arr_b;
    private byte var_byte_b;
    private byte var_byte_c;
    private byte a;
    private byte e;
    private byte d;
    private byte[][] var_byte_arr_arr_c;
    private String[][] var_java_lang_String_arr_arr_c;
    private int[] var_int_arr_b;
    private String[] var_java_lang_String_arr_b;
    private String[] var_java_lang_String_arr_c;
    private ap var_ap_b;
    private byte h;

    private ar(ak ak2) {
        new StringBuffer();
        new StringBuffer();
        this.var_java_lang_String_arr_arr_b = new String[][]{{"Tin nh\u1eafn"}, {"Mua 30000 kim", "L\u00e0 c\u00f4ng t\u1eed c\u1ee7a m\u1ed9t trong T\u1ee9 \u0110\u1ea1i Gia T\u1ed9c, sao c\u00f3 th\u1ec3 thi\u1ebfu ti\u1ec1n! \u0110\u1ea7u t\u01b0 m\u1ed9t l\u1ea7n duy nh\u1ea5t gi\u00e1 tr\u1ecb c\u00e0ng l\u1edbn. Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn 15000\u0111, l\u1eadp t\u1ee9c c\u00f3 ngay 30000 kim."}, {"Mua 5000 kim", "L\u00e0 c\u00f4ng t\u1eed c\u1ee7a m\u1ed9t trong T\u1ee9 \u0110\u1ea1i Gia T\u1ed9c, sao c\u00f3 th\u1ec3 thi\u1ebfu ti\u1ec1n! Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn 5000\u0111, l\u1eadp t\u1ee9c c\u00f3 \u0111\u01b0\u1ee3c 5000 kim."}, {"Mua 50 huy ch\u01b0\u01a1ng", "Huy ch\u01b0\u01a1ng c\u00f3 th\u1ec3 mua s\u1eafm g\u1ea5p \u0111\u00f4i kinh nghi\u1ec7m, k\u1ef9 n\u0103ng S\u1ee7ng V\u1eadt, S\u1ee7ng V\u1eadt m\u1ea1nh b\u1eaft \u0111\u01b0\u1ee3c c\u1ea7n c\u00e1c lo\u1ea1i \u0111\u1ea1o c\u1ee5 th\u1ea7n k\u1ef3. Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn 15000\u0111, l\u1eadp t\u1ee9c c\u00f3 \u0111\u01b0\u1ee3c 50 huy ch\u01b0\u01a1ng"}, {"Mua 10 huy ch\u01b0\u01a1ng", "Huy ch\u01b0\u01a1ng c\u00f3 th\u1ec3 mua s\u1eafm g\u1ea5p \u0111\u00f4i kinh nghi\u1ec7m, k\u1ef9 n\u0103ng S\u1ee7ng V\u1eadt, S\u1ee7ng V\u1eadt m\u1ea1nh b\u1eaft \u0111\u01b0\u1ee3c c\u1ea7n c\u00e1c lo\u1ea1i \u0111\u1ea1o c\u1ee5 th\u1ea7n k\u1ef3. Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn 5000\u0111, l\u1eadp t\u1ee9c c\u00f3 \u0111\u01b0\u1ee3c 10 huy ch\u01b0\u01a1ng"}, {"S\u1ee7ng V\u1eadt th\u0103ng c\u1ea5p", "B\u1ea1n c\u00f3 th\u1ec3 t\u00f9y \u00fd ch\u1ecdn mang theo, S\u1ee7ng V\u1eadt l\u1eadp t\u1ee9c t\u0103ng l\u00ean 5 c\u1ea5p (kh\u00f4ng th\u1ec3 t\u0103ng qu\u00e1 c\u1ea5p 70). Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn 10000\u0111."}, {"Mua D\u1ecb th\u00fa", "D\u1ecb th\u00fa c\u01b0\u1ee1i r\u1ea5t \u0111\u00e1ng y\u00eau, t\u1ed1c \u0111\u1ed9 di chuy\u1ec3n c\u00f3 th\u1ec3 t\u0103ng g\u1ea5p \u0111\u00f4i, l\u1ea1i kh\u00f4ng g\u1eb7p b\u1ea5t c\u1ee9 k\u1ebb \u0111\u1ecbch n\u00e0o! Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn 10000\u0111, b\u1ea1n s\u1ebd c\u00f3 ngay d\u1ecb th\u00fa."}, {"B\u1ea3n ch\u00ednh", "Mu\u1ed1n v\u01b0\u1ee3t qua th\u1eed th\u00e1ch \u0111\u1ec3 tr\u1edf th\u00e0nh Ho\u00e0ng Kim Hu\u1ea5n luy\u1ec7n s\u01b0, c\u1ee9u V\u01b0\u01a1ng qu\u1ed1c C\u1ea7u v\u1ed3ng tho\u00e1t kh\u1ecfi k\u1ebf ho\u1ea1ch \u0111en t\u1ed1i? Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn 15000\u0111, b\u1ea1n s\u1ebd \u0111\u01b0\u1ee3c ch\u01a1i v\u1edbi s\u1ed1 l\u1ea7n ch\u01a1i kh\u00f4ng gi\u1edbi h\u1ea1n. \u0110\u1ed3ng th\u1eddi b\u1ea1n s\u1ebd \u0111\u01b0\u1ee3c t\u1eb7ng ngay 5 huy ch\u01b0\u01a1ng (\u0111\u1ec3 mua s\u1eafm \u0111\u1ea1o c\u1ee5 m\u1ea1nh)"}, {"H\u1ed3i sinh", "Trong chi\u1ebfn \u0111\u1ea5u kh\u00f3 tr\u00e1nh kh\u1ecfi c\u00e1i ch\u1ebft, ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin 10000\u0111 c\u00f3 th\u1ec3 h\u1ed3i ph\u1ee5c to\u00e0n b\u1ed9 s\u1ed1 S\u1ee7ng V\u1eadt b\u1ea1n mang theo. \u0110\u1ed3ng th\u1eddi S\u1ee7ng V\u1eadt c\u1ee7a b\u1ea1n s\u1ebd ngay l\u1eadp t\u1ee9c t\u0103ng l\u00ean 5 c\u1ea5p (qua 70 c\u1ea5p S\u1ee7ng V\u1eadt kh\u00f4ng th\u1ec3 t\u0103ng c\u1ea5p), cu\u1ed9c chi\u1ebfn k\u1ebf ti\u1ebfp s\u1ebd d\u1ec5 d\u00e0ng h\u01a1n."}};
        this.var_boolean_b = true;
        this.var_boolean_c = false;
        this.var_byte_arr_arr_b = new byte[][]{{0, 2, 4, 5}, {6}, {7}, {8}};
        this.var_byte_arr_b = new byte[2];
        this.d = (byte)-1;
        this.var_byte_arr_arr_c = new byte[][]{{1, 2, 1}, {1, 1, 2}, {1, 2, 3}, {1, 1, 4}, {1, 1, 5}, {1, 1, 0}, {1, 1, 6}, {1, 1, 5}};
        this.var_java_lang_String_arr_arr_c = new String[][]{{"Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn, b\u1ea1n s\u1ebd nh\u1eadn \u0111\u01b0\u1ee3c 5000 kim. B\u1ea1n c\u00f3 mu\u1ed1n nh\u1eafn tin kh\u00f4ng?"}, {"Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn, b\u1ea1n s\u1ebd nh\u1eadn \u0111\u01b0\u1ee3c 5000 kim. B\u1ea1n c\u00f3 mu\u1ed1n nh\u1eafn tin kh\u00f4ng?"}, {"Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn, b\u1ea1n s\u1ebd nh\u1eadn \u0111\u01b0\u1ee3c 50 huy ch\u01b0\u01a1ng. B\u1ea1n c\u00f3 mu\u1ed1n nh\u1eafn tin kh\u00f4ng?"}, {"Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn, b\u1ea1n s\u1ebd nh\u1eadn \u0111\u01b0\u1ee3c 10 huy ch\u01b0\u01a1ng. B\u1ea1n c\u00f3 mu\u1ed1n nh\u1eafn tin kh\u00f4ng?"}, {"Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn, b\u1ea1n s\u1ebd c\u00f3 S\u1ee7ng V\u1eadt th\u0103ng c\u1ea5p. B\u1ea1n c\u00f3 mu\u1ed1n nh\u1eafn tin kh\u00f4ng?"}, {"Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn, b\u1ea1n s\u1ebd nh\u1eadn \u0111\u01b0\u1ee3c D\u1ecb th\u00fa. B\u1ea1n c\u00f3 mu\u1ed1n nh\u1eafn tin kh\u00f4ng?"}, {"Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn, b\u1ea1n s\u1ebd k\u00edch ho\u1ea1t tr\u00f2 ch\u01a1i. B\u1ea1n c\u00f3 mu\u1ed1n nh\u1eafn tin kh\u00f4ng?"}, {"Ch\u1ec9 c\u1ea7n nh\u1eafn 1 tin nh\u1eafn, b\u1ea1n s\u1ebd nh\u1eadn \u0111\u01b0\u1ee3c h\u1ed3i sinh. B\u1ea1n c\u00f3 mu\u1ed1n nh\u1eafn tin kh\u00f4ng?"}};
        this.var_int_arr_b = new int[]{2, 2, 2, 2, 2, 2, 2, 2};
        this.var_java_lang_String_arr_b = new String[]{"30000 kim", "5000 kim", "50 huy ch\u01b0\u01a1ng", "10 huy ch\u01b0\u01a1ng", "S\u1ee7ng V\u1eadt th\u0103ng c\u1ea5p", "D\u1ecb th\u00fa", "B\u1ea3n ch\u00ednh", "H\u1ed3i sinh"};
        this.var_java_lang_String_arr_c = new String[]{"01", "02", "03", "04", "05", "06", "07", "08"};
        this.var_ak_b = ak2;
        var_ar_b = this;
    }

    public static ar b(ak ak2) {
        if (var_ar_b == null) {
            var_ar_b = new ar(ak2);
        }
        return var_ar_b;
    }

    public final void b(int n2, boolean bl) {
        this.var_int_b = ak.var_int_a;
        this.var_byte_c = this.var_ak_b.var_at_b.var_aj_b.var_byte_a;
        this.var_boolean_b = true;
        this.var_boolean_c = false;
        ak.var_int_a = -20;
        this.a = (byte)n2;
        this.var_byte_b = (byte)5;
        this.d = (byte)-1;
        this.var_byte_arr_b[0] = this.var_byte_arr_b[1] = (byte)(this.var_byte_arr_arr_b[this.a].length > 1 ? 1 : 0);
        this.e = (byte)(this.var_byte_arr_arr_b[this.a][this.var_byte_arr_b[0]] - 1);
        ad.ad_b();
        this.var_java_lang_StringBuffer_arr_b = ad.java_lang_StringBuffer_arr_b(this.var_java_lang_String_arr_arr_b[this.var_byte_arr_arr_b[this.a][this.var_byte_arr_b[0]]][1], 202);
    }

    public final void void_b() {
        int n2;
        ar ar2 = this;
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.b(1, 1, 238, 319);
        if (ar2.var_byte_arr_arr_b[ar2.a][0] == 6) {
            ah.ah_b();
            ah.h(63, 4, 114, 23, 4);
        } else {
            ah.ah_b();
            ah.h(82, 4, 76, 19, 4);
        }
        ah.ah_b();
        ah.b(ar2.var_java_lang_String_arr_arr_b[ar2.var_byte_arr_arr_b[ar2.a][0]][0], 120, 4, 17, 0, 1);
        int n3 = 25;
        if (ar2.var_byte_arr_arr_b[ar2.a].length > 1) {
            ah.ah_b();
            ah.h(6, 25, 213, 23 * ar2.var_byte_b, 1);
            ah.ah_b().b(221, 25, 23 * ar2.var_byte_b, ar2.var_byte_arr_b[0] - 1, ar2.var_byte_arr_arr_b[ar2.a].length - 1, true);
            ah.ah_b().b(ar2.var_byte_b, 6, 27, 213, 2, 23, -1, ar2.var_byte_arr_b[0] - ar2.var_byte_arr_b[1], 4, 2);
            for (n2 = ar2.var_byte_arr_b[1]; n2 < ar2.var_byte_arr_b[1] + ar2.var_byte_b && n2 < ar2.var_byte_arr_arr_b[ar2.a].length; ++n2) {
                ah.ah_b();
                ah.b(ar2.var_java_lang_String_arr_arr_b[ar2.var_byte_arr_arr_b[ar2.a][n2]][0], 120, 29 + (n2 - ar2.var_byte_arr_b[1]) * 22, 17, ar2.var_byte_arr_b[0] == n2 ? 0 : 3, 0);
            }
            n3 = 25 + (23 * ar2.var_byte_b + 5);
        }
        n2 = 319 - (n3 + 10);
        ah.ah_b();
        ah.h(6, n3, 228, n2, 2);
        for (n2 = 0; n2 < ar2.var_java_lang_StringBuffer_arr_b.length; ++n2) {
            ah.ah_b();
            ah.b(ar2.var_java_lang_StringBuffer_arr_b[n2].toString(), 19, n3 + 23 * n2, 12, 0);
        }
        n2 = 1;
        n3 = 1;
        if (ar2.d >= 0) {
            String string = "";
            if (ar2.d == 0) {
                if (ar2.var_byte_arr_arr_c[ar2.e][2] >= 0) {
                    byte[][] cfr_ignored_0 = ar2.var_ak_b.var_byte_arr_arr_m;
                }
                byte[][] cfr_ignored_1 = ar2.var_byte_arr_arr_c;
                byte cfr_ignored_2 = ar2.e;
                string = "B\u1ea1n c\u00f3 mu\u1ed1n th\u1ef1c hi\u1ec7n ch\u1ee9c n\u0103ng n\u00e0y kh\u00f4ng?";
            } else if (ar2.d == 1 || ar2.d == 2) {
                string = "G\u1eedi...";
                n3 = 0;
                n2 = 0;
            } else if (ar2.d == 3) {
                string = "G\u1eedi \u0111i th\u1ea5t b\u1ea1i!";
                n2 = 0;
            } else if (ar2.d > 3 && ar2.d < 15 || ar2.d > 23 && ar2.d < 34) {
                string = "Mua th\u00e0nh c\u00f4ng!";
                n3 = 0;
                n2 = 0;
                if (ar2.d > 23 && ar2.d < 34) {
                    ar2.d = (byte)(ar2.d + 1);
                }
            } else if (ar2.d == 15) {
                string = "T\u1ef1 \u0111\u1ed9ng L\u01b0u tr\u1eef tr\u00f2 ch\u01a1i.";
                n3 = 0;
                n2 = 0;
            } else if (ar2.d < 23) {
                string = "L\u01b0u tr\u1eef tr\u00f2 ch\u01a1i th\u00e0nh c\u00f4ng.";
                ar2.d = (byte)(ar2.d + 1);
                n3 = 0;
                n2 = 0;
                if (ar2.e == 5) {
                    ar2.var_ak_b.b("Mua th\u00e0nh c\u00f4ng! Tr\u00f2 ch\u01a1i \u0111\u00e3 L\u01b0u tr\u1eef.#nSau n\u00e0y m\u1ed7i l\u1ea7n ch\u01a1i m\u1edbi l\u1ea1i b\u1ea1n kh\u00f4ng ph\u1ea3i tr\u1ea3 ti\u1ec1n.", -1);
                } else if (ar2.e == 6) {
                    ar2.var_ak_b.b("Mua th\u00e0nh c\u00f4ng! \u0110\u1ea1t \u0111\u01b0\u1ee3c 5 huy ch\u01b0\u01a1ng (C\u00f3 th\u1ec3 xem t\u1ea1i menu H\u00e0nh trang). Tr\u00f2 ch\u01a1i \u0111\u00e3 L\u01b0u tr\u1eef.#nSau n\u00e0y m\u1ed7i l\u1ea7n ch\u01a1i m\u1edbi l\u1ea1i b\u1ea1n kh\u00f4ng ph\u1ea3i tr\u1ea3 ti\u1ec1n.", 0);
                }
            }
            ak cfr_ignored_3 = ar2.var_ak_b;
            ak.c(string, 120, 0);
        }
        ah.ah_b().b(n2 != 0, n3 != 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void c() {
        if (this.d == 1) {
            this.d = (byte)2;
        } else if (this.d == 2) {
            this.var_ap_b.var_ar_b = this;
            Display.getDisplay((MIDlet)ak.var_byte_b.var_main_XConnection_b).setCurrent((Displayable)this.var_ap_b);
            if (this.d == 4 && this.var_byte_arr_arr_c[this.e][1] > 1) {
                byte by = this.var_byte_arr_arr_c[this.e][2];
                byte by2 = (byte)(this.var_ak_b.var_byte_arr_arr_m[by] + true);
                this.var_ak_b.var_byte_arr_arr_m[by] = (byte[])by2;
                if (by2 != this.var_byte_arr_arr_c[this.e][1]) {
                    this.d = 0;
                    ad.ad_b();
                    ad.byte_arr_b(5, (byte[])this.var_ak_b.var_byte_arr_arr_m, 2);
                    ad.ad_b();
                    ad.byte_arr_b(5, null, 4);
                } else {
                    this.var_ak_b.var_byte_arr_arr_m[this.var_byte_arr_arr_c[this.e][2]] = (byte[])false;
                }
            }
        }
        if (this.d > 3 && this.d < 15) {
            byte by = this.d;
            this.d = (byte)(by + 1);
            if (by != 14) return;
            switch (this.e) {
                case 0: {
                    this.var_ak_b.var_int_b += 30000;
                    return;
                }
                case 1: {
                    this.var_ak_b.var_int_b += 5000;
                    return;
                }
                case 2: {
                    this.var_ak_b.var_int_c += 50;
                    return;
                }
                case 3: {
                    this.var_ak_b.var_int_c += 10;
                    return;
                }
                case 4: {
                    this.var_int_b = -1;
                }
                case 7: {
                    ar ar2 = this;
                    ak.var_int_a = -21;
                    ar2.h = 0;
                    ar2.var_ak_b.var_byte_g = 0;
                    if (ar2.var_int_b != -31) {
                        ar2.var_ak_b.var_byte_arr_arr_a = null;
                        ar2.var_ak_b.var_byte_arr_arr_a = new byte[ar2.var_ak_b.w][2];
                        ar2.var_ak_b.var_short_arr_arr_b = null;
                        ar2.var_ak_b.var_short_arr_arr_b = new short[((byte)ar2.var_ak_b.var_byte_b).length][7];
                    }
                    for (byte by3 = 0; by3 < ar2.var_ak_b.y; by3 = (byte)(by3 + 1)) {
                        if (ar2.var_ak_b.var_byte_b[by3].var_byte_arr_b[2] >= 70) {
                            ak.void_b((al)ar2.var_ak_b.var_byte_b[by3]);
                            continue;
                        }
                        ar2.var_ak_b.var_short_arr_arr_b[by3][6] = ar2.var_ak_b.var_byte_b[by3].var_byte_arr_b[2];
                        ar2.var_ak_b.var_byte_arr_arr_a[by3][0] = 1;
                        ar2.var_ak_b.var_byte_arr_arr_a[by3][1] = -1;
                        for (int n2 = 0; n2 < 5; n2 = (int)((byte)(n2 + 1))) {
                            ar2.var_ak_b.void_b((int)by3, false);
                            ar2.var_ak_b.a((al)ar2.var_ak_b.var_byte_b[by3]);
                            if (ar2.var_ak_b.var_byte_p == -1) continue;
                            ar2.var_ak_b.var_byte_arr_arr_a[by3][1] = ar2.var_ak_b.var_byte_p;
                        }
                    }
                    return;
                }
                case 5: {
                    this.var_ak_b.var_byte_arr_arr_m[0] = (byte[])10;
                    return;
                }
                case 6: {
                    this.var_ak_b.var_byte_arr_arr_m[this.var_byte_arr_arr_c[this.e][2]] = (byte[])10;
                    this.var_ak_b.var_int_c += 5;
                    this.var_boolean_c = true;
                }
            }
            return;
        }
        if (this.d == 15) {
            this.var_ak_b.a();
            this.d = (byte)16;
            return;
        }
        if (this.d == 23) {
            if (this.a != 0) {
                if (this.var_ak_b.var_byte_k != 0) return;
                this.i();
                return;
            }
            this.d = (byte)-1;
            return;
        }
        if (this.d != 34) return;
        this.d = (byte)-1;
    }

    /*
     * Unable to fully structure code
     */
    public final void a() {
        block21: {
            block22: {
                block23: {
                    block24: {
                        block19: {
                            block20: {
                                if (this.d != -1) ** GOTO lbl-1000
                                ad.ad_b();
                                if (ad.d()) {
                                    ad.ad_b();
                                    if (ad.boolean_b()) {
                                        return;
                                    }
                                } else if (this.d == -1) {
                                    ad.ad_b();
                                    if (ad.h()) {
                                        ad.ad_b();
                                        if (ad.boolean_b()) {
                                            return;
                                        }
                                    }
                                }
                                if (this.d != -1) break block20;
                                ad.ad_b();
                                if (!ad.boolean_c()) break block20;
                                ad.ad_b();
                                if (ad.boolean_b()) {
                                    return;
                                }
                                if (this.var_byte_arr_arr_b[this.a].length > 1) {
                                    ad.ad_b();
                                    ad.b(this.var_byte_arr_b, 1, this.var_byte_arr_arr_b[this.a].length, this.var_byte_b);
                                    this.e = (byte)(this.var_byte_arr_arr_b[this.a][this.var_byte_arr_b[0]] - 1);
                                    ad.ad_b();
                                    this.var_java_lang_StringBuffer_arr_b = ad.java_lang_StringBuffer_arr_b(this.var_java_lang_String_arr_arr_b[this.var_byte_arr_arr_b[this.a][this.var_byte_arr_b[0]]][1], 202);
                                    return;
                                }
                                break block21;
                            }
                            if (this.d != -1 && this.d != 0) break block22;
                            ad.ad_b();
                            if (!ad.f()) break block22;
                            ad.ad_b();
                            ad.void_c();
                            if (this.e != 4 || this.var_byte_arr_b[0] == 7) break block23;
                            if (this.var_ak_b.y <= 0) break block24;
                            var1_1 = this;
                            for (var2_2 = (byte)(var1_1.var_ak_b.y - 1); var2_2 >= 0; var2_2 = (byte)(var2_2 - 1)) {
                                if (var1_1.var_ak_b.var_byte_b[var2_2].var_byte_arr_b[2] >= 70) continue;
                                v0 = true;
                                break block19;
                            }
                            v0 = false;
                        }
                        if (v0) break block23;
                    }
                    this.d = (byte)-1;
                    this.var_ak_b.b("Hi\u1ec7n t\u1ea1i kh\u00f4ng th\u1ec3 th\u0103ng c\u1ea5p S\u1ee7ng V\u1eadt!", 0);
                    return;
                }
                if (this.d != 0 && this.var_byte_arr_arr_c[this.e][1] > 1 && this.var_ak_b.var_byte_arr_arr_m[this.var_byte_arr_arr_c[this.e][2]] > 0 && this.var_ak_b.var_byte_arr_arr_m[this.var_byte_arr_arr_c[this.e][2]] != this.var_byte_arr_arr_c[this.e][1]) {
                    this.d = 0;
                    return;
                }
                this.d = this.d != 0 ? 0 : 1;
                this.var_ap_b = new ap(ak.var_byte_b.var_main_XConnection_b, (Displayable)ak.var_byte_b, "406", "085", this.var_java_lang_String_arr_c[this.e], null, this.var_int_arr_b[this.e], this.var_java_lang_String_arr_b[this.e], this.var_java_lang_String_arr_arr_c[this.e][0], "010-88901665");
                return;
            }
            if (this.d == -1 || this.d == 0 || this.d == 3 || this.d == 24) {
                ad.ad_b();
                if (ad.i()) {
                    ad.ad_b();
                    ad.void_c();
                    if (this.d == -1) {
                        this.i();
                        if (this.e == 6) {
                            return;
                        }
                    } else {
                        this.d = (byte)-1;
                    }
                }
            }
        }
    }

    private void g() {
        int n2;
        ah.ah_b();
        ah.c();
        ah.ah_b();
        ah.b(1, 1, 238, 319);
        if (this.var_byte_arr_arr_b[this.a][0] == 6) {
            ah.ah_b();
            ah.h(63, 4, 114, 23, 4);
        } else {
            ah.ah_b();
            ah.h(82, 4, 76, 19, 4);
        }
        ah.ah_b();
        ah.b(this.var_java_lang_String_arr_arr_b[this.var_byte_arr_arr_b[this.a][0]][0], 120, 4, 17, 0, 1);
        int n3 = 25;
        if (this.var_byte_arr_arr_b[this.a].length > 1) {
            ah.ah_b();
            ah.h(6, 25, 213, 23 * this.var_byte_b, 1);
            ah.ah_b().b(221, 25, 23 * this.var_byte_b, this.var_byte_arr_b[0] - 1, this.var_byte_arr_arr_b[this.a].length - 1, true);
            ah.ah_b().b(this.var_byte_b, 6, 27, 213, 2, 23, -1, this.var_byte_arr_b[0] - this.var_byte_arr_b[1], 4, 2);
            for (n2 = this.var_byte_arr_b[1]; n2 < this.var_byte_arr_b[1] + this.var_byte_b && n2 < this.var_byte_arr_arr_b[this.a].length; ++n2) {
                ah.ah_b();
                ah.b(this.var_java_lang_String_arr_arr_b[this.var_byte_arr_arr_b[this.a][n2]][0], 120, 29 + (n2 - this.var_byte_arr_b[1]) * 22, 17, this.var_byte_arr_b[0] == n2 ? 0 : 3, 0);
            }
            n3 = 25 + (23 * this.var_byte_b + 5);
        }
        n2 = 319 - (n3 + 10);
        ah.ah_b();
        ah.h(6, n3, 228, n2, 2);
        for (n2 = 0; n2 < this.var_java_lang_StringBuffer_arr_b.length; ++n2) {
            ah.ah_b();
            ah.b(this.var_java_lang_StringBuffer_arr_b[n2].toString(), 19, n3 + 23 * n2, 12, 0);
        }
        ar ar2 = this;
        n3 = 1;
        int n4 = 1;
        if (ar2.d >= 0) {
            String string = "";
            if (ar2.d == 0) {
                if (ar2.var_byte_arr_arr_c[ar2.e][2] >= 0) {
                    byte[][] cfr_ignored_0 = ar2.var_ak_b.var_byte_arr_arr_m;
                }
                byte[][] cfr_ignored_1 = ar2.var_byte_arr_arr_c;
                byte cfr_ignored_2 = ar2.e;
                string = "B\u1ea1n c\u00f3 mu\u1ed1n th\u1ef1c hi\u1ec7n ch\u1ee9c n\u0103ng n\u00e0y kh\u00f4ng?";
            } else if (ar2.d == 1 || ar2.d == 2) {
                string = "G\u1eedi...";
                n4 = 0;
                n3 = 0;
            } else if (ar2.d == 3) {
                string = "G\u1eedi \u0111i th\u1ea5t b\u1ea1i!";
                n3 = 0;
            } else if (ar2.d > 3 && ar2.d < 15 || ar2.d > 23 && ar2.d < 34) {
                string = "Mua th\u00e0nh c\u00f4ng!";
                n4 = 0;
                n3 = 0;
                if (ar2.d > 23 && ar2.d < 34) {
                    ar2.d = (byte)(ar2.d + 1);
                }
            } else if (ar2.d == 15) {
                string = "T\u1ef1 \u0111\u1ed9ng L\u01b0u tr\u1eef tr\u00f2 ch\u01a1i.";
                n4 = 0;
                n3 = 0;
            } else if (ar2.d < 23) {
                string = "L\u01b0u tr\u1eef tr\u00f2 ch\u01a1i th\u00e0nh c\u00f4ng.";
                ar2.d = (byte)(ar2.d + 1);
                n4 = 0;
                n3 = 0;
                if (ar2.e == 5) {
                    ar2.var_ak_b.b("Mua th\u00e0nh c\u00f4ng! Tr\u00f2 ch\u01a1i \u0111\u00e3 L\u01b0u tr\u1eef.#nSau n\u00e0y m\u1ed7i l\u1ea7n ch\u01a1i m\u1edbi l\u1ea1i b\u1ea1n kh\u00f4ng ph\u1ea3i tr\u1ea3 ti\u1ec1n.", -1);
                } else if (ar2.e == 6) {
                    ar2.var_ak_b.b("Mua th\u00e0nh c\u00f4ng! \u0110\u1ea1t \u0111\u01b0\u1ee3c 5 huy ch\u01b0\u01a1ng (C\u00f3 th\u1ec3 xem t\u1ea1i menu H\u00e0nh trang). Tr\u00f2 ch\u01a1i \u0111\u00e3 L\u01b0u tr\u1eef.#nSau n\u00e0y m\u1ed7i l\u1ea7n ch\u01a1i m\u1edbi l\u1ea1i b\u1ea1n kh\u00f4ng ph\u1ea3i tr\u1ea3 ti\u1ec1n.", 0);
                }
            }
            ak cfr_ignored_3 = ar2.var_ak_b;
            ak.c(string, 120, 0);
        }
        ah.ah_b().b(n3 != 0, n4 != 0);
    }

    private void f() {
        boolean bl = true;
        boolean bl2 = true;
        if (this.d >= 0) {
            String string = "";
            if (this.d == 0) {
                if (this.var_byte_arr_arr_c[this.e][2] >= 0) {
                    byte[][] cfr_ignored_0 = this.var_ak_b.var_byte_arr_arr_m;
                }
                string = "B\u1ea1n c\u00f3 mu\u1ed1n th\u1ef1c hi\u1ec7n ch\u1ee9c n\u0103ng n\u00e0y kh\u00f4ng?";
            } else if (this.d == 1 || this.d == 2) {
                string = "G\u1eedi...";
                bl2 = false;
                bl = false;
            } else if (this.d == 3) {
                string = "G\u1eedi \u0111i th\u1ea5t b\u1ea1i!";
                bl = false;
            } else if (this.d > 3 && this.d < 15 || this.d > 23 && this.d < 34) {
                string = "Mua th\u00e0nh c\u00f4ng!";
                bl2 = false;
                bl = false;
                if (this.d > 23 && this.d < 34) {
                    this.d = (byte)(this.d + 1);
                }
            } else if (this.d == 15) {
                string = "T\u1ef1 \u0111\u1ed9ng L\u01b0u tr\u1eef tr\u00f2 ch\u01a1i.";
                bl2 = false;
                bl = false;
            } else if (this.d < 23) {
                string = "L\u01b0u tr\u1eef tr\u00f2 ch\u01a1i th\u00e0nh c\u00f4ng.";
                this.d = (byte)(this.d + 1);
                bl2 = false;
                bl = false;
                if (this.e == 5) {
                    this.var_ak_b.b("Mua th\u00e0nh c\u00f4ng! Tr\u00f2 ch\u01a1i \u0111\u00e3 L\u01b0u tr\u1eef.#nSau n\u00e0y m\u1ed7i l\u1ea7n ch\u01a1i m\u1edbi l\u1ea1i b\u1ea1n kh\u00f4ng ph\u1ea3i tr\u1ea3 ti\u1ec1n.", -1);
                } else if (this.e == 6) {
                    this.var_ak_b.b("Mua th\u00e0nh c\u00f4ng! \u0110\u1ea1t \u0111\u01b0\u1ee3c 5 huy ch\u01b0\u01a1ng (C\u00f3 th\u1ec3 xem t\u1ea1i menu H\u00e0nh trang). Tr\u00f2 ch\u01a1i \u0111\u00e3 L\u01b0u tr\u1eef.#nSau n\u00e0y m\u1ed7i l\u1ea7n ch\u01a1i m\u1edbi l\u1ea1i b\u1ea1n kh\u00f4ng ph\u1ea3i tr\u1ea3 ti\u1ec1n.", 0);
                }
            }
            ak.c(string, 120, 0);
        }
        ah.ah_b().b(bl, bl2);
    }

    private static String java_lang_String_b() {
        return "B\u1ea1n c\u00f3 mu\u1ed1n th\u1ef1c hi\u1ec7n ch\u1ee9c n\u0103ng n\u00e0y kh\u00f4ng?";
    }

    private void i() {
        if (this.var_int_b != -1) {
            ak.var_int_a = this.var_int_b;
            this.var_ak_b.var_at_b.var_aj_b.var_byte_a = this.var_byte_c;
            if (ak.var_int_a == -31) {
                this.var_boolean_b = false;
                return;
            }
        } else {
            ak.var_int_a = -10;
        }
    }

    public final void e() {
        if (this.var_ak_b.var_byte_g != 1) {
            return;
        }
        this.var_ak_b.void_b(0, (int)this.h, true);
    }

    public final void d() {
        if (this.var_ak_b.var_byte_g == 0) {
            if (this.var_ak_b.var_byte_arr_arr_a[this.h][0] == 1) {
                this.var_ak_b.var_byte_arr_arr_a[this.h][0] = 0;
                this.var_ak_b.var_byte_g = 1;
                this.var_ak_b.var_short_b = (short)52;
                this.var_ak_b.void_b((int)this.h, true);
                this.var_ak_b.b("Sinh m\u1ec7nh: +" + this.var_ak_b.var_short_arr_arr_b[this.h][0] + "#npow" + ": +" + this.var_ak_b.var_short_arr_arr_b[this.h][1], 240, 0);
                this.var_ak_b.b("S\u1ee9c m\u1ea1nh: +" + this.var_ak_b.var_short_arr_arr_b[this.h][3] + "#nPh\u00f2ng ng\u1ef1" + ": +" + this.var_ak_b.var_short_arr_arr_b[this.h][4] + "#nNhanh nh\u1eb9n" + ": +" + this.var_ak_b.var_short_arr_arr_b[this.h][5], 240, 1);
                this.var_ak_b.b(2, (int)this.var_ak_b.var_byte_arr_arr_e[this.var_ak_b.var_byte_b[this.h].var_byte_arr_b[0]][0], 1);
            } else {
                this.h = (byte)(this.h + 1);
            }
            if (this.h >= this.var_ak_b.y) {
                if (this.var_int_b == -1) {
                    ak.var_int_a = -20;
                    this.var_ak_b.var_byte_arr_arr_a = null;
                    this.var_ak_b.var_short_arr_arr_b = null;
                    return;
                }
                ak.var_int_a = this.var_int_b;
                if (this.var_int_b == -31) {
                    this.var_ak_b.b(2, (int)this.var_ak_b.var_byte_arr_arr_e[this.var_ak_b.var_z_b.al_b().var_byte_arr_b[0]][0], 1);
                    this.var_ak_b.var_z_b.d = 0;
                    this.var_ak_b.c(this.var_ak_b.var_z_b.al_b());
                    for (byte by = 0; by < this.var_ak_b.y; by = (byte)(by + 1)) {
                        this.var_ak_b.var_short_arr_arr_b[this.var_ak_b.var_byte_b[by].var_byte_arr_b[1]][6] = this.var_ak_b.var_byte_b[by].var_byte_arr_b[2];
                    }
                    return;
                }
            }
        } else if (this.var_ak_b.var_byte_g == 1) {
            ad.ad_b();
            this.var_ak_b.var_short_b = (byte)ad.b((int)this.var_ak_b.var_short_b, 4, true);
        }
    }

    public final void h() {
        ad.ad_b();
        if (ad.boolean_b()) {
            return;
        }
        if (this.var_ak_b.var_byte_g == 1 && this.var_ak_b.var_short_b == 0) {
            this.var_ak_b.var_byte_g = 0;
        }
    }

    private void j() {
        ak.var_int_a = -21;
        this.h = 0;
        this.var_ak_b.var_byte_g = 0;
        if (this.var_int_b != -31) {
            this.var_ak_b.var_byte_arr_arr_a = null;
            this.var_ak_b.var_byte_arr_arr_a = new byte[this.var_ak_b.w][2];
            this.var_ak_b.var_short_arr_arr_b = null;
            this.var_ak_b.var_short_arr_arr_b = new short[((byte)this.var_ak_b.var_byte_b).length][7];
        }
        for (byte by = 0; by < this.var_ak_b.y; by = (byte)(by + 1)) {
            if (this.var_ak_b.var_byte_b[by].var_byte_arr_b[2] >= 70) {
                ak.void_b((al)this.var_ak_b.var_byte_b[by]);
                continue;
            }
            this.var_ak_b.var_short_arr_arr_b[by][6] = this.var_ak_b.var_byte_b[by].var_byte_arr_b[2];
            this.var_ak_b.var_byte_arr_arr_a[by][0] = 1;
            this.var_ak_b.var_byte_arr_arr_a[by][1] = -1;
            for (int n2 = 0; n2 < 5; n2 = (int)((byte)(n2 + 1))) {
                this.var_ak_b.void_b((int)by, false);
                this.var_ak_b.a((al)this.var_ak_b.var_byte_b[by]);
                if (this.var_ak_b.var_byte_p == -1) continue;
                this.var_ak_b.var_byte_arr_arr_a[by][1] = this.var_ak_b.var_byte_p;
            }
        }
    }

    private boolean boolean_b() {
        for (byte by = (byte)(this.var_ak_b.y - 1); by >= 0; by = (byte)(by - 1)) {
            if (this.var_ak_b.var_byte_b[by].var_byte_arr_b[2] >= 70) continue;
            return true;
        }
        return false;
    }

    public final void b(boolean bl) {
        this.d = (byte)(bl ? 4 : 3);
    }

    public final int int_b() {
        return this.e;
    }
}

