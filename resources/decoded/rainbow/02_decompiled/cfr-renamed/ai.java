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

public final class ai {
    private static ai var_ai_b;
    private Player var_javax_microedition_media_Player_b;
    private VolumeControl var_javax_microedition_media_control_VolumeControl_b;
    private boolean var_boolean_c = false;
    public boolean var_boolean_b = false;
    private byte var_byte_c;
    private byte a = (byte)-1;
    private byte e = (byte)-1;
    private byte d;
    public byte var_byte_b = (byte)30;
    private byte[] var_byte_arr_b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public ai() {
        var_ai_b = this;
    }

    public static ai ai_b() {
        if (var_ai_b == null) {
            var_ai_b = new ai();
        }
        return var_ai_b;
    }

    public final void b(int n2) {
        this.a = (byte)n2;
    }

    public final void c(int n2) {
        this.var_byte_b = (byte)n2;
    }

    private Player b(int n2, int n3) {
        String[] stringArray = new String[]{"audio/midi", "audio/x-wav"};
        try {
            if (this.var_javax_microedition_media_Player_b != null) {
                this.var_javax_microedition_media_Player_b.close();
            }
            this.var_javax_microedition_media_Player_b = null;
            Object object = this.getClass().getResourceAsStream("/music/" + n2 + ".mid");
            this.var_javax_microedition_media_Player_b = Manager.createPlayer((InputStream)object, (String)stringArray[0]);
            this.var_javax_microedition_media_Player_b.prefetch();
            this.var_javax_microedition_media_control_VolumeControl_b = null;
            byte by = this.var_byte_b;
            object = this;
            if (((ai)object).var_javax_microedition_media_control_VolumeControl_b == null) {
                ((ai)object).var_javax_microedition_media_control_VolumeControl_b = (VolumeControl)((ai)object).var_javax_microedition_media_Player_b.getControl("VolumeControl");
            }
            ((ai)object).var_javax_microedition_media_control_VolumeControl_b.setLevel((int)by);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return this.var_javax_microedition_media_Player_b;
    }

    public final void b(boolean bl) {
        if (!this.var_boolean_b || this.a < 0) {
            return;
        }
        try {
            if (this.e != this.a || bl) {
                this.d = this.var_byte_arr_b[this.a];
                this.e = this.var_byte_c = this.a;
                if (this.var_javax_microedition_media_Player_b != null) {
                    this.var_javax_microedition_media_Player_b.close();
                }
                this.var_javax_microedition_media_Player_b = null;
                this.b(this.var_byte_c, 0);
            }
            this.var_boolean_c = true;
            return;
        }
        catch (Exception exception) {
            this.var_boolean_c = false;
            return;
        }
    }

    private void a() {
        try {
            this.var_javax_microedition_media_Player_b.start();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public final void void_b() {
        if (!this.var_boolean_b || this.var_byte_c < 0) {
            return;
        }
        if (this.var_boolean_c) {
            if (this.d == -1 && this.var_javax_microedition_media_Player_b != null) {
                this.var_javax_microedition_media_Player_b.setLoopCount(-1);
                this.a();
                this.var_byte_c = (byte)-1;
                return;
            }
            if (this.d > 0 && this.var_javax_microedition_media_Player_b != null && this.var_javax_microedition_media_Player_b.getState() != 400) {
                this.var_javax_microedition_media_Player_b.setLoopCount(1);
                this.a();
                this.d = (byte)(this.d - 1);
                return;
            }
            if (this.d == 0) {
                this.var_byte_c = (byte)-1;
            }
        }
    }

    public final void c() {
        try {
            if (this.var_javax_microedition_media_Player_b != null) {
                this.var_javax_microedition_media_Player_b.close();
            }
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        finally {
            this.var_boolean_c = false;
        }
    }

    private void e(int n2) {
        if (this.var_javax_microedition_media_control_VolumeControl_b == null) {
            this.var_javax_microedition_media_control_VolumeControl_b = (VolumeControl)this.var_javax_microedition_media_Player_b.getControl("VolumeControl");
        }
        this.var_javax_microedition_media_control_VolumeControl_b.setLevel(n2);
    }

    public final void a(int n2) {
        this.var_byte_b = (byte)(this.var_byte_b + 30);
        if (this.var_byte_b > 90) {
            this.var_byte_b = 0;
        }
        if (this.var_byte_b == 0) {
            this.var_boolean_b = false;
            this.c();
            return;
        }
        this.var_boolean_b = true;
    }
}

