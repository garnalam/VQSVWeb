package c;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class l {
   public int a;
   public int[] b;
   public int[][][] c;
   public int d;
   private k[] p;
   public int e;
   public int f;
   public boolean g;
   public int h = 0;
   public int i = 0;
   public int j;
   public int k = 0;
   public int l = 10;
   public int m = 2;
   private int q = -1;
   public int[][] n = null;
   private int r = -1;
   private Vector s = new Vector();
   public Vector o = new Vector();

   public l(int var1) {
      this.a = 0;
      this.b = null;
      this.b = a.e.c(50);
      this.d = 0;
      this.p = new k[20];
      this.e = 0;
      this.f = 0;
      this.g = true;
      this.j = var1;
      this.q = -1;
   }

   public final void a(int var1, f var2) {
      if (this.a <= 1) {
         this.f = 0;
         this.e = 0;
      } else {
         if (this.g) {
            if (this.h == 0) {
               this.f += var1;
               if (this.f >= this.a) {
                  this.f = this.f % this.a;
                  if (this.f >= this.e + this.d || this.f < this.e) {
                     this.e = this.f;
                  }

                  this.a(var2);
                  return;
               }

               if (this.f >= this.e + this.d) {
                  this.e += var1;
                  if (this.e + this.d >= this.a) {
                     this.e = this.a - this.d;
                  }

                  this.a(var2);
                  return;
               }
            } else if (this.h == 1) {
               this.f += var1;
               if (this.f >= this.a) {
                  this.f = this.f % this.a;
               }

               this.e = this.f - this.i < 0 ? this.a + (this.f - this.i) : this.f - this.i;
               this.a(var2);
               return;
            }
         } else {
            this.f += var1;
            if (this.f >= this.a) {
               this.f = this.a - 1;
               if (this.a >= this.d) {
                  this.e = this.a - this.d;
               }

               this.a(var2);
               return;
            }

            if (this.f >= this.e + this.d) {
               this.e += var1;
               this.a(var2);
            }
         }
      }
   }

   public final void b(int var1, f var2) {
      if (this.a <= 1) {
         this.f = 0;
         this.e = 0;
      } else {
         if (this.g) {
            if (this.h == 0) {
               this.f -= var1;
               if (this.f < 0) {
                  this.f = this.a + this.f % this.a;
                  if (this.f >= this.e + this.d || this.f < this.e) {
                     this.e = this.a - this.d - (this.a - this.f - 1);
                  }

                  this.a(var2);
                  return;
               }

               if (this.f < this.e) {
                  this.e = this.f;
                  this.a(var2);
                  return;
               }
            } else if (this.h == 1) {
               this.f -= var1;
               if (this.f < 0) {
                  this.f = this.a + this.f % this.a;
               }

               this.e = this.f - this.i < 0 ? this.a + (this.f - this.i) : this.f - this.i;
               this.a(var2);
               return;
            }
         } else {
            this.f -= var1;
            if (this.f < 0) {
               this.f = 0;
               this.e = 0;
               this.a(var2);
               return;
            }

            if (this.f < this.e) {
               this.e -= var1;
               this.a(var2);
            }
         }
      }
   }

   private void a(f var1) {
      if (this.q == 1) {
         if (this.r == 1) {
            for (int var5 = 0; var5 < this.d; var5++) {
               int var6 = ((Object[])null).length > ((String[])this.s.elementAt((this.e + var5) % this.a)).length
                  ? ((String[])this.s.elementAt((this.e + var5) % this.a)).length
                  : ((Object[])null).length;

               for (int var7 = 0; var7 < var6; var7++) {
                  a.e.a(var1, ((Object[])null)[var7]).i().a = ((String[])this.s.elementAt((this.e + var5) % this.a))[var7];
               }
            }

            return;
         }

         if (this.r == 2) {
            for (int var2 = 0; var2 < this.d; var2++) {
               int var3 = ((Object[])null).length > ((i[])this.s.elementAt((this.e + var2) % this.a)).length
                  ? ((i[])this.s.elementAt((this.e + var2) % this.a)).length
                  : ((Object[])null).length;

               for (int var4 = 0; var4 < var3; var4++) {
                  a.e.a(var1, ((Object[])null)[var4]).a(((i[])this.s.elementAt((this.e + var2) % this.a))[var4]);
               }
            }
         }
      }
   }

   public final void a(Graphics var1, int var2, boolean var3, int[] var4, boolean var5, f var6) {
      if (this.p != null) {
         this.p = new k[20];

         for (int var7 = 0; var7 < this.d; var7++) {
            f var8 = a.e.a(var6, this.b[var7]);
            k var9 = new k(var8.c(), var8.d(), var8.e(), var8.f());
            this.p[var7] = var9;
         }
      }

      int var15 = -1;

      for (int var16 = 0; var16 < this.b.length && this.b[var16] != -1; var16++) {
         if (this.b[var16] == var2) {
            var15 = var16;
            break;
         }
      }

      int[] var17 = a.e.c(50);
      if (this.q == 1) {
         int var18 = 0;

         while (var18 < this.d) {
            var17[var18] = var18++;
         }
      } else if (this.q == -1) {
         for (int var19 = 0; var19 < this.d; var19++) {
            var17[var19] = (this.e + var19) % this.b.length;
         }
      }

      for (int var20 = 0; var20 < var17.length && var17[var20] != -1; var20++) {
         if (var15 == var17[var20]) {
            f var14;
            int var10 = (var14 = a.e.a(var6, var2)).c() - this.p[var20].a;
            int var11 = var14.d() - this.p[var20].b;
            int var12 = var14.e();
            int var13 = var14.f();
            a.e.a(var14, -var10, -var11, var6);
            var14.c(this.p[var20].c, var6);
            var14.d(this.p[var20].d, var6);
            if (!var3 || this.a <= 0) {
               var14.a(var1, false, var5, var6, var4);
            } else if (this.q == 1) {
               if (this.f == (this.e + var17[var20]) % this.a) {
                  var14.a(var1, true, var5, var6, var4);
               } else {
                  var14.a(var1, false, var5, var6, var4);
               }
            } else if (this.f == var17[var20]) {
               var14.a(var1, true, var5, var6, var4);
            } else {
               var14.a(var1, false, var5, var6, var4);
            }

            a.e.a(var14, var10, var11, var6);
            var14.c(var12, var6);
            var14.d(var13, var6);
         }
      }
   }

   public final void a(int var1, int[] var2, boolean var3, f var4) {
      if (this.p != null) {
         this.p = new k[20];

         for (int var5 = 0; var5 < this.d; var5++) {
            f var6 = a.e.a(var4, this.b[var5]);
            k var7 = new k(var6.c(), var6.d(), var6.e(), var6.f());
            this.p[var5] = var7;
         }
      }

      int var13 = -1;

      for (int var14 = 0; var14 < this.b.length && this.b[var14] != -1; var14++) {
         if (this.b[var14] == var1) {
            var13 = var14;
            break;
         }
      }

      int[] var15 = a.e.c(50);
      if (this.q == 1) {
         int var16 = 0;

         while (var16 < this.d) {
            var15[var16] = var16++;
         }
      } else if (this.q == -1) {
         for (int var17 = 0; var17 < this.d; var17++) {
            var15[var17] = (this.e + var17) % this.b.length;
         }
      }

      for (int var18 = 0; var18 < var15.length && var15[var18] != -1; var18++) {
         if (var13 == var15[var18]) {
            f var12;
            int var8 = (var12 = a.e.a(var4, var1)).c() - this.p[var18].a;
            int var9 = var12.d() - this.p[var18].b;
            int var10 = var12.e();
            int var11 = var12.f();
            a.e.a(var12, -var8, -var9, var4);
            var12.c(this.p[var18].c, var4);
            var12.d(this.p[var18].d, var4);
            var12.a(var3, var3, var4, var2);
            a.e.a(var12, var8, var9, var4);
            var12.c(var10, var4);
            var12.d(var11, var4);
         }
      }
   }

   public final void a() {
      if (this.o != null) {
         this.o = null;
      }

      if (this.b != null) {
         this.b = null;
      }

      if (this.c != null) {
         this.c = null;
      }

      if (this.s != null) {
         this.s = null;
      }

      if (this.p != null) {
         this.p = null;
      }
   }

   public final void a(int var1) {
      if (var1 != 1 && var1 != -1) {
         this.q = -1;
      } else {
         this.q = var1;
      }
   }
}
