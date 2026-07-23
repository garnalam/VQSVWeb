/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.lcdui.Font
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.midlet.MIDlet
 */
import java.io.InputStream;
import java.io.Serializable;
import java.util.Calendar;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;
import main.XConnection;

public final class ap
extends Canvas
implements Runnable {
    private static int var_int_b;
    private static int var_int_c;
    private int[][] var_int_arr_arr_b = new int[4][4];
    private static final String[] var_java_lang_String_arr_b;
    private String var_java_lang_String_b = null;
    private y var_y_b;
    private String var_java_lang_String_c;
    private MIDlet var_javax_microedition_midlet_MIDlet_b;
    private Displayable var_javax_microedition_lcdui_Displayable_b;
    private int var_int_a;
    private int var_int_e;
    private String var_java_lang_String_a;
    private String var_java_lang_String_e;
    private String var_java_lang_String_d;
    private String var_java_lang_String_h;
    private String g;
    private String f;
    private int var_int_d;
    private String i;
    private String j;
    private String k;
    private String l;
    public ar var_ar_b;
    private int var_int_h;

    static {
        var_int_b = 240;
        var_int_c = 320;
        var_java_lang_String_arr_b = new String[]{"Nokia", "Motorokr", "Motorola", "SonyEricsson", "Samsung", "j2me", "SunMicrosystems_wtk", "MX6", "MotoA668"};
    }

    public ap(MIDlet object, Displayable displayable, String string, String string2, String string3, String string4, int n2, String string5, String string6, String string7) {
        this.var_java_lang_String_c = null;
        this.var_javax_microedition_midlet_MIDlet_b = null;
        this.var_int_a = 0;
        this.var_int_e = 0;
        this.var_java_lang_String_a = "G\u1eedi tin";
        this.var_java_lang_String_e = "Quay l\u1ea1i";
        this.var_java_lang_String_d = null;
        this.var_java_lang_String_h = null;
        this.g = null;
        this.f = null;
        this.var_int_d = 0;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = "Mua s\u1eafm";
        this.var_ar_b = null;
        this.var_int_h = -1;
        this.setFullScreenMode(true);
        try {
            this.var_javax_microedition_midlet_MIDlet_b = object;
            this.var_javax_microedition_lcdui_Displayable_b = displayable;
            this.var_java_lang_String_d = string;
            this.var_java_lang_String_h = string2;
            if (string3 == null || string3.length() == 0) {
                string3 = "00";
            }
            string4 = "000";
            this.g = string3;
            this.f = string4;
            this.var_int_d = n2;
            this.i = string5;
            this.j = string6;
            this.k = string7;
            this.b((MIDlet)object);
            var_int_b = this.getWidth();
            var_int_c = this.getHeight();
            this.void_b();
            object = this;
            this.var_java_lang_String_a = "G\u1eedi tin";
            ((ap)object).var_java_lang_String_e = "Quay l\u1ea1i";
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public final void sizeChanged(int n2, int n3) {
        super.sizeChanged(n2, n3);
        var_int_b = this.getWidth();
        var_int_c = this.getHeight();
        this.void_b();
    }

    private void void_b() {
        int n2 = Font.getFont((int)0, (int)1, (int)0).getHeight() + 4;
        int n3 = t.b("G\u1eedi tin") + 4;
        this.var_int_arr_arr_b[0][0] = 2;
        this.var_int_arr_arr_b[0][1] = var_int_c - n2;
        this.var_int_arr_arr_b[0][2] = n3;
        this.var_int_arr_arr_b[0][3] = var_int_c;
        this.var_int_arr_arr_b[1][0] = var_int_b - n3;
        this.var_int_arr_arr_b[1][1] = var_int_c - n2;
        this.var_int_arr_arr_b[1][2] = var_int_b;
        this.var_int_arr_arr_b[1][3] = var_int_c;
        this.var_int_arr_arr_b[2][0] = var_int_b / 2 - (n3 <<= 1);
        this.var_int_arr_arr_b[2][1] = var_int_c - n2;
        this.var_int_arr_arr_b[2][2] = var_int_b / 2;
        this.var_int_arr_arr_b[2][3] = var_int_c;
        this.var_int_arr_arr_b[3][0] = var_int_b / 2;
        this.var_int_arr_arr_b[3][1] = var_int_c - n2;
        this.var_int_arr_arr_b[3][2] = var_int_b / 2 + n3;
        this.var_int_arr_arr_b[3][3] = var_int_c;
    }

    private void b(MIDlet object) {
        int n2 = 0;
        String string = null;
        try {
            string = object.getAppProperty("Platform");
            if (string == null) {
                string = System.getProperty("microedition.platform");
            }
        }
        catch (Exception exception) {}
        if (string != null) {
            string = string.toLowerCase();
            object = null;
            n2 = 0;
            while (n2 < var_java_lang_String_arr_b.length) {
                object = var_java_lang_String_arr_b[n2].toLowerCase();
                if (string.length() >= ((String)object).length() && string.startsWith((String)object)) break;
                ++n2;
            }
            this.var_java_lang_String_b = object;
        }
    }

    private void c() {
        Serializable serializable;
        this.var_java_lang_String_a = "G\u1eedi tin";
        this.var_java_lang_String_e = "Quay l\u1ea1i";
        ap ap2 = this;
        this.var_y_b = af.y_b(ap2.var_java_lang_String_d, ap2.var_java_lang_String_h, ap2.g, ap2.f, ap2.var_int_d);
        if (ap2.var_y_b != null && ap2.var_y_b.var_boolean_b) {
            serializable = Calendar.getInstance();
            ((Calendar)serializable).set(11, 0);
            ((Calendar)serializable).set(12, 0);
            ((Calendar)serializable).set(13, 0);
            ((Calendar)serializable).set(14, 0);
            if (((Calendar)serializable).getTime().getTime() > ap2.var_y_b.var_long_b) {
                ap2.var_y_b.var_long_b = 0L;
                if (ap2.var_y_b != null && ap2.var_y_b.var_int_e % 2 != 0) {
                    --ap2.var_y_b.var_int_e;
                }
            }
        }
        try {
            if (ap2.var_y_b == null || ap2.var_y_b != null && ap2.var_y_b.var_int_a >= ap2.var_int_d) {
                ap2.var_y_b = x.y_b(ap2.var_java_lang_String_d, ap2.var_java_lang_String_h, ap2.g, ap2.f, ap2.var_int_d);
            }
        }
        catch (Exception exception) {
            serializable = exception;
            exception.printStackTrace();
            ap2.var_java_lang_String_a = "";
            ap2.b(((Throwable)serializable).toString());
            return;
        }
        ap2.e();
    }

    private void a() {
        Serializable serializable;
        this.var_y_b = af.y_b(this.var_java_lang_String_d, this.var_java_lang_String_h, this.g, this.f, this.var_int_d);
        if (this.var_y_b != null && this.var_y_b.var_boolean_b) {
            serializable = Calendar.getInstance();
            ((Calendar)serializable).set(11, 0);
            ((Calendar)serializable).set(12, 0);
            ((Calendar)serializable).set(13, 0);
            ((Calendar)serializable).set(14, 0);
            if (((Calendar)serializable).getTime().getTime() > this.var_y_b.var_long_b) {
                this.var_y_b.var_long_b = 0L;
                if (this.var_y_b != null && this.var_y_b.var_int_e % 2 != 0) {
                    --this.var_y_b.var_int_e;
                }
            }
        }
        try {
            if (this.var_y_b == null || this.var_y_b != null && this.var_y_b.var_int_a >= this.var_int_d) {
                this.var_y_b = x.y_b(this.var_java_lang_String_d, this.var_java_lang_String_h, this.g, this.f, this.var_int_d);
            }
        }
        catch (Exception exception) {
            serializable = exception;
            exception.printStackTrace();
            this.var_java_lang_String_a = "";
            this.b(((Throwable)serializable).toString());
            return;
        }
        this.e();
    }

    private void e() {
        if (this.var_y_b.var_int_e == 0) {
            ap ap2 = this;
            if (ap2.var_y_b != null) {
                ap2.b(ap2.j);
            }
            return;
        }
        this.b(false);
    }

    private void d() {
        if (this.var_y_b == null) {
            return;
        }
        this.b(this.j);
    }

    /*
     * WARNING - void declaration
     */
    private void b(boolean bl) {
        void var1_7;
        if (this.var_y_b.var_boolean_b) {
            void var1_4;
            String charSequence;
            if (bl) {
                try {
                    Thread.sleep(3000L);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            if ((charSequence = this.var_y_b.var_java_lang_String_a).startsWith("10658008")) {
                String string = "10658008";
            }
            if (this.var_y_b.var_int_e % 2 == 0) {
                int n2 = this.var_y_b.var_int_b << 1;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("B\u1ea1n \u0111\u00e3 g\u1eedi \u0111i" + this.var_y_b.var_int_e / 2 + "S\u1ed1 \u0111i\u1ec7n tho\u1ea1i thu ph\u00ed SMS, c\u00f2n c\u1ea7n g\u1eedi \u0111i" + (n2 - this.var_y_b.var_int_e) / 2 + "S\u1ed1 \u0111i\u1ec7n tho\u1ea1i thu ph\u00ed SMS");
                stringBuffer.append(". \n").append(this.var_y_b.d);
                this.b(stringBuffer.toString());
                return;
            }
            this.b("Theo y\u00eau c\u1ea7u m\u1ed9t l\u1ea7n n\u1eefa c\u1ee7a ng\u01b0\u1eddi d\u00f9ng \u0111\u01b0\u1ee3c ch\u1ea5p nh\u1eadn" + (String)var1_4 + "G\u1eedi tin nh\u1eafn \u0111\u1ec3 x\u00e1c nh\u1eadn mua s\u1eafm" + this.i + ", Tin nh\u1eafn: " + this.var_y_b.var_int_c + " tin" + this.k);
            return;
        }
        int n3 = this.var_y_b.var_int_b;
        if (this.var_y_b.var_java_lang_String_c != null && this.var_y_b.var_java_lang_String_c.length() != 0) {
            ++var1_7;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("B\u1ea1n \u0111\u00e3 g\u1eedi \u0111i" + this.var_y_b.var_int_e + " tin, c\u00f2n c\u1ea7n g\u1eedi " + (int)(var1_7 - this.var_y_b.var_int_e) + "SMS");
        if (this.var_y_b.var_java_lang_String_c != null && this.var_y_b.var_java_lang_String_c.length() != 0) {
            stringBuffer.append(", C\u00e1c tin nh\u1eafn SMS \u0111\u1ea7u ti\u00ean mi\u1ec5n ph\u00ed \u0111\u01b0\u1ee3c s\u1eed d\u1ee5ng \u0111\u1ec3 nh\u1eadn th\u00f4ng tin v\u1ec1 tr\u00f2 ch\u01a1i");
        }
        stringBuffer.append(". \n").append(this.var_y_b.d);
        this.b(stringBuffer.toString());
    }

    private void h() {
        new Thread(this).start();
    }

    public final void run() {
        w.b(XConnection.var_javax_microedition_midlet_MIDlet_b);
        w.b(this.var_ar_b.int_b());
        i i2 = new i();
        Object object = i2;
        object = i2.var_l_b.var_j_b;
        object.b("ca", (Object)new aq(this, 0));
        object.b("gi", (Object)new aq(this, 1));
        object.b("gs", (Object)new aq(this, 2));
        object.b("gg", (Object)new aq(this, 3));
        object.b("gj", (Object)new aq(this, 4));
        object.b("yc", (Object)new aq(this, 5));
        object.b("m", (Object)new aq(this, 6));
        object.b("n", (Object)new aq(this, 7));
        object.b("as", (Object)new aq(this, 8));
        object.b("ufc", (Object)new aq(this, 9));
        object.b("ufb", (Object)new aq(this, 10));
        object.b("aa", (Object)new aq(this, 11));
        object.b("kq", (Object)new aq(this, 12));
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/data/dcn.bin");
            object = i2;
            object = h.b(inputStream, ((i)object).var_l_b.var_j_b);
            inputStream.close();
            i2.java_lang_Object_b(object, (Object)null);
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    private static boolean boolean_b() {
        return false;
    }

    private static int int_b() {
        String string = System.getProperty("wireless.messaging.sms.smsc");
        if (string != null) {
            if (string.startsWith("138") || string.startsWith("+138") || string.startsWith("+86138")) {
                return 0;
            }
            if (string.startsWith("+86130") || string.startsWith("0086130") || string.startsWith("130") || string.startsWith("+130")) {
                return 1;
            }
        }
        return 0;
    }

    private void b(String string) {
        this.var_int_a = 0;
        this.var_java_lang_String_c = string;
        this.repaint();
    }

    private void g() {
        if (this.var_ar_b != null) {
            this.var_ar_b.b(this.var_y_b.var_int_a >= this.var_int_d);
        }
    }

    private int b(int n2) {
        if ("Motorola".equals(this.var_java_lang_String_b)) {
            switch (n2) {
                case -21: 
                case 21: {
                    return -6;
                }
                case -22: 
                case 22: {
                    return -7;
                }
                case -6: {
                    return 56;
                }
            }
        }
        return n2;
    }

    /*
     * Unable to fully structure code
     */
    public final void keyPressed(int var1_1) {
        var2_4 = var1_1;
        var1_2 = this;
        if (!"Motorola".equals(var1_2.var_java_lang_String_b)) ** GOTO lbl-1000
        switch (var2_4) {
            case -21: 
            case 21: {
                v0 = -6;
                break;
            }
            case -22: 
            case 22: {
                v0 = -7;
                break;
            }
            case -6: {
                v0 = 56;
                break;
            }
            default: lbl-1000:
            // 2 sources

            {
                v0 = var2_4;
            }
        }
        var1_3 = v0;
        switch (v0) {
            case -202: 
            case -21: 
            case -6: 
            case 21: {
                this.j();
                break;
            }
            case -203: 
            case -22: 
            case -7: 
            case 22: {
                this.k();
                break;
            }
            case 50: {
                this.f();
                break;
            }
            case 56: {
                this.i();
                break;
            }
            default: {
                System.out.println(var1_3);
            }
        }
        switch (this.getGameAction(var1_3)) {
            case 1: {
                this.f();
                return;
            }
            case 6: {
                this.i();
                return;
            }
        }
    }

    private boolean b(int n2, int n3, int n4) {
        return n2 > this.var_int_arr_arr_b[n4][0] && n2 < this.var_int_arr_arr_b[n4][2] && n3 > this.var_int_arr_arr_b[n4][1] && n3 < this.var_int_arr_arr_b[n4][3];
    }

    public final void pointerPressed(int n2, int n3) {
        if (this.b(n2, n3, 0)) {
            this.j();
            return;
        }
        if (this.b(n2, n3, 1)) {
            this.k();
            return;
        }
        if (this.b(n2, n3, 2)) {
            if (this.var_int_h == 0 || this.var_int_h == 1) {
                this.f();
                return;
            }
        } else if (this.b(n2, n3, 3) && (this.var_int_h == 0 || this.var_int_h == 2)) {
            this.i();
        }
    }

    public final void keyRepeated(int n2) {
        super.keyRepeated(n2);
        this.keyPressed(n2);
    }

    private void f() {
        --this.var_int_a;
        if (this.var_int_a <= 0) {
            this.var_int_a = 0;
        }
        this.repaint();
    }

    private void i() {
        if (this.var_int_e > 0) {
            ++this.var_int_a;
        }
        this.repaint();
    }

    private void j() {
        if ("G\u1eedi tin".equals(this.var_java_lang_String_a) && this.var_y_b.var_int_b > 0) {
            this.var_java_lang_String_a = "";
            this.var_java_lang_String_e = "";
            ap ap2 = this;
            new Thread(ap2).start();
            return;
        }
        if ("X\u00e1c nh\u1eadn".equals(this.var_java_lang_String_a)) {
            this.var_java_lang_String_a = "G\u1eedi tin";
            this.var_java_lang_String_e = "Quay l\u1ea1i";
            this.e();
        }
    }

    private void k() {
        if ("Quay l\u1ea1i".equals(this.var_java_lang_String_e)) {
            if (this.var_y_b.var_int_a < this.var_int_d) {
                this.var_java_lang_String_a = "X\u00e1c nh\u1eadn";
                this.var_java_lang_String_e = "Tr\u1edf v\u1ec1";
                this.b("B\u1ea1n v\u1eabn ch\u01b0a ho\u00e0n t\u1ea5t thanh to\u00e1n, vui l\u00f2ng ho\u00e0n t\u1ea5t thanh to\u00e1n.");
                return;
            }
            this.g();
            Display.getDisplay((MIDlet)this.var_javax_microedition_midlet_MIDlet_b).setCurrent(this.var_javax_microedition_lcdui_Displayable_b);
            return;
        }
        if ("Tr\u1edf v\u1ec1".equals(this.var_java_lang_String_e)) {
            this.g();
            Display.getDisplay((MIDlet)this.var_javax_microedition_midlet_MIDlet_b).setCurrent(this.var_javax_microedition_lcdui_Displayable_b);
        }
    }

    public final void paint(Graphics graphics) {
        Font.getDefaultFont();
        Font font = Font.getFont((int)0, (int)1, (int)0);
        graphics.setColor(4423868);
        graphics.fillRect(0, 0, var_int_b, var_int_c);
        graphics.setColor(255, 102, 0);
        graphics.fillRect(0, 0, var_int_b, 30);
        graphics.setColor(0xFFFFFF);
        int n2 = (30 - font.getHeight()) / 2;
        graphics.drawString(this.l, 2, n2, 0);
        graphics.setFont(font);
        int n3 = font.getHeight() + 8;
        int[] nArray = t.b(graphics, this.var_java_lang_String_c, font, var_int_b - 10, var_int_c - n3 - 10, this.var_int_a, 5, 35, 5);
        this.var_int_e = nArray[1];
        graphics.setColor(255, 102, 0);
        int n4 = var_int_c - n3;
        graphics.fillRect(0, n4, var_int_b, n3);
        graphics.setColor(0xFFFFFF);
        n4 = var_int_c - (n3 + font.getHeight()) / 2;
        graphics.drawString(this.var_java_lang_String_a, 2, n4, 0);
        int n5 = var_int_b - t.b(this.var_java_lang_String_e) - 2 - 2;
        graphics.drawString(this.var_java_lang_String_e, n5, n4, 0);
        n5 = var_int_c - n3 / 2;
        this.var_int_h = -1;
        if (this.var_int_a > 0 && this.var_int_e > 0) {
            this.var_int_h = 0;
            n4 = n5 + 5;
            graphics.fillTriangle(var_int_b / 2 - 10 - 3, n4, var_int_b / 2 - 10 + 3, n4, var_int_b / 2 - 10, n4 - 11);
            graphics.fillTriangle(var_int_b / 2 + 10 - 3, n5 -= 5, var_int_b / 2 + 10 + 3, n5, var_int_b / 2 + 10, n5 + 11);
            return;
        }
        if (this.var_int_a > 0) {
            this.var_int_h = 1;
            graphics.fillTriangle(var_int_b / 2 - 10 - 3, n5 += 5, var_int_b / 2 - 10 + 3, n5, var_int_b / 2 - 10, n5 - 11);
            return;
        }
        if (this.var_int_e > 0) {
            this.var_int_h = 2;
            graphics.fillTriangle(var_int_b / 2 + 10 - 3, n5 -= 5, var_int_b / 2 + 10 + 3, n5, var_int_b / 2 + 10, n5 + 11);
        }
    }

    public ap() {
        this.var_y_b = new y();
        this.var_java_lang_String_c = null;
        this.var_javax_microedition_midlet_MIDlet_b = null;
        this.var_int_a = 0;
        this.var_int_e = 0;
        this.var_java_lang_String_a = "G\u1eedi tin";
        this.var_java_lang_String_e = "Quay l\u1ea1i";
        this.var_java_lang_String_d = null;
        this.var_java_lang_String_h = null;
        this.g = null;
        this.f = null;
        this.var_int_d = 0;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = "\u0110\u1eb7t h\u00e0ng";
        this.var_int_h = -1;
    }

    public final int b(int n2, e e2, int n3) {
        switch (n2) {
            case 0: {
                if (this.var_y_b.var_java_lang_String_b != null && this.var_y_b.var_java_lang_String_c.length() != 0 && this.var_y_b.var_java_lang_String_c != null && this.var_y_b.var_java_lang_String_c.length() != 0 && (this.var_y_b.var_long_b == 0L || this.var_y_b.var_boolean_b && this.var_y_b.var_int_e % 2 == 0)) {
                    this.var_y_b.var_long_b = System.currentTimeMillis();
                    ++this.var_y_b.var_int_e;
                    try {
                        af.b(this.var_y_b, this.var_java_lang_String_d, this.var_java_lang_String_h, this.g, this.f, this.var_int_d);
                    }
                    catch (Exception exception) {}
                    this.b(true);
                }
                return 0;
            }
            case 1: {
                if (n3 == 0) {
                    e2.b(new Integer(this.var_y_b.var_int_a));
                    return 1;
                }
                this.var_y_b.var_int_a = (Integer)e2.java_lang_Object_b(0);
                return 0;
            }
            case 2: {
                e2.b(new Integer(this.var_int_d));
                return 1;
            }
            case 3: {
                e2.b(new Integer(this.var_y_b.var_int_c));
                return 1;
            }
            case 4: {
                if (n3 == 0) {
                    e2.b(new Integer(this.var_y_b.var_int_e));
                    return 1;
                }
                this.var_y_b.var_int_e = (Integer)e2.java_lang_Object_b(0);
                return 0;
            }
            case 5: {
                try {
                    af.b(this.var_y_b, this.var_java_lang_String_d, this.var_java_lang_String_h, this.g, this.f, this.var_int_d);
                    e2.b(new Integer(1));
                }
                catch (Exception exception) {
                    e2.b(new Integer(0));
                }
                return 0;
            }
            case 6: {
                this.var_java_lang_String_a = (String)e2.java_lang_Object_b(0);
                return 0;
            }
            case 7: {
                this.var_java_lang_String_e = (String)e2.java_lang_Object_b(0);
                return 0;
            }
            case 8: {
                this.b((String)e2.java_lang_Object_b(0));
                return 0;
            }
            case 9: {
                e2.b(w.var_java_lang_String_b);
                return 1;
            }
            case 10: {
                e2.b(w.var_java_lang_String_c);
                return 1;
            }
            case 11: {
                this.b((Boolean)e2.java_lang_Object_b(0));
                return 0;
            }
            case 12: {
                if (n3 == 0) {
                    e2.b(new Integer(af.b));
                    return 1;
                }
                af.b = (Integer)e2.java_lang_Object_b(0);
                return 0;
            }
        }
        return 0;
    }
}

