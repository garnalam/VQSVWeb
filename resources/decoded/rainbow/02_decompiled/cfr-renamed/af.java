/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.rms.RecordStoreException
 *  javax.microedition.rms.RecordStoreNotOpenException
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.OutputStream;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

public final class af {
    public static int b;

    private static an an_b(String string, String string2, String string3, String charSequence, int n2) {
        an an2 = null;
        try {
            if (string3 == null || string3.length() == 0) {
                string3 = "00";
            }
            if (charSequence != null) {
                ((String)charSequence).length();
            }
            charSequence = new StringBuffer();
            ((StringBuffer)charSequence).append("dcn").append(string).append(string2).append(string3).append(n2);
            an2 = an.b(((StringBuffer)charSequence).toString(), true, 1, true);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return an2;
    }

    private static String java_lang_String_b(String string, String string2, String string3, String charSequence, int n2) {
        if (string3 == null || string3.length() == 0) {
            string3 = "00";
        }
        if (charSequence != null) {
            ((String)charSequence).length();
        }
        charSequence = new StringBuffer();
        ((StringBuffer)charSequence).append("dcn").append(string).append(string2).append(string3).append(n2);
        return ((StringBuffer)charSequence).toString();
    }

    public static y y_b(String object, String object2, String string, String object3, int n2) {
        if ((object = af.an_b((String)object, (String)object2, string, (String)object3, n2)) == null) {
            return null;
        }
        try {
            if (((an)object).int_b() == 0) {
                ((an)object).void_b();
                return null;
            }
        }
        catch (Exception exception) {
            object2 = exception;
            exception.printStackTrace();
            return null;
        }
        try {
            int n3;
            object2 = new byte[((an)object).int_b(1)];
            int n4 = ((an)object).b(1, (byte[])object2, 0);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object2, 0, n4);
            object3 = new DataInputStream(byteArrayInputStream);
            y y2 = new y();
            y2.var_int_a = n3 = ((DataInputStream)object3).readInt();
            if (n3 < n2 && ((Object)object2).length > 4) {
                b = ((DataInputStream)object3).readInt();
                if (b != 30) {
                    ((FilterInputStream)object3).close();
                    ((an)object).void_b();
                    return null;
                }
                y2.var_int_c = ((DataInputStream)object3).readInt();
                y2.var_java_lang_String_a = ((DataInputStream)object3).readUTF();
                y2.var_java_lang_String_e = ((DataInputStream)object3).readUTF();
                y2.d = ((DataInputStream)object3).readUTF();
                y2.var_int_b = ((DataInputStream)object3).readInt();
                y2.var_java_lang_String_b = ((DataInputStream)object3).readUTF();
                y2.var_java_lang_String_c = ((DataInputStream)object3).readUTF();
                y2.var_boolean_b = ((DataInputStream)object3).readBoolean();
                y2.var_int_e = ((DataInputStream)object3).readInt();
                y2.var_long_b = ((DataInputStream)object3).readLong();
            }
            byteArrayInputStream.close();
            ((FilterInputStream)object3).close();
            return y2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * Loose catch block
     */
    public static void b(y object, String object2, String object3, String object4, String string, int n2) {
        if (b != 30) {
            throw new Exception();
        }
        if ((object2 /* !! */  = af.an_b((String)object2 /* !! */ , (String)object3, (String)object4, string, n2)) != null) {
            try {
                object3 = new ByteArrayOutputStream();
                object4 = new DataOutputStream((OutputStream)object3);
                ((DataOutputStream)object4).writeInt(((y)object).var_int_a);
                if (((y)object).var_int_a < n2) {
                    ((DataOutputStream)object4).writeInt(b);
                    ((DataOutputStream)object4).writeInt(((y)object).var_int_c);
                    ((DataOutputStream)object4).writeUTF(((y)object).var_java_lang_String_a);
                    ((DataOutputStream)object4).writeUTF(((y)object).var_java_lang_String_e);
                    ((DataOutputStream)object4).writeUTF(((y)object).d);
                    ((DataOutputStream)object4).writeInt(((y)object).var_int_b);
                    ((DataOutputStream)object4).writeUTF(((y)object).var_java_lang_String_b);
                    ((DataOutputStream)object4).writeUTF(((y)object).var_java_lang_String_c);
                    ((DataOutputStream)object4).writeBoolean(((y)object).var_boolean_b);
                    ((DataOutputStream)object4).writeInt(((y)object).var_int_e);
                    ((DataOutputStream)object4).writeLong(((y)object).var_long_b);
                }
                object = ((ByteArrayOutputStream)object3).toByteArray();
                if (((an)object2 /* !! */ ).int_b() == 0) {
                    ((an)object2 /* !! */ ).int_b((byte[])object, 0, ((Object)object).length);
                } else {
                    ((an)object2 /* !! */ ).b(1, (byte[])object, 0, ((Object)object).length);
                }
            }
            catch (Exception exception) {
                try {
                    ((an)object2 /* !! */ ).void_b();
                    try {
                        ((an)object2 /* !! */ ).void_b();
                        return;
                    }
                    catch (RecordStoreNotOpenException recordStoreNotOpenException) {
                        object2 /* !! */  = recordStoreNotOpenException;
                        recordStoreNotOpenException.printStackTrace();
                        return;
                    }
                    catch (RecordStoreException recordStoreException) {
                        object2 /* !! */  = recordStoreException;
                        recordStoreException.printStackTrace();
                        return;
                    }
                }
                catch (RecordStoreNotOpenException recordStoreNotOpenException) {
                    object4 = recordStoreNotOpenException;
                    recordStoreNotOpenException.printStackTrace();
                    try {
                        ((an)object2 /* !! */ ).void_b();
                        return;
                    }
                    catch (RecordStoreNotOpenException recordStoreNotOpenException2) {
                        object2 /* !! */  = recordStoreNotOpenException2;
                        recordStoreNotOpenException2.printStackTrace();
                        return;
                    }
                    catch (RecordStoreException recordStoreException) {
                        object2 /* !! */  = recordStoreException;
                        recordStoreException.printStackTrace();
                        return;
                    }
                }
                catch (RecordStoreException recordStoreException) {
                    object4 = recordStoreException;
                    recordStoreException.printStackTrace();
                    try {
                        ((an)object2 /* !! */ ).void_b();
                        return;
                    }
                    catch (RecordStoreNotOpenException recordStoreNotOpenException) {
                        object2 /* !! */  = recordStoreNotOpenException;
                        recordStoreNotOpenException.printStackTrace();
                        return;
                    }
                    catch (RecordStoreException recordStoreException2) {
                        object2 /* !! */  = recordStoreException2;
                        recordStoreException2.printStackTrace();
                        return;
                    }
                    {
                        catch (Throwable throwable) {
                            try {
                                ((an)object2 /* !! */ ).void_b();
                            }
                            catch (RecordStoreNotOpenException recordStoreNotOpenException) {
                                object2 /* !! */  = recordStoreNotOpenException;
                                recordStoreNotOpenException.printStackTrace();
                            }
                            catch (RecordStoreException recordStoreException3) {
                                object2 /* !! */  = recordStoreException3;
                                recordStoreException3.printStackTrace();
                            }
                            throw throwable;
                        }
                    }
                }
            }
            try {
                ((an)object2 /* !! */ ).void_b();
                return;
            }
            catch (RecordStoreNotOpenException recordStoreNotOpenException) {
                object2 /* !! */  = recordStoreNotOpenException;
                recordStoreNotOpenException.printStackTrace();
                return;
            }
            catch (RecordStoreException recordStoreException) {
                object2 /* !! */  = recordStoreException;
                recordStoreException.printStackTrace();
            }
        }
    }
}

