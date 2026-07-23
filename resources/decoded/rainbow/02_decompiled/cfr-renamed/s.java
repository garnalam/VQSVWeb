/*
 * Decompiled with CFR 0.152.
 */
public final class s {
    public l var_l_b;
    public int var_int_b;
    public Object var_java_lang_Object_b;

    public final Object b() {
        if (this.var_l_b == null) {
            return this.var_java_lang_Object_b;
        }
        return this.var_l_b.var_java_lang_Object_arr_b[this.var_int_b];
    }

    public final void b(Object object) {
        if (this.var_l_b == null) {
            this.var_java_lang_Object_b = object;
            return;
        }
        this.var_l_b.var_java_lang_Object_arr_b[this.var_int_b] = object;
    }
}

