package game;

import javax.microedition.lcdui.Graphics;

public final class d {
   private static int c = 0;
   private char[] d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int[] i;
   private int j;
   private int k;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;
   private int q;
   public static boolean a = false;
   private int r;
   public static boolean b = false;
   private byte s;
   private static d t;
   private boolean u;
   private int v;
   private int[][] w;
   private int x;
   private char[] y;
   private char[] z;
   private String[] A;
   private int B;
   private long C;
   private int D;

   public d() {
      a.a.o();
      this.f = 0;
      this.g = 0;
      this.h = 0;
      this.i = new int[10];
      this.j = 0;
      this.k = 0;
      this.l = 2;
      this.m = 0;
      this.p = 0;
      this.q = 2;
      this.r = 0;
      this.s = 0;
      this.v = 0;
      this.w = null;
      this.x = 0;
      this.y = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
      this.z = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
      this.A = new String[]{"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
   }

   public static d a() {
      if (t == null) {
         t = new d();
      }

      return t;
   }

   public final void b() {
      switch (c) {
         case 0:
            if (this.g < this.d.length) {
               if (this.g - this.f >= this.q * this.e + this.h) {
                  this.f = this.g;
                  this.h = 0;
                  this.i[0] = this.i[this.k];
                  a = false;
                  return;
               }

               while (this.g - this.f < this.q * this.e + this.h && this.g < this.d.length) {
                  if (this.d[this.g] == '#') {
                     this.h += 7;
                     this.g += 7;
                  } else {
                     this.g++;
                  }
               }
            }

            game.e.B = null;
            this.i[0] = this.i[this.k];
            b = false;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            a = false;
            return;
         case 1:
            b = false;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            return;
         case 2:
            return;
         case 3:
            if (this.r < this.q * (this.x + 1)) {
               if (this.q * (this.x + 1) > this.w.length) {
                  this.r = this.w.length;
                  return;
               } else {
                  this.r = this.q * (this.x + 1);
               }
            }
      }
   }

   public final void a(Graphics var1) {
      Graphics var2 = var1;
      d var14 = this;
      if (b) {
         label69:
         switch (c) {
            case 0:
               switch (var14.s) {
                  case 0:
                     var2.setColor(16777215);
                     var14.a(var2, var14.n, var14.o);
                     break label69;
                  case 1:
                     var14.a(var2, var14.n, var14.o - (a.a.o() >> 1));
                  default:
                     break label69;
               }
            case 1:
            case 2:
               int var17 = c == 1 ? 0 : var14.m;
               switch (var14.s) {
                  case 0:
                     int var16 = 0;

                     while (true) {
                        if (var16 >= a.e.a.length) {
                           break label69;
                        }

                        game.n.a(var2, a.e.a[var16], var14.n, var14.o + var16 * (game.n.a + 1) + var17, 16777215);
                        var16++;
                     }
                  case 1:
                     for (int var15 = 0; var15 < a.e.a.length; var15++) {
                        var2.setColor(16777215);
                        game.n.b(var2, a.e.a[var15], var14.n, var14.o + (game.n.a + 1) * (a.e.a.length >> var15 + 1) + var17, 17);
                     }
                  default:
                     break label69;
               }
            case 3:
               int var6 = var14.o;
               int var5 = var14.n;
               Graphics var4 = var2;
               d var3 = var14;
               int var7 = var14.d.length;
               System.out.println("drawDialogRow: startLine=" + var3.x + ", m=" + var3.q + ", n=" + var3.r);

               for (int var8 = var3.x * var3.q; var8 < var3.r; var8++) {
                  int var9 = game.n.a * (var8 - var3.x * var3.q) + var6;
                  int var10 = var5;

                  for (int var11 = var3.w[var8][0]; var11 < var3.w[var8][1]; var11++) {
                     while (var11 < var7 && var3.d[var11] == '#') {
                        String var12 = "";

                        for (int var13 = 0; var13 < 7; var13++) {
                           var12 = var12 + var3.d[var11 + var13];
                        }

                        var3.j = ++var3.j >= var3.i.length ? 0 : var3.j;
                        var3.i[var3.j] = var3.a(var12);
                        var4.setColor(var3.i[var3.j]);
                        var11 += 7;
                     }

                     var4.setColor(var3.i[var3.j]);
                     if (var11 < var7) {
                        char var18 = var3.d[var11];
                        game.n.a(var4, var18, var10, var9);
                        var10 += game.n.a(var18);
                     }
                  }
               }

               var3.k = var3.j;
               var3.j = 0;
         }

         if (var14.u && a && var14.r % 10 < 5) {
            var2.setColor(16777215);
            var2.drawString("Nhấn 0 để tiếp tục", a.a.g() >> 1, a.a.h() - 8, 33);
         }
      }
   }

   public final void c() {
      this.d = null;
      a.e.a = null;
      this.r = 0;
   }

   public final void a(byte var1, String var2, int var3) {
      this.d = var2.toCharArray();
      c = var1;
      switch (var1) {
         case 0:
            d var12 = this;
            int var13 = this.d.length;
            int var4 = 0;
            int var5 = 0;
            int var6;
            int var7 = (var6 = var12.D - 10) - game.n.b;
            StringBuffer var8 = new StringBuffer();

            while (var12.g < var13) {
               char var9;
               if ((var9 = var12.d[var12.g]) == '#') {
                  var12.h += 7;
                  var12.g += 7;
               } else {
                  var12.g++;
                  int var10 = game.n.a(var9);
                  int var11 = var5 + var10;
                  var8.append(var9);
                  if (var5 > var6 || var9 == ' ' && var5 > var7) {
                     var11 = 0;
                     if (var9 != ' ') {
                        var11 = var10 + 0;
                     }

                     var4++;
                     var8 = new StringBuffer();
                  }

                  var5 = var11;
               }
            }

            if (var5 > 0) {
               var4++;
            }

            this.q = var4;
         case 1:
         case 2:
         default:
            break;
         case 3:
            this.x = 0;
            this.f();
            this.a(0, 80);
      }

      this.f = 0;
      this.g = 0;
      this.h = 0;
      b = true;
      a = false;
      boolean var14 = false;
      this.u = var14;
      this.s = (byte)var3;
   }

   public final void a(int var1, int var2) {
      this.n = var1;
      this.o = var2;
      this.D = a.a.g() - 2 * this.n;
   }

   private void f() {
      c = 3;
      int var1 = 0;
      char[] var2 = this.d;
      int var3 = this.d.length;
      int[][] var4 = new int[50][2];
      int var5 = 0;
      int var6;
      int var7 = (var6 = this.D - 10) - game.n.b;
      int var8 = 0;
      int var9 = 0;

      while (var9 < var3) {
         char var10;
         if ((var10 = var2[var9]) == '#') {
            var9 += 7;
         } else {
            int var11 = game.n.a(var10);
            int var12 = var5 + var11;
            if (var5 > var6 || var10 == ' ' && var5 > var7) {
               var12 = 0;
               if (var10 != ' ') {
                  var12 = var11 + 0;
               }

               var4[var1][0] = var8;
               var4[var1][1] = var9;
               var8 = var9;
               var1++;
            }

            var5 = var12;
            var9++;
         }
      }

      if (var5 > 0) {
         var4[var1][0] = var8;
         var4[var1][1] = this.m;
         var1++;
      }

      this.w = new int[var1][2];

      for (int var13 = 0; var13 < var1; var13++) {
         System.arraycopy(var4[var13], 0, this.w[var13], 0, 2);
      }
   }

   public final void b(int var1, int var2) {
      this.D = var1;
      int var3 = game.n.a('w');
      this.e = var1 / var3;
      this.q = var2 / (game.n.a + 1);
   }

   private void a(Graphics var1, int var2, int var3) {
      this.p = this.f;
      char[] var4 = this.d;
      int var5 = this.d.length;
      int var6 = var2;
      var3 = var3;
      int var7;
      int var8 = (var7 = this.D + var2 - 10) - game.n.b;

      for (int var9 = this.f; var9 < this.g; var9++) {
         while (var9 < var5 && var4[var9] == '#') {
            String var10 = "";

            for (int var11 = 0; var11 < 7; var11++) {
               var10 = var10 + var4[var9 + var11];
            }

            this.j = ++this.j >= this.i.length ? 0 : this.j;
            this.i[this.j] = this.a(var10);
            var1.setColor(this.i[this.j]);
            var9 += 7;
         }

         var1.setColor(this.i[this.j]);
         if (var9 < var5) {
            char var14;
            int var15 = game.n.a(var14 = var4[var9]);
            int var12;
            if ((var12 = var6 + var15) > var7 || var14 == ' ' && var12 > var8) {
               var12 = var2;
               var6 = var2;
               if (var14 != ' ') {
                  var12 = var6 + var15;
               }

               var3 += game.n.a + 1;
            }

            game.n.a(var1, var14, var6, var3);
            var6 = var12;
         }

         this.p++;
      }

      this.k = this.j;
      this.j = 0;
   }

   private int a(String var1) {
      char[] var4 = var1.toCharArray();
      StringBuffer var2 = new StringBuffer();

      for (int var3 = 0; var3 < var4.length; var3++) {
         var2.append(this.a(var4[var3]));
      }

      char[] var5 = var2.toString().toCharArray();
      int var7 = 0;

      for (int var6 = 0; var6 < var5.length; var6++) {
         if (var5[var6] == '1') {
            var7 += 1 << var5.length - var6 - 1;
         }
      }

      return var7;
   }

   private String a(char var1) {
      for (int var2 = 0; var2 < this.y.length; var2++) {
         if (var1 == this.y[var2] || var1 == this.z[var2]) {
            return this.A[var2];
         }
      }

      return "0000";
   }

   public final void d() {
      d var1 = this;
      char[] var2 = this.d;
      if (b) {
         switch (c) {
            case 0:
               int var3 = var2.length;
               int var4;
               int var5 = (var4 = var1.D - 10) - game.n.b;
               int var6 = 1;

               for (int var7 = 0; var7 < 2; var7++) {
                  if (var1.g < var3) {
                     var1.C = 0L;
                     if (var1.g == 0) {
                        var1.B = 0;
                     }

                     char var8;
                     if ((var8 = var2[var1.g]) == '#') {
                        var1.h += 7;
                        var1.g += 7;
                     } else {
                        int var9 = game.n.a(var8);
                        int var10;
                        if ((var10 = var1.B + var9) > var4 || var8 == ' ' && var10 > var5) {
                           var10 = 0;
                           var1.B = 0;
                           if (var8 != ' ') {
                              var10 = var9 + 0;
                           }

                           if (++var6 > var1.q) {
                              var6 = 0;
                              var1.f = var1.g;
                           }
                        }

                        var1.B = var10;
                        var1.g++;
                     }
                  } else if (var1.C == 0L) {
                     var1.C = System.currentTimeMillis() + 2500L;
                  } else if (System.currentTimeMillis() > var1.C) {
                     if (!var1.u) {
                        var1.c();
                        b = false;
                        if (game.l.B().c.b("/data/ui/dialog.ui")) {
                           game.l.B().d.aF();
                        }
                     }

                     a = true;
                     var1.r++;
                  }
               }

               return;
            case 1:
               a = true;
               var1.r++;
               return;
            case 2:
               var1.m = var1.m + var1.l;
               if (var1.m > a.e.a.length * (a.a.h() + a.a.h() / 2)) {
                  var1.m = 0;
                  a = true;
                  b = false;
                  var1.r++;
                  return;
               }
               break;
            case 3:
               if (var1.r < var1.w.length) {
                  var1.v++;
                  if (var1.v >= 20) {
                     var1.r++;
                     if (var1.r > var1.q * (var1.x + 1)) {
                        var1.x++;
                        var1.i[0] = var1.i[var1.k];
                     }

                     var1.v = 0;
                  }
               }
         }
      }
   }

   public final void a(boolean var1) {
      this.u = var1;
   }

   public final boolean e() {
      return this.u;
   }
}
