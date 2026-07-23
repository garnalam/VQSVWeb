package a.a;

import c.j;
import game.k;
import game.l;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class f {
   private static f i;
   public int a = -1;
   private int j = -1;
   public int b = -1;
   public int c = -1;
   public boolean d;
   public boolean e;
   private int k;
   public int f;
   private int l = 0;
   private int m = 20;
   public int g = 5;
   private int n = -2013265920;
   private int[] o = null;
   private int[] p = null;
   private int[] q = null;
   private int r = 16;
   private int s = 4;
   private int t = 0;
   private int[][] u;
   private int[] v;
   private int w = 20;
   private int x;
   private static j y;
   private static k z;
   private static short[][] A = null;
   private short[][] B = new short[][]{{-20, 20, 20, -20, -15, 15, -15, 15, -5, 5, -5, 5}, {-5, 5, 5, -5}, {-5, 10, -5}};
   private int C = 0;
   private int D = 0;
   private int E = 0;
   private int F = 0;
   private int G = 0;
   private int H = 0;
   private int I;
   private int J;
   private int K;
   private int L = 0;
   private int M = 0;
   private Image N = null;
   private c O = null;
   private int P;
   private int Q;
   private int R = 0;
   private int S = 0;
   private int T = 0;
   private int U = 0;
   private int[] V = new int[]{16777215, 9115396};
   private static int W = 0;
   private static int[] X = new int[5];
   private a.a.b Y;
   private int Z = 0;
   private int aa = 0;
   public byte h = -1;
   private int ab;
   private int ac;
   private int ad;
   private int ae;
   private int af;
   private int ag;
   private static final int[][] ah = new int[][]{{1, 3}, {1, 4}, {2, 5}, {2, 6}};
   private byte ai = 50;
   private Image[] aj;
   private Image ak = null;
   private int[][] al;
   private int am = 0;
   private int an = 0;
   private byte ao = 0;
   private boolean ap = false;
   private boolean aq = false;

   public static f a() {
      if (i == null) {
         i = new f();
      }

      y = c.j.a();
      z = game.k.a();
      return i;
   }

   public static void b() {
      A = null;
      A = a.e.a(a.e.a("/data/script/battleNpc.mid"));
   }

   public static void c() {
      A = null;
   }

   public final void a(Graphics var1) {
      if (this.a != -1 || this.b != -1 || this.c != -1) {
         switch (this.c) {
            case 18:
               y.a(var1);
               if (this.k >= A.length) {
                  this.k = 0;
                  this.c = -1;
                  this.d = true;
                  A = null;
                  y.a("/data/ui/menu1.ui");
                  return;
               }
         }

         switch (this.a) {
            case 0:
            case 1:
            case 2:
               Graphics var20 = var1;
               f var17 = this;
               int var27 = this.n & 16777215;
               boolean var37 = false;
               int var32 = 0;
               if (var17.a == 0) {
                  var32 = var17.n;
               } else if (var17.a == 1) {
                  if (255 - var17.l * var17.g < 0) {
                     var17.l--;
                     var17.a = -1;
                     var37 = true;
                  }

                  var32 = 255 - var17.l * var17.g << 24;
                  var32 = var27 | var32;
               } else if (var17.a == 2) {
                  if (var17.l * var17.g > 255) {
                     var17.l--;
                     var37 = true;
                  }

                  var32 = var17.l * var17.g << 24;
                  var32 = var27 | var32;
               }

               var27 = var17.w;
               int var39 = a.a.h() / var27 + 1;
               int var41 = a.a.g() * var39;
               if (var17.o == null || var17.o.length != var41) {
                  var17.o = new int[var41];
               }

               if (var17.o[0] != var32) {
                  for (int var42 = 0; var42 < var17.o.length; var42++) {
                     var17.o[var42] = var32;
                  }
               }

               for (int var43 = 0; var43 < var27; var43++) {
                  var20.drawRGB(var17.o, 0, a.a.g(), 0, var43 * var39, a.a.g(), var39, true);
               }

               boolean var49;
               if (var37) {
                  var17.f();
                  var49 = true;
               } else {
                  var17.l++;
                  var49 = false;
               }

               this.d = var49;
               break;
            case 3:
               Graphics var19 = var1;
               f var16 = this;
               int var22 = a.a.g();
               int var30 = a.a.h();
               int var6 = var16.n & 16777215;
               int var7 = var16.m;
               int var8 = 255 / var7 / 2;
               int var9 = var22 / 2;
               var30 /= 2;
               int var10;
               int var47 = var10 = var9 * 200 / 120;
               int var11 = var47 * var47;
               boolean var12 = false;
               if (var16.q == null) {
                  var16.q = new int[var10];
               }

               int var13 = var10 + var7 - (var16.l << 1);
               if (var16.l <= 0) {
                  var12 = true;
                  var13 = var10 + var7 - (--var16.l << 1);
               }

               if (var16.o == null || var16.o.length != var9 * var30) {
                  var16.o = new int[var9 * var30];
               }

               if (var16.p == null || var16.p.length != var9 * var30) {
                  var16.p = new int[var9 * var30];
               }

               for (int var14 = 0; var14 < var16.q.length; var14++) {
                  if ((var22 = var14 - var13) > var7) {
                     var22 = 255;
                  } else if (var22 < -var7) {
                     var22 = 0;
                  } else {
                     var22 = 127 + var22 * var8;
                  }

                  var16.q[var14] = var6 | var22 << 24;
               }

               int var46 = var10 - 1;
               var22 = var13 + var7;
               if ((var6 = var13 - var7) < 0) {
                  var6 = 0;
               }

               var22 = var22 * var11 / var46;
               var6 = var6 * var11 / var46;

               for (int var38 = 0; var38 < var30; var38++) {
                  var10 = var38 * var38;
                  var13 = var38 * var9;

                  for (int var15 = 0; var15 < var9; var15++) {
                     if ((var8 = var10 + var15 * var15) > var22) {
                        var16.o[var13 + var15] = -16777216;
                     } else if (var8 < var6) {
                        var16.o[var13 + var15] = 0;
                     } else {
                        var16.o[var13 + var15] = var16.q[var46 * var8 / var11];
                     }
                  }
               }

               if (var16.o != null) {
                  var19.drawRGB(var16.o, 0, var9, var9, var30, var9, var30, true);
                  var19.drawRGB(a(var16.o, var16.p, var9, var30, (byte)2), 0, var9, 0, var30, var9, var30, true);
                  var19.drawRGB(a(var16.o, var16.p, var9, var30, (byte)3), 0, var9, 0, 0, var9, var30, true);
                  var19.drawRGB(a(var16.o, var16.p, var9, var30, (byte)1), 0, var9, var9, 0, var9, var30, true);
               }

               boolean var48;
               if (var12) {
                  var16.f();
                  var48 = true;
               } else {
                  var16.l -= 10;
                  var48 = false;
               }

               this.d = var48;
               break;
            case 4:
               if (this.d) {
                  this.a = -1;
                  var1.fillRect(0, 0, a.a.g(), a.a.h());
               } else {
                  this.d = this.e(var1);
               }
               break;
            case 5:
               if (!this.d) {
                  this.d = this.e(var1);
               }
               break;
            case 6:
               if (this.d) {
                  this.a = -1;
                  var1.fillRect(0, 0, a.a.g(), a.a.h());
               } else {
                  this.d = this.d(var1);
               }
               break;
            case 7:
               if (this.k < a.a.h()) {
                  var1.drawRGB(this.o, 0, a.a.g(), 0, 0, a.a.g(), this.k, true);
                  var1.drawRGB(this.p, 0, a.a.g(), 0, a.a.h() - this.k, a.a.g(), this.k, true);
                  this.k += 20;
               } else {
                  var1.drawRGB(this.o, 0, a.a.g(), 0, 0, a.a.g(), a.a.h(), true);
                  var1.drawRGB(this.p, 0, a.a.g(), 0, 0, a.a.g(), a.a.h(), true);
                  if (this.Y == null) {
                     this.a(0);
                  }
               }

               if (this.Y != null) {
                  this.Y.a(var1, 0, 0);
               }
               break;
            case 8:
               if (this.k >= 5) {
                  var1.drawImage(game.a.B().m, 0, 0, 20);
               }

               y.a(var1);
               if (this.k >= A.length) {
                  this.k = 0;
                  this.a = -1;
                  this.d = true;
                  y.a("/data/ui/npcEnemy.ui");
                  return;
               }
               break;
            case 9:
               var1.setColor(this.n);
               var1.fillRect(0, 0, a.a.g(), a.a.h());
               break;
            case 10:
               if (this.k <= this.L) {
                  if (this.k % 3 / (this.M + 1) == 0) {
                     var1.setColor(16777215);
                     var1.fillRect(0, 0, a.a.g(), a.a.h());
                  } else if (this.k % 3 / (this.M + 1) == 1) {
                     var1.setColor(0);
                     var1.fillRect(0, 0, a.a.g(), a.a.h());
                  }

                  this.k++;
               }
            case 11:
            case 12:
            case 13:
            case 16:
            case 18:
            default:
               break;
            case 14:
            case 15:
               Graphics var18 = var1;
               f var2 = this;
               boolean var21 = false;
               int var29 = 0;
               if (var2.a == 15) {
                  var29 = var2.l;
                  if (var2.l >= 255) {
                     var29 = 255;
                     var2.l = 255;
                     var21 = true;
                  }
               } else if (var2.a == 14 && (var29 = 255 - var2.l) <= 0) {
                  var29 = 0;
                  var2.a = -1;
                  var21 = true;
               }

               if (var2.O != null) {
                  var2.O = a.a.d.b(var2.O, var29);
                  var18.drawRGB(var2.O.a, 0, var2.O.b, var2.P - var2.O.b / 2, var2.Q - var2.O.c / 2, var2.O.b, var2.O.c, true);
               }

               boolean var10001;
               if (var21) {
                  var2.a = -1;
                  var2.f();
                  var10001 = true;
               } else {
                  var2.l = var2.l + var2.g;
                  var10001 = false;
               }

               this.d = var10001;
               break;
            case 17:
               var1.setColor(this.V[this.n]);
               int var5 = this.R;
               int var4 = this.U;
               int var3 = this.T;
               var1.fillArc(var3 - var5, var4 - var5, var5 << 1, var5 << 1, 0, 360);
               break;
            case 19:
            case 20:
               this.d = this.f(var1);
         }

         switch (this.b) {
            case 12:
               var1.setColor(0);
               var1.fillRect(0, 0, this.I, this.J - this.f * this.J / this.G);
               var1.fillRect(0, a.a.h() - this.K + this.f * this.K / this.G, this.I, this.K - this.f * this.K / this.G);
               return;
            case 13:
               var1.setColor(0);
               var1.fillRect(0, 0, this.I, this.f * this.J / this.G);
               var1.fillRect(0, a.a.h() - this.f * this.K / this.G, this.I, this.f * this.K / this.G);
         }
      }
   }

   private void a(int var1) {
      this.aa = var1;
      switch (this.a) {
         case 7:
            short var2 = a.b.c.c[0][game.a.B().p(0)][17];
            switch (this.aa) {
               case 0:
                  short[] var6 = new short[]{8, 118, 160, var2, 0, 1, 0, 4, 0, 2, 1, 8, 0, -16, 10, 0, 0};
                  this.Y = new a.a.b();
                  this.Y.a(var6);
                  this.Y.d(true);
                  this.Y.a();
                  return;
               case 1:
                  short[] var5 = new short[]{17, 118, 160, var2, 0, 1, 100, 255, 255, 255, 12, 0, 1, 1, 9};
                  this.Y.a(var5);
                  this.Y.a();
                  return;
               case 2:
                  short[] var4 = new short[]{17, 118, 160, var2, 0, 1, 255, 255, 255, 255, 15, 0, 1, 1, 13};
                  this.Y.a(var4);
                  this.Y.a();
                  return;
               case 3:
                  short[] var3 = new short[]{9, 118, 160, var2, 0, 1, 160, 255, 255, 255, 0, 4, 1};
                  this.Y.a(var3);
                  this.Y.a();
               default:
                  return;
            }
         default:
            this.Z = A[this.k].length;
      }
   }

   public final void d() {
      if (this.a != -1 || this.b != -1 || this.c != -1) {
         switch (this.a) {
            case 7:
               if (this.Y != null && !this.Y.d()) {
                  this.aa++;
                  if (this.aa >= 4) {
                     this.d = true;
                     this.a = -1;
                     this.k = 0;
                     this.Y = null;
                     return;
                  }

                  this.a(this.aa);
               }
               break;
            case 8:
               if (this.aa < this.Z) {
                  z.c(this.k, A[this.k][this.aa]);
                  this.aa++;
               } else {
                  this.k++;
                  if (this.k < A.length) {
                     this.a(0);
                  }
               }

               y.c();
            case 9:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            default:
               break;
            case 10:
               if (this.k > this.L) {
                  this.d = true;
                  this.a = -1;
                  this.k = 0;
               }
               break;
            case 11:
               if (this.C == 0) {
                  if (this.F >= this.B[this.D].length * this.E) {
                     this.a = -1;
                     this.d = true;
                     this.F = 0;
                     a.b.b.a().a = 1;
                     return;
                  }

                  a.b.b.a().d(this.B[this.D][this.F % this.B[this.D].length]);
                  this.F++;
               } else {
                  if (this.F >= this.B[this.D].length * this.E) {
                     this.a = -1;
                     this.d = true;
                     this.F = 0;
                     a.b.b.a().a = 1;
                     return;
                  }

                  a.b.b.a().e(this.B[this.D][this.F % this.B[this.D].length]);
                  this.F++;
               }
               break;
            case 17:
               this.k++;
               if (this.S == 0) {
                  if ((a.a.g() - this.T) * (a.a.g() - this.T) + (a.a.h() - this.U) * (a.a.h() - this.U) < this.R * this.R) {
                     this.k = 0;
                     this.d = true;
                  }

                  this.R += 10;
               } else if (this.S == 1) {
                  this.R -= 10;
                  if (this.R <= 0) {
                     this.k = 0;
                     this.a = -1;
                     this.d = true;
                  }
               } else if (this.k <= 10) {
                  this.R += 10;
               } else if (this.k > 10 && this.k <= 20) {
                  this.R -= 10;
               } else {
                  this.k = 0;
                  this.d = true;
                  this.a = -1;
               }
         }

         switch (this.b) {
            case 12:
               this.f = this.f + this.H;
               if (this.f > this.G) {
                  this.f = 0;
                  this.e = true;
                  this.b = -1;
               }
               break;
            case 13:
               this.f = this.f + this.H;
               if (this.f > this.G) {
                  this.f = this.G;
                  this.e = true;
               }
         }

         switch (this.c) {
            case 18:
               if (this.aa < this.Z) {
                  z.a(this.k, A[this.k][this.aa]);
                  this.aa++;
               } else {
                  this.k++;
                  if (this.k < A.length) {
                     this.a(0);
                  }
               }

               y.c();
         }
      }
   }

   private boolean d(Graphics var1) {
      if (this.k < 10) {
         if (this.k % 3 == 1) {
            var1.setColor(16777215);
            var1.fillRect(0, 0, a.a.g(), a.a.h());
         } else {
            game.l.B();
            game.l.b(var1);
            game.l.B().l.a(var1);
         }

         this.k++;
      } else {
         if (this.k >= a.a.g()) {
            var1.setColor(0);
            var1.fillRect(0, 0, a.a.g(), a.a.h());
            return true;
         }

         switch (this.x) {
            case 0:
               var1.setColor(0);
               var1.fillRect(0, 0, this.k, a.a.j());

               for (int var5 = 1; var5 < 6; var5++) {
                  var1.fillRect(this.k + var5 * 15, 0, 15 - var5 * 3, a.a.j());
               }

               var1.fillRect(a.a.g() - this.k, a.a.j(), this.k, a.a.j());

               for (int var6 = 1; var6 < 6; var6++) {
                  var1.fillRect(a.a.g() - this.k - var6 * 15, a.a.j(), 15 - var6 * 3, a.a.j());
               }

               this.k += 15;
               break;
            case 1:
               var1.setColor(0);
               boolean var4 = false;

               for (byte var7 = 0; var7 < a.a.h(); var7 += 10) {
                  if (var4) {
                     var1.fillRect(0, var7, this.k, 10);
                     var4 = false;
                  } else {
                     var1.fillRect(a.a.g() - this.k, var7, this.k, 10);
                     var4 = true;
                  }
               }

               this.k += 15;
               break;
            case 2:
               var1.setColor(0);
               boolean var2 = false;

               for (byte var3 = 0; var3 < a.a.g(); var3 += 10) {
                  if (var2) {
                     var1.fillRect(var3, 0, 10, this.k);
                     var2 = false;
                  } else {
                     var1.fillRect(var3, a.a.h() - this.k, 10, this.k);
                     var2 = true;
                  }
               }

               this.k += 15;
         }
      }

      return false;
   }

   private boolean e(Graphics var1) {
      int var2 = this.n & 16777215;
      int var3 = 0;
      int var4 = this.s;
      int var5 = 255 / ((var4 << 1) + 1);
      int var6;
      int var7;
      int var10000 = var7 = (var6 = this.r / 2) * 200 / 120;
      int var8 = var10000 * var10000;
      int var10 = this.t / this.r + 1;
      int var11 = a.a.g() / this.r;
      int var12 = a.a.h() / this.r;
      int var13 = var11 / 2;
      int var14 = var12 / 2;
      int[] var15 = new int[var7];
      if (this.u == null) {
         this.u = new int[a.e.a(var13 * var13 + var14 * var14, 0)][];
      }

      if (this.v == null) {
         this.v = new int[this.u.length];
      }

      if (var10 > this.u.length) {
         var10 = this.u.length;
      }

      for (int var16 = 0; var16 < var10; var16++) {
         if (this.u[var16] == null) {
            this.u[var16] = new int[this.r * this.r];
         }

         if (this.v[var16] < var7 + var4) {
            int var9 = -var4 + this.v[var16];

            for (int var17 = 0; var17 < var15.length; var17++) {
               int var18;
               if ((var18 = var17 - var9) > var4) {
                  var3 = this.a == 4 ? 0 : 255;
               } else if (var18 < -var4) {
                  var3 = this.a == 4 ? 255 : 0;
               } else if (this.a == 4) {
                  var3 = 127 - var18 * var5;
               } else if (this.a == 5) {
                  var3 = 127 + var18 * var5;
               }

               var15[var17] = var2 | var3 << 24;
            }

            int var28 = var7 - 1;
            int var31 = var9 + var4;
            if ((var9 = var9 - var4) < 0) {
               var9 = 0;
            }

            int var19 = var31 * var8 / var28;
            int var20 = var9 * var8 / var28;

            for (int var25 = 0; var25 < this.r; var25++) {
               var31 = (var25 - var6) * (var25 - var6);
               int var21 = var25 * this.r;

               for (int var23 = 0; var23 < this.r; var23++) {
                  int var22 = a.e.a(var28 = var31 + (var23 - var6) * (var23 - var6), 1);
                  if (var28 > var19) {
                     this.u[var16][var21 + var23] = this.a == 4 ? 0 : -16777216;
                  } else if (var28 < var20) {
                     this.u[var16][var21 + var23] = this.a == 4 ? -16777216 : 0;
                  } else {
                     this.u[var16][var21 + var23] = var15[var22];
                  }
               }
            }

            this.v[var16]++;
         }
      }

      boolean var27 = true;
      var1.setColor(var2);

      for (int var30 = 0; var30 < var12; var30++) {
         int var33 = (var30 - var14) * (var30 - var14);

         for (int var34 = 0; var34 < var11; var34++) {
            int var26 = a.e.a(var33 + (var34 - var13) * (var34 - var13), 1);
            if (this.u[var26] == null) {
               if (this.a == 5) {
                  var1.fillRect(var34 * this.r, var30 * this.r, this.r, this.r);
               }
            } else if (this.v[var26] >= var7 + var4) {
               if (this.a == 4) {
                  var1.fillRect(var34 * this.r, var30 * this.r, this.r, this.r);
               }
            } else {
               var27 = false;
               var1.drawRGB(this.u[var26], 0, this.r, var34 * this.r, var30 * this.r, this.r, this.r, true);
            }
         }
      }

      if (var27) {
         this.f();
         return true;
      } else {
         this.t += 15;
         return false;
      }
   }

   private static int[] a(int[] var0, int[] var1, int var2, int var3, byte var4) {
      if (var4 == 5) {
         for (int var9 = 0; var9 < var3; var9++) {
            int var5 = var9 * var2;
            int var6 = -1 - var9;
            int var7 = 0;

            for (int var8 = 1; var7 < var2; var8++) {
               var1[var8 * var3 + var6] = var0[var5 + var7];
               var7++;
            }
         }
      } else if (var4 == 3) {
         var4 = var2 * var3 - 1;

         for (int var14 = 0; var14 < var3; var14++) {
            int var18 = var14 * var2;
            int var22 = var4 - var14 * var2;

            for (int var26 = 0; var26 < var2; var26++) {
               var1[var22 - var26] = var0[var18 + var26];
            }
         }
      } else if (var4 == 6) {
         var4 = var2 - 1;

         for (int var15 = 0; var15 < var3; var15++) {
            int var19 = var4 * var3 + var15;
            int var23 = var15 * var2;

            for (int var27 = 0; var27 < var2; var27++) {
               var1[var19 - var27 * var3] = var0[var23 + var27];
            }
         }
      } else if (var4 != 0 && var4 != 7) {
         if (var4 == 1) {
            var4 = var3 - 1;

            for (int var16 = 0; var16 < var3; var16++) {
               int var20 = var16 * var2;
               int var24 = (var4 - var16) * var2;

               for (int var28 = 0; var28 < var2; var28++) {
                  var1[var24 + var28] = var0[var20 + var28];
               }
            }
         } else if (var4 != 4 && var4 == 2) {
            var4 = var2 - 1;

            for (int var17 = 0; var17 < var3; var17++) {
               int var21;
               int var25 = (var21 = var17 * var2) + var4;

               for (int var29 = 0; var29 < var2; var29++) {
                  var1[var25 - var29] = var0[var21 + var29];
               }
            }
         }
      }

      return var1;
   }

   public final void a(byte var1) {
      this.h = -1;
      this.O = null;
   }

   public final void a(byte var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.h = 0;
      this.b(var2, var3);
      this.ad = var4;
      this.ae = var5;
      this.af = var6;
      this.ag = var7;
   }

   public final void a(int var1, int var2) {
      this.af = var1;
      this.ag = var2;
   }

   public final void b(int var1, int var2) {
      this.ab = var1;
      this.ac = var2;
   }

   public final void a(Graphics var1, int var2, int var3) {
      var1.setColor(0);
      var1.fillRect(0, 0, this.ad, this.ac - this.ag);
      var1.fillRect(0, this.ac - this.ag, this.ab - this.af, this.ag << 1);
      var1.fillRect(0, this.ac + this.ag, this.ad, this.ae - (this.ac + this.ag));
      var1.fillRect(this.ab + this.af, this.ac - this.ag, this.ad - (this.ab + this.af), this.ag << 1);
   }

   public final void c(int var1, int var2) {
      this.l = 0;
      this.n = var1;
      if (var2 == 12 || var2 == 13) {
         this.b = var2;
         this.e = false;
      } else if (var2 == 18) {
         this.c = var2;
      } else {
         this.a = var2;
      }

      this.d = false;
      switch (this.a) {
         case 1:
         case 2:
            this.g = 17;
            return;
         case 3:
            this.l = a.a.i();
            this.m = 20;
            return;
         case 4:
         case 5:
            this.t = 0;
            return;
         case 6:
            this.k = 0;
            this.x = a.e.a(2);
            return;
         case 7:
            this.k = 0;
            this.o = null;
            this.p = null;
            this.o = new int[a.a.g() * a.a.h()];
            this.p = new int[this.o.length];

            for (int var3 = 0; var3 < this.o.length; var3++) {
               if (var3 % a.a.g() / 10 % 2 == 0) {
                  this.o[var3] = -2013265920 | this.o[var3] & 16777215;
                  this.p[var3] = this.p[var3] & 16777215;
               } else {
                  this.p[var3] = -2013265920 | this.p[var3] & 16777215;
                  this.o[var3] = this.o[var3] & 16777215;
               }
            }

            return;
         case 8:
            this.k = 0;
            z.aw();
            this.a(0);
            return;
         case 10:
         case 17:
            this.k = 0;
            return;
         case 19:
            this.c(-1);
            return;
         case 20:
            this.c(1);
         case 9:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 18:
      }
   }

   public final void a(int var1, int var2, int var3) {
      a.b.b.a().a = 3;
      this.C = var1;
      this.D = var2;
      this.E = var3;
   }

   public final void a(int var1, int var2, int var3, int var4, int var5) {
      this.f = 0;
      this.G = var1;
      this.H = var2;
      this.I = var3;
      this.J = var4;
      this.K = var5;
   }

   public final void d(int var1, int var2) {
      this.L = var1;
      this.M = var2;
   }

   public final void a(int var1, int var2, int var3, int var4) {
      this.S = var1;
      this.T = var2;
      this.U = var3;
      this.R = var4;
   }

   public final void a(String var1, int var2, int var3, int var4) {
      if (game.e.k == 1) {
         this.N = a.e.b("/data/tex/", var1);
         this.N = a.a.d.a(this.N);
      } else {
         this.N = a.e.b("/data/tex/", var1);
      }

      this.O = new c();
      this.O = a.a.d.a(this.N, this.O);
      this.P = var2;
      this.Q = var3;
      this.g = var4;
   }

   public final void e() {
      this.k = 0;
      A = new short[][]{
         {7},
         {8},
         {10},
         {12},
         {16},
         {18},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {20},
         {200, 200, 100, 100, 50, 50, 0, 0},
         {38, 38, 39, 39, 40, 40, 41, 41, 42, 42},
         {43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 48}
      };
      z.v();
      this.a(0);
   }

   private void f() {
      this.o = null;
      this.p = null;
      this.q = null;
      this.u = null;
      this.v = null;
      this.N = null;
   }

   public final void a(int var1, int var2, byte var3, byte var4, Image var5, String[] var6) {
      this.j = var1;
      if (this.a != 17 || this.S != 0) {
         this.a = -1;
         if (this.j >= 16) {
            this.ai = var3;
            this.am = var1;
            this.an = 0;
            this.ao = var4;
            this.ak = var5;
            this.aj = null;
            this.aj = new Image[var6.length];

            for (int var7 = 0; var7 < var6.length; var7++) {
               this.aj[var7] = a.e.b("/data/tex/", var6[var7]);
            }

            this.al = new int[var3][5];

            for (int var8 = 0; var8 < var3; var8++) {
               this.b(var8);
            }
         }
      }
   }

   private void b(int var1) {
      int var2;
      if ((var2 = a.e.a(100)) < 3) {
         this.al[var1][0] = this.aj.length - 1;
      } else if (var2 < 15) {
         this.al[var1][0] = this.aj.length - 2;
      } else if (var2 < 50) {
         this.al[var1][0] = this.aj.length - 3;
      } else {
         this.al[var1][0] = 0;
      }

      this.al[var1][1] = a.e.a(a.a.g());
      this.al[var1][2] = a.e.a(a.a.h());
      this.al[var1][3] = a.e.a(ah[this.al[var1][0]][1] - ah[this.al[var1][0]][0]) + ah[this.al[var1][0]][0];
      this.al[var1][4] = a.e.b(2);
   }

   public final void b(Graphics var1) {
      if (this.j >= 16) {
         if (this.ak == null) {
            var1.setColor(0);
            var1.fillRect(0, 0, a.a.g(), a.a.h());
         } else {
            int var2 = this.ak.getWidth();

            for (int var3 = 0; var3 < a.a.g() / var2; var3++) {
               var1.drawImage(this.ak, var3 * var2, 0, 20);
            }
         }

         this.aq = false;
      }
   }

   public final void c(Graphics var1) {
      if (this.j >= 16 || this.aq) {
         for (int var2 = 0; var2 < this.ai; var2++) {
            if (this.al[var2][1] < a.a.g() && this.al[var2][2] < a.a.h()) {
               var1.drawImage(this.aj[this.al[var2][0]], this.al[var2][1], this.al[var2][2], 20);
            }

            switch (this.ao) {
               case 0:
                  this.al[var2][2] = this.al[var2][2] - this.al[var2][3];
                  break;
               case 1:
                  this.al[var2][1] = this.al[var2][1] + this.al[var2][3];
                  this.al[var2][2] = this.al[var2][2] - this.al[var2][3];
                  break;
               case 2:
                  this.al[var2][1] = this.al[var2][1] + this.al[var2][3];
                  break;
               case 3:
                  this.al[var2][1] = this.al[var2][1] + this.al[var2][3];
                  this.al[var2][2] = this.al[var2][2] + this.al[var2][3];
                  break;
               case 4:
                  this.al[var2][2] = this.al[var2][2] + this.al[var2][3];
                  break;
               case 5:
                  this.al[var2][1] = this.al[var2][1] - this.al[var2][3];
                  this.al[var2][2] = this.al[var2][2] + this.al[var2][3];
                  break;
               case 6:
                  this.al[var2][1] = this.al[var2][1] - this.al[var2][3];
                  break;
               case 7:
                  this.al[var2][1] = this.al[var2][1] - this.al[var2][3];
                  this.al[var2][2] = this.al[var2][2] - this.al[var2][3];
            }

            if (this.al[var2][1] < this.am - this.aj[this.al[var2][0]].getWidth() || this.al[var2][2] < this.an - this.aj[this.al[var2][0]].getHeight()) {
               this.b(var2);
            }
         }
      }
   }

   private void c(int var1) {
      X[0] = 20;
      W = a.a.g() / X[0];
      X[1] = (a.a.h() - 1) / X[0] + 1;
      X[2] = var1;
      X[3] = a.e.b(0, 7);
      X[4] = 0;
      this.d = false;
   }

   private boolean f(Graphics var1) {
      var1.setColor(this.n);
      int var2 = 0;

      for (int var3 = 0; var3 < W; var3++) {
         for (int var4 = 0; var4 < X[1]; var4++) {
            switch (X[2]) {
               case -1:
                  var2 = 0;
                  break;
               case 1:
                  var2 = X[0];
            }

            switch (X[3]) {
               case 0:
                  int var12;
                  var2 = (var12 = var2 + (var4 - X[4]) * X[2]) < 0 ? 0 : (var12 > X[0] ? X[0] : var12);
                  break;
               case 1:
                  int var11;
                  var2 = (var11 = var2 + (X[1] - var4 - X[4]) * X[2]) < 0 ? 0 : (var11 > X[0] ? X[0] : var11);
                  break;
               case 2:
                  int var10;
                  var2 = (var10 = var2 + (var3 - X[4]) * X[2]) < 0 ? 0 : (var10 > X[0] ? X[0] : var10);
                  break;
               case 3:
                  int var9;
                  var2 = (var9 = var2 + (8 - var3 - X[4]) * X[2]) < 0 ? 0 : (var9 > X[0] ? X[0] : var9);
                  break;
               case 4:
                  int var8;
                  var2 = (var8 = var2 + ((var3 + var4 >> 1) - X[4]) * X[2]) < 0 ? 0 : (var8 > X[0] ? X[0] : var8);
                  break;
               case 5:
                  int var7;
                  var2 = (var7 = var2 + ((8 - var3 + var4 >> 1) - X[4]) * X[2]) < 0 ? 0 : (var7 > X[0] ? X[0] : var7);
                  break;
               case 6:
                  int var6;
                  var2 = (var6 = var2 + ((var3 + X[1] - var4 >> 1) - X[4]) * X[2]) < 0 ? 0 : (var6 > X[0] ? X[0] : var6);
                  break;
               case 7:
                  int var5;
                  var2 = (var5 = var2 + ((8 - var3 + X[1] - var4 >> 1) - X[4]) * X[2]) < 0 ? 0 : (var5 > X[0] ? X[0] : var5);
            }

            var1.fillRect(X[0] * var3 + (X[0] - var2 >> 1), X[0] * var4 + (X[0] - var2 >> 1), var2, var2);
         }
      }

      X[4] = X[4] + 2;
      if (X[4] > 40) {
         if (this.a == 20) {
            this.a = -1;
         }

         if (this.a == 19) {
            var1.fillRect(0, 0, a.a.g(), a.a.h());
         }

         return true;
      } else {
         return false;
      }
   }

   static {
      byte[] var10000 = new byte[]{0, 5, 3, 6, 2, 7, 1, 4};
   }
}
