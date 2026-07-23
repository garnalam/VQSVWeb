package c;

import javax.microedition.lcdui.Graphics;

public final class m implements f {
   private int f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;
   private int q;
   private int r;
   private int s;
   private int t;
   private int u;
   private int v;
   private int w;
   private int x;
   public int a;
   public g b;
   public g c;
   public boolean d;
   private boolean y = true;
   private int z;
   private int A;
   private int B;
   e[] e;

   public final void a(int var1) {
      this.h = var1;
   }

   public final void b(int var1) {
      this.i = var1;
   }

   public final void c(int var1) {
      this.j = var1;
   }

   public final void d(int var1) {
      this.k = var1;
   }

   public final int a() {
      return this.l;
   }

   public final void e(int var1) {
      this.l = var1;
   }

   public final int m() {
      return this.m;
   }

   public final void f(int var1) {
      this.m = var1;
   }

   public final void g(int var1) {
      if (var1 > 0 && var1 <= this.l) {
         this.p = var1;
      } else {
         this.p = this.l;
      }
   }

   public final void h(int var1) {
      if (var1 > 0 && var1 <= this.m) {
         this.r = var1;
      } else {
         this.r = this.m;
      }
   }

   public final void i(int var1) {
      this.q = var1;
   }

   public final void j(int var1) {
      this.s = var1;
   }

   private int o() {
      return this.s + this.r - 1;
   }

   private int p() {
      return this.q + this.p - 1;
   }

   public final void k(int var1) {
      this.n = var1;
   }

   public final void l(int var1) {
      this.o = var1;
   }

   public final void m(int var1) {
      this.t = var1;
   }

   public final void n(int var1) {
      this.v = var1;
   }

   public final void o(int var1) {
      this.u = var1;
   }

   public final void p(int var1) {
      this.w = var1;
   }

   public final e[] n() {
      int var3 = this.m;
      int var2 = this.l;
      e[] var5 = new e[this.l * var3];

      for (int var6 = 0; var6 != var2 * var3; var6++) {
         e var7 = new e(var6 - var2, var6 + var2, var6 - 1, var6 + 1);
         var5[var6] = var7;
      }

      e[] var1 = var5;
      int var21 = this.m;
      int var4 = this.l;
      e[] var18 = var1;
      m var16 = this;

      for (int var23 = 0; var23 != var21; var23++) {
         e var25 = new e(-1, (byte)0, 0, 0, 0, 0, 0);
         e var8 = new e(-1, (byte)0, 0, 0, 0, 0, 0);
         int var9 = -1;
         int var10 = -1;

         for (int var11 = 0; var11 != var4; var11++) {
            if (var25.a() == 0 && var18[var23 * var4 + var11].a() == 1) {
               var25 = var18[var23 * var4 + var11];
               var9 = var23 * var4 + var11;
            }

            if (var8.a() == 0 && var18[(var23 + 1) * var4 - var11 - 1].a() == 1) {
               var8 = var18[(var23 + 1) * var4 - var11 - 1];
               var10 = (var23 + 1) * var4 - var11 - 1;
            }
         }

         if (var25.a() == 1) {
            if (var16.t == 0) {
               var25.c(var9);
               var8.d(var10);
            } else {
               var9 = var9;
               e[] var26 = var18;
               int var38 = -1;

               for (int var12 = 0; var12 != var26.length; var12++) {
                  int var13;
                  if ((var13 = var9 - var12 - 1) < 0) {
                     var13 += var4 * var21;
                  }

                  if (var38 == -1 && var26[var13].a() == 1) {
                     var38 = var13;
                  }
               }

               var25.c(var38);
               var9 = var10;
               e[] var27 = var18;
               var38 = -1;

               for (int var43 = 0; var43 != var27.length; var43++) {
                  int var46;
                  if ((var46 = var9 + var43 + 1) >= var4 * var21) {
                     var46 -= var4 * var21;
                  }

                  if (var38 == -1 && var27[var46].a() == 1) {
                     var38 = var46;
                  }
               }

               var8.d(var38);
            }
         }
      }

      int var22 = this.m;
      var4 = this.l;
      e[] var19 = var1;
      m var17 = this;

      for (int var24 = 0; var24 != var4; var24++) {
         e var28 = new e(-1, (byte)0, 0, 0, 0, 0, 0);
         e var31 = new e(-1, (byte)0, 0, 0, 0, 0, 0);
         int var34 = -1;
         int var37 = -1;

         for (int var40 = 0; var40 != var22; var40++) {
            if (var28.a() == 0 && var19[var24 + var4 * var40].a() == 1) {
               var28 = var19[var24 + var4 * var40];
               var34 = var24 + var4 * var40;
            }

            if (var31.a() == 0 && var19[var24 + var4 * (var22 - var40 - 1)].a() == 1) {
               var31 = var19[var24 + var4 * (var22 - var40 - 1)];
               var37 = var24 + var4 * (var22 - var40 - 1);
            }
         }

         if (var28.a() == 1) {
            if (var17.v == 0) {
               var28.a(var34);
               var31.b(var37);
            } else {
               int var41 = var34;
               e[] var35 = var19;
               m var29 = var17;
               int var44 = -1;
               int var47 = var41 % var4;

               for (int var14 = 0; var14 != var22; var14++) {
                  int var15;
                  if ((var15 = var41 / var4 - 1 - var14) < 0) {
                     var15 += var22;
                  }

                  if (var44 == -1 && var35[var15 * var29.l + var47].a() == 1) {
                     var44 = var15 * var29.l + var47;
                  }
               }

               var28.a(var44);
               var41 = var37;
               e[] var36 = var19;
               m var30 = var17;
               var44 = -1;
               var47 = var41 % var4;

               for (int var49 = 0; var49 != var22; var49++) {
                  int var50;
                  if ((var50 = var41 / var4 + 1 + var49) >= var22) {
                     var50 -= var22;
                  }

                  if (var44 == -1 && var36[var50 * var30.l + var47].a() == 1) {
                     var44 = var50 * var30.l + var47;
                  }
               }

               var31.b(var44);
            }
         }
      }

      return var1;
   }

   public static e[] a(int var0, int var1) {
      e[] var2 = new e[var0 * var1];

      for (int var3 = 0; var3 != var0 * var1; var3++) {
         var2[var3] = new e();
      }

      return var2;
   }

   public final boolean a(byte var1) {
      boolean var2 = false;
      int var3 = this.x;
      if (var1 == 0) {
         if (this.e[this.x].a() == 1 && var3 != this.e[this.x].b()) {
            var3 = this.e[this.x].b();
            var2 = true;
         }
      } else if (var1 == 1) {
         if (this.e[this.x].a() == 1 && var3 != this.e[this.x].c()) {
            var3 = this.e[this.x].c();
            var2 = true;
         }
      } else if (var1 == 2) {
         if (this.e[this.x].a() == 1 && var3 != this.e[this.x].d()) {
            var3 = this.e[this.x].d();
            var2 = true;
         }
      } else if (var1 == 3 && this.e[this.x].a() == 1 && var3 != this.e[this.x].e()) {
         var3 = this.e[this.x].e();
         var2 = true;
      }

      this.r(var3);
      return var2;
   }

   public m() {
      this.f = this.g = 0;
      this.h = this.i = this.j = this.k = this.l = this.m = 0;
      this.n = this.o = 0;
      this.p = this.q = 0;
      this.r = this.s = 0;
      this.A = 2;
      this.z = this.B = -1;
      this.x = 0;
      this.e = new e[0];
      this.c = null;
      this.d = false;
      this.y = true;
   }

   public final void a(Graphics var1, boolean var2, boolean var3, f var4, int[] var5) {
      if (this.y) {
         if (var1 != null) {
            var1.setColor(this.a);
            var1.fillRect(this.f, this.g, this.e(), this.f());
            k var8 = new k(this.f, this.g, this.e(), this.f());
            if (this.b != null && var1 != null) {
               this.b.a(var1, var8, 0);
            }

            var3 = this.o();
            int var12 = this.p();

            for (int var13 = this.s; var13 <= var3; var13++) {
               for (int var6 = this.q; var6 <= var12; var6++) {
                  k var9 = new k(this.f + this.j + (var6 - this.q) * (this.j + this.h), this.g + this.k + (var13 - this.s) * (this.k + this.i), this.h, this.i);
                  g var7;
                  if ((var7 = this.e[var13 * this.l + var6].a) != null && var1 != null) {
                     var7.a(var1, var9, 0);
                  }
               }
            }

            k var10 = new k(
               this.f + this.j + (this.x % this.l - this.q) * (this.j + this.h) + this.n,
               this.g + this.k + (this.x / this.l - this.s) * (this.k + this.i) + this.o,
               this.e(),
               this.f()
            );
            if (this.d && this.c != null && var1 != null) {
               this.c.a(var1, var10, 0);
            }
         }
      }
   }

   public final void a(boolean var1, boolean var2, f var3, int[] var4) {
      if (this.b != null) {
         this.b.b();
      }

      for (int var5 = 0; var5 < this.e.length; var5++) {
         if (this.e[var5].a != null) {
            this.e[var5].a.b();
         }
      }

      if (this.d && this.c != null) {
         this.c.b();
      }
   }

   public final int b() {
      return this.z;
   }

   public final void q(int var1) {
      this.z = var1;
   }

   public final int c() {
      return this.f;
   }

   public final void a(int var1, f var2) {
      this.f = var1;
   }

   public final int d() {
      return this.g;
   }

   public final void b(int var1, f var2) {
      this.g = var1;
   }

   public final int e() {
      return this.p > 0 && this.p <= this.l ? (this.h + this.j) * this.p + this.j : (this.h + this.j) * this.l + this.j;
   }

   public final void c(int var1, f var2) {
   }

   public final int f() {
      return this.r > 0 && this.r <= this.m ? (this.i + this.k) * this.r + this.k : (this.i + this.k) * this.m + this.k;
   }

   public final void d(int var1, f var2) {
   }

   public final void r(int var1) {
      if (this.e != null && var1 > -2 && var1 < this.e.length) {
         this.x = var1;
         m var4 = this;
         m var2 = this;
         int var3 = this.x / var2.l;
         if (var2.w == 1) {
            var2.s = var3 / var2.r * var2.r;
         } else if (var3 < var2.s) {
            var2.s = var3;
         } else if (var3 > var2.o()) {
            var3 = var3;
            m var5 = var2;
            var2.s = var3 - var5.r + 1;
         }

         var2 = var4;
         var3 = var4.x % var2.l;
         if (var2.u == 1) {
            var2.q = var3 / var2.p * var2.p;
            return;
         }

         if (var3 < var2.q) {
            var2.q = var3;
            return;
         }

         if (var3 > var2.p()) {
            var3 = var3;
            m var7 = var2;
            var2.q = var3 - var7.p + 1;
         }
      }
   }

   public final l g() {
      return null;
   }

   public final f[] h() {
      return null;
   }

   public final i i() {
      return null;
   }

   public final void a(i var1) {
   }

   public final int j() {
      return this.A;
   }

   public final int k() {
      return this.B;
   }

   public final void s(int var1) {
      this.B = var1;
   }

   public final void a(f var1) {
   }

   public final void l() {
      if (this.c != null) {
         this.c.c();
         this.c = null;
      }

      if (this.b != null) {
         this.b.c();
         this.b = null;
      }

      if (this.e != null) {
         for (int var1 = 0; var1 < this.e.length; var1++) {
            if (this.e[var1] != null) {
               e var2;
               (var2 = this.e[var1]).a.c();
               this.e[var1] = null;
            }
         }

         this.e = null;
      }
   }

   public final void a(boolean var1) {
      this.y = var1;
   }
}
