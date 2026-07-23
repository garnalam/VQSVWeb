/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class l {
    public j b;
    public l b;
    public String b;
    public Vector b;
    private static int c = 1000;
    private static int a = 10;
    private static final int e = 100;
    private static final int d = 10;
    public Object[] b;
    public int b;
    private e[] b;
    private int h;
    public i b;
    private int g;
    private boolean b = "";

    private l b() {
        return new l(this.b, this.b);
    }

    public l() {
    }

    public l(i i2, j j2) {
        this.b = i2;
        this.b = j2;
        this.b = new Object[10];
        this.b = new e[10];
        this.b = new Vector();
    }

    public final e b(f f2, int n2, int n3, int n4, boolean bl, boolean bl2) {
        this.e(this.h + 1);
        e e2 = this.b();
        this.b().c = n2;
        e2.a = n3;
        e2.e = n4;
        e2.b = bl;
        e2.c = bl2;
        e2.b = f2;
        return e2;
    }

    public final void b() {
        if (this.b()) {
            throw new RuntimeException("Stack underflow");
        }
        this.e(this.h - 1);
    }

    private void b(e e2) {
        if (this.b()) {
            throw new RuntimeException("Stack underflow");
        }
        if (this.b() == e2) {
            this.e(this.h - 1);
        }
    }

    private final void a(int n2) {
        int n3;
        if (n2 > 100) {
            throw new RuntimeException("Stack overflow");
        }
        int n4 = n3 = this.b.length;
        while (n4 <= n2) {
            n4 <<= 1;
        }
        if (n4 > n3) {
            e[] eArray = new e[n4];
            System.arraycopy(this.b, 0, eArray, 0, n3);
            this.b = eArray;
        }
    }

    private void e(int n2) {
        if (n2 > this.h) {
            int n3;
            l l2 = this;
            if (n2 > 100) {
                throw new RuntimeException("Stack overflow");
            }
            int n4 = n3 = l2.b.length;
            while (n4 <= n2) {
                n4 <<= 1;
            }
            if (n4 > n3) {
                e[] eArray = new e[n4];
                System.arraycopy(l2.b, 0, eArray, 0, n3);
                l2.b = eArray;
            }
        } else {
            this.b(n2, this.h - 1);
        }
        this.h = n2;
    }

    private void b(int n2, int n3) {
        while (n2 <= n3) {
            if (this.b[n2] != null) {
                this.b[n2].b = null;
            }
            ++n2;
        }
    }

    private final void d(int n2) {
        int n3;
        if (n2 > 1000) {
            throw new RuntimeException("Stack overflow");
        }
        int n4 = n3 = this.b.length;
        while (n4 <= n2) {
            n4 <<= 1;
        }
        if (n4 > n3) {
            Object[] objectArray = new Object[n4];
            System.arraycopy(this.b, 0, objectArray, 0, n3);
            this.b = objectArray;
        }
    }

    public final void b(int n2) {
        if (this.b < n2) {
            int n3;
            l l2 = this;
            if (n2 > 1000) {
                throw new RuntimeException("Stack overflow");
            }
            int n4 = n3 = l2.b.length;
            while (n4 <= n2) {
                n4 <<= 1;
            }
            if (n4 > n3) {
                Object[] objectArray = new Object[n4];
                System.arraycopy(l2.b, 0, objectArray, 0, n3);
                l2.b = objectArray;
            }
        } else {
            this.c(n2, this.b - 1);
        }
        this.b = n2;
    }

    public final void b(int n2, int n3, int n4) {
        if (n4 > 0 && n2 != n3) {
            System.arraycopy(this.b, n2, this.b, n3, n4);
        }
    }

    private void c(int n2, int n3) {
        while (n2 <= n3) {
            this.b[n2] = null;
            ++n2;
        }
    }

    public final void c(int n2) {
        int n3 = this.b.size();
        while (--n3 >= 0) {
            s s2 = (s)this.b.elementAt(n3);
            if (s2.b < n2) {
                return;
            }
            s2.b = this.b[s2.b];
            s2.b = null;
            this.b.removeElementAt(n3);
        }
    }

    private s b(int n2) {
        s s2;
        int n3 = this.b.size();
        while (--n3 >= 0) {
            s2 = (s)this.b.elementAt(n3);
            if (s2.b == n2) {
                return s2;
            }
            if (s2.b < n2) break;
        }
        s2 = new s();
        new s().b = this;
        s2.b = n2;
        this.b.insertElementAt(s2, n3 + 1);
        return s2;
    }

    public final e b() {
        if (this.b()) {
            return null;
        }
        e e2 = this.b[this.h - 1];
        if (e2 == null) {
            this.b[this.h - 1] = e2 = new e(this);
        }
        return e2;
    }

    private int b() {
        return this.b;
    }

    public final e b(int n2) {
        a.b(n2 >= 0, "Level must be non-negative");
        n2 = this.h - n2 - 1;
        a.b(n2 >= 0, "Level too high");
        return this.b[n2];
    }

    private void c(e e2) {
        e e3;
        while ((e3 = this.b()) != null && e3 != e2) {
            this.b();
        }
    }

    public final boolean b() {
        return this.h == 0;
    }
}

