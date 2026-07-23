package a.a;

import javax.microedition.lcdui.Graphics;

public final class b extends a.b.a {
   private c[] c;
   private short[] u;
   public byte a;
   private int v = 0;
   private int w = 0;
   private int[] x = new int[]{262, 263, 264, 265, 266, 267, 268, 299, 300, 301, 304, 306, 307, 308, 309};
   public a.b.g b = new a.b.g();

   public final void a(short[] var1) {
      this.a = (byte)var1[0];
      switch (this.a) {
         case 0:
            this.u = new short[3];
            System.arraycopy(var1, 0, this.u, 0, this.u.length);
            this.b(var1[3], var1[4]);
            this.c = new c[3];
            a.b.g var16 = new a.b.g();

            for (int var27 = 0; var27 < 2; var27++) {
               var16.a(var1[5 + var27 * 3], false);
               int[] var35 = var16.b(var1[6 + var27 * 3], (byte)var1[7 + var27 * 3]);
               this.c[var27] = new c();
               this.c[var27] = a.a.d.a(var16, var1[6 + var27 * 3], var35, (byte)var1[7 + var27 * 3], this.c[var27]);
               var16.a();
            }

            this.c[2] = this.c[0].a();
            return;
         case 1:
            this.u = new short[var1.length - 6];
            this.o = (byte)var1[5];
            System.arraycopy(var1, 6, this.u, 0, this.u.length);
            this.b(var1[1], var1[2]);
            this.c = new c[3];
            a.b.g var15;
            (var15 = new a.b.g()).a(var1[3], false);
            int[] var26 = var15.b(var1[4], (byte)var1[5]);
            this.c[0] = new c();
            this.c[0] = a.a.d.a(var15, var1[4], var26, (byte)var1[5], this.c[0]);
            var15.a();
            this.c[1] = new c();
            this.c[1].a(a.b.c.e[this.u[2]], 16, 16);
            this.c[2] = this.c[0].a();
            return;
         case 2:
            return;
         case 3:
            return;
         case 4:
            return;
         case 5:
            return;
         case 6:
            return;
         case 7:
            this.u = new short[var1.length - 6];
            this.o = (byte)var1[5];
            System.arraycopy(var1, 6, this.u, 0, this.u.length);
            this.b(var1[1], var1[2]);
            this.c = new c[2];
            a.b.g var14;
            (var14 = new a.b.g()).a(var1[3], false);
            int[] var25 = var14.b(var1[4], (byte)var1[5]);
            this.c[0] = new c();
            this.c[0] = a.a.d.a(var14, var1[4], var25, (byte)var1[5], this.c[0]);
            this.c[1] = this.c[0].a();
            int var34 = var25[2] * var1[9] / var1[10];
            int var5 = var25[3] * var1[11] / var1[12];
            this.v = (var25[2] - var34) / 2;
            this.w = var25[3] - var5;
            this.c[1] = a.a.d.a(this.c[1], var34, var5);
            var14.a();
            return;
         case 8:
            this.u = new short[var1.length - 6];
            this.o = (byte)var1[5];
            System.arraycopy(var1, 6, this.u, 0, this.u.length);
            this.b(var1[1], var1[2]);
            this.c = new c[2];
            a.b.g var13;
            (var13 = new a.b.g()).a(var1[3], false);
            int[] var24 = var13.b(var1[4], (byte)var1[5]);
            this.c[0] = new c();
            this.c[0] = a.a.d.a(var13, var1[4], var24, (byte)var1[5], this.c[0]);
            var13.a();
            this.c[1] = this.c[0].a();
            if (this.u[4] == 1) {
               this.c[1] = a.a.d.b(a.a.d.a(this.c[1], this.u[2]), 1, 50);
               this.c[1].d = this.c[1].d + this.u[3];
               this.c[1].e = this.c[1].e + this.u[4];
            }

            return;
         case 9:
            this.u = new short[var1.length - 10];
            this.o = (byte)var1[5];
            System.arraycopy(var1, 10, this.u, 0, this.u.length);
            this.b(var1[1], var1[2]);
            this.c = new c[2];
            a.b.g var12;
            (var12 = new a.b.g()).a(var1[3], false);
            int[] var23 = var12.b(var1[4], (byte)var1[5]);
            this.c[0] = new c();
            this.c[0] = a.a.d.a(var12, var1[4], var23, (byte)var1[5], this.c[0]);
            this.c[1] = this.c[0].a();
            this.c[1] = a.a.d.a(this.c[1], var1[6], var1[7], var1[8], var1[9]);
            this.c[1] = a.a.d.b(this.c[1], 1, 50);
            var12.a();
            return;
         case 10:
            this.u = new short[var1.length - 7];
            this.o = (byte)var1[5];
            System.arraycopy(var1, 7, this.u, 0, this.u.length);
            this.b(var1[1], var1[2]);
            this.c = new c[2];
            a.b.g var11;
            (var11 = new a.b.g()).a(var1[3], false);
            int[] var22 = var11.b(var1[4], (byte)var1[5]);
            this.c[0] = new c();
            this.c[0] = a.a.d.a(var11, var1[4], var22, (byte)var1[5], this.c[0]);
            this.c[1] = this.c[0].a();
            this.c[1] = a.a.d.b(this.c[1], var1[6]);
            var11.a();
            return;
         case 11:
         case 14:
            this.u = new short[var1.length - 7 - (var1[6] - 1 << 2)];
            this.o = (byte)var1[5];
            System.arraycopy(var1, 7 + (var1[6] - 1 << 2), this.u, 0, this.u.length);
            this.b(var1[1], var1[2]);
            this.c = new c[var1[6]];
            a.b.g var10;
            (var10 = new a.b.g()).a(var1[3], false);
            int[] var21 = var10.b(var1[4], (byte)var1[5]);
            this.c[0] = new c();
            this.c[0] = a.a.d.a(var10, var1[4], var21, (byte)var1[5], this.c[0]);
            if (var1[0] == 11) {
               for (int var32 = 1; var32 < this.c.length; var32++) {
                  this.c[var32] = this.c[0].a();
                  this.c[var32] = a.a.d.a(
                     this.c[var32], var1[7 + (var32 - 1 << 2)], var1[8 + (var32 - 1 << 2)], var1[9 + (var32 - 1 << 2)], var1[10 + (var32 - 1 << 2)]
                  );
               }
            } else {
               for (int var33 = 1; var33 < this.c.length; var33++) {
                  this.c[var33] = this.c[0].a();
                  this.c[var33] = a.a.d.b(this.c[var33], var1[7 + (var33 - 1 << 2)], var1[8 + (var33 - 1 << 2)]);
               }
            }

            var10.a();
            return;
         case 12:
            this.o = (byte)var1[5];
            this.u = new short[var1.length - 9];
            System.arraycopy(var1, 9, this.u, 0, this.u.length);
            this.b(var1[1], var1[2]);
            this.c = new c[var1[6]];
            a.b.g var9;
            (var9 = new a.b.g()).a(var1[3], false);
            int[] var20 = var9.b(var1[4], (byte)var1[5]);
            this.c[0] = new c();
            this.c[0] = a.a.d.a(var9, var1[4], var20, (byte)var1[5], this.c[0]);

            for (int var30 = 1; var30 < this.c.length; var30++) {
               this.c[var30] = this.c[0].a();
            }

            for (int var31 = 0; var31 < this.c.length; var31++) {
               this.c[var31] = a.a.d.b(this.c[var31], var1[var31 + 7]);
            }

            var9.a();
            return;
         case 13:
            this.o = (byte)var1[5];
            this.u = new short[var1.length - 7 - var1[6]];
            System.arraycopy(var1, 7 + var1[6], this.u, 0, this.u.length);
            this.b(var1[1], var1[2]);
            this.c = new c[var1[6]];
            a.b.g var8;
            (var8 = new a.b.g()).a(var1[3], false);
            int[] var19 = var8.b(var1[4], (byte)var1[5]);
            this.c[0] = new c();
            this.c[0] = a.a.d.a(var8, var1[4], var19, (byte)var1[5], this.c[0]);

            for (int var28 = 1; var28 < this.c.length; var28++) {
               this.c[var28] = this.c[0].a();
            }

            for (int var29 = 0; var29 < this.c.length; var29++) {
               this.c[var29] = a.a.d.b(this.c[var29], var1[var29 + 7]);
            }

            return;
         case 15:
            this.o = (byte)var1[5];
            this.u = new short[var1.length - 7 - (var1[6] - 1 << 2)];
            System.arraycopy(var1, 7 + (var1[6] - 1 << 2), this.u, 0, this.u.length);
            this.b(var1[1], var1[2]);
            this.c = new c[var1[6]];
            a.b.g var7;
            (var7 = new a.b.g()).a(var1[3], false);
            int[] var18 = var7.b(var1[4], (byte)var1[5]);
            this.c[0] = new c();
            this.c[0] = a.a.d.a(var7, var1[4], var18, (byte)var1[5], this.c[0]);

            for (int var4 = 1; var4 < this.c.length; var4++) {
               this.c[var4] = this.c[0].a();
               this.c[var4] = a.a.d.a(this.c[var4], var1[7 + (var4 - 1 << 2)], var1[8 + (var4 - 1 << 2)], var1[9 + (var4 - 1 << 2)], var1[10 + (var4 - 1 << 2)]);
            }

            var7.a();
            return;
         case 16:
            this.u = new short[var1.length - 6];
            this.o = (byte)var1[5];
            System.arraycopy(var1, 6, this.u, 0, this.u.length);
            this.b(var1[1], var1[2]);
            this.c = new c[1];
            a.b.g var6;
            (var6 = new a.b.g()).a(var1[3], false);
            int[] var17 = var6.b(var1[4], (byte)var1[5]);
            this.c[0] = new c();
            this.c[0] = a.a.d.a(var6, var1[4], var17, (byte)var1[5], this.c[0]);
            this.u[1] = (short)(this.c[0].c / this.u[2]);
            var6.a();
            return;
         case 17:
            this.u = new short[var1.length - 11];
            this.o = (byte)var1[5];
            System.arraycopy(var1, 11, this.u, 0, this.u.length);
            this.b(var1[1], var1[2]);
            this.c = new c[2];
            a.b.g var2;
            (var2 = new a.b.g()).a(var1[3], false);
            int[] var3 = var2.b(var1[4], (byte)var1[5]);
            this.c[0] = new c();
            this.c[0] = a.a.d.a(var2, var1[4], var3, (byte)var1[5], this.c[0]);
            this.c[0] = a.a.d.a(this.c[0], var1[10]);
            this.c[1] = this.c[0].a();
            this.c[1] = a.a.d.a(this.c[1], var1[6], var1[7], var1[8], var1[9]);
            var2.a();
            return;
         default:
            this.o = (byte)var1[2];
            this.b.a(this.x[this.a - 20], false);
            this.b.a((byte)var1[1], (byte)0, true);
      }
   }

   private void e() {
      if (this.c != null) {
         for (int var1 = 0; var1 < this.c.length; var1++) {
            c var2;
            (var2 = this.c[var1]).a = null;
            this.c[var1] = null;
         }

         this.c = null;
      }

      if (this.u != null) {
         this.u = null;
      }
   }

   public final void a() {
      this.b(true);
      this.c(true);
   }

   public final void b() {
      this.b(false);
      this.c(false);
   }

   public final boolean a(byte var1) {
      return this.a == 8 && this.f;
   }

   public final boolean c() {
      return this.b.f();
   }

   public final boolean a(int var1) {
      return this.b.b(var1);
   }

   public final boolean d() {
      if (!this.f) {
         return false;
      }

      switch (this.a) {
         case 0:
            if (this.u[1] < this.u[2] / 5) {
               this.c[2] = this.c[0].a();
               if (this.u[1] % 2 == 1) {
                  this.c[2] = a.a.d.b(a.a.d.a(this.c[2], 6), 5, 1);
               } else {
                  this.c[2] = a.a.d.b(this.c[2], 2, 1);
               }
            } else if (this.u[1] >= (this.u[2] << 2) / 5) {
               this.c[2] = this.c[1].a();
               if (this.u[1] % 2 == 1) {
                  this.c[2] = a.a.d.b(a.a.d.a(this.c[2], 6), 5, 1);
               } else {
                  this.c[2] = a.a.d.b(this.c[2], 2, 1);
               }
            } else {
               if (this.u[1] % 4 != 1 && this.u[1] % 4 != 2) {
                  this.c[2] = this.c[1].a();
               } else {
                  this.c[2] = this.c[0].a();
               }

               if (this.u[1] % 2 == 1) {
                  this.c[2] = a.a.d.b(a.a.d.a(this.c[2], 8), 8, 1);
               } else {
                  this.c[2] = a.a.d.b(a.a.d.a(this.c[2], 4), 4, 1);
               }
            }

            if (this.u[1] >= this.u[2]) {
               this.b();
               this.e();
               return false;
            }

            this.u[1]++;
            break;
         case 1:
            switch (this.u[4]) {
               case 0:
                  int[] var6 = new int[4];

                  for (int var9 = 0; var9 < this.c[1].b; var9++) {
                     for (int var18 = 0; var18 < 4; var18++) {
                        var6[var18] = this.c[1].a[var9 + var18 * this.c[1].b];
                     }

                     for (int var19 = 0; var19 < this.c[1].c - 4; var19++) {
                        this.c[1].a[var9 + var19 * this.c[1].b] = this.c[1].a[var9 + (var19 + 4) * this.c[1].b];
                     }

                     for (int var20 = 0; var20 < 4; var20++) {
                        this.c[1].a[var9 + (var20 + this.c[1].c - 4) * this.c[1].b] = var6[var20];
                     }
                  }
                  break;
               case 1:
                  int[] var5 = new int[4];

                  for (int var8 = 0; var8 < this.c[1].b; var8++) {
                     for (int var15 = 0; var15 < 4; var15++) {
                        var5[var15] = this.c[1].a[var8 + (this.c[1].c - 4 + var15) * this.c[1].b];
                     }

                     for (int var16 = this.c[1].c - 1; var16 > 3; var16--) {
                        this.c[1].a[var8 + var16 * this.c[1].b] = this.c[1].a[var8 + (var16 - 4) * this.c[1].b];
                     }

                     for (int var17 = 0; var17 < 4; var17++) {
                        this.c[1].a[var8 + var17 * this.c[1].b] = var5[var17];
                     }
                  }
                  break;
               case 2:
                  int[] var4 = new int[4];

                  for (int var7 = 0; var7 < this.c[1].c; var7++) {
                     for (int var12 = 0; var12 < 4; var12++) {
                        var4[var12] = this.c[1].a[var7 * this.c[1].c + var12];
                     }

                     for (int var13 = 0; var13 < this.c[1].b - 4; var13++) {
                        this.c[1].a[var7 * this.c[1].c + var13] = this.c[1].a[var7 * this.c[1].c + var13 + 4];
                     }

                     for (int var14 = 0; var14 < 4; var14++) {
                        this.c[1].a[var7 * this.c[1].c + var14 + this.c[1].b - 4] = var4[var14];
                     }
                  }
                  break;
               case 3:
                  int[] var1 = new int[4];

                  for (int var2 = 0; var2 < this.c[1].c; var2++) {
                     for (int var3 = 0; var3 < 4; var3++) {
                        var1[var3] = this.c[1].a[var2 * this.c[1].c + this.c[1].b - 4 + var3];
                     }

                     for (int var10 = this.c[1].b - 1; var10 > 3; var10--) {
                        this.c[1].a[var2 * this.c[1].c + var10] = this.c[1].a[var2 * this.c[1].c + var10 - 4];
                     }

                     for (int var11 = 0; var11 < 4; var11++) {
                        this.c[1].a[var2 * this.c[1].c + var11] = var1[var11];
                     }
                  }
            }

            this.c[2] = this.c[0].a();
            this.c[2] = a.a.d.a(this.c[2], this.c[1], (byte)this.u[3]);
            if (this.u[0] >= this.u[1]) {
               this.b();
               this.e();
               return false;
            }

            this.u[0]++;
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
            break;
         case 7:
         case 9:
         case 10:
         case 16:
         case 17:
            if (this.u[0] >= this.u[1]) {
               this.b();
               this.e();
               return false;
            }

            this.u[0]++;
            break;
         case 8:
            if (this.u[0] < this.u[1] / this.u[3] * this.u[2]) {
               if (this.u[4] == 1) {
                  this.c[1] = this.c[0].a();
               }

               this.c[1] = a.a.d.b(a.a.d.a(this.c[1], this.u[5 + (this.u[2] - 1) * 3]), 1, 50);
               this.c[1].d = this.c[1].d + this.u[6 + (this.u[2] - 1) * 3];
               this.c[1].e = this.c[1].e + this.u[7 + (this.u[2] - 1) * 3];
            } else {
               this.u[2]++;
            }

            if (this.u[0] >= this.u[1]) {
               this.b();
               this.e();
               return false;
            }

            this.u[0]++;
            break;
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
            if (this.u[2] < this.u[3]) {
               this.u[2]++;
            } else {
               this.u[2] = 0;
               this.u[0]++;
               if (this.u[0] >= this.u[1]) {
                  this.u[0] = 0;
                  this.b();
                  this.e();
                  return false;
               }
            }
            break;
         default:
            this.b.e();
      }

      return true;
   }

   public final void a(Graphics var1, int var2, int var3) {
      if (this.g && this.h) {
         switch (this.a) {
            case 0:
               var1.drawRGB(this.c[2].a, 0, this.c[2].b, this.j + this.c[2].d, this.k + this.c[2].e, this.c[2].b, this.c[2].c, true);
               return;
            case 1:
               var1.drawRGB(this.c[2].a, 0, this.c[2].b, this.j + this.c[2].d, this.k + this.c[2].e, this.c[2].b, this.c[2].c, true);
               return;
            case 2:
               return;
            case 3:
               return;
            case 4:
               return;
            case 5:
               return;
            case 6:
               return;
            case 7:
               if (this.u[0] / this.u[2] % 2 == 0) {
                  var1.drawRGB(this.c[1].a, 0, this.c[1].b, this.j + this.c[0].d + this.v, this.k + this.c[0].e + this.w, this.c[1].b, this.c[1].c, true);
                  return;
               }

               var1.drawRGB(this.c[0].a, 0, this.c[0].b, this.j + this.c[0].d, this.k + this.c[0].e, this.c[0].b, this.c[0].c, true);
               return;
            case 8:
               var1.drawRGB(this.c[1].a, 0, this.c[1].b, this.j + this.c[1].d, this.k + this.c[1].e, this.c[1].b, this.c[1].c, true);
               return;
            case 9:
            case 10:
               var1.drawRGB(this.c[0].a, 0, this.c[0].b, this.j + this.c[0].d, this.k + this.c[0].e, this.c[0].b, this.c[0].c, true);
               if (this.u[0] / this.u[2] % 2 == 0) {
                  var1.drawRGB(this.c[1].a, 0, this.c[1].b, this.j + this.c[1].d, this.k + this.c[1].e, this.c[1].b, this.c[1].c, true);
                  return;
               }
               break;
            case 11:
            case 14:
               var1.setColor(16711935);

               for (int var7 = 1; var7 < this.c.length; var7++) {
                  if (this.o == 1) {
                     var1.drawRGB(
                        this.c[var7].a,
                        0,
                        this.c[var7].b,
                        this.j + this.c[var7].d - this.u[4 + (this.u[0] * (this.c.length - 1) << 1) + (var7 - 1 << 1)],
                        this.k + this.c[var7].e + this.u[4 + (this.u[0] * (this.c.length - 1) << 1) + (var7 - 1 << 1) + 1],
                        this.c[var7].b,
                        this.c[var7].c,
                        true
                     );
                  } else {
                     var1.drawRGB(
                        this.c[var7].a,
                        0,
                        this.c[var7].b,
                        this.j + this.c[var7].d + this.u[4 + (this.u[0] * (this.c.length - 1) << 1) + (var7 - 1 << 1)],
                        this.k + this.c[var7].e + this.u[4 + (this.u[0] * (this.c.length - 1) << 1) + (var7 - 1 << 1) + 1],
                        this.c[var7].b,
                        this.c[var7].c,
                        true
                     );
                  }
               }

               return;
            case 12:
               if (this.o == 1) {
                  var1.drawRGB(
                     this.c[1].a,
                     0,
                     this.c[1].b,
                     this.j + this.c[1].d - (this.u[4 + (this.u[1] << 1) + (this.u[0] << 1)] + this.u[4 + (this.u[0] << 1)]),
                     this.k + this.c[1].e - this.u[4 + (this.u[1] << 1) + (this.u[0] << 1) + 1] + this.u[4 + (this.u[0] << 1) + 1],
                     this.c[1].b,
                     this.c[1].c,
                     true
                  );
                  var1.drawRGB(
                     this.c[0].a,
                     0,
                     this.c[0].b,
                     this.j + this.c[0].d - this.u[4 + (this.u[0] << 1)],
                     this.k + this.c[0].e + this.u[4 + (this.u[0] << 1) + 1],
                     this.c[0].b,
                     this.c[0].c,
                     true
                  );
                  return;
               }

               var1.drawRGB(
                  this.c[1].a,
                  0,
                  this.c[1].b,
                  this.j + this.c[1].d + this.u[4 + (this.u[1] << 1) + (this.u[0] << 1)] + this.u[4 + (this.u[0] << 1)],
                  this.k + this.c[1].e - this.u[4 + (this.u[1] << 1) + (this.u[0] << 1) + 1] + this.u[4 + (this.u[0] << 1) + 1],
                  this.c[1].b,
                  this.c[1].c,
                  true
               );
               var1.drawRGB(
                  this.c[0].a,
                  0,
                  this.c[0].b,
                  this.j + this.c[0].d + this.u[4 + (this.u[0] << 1)],
                  this.k + this.c[0].e + this.u[4 + (this.u[0] << 1) + 1],
                  this.c[0].b,
                  this.c[0].c,
                  true
               );
               return;
            case 13:
               for (int var6 = 0; var6 < this.c.length; var6++) {
                  if (this.o == 1) {
                     var1.drawRGB(
                        this.c[var6].a,
                        0,
                        this.c[var6].b,
                        this.j + this.c[var6].d - this.u[4 + (this.u[0] * this.c.length << 1) + (var6 << 1)],
                        this.k + this.c[var6].e + this.u[4 + (this.u[0] * this.c.length << 1) + (var6 << 1) + 1],
                        this.c[var6].b,
                        this.c[var6].c,
                        true
                     );
                  } else {
                     var1.drawRGB(
                        this.c[var6].a,
                        0,
                        this.c[var6].b,
                        this.j + this.c[var6].d + this.u[4 + (this.u[0] * this.c.length << 1) + (var6 << 1)],
                        this.k + this.c[var6].e + this.u[4 + (this.u[0] * this.c.length << 1) + (var6 << 1) + 1],
                        this.c[var6].b,
                        this.c[var6].c,
                        true
                     );
                  }
               }

               return;
            case 15:
               var2 = 4 + this.u[0] * 3;
               if (this.o == 1) {
                  var1.drawRGB(
                     this.c[this.u[var2]].a,
                     0,
                     this.c[this.u[var2]].b,
                     this.j + this.c[this.u[var2]].d - this.u[var2 + 1],
                     this.k + this.c[this.u[var2]].e + this.u[var2 + 2],
                     this.c[this.u[var2]].b,
                     this.c[this.u[var2]].c,
                     true
                  );
                  return;
               }

               var1.drawRGB(
                  this.c[this.u[var2]].a,
                  0,
                  this.c[this.u[var2]].b,
                  this.j + this.c[this.u[var2]].d + this.u[var2 + 1],
                  this.k + this.c[this.u[var2]].e + this.u[var2 + 2],
                  this.c[this.u[var2]].b,
                  this.c[this.u[var2]].c,
                  true
               );
               return;
            case 16:
               for (int var4 = 0; var4 < this.u[2]; var4++) {
                  for (int var8 = 0; var8 < this.c[0].b * this.u[0]; var8++) {
                     if (this.c[0].a[var4 * this.u[1] * this.c[0].b + var8] != 16777215 && this.c[0].a[var4 * this.u[1] * this.c[0].b + var8] != 0) {
                        this.c[0].a[var4 * this.u[1] * this.c[0].b + var8] = this.c[0].a[var4 * this.u[1] * this.c[0].b + var8] & 16777215;
                     }
                  }
               }

               var1.drawRGB(this.c[0].a, 0, this.c[0].b, this.j + this.c[0].d, this.k + this.c[0].e, this.c[0].b, this.c[0].c, true);
               return;
            case 17:
               var1.drawRGB(this.c[0].a, 0, this.c[0].b, this.j + this.c[0].d, this.k + this.c[0].e + this.u[3], this.c[0].b, this.c[0].c, true);
               if (this.u[0] / this.u[2] % 2 == 0) {
                  var1.drawRGB(this.c[1].a, 0, this.c[1].b, this.j + this.c[1].d, this.k + this.c[1].e + this.u[3], this.c[1].b, this.c[1].c, true);
                  return;
               }
               break;
            default:
               this.b.a(var1, this.j, this.k, this.o);
         }
      }
   }
}
