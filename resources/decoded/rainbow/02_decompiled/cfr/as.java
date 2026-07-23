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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class as {
    public static ag b;
    public static Image b;
    public static Graphics b;
    public static Graphics c;
    private static DirectGraphics b;
    public StringBuffer[] c;
    public StringBuffer[] a;
    public StringBuffer[] e;
    public StringBuffer[] d;
    public int g;
    public String b;
    public int f;
    private byte b;
    public StringBuffer[] h;
    public byte o;
    public byte q;
    public byte[] d;
    public byte[] h;
    public byte[] g;
    public String c;
    public String[] c;
    public byte s;
    public byte r;
    public byte t;
    public byte u;
    public byte v;
    public byte[] f;
    public byte[] i;
    public byte[][] h;
    public short c;
    public short a;
    public byte[][][] b;
    public byte[] j;
    public byte w;
    public byte x;
    public byte[] k;
    public byte y;
    public byte z;
    public al b;
    public al[] b;
    public al[] c;
    public byte[] l;
    public byte[] m;
    public byte[] n;
    public byte[] p;
    public byte[][] g;

    public as() {
        byte[] byArray = new byte[]{20, 36, 40, 24, 24, 40, 36, 20};
        short[] sArray = new short[]{0, 90, 180, 270, 8192, 8282, 8372, 8462};
        this.g = 120;
        this.b = "";
        this.f = 240;
        this.b = 0;
        this.o = 0;
        this.q = 0;
        this.d = new byte[]{0, 0, 0, 0};
        this.f = new byte[4];
        this.i = new byte[4];
        this.h = new byte[2][2];
        this.w = (byte)3;
        this.x = (byte)10;
    }

    public static void c(Graphics graphics) {
        c = graphics;
        DirectUtils.getDirectGraphics((Graphics)graphics);
    }

    public static void n() {
        b = Image.createImage((int)260, (int)340);
        b = b.getGraphics();
    }

    public final void b(String string, int n2, int n3) {
        if (n3 == 0) {
            ad.b();
            this.c = ad.b(string, n2);
            return;
        }
        if (n3 == 1) {
            ad.b();
            this.a = ad.b(string, n2);
            return;
        }
        if (n3 == 2) {
            ad.b();
            this.e = ad.b(string, n2);
            return;
        }
        if (n3 == 3) {
            ad.b();
            this.d = ad.b(string, n2);
        }
    }

    public static short b(String string) {
        int n2 = 0;
        byte by = 0;
        byte by2 = (byte)string.indexOf("#", 0);
        if (by2 == 0) {
            by2 = 1;
        }
        while (by2 != -1) {
            by = (byte)(by + by2);
            by2 = (byte)string.indexOf("#", (int)by);
            n2 = (byte)(n2 + 1);
        }
        ad.b();
        return (short)(ad.b("#1") * n2);
    }

    public static void a(int n2, int n3, int n4, int n5) {
        ah.b();
        ah.b("Nh\u1ea5n n\u00fat 0 \u0111\u1ec3 ti\u1ebfp t\u1ee5c", 120, 296, 33, 0, 0);
    }

    public static void c(String string, int n2) {
        ah.b();
        ah.b("Nh\u1ea5n n\u00fat 0" + string, 120, 310, 33, 0, 0);
    }

    public final void b(String string, int n2, int n3, int n4, int n5, int n6, int n7) {
        ad.b();
        short s2 = (short)(ad.b(string) - as.b(string));
        n2 = s2;
        if (s2 > 206) {
            this.g -= 2;
            if (this.g + n2 < 11) {
                this.g = 160;
            }
        } else {
            this.g = 11;
        }
        c.clipRect(11, 278, 206, 25);
        ah.b();
        ah.b(string, this.g, 278, 0, 1);
        c.setClip(0, 0, 240, 320);
    }

    public final void b(String string, int n2, int n3, int n4, int n5, int n6) {
        ad.b();
        n6 = (short)ad.b(string);
        this.f -= 2;
        if (this.f + n6 < n3 << 1) {
            this.f = 241;
        }
        c.clipRect(n3, n2, 240 - (n3 << 1), 25);
        ah.b();
        ah.b(string, this.f, n2, 0, n4, n5);
        c.setClip(0, 0, 240, 320);
    }

    private void b(int n2, int n3) {
        ah.b().a(40, n2, n3 + (this.b % 3 == 0 ? 1 : 0), 0, 0);
        byte by = this.b;
        this.b = (byte)(by + 1);
        if (by > 100) {
            this.b = 0;
        }
    }

    public final void b(StringBuffer[] stringBufferArray, int n2, int n3, int n4) {
        if (n4 != 0) {
            ah.b();
            ah.a(n3 + -5, n2, 250, 20 * stringBufferArray.length + 12);
            if (n4 == 2) {
                int n5 = n2 + 20 * stringBufferArray.length + 4;
                int n6 = n3 + 120;
                as as2 = this;
                ah.b().a(40, n6, n5 + (as2.b % 3 == 0 ? 1 : 0), 0, 0);
                byte by = as2.b;
                as2.b = (byte)(by + 1);
                if (by > 100) {
                    as2.b = 0;
                }
            }
        }
        for (n4 = 0; n4 < stringBufferArray.length; n4 = (int)((byte)(n4 + 1))) {
            ah.b();
            ah.b(stringBufferArray[n4].toString(), n3 + 19, n2 + 4 + n4 * 20, -1, 1);
        }
    }

    public static void c(String stringArray, int n2, int n3) {
        stringArray = u.b((String)stringArray, 240);
        n3 = stringArray.length;
        ah.b();
        ah.d(-5, n2, 250, 20 * (n3 + 1) + 8, 3);
        int n4 = 0;
        while (n4 < n3) {
            ah.b(stringArray[n4], 120, n2 + 5 + n4 * 20, 17, 13, 0);
            ++n4;
        }
    }

    public static void b(String stringArray, int n2, int n3, int n4, int n5) {
        stringArray = u.b((String)stringArray, (n4 + 2) * 13);
        n4 = stringArray.length;
        int n6 = 0;
        while (n6 < n4) {
            ah.b(stringArray[n6], n2, n3 + n6 * 15, 17, n5, 0);
            ++n6;
        }
    }

    public final void b(StringBuffer[] stringBufferArray, int n2, int n3, int n4, int n5) {
        n4 = (byte)(n2 * this.q);
        for (n3 = (int)(v82860); n3 < n4 + n2 && n3 < stringBufferArray.length; n3 = (int)((byte)(n3 + 1))) {
            ah.b();
            ah.b(stringBufferArray[n3].toString(), 120, 10 + (n3 - n4) * 22, 17, 3, 0);
        }
        if (stringBufferArray.length > n2) {
            this.o = (byte)(stringBufferArray.length / n2 + (stringBufferArray.length % n2 != 0 ? 1 : 0));
            ah.b();
            ah.b(this.q + 1 + "/" + this.o, 120, 318, 33, 3, 0);
            ah.b().b(120, 308, 57, true, true);
            return;
        }
        this.o = 1;
    }

    public final void b(Graphics graphics, int n2, int n3, int n4, boolean bl, boolean bl2) {
        n3 = 0;
        graphics.setColor(0);
        if (!bl) {
            n4 = (short)(2 << this.d[0]);
            n3 = 9;
            while (n3 >= 0) {
                if (12 - n4 > 0) {
                    graphics.fillRect(0, n2 + n3 * 12 + (n4 < 2 ? 0 : n4), 240, 12 - (n4 < 2 ? 0 : n4));
                }
                n3 = (byte)(n3 - 1);
                n4 = (short)(n4 / 2);
            }
            if (bl2 && this.d[0] < 12) {
                this.d[0] = (byte)(this.d[0] + 1);
                return;
            }
            if (!bl2 && this.d[0] > 0) {
                this.d[0] = (byte)(this.d[0] - 1);
                return;
            }
        } else {
            n4 = (short)(2 << this.d[1]);
            while (bl && n3 < 10) {
                if (12 - n4 > 0) {
                    graphics.fillRect(0, n2 + n3 * 12, 240, 12 - (n4 < 2 ? 0 : n4));
                }
                n3 = (byte)(n3 + 1);
                n4 = (short)(n4 / 2);
            }
            if (bl2 && this.d[1] < 12) {
                this.d[1] = (byte)(this.d[1] + 1);
                return;
            }
            if (!bl2 && this.d[1] > 0) {
                this.d[1] = (byte)(this.d[1] - 1);
            }
        }
    }

    public static String b(String string) {
        ad.b();
        ad.c = 0;
        ad.b();
        return ad.b(ad.b().b(string, -1))[0].toString();
    }

    public static byte[] b(int n2) {
        return ad.b().b("4", n2);
    }

    public static void b(Object[] objectArray, int n2, int n3, int n4, int n5, int n6, int n7) {
        for (n6 = 0; n6 < objectArray.length; n6 = (int)((byte)(n6 + 1))) {
            ah.b();
            ah.d(n2, n3 + n6 * (n5 + 28), n4, 28, n6 == n7 ? 1 : 0);
            ah.b();
            ah.b(objectArray[n6].toString(), n2 + (n4 >> 1), n3 + 2 + n6 * (n5 + 28), 17, n6 == n7 ? 0 : 3, 1);
        }
    }

    public final void e(int n2, int n3, int n4, int n5) {
        ah.b();
        ah.b(63, 40, 124, 200);
        ah.b();
        ah.h(72, 71, 106, 180 - 3 * this.c.length - 5, 0);
        ah.b().b(this.c.length, 71, 73, 108, 1, 27, -1, this.v, 4, 2);
        ah.b();
        ah.b(this.c, 71, 73, 108, 26, this.v, 0, 3, 0);
        if (this.u == 1) {
            ah.b();
            ah.b(136, 104, (int)ai.b().b, this.v == 1);
        }
        ah.b();
        ah.h(125 + (this.u == 0 ? -40 : 0), 44, 40, 24, 4);
        ah.b();
        ah.b("Menu", 106, 45, 17, this.u == 0 ? 0 : 1, 0);
        ah.b();
        ah.b("H\u1ec7 th\u1ed1ng", 144, 45, 17, this.u == 0 ? 1 : 0, 0);
        ah.b().b(125, 52, 57, true, true);
    }

    private static void b(ByteArrayOutputStream byteArrayOutputStream, al al2) {
        byteArrayOutputStream.write(al2.b);
        short s2 = 0;
        for (int i2 = 0; i2 < 5; ++i2) {
            s2 = al2.b[i2];
            byteArrayOutputStream.write((byte)s2);
            byteArrayOutputStream.write((byte)(s2 >> 8));
        }
    }

    private void b(ByteArrayInputStream byteArrayInputStream, al al2, byte[][] byArray) {
        al2.b = new byte[18];
        al2.b = new short[8];
        byteArrayInputStream.read(al2.b);
        this.g = new byte[10];
        byteArrayInputStream.read(this.g);
        for (int i2 = 0; i2 < 5; ++i2) {
            al2.b[i2] = (short)((this.g[1 + (i2 << 1)] & 0xFF) << 8 | this.g[0 + (i2 << 1)] & 0xFF);
        }
        al2.b(byArray[al2.b[0]]);
        this.g = null;
    }

    public final void j(int n2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int n3;
            if (n2 == 0) {
                byteArrayOutputStream.write(this.z);
                for (n3 = 0; n3 < this.z; ++n3) {
                    as.b(byteArrayOutputStream, this.c[n3]);
                }
                ad.b();
                ad.b(8, byteArrayOutputStream.toByteArray(), 2);
            } else {
                byteArrayOutputStream.write(this.y);
                while (n3 < this.y) {
                    as.b(byteArrayOutputStream, this.b[n3]);
                    ++n3;
                }
                ad.b();
                ad.b(9, byteArrayOutputStream.toByteArray(), 2);
            }
            byteArrayOutputStream.close();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public final void b(int n2, byte[][] byArray) {
        ad.b();
        this.h = ad.b(n2 + 8, null, 1);
        try {
            int n3;
            ByteArrayInputStream byteArrayInputStream;
            if (n2 == 0) {
                this.c = new al[95];
                if (this.h[0] == -1) {
                    this.z = 0;
                    return;
                }
                byteArrayInputStream = new ByteArrayInputStream(this.h);
                this.z = (byte)byteArrayInputStream.read();
                for (n3 = 0; n3 < this.z; ++n3) {
                    this.c[n3] = new al();
                    this.b(byteArrayInputStream, this.c[n3], byArray);
                }
            } else {
                this.b = new al[5];
                if (this.h[0] == -1) {
                    this.y = 0;
                    return;
                }
                byteArrayInputStream = new ByteArrayInputStream(this.h);
                this.y = (byte)byteArrayInputStream.read();
                while (n3 < this.y) {
                    this.b[n3] = new al();
                    this.b(byteArrayInputStream, this.b[n3], byArray);
                    ++n3;
                }
            }
            byteArrayInputStream.close();
            this.h = null;
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public final void p() {
        ad.b();
        ad.b(6, this.k, 2);
    }

    public final void o() {
        ad.b();
        this.h = ad.b(6, null, 1);
        if (this.h[0] == -1) {
            this.k = new byte[105];
            for (int i2 = 0; i2 < this.k.length; ++i2) {
                this.k[i2] = 0;
            }
        } else {
            this.k = this.h;
        }
        this.h = null;
    }

    public final void q() {
        ad.b();
        this.h = ad.b(10, null, 1);
        if (this.h[0] == -1) {
            this.a(true);
            this.t();
        } else {
            this.l = this.h;
            this.a(false);
        }
        this.h = null;
    }

    public final void a(boolean bl) {
        if (bl) {
            this.w = (byte)3;
            this.x = (byte)10;
            return;
        }
        if (this.l[3] == 2) {
            this.w = (byte)4;
            this.x = (byte)20;
            return;
        }
        if (this.l[3] == 3) {
            this.w = (byte)5;
            this.x = (byte)40;
            return;
        }
        if (this.l[3] == 4) {
            this.w = (byte)5;
            this.x = (byte)80;
            return;
        }
        if (this.l[3] == 5) {
            this.w = (byte)5;
            this.x = (byte)95;
        }
    }

    public final byte b(boolean bl) {
        switch (this.l[3]) {
            case 1: {
                if (bl && this.k[103] > 4) {
                    this.l[3] = 2;
                    break;
                }
                return 5;
            }
            case 2: {
                if (bl && this.k[103] > 9) {
                    this.l[3] = 3;
                    break;
                }
                return 10;
            }
            case 3: {
                if (bl && this.k[103] > 14) {
                    this.l[3] = 4;
                    break;
                }
                return 15;
            }
            case 4: {
                if (bl && this.k[103] > 29) {
                    this.l[3] = 5;
                    break;
                }
                return 30;
            }
        }
        return -1;
    }

    public final void s() {
        int n2;
        int n3 = 0;
        for (n2 = 0; n2 < 4; ++n2) {
            n3 += this.j[n2];
        }
        this.h = new byte[this.b.length + (n3 << 1)];
        n3 = 0;
        for (n2 = 0; n2 < 4; ++n2) {
            this.h[n2] = this.j[n2];
        }
        for (n2 = 0; n2 < this.b.length; ++n2) {
            int n4 = 0;
            while (n4 < this.j[n2]) {
                this.h[(n3 << 1) + 4] = this.b[n2][n4][0];
                this.h[(n3 << 1) + 4 + 1] = this.b[n2][n4][1];
                ++n4;
                ++n3;
            }
        }
        ad.b();
        ad.b(4, this.h, 2);
        this.h = null;
    }

    public final void r() {
        ad.b();
        this.h = ad.b(4, null, 1);
        this.g = new byte[]{16, 19, 23, 12};
        this.j = new byte[4];
        int n2 = 0;
        int n3 = 0;
        if (this.h[0] != -1) {
            for (n2 = 0; n2 < 4; ++n2) {
                this.j[n2] = this.h[n2];
            }
        }
        this.b = new byte[this.j.length][][];
        int n4 = 0;
        for (n2 = 0; n2 < this.b.length; ++n2) {
            this.b[n2] = new byte[this.g[n2]][2];
            n3 = 0;
            while (n3 < this.j[n2]) {
                this.b[n2][n3][0] = this.h[(n4 << 1) + 4];
                this.b[n2][n3][1] = this.h[(n4 << 1) + 4 + 1];
                ++n3;
                ++n4;
            }
        }
        this.h = null;
        this.g = null;
    }

    public final void t() {
        this.l = null;
        this.l = new byte[]{-1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public final void u() {
        ad.b();
        this.m = ad.b(5, null, 1);
        if (this.m[0] == -1) {
            this.m = null;
            this.m = new byte[]{-3, 0, 0, 0, 0, 0, 0};
        }
        if (this.m[0] == 10) {
            this.l[2] = (byte)(this.l[2] | 8);
        }
    }

    public final void v() {
        ad.b();
        this.n = ad.b(3, null, 1);
        if (this.n[0] == -1) {
            this.n = null;
            this.n = new byte[]{-2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10};
        }
    }

    public final byte c(int n2) {
        return this.n[n2 * 5];
    }

    public final byte a(int n2) {
        return this.g[0][this.c(n2)];
    }

    public final byte e(int n2) {
        return this.g[1][this.c(n2)];
    }

    public final short b(int n2, int n3) {
        ad.b();
        return ad.b(this.n, n2 * 5 + n3);
    }

    public final boolean c(int n2) {
        for (int n3 = 0; n3 < this.n.length; n3 = (int)((byte)(n3 + 5))) {
            if (this.n[n3] != -2) continue;
            this.n[n3] = (byte)n2;
            ad.b();
            ad.c(0, this.n, n3 + 1);
            ad.b();
            ad.c(200, this.n, n3 + 3);
            return true;
        }
        return false;
    }

    public final void k(int n2) {
        this.n[n2 * 5] = -2;
    }

    public final void l(int n2) {
        n2 = n2 / 10 <= 0 ? 1 : n2 / 10;
        for (int n3 = 0; n3 < 5; n3 = (int)((byte)(n3 + 1))) {
            if (this.c(n3) == -2) continue;
            ad.b();
            ad.c(this.b(n3, 1) + n2, this.n, n3 * 5 + 1);
            if (this.b(n3, 1) <= this.b(n3, 3)) continue;
            ad.b();
            ad.c((int)this.b(n3, 3), this.n, n3 * 5 + 1);
        }
    }
}

