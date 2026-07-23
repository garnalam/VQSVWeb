/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.rms.RecordComparator
 *  javax.microedition.rms.RecordEnumeration
 *  javax.microedition.rms.RecordFilter
 *  javax.microedition.rms.RecordListener
 *  javax.microedition.rms.RecordStore
 */
import javax.microedition.rms.RecordComparator;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordFilter;
import javax.microedition.rms.RecordListener;
import javax.microedition.rms.RecordStore;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class an {
    private RecordStore b;
    private static byte[] b = null;

    private an(RecordStore recordStore) {
        this.b = recordStore;
    }

    public static an b(String string, boolean bl) {
        return new an(RecordStore.openRecordStore((String)string, (boolean)true));
    }

    public static an b(String string, boolean bl, int n2, boolean bl2) {
        return new an(RecordStore.openRecordStore((String)string, (boolean)true, (int)1, (boolean)true));
    }

    private static an b(String string, String string2, String string3) {
        return new an(RecordStore.openRecordStore((String)string, (String)string2, (String)string3));
    }

    public final void b() {
        this.b.closeRecordStore();
    }

    private static void b(String string) {
        RecordStore.deleteRecordStore((String)string);
    }

    private void b(int n2, boolean bl) {
        this.b.setMode(n2, bl);
    }

    private static String[] b() {
        return RecordStore.listRecordStores();
    }

    private String b() {
        return this.b.getName();
    }

    private static byte[] b() {
        Object object;
        if (b != null) {
            return b;
        }
        String[] stringArray = new String[]{"Platform", "microedition.platform", "phone.imei", "com.nokia.imei", "com.nokia.mid.imei", "com.sonyericsson.imei", "com.samsung.imei"};
        String string = "";
        int n2 = 0;
        while (n2 < stringArray.length) {
            object = System.getProperty(stringArray[n2]);
            if (object != null) {
                string = String.valueOf(string) + (String)object;
            }
            ++n2;
        }
        byte[] byArray = new byte[]{2, 2, 3, 5, 2, 7};
        object = string.getBytes();
        int n3 = 0;
        while (n3 < ((Object)object).length) {
            int n4 = 0;
            while (n4 < byArray.length) {
                int n5 = n4++;
                byArray[n5] = (byte)(byArray[n5] ^ object[n3]);
            }
            ++n3;
        }
        b = byArray;
        return byArray;
    }

    private int a() {
        return this.b.getVersion();
    }

    public final int b() {
        return this.b.getNumRecords();
    }

    private int e() {
        return this.b.getSize();
    }

    public final int c() {
        return this.b.getSizeAvailable();
    }

    private long b() {
        return this.b.getLastModified();
    }

    private void b(RecordListener recordListener) {
        this.b.addRecordListener(recordListener);
    }

    private void c(RecordListener recordListener) {
        this.b.removeRecordListener(recordListener);
    }

    private int d() {
        return this.b.getNextRecordID();
    }

    public final int b(byte[] byArray, int n2, int n3) {
        byArray = an.b(byArray, 0, n3);
        return this.b.addRecord(byArray, 0, byArray.length);
    }

    private static byte[] b(byte[] byArray, int n2, int n3) {
        byte[] byArray2 = new byte[n3 + 5];
        System.arraycopy(byArray, n2, byArray2, 0, n3);
        byArray = an.b();
        byte[] byArray3 = new byte[]{5, 2, 3, 4, 1};
        int n4 = byArray.length;
        int n5 = 0;
        while (n5 < n3) {
            int n6 = n5 % n4;
            int n7 = 0;
            while (n7 <= n6) {
                int n8 = n5;
                byArray2[n8] = (byte)(byArray2[n8] ^ byArray[n7]);
                ++n7;
            }
            int n9 = n5 % 5;
            byArray3[n9] = (byte)(byArray3[n9] ^ byArray2[n5]);
            ++n5;
        }
        System.arraycopy(byArray3, 0, byArray2, n3, 5);
        return byArray2;
    }

    private void b(int n2) {
        this.b.deleteRecord(n2);
    }

    public final int b(int n2) {
        n2 = this.b.getRecordSize(1);
        if (n2 > 5) {
            n2 -= 5;
        }
        return n2;
    }

    public final int b(int n2, byte[] byArray, int n3) {
        byte[] byArray2 = this.b(1);
        n3 = byArray2.length;
        if (n3 + 0 > byArray.length) {
            n3 = byArray.length;
        }
        System.arraycopy(byArray2, 0, byArray, 0, n3);
        return n3;
    }

    public final byte[] b(int n2) {
        byte[] byArray = this.b.getRecord(n2);
        if (byArray == null) {
            return null;
        }
        byte[] byArray2 = an.b();
        byte[] byArray3 = new byte[]{5, 2, 3, 4, 1};
        int n3 = byArray.length - 5;
        int n4 = 0;
        while (n4 < n3) {
            int n5 = n4 % 5;
            byArray3[n5] = (byte)(byArray3[n5] ^ byArray[n4]);
            ++n4;
        }
        n4 = 0;
        while (n4 < 5) {
            if (byArray[n4 + n3] != byArray3[n4]) {
                return null;
            }
            ++n4;
        }
        n4 = byArray2.length;
        int n6 = 0;
        while (n6 < n3) {
            int n7 = n6 % n4;
            int n8 = 0;
            while (n8 <= n7) {
                int n9 = n6;
                byArray[n9] = (byte)(byArray[n9] ^ byArray2[n8]);
                ++n8;
            }
            ++n6;
        }
        byte[] byArray4 = new byte[n3];
        System.arraycopy(byArray, 0, byArray4, 0, n3);
        return byArray4;
    }

    public final void b(int n2, byte[] byArray, int n3, int n4) {
        byArray = an.b(byArray, 0, n4);
        this.b.setRecord(n2, byArray, 0, byArray.length);
    }

    private RecordEnumeration b(RecordFilter recordFilter, RecordComparator recordComparator, boolean bl) {
        return this.b.enumerateRecords(recordFilter, recordComparator, bl);
    }
}

