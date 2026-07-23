/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nokia.mid.ui.DirectGraphics
 *  com.nokia.mid.ui.DirectUtils
 *  com.nokia.mid.ui.FullCanvas
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import com.nokia.mid.ui.FullCanvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.XConnection;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ag
extends FullCanvas
implements Runnable {
    private int a;
    private String b;
    public Image b;
    private Image c;
    public XConnection b;
    private ak b;
    public int b;
    private int e;
    private boolean b;
    private long b;
    private long c;
    private am b;
    private byte b = 0L;
    private byte c;
    private static Graphics b;
    private static DirectGraphics b;
    public int c = 0;
    private int d = -1;
    private byte a;

    public ag(XConnection xConnection, String string) {
        this.b = xConnection;
        this.b = new ak(this);
    }

    private static void f() {
        as.b = Image.createImage((int)260, (int)340);
        as.b = as.b.getGraphics();
    }

    public final void b() {
        new Thread(this).start();
    }

    public static void c() {
        ad.b();
        ad.b(0, null, 4);
        ai.b().c();
    }

    /*
     * Unable to fully structure code
     */
    public final void run() {
        try {
            while (!this.b) {
                block59: {
                    this.b = System.currentTimeMillis();
                    ai.b().b();
                    switch (this.b) {
                        case 30: {
                            this.b.e();
                            break;
                        }
                        case 20: {
                            if (this.b.a == -1) {
                                this.b.i = (byte)60;
                                this.d();
                            } else if (this.b.i < 60) {
                                this.b.i = (byte)(this.b.i + 1);
                            }
                            if (this.b.e != 0 || this.b.a != -1 || this.b.i != 60) break;
                            ad.b();
                            ad.b(0, null, 4);
                            this.b.c();
                        }
                    }
                    this.d();
                    ad.b();
                    if (!ad.b) break block59;
                    var1_1 = this;
                    this.a = 3;
                    block5 : switch (var1_1.b) {
                        case 10: {
                            ad.b();
                            if (ad.f()) ** GOTO lbl36
                            ad.b();
                            if (!ad.i()) ** GOTO lbl50
lbl36:
                            // 2 sources

                            v0 = ai.b();
                            ad.b();
                            v0.b = ad.f();
                            v1 = ai.b();
                            ad.b();
                            var3_4 = ad.f() != false ? 30 : 0;
                            var2_3 = v1;
                            v1.b = (byte)var3_4;
                            ad.b();
                            ad.c();
                            var1_1.b.b();
lbl50:
                            // 2 sources

                            ad.b();
                            ad.c();
                            break;
                        }
                        case 30: {
                            var1_1.b.h();
                            break;
                        }
                        case 11: {
                            ad.b();
                            if (!ad.g()) break;
                            ad.b();
                            ad.c();
                            var1_1.b.b();
                            break;
                        }
                        case 101: {
                            ad.b();
                            if (ad.f()) {
                                var1_1.b = true;
                            } else {
                                ad.b();
                                if (ad.i()) {
                                    var1_1.b = 40;
                                    var1_1.d = 1;
                                }
                            }
                            ad.b();
                            ad.c();
                            break;
                        }
                        case 70: {
                            ad.b();
                            if (ad.j()) {
                                var1_1.b = var1_1.c;
                                ai.b().b(true);
                            }
                            ad.b();
                            ad.c();
                            break;
                        }
                        case 40: {
                            switch (var1_1.e) {
                                case 2: {
                                    ad.b();
                                    if (ad.g()) {
                                        var1_1.m();
                                    } else {
                                        ad.b();
                                        if (ad.i()) {
                                            var1_1.e = 0;
                                            var1_1.b.c = (int)null;
                                        }
                                    }
                                    ad.b();
                                    ad.c();
                                    break block5;
                                }
                                case 0: {
                                    ad.b();
                                    ad.c();
                                    ad.b();
                                    if (!ad.j()) ** GOTO lbl119
                                    var1_1.b = 0;
                                    var1_1.c = 0;
                                    var1_1.d = 1;
                                    ** GOTO lbl120
lbl119:
                                    // 1 sources

                                    if (var1_1.d == 0) break block59;
lbl120:
                                    // 2 sources

                                    ad.b();
                                    if (ad.g()) {
                                        switch (var1_1.b.u) {
                                            case 1: {
                                                if (var1_1.b.l[0] == -1) {
                                                    var1_1.m();
                                                    break block5;
                                                }
                                                var1_1.e = 2;
                                                var1_1.b.b = (byte)"\u0110i\u1ec1u n\u00e0y s\u1ebd x\u00f3a b\u1ecf t\u1ea5t c\u1ea3 c\u00e1c d\u1eef li\u1ec7u tr\u01b0\u1edbc \u0111\u00f3, b\u1ea1n c\u00f3 mu\u1ed1n ti\u1ebfp t\u1ee5c kh\u00f4ng?";
                                                break block5;
                                            }
                                            case 0: {
                                                var1_1.b.j();
                                                System.gc();
                                                var1_1.b.b.f = 0;
                                                var1_1.g();
                                                break block5;
                                            }
                                            case 2: {
                                                ai.b().a(0);
                                                ai.b().b(true);
                                                break block5;
                                            }
                                            case 3: {
                                                var1_1.b(0);
                                                break block5;
                                            }
                                            case 4: {
                                                var1_1.e = 5;
                                                ad.b();
                                                ad.b("Vi\u1ec7t h\u00f3a: BIGAME", 221);
                                                break block5;
                                            }
                                            case 5: {
                                                var2_3 = var1_1;
                                                var1_1.b = 101;
                                                var2_3.b.destroyApp(true);
                                            }
                                        }
                                        break block5;
                                    }
                                    ad.b();
                                    if (ad.e()) {
                                        v2 = var1_1.b;
                                        ad.b();
                                        v2.u = (byte[])ad.b((int)var1_1.b.u, var1_1.b.l[0] == -1 ? 1 : 0, ((int)var1_1.b.c).length - 1);
                                        break block5;
                                    }
                                    break block59;
                                }
                                case 4: {
                                    ad.b();
                                    if (!ad.i()) ** GOTO lbl182
                                    var1_1.b.c = (int)null;
                                    if (var1_1.a == 1) {
                                        var1_1.b = 30;
                                        var1_1.b.b(0);
                                        var1_1.b.d(2);
                                        var1_1.b.u = (byte[])true;
                                        var1_1.b.v = (byte[])2;
                                        var1_1.b.h((int)var1_1.b.u);
                                    } else {
                                        var1_1.e();
                                        var1_1.b.h[0][0] = 3;
                                    }
                                    ** GOTO lbl192
lbl182:
                                    // 1 sources

                                    ad.b();
                                    if (ad.c()) ** GOTO lbl188
                                    ad.b();
                                    if (!ad.e()) ** GOTO lbl192
lbl188:
                                    // 2 sources

                                    v3 = var1_1.b;
                                    ad.b();
                                    v3.q = (byte[])ad.b((int)var1_1.b.q, 0, (int)(var1_1.b.o - true));
lbl192:
                                    // 4 sources

                                    ad.b();
                                    ad.c();
                                    break block5;
                                }
                                case 5: {
                                    ad.b();
                                    if (ad.i()) {
                                        ad.b();
                                        ad.c();
                                        var1_1.b.b();
                                    } else {
                                        ** GOTO lbl204
                                    }
                                }
                            }
                        }
                    }
                }
                ad.b();
                ad.b();
                this.c = System.currentTimeMillis() - this.b;
                if (ad.b().b > 0) {
                    Thread.sleep(ad.b().b);
                    ad.b().b = 0;
                    continue;
                }
                if (this.c >= 60L) continue;
                Thread.sleep(60L - this.c);
            }
        }
        catch (Exception var1_2) {
            this.b = "r" + var1_2.toString();
            var1_2.printStackTrace();
            do {
                ad.b();
            } while (!ad.j());
        }
        this.b.destroyApp(true);
    }

    public final void a() {
        if (this.b == null) {
            this.b = ad.b().b("data/fm", false);
        }
        this.c = 0;
        this.b = 0;
        this.d = 0;
    }

    private void i() {
        this.c = (byte)(this.c + 1);
        if (this.c > this.b.c(this.d, this.b, 1)) {
            this.c = 0;
            this.b = (byte)(this.b + 1);
            if (this.b >= this.b.b(this.d)) {
                this.b = 0;
                if (this.d == 0) {
                    this.d = 1;
                }
            }
        }
    }

    public final void e() {
        ai.b().b(7);
        ai.b().b(false);
        this.b = 40;
        this.e = 0;
    }

    public final void d() {
        this.repaint();
        this.serviceRepaints();
    }

    private static void b(Graphics graphics) {
        b = graphics;
        b = DirectUtils.getDirectGraphics((Graphics)graphics);
        as.c = graphics = b;
        DirectUtils.getDirectGraphics((Graphics)graphics);
        ah.b();
        ah.b(b);
    }

    public final void paint(Graphics graphics) {
        Object object;
        Object object2;
        b = object2 = graphics;
        b = DirectUtils.getDirectGraphics((Graphics)object2);
        as.c = object = b;
        DirectUtils.getDirectGraphics((Graphics)object);
        ah.b();
        ah.b(b);
        ad.b();
        graphics.setFont(ad.b);
        graphics.setClip(0, 0, 240, 320);
        try {
            switch (this.b) {
                case 30: {
                    this.b.b(graphics);
                    return;
                }
                case 60: {
                    return;
                }
                case 0: {
                    object2 = this;
                    if (object2.d >= 0 && object2.d < 15) {
                        if (object2.d == 0) {
                            object2.b = null;
                            ad.b();
                            object2.b = ad.b("cwa");
                            ad.b();
                            object2.c = ad.b("dangle");
                        }
                        ah.b();
                        ah.b(0xFFFFFF, 0, 0, 240, 320);
                        b.drawImage(object2.c, 120, 160, 3);
                    } else if (object2.d >= 15 && object2.d <= 30) {
                        ah.b();
                        ah.b(0, 0, 0, 240, 320);
                        b.drawImage(object2.b, 120, 160, 3);
                    } else if (object2.d > 30) {
                        object2.b = null;
                        object2.c = null;
                        object2.b.h = 0;
                        object2.b = 10;
                        as.b = Image.createImage((int)260, (int)340);
                        as.b = as.b.getGraphics();
                    }
                    ++object2.d;
                    return;
                }
                case 70: {
                    ag.h();
                    ah.b();
                    ah.h(-5, 260, 250, 60, 3);
                    ak.b("Tr\u00f2 ch\u01a1i t\u1ea1m d\u1eebng, Nh\u1ea5n n\u00fat 0 \u0111\u1ec3 quay l\u1ea1i.", 120, 278, 11, 3);
                    return;
                }
                case 10: {
                    ah.b();
                    ah.b(0, 0, 0, 240, 320);
                    ah.b();
                    ah.b("B\u1ea1n c\u00f3 mu\u1ed1n b\u1eadt nh\u1ea1c kh\u00f4ng?", 120, 140, 17, 0, 0);
                    ah.b();
                    ah.b("(T\u1eaft nh\u1ea1c tr\u00f2 ch\u01a1i s\u1ebd nhanh h\u01a1n)", 120, 160, 17, 5, 0);
                    ah.b();
                    ah.b("C\u00f3", 4, 320, 36, 0, 0);
                    ah.b();
                    ah.b("Kh\u00f4ng", 236, 320, 40, 0, 0);
                    return;
                }
                case 20: {
                    this.b.b(true, (int)this.b.i, 30, 282, 180);
                    return;
                }
                case 101: {
                    this.b.destroyApp(true);
                    return;
                }
                case 11: {
                    ah.b();
                    ah.b(this.b, 0, 0, 0);
                    return;
                }
                case 40: {
                    switch (this.e) {
                        case 0: {
                            ah.b();
                            ah.b(0, 0, 0, 240, 320);
                            ah.b().b(this.b, this.b.c(this.d, this.b, 0), 120, 160, 0);
                            object2 = this;
                            object2.c = (byte)(object2.c + 1);
                            if (object2.c > object2.b.c(object2.d, object2.b, 1)) {
                                object2.c = 0;
                                object2.b = (byte)(object2.b + 1);
                                if (object2.b >= object2.b.b(object2.d)) {
                                    object2.b = 0;
                                    if (object2.d == 0) {
                                        object2.d = 1;
                                    }
                                }
                            }
                            if (this.d == 1) {
                                ah.b();
                                ah.d(58, 294, 124, 26, 0);
                                if (this.b.u == 2) {
                                    ah.b();
                                    ah.b(126, 301, (int)ai.b().b, true);
                                }
                                ah.b();
                                ah.b((String)this.b.c[this.b.u], 120, 318, 33, 3, 1);
                                ah.b().b(120, 307, 57, true, true);
                                ah.b().b(true, false);
                                return;
                            }
                            ah.b();
                            ah.b("Nh\u1ea5n n\u00fat 0 \u0111\u1ec3 b\u1ecf qua", 120, 320, 33, 1, 2);
                            return;
                        }
                        case 2: {
                            ah.b();
                            ah.a(0, 248, 240, 48);
                            ak.b((String)this.b.b, 120, 250, 12, 3);
                            ah.b().b(true, true);
                            return;
                        }
                        case 4: {
                            byte by;
                            ah.b();
                            ah.d(0, 0, 240, 320, 2);
                            int n2 = 17;
                            n2 = 10;
                            n2 = 120;
                            byte by2 = this.b.d;
                            object = this.b.c;
                            ak ak2 = this.b;
                            for (byte by3 = by = (byte)(by2 * ((as)ak2).q); by3 < by + by2 && by3 < ((Graphics)object).length; by3 = (byte)(by3 + 1)) {
                                ah.b();
                                ah.b(object[by3].toString(), 120, 10 + (by3 - by) * 22, 17, 3, 0);
                            }
                            if (((Graphics)object).length > by2) {
                                ((as)ak2).o = (byte)(((Graphics)object).length / by2 + (((Graphics)object).length % by2 != 0 ? 1 : 0));
                                ah.b();
                                ah.b(((as)ak2).q + 1 + "/" + ((as)ak2).o, 120, 318, 33, 3, 0);
                                ah.b().b(120, 308, 57, true, true);
                            } else {
                                ((as)ak2).o = 1;
                            }
                            ah.b().b(false, true);
                            return;
                        }
                        case 5: {
                            ah.b();
                            ah.d(0, 0, 240, 320, 2);
                            ah.b().b(false, true);
                            ah.b();
                            ah.b("Nh\u00e0 ph\u00e1t tri\u1ec3n: ", 120, 40, 17, 3, 0);
                            ah.b();
                            ah.b("BIGAME", 120, 60, 17, 3, 0);
                            ah.b();
                            ah.b("D\u1ecbch v\u1ee5 ch\u0103m s\u00f3c kh\u00e1ch h\u00e0ng", 120, 80, 17, 3, 0);
                            ah.b();
                            ah.b("010-88901665", 120, 100, 17, 3, 0);
                        }
                    }
                    return;
                }
                case 9999: {
                    graphics.setColor(0xFF0000);
                    graphics.drawString(this.b + " " + this.a + ":" + this.b, 0, 20, 20);
                    graphics.drawString(this.b, -128, 40, 20);
                    graphics.drawString(this.b, -256, 60, 20);
                    graphics.drawString("   " + ak.a, 0, 80, 20);
                }
            }
            return;
        }
        catch (Exception exception) {
            graphics.setClip(0, 0, 240, 320);
            graphics.setColor(0);
            exception.printStackTrace();
            graphics.drawString(exception.toString() + this.a + "game" + this.b, 20, 20, 20);
            return;
        }
    }

    public final void hideNotify() {
        ad.b();
        ad.b = false;
        if (this.b == 30) {
            this.b = 100;
        } else {
            if (this.b != 70) {
                this.c = this.b;
            }
            this.b = 70;
        }
        ai.b().c();
    }

    public final void showNotify() {
        if (this.b == 100) {
            this.b = 30;
            if (ak.a != 98) {
                this.c = ak.a;
            }
            ak.a = 98;
            return;
        }
        if (this.b == 70) {
            return;
        }
        if (ak.a != 99) {
            ai.b().b(false);
        }
    }

    public final void keyPressed(int n2) {
        if (n2 == 50) {
            n2 = -1;
        } else if (n2 == 52) {
            n2 = -3;
        } else if (n2 == 54) {
            n2 = -4;
        } else if (n2 == 56) {
            n2 = -2;
        }
        ad.b();
        ad.b = true;
        ad.b();
        ad.e = n2;
    }

    public final void keyReleased(int n2) {
        ad.b();
        ad.c();
    }

    /*
     * Unable to fully structure code
     */
    private final void j() {
        block46: {
            this.a = 3;
            switch (this.b) {
                case 10: {
                    ad.b();
                    if (ad.f()) ** GOTO lbl10
                    ad.b();
                    if (!ad.i()) ** GOTO lbl24
lbl10:
                    // 2 sources

                    v0 = ai.b();
                    ad.b();
                    v0.b = ad.f();
                    v1 = ai.b();
                    ad.b();
                    var2_1 = ad.f() != false ? 30 : 0;
                    var1_2 = v1;
                    v1.b = (byte)var2_1;
                    ad.b();
                    ad.c();
                    this.b.b();
lbl24:
                    // 2 sources

                    ad.b();
                    ad.c();
                    return;
                }
                case 30: {
                    this.b.h();
                    return;
                }
                case 11: {
                    ad.b();
                    if (!ad.g()) break;
                    ad.b();
                    ad.c();
                    this.b.b();
                    return;
                }
                case 101: {
                    ad.b();
                    if (ad.f()) {
                        this.b = true;
                    } else {
                        ad.b();
                        if (ad.i()) {
                            this.b = 40;
                            this.d = 1;
                        }
                    }
                    ad.b();
                    ad.c();
                    return;
                }
                case 70: {
                    ad.b();
                    if (ad.j()) {
                        this.b = this.c;
                        ai.b().b(true);
                    }
                    ad.b();
                    ad.c();
                    return;
                }
                case 40: {
                    switch (this.e) {
                        case 2: {
                            ad.b();
                            if (ad.g()) {
                                this.m();
                            } else {
                                ad.b();
                                if (ad.i()) {
                                    this.e = 0;
                                    this.b.c = (int)null;
                                }
                            }
                            ad.b();
                            ad.c();
                            return;
                        }
                        case 0: {
                            ad.b();
                            ad.c();
                            ad.b();
                            if (ad.j()) {
                                this.b = 0;
                                this.c = 0;
                                this.d = 1;
                            } else if (this.d == 0) {
                                return;
                            }
                            ad.b();
                            if (ad.g()) {
                                switch (this.b.u) {
                                    case 1: {
                                        if (this.b.l[0] == -1) {
                                            this.m();
                                            return;
                                        }
                                        this.e = 2;
                                        this.b.b = (byte)"\u0110i\u1ec1u n\u00e0y s\u1ebd x\u00f3a b\u1ecf t\u1ea5t c\u1ea3 c\u00e1c d\u1eef li\u1ec7u tr\u01b0\u1edbc \u0111\u00f3, b\u1ea1n c\u00f3 mu\u1ed1n ti\u1ebfp t\u1ee5c kh\u00f4ng?";
                                        return;
                                    }
                                    case 0: {
                                        this.b.j();
                                        System.gc();
                                        this.b.b.f = 0;
                                        this.g();
                                        return;
                                    }
                                    case 2: {
                                        ai.b().a(0);
                                        ai.b().b(true);
                                        return;
                                    }
                                    case 3: {
                                        this.b(0);
                                        return;
                                    }
                                    case 4: {
                                        this.e = 5;
                                        ad.b();
                                        ad.b("Vi\u1ec7t h\u00f3a: BIGAME", 221);
                                        return;
                                    }
                                    case 5: {
                                        var1_3 = this;
                                        this.b = 101;
                                        var1_3.b.destroyApp(true);
                                    }
                                }
                                return;
                            }
                            ad.b();
                            if (ad.e()) {
                                ad.b();
                                this.b.u = (byte[])ad.b((int)this.b.u, this.b.l[0] == -1 ? 1 : 0, ((int)this.b.c).length - 1);
                                return;
                            }
                            break block46;
                        }
                        case 4: {
                            ad.b();
                            if (!ad.i()) ** GOTO lbl155
                            this.b.c = (int)null;
                            if (this.a == 1) {
                                this.b = 30;
                                this.b.b(0);
                                this.b.d(2);
                                this.b.u = (byte[])true;
                                this.b.v = (byte[])2;
                                this.b.h((int)this.b.u);
                            } else {
                                this.e();
                                this.b.h[0][0] = 3;
                            }
                            ** GOTO lbl164
lbl155:
                            // 1 sources

                            ad.b();
                            if (ad.c()) ** GOTO lbl161
                            ad.b();
                            if (!ad.e()) ** GOTO lbl164
lbl161:
                            // 2 sources

                            ad.b();
                            this.b.q = (byte[])ad.b((int)this.b.q, 0, (int)(this.b.o - true));
lbl164:
                            // 4 sources

                            ad.b();
                            ad.c();
                            return;
                        }
                        case 5: {
                            ad.b();
                            if (ad.i()) {
                                ad.b();
                                ad.c();
                                this.b.b();
                            } else {
                                ** GOTO lbl176
                            }
                        }
                    }
                }
            }
        }
    }

    private void k() {
        this.b = 101;
        this.b.destroyApp(true);
    }

    public static void h() {
        ah.b();
        ah.c();
        int[] nArray = new int[]{0, 10, 20, 10};
        int[] nArray2 = new int[]{10, 0, 10, 20};
        for (int n2 = 0; n2 < 17; n2 = (int)((byte)(n2 + 1))) {
            for (int n3 = 0; n3 < 13; n3 = (int)((byte)(n3 + 1))) {
                b.translate(n3 * 20, n2 * 20);
                b.fillPolygon(nArray, 0, nArray2, 0, 4, -11548673);
                b.translate(n3 * -20, n2 * -20);
            }
        }
    }

    private void l() {
        if (this.d >= 0 && this.d < 15) {
            if (this.d == 0) {
                this.b = null;
                ad.b();
                this.b = ad.b("cwa");
                ad.b();
                this.c = ad.b("dangle");
            }
            ah.b();
            ah.b(0xFFFFFF, 0, 0, 240, 320);
            b.drawImage(this.c, 120, 160, 3);
        } else if (this.d >= 15 && this.d <= 30) {
            ah.b();
            ah.b(0, 0, 0, 240, 320);
            b.drawImage(this.b, 120, 160, 3);
        } else if (this.d > 30) {
            this.b = null;
            this.c = null;
            this.b.h = 0;
            this.b = 10;
            as.b = Image.createImage((int)260, (int)340);
            as.b = as.b.getGraphics();
        }
        ++this.d;
    }

    public final void b(int n2) {
        this.b = 40;
        this.e = 4;
        this.a = (byte)n2;
        this.b.d = (byte)11;
        this.b.b(ak.b("data/help_d.t"), 202, 0);
    }

    private void m() {
        this.b.j();
        ad.b();
        if (ad.b(0, null, 5) == null) {
            System.gc();
            this.b.b.f = 0;
            ad.b();
            ad.b(0, null, 3);
            this.b.t();
            ad.b();
            ad.b(10, (byte[])this.b.l, 2);
            this.g();
            this.b.b.b(1);
        } else {
            this.b.b("Kh\u00f4ng gian l\u01b0u tr\u1eef kh\u00f4ng \u0111\u1ee7!", 0);
        }
        this.b.c = (int)null;
    }

    public final void g() {
        this.b = 20;
        this.b.i = 0;
        this.b = null;
        this.b.q();
        this.b.b.b();
        this.b.b.b = this.b.b.c;
        at at2 = this.b.b;
        ad.b();
        at2.c = (byte)ad.c(5);
        this.b.b.g();
        this.d();
        new ac(this.b, 0);
    }
}

