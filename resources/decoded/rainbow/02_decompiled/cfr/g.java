/*
 * Decompiled with CFR 0.152.
 */
/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class g
extends RuntimeException {
    private static final long b = 1L;
    public Object b;

    private g(Object object) {
        this.b = object;
    }

    public final String getMessage() {
        if (this.b == null) {
            return "nil";
        }
        return this.b.toString();
    }
}

