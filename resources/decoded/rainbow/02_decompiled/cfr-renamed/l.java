/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;

public final class l {
    public j var_j_b;
    public l var_l_b;
    public String var_java_lang_String_b = "";
    public Vector var_java_util_Vector_b;
    private static int c = 1000;
    private static int a = 10;
    private static final int e = 100;
    private static final int d = 10;
    public Object[] var_java_lang_Object_arr_b;
    public int var_int_b;
    private e[] var_e_arr_b;
    private int h;
    public i var_i_b;
    private int g;
    private boolean var_boolean_b;

    private l l_b() {
        return new l(this.var_i_b, this.var_j_b);
    }

    public l() {
    }

    public l(i i2, j j2) {
        this.var_i_b = i2;
        this.var_j_b = j2;
        this.var_java_lang_Object_arr_b = new Object[10];
        this.var_e_arr_b = new e[10];
        this.var_java_util_Vector_b = new Vector();
    }

    public final e b(f f2, int n2, int n3, int n4, boolean bl, boolean bl2) {
        this.e(this.h + 1);
        e e2 = this.e_b();
        this.e_b().var_int_c = n2;
        e2.var_int_a = n3;
        e2.e = n4;
        e2.var_boolean_b = bl;
        e2.var_boolean_c = bl2;
        e2.var_f_b = f2;
        return e2;
    }

    public final void void_b() {
        if (this.boolean_b()) {
            throw new RuntimeException("Stack underflow");
        }
        this.e(this.h - 1);
    }

    private void b(e e2) {
        if (this.boolean_b()) {
            throw new RuntimeException("Stack underflow");
        }
        if (this.e_b() == e2) {
            this.e(this.h - 1);
        }
    }

    private final void a(int n2) {
        int n3;
        if (n2 > 100) {
            throw new RuntimeException("Stack overflow");
        }
        int n4 = n3 = this.var_e_arr_b.length;
        while (n4 <= n2) {
            n4 <<= 1;
        }
        if (n4 > n3) {
            e[] eArray = new e[n4];
            System.arraycopy(this.var_e_arr_b, 0, eArray, 0, n3);
            this.var_e_arr_b = eArray;
        }
    }

    private void e(int n2) {
        if (n2 > this.h) {
            int n3;
            l l2 = this;
            if (n2 > 100) {
                throw new RuntimeException("Stack overflow");
            }
            int n4 = n3 = l2.var_e_arr_b.length;
            while (n4 <= n2) {
                n4 <<= 1;
            }
            if (n4 > n3) {
                e[] eArray = new e[n4];
                System.arraycopy(l2.var_e_arr_b, 0, eArray, 0, n3);
                l2.var_e_arr_b = eArray;
            }
        } else {
            this.b(n2, this.h - 1);
        }
        this.h = n2;
    }

    private void b(int n2, int n3) {
        while (n2 <= n3) {
            if (this.var_e_arr_b[n2] != null) {
                this.var_e_arr_b[n2].var_f_b = null;
            }
            ++n2;
        }
    }

    private final void d(int n2) {
        int n3;
        if (n2 > 1000) {
            throw new RuntimeException("Stack overflow");
        }
        int n4 = n3 = this.var_java_lang_Object_arr_b.length;
        while (n4 <= n2) {
            n4 <<= 1;
        }
        if (n4 > n3) {
            Object[] objectArray = new Object[n4];
            System.arraycopy(this.var_java_lang_Object_arr_b, 0, objectArray, 0, n3);
            this.var_java_lang_Object_arr_b = objectArray;
        }
    }

    public final void void_b(int n2) {
        if (this.var_int_b < n2) {
            int n3;
            l l2 = this;
            if (n2 > 1000) {
                throw new RuntimeException("Stack overflow");
            }
            int n4 = n3 = l2.var_java_lang_Object_arr_b.length;
            while (n4 <= n2) {
                n4 <<= 1;
            }
            if (n4 > n3) {
                Object[] objectArray = new Object[n4];
                System.arraycopy(l2.var_java_lang_Object_arr_b, 0, objectArray, 0, n3);
                l2.var_java_lang_Object_arr_b = objectArray;
            }
        } else {
            this.c(n2, this.var_int_b - 1);
        }
        this.var_int_b = n2;
    }

    public final void b(int n2, int n3, int n4) {
        if (n4 > 0 && n2 != n3) {
            System.arraycopy(this.var_java_lang_Object_arr_b, n2, this.var_java_lang_Object_arr_b, n3, n4);
        }
    }

    private void c(int n2, int n3) {
        while (n2 <= n3) {
            this.var_java_lang_Object_arr_b[n2] = null;
            ++n2;
        }
    }

    public final void c(int n2) {
        int n3 = this.var_java_util_Vector_b.size();
        while (--n3 >= 0) {
            s s2 = (s)this.var_java_util_Vector_b.elementAt(n3);
            if (s2.var_int_b < n2) {
                return;
            }
            s2.var_java_lang_Object_b = this.var_java_lang_Object_arr_b[s2.var_int_b];
            s2.var_l_b = null;
            this.var_java_util_Vector_b.removeElementAt(n3);
        }
    }

    private s s_b(int n2) {
        s s2;
        int n3 = this.var_java_util_Vector_b.size();
        while (--n3 >= 0) {
            s2 = (s)this.var_java_util_Vector_b.elementAt(n3);
            if (s2.var_int_b == n2) {
                return s2;
            }
            if (s2.var_int_b < n2) break;
        }
        s2 = new s();
        new s().var_l_b = this;
        s2.var_int_b = n2;
        this.var_java_util_Vector_b.insertElementAt(s2, n3 + 1);
        return s2;
    }

    public final e e_b() {
        if (this.boolean_b()) {
            return null;
        }
        e e2 = this.var_e_arr_b[this.h - 1];
        if (e2 == null) {
            this.var_e_arr_b[this.h - 1] = e2 = new e(this);
        }
        return e2;
    }

    private int int_b() {
        return this.var_int_b;
    }

    public final e e_b(int n2) {
        a.b(n2 >= 0, "Level must be non-negative");
        n2 = this.h - n2 - 1;
        a.b(n2 >= 0, "Level too high");
        return this.var_e_arr_b[n2];
    }

    private void c(e e2) {
        e e3;
        while ((e3 = this.e_b()) != null && e3 != e2) {
            this.void_b();
        }
    }

    public final boolean boolean_b() {
        return this.h == 0;
    }
}

