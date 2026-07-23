package game;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class g extends a.a {
   private static g l;
   private static int[] m = null;
   private static int n;
   private byte o = 0;
   private byte p = 0;
   private Image q;
   int k = 0;
   private byte r = 10;
   private int[][] s = new int[this.r][5];
   private int[] t = new int[]{28, 3, 21, 22, 50, 5, 17, 17};
   private byte u = 30;
   private byte v = 30;
   private boolean w = false;
   private int x = 0;
   private int[] y = new int[this.r];
   private int[] z = new int[]{3958719, 3958719, 3958719, 7248110, 7248110, 9943031};

   public static g B() {
      if (l == null) {
         l = new g();
      }

      return l;
   }

   public final boolean b() {
      this.d = game.k.a();
      this.c = c.j.a();
      this.d.a(this);
      n = 0;
      if (h) {
         m = new int[]{504, 503, 505, 506, 507, 508};
      } else {
         m = new int[]{503, 505, 506, 507, 508};
      }

      if (this.q == null) {
         this.q = a.e.b("/data/img/", "img_833");
      }

      this.C();
      this.a((byte)0);
      this.k = 0;
      if (game.l.B().W != null) {
         this.k = game.f.B().r;
         game.f.B().l(0);
         game.l.B().W.a((byte)1);
         game.l.B().W.a();
         game.l.B().W = null;
      }

      return true;
   }

   private void C() {
      for (int var1 = 0; var1 < this.r; var1++) {
         this.s[var1][0] = -a.e.a(this.u);
         this.s[var1][1] = h() + a.e.a(this.v);
         this.s[var1][2] = a.e.a(2);
         this.s[var1][3] = a.e.b(1, 5);
         this.s[var1][4] = a.e.b(3, 5);
      }
   }

   private void D() {
      game.l.H = false;
      game.l.N = false;
      game.l.Q = 0;
      game.e.r = true;
      game.l.B().p = 0;
      game.l.B().q = 0;
      if (game.l.B().Z != null) {
         game.l.B().Z.D();
      }

      if (game.l.B().m != null) {
         game.l.B().m.q();
      }

      if (this.d != null) {
         this.d.b();
      }

      this.o = 0;
      game.j.p().z = false;
      h = false;
      game.f.B().a((byte)9);
      if (this.k > 0 && game.f.B().r <= 0) {
         game.f.B().l(this.k);
      }
   }

   public final void a() {
      if (this.j) {
         this.A();
         switch (this.a) {
            case 0:
               g var1 = this;
               if (this.o == 0 && var1.g(16400)) {
                  if (--n < 0) {
                     n = m.length - 1;
                  }
               } else if (var1.o == 0 && var1.g(32832)) {
                  if (++n > m.length - 1) {
                     n = 0;
                  }
               } else if (var1.g(196640)) {
                  if (h) {
                     switch (n) {
                        case 0:
                           if (var1.o == 0) {
                              a.e.a();
                              var1.E();
                              g var2 = var1;
                              if (game.l.B().Z != null) {
                                 game.l.B().Z.D();
                              }

                              if (game.l.B().m != null) {
                                 game.l.B().m.q();
                              }

                              if (var2.d != null) {
                                 var2.d.b();
                              }

                              var2.o = 0;
                              game.j.p().z = false;
                              game.f.B().a((byte)9);
                              game.f.B().a((byte)9);
                              if (var1.k > 0 && game.f.B().r <= 0) {
                                 game.f.B().l(var1.k);
                              }
                           } else if (var1.o == 1) {
                              var1.o = 0;
                              var1.d.az();
                           }
                           break;
                        case 1:
                           if (var1.o == 0) {
                              a.e.a();
                              var1.a((byte)5);
                           } else if (var1.o == 1) {
                              var1.o = 0;
                              var1.d.az();
                           }
                           break;
                        case 2:
                           var1.a((byte)1);
                           break;
                        case 3:
                           var1.a((byte)2);
                           break;
                        case 4:
                           var1.a((byte)3);
                           break;
                        case 5:
                           var1.a((byte)4);
                     }
                  } else {
                     switch (n) {
                        case 0:
                           if (var1.o == 0) {
                              a.e.a();
                              var1.E();
                              var1.D();
                              game.f.B().a((byte)9);
                           } else if (var1.o == 1) {
                              var1.o = 0;
                              var1.d.az();
                           }
                           break;
                        case 1:
                           var1.a((byte)1);
                           break;
                        case 2:
                           var1.a((byte)2);
                           break;
                        case 3:
                           var1.a((byte)3);
                           break;
                        case 4:
                           var1.a((byte)4);
                     }
                  }
               }

               if (var1.d.f()) {
                  var1.o = 0;
               }

               var1 = this;
               if (this.w) {
                  var1.x++;
                  if (var1.x >= 100) {
                     for (int var4 = 0; var4 < var1.y.length; var4++) {
                        var1.y[var4] = 0;
                     }

                     var1.x = 0;
                     var1.C();
                     var1.w = false;
                  }
               }
               break;
            case 1:
               this.d.t();
               break;
            case 2:
               this.d.p();
               break;
            case 3:
               this.d.r();
               break;
            case 4:
               if (this.g(131072)) {
                  game.f.B().a((byte)1);
               } else if (this.g(262144)) {
                  this.a((byte)0);
               }
               break;
            case 5:
               if (this.g(131104)) {
                  game.l.B();
                  game.l.K();
                  this.D();
               } else if (this.g(262144)) {
                  this.a((byte)0);
                  this.c.a("/data/ui/msgtip.ui");
               }
         }

         this.c.c();
      }
   }

   public final void a(Graphics var1) {
      switch (this.a) {
         case 1:
         case 2:
         case 3:
            Graphics var2 = var1;

            for (int var4 = 0; var4 < h() / 20; var4++) {
               if (var4 % 2 == 0) {
                  var2.setColor(10440998);
               } else {
                  var2.setColor(12082732);
               }

               var2.fillRect(0, var4 * 20, g(), 20);
            }
         default:
            this.c.a(var1);
            if (this.a == 0) {
               String var10002 = c(m[n]);
               int var10003 = (g() - m().stringWidth(c(m[n]))) / 2 + 4;
               int var10004 = h() - 20;
               byte var7 = 36;
               int var6 = var10004;
               int var5 = var10003;
               String var11 = var10002;
               Graphics var3 = var1;
               g var8 = this;
               var3.setColor(var8.z[var8.p]);
               var3.drawString(var11, var5, var6 - 1, 36);
               var3.drawString(var11, var5, var6 + 1, 36);
               var3.drawString(var11, var5 - 1, var6, 36);
               var3.drawString(var11, var5 + 1, var6, 36);
               var3.setColor(16777215);
               var3.drawString(var11, var5, var6, 36);
               var8.p++;
               if (var8.p >= 6) {
                  var8.p = 0;
               }

               var3 = var1;
               g var9 = this;
               if (!this.w) {
                  for (int var12 = 0; var12 < var9.r; var12++) {
                     var3.drawRegion(
                        var9.q,
                        var9.t[var9.s[var12][2] << 2],
                        var9.t[(var9.s[var12][2] << 2) + 1],
                        var9.t[(var9.s[var12][2] << 2) + 2],
                        var9.t[(var9.s[var12][2] << 2) + 3],
                        0,
                        var9.s[var12][0],
                        var9.s[var12][1],
                        20
                     );
                     var9.s[var12][0] = var9.s[var12][0] + var9.s[var12][3];
                     var9.s[var12][1] = var9.s[var12][1] - var9.s[var12][4];
                     if (var9.s[var12][0] > g() || var9.s[var12][1] < 0) {
                        var9.y[var12]++;
                     }
                  }

                  int var13 = 0;

                  while (var13 < var9.y.length && var9.y[var13] > 0) {
                     var13++;
                  }

                  if (var13 >= var9.y.length) {
                     var9.w = true;
                  }
               }
            } else {
               if (this.a == 4) {
                  var1.setColor(0);
                  var1.fillRect(0, 0, g(), h());
                  var1.setColor(16777215);
                  var1.drawString("Bạn có muốn thoát không?", i(), j() - 10, 17);
                  var1.drawString("", 2, h(), 36);
                  var1.drawString("Không", g() - 2, h(), 40);
               }
            }
      }
   }

   public final void c() {
      this.q = null;
      this.c.b();
   }

   private void E() {
      this.c.a("/data/ui/menu.ui");
   }

   public final void a(byte var1) {
      this.a = var1;
      switch (var1) {
         case 0:
            this.d.u();
            this.d.w();
            return;
         case 1:
            if (this.k > 0) {
               game.f.B().r = (byte)this.k;
            }

            this.d.s();
            this.E();
            return;
         case 2:
            this.d.o();
            this.E();
            return;
         case 3:
            this.d.q();
            this.E();
            return;
         case 5:
            this.d.K();
            this.d.a("Có chắc chắn xóa dữ liệu cũ để chơi mới không?");
         case 4:
      }
   }
}
