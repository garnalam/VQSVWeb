/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class e {
    public l b;
    public f b;
    public int b;
    public int c;
    int a;
    public int e;
    boolean b;
    public boolean c;
    boolean a;

    public e(l l2) {
        this.b = l2;
    }

    public final void b(int n2, Object object) {
        this.b.b[this.c + n2] = object;
    }

    public final Object b(int n2) {
        return this.b.b[this.c + n2];
    }

    public final int b(Object object) {
        int n2 = this.b();
        this.c(n2 + 1);
        this.b(n2, object);
        return 1;
    }

    private int b(Object object, Object object2) {
        int n2 = this.b();
        this.c(n2 + 2);
        this.b(n2, object);
        this.b(n2 + 1, object2);
        return 2;
    }

    private int c() {
        return this.b(null);
    }

    public final void b(int n2, int n3, int n4) {
        this.b.b(this.c + n2, this.c + n3, n4);
    }

    public final void b(int n2, int n3) {
        while (n2 <= n3) {
            this.b.b[this.c + n2] = null;
            ++n2;
        }
    }

    public final void b(int n2) {
        if (this.b() < n2) {
            this.c(n2);
        }
        this.b(n2, this.b() - 1);
    }

    public final void c(int n2) {
        this.b.b(this.c + n2);
    }

    public final void a(int n2) {
        this.b.c(this.c + n2);
    }

    public final s b(int n2) {
        s s2;
        int n3 = this.c + n2;
        l l2 = this.b;
        int n4 = l2.b.size();
        while (--n4 >= 0) {
            s2 = (s)l2.b.elementAt(n4);
            if (s2.b == n3) {
                return s2;
            }
            if (s2.b < n3) break;
        }
        s2 = new s();
        new s().b = l2;
        s2.b = n3;
        l2.b.insertElementAt(s2, n4 + 1);
        return s2;
    }

    public final int b() {
        return this.b.b - this.c;
    }

    public final void b() {
        if (this.c()) {
            this.b = 0;
            if (this.b.b.b) {
                this.c += this.e;
                this.c(this.b.b.a);
                int n2 = Math.min(this.e, this.b.b.b);
                this.b(-this.e, 0, n2);
                return;
            }
            this.c(this.b.b.a);
        }
    }

    public final void c() {
        if (this.c()) {
            this.c(this.b.b.a);
        }
    }

    public final void c(int n2, int n3) {
        int n4 = this.b.b.b;
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

    private j b() {
        if (this.c()) {
            return this.b.b;
        }
        return this.b.b;
    }

    public final boolean b() {
        return !this.c();
    }

    public final boolean c() {
        return this.b != null;
    }

    e() {
    }

    private static int b(e e2) {
        e2.b(new p());
        return 1;
    }
}

