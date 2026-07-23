/*
 * Decompiled with CFR 0.152.
 */
public final class v {
    private static v var_v_b;
    private ao var_ao_b;

    public v() {
        var_v_b = this;
    }

    public static v v_b() {
        if (var_v_b == null) {
            var_v_b = new v();
        }
        return var_v_b;
    }

    private void b(ak ak2, int n2) {
        this.var_ao_b = null;
        switch (n2) {
            case 0: {
                this.var_ao_b = new au(ak2);
                return;
            }
            case 1: {
                this.var_ao_b = new ab(ak2);
                return;
            }
            case 2: {
                this.var_ao_b = new aa(ak2);
                return;
            }
            case 3: {
                this.var_ao_b = new t(ak2);
            }
        }
    }

    public final void b(ak object, int n2, int n3, int n4) {
        ak.var_int_a = 69;
        n3 = n2;
        ak ak2 = object;
        object = this;
        this.var_ao_b = null;
        switch (n3) {
            case 0: {
                ((v)object).var_ao_b = new au(ak2);
                break;
            }
            case 1: {
                ((v)object).var_ao_b = new ab(ak2);
                break;
            }
            case 2: {
                ((v)object).var_ao_b = new aa(ak2);
                break;
            }
            case 3: {
                ((v)object).var_ao_b = new t(ak2);
            }
        }
        this.var_ao_b.void_b(-1, n4);
    }

    public final void void_b() {
        this.var_ao_b.void_b();
    }

    public final void c() {
        this.var_ao_b.c();
    }

    public final void a() {
        if (this.var_ao_b.boolean_b()) {
            ak.var_int_a = -10;
            this.var_ao_b = null;
        }
    }
}

