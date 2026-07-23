/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class h {
    public int[] var_int_arr_b;
    public Object[] var_java_lang_Object_arr_b;
    public h[] var_h_arr_b;
    public int var_int_b;
    public boolean var_boolean_b;
    private String var_java_lang_String_b;
    public int c;
    public int a;

    public final void b() {
        this.var_int_arr_b = null;
        this.var_java_lang_Object_arr_b = null;
        if (this.var_h_arr_b != null) {
            int n2 = 0;
            while (n2 < this.var_h_arr_b.length) {
                this.var_h_arr_b[n2].b();
                ++n2;
            }
            this.var_h_arr_b = null;
        }
        this.var_java_lang_String_b = null;
    }

    public h() {
    }

    private h(DataInputStream dataInputStream, String string) {
        this.var_java_lang_String_b = h.b(dataInputStream);
        if (this.var_java_lang_String_b == null) {
            this.var_java_lang_String_b = string;
        }
        dataInputStream.readInt();
        dataInputStream.readInt();
        this.c = dataInputStream.read();
        this.var_int_b = dataInputStream.read();
        int n2 = dataInputStream.read();
        this.var_boolean_b = (n2 & 2) != 0;
        this.a = dataInputStream.read();
        n2 = dataInputStream.readInt();
        this.var_int_arr_b = new int[n2];
        int n3 = 0;
        while (n3 < n2) {
            this.var_int_arr_b[n3] = dataInputStream.readInt();
            ++n3;
        }
        n3 = dataInputStream.readInt();
        this.var_java_lang_Object_arr_b = new Object[n3];
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
                    object = i.java_lang_Integer_b(dataInputStream.readInt());
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
            this.var_java_lang_Object_arr_b[n2] = object;
            ++n2;
        }
        n2 = dataInputStream.readInt();
        this.var_h_arr_b = new h[n2];
        int n5 = 0;
        while (n5 < n2) {
            this.var_h_arr_b[n5] = new h(dataInputStream, this.var_java_lang_String_b);
            ++n5;
        }
        dataInputStream.readInt();
        dataInputStream.readInt();
        dataInputStream.readInt();
    }

    public final String toString() {
        return this.var_java_lang_String_b;
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

