/*
 * Decompiled with CFR 0.152.
 */
import java.lang.ref.WeakReference;

public final class k
implements j {
    private static final int var_int_b = 4;
    private Object[] var_java_lang_Object_arr_b;
    private Object[] var_java_lang_Object_arr_c;
    private int[] var_int_arr_b;
    private int var_int_c;
    private boolean var_boolean_b;
    private boolean var_boolean_c;

    private static int int_b(int n2) {
        if (n2 < 4) {
            return 4;
        }
        --n2;
        n2 |= n2 >> 1;
        n2 |= n2 >> 2;
        n2 |= n2 >> 4;
        n2 |= n2 >> 8;
        return (n2 | n2 >> 16) + 1;
    }

    private k() {
        k k2 = this;
        int n2 = k.int_b(4);
        k2.var_java_lang_Object_arr_b = new Object[n2];
        k2.var_java_lang_Object_arr_c = new Object[n2];
        k2.var_int_arr_b = new int[n2];
        k2.var_int_c = n2;
    }

    private void void_b(int n2) {
        n2 = k.int_b(n2);
        this.var_java_lang_Object_arr_b = new Object[n2];
        this.var_java_lang_Object_arr_c = new Object[n2];
        this.var_int_arr_b = new int[n2];
        this.var_int_c = n2;
    }

    public k(byte by) {
        this();
    }

    private int int_b(Object object) {
        int n2 = this.var_java_lang_Object_arr_b.length;
        return (object instanceof Integer ? ((Integer)(object = (Integer)object) == 0 ? 0 : ((Integer)object).hashCode()) : (object instanceof String ? object.hashCode() : System.identityHashCode(object))) & n2 - 1;
    }

    private static Object a(Object object) {
        if (!k.boolean_b(object)) {
            return object;
        }
        return ((WeakReference)object).get();
    }

    private static Object e(Object object) {
        if (!k.boolean_b(object)) {
            return object;
        }
        return new WeakReference<Object>(object);
    }

    private static boolean boolean_b(Object object) {
        return object != null && !(object instanceof String) && !(object instanceof Integer) && !(object instanceof Boolean) && !(object instanceof b);
    }

    private Object c(int n2) {
        Object object = this.var_java_lang_Object_arr_b[n2];
        if (this.var_boolean_b) {
            return k.a(object);
        }
        return object;
    }

    private final void c(int n2, Object object) {
        if (this.var_boolean_b) {
            object = k.e(object);
        }
        this.var_java_lang_Object_arr_b[n2] = object;
    }

    private Object a(int n2) {
        Object object = this.var_java_lang_Object_arr_c[n2];
        if (this.var_boolean_c) {
            return k.a(object);
        }
        return object;
    }

    private void a(int n2, Object object) {
        if (this.var_boolean_c) {
            object = k.e(object);
        }
        this.var_java_lang_Object_arr_c[n2] = object;
    }

    private int b(Object object, int n2) {
        Object object2 = this.c(n2);
        if (object2 == null) {
            return -1;
        }
        if (object instanceof Integer) {
            int n3 = (Integer)object;
            while (true) {
                int n4;
                if (object2 instanceof Integer && n3 == (n4 = ((Integer)object2).intValue())) {
                    return n2;
                }
                if ((n2 = this.var_int_arr_b[n2]) == -1) {
                    return -1;
                }
                object2 = this.c(n2);
            }
        }
        if (object instanceof String) {
            while (true) {
                if (object.equals(object2)) {
                    return n2;
                }
                if ((n2 = this.var_int_arr_b[n2]) == -1) {
                    return -1;
                }
                object2 = this.c(n2);
            }
        }
        while (object != object2) {
            if ((n2 = this.var_int_arr_b[n2]) == -1) {
                return -1;
            }
            object2 = this.c(n2);
        }
        return n2;
    }

    /*
     * Unable to fully structure code
     */
    private int c(Object var1_1, int var2_3) {
        while (true) {
            if ((var3_6 = this.c(var2_3)) == null) {
                this.c(var2_3, var1_1);
                this.var_int_arr_b[var2_3] = -1;
                return var2_3;
            }
            try {
                while (this.c(--this.var_int_c) != null) {
                }
                break;
            }
            catch (ArrayIndexOutOfBoundsException v0) {
                var2_4 = this;
                var3_5 = var2_4.var_boolean_b;
                var4_8 = var2_4.var_boolean_c;
                var2_4.b(false, false);
                var5_9 = var2_4.var_java_lang_Object_arr_b;
                var6_10 = var2_4.var_java_lang_Object_arr_c;
                var7_11 = var5_9.length;
                var8_13 = 0;
                var9_15 = var7_11;
                ** while (var9_15-- > 0)
            }
lbl-1000:
            // 1 sources

            {
                if (var2_4.var_java_lang_Object_arr_b[var9_15] == null || var2_4.var_java_lang_Object_arr_c[var9_15] == null) continue;
                ++var8_13;
                continue;
            }
lbl24:
            // 1 sources

            var8_13 = 2 * k.int_b(var8_13);
            var2_4.var_java_lang_Object_arr_b = new Object[var8_13];
            var2_4.var_java_lang_Object_arr_c = new Object[var8_13];
            var2_4.var_int_arr_b = new int[var8_13];
            var2_4.var_int_c = var8_13;
            var9_15 = var7_11;
            while (var9_15-- > 0) {
                var7_12 = var5_9[var9_15];
                if (var7_12 == null || (var8_14 = var6_10[var9_15]) == null) continue;
                var2_4.b(var7_12, var8_14);
            }
            var2_4.b(var3_5, var4_8);
            var2_3 = this.int_b(var1_1);
        }
        var3_7 = this.int_b(var3_6);
        if (var3_7 == var2_3) {
            this.c(this.var_int_c, var1_1);
            this.var_int_arr_b[this.var_int_c] = this.var_int_arr_b[var2_3];
            this.var_int_arr_b[var2_3] = this.var_int_c;
            return this.var_int_arr_b[var2_3];
        }
        this.var_java_lang_Object_arr_b[this.var_int_c] = this.var_java_lang_Object_arr_b[var2_3];
        this.var_java_lang_Object_arr_c[this.var_int_c] = this.var_java_lang_Object_arr_c[var2_3];
        this.var_int_arr_b[this.var_int_c] = this.var_int_arr_b[var2_3];
        this.c(var2_3, var1_1);
        this.var_int_arr_b[var2_3] = -1;
        var1_2 = var3_7;
        while (true) {
            if ((var3_7 = this.var_int_arr_b[var1_2]) == var2_3) break;
            var1_2 = var3_7;
        }
        this.var_int_arr_b[var1_2] = this.var_int_c;
        return var2_3;
    }

    private void b() {
        boolean bl = this.var_boolean_b;
        boolean bl2 = this.var_boolean_c;
        this.b(false, false);
        Object[] objectArray = this.var_java_lang_Object_arr_b;
        Object[] objectArray2 = this.var_java_lang_Object_arr_c;
        int n2 = objectArray.length;
        int n3 = 0;
        int n4 = n2;
        while (n4-- > 0) {
            if (this.var_java_lang_Object_arr_b[n4] == null || this.var_java_lang_Object_arr_c[n4] == null) continue;
            ++n3;
        }
        n3 = 2 * k.int_b(n3);
        this.var_java_lang_Object_arr_b = new Object[n3];
        this.var_java_lang_Object_arr_c = new Object[n3];
        this.var_int_arr_b = new int[n3];
        this.var_int_c = n3;
        n4 = n2;
        while (n4-- > 0) {
            Object object;
            Object object2 = objectArray[n4];
            if (object2 == null || (object = objectArray2[n4]) == null) continue;
            this.b(object2, object);
        }
        this.b(bl, bl2);
    }

    public final void b(Object object, Object object2) {
        k.void_b(object);
        int n2 = this.int_b(object);
        int n3 = this.b(object, n2);
        if (n3 < 0) {
            n3 = this.c(object, n2);
        }
        Object object3 = object2;
        int n4 = n3;
        object = this;
        if (((k)object).var_boolean_c) {
            object3 = k.e(object3);
        }
        ((k)object).var_java_lang_Object_arr_c[n4] = object3;
    }

    public final Object java_lang_Object_b(Object object) {
        k.void_b(object);
        int n2 = this.int_b(object);
        int n3 = this.b(object, n2);
        if (n3 >= 0) {
            return this.a(n3);
        }
        return null;
    }

    private static void void_b(Object object) {
        a.b(object != null, "table index is nil");
    }

    public final Object java_lang_Object_c(Object object) {
        int n2 = 0;
        if (object != null) {
            int n3 = this.int_b(object);
            n2 = 1 + this.b(object, n3);
            a.b(n2 > 0, "invalid key to 'next'");
        }
        while (n2 != this.var_java_lang_Object_arr_b.length) {
            Object object2 = this.c(n2);
            if (object2 != null && this.a(n2) != null) {
                return object2;
            }
            ++n2;
        }
        return null;
    }

    public final int c() {
        int n2 = this.var_java_lang_Object_arr_b.length;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = n2 + n3 + 1 >> 1;
            Integer n5 = i.java_lang_Integer_b(n4);
            if (this.java_lang_Object_b(n5) == null) {
                n2 = n4 - 1;
                continue;
            }
            n3 = n4;
        }
        return n3;
    }

    private static int int_c(Object object) {
        if (object instanceof Integer) {
            if ((Integer)(object = (Integer)object) == 0) {
                return 0;
            }
            return ((Integer)object).hashCode();
        }
        if (object instanceof String) {
            return object.hashCode();
        }
        return System.identityHashCode(object);
    }

    public final void b(boolean bl, boolean bl2) {
        if (bl != this.var_boolean_b) {
            this.b(this.var_java_lang_Object_arr_b, bl);
            this.var_boolean_b = bl;
        }
        if (bl2 != this.var_boolean_c) {
            this.b(this.var_java_lang_Object_arr_c, bl2);
            this.var_boolean_c = bl2;
        }
    }

    private void b(Object[] objectArray, boolean bl) {
        int n2 = objectArray.length - 1;
        while (n2 >= 0) {
            Object object = objectArray[n2];
            objectArray[n2] = bl ? k.e(object) : k.a(object);
            --n2;
        }
    }

    public final Object java_lang_Object_b(int n2) {
        return this.java_lang_Object_b(i.java_lang_Integer_b(n2));
    }

    public final void b(int n2, Object object) {
        this.b((Object)i.java_lang_Integer_b(n2), object);
    }
}

