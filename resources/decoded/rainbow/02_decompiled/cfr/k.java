/*
 * Decompiled with CFR 0.152.
 */
import java.lang.ref.WeakReference;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class k
implements j {
    private static final int b = 4;
    private Object[] b;
    private Object[] c;
    private int[] b;
    private int c;
    private boolean b;
    private boolean c;

    private static int b(int n2) {
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
        int n2 = k.b(4);
        k2.b = new Object[n2];
        k2.c = new Object[n2];
        k2.b = new int[n2];
        k2.c = n2;
    }

    private void b(int n2) {
        n2 = k.b(n2);
        this.b = new Object[n2];
        this.c = new Object[n2];
        this.b = new int[n2];
        this.c = n2;
    }

    public k(byte by) {
        this();
    }

    private int b(Object object) {
        int n2 = this.b.length;
        return (object instanceof Integer ? ((Integer)(object = (Integer)object) == 0 ? 0 : ((Integer)object).hashCode()) : (object instanceof String ? object.hashCode() : System.identityHashCode(object))) & n2 - 1;
    }

    private static Object a(Object object) {
        if (!k.b(object)) {
            return object;
        }
        return ((WeakReference)object).get();
    }

    private static Object e(Object object) {
        if (!k.b(object)) {
            return object;
        }
        return new WeakReference<Object>(object);
    }

    private static boolean b(Object object) {
        return object != null && !(object instanceof String) && !(object instanceof Integer) && !(object instanceof Boolean) && !(object instanceof b);
    }

    private Object c(int n2) {
        Object object = this.b[n2];
        if (this.b) {
            return k.a(object);
        }
        return object;
    }

    private final void c(int n2, Object object) {
        if (this.b) {
            object = k.e(object);
        }
        this.b[n2] = object;
    }

    private Object a(int n2) {
        Object object = this.c[n2];
        if (this.c) {
            return k.a(object);
        }
        return object;
    }

    private void a(int n2, Object object) {
        if (this.c) {
            object = k.e(object);
        }
        this.c[n2] = object;
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
                if ((n2 = this.b[n2]) == -1) {
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
                if ((n2 = this.b[n2]) == -1) {
                    return -1;
                }
                object2 = this.c(n2);
            }
        }
        while (object != object2) {
            if ((n2 = this.b[n2]) == -1) {
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
                this.b[var2_3] = -1;
                return var2_3;
            }
            try {
                while (this.c(--this.c) != null) {
                }
                break;
            }
            catch (ArrayIndexOutOfBoundsException v0) {
                var2_4 = this;
                var3_5 = var2_4.b;
                var4_8 = var2_4.c;
                var2_4.b(false, false);
                var5_9 = var2_4.b;
                var6_10 = var2_4.c;
                var7_11 = var5_9.length;
                var8_13 = 0;
                var9_15 = var7_11;
                ** while (var9_15-- > 0)
            }
lbl-1000:
            // 1 sources

            {
                if (var2_4.b[var9_15] == null || var2_4.c[var9_15] == null) continue;
                ++var8_13;
                continue;
            }
lbl24:
            // 1 sources

            var8_13 = 2 * k.b(var8_13);
            var2_4.b = new Object[var8_13];
            var2_4.c = new Object[var8_13];
            var2_4.b = new int[var8_13];
            var2_4.c = var8_13;
            var9_15 = var7_11;
            while (var9_15-- > 0) {
                var7_12 = var5_9[var9_15];
                if (var7_12 == null || (var8_14 = var6_10[var9_15]) == null) continue;
                var2_4.b(var7_12, var8_14);
            }
            var2_4.b(var3_5, var4_8);
            var2_3 = this.b(var1_1);
        }
        var3_7 = this.b(var3_6);
        if (var3_7 == var2_3) {
            this.c(this.c, var1_1);
            this.b[this.c] = this.b[var2_3];
            this.b[var2_3] = this.c;
            return this.b[var2_3];
        }
        this.b[this.c] = this.b[var2_3];
        this.c[this.c] = this.c[var2_3];
        this.b[this.c] = this.b[var2_3];
        this.c(var2_3, var1_1);
        this.b[var2_3] = -1;
        var1_2 = var3_7;
        while (true) {
            if ((var3_7 = this.b[var1_2]) == var2_3) break;
            var1_2 = var3_7;
        }
        this.b[var1_2] = this.c;
        return var2_3;
    }

    private void b() {
        boolean bl = this.b;
        boolean bl2 = this.c;
        this.b(false, false);
        Object[] objectArray = this.b;
        Object[] objectArray2 = this.c;
        int n2 = objectArray.length;
        int n3 = 0;
        int n4 = n2;
        while (n4-- > 0) {
            if (this.b[n4] == null || this.c[n4] == null) continue;
            ++n3;
        }
        n3 = 2 * k.b(n3);
        this.b = new Object[n3];
        this.c = new Object[n3];
        this.b = new int[n3];
        this.c = n3;
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
        k.b(object);
        int n2 = this.b(object);
        int n3 = this.b(object, n2);
        if (n3 < 0) {
            n3 = this.c(object, n2);
        }
        Object object3 = object2;
        int n4 = n3;
        object = this;
        if (((k)object).c) {
            object3 = k.e(object3);
        }
        ((k)object).c[n4] = object3;
    }

    public final Object b(Object object) {
        k.b(object);
        int n2 = this.b(object);
        int n3 = this.b(object, n2);
        if (n3 >= 0) {
            return this.a(n3);
        }
        return null;
    }

    private static void b(Object object) {
        a.b(object != null, "table index is nil");
    }

    public final Object c(Object object) {
        int n2 = 0;
        if (object != null) {
            int n3 = this.b(object);
            n2 = 1 + this.b(object, n3);
            a.b(n2 > 0, "invalid key to 'next'");
        }
        while (n2 != this.b.length) {
            Object object2 = this.c(n2);
            if (object2 != null && this.a(n2) != null) {
                return object2;
            }
            ++n2;
        }
        return null;
    }

    public final int c() {
        int n2 = this.b.length;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = n2 + n3 + 1 >> 1;
            Integer n5 = i.b(n4);
            if (this.b(n5) == null) {
                n2 = n4 - 1;
                continue;
            }
            n3 = n4;
        }
        return n3;
    }

    private static int c(Object object) {
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
        if (bl != this.b) {
            this.b(this.b, bl);
            this.b = bl;
        }
        if (bl2 != this.c) {
            this.b(this.c, bl2);
            this.c = bl2;
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

    public final Object b(int n2) {
        return this.b(i.b(n2));
    }

    public final void b(int n2, Object object) {
        this.b((Object)i.b(n2), object);
    }
}

