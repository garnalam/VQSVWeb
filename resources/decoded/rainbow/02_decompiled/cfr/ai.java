/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.media.Manager
 *  javax.microedition.media.Player
 *  javax.microedition.media.control.VolumeControl
 */
import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ai {
    private static ai b;
    private Player b;
    private VolumeControl b;
    private boolean c;
    public boolean b;
    private byte c = false;
    private byte a = (byte)-1;
    private byte e = (byte)-1;
    private byte d;
    public byte b;
    private byte[] b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public ai() {
        b = this;
    }

    public static ai b() {
        if (b == null) {
            b = new ai();
        }
        return b;
    }

    public final void b(int n2) {
        this.a = (byte)n2;
    }

    public final void c(int n2) {
        this.b = (byte)n2;
    }

    private Player b(int n2, int n3) {
        String[] stringArray = new String[]{"audio/midi", "audio/x-wav"};
        try {
            if (this.b != null) {
                this.b.close();
            }
            this.b = null;
            Object object = this.getClass().getResourceAsStream("/music/" + n2 + ".mid");
            this.b = Manager.createPlayer((InputStream)object, (String)stringArray[0]);
            this.b.prefetch();
            this.b = null;
            byte by = this.b;
            object = this;
            if (((ai)object).b == null) {
                ((ai)object).b = (VolumeControl)((ai)object).b.getControl("VolumeControl");
            }
            ((ai)object).b.setLevel((int)by);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return this.b;
    }

    public final void b(boolean bl) {
        if (!this.b || this.a < 0) {
            return;
        }
        try {
            if (this.e != this.a || bl) {
                this.d = this.b[this.a];
                this.e = this.c = this.a;
                if (this.b != null) {
                    this.b.close();
                }
                this.b = null;
                this.b(this.c, 0);
            }
            this.c = true;
            return;
        }
        catch (Exception exception) {
            this.c = false;
            return;
        }
    }

    private void a() {
        try {
            this.b.start();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public final void b() {
        if (!this.b || this.c < 0) {
            return;
        }
        if (this.c) {
            if (this.d == -1 && this.b != null) {
                this.b.setLoopCount(-1);
                this.a();
                this.c = (byte)-1;
                return;
            }
            if (this.d > 0 && this.b != null && this.b.getState() != 400) {
                this.b.setLoopCount(1);
                this.a();
                this.d = (byte)(this.d - 1);
                return;
            }
            if (this.d == 0) {
                this.c = (byte)-1;
            }
        }
    }

    public final void c() {
        try {
            if (this.b != null) {
                this.b.close();
            }
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        finally {
            this.c = false;
        }
    }

    private void e(int n2) {
        if (this.b == null) {
            this.b = (VolumeControl)this.b.getControl("VolumeControl");
        }
        this.b.setLevel(n2);
    }

    public final void a(int n2) {
        this.b = (byte)(this.b + 30);
        if (this.b > 90) {
            this.b = 0;
        }
        if (this.b == 0) {
            this.b = false;
            this.c();
            return;
        }
        this.b = true;
    }
}

