/*
 * Decompiled with CFR 0.152.
 */
import java.io.PrintStream;
import java.util.Random;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class i {
    private static int b = 50;
    private static int c = 0;
    private static int a = 1;
    private static int e = 2;
    private static int d = 3;
    private static int h = 4;
    private static int g = 5;
    private static int f = 6;
    private static int i = 7;
    private static int j = 8;
    private static int k = 9;
    private static int l = 10;
    private static int m = 11;
    private static int n = 12;
    private static int p = 13;
    private static int o = 14;
    private static int q = 15;
    private static int s = 16;
    private static int r = 17;
    private static int t = 18;
    private static int u = 19;
    private static int v = 20;
    private static int w = 21;
    private static int x = 22;
    private static int y = 23;
    private static int z = 24;
    private static int B = 25;
    private static int A = 26;
    private static int C = 27;
    private static int D = 28;
    private static int F = 29;
    private static int G = 30;
    private static int H = 31;
    private static int I = 32;
    private static int E = 33;
    private static int J = 34;
    private static int K = 35;
    private static int L = 36;
    private static int M = 37;
    private static int N = 38;
    public l b;
    private Random b;
    public PrintStream b;

    private i(PrintStream printStream) {
        this(printStream, 0);
    }

    public i() {
        this(System.out, 0);
    }

    private i(PrintStream object, byte by) {
        new Random();
        this.b = object;
        object = this;
        this.b = new l((i)object, new k(0));
        ((i)object).b.b.b("_G", (Object)((i)object).b.b);
        a.b((i)object);
    }

    private void b() {
        this.b = new l(this, new k(0));
        this.b.b.b("_G", (Object)this.b.b);
        a.b(this);
    }

    public final int b(l l2, int n2) {
        return this.a(l2, n2);
    }

    private int a(l l2, int n2) {
        int n3 = l2.b - n2 - 1;
        Object object = l2.b[n3];
        if (object == null) {
            throw new RuntimeException("call nil");
        }
        if (object instanceof b) {
            return i.b(l2, (b)object, n3 + 1, n3, n2);
        }
        if (!(object instanceof f)) {
            throw new RuntimeException("call a non-func");
        }
        l2.b((f)object, n3 + 1, n3, n2, false, false).b();
        this.b(l2);
        n2 = l2.b - n3;
        l2.b = "";
        return n2;
    }

    private static int b(l l2, b b2, int n2, int n3, int n4) {
        int n5 = 0;
        e e2 = l2.b(null, n2, n3, n4, false, false);
        l2.b();
        try {
            n5 = b2.b(e2, n4);
        }
        catch (ClassCastException classCastException) {
            classCastException.printStackTrace();
            System.out.println("func");
        }
        int n6 = 0;
        n6 = e2.b() - n5;
        e2.b(n6, -1, n5);
        e2.c(n5 - 1);
        return n5;
    }

    private final void b(l l2) {
        e e2 = l2.b();
        f f2 = e2.b;
        h h2 = f2.b;
        int[] nArray = h2.b;
        int n2 = e2.a;
        while (true) {
            try {
                while (true) {
                    int n3 = nArray[e2.b++];
                    int n4 = n3 & 0x3F;
                    int n5 = n3 >>> 6 & 0xFF;
                    switch (n4) {
                        case 0: {
                            int n6 = n3 >>> 23 & 0x1FF;
                            e2.b(n5, e2.b(n6));
                            break;
                        }
                        case 1: {
                            int n7 = n3 >>> 14;
                            e2.b(n5, h2.b[n7]);
                            break;
                        }
                        case 2: {
                            int n8 = n3 >>> 23 & 0x1FF;
                            n3 = n3 >>> 14 & 0x1FF;
                            e2.b(n5, (Object)(n8 == 0 ? Boolean.FALSE : Boolean.TRUE));
                            if (n3 == 0) break;
                            ++e2.b;
                            break;
                        }
                        case 3: {
                            int n9 = n3 >>> 23 & 0x1FF;
                            e2.b(n5, n9);
                            break;
                        }
                        case 4: {
                            int n10 = n3 >>> 23 & 0x1FF;
                            e2.b(n5, f2.b[n10].b());
                            break;
                        }
                        case 5: {
                            int n11 = n3 >>> 14;
                            e2.b(n5, i.c(f2.b, h2.b[n11]));
                            break;
                        }
                        case 6: {
                            int n12 = n3 >>> 23 & 0x1FF;
                            n3 = n3 >>> 14 & 0x1FF;
                            Object object = e2.b(n12);
                            Object object2 = i.b(e2, n3, h2);
                            e2.b(n5, i.c(object, object2));
                            break;
                        }
                        case 7: {
                            int n13 = n3 >>> 14;
                            Object object = e2.b(n5);
                            Object object3 = h2.b[n13];
                            i.b(f2.b, object3, object);
                            break;
                        }
                        case 8: {
                            int n14 = n3 >>> 23 & 0x1FF;
                            f2.b[n14].b(e2.b(n5));
                            break;
                        }
                        case 9: {
                            int n15 = n3 >>> 23 & 0x1FF;
                            n3 = n3 >>> 14 & 0x1FF;
                            Object object = e2.b(n5);
                            Object object4 = i.b(e2, n15, h2);
                            Object object5 = i.b(e2, n3, h2);
                            i.b(object, object4, object5);
                            break;
                        }
                        case 10: {
                            k k2 = new k(0);
                            e2.b(n5, (Object)k2);
                            break;
                        }
                        case 11: {
                            int n16 = n3 >>> 23 & 0x1FF;
                            n3 = n3 >>> 14 & 0x1FF;
                            Object object = i.b(e2, n3, h2);
                            Object object6 = e2.b(n16);
                            Object object7 = i.c(object6, object);
                            e2.b(n5, object7);
                            e2.b(n5 + 1, object6);
                            break;
                        }
                        case 12: 
                        case 13: 
                        case 14: 
                        case 15: 
                        case 16: 
                        case 17: {
                            int n17 = n3 >>> 23 & 0x1FF;
                            n3 = n3 >>> 14 & 0x1FF;
                            Object object = i.b(e2, n17, h2);
                            Object object8 = i.b(e2, n3, h2);
                            Integer n18 = null;
                            Integer n19 = null;
                            Integer n20 = a.b(object);
                            if (n20 != null && (n18 = a.b(object8)) != null) {
                                n19 = i.b(n20, n18, n4);
                            }
                            e2.b(n5, (Object)n19);
                            break;
                        }
                        case 19: {
                            int n21 = n3 >>> 23 & 0x1FF;
                            Object object = e2.b(n21);
                            e2.b(n5, (Object)i.b(!i.b(object)));
                            break;
                        }
                        case 20: {
                            int n22 = n3 >>> 23 & 0x1FF;
                            Object object = e2.b(n22);
                            Integer n23 = object instanceof j ? i.b(((j)object).c()) : (object instanceof String ? i.b(((String)object).length()) : null);
                            e2.b(n5, (Object)n23);
                            break;
                        }
                        case 21: {
                            int n24 = n3 >>> 23 & 0x1FF;
                            n3 = n3 >>> 14 & 0x1FF;
                            int n25 = n24;
                            int n26 = n3;
                            Object object = e2.b(n26);
                            --n26;
                            while (n25 <= n26) {
                                String string = a.b(object);
                                if (object != null) {
                                    n3 = 0;
                                    n24 = n26;
                                    while (n25 <= n24) {
                                        Object object9 = e2.b(n24);
                                        --n24;
                                        if (a.b(object9) == null) break;
                                        ++n3;
                                    }
                                    if (n3 > 0) {
                                        StringBuffer stringBuffer = new StringBuffer();
                                        n24 = n26 - n3 + 1;
                                        while (n24 <= n26) {
                                            stringBuffer.append(a.b(e2.b(n24)));
                                            ++n24;
                                        }
                                        stringBuffer.append(string);
                                        object = stringBuffer.toString();
                                        n26 -= n3;
                                    }
                                }
                                if (n25 > n26) continue;
                                e2.b(n26);
                                --n26;
                            }
                            e2.b(n5, object);
                            break;
                        }
                        case 22: {
                            e2.b += i.b(n3);
                            break;
                        }
                        case 23: 
                        case 24: 
                        case 25: {
                            int n27 = n3 >>> 23 & 0x1FF;
                            n3 = n3 >>> 14 & 0x1FF;
                            Object object = i.b(e2, n27, h2);
                            Object object10 = i.b(e2, n3, h2);
                            if (object instanceof Integer && object10 instanceof Integer) {
                                int n28 = i.b(object);
                                int n29 = i.b(object10);
                                if (n4 == 23) {
                                    if (n28 == n29 != (n5 == 0)) break;
                                    ++e2.b;
                                    break;
                                }
                                if (n4 == 24) {
                                    if (n28 < n29 != (n5 == 0)) break;
                                    ++e2.b;
                                    break;
                                }
                                if (n28 <= n29 != (n5 == 0)) break;
                                ++e2.b;
                                break;
                            }
                            if (object instanceof String && object10 instanceof String) {
                                if (n4 == 23) {
                                    if (object.equals(object10) != (n5 == 0)) break;
                                    ++e2.b;
                                    break;
                                }
                                String string = (String)object;
                                String string2 = (String)object10;
                                n3 = string.compareTo(string2);
                                if (n4 == 24) {
                                    if (n3 < 0 != (n5 == 0)) break;
                                    ++e2.b;
                                    break;
                                }
                                if (n3 <= 0 != (n5 == 0)) break;
                                ++e2.b;
                                break;
                            }
                            boolean bl = false;
                            if (object == object10) {
                                bl = true;
                            } else if (n4 == 23) {
                                bl = i.b(object, object10);
                            } else {
                                a.b(String.valueOf(String.valueOf(n4)) + " not defined for operand");
                            }
                            if (bl != (n5 == 0)) break;
                            ++e2.b;
                            break;
                        }
                        case 26: {
                            n3 = n3 >>> 14 & 0x1FF;
                            if (i.b(e2.b(n5)) != (n3 == 0)) break;
                            ++e2.b;
                            break;
                        }
                        case 27: {
                            int n30 = n3 >>> 23 & 0x1FF;
                            n3 = n3 >>> 14 & 0x1FF;
                            Object object = e2.b(n30);
                            if (i.b(object) != (n3 == 0)) {
                                e2.b(n5, object);
                                break;
                            }
                            ++e2.b;
                            break;
                        }
                        case 28: {
                            int n31 = n3 >>> 23 & 0x1FF;
                            n3 = n3 >>> 14 & 0x1FF;
                            int n32 = n31 - 1;
                            if (n32 != -1) {
                                e2.c(n5 + n32 + 1);
                            } else {
                                n32 = e2.b() - n5 - 1;
                            }
                            e2.a = n3 != 0;
                            int n33 = e2.c;
                            int n34 = n33 + n5;
                            int n35 = n34 + 1;
                            Object object = e2.b(n5);
                            if (object == null) {
                                a.b(object != null, "call nil");
                            }
                            if (object instanceof f) {
                                e e3 = l2.b((f)object, n35, n34, n32, true, e2.c);
                                e3.b();
                                e2 = e3;
                                f2 = e3.b;
                                h2 = f2.b;
                                nArray = h2.b;
                                n2 = e2.a;
                                break;
                            }
                            if (object instanceof b) {
                                i.b(l2, (b)object, n33 + n5 + 1, n33 + n5, n32);
                                e2 = l2.b();
                                if (e2.b()) {
                                    return;
                                }
                                if (e2.b != null) {
                                    f2 = e2.b;
                                    h2 = f2.b;
                                    nArray = h2.b;
                                    n2 = e2.a;
                                }
                                if (!e2.a) break;
                                e2.c(h2.a);
                                break;
                            }
                            throw new RuntimeException("Call non-func: " + object);
                        }
                        case 29: {
                            int n36 = e2.c;
                            l2.c(n36);
                            int n37 = (n3 >>> 23 & 0x1FF) - 1;
                            if (n37 == -1) {
                                n37 = e2.b() - n5 - 1;
                            }
                            e2.a = false;
                            Object object = e2.b(n5);
                            if (object == null) {
                                a.b(object != null, "Tried to call nil");
                            }
                            int n38 = n2 + 1;
                            l2.b(n36 + n5, n2, n37 + 1);
                            l2.b(n2 + n37 + 1);
                            if (object instanceof f) {
                                e2.c = n38;
                                e2.e = n37;
                                e2.b = (f)object;
                                e2.b();
                            } else {
                                if (!(object instanceof b)) {
                                    a.b("Tried to call a non-function: " + object);
                                }
                                l l3 = l2;
                                i.b(l2, (b)object, n38, n2, n37);
                                e2 = l2.b();
                                l3.b();
                                if (l3 != l2) {
                                    if (l3.b() && l2.b == l3) {
                                        l2.b = l3.b;
                                        l3.b = null;
                                        l2.b.b().b(Boolean.TRUE);
                                    }
                                    if ((e2 = l2.b()).b()) {
                                        return;
                                    }
                                } else {
                                    if (!e2.b) {
                                        return;
                                    }
                                    e2 = l2.b();
                                    if (e2.a) {
                                        e2.c(e2.b.b.a);
                                    }
                                }
                            }
                            f2 = e2.b;
                            h2 = f2.b;
                            nArray = h2.b;
                            n2 = e2.a;
                            break;
                        }
                        case 30: {
                            int n39 = (n3 >>> 23 & 0x1FF) - 1;
                            int n40 = e2.c;
                            l2.c(n40);
                            if (n39 == -1) {
                                n39 = e2.b() - n5;
                            }
                            l2.b(e2.c + n5, n2, n39);
                            l2.b(n2 + n39);
                            if (e2.b) {
                                l2.b();
                                e2 = l2.b();
                                if (e2.b != null) {
                                    f2 = e2.b;
                                    h2 = f2.b;
                                    nArray = h2.b;
                                    n2 = e2.a;
                                }
                                if (!e2.a) break;
                                e2.c(h2.a);
                                break;
                            }
                            l2.b();
                            return;
                        }
                        case 32: {
                            int n41 = i.b(n3);
                            int n42 = i.b(e2.b(n5));
                            int n43 = i.b(e2.b(n5 + 2));
                            e2.b(n5, (Object)i.b(n42 - n43));
                            e2.b += n41;
                            break;
                        }
                        case 31: {
                            int n44 = i.b(e2.b(n5));
                            int n45 = i.b(e2.b(n5 + 1));
                            int n46 = i.b(e2.b(n5 + 2));
                            Integer n47 = i.b(n44 += n46);
                            e2.b(n5, (Object)n47);
                            if (n46 > 0 ? n44 <= n45 : n44 >= n45) {
                                int n48 = i.b(n3);
                                e2.b += n48;
                                e2.b(n5 + 3, (Object)n47);
                                break;
                            }
                            e2.b(n5);
                            break;
                        }
                        case 33: {
                            n3 = n3 >>> 14 & 0x1FF;
                            e2.c(n5 + 6);
                            e2.b(n5, n5 + 3, 3);
                            this.b(l2, 2);
                            e2.b(n5 + 3 + n3);
                            e2.c();
                            Object object = e2.b(n5 + 3);
                            if (object != null) {
                                e2.b(n5 + 2, object);
                                break;
                            }
                            ++e2.b;
                            break;
                        }
                        case 34: {
                            int n49 = n3 >>> 23 & 0x1FF;
                            n3 = n3 >>> 14 & 0x1FF;
                            if (n49 == 0) {
                                n49 = e2.b() - n5 - 1;
                            }
                            if (n3 == 0) {
                                n3 = nArray[e2.b++];
                            }
                            int n50 = (n3 - 1) * 50;
                            j j2 = (j)e2.b(n5);
                            int n51 = 1;
                            while (n51 <= n49) {
                                Integer n52 = i.b(n50 + n51);
                                Object object = e2.b(n5 + n51);
                                j2.b(n52, object);
                                ++n51;
                            }
                            break;
                        }
                        case 35: {
                            e2.a(n5);
                            break;
                        }
                        case 36: {
                            int n53 = n3 >>> 14;
                            h h3 = h2.b[n53];
                            f f3 = new f(h3, f2.b);
                            e2.b(n5, (Object)f3);
                            int n54 = h3.c;
                            int n55 = 0;
                            while (n55 < n54) {
                                n3 = nArray[e2.b++];
                                n4 = n3 & 0x3F;
                                n53 = n3 >>> 23 & 0x1FF;
                                switch (n4) {
                                    case 0: {
                                        f3.b[n55] = e2.b(n53);
                                        break;
                                    }
                                    case 4: {
                                        f3.b[n55] = f2.b[n53];
                                    }
                                }
                                ++n55;
                            }
                            break;
                        }
                        case 37: {
                            int n56 = (n3 >>> 23 & 0x1FF) - 1;
                            e2.c(n5, n56);
                        }
                    }
                }
            }
            catch (RuntimeException runtimeException) {
                RuntimeException runtimeException2 = runtimeException;
                runtimeException.printStackTrace();
                while (!l2.b().c()) {
                    l2.b();
                }
                boolean bl = true;
                do {
                    if ((e2 = l2.b()) == null) {
                        l l4 = l2.b;
                        if (l4 == null) break;
                        l2.b = null;
                        e e4 = l4.b();
                        e4.b(Boolean.FALSE);
                        e4.b(runtimeException2.getMessage());
                        e4.b(l2.b);
                        l2.b.b = l4;
                        l2 = l4;
                        e2 = l2.b();
                        f2 = e2.b;
                        h2 = f2.b;
                        nArray = h2.b;
                        n2 = e2.a;
                        bl = false;
                        break;
                    }
                    l2.b();
                } while (e2.b);
                if (e2 == null) continue;
                e2.a(0);
                if (!bl) continue;
                throw runtimeException2;
            }
            break;
        }
    }

    private static final Object b(e e2, int n2, h h2) {
        int n3 = n2 - 256;
        if (n3 < 0) {
            return e2.b(n2);
        }
        return h2.b[n3];
    }

    private static final int b(int n2) {
        return (n2 >>> 14) - 131071;
    }

    private static final Integer b(Integer n2, Integer n3, int n4) {
        int n5 = n2;
        int n6 = n3;
        int n7 = 0;
        switch (n4) {
            case 12: {
                n7 = n5 + n6;
                break;
            }
            case 13: {
                n7 = n5 - n6;
                break;
            }
            case 14: {
                n7 = n5 * n6;
                break;
            }
            case 15: {
                n7 = n5 / n6;
                break;
            }
            case 16: {
                n7 = n5 % n6;
            }
        }
        return i.b(n7);
    }

    public final Object b(Object object, Object object2) {
        int n2 = this.b.b;
        this.b.b(n2 + 1 + 3);
        object2 = this.b.b;
        this.b.b[n2] = object;
        object2[n2 + 1] = null;
        object2[n2 + 2] = null;
        object2[n2 + 3] = null;
        object = this.b;
        int n3 = this.a((l)object, 3);
        object2 = null;
        if (n3 > 0) {
            object2 = this.b.b[n2];
        }
        this.b.b(n2);
        return object2;
    }

    private Object b(Object object, Object[] objectArray) {
        int n2 = this.b.b;
        int n3 = objectArray == null ? 0 : objectArray.length;
        this.b.b(n2 + 1 + n3);
        this.b.b[n2] = object;
        int n4 = 1;
        while (n4 <= n3) {
            this.b.b[n2 + n4] = objectArray[n4 - 1];
            ++n4;
        }
        int n5 = n3;
        l l2 = this.b;
        int n6 = this.a(l2, n5);
        Object object2 = null;
        if (n6 > 0) {
            object2 = this.b.b[n2];
        }
        this.b.b(n2);
        return object2;
    }

    public static final Object c(Object object, Object object2) {
        int n2;
        Object object3;
        if (!(object instanceof j)) {
            if (object instanceof String && object2 instanceof Integer) {
                int n3 = (Integer)object2;
                return ((String)object).substring(n3 - 1, n3);
            }
            return null;
        }
        if (object2 instanceof Integer && (object3 = ((j)object).b(n2 = ((Integer)object2).intValue())) != null) {
            return object3;
        }
        return ((j)object).b(object2);
    }

    private static void b(Object object, Object object2, Object object3) {
        try {
            ((j)object).b(object2, object3);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(object2);
            System.out.println(object3);
            System.out.println(object);
            return;
        }
    }

    public final Object[] b(Object object, Object[] objectArray) {
        int n2 = objectArray == null ? 0 : objectArray.length;
        l l2 = this.b;
        l2 = new l(l2.b, l2.b);
        int n3 = l2.b;
        l2.b(n3 + 1 + n2);
        l2.b[n3] = object;
        if (n2 > 0) {
            System.arraycopy(objectArray, 0, l2.b, n3 + 1, n2);
        }
        int n4 = this.c(l2, n2);
        a.b(true, "Thread changed in pcall");
        objectArray = new Object[n4];
        System.arraycopy(l2.b, n3, objectArray, 0, n4);
        l2.b(n3);
        return objectArray;
    }

    private Object[] b(Object object) {
        return this.b(object, null);
    }

    public final int c(l object, int n2) {
        e e2;
        Throwable throwable;
        Object object2;
        l l2 = object;
        Object object3 = l2.b();
        l2.b = "";
        int n3 = l2.b - n2 - 1;
        try {
            int n4 = this.a((l)object, n2);
            int n5 = n3 + n4 + 1;
            l2.b(n5);
            l2.b(n3, n3 + 1, n4);
            l2.b[n3] = Boolean.TRUE;
            return n4 + 1;
        }
        catch (g g2) {
            object2 = g2;
            throwable = g2;
            object = ((g)object2).b;
            ((Throwable)object2).printStackTrace();
        }
        catch (Throwable throwable2) {
            object2 = throwable2;
            throwable = throwable2;
            object = ((Throwable)object2).getMessage();
            ((Throwable)object2).printStackTrace();
        }
        a.b(true, "Thread changed in pcall");
        if (object3 != null) {
            ((e)object3).a(0);
        }
        object2 = object3;
        object3 = l2;
        while ((e2 = ((l)object3).b()) != null && e2 != object2) {
            ((l)object3).b();
        }
        if (object instanceof String) {
            object = (String)object;
        }
        l2.b(n3 + 4);
        l2.b[n3] = Boolean.FALSE;
        l2.b[n3 + 1] = object;
        l2.b[n3 + 2] = l2.b;
        l2.b[n3 + 3] = throwable;
        l2.b = "";
        return 4;
    }

    public final j b() {
        return this.b.b;
    }

    public static boolean b(Object object, Object object2) {
        if (object == null || object2 == null) {
            return object == object2;
        }
        if (object instanceof Integer && object2 instanceof Integer) {
            object = (Integer)object;
            object2 = (Integer)object2;
            return ((Integer)object).intValue() == ((Integer)object2).intValue();
        }
        if (object instanceof Boolean && object2 instanceof Boolean) {
            return object.equals(object2);
        }
        return object == object2;
    }

    private static double b(Object object) {
        return ((Double)object).intValue();
    }

    private static int b(Object object) {
        return (Integer)object;
    }

    public static Integer b(int n2) {
        return new Integer(n2);
    }

    private static Double b(double d2) {
        return new Double(d2);
    }

    private static Integer b(long l2) {
        return i.b((int)l2);
    }

    private static Double b(long l2) {
        return new Double(l2);
    }

    private static boolean b(Object object) {
        return !Boolean.FALSE.equals(object);
    }

    private static Boolean b(boolean bl) {
        if (bl) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static void c() {
    }

    private static void a() {
    }
}

