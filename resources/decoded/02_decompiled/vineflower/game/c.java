package game;

import javax.microedition.lcdui.Graphics;

public final class c extends a.a {
   private static c k = null;
   private StringBuffer l = null;
   private l m = game.l.B();
   private game.a n = game.a.B();
   private int[] o = new int[]{2, 7, 8, 8, 13, 7, 2, 13, 7, 8, 15, 29};
   private int[] p = new int[]{0, 2, 9, 17, 25, 38, 45, 47, 60, 67, 75, 90};
   private byte q = 0;
   private byte r = 0;
   private byte s = 0;
   private byte t = 0;
   private byte u = 0;
   private static boolean v = true;
   private String[] w = new String[]{"1: tràng cảnh khống chế", "2: sủng vật khống chế"};
   private String[] x = new String[]{"Lựa chọn tràng cảnh", "Lựa chọn gian phòng", "Gặp địch điều chỉnh thử"};
   private short[] y = new short[]{0, 0, 198, 198, 151, 55, 80, 63, 118, 118, 118, 132, 112, 174, 160, 368, 136, 136, 230, 245, 167, 135, 168, 198};
   private String[] z = new String[]{
      "CG tràng cảnh",
      "Thôn trang",
      "Bích thủy",
      "Gỗ thô",
      "Niêm thổ",
      "Hắc thạch",
      "Hắc Long thần điện",
      "Thiên giới",
      "Viễn cổ",
      "Đạo quán",
      "Thần thú mê cung",
      "Trong phòng"
   };

   public static c B() {
      if (k == null) {
         k = new c();
      }

      return k;
   }

   public final void a() {
      if (this.j) {
         this.A();
         switch (this.a) {
            case 0:
               if (this.g(196640)) {
                  this.a((byte)1);
                  return;
               }
               break;
            case 1:
               if (this.g(16400)) {
                  this.t = 0;
                  this.r--;
                  if (this.r <= 0) {
                     this.r = 0;
                     return;
                  }
               } else if (this.g(32832)) {
                  this.t = 0;
                  this.r++;
                  if (this.r > this.x.length - 1) {
                     this.r = (byte)(this.x.length - 1);
                     return;
                  }
               } else if (this.g(4100)) {
                  if (this.r == 0) {
                     this.s--;
                     if (this.s <= 0) {
                        this.s = 0;
                        return;
                     }
                  } else if (this.r == 1) {
                     this.t--;
                     if (this.t <= 0) {
                        this.t = 0;
                        return;
                     }
                  } else if (this.r == 2) {
                     v = !v;
                     return;
                  }
               } else if (this.g(8448)) {
                  if (this.r == 0) {
                     this.s++;
                     if (this.s >= this.o.length - 1) {
                        this.s = (byte)(this.o.length - 1);
                        return;
                     }
                  } else if (this.r == 1) {
                     this.t++;
                     if (this.t >= this.o[this.s] - 1) {
                        this.t = (byte)(this.o[this.s] - 1);
                        return;
                     }
                  } else if (this.r == 2) {
                     v = !v;
                     return;
                  }
               } else {
                  if (this.g(196640)) {
                     this.m.p = this.s;
                     this.m.q = this.t;
                     game.l.B().t = -1;
                     game.l.H = true;
                     h = false;
                     this.m.r = this.y[this.s << 1];
                     this.m.s = this.y[(this.s << 1) + 1];
                     this.m.c();
                     game.f.B().a((byte)9);
                     return;
                  }

                  if (this.g(1024)) {
                     game.f.B().a((byte)10);
                     return;
                  }
               }
               break;
            case 2:
               if (this.g(4100)) {
                  this.u--;
                  if (this.u <= 0) {
                     this.u = (byte)(a.b.c.c[0].length - 1);
                     return;
                  }
               } else if (this.g(8448)) {
                  this.u++;
                  if (this.u >= a.b.c.c[0].length - 1) {
                     this.u = 0;
                     return;
                  }
               } else if (this.g(196640)) {
                  this.n.c();
                  this.m.M();
                  game.f.B().a((byte)12);
               }
         }
      }
   }

   public final void a(Graphics var1) {
      var1.setColor(16777215);
      var1.fillRect(0, 0, g(), 100);
      switch (this.a) {
         case 0:
            var1.setColor(16711680);
            var1.drawString("Đài điều khiển", g() >> 1, 10, 17);
            var1.setColor(0);

            for (int var3 = 0; var3 < this.w.length; var3++) {
               if (var3 == 0) {
                  var1.setColor(16711680);
               } else {
                  var1.setColor(0);
               }

               var1.drawString(this.w[var3], 10, 30 + var3 * 20, 20);
            }

            return;
         case 1:
            var1.setColor(16711680);
            var1.drawString(this.w[0], g() >> 1, 10, 17);

            for (int var2 = 0; var2 < this.x.length; var2++) {
               if (this.r == var2) {
                  var1.setColor(16711680);
               } else {
                  var1.setColor(0);
               }

               var1.drawString(this.x[var2], 30 + var2 * 80, 30, 20);
            }

            var1.setColor(0);
            var1.drawString("Tràng cảnh: " + this.s + "  " + this.z[this.s], 10, 50, 20);
            var1.drawString("Gian phòng: " + this.t + "  " + c(384 + this.p[this.s] + this.t), 10, 70, 20);
            if (v) {
               var1.drawString("Có thể gặp được địch", 120, 70, 20);
               return;
            }

            var1.drawString("Không thể gặp địch", 120, 70, 20);
            return;
         case 2:
            var1.setColor(16711680);
            var1.drawString(this.w[1], g() >> 1, 10, 17);
            var1.drawString("Sủng vật trước mặt: " + this.u + " tên: " + c(a.b.c.c[0][this.u][0]), g() >> 1, 30, 17);
      }
   }

   public final boolean b() {
      if (this.l == null) {
         this.l = new StringBuffer();
      }

      return true;
   }

   public final void c() {
   }

   public final void a(byte var1) {
      this.b = this.a;
      switch (var1) {
         case 1:
            this.s = (byte)this.m.p;
            this.t = (byte)this.m.q;
         case 0:
         default:
            this.a = var1;
      }
   }
}
