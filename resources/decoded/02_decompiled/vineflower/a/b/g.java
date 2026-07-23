package a.b;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class g {
   private static int[] c = new int[]{0, 5, 3, 6, 2, 4, 1, 7};
   private static int[] d = new int[]{2, 4, 1, 7, 0, 5, 3, 6};
   private static int[] e = new int[]{3, 6, 0, 5, 1, 7, 2, 4};
   private static int[] f = new int[]{1, 7, 2, 4, 3, 6, 0, 5};
   private Image[] g;
   private h h;
   private int[] i;
   public int a;
   private int j;
   private int k;
   private byte l;
   private int m;
   private int n;
   protected byte b;
   private boolean o = true;

   public final boolean a(int var1, boolean var2) {
      this.i = new int[a.b.c.a[var1].length - 1];
      this.g = new Image[a.b.c.a[var1].length - 1];

      for (int var3 = 0; var3 < this.g.length; var3++) {
         this.i[var3] = a.b.c.a[var1][var3 + 1];
         this.g[var3] = a.b.c.b(this.i[var3]);
      }

      this.a = var1;
      this.h = a.b.f.b(a.b.c.a[var1][0]);
      this.h.g = var2;
      this.c(0);
      return true;
   }

   public final void a() {
      for (int var1 = 0; var1 < this.i.length; var1++) {
         this.g[var1] = null;
         a.b.c.c(this.i[var1]);
      }

      this.i = null;
      this.h = null;
      a.b.f.c(this.a);
   }

   public final void b() {
      if (this.i != null) {
         for (int var1 = 0; var1 < this.i.length; var1++) {
            this.g[var1] = null;
            a.b.c.d(this.i[var1]);
         }

         this.i = null;
         this.h = null;
         a.b.f.d(this.a);
      }
   }

   public final void a(int var1, int var2, boolean var3) {
      this.g[var1] = null;
      if (var3) {
         a.b.c.d(this.i[var1]);
      } else {
         a.b.c.c(this.i[var1]);
      }

      this.i[var1] = var2;
      this.g[var1] = a.b.c.b(this.i[var1]);
   }

   public final void c() {
      if (game.e.k == 1) {
         for (int var1 = 0; var1 < this.g.length; var1++) {
            this.g[var1] = a.a.d.a(a.b.c.b(this.i[var1]));
         }
      }
   }

   public final void d() {
      for (int var1 = 0; var1 < this.g.length; var1++) {
         if (game.e.k == 1) {
            this.g[var1] = a.a.d.a(a.b.c.b(this.i[var1]));
         } else {
            this.b();
         }
      }

      if (game.e.k == 0) {
         this.a(this.a, false);
      }
   }

   public final void a(int var1) {
      for (int var2 = 0; var2 < this.g.length; var2++) {
         if (var1 == 1) {
            this.g[var2] = a.a.d.a(a.b.c.b(this.i[var2]), 100);
         } else {
            this.b();
         }
      }

      if (var1 == 0) {
         this.a(this.a, false);
      }
   }

   public final boolean a(byte var1, byte var2, boolean var3) {
      if (this.b == var1 && !var3) {
         this.b = var1;
      } else {
         this.b = var1;
         this.c(0);
      }

      this.l = var2;
      return true;
   }

   public final void a(byte var1, byte var2) {
      this.b = var1;
      this.l = var2;
   }

   private void c(int var1) {
      this.m = var1;
      if (this.h.f != null) {
         if (this.h.g) {
            this.j = this.h.f[this.b][this.m << 2];
            this.n = this.h.f[this.b].length / 4;
         } else {
            this.j = this.h.f[this.b][this.m << 1];
            this.n = this.h.f[this.b].length / 2;
         }

         this.k = 0;
         if (this.j > 0) {
            this.j--;
         } else {
            if (this.k > 0) {
               this.k--;
            }
         }
      }
   }

   public final boolean e() {
      if (!this.o) {
         return false;
      }

      if (this.j > 0) {
         this.j--;
      } else if (this.k > 0) {
         this.k--;
      } else {
         this.m++;
         if (this.m >= this.n) {
            if (this.l >= 0) {
               this.a(this.l, (byte)-1, true);
            } else if (this.l == -2) {
               this.m--;
               this.c(this.m);
            } else if (this.l == -1) {
               this.c(0);
            }

            return true;
         }

         this.c(this.m);
      }

      return false;
   }

   public final boolean f() {
      return this.m >= this.n - 1;
   }

   public final boolean b(int var1) {
      return this.m == var1;
   }

   public final byte g() {
      return this.b;
   }

   public final int h() {
      return this.m;
   }

   public final int[] a(int var1, byte var2) {
      if (var1 >= 0 && var1 < this.h.f.length) {
         int[] var3;
         int var4 = (var3 = this.b(this.h.f[var1][1], var2))[0];
         int var5 = var3[0] + var3[2];
         int var6 = var3[1];
         int var7 = var3[1] + var3[3];
         if (this.h.g) {
            for (int var8 = 1; var8 != this.h.f[var1].length / 4; var8++) {
               if ((var3 = this.b(this.h.f[var1][(var8 << 2) + 1], var2)) != null) {
                  if (var4 > var3[0]) {
                     var4 = var3[0];
                  }

                  if (var5 < var3[0] + var3[2]) {
                     var5 = var3[0] + var3[2];
                  }

                  if (var6 > var3[1]) {
                     var6 = var3[1];
                  }

                  if (var7 < var3[1] + var3[3]) {
                     var7 = var3[1] + var3[3];
                  }
               }
            }
         } else {
            for (int var11 = 1; var11 != this.h.f[var1].length / 2; var11++) {
               if ((var3 = this.b(this.h.f[var1][(var11 << 1) + 1], var2)) != null) {
                  if (var4 > var3[0]) {
                     var4 = var3[0];
                  }

                  if (var5 < var3[0] + var3[2]) {
                     var5 = var3[0] + var3[2];
                  }

                  if (var6 > var3[1]) {
                     var6 = var3[1];
                  }

                  if (var7 < var3[1] + var3[3]) {
                     var7 = var3[1] + var3[3];
                  }
               }
            }
         }

         return new int[]{var4, var6, var5 - var4, var7 - var6};
      } else {
         return null;
      }
   }

   public final int[] b(int var1, byte var2) {
      if (this.h.e[var1].length <= 0) {
         return null;
      }

      short var3 = this.h.e[var1][0];
      int var4 = this.h.e[var1][1];
      int var5 = this.h.e[var1][2];

      for (byte var6 = 0; var6 < this.h.e[var1].length; var6 += 4) {
         var3 = this.h.e[var1][var6];
         if (this.h.e[var1][var6 + 1] < var4) {
            var4 = this.h.e[var1][var6 + 1];
         }

         if (this.h.e[var1][var6 + 2] < var5) {
            var5 = this.h.e[var1][var6 + 2];
         }
      }

      int[] var17 = new int[2];
      int[] var18;
      int var7 = (var18 = this.a(0, var3, var1, var4, var5, var17))[0];
      int var8 = var18[1];

      for (byte var9 = 0; var9 < this.h.e[var1].length; var9 += 4) {
         var3 = this.h.e[var1][var9];
         if ((var18 = this.a(var9, var3, var1, var4, var5, var18))[0] > var7) {
            var7 = var18[0];
         }

         if (var18[1] > var8) {
            var8 = var18[1];
         }
      }

      switch (var2) {
         case 1:
            var3 = this.h.e[var1][0];
            if (this.h.e[var1][3] % 2 == 1) {
               var4 = -this.h.e[var1][1] - this.h.b[var3 * 5 + 4];
            } else {
               var4 = -this.h.e[var1][1] - this.h.b[var3 * 5 + 3];
            }

            for (byte var21 = 0; var21 < this.h.e[var1].length; var21 += 4) {
               var3 = this.h.e[var1][var21];
               if (this.h.e[var1][var21 + 3] % 2 == 1) {
                  if (-this.h.e[var1][var21 + 1] - this.h.b[var3 * 5 + 4] < var4) {
                     var4 = -this.h.e[var1][var21 + 1] - this.h.b[var3 * 5 + 4];
                  }
               } else if (-this.h.e[var1][var21 + 1] - this.h.b[var3 * 5 + 3] < var4) {
                  var4 = -this.h.e[var1][var21 + 1] - this.h.b[var3 * 5 + 3];
               }
            }
         case 2:
         default:
            break;
         case 3:
            var3 = this.h.e[var1][0];
            if (this.h.e[var1][3] % 2 == 1) {
               var4 = -this.h.e[var1][1] - this.h.b[var3 * 5 + 4];
               var5 = -this.h.e[var1][2] - this.h.b[var3 * 5 + 3];
            } else {
               var4 = -this.h.e[var1][1] - this.h.b[var3 * 5 + 3];
               var5 = -this.h.e[var1][2] - this.h.b[var3 * 5 + 4];
            }

            for (byte var20 = 0; var20 < this.h.e[var1].length; var20 += 4) {
               var3 = this.h.e[var1][var20];
               if (this.h.e[var1][var20 + 3] % 2 == 1) {
                  if (-this.h.e[var1][var20 + 1] - this.h.b[var3 * 5 + 4] < var4) {
                     var4 = -this.h.e[var1][var20 + 1] - this.h.b[var3 * 5 + 4];
                  }

                  if (-this.h.e[var1][var20 + 2] - this.h.b[var3 * 5 + 3] < var5) {
                     var5 = -this.h.e[var1][var20 + 2] - this.h.b[var3 * 5 + 3];
                  }
               } else {
                  if (-this.h.e[var1][var20 + 1] - this.h.b[var3 * 5 + 3] < var4) {
                     var4 = -this.h.e[var1][var20 + 1] - this.h.b[var3 * 5 + 3];
                  }

                  if (-this.h.e[var1][var20 + 2] - this.h.b[var3 * 5 + 4] < var5) {
                     var5 = -this.h.e[var1][var20 + 2] - this.h.b[var3 * 5 + 4];
                  }
               }
            }
            break;
         case 4:
            var3 = this.h.e[var1][0];
            if (this.h.e[var1][3] % 2 == 1) {
               var5 = -this.h.e[var1][2] - this.h.b[var3 * 5 + 3];
            } else {
               var5 = -this.h.e[var1][2] - this.h.b[var3 * 5 + 4];
            }

            for (byte var19 = 0; var19 < this.h.e[var1].length; var19 += 4) {
               var3 = this.h.e[var1][var19];
               if (this.h.e[var1][var19 + 3] % 2 == 1) {
                  if (-this.h.e[var1][var19 + 2] - this.h.b[var3 * 5 + 3] < var5) {
                     var5 = -this.h.e[var1][var19 + 2] - this.h.b[var3 * 5 + 3];
                  }
               } else if (-this.h.e[var1][var19 + 2] - this.h.b[var3 * 5 + 4] < var5) {
                  var5 = -this.h.e[var1][var19 + 2] - this.h.b[var3 * 5 + 4];
               }
            }
      }

      return new int[]{var4, var5, var7, var8};
   }

   private int[] a(int var1, int var2, int var3, int var4, int var5, int[] var6) {
      if (this.h.e[var3][var1 + 3] % 2 == 1) {
         var6[1] = this.h.e[var3][var1 + 2] - var5 + this.h.b[var2 * 5 + 3];
         var6[0] = this.h.e[var3][var1 + 1] - var4 + this.h.b[var2 * 5 + 4];
      } else {
         var6[0] = this.h.e[var3][var1 + 1] - var4 + this.h.b[var2 * 5 + 3];
         var6[1] = this.h.e[var3][var1 + 2] - var5 + this.h.b[var2 * 5 + 4];
      }

      return var6;
   }

   public final void a(Graphics var1, int var2, int var3, byte var4) {
      if (this.h.g) {
         this.a(var1, this.h.f[this.b][(this.m << 2) + 1], var2, var3, var4, 20);
      } else {
         this.a(var1, this.h.f[this.b][(this.m << 1) + 1], var2, var3, var4, 20);
      }
   }

   public final void a(Graphics var1, int var2, int var3, int var4, byte var5, int var6) {
      if (this.h.e[var2].length > 0) {
         switch (var5) {
            case 0:
               for (byte var10 = 0; var10 < this.h.e[var2].length; var10 += 4) {
                  this.a(var1, this.h.e[var2][var10], var3 + this.h.e[var2][var10 + 1], var4 + this.h.e[var2][var10 + 2], c[this.h.e[var2][var10 + 3]], 20);
               }

               return;
            case 1:
               for (byte var9 = 0; var9 < this.h.e[var2].length; var9 += 4) {
                  if (this.h.e[var2][var9 + 3] % 2 == 1) {
                     this.a(
                        var1,
                        this.h.e[var2][var9],
                        var3 - this.h.e[var2][var9 + 1] - this.h.b[this.h.e[var2][var9] * 5 + 4],
                        var4 + this.h.e[var2][var9 + 2],
                        d[this.h.e[var2][var9 + 3]],
                        20
                     );
                  } else {
                     this.a(
                        var1,
                        this.h.e[var2][var9],
                        var3 - this.h.e[var2][var9 + 1] - this.h.b[this.h.e[var2][var9] * 5 + 3],
                        var4 + this.h.e[var2][var9 + 2],
                        d[this.h.e[var2][var9 + 3]],
                        20
                     );
                  }
               }

               return;
            case 3:
               for (byte var8 = 0; var8 < this.h.e[var2].length; var8 += 4) {
                  if (this.h.e[var2][var8 + 3] % 2 == 1) {
                     this.a(
                        var1,
                        this.h.e[var2][var8],
                        var3 - this.h.e[var2][var8 + 1] - this.h.b[this.h.e[var2][var8] * 5 + 4],
                        var4 - this.h.e[var2][var8 + 2] - this.h.b[this.h.e[var2][var8] * 5 + 3],
                        e[this.h.e[var2][var8 + 3]],
                        20
                     );
                  } else {
                     this.a(
                        var1,
                        this.h.e[var2][var8],
                        var3 - this.h.e[var2][var8 + 1] - this.h.b[this.h.e[var2][var8] * 5 + 3],
                        var4 - this.h.e[var2][var8 + 2] - this.h.b[this.h.e[var2][var8] * 5 + 4],
                        e[this.h.e[var2][var8 + 3]],
                        20
                     );
                  }
               }

               return;
            case 4:
               for (byte var7 = 0; var7 < this.h.e[var2].length; var7 += 4) {
                  if (this.h.e[var2][var7 + 3] % 2 == 1) {
                     this.a(
                        var1,
                        this.h.e[var2][var7],
                        var3 + this.h.e[var2][var7 + 1],
                        var4 - this.h.e[var2][var7 + 2] - this.h.b[this.h.e[var2][var7] * 5 + 3],
                        f[this.h.e[var2][var7 + 3]],
                        20
                     );
                  } else {
                     this.a(
                        var1,
                        this.h.e[var2][var7],
                        var3 + this.h.e[var2][var7 + 1],
                        var4 - this.h.e[var2][var7 + 2] - this.h.b[this.h.e[var2][var7] * 5 + 4],
                        f[this.h.e[var2][var7 + 3]],
                        20
                     );
                  }
               }
            case 2:
         }
      }
   }

   private void a(Graphics var1, int var2, int var3, int var4, int var5, int var6) {
      var1.drawRegion(
         this.g[this.h.b[var2 * 5]], this.h.b[var2 * 5 + 1], this.h.b[var2 * 5 + 2], this.h.b[var2 * 5 + 3], this.h.b[var2 * 5 + 4], var5, var3, var4, var6
      );
   }

   public final boolean i() {
      return this.h == null || this.h.c == null;
   }

   public final short[] j() {
      if (this.h.c == null) {
         return null;
      } else {
         return this.h.g ? this.h.c[this.h.f[this.b][(this.m << 2) + 1]] : this.h.c[this.h.f[this.b][(this.m << 1) + 1]];
      }
   }

   public final short[] k() {
      if (this.h.d == null) {
         return null;
      } else {
         return this.h.g ? this.h.d[this.h.f[this.b][(this.m << 2) + 1]] : this.h.d[this.h.f[this.b][(this.m << 1) + 1]];
      }
   }
}
