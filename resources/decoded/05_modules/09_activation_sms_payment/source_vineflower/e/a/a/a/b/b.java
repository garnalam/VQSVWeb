package e.a.a.a.b;

import d.d;
import d.f;
import d.g;
import d.h;
import java.io.InputStream;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;

public final class b extends Canvas implements Runnable {
   private static int a = 240;
   private static int b = 320;
   private int[][] c = new int[4][4];
   private static final String[] d = new String[]{"Nokia", "Motorokr", "Motorola", "SonyEricsson", "Samsung", "j2me", "SunMicrosystems_wtk", "MX6", "MotoA668"};
   private String e = null;
   private e.a.a.a.a.a f;
   private String g = null;
   private MIDlet h = null;
   private Displayable i;
   private int j = 0;
   private int k = 0;
   private String l = "Gửi tin";
   private String m = "Quay lại";
   private String n = null;
   private String o = null;
   private String p = null;
   private String q = null;
   private int r = 0;
   private String s = null;
   private String t = null;
   private String u = "Đặt hàng";
   private e.a.a.a.b.a v = null;
   private int w = -1;

   public b(MIDlet var1, Displayable var2, String var3, String var4, String var5, String var6, int var7, String var8, String var9, String var10) {
      this.setFullScreenMode(true);

      try {
         this.h = var1;
         this.i = var2;
         this.n = var3;
         this.o = var4;
         if (var5 == null || var5.length() == 0) {
            var5 = "00";
         }

         var6 = "000";
         this.p = var5;
         this.q = var6;
         this.r = var7;
         this.s = var8;
         this.t = var9;
         this.a(var1);
         a = this.getWidth();
         b = this.getHeight();
         this.a();
         e.a.a.a.b.b var12 = this;
         this.l = "Gửi tin";
         var12.m = "Quay lại";
         e.a.a.a.b.b var13 = var12;
         e.a.a.a.a.a var14;
         (var14 = new e.a.a.a.a.a()).c(a.a);
         var14.d(a.b);
         var14.a(2);
         var14.c(0);
         var14.e("eeee");
         var14.b(1);
         var14.a("");
         var14.b("");
         var14.a(false);
         var13.f = var14;
         var13.b();
      } catch (Exception var11) {
         var11.printStackTrace();
      }
   }

   protected final void sizeChanged(int var1, int var2) {
      super.sizeChanged(var1, var2);
      a = this.getWidth();
      b = this.getHeight();
      this.a();
   }

   private void a() {
      Font var1;
      int var2 = (var1 = Font.getFont(0, 1, 0)).getHeight() + 4;
      int var3 = a.a.c.a("Gửi tin", var1) + 4;
      this.c[0][0] = 2;
      this.c[0][1] = b - var2;
      this.c[0][2] = var3;
      this.c[0][3] = b;
      this.c[1][0] = a - var3;
      this.c[1][1] = b - var2;
      this.c[1][2] = a;
      this.c[1][3] = b;
      int var4 = var3 << 1;
      this.c[2][0] = a / 2 - var4;
      this.c[2][1] = b - var2;
      this.c[2][2] = a / 2;
      this.c[2][3] = b;
      this.c[3][0] = a / 2;
      this.c[3][1] = b - var2;
      this.c[3][2] = a / 2 + var4;
      this.c[3][3] = b;
   }

   private void a(MIDlet var1) {
      String var2 = null;

      try {
         if ((var2 = var1.getAppProperty("Platform")) == null) {
            var2 = System.getProperty("microedition.platform");
         }
      } catch (Exception var4) {
      }

      if (var2 != null) {
         var2 = var2.toLowerCase();
         String var3 = null;

         for (int var5 = 0; var5 < d.length; var5++) {
            var3 = d[var5].toLowerCase();
            if (var2.length() >= var3.length() && var2.startsWith(var3)) {
               break;
            }
         }

         this.e = var3;
      }
   }

   private void b() {
      if (this.f.j() == 0) {
         if (this.f != null) {
            this.a(this.t);
         }
      } else {
         this.c();
      }
   }

   private void c() {
      if (this.f.h()) {
         this.a("Hãy nhấn xác nhận để gửi tin nhắn");
      } else {
         int var1 = this.f.a();
         if (this.f.e() != null && this.f.e().length() != 0) {
            var1++;
         }

         StringBuffer var2;
         (var2 = new StringBuffer()).append("Bạn đã gửi " + this.f.j() + " tin nhắn, còn " + (var1 - this.f.j()) + " tin");
         this.a(var2.toString());
      }
   }

   public final void run() {
      if (this.f.f() != null
         && this.f.e().length() != 0
         && this.f.e() != null
         && this.f.e().length() != 0
         && (this.f.k() == 0L || this.f.h() && this.f.j() % 2 == 0)) {
         this.f.a(System.currentTimeMillis());
         this.f.d(this.f.j() + 1);
      }

      g var1;
      h var2;
      (var2 = (var1 = new g()).a.a).a("ca", new c(this, 0));
      var2.a("gi", new c(this, 1));
      var2.a("gs", new c(this, 2));
      var2.a("gg", new c(this, 3));
      var2.a("gj", new c(this, 4));
      var2.a("yc", new c(this, 5));
      var2.a("m", new c(this, 6));
      var2.a("n", new c(this, 7));
      var2.a("as", new c(this, 8));
      var2.a("_fc", new c(this, 9));
      var2.a("_fb", new c(this, 10));
      var2.a("ts", new c(this, 11));
      var2.a("aa", new c(this, 12));

      try {
         InputStream var3;
         d var5 = d.f.a(var3 = this.getClass().getResourceAsStream("/data/event/scene_13.mib"), var1.a.a);
         var3.close();
         var1.a(var5, null);
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   private void a(String var1) {
      this.j = 0;
      this.g = var1;
      this.repaint();
   }

   private void d() {
      if (this.v != null) {
         this.v.c(this.f.i() >= this.r);
      }
   }

   protected final void keyPressed(int var1) {
      int var10000;
      label27: {
         int var2 = var1;
         e.a.a.a.b.b var3 = this;
         if ("Motorola".equals(var3.e)) {
            switch (var2) {
               case -22:
               case 22:
                  var10000 = -7;
                  break label27;
               case -21:
               case 21:
                  var10000 = -6;
                  break label27;
               case -6:
                  var10000 = 56;
                  break label27;
            }
         }

         var10000 = var2;
      }

      var1 = var10000;
      switch (var10000) {
         case -203:
         case -22:
         case -7:
         case 22:
            this.h();
            break;
         case -202:
         case -21:
         case -6:
         case 21:
            this.g();
            break;
         case 50:
            this.e();
            break;
         case 56:
            this.f();
            break;
         default:
            System.out.println(var1);
      }

      switch (this.getGameAction(var1)) {
         case 1:
            this.e();
            return;
         case 6:
            this.f();
            return;
      }
   }

   private boolean a(int var1, int var2, int var3) {
      return var1 > this.c[var3][0] && var1 < this.c[var3][2] && var2 > this.c[var3][1] && var2 < this.c[var3][3];
   }

   protected final void pointerPressed(int var1, int var2) {
      if (this.a(var1, var2, 0)) {
         this.g();
      } else if (this.a(var1, var2, 1)) {
         this.h();
      } else {
         if (this.a(var1, var2, 2)) {
            if (this.w == 0 || this.w == 1) {
               this.e();
               return;
            }
         } else if (this.a(var1, var2, 3) && (this.w == 0 || this.w == 2)) {
            this.f();
         }
      }
   }

   protected final void keyRepeated(int var1) {
      super.keyRepeated(var1);
      this.keyPressed(var1);
   }

   private void e() {
      this.j--;
      if (this.j <= 0) {
         this.j = 0;
      }

      this.repaint();
   }

   private void f() {
      if (this.k > 0) {
         this.j++;
      }

      this.repaint();
   }

   private void g() {
      if ("Gửi tin".equals(this.l) && this.f.a() > 0) {
         this.l = "";
         this.m = "";
         new Thread(this).start();
      } else {
         if ("Xác nhận".equals(this.l)) {
            this.l = "Gửi tin";
            this.m = "Quay lại";
            this.b();
         }
      }
   }

   private void h() {
      System.out.println("payed=" + this.f.i());
      System.out.println("count=" + this.r);
      if ("Quay lại".equals(this.m)) {
         if (this.f.i() < this.r) {
            this.l = "Xác nhận";
            this.m = "Thoát";
            this.a("Bạn chưa trả tiền xong, đề nghị tiếp tục trả tiền.");
         } else {
            this.d();
            Display.getDisplay(this.h).setCurrent(this.i);
         }
      } else {
         if ("Thoát".equals(this.m)) {
            this.d();
            Display.getDisplay(this.h).setCurrent(this.i);
         }
      }
   }

   public final void paint(Graphics var1) {
      Font.getDefaultFont();
      Font var2 = Font.getFont(0, 1, 0);
      var1.setColor(4423868);
      var1.fillRect(0, 0, a, b);
      var1.setColor(255, 102, 0);
      var1.fillRect(0, 0, a, 30);
      var1.setColor(16777215);
      int var3 = (30 - var2.getHeight()) / 2;
      var1.drawString(this.u, 2, var3, 0);
      var1.setFont(var2);
      int var4 = var2.getHeight() + 8;
      int[] var10 = a.a.c.a(var1, this.g, var2, a - 10, b - var4 - 10, this.j, 5, 35, 5);
      this.k = var10[1];
      var1.setColor(255, 102, 0);
      var3 = b - var4;
      var1.fillRect(0, var3, a, var4);
      var1.setColor(16777215);
      var3 = b - (var4 + var2.getHeight()) / 2;
      var1.drawString(this.l, 2, var3, 0);
      int var5 = a - a.a.c.a(this.m, var2) - 2 - 2;
      var1.drawString(this.m, var5, var3, 0);
      int var6 = b - var4 / 2;
      this.w = -1;
      if (this.j > 0 && this.k > 0) {
         this.w = 0;
         var3 = var6 + 5;
         var1.fillTriangle(a / 2 - 10 - 3, var3, a / 2 - 10 + 3, var3, a / 2 - 10, var3 - 11);
         int var9 = var6 - 5;
         var1.fillTriangle(a / 2 + 10 - 3, var9, a / 2 + 10 + 3, var9, a / 2 + 10, var9 + 11);
      } else if (this.j > 0) {
         this.w = 1;
         int var8 = var6 + 5;
         var1.fillTriangle(a / 2 - 10 - 3, var8, a / 2 - 10 + 3, var8, a / 2 - 10, var8 - 11);
      } else {
         if (this.k > 0) {
            this.w = 2;
            int var7 = var6 - 5;
            var1.fillTriangle(a / 2 + 10 - 3, var7, a / 2 + 10 + 3, var7, a / 2 + 10, var7 + 11);
         }
      }
   }

   public final void a(e.a.a.a.b.a var1) {
      this.v = var1;
   }

   public final int a(int var1, d.c var2, int var3) {
      switch (var1) {
         case 0:
            return 0;
         case 1:
            if (var3 == 0) {
               var2.a(new Integer(this.f.i()));
               return 1;
            }

            this.f.c((Integer)var2.a(0));
            return 0;
         case 2:
            var2.a(new Integer(this.r));
            return 1;
         case 3:
            var2.a(new Integer(this.f.d()));
            return 1;
         case 4:
            if (var3 == 0) {
               var2.a(new Integer(this.f.j()));
               return 1;
            }

            this.f.d((Integer)var2.a(0));
            return 0;
         case 5:
            a.a.c.a(this.f, this.n, this.o, this.p, this.q, this.r);
            return 0;
         case 6:
            this.l = (String)var2.a(0);
            return 0;
         case 7:
            this.m = (String)var2.a(0);
            return 0;
         case 8:
            this.a((String)var2.a(0));
            return 0;
         case 9:
            var2.a(a.a);
            return 1;
         case 10:
            var2.a(a.b);
            return 1;
         case 11:
            var2.a(this.s);
            return 1;
         case 12:
            var2.a(0);
            this.c();
            return 0;
         default:
            return 0;
      }
   }
}
