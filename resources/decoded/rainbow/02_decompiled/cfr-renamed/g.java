/*
 * Decompiled with CFR 0.152.
 */
public final class g
extends RuntimeException {
    private static final long var_long_b = 1L;
    public Object var_java_lang_Object_b;

    private g(Object object) {
        this.var_java_lang_Object_b = object;
    }

    public final String getMessage() {
        if (this.var_java_lang_Object_b == null) {
            return "nil";
        }
        return this.var_java_lang_Object_b.toString();
    }
}

