/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.midlet.MIDlet
 */
package main;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class XConnection
extends MIDlet {
    private ag b = new ag(this, this.getAppProperty("palnum"));
    public static MIDlet b;

    public XConnection() {
        b = this;
        Display.getDisplay((MIDlet)this).setCurrent((Displayable)this.b);
        this.b.b();
    }

    public final void startApp() {
    }

    public final void pauseApp() {
    }

    public final void destroyApp(boolean bl) {
        ag.c();
        this.notifyDestroyed();
    }
}

