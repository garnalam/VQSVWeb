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

public final class ag
extends FullCanvas
implements Runnable {
    private int var_int_a;
    private String var_java_lang_String_b = "";
    public Image var_javax_microedition_lcdui_Image_b;
    private Image var_javax_microedition_lcdui_Image_c;
    public XConnection var_main_XConnection_b;
    private ak var_ak_b;
    public int var_int_b;
    private int e;
    private boolean var_boolean_b = false;
    private long var_long_b = 0L;
    private long var_long_c = 0L;
    private am var_am_b;
    private byte var_byte_b;
    private byte var_byte_c;
    private static Graphics var_javax_microedition_lcdui_Graphics_b;
    private static DirectGraphics var_com_nokia_mid_ui_DirectGraphics_b;
    public int var_int_c = 0;
    private int d = -1;
    private byte var_byte_a;

    public ag(XConnection xConnection, String string) {
        this.var_main_XConnection_b = xConnection;
        this.var_ak_b = new ak(this);
    }

    private static void f() {
        as.var_javax_microedition_lcdui_Image_b = Image.createImage((int)260, (int)340);
        as.var_javax_microedition_lcdui_Graphics_b = as.var_javax_microedition_lcdui_Image_b.getGraphics();
    }

    public final void b() {
        new Thread(this).start();
    }

    public static void c() {
        ad.ad_b();
        ad.byte_arr_b(0, null, 4);
        ai.ai_b().c();
    }

    /*
     * Unable to fully structure code
     */
    public final void run() {
        try {
            while (!this.var_boolean_b) {
                block59: {
                    this.var_long_b = System.currentTimeMillis();
                    ai.ai_b().void_b();
                    switch (this.var_int_b) {
                        case 30: {
                            this.var_ak_b.e();
                            break;
                        }
                        case 20: {
                            if (this.var_ak_b.var_byte_a == -1) {
                                this.var_ak_b.var_byte_i = (byte)60;
                                this.d();
                            } else if (this.var_ak_b.var_byte_i < 60) {
                                this.var_ak_b.var_byte_i = (byte)(this.var_ak_b.var_byte_i + 1);
                            }
                            if (this.var_ak_b.var_byte_e != 0 || this.var_ak_b.var_byte_a != -1 || this.var_ak_b.var_byte_i != 60) break;
                            ad.ad_b();
                            ad.byte_arr_b(0, null, 4);
                            this.var_ak_b.void_c();
                        }
                    }
                    this.d();
                    ad.ad_b();
                    if (!ad.var_boolean_b) break block59;
                    var1_1 = this;
                    this.var_int_a = 3;
                    block5 : switch (var1_1.var_int_b) {
                        case 10: {
                            ad.ad_b();
                            if (ad.f()) ** GOTO lbl36
                            ad.ad_b();
                            if (!ad.i()) ** GOTO lbl50
lbl36:
                            // 2 sources

                            v0 = ai.ai_b();
                            ad.ad_b();
                            v0.var_boolean_b = ad.f();
                            v1 = ai.ai_b();
                            ad.ad_b();
                            var3_4 = ad.f() != false ? 30 : 0;
                            var2_3 = v1;
                            v1.var_byte_b = (byte)var3_4;
                            ad.ad_b();
                            ad.void_c();
                            var1_1.var_ak_b.void_b();
lbl50:
                            // 2 sources

                            ad.ad_b();
                            ad.void_c();
                            break;
                        }
                        case 30: {
                            var1_1.var_ak_b.h();
                            break;
                        }
                        case 11: {
                            ad.ad_b();
                            if (!ad.g()) break;
                            ad.ad_b();
                            ad.void_c();
                            var1_1.var_ak_b.void_b();
                            break;
                        }
                        case 101: {
                            ad.ad_b();
                            if (ad.f()) {
                                var1_1.var_boolean_b = true;
                            } else {
                                ad.ad_b();
                                if (ad.i()) {
                                    var1_1.var_int_b = 40;
                                    var1_1.d = 1;
                                }
                            }
                            ad.ad_b();
                            ad.void_c();
                            break;
                        }
                        case 70: {
                            ad.ad_b();
                            if (ad.j()) {
                                var1_1.var_int_b = var1_1.var_int_c;
                                ai.ai_b().b(true);
                            }
                            ad.ad_b();
                            ad.void_c();
                            break;
                        }
                        case 40: {
                            switch (var1_1.e) {
                                case 2: {
                                    ad.ad_b();
                                    if (ad.g()) {
                                        var1_1.m();
                                    } else {
                                        ad.ad_b();
                                        if (ad.i()) {
                                            var1_1.e = 0;
                                            var1_1.var_ak_b.var_int_c = (int)null;
                                        }
                                    }
                                    ad.ad_b();
                                    ad.void_c();
                                    break block5;
                                }
                                case 0: {
                                    ad.ad_b();
                                    ad.void_c();
                                    ad.ad_b();
                                    if (!ad.j()) ** GOTO lbl119
                                    var1_1.var_byte_b = 0;
                                    var1_1.var_byte_c = 0;
                                    var1_1.d = 1;
                                    ** GOTO lbl120
lbl119:
                                    // 1 sources

                                    if (var1_1.d == 0) break block59;
lbl120:
                                    // 2 sources

                                    ad.ad_b();
                                    if (ad.g()) {
                                        switch (var1_1.var_ak_b.u) {
                                            case 1: {
                                                if (var1_1.var_ak_b.var_byte_arr_arr_l[0] == -1) {
                                                    var1_1.m();
                                                    break block5;
                                                }
                                                var1_1.e = 2;
                                                var1_1.var_ak_b.var_byte_b = (byte)"\u0110i\u1ec1u n\u00e0y s\u1ebd x\u00f3a b\u1ecf t\u1ea5t c\u1ea3 c\u00e1c d\u1eef li\u1ec7u tr\u01b0\u1edbc \u0111\u00f3, b\u1ea1n c\u00f3 mu\u1ed1n ti\u1ebfp t\u1ee5c kh\u00f4ng?";
                                                break block5;
                                            }
                                            case 0: {
                                                var1_1.var_ak_b.j();
                                                System.gc();
                                                var1_1.var_ak_b.var_at_b.var_byte_f = 0;
                                                var1_1.g();
                                                break block5;
                                            }
                                            case 2: {
                                                ai.ai_b().a(0);
                                                ai.ai_b().b(true);
                                                break block5;
                                            }
                                            case 3: {
                                                var1_1.b(0);
                                                break block5;
                                            }
                                            case 4: {
                                                var1_1.e = 5;
                                                ad.ad_b();
                                                ad.java_lang_StringBuffer_arr_b("Vi\u1ec7t h\u00f3a: BIGAME", 221);
                                                break block5;
                                            }
                                            case 5: {
                                                var2_3 = var1_1;
                                                var1_1.var_int_b = 101;
                                                var2_3.var_main_XConnection_b.destroyApp(true);
                                            }
                                        }
                                        break block5;
                                    }
                                    ad.ad_b();
                                    if (ad.e()) {
                                        v2 = var1_1.var_ak_b;
                                        ad.ad_b();
                                        v2.u = (byte[])ad.byte_b((int)var1_1.var_ak_b.u, var1_1.var_ak_b.var_byte_arr_arr_l[0] == -1 ? 1 : 0, ((int)var1_1.var_ak_b.var_int_c).length - 1);
                                        break block5;
                                    }
                                    break block59;
                                }
                                case 4: {
                                    ad.ad_b();
                                    if (!ad.i()) ** GOTO lbl182
                                    var1_1.var_ak_b.var_int_c = (int)null;
                                    if (var1_1.var_byte_a == 1) {
                                        var1_1.var_int_b = 30;
                                        var1_1.var_ak_b.void_b(0);
                                        var1_1.var_ak_b.void_d(2);
                                        var1_1.var_ak_b.u = (byte[])true;
                                        var1_1.var_ak_b.v = (byte[])2;
                                        var1_1.var_ak_b.void_h((int)var1_1.var_ak_b.u);
                                    } else {
                                        var1_1.e();
                                        var1_1.var_ak_b.var_byte_h[0][0] = 3;
                                    }
                                    ** GOTO lbl192
lbl182:
                                    // 1 sources

                                    ad.ad_b();
                                    if (ad.boolean_c()) ** GOTO lbl188
                                    ad.ad_b();
                                    if (!ad.e()) ** GOTO lbl192
lbl188:
                                    // 2 sources

                                    v3 = var1_1.var_ak_b;
                                    ad.ad_b();
                                    v3.var_byte_arr_q = (byte[])ad.byte_b((int)var1_1.var_ak_b.var_byte_arr_q, 0, (int)(var1_1.var_ak_b.var_byte_arr_o - true));
lbl192:
                                    // 4 sources

                                    ad.ad_b();
                                    ad.void_c();
                                    break block5;
                                }
                                case 5: {
                                    ad.ad_b();
                                    if (ad.i()) {
                                        ad.ad_b();
                                        ad.void_c();
                                        var1_1.var_ak_b.void_b();
                                    } else {
                                        ** GOTO lbl204
                                    }
                                }
                            }
                        }
                    }
                }
                ad.ad_b();
                ad.void_b();
                this.var_long_c = System.currentTimeMillis() - this.var_long_b;
                if (ad.ad_b().var_int_b > 0) {
                    Thread.sleep(ad.ad_b().var_int_b);
                    ad.ad_b().var_int_b = 0;
                    continue;
                }
                if (this.var_long_c >= 60L) continue;
                Thread.sleep(60L - this.var_long_c);
            }
        }
        catch (Exception var1_2) {
            this.var_java_lang_String_b = "r" + var1_2.toString();
            var1_2.printStackTrace();
            do {
                ad.ad_b();
            } while (!ad.j());
        }
        this.var_main_XConnection_b.destroyApp(true);
    }

    public final void a() {
        if (this.var_am_b == null) {
            this.var_am_b = ad.ad_b().b("data/fm", false);
        }
        this.var_byte_c = 0;
        this.var_byte_b = 0;
        this.d = 0;
    }

    private void i() {
        this.var_byte_c = (byte)(this.var_byte_c + 1);
        if (this.var_byte_c > this.var_am_b.c(this.d, this.var_byte_b, 1)) {
            this.var_byte_c = 0;
            this.var_byte_b = (byte)(this.var_byte_b + 1);
            if (this.var_byte_b >= this.var_am_b.b(this.d)) {
                this.var_byte_b = 0;
                if (this.d == 0) {
                    this.d = 1;
                }
            }
        }
    }

    public final void e() {
        ai.ai_b().b(7);
        ai.ai_b().b(false);
        this.var_int_b = 40;
        this.e = 0;
    }

    public final void d() {
        this.repaint();
        this.serviceRepaints();
    }

    private static void b(Graphics graphics) {
        var_javax_microedition_lcdui_Graphics_b = graphics;
        var_com_nokia_mid_ui_DirectGraphics_b = DirectUtils.getDirectGraphics((Graphics)graphics);
        as.var_javax_microedition_lcdui_Graphics_c = graphics = var_javax_microedition_lcdui_Graphics_b;
        DirectUtils.getDirectGraphics((Graphics)graphics);
        ah.ah_b();
        ah.b(var_javax_microedition_lcdui_Graphics_b);
    }

    public final void paint(Graphics graphics) {
        Object object;
        Object object2;
        var_javax_microedition_lcdui_Graphics_b = object2 = graphics;
        var_com_nokia_mid_ui_DirectGraphics_b = DirectUtils.getDirectGraphics((Graphics)object2);
        as.var_javax_microedition_lcdui_Graphics_c = object = var_javax_microedition_lcdui_Graphics_b;
        DirectUtils.getDirectGraphics((Graphics)object);
        ah.ah_b();
        ah.b(var_javax_microedition_lcdui_Graphics_b);
        ad.ad_b();
        graphics.setFont(ad.var_javax_microedition_lcdui_Font_b);
        graphics.setClip(0, 0, 240, 320);
        try {
            switch (this.var_int_b) {
                case 30: {
                    this.var_ak_b.b(graphics);
                    return;
                }
                case 60: {
                    return;
                }
                case 0: {
                    object2 = this;
                    if (object2.d >= 0 && object2.d < 15) {
                        if (object2.d == 0) {
                            object2.var_javax_microedition_lcdui_Image_b = null;
                            ad.ad_b();
                            object2.var_javax_microedition_lcdui_Image_b = ad.javax_microedition_lcdui_Image_b("cwa");
                            ad.ad_b();
                            object2.var_javax_microedition_lcdui_Image_c = ad.javax_microedition_lcdui_Image_b("dangle");
                        }
                        ah.ah_b();
                        ah.b(0xFFFFFF, 0, 0, 240, 320);
                        var_javax_microedition_lcdui_Graphics_b.drawImage(object2.var_javax_microedition_lcdui_Image_c, 120, 160, 3);
                    } else if (object2.d >= 15 && object2.d <= 30) {
                        ah.ah_b();
                        ah.b(0, 0, 0, 240, 320);
                        var_javax_microedition_lcdui_Graphics_b.drawImage(object2.var_javax_microedition_lcdui_Image_b, 120, 160, 3);
                    } else if (object2.d > 30) {
                        object2.var_javax_microedition_lcdui_Image_b = null;
                        object2.var_javax_microedition_lcdui_Image_c = null;
                        object2.var_ak_b.var_byte_h = 0;
                        object2.var_int_b = 10;
                        as.var_javax_microedition_lcdui_Image_b = Image.createImage((int)260, (int)340);
                        as.var_javax_microedition_lcdui_Graphics_b = as.var_javax_microedition_lcdui_Image_b.getGraphics();
                    }
                    ++object2.d;
                    return;
                }
                case 70: {
                    ag.h();
                    ah.ah_b();
                    ah.h(-5, 260, 250, 60, 3);
                    ak.b("Tr\u00f2 ch\u01a1i t\u1ea1m d\u1eebng, Nh\u1ea5n n\u00fat 0 \u0111\u1ec3 quay l\u1ea1i.", 120, 278, 11, 3);
                    return;
                }
                case 10: {
                    ah.ah_b();
                    ah.b(0, 0, 0, 240, 320);
                    ah.ah_b();
                    ah.b("B\u1ea1n c\u00f3 mu\u1ed1n b\u1eadt nh\u1ea1c kh\u00f4ng?", 120, 140, 17, 0, 0);
                    ah.ah_b();
                    ah.b("(T\u1eaft nh\u1ea1c tr\u00f2 ch\u01a1i s\u1ebd nhanh h\u01a1n)", 120, 160, 17, 5, 0);
                    ah.ah_b();
                    ah.b("C\u00f3", 4, 320, 36, 0, 0);
                    ah.ah_b();
                    ah.b("Kh\u00f4ng", 236, 320, 40, 0, 0);
                    return;
                }
                case 20: {
                    this.var_ak_b.b(true, (int)this.var_ak_b.var_byte_i, 30, 282, 180);
                    return;
                }
                case 101: {
                    this.var_main_XConnection_b.destroyApp(true);
                    return;
                }
                case 11: {
                    ah.ah_b();
                    ah.b(this.var_javax_microedition_lcdui_Image_b, 0, 0, 0);
                    return;
                }
                case 40: {
                    switch (this.e) {
                        case 0: {
                            ah.ah_b();
                            ah.b(0, 0, 0, 240, 320);
                            ah.ah_b().b(this.var_am_b, this.var_am_b.c(this.d, this.var_byte_b, 0), 120, 160, 0);
                            object2 = this;
                            object2.var_byte_c = (byte)(object2.var_byte_c + 1);
                            if (object2.var_byte_c > object2.var_am_b.c(object2.d, object2.var_byte_b, 1)) {
                                object2.var_byte_c = 0;
                                object2.var_byte_b = (byte)(object2.var_byte_b + 1);
                                if (object2.var_byte_b >= object2.var_am_b.b(object2.d)) {
                                    object2.var_byte_b = 0;
                                    if (object2.d == 0) {
                                        object2.d = 1;
                                    }
                                }
                            }
                            if (this.d == 1) {
                                ah.ah_b();
                                ah.d(58, 294, 124, 26, 0);
                                if (this.var_ak_b.u == 2) {
                                    ah.ah_b();
                                    ah.b(126, 301, (int)ai.ai_b().var_byte_b, true);
                                }
                                ah.ah_b();
                                ah.b((String)this.var_ak_b.var_int_c[this.var_ak_b.u], 120, 318, 33, 3, 1);
                                ah.ah_b().b(120, 307, 57, true, true);
                                ah.ah_b().b(true, false);
                                return;
                            }
                            ah.ah_b();
                            ah.b("Nh\u1ea5n n\u00fat 0 \u0111\u1ec3 b\u1ecf qua", 120, 320, 33, 1, 2);
                            return;
                        }
                        case 2: {
                            ah.ah_b();
                            ah.a(0, 248, 240, 48);
                            ak.b((String)this.var_ak_b.var_byte_b, 120, 250, 12, 3);
                            ah.ah_b().b(true, true);
                            return;
                        }
                        case 4: {
                            byte by;
                            ah.ah_b();
                            ah.d(0, 0, 240, 320, 2);
                            int n2 = 17;
                            n2 = 10;
                            n2 = 120;
                            byte by2 = this.var_ak_b.var_byte_d;
                            object = this.var_ak_b.var_int_c;
                            ak ak2 = this.var_ak_b;
                            for (byte by3 = by = (byte)(by2 * ((as)ak2).q); by3 < by + by2 && by3 < ((Graphics)object).length; by3 = (byte)(by3 + 1)) {
                                ah.ah_b();
                                ah.b(object[by3].toString(), 120, 10 + (by3 - by) * 22, 17, 3, 0);
                            }
                            if (((Graphics)object).length > by2) {
                                ((as)ak2).o = (byte)(((Graphics)object).length / by2 + (((Graphics)object).length % by2 != 0 ? 1 : 0));
                                ah.ah_b();
                                ah.b(((as)ak2).q + 1 + "/" + ((as)ak2).o, 120, 318, 33, 3, 0);
                                ah.ah_b().b(120, 308, 57, true, true);
                            } else {
                                ((as)ak2).o = 1;
                            }
                            ah.ah_b().b(false, true);
                            return;
                        }
                        case 5: {
                            ah.ah_b();
                            ah.d(0, 0, 240, 320, 2);
                            ah.ah_b().b(false, true);
                            ah.ah_b();
                            ah.b("Nh\u00e0 ph\u00e1t tri\u1ec3n: ", 120, 40, 17, 3, 0);
                            ah.ah_b();
                            ah.b("BIGAME", 120, 60, 17, 3, 0);
                            ah.ah_b();
                            ah.b("D\u1ecbch v\u1ee5 ch\u0103m s\u00f3c kh\u00e1ch h\u00e0ng", 120, 80, 17, 3, 0);
                            ah.ah_b();
                            ah.b("010-88901665", 120, 100, 17, 3, 0);
                        }
                    }
                    return;
                }
                case 9999: {
                    graphics.setColor(0xFF0000);
                    graphics.drawString(this.var_int_b + " " + this.var_int_a + ":" + this.var_java_lang_String_b, 0, 20, 20);
                    graphics.drawString(this.var_java_lang_String_b, -128, 40, 20);
                    graphics.drawString(this.var_java_lang_String_b, -256, 60, 20);
                    graphics.drawString("   " + ak.var_int_a, 0, 80, 20);
                }
            }
            return;
        }
        catch (Exception exception) {
            graphics.setClip(0, 0, 240, 320);
            graphics.setColor(0);
            exception.printStackTrace();
            graphics.drawString(exception.toString() + this.var_int_a + "game" + this.var_int_b, 20, 20, 20);
            return;
        }
    }

    public final void hideNotify() {
        ad.ad_b();
        ad.var_boolean_b = false;
        if (this.var_int_b == 30) {
            this.var_int_b = 100;
        } else {
            if (this.var_int_b != 70) {
                this.var_int_c = this.var_int_b;
            }
            this.var_int_b = 70;
        }
        ai.ai_b().c();
    }

    public final void showNotify() {
        if (this.var_int_b == 100) {
            this.var_int_b = 30;
            if (ak.var_int_a != 98) {
                this.var_int_c = ak.var_int_a;
            }
            ak.var_int_a = 98;
            return;
        }
        if (this.var_int_b == 70) {
            return;
        }
        if (ak.var_int_a != 99) {
            ai.ai_b().b(false);
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
        ad.ad_b();
        ad.var_boolean_b = true;
        ad.ad_b();
        ad.e = n2;
    }

    public final void keyReleased(int n2) {
        ad.ad_b();
        ad.void_c();
    }

    /*
     * Unable to fully structure code
     */
    private final void j() {
        block46: {
            this.var_int_a = 3;
            switch (this.var_int_b) {
                case 10: {
                    ad.ad_b();
                    if (ad.f()) ** GOTO lbl10
                    ad.ad_b();
                    if (!ad.i()) ** GOTO lbl24
lbl10:
                    // 2 sources

                    v0 = ai.ai_b();
                    ad.ad_b();
                    v0.var_boolean_b = ad.f();
                    v1 = ai.ai_b();
                    ad.ad_b();
                    var2_1 = ad.f() != false ? 30 : 0;
                    var1_2 = v1;
                    v1.var_byte_b = (byte)var2_1;
                    ad.ad_b();
                    ad.void_c();
                    this.var_ak_b.void_b();
lbl24:
                    // 2 sources

                    ad.ad_b();
                    ad.void_c();
                    return;
                }
                case 30: {
                    this.var_ak_b.h();
                    return;
                }
                case 11: {
                    ad.ad_b();
                    if (!ad.g()) break;
                    ad.ad_b();
                    ad.void_c();
                    this.var_ak_b.void_b();
                    return;
                }
                case 101: {
                    ad.ad_b();
                    if (ad.f()) {
                        this.var_boolean_b = true;
                    } else {
                        ad.ad_b();
                        if (ad.i()) {
                            this.var_int_b = 40;
                            this.d = 1;
                        }
                    }
                    ad.ad_b();
                    ad.void_c();
                    return;
                }
                case 70: {
                    ad.ad_b();
                    if (ad.j()) {
                        this.var_int_b = this.var_int_c;
                        ai.ai_b().b(true);
                    }
                    ad.ad_b();
                    ad.void_c();
                    return;
                }
                case 40: {
                    switch (this.e) {
                        case 2: {
                            ad.ad_b();
                            if (ad.g()) {
                                this.m();
                            } else {
                                ad.ad_b();
                                if (ad.i()) {
                                    this.e = 0;
                                    this.var_ak_b.var_int_c = (int)null;
                                }
                            }
                            ad.ad_b();
                            ad.void_c();
                            return;
                        }
                        case 0: {
                            ad.ad_b();
                            ad.void_c();
                            ad.ad_b();
                            if (ad.j()) {
                                this.var_byte_b = 0;
                                this.var_byte_c = 0;
                                this.d = 1;
                            } else if (this.d == 0) {
                                return;
                            }
                            ad.ad_b();
                            if (ad.g()) {
                                switch (this.var_ak_b.u) {
                                    case 1: {
                                        if (this.var_ak_b.var_byte_arr_arr_l[0] == -1) {
                                            this.m();
                                            return;
                                        }
                                        this.e = 2;
                                        this.var_ak_b.var_byte_b = (byte)"\u0110i\u1ec1u n\u00e0y s\u1ebd x\u00f3a b\u1ecf t\u1ea5t c\u1ea3 c\u00e1c d\u1eef li\u1ec7u tr\u01b0\u1edbc \u0111\u00f3, b\u1ea1n c\u00f3 mu\u1ed1n ti\u1ebfp t\u1ee5c kh\u00f4ng?";
                                        return;
                                    }
                                    case 0: {
                                        this.var_ak_b.j();
                                        System.gc();
                                        this.var_ak_b.var_at_b.var_byte_f = 0;
                                        this.g();
                                        return;
                                    }
                                    case 2: {
                                        ai.ai_b().a(0);
                                        ai.ai_b().b(true);
                                        return;
                                    }
                                    case 3: {
                                        this.b(0);
                                        return;
                                    }
                                    case 4: {
                                        this.e = 5;
                                        ad.ad_b();
                                        ad.java_lang_StringBuffer_arr_b("Vi\u1ec7t h\u00f3a: BIGAME", 221);
                                        return;
                                    }
                                    case 5: {
                                        var1_3 = this;
                                        this.var_int_b = 101;
                                        var1_3.var_main_XConnection_b.destroyApp(true);
                                    }
                                }
                                return;
                            }
                            ad.ad_b();
                            if (ad.e()) {
                                ad.ad_b();
                                this.var_ak_b.u = (byte[])ad.byte_b((int)this.var_ak_b.u, this.var_ak_b.var_byte_arr_arr_l[0] == -1 ? 1 : 0, ((int)this.var_ak_b.var_int_c).length - 1);
                                return;
                            }
                            break block46;
                        }
                        case 4: {
                            ad.ad_b();
                            if (!ad.i()) ** GOTO lbl155
                            this.var_ak_b.var_int_c = (int)null;
                            if (this.var_byte_a == 1) {
                                this.var_int_b = 30;
                                this.var_ak_b.void_b(0);
                                this.var_ak_b.void_d(2);
                                this.var_ak_b.u = (byte[])true;
                                this.var_ak_b.v = (byte[])2;
                                this.var_ak_b.void_h((int)this.var_ak_b.u);
                            } else {
                                this.e();
                                this.var_ak_b.var_byte_h[0][0] = 3;
                            }
                            ** GOTO lbl164
lbl155:
                            // 1 sources

                            ad.ad_b();
                            if (ad.boolean_c()) ** GOTO lbl161
                            ad.ad_b();
                            if (!ad.e()) ** GOTO lbl164
lbl161:
                            // 2 sources

                            ad.ad_b();
                            this.var_ak_b.var_byte_arr_q = (byte[])ad.byte_b((int)this.var_ak_b.var_byte_arr_q, 0, (int)(this.var_ak_b.var_byte_arr_o - true));
lbl164:
                            // 4 sources

                            ad.ad_b();
                            ad.void_c();
                            return;
                        }
                        case 5: {
                            ad.ad_b();
                            if (ad.i()) {
                                ad.ad_b();
                                ad.void_c();
                                this.var_ak_b.void_b();
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
        this.var_int_b = 101;
        this.var_main_XConnection_b.destroyApp(true);
    }

    public static void h() {
        ah.ah_b();
        ah.c();
        int[] nArray = new int[]{0, 10, 20, 10};
        int[] nArray2 = new int[]{10, 0, 10, 20};
        for (int n2 = 0; n2 < 17; n2 = (int)((byte)(n2 + 1))) {
            for (int n3 = 0; n3 < 13; n3 = (int)((byte)(n3 + 1))) {
                var_javax_microedition_lcdui_Graphics_b.translate(n3 * 20, n2 * 20);
                var_com_nokia_mid_ui_DirectGraphics_b.fillPolygon(nArray, 0, nArray2, 0, 4, -11548673);
                var_javax_microedition_lcdui_Graphics_b.translate(n3 * -20, n2 * -20);
            }
        }
    }

    private void l() {
        if (this.d >= 0 && this.d < 15) {
            if (this.d == 0) {
                this.var_javax_microedition_lcdui_Image_b = null;
                ad.ad_b();
                this.var_javax_microedition_lcdui_Image_b = ad.javax_microedition_lcdui_Image_b("cwa");
                ad.ad_b();
                this.var_javax_microedition_lcdui_Image_c = ad.javax_microedition_lcdui_Image_b("dangle");
            }
            ah.ah_b();
            ah.b(0xFFFFFF, 0, 0, 240, 320);
            var_javax_microedition_lcdui_Graphics_b.drawImage(this.var_javax_microedition_lcdui_Image_c, 120, 160, 3);
        } else if (this.d >= 15 && this.d <= 30) {
            ah.ah_b();
            ah.b(0, 0, 0, 240, 320);
            var_javax_microedition_lcdui_Graphics_b.drawImage(this.var_javax_microedition_lcdui_Image_b, 120, 160, 3);
        } else if (this.d > 30) {
            this.var_javax_microedition_lcdui_Image_b = null;
            this.var_javax_microedition_lcdui_Image_c = null;
            this.var_ak_b.var_byte_h = 0;
            this.var_int_b = 10;
            as.var_javax_microedition_lcdui_Image_b = Image.createImage((int)260, (int)340);
            as.var_javax_microedition_lcdui_Graphics_b = as.var_javax_microedition_lcdui_Image_b.getGraphics();
        }
        ++this.d;
    }

    public final void b(int n2) {
        this.var_int_b = 40;
        this.e = 4;
        this.var_byte_a = (byte)n2;
        this.var_ak_b.var_byte_d = (byte)11;
        this.var_ak_b.b(ak.java_lang_String_b("data/help_d.t"), 202, 0);
    }

    private void m() {
        this.var_ak_b.j();
        ad.ad_b();
        if (ad.byte_arr_b(0, null, 5) == null) {
            System.gc();
            this.var_ak_b.var_at_b.var_byte_f = 0;
            ad.ad_b();
            ad.byte_arr_b(0, null, 3);
            this.var_ak_b.t();
            ad.ad_b();
            ad.byte_arr_b(10, (byte[])this.var_ak_b.var_byte_arr_arr_l, 2);
            this.g();
            this.var_ak_b.var_at_b.boolean_b(1);
        } else {
            this.var_ak_b.b("Kh\u00f4ng gian l\u01b0u tr\u1eef kh\u00f4ng \u0111\u1ee7!", 0);
        }
        this.var_ak_b.var_int_c = (int)null;
    }

    public final void g() {
        this.var_int_b = 20;
        this.var_ak_b.var_byte_i = 0;
        this.var_am_b = null;
        this.var_ak_b.q();
        this.var_ak_b.var_at_b.void_b();
        this.var_ak_b.var_at_b.var_byte_b = this.var_ak_b.var_at_b.var_byte_c;
        at at2 = this.var_ak_b.var_at_b;
        ad.ad_b();
        at2.var_byte_c = (byte)ad.c(5);
        this.var_ak_b.var_at_b.g();
        this.d();
        new ac(this.var_ak_b, 0);
    }
}

