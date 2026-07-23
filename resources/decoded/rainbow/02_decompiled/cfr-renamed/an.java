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

public final class an {
    private RecordStore var_javax_microedition_rms_RecordStore_b;
    private static byte[] var_byte_arr_b;

    static {
        var_byte_arr_b = null;
    }

    private an(RecordStore recordStore) {
        this.var_javax_microedition_rms_RecordStore_b = recordStore;
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

    public final void void_b() {
        this.var_javax_microedition_rms_RecordStore_b.closeRecordStore();
    }

    private static void b(String string) {
        RecordStore.deleteRecordStore((String)string);
    }

    private void b(int n2, boolean bl) {
        this.var_javax_microedition_rms_RecordStore_b.setMode(n2, bl);
    }

    private static String[] java_lang_String_arr_b() {
        return RecordStore.listRecordStores();
    }

    private String java_lang_String_b() {
        return this.var_javax_microedition_rms_RecordStore_b.getName();
    }

    private static byte[] byte_arr_b() {
        Object object;
        if (var_byte_arr_b != null) {
            return var_byte_arr_b;
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
        var_byte_arr_b = byArray;
        return byArray;
    }

    private int a() {
        return this.var_javax_microedition_rms_RecordStore_b.getVersion();
    }

    public final int int_b() {
        return this.var_javax_microedition_rms_RecordStore_b.getNumRecords();
    }

    private int e() {
        return this.var_javax_microedition_rms_RecordStore_b.getSize();
    }

    public final int c() {
        return this.var_javax_microedition_rms_RecordStore_b.getSizeAvailable();
    }

    private long long_b() {
        return this.var_javax_microedition_rms_RecordStore_b.getLastModified();
    }

    private void b(RecordListener recordListener) {
        this.var_javax_microedition_rms_RecordStore_b.addRecordListener(recordListener);
    }

    private void c(RecordListener recordListener) {
        this.var_javax_microedition_rms_RecordStore_b.removeRecordListener(recordListener);
    }

    private int d() {
        return this.var_javax_microedition_rms_RecordStore_b.getNextRecordID();
    }

    public final int int_b(byte[] byArray, int n2, int n3) {
        byArray = an.byte_arr_b(byArray, 0, n3);
        return this.var_javax_microedition_rms_RecordStore_b.addRecord(byArray, 0, byArray.length);
    }

    private static byte[] byte_arr_b(byte[] byArray, int n2, int n3) {
        byte[] byArray2 = new byte[n3 + 5];
        System.arraycopy(byArray, n2, byArray2, 0, n3);
        byArray = an.byte_arr_b();
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

    private void void_b(int n2) {
        this.var_javax_microedition_rms_RecordStore_b.deleteRecord(n2);
    }

    public final int int_b(int n2) {
        n2 = this.var_javax_microedition_rms_RecordStore_b.getRecordSize(1);
        if (n2 > 5) {
            n2 -= 5;
        }
        return n2;
    }

    public final int b(int n2, byte[] byArray, int n3) {
        byte[] byArray2 = this.byte_arr_b(1);
        n3 = byArray2.length;
        if (n3 + 0 > byArray.length) {
            n3 = byArray.length;
        }
        System.arraycopy(byArray2, 0, byArray, 0, n3);
        return n3;
    }

    public final byte[] byte_arr_b(int n2) {
        byte[] byArray = this.var_javax_microedition_rms_RecordStore_b.getRecord(n2);
        if (byArray == null) {
            return null;
        }
        byte[] byArray2 = an.byte_arr_b();
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
        byArray = an.byte_arr_b(byArray, 0, n4);
        this.var_javax_microedition_rms_RecordStore_b.setRecord(n2, byArray, 0, byArray.length);
    }

    private RecordEnumeration b(RecordFilter recordFilter, RecordComparator recordComparator, boolean bl) {
        return this.var_javax_microedition_rms_RecordStore_b.enumerateRecords(recordFilter, recordComparator, bl);
    }
}

