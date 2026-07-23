package c;

import javax.microedition.lcdui.Graphics;

public final class g {
   private a.b.g b = null;
   private byte c = 0;
   private short d = -1;
   public byte a = 4;

   public final void a(int var1, boolean var2, byte var3) {
      if (var1 != -1) {
         this.b = new a.b.g();
         this.b.a(var1, var2);
         switch (this.a) {
            case 3:
               this.b.a((byte)this.d, var3, true);
         }
      }
   }

   public final void a(byte var1, byte var2) {
      this.d = var1;
      this.b.a(var1, var2, true);
   }

   public final a.b.g a() {
      return this.b;
   }

   public final void a(int var1) {
      this.d = (short)var1;
   }

   public final void a(byte var1) {
      this.c = 1;
   }

   public g() {
      this.b = null;
      this.d = -1;
      this.a = 4;
   }

   public final void a(Graphics var1, k var2, int var3) {
      if (this.b != null) {
         boolean var4 = false;
         g var7 = this;
         k var10000;
         if (this.d == -1) {
            var10000 = null;
         } else {
            int[] var5 = new int[4];
            switch (var7.a) {
               case 2:
                  var5 = var7.b.b(var7.d, (byte)0);
                  break;
               case 3:
                  var5 = var7.b.a(var7.d, (byte)0);
            }

            var10000 = new k(var5[0], var5[1], var5[2], var5[3]);
         }

         k var8 = var10000;
         if (var10000 == null) {
            return;
         }

         int var9 = var2.a;
         int var6 = var2.b;
         switch (var3) {
            case 0:
               var9 = var2.a - var8.a;
               var6 = var2.b - var8.b;
               break;
            case 1:
               var9 = var2.a + (var2.c - var8.c) / 2 - var8.a;
               var6 = var2.b - var8.b;
               break;
            case 2:
               var9 = var2.a + (var2.c - var8.c) - var8.a;
               var6 = var2.b - var8.b;
               break;
            case 3:
               var9 = var2.a - var8.a;
               var6 = var2.b + (var2.d - var8.d) / 2 - var8.b;
               break;
            case 4:
               var9 = var2.a + (var2.c - var8.c) / 2 - var8.a;
               var6 = var2.b + (var2.d - var8.d) / 2 - var8.b;
               break;
            case 5:
               var9 = var2.a + (var2.c - var8.c) - var8.a;
               var6 = var2.b + (var2.d - var8.d) / 2 - var8.b;
               break;
            case 6:
               var9 = var2.a - var8.a;
               var6 = var2.b + (var2.d - var8.d) - var8.b;
               break;
            case 7:
               var9 = var2.a + (var2.c - var8.c) / 2 - var8.a;
               var6 = var2.b + (var2.d - var8.d) - var8.b;
               break;
            case 8:
               var9 = var2.a + (var2.c - var8.c) - var8.a;
               var6 = var2.b + (var2.d - var8.d) - var8.b;
         }

         if (this.a == 3) {
            this.b.a(var1, var9, var6, this.c);
            return;
         }

         if (this.a == 2) {
            this.b.a(var1, this.d, var9, var6, (byte)0, 20);
         }
      }
   }

   public final void b() {
      if (this.a == 3) {
         this.b.e();
      }
   }

   public final void c() {
      if (this.b != null) {
         this.b.b();
         this.b = null;
      }
   }
}
