package a.b;

import java.io.ByteArrayOutputStream;
import javax.microedition.rms.RecordStore;

public final class e {
   private String a;
   private RecordStore b;
   private int c;
   private int d = 1;

   public e(String var1, int var2) {
      this.a = var1;
      if (this.b() == 0) {
         this.b(1);
      } else {
         if (this.b() != 1) {
            this.a();
            this.b(1);
         }
      }
   }

   private void b(int var1) {
      try {
         byte[] var2 = new byte[]{0};

         for (int var3 = 0; var3 < var1; var3++) {
            int var6 = var2.length;
            byte[] var5 = var2;
            this.a(this.d, var5, 0, var6, 1);
         }
      } catch (Exception var7) {
      }
   }

   private int b() {
      this.a(this.d, null, 0, 0, 0);
      return this.c;
   }

   public final byte[] a(int var1) {
      byte[] var3;
      byte[] var2 = new byte[(var3 = this.a(1, null, 0, 0, 3)).length - 1];
      System.arraycopy(var3, 1, var2, 0, var2.length);
      this.c();
      return var2;
   }

   public final void a(ByteArrayOutputStream var1) {
      byte[] var4;
      byte[] var2 = new byte[(var4 = var1.toByteArray()).length + 1];
      System.arraycopy(var4, 0, var2, 1, var4.length);
      var2[0] = 1;
      int var3 = var2.length;
      var2 = var2;
      e var5 = this;
      this.a(var5.d, var2, 0, var3, 4);
      this.c();
   }

   private void c() {
      this.a(0, null, 0, 0, 6);
   }

   public final void a() {
      this.a(0, null, 0, 0, 7);
   }

   private byte[] a(int var1, byte[] var2, int var3, int var4, int var5) {
      try {
         if (var5 == 7 || var5 == 6) {
            if (this.b != null) {
               this.b.closeRecordStore();
               this.b = null;
            }

            if (var5 == 7) {
               RecordStore.deleteRecordStore(this.a);
            }

            return null;
         }

         if (this.b == null) {
            this.b = RecordStore.openRecordStore(this.a, true);
         }

         switch (var5) {
            case 0:
               this.c = this.b.getNumRecords();
               break;
            case 1:
               this.b.addRecord(var2, 0, var4);
               break;
            case 2:
               this.b.deleteRecord(var1);
               break;
            case 3:
               return this.b.getRecord(var1);
            case 4:
               this.b.setRecord(var1, var2, 0, var4);
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return null;
   }
}
