/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class v {
    private static v b;
    private ao b;

    public v() {
        b = this;
    }

    public static v b() {
        if (b == null) {
            b = new v();
        }
        return b;
    }

    private void b(ak ak2, int n2) {
        this.b = null;
        switch (n2) {
            case 0: {
                this.b = new au(ak2);
                return;
            }
            case 1: {
                this.b = new ab(ak2);
                return;
            }
            case 2: {
                this.b = new aa(ak2);
                return;
            }
            case 3: {
                this.b = new t(ak2);
            }
        }
    }

    public final void b(ak object, int n2, int n3, int n4) {
        ak.a = 69;
        n3 = n2;
        ak ak2 = object;
        object = this;
        this.b = null;
        switch (n3) {
            case 0: {
                ((v)object).b = new au(ak2);
                break;
            }
            case 1: {
                ((v)object).b = new ab(ak2);
                break;
            }
            case 2: {
                ((v)object).b = new aa(ak2);
                break;
            }
            case 3: {
                ((v)object).b = new t(ak2);
            }
        }
        this.b.b(-1, n4);
    }

    public final void b() {
        this.b.b();
    }

    public final void c() {
        this.b.c();
    }

    public final void a() {
        if (this.b.b()) {
            ak.a = -10;
            this.b = null;
        }
    }
}

