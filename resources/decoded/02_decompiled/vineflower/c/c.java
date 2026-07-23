package c;

import javax.microedition.lcdui.Graphics;

public final class c {
   private f[] a = new f[200];
   private int b = 0;
   private int c = -1;
   private c.b d;
   private int[] e = new int[]{0, 1, 2, 3, 5, 6, 7, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
   private int[] f = null;
   private int[] g = null;
   private d h;
   private c.a i;

   public c(c.a var1) {
      this.i = var1;
      this.d();
   }

   private void d() {
      this.c = -1;
      this.d = new c.b();
      this.d.a(0);
      this.d.c(-1);
      this.f = a.e.c(100);
      this.f();
   }

   public final c.b a() {
      return this.d;
   }

   public final void a(d var1) {
      this.h = var1;
   }

   public final void a(String var1, int var2, boolean var3) {
      this.d();
      byte[] var7;
      a.e.b(var7 = new byte[20000], var1, 0);
      int[] var5 = new int[]{0};
      this.c = a.e.d(var7, var5);
      this.c = 0;
      a.e.d(var7, var5);
      short var4 = a.e.c(var7, var5);
      this.d.b(var4);
      var4 = a.e.d(var7, var5);
      this.d.a(var4);
      var4 = a.e.d(var7, var5);
      this.d.a(var4, this.d);
      var4 = a.e.d(var7, var5);
      this.d.b(var4, this.d);
      var4 = a.e.d(var7, var5);
      this.d.c(var4, this.d);
      var4 = a.e.d(var7, var5);
      this.d.d(var4, this.d);
      this.a[this.b] = this.d;
      this.b = 1;
      this.a(var7, var5, this.d, var2, false);
      c var6 = this;
      this.f = a.e.c(50);
      var6.a(var6.d, -1);
   }

   private void a(byte[] var1, int[] var2, c.b var3, int var4, boolean var5) {
      byte var6;
      if ((var6 = a.e.c(var1, var2)) > 0) {
         byte[][] var7 = new byte[var6][4];

         for (int var8 = 0; var8 < var6; var8++) {
            var7[var8][0] = a.e.c(var1, var2);
            var7[var8][1] = a.e.c(var1, var2);
            var7[var8][2] = a.e.c(var1, var2);
            var7[var8][3] = a.e.c(var1, var2);
         }

         var3.a(var7);
      }

      short var20 = a.e.c(var1, var2);

      for (int var23 = 0; var23 < var20; var23++) {
         var6 = a.e.c(var1, var2);
         l var9;
         (var9 = new l(var6)).g = a.e.c(var1, var2) != 0;
         var9.d = a.e.d(var1, var2);
         var9.a = a.e.d(var1, var2);
         var9.h = a.e.c(var1, var2);
         var9.i = a.e.c(var1, var2);

         for (int var10 = 0; var10 < var9.a; var10++) {
            short var11 = a.e.d(var1, var2);
            var9.b[var10] = var11;
            short var12;
            byte[] var13 = new byte[var12 = a.e.d(var1, var2)];

            for (int var14 = 0; var14 < var12; var14++) {
               var13[var14] = a.e.c(var1, var2);
            }

            var9.o.addElement(a.e.a(var13));
         }

         var9.c = new int[var9.d + this.e.length][][];

         for (int var29 = 0; var29 < var9.c.length; var29++) {
            var9.c[var29] = new int[0][];
         }

         short var30 = a.e.d(var1, var2);

         for (int var34 = 0; var34 < var30; var34++) {
            short var41 = a.e.d(var1, var2);
            short var46;
            int[][] var51 = new int[var46 = a.e.d(var1, var2)][];

            for (int var15 = 0; var15 < var46; var15++) {
               var51[var15] = new int[5];
               var51[var15][0] = a.e.d(var1, var2);
               var51[var15][1] = a.e.d(var1, var2);
               var51[var15][2] = a.e.d(var1, var2);
               var51[var15][3] = a.e.d(var1, var2);
               var51[var15][4] = a.e.d(var1, var2);
            }

            var9.c[var41] = var51;
         }

         if (var6 == 0) {
            var3.a = var9;
         } else {
            var3.b = var9;
         }
      }

      short var24 = a.e.d(var1, var2);

      for (int var19 = 0; var19 < var24; var19++) {
         byte var25;
         if ((var25 = a.e.c(var1, var2)) == 0) {
            c.b var33;
            (var33 = new c.b()).b(var25);
            var33.a(a.e.d(var1, var2));
            var33.a(a.e.d(var1, var2), this.a());
            var33.b(a.e.d(var1, var2), this.a());
            var33.c(a.e.d(var1, var2), this.a());
            var33.d(a.e.d(var1, var2), this.a());
            var33.c(var3.b());
            if (var3.a != null) {
               for (int var39 = 0; var39 < var3.a.b.length; var39++) {
                  if (var3.a.b[var39] == var33.b()) {
                     var33.a(var3.a);
                     break;
                  }
               }
            }

            if (var3.b != null) {
               for (int var40 = 0; var40 < var3.b.b.length; var40++) {
                  if (var3.b.b[var40] == var33.b()) {
                     var33.a(var3.b);
                     break;
                  }
               }
            }

            this.a[this.b] = var33;
            this.b++;
            var3.h()[var19] = var33;
            this.a(var1, var2, (c.b)var3.h()[var19], var4, var5);
         } else if (var25 == 1) {
            h var32;
            (var32 = new h()).b(var25);
            var32.a(a.e.d(var1, var2));
            var32.a(a.e.d(var1, var2), this.a());
            var32.b(a.e.d(var1, var2), this.a());
            var32.c(a.e.d(var1, var2), this.a());
            var32.d(a.e.d(var1, var2), this.a());
            var32.a();
            var32.c = this.h;
            short var38;
            byte[] var45 = new byte[var38 = a.e.d(var1, var2)];

            for (int var49 = 0; var49 < var38; var49++) {
               var45[var49] = a.e.c(var1, var2);
            }

            var32.i().a = a.e.a(var45);
            var32.i().b = a.e.c(var1, var2);
            var32.i().c = a.e.c(var1, var2);
            var32.i().d = a.e.c(var1, var2) != 0;
            var32.i().e = a.e.e(var1, var2);
            var32.i().f = a.e.e(var1, var2);
            var32.i().g = a.e.e(var1, var2);
            short var50 = a.e.d(var1, var2);
            byte var55 = a.e.c(var1, var2);
            if (var50 < 0) {
               var32.i().i = null;
            } else {
               var32.i().i = new g();
               var32.i().i.a = var55;
               var32.i().i.a(var50);
            }

            var32.i().j = a.e.e(var1, var2);
            var32.i().k = a.e.e(var1, var2);
            var32.i().l = a.e.e(var1, var2);
            short var57 = a.e.d(var1, var2);
            var20 = a.e.c(var1, var2);
            if (var57 < 0) {
               var32.i().m = null;
            } else {
               var32.i().m = new g();
               var32.i().m.a(var57);
               var32.i().m.a = var20;
            }

            var32.i().h = a.e.c(var1, var2);
            if (var32.i().i != null) {
               var32.i().i.a(var4, var5, var32.i().h);
            }

            if (var32.i().m != null) {
               var32.i().m.a(var4, var5, var32.i().h);
            }

            var32.c(var3.b());
            if (var3.a != null) {
               for (int var27 = 0; var27 < var3.a.b.length; var27++) {
                  if (var3.a.b[var27] == var32.b()) {
                     var32.a(var3.a);
                     break;
                  }
               }
            }

            if (var3.b != null) {
               for (int var28 = 0; var28 < var3.b.b.length; var28++) {
                  if (var3.b.b[var28] == var32.b()) {
                     var32.a(var3.b);
                     break;
                  }
               }
            }

            this.a[this.b] = var32;
            this.b++;
            var3.h()[var19] = var32;
            var32.a = a.e.c(var1, var2);
            var32.b = a.e.c(var1, var2);
         } else if (var25 == 2) {
            m var31;
            (var31 = new m()).q(a.e.d(var1, var2));
            var31.a(a.e.d(var1, var2), this.a());
            var31.b(a.e.d(var1, var2), this.a());
            var31.a((int)a.e.c(var1, var2));
            var31.b(a.e.c(var1, var2));
            var31.c(a.e.c(var1, var2));
            var31.d(a.e.c(var1, var2));
            var31.e(a.e.c(var1, var2));
            var31.f(a.e.c(var1, var2));
            var31.g(a.e.c(var1, var2));
            var31.h(a.e.c(var1, var2));
            var31.k(a.e.c(var1, var2));
            var31.l(a.e.c(var1, var2));
            var31.m(a.e.c(var1, var2));
            var31.n(a.e.c(var1, var2));
            var31.o(a.e.c(var1, var2));
            var31.p(a.e.c(var1, var2));
            var31.i(a.e.c(var1, var2));
            var31.j(a.e.c(var1, var2));
            var31.a = a.e.e(var1, var2);
            short var35 = a.e.d(var1, var2);
            short var42 = a.e.c(var1, var2);
            if (var35 < 0) {
               var31.b = null;
            } else {
               var31.b = new g();
               var31.b.a(var35);
               var31.b.a = (byte)var42;
               var31.b.a(var4, var5, (byte)var42);
            }

            var35 = a.e.d(var1, var2);
            var42 = a.e.c(var1, var2);
            if (var35 < 0) {
               var31.c = null;
            } else {
               var31.c = new g();
               var31.c.a(var35);
               var31.c.a = var42;
               var31.c.a(var4, var5, var42);
            }

            var31.r(a.e.d(var1, var2));
            byte var47;
            if ((var47 = a.e.c(var1, var2)) == 0) {
               var31.e = var31.n();
            } else if (var47 == 1) {
               var31.e = m.a(var31.a(), var31.m());
               short var52 = a.e.d(var1, var2);

               for (int var56 = 0; var56 < var52; var56++) {
                  var20 = a.e.d(var1, var2);
                  var25 = a.e.d(var1, var2);
                  byte var37 = a.e.c(var1, var2);
                  var42 = a.e.d(var1, var2);
                  var47 = a.e.d(var1, var2);
                  short var16 = a.e.d(var1, var2);
                  short var17 = a.e.d(var1, var2);
                  var31.e[var20] = new e(var25, var37, var42, var47, var16, var17);
               }
            }

            var31.s(var3.b());
            if (var3.a != null) {
               for (int var53 = 0; var53 < var3.a.b.length; var53++) {
                  if (var3.a.b[var53] == var31.b()) {
                     break;
                  }
               }
            }

            if (var3.b != null) {
               for (int var54 = 0; var54 < var3.b.b.length; var54++) {
                  if (var3.b.b[var54] == var31.b()) {
                     break;
                  }
               }
            }

            this.a[this.b] = var31;
            this.b++;
            var3.h()[var19] = var31;
         }
      }
   }

   private k a(f var1) {
      if (var1.j() != 0) {
         return new k(var1.c(), var1.d(), var1.e(), var1.f());
      }

      c.b var2;
      if ((var2 = (c.b)var1).h() != null && var2.h()[0] != null) {
         int var8 = this.a(var2.h()[0]).a;
         int var3 = this.a(var2.h()[0]).a + this.a(var2.h()[0]).c;
         int var4 = this.a(var2.h()[0]).b;
         int var5 = this.a(var2.h()[0]).b + this.a(var2.h()[0]).d;

         for (int var6 = 0; var6 < var2.h().length && var2.h()[var6] != null; var6++) {
            k var7 = this.a(var2.h()[var6]);
            if (var8 > var7.a) {
               var8 = var7.a;
            }

            if (var3 < var7.a + var7.c) {
               var3 = var7.a + var7.c;
            }

            if (var4 > var7.b) {
               var4 = var7.b;
            }

            if (var5 < var7.b + var7.d) {
               var5 = var7.b + var7.d;
            }
         }

         return new k(var8, var4, var3 - var8, var5 - var4);
      } else {
         return new k(var1.c(), var1.d(), var1.e(), var1.f());
      }
   }

   public final void a(Graphics var1) {
      Graphics var2;
      c.b var3;
      c var4;
      Graphics var5;
      l var10000;
      label96: {
         var3 = this.d;
         var2 = var1;
         var15 = this;
         c.b var6 = var3;
         var5 = var2;
         var4 = this;
         c.b var7 = var6;
         if (var6.a != null || var7.b != null) {
            if (var7.a == null && var7.b != null) {
               var10000 = var7.b;
               break label96;
            }

            if (var7.a != null && var7.b == null) {
               var10000 = var7.a;
               break label96;
            }
         }

         var10000 = null;
      }

      l var20 = var10000;
      if (var10000 != null && var20.d < var20.a) {
         c var8;
         c var25 = var8 = var4;
         l var16 = var20;
         c var22 = var25;
         int var9 = 0;
         int var10 = 0;
         int var11 = 0;
         int var12 = 0;
         if (var16.b[0] != -1) {
            k var13;
            var9 = (var13 = var22.a(var8.a(var16.b[0]))).a;
            var10 = var13.a + var13.c;
            var11 = var13.b;
            var12 = var13.b + var13.d;

            for (int var14 = 1; var14 != var16.d; var14++) {
               var13 = var22.a(var8.a(var16.b[var14]));
               if (var9 > var13.a) {
                  var9 = var13.a;
               }

               if (var10 < var13.a + var13.c) {
                  var10 = var13.a + var13.c;
               }

               if (var11 > var13.b) {
                  var11 = var13.b;
               }

               if (var12 < var13.b + var13.d) {
                  var12 = var13.b + var13.d;
               }
            }
         }

         new k(var9, var11, var10 - var9, var12 - var11);
         k var17 = new k();
         k var23 = new k();
         if (var20.j != 0) {
            ;
         }

         var5.setColor(255, 255, 255);
         var5.fillRect(var17.a, var17.b, var17.c, var17.d);
         var5.setColor(245, 222, 179);
         var5.drawRect(var17.a, var17.b, var17.c, var17.d);
         var5.setColor(95, 158, 160);
         var5.fillRect(var23.a, var23.b, var23.c, var23.d);
      }

      for (int var18 = 0; var18 < var3.h().length && var3.h()[var18] != null; var18++) {
         if (var3.h()[var18].g() != null) {
            boolean var19 = false;
            int var21;
            if ((var21 = a.e.a(var15.g)) > 0 && var15.g[var21 - 1] == var3.b()) {
               var19 = true;
            }

            var3.h()[var18].g().a(var2, var3.h()[var18].b(), var19, var15.g, true, var15.d);
         } else {
            var3.h()[var18].a(var2, false, true, var15.d, var15.g);
         }
      }
   }

   public final void b() {
      boolean var1 = true;
      c.b var2 = this.d;
      c var4 = this;

      for (int var3 = 0; var3 < var2.h().length && var2.h()[var3] != null; var3++) {
         if (var2.h()[var3].g() != null) {
            if (a.e.a(var4.g) > 0) {
               var2.b();
            }

            var2.h()[var3].g().a(var2.h()[var3].b(), var4.g, true, var4.d);
         } else {
            var2.h()[var3].a(false, true, var4.d, var4.g);
         }
      }
   }

   public final f a(int var1) {
      return a.e.a(this.d, var1);
   }

   public final boolean b(int var1) {
      f var2;
      boolean var10;
      if ((var2 = this.a(this.d, this.f, 0)).j() == 2) {
         m var3 = (m)var2;
         int var12 = var1;
         c var9 = this;
         boolean var4 = false;
         switch (var12) {
            case 0:
               var4 = var3.a((byte)0);
               var9.i.a(new int[]{-1, -1, 0}, new int[]{-1, -1, -1, -1});
               break;
            case 1:
               var4 = var3.a((byte)1);
               var9.i.a(new int[]{-1, -1, 1}, new int[]{-1, -1, -1, -1});
               break;
            case 2:
               var4 = var3.a((byte)2);
               var9.i.a(new int[]{-1, -1, 2}, new int[]{-1, -1, -1, -1});
               break;
            case 3:
               var4 = var3.a((byte)3);
               var9.i.a(new int[]{-1, -1, 3}, new int[]{-1, -1, -1, -1});
            case 4:
            case 6:
            default:
               break;
            case 5:
               var9.i.a(new int[]{-1, -1, 4}, new int[]{-1, -1, -1, -1});
               var4 = true;
               break;
            case 7:
               if (var4 = var9.e()) {
                  var3.d = false;
                  var9.i.a(new int[]{-1, -1, 7}, new int[]{-1, -1, -1, -1});
               } else {
                  var9.i.a(new int[]{-1, -1, 5}, new int[]{-1, -1, -1, -1});
               }
         }

         var10 = var4;
      } else {
         c.b var14 = (c.b)var2;
         int var13 = var1;
         c var11 = this;
         boolean var15 = false;
         boolean var5 = false;
         byte[][] var6;
         if (var14.a() != null) {
            var6 = var14.a();
         } else {
            var6 = new byte[][]{{0, 0, 1, -1}, {1, 1, 1, -1}, {2, 2, 1, -1}, {3, 3, 1, -1}, {5, 4, -1, -1}, {7, 5, -1, -1}};
         }

         int[] var7 = new int[3];
         if (var14.b != null) {
            var7[1] = var14.b.f;
         } else {
            var7[1] = -1;
         }

         if (var14.a != null) {
            var7[0] = var14.a.f;
         } else {
            var7[0] = -1;
         }

         for (int var8 = 0; var8 < var6.length; var8++) {
            if (var6[var8][0] == var13) {
               var5 = true;
               var15 = false;
               switch (var6[var8][1]) {
                  case 0:
                     var7[2] = 0;
                     if (var14.a == null) {
                        var11.i.a(var7, new int[]{-1, -1, -1, -1});
                        break;
                     }

                     if (var6[var8][3] != -1 && var14.a.f % (var6[var8][3] + 1) == 0) {
                        var14.a.a(var6[var8][3], var11.d);
                     } else {
                        var14.a.b(var6[var8][2], var11.d);
                     }

                     var15 = true;
                     var7[0] = var14.a.f;
                     var11.i.a(var7, new int[]{-1, -1, -1, -1});
                     break;
                  case 1:
                     var7[2] = 1;
                     if (var14.a == null) {
                        var11.i.a(var7, new int[]{-1, -1, -1, -1});
                        break;
                     }

                     if (var6[var8][3] != -1 && (var14.a.f + 1) % (var6[var8][3] + 1) == 0) {
                        var14.a.b(var6[var8][3], var11.d);
                     } else {
                        var14.a.a(var6[var8][2], var11.d);
                     }

                     var15 = true;
                     var7[0] = var14.a.f;
                     var11.i.a(var7, new int[]{-1, -1, -1, -1});
                     break;
                  case 2:
                     var7[2] = 2;
                     if (var14.b == null) {
                        var11.i.a(var7, new int[]{-1, -1, -1, -1});
                        break;
                     }

                     if (var6[var8][3] != -1 && var14.b.f % (var6[var8][3] + 1) == 0) {
                        var14.b.a(var6[var8][3], var11.d);
                     } else {
                        var14.b.b(var6[var8][2], var11.d);
                     }

                     var15 = true;
                     var7[1] = var14.b.f;
                     var11.i.a(var7, new int[]{-1, -1, -1, -1});
                     break;
                  case 3:
                     var7[2] = 3;
                     if (var14.b == null) {
                        var11.i.a(var7, new int[]{-1, -1, -1, -1});
                        break;
                     }

                     if (var6[var8][3] != -1 && (var14.b.f + 1) % (var6[var8][3] + 1) == 0) {
                        var14.b.b(var6[var8][3], var11.d);
                     } else {
                        var14.b.a(var6[var8][2], var11.d);
                     }

                     var15 = true;
                     var7[1] = var14.b.f;
                     var11.i.a(var7, new int[]{-1, -1, -1, -1});
                     break;
                  case 4:
                     if (var14.b != null) {
                        if (var14.b.f >= a.e.a(var14.b.b)) {
                           var15 = var11.a(var14, var14.b.b[var14.b.f - var14.b.e]);
                        } else {
                           var15 = var11.a(var14, var14.b.b[var14.b.f]);
                        }
                     }

                     if (!var15 && var14.a != null) {
                        if (var14.a.f >= a.e.a(var14.a.b)) {
                           var15 = var11.a(var14, var14.a.b[var14.a.f - var14.a.e]);
                        } else {
                           var15 = var11.a(var14, var14.a.b[var14.a.f]);
                        }
                     }

                     if (var15) {
                        var7[2] = 6;
                        var11.i.a(var7, new int[]{-1, -1, -1, -1});
                     } else {
                        var7[2] = 4;
                        var11.i.a(var7, new int[]{-1, -1, -1, -1});
                     }
                     break;
                  case 5:
                     if (var15 = var11.e()) {
                        var7[2] = 7;
                        var11.i.a(var7, new int[]{-1, -1, -1, -1});
                     } else {
                        var7[2] = 5;
                        var11.i.a(var7, new int[]{-1, -1, -1, -1});
                     }
               }

               if (var15) {
                  break;
               }
            }
         }

         if (!var5) {
            switch (var13) {
               case 14:
               case 15:
               case 16:
               case 17:
               case 18:
               case 19:
               case 20:
               case 21:
               case 22:
               case 23:
                  var7[2] = var13 - 6;
                  var11.i.a(var7, new int[]{-1, -1, -1, -1});
            }
         }

         var10 = var15;
      }

      return var10;
   }

   private boolean e() {
      boolean var1 = false;
      int var2 = -1;

      for (int var3 = a.e.a(this.g) - 2; var3 >= 0; var3--) {
         f var4;
         if (((c.b)(var4 = a.e.a(this.d, this.g[var3]))).a != null || ((c.b)var4).b != null) {
            var1 = true;
            var2 = var4.b();
            break;
         }
      }

      if (var1) {
         this.f = this.c(var2);
         if (this.f == null) {
            this.f = a.e.c(50);
         }

         this.f();
      }

      return var1;
   }

   private boolean a(f var1, int var2) {
      if (var1.j() == 1) {
         return false;
      }

      int var3;
      if ((var3 = this.a(var1, var2, true)) == -1) {
         return false;
      }

      this.f = this.c(var3);
      if (this.f == null) {
         this.f = a.e.c(50);
      }

      this.f();
      return true;
   }

   private void f() {
      this.g = a.e.c(50);
      f var1 = this.d;
      int var2 = 0;
      var2++;
      this.g[0] = var1.b();

      for (int var3 = 0; var3 < this.f.length && this.f[var3] != -1; var3++) {
         var1 = var1.h()[this.f[var3]];
         this.g[var2++] = var1.b();
      }
   }

   private int a(f var1, int var2, boolean var3) {
      if (var1.j() == 2 && var2 == -1) {
         if (var3) {
            ((m)var1).d = true;
         }

         return var1.b();
      } else {
         if ((((c.b)var1).a != null || ((c.b)var1).b != null) && var2 == -1) {
            return var1.b();
         }

         for (int var4 = 0; var4 < var1.h().length && var1.h()[var4] != null; var4++) {
            int var5;
            if (var1.h()[var4].j() != 1 && (var2 == -1 || var1.h()[var4].b() == var2) && (var5 = this.a(var1.h()[var4], -1, var3)) != -1) {
               return var5;
            }
         }

         return -1;
      }
   }

   private int[] c(int var1) {
      int[] var2 = a.e.c(50);

      for (f var5 = a.e.a(this.d, var1); var5.k() != -1; var5 = a.e.a(this.d, var5.k())) {
         f var3 = a.e.a(this.d, var5.k());

         for (int var4 = 0; var4 < var3.h().length && var3.h()[var4] != null; var4++) {
            if (var3.h()[var4].b() == var5.b()) {
               a.e.a(var2, 0, var4);
               break;
            }
         }
      }

      return var2;
   }

   private f a(f var1, int[] var2, int var3) {
      int var4;
      while ((var4 = a.e.a(var2)) != 0) {
         if (var3 == var4 - 1) {
            return var1.h()[var2[var3]];
         }

         f var10000 = var1.h()[var2[var3]];
         var3++;
         var2 = var2;
         var1 = var10000;
      }

      return var1;
   }

   public final void c() {
      this.d.l();
      this.e = null;
      this.f = null;
      this.g = null;
      this.i = null;
      this.a = null;
   }
}
