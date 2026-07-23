/*
 * Decompiled with CFR 0.152.
 */
public class e {
    public l var_l_b;
    public f var_f_b;
    public int var_int_b;
    public int var_int_c;
    int var_int_a;
    public int e;
    boolean var_boolean_b;
    public boolean var_boolean_c;
    boolean var_boolean_a;

    public e(l l2) {
        this.var_l_b = l2;
    }

    public final void b(int n2, Object object) {
        this.var_l_b.var_java_lang_Object_arr_b[this.var_int_c + n2] = object;
    }

    public final Object java_lang_Object_b(int n2) {
        return this.var_l_b.var_java_lang_Object_arr_b[this.var_int_c + n2];
    }

    public final int b(Object object) {
        int n2 = this.int_b();
        this.c(n2 + 1);
        this.b(n2, object);
        return 1;
    }

    private int b(Object object, Object object2) {
        int n2 = this.int_b();
        this.c(n2 + 2);
        this.b(n2, object);
        this.b(n2 + 1, object2);
        return 2;
    }

    private int int_c() {
        return this.b(null);
    }

    public final void b(int n2, int n3, int n4) {
        this.var_l_b.b(this.var_int_c + n2, this.var_int_c + n3, n4);
    }

    public final void b(int n2, int n3) {
        while (n2 <= n3) {
            this.var_l_b.var_java_lang_Object_arr_b[this.var_int_c + n2] = null;
            ++n2;
        }
    }

    public final void void_b(int n2) {
        if (this.int_b() < n2) {
            this.c(n2);
        }
        this.b(n2, this.int_b() - 1);
    }

    public final void c(int n2) {
        this.var_l_b.void_b(this.var_int_c + n2);
    }

    public final void a(int n2) {
        this.var_l_b.c(this.var_int_c + n2);
    }

    public final s s_b(int n2) {
        s s2;
        int n3 = this.var_int_c + n2;
        l l2 = this.var_l_b;
        int n4 = l2.var_java_util_Vector_b.size();
        while (--n4 >= 0) {
            s2 = (s)l2.var_java_util_Vector_b.elementAt(n4);
            if (s2.var_int_b == n3) {
                return s2;
            }
            if (s2.var_int_b < n3) break;
        }
        s2 = new s();
        new s().var_l_b = l2;
        s2.var_int_b = n3;
        l2.var_java_util_Vector_b.insertElementAt(s2, n4 + 1);
        return s2;
    }

    public final int int_b() {
        return this.var_l_b.var_int_b - this.var_int_c;
    }

    public final void void_b() {
        if (this.boolean_c()) {
            this.var_int_b = 0;
            if (this.var_f_b.var_h_b.var_boolean_b) {
                this.var_int_c += this.e;
                this.c(this.var_f_b.var_h_b.a);
                int n2 = Math.min(this.e, this.var_f_b.var_h_b.var_int_b);
                this.b(-this.e, 0, n2);
                return;
            }
            this.c(this.var_f_b.var_h_b.a);
        }
    }

    public final void void_c() {
        if (this.boolean_c()) {
            this.c(this.var_f_b.var_h_b.a);
        }
    }

    public final void c(int n2, int n3) {
        int n4 = this.var_f_b.var_h_b.var_int_b;
        int n5 = this.e - n4;
        if (n5 < 0) {
            n5 = 0;
        }
        if (n3 == -1) {
            n3 = n5;
            this.c(n2 + n3);
        }
        if (n5 > n3) {
            n5 = n3;
        }
        this.b(-this.e + n4, n2, n5);
        if (n3 - n5 > 0) {
            this.b(n2 + n5, n2 + n3 - 1);
        }
    }

    private j j_b() {
        if (this.boolean_c()) {
            return this.var_f_b.var_j_b;
        }
        return this.var_l_b.var_j_b;
    }

    public final boolean boolean_b() {
        return !this.boolean_c();
    }

    public final boolean boolean_c() {
        return this.var_f_b != null;
    }

    e() {
    }

    private static int b(e e2) {
        e2.b(new p());
        return 1;
    }
}

