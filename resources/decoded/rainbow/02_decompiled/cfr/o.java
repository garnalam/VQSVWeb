/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;

public class o
extends r
implements d,
j {
    private Hashtable b;

    public final int b() {
        return 0;
    }

    public final void b(Object object, Object object2) {
        if (object2 != null) {
            if (this.b == null) {
                this.b = new Hashtable(4);
            }
            this.b.put(object, object2);
            return;
        }
        if (this.b != null) {
            this.b.remove(object);
        }
    }

    public final Object b(Object object) {
        if (this.b == null) {
            return null;
        }
        return this.b.get(object);
    }
}

