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

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ap
extends Canvas
implements Runnable {
    private static int b = 240;
    private static int c = 320;
    private int[][] b;
    private static final String[] b = new String[]{"Nokia", "Motorokr", "Motorola", "SonyEricsson", "Samsung", "j2me", "SunMicrosystems_wtk", "MX6", "MotoA668"};
    private String b;
    private y b;
    private String c;
    private MIDlet b;
    private Displayable b;
    private int a;
    private int e;
    private String a;
    private String e;
    private String d;
    private String h;
    private String g;
    private String f;
    private int d;
    private String i;
    private String j;
    private String k;
    private String l;
    public ar b = null;
    private int h;

    public ap(MIDlet object, Displayable displayable, String string, String string2, String string3, String string4, int n2, String string5, String string6, String string7) {
        this.c = null;
        this.b = null;
        this.a = 0;
        this.e = 0;
        this.a = "G\u1eedi tin";
        this.e = "Quay l\u1ea1i";
        this.d = null;
        this.h = null;
        this.g = null;
        this.f = null;
        this.d = 0;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = "Mua s\u1eafm";
        this.b = null;
        this.h = -1;
        this.setFullScreenMode(true);
        try {
            this.b = object;
            this.b = displayable;
            this.d = string;
            this.h = string2;
            if (string3 == null || string3.length() == 0) {
                string3 = "00";
            }
            string4 = "000";
            this.g = string3;
            this.f = string4;
            this.d = n2;
            this.i = string5;
            this.j = string6;
            this.k = string7;
            this.b((MIDlet)object);
            b = this.getWidth();
            c = this.getHeight();
            this.b();
            object = this;
            this.a = "G\u1eedi tin";
            ((ap)object).e = "Quay l\u1ea1i";
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public final void sizeChanged(int n2, int n3) {
        super.sizeChanged(n2, n3);
        b = this.getWidth();
        c = this.getHeight();
        this.b();
    }

    private void b() {
        int n2 = Font.getFont((int)0, (int)1, (int)0).getHeight() + 4;
        int n3 = t.b("G\u1eedi tin") + 4;
        this.b[0][0] = 2;
        this.b[0][1] = c - n2;
        this.b[0][2] = n3;
        this.b[0][3] = c;
        this.b[1][0] = b - n3;
        this.b[1][1] = c - n2;
        this.b[1][2] = b;
        this.b[1][3] = c;
        this.b[2][0] = b / 2 - (n3 <<= 1);
        this.b[2][1] = c - n2;
        this.b[2][2] = b / 2;
        this.b[2][3] = c;
        this.b[3][0] = b / 2;
        this.b[3][1] = c - n2;
        this.b[3][2] = b / 2 + n3;
        this.b[3][3] = c;
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
            while (n2 < b.length) {
                object = b[n2].toLowerCase();
                if (string.length() >= ((String)object).length() && string.startsWith((String)object)) break;
                ++n2;
            }
            this.b = object;
        }
    }

    private void c() {
        Serializable serializable;
        this.a = "G\u1eedi tin";
        this.e = "Quay l\u1ea1i";
        ap ap2 = this;
        this.b = af.b(ap2.d, ap2.h, ap2.g, ap2.f, ap2.d);
        if (ap2.b != null && ap2.b.b) {
            serializable = Calendar.getInstance();
            ((Calendar)serializable).set(11, 0);
            ((Calendar)serializable).set(12, 0);
            ((Calendar)serializable).set(13, 0);
            ((Calendar)serializable).set(14, 0);
            if (((Calendar)serializable).getTime().getTime() > ap2.b.b) {
                ap2.b.b = 0L;
                if (ap2.b != null && ap2.b.e % 2 != 0) {
                    --ap2.b.e;
                }
            }
        }
        try {
            if (ap2.b == null || ap2.b != null && ap2.b.a >= ap2.d) {
                ap2.b = x.b(ap2.d, ap2.h, ap2.g, ap2.f, ap2.d);
            }
        }
        catch (Exception exception) {
            serializable = exception;
            exception.printStackTrace();
            ap2.a = "";
            ap2.b(((Throwable)serializable).toString());
            return;
        }
        ap2.e();
    }

    private void a() {
        Serializable serializable;
        this.b = af.b(this.d, this.h, this.g, this.f, this.d);
        if (this.b != null && this.b.b) {
            serializable = Calendar.getInstance();
            ((Calendar)serializable).set(11, 0);
            ((Calendar)serializable).set(12, 0);
            ((Calendar)serializable).set(13, 0);
            ((Calendar)serializable).set(14, 0);
            if (((Calendar)serializable).getTime().getTime() > this.b.b) {
                this.b.b = 0L;
                if (this.b != null && this.b.e % 2 != 0) {
                    --this.b.e;
                }
            }
        }
        try {
            if (this.b == null || this.b != null && this.b.a >= this.d) {
                this.b = x.b(this.d, this.h, this.g, this.f, this.d);
            }
        }
        catch (Exception exception) {
            serializable = exception;
            exception.printStackTrace();
            this.a = "";
            this.b(((Throwable)serializable).toString());
            return;
        }
        this.e();
    }

    private void e() {
        if (this.b.e == 0) {
            ap ap2 = this;
            if (ap2.b != null) {
                ap2.b(ap2.j);
            }
            return;
        }
        this.b(false);
    }

    private void d() {
        if (this.b == null) {
            return;
        }
        this.b(this.j);
    }

    /*
     * WARNING - void declaration
     */
    private void b(boolean bl) {
        void var1_7;
        if (this.b.b) {
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
            if ((charSequence = this.b.a).startsWith("10658008")) {
                String string = "10658008";
            }
            if (this.b.e % 2 == 0) {
                int n2 = this.b.b << 1;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("B\u1ea1n \u0111\u00e3 g\u1eedi \u0111i" + this.b.e / 2 + "S\u1ed1 \u0111i\u1ec7n tho\u1ea1i thu ph\u00ed SMS, c\u00f2n c\u1ea7n g\u1eedi \u0111i" + (n2 - this.b.e) / 2 + "S\u1ed1 \u0111i\u1ec7n tho\u1ea1i thu ph\u00ed SMS");
                stringBuffer.append(". \n").append(this.b.d);
                this.b(stringBuffer.toString());
                return;
            }
            this.b("Theo y\u00eau c\u1ea7u m\u1ed9t l\u1ea7n n\u1eefa c\u1ee7a ng\u01b0\u1eddi d\u00f9ng \u0111\u01b0\u1ee3c ch\u1ea5p nh\u1eadn" + (String)var1_4 + "G\u1eedi tin nh\u1eafn \u0111\u1ec3 x\u00e1c nh\u1eadn mua s\u1eafm" + this.i + ", Tin nh\u1eafn: " + this.b.c + " tin" + this.k);
            return;
        }
        int n3 = this.b.b;
        if (this.b.c != null && this.b.c.length() != 0) {
            ++var1_7;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("B\u1ea1n \u0111\u00e3 g\u1eedi \u0111i" + this.b.e + " tin, c\u00f2n c\u1ea7n g\u1eedi " + (int)(var1_7 - this.b.e) + "SMS");
        if (this.b.c != null && this.b.c.length() != 0) {
            stringBuffer.append(", C\u00e1c tin nh\u1eafn SMS \u0111\u1ea7u ti\u00ean mi\u1ec5n ph\u00ed \u0111\u01b0\u1ee3c s\u1eed d\u1ee5ng \u0111\u1ec3 nh\u1eadn th\u00f4ng tin v\u1ec1 tr\u00f2 ch\u01a1i");
        }
        stringBuffer.append(". \n").append(this.b.d);
        this.b(stringBuffer.toString());
    }

    private void h() {
        new Thread(this).start();
    }

    public final void run() {
        w.b(XConnection.b);
        w.b(this.b.b());
        i i2 = new i();
        Object object = i2;
        object = i2.b.b;
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
            object = h.b(inputStream, ((i)object).b.b);
            inputStream.close();
            i2.b(object, (Object)null);
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    private static boolean b() {
        return false;
    }

    private static int b() {
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
        this.a = 0;
        this.c = string;
        this.repaint();
    }

    private void g() {
        if (this.b != null) {
            this.b.b(this.b.a >= this.d);
        }
    }

    private int b(int n2) {
        if ("Motorola".equals(this.b)) {
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
        if (!"Motorola".equals(var1_2.b)) ** GOTO lbl-1000
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
        return n2 > this.b[n4][0] && n2 < this.b[n4][2] && n3 > this.b[n4][1] && n3 < this.b[n4][3];
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
            if (this.h == 0 || this.h == 1) {
                this.f();
                return;
            }
        } else if (this.b(n2, n3, 3) && (this.h == 0 || this.h == 2)) {
            this.i();
        }
    }

    public final void keyRepeated(int n2) {
        super.keyRepeated(n2);
        this.keyPressed(n2);
    }

    private void f() {
        --this.a;
        if (this.a <= 0) {
            this.a = 0;
        }
        this.repaint();
    }

    private void i() {
        if (this.e > 0) {
            ++this.a;
        }
        this.repaint();
    }

    private void j() {
        if ("G\u1eedi tin".equals(this.a) && this.b.b > 0) {
            this.a = "";
            this.e = "";
            ap ap2 = this;
            new Thread(ap2).start();
            return;
        }
        if ("X\u00e1c nh\u1eadn".equals(this.a)) {
            this.a = "G\u1eedi tin";
            this.e = "Quay l\u1ea1i";
            this.e();
        }
    }

    private void k() {
        if ("Quay l\u1ea1i".equals(this.e)) {
            if (this.b.a < this.d) {
                this.a = "X\u00e1c nh\u1eadn";
                this.e = "Tr\u1edf v\u1ec1";
                this.b("B\u1ea1n v\u1eabn ch\u01b0a ho\u00e0n t\u1ea5t thanh to\u00e1n, vui l\u00f2ng ho\u00e0n t\u1ea5t thanh to\u00e1n.");
                return;
            }
            this.g();
            Display.getDisplay((MIDlet)this.b).setCurrent(this.b);
            return;
        }
        if ("Tr\u1edf v\u1ec1".equals(this.e)) {
            this.g();
            Display.getDisplay((MIDlet)this.b).setCurrent(this.b);
        }
    }

    public final void paint(Graphics graphics) {
        Font.getDefaultFont();
        Font font = Font.getFont((int)0, (int)1, (int)0);
        graphics.setColor(4423868);
        graphics.fillRect(0, 0, b, c);
        graphics.setColor(255, 102, 0);
        graphics.fillRect(0, 0, b, 30);
        graphics.setColor(0xFFFFFF);
        int n2 = (30 - font.getHeight()) / 2;
        graphics.drawString(this.l, 2, n2, 0);
        graphics.setFont(font);
        int n3 = font.getHeight() + 8;
        int[] nArray = t.b(graphics, this.c, font, b - 10, c - n3 - 10, this.a, 5, 35, 5);
        this.e = nArray[1];
        graphics.setColor(255, 102, 0);
        int n4 = c - n3;
        graphics.fillRect(0, n4, b, n3);
        graphics.setColor(0xFFFFFF);
        n4 = c - (n3 + font.getHeight()) / 2;
        graphics.drawString(this.a, 2, n4, 0);
        int n5 = b - t.b(this.e) - 2 - 2;
        graphics.drawString(this.e, n5, n4, 0);
        n5 = c - n3 / 2;
        this.h = -1;
        if (this.a > 0 && this.e > 0) {
            this.h = 0;
            n4 = n5 + 5;
            graphics.fillTriangle(b / 2 - 10 - 3, n4, b / 2 - 10 + 3, n4, b / 2 - 10, n4 - 11);
            graphics.fillTriangle(b / 2 + 10 - 3, n5 -= 5, b / 2 + 10 + 3, n5, b / 2 + 10, n5 + 11);
            return;
        }
        if (this.a > 0) {
            this.h = 1;
            graphics.fillTriangle(b / 2 - 10 - 3, n5 += 5, b / 2 - 10 + 3, n5, b / 2 - 10, n5 - 11);
            return;
        }
        if (this.e > 0) {
            this.h = 2;
            graphics.fillTriangle(b / 2 + 10 - 3, n5 -= 5, b / 2 + 10 + 3, n5, b / 2 + 10, n5 + 11);
        }
    }

    public ap() {
        this.b = new y();
        this.c = null;
        this.b = null;
        this.a = 0;
        this.e = 0;
        this.a = "G\u1eedi tin";
        this.e = "Quay l\u1ea1i";
        this.d = null;
        this.h = null;
        this.g = null;
        this.f = null;
        this.d = 0;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = "\u0110\u1eb7t h\u00e0ng";
        this.h = -1;
    }

    public final int b(int n2, e e2, int n3) {
        switch (n2) {
            case 0: {
                if (this.b.b != null && this.b.c.length() != 0 && this.b.c != null && this.b.c.length() != 0 && (this.b.b == 0L || this.b.b && this.b.e % 2 == 0)) {
                    this.b.b = System.currentTimeMillis();
                    ++this.b.e;
                    try {
                        af.b(this.b, this.d, this.h, this.g, this.f, this.d);
                    }
                    catch (Exception exception) {}
                    this.b(true);
                }
                return 0;
            }
            case 1: {
                if (n3 == 0) {
                    e2.b(new Integer(this.b.a));
                    return 1;
                }
                this.b.a = (Integer)e2.b(0);
                return 0;
            }
            case 2: {
                e2.b(new Integer(this.d));
                return 1;
            }
            case 3: {
                e2.b(new Integer(this.b.c));
                return 1;
            }
            case 4: {
                if (n3 == 0) {
                    e2.b(new Integer(this.b.e));
                    return 1;
                }
                this.b.e = (Integer)e2.b(0);
                return 0;
            }
            case 5: {
                try {
                    af.b(this.b, this.d, this.h, this.g, this.f, this.d);
                    e2.b(new Integer(1));
                }
                catch (Exception exception) {
                    e2.b(new Integer(0));
                }
                return 0;
            }
            case 6: {
                this.a = (String)e2.b(0);
                return 0;
            }
            case 7: {
                this.e = (String)e2.b(0);
                return 0;
            }
            case 8: {
                this.b((String)e2.b(0));
                return 0;
            }
            case 9: {
                e2.b(w.b);
                return 1;
            }
            case 10: {
                e2.b(w.c);
                return 1;
            }
            case 11: {
                this.b((Boolean)e2.b(0));
                return 0;
            }
            case 12: {
                if (n3 == 0) {
                    e2.b(new Integer(af.b));
                    return 1;
                }
                af.b = (Integer)e2.b(0);
                return 0;
            }
        }
        return 0;
    }
}

