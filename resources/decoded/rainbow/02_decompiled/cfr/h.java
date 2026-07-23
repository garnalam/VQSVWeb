/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class h {
    public int[] b;
    public Object[] b;
    public h[] b;
    public int b;
    public boolean b;
    private String b;
    public int c;
    public int a;

    public final void b() {
        this.b = null;
        this.b = null;
        if (this.b != null) {
            int n2 = 0;
            while (n2 < this.b.length) {
                this.b[n2].b();
                ++n2;
            }
            this.b = null;
        }
        this.b = null;
    }

    public h() {
    }

    private h(DataInputStream dataInputStream, String string) {
        this.b = h.b(dataInputStream);
        if (this.b == null) {
            this.b = string;
        }
        dataInputStream.readInt();
        dataInputStream.readInt();
        this.c = dataInputStream.read();
        this.b = dataInputStream.read();
        int n2 = dataInputStream.read();
        this.b = (n2 & 2) != 0;
        this.a = dataInputStream.read();
        n2 = dataInputStream.readInt();
        this.b = new int[n2];
        int n3 = 0;
        while (n3 < n2) {
            this.b[n3] = dataInputStream.readInt();
            ++n3;
        }
        n3 = dataInputStream.readInt();
        this.b = new Object[n3];
        n2 = 0;
        while (n2 < n3) {
            Object object = null;
            int n4 = dataInputStream.read();
            switch (n4) {
                case 0: {
                    break;
                }
                case 1: {
                    object = dataInputStream.read() == 0 ? Boolean.FALSE : Boolean.TRUE;
                    break;
                }
                case 3: {
                    object = i.b(dataInputStream.readInt());
                    break;
                }
                case 4: {
                    object = h.b(dataInputStream);
                    break;
                }
                default: {
                    throw new IOException("unknown constant type: " + n4);
                }
            }
            this.b[n2] = object;
            ++n2;
        }
        n2 = dataInputStream.readInt();
        this.b = new h[n2];
        int n5 = 0;
        while (n5 < n2) {
            this.b[n5] = new h(dataInputStream, this.b);
            ++n5;
        }
        dataInputStream.readInt();
        dataInputStream.readInt();
        dataInputStream.readInt();
    }

    public final String toString() {
        return this.b;
    }

    private static String b(DataInputStream dataInputStream) {
        int n2 = dataInputStream.readShort();
        if (n2 == 0) {
            return "";
        }
        h.b(n2 < 65536, "Too long str: " + n2);
        byte[] byArray = new byte[n2];
        int n3 = 0;
        int n4 = n2;
        int n5 = 0;
        while (n5 < 100 && n4 > 0) {
            n2 = dataInputStream.read(byArray, n3, n4);
            n3 += n2;
            n4 -= n2;
            ++n5;
        }
        h.b(n4 == 0, "strload");
        return new String(byArray, "utf-8");
    }

    private static f b(DataInputStream object, j j2) {
        h.b(((FilterInputStream)object).read() == 27, "Signature 1");
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        object = new h((DataInputStream)object, null);
        return new f((h)object, j2);
    }

    private static void b(boolean bl, String string) {
        if (!bl) {
            throw new IOException("Couldn't load bytecode:" + string);
        }
    }

    public static f b(InputStream object, j j2) {
        if (!(object instanceof DataInputStream)) {
            object = new DataInputStream((InputStream)object);
        }
        h.b(((FilterInputStream)(object = (DataInputStream)object)).read() == 27, "Signature 1");
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        ((FilterInputStream)object).read();
        object = new h((DataInputStream)object, null);
        return new f((h)object, j2);
    }
}

