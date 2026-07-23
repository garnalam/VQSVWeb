package game;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class f extends a.a {
   private static f s = null;
   private byte t;
   private byte u;
   private int v;
   private Image w;
   private a.a x;
   private static int y = 0;
   private static int z = 10;
   private String[] A = new String[]{
      "Hỏa hệ khắc mộc hệ",
      "Mộc hệ khắc thổ hệ",
      "Thổ hệ khắc thủy hệ",
      "Thủy hệ khắc hỏa hệ",
      "Quỷ hệ khắc phong hệ",
      "Phong hệ khắc điện hệ",
      "Điện hệ khắc quỷ hệ"
   };
   private game.b B = game.b.B();
   public long k = 0L;
   public long l = 0L;
   public long m = 0L;
   public long n = 0L;
   public long o = 0L;
   public long p = 0L;
   a.a.c q = null;
   private String C = "";
   public byte r = 0;

   public static f B() {
      if (s == null) {
         s = new f();
      }

      return s;
   }

   public final void d(boolean var1) {
      if (var1) {
         this.C();
      } else {
         this.H();
      }
   }

   public final void C() {
      this.p = System.currentTimeMillis();
      this.a((byte)3);
      super.d(true);
   }

   private void H() {
      this.a((byte)1);
      super.d(false);
   }

   public final void a(byte var1) {
      if (var1 < 24) {
         this.u = this.t;
         switch (this.t) {
            case 2:
            case 4:
            case 5:
            case 6:
            case 8:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            default:
               break;
            case 3:
               a.a.f.a().a = -1;
               break;
            case 7:
            case 9:
            case 12:
            case 22:
            case 23:
               y = 0;
         }

         this.t = (byte)var1;
         switch (var1) {
            case 2:
               if (game.l.B().m != null) {
                  game.l.B().m.I();
               }
               break;
            case 3:
               y = 0;
               a.a.f.a().c(0, 19);
            case 4:
            case 5:
            case 7:
            case 8:
            case 10:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            default:
               break;
            case 6:
               this.w = null;
               this.w = a.e.b("/data/img/", "img_831");
               break;
            case 9:
               a(false);
               var1 = a.e.a(this.A.length);
               this.C = this.A[var1];
               break;
            case 11:
               game.l.B().d.g = true;
               break;
            case 12:
            case 22:
               a(false);
               y = 0;
               break;
            case 15:
               this.w = null;
               this.w = a.e.a("/data/logo/", "0");
               break;
            case 21:
               a.a.f.a().c(0, 18);
               a.a.f.a().e();
               break;
            case 23:
               a(false);
               y = 0;
               this.B.a((byte)1);
         }

         this.v = 0;
      }
   }

   public final byte D() {
      return this.t;
   }

   public final synchronized void E() {
      if (game.l.B().W != null) {
         game.l.B().W.b();
      }

      if (this.t != 2) {
         this.a((byte)2);
         this.z();
      }
   }

   private void I() {
      this.a(this.u);
      if (game.l.B().W != null) {
         game.l.B().W.c();
      }

      this.z();
   }

   public final boolean b() {
      this.d();
      this.d = game.k.a();
      this.c = c.j.a();
      this.d.a(this);
      a.b.c.a(50000);
      a.b.f.a(1000);
      a.b.c.a();
      b(0);
      m();
      this.B.b();
      Image var1;
      int[] var2 = a.e.a(var1 = a.e.b("/data/img/", "img_22"));
      this.q = new a.a.c();
      this.q.a(var2, var1.getWidth(), var1.getHeight());
      game.l.B();
      game.l.G();
      e();
      return true;
   }

   public final void c() {
      if (this.x != null) {
         this.x.c();
         this.x = null;
      }
   }

   public final void a() {
      if (this.j) {
         this.A();
         switch (this.t) {
            case 2:
               if (this.g(262144)) {
                  this.I();
               }
               break;
            case 3:
               if (!f()) {
                  this.b();
               }

               if (a.a.f.a().d && f()) {
                  this.a((byte)15);
               }
               break;
            case 4:
               if (this.g(131072)) {
                  this.H();
               } else if (this.g(262144)) {
                  this.I();
               }
            case 5:
            case 14:
            case 17:
            case 18:
            default:
               break;
            case 6:
               if (this.g(131072)) {
                  byte var2 = 1;
                  this.r = (byte)var2;
                  this.a((byte)21);
               } else if (this.g(262144)) {
                  byte var4 = 0;
                  this.r = (byte)var4;
                  this.a((byte)21);
               }
               break;
            case 7:
               this.c();
               this.x = game.g.B();
               this.x.b();
               this.a(this.x);
               this.a((byte)8);
               break;
            case 8:
            case 11:
            case 13:
            case 20:
               if (this.x != null) {
                  this.x.a();
               }
               break;
            case 9:
            case 22:
               this.c();
               this.x = game.l.B();
               this.x.b();
               this.a(this.x);
               if (this.t == 9 || this.t == 22) {
                  this.a((byte)11);
               }

               game.j.V = false;
               break;
            case 10:
               this.c();
               this.x = game.l.B();
               ((l)this.x).L();
               this.a(this.x);
               this.a((byte)11);
               break;
            case 12:
               if (!f()) {
                  this.x = null;
                  this.x = game.a.B();
                  this.x.b();
                  this.a(this.x);
                  if (((game.a)this.x).l == 0) {
                     a.a.f.a().c(-2013265920, 6);
                  } else if (((game.a)this.x).l == 2) {
                     a.a.f.a().c(-2013265920, 8);
                  } else if (((game.a)this.x).l == 1) {
                     a.a.f.a().c(-2013265920, 7);
                  }
               }

               if (f()) {
                  a.a.f.a().d();
                  game.j.V = false;
               }

               if (a.a.f.a().d) {
                  ((game.a)this.x).E();
                  this.a((byte)13);
               }
               break;
            case 15:
               this.v++;
               if (this.v >= 10) {
                  this.v = 0;
                  this.w = null;
                  this.w = a.e.a("/data/logo/", "cwalogo");
                  this.a((byte)16);
               }
               break;
            case 16:
               this.v++;
               if (this.v >= 10) {
                  this.a((byte)6);
               }
               break;
            case 19:
               byte var3;
               if (this.x instanceof l) {
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               this.x = game.c.B();
               this.x.b();
               this.a(this.x);
               this.x.a(var3);
               this.a((byte)20);
               break;
            case 21:
               a.a.f.a().d();
               if (a.a.f.a().c == -1 || this.g(65568) && game.g.h) {
                  a.a.f.a().c = -1;
                  a.a.f.a().b = -1;
                  a.a.f.a().f = 0;
                  a.a.f.a().a = -1;
                  this.w = null;
                  a.a.c var1 = this.q;
                  this.q.a = null;
                  this.q = null;
                  this.a((byte)7);
               }
               break;
            case 23:
               a.a.f.a().d();
               if (this.B.a == 1 && a.a.f.a().e) {
                  this.B.a((byte)2);
               } else if (this.B.a == 2) {
                  if (this.B.k) {
                     this.c();
                     this.x = game.l.B();
                     this.x.b();
                     this.a(this.x);
                     this.B.a((byte)3);
                  }
               } else if (this.B.a == 3 && a.a.f.a().e) {
                  a.a.f.a().b = -1;
                  this.B.C();
                  this.a((byte)11);
               }
         }

         if (this.a != 2) {
            if (game.l.B().p == 3 && game.l.B().q == 7 && this.m == 0L && this.k != 0L) {
               this.l = System.currentTimeMillis();
            }

            this.o = System.currentTimeMillis();
         }
      }
   }

   public final void a(Graphics var1) {
      if (this.j) {
         var1.setFont(m());
         switch (this.t) {
            case 2:
               var1.setColor(0);
               var1.fillRect(0, 0, g(), h());
               var1.setColor(16777215);
               var1.drawString("Trò chơi tạm dừng", g() >> 1, j(), 33);
               var1.drawString("Quay lại", g() - 2, h() - 2, 40);
               return;
            case 3:
               var1.setColor(16777215);
               var1.fillRect(0, 0, g(), h());
               a.a.f.a().a(var1);
               return;
            case 4:
               return;
            case 5:
            case 14:
            case 17:
            case 18:
            case 19:
            case 22:
            default:
               break;
            case 6:
               var1.setColor(0);
               var1.fillRect(0, 0, g(), h());
               var1.setFont(m());
               var1.setColor(16777215);
               var1.drawString(c(8), g() >> 1, 144, 17);
               var1.drawString(c(4), 2, h() - 2, 36);
               var1.drawString(c(5), g() - 2, h() - 2, 40);
               var1.setColor(16739328);
               var1.drawString(c(9), g() >> 1, 166, 17);
               return;
            case 7:
               return;
            case 8:
            case 11:
            case 13:
            case 20:
               if (this.x != null) {
                  this.x.a(var1);
               }
               break;
            case 9:
               Graphics var6 = var1;
               f var5 = this;
               if (game.j.V) {
                  var6.setColor(0);
                  var6.fillRect(0, 0, g(), h());
                  if (y % 4 == 3) {
                     game.j.p().a((byte)1, (byte)-1, false);
                  } else {
                     game.j.p().a((byte)(y % 4), (byte)-1, false);
                  }

                  j var10000 = game.j.p();
                  byte var4 = (byte)(y % 4);
                  var10000.o = var4;
                  game.j.p().a(var6, a.b.d.a().a, a.b.d.a().b - y);
               } else {
                  var6.setColor(0);
                  var6.fillRect(0, 0, g(), h());
               }

               if (y < 148) {
                  y = y + z;
               }

               if (y > 148) {
                  y = 148;
               }

               if (!game.j.V) {
                  var6.setColor(0);
                  var6.fillRect(45, h() - 48, 150, 5);
                  var6.setColor(7877410);
                  var6.fillRect(46, h() - 47, 148, 3);
                  var6.setColor(16707204);
                  var6.fillRect(46, h() - 47, y, 3);
                  var6.setColor(16777215);
                  var6.drawString(var5.C, g() >> 1, h() - 70, 17);
               }

               return;
            case 10:
               return;
            case 12:
               game.l.B().l.a(var1);
               if (f()) {
                  a.a.f.a().a(var1);
                  game.j.V = false;
                  return;
               }
               break;
            case 15:
               var1.setColor(16777215);
               var1.fillRect(0, 0, g(), h());
               var1.setColor(16777215);
               var1.setFont(m());
               if (this.w != null) {
                  var1.drawImage(this.w, i(), j(), 3);
                  return;
               }
               break;
            case 16:
               var1.setColor(l());
               var1.fillRect(0, 0, g(), h());
               if (this.w != null) {
                  var1.drawImage(this.w, (g() - this.w.getWidth()) / 2, (h() - this.w.getHeight()) / 2, 20);
                  return;
               }
               break;
            case 21:
               var1.drawImage(this.w, 0, 0, 20);

               for (int var2 = 0; var2 < g() / 10; var2++) {
                  var1.drawRGB(this.q.a, 0, this.q.b, var2 * 10, 0, this.q.b, this.q.c, true);
               }

               a.a.f.a().a(var1);
               return;
            case 23:
               this.B.a();
               this.B.a(var1);
               a.a.f.a().a(var1);
               return;
         }
      }
   }

   public final void l(int var1) {
      this.r = (byte)var1;
   }

   public final void F() {
      this.r++;
      if (this.r > 3) {
         this.r = 3;
      }
   }

   public final void G() {
      this.r--;
      if (this.r < 0) {
         this.r = 0;
      }
   }
}
