package a.b;

import java.io.DataInputStream;
import java.io.InputStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class d {
   private static d e;
   private static final int[] f = new int[]{0, 5, 3, 6, 2, 4, 1, 7};
   private int g = -1;
   private int h = -1;
   private short i = -1;
   private short j = -1;
   private short k = -1;
   private short l = -1;
   private int m = -1;
   private byte n = -1;
   private byte o = -1;
   private Image[] p = null;
   public int a;
   public int b;
   public int c;
   public int d;
   private int q;
   private int r;
   private int s;
   private int t;
   private byte u;
   private short[][] v;
   private short[][][] w;
   private byte[] x = null;

   public static d a() {
      if (e == null) {
         e = new d();
      }

      return e;
   }

   public d() {
      this.h = a.a.h();
      this.g = a.a.g();
   }

   public final void b() {
      this.w = null;
      this.x = null;
      this.v = null;
   }

   public final void a(int var1) {
      this.m = var1;
      d var12 = this;

      try {
         var12.getClass();
         InputStream var2 = b.a("/data/map/map_" + var12.m + ".mid");
         DataInputStream var13;
         byte var3 = (var13 = new DataInputStream(var2)).readByte();
         var12.o = var12.n;
         var12.n = var13.readByte();
         var12.e();
         if (var3 == 1) {
            var12.i = var13.readByte();
         } else {
            var12.i = var13.readShort();
         }

         if (var3 == 1) {
            var12.j = var13.readByte();
         } else {
            var12.j = var13.readShort();
         }

         var12.k = var13.readByte();
         var12.l = var12.k;
         var12.c = var12.i * var12.k;
         var12.d = var12.j * var12.l;
         var12.u = var13.readByte();
         var12.x = new byte[var12.u];
         var12.w = new short[var12.u][][];

         for (int var4 = 0; var4 < var12.u; var4++) {
            byte var5 = var13.readByte();
            var12.x[var4] = var13.readByte();
            short var6 = var13.readShort();
            if (var12.x[var5] != 0 && var12.x[var5] != 1) {
               var12.w[var5] = new short[var6][4];
            } else {
               var12.w[var5] = new short[var12.i][var12.j];

               for (int var7 = 0; var7 < var12.i; var7++) {
                  for (int var8 = 0; var8 < var12.j; var8++) {
                     var12.w[var5][var7][var8] = -1;
                  }
               }
            }

            for (int var14 = 0; var14 < var6; var14++) {
               short var9;
               short var15;
               if (var3 == 1) {
                  var15 = var13.readByte();
                  var9 = var13.readByte();
               } else {
                  var15 = var13.readShort();
                  var9 = var13.readShort();
               }

               short var10 = var13.readShort();
               if (var12.x[var4] == 1) {
                  var12.w[var4][var15][var9] = var10;
               } else if (var12.x[var5] == 0) {
                  var12.w[var4][var15][var9] = (short)(var10 & 4095);
               } else {
                  var12.w[var4][var14][1] = var15;
                  var12.w[var4][var14][2] = var9;
                  var12.w[var4][var14][0] = (short)(var10 & 4095);
                  var12.w[var4][var14][3] = (short)((var10 & 28672) >> 12);
               }
            }
         }

         var13.close();
      } catch (Exception var11) {
         var11.printStackTrace();
      }
   }

   private void e() {
      if (this.p != null) {
         if (game.e.k != 0) {
            for (int var1 = 0; var1 < this.p.length; var1++) {
               if (this.p[var1] != null) {
                  this.p[var1] = null;
               }
            }

            this.p = null;
         } else {
            for (int var6 = 0; var6 < this.p.length; var6++) {
               for (int var2 = 0; var2 < a.b.c.b[this.n].length; var2++) {
                  if (a.b.c.b[this.o][var6] == a.b.c.b[this.n][var2]) {
                     a.b.c.c(a.b.c.b[this.o][var6]);
                     this.p[var6] = null;
                     break;
                  }
               }

               if (this.p[var6] != null) {
                  a.b.c.d(a.b.c.b[this.o][var6]);
                  this.p[var6] = null;
               }
            }

            this.p = null;
         }
      }

      this.p = new Image[a.b.c.b[this.n].length];

      for (int var7 = 0; var7 < this.p.length; var7++) {
         if (game.e.k == 1) {
            this.p[var7] = a.a.d.a(a.b.c.b(a.b.c.b[this.n][var7]));
         } else {
            this.p[var7] = a.b.c.b(a.b.c.b[this.n][var7]);
         }
      }

      try {
         "".getClass();
         InputStream var8 = b.a("/data/mod/mod_" + this.n + ".mid");
         DataInputStream var9;
         short var3 = (var9 = new DataInputStream(var8)).readShort();
         this.v = new short[var3][5];

         for (int var4 = 0; var4 < var3; var4++) {
            this.v[var4][0] = var9.readByte();
            this.v[var4][1] = var9.readShort();
            this.v[var4][2] = var9.readShort();
            this.v[var4][3] = var9.readShort();
            this.v[var4][4] = var9.readShort();
         }

         var9.close();
         var8.close();
      } catch (Exception var5) {
         var5.printStackTrace();
      }
   }

   public final void c() {
      for (int var1 = 0; var1 < this.p.length; var1++) {
         if (game.e.k == 1) {
            this.p[var1] = a.a.d.a(a.b.c.b(a.b.c.b[this.n][var1]));
         } else {
            a.b.c.d(a.b.c.b[this.n][var1]);
         }
      }

      for (int var2 = 0; var2 < this.p.length; var2++) {
         if (game.e.k == 0) {
            this.p[var2] = a.b.c.b(a.b.c.b[this.n][var2]);
         }
      }
   }

   public final void d() {
      if (this.k != 0) {
         this.r = this.b / this.l;
         this.q = this.a / this.k;
         this.t = this.h / this.l + 1;
         this.s = this.g / this.k + 1;
         if (this.r + this.t >= this.j) {
            this.t = this.j - 1 - this.r;
         }

         if (this.s + this.q >= this.i) {
            this.s = this.i - 1 - this.q;
         }
      }
   }

   public final void a(Graphics var1, int var2) {
      switch (this.x[var2]) {
         case 0:
            int var15 = var2;
            Graphics var13 = var1;
            d var10 = this;

            for (int var17 = 0; var17 <= var10.s; var17++) {
               for (int var18 = 0; var18 <= var10.t; var18++) {
                  short var20;
                  if ((var20 = var10.w[var15][var10.q + var17][var10.r + var18]) != -1) {
                     var13.drawRegion(
                        var10.p[0],
                        var10.v[var20][1],
                        var10.v[var20][2],
                        var10.v[var20][3],
                        var10.v[var20][4],
                        0,
                        var17 * var10.k - var10.a % var10.k,
                        var18 * var10.l - var10.b % var10.l,
                        20
                     );
                  }
               }
            }

            return;
         case 1:
            int var14 = var2;
            Graphics var12 = var1;
            d var9 = this;

            for (int var16 = 0; var16 <= var9.s; var16++) {
               for (int var5 = 0; var5 <= var9.t; var5++) {
                  short var6;
                  if ((var6 = var9.w[var14][var9.q + var16][var9.r + var5]) != -1) {
                     short var7 = (short)(var6 & 4095);
                     var6 = (short)f[(var6 & 28672) >> 12];
                     var12.drawRegion(
                        var9.p[var9.v[var7][0]],
                        var9.v[var7][1],
                        var9.v[var7][2],
                        var9.v[var7][3],
                        var9.v[var7][4],
                        var6,
                        var16 * var9.k - var9.a % var9.k,
                        var5 * var9.l - var9.b % var9.l,
                        20
                     );
                  }
               }
            }

            return;
         case 2:
         case 3:
         case 4:
            int var3 = var2;
            Graphics var11 = var1;
            d var8 = this;

            for (int var4 = 0; var4 < var8.w[var3].length; var4++) {
               if (var8.w[var3][var4][2] >= 0
                  && a.e.a(
                     var8.w[var3][var4][1],
                     var8.w[var3][var4][2],
                     var8.v[var8.w[var3][var4][0]][3],
                     var8.v[var8.w[var3][var4][0]][4],
                     var8.q,
                     var8.r,
                     var8.s + 1,
                     var8.t + 1,
                     var8.w[var3][var4][3]
                  )) {
                  var11.drawRegion(
                     var8.p[var8.v[var8.w[var3][var4][0]][0]],
                     var8.v[var8.w[var3][var4][0]][1],
                     var8.v[var8.w[var3][var4][0]][2],
                     var8.v[var8.w[var3][var4][0]][3],
                     var8.v[var8.w[var3][var4][0]][4],
                     f[var8.w[var3][var4][3]],
                     (var8.w[var3][var4][1] - var8.q) * var8.k - var8.a % var8.k,
                     (var8.w[var3][var4][2] - var8.r) * var8.l - var8.b % var8.l,
                     20
                  );
               }
            }
      }
   }

   public final void a(int var1, int var2) {
      this.a = var1 - this.g / 2;
      this.b = var2 - this.h / 2;
      if (this.a + this.g >= this.i * this.k) {
         this.a = this.i * this.k - this.g;
      }

      if (this.a <= 0) {
         this.a = 0;
      }

      if (this.b + this.h >= this.j * this.l) {
         this.b = this.j * this.l - this.h;
      }

      if (this.b <= 0) {
         this.b = 0;
      }
   }

   public final byte a(int var1, int var2, int var3) {
      if (this.w != null && this.w[0] != null) {
         var1 = var2 / this.k;
         int var4 = var3 / this.l;
         if (this.b(var2, var3)) {
            return 1;
         }

         if (var4 < 0) {
            var4 = 0;
         }

         if (var1 < 0) {
            var1 = 0;
         }

         if (var1 > this.i) {
            var1 = this.i;
         }

         if (var4 > this.j) {
            var4 = this.j;
         }

         return (byte)this.w[0][var1][var4];
      } else {
         return -1;
      }
   }

   public final boolean b(int var1, int var2) {
      return var1 <= 0 || var1 >= this.c || var2 <= 0 || var2 >= this.d;
   }
}
