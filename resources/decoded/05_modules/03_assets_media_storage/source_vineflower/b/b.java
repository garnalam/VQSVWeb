package b;

import java.io.DataInputStream;

public final class b {
   private short a;
   private short[] b;
   private String[] c;

   public final void a(DataInputStream var1, String[] var2) {
      this.a = var1.readShort();
      byte var3 = var1.readByte();
      byte var4 = var1.readByte();
      this.b = new short[var4];

      for (int var5 = 0; var5 < var4; var5++) {
         this.b[var5] = var1.readShort();
      }

      if (var2 != null) {
         this.c = new String[var3 - var4];

         for (int var7 = 0; var7 < var3 - var4; var7++) {
            short var6 = var1.readShort();
            this.c[var7] = var2[var6];
         }
      }
   }

   public final short a() {
      return this.a;
   }

   public final short[] b() {
      return this.b;
   }

   public final String[] c() {
      return this.c;
   }
}
