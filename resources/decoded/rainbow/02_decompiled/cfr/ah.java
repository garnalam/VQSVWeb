/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nokia.mid.ui.DirectGraphics
 *  com.nokia.mid.ui.DirectUtils
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ah {
    private static ah b;
    public static Graphics b;
    private static DirectGraphics b;
    private byte[][] b;
    private byte[] b;
    private int[] b;
    private static final short[] b;
    private Image b;
    private short[][] b;
    private byte b = new int[]{20, 24};
    private byte c = 0;

    public ah() {
        b = this;
    }

    public static ah b() {
        if (b == null) {
            b = new ah();
        }
        return b;
    }

    public static void b(Graphics graphics) {
        b = graphics;
        b = DirectUtils.getDirectGraphics((Graphics)graphics);
    }

    public static void b(Image image, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Graphics graphics) {
        graphics.drawRegion(image, n2, n3, n4, n5, (int)b[n9], n6, n7, n8);
    }

    public final void b(am am2, int n2, int n3, int n4, int n5, int n6) {
        ah.b(am2.b, am2.b(n2, 0), am2.b(n2, 1), am2.b(n2, 2), am2.b(n2, 3), n3, n4, this.b[n5], this.b[n5][n6], b);
    }

    public final void b(am am2, int n2, int n3, int n4, int n5) {
        for (int n6 = 0; n6 < am2.c(n2); n6 = (int)((short)(n6 + 1))) {
            this.b(am2, am2.b(n2, n6, 0), n3 + am2.b(n2, n6, 1) * this.b[n5], n4 + am2.b(n2, n6, 2), n5, am2.b(n2, n6, 3));
        }
    }

    public final boolean b(am am2, int n2, int n3, int n4, byte[] byArray, int n5, boolean bl) {
        this.b(am2, am2.c(n2, byArray[0], 0), n3, n4, 0);
        byArray[1] = (byte)(byArray[1] + 1);
        if (byArray[1] > am2.c(n2, byArray[0], 1)) {
            byArray[1] = 0;
            byArray[0] = (byte)(byArray[0] + 1);
            if (byArray[0] >= am2.b(n2)) {
                if (!bl) {
                    byArray[0] = (byte)(am2.b(n2) - 1);
                    return true;
                }
                byArray[0] = 0;
            }
        }
        return false;
    }

    public static void b(Image image, int n2, int n3, int n4) {
        b.drawImage(image, n2, n3, n4);
    }

    public static void b(Image image, int n2, int n3, int n4, int n5) {
        b.drawImage(image, 0, 119, 0, 8192);
    }

    public static void b(int n2, int n3, int n4, int n5, int n6) {
        b.setColor(n2);
        b.fillRect(n3, n4, n5, n6);
    }

    public static void c(int n2, int n3, int n4, int n5, int n6) {
        b.setColor(n2);
        b.drawLine(n3, n4, n5, n6);
    }

    public static void b(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        b.setColor(5422575);
        b.fillArc(-25, 141, 50, 70, 270, 180);
    }

    public static void b(String string, int n2, int n3, int n4, int n5, int n6) {
        int n7 = 13281366;
        int n8 = 3676168;
        ++n3;
        switch (n5) {
            case 0: {
                n7 = 0;
                n8 = 0xFFFFFF;
                break;
            }
            case 1: {
                n7 = 0x535453;
                n8 = 7727871;
                break;
            }
            case 2: {
                n7 = 2707928;
                n8 = 43016;
                break;
            }
            case 3: {
                n7 = 1908277;
                n8 = 24295;
                break;
            }
            case 4: {
                n7 = 1314307;
                n8 = 5228543;
                break;
            }
            case 5: {
                n7 = 2233603;
                n8 = 16739328;
                break;
            }
            case 6: {
                n7 = 8075577;
                n8 = 16189448;
                break;
            }
            case 7: {
                n7 = 4467457;
                n8 = 16757760;
                break;
            }
            case 8: {
                n7 = 10122756;
                n8 = 0xC000FF;
                break;
            }
            case 9: {
                n7 = 11563064;
                n8 = 3676168;
                break;
            }
            case 10: {
                n7 = 1311269;
                n8 = 0x868686;
            }
        }
        if (n6 == 2) {
            u.b(b, string, n2, n3, n4, n8, n7);
            return;
        }
        b.setColor(n8);
        u.c(b, string, n2, n3, n4);
    }

    public static void b(String string, int n2, int n3, int n4, int n5) {
        byte by;
        byte by2 = (byte)n4;
        int n6 = 0;
        int n7 = 0;
        do {
            if ((by = (byte)string.indexOf("#", n6)) != -1) {
                String string2 = string.substring(n6, by);
                ah.b(string2, n2 + n7, n3, 0, (int)by2, n5);
                ad.b();
                n7 = (short)(n7 + ad.b(string2));
                by2 = (byte)(Integer.parseInt(string.substring(by + 1, by + 2)) - 1);
                n6 = (byte)(by + 2);
                if (by2 != -1) continue;
                by2 = (byte)n4;
                continue;
            }
            ah.b(string.substring(n6, string.length()), n2 + n7, n3, 0, (int)by2, n5);
        } while (by != -1);
    }

    public final void b(StringBuffer[] stringBufferArray, int n2, int n3, int n4, int n5, int n6) {
        n4 += 251;
        n5 = 0;
        while (n5 < stringBufferArray.length) {
            ah.b(stringBufferArray[n5].toString(), n2, n3 + 4 + n5 * n4, 0, 0);
            n5 = (byte)(n5 + 1);
        }
        System.out.println(stringBufferArray[0].toString());
        new Exception().printStackTrace();
    }

    public final void b() {
        ad.b();
        this.b = ad.b("data/ui");
        ad.b();
        ad.c = 0;
        this.b = ad.b().b(ad.b().b("data/ui_m.d", -1), 0);
    }

    public final void a(int n2, int n3, int n4, int n5, int n6) {
        ah.b(this.b, this.b[n2][0], this.b[n2][1], this.b[n2][2], this.b[n2][3], n3, n4, n5, n6, b);
    }

    public static void b(int n2, int n3, int n4, boolean bl) {
        b.setColor(bl ? 458827 : 11563064);
        b.drawRect(n2 - 1, n3 + 5, 5, 8);
        b.drawRect(n2 + 5, n3 + 2, 5, 11);
        b.drawRect(n2 + 11, n3 - 1, 6, 14);
        b.setColor(bl ? 16048400 : 3676168);
        b.drawRect(n2, n3 + 6, 4, 6);
        b.drawRect(n2 + 6, n3 + 3, 4, 9);
        b.drawRect(n2 + 12, n3, 4, 12);
        if (n4 > 0) {
            b.fillRect(n2 + 1, n3 + 7, 3, 5);
        }
        if (n4 > 30) {
            b.fillRect(n2 + 7, n3 + 4, 3, 8);
        }
        if (n4 > 60) {
            b.fillRect(n2 + 13, n3 + 1, 3, 11);
        }
    }

    public static void e(int n2, int n3, int n4, int n5, int n6) {
        n6 = n6 == 0 ? 15400191 : (n6 == 1 ? 12352252 : (n6 == 2 ? 12313343 : (n6 == 3 ? 5228543 : (n6 == 4 ? 30975 : 11121884))));
        b.setColor(n6);
        b.fillRect(n2 + 1, n3, n4 - 2, n5);
        b.fillRect(n2, n3 + 1, n4, n5 - 2);
    }

    public static void d(int n2, int n3, int n4, int n5, int n6) {
        byte by = (byte)n6;
        n6 = n6 == 2 ? 15400191 : 1908277;
        b.setColor(n6);
        b.drawRect(n2 + 1, n3, n4 - 3, n5 - 1);
        b.drawRect(n2, n3 + 1, n4 - 1, n5 - 3);
        ah.e(n2 + 1, n3 + 1, n4 - 2, n5 - 2, by);
    }

    public static void h(int n2, int n3, int n4, int n5, int n6) {
        b.setColor(n6 == 0 ? 0x535453 : 1908277);
        b.drawRect(n2, n3 + 2, n4, n5 - 3);
        b.drawLine(n2 + 1, n3 + n5, n2 + n4 - 1, n3 + n5);
        n6 = n6 == 0 || n6 == 1 ? 15400191 : (n6 == 2 ? 13892607 : (n6 == 3 ? 7727871 : 12352252));
        b.setColor(n6);
        b.fillRect(n2 + 1, n3, n4 - 2, n5);
        b.fillRect(n2, n3 + 1, n4, n5 - 2);
    }

    public static void b(int n2, int n3, int n4, int n5) {
        b.setColor(0);
        b.fillRect(n2, n3, n4, n5);
        b.setColor(30975);
        b.fillRect(n2 + 2, n3 + 2, n4 - 4, n5 - 4);
    }

    public static void c(int n2, int n3, int n4, int n5) {
        b.setColor(16771373);
        b.drawLine(n2 + 1, n3, n2 + n4 - 2, n3);
        b.drawLine(n2 + 1, n3 + n5 - 1, n2 + n4 - 2, n3 + n5 - 1);
        b.drawLine(n2, n3 + 1, n2, n3 + n5 - 2);
        b.drawLine(n2 + n4 - 1, n3 + 1, n2 + n4 - 1, n3 + n5 - 2);
        b.drawLine(n2, n3 + 1, n2 + 1, n3 + 1);
        b.drawLine(n2 + n4 - 2, n3 + 1, n2 + n4 - 1, n3 + 1);
        b.drawLine(n2, n3 + n5 - 2, n2 + 1, n3 + n5 - 2);
        b.drawLine(n2 + n4 - 2, n3 + n5 - 2, n2 + n4 - 2, n3 + n5 - 2);
    }

    public static void a(int n2, int n3, int n4, int n5) {
        b.setColor(1908277);
        b.drawRect(n2 + 1, n3, n4 - 4, n5 - 2);
        b.drawRect(n2 + 2, n3 + 1, n4 - 4, n5 - 2);
        b.drawLine(n2, n3 + 1, n2, n3 + n5 - 3);
        b.drawLine(n2 + n4 - 1, n3 + 2, n2 + n4 - 1, n3 + n5 - 2);
        ah.b(15400191, n2 + 1, n3 + 1, n4 - 3, n5 - 3);
    }

    public static void b(int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8 = 16125468;
        if (n7 == 1) {
            n8 = 55551;
        } else if (n7 == 2) {
            n8 = 60177;
        }
        ah.b(4067649, n2 + 1, n3, n4 - 1, 5);
        b.drawRect(n2, n3 + 1, n4, 2);
        ah.b(16752385, n2 + 1, n3 + 1, n5, 3);
        ah.b(n8, n2 + 1, n3 + 1, n5 > n6 ? n6 : n5, 3);
    }

    public final void b(int n2, int n3, int n4, int n5, int n6, boolean bl) {
        if (!bl) {
            ah.e(n2 - 2, n3 - 2, 14, n4 + 4, 0);
        }
        ah.e(n2, n3, 10, n4, bl ? 0 : 3);
        ah.e(n2, n3, 10, 11, bl ? 2 : 4);
        ah.e(n2, n3 + n4 - 11, 10, 11, bl ? 2 : 4);
        this.a(12, n2 + 1, n3 + 1, 0, 0);
        this.a(18, n2 + 1, n3 + n4 - 10, 0, 0);
        n4 -= 22;
        if (--n6 <= 0) {
            ah.e(n2 + 1, n3 + 12, 8, n4 - 2, bl ? 3 : 0);
            return;
        }
        int n7 = n4 / (n6 + 1);
        if (n7 < 15) {
            n7 = 15;
        }
        n4 = (short)((n4 - 2 - n7) * n5 / n6);
        ah.e(n2 + 1, n3 + 12 + n4, 8, n7, bl ? 3 : 0);
    }

    public final void c(String string, int n2, int n3, int n4, int n5) {
        if (string.length() == 0) {
            return;
        }
        byte by = (byte)(n4 == 0 ? 0 : string.length() - 1);
        int n6 = 0;
        do {
            int n7 = n5 == 0 ? 8 : (n5 == 1 ? 10 : 14);
            int n8 = -1;
            char c2 = string.charAt(by);
            if (c2 >= '0' && c2 <= '9') {
                n8 = (byte)(c2 - 48);
                n8 = n5 == 0 ? (int)((byte)(n8 + 10)) : (n5 == 1 ? (int)((byte)(n8 + 35)) : (int)((byte)(n8 + 57)));
            } else if (c2 == '/') {
                n8 = 20;
            } else if (c2 == '-') {
                n8 = (byte)(n5 == 2 ? 56 : 46);
            } else if (c2 == '+') {
                n8 = 47;
            } else if (c2 == '%') {
                n8 = 45;
                n7 = 14;
            } else if (c2 == '\u7ea7') {
                n8 = 29;
                n7 = 12;
            }
            if (n8 != -1) {
                if (n4 == 0) {
                    this.a(n8, n2 + n6, n3, 36, 0);
                } else {
                    this.a(n8, n2 - n6, n3, 40, 0);
                }
                n6 = (short)(n6 + n7);
            } else {
                if (n4 == 0) {
                    ah.b("" + c2, n2 + n6, n3 + 5, 36, 3, 0);
                } else {
                    ah.b("" + c2, n2 - n6, n3 + 5, 40, 3, 0);
                }
                n6 = (short)(n6 + 19);
            }
            by = n4 == 0 ? (byte)(by + 1) : (byte)(by - 1);
        } while (n4 != 0 ? by >= 0 : by < string.length());
    }

    public final void c(int n2, int n3, int n4, int n5, int n6, int n7) {
        b.setColor(n2);
        ad.b();
        int n8 = n3 - ad.a(this.b);
        ad.b();
        int n9 = n4 - ad.a(this.b);
        ad.b();
        int n10 = n5 + (ad.a(this.b) << 1);
        ad.b();
        b.drawRect(n8, n9, n10, n6 + (ad.a(this.b) << 1));
        this.b = (byte)(this.b + 1);
        if (this.b > n7) {
            this.b = (byte)(-n7);
        }
    }

    public static void c() {
        ah.b(5422575, 0, 0, 240, 320);
    }

    public final void b(int n2, int n3, int n4, boolean bl, boolean bl2) {
        ad.b();
        this.a(30, n2 - n4 - ad.a(this.c), n3, 6, 4);
        ad.b();
        this.a(14, n2 + 6 - n4 - ad.a(this.c), n3, 6, 0);
        ad.b();
        this.a(30, n2 + n4 + ad.a(this.c), n3, 10, 0);
        ad.b();
        this.a(16, n2 - 6 + n4 + ad.a(this.c), n3, 10, 0);
        if (bl2 && (this.c = (byte)(this.c + 1)) > 4) {
            this.c = (byte)-3;
        }
    }

    public final void b(boolean bl, boolean bl2) {
        if (bl) {
            this.a(27, 0, 320, 36, 0);
        }
        if (bl2) {
            this.a(28, 240, 320, 40, 0);
        }
    }

    public static void b(Object[] objectArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        for (n5 = 0; n5 < objectArray.length; n5 = (int)((byte)(n5 + 1))) {
            ah.b(objectArray[n5].toString(), n2 + (n4 >> 1), n3 + 2 + n5 * 26, 17, n5 == n6 ? 0 : 3, 0);
        }
    }

    public final void b(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        for (n10 = 0; n10 < n2; n10 = (int)((byte)(n10 + 1))) {
            if (n10 == n9) continue;
            ah.d(n3 + n6, n4 + n10 * (n7 + n8), n5 - (n6 << 1), n7, 2);
        }
        if (n9 != -1) {
            ah.h(n3, n4 + n9 * (n7 + n8), n5, n7, 4);
        }
    }

    public static void b(Object[] objectArray, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        for (n4 = 0; n4 < 3 && n4 < objectArray.length; n4 = (int)((byte)(n4 + 1))) {
            ah.b();
            ah.b(objectArray[n4].toString(), n2, n3 + n6 * n4, 0, n7, 0);
        }
    }

    static {
        b = new short[]{0, 5, 3, 6, 2, 4, 1, 7};
    }
}

