/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class at {
    private static Graphics b;
    private int c;
    private int a;
    private short b;
    private short c;
    private short a;
    private short e;
    private short d;
    private short h;
    private short g;
    private short f;
    public aj[][] b;
    private static aj c;
    private byte i;
    private byte j;
    private byte k;
    private byte l;
    private byte m;
    private byte n;
    private short i;
    private short j;
    private byte[] b;
    private byte[][] c;
    private byte[][] a;
    private byte p;
    private byte o;
    private byte q;
    private byte[][] e;
    private byte[][] d;
    private int e;
    public byte b;
    public byte c;
    public byte a;
    private byte s = 0;
    public byte e;
    public byte d;
    private short[] b;
    private short[][] b;
    private short[] c;
    private StringBuffer[] b;
    private ak b;
    private String[] b;
    private String[] c;
    private byte r;
    private byte[] c;
    private byte t;
    private boolean c;
    private byte u = 0;
    public byte h;
    private byte v;
    private byte w;
    public byte g;
    private String b;
    public boolean b;
    private byte x = 0;
    private byte y;
    private byte z;
    private byte[][] h;
    private byte B = 0;
    private byte A;
    private boolean a;
    private byte C;
    private byte D;
    private byte F = 0;
    private boolean e;
    private byte[][] g;
    private byte[][] f;
    private byte G;
    private byte H;
    private byte I;
    private short k;
    private short l;
    private short m;
    private boolean d;
    private StringBuffer[][] b;
    private byte[] a;
    private byte[] e;
    private short[][] c;
    public Image[] b;
    private int d;
    private short[] a;
    private short[] e;
    private short[][] a;
    public byte f = 0;
    private int h;
    private int g;
    private Image b;
    private boolean h = false;
    private byte E;
    private short n = 0;
    private am b;
    private byte J;
    private byte K;
    private Image c = null;
    public static am[][] b;
    private byte[] d = 0;
    private short p = 0;
    private short o = 0;
    private boolean g = false;
    private byte L = 0;
    public aj b;
    private Image a = null;
    private short[][] e = null;
    private byte M;
    public byte[][] b = null;
    public static int b;

    public final void b(int n2, int n3) {
        if (n2 == 0) {
            this.e = 0;
            ad.b();
            this.j = (short)(ad.c(30) + 1);
            this.i = (short)((this.j - 15) * (this.j - 15));
            ad.b();
            if (this.i > ad.c(50)) {
                ad.b();
                int n4 = 17 + ad.c(9);
                ad.b();
                this.j = (byte)(n4 - ad.c(7));
            }
            this.j = (short)(this.j << 2);
            this.i = 0;
            this.r = (byte)-1;
            return;
        }
        if (n2 == 1) {
            this.e = 1;
            this.j = (short)(200 * (n3 - 14 + 1));
            this.j = (short)(this.j << 2);
            this.i = 0;
            this.r = (byte)100;
        }
    }

    public at(ak object) {
        this.j = (byte)-1;
        this.j = (short)4;
        this.e = new byte[70][];
        this.b = (byte)-1;
        this.c = (byte)-1;
        this.d = (byte)-1;
        this.r = (byte)-1;
        this.t = (byte)-2;
        this.h = (byte)-1;
        this.h = new byte[][]{{0, 0}, {0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        this.A = (byte)-1;
        this.D = (byte)-1;
        this.G = (byte)-1;
        this.m = (short)300;
        this.E = (byte)-1;
        this.M = (byte)-1;
        this.b = object;
        System.gc();
        object = this;
        at at2 = object;
        if (at2.b == null) {
            at2.b = ad.b().b("data/face/brow", true);
        }
        at.b[0] = new am[100];
        at.b[1] = new am[5];
        at.b[2] = new am[60];
        if (null == b[1][0]) {
            at.b[1][0] = new am();
            ((at)object).b = new aj(8);
            ((at)object).b.b[4] = 1;
            ((at)object).g();
        }
        if (((at)object).c == null) {
            ad.b();
            ((at)object).c = ad.b("data/shadow");
        }
    }

    private void j() {
        ad.b();
        this.c = ad.b(at.b(ak.b(1), (int)this.a));
        ad.b();
        this.b = ad.b(at.b(ak.b(2), (int)this.a));
    }

    public final void b() {
        ad.b();
        byte[] byArray = ad.b(2, null, 1);
        if (byArray[0] == -1) {
            byte[] byArray2 = new byte[]{58, 9, 16, 2, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, -1};
            byArray = byArray2;
            ad.b();
            ad.b(2, byArray2, 2);
            this.b = new short[70][];
            ad.b();
            ad.b();
            ad.b(11, ad.b(this.b), 2);
        } else {
            this.b = ad.b().b();
        }
        this.a = byArray[0];
        this.l = byArray[5];
        this.m = byArray[6];
        this.b.b(byArray[1], byArray[2], 0, 0);
        this.b.n = byArray[3];
        this.b.b(false);
        ad.b();
        this.b.b = ad.b(byArray, 7);
        ad.b();
        this.b.c = ad.b(byArray, 11);
        this.c = byArray[15];
    }

    private void k() {
        byte[] byArray = new byte[16];
        byte[] byArray2 = byArray;
        byArray[0] = this.a;
        byArray2[5] = this.l;
        byArray2[6] = this.m;
        byArray2[1] = (byte)(this.b.b / 20);
        byArray2[2] = (byte)(this.b.c / 20);
        byArray2[3] = this.b.n;
        ad.b();
        ad.b(this.b.b, byArray2, 7);
        ad.b();
        ad.b(this.b.c, byArray2, 11);
        byArray2[15] = this.c;
        ad.b();
        ad.b(2, byArray2, 2);
    }

    public final void c() {
        at at2 = this;
        byte[] byArray = new byte[16];
        byte[] byArray2 = byArray;
        byArray[0] = at2.a;
        byArray2[5] = at2.l;
        byArray2[6] = at2.m;
        byArray2[1] = (byte)(at2.b.b / 20);
        byArray2[2] = (byte)(at2.b.c / 20);
        byArray2[3] = at2.b.n;
        ad.b();
        ad.b(at2.b.b, byArray2, 7);
        ad.b();
        ad.b(at2.b.c, byArray2, 11);
        byArray2[15] = at2.c;
        ad.b();
        ad.b(2, byArray2, 2);
        this.o();
        for (int i2 = 0; i2 < this.b.length / 2; ++i2) {
            if (this.b[i2] != 1) continue;
            this.b[i2] = 0;
            ad.b();
            ad.b(i2 + 13, this.e[i2], 2);
        }
        ad.b();
        ad.b();
        ad.b(12, ad.b(this.b), 2);
        ad.b();
        ad.b();
        ad.b(11, ad.b(this.b), 2);
        ad.b();
        ad.b(1, this.b, 2);
        ad.b();
        ad.b(7, this.a, 2);
        ad.b();
        ad.b(5, (byte[])this.b.m, 2);
        ad.b();
        ad.b(1, null, 4);
    }

    private static byte[] b(byte[] byArray, int n2) {
        int n3 = 1;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = (byArray[n3++] & 0xFF) << 8 | byArray[n3++] & 0xFF;
            n3 += n4;
        }
        byte[] byArray2 = new byte[(byArray[n3++] & 0xFF) << 8 | byArray[n3++] & 0xFF];
        System.arraycopy(byArray, n3, byArray2, 0, byArray2.length);
        return byArray2;
    }

    private void l() {
        int n2;
        byte[] byArray = ad.b().b("event", (int)this.a);
        int n3 = 0;
        if (byArray.length == 1) {
            this.e = 0;
            return;
        }
        ++n3;
        this.e = byArray[0];
        if (this.b[this.a << 1] <= 0) {
            this.b[this.a] = null;
            this.b[this.a] = new short[this.e];
        } else {
            for (n2 = 0; n2 < this.e; n2 = (int)((byte)(n2 + 1))) {
                if (!this.b((int)this.a, n2)) continue;
                this.b[this.a][n2] = 24224;
            }
        }
        this.c = this.b[this.a];
        this.d = new byte[this.e][];
        short s2 = 0;
        for (n2 = 0; n2 < this.e; n2 = (int)((byte)(n2 + 1))) {
            s2 = (short)(byArray[n3++] << 8 | byArray[n3++] & 0xFF);
            this.d[n2] = new byte[s2];
            System.arraycopy(byArray, n3, this.d[n2], 0, this.d[n2].length);
            n3 += s2;
        }
    }

    private void m() {
        at at2 = this;
        if (at2.b == null) {
            at2.b = ad.b().b("data/face/brow", true);
        }
        at.b[0] = new am[100];
        at.b[1] = new am[5];
        at.b[2] = new am[60];
        if (null == b[1][0]) {
            at.b[1][0] = new am();
            this.b = new aj(8);
            this.b.b[4] = 1;
            this.g();
        }
        if (this.c == null) {
            ad.b();
            this.c = ad.b("data/shadow");
        }
    }

    private static void n() {
        at.b[0] = new am[100];
        at.b[1] = new am[5];
        at.b[2] = new am[60];
    }

    public final void a() {
        this.b.n = (byte)4;
        this.j = (byte)-1;
        ak ak2 = this.b;
        ad.b();
        ((as)this.b).m = ad.b(5, null, 1);
        if (((as)ak2).m[0] == -1) {
            ((as)ak2).m = null;
            ((as)ak2).m = new byte[]{-3, 0, 0, 0, 0, 0, 0};
        }
        if (((as)ak2).m[0] == 10) {
            ((as)ak2).l[2] = (byte)(((as)ak2).l[2] | 8);
        }
        ak2 = this.b;
        ad.b();
        ((as)this.b).n = ad.b(3, null, 1);
        if (((as)ak2).n[0] == -1) {
            ((as)ak2).n = null;
            ((as)ak2).n = new byte[]{-2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10};
        }
        this.b(0, 0);
        ad.b();
        ad.b();
        this.b = ad.b(ad.b(12, null, 1));
        ad.b();
        this.b = ad.b(1, null, 1);
        for (int n2 = 0; n2 < this.b.length; n2 = (int)((short)(n2 + 1))) {
            if (this.b[n2] != 1) continue;
            ad.b();
            this.e[n2] = ad.b(n2 + 13, null, 1);
        }
        System.gc();
        this.b.a = (byte)33;
        this.p();
        this.b.a = (byte)35;
        this.s();
        this.b.a = (byte)37;
        this.l();
        this.b.a = (byte)39;
        this.j();
        this.b.a = (byte)40;
        ad.b();
        ad.b(1, null, 4);
        this.b.c((int)this.a, true);
        at at2 = this;
        ad.b();
        byte[] byArray = ad.b(7, null, 1);
        at2.a = (byte[])(byArray[0] == -1 ? null : byArray);
        if (at2.a == null) {
            at2.a = new byte[20];
        }
        this.V();
    }

    private void p() {
        byte by;
        int n2;
        ad.b();
        ad.c = 0;
        ad.b();
        ad.a = 0;
        byte[] byArray = at.b(ak.b(0), (int)this.a);
        Object object = byArray;
        ad.b();
        byte[] byArray2 = new byte[byArray[ad.c++]];
        for (n2 = 0; n2 < byArray2.length; ++n2) {
            ad.b();
            byArray2[n2] = object[ad.c++];
        }
        this.c = byArray2;
        if (this.b[this.a << 1] > 0 && this.e[this.a] == null) {
            ad.b();
            this.e[this.a] = ad.b(13 + this.a, null, 1);
        }
        this.b[0] = this.b(byArray);
        this.b[1] = this.b(byArray);
        this.b[2] = this.b(byArray);
        this.a = this.b(byArray);
        this.c = this.b(byArray);
        this.d = null;
        this.d = new byte[this.b[0].length + 1 + this.a.length];
        object = this;
        int n3 = 0;
        byte[][] byArrayArray = new byte[3][];
        byte[][] byArrayArray2 = byArrayArray;
        byArrayArray[0] = new byte[100];
        byArrayArray2[1] = new byte[5];
        byArrayArray2[2] = new byte[60];
        ((at)object).b.e(0);
        for (by = (byte)(((at)object).b.length - 1); by >= 0; by = (byte)(by - 1)) {
            for (n2 = (int)((byte)(((at)object).b[by].length - 1)); n2 >= 0; n2 = (int)((byte)(n2 - 1))) {
                byArrayArray2[((at)object).b[by][n2].b[3] - 1][((at)object).b[by][n2].b[2]] = 1;
                if (by != 0) continue;
                ((at)object).d[n2 + 1] = n2;
                if (((at)object).b[by][n2].b[8] != 1) continue;
                int n4 = n3;
                n3 = (byte)(n3 + 1);
                ((at)object).b.p[n4] = n2;
            }
        }
        ((at)object).b.e(1);
        ((at)object).d[0] = -1;
        for (by = (byte)(((at)object).a.length + ((at)object).b[0].length); by > ((at)object).b[0].length; by = (byte)(by - 1)) {
            ((at)object).d[by] = (byte)(-2 - by + ((at)object).b[0].length + 1);
        }
        super.b(100, 0, byArrayArray2[0]);
        super.b(5, 1, byArrayArray2[1]);
        super.b(60, 2, byArrayArray2[2]);
        for (n2 = (int)((byte)(((at)object).b[0].length - 1)); n2 >= 0; n2 = (int)((byte)(n2 - 1))) {
            ((at)object).b[0][n2].b(b[((at)object).b[0][n2].b[3] - 1][((at)object).b[0][n2].b[2]].b());
        }
    }

    private aj[] b(byte[] byArray) {
        int n2;
        int n3;
        ad.b();
        aj[] ajArray = new aj[byArray[ad.c++]];
        for (n3 = 0; n3 < ajArray.length; ++n3) {
            ad.b();
            ajArray[n3] = new aj(byArray[ad.c++]);
            for (n2 = 0; n2 < ajArray[n3].b.length; ++n2) {
                byte[] byArray2 = ajArray[n3].b;
                ad.b();
                byArray2[n2] = byArray[ad.c++];
            }
            ajArray[n3].b();
        }
        if (this.b[this.a << 1] > 0) {
            for (n3 = 0; n3 < ajArray.length; ++n3) {
                if (ajArray[n3].b[9] != 1) continue;
                for (n2 = 0; n2 < ajArray[n3].b.length; ++n2) {
                    byte[] byArray3 = ajArray[n3].b;
                    byte[] byArray4 = this.e[this.a];
                    ad.b();
                    byArray3[n2] = byArray4[ad.a++];
                }
                ajArray[n3].b();
            }
        }
        return ajArray;
    }

    private byte[][] b(byte[] byArray) {
        byte[][] byArrayArray;
        if (this.b[this.a << 1] > 0) {
            byArray = this.e[this.a];
            ad.b();
            byArrayArray = new byte[byArray[ad.a++]][];
            for (int i2 = 0; i2 < byArrayArray.length; ++i2) {
                ad.b();
                byArrayArray[i2] = new byte[byArray[ad.a++]];
                for (int i3 = 0; i3 < byArrayArray[i2].length; ++i3) {
                    byte[] byArray2 = byArrayArray[i2];
                    ad.b();
                    byArray2[i3] = byArray[ad.a++];
                }
            }
        } else {
            ad.b();
            byArrayArray = new byte[byArray[ad.c++]][];
            for (int i4 = 0; i4 < byArrayArray.length; ++i4) {
                ad.b();
                byArrayArray[i4] = new byte[byArray[ad.c++]];
                for (int i5 = 0; i5 < byArrayArray[i4].length; ++i5) {
                    byte[] byArray3 = byArrayArray[i4];
                    ad.b();
                    byArray3[i5] = byArray[ad.c++];
                }
            }
        }
        return byArrayArray;
    }

    private byte b(int n2) {
        return (byte)((this.c[n2] & 0xFF) >> 6);
    }

    private byte c(int n2) {
        return (byte)(this.c[n2] & 0x3F);
    }

    private static byte[] b(byte[] byArray) {
        ad.b();
        byte[] byArray2 = new byte[byArray[ad.c++]];
        for (int i2 = 0; i2 < byArray2.length; ++i2) {
            ad.b();
            byArray2[i2] = byArray[ad.c++];
        }
        return byArray2;
    }

    private void o() {
        this.e[this.a] = null;
        at at2 = this;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        at.b(byteArrayOutputStream, at2.b[0]);
        at.b(byteArrayOutputStream, at2.b[1]);
        at.b(byteArrayOutputStream, at2.b[2]);
        at.b(byteArrayOutputStream, at2.a);
        at.b(byteArrayOutputStream, at2.c);
        this.e[this.a] = byteArrayOutputStream.toByteArray();
        this.b[this.a << 1] = 1;
        this.b[this.a] = 1;
    }

    private void q() {
        this.c = at.b(this.b.b(), this.b, 12, 6, 240, 20);
        this.a = at.b(this.b.c(), this.c, 16, 8, 320, 20);
        this.d = (short)110;
        this.h = (short)(this.b * 20 - 120 - 10);
        this.g = (short)150;
        this.f = (short)(this.c * 20 - 160 - 10);
    }

    private void s() {
        at at2;
        at at3 = at2 = this;
        ad.b();
        ad.c = 0;
        byte[] byArray = ad.b().b("data/map/area.dat", -1);
        ad.b();
        byte[] byArray2 = ad.b(byArray);
        byte[][] byArray3 = ad.b().b(byArray);
        if (at3.b == null || byArray2[at3.l] != byArray2[at3.a]) {
            ad.b();
            ad.c = 0;
            at3.c = ad.b().b(ad.b().b("data/map/" + byArray2[at3.a] + ".data", -1), 1);
            at3.b = null;
            at3.b = new Image[byArray3[byArray2[at3.a]].length];
            for (int n2 = 0; n2 < byArray3[byArray2[at3.a]].length; n2 = (int)((byte)(n2 + 1))) {
                Image[] imageArray = at3.b;
                ad.b();
                imageArray[n2] = ad.b("data/map/" + byArray3[byArray2[at3.a]][n2]);
            }
        }
        at2.l(at2.a);
        at2 = this;
        this.c = at.b(at2.b.b(), at2.b, 12, 6, 240, 20);
        at2.a = at.b(at2.b.c(), at2.c, 16, 8, 320, 20);
        at2.d = (short)110;
        at2.h = (short)(at2.b * 20 - 120 - 10);
        at2.g = (short)150;
        at2.f = (short)(at2.c * 20 - 160 - 10);
    }

    private byte b(byte[][] byArray) {
        byte by;
        if (byArray[this.k][3] == -1) {
            by = this.a;
            this.a = this.l;
            this.l = by;
            this.m = this.k;
            by = -1;
        } else {
            by = this.a;
            this.a = byArray[this.k][4];
            this.l = by;
            this.m = this.k;
            by = byArray[this.k][3];
        }
        return by;
    }

    private void r() {
        this.o();
        this.b[this.a] = 1;
        ad.b();
        ad.b(1, this.b, 2);
    }

    private void t() {
        this.f = 0;
        this.b.b(2);
        at at2 = this;
        at2.o();
        at2.b[at2.a] = 1;
        ad.b();
        ad.b(1, at2.b, 2);
        byte by = this.m;
        if (this.t != -2) {
            this.l = this.a;
            this.a = this.u;
            this.u = 0;
            this.m = this.t;
        }
        this.b.b(5);
        if (this.t == -2) {
            int n2;
            byte[][] byArray = this.c;
            at2 = this;
            if (byArray[at2.k][3] == -1) {
                n2 = at2.a;
                at2.a = at2.l;
                at2.l = n2;
                at2.m = at2.k;
                n2 = -1;
            } else {
                n2 = at2.a;
                at2.a = byArray[at2.k][4];
                at2.l = n2;
                at2.m = at2.k;
                n2 = byArray[at2.k][3];
            }
            this.t = (byte)n2;
        }
        this.b.b(false);
        this.b.b(8);
        this.p();
        this.b.b(10);
        if (this.t == -1) {
            this.t = by;
        }
        if (!this.c) {
            byte[][] byArray = this.c;
            byte by2 = this.t;
            at2 = this;
            this.b.n = (byte)(((byArray[by2][2] - 1) / 2 << 1) + 1 + byArray[by2][2] % 2);
            at2.b.b(byArray[by2][0], byArray[by2][1], 0, 0);
        }
        this.l();
        this.b.b(15);
        this.j();
        this.s();
        this.b.b(20);
        if (!(this.c || this.c[this.t][5] != 1 && this.c[this.t][5] != 2)) {
            this.b.b = (byte)(20 / this.b.g);
            this.b.e = (byte)(this.h[this.b.n][0] * this.b.g);
            this.b.d = (byte)(this.h[this.b.n][1] * this.b.g);
            this.b.b(true);
        } else {
            this.b.b(false);
        }
        this.b.g = 0;
        boolean bl = false;
        at2 = this;
        ai.b().b(at2.b.e[at2.a]);
        ai.b().b(false);
        this.t = (byte)-2;
        this.b.c((int)this.a, true);
        this.b.l = (byte)25;
        this.j = (byte)-1;
        ad.b();
        ad.b(1, null, 4);
        this.V();
        this.c = false;
        this.b.a = (byte)9;
        if (this.M == -1) {
            this.b.a = 0;
            this.b.c(-1, -1);
            this.b.g = this.b();
        }
        this.D = (byte)-1;
    }

    private void b(int n2, int n3, int n4, int n5) {
        int n6 = n2;
        n2 = 0;
        int n7 = n6;
        at at2 = this;
        this.b.a = (byte)5;
        at2.u = (byte)n7;
        at2.t = 0;
        at2.C();
        this.c = true;
        this.b.b(n3, n4, 0, 0);
        this.b.n = (byte)n5;
    }

    private void c(int n2, int n3) {
        this.b.a = (byte)5;
        this.u = (byte)n2;
        this.t = 0;
        this.C();
    }

    private void b(byte by, byte[][] byArray) {
        this.b.n = (byte)(((byArray[by][2] - 1) / 2 << 1) + 1 + byArray[by][2] % 2);
        this.b.b(byArray[by][0], byArray[by][1], 0, 0);
    }

    private static int b(int n2, int n3, int n4, int n5, int n6, int n7) {
        n2 = n3 <= n4 ? n6 - n3 * 20 >> 1 : (n2 + 1 <= n5 ? 0 : (n2 >= n3 - n5 ? n6 - n3 * 20 : n6 / 2 - n2 * 20 - 10));
        return n2;
    }

    private boolean b(int n2, boolean bl, boolean bl2) {
        if (n2 == 2) {
            this.h = (byte)(!bl ? 1 : 0);
            return true;
        }
        if (bl2 && bl) {
            return true;
        }
        return !bl2 && n2 == 1;
    }

    private void b(int n2, int n3, int n4, int n5, boolean bl) {
        if (this.b(n5, bl, true)) {
            int n6 = n2;
            this.c[n6] = (short)(this.c[n6] + n3);
            this.c(n4);
            return;
        }
        if (this.b(n5, bl, false)) {
            this.c(n2, false);
        }
    }

    private boolean b(int n2, int n3) {
        return (this.b[(n2 << 1) + 1] & 1 << n3) != 0;
    }

    private void a(int n2, int n3) {
        if (this.b(n2, n3)) {
            int n4 = (n2 << 1) + 1;
            this.b[n4] = (short)(this.b[n4] ^ 1 << n3);
        }
        if (n2 == this.a) {
            this.c[n3] = 0;
            return;
        }
        if (null != this.b[n2]) {
            this.b[n2][n3] = 0;
        }
    }

    private void e(int n2, int n3) {
        if (!this.b(n2, n3)) {
            int n4 = (n2 << 1) + 1;
            this.b[n4] = (short)(this.b[n4] | 1 << n3);
        }
        if (n2 == this.a) {
            this.c[n3] = 24224;
            return;
        }
        if (null != this.b[n2]) {
            this.b[n2][n3] = 24224;
        }
    }

    private void c(int n2, boolean bl) {
        if (bl) {
            this.b.a = 0;
        }
        this.o = 0;
        this.q = 0;
        this.g = 0;
        this.c[n2] = 0;
    }

    private void c(int n2) {
        if ((n2 & 0x1000) != 0) {
            this.o = 0;
            this.q = 0;
        }
        if ((n2 & 0x100) != 0) {
            this.g = 0;
        }
        if ((n2 & 0x10) != 0) {
            this.p = 1;
        }
        if ((n2 & 1) != 0) {
            this.b.a = 0;
        }
    }

    /*
     * WARNING - void declaration
     */
    private void u() {
        boolean bl = false;
        Object object = w.b;
        int n2 = 0;
        while (this.d != null && n2 < this.d.length) {
            if (this.d[n2] != null && this.c[n2] < this.d[n2].length) {
                block60: do {
                    this.p = 0;
                    if (this.c[n2] >= this.d[n2].length) {
                        int n3 = (this.a << 1) + 1;
                        short[] sArray = this.b;
                        this.b[n3] = (short)(sArray[n3] | 1 << n2);
                        break;
                    }
                    switch (this.d[n2][this.c[n2]]) {
                        case 41: {
                            int n4 = this.d[n2][this.c[n2] + 2] - 1;
                            if (n4 == -1) {
                                this.b.b(this.d[n2][this.c[n2] + 3], this.d[n2][this.c[n2] + 4], 0, 0);
                                this.b.b = (byte)-1;
                                if (this.j == -1) {
                                    this.c = at.b(this.d[n2][this.c[n2] + 3], this.b, 12, 6, 240, 20);
                                    this.a = at.b(this.d[n2][this.c[n2] + 4], this.c, 16, 8, 320, 20);
                                }
                            } else {
                                this.o = this.b(n4);
                                this.q = this.c(n4);
                                this.b[this.o][this.q].b[0] = this.d[n2][this.c[n2] + 3];
                                this.b[this.o][this.q].b[1] = this.d[n2][this.c[n2] + 4];
                                this.b[this.o][this.q].b();
                            }
                            int object2 = n2;
                            short[] sArray = this.c;
                            this.c[object2] = (short)(sArray[object2] + 5);
                            this.c(4112);
                            break;
                        }
                        case 15: {
                            this.c(n2, this.d[n2][this.c[n2] + 2] == 0);
                            break;
                        }
                        case 4: {
                            boolean bl2 = ((as)this.b).k[103] >= this.d[n2][this.c[n2] + 2];
                            this.b(n2, 4, 16, (int)this.d[n2][this.c[n2] + 3], bl2);
                            break;
                        }
                        case 24: {
                            this.p(this.d[n2][this.c[n2] + 2]);
                            int n6 = n2;
                            short[] sArray = this.c;
                            this.c[n6] = (short)(sArray[n6] + 3);
                            this.c(16);
                            break;
                        }
                        case 25: {
                            this.b.n = (byte)(this.d[n2][this.c[n2] + 2] + 1);
                            int n7 = n2;
                            short[] sArray = this.c;
                            this.c[n7] = (short)(sArray[n7] + 3);
                            break;
                        }
                        case 50: {
                            if (this.b.a == 24 || this.b.a == 25) {
                                int n8 = n2;
                                short[] sArray = this.c;
                                this.c[n8] = (short)(sArray[n8] + 3);
                                this.c(0);
                                if (this.b.a == 24) {
                                    this.b.b("Ho\u00e0n th\u00e0nh ti\u1ebfn \u0111\u1ed9 l\u01b0u", 1);
                                    this.b.a();
                                }
                                this.b.a = 0;
                                break;
                            }
                            if (this.b.b != -1 || this.b.a == 23) continue block60;
                            this.b.a = (byte)23;
                            break;
                        }
                        case 29: {
                            int n9 = this.d[n2][this.c[n2] + 2] - 1;
                            c = n9 == -1 ? this.b : this.b[this.b(n9)][this.c(n9)];
                            c.b(false, (int)this.d[n2][this.c[n2] + 4]);
                            at.c.b[7] = this.d[n2][this.c[n2] + 3];
                            at.c.o = 0;
                            int n10 = n2;
                            short[] sArray = this.c;
                            this.c[n10] = (short)(sArray[n10] + 5);
                            this.c(4096);
                            break;
                        }
                        case 30: {
                            this.b.a = (byte)10;
                            int n11 = this.d[n2][this.c[n2] + 2] - 1;
                            c = n11 == -1 ? this.b : this.b[this.b(n11)][this.c(n11)];
                            c.c(this.d[n2][this.c[n2] + 3], this.d[n2][this.c[n2] + 4]);
                            at.c.g = this.d[n2][this.c[n2] + 5];
                            at.c.b = this.d[n2][this.c[n2] + 6] == 0;
                            c.b(false, 127);
                            int sArray = n2;
                            short[] sArray2 = this.c;
                            this.c[sArray] = (short)(sArray2[sArray] + 7);
                            this.c(16);
                            break;
                        }
                        case 42: {
                            this.o = this.d[n2][this.c[n2] + 2];
                            this.q = this.d[n2][this.c[n2] + 3];
                            v.b().b(this.b, this.o, -1, this.q);
                            int n13 = n2;
                            short[] sArray3 = this.c;
                            this.c[n13] = (short)(sArray3[n13] + 4);
                            this.c(4113);
                            break;
                        }
                        case 18: {
                            this.f(n2);
                            break;
                        }
                        case 49: {
                            if (this.b.m + 2 == 0) {
                                this.b.a = (byte)10;
                                this.b.m = this.d[n2][this.c[n2] + 2];
                                this.b.d = this.c + this.d[n2][this.c[n2] + 3] * 20 + 10;
                                this.b.h = this.a + this.d[n2][this.c[n2] + 4] * 20 + 20;
                                this.b.g(this.d[n2][this.c[n2] + 2] / 5);
                                break;
                            }
                            if (this.b.m != -1) break;
                            this.b.m = (byte)-2;
                            sArray = n2;
                            short[] n14 = this.c;
                            this.c[sArray] = (short)(n14[sArray] + 5);
                            this.c(16);
                            break;
                        }
                        case 26: {
                            this.a(n2);
                            break;
                        }
                        case 39: {
                            this.o = this.d[n2][this.c[n2] + 2];
                            this.q = this.d[n2][this.c[n2] + 3];
                            if ((((as)this.b).l[4 + (this.o << 1)] & 1 << this.q) == 0) break;
                            int n15 = n2;
                            short[] sArray4 = this.c;
                            this.c[n15] = (short)(sArray4[n15] + 4);
                            this.c(4113);
                            break;
                        }
                        case 27: {
                            if (this.g == 0) {
                                this.q = this.b.c((int)this.d[n2][this.c[n2] + 2], this.d[n2][this.c[n2] + 3]);
                                if (this.q != -1) {
                                    this.o = this.b.b((int)this.q);
                                    this.g = 1;
                                    break;
                                }
                                this.c(n2, false);
                                break;
                            }
                            if (this.b.k != 0) break;
                            if (this.o == -1) {
                                this.c(n2, false);
                                break;
                            }
                            int n16 = n2;
                            short[] sArray5 = this.c;
                            this.c[n16] = (short)(sArray5[n16] + (this.d[n2][this.c[n2] + 1] + 2));
                            this.c(4368);
                            break;
                        }
                        case 32: {
                            this.g(n2);
                            break;
                        }
                        case 46: {
                            ai.b().b(this.d[n2][this.c[n2] + 2]);
                            ai.b().b(false);
                            int n17 = n2;
                            short[] sArray6 = this.c;
                            this.c[n17] = (short)(sArray6[n17] + 3);
                            this.c(16);
                            break;
                        }
                        case 47: {
                            this.b.a = (byte)10;
                            this.n = (byte)(this.n + 1);
                            if (this.n != this.d[n2][this.c[n2] + 2]) break;
                            this.n = 0;
                            int n18 = n2;
                            short[] sArray7 = this.c;
                            this.c[n18] = (short)(sArray7[n18] + 3);
                            this.c(17);
                            break;
                        }
                        case 35: {
                            int exception = this.d[n2][this.c[n2] + 2] - 1;
                            if (exception == -1) {
                                this.b.b[4] = this.d[n2][this.c[n2] + 3];
                                switch (this.d[n2][this.c[n2] + 3]) {
                                    case 0: 
                                    case 2: {
                                        this.b.a = 0;
                                        break;
                                    }
                                    case 1: 
                                    case 3: {
                                        this.b.a = (byte)10;
                                    }
                                }
                            } else {
                                this.o = this.b(exception);
                                this.q = this.c(exception);
                                this.b[this.o][this.q].b[4] = this.d[n2][this.c[n2] + 3];
                            }
                            int n19 = n2;
                            short[] sArray8 = this.c;
                            this.c[n19] = (short)(sArray8[n19] + 4);
                            this.c(4112);
                            break;
                        }
                        case 52: {
                            this.b.a = (byte)10;
                            this.x = this.d[n2][this.c[n2] + 2];
                            int byArray = n2;
                            short[] n35 = this.c;
                            this.c[byArray] = (short)(n35[byArray] + 3);
                            this.c(16);
                            break;
                        }
                        case 16: {
                            this.h(n2);
                            break;
                        }
                        case 28: {
                            if (object != null) {
                                b = 4987;
                                af.b = 4987;
                                try {
                                    ((Runnable)object).run();
                                    b = 0;
                                    this.c = new short[b];
                                    return;
                                }
                                catch (Exception n20) {
                                    b = 0;
                                    if (!(n20 instanceof IOException)) {
                                        this.c = new short[b];
                                        return;
                                    }
                                    object = null;
                                }
                            }
                            this.i(n2);
                            break;
                        }
                        case 53: {
                            if (!this.b((int)this.d[n2][this.c[n2] + 2])) break;
                            int n21 = n2;
                            short[] n37 = this.c;
                            this.c[n21] = (short)(n37[n21] + 3);
                            this.c(16);
                            break;
                        }
                        case 19: {
                            ad.b();
                            ad.c = 0;
                            byte[] n22 = ad.b().b("data/battle/boss.d", -1);
                            Object n40 = ad.b().b(n22);
                            int n23 = this.d[n2][this.c[n2] + 1] >> 1;
                            this.b.b = new byte[n23][5];
                            this.q = 0;
                            while (this.q < n23) {
                                this.o = this.d[n2][this.c[n2] + 2 + (this.q << 1)];
                                this.b.b[this.q][0] = n40[this.o][0];
                                this.b.b[this.q][1] = this.d[n2][this.c[n2] + 3 + (this.q << 1)];
                                this.b.b[this.q][2] = n40[this.o][1];
                                this.b.b[this.q][3] = n40[this.o][2];
                                this.b.b[this.q][4] = n40[this.o][3];
                                this.q = (byte)(this.q + 1);
                            }
                            ai.b().b(6);
                            ai.b().b(false);
                            this.b.f(3);
                            this.b.l();
                            int n24 = n2;
                            n40 = this.c;
                            this.c[n24] = (short)(n40[n24] + (2 + this.d[n2][this.c[n2] + 1]));
                            break;
                        }
                        case 13: {
                            if (this.g == 0) {
                                this.g = 1;
                                if (this.d[n2][this.c[n2] + 3] == 0) {
                                    this.a[14] = this.d[n2][this.c[n2] + 2];
                                    if (this.a[14] == -1) break;
                                    this.b.b("#4 C\u1eadp nh\u1eadt nhi\u1ec7m v\u1ee5 ch\u00ednh #0 \u0111\u00e3 \u0111\u1ed5i m\u1edbi, Nh\u1ea5n #71 n\u00fat #0 \u0111\u1ec3 xem b\u1ea3ng nhi\u1ec7m v\u1ee5 th\u1ef1c thi.", -1);
                                    break;
                                }
                                this.a((int)this.d[n2][this.c[n2] + 2], this.d[n2][this.c[n2] + 3] == 2);
                                if (this.d[n2][this.c[n2] + 3] != 2) break;
                                this.b.b("#4 Nhi\u1ec7m v\u1ee5 ph\u1ee5 #0 \u0111\u00e3 \u0111\u1ed5i m\u1edbi, nh\u1ea5n #73 n\u00fat #0 \u0111\u1ec3 xem b\u1ea3ng nhi\u1ec7m v\u1ee5 th\u1ef1c thi.", -1);
                                break;
                            }
                            if (this.b.k != 0) break;
                            int n25 = n2;
                            short[] sArray9 = this.c;
                            this.c[n25] = (short)(sArray9[n25] + 4);
                            this.c(272);
                            break;
                        }
                        case 23: {
                            this.o = this.d[n2][this.c[n2] + 2];
                            this.q = this.d[n2][this.c[n2] + 3];
                            int n26 = n2;
                            short[] sArray = this.c;
                            this.c[n26] = (short)(sArray[n26] + 4);
                            this.a((int)this.o, (int)this.q);
                            this.c(4112);
                            break;
                        }
                        case 17: {
                            this.o = this.d[n2][this.c[n2] + 2];
                            this.q = this.d[n2][this.c[n2] + 3];
                            int n27 = n2;
                            short[] sArray = this.c;
                            this.c[n27] = (short)(sArray[n27] + 4);
                            this.e(this.o, (int)this.q);
                            this.c(4112);
                            break;
                        }
                        case 37: {
                            this.b.a = (byte)10;
                            int bl3 = this.d[n2][this.c[n2] + 2] - 1;
                            c = bl3 == -1 ? this.b : this.b[this.b(bl3)][this.c(bl3)];
                            c.b(true, (int)this.d[n2][this.c[n2] + 6]);
                            c.c(this.d[n2][this.c[n2] + 3], this.d[n2][this.c[n2] + 4]);
                            at.c.b[7] = this.d[n2][this.c[n2] + 5];
                            if (this.d[n2][this.c[n2] + 5] < 0) {
                                at.c.n = (byte)4;
                            }
                            at.c.g = this.d[n2][this.c[n2] + 7];
                            int by = n2;
                            short[] sArray = this.c;
                            this.c[by] = (short)(sArray[by] + 8);
                            this.c(16);
                            break;
                        }
                        case 22: {
                            this.b((int)this.d[n2][this.c[n2] + 2], (int)this.d[n2][this.c[n2] + 3], (int)this.d[n2][this.c[n2] + 4], (int)this.d[n2][this.c[n2] + 5]);
                            int bl4 = n2;
                            short[] sArray = this.c;
                            this.c[bl4] = (short)(sArray[bl4] + 6);
                            this.c(16);
                            break;
                        }
                        case 36: {
                            int bl5 = this.d[n2][this.c[n2] + 2] - 1;
                            this.o = this.b(bl5);
                            this.q = this.c(bl5);
                            this.b[this.o][this.q].b[5] = (byte)(this.d[n2][this.c[n2] + 3] + 1);
                            int bl6 = n2;
                            short[] sArray = this.c;
                            this.c[bl6] = (short)(sArray[bl6] + 4);
                            this.c(4112);
                            break;
                        }
                        case 2: {
                            this.o = this.d[n2][this.c[n2] + 2];
                            this.q = this.d[n2][this.c[n2] + 3];
                            this.b(n2, 5, 4112, (int)this.d[n2][this.c[n2] + 4], this.b((int)this.o, (int)this.q));
                            break;
                        }
                        case 45: {
                            this.d(n2);
                            break;
                        }
                        case 48: {
                            this.b.a = (byte)10;
                            this.L = (byte)(this.d[n2][this.c[n2] + 2] << 1);
                            int n28 = n2;
                            short[] sArray = this.c;
                            this.c[n28] = (short)(sArray[n28] + 3);
                            this.c(16);
                            break;
                        }
                        case 38: {
                            this.e(n2);
                            break;
                        }
                        case 6: {
                            ad.b();
                            boolean n29 = ad.b(this.b.b, this.b.c, 19, 19, this.d[n2][this.c[n2] + 2] * 20, this.d[n2][this.c[n2] + 3] * 20, (this.d[n2][this.c[n2] + 4] - this.d[n2][this.c[n2] + 2] + 1) * 20, (this.d[n2][this.c[n2] + 5] - this.d[n2][this.c[n2] + 3] + 1) * 20);
                            this.b(n2, 7, 16, (int)this.d[n2][this.c[n2] + 6], n29);
                            break;
                        }
                        case 5: {
                            void n33;
                            byte n30 = this.b.b(-2, (int)this.d[n2][this.c[n2] + 2], true);
                            if (this.d[n2][this.c[n2] + 3] == 0) {
                                boolean n31 = n30 == 0;
                            } else {
                                boolean n32 = n30 >= this.d[n2][this.c[n2] + 3];
                            }
                            this.b(n2, 5, 16, (int)this.d[n2][this.c[n2] + 4], (boolean)n33);
                            break;
                        }
                        case 1: {
                            int n34 = this.d[n2][this.c[n2] + 2] - 1;
                            if (n34 == -1) break;
                            this.o = this.b(n34);
                            this.q = this.c(n34);
                            boolean n39 = this.b.a == 2 && this.k == this.q;
                            this.b(n2, 4, 16, (int)this.d[n2][this.c[n2] + 3], n39);
                            break;
                        }
                        case 3: {
                            boolean n41 = this.b.b >= this.d[n2][this.c[n2] + 2] * 100;
                            this.b(n2, 4, 16, (int)this.d[n2][this.c[n2] + 3], n41);
                            break;
                        }
                        case 8: {
                            boolean bl2 = this.b.b((int)this.d[n2][this.c[n2] + 2], (int)this.d[n2][this.c[n2] + 3]) != -1;
                            this.b(n2, 5, 16, (int)this.d[n2][this.c[n2] + 4], bl2);
                            break;
                        }
                        case 12: {
                            this.j(n2);
                            break;
                        }
                        case 11: {
                            int n3 = this.d[n2][this.c[n2] + 2] - 1;
                            this.o = this.b(n3);
                            this.q = this.c(n3);
                            if (this.b[this.o][this.q].b[8] == this.d[n2][this.c[n2] + 3]) {
                                int n4 = n2;
                                short[] sArray = this.c;
                                this.c[n4] = (short)(sArray[n4] + 4);
                                this.c(16);
                                break;
                            }
                            this.c(n2, false);
                            break;
                        }
                        case 40: {
                            int n5 = this.d[n2][this.c[n2] + 2] - 1;
                            if (n5 == -1) {
                                ad.b();
                                this.b.b[7] = (byte)ad.a(this.d[n2][this.c[n2] + 3]);
                                if (this.d[n2][this.c[n2] + 3] < 0) {
                                    this.b.n = (byte)4;
                                }
                            } else {
                                c = this.b[this.b(n5)][this.c(n5)];
                                at.c.b[7] = this.d[n2][this.c[n2] + 3];
                                c.b(b[at.c.b[3] - 1][at.c.b[2]].b());
                            }
                            int n6 = n2;
                            short[] sArray = this.c;
                            this.c[n6] = (short)(sArray[n6] + 4);
                            this.c(16);
                            break;
                        }
                        case 43: {
                            int n7 = this.d[n2][this.c[n2] + 2] - 1;
                            this.o = this.b(n7);
                            this.q = this.c(n7);
                            this.b[this.o][this.q].b[8] = this.d[n2][this.c[n2] + 3];
                            int n8 = n2;
                            short[] sArray = this.c;
                            this.c[n8] = (short)(sArray[n8] + 4);
                            this.c(16);
                            break;
                        }
                        case 21: {
                            if (this.g == 0) {
                                this.g = 1;
                                int n9 = this.d[n2][this.c[n2] + 2] * 100;
                                if (n9 < 0) {
                                    ad.b();
                                    if (this.b.b < ad.a(n9)) {
                                        this.b.b("Kim ti\u1ec1n kh\u00f4ng \u0111\u1ee7!", 0);
                                        this.g = (byte)2;
                                    }
                                }
                                if (this.g != 1) break;
                                this.b.b += n9;
                                ad.b();
                                this.b.b(String.valueOf(n9 < 0 ? "M\u1ea5t \u0111i: " : "\u0110\u1ea1t \u0111\u01b0\u1ee3c: ") + ad.a(n9) + " Kim", 0);
                                break;
                            }
                            if (this.b.k != 0) break;
                            if (this.g == 2) {
                                this.c(n2, true);
                                break;
                            }
                            int n10 = n2;
                            short[] sArray = this.c;
                            this.c[n10] = (short)(sArray[n10] + 3);
                            this.c(272);
                            break;
                        }
                        case 33: {
                            this.c = (byte)(this.d[n2][this.c[n2] + 2] - 1);
                            this.g();
                            int n11 = n2;
                            short[] sArray = this.c;
                            this.c[n11] = (short)(sArray[n11] + 3);
                            this.c(16);
                            break;
                        }
                        case 51: {
                            short[] sArray;
                            int n12 = this.d[n2][this.c[n2] + 4] & 0xFF | (this.d[n2][this.c[n2] + 3] & 0xFF) << 8;
                            switch (this.d[n2][this.c[n2] + 2]) {
                                case 0: {
                                    if (this.g == 0) {
                                        ad.b();
                                        this.b.b(ad.b(this.d[n2], this.c[n2] + 5, n12), -1);
                                        this.g = 1;
                                        break;
                                    }
                                    if (this.b.k != 0) break;
                                    int n13 = n2;
                                    short[] sArray2 = sArray = this.c;
                                    int n14 = n13;
                                    sArray2[n14] = (short)(sArray2[n14] + ((n12 << 1) + 5));
                                    this.c(272);
                                    break;
                                }
                                case 1: 
                                case 2: {
                                    if (this.g == 0) {
                                        this.b.a = (byte)22;
                                        this.z = 0;
                                        this.y = 0;
                                        ad.b();
                                        this.b.b(ad.b(this.d[n2], this.c[n2] + 5, n12), 202, 3);
                                        this.g = this.d[n2][this.c[n2] + 2];
                                        break;
                                    }
                                    if (this.g != 3) break;
                                    int n15 = n2;
                                    short[] sArray3 = sArray = this.c;
                                    int n16 = n15;
                                    sArray3[n16] = (short)(sArray3[n16] + ((n12 << 1) + 5));
                                    this.c(272);
                                    ((as)this.b).d = null;
                                    this.y = (byte)-1;
                                }
                            }
                            continue block60;
                        }
                        case 31: {
                            int n17 = this.d[n2][this.c[n2] + 2] - 1;
                            if (n17 == -1) {
                                this.b.n = this.o = this.d[n2][this.c[n2] + 3];
                                this.b.b(false);
                            } else {
                                this.o = this.b(n17);
                                if (this.o == 0) {
                                    this.q = this.c(n17);
                                    this.b[this.o][this.q].n = this.d[n2][this.c[n2] + 3];
                                    this.b[this.o][this.q].b(false);
                                }
                            }
                            int n18 = n2;
                            short[] sArray = this.c;
                            this.c[n18] = (short)(sArray[n18] + 4);
                            this.c(4112);
                            break;
                        }
                        case 44: {
                            byte by = this.d[n2][this.c[n2] + 2];
                            if (by == 0) {
                                boolean bl3 = ((as)this.b).m[6] == 10;
                                this.b(n2, 3, 16, 2, bl3);
                                break;
                            }
                            if (by == 1) {
                                ar.b(this.b).b(2, true);
                                int n19 = n2;
                                short[] sArray = this.c;
                                this.c[n19] = (short)(sArray[n19] + 3);
                                this.c(0);
                                break;
                            }
                            if (by != 2) break;
                            this.b(n2, 3, 16, 2, ar.b((ak)this.b).c);
                        }
                    }
                } while (this.p == 1);
            }
            ++n2;
        }
    }

    private void a(int n2) {
        this.b = false;
        if (this.b.b((int)this.d[n2][this.c[n2] + 2], (int)this.d[n2][this.c[n2] + 3], (int)this.d[n2][this.c[n2] + 4], -1) == -1) {
            this.b.b("S\u1ee7ng V\u1eadt \u0111\u00e3 \u0111\u1ee7, kh\u00f4ng th\u1ec3 \u0111o\u1ea1t S\u1ee7ng V\u1eadt m\u1edbi, h\u00e3y l\u01b0u tr\u1eef \u0111\u1ec3 c\u00f3 ch\u1ed7 tr\u1ed1ng b\u1eaft S\u1ee7ng V\u1eadt m\u1edbi.", -1);
            this.b = true;
            this.b.f = (byte)6;
            this.b.c = 1;
            this.b.d();
            return;
        }
        int n3 = n2;
        this.c[n3] = (short)(this.c[n3] + (this.d[n2][this.c[n2] + 1] + 2));
        this.c(4368);
    }

    public static void e() {
        ak.a = -10;
    }

    private void e(int n2) {
        int n3 = this.d[n2][this.c[n2] + 2] - 1;
        c = n3 == -1 ? this.b : this.b[this.b(n3)][this.c(n3)];
        if (this.d[n2][this.c[n2] + 4] == 0) {
            at.c.j = this.d[n2][this.c[n2] + 3];
            at.c.f = 0;
            at.c.i = 0;
        } else if (this.d[n2][this.c[n2] + 4] == 1) {
            at.c.b[6] = this.d[n2][this.c[n2] + 3];
        } else if (this.d[n2][this.c[n2] + 4] == 2) {
            at.c.j = (byte)-1;
            at.c.b[6] = 0;
        }
        int n4 = n2;
        this.c[n4] = (short)(this.c[n4] + 5);
        this.c(4112);
    }

    private void d(int n2) {
        int n3;
        this.b.a = (byte)10;
        int n4 = this.d[n2][this.c[n2] + 2] - 1;
        if (n4 == -1) {
            n4 = this.b.b();
            n3 = this.b.c();
            this.j = (byte)-1;
        } else {
            this.o = this.b(n4);
            this.q = this.c(n4);
            this.j = this.o == 0 ? this.q : (byte)0;
            n4 = this.b[this.o][this.q].b[0];
            n3 = this.b[this.o][this.q].b[1];
        }
        n4 = at.b(n4, this.b, 12, 6, 240, 20) - this.c;
        n3 = at.b(n3, this.c, 16, 8, 320, 20) - this.a;
        ad.b();
        if (ad.a(n3) < 10) {
            ad.b();
            if (ad.a(n4) < 10) {
                int n5 = n2;
                this.c[n5] = (short)(this.c[n5] + 3);
                this.c(4112);
                return;
            }
        }
        ad.b();
        if (ad.a(n4) >= 10) {
            ad.b();
            this.c += n4 / ad.a(n4) * 10;
        }
        ad.b();
        if (ad.a(n3) >= 10) {
            ad.b();
            this.a += n3 / ad.a(n3) * 10;
        }
    }

    private void h(int n2) {
        byte by = this.d[n2][this.c[n2] + 3];
        if (by == 4) {
            if (this.s == 0 && this.b.a != 16) {
                this.b.a = (byte)16;
                this.s = 1;
                ((as)this.b).c = new String[]{"H\u1ed3i ph\u1ee5c", "Kh\u00f4ng h\u1ed3i ph\u1ee5c"};
                this.b.h = 0;
                this.b.e = 0;
                for (n2 = 0; n2 < this.b.y; n2 = (int)((byte)(n2 + 1))) {
                    this.b.e += 40 + 20 * this.b.b[n2].b[4];
                }
                return;
            }
            if (this.b.a == 0) {
                if (this.s == 1 && this.b.h == 0) {
                    this.s = (byte)2;
                    if (!this.b.b() && this.b.b(this.b.e, true)) {
                        this.b.c(true);
                        return;
                    }
                } else if (this.b.k == 0) {
                    this.s = 0;
                    int n3 = n2;
                    this.c[n3] = (short)(this.c[n3] + 4);
                    this.c(0);
                    return;
                }
            }
        } else {
            if (by < 3) {
                this.b.b((int)this.d[n2][this.c[n2] + 2], (int)by);
            } else if (by == 3) {
                this.b.c(0);
            } else if (by == 5) {
                this.b.a(0);
            } else if (by == 6) {
                this.b.c = (byte)4;
                this.b.h = (byte)-1;
            } else if (by == 7) {
                this.b.c = 1;
            }
            int n4 = n2;
            this.c[n4] = (short)(this.c[n4] + 4);
            this.c(16);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void g(int n2) {
        byte by = this.d[n2][this.c[n2] + 2];
        if (by <= 1) {
            if (this.g < 2) {
                if (by == 0) {
                    if (this.b.m == -2) {
                        if (this.b.l[3] == 5) {
                            this.b.m = (byte)-2;
                            this.g = (byte)2;
                            this.b.b("Hi\u1ec7n t\u1ea1i \u0111\u1eb3ng c\u1ea5p hu\u1ea5n luy\u1ec7n s\u1ef1 c\u1ee7a b\u1ea1n \u0111\u00e3 \u0111\u1ea1t t\u1edbi h\u1ea1n m\u1ee9c cao nh\u1ea5t!", 0);
                            return;
                        }
                        this.b.e = this.b.b(true);
                        if (this.b.e == -1) {
                            this.b.a = (byte)10;
                            this.b.m = (byte)28;
                            this.b.d = this.c + this.b.b + 10;
                            this.b.h = this.a + this.b.c + 19;
                            this.b.g(this.b.m / 5);
                            this.b.a(false);
                            return;
                        }
                        this.g = (byte)2;
                        return;
                    }
                    if (this.b.m != -1) return;
                    this.b.m = (byte)-2;
                    this.g = (byte)2;
                    if (this.b.l[3] > 3) {
                        this.b.b("Ch\u00fac m\u1eebng b\u1ea1n \u0111\u00e3 \u0111\u01b0\u1ee3c n\u00e2ng c\u1ea5p hu\u1ea5n luy\u1ec7n s\u01b0 b\u1eadc #7" + (int)this.b.l[3] + "#0, B\u1ea1n c\u00f3 th\u1ec3 l\u01b0u tr\u1eef S\u1ee7ng V\u1eadt t\u1ea1i c\u1eeda h\u00e0ng #7 b\u1ea1o t\u0103ng \u0111\u1ebfn" + this.b.x, -1);
                        return;
                    }
                    this.b.b("Ch\u00fac m\u1eebng b\u1ea1n \u0111\u00e3 \u0111\u01b0\u1ee3c n\u00e2ng c\u1ea5p hu\u1ea5n luy\u1ec7n s\u01b0 b\u1eadc #7" + (int)this.b.l[3] + "#0, B\u1ea1n c\u00f3 th\u1ec3 mang theo s\u1ed1 l\u01b0\u1ee3ng S\u1ee7ng V\u1eadt t\u00f9y \u00fd #7 b\u1ea1o t\u0103ng \u0111\u1ebfn" + (int)this.b.w + "#0, B\u1ea1n c\u00f3 th\u1ec3 l\u01b0u tr\u1eef S\u1ee7ng V\u1eadt t\u1ea1i c\u1eeda h\u00e0ng #7 b\u1ea1o t\u0103ng \u0111\u1ebfn" + this.b.x, -1);
                    return;
                }
                if (by != 1) return;
                if (this.g == 0 && this.b.k[104] == false) {
                    this.b.e = 0;
                    this.g = (byte)3;
                    this.b.b("B\u1ea1n kh\u00f4ng c\u1ea7n ph\u1ea3i b\u1eaft \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt m\u1edbi. B\u1eaft ch\u00fang kh\u00f4ng ph\u1ea3i l\u00e0 c\u00e1ch duy nh\u1ea5t. C\u00f3 nh\u1eefng S\u1ee7ng V\u1eadt c\u1ea7n th\u00f4ng qua ti\u1ebfn h\u00f3a m\u1edbi c\u00f3 th\u1ec3 c\u00f3 \u0111\u01b0\u1ee3c.", -1);
                    return;
                }
                if (this.g != 0) return;
                this.g = (byte)3;
                this.b.e = (int)this.b.k[104];
                this.b.k[104] = (byte[])false;
                this.b.b("B\u1eaft \u0111\u01b0\u1ee3c" + this.b.e + "S\u1ee7ng V\u1eadt m\u1edbi, l\u00e0 c\u00e1c hu\u1ea5n luy\u1ec7n s\u01b0 trong V\u01b0\u01a1ng Qu\u1ed1c th\u01b0\u1edfng cho b\u1ea1n" + this.b.e + "Huy ch\u01b0\u01a1ng, hy v\u1ecdng kh\u00f4ng ng\u1eebng c\u1ed1 g\u1eafng gia t\u0103ng s\u1ed1 huy ch\u01b0\u01a1ng.", -1);
                this.b.c += this.b.e;
                return;
            }
            if (this.b.k != 0) return;
            if (this.g == 2) {
                if (this.b.l[3] == 5) {
                    this.b.b("Hi\u1ec7n t\u1ea1i \u0111\u1eb3ng c\u1ea5p hu\u1ea5n luy\u1ec7n s\u1ef1 c\u1ee7a b\u1ea1n \u0111\u00e3 \u0111\u1ea1t t\u1edbi h\u1ea1n m\u1ee9c cao nh\u1ea5t!", 0);
                } else {
                    this.b.e = (byte)(this.b.b(false) - this.b.k[103]);
                    if (this.b.e <= 0) {
                        this.b.e = 0;
                    }
                    this.b.b("\u0110\u1eb3ng c\u1ea5p hi\u1ec7n t\u1ea1i c\u1ee7a hu\u1ea5n luy\u1ec7n s\u01b0 #7" + (int)this.b.l[3] + "#0 C\u1ea7n n\u1eafm b\u1eaft kho\u1ea3ng n\u00e2ng c\u1ea5p k\u1ebf ti\u1ebfp #7" + this.b.e + "#0 Kh\u00f4ng c\u00f3 S\u1ee7ng V\u1eadt, c\u1ed1 g\u1eafng l\u1ea5y \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt m\u1edbi.", -1);
                }
                this.g = (byte)4;
                return;
            }
            if (this.g == 3 && this.b.e > 0) {
                this.b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c: huy ch\u01b0\u01a1ng x" + this.b.e, 0);
                this.g = (byte)4;
                return;
            }
        }
        int n3 = n2;
        this.c[n3] = (short)(this.c[n3] + 3);
        this.c(4368);
    }

    private void f(int n2) {
        int n3 = 0;
        if (this.g == 0) {
            this.o = this.d[n2][this.c[n2] + 2];
            this.q = this.d[n2][this.c[n2] + 3];
            if (this.d[n2][this.c[n2] + 3] >= 0) {
                n3 = this.b.e(this.o, this.q);
            } else {
                byte by = this.b.b(-2, (int)this.o, true);
                ad.b();
                if (by >= ad.a(this.q)) {
                    ad.b();
                    this.b.c((int)this.o, ad.a(this.q));
                } else {
                    n3 = -1;
                    this.b.b("\u0110\u1ea1o c\u1ee5 kh\u00f4ng \u0111\u1ee7!", 0);
                }
            }
            if (n3 != -1) {
                StringBuffer stringBuffer = new StringBuffer().append(this.q >= 0 ? "\u0110\u1ea1t \u0111\u01b0\u1ee3c: " : "M\u1ea5t \u0111i: ").append(this.b.c(this.o)).append("x");
                ad.b();
                this.b.b(stringBuffer.append(ad.a(this.q)).toString(), 0);
            }
            this.g = 1;
            return;
        }
        if (this.b.k == 0) {
            int n4 = n2;
            this.c[n4] = (short)(this.c[n4] + 4);
            this.c(4368);
        }
    }

    private void i(int n2) {
        int n3 = this.d[n2][this.c[n2] + 5] & 0xFF | (this.d[n2][this.c[n2] + 4] & 0xFF) << 8;
        this.D = (byte)-1;
        if (this.g == 0) {
            int n4;
            this.g = 1;
            if (this.c == 1) {
                this.g();
            }
            if ((n4 = this.d[n2][this.c[n2] + 2] - 1) == -1) {
                this.b = "T\u1eafc K\u1ef3";
                this.q = 0;
            } else {
                this.o = this.b(n4);
                this.q = this.c(n4);
                this.b = this.c[this.q];
                if (this.b.equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng")) {
                    this.b = null;
                }
                this.q = this.b[this.o][this.q].b[2];
            }
            this.c(this.b);
            ad.b();
            ad.b();
            this.b = ad.b(ad.b(this.d[n2], this.c[n2] + 6, n3), 220);
            this.d = 0;
            this.b.a = 1;
            this.a = false;
            return;
        }
        if (this.g == 2) {
            short[] sArray;
            short[] sArray2 = sArray = this.c;
            int n5 = n2;
            sArray2[n5] = (short)(sArray2[n5] + ((n3 << 1) + 6));
            this.c(4369);
        }
    }

    private void j(int n2) {
        if (this.b.a != 12 && this.b.a != 13 && this.b.a != 14) {
            this.w = this.d[n2][this.c[n2] + 1];
            this.v = 0;
            this.b.c = (int)null;
            this.b.c = (int)new String[this.w];
            for (byte by = 0; by < this.w; by = (byte)(by + 1)) {
                int n3 = this.b.c;
                ad.b();
                n3[by] = ad.b(this.d[n2], this.c[n2] + 2 + this.v + 1, (int)this.d[n2][this.c[n2] + 2 + this.v]);
                this.v = (byte)(this.v + ((this.d[n2][this.c[n2] + 2 + this.v] << 1) + 1));
            }
            if (this.h != -1) {
                this.p = 1;
                this.b.s = (byte[])this.h;
                this.b.a = (byte)13;
                this.b.c = (int)null;
                this.h = (byte)-1;
                return;
            }
            this.b.s = (byte[])false;
            this.b.a = (byte)12;
            return;
        }
        if (this.b.a == 13) {
            this.v = (byte)(this.v + 2);
            short s2 = this.d[n2][this.c[n2] + this.v + (this.b.s << 1)];
            byte by = this.d[n2][this.c[n2] + this.v + (this.b.s << 1) + 1];
            s2 = (short)((s2 & 0xFF) << 8 | by & 0xFF);
            int n4 = n2;
            this.c[n4] = (short)(this.c[n4] + (this.v + (this.w << 1) + s2));
            this.c(17);
            return;
        }
        if (this.b.a == 14) {
            this.c(n2, true);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void d() {
        if (this.b.a != 9 && this.b.a != 6) {
            this.u();
        }
        if (this.b.a == 5 && this.b.b <= 0) {
            this.C();
            this.b.a = (byte)6;
        }
        if (this.b.a == 6) {
            this.b.a = 1;
            var1_1 = this;
            this.f = 0;
            var1_1.b.b(2);
            var3_3 = var1_1;
            var3_3.o();
            var3_3.b[var3_3.a] = 1;
            ad.b();
            ad.b(1, var3_3.b, 2);
            var2_5 = var1_1.m;
            if (var1_1.t != -2) {
                var1_1.l = var1_1.a;
                var1_1.a = var1_1.u;
                var1_1.u = 0;
                var1_1.m = var1_1.t;
            }
            var1_1.b.b(5);
            if (var1_1.t == -2) {
                var4_7 = var1_1.c;
                var3_3 = var1_1;
                if (var4_7[var3_3.k][3] == -1) {
                    var5_13 = var3_3.a;
                    var3_3.a = var3_3.l;
                    var3_3.l = var5_13;
                    var3_3.m = var3_3.k;
                    var5_13 = -1;
                } else {
                    var5_13 = var3_3.a;
                    var3_3.a = var4_7[var3_3.k][4];
                    var3_3.l = var5_13;
                    var3_3.m = var3_3.k;
                    var5_13 = var4_7[var3_3.k][3];
                }
                var1_1.t = (byte)var5_13;
            }
            var1_1.b.b(false);
            var1_1.b.b(8);
            var1_1.p();
            var1_1.b.b(10);
            if (var1_1.t == -1) {
                var1_1.t = var2_5;
            }
            if (!var1_1.c) {
                var5_14 = var1_1.c;
                var4_8 = var1_1.t;
                var3_3 = var1_1;
                var1_1.b.n = (byte)(((var5_14[var4_8][2] - 1) / 2 << 1) + 1 + var5_14[var4_8][2] % 2);
                var3_3.b.b(var5_14[var4_8][0], var5_14[var4_8][1], 0, 0);
            }
            var1_1.l();
            var1_1.b.b(15);
            var1_1.j();
            var1_1.s();
            var1_1.b.b(20);
            if (!(var1_1.c || var1_1.c[var1_1.t][5] != 1 && var1_1.c[var1_1.t][5] != 2)) {
                var1_1.b.b = (byte)(20 / var1_1.b.g);
                var1_1.b.e = (byte)(var1_1.h[var1_1.b.n][0] * var1_1.b.g);
                var1_1.b.d = (byte)(var1_1.h[var1_1.b.n][1] * var1_1.b.g);
                var1_1.b.b(true);
            } else {
                var1_1.b.b(false);
            }
            var1_1.b.g = 0;
            var4_9 = false;
            var3_3 = var1_1;
            ai.b().b(var3_3.b.e[var3_3.a]);
            ai.b().b(false);
            var1_1.t = (byte)-2;
            var1_1.b.c((int)var1_1.a, true);
            var1_1.b.l = (byte)25;
            var1_1.j = (byte)-1;
            ad.b();
            ad.b(1, null, 4);
            var1_1.V();
            var1_1.c = false;
            var1_1.b.a = (byte)9;
            if (var1_1.M == -1) {
                var1_1.b.a = 0;
                var1_1.b.c(-1, -1);
                var1_1.b.g = var1_1.b();
            }
            var1_1.D = (byte)-1;
            return;
        }
        if (this.b.a == 2 && this.g == 0) {
            if ((this.b[0][this.k].b[4] == 1 || this.b[0][this.k].b[4] == 3) && this.b[0][this.k].b[5] > 0) {
                this.b = this.c[this.k];
                if (this.b.equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng")) {
                    this.b = null;
                }
                this.c(this.b);
                ad.b();
                this.b = ad.b(this.b[this.b[0][this.k].b[5] - 1], 220);
                this.d = 0;
                this.b.a = 1;
            } else {
                this.b.a = 0;
            }
        } else if (this.b.a == 8 && this.b.b == -1) {
            if (this.b.b == 0) {
                v0 = this.b.b;
                ad.b();
                this.b.b(v0[ad.c(3)], 0);
                ak.b.repaint();
                this.b.f(4);
                this.b.k();
            } else {
                this.b.a = 0;
            }
        }
        var1_2 = this;
        if (var1_2.b.k != -1 || var1_2.b.l != -1) {
            var1_2.b(var1_2.b, false);
        } else {
            var4_10 = var1_2;
            if (var4_10.M != -1 && var4_10.b.k == -1 && var4_10.b.l == -1) {
                var4_10.b.a = (byte)9;
                v1 = (byte)(var4_10.b.s + 2);
                var4_10.b.s = (byte[])v1;
                if (v1 >= var4_10.b[var4_10.M].length) {
                    var4_10.M = (byte)-1;
                    var4_10.b.a = 0;
                    var4_10.c = (byte)-1;
                    var4_10.g();
                } else {
                    var4_10.C = at.b(var4_10.c, (int)var4_10.b.b, (int)var4_10.b.c);
                    if (var4_10.C != -1) {
                        var4_10.b.a = (byte)5;
                        var4_10.k = var4_10.C;
                    }
                    var4_10.b.c(var4_10.b[var4_10.M][var4_10.b.s], var4_10.b[var4_10.M][var4_10.b.s + true]);
                }
            }
        }
        var1_2.b(var1_2.b, -1);
        for (var3_4 = 0; var3_4 < 3; var3_4 = (int)((byte)(var3_4 + 2))) {
            for (var2_6 = 0; var2_6 < var1_2.b[var3_4].length; var2_6 = (int)((byte)(var2_6 + 1))) {
                block45: {
                    block43: {
                        block48: {
                            block46: {
                                block47: {
                                    block44: {
                                        if (var1_2.b[var3_4][var2_6].b[4] != 1 && var1_2.b[var3_4][var2_6].b[4] != 2) continue;
                                        if (var1_2.b[var3_4][var2_6].b[8] < 5) break block43;
                                        var6_16 = var2_6;
                                        var5_15 = var1_2.b[var3_4][var2_6];
                                        var4_11 = var1_2;
                                        if (var4_11.b.a != 1 || var4_11.k != var6_16) break block44;
                                        v2 = var5_15.b;
                                        ad.b();
                                        v2[7] = (byte)(ad.a(var5_15.b[7]) / 3 * 3 + (var4_11.b.n < 4 ? var4_11.b.n - 1 : var4_11.b.n - 2));
                                        if (var4_11.b.n == 3) {
                                            var5_15.b[7] = -var5_15.b[7];
                                        } else {
                                            var5_15.n = (byte)3;
                                        }
                                        break block45;
                                    }
                                    var7_18 = 10;
                                    var6_17 = var5_15;
                                    if (var6_17.m != 0) break block46;
                                    if (var6_17.b != -1) break block47;
                                    ad.b();
                                    var6_17.c = ad.c(100) < 50;
                                    ad.b();
                                    if (ad.c(100) >= 50) ** GOTO lbl-1000
                                    ad.b();
                                    var6_17.m = (byte)(-(ad.c(10) + 20));
                                    var6_17.b(false);
                                    v3 = false;
                                    break block48;
                                }
                                v3 = false;
                                break block48;
                            }
                            if (var6_17.m < 0) {
                                var6_17.m = (byte)(var6_17.m + 1);
                                v3 = false;
                            } else lbl-1000:
                            // 2 sources

                            {
                                v3 = true;
                            }
                        }
                        if (v3) {
                            if (var5_15.c) {
                                var4_12 = var4_11.b.b[var5_15.b[8] - 5 << 1];
                                var7_19 = var5_15;
                                var6_17 = var4_11;
                                if (var7_19.m == 0) {
                                    ad.b();
                                    var7_19.n = (byte)(ad.c(100) < 50 ? 3 : 4);
                                    var4_12 = var7_19.n == 3 ? (short)(var7_19.b - var7_19.b[0] * 20) : (short)((var4_12 + var7_19.b[0]) * 20 - var7_19.b);
                                    if (var4_12 <= 20) {
                                        var7_19.m = (byte)(var4_12 / var7_19.g);
                                    } else {
                                        ad.b();
                                        var7_19.m = (byte)(ad.c((var4_12 - 20) / var7_19.g + 1) + 20 / var7_19.g);
                                    }
                                } else if (var7_19.m > 0 && var7_19.b <= 0) {
                                    if (super.b(var7_19, (int)(var7_19.n == 3 ? -var7_19.g : var7_19.g), 0)) {
                                        var7_19.b(var7_19.n == 3 ? -var7_19.g : var7_19.g, 0);
                                        var7_19.m = (byte)(var7_19.m - 1);
                                        var7_19.b = 1;
                                        var7_19.b(true);
                                    } else {
                                        var7_19.m = (byte)-20;
                                        var7_19.b = (byte)-1;
                                        var7_19.b(false);
                                    }
                                }
                            } else {
                                var4_11.a(var5_15, (int)var4_11.b.b[(var5_15.b[8] - 5 << 1) + 1]);
                            }
                        }
                        break block45;
                    }
                    if (var1_2.b[var3_4][var2_6].k != -1 || var1_2.b[var3_4][var2_6].l != -1) {
                        var1_2.b(var1_2.b[var3_4][var2_6], true);
                    }
                }
                var1_2.b(var1_2.b[var3_4][var2_6], var2_6);
            }
        }
        var1_2.i();
    }

    public final void b(Graphics object) {
        b = object;
        if (this.b.a == 6) {
            this.b.b(false, (int)this.b.g, 30, 282, 180);
            return;
        }
        if (this.b.a == 17) {
            at at2 = this;
            ah.b();
            ah.c();
            ah.b();
            ah.b(1, 2, 238, 318);
            ah.b();
            ah.h(6, 28, 228, 233, 1);
            ah.b();
            ah.h(6, 266, 228, 48, 2);
            ah.b().b(false, true);
            ah.b();
            ah.b("\u0110\u1ecba \u0111\u1ed3 tr\u00f2 ch\u01a1i", 120, 4, 17, 1, 2);
            if (at2.G == -1) {
                ah.b();
                ah.b("Kh\u00f4ng c\u00f3 \u0111\u1ecba \u0111\u1ed3 khu v\u1ef1c!", 120, 268, 17, 3, 0);
                return;
            }
            ak.b("V\u1ecb tr\u00ed nh\u00e2n v\u1eadt hi\u1ec7n t\u1ea1i: " + at2.b.a(at2.H), 120, 268, 10, 3);
            b.setClip(6, 28, 228, 233);
            int n2 = 120 - at2.g[at2.I][0] * 13 - (at2.e ? at2.g[at2.I][6] * 13 / 2 : 25);
            ad.b();
            at2.k = ad.b(at2.k, n2, 10, false);
            n2 = at2.m / 2 - (at2.g[at2.I][1] << 3) - (at2.e ? (at2.g[at2.I][7] << 3) / 2 : 15);
            ad.b();
            at2.l = ad.b(at2.l, n2, 10, false);
            for (int n3 = 0; n3 < at2.f[at2.G].length; n3 = (int)((byte)(n3 + 1))) {
                byte by = at2.f[at2.G][n3];
                if (by < 0 || at2.g[by].length <= 0 || !at2.e && by == at2.H) continue;
                at2.b((byte)13, (byte)8, (int)by, false);
            }
            if (!at2.e) {
                at2.b((byte)13, (byte)8, (int)at2.H, false);
            }
            at2.b((byte)13, (byte)8, (int)at2.I, true);
            b.setClip(0, 0, 240, 320);
            return;
        }
        if (this.b.a == 18) {
            this.J();
            return;
        }
        ah.b();
        ah.b(this.d, 0, 0, 240, 320);
        at at3 = this;
        if (at3.a + at3.c * 20 < 320 && at3.c > 16) {
            at3.a = 320 - at3.c * 20;
        } else if (at3.a > 0 && at3.c > 16) {
            at3.a = 0;
        } else if (at3.c > 0 && at3.b > 12) {
            at3.c = 0;
        } else if (at3.c + at3.b * 20 < 240 && at3.b > 12) {
            at3.c = 240 - at3.b * 20;
        }
        if (this.x > 0) {
            this.x = (byte)(this.x - 1);
            object.translate(this.x % 2, this.x % 2);
        }
        byte by = ak.b;
        at3 = this;
        short s2 = at3.a;
        short s3 = at3.e;
        if (at3.c >= 0) {
            at3.a = 0;
            at3.h = at3.c;
        } else {
            at3.a = (short)(-at3.c / 20);
            at3.h = at3.c % 20;
        }
        if (at3.a >= 0) {
            at3.e = 0;
            at3.g = at3.a;
        } else {
            at3.e = (short)(-at3.a / 20);
            at3.g = at3.a % 20;
        }
        int n4 = at3.a * 20;
        int n5 = at3.e * 20;
        if (at3.f == 0) {
            at3.f = 1;
            at3.b(at3.a, at3.b, n4, n5, at3.c, (Graphics)by, 0, 0, 260, 340, true);
        } else if (at3.a != s2 || at3.e != s3) {
            by.setClip(0, 0, 260, 340);
            by.copyArea(0, 0, 260, 340, (s2 - at3.a) * 20, (s3 - at3.e) * 20, 20);
            if (at3.a < s2) {
                at3.b(at3.a, at3.b, n4, n5, at3.c, (Graphics)by, 0, 0, (s2 - at3.a) * 20, 340, true);
            } else if (at3.a > s2) {
                at3.b(at3.a, at3.b, n4, n5, at3.c, (Graphics)by, 260 + (s2 - at3.a) * 20, 0, 260, 340, true);
            }
            if (at3.e < s3) {
                at3.b(at3.a, at3.b, n4, n5, at3.c, (Graphics)by, 0, 0, 260, (s3 - at3.e) * 20, true);
            } else if (at3.e > s3) {
                at3.b(at3.a, at3.b, n4, n5, at3.c, (Graphics)by, 0, 340 + (s3 - at3.e) * 20, 260, 340, true);
            }
        }
        b.drawImage((Image)ak.b, at3.h, at3.g, 20);
        this.b(this.b[2]);
        this.c(this.b[0]);
        this.b(this.e, this.b, -this.c, -this.a, this.c, (Graphics)object, 0, 0, 240, 320, false);
        this.b(this.b[1]);
        this.a((Graphics)object);
        this.b((Graphics)object, 223, 0, 16);
        this.Q();
        this.m(4);
        this.W();
        if (this.b.m >= 0 && this.b.b(this.b.m / 5 > 5 ? 5 : this.b.m / 5, this.b.m / 5 > 5 ? 5 : this.b.m / 5, this.b.m / 5 >= 5 ? this.b.m - 25 : this.b.m % 5, this.b.d, this.b.h + 16, 0)) {
            if (this.b.a == 21) {
                this.b.m = (byte)-2;
                this.g();
            } else {
                this.b.m = (byte)-1;
            }
            this.b.a = 0;
        }
        object.translate(-object.getTranslateX(), -object.getTranslateY());
        this.b.i(this.b.a);
        if (this.b.a == 19) {
            at3 = this;
            ak cfr_ignored_0 = at3.b;
            ak.c("B\u1ea1n c\u00f3 mu\u1ed1n l\u01b0u c\u00e1c b\u00e0n kh\u00f4ng?", 260, 0);
            ah.b().b(true, true);
            return;
        }
        if (this.b.l[2] > 0) {
            ah.b();
            ah.b("9: T\u1ecda K\u1ef5", 120, 312, 33, 0, 2);
        }
        this.b.i();
        this.U();
        if (this.b.c == 4) {
            object = new byte[]{4, 25, 56};
            ah.b();
            ah.a(0, 260, 240, 60);
            ak.b(this.b.b((int)object[this.b.s]), 120, 272, 10, 3);
        } else if (this.b.a == 16) {
            ah.b();
            ah.a(0, 240, 240, 80);
            ak.b("B\u1ea1n c\u00f3 mu\u1ed1n h\u1ed3i ph\u1ee5c t\u1ea5t c\u1ea3 S\u1ee7ng V\u1eadt kh\u00f4ng?", 120, 244, 10, 3);
            ak.b((Object[])this.b.c, 82, 140, 76, -1, 0, this.b.h);
            ak.b("Kim ng\u1ea1ch c\u1ea7n thi\u1ebft: " + this.b.e, 120, 264, 10, 3);
            this.b.b(120, 300, 3, false);
        }
        if (this.b.a == 23) {
            ah.b();
            ah.a(0, 280, 240, 40);
            ah.b();
            ah.b("B\u1ea1n c\u00f3 mu\u1ed1n l\u01b0u tr\u1eef ti\u1ebfn \u0111\u1ed9 kh\u00f4ng?", 120, 284, 17, 3, 0);
            ah.b().b(true, true);
        } else if (this.b.a == 12) {
            ak.b((Object[])this.b.c, 63, 160 - 20 * (((int)this.b.c).length >> 1), 114, 0, 0, (int)this.b.s);
        }
        if (this.d >= 0) {
            this.b(this.b);
        }
        this.b.f();
        if (this.b.a == 20) {
            this.w();
        }
    }

    private void v() {
        if (this.a + this.c * 20 < 320 && this.c > 16) {
            this.a = 320 - this.c * 20;
            return;
        }
        if (this.a > 0 && this.c > 16) {
            this.a = 0;
            return;
        }
        if (this.c > 0 && this.b > 12) {
            this.c = 0;
            return;
        }
        if (this.c + this.b * 20 < 240 && this.b > 12) {
            this.c = 240 - this.b * 20;
        }
    }

    private void b(Graphics graphics, int n2, int n3, int n4) {
        if (this.r > 0) {
            graphics.setColor(0x3C3B3B);
            graphics.drawRect(224, 0, 14, 16);
            graphics.drawRect(223, 1, 16, 14);
            graphics.setColor(0xCCCCCC);
            graphics.drawRect(225, 1, 12, 14);
            graphics.drawRect(224, 2, 14, 12);
            ah.b();
            ah.b(0xFFFFFF, 225, 2, 13, 13);
            ah.b().a(67, 231, 8, 3, 0);
            if (this.r % 12 < 6) {
                ah.b();
                ah.c(0xEE0000, 238, 0, 223, 15);
                ah.b();
                ah.c(0, 239, 0, 223, 16);
                ah.b();
                ah.c(0xEE0000, 239, 1, 224, 16);
            }
            if ((this.r = (byte)(this.r - 1)) < 2) {
                this.r = (byte)100;
            }
        }
    }

    public final void b(Graphics graphics, int n2, boolean bl) {
        graphics.setColor(0xFFFFFF);
        byte by = 0;
        byte by2 = (byte)(this.y - 5 > 0 ? this.y - 5 : 0);
        while (bl ? by < ((byte)this.b.d).length : by <= this.y && by < ((byte)this.b.d).length) {
            if (!bl) {
                if (this.y == by) {
                    graphics.setClip(0, n2 + (by - by2) * 24, this.z << 1, 24);
                }
                ah.b();
                ah.b(this.b.d[by].toString(), 19, n2 + (by - by2) * 24, 0, 0);
                graphics.setClip(0, 0, 240, 320);
            } else {
                ad.b();
                short s2 = (short)(ad.b(this.b.d[by].toString()) - ak.b(this.b.d[by].toString()));
                ah.b();
                ah.b(this.b.d[by].toString(), 240 - s2 >> 1, n2 + by * 24, 0, 0);
            }
            by = (byte)(by + 1);
        }
        if (!bl) {
            graphics.setColor(0);
            graphics.fillRect(0, 0, 240, 40);
            graphics.fillRect(0, 280, 240, 40);
        }
        if (this.y == ((byte)this.b.d).length) {
            int n3 = 0;
            n3 = 33;
            n3 = 296;
            n3 = 120;
            ah.b();
            ah.b("Nh\u1ea5n n\u00fat 0 \u0111\u1ec3 ti\u1ebfp t\u1ee5c", 120, 296, 33, 0, 0);
            return;
        }
        if (!bl && (this.z = (byte)(this.z + 4)) >= 120) {
            this.z = 0;
            this.y = (byte)(this.y + 1);
            return;
        }
        if (bl) {
            this.y = (byte)((byte)this.b.d).length;
        }
    }

    public final void h() {
        block94: {
            block96: {
                block97: {
                    block92: {
                        block95: {
                            block93: {
                                block87: {
                                    block88: {
                                        at at2;
                                        block91: {
                                            block90: {
                                                block89: {
                                                    block82: {
                                                        block83: {
                                                            at at3;
                                                            block86: {
                                                                block85: {
                                                                    block84: {
                                                                        if (this.b.a != 17) break block82;
                                                                        at3 = this;
                                                                        ad.b();
                                                                        ad.c();
                                                                        ad.b();
                                                                        if (ad.g()) break block83;
                                                                        ad.b();
                                                                        if (ad.i()) break block84;
                                                                        ad.b();
                                                                        if (!ad.j()) break block85;
                                                                    }
                                                                    at3.b.a = 0;
                                                                    at3.f = null;
                                                                    at3.g = null;
                                                                    return;
                                                                }
                                                                ad.b();
                                                                if (ad.e()) break block86;
                                                                ad.b();
                                                                if (!ad.c()) break block83;
                                                            }
                                                            if (at3.g[at3.I].length >= 6) {
                                                                byte[] byArray = at3.g[at3.I];
                                                                ad.b();
                                                                ad.b();
                                                                if (byArray[ad.a(ad.e) + 1] != -1) {
                                                                    byte[] byArray2 = at3.g[at3.I];
                                                                    ad.b();
                                                                    ad.b();
                                                                    at3.I = byArray2[ad.a(ad.e) + 1];
                                                                }
                                                            }
                                                        }
                                                        return;
                                                    }
                                                    if (this.b.a != 18) break block87;
                                                    at2 = this;
                                                    ad.b();
                                                    if (ad.b()) break block88;
                                                    ad.b();
                                                    if (ad.e()) break block89;
                                                    ad.b();
                                                    if (ad.k() && at2.b.s == true) break block89;
                                                    ad.b();
                                                    if (!ad.l() || at2.b.s != false) break block90;
                                                }
                                                at2.b.s = (byte[])((byte)(at2.b.s ^ 1));
                                                at2.b((int)at2.b.s, at2.d);
                                                return;
                                            }
                                            ad.b();
                                            if (ad.c()) {
                                                byte by = at2.b.s == false ? (byte)(at2.a[14] + 1 > at2.b.length ? at2.b.length : at2.a[14] + 1) : (byte)at2.e.length;
                                                ad.b();
                                                ad.b((byte[])at2.b.h[0], 0, (int)by, at2.b.d);
                                                if (at2.b.s == false) {
                                                    at2.b.b(at2.b[at2.b.h[0][0]][1].toString(), 202, 0);
                                                    return;
                                                }
                                                if (at2.e.length > 0) {
                                                    at2.b.b(at2.b[at2.e[at2.b.h[0][0]]][1].toString(), 202, 0);
                                                    return;
                                                }
                                                at2.b.c = (int)null;
                                                return;
                                            }
                                            ad.b();
                                            if (ad.i()) break block91;
                                            ad.b();
                                            if (ad.k()) break block91;
                                            ad.b();
                                            if (!ad.l()) break block88;
                                        }
                                        at2.b.a = 0;
                                        if (at2.d) {
                                            at2.b.b(0);
                                            ak.a = 97;
                                        } else {
                                            ak.a = -10;
                                        }
                                        at2.e = null;
                                        at2.b = null;
                                        at2.b.c = (int)null;
                                        ad.b();
                                        ad.c();
                                    }
                                    return;
                                }
                                if (this.b.a == 12) {
                                    at at4 = this;
                                    ad.b();
                                    if (!ad.b()) {
                                        ad.b();
                                        if (ad.g()) {
                                            at4.b.a = (byte)13;
                                            return;
                                        }
                                        ad.b();
                                        if (ad.c()) {
                                            ak ak2 = at4.b;
                                            ad.b();
                                            ak2.s = (byte[])ad.b((int)at4.b.s, 0, ((int)at4.b.c).length - 1);
                                        }
                                    }
                                    return;
                                }
                                if (this.b.a == 19) {
                                    at at5 = this;
                                    ad.b();
                                    if (ad.f()) {
                                        at5.b.a = 0;
                                        at5.g = (byte)2;
                                        return;
                                    }
                                    ad.b();
                                    if (ad.i()) {
                                        at5.b.a = 0;
                                        at5.g = (byte)3;
                                    }
                                    return;
                                }
                                if (this.b.a == 22 && this.y >= 0 && this.y == ((byte)this.b.d).length) {
                                    ad.b();
                                    if (ad.j()) {
                                        this.g = (byte)3;
                                        this.y = (byte)-1;
                                        ad.b();
                                        ad.c();
                                        return;
                                    }
                                }
                                if (this.b.a != 16) break block92;
                                ad.b();
                                if (ad.b()) {
                                    return;
                                }
                                ad.b();
                                if (!ad.c()) break block93;
                                this.b.h = (byte)(this.b.h ^ 1);
                                break block94;
                            }
                            ad.b();
                            if (ad.g()) break block95;
                            ad.b();
                            if (!ad.i()) break block94;
                        }
                        ad.b();
                        if (ad.i()) {
                            this.b.h = 1;
                        }
                        this.b.a = 0;
                        return;
                    }
                    if (this.b.a == 10) {
                        ad.b();
                        ad.c();
                        return;
                    }
                    if (this.b.a == 23) {
                        ad.b();
                        if (ad.i()) {
                            this.b.a = (byte)25;
                        } else {
                            ad.b();
                            if (ad.g()) {
                                this.b.a = (byte)24;
                            }
                        }
                        ad.b();
                        ad.c();
                        return;
                    }
                    if (this.b.a == 11) {
                        ad.b();
                        if (ad.g()) {
                            this.b.k = 0;
                        }
                        if (this.b.k == 0) {
                            this.b.a = 0;
                        }
                        return;
                    }
                    if (this.b.a != 20) break block94;
                    at at6 = this;
                    ad.b();
                    if (ad.b()) break block96;
                    ad.b();
                    if (ad.e()) {
                        ad.b();
                        at6.B = ad.b((int)at6.B, 0, 4);
                        return;
                    }
                    ad.b();
                    if (ad.g()) {
                        if (!at6.c(at6.B)) {
                            at6.b.b("Kh\u00f4ng gi\u00e0nh \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt c\u01b0\u1ee1i", 0);
                        } else if (at6.B == 4) {
                            at6.b.b("Ch\u1ec9 s\u1eed d\u1ee5ng \u0111\u01b0\u1ee3c khi \u1edf trong n\u01b0\u1edbc", 0);
                        } else {
                            at6.c = at6.c == at6.B ? (byte)-1 : at6.B;
                            if (at6.c == 3 && at6.b.m[0] == false) {
                                ar.b(at6.b).b(1, true);
                                at6.c = (byte)-1;
                            } else {
                                if (at6.c == 3 && at6.b.m[0] < 0) {
                                    at6.b.m[0] = (byte[])((byte)(at6.b.m[0] + true));
                                    at6.b.b("D\u1ecb th\u00fa kh\u00f4ng ch\u1ec9 c\u00f3 kh\u1ea3 n\u0103ng ch\u1ea1y tr\u1ed1n nhanh m\u00e0 c\u00f2n c\u00f3 th\u1ec3 kh\u00f4ng g\u1eb7p \u0111\u1ecbch, b\u1ea1n c\u00f3 3 l\u1ea7n c\u01b0\u1ee1i th\u1eed tr\u01b0\u1edbc khi mua!", -1);
                                }
                                at6.b.m = (byte)13;
                                at6.b.d = at6.c + at6.b.b + 10;
                                at6.b.h = at6.a + at6.b.c + 19;
                                at6.b.g(at6.b.m / 5);
                                at6.b.a = (byte)21;
                            }
                        }
                        ad.b();
                        ad.c();
                        return;
                    }
                    ad.b();
                    if (ad.i()) break block97;
                    ad.b();
                    if (!ad.m()) break block96;
                }
                at6.b.a = 0;
                ad.b();
                ad.c();
            }
            return;
        }
        if (this.b.a == 1) {
            ad.b();
            if (ad.g()) {
                if (this.d + 2 >= this.b.length) {
                    this.d = (byte)-1;
                    this.b = null;
                    if (this.g == 0) {
                        this.b.a = 0;
                    } else {
                        this.g = (byte)2;
                    }
                    if (this.a) {
                        this.b[0][this.k].b[7] = this.A;
                        if (this.b[0][this.k].b[7] >= 0) {
                            this.b[0][this.k].n = (byte)3;
                        }
                        this.a = false;
                    }
                    return;
                }
                this.d = (byte)(this.d + 2);
                ad.b();
                ad.c();
            }
        }
        if (this.b.b > 0) {
            return;
        }
        if (this.b.a == 0 && ak.a != 98) {
            ad.b();
            if (ad.f()) {
                this.b.d(0);
            } else {
                ad.b();
                if (ad.i()) {
                    ar.b(this.b).b(0, true);
                }
            }
        }
        if (this.b.a != 0) {
            return;
        }
        ad.b();
        this.i = (byte)(-ad.e);
        at at7 = this;
        switch (at7.i) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                if (at7.b.n != at7.i) {
                    byte by = at7.i;
                    at at8 = at7;
                    at7.b.n = by;
                    at8.b.b(true);
                }
                at7.d(at7.h[at7.i][0] * at7.b.g, at7.h[at7.i][1] * at7.b.g);
                return;
            }
            case -53: 
            case 5: {
                at7.b(at7.b.b, (int)at7.b.c, at7.h[at7.b.n][0] * at7.b.g, at7.h[at7.b.n][1] * at7.b.g);
                return;
            }
            case -57: {
                boolean bl;
                ad.b();
                ad.c();
                if (at7.b.l[2] <= 0) break;
                at at9 = at7;
                if (at9.b((int)at9.b.b, (int)at9.b.c, (int)at9.c)) {
                    at9.b.b("Kh\u00f4ng th\u1ec3 thay T\u1ecda K\u1ef5", 0);
                    bl = false;
                } else {
                    at9.b.a = (byte)20;
                    at9.b.s = (byte[])false;
                    at9.b.r = (byte[])false;
                    at9.b.b("Ng\u1ed3i xu\u1ed1ng T\u1ecda K\u1ef5#nTh\u1ef1c V\u1eadt T\u1ecda K\u1ef5#nKim Lo\u1ea1i T\u1ecda K\u1ef5#nPhi H\u00e0nh T\u1ecda K\u1ef5#nD\u00e3 th\u00fa T\u1ecda K\u1ef5#nH\u1ea3i D\u01b0\u01a1ng T\u1ecda K\u1ef5#nKh\u00f4ng T\u1ecda K\u1ef5", 240, 0);
                    bl = true;
                }
                return;
            }
            case -55: {
                return;
            }
            case -51: {
                at7.b(1, false);
                return;
            }
            case -49: {
                at7.b(0, false);
                return;
            }
            case -48: {
                at7.G();
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void w() {
        ad.b();
        this.b.s = (byte[])((byte)ad.b((int)this.b.s, 52, 8, false));
        ah.b();
        ah.h(0, 320 - this.b.s, 76, 24, 2);
        ah.b();
        ah.b(0, 344 - this.b.s, 240, 28);
        for (var1_1 = 0; var1_1 < 5; var1_1 = (byte)(var1_1 + 1)) {
            block4: {
                if (this.c(var1_1)) break block4;
                var3_3 = 6;
                v0 = var1_1 + 70;
                ** GOTO lbl21
            }
            var3_3 = (byte)(var1_1 == this.B);
            if (var1_1 == this.c) {
                var2_2 = (byte)69;
            } else {
                v0 = var1_1 == this.B ? var1_1 + 5 : (int)var1_1;
lbl21:
                // 2 sources

                var2_2 = (byte)v0;
            }
            ah.b();
            ah.d(32 + var1_1 * 240 / 6, 348 - this.b.s, 20, 20, var3_3);
            ah.b().a(var2_2, 32 + var1_1 * 240 / 6 + 10, 348 - this.b.s + 18, 33, 0);
        }
        var2_2 = this.B == this.c ? 0 : (byte)(this.c(this.B) != false ? this.B + 1 : 6);
        ah.b();
        ah.b(this.b.c[var2_2].toString(), 38, 320 - this.b.s, 17, 1, 2);
        ah.b();
        ah.c(31 + this.B * 240 / 6 + this.b.r / 3, 347 - this.b.s + this.b.r / 3, 22 - (this.b.r / 3 << 1), 22 - (this.b.r / 3 << 1));
        v1 = this.b;
        v1.r = (byte[])((byte)(v1.r + true));
        if (v1.r > 4) {
            this.b.r = (byte[])false;
        }
        ah.b().b(true, true);
    }

    private void x() {
        block14: {
            block13: {
                ad.b();
                if (ad.b()) {
                    return;
                }
                ad.b();
                if (ad.e()) {
                    ad.b();
                    this.B = ad.b((int)this.B, 0, 4);
                    return;
                }
                ad.b();
                if (ad.g()) {
                    if (!this.c(this.B)) {
                        this.b.b("Kh\u00f4ng gi\u00e0nh \u0111\u01b0\u1ee3c S\u1ee7ng V\u1eadt c\u01b0\u1ee1i", 0);
                    } else if (this.B == 4) {
                        this.b.b("Ch\u1ec9 s\u1eed d\u1ee5ng \u0111\u01b0\u1ee3c khi \u1edf trong n\u01b0\u1edbc", 0);
                    } else {
                        this.c = this.c == this.B ? (byte)-1 : this.B;
                        if (this.c == 3 && this.b.m[0] == false) {
                            ar.b(this.b).b(1, true);
                            this.c = (byte)-1;
                        } else {
                            if (this.c == 3 && this.b.m[0] < 0) {
                                this.b.m[0] = (byte[])((byte)(this.b.m[0] + true));
                                this.b.b("D\u1ecb th\u00fa kh\u00f4ng ch\u1ec9 c\u00f3 kh\u1ea3 n\u0103ng ch\u1ea1y tr\u1ed1n nhanh m\u00e0 c\u00f2n c\u00f3 th\u1ec3 kh\u00f4ng g\u1eb7p \u0111\u1ecbch, b\u1ea1n c\u00f3 3 l\u1ea7n c\u01b0\u1ee1i th\u1eed tr\u01b0\u1edbc khi mua!", -1);
                            }
                            this.b.m = (byte)13;
                            this.b.d = this.c + this.b.b + 10;
                            this.b.h = this.a + this.b.c + 19;
                            this.b.g(this.b.m / 5);
                            this.b.a = (byte)21;
                        }
                    }
                    ad.b();
                    ad.c();
                    return;
                }
                ad.b();
                if (ad.i()) break block13;
                ad.b();
                if (!ad.m()) break block14;
            }
            this.b.a = 0;
            ad.b();
            ad.c();
        }
    }

    /*
     * Unable to fully structure code
     */
    private boolean b() {
        block11: {
            block12: {
                block8: {
                    block10: {
                        block9: {
                            block7: {
                                var4_1 = this.c;
                                var3_2 = this.b.c;
                                var2_3 = this.b.b;
                                var1_4 = this;
                                if (var4_1 != 0) break block7;
                                var4_1 = 3;
                                break block8;
                            }
                            if (var4_1 != 2) break block9;
                            var4_1 = 4;
                            break block8;
                        }
                        if (var4_1 == 4) break block10;
                        v0 = false;
                        break block11;
                    }
                    var4_1 = 2;
                }
                var5_5 = 0;
                if (var2_3 % 20 != 0) {
                    var5_5 = 1;
                }
                if (var3_2 % 20 != 0) {
                    var5_5 = (byte)(var5_5 + 1);
                }
                v1 = (byte)(1 << var5_5);
                var5_5 = v1;
                if (v1 != 4 || var1_4.a[(var2_3 + 19) / 20][var3_2 / 20] != var4_1) break block12;
                v0 = true;
                break block11;
            }
            if (var5_5 <= 1) ** GOTO lbl-1000
            if (var2_3 % 20 != 0 && var1_4.a[(var2_3 + 19) / 20][(var3_2 + 19) / 20] == var4_1) {
                v0 = true;
            } else if (var3_2 % 20 != 0 && var1_4.a[var2_3 / 20][var3_2 / 20] == var4_1) {
                v0 = true;
            } else lbl-1000:
            // 2 sources

            {
                v0 = var1_4.a[var2_3 / 20][var3_2 / 20] == var4_1;
            }
        }
        if (v0) {
            this.b.b("Kh\u00f4ng th\u1ec3 thay T\u1ecda K\u1ef5", 0);
            return false;
        }
        this.b.a = (byte)20;
        this.b.s = (byte[])false;
        this.b.r = (byte[])false;
        this.b.b("Ng\u1ed3i xu\u1ed1ng T\u1ecda K\u1ef5#nTh\u1ef1c V\u1eadt T\u1ecda K\u1ef5#nKim Lo\u1ea1i T\u1ecda K\u1ef5#nPhi H\u00e0nh T\u1ecda K\u1ef5#nD\u00e3 th\u00fa T\u1ecda K\u1ef5#nH\u1ea3i D\u01b0\u01a1ng T\u1ecda K\u1ef5#nKh\u00f4ng T\u1ecda K\u1ef5", 240, 0);
        return true;
    }

    private boolean c(int n2) {
        return (this.b.l[2] & 1 << n2) != 0;
    }

    public final void b(int n2) {
        if (n2 != 13 && n2 != 34 && n2 != 49 && n2 != 66 && n2 != 82) {
            return;
        }
        n2 = n2 == 13 ? 0 : (n2 == 34 ? 1 : (n2 == 49 ? 2 : (n2 == 66 ? 3 : 4)));
        this.b.l[2] = (byte[])((byte)(this.b.l[2] | 1 << n2));
    }

    public final void g() {
        this.b.b = (byte)(this.c == 3 ? 1 : 0);
        this.b.g = this.b();
        ad.b().b(b[1][0], "data/npc1/" + (this.c == -1 ? "0" : "r" + this.c), this.c == -1);
        this.b.b(false);
    }

    private byte b() {
        if (this.c == 0) {
            return 6;
        }
        if (this.c == 1) {
            return 6;
        }
        if (this.c == 2) {
            return 10;
        }
        if (this.c == 4) {
            return 5;
        }
        if (this.c == 3) {
            return 10;
        }
        return 5;
    }

    /*
     * Unable to fully structure code
     */
    private void y() {
        switch (this.i) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                if (this.b.n != this.i) {
                    var2_1 = this.i;
                    var1_3 = this;
                    this.b.n = (byte)var2_1;
                    var1_3.b.b(true);
                }
                var3_5 = this.h[this.i][1] * this.b.g;
                var2_1 = this.h[this.i][0] * this.b.g;
                var1_3 = this;
                this.b.e = (byte)var2_1;
                var1_3.b.d = (byte)var3_5;
                if (var1_3.b.b + var1_3.b.e < 0 || var1_3.b.b + var1_3.b.e + 19 >= var1_3.b * 20 || var1_3.b.c + var1_3.b.d < 0 || var1_3.b.c + var1_3.b.d + 19 >= var1_3.c * 20) ** GOTO lbl93
                var1_3.F = var1_3.c(var1_3.b.b, var1_3.b.c, var1_3.b.e, var1_3.b.d);
                if (var1_3.F == 0) {
                    var1_3.S();
                    return;
                }
                if (var1_3.a(var1_3.D)) {
                    var1_3.S();
                    return;
                }
                if (var1_3.D == -1) ** GOTO lbl40
                var4_7 = var1_3;
                if (var4_7.D < 0) ** GOTO lbl-1000
                if (var4_7.b.e == 0) ** GOTO lbl31
                ad.b();
                var5_9 = 20 - ad.a(var4_7.b.c - var4_7.b[0][var4_7.D].c);
                if (var5_9 <= 0 || var5_9 >= 11) ** GOTO lbl-1000
                v0 = true;
                ** GOTO lbl39
lbl31:
                // 1 sources

                if (var4_7.b.d == 0) ** GOTO lbl-1000
                ad.b();
                var5_9 = 20 - ad.a(var4_7.b.b - var4_7.b[0][var4_7.D].b);
                if (var5_9 > 0 && var5_9 < 11) {
                    v0 = true;
                } else lbl-1000:
                // 4 sources

                {
                    v0 = false;
                }
lbl39:
                // 3 sources

                if (!v0) ** GOTO lbl88
lbl40:
                // 2 sources

                var5_9 = var1_3.F;
                var4_7 = var1_3;
                var6_11 = 0;
                var2_1 = 0;
                var3_5 = (byte)(var4_7.b.b / 20);
                var7_13 = var4_7.b.c / 20;
                if (var4_7.b.e == 0) {
                    var6_11 = var4_7.c((var3_5 - (var4_7.b.b % 20 != 0 ? 0 : 1)) * 20, (var7_13 + (var4_7.b.d >= 0 ? 1 : -1)) * 20, 0, 0);
                    var2_1 = var4_7.c((var3_5 + 1) * 20, (var7_13 + (var4_7.b.d >= 0 ? 1 : -1)) * 20, 0, 0);
                } else if (var4_7.b.d == 0) {
                    var6_11 = var4_7.c((var3_5 + (var4_7.b.e >= 0 ? 1 : -1)) * 20, (var7_13 - (var4_7.b.c % 20 != 0 ? 0 : 1)) * 20, 0, 0);
                    var2_1 = var4_7.c((var3_5 + (var4_7.b.e >= 0 ? 1 : -1)) * 20, (var7_13 + 1) * 20, 0, 0);
                }
                if (var6_11 == 1 && var2_1 == 1) ** GOTO lbl-1000
                if (var6_11 == 0 && var4_7.c((var4_7.b.e == 0 ? var3_5 - (var4_7.b.b % 20 != 0 ? 0 : 1) : var3_5) * 20, (var4_7.b.d == 0 ? var7_13 - (var4_7.b.c % 20 != 0 ? 0 : 1) : var7_13) * 20, 0, 0) == 0) {
                    v1 = -1;
                } else if (var2_1 == 0 && var4_7.c((var4_7.b.e == 0 ? var3_5 + (var4_7.b.b % 20 != 0 ? 0 : 1) : var3_5) * 20, (var4_7.b.d == 0 ? var7_13 + (var4_7.b.c % 20 != 0 ? 0 : 1) : var7_13) * 20, 0, 0) == 0) {
                    v1 = -2;
                } else lbl-1000:
                // 2 sources

                {
                    v1 = var1_3.F = var5_9;
                }
                if (var1_3.F == -1) {
                    var1_3.b((byte)3, (byte)1, (int)(-var1_3.b.g));
                    return;
                }
                if (var1_3.F == -2) {
                    var1_3.b((byte)4, (byte)2, (int)var1_3.b.g);
                    return;
                }
                var4_7 = var1_3;
                var1_3.C = var4_7.b(var4_7.b.b, (int)var4_7.b.c, (int)var4_7.b.e, (int)var4_7.b.d, true);
                if (var4_7.C != 2) ** GOTO lbl72
                if (!var4_7.e(4)) ** GOTO lbl-1000
                ** GOTO lbl98
lbl72:
                // 1 sources

                if (var4_7.C != 3) ** GOTO lbl75
                if (!var4_7.e(0)) ** GOTO lbl-1000
                ** GOTO lbl98
lbl75:
                // 1 sources

                if (var4_7.C != 4) ** GOTO lbl78
                if (!var4_7.e(2)) ** GOTO lbl-1000
                ** GOTO lbl98
lbl78:
                // 1 sources

                if (var4_7.C == 0 && var4_7.c == 4) {
                    var4_7.c = var4_7.c != 3 && var4_7.c(3) != false ? (byte)3 : (byte)-1;
                    var4_7.g();
                    var4_7.S();
                } else lbl-1000:
                // 4 sources

                {
                    ad.b();
                    ad.c();
                    var4_7.C();
                    return;
lbl88:
                    // 1 sources

                    ad.b();
                    ad.c();
                    var1_3.C();
                    return;
lbl93:
                    // 1 sources

                    var1_3.C();
                    var1_3.C = at.b(var1_3.c, (int)var1_3.b.b, (int)var1_3.b.c);
                    if (var1_3.C != -1 && var1_3.c[var1_3.C][5] == 0 && var1_3.i == var1_3.c[var1_3.C][2]) {
                        var1_3.b.a = (byte)5;
                        var1_3.k = var1_3.C;
                    }
                }
lbl98:
                // 7 sources

                return;
            }
            case -53: 
            case 5: {
                var5_10 = this.h[this.b.n][1] * this.b.g;
                var4_8 = this.h[this.b.n][0] * this.b.g;
                var3_6 = this.b.c;
                var2_2 = this.b.b;
                var1_4 = this;
                if (var2_2 + var4_8 < 0 || var2_2 + var4_8 >= var1_4.b * 20 || var3_6 + var5_10 < 0 || var3_6 + var5_10 >= var1_4.c * 20) {
                    v2 = 0;
                } else {
                    var6_12 = at.b(var1_4.b[0], var2_2 + var4_8, var3_6 + var5_10);
                    if (var1_4.b.a == 0 && var6_12 != -1) {
                        if (var1_4.c == 1 && var1_4.b[0][var6_12].b[8] == 4) {
                            var1_4.b[0][var6_12].b[8] = -4;
                            var1_4.b[0][var6_12].b[7] = (byte)(var1_4.b[0][var6_12].b[7] + 1);
                            var1_4.b[0][var6_12].o = 0;
                            var1_4.b[0][var6_12].p = 0;
                        } else if (var1_4.b[0][var6_12].b[8] != -4) {
                            var1_4.b.a = (byte)2;
                            var1_4.k = var6_12;
                            if (var1_4.b[0][var6_12].b[8] != 2 && var1_4.b[0][var6_12].b[8] != 3 && !var1_4.c[var6_12].equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng")) {
                                var1_4.a = true;
                                var1_4.A = var1_4.b[0][var6_12].b[7];
                                v3 = var1_4.b[0][var6_12].b;
                                ad.b();
                                v3[7] = (byte)(ad.a(var1_4.A) / 3 * 3 + (var1_4.b.n < 4 ? var1_4.b.n - 1 : var1_4.b.n - 2));
                                if (var1_4.b.n == 3) {
                                    var1_4.b[0][var6_12].b[7] = -var1_4.b[0][var6_12].b[7];
                                } else {
                                    var1_4.b[0][var6_12].n = (byte)3;
                                }
                            } else {
                                var1_4.a = false;
                            }
                        }
                        v2 = 9;
                    } else {
                        var6_12 = at.b(var1_4.a, var2_2 + var4_8, var3_6 + var5_10);
                        if (var6_12 != -1 && var1_4.a[var6_12][2] != -1) {
                            ad.b();
                            ad.c();
                            var1_4.k = var6_12;
                            var1_4.z();
                            v2 = 0;
                        } else {
                            v2 = -1;
                        }
                    }
                }
                return;
            }
            case -57: {
                ad.b();
                ad.c();
                if (this.b.l[2] <= 0) break;
                this.b();
                return;
            }
            case -55: {
                return;
            }
            case -51: {
                this.b(1, false);
                return;
            }
            case -49: {
                this.b(0, false);
                return;
            }
            case -48: {
                this.G();
            }
        }
    }

    private void k(int n2) {
        this.b.n = (byte)n2;
        this.b.b(true);
    }

    private void c(int n2, int n3, int n4, int n5) {
        if (n4 > 0 && n2 >= this.d && n2 < this.h || n4 < 0 && n2 > this.d && n2 <= this.h) {
            this.c -= n4;
        }
        if (n5 > 0 && n3 >= this.g && n3 < this.f || n5 < 0 && n3 > this.g && n3 <= this.f) {
            this.a -= n5;
        }
    }

    private void b(aj aj2, int n2) {
        if (aj2.b > 0) {
            if (this.j == n2) {
                byte by = aj2.d;
                byte by2 = aj2.e;
                short s2 = aj2.c;
                short s3 = aj2.b;
                at at2 = this;
                if (by2 > 0 && s3 >= at2.d && s3 < at2.h || by2 < 0 && s3 > at2.d && s3 <= at2.h) {
                    at2.c -= by2;
                }
                if (by > 0 && s2 >= at2.g && s2 < at2.f || by < 0 && s2 > at2.g && s2 <= at2.f) {
                    at2.a -= by;
                }
            }
            aj2.b = (short)(aj2.b + aj2.e);
            aj2.c = (short)(aj2.c + aj2.d);
            aj2.b = (byte)(aj2.b - 1);
            return;
        }
        if (aj2.b != -1) {
            aj2.b = (byte)-1;
            aj2.b(false);
        }
    }

    private static byte b(aj[] ajArray, int n2, int n3) {
        for (byte by = (byte)(ajArray.length - 1); by >= 0; by = (byte)(by - 1)) {
            ad.b();
            if (!ad.b(n2, n3, 19, 19, ajArray[by].b, ajArray[by].c, 20, 20) || ajArray[by].b[4] != 1 && ajArray[by].b[4] != 3) continue;
            return by;
        }
        return -1;
    }

    private static byte b(byte[][] byArray, int n2, int n3) {
        for (byte by = (byte)(byArray.length - 1); by >= 0; by = (byte)(by - 1)) {
            ad.b();
            if (!ad.b(n2, n3, 19, 19, byArray[by][0] * 20, byArray[by][1] * 20, 20, 20)) continue;
            return by;
        }
        return -1;
    }

    private byte b(int n2, int n3, int n4, int n5) {
        if (n2 + n4 < 0 || n2 + n4 >= this.b * 20 || n3 + n5 < 0 || n3 + n5 >= this.c * 20) {
            return 0;
        }
        byte by = at.b(this.b[0], n2 + n4, n3 + n5);
        if (this.b.a == 0 && by != -1) {
            if (this.c == 1 && this.b[0][by].b[8] == 4) {
                this.b[0][by].b[8] = -4;
                this.b[0][by].b[7] = (byte)(this.b[0][by].b[7] + 1);
                this.b[0][by].o = 0;
                this.b[0][by].p = 0;
            } else if (this.b[0][by].b[8] != -4) {
                this.b.a = (byte)2;
                this.k = by;
                if (this.b[0][by].b[8] != 2 && this.b[0][by].b[8] != 3 && !this.c[by].equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng")) {
                    this.a = true;
                    this.A = this.b[0][by].b[7];
                    byte[] byArray = this.b[0][by].b;
                    ad.b();
                    byArray[7] = (byte)(ad.a(this.A) / 3 * 3 + (this.b.n < 4 ? this.b.n - 1 : this.b.n - 2));
                    if (this.b.n == 3) {
                        this.b[0][by].b[7] = -this.b[0][by].b[7];
                    } else {
                        this.b[0][by].n = (byte)3;
                    }
                } else {
                    this.a = false;
                }
            }
            return 9;
        }
        by = at.b(this.a, n2 + n4, n3 + n5);
        if (by != -1 && this.a[by][2] != -1) {
            ad.b();
            ad.c();
            this.k = by;
            at at2 = this;
            if (at2.a[at2.k][2] == 2) {
                at2.b.b("B\u1ea3o r\u01b0\u01a1ng n\u00e0y tr\u1ed1ng kh\u00f4ng.", 0);
            } else {
                byte by2 = (byte)(at2.a[at2.k][3] - 2);
                n3 = by2;
                if (by2 == -2) {
                    at2.b.b += at2.a[at2.k][4] * 100;
                    at2.b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c kim ti\u1ec1n: " + at2.a[at2.k][4] * 100 + "Kim", 0);
                } else if (n3 == -1) {
                    at2.b.c += at2.a[at2.k][4];
                    at2.b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c huy ch\u01b0\u01a1ng: " + at2.a[at2.k][4] + "Huy ch\u01b0\u01a1ng", 0);
                } else {
                    at2.b.a(n3, at2.a[at2.k][4]);
                }
                at2.a[at2.k][2] = 2;
            }
            return 0;
        }
        return -1;
    }

    private void z() {
        if (this.a[this.k][2] == 2) {
            this.b.b("B\u1ea3o r\u01b0\u01a1ng n\u00e0y tr\u1ed1ng kh\u00f4ng.", 0);
            return;
        }
        byte by = (byte)(this.a[this.k][3] - 2);
        if (by == -2) {
            this.b.b += this.a[this.k][4] * 100;
            this.b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c kim ti\u1ec1n: " + this.a[this.k][4] * 100 + "Kim", 0);
        } else if (by == -1) {
            this.b.c += this.a[this.k][4];
            this.b.b("\u0110\u1ea1t \u0111\u01b0\u1ee3c huy ch\u01b0\u01a1ng: " + this.a[this.k][4] + "Huy ch\u01b0\u01a1ng", 0);
        } else {
            this.b.a(by, this.a[this.k][4]);
        }
        this.a[this.k][2] = 2;
    }

    private byte c(int n2, int n3, int n4, int n5) {
        this.D = (byte)-1;
        this.C = at.b(this.a, n2 + n4, n3 + n5);
        if (this.C != -1) {
            this.D = (byte)-2;
            return 1;
        }
        if (n2 + n4 < 0 || n2 + n4 >= this.b * 20 || n3 + n5 < 0 || n3 + n5 >= this.c * 20) {
            return 1;
        }
        this.C = at.b(this.b[0], n2 + n4, n3 + n5);
        if (this.C != -1) {
            if (!this.c[this.C].equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng") || this.b[0][this.C].b[5] > 0) {
                this.D = this.C;
            }
            return 1;
        }
        this.C = at.b(this.c, n2 + n4, n3 + n5);
        if (this.C != -1 && (this.c[this.C][5] == 2 || this.i == this.c[this.C][2])) {
            this.b.a = (byte)5;
            this.k = this.C;
            return 0;
        }
        return this.b(n2, n3, n4, n5, false);
    }

    private byte b(int n2, int n3, int n4, int n5, boolean bl) {
        int n6 = 0;
        int n7 = 1;
        if (n4 == 0 && n2 % 20 != 0 || n5 == 0 && n3 % 20 != 0) {
            n7 = 2;
        }
        while (n6 < n7) {
            byte by;
            byte by2;
            if (n5 == 0) {
                by2 = (byte)((n3 + n6 * 20) / 20);
                by = (byte)(n4 >= 0 ? (n2 + n4 + 19) / 20 : (n2 + n4) / 20);
            } else {
                by = (byte)((n2 + n6 * 20) / 20);
                by2 = (byte)(n5 >= 0 ? (n3 + n5 + 19) / 20 : (n3 + n5) / 20);
            }
            if (bl) {
                if (this.a[by][by2] != 0) {
                    return (byte)this.a[by][by2];
                }
            } else {
                byte by3 = by2;
                by2 = by;
                at at2 = this;
                boolean bl2 = at2.a[by2][by3] == 1 ? true : (at2.c == 0 ? at2.a[by2][by3] == 2 || at2.a[by2][by3] == 4 : (at2.c == 2 ? at2.a[by2][by3] == 3 || at2.a[by2][by3] == 2 : (at2.c == 4 ? at2.a[by2][by3] != 2 : at2.a[by2][by3] == 2 || at2.a[by2][by3] == 3 || at2.a[by2][by3] == 4)));
                if (bl2) {
                    return 1;
                }
            }
            n6 = (byte)(n6 + 1);
        }
        return 0;
    }

    private boolean b(int n2, int n3, int n4) {
        if (n4 == 0) {
            n4 = 3;
        } else if (n4 == 2) {
            n4 = 4;
        } else if (n4 == 4) {
            n4 = 2;
        } else {
            return false;
        }
        int n5 = 0;
        if (n2 % 20 != 0) {
            n5 = 1;
        }
        if (n3 % 20 != 0) {
            n5 = (byte)(n5 + 1);
        }
        byte by = (byte)(1 << n5);
        n5 = by;
        if (by == 4 && this.a[(n2 + 19) / 20][n3 / 20] == n4) {
            return true;
        }
        if (n5 > 1) {
            if (n2 % 20 != 0 && this.a[(n2 + 19) / 20][(n3 + 19) / 20] == n4) {
                return true;
            }
            if (n3 % 20 != 0 && this.a[n2 / 20][n3 / 20] == n4) {
                return true;
            }
        }
        return this.a[n2 / 20][n3 / 20] == n4;
    }

    private boolean c(int n2, int n3) {
        if (this.a[n2][n3] == 1) {
            return true;
        }
        if (this.c == 0) {
            return this.a[n2][n3] == 2 || this.a[n2][n3] == 4;
        }
        if (this.c == 2) {
            return this.a[n2][n3] == 3 || this.a[n2][n3] == 2;
        }
        if (this.c == 4) {
            return this.a[n2][n3] != 2;
        }
        return this.a[n2][n3] == 2 || this.a[n2][n3] == 3 || this.a[n2][n3] == 4;
    }

    private void B() {
        if (this.i < this.j) {
            if (this.a[this.b.b()][this.b.c()] != 7) {
                this.i = (short)(this.i + 1);
                return;
            }
        } else {
            if (this.b.c.length > 1 && this.b.b == 0) {
                this.b.b = 0;
                this.b.a = (byte)8;
            }
            this.b(0, 0);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void d(int var1_1, int var2_4) {
        block24: {
            block28: {
                block25: {
                    block27: {
                        block26: {
                            this.b.e = (byte)var1_1;
                            this.b.d = (byte)var2_4;
                            if (this.b.b + this.b.e < 0 || this.b.b + this.b.e + 19 >= this.b * 20 || this.b.c + this.b.d < 0 || this.b.c + this.b.d + 19 >= this.c * 20) break block24;
                            this.F = this.c(this.b.b, this.b.c, this.b.e, this.b.d);
                            if (this.F == 0) {
                                this.S();
                                return;
                            }
                            if (this.a(this.D)) {
                                this.S();
                                return;
                            }
                            if (this.D == -1) break block25;
                            var1_2 = this;
                            if (var1_2.D < 0) ** GOTO lbl-1000
                            if (var1_2.b.e == 0) break block26;
                            ad.b();
                            v0 = (byte)(20 - ad.a(var1_2.b.c - var1_2.b[0][var1_2.D].c));
                            var2_4 = v0;
                            if (v0 <= 0 || var2_4 >= 11) ** GOTO lbl-1000
                            v1 = true;
                            break block27;
                        }
                        if (var1_2.b.d == 0) ** GOTO lbl-1000
                        ad.b();
                        v2 = (byte)(20 - ad.a(var1_2.b.b - var1_2.b[0][var1_2.D].b));
                        var2_4 = v2;
                        if (v2 > 0 && var2_4 < 11) {
                            v1 = true;
                        } else lbl-1000:
                        // 4 sources

                        {
                            v1 = false;
                        }
                    }
                    if (!v1) break block28;
                }
                var2_4 = this.F;
                var1_3 = this;
                var3_5 = 0;
                var4_6 = 0;
                var5_7 = var1_3.b.b / 20;
                var6_8 = var1_3.b.c / 20;
                if (var1_3.b.e == 0) {
                    var3_5 = var1_3.c((var5_7 - (var1_3.b.b % 20 != 0 ? 0 : 1)) * 20, (var6_8 + (var1_3.b.d >= 0 ? 1 : -1)) * 20, 0, 0);
                    var4_6 = var1_3.c((var5_7 + 1) * 20, (var6_8 + (var1_3.b.d >= 0 ? 1 : -1)) * 20, 0, 0);
                } else if (var1_3.b.d == 0) {
                    var3_5 = var1_3.c((var5_7 + (var1_3.b.e >= 0 ? 1 : -1)) * 20, (var6_8 - (var1_3.b.c % 20 != 0 ? 0 : 1)) * 20, 0, 0);
                    var4_6 = var1_3.c((var5_7 + (var1_3.b.e >= 0 ? 1 : -1)) * 20, (var6_8 + 1) * 20, 0, 0);
                }
                if (var3_5 == 1 && var4_6 == true) ** GOTO lbl-1000
                if (var3_5 == 0 && var1_3.c((var1_3.b.e == 0 ? var5_7 - (var1_3.b.b % 20 != 0 ? 0 : 1) : var5_7) * 20, (var1_3.b.d == 0 ? var6_8 - (var1_3.b.c % 20 != 0 ? 0 : 1) : var6_8) * 20, 0, 0) == 0) {
                    v3 = -1;
                } else if (var4_6 == 0 && var1_3.c((var1_3.b.e == 0 ? var5_7 + (var1_3.b.b % 20 != 0 ? 0 : 1) : var5_7) * 20, (var1_3.b.d == 0 ? var6_8 + (var1_3.b.c % 20 != 0 ? 0 : 1) : var6_8) * 20, 0, 0) == 0) {
                    v3 = -2;
                } else lbl-1000:
                // 2 sources

                {
                    v3 = var2_4;
                }
                this.F = (byte)v3;
                if (this.F == -1) {
                    this.b((byte)3, (byte)1, (int)(-this.b.g));
                    return;
                }
                if (this.F == -2) {
                    this.b((byte)4, (byte)2, (int)this.b.g);
                    return;
                }
                var1_3 = this;
                this.C = var1_3.b(var1_3.b.b, (int)var1_3.b.c, (int)var1_3.b.e, (int)var1_3.b.d, true);
                if (var1_3.C == 2) {
                    if (var1_3.e(4)) {
                        return;
                    }
                } else if (var1_3.C == 3) {
                    if (var1_3.e(0)) {
                        return;
                    }
                } else if (var1_3.C == 4) {
                    if (var1_3.e(2)) {
                        return;
                    }
                } else if (var1_3.C == 0 && var1_3.c == 4) {
                    var1_3.c = var1_3.c != 3 && var1_3.c(3) != false ? (byte)3 : (byte)-1;
                    var1_3.g();
                    var1_3.S();
                    return;
                }
                ad.b();
                ad.c();
                var1_3.C();
                return;
            }
            ad.b();
            ad.c();
            this.C();
            return;
        }
        this.C();
        this.C = at.b(this.c, (int)this.b.b, (int)this.b.c);
        if (this.C != -1 && this.c[this.C][5] == 0 && this.i == this.c[this.C][2]) {
            this.b.a = (byte)5;
            this.k = this.C;
        }
    }

    private boolean c() {
        if (this.D < 0) {
            return false;
        }
        if (this.b.e != 0) {
            ad.b();
            byte by = (byte)(20 - ad.a(this.b.c - this.b[0][this.D].c));
            if (by > 0 && by < 11) {
                return true;
            }
        } else if (this.b.d != 0) {
            ad.b();
            byte by = (byte)(20 - ad.a(this.b.b - this.b[0][this.D].b));
            if (by > 0 && by < 11) {
                return true;
            }
        }
        return false;
    }

    private void b(byte by, byte by2, int n2) {
        if (this.b.e == 0) {
            this.b.n = by;
        } else if (this.b.d == 0) {
            this.b.n = by2;
        }
        this.b.e = (byte)(this.b.e != 0 ? 0 : n2);
        this.b.d = (byte)(this.b.d != 0 ? 0 : n2);
        this.a(this.D);
        this.S();
    }

    private boolean a(int n2) {
        if (n2 >= 0) {
            byte by = (byte)(this.b[0][n2].b + 20 - this.b.b);
            byte by2 = (byte)(this.b[0][n2].b - this.b.b - 20);
            byte by3 = (byte)(this.b[0][n2].c + 20 - this.b.c);
            n2 = (byte)(this.b[0][n2].c - this.b.c - 20);
            if (this.b.e < 0 && by != 0) {
                this.b.e = by < this.b.e ? this.b.e : by;
                return true;
            }
            if (this.b.e > 0 && by2 != 0) {
                this.b.e = by2 < this.b.e ? by2 : this.b.e;
                return true;
            }
            if (this.b.d < 0 && by3 != 0) {
                this.b.d = by3 < this.b.d ? this.b.d : by3;
                return true;
            }
            if (this.b.d > 0 && n2 != 0) {
                this.b.d = (byte)(n2 < this.b.d ? n2 : (int)this.b.d);
                return true;
            }
        } else {
            byte by = this.b.a();
            byte by4 = (byte)(20 - this.b.a());
            byte by5 = this.b.e();
            n2 = (byte)(20 - this.b.e());
            if (this.b.e != 0 && by != 0) {
                byte by6;
                aj aj2;
                if (this.b.e < 0) {
                    aj2 = this.b;
                    by6 = -by < this.b.e ? this.b.e : -by;
                } else {
                    aj2 = this.b;
                    by6 = by4 < this.b.e ? by4 : this.b.e;
                }
                aj2.e = by6;
                return true;
            }
            if (this.b.d != 0 && by5 != 0) {
                byte by7;
                aj aj3;
                if (this.b.d < 0) {
                    aj3 = this.b;
                    by7 = -by5 < this.b.d ? this.b.d : -by5;
                } else {
                    aj3 = this.b;
                    by7 = (byte)(n2 < this.b.d ? n2 : (byte)this.b.d);
                }
                aj3.d = by7;
                return true;
            }
        }
        return false;
    }

    private void A() {
        this.C = this.b(this.b.b, (int)this.b.c, (int)this.b.e, (int)this.b.d, true);
        if (this.C == 2) {
            if (this.e(4)) {
                return;
            }
        } else if (this.C == 3) {
            if (this.e(0)) {
                return;
            }
        } else if (this.C == 4) {
            if (this.e(2)) {
                return;
            }
        } else if (this.C == 0 && this.c == 4) {
            this.c = this.c != 3 && this.c(3) ? (byte)3 : (byte)-1;
            this.g();
            this.S();
            return;
        }
        ad.b();
        ad.c();
        this.C();
    }

    private boolean e(int n2) {
        if (this.c != n2 && this.c(n2)) {
            this.c = (byte)n2;
            this.g();
            return true;
        }
        if (!this.c(n2)) {
            this.b.b("Kh\u00f4ng c\u00f3" + this.b.b[n2] + "T\u1ecda K\u1ef5, Kh\u00f4ng th\u1ec3 \u0111i qua", -1);
        }
        return false;
    }

    private void C() {
        this.b.e = 0;
        this.b.d = 0;
        this.b.b = (byte)-1;
        this.b.b(false);
    }

    private byte b(byte by) {
        byte by2 = 0;
        byte by3 = 0;
        int n2 = this.b.b / 20;
        int n3 = this.b.c / 20;
        if (this.b.e == 0) {
            by2 = this.c((n2 - (this.b.b % 20 != 0 ? (byte)0 : 1)) * 20, (n3 + (this.b.d >= 0 ? 1 : -1)) * 20, 0, 0);
            by3 = this.c((n2 + 1) * 20, (n3 + (this.b.d >= 0 ? 1 : -1)) * 20, 0, 0);
        } else if (this.b.d == 0) {
            by2 = this.c((n2 + (this.b.e >= 0 ? 1 : -1)) * 20, (n3 - (this.b.c % 20 != 0 ? (byte)0 : 1)) * 20, 0, 0);
            by3 = this.c((n2 + (this.b.e >= 0 ? 1 : -1)) * 20, (n3 + 1) * 20, 0, 0);
        }
        if (by2 == 1 && by3 == 1) {
            return by;
        }
        if (by2 == 0 && this.c((this.b.e == 0 ? n2 - (this.b.b % 20 != 0 ? (byte)0 : 1) : n2) * 20, (this.b.d == 0 ? n3 - (this.b.c % 20 != 0 ? (byte)0 : 1) : n3) * 20, 0, 0) == 0) {
            return -1;
        }
        if (by3 == 0 && this.c((this.b.e == 0 ? n2 + (this.b.b % 20 != 0 ? 0 : 1) : n2) * 20, (this.b.d == 0 ? n3 + (this.b.c % 20 != 0 ? 0 : 1) : n3) * 20, 0, 0) == 0) {
            return -2;
        }
        return by;
    }

    private void b(String string) {
        int n2 = 0;
        ah.b();
        ah.a(4, 265, 236, 55);
        if (string != null) {
            int n3 = 33;
            n3 = 265;
            int n4 = this.h ? 190 : 50;
            at at2 = this;
            if (at2.b != null) {
                ah.b();
                ah.b(at2.b, n4 + at2.n, 265, 33);
            }
            ad.b();
            at2.n = ad.b(at2.n, 0, 20, false);
            ah.b();
            ad.b();
            ah.a(0, 241, ad.b(string) + 16, 28);
            ah.b();
            ah.b(string, 8, 243, 0, 9, 1);
        }
        while (n2 < 2 && this.d + n2 < this.b.length) {
            ah.b();
            ah.b(this.b[this.d + n2].toString(), 10, 270 + n2 * 20, -1, 1);
            n2 = (byte)(n2 + 1);
        }
    }

    public final void f() {
        this.b[0] = null;
        this.a = null;
        this.c = null;
        this.d = null;
        this.b = null;
        this.c = null;
    }

    private byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        at.b(byteArrayOutputStream, this.b[0]);
        at.b(byteArrayOutputStream, this.b[1]);
        at.b(byteArrayOutputStream, this.b[2]);
        at.b(byteArrayOutputStream, this.a);
        at.b(byteArrayOutputStream, this.c);
        return byteArrayOutputStream.toByteArray();
    }

    private static void b(ByteArrayOutputStream byteArrayOutputStream, aj[] ajArray) {
        try {
            for (int i2 = 0; i2 < ajArray.length; ++i2) {
                if (ajArray[i2].b[9] != 1) continue;
                byteArrayOutputStream.write(ajArray[i2].b);
            }
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    private static void b(ByteArrayOutputStream byteArrayOutputStream, byte[][] byArray) {
        try {
            byteArrayOutputStream.write(byArray.length);
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                byteArrayOutputStream.write(byArray[i2].length);
                byteArrayOutputStream.write(byArray[i2]);
            }
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    private void D() {
        ah.b();
        ah.c();
        ah.b();
        ah.b(1, 2, 238, 318);
        ah.b();
        ah.h(6, 28, 228, 233, 1);
        ah.b();
        ah.h(6, 266, 228, 48, 2);
        ah.b().b(false, true);
        ah.b();
        ah.b("\u0110\u1ecba \u0111\u1ed3 tr\u00f2 ch\u01a1i", 120, 4, 17, 1, 2);
        if (this.G == -1) {
            ah.b();
            ah.b("Kh\u00f4ng c\u00f3 \u0111\u1ecba \u0111\u1ed3 khu v\u1ef1c!", 120, 268, 17, 3, 0);
            return;
        }
        ak.b("V\u1ecb tr\u00ed nh\u00e2n v\u1eadt hi\u1ec7n t\u1ea1i: " + this.b.a(this.H), 120, 268, 10, 3);
        b.setClip(6, 28, 228, 233);
        int n2 = 120 - this.g[this.I][0] * 13 - (this.e ? this.g[this.I][6] * 13 / 2 : 25);
        ad.b();
        this.k = ad.b(this.k, n2, 10, false);
        n2 = this.m / 2 - (this.g[this.I][1] << 3) - (this.e ? (this.g[this.I][7] << 3) / 2 : 15);
        ad.b();
        this.l = ad.b(this.l, n2, 10, false);
        for (int n3 = 0; n3 < this.f[this.G].length; n3 = (int)((byte)(n3 + 1))) {
            n2 = this.f[this.G][n3];
            if (n2 < 0 || this.g[n2].length <= 0 || !this.e && n2 == this.H) continue;
            this.b((byte)13, (byte)8, n2, false);
        }
        if (!this.e) {
            this.b((byte)13, (byte)8, (int)this.H, false);
        }
        this.b((byte)13, (byte)8, (int)this.I, true);
        b.setClip(0, 0, 240, 320);
    }

    private void b(byte by, byte by2, int n2, boolean bl) {
        by = (byte)78;
        by2 = (byte)48;
        if (this.e) {
            by = (byte)(this.g[n2][6] * 13);
            by2 = (byte)(this.g[n2][7] << 3);
        }
        if (bl) {
            ah.b().c(12352252, this.g[n2][0] * 13 + this.k, (this.g[n2][1] << 3) + this.l, by, by2, 5);
            return;
        }
        if (n2 == this.H) {
            ah.b();
            ah.h(this.g[n2][0] * 13 + this.k, (this.g[n2][1] << 3) + this.l, by, by2, 4);
        } else {
            ah.b();
            ah.d(this.g[n2][0] * 13 + this.k, (this.g[n2][1] << 3) + this.l, by, by2, 2);
        }
        if (this.e) {
            ak.b(this.b.a(n2), this.g[n2][0] * 13 + this.k + (by >> 1) + 19, (this.g[n2][1] << 3) + this.l + (by2 >> 1) - 20, 4, n2 == this.H ? 0 : 3);
        } else {
            ak.b(this.b.a(n2), this.g[n2][0] * 13 + this.k + (by >> 1), (this.g[n2][1] << 3) + this.l + (by2 >> 1) - 20, 4, n2 == this.H ? 0 : 3);
        }
        if (n2 == this.H) {
            ah.b().a(67, this.g[n2][0] * 13 + this.k + (by >> 1), (this.g[n2][1] << 3) + this.l + (by2 >> 1), 3, 0);
        }
    }

    private void F() {
        block12: {
            block11: {
                block10: {
                    block9: {
                        ad.b();
                        ad.c();
                        ad.b();
                        if (ad.g()) {
                            return;
                        }
                        ad.b();
                        if (ad.i()) break block9;
                        ad.b();
                        if (!ad.j()) break block10;
                    }
                    this.b.a = 0;
                    this.f = null;
                    this.g = null;
                    return;
                }
                ad.b();
                if (ad.e()) break block11;
                ad.b();
                if (!ad.c()) break block12;
            }
            if (this.g[this.I].length >= 6) {
                byte[] byArray = this.g[this.I];
                ad.b();
                ad.b();
                if (byArray[ad.a(ad.e) + 1] != -1) {
                    byte[] byArray2 = this.g[this.I];
                    ad.b();
                    ad.b();
                    this.I = byArray2[ad.a(ad.e) + 1];
                }
            }
        }
    }

    private void G() {
        ad.b();
        ad.c();
        byte[] byArray = ad.b().b("data/map.d", -1);
        ad.b();
        ad.c = 0;
        this.f = ad.b().b(byArray);
        this.g = ad.b().b(byArray);
        this.b.a = (byte)17;
        this.G = (byte)-1;
        this.H = (byte)-1;
        this.I = 0;
        for (int n2 = 0; n2 < this.f.length; n2 = (int)((byte)(n2 + 1))) {
            for (int n3 = 0; n3 < this.f[n2].length; n3 = (int)((byte)(n3 + 1))) {
                if (this.a != this.f[n2][n3]) continue;
                this.I = this.a;
                if (this.g[this.I].length <= 0) continue;
                this.H = this.I;
                this.G = (byte)n2;
                this.e = this.f[this.G][0] >= 0;
                return;
            }
        }
    }

    private void H() {
        ak.c("B\u1ea1n c\u00f3 mu\u1ed1n l\u01b0u c\u00e1c b\u00e0n kh\u00f4ng?", 260, 0);
        ah.b().b(true, true);
    }

    private void I() {
        ad.b();
        if (ad.f()) {
            this.b.a = 0;
            this.g = (byte)2;
            return;
        }
        ad.b();
        if (ad.i()) {
            this.b.a = 0;
            this.g = (byte)3;
        }
    }

    private void E() {
        ad.b();
        byte[] byArray = ad.b(7, null, 1);
        this.a = (byte[])(byArray[0] == -1 ? null : byArray);
        if (this.a == null) {
            this.a = new byte[20];
        }
    }

    public final void b(int n2, boolean bl) {
        if (this.b.a != 18 && this.b.a != 0) {
            return;
        }
        ad.b();
        ad.c();
        this.d = bl;
        ak.a = -10;
        this.b.a = (byte)18;
        this.b.s = (byte[])((byte)n2);
        this.b.h[0][1] = false;
        this.b.h[0][0] = false;
        ad.b();
        ad.c = 0;
        byte[] byArray = ad.b().b("data/mission" + n2 + ".t", -1);
        this.b = ad.b().b(byArray);
        this.b.d = (byte)6;
        this.b.c = (int)null;
        if (n2 == 1) {
            int n3 = 0;
            byte[] byArray2 = new byte[50];
            for (n2 = 0; n2 < this.b.length; n2 = (int)((byte)(n2 + 1))) {
                int n4 = n2;
                at at2 = this;
                byte by = (byte)(n4 / 8);
                if (!((at2.a[by] & 1 << (n4 = (int)((byte)(n4 % 8)))) != 0)) continue;
                int n5 = n3;
                n3 = (byte)(n3 + 1);
                byArray2[n5] = n2;
            }
            this.e = null;
            this.e = new byte[n3];
            System.arraycopy(byArray2, 0, this.e, 0, this.e.length);
            if (this.e.length > 0) {
                this.b.b(this.b[this.e[this.b.h[0][0]]][1].toString(), 202, 0);
            }
            return;
        }
        this.b.h[0][0] = this.a[14];
        this.b.h[0][1] = this.a[14] >= this.b.d ? (byte)(this.b.h[0][0] - this.b.d + true) : (byte)0;
        this.b.b(this.b[this.b.h[0][0]][1].toString(), 202, 0);
    }

    private void a(int n2, boolean bl) {
        byte by = (byte)(n2 / 8);
        n2 = (byte)(n2 % 8);
        if (bl) {
            byte by2 = by;
            this.a[by2] = (byte)(this.a[by2] | 1 << n2);
            return;
        }
        if ((this.a[by] & 1 << n2) != 0) {
            byte by3 = by;
            this.a[by3] = (byte)(this.a[by3] ^ 1 << n2);
            this.a[15] = (byte)(this.a[15] + 1);
        }
    }

    private boolean d(int n2) {
        byte by = (byte)(n2 / 8);
        return (this.a[by] & 1 << (n2 = (int)((byte)(n2 % 8)))) != 0;
    }

    private void J() {
        ah.b();
        ah.c();
        ah.b();
        ah.b(1, 6, 238, 314);
        ah.b();
        ah.h(8, 35, 214, this.b.d * 24 + 10, 1);
        ah.b();
        ah.h(8, 53 + this.b.d * 24, 224, 100, 2);
        int n2 = this.b.s == false ? this.a[14] + 1 : this.e.length;
        void var3_2 = this.b.h[0];
        byte by = this.b.d;
        int n3 = 24;
        n3 = 214;
        n3 = 41;
        n3 = 8;
        at at2 = this;
        ah.b().b(by, 8, 41, 214, 6, 24, -1, (int)(var3_2[0] - var3_2[1]), 4, 2);
        for (byte by2 = var3_2[1]; by2 < var3_2[1] + by; by2 = (byte)(by2 + true)) {
            if (by2 >= n2) continue;
            String string = at2.b.s == false ? by2 + 1 + ", " + at2.b[by2][0].toString() : by2 + 1 + ", " + at2.b[at2.e[by2]][0].toString();
            ah.b();
            ah.b(string, 16, 41 + (by2 - var3_2[1]) * 23, 0, by2 < at2.a[14] ? -1 : (var3_2[0] == by2 ? 0 : 3), 0);
            if (at2.b.s != false || by2 == n2 - 1) continue;
            ah.b();
            ah.b("Ho\u00e0n th\u00e0nh", 214, 41 + (by2 - var3_2[1]) * 23, 24, by2 < at2.a[14] ? -1 : (var3_2[0] == by2 ? 0 : 3), 0);
        }
        ah.b().b(226, 41, by * 24, (int)var3_2[0], n2, true);
        for (int n4 = 0; null != this.b.c && n4 < ((int)this.b.c).length; n4 = (int)((byte)(n4 + 1))) {
            ah.b();
            ah.b(this.b.c[n4].toString(), 19, 55 + this.b.d * 24 + n4 * 20, 3, 0);
        }
        ah.b();
        ah.h(this.b.s == false ? 25 : 140, 9, 76, 24, 4);
        ah.b();
        ah.b("C\u1eadp nh\u1eadt nhi\u1ec7m v\u1ee5 ch\u00ednh", 63, 9, 17, this.b.s == false ? 0 : 1, 0);
        ah.b();
        ah.b("Nhi\u1ec7m v\u1ee5 ph\u1ee5", 177, 9, 17, this.b.s == true ? 0 : 1, 0);
        ah.b().b(120, 18, 114, true, true);
        ah.b();
        StringBuffer stringBuffer = new StringBuffer().append(this.b.s == false ? "M\u1ee9c \u0111\u1ed9 ho\u00e0n th\u00e0nh nhi\u1ec7m v\u1ee5 ch\u00ednh: " : "M\u1ee9c \u0111\u1ed9 ho\u00e0n th\u00e0nh nhi\u1ec7m v\u1ee5 ph\u1ee5: ");
        ad.b();
        ah.b(stringBuffer.append(ad.b(this.a[this.b.s == false ? 14 : 15] * 1000 / (this.b.s == false ? this.b.length - 1 : this.b.length))).append("%").toString(), 120, 317, 33, 0, 1);
        ah.b().b(false, true);
    }

    private void b(int n2, int n3, int n4, int n5, int n6, byte[] byArray, int n7) {
        ah.b().b(n6, 8, 41, 214, 6, 24, -1, byArray[0] - byArray[1], 4, 2);
        for (n2 = byArray[1]; n2 < byArray[1] + n6; n2 = (int)((byte)(n2 + 1))) {
            if (n2 >= n7) continue;
            String string = this.b.s == false ? n2 + 1 + ", " + this.b[n2][0].toString() : n2 + 1 + ", " + this.b[this.e[n2]][0].toString();
            ah.b();
            ah.b(string, 16, 41 + (n2 - byArray[1]) * 23, 0, n2 < this.a[14] ? -1 : (byArray[0] == n2 ? 0 : 3), 0);
            if (this.b.s != false || n2 == n7 - 1) continue;
            ah.b();
            ah.b("Ho\u00e0n th\u00e0nh", 214, 41 + (n2 - byArray[1]) * 23, 24, n2 < this.a[14] ? -1 : (byArray[0] == n2 ? 0 : 3), 0);
        }
        ah.b().b(226, 41, n6 * 24, (int)byArray[0], n7, true);
    }

    private void K() {
        block15: {
            block14: {
                block13: {
                    block12: {
                        ad.b();
                        if (ad.b()) {
                            return;
                        }
                        ad.b();
                        if (ad.e()) break block12;
                        ad.b();
                        if (ad.k() && this.b.s == true) break block12;
                        ad.b();
                        if (!ad.l() || this.b.s != false) break block13;
                    }
                    this.b.s = (byte[])((byte)(this.b.s ^ 1));
                    this.b((int)this.b.s, this.d);
                    return;
                }
                ad.b();
                if (ad.c()) {
                    byte by = this.b.s == false ? (byte)(this.a[14] + 1 > this.b.length ? this.b.length : this.a[14] + 1) : (byte)this.e.length;
                    ad.b();
                    ad.b((byte[])this.b.h[0], 0, (int)by, this.b.d);
                    if (this.b.s == false) {
                        this.b.b(this.b[this.b.h[0][0]][1].toString(), 202, 0);
                        return;
                    }
                    if (this.e.length > 0) {
                        this.b.b(this.b[this.e[this.b.h[0][0]]][1].toString(), 202, 0);
                        return;
                    }
                    this.b.c = (int)null;
                    return;
                }
                ad.b();
                if (ad.i()) break block14;
                ad.b();
                if (ad.k()) break block14;
                ad.b();
                if (!ad.l()) break block15;
            }
            this.b.a = 0;
            if (this.d) {
                this.b.b(0);
                ak.a = 97;
            } else {
                ak.a = -10;
            }
            this.e = null;
            this.b = null;
            this.b.c = (int)null;
            ad.b();
            ad.c();
        }
    }

    private void L() {
        at at2 = this;
        ad.b();
        ad.c = 0;
        byte[] byArray = ad.b().b("data/map/area.dat", -1);
        ad.b();
        byte[] byArray2 = ad.b(byArray);
        byte[][] byArray3 = ad.b().b(byArray);
        if (at2.b == null || byArray2[at2.l] != byArray2[at2.a]) {
            ad.b();
            ad.c = 0;
            at2.c = ad.b().b(ad.b().b("data/map/" + byArray2[at2.a] + ".data", -1), 1);
            at2.b = null;
            at2.b = new Image[byArray3[byArray2[at2.a]].length];
            for (int n2 = 0; n2 < byArray3[byArray2[at2.a]].length; n2 = (int)((byte)(n2 + 1))) {
                Image[] imageArray = at2.b;
                ad.b();
                imageArray[n2] = ad.b("data/map/" + byArray3[byArray2[at2.a]][n2]);
            }
        }
        this.l(this.a);
    }

    private void M() {
        ad.b();
        ad.c = 0;
        byte[] byArray = ad.b().b("data/map/area.dat", -1);
        ad.b();
        byte[] byArray2 = ad.b(byArray);
        byte[][] byArray3 = ad.b().b(byArray);
        if (this.b != null && byArray2[this.l] == byArray2[this.a]) {
            return;
        }
        ad.b();
        ad.c = 0;
        this.c = ad.b().b(ad.b().b("data/map/" + byArray2[this.a] + ".data", -1), 1);
        this.b = null;
        this.b = new Image[byArray3[byArray2[this.a]].length];
        for (int n2 = 0; n2 < byArray3[byArray2[this.a]].length; n2 = (int)((byte)(n2 + 1))) {
            ad.b();
            this.b[n2] = ad.b("data/map/" + byArray3[byArray2[this.a]][n2]);
        }
    }

    private void l(int n2) {
        int n3 = 0;
        byte[] byArray = new byte[2];
        byte[] byArray2 = new byte[4];
        byte by = 0;
        this.a = null;
        this.e = null;
        this.a = null;
        int n4 = 0;
        try {
            DataInputStream dataInputStream = new DataInputStream(this.getClass().getResourceAsStream("/data/map/" + n2 + ".mid"));
            dataInputStream.skip(2L);
            dataInputStream.read(byArray2);
            ad.b();
            this.d = (int)ad.b(byArray2);
            byte[] byArray3 = new byte[dataInputStream.readByte()];
            dataInputStream.read(byArray3);
            dataInputStream.read(byArray3);
            ad.b();
            this.b = (byte)ad.b(byArray3);
            dataInputStream.read(byArray3);
            ad.b();
            this.c = (byte)ad.b(byArray3);
            this.a = new short[this.b][this.c];
            for (int n5 = 0; n5 < 3; n5 = (int)((byte)(n5 + 1))) {
                by = dataInputStream.readByte();
                if (by == -1) continue;
                dataInputStream.read(byArray2);
                ad.b();
                n3 = (int)ad.b(byArray2) * 3;
                switch (by) {
                    case 1: {
                        this.a = new short[n3];
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        this.e = new short[n3];
                    }
                }
                n4 = 0;
                while (n4 < n3) {
                    dataInputStream.read(byArray3);
                    ad.b();
                    n2 = (short)ad.b(byArray3);
                    dataInputStream.read(byArray3);
                    long l2 = this.c - 1;
                    ad.b();
                    short s2 = (short)(l2 - ad.b(byArray3));
                    dataInputStream.read(byArray);
                    ad.b();
                    short s3 = (short)ad.b(byArray);
                    switch (by) {
                        case 1: {
                            int n6 = n4;
                            n4 = (short)(n4 + 1);
                            this.a[n6] = (short)n2;
                            int n7 = n4;
                            n4 = (short)(n4 + 1);
                            this.a[n7] = s2;
                            int n8 = n4;
                            n4 = (short)(n4 + 1);
                            this.a[n8] = s3;
                            break;
                        }
                        case 2: {
                            n4 = (short)(n4 + 3);
                            this.a[n2][s2] = (short)(s3 >> 3);
                            break;
                        }
                        case 3: {
                            int n9 = n4;
                            n4 = (short)(n4 + 1);
                            this.e[n9] = (short)n2;
                            int n10 = n4;
                            n4 = (short)(n4 + 1);
                            this.e[n10] = s2;
                            int n11 = n4;
                            n4 = (short)(n4 + 1);
                            this.e[n11] = s3;
                        }
                    }
                }
            }
            dataInputStream.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void c(Graphics graphics) {
        short s2 = this.a;
        short s3 = this.e;
        if (this.c >= 0) {
            this.a = 0;
            this.h = this.c;
        } else {
            this.a = (short)(-this.c / 20);
            this.h = this.c % 20;
        }
        if (this.a >= 0) {
            this.e = 0;
            this.g = this.a;
        } else {
            this.e = (short)(-this.a / 20);
            this.g = this.a % 20;
        }
        int n2 = this.a * 20;
        int n3 = this.e * 20;
        if (this.f == 0) {
            this.f = 1;
            this.b(this.a, this.b, n2, n3, this.c, graphics, 0, 0, 260, 340, true);
        } else if (this.a != s2 || this.e != s3) {
            graphics.setClip(0, 0, 260, 340);
            graphics.copyArea(0, 0, 260, 340, (s2 - this.a) * 20, (s3 - this.e) * 20, 20);
            if (this.a < s2) {
                this.b(this.a, this.b, n2, n3, this.c, graphics, 0, 0, (s2 - this.a) * 20, 340, true);
            } else if (this.a > s2) {
                this.b(this.a, this.b, n2, n3, this.c, graphics, 260 + (s2 - this.a) * 20, 0, 260, 340, true);
            }
            if (this.e < s3) {
                this.b(this.a, this.b, n2, n3, this.c, graphics, 0, 0, 260, (s3 - this.e) * 20, true);
            } else if (this.e > s3) {
                this.b(this.a, this.b, n2, n3, this.c, graphics, 0, 340 + (s3 - this.e) * 20, 260, 340, true);
            }
        }
        b.drawImage((Image)ak.b, this.h, this.g, 20);
    }

    private void b(short[] sArray, Image[] imageArray, int n2, int n3, short[][] sArray2, Graphics graphics, int n4, int n5, int n6, int n7, boolean bl) {
        if (sArray == null) {
            return;
        }
        n3 -= 20;
        if (bl) {
            graphics.setClip(n4, n5, n6 - n4, n7 - n5);
            graphics.setColor(this.d);
            graphics.fillRect(n4, n5, n6 - n4, n7 - n5);
        }
        boolean bl2 = false;
        int n8 = 0;
        n8 = 0;
        short s2 = 0;
        for (int i2 = 0; i2 < sArray.length; i2 += 3) {
            if (sArray[i2 + 2] < 0) continue;
            int n9 = sArray[i2 + 2] >> 3;
            n8 = sArray[i2 + 2] & 3;
            int n10 = sArray[i2] * 20 - n2;
            int n11 = sArray[i2 + 1] * 20 - n3;
            if (n8 % 2 == 1) {
                n8 = sArray2[n9][4];
                s2 = sArray2[n9][3];
            } else {
                n8 = sArray2[n9][3];
                s2 = sArray2[n9][4];
            }
            if (n10 + n8 < n4 || n10 > n6 || n11 < n5 || n11 - s2 > n7) continue;
            ah.b();
            ah.b(imageArray[sArray2[n9][0]], sArray2[n9][1], sArray2[n9][2], sArray2[n9][3], sArray2[n9][4], n10, n11, 36, sArray[i2 + 2] & 7, graphics);
        }
    }

    private void N() {
        ad.b();
        if (ad.b()) {
            return;
        }
        ad.b();
        if (ad.g()) {
            this.b.a = (byte)13;
            return;
        }
        ad.b();
        if (ad.c()) {
            ad.b();
            this.b.s = (byte[])ad.b((int)this.b.s, 0, ((int)this.b.c).length - 1);
        }
    }

    private void b(int n2, int n3, int n4) {
        if (this.b != null) {
            ah.b();
            ah.b(this.b, n2 + this.n, 265, 33);
        }
        ad.b();
        this.n = ad.b(this.n, 0, 20, false);
    }

    private void c(String object) {
        if (object == null) {
            return;
        }
        int n2 = -1;
        this.h = true;
        if (((String)object).equals("T\u1eafc K\u1ef3")) {
            n2 = 0;
            this.h = false;
        } else if (((String)object).equals("Angel") || ((String)object).equals("N\u1eef nh\u00e2n t\u00f3c xanh")) {
            n2 = 1;
        } else if (((String)object).equals("Qu\u1ef7 V\u01b0\u01a1ng \u0110\u1ecba Ph\u1ee7")) {
            n2 = 2;
        } else if (((String)object).equals("Hi\u1ec7u tr\u01b0\u1edfng Jieqi")) {
            n2 = 3;
        } else if (((String)object).equals("General") || ((String)object).equals("Hi\u1ec3u tr\u01b0\u1edfng General")) {
            n2 = 4;
        } else if (((String)object).equals("Nam nh\u00e2n \u0110\u00f4ng Ph\u01b0\u01a1ng th\u1ea7n b\u00ed")) {
            n2 = 5;
        } else if (((String)object).equals("Nam Cung V\u00e2n")) {
            n2 = 6;
        }
        if (n2 >= 0) {
            if (this.b == null || this.E != n2) {
                this.n = (short)(this.h ? 50 : -50);
                this.E = (byte)n2;
                this.b = null;
                ad.b();
                this.b = ad.b("data/face/" + n2);
                return;
            }
        } else {
            object = this;
            this.b = null;
        }
    }

    private void O() {
        this.b = null;
    }

    private void P() {
        if (this.b == null) {
            this.b = ad.b().b("data/face/brow", true);
        }
    }

    private void m(int n2) {
        if (this.D < 0 || this.b.a != 0 || this.b[0][this.D].b[6] != 0) {
            return;
        }
        ah.b().b(this.b, this.b.c(4, this.J, 0), this.c + this.b[0][this.D].b + 10, this.a + this.b[0][this.D].c - 16 - 10, 0);
        this.K = (byte)(this.K + 1);
        if (this.K > this.b.c(4, this.J, 1)) {
            this.J = (byte)(this.J + 1);
            if (this.J >= this.b.b(4)) {
                this.J = 0;
            }
            this.K = 0;
        }
    }

    private void Q() {
        for (int n2 = 0; n2 < this.d.length; n2 = (int)((byte)(n2 + 1))) {
            byte by = this.d[n2];
            if (by < -1) continue;
            c = by == -1 ? this.b : this.b[0][by];
            if (at.c.b[4] != 1 && at.c.b[4] != 2 || at.c.j < 0 && at.c.b[6] == 0 || by >= 0 && !this.a((int)at.c.b, (int)at.c.c)) continue;
            if (at.c.b[6] != 0) {
                at.c.j = at.c.b[6];
            }
            if (at.c.f >= this.b.b(at.c.j)) {
                if (at.c.b[6] != 0) {
                    at.c.f = 0;
                } else {
                    at.c.j = (byte)-1;
                    continue;
                }
            }
            ah.b().b(this.b, this.b.c(at.c.j, at.c.f, 0), this.c + at.c.b + 14, this.a + at.c.c - 15 - 10, 0);
            at.c.i = (byte)(at.c.i + 1);
            if (at.c.i <= this.b.c(at.c.j, at.c.f, 1)) continue;
            at.c.f = (byte)(at.c.f + 1);
            at.c.i = 0;
        }
    }

    private void b(String string, int n2, int n3) {
        at.b[n3][n2] = ad.b().b("data/npc" + n3 + "/" + string, n3 == 2 ? this.b.b(Integer.parseInt(string)) : true);
    }

    private void R() {
        byte by;
        byte by2;
        int n2 = 0;
        byte[][] byArrayArray = new byte[3][];
        byte[][] byArrayArray2 = byArrayArray;
        byArrayArray[0] = new byte[100];
        byArrayArray2[1] = new byte[5];
        byArrayArray2[2] = new byte[60];
        this.b.e(0);
        for (by2 = (byte)(this.b.length - 1); by2 >= 0; by2 = (byte)(by2 - 1)) {
            for (by = (byte)(this.b[by2].length - 1); by >= 0; by = (byte)(by - 1)) {
                byArrayArray2[this.b[by2][by].b[3] - 1][this.b[by2][by].b[2]] = 1;
                if (by2 != 0) continue;
                this.d[by + 1] = by;
                if (this.b[by2][by].b[8] != 1) continue;
                int n3 = n2;
                n2 = (byte)(n2 + 1);
                this.b.p[n3] = by;
            }
        }
        this.b.e(1);
        this.d[0] = -1;
        for (by2 = (byte)(this.a.length + this.b[0].length); by2 > this.b[0].length; by2 = (byte)(by2 - 1)) {
            this.d[by2] = (byte)(-2 - by2 + this.b[0].length + 1);
        }
        this.b(100, 0, byArrayArray2[0]);
        this.b(5, 1, byArrayArray2[1]);
        this.b(60, 2, byArrayArray2[2]);
        for (by = (byte)(this.b[0].length - 1); by >= 0; by = (byte)(by - 1)) {
            this.b[0][by].b(b[this.b[0][by].b[3] - 1][this.b[0][by].b[2]].b());
        }
    }

    private void b(int n2, int n3, byte[] byArray) {
        --n2;
        while (n2 > 0) {
            if (byArray[n2] != 0) {
                if (null == b[n3][n2]) {
                    int n4 = n3;
                    int n5 = n2;
                    String string = "" + n2;
                    at at2 = this;
                    at.b[n4][n5] = ad.b().b("data/npc" + n4 + "/" + string, n4 == 2 ? at2.b.b(Integer.parseInt(string)) : true);
                }
            } else {
                at.b[n3][n2] = null;
            }
            --n2;
        }
    }

    private boolean a(int n2, int n3) {
        return this.c + n2 >= -80 && this.c + n2 <= 300 && this.a + n3 >= -80 && this.a + n3 <= 380;
    }

    private void b(aj[] ajArray) {
        if (ajArray == null) {
            return;
        }
        for (int n2 = 0; n2 < ajArray.length; n2 = (int)((byte)(n2 + 1))) {
            if ((ajArray[n2].b[4] == 1 || ajArray[n2].b[4] == 2) && this.a((int)ajArray[n2].b, (int)ajArray[n2].c)) {
                this.b(ajArray, n2);
            }
            at.c(ajArray, n2);
        }
    }

    private void c(aj[] ajArray) {
        if (ajArray == null) {
            return;
        }
        for (int n2 = 0; n2 < this.d.length; n2 = (int)((byte)(n2 + 1))) {
            byte by = this.d[n2];
            if (by == -1) {
                if (this.b.b[4] != 1 && this.b.b[4] != 2) continue;
                this.b(this.b, 0, this.c + this.b.b + 10, this.a + this.b.c + 19, this.b.b[7]);
                continue;
            }
            if (by < -1) {
                ad.b();
                by = (byte)(ad.a(by) - 2);
                if (!this.a(this.a[by][0] * 20, this.a[by][1] * 20)) continue;
                ah.b().a(this.a[by][2] == 2 ? 55 : 54, this.c + this.a[by][0] * 20 + 10, this.a + this.a[by][1] * 20 + 20, 33, 0);
                continue;
            }
            if ((ajArray[by].b[4] == 1 || ajArray[by].b[4] == 2) && this.a((int)ajArray[by].b, (int)ajArray[by].c)) {
                if (ajArray[by].b[8] != 3 && !this.c[by].equals("Ng\u01b0\u1eddi qua \u0111\u01b0\u1eddng")) {
                    b.drawImage(this.c, this.c + ajArray[by].b + 10, this.a + ajArray[by].c + 20, 33);
                }
                this.b(ajArray, (int)by);
            }
            at.c(ajArray, by);
        }
    }

    private void b(aj[] ajArray, int n2) {
        byte by;
        byte by2;
        byte by3;
        byte by4;
        do {
            by4 = (byte)(ajArray[n2].b[3] - 1);
            by3 = ajArray[n2].b[2];
            by2 = ajArray[n2].b[7];
            by = ajArray[n2].o;
            if (by2 < 0) {
                ajArray[n2].n = (byte)4;
                by2 = -by2;
            }
            if (ajArray[n2].o < b[by4][by3].b(by2)) break;
            ajArray[n2].o = 0;
            by = 0;
            if (ajArray[n2].b[8] != -4) continue;
            ajArray[n2].b[8] = 0;
            ajArray[n2].b[4] = 0;
            return;
        } while (!ajArray[n2].a && at.b(ajArray, n2));
        ah.b().b(b[by4][by3], b[by4][by3].c(by2, by, 0), this.c + ajArray[n2].b + 10, this.a + ajArray[n2].c + 19, ajArray[n2].n == 4 ? 1 : 0);
    }

    private static void c(aj[] ajArray, int n2) {
        byte by = (byte)(ajArray[n2].b[3] - 1);
        byte by2 = ajArray[n2].b[2];
        ad.b();
        byte by3 = (byte)ad.a(ajArray[n2].b[7]);
        if (ajArray[n2].o >= b[by][by2].b(by3)) {
            ajArray[n2].o = 0;
            at.b(ajArray, n2);
        }
        if ((ajArray[n2].p = (byte)(ajArray[n2].p + 1)) >= b[by][by2].c(by3, ajArray[n2].o, 1)) {
            ajArray[n2].o = (byte)(ajArray[n2].o + 1);
            ajArray[n2].p = 0;
        }
    }

    private static boolean b(aj[] ajArray, int n2) {
        if (ajArray[n2].h != 127) {
            ajArray[n2].b[7] = ajArray[n2].h;
            ajArray[n2].h = (byte)127;
            return true;
        }
        return false;
    }

    public final void b(aj aj2, int n2, int n3, int n4, int n5) {
        if (aj2.o >= b[1][0].b(n5)) {
            aj2.o = 0;
        }
        if (this.c != 2 && this.c != 4) {
            ah.b();
            ah.b(this.c, n3, n4, 33);
        }
        ah.b().b(b[1][0], b[1][0].c(n5, aj2.o, 0), n3, n4, aj2.n == 4 ? 1 : 0);
        aj2.p = (byte)(aj2.p + 1);
        if (aj2.p > b[1][0].c(n5, aj2.o, 1)) {
            aj2.o = (byte)(aj2.o + 1);
            aj2.p = 0;
        }
    }

    public final void i() {
        if (this.b == null) {
            return;
        }
        short s2 = 0;
        for (int n2 = 1; n2 < this.d.length; n2 = (int)((byte)(n2 + 1))) {
            short s3;
            for (int n3 = n2; n3 > 0 && (s2 = this.b(n3)) <= (s3 = this.b(n3 - 1)); n3 = (int)((byte)(n3 - 1))) {
                if (s2 == s3 && (s2 != s3 || this.d[n3 - 1] != -1)) continue;
                s2 = this.d[n3];
                this.d[n3] = this.d[n3 - 1];
                this.d[n3 - 1] = s2;
            }
        }
    }

    private short b(int n2) {
        if (this.d[n2] == -1) {
            n2 = (short)(this.b.c + this.h[this.b.n][1] * this.b.g);
        } else if (this.d[n2] < -1) {
            ad.b();
            n2 = (short)(this.a[ad.a(this.d[n2]) - 2][1] * 20);
        } else {
            n2 = this.b[0][this.d[n2]].c;
        }
        return (short)n2;
    }

    private void S() {
        this.b.b = this.b.c;
        this.b.b(true);
        if (this.b.a == 0 && this.b.c.length > 0) {
            at at2 = this;
            if (at2.i < at2.j) {
                if (at2.a[at2.b.b()][at2.b.c()] != 7) {
                    at2.i = (short)(at2.i + 1);
                    return;
                }
            } else {
                if (at2.b.c.length > 1 && at2.b.b == 0) {
                    at2.b.b = 0;
                    at2.b.a = (byte)8;
                }
                at2.b(0, 0);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void T() {
        if (this.b.k != -1 || this.b.l != -1) {
            this.b(this.b, false);
        } else {
            var3_1 = this;
            if (var3_1.M != -1 && var3_1.b.k == -1 && var3_1.b.l == -1) {
                var3_1.b.a = (byte)9;
                v0 = (byte)(var3_1.b.s + 2);
                var3_1.b.s = (byte[])v0;
                if (v0 >= var3_1.b[var3_1.M].length) {
                    var3_1.M = (byte)-1;
                    var3_1.b.a = 0;
                    var3_1.c = (byte)-1;
                    var3_1.g();
                } else {
                    var3_1.C = at.b(var3_1.c, (int)var3_1.b.b, (int)var3_1.b.c);
                    if (var3_1.C != -1) {
                        var3_1.b.a = (byte)5;
                        var3_1.k = var3_1.C;
                    }
                    var3_1.b.c(var3_1.b[var3_1.M][var3_1.b.s], var3_1.b[var3_1.M][var3_1.b.s + true]);
                }
            }
        }
        this.b(this.b, -1);
        for (var2_4 = 0; var2_4 < 3; var2_4 = (int)((byte)(var2_4 + 2))) {
            for (var1_5 = 0; var1_5 < this.b[var2_4].length; var1_5 = (int)((byte)(var1_5 + 1))) {
                block32: {
                    block30: {
                        block35: {
                            block33: {
                                block34: {
                                    block31: {
                                        if (this.b[var2_4][var1_5].b[4] != 1 && this.b[var2_4][var1_5].b[4] != 2) continue;
                                        if (this.b[var2_4][var1_5].b[8] < 5) break block30;
                                        var5_7 = var1_5;
                                        var4_6 = this.b[var2_4][var1_5];
                                        var3_1 = this;
                                        if (var3_1.b.a != 1 || var3_1.k != var5_7) break block31;
                                        v1 = var4_6.b;
                                        ad.b();
                                        v1[7] = (byte)(ad.a(var4_6.b[7]) / 3 * 3 + (var3_1.b.n < 4 ? var3_1.b.n - 1 : var3_1.b.n - 2));
                                        if (var3_1.b.n == 3) {
                                            var4_6.b[7] = -var4_6.b[7];
                                        } else {
                                            var4_6.n = (byte)3;
                                        }
                                        break block32;
                                    }
                                    var6_9 = 10;
                                    var5_8 = var4_6;
                                    if (var5_8.m != 0) break block33;
                                    if (var5_8.b != -1) break block34;
                                    ad.b();
                                    var5_8.c = ad.c(100) < 50;
                                    ad.b();
                                    if (ad.c(100) >= 50) ** GOTO lbl-1000
                                    ad.b();
                                    var5_8.m = (byte)(-(ad.c(10) + 20));
                                    var5_8.b(false);
                                    v2 = false;
                                    break block35;
                                }
                                v2 = false;
                                break block35;
                            }
                            if (var5_8.m < 0) {
                                var5_8.m = (byte)(var5_8.m + 1);
                                v2 = false;
                            } else lbl-1000:
                            // 2 sources

                            {
                                v2 = true;
                            }
                        }
                        if (v2) {
                            if (var4_6.c) {
                                var3_2 = var3_1.b.b[var4_6.b[8] - 5 << 1];
                                var6_10 = var4_6;
                                var5_8 = var3_1;
                                if (var6_10.m == 0) {
                                    ad.b();
                                    var6_10.n = (byte)(ad.c(100) < 50 ? 3 : 4);
                                    var3_2 = var6_10.n == 3 ? (short)(var6_10.b - var6_10.b[0] * 20) : (short)((var3_2 + var6_10.b[0]) * 20 - var6_10.b);
                                    if (var3_2 <= 20) {
                                        var6_10.m = (byte)(var3_2 / var6_10.g);
                                    } else {
                                        ad.b();
                                        var6_10.m = (byte)(ad.c((var3_2 - 20) / var6_10.g + 1) + 20 / var6_10.g);
                                    }
                                } else if (var6_10.m > 0 && var6_10.b <= 0) {
                                    if (super.b(var6_10, (int)(var6_10.n == 3 ? -var6_10.g : var6_10.g), 0)) {
                                        var6_10.b(var6_10.n == 3 ? -var6_10.g : var6_10.g, 0);
                                        var6_10.m = (byte)(var6_10.m - 1);
                                        var6_10.b = 1;
                                        var6_10.b(true);
                                    } else {
                                        var6_10.m = (byte)-20;
                                        var6_10.b = (byte)-1;
                                        var6_10.b(false);
                                    }
                                }
                            } else {
                                var3_3 = var3_1.b.b[(var4_6.b[8] - 5 << 1) + 1];
                                var6_11 = var4_6;
                                var5_8 = var3_1;
                                if (var6_11.m == 0 && var6_11.b == -1) {
                                    ad.b();
                                    var6_11.n = (byte)(ad.c(100) < 50 ? 1 : 2);
                                    var3_3 = var6_11.n == 1 ? (short)(var6_11.c - var6_11.b[1] * 20) : (short)((var3_3 + var6_11.b[1]) * 20 - var6_11.c);
                                    if (var3_3 <= 20) {
                                        var6_11.m = (byte)(var3_3 / var6_11.g);
                                    } else {
                                        ad.b();
                                        var6_11.m = (byte)(ad.c((var3_3 - 20) / var6_11.g + 1) + 20 / var6_11.g);
                                    }
                                } else if (var6_11.m > 0 && var6_11.b <= 0) {
                                    if (super.b(var6_11, 0, (int)(var6_11.n == 1 ? -var6_11.g : var6_11.g))) {
                                        var6_11.b(0, (int)(var6_11.n == 1 ? -var6_11.g : var6_11.g));
                                        var6_11.m = (byte)(var6_11.m - 1);
                                        var6_11.b = 1;
                                        var6_11.b(true);
                                    } else {
                                        var6_11.m = (byte)-20;
                                        var6_11.b = (byte)-1;
                                        var6_11.b(false);
                                    }
                                }
                            }
                        }
                        break block32;
                    }
                    if (this.b[var2_4][var1_5].k != -1 || this.b[var2_4][var1_5].l != -1) {
                        this.b(this.b[var2_4][var1_5], true);
                    }
                }
                this.b(this.b[var2_4][var1_5], var1_5);
            }
        }
        this.i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void c(aj aj2, int n2) {
        if (this.b.a == 1 && this.k == n2) {
            byte[] byArray = aj2.b;
            ad.b();
            byArray[7] = (byte)(ad.a(aj2.b[7]) / 3 * 3 + (this.b.n < 4 ? this.b.n - 1 : this.b.n - 2));
            if (this.b.n == 3) {
                aj2.b[7] = -aj2.b[7];
                return;
            }
            aj2.n = (byte)3;
            return;
        }
        int n3 = 10;
        Object object = aj2;
        if (((aj)object).m == 0) {
            if (((aj)object).b != -1) return;
            ad.b();
            ((aj)object).c = ad.c(100) < 50;
            ad.b();
            if (ad.c(100) < 50) {
                ad.b();
                ((aj)object).m = (byte)(-(ad.c(10) + 20));
                ((aj)object).b(false);
                return;
            }
        } else if (((aj)object).m < 0) {
            ((aj)object).m = (byte)(((aj)object).m + 1);
            return;
        }
        boolean bl = true;
        if (!bl) return;
        if (aj2.c) {
            short s2 = this.b.b[aj2.b[8] - 5 << 1];
            aj aj3 = aj2;
            object = this;
            if (aj3.m == 0) {
                ad.b();
                aj3.n = (byte)(ad.c(100) < 50 ? 3 : 4);
                s2 = aj3.n == 3 ? (short)(aj3.b - aj3.b[0] * 20) : (short)((s2 + aj3.b[0]) * 20 - aj3.b);
                if (s2 <= 20) {
                    aj3.m = (byte)(s2 / aj3.g);
                    return;
                }
                ad.b();
                aj3.m = (byte)(ad.c((s2 - 20) / aj3.g + 1) + 20 / aj3.g);
                return;
            }
            if (aj3.m <= 0) return;
            if (aj3.b > 0) return;
            if (super.b(aj3, (int)(aj3.n == 3 ? -aj3.g : aj3.g), 0)) {
                aj3.b(aj3.n == 3 ? -aj3.g : aj3.g, 0);
                aj3.m = (byte)(aj3.m - 1);
                aj3.b = 1;
                aj3.b(true);
                return;
            }
            aj3.m = (byte)-20;
            aj3.b = (byte)-1;
            aj3.b(false);
            return;
        }
        short s3 = this.b.b[(aj2.b[8] - 5 << 1) + 1];
        aj aj4 = aj2;
        object = this;
        if (aj4.m == 0 && aj4.b == -1) {
            ad.b();
            aj4.n = (byte)(ad.c(100) < 50 ? 1 : 2);
            s3 = aj4.n == 1 ? (short)(aj4.c - aj4.b[1] * 20) : (short)((s3 + aj4.b[1]) * 20 - aj4.c);
            if (s3 <= 20) {
                aj4.m = (byte)(s3 / aj4.g);
                return;
            }
            ad.b();
            aj4.m = (byte)(ad.c((s3 - 20) / aj4.g + 1) + 20 / aj4.g);
            return;
        }
        if (aj4.m <= 0) return;
        if (aj4.b > 0) return;
        if (super.b(aj4, 0, (int)(aj4.n == 1 ? -aj4.g : aj4.g))) {
            aj4.b(0, (int)(aj4.n == 1 ? -aj4.g : aj4.g));
            aj4.m = (byte)(aj4.m - 1);
            aj4.b = 1;
            aj4.b(true);
            return;
        }
        aj4.m = (byte)-20;
        aj4.b = (byte)-1;
        aj4.b(false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean b(aj aj2, int n2) {
        if (aj2.m == 0) {
            if (aj2.b != -1) return false;
            ad.b();
            aj2.c = ad.c(100) < 50;
            ad.b();
            if (ad.c(100) >= 50) return true;
            ad.b();
            aj2.m = (byte)(-(ad.c(10) + 20));
            aj2.b(false);
            return false;
        }
        if (aj2.m >= 0) return true;
        aj2.m = (byte)(aj2.m + 1);
        return false;
    }

    private boolean b(aj aj2, int n2, int n3) {
        block3: {
            block2: {
                if (this.b(aj2.b, (int)aj2.c, n2, n3, false) == 1) break block2;
                ad.b();
                if (!ad.b(aj2.b + n2, aj2.c + n3, 19, 19, this.b.b, this.b.c, 19, 19)) break block3;
            }
            return false;
        }
        return true;
    }

    private void a(aj aj2, int n2) {
        if (aj2.m == 0 && aj2.b == -1) {
            ad.b();
            aj2.n = (byte)(ad.c(100) < 50 ? 1 : 2);
            n2 = aj2.n == 1 ? (int)((short)(aj2.c - aj2.b[1] * 20)) : (int)((short)((n2 + aj2.b[1]) * 20 - aj2.c));
            if (n2 <= 20) {
                aj2.m = (byte)(n2 / aj2.g);
                return;
            }
            ad.b();
            aj2.m = (byte)(ad.c((n2 - 20) / aj2.g + 1) + 20 / aj2.g);
            return;
        }
        if (aj2.m > 0 && aj2.b <= 0) {
            if (this.b(aj2, 0, (int)(aj2.n == 1 ? -aj2.g : aj2.g))) {
                aj2.b(0, (int)(aj2.n == 1 ? -aj2.g : aj2.g));
                aj2.m = (byte)(aj2.m - 1);
                aj2.b = 1;
                aj2.b(true);
                return;
            }
            aj2.m = (byte)-20;
            aj2.b = (byte)-1;
            aj2.b(false);
        }
    }

    private void e(aj aj2, int n2) {
        if (aj2.m == 0) {
            ad.b();
            aj2.n = (byte)(ad.c(100) < 50 ? 3 : 4);
            n2 = aj2.n == 3 ? (int)((short)(aj2.b - aj2.b[0] * 20)) : (int)((short)((n2 + aj2.b[0]) * 20 - aj2.b));
            if (n2 <= 20) {
                aj2.m = (byte)(n2 / aj2.g);
                return;
            }
            ad.b();
            aj2.m = (byte)(ad.c((n2 - 20) / aj2.g + 1) + 20 / aj2.g);
            return;
        }
        if (aj2.m > 0 && aj2.b <= 0) {
            if (this.b(aj2, (int)(aj2.n == 3 ? -aj2.g : aj2.g), 0)) {
                aj2.b(aj2.n == 3 ? -aj2.g : aj2.g, 0);
                aj2.m = (byte)(aj2.m - 1);
                aj2.b = 1;
                aj2.b(true);
                return;
            }
            aj2.m = (byte)-20;
            aj2.b = (byte)-1;
            aj2.b(false);
        }
    }

    private void b(aj aj2, boolean bl) {
        boolean bl2 = aj2.b;
        short s2 = (short)(aj2.k * 20);
        short s3 = (short)(aj2.l * 20);
        if (aj2.b == s2 && aj2.c == s3) {
            if (aj2.b == -1) {
                aj2.l = (byte)-1;
                aj2.k = (byte)-1;
                if (bl) {
                    aj aj3 = aj2;
                    aj3.b[0] = aj3.b();
                    aj3.b[1] = aj3.c();
                } else {
                    aj2.g = this.b();
                }
                if (aj2.a) {
                    aj2.b[7] = aj2.h;
                    aj2.n = (byte)(aj2.h < 0 ? 4 : 3);
                    aj2.b(false, 127);
                    return;
                }
            }
        } else if (aj2.b <= 0) {
            if (bl2) {
                bl2 = aj2.b != s2;
            } else {
                boolean bl3 = bl2 = aj2.c == s3;
            }
            if (bl2) {
                int n2;
                aj aj4;
                if (aj2.b > s2 && aj2.b - aj2.g < s2 || aj2.b < s2 && aj2.b + aj2.g > s2) {
                    aj4 = aj2;
                    n2 = s2 - aj2.b;
                } else {
                    aj4 = aj2;
                    n2 = aj2.b > s2 ? (int)(-aj2.g) : aj2.g;
                }
                aj4.b(n2, 0);
                if (!aj2.a) {
                    aj2.n = (byte)(aj2.b > s2 ? 3 : 4);
                }
            } else {
                int n3;
                int n4;
                aj aj5;
                if (aj2.c > s3 && aj2.c - aj2.g < s3 || aj2.c < s3 && aj2.c + aj2.g > s3) {
                    aj5 = aj2;
                    n4 = 0;
                    n3 = s3 - aj2.c;
                } else {
                    aj5 = aj2;
                    n4 = 0;
                    n3 = aj2.c > s3 ? (int)(-aj2.g) : aj2.g;
                }
                aj5.b(n4, n3);
                if (!aj2.a) {
                    aj2.n = (byte)(aj2.c > s3 ? 1 : 2);
                }
            }
            aj2.b = aj2.c;
            aj2.b(true);
        }
    }

    private void U() {
        if (this.L > 0) {
            byte by = this.L;
            this.L = (byte)(by - 1);
            if (by % 2 == 0) {
                ah.b();
                ah.b(0xFFFFFF, 0, 0, 240, 320);
            }
        }
        if (this.g) {
            b.setColor(0);
            b.fillRect(0, this.p - 176 - this.o, 240, 176);
            b.fillRect(0, 320 - this.p + this.o, 240, 176);
        }
        if (this.b.a == 22) {
            this.b(b, this.g == 2 ? 320 - ((byte)this.b.d).length * 24 >> 1 : 45, this.g == 2);
        }
    }

    public final boolean b(int n2) {
        this.b.a = (byte)10;
        switch (n2) {
            case 0: 
            case 1: 
            case 2: {
                this.o = 0;
                this.p = (short)(n2 == 1 ? 176 : 0);
                this.g = n2 == 1;
                return true;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                this.g = true;
                if (this.o == 0) {
                    if (n2 == 6 || n2 == 5) {
                        this.o = (short)-40;
                        this.p = (short)(n2 == 5 ? 40 : 0);
                    } else {
                        this.p = this.o = (short)(n2 == 4 ? 176 : 40);
                    }
                }
                ad.b();
                this.o = ad.b(this.o, 0, 12, false);
                if (this.o != 0) break;
                this.g = n2 != 6;
                return true;
            }
        }
        return false;
    }

    private void V() {
        if (this.a == 24 || this.a == 25 || this.a == 26 || this.a == 49 || this.a == 50) {
            if (this.a == null) {
                ad.b();
                this.a = ad.b("data/cloud");
                this.e = null;
                this.e = new short[4][3];
            }
            for (int n2 = 0; n2 < this.e.length; n2 = (int)((byte)(n2 + 1))) {
                this.n(n2);
            }
            return;
        }
        this.e = null;
        this.a = null;
    }

    private void W() {
        int n2;
        if (this.a == null) {
            return;
        }
        for (n2 = 0; n2 < this.e.length; n2 = (int)((byte)(n2 + 1))) {
            ah.b();
            ah.b(this.a, this.c + this.e[n2][0], this.a + this.e[n2][1], 0);
        }
        for (n2 = 0; n2 < this.e.length; n2 = (int)((byte)(n2 + 1))) {
            if (!this.a((int)this.e[n2][0], (int)this.e[n2][1])) {
                this.n(n2);
                continue;
            }
            short[] sArray = this.e[n2];
            sArray[0] = (short)(sArray[0] - this.e[n2][2]);
        }
    }

    private void n(int n2) {
        short[] sArray = this.e[n2];
        ad.b();
        sArray[0] = (short)(this.a * 20 + 240 + ad.c(120));
        short[] sArray2 = this.e[n2];
        ad.b();
        sArray2[1] = (short)(this.e * 20 + 20 + 2 + n2 * (ad.c(25) + 55));
        short[] sArray3 = this.e[n2];
        ad.b();
        sArray3[2] = (short)(ad.c(3) + 1);
    }

    private void a(Graphics graphics) {
        graphics.setColor(0);
        for (int n2 = 0; n2 < this.b.c.length; n2 = (int)((byte)(n2 + 1))) {
            ad.b();
            if (ad.b(this.b.b, this.b.c, 19, 19, this.b.c[n2][0] * 20, this.b.c[n2][1] * 20, (this.b.c[n2][2] - this.b.c[n2][0] + 1) * 20, (this.b.c[n2][3] - this.b.c[n2][1] + 1) * 20)) continue;
            for (int n3 = 4; n3 < this.b.c[n2].length; n3 = (int)((byte)(n3 + 4))) {
                graphics.fillRect(this.c + this.b.c[n2][n3] * 20, this.a + this.b.c[n2][n3 + 1] * 20, (this.b.c[n2][n3 + 2] - this.b.c[n2][n3] + 1) * 20, (this.b.c[n2][n3 + 3] - this.b.c[n2][n3 + 1] + 1) * 20);
            }
        }
    }

    private void p(int n2) {
        this.b.a = (byte)9;
        this.c = (byte)5;
        this.g();
        this.M = (byte)n2;
        this.b.s = (byte[])false;
        this.b.c(this.b[this.M][this.b.s], this.b[this.M][this.b.s + true]);
    }

    private void X() {
        if (this.M == -1 || this.b.k != -1 || this.b.l != -1) {
            return;
        }
        this.b.a = (byte)9;
        byte by = (byte)(this.b.s + 2);
        this.b.s = (byte[])by;
        if (by >= this.b[this.M].length) {
            this.M = (byte)-1;
            this.b.a = 0;
            this.c = (byte)-1;
            this.g();
            return;
        }
        this.C = at.b(this.c, (int)this.b.b, (int)this.b.c);
        if (this.C != -1) {
            this.b.a = (byte)5;
            this.k = this.C;
        }
        this.b.c(this.b[this.M][this.b.s], this.b[this.M][this.b.s + true]);
    }

    private void b(boolean bl) {
        ai.b().b(this.b.e[this.a]);
        ai.b().b(false);
    }

    static {
        b = new am[3][];
    }
}

