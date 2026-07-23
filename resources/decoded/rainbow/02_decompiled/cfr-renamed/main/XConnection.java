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

public final class XConnection
extends MIDlet {
    private ag var_ag_b = new ag(this, this.getAppProperty("palnum"));
    public static MIDlet var_javax_microedition_midlet_MIDlet_b;

    public XConnection() {
        var_javax_microedition_midlet_MIDlet_b = this;
        Display.getDisplay((MIDlet)this).setCurrent((Displayable)this.var_ag_b);
        this.var_ag_b.b();
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

