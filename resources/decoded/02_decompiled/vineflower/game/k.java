package game;

import java.util.Vector;

public final class k implements c.a {
   private static k n;
   private a.a o;
   private c.j p = c.j.a();
   private j q;
   protected int a;
   protected int b;
   protected int c;
   private int r;
   protected int d;
   protected int e;
   private int s;
   protected int f;
   protected boolean g;
   private byte t;
   private byte u;
   private int v;
   protected int h;
   private int w;
   protected int i;
   private int[] x;
   private int[] y;
   public byte j = -1;
   private static String[] z = new String[]{"Thủy Kimura", "Bích Thủy thành", "Nguyên Mộc Thành", "Niêm Thổ Thành", "Hắc Thạch thành", "Thiên không", "Xa cổ"};
   private static short[] A = new short[]{
      1, 0, 196, 208, 0, 2, 1, 196, 208, 0, 3, 3, 196, 208, 0, 4, 5, 320, 352, 0, 5, 3, 320, 196, 0, 7, 2, 288, 112, 0, 8, 0, 160, 144, 0
   };
   private Vector B = new Vector();
   private int C = 0;
   private int D = 0;
   private int E = 0;
   private int F = 0;
   public int k = 0;
   boolean l = false;
   private int G;
   private int H;
   private int I = 0;
   private int J = 0;
   private int K = 0;
   private int L = 0;
   private String[] M = new String[]{"/data/ui/option.ui", "/data/ui/answer.ui", "/data/ui/wharf1.ui"};
   public short[] m = new short[]{9, 0, 120, 448, 9, 1, 136, 272, 9, 2, 208, 256, 9, 3, 80, 264, 9, 4, 112, 288, 9, 5, 40, 280, 9, 6, 136, 328, 9, 7, 104, 328};
   private String[] N = new String[]{
      "Đạt được 2000 kim tiền", "Đạt được 5 Phong ấn cầu", "Đạt được 5 Bánh Sandwich", "Đạt được 2 Sinh mệnh thạch", "Đạt được 2 huy hiệu"
   };
   private short[][] O = new short[][]{{621, 622}, {623, 624}, {625, 626}, {627, 628}, {629, 630, 631, 632}};
   private short[][] P = new short[][]{
      {5, 2, 112, 224, 2, 2, 5, 6, 1, 6, 0, 112, 224, 2, 0, 1, 0, 10},
      {4, 0, 48, 176, 2, 2, 3, 6, 3, 6, 0, 112, 224, 2, 2, 1, 0, 10},
      {3, 6, 288, 224, 3, 0, 3, 6, 3, 6, 0, 112, 224, 2, 2, 1, 0, 10},
      {1, 5, 272, 128, 3, 0, 5, 6, 1, 6, 0, 112, 224, 2, 0, 1, 0, 10},
      {1, 5, 272, 128, 3, 2, 0, 0, 0, 3, 6, 288, 224, 3, 0, 0, 0, 0, 4, 0, 48, 176, 2, 0, 0, 0, 0, 5, 2, 112, 224, 2, 2, 0, 0, 0}
   };
   private byte Q;
   private byte R;
   private String[] S = new String[]{"Dẫn thưởng", "Tiến hóa", "Dị hóa", "Tài liệu", "Cách mở"};

   public static k a() {
      if (n == null) {
         n = new k();
      }

      return n;
   }

   public k() {
      if (this.q == null) {
         this.q = game.j.p();
      }
   }

   public final void b() {
      n = null;
      this.q = null;
   }

   public final void a(a.a var1) {
      if (this.o != null) {
         this.o = null;
      }

      this.o = var1;
      this.g = true;
   }

   public final void c() {
      this.p.a("/data/ui/world.ui", 257, this);
      this.t = 0;
   }

   public final void d() {
      this.p.a.a(5).a(true);
      this.p.a.a(7).a(true);
   }

   private void aU() {
      if (this.p.b("/data/ui/world.ui")) {
         for (int var1 = 1; var1 <= 7; var1++) {
            this.p.a.a(var1).a(false);
         }
      }
   }

   public final void e() {
      if (this.t < 2 && !game.e.r && game.l.T && this.p.c("/data/ui/world.ui")) {
         c.c var10000 = this.p.d("/data/ui/world.ui");
         byte var1 = 4;
         boolean var2 = true;
         if (((c.h)var10000.a(1)).i().m.a().b(4)) {
            ((c.h)this.p.d("/data/ui/world.ui").a(6)).i().a = ((l)this.o).u;
            this.t = 1;
         } else if (this.t == 1) {
            var10000 = this.p.d("/data/ui/world.ui");
            var2 = true;
            if (((c.h)var10000.a(1)).i().m.a().h() >= 5) {
               ((c.h)this.p.d("/data/ui/world.ui").a(6)).i().a = "";
               this.t = 2;
               game.l.T = false;
            }
         }
      }

      this.f();
   }

   public final boolean f() {
      if (this.u < 2 && this.p.b("/data/ui/openbox.ui")) {
         if (this.u == 1) {
            if (this.o.g(196640)) {
               this.p.a.a(2).i().a = "";
               this.u = 2;
               this.g = true;
               this.az();
               return true;
            }
         } else {
            this.u = 1;
         }
      }

      return this.g();
   }

   public final boolean g() {
      if (this.u < 2) {
         if (this.p.b("/data/ui/taskTip.ui")) {
            if (this.u == 1) {
               if (this.o.g(196640)) {
                  this.u = 2;
                  this.g = true;
                  k var1 = this;
                  if (this.p.b("/data/ui/taskTip.ui")) {
                     var1.p.a("/data/ui/taskTip.ui");
                  }

                  return true;
               }
            } else {
               this.u = 1;
            }
         }

         this.g = true;
      }

      return false;
   }

   public final void h() {
      this.p.a("/data/ui/transmit.ui", 257, this);
      ((c.b)this.p.a.a(0)).a.a = z.length;
      ((c.b)this.p.a.a(0)).a.a(1);
      this.aV();
   }

   private void aV() {
      this.v = ((c.b)this.p.a.a(0)).a.e;
      this.h = ((c.b)this.p.a.a(0)).a.f;

      for (int var1 = 0; var1 < 5; var1++) {
         this.p.a.a(var1 + 5).i().a = z[var1 + this.v];
      }

      this.p.a.a(13).b(109 + this.h * 88 / z.length, this.p.a.a());
   }

   public final void i() {
      if (this.o.g(4100)) {
         this.p.a.b(0);
         this.aV();
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
         this.aV();
      } else if (this.o.g(196640)) {
         game.l.B().p = A[this.h * 5];
         game.l.B().q = A[this.h * 5 + 1];
         game.l.B().r = A[this.h * 5 + 2];
         game.l.B().s = A[this.h * 5 + 3];
         game.l.G = (byte)A[this.h * 5 + 4];
         game.l.B().t = -1;
         game.f.B().a((byte)9);
      } else {
         if (this.o.g(262144)) {
            this.o.a((byte)8);
            this.p.a("/data/ui/transmit.ui");
         }
      }
   }

   public final boolean j() {
      return this.p.b("/data/ui/openbox.ui") || this.p.b("/data/ui/taskTip.ui");
   }

   public final void k() {
      String[] var1 = new String[]{"Tùy thân cửa hàng", "Sủng vật", "Lưng bao", "Đồ giám", "Nhiệm vụ", "Lưu dữ liệu"};
      this.aU();
      this.p.a("/data/ui/gamemenu.ui", 257, this);
      if (a.a.i) {
         ((c.b)this.p.a.a(0)).a.a = 6;
         this.p.a.a(14).i().a = a.a.c(605 + this.b);
         this.p.a.a(15).i().a = var1[0];

         for (int var2 = 0; var2 < 5; var2++) {
            this.p.a.a(var2 + 5).i().a = var1[var2 + 1];
         }
      } else {
         ((c.b)this.p.a.a(0)).a.a = 5;
         this.p.a.a(14).i().a = a.a.c(606 + this.b);
         this.p.a.a(15).i().a = var1[1];

         for (int var3 = 0; var3 < 4; var3++) {
            this.p.a.a(var3 + 5).i().a = var1[var3 + 2];
         }

         this.p.a.a(9).a(false);
      }

      ((c.b)this.p.a.a(0)).a.f = this.b;
      this.p.a.a(18).i().a = "" + this.q.G();
      this.p.a.a(19).i().a = "" + this.q.F();
      this.f = 0;
   }

   public final void l() {
      this.o.q();
      if (!a.a.a(this.b, 0) && !this.j() && this.o.g(4100)) {
         this.p.a.b(0);
      } else if (!a.a.a(this.b, 0) && !this.j() && this.o.g(8448)) {
         this.p.a.b(1);
      } else if (!this.j() && a.a.s() && this.o.g(196640)) {
         if (a.a.p() && !a.a.a(this.b, 0)) {
            return;
         }

         if (a.a.i) {
            switch (this.b) {
               case 0:
                  this.o.a((byte)14);
                  this.p.a("/data/ui/gamemenu.ui");
                  break;
               case 1:
                  this.c = 0;
                  this.o.r();
                  this.o.a((byte)7);
                  this.p.a("/data/ui/gamemenu.ui");
                  break;
               case 2:
                  this.o.r();
                  this.o.a((byte)8);
                  this.p.a("/data/ui/gamemenu.ui");
                  break;
               case 3:
                  this.c = 0;
                  this.o.a((byte)9);
                  this.p.a("/data/ui/gamemenu.ui");
                  break;
               case 4:
                  this.b = 0;
                  this.o.a((byte)10);
                  this.p.a("/data/ui/gamemenu.ui");
                  break;
               case 5:
                  this.p.a.a(11).a(false);
                  this.p.a.a(12).a(false);
                  this.o.a((byte)22);
            }
         } else {
            switch (this.b) {
               case 0:
                  this.c = 0;
                  this.o.r();
                  this.o.a((byte)7);
                  this.p.a("/data/ui/gamemenu.ui");
                  break;
               case 1:
                  this.o.r();
                  this.o.a((byte)8);
                  this.p.a("/data/ui/gamemenu.ui");
                  break;
               case 2:
                  this.c = 0;
                  this.o.a((byte)9);
                  this.p.a("/data/ui/gamemenu.ui");
                  break;
               case 3:
                  this.b = 0;
                  this.o.a((byte)10);
                  this.p.a("/data/ui/gamemenu.ui");
                  break;
               case 4:
                  this.p.a.a(11).a(false);
                  this.p.a.a(12).a(false);
                  this.o.a((byte)22);
            }
         }
      } else if (a.a.t() && this.o.g(262144)) {
         this.p.a("/data/ui/gamemenu.ui");
         this.o.a((byte)0);
      }

      this.g();
   }

   public final void m() {
      this.aU();
      this.p.a("/data/ui/gamesystem.ui", 257, this);
      ((c.b)this.p.a.a(0)).a.f = this.b;
      this.f = 0;
   }

   public final void n() {
      if (this.o.g(4100)) {
         this.p.a.b(0);
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
      } else if (this.o.g(196640)) {
         switch (this.b) {
            case 0:
               this.p.a("/data/ui/gamesystem.ui");
               this.o.a((byte)0);
               return;
            case 1:
               this.o.a((byte)20);
               this.p.a("/data/ui/gamesystem.ui");
               return;
            case 2:
               this.o.a((byte)21);
               this.p.a("/data/ui/gamesystem.ui");
               return;
            case 3:
               if (this.f == 0) {
                  this.p.a("/data/ui/option.ui", 257, this);
                  this.c = 1;
                  ((c.b)this.p.a.a(0)).a.f = this.c;
                  this.p.a.a(12).i().a = "";
                  this.p.a.a(13).i().a = "Không";
                  this.f = 1;
                  return;
               } else {
                  switch (this.c) {
                     case 0:
                        game.f.B().l = 0L;
                        game.f.B().k = 0L;
                        game.j.p().z = false;
                        game.f.B().a((byte)7);
                        this.p.a("/data/ui/gamesystem.ui");
                        break;
                     case 1:
                        this.p.a("/data/ui/option.ui");
                        this.f = 0;
                        this.g = true;
                        return;
                  }
               }
         }
      } else {
         if (this.o.g(262144)) {
            if (this.f == 0) {
               this.p.a("/data/ui/gamesystem.ui");
               this.o.a((byte)0);
               return;
            }

            if (this.f == 1) {
               this.g = true;
               this.p.a("/data/ui/option.ui");
               this.f = 0;
            }
         }
      }
   }

   public final void o() {
      this.p.a("/data/ui/help1.ui", 257, this);
      this.b = 0;
      this.p.a.a(6).a(true);
      this.p.a.a(7).a(false);
      this.e(this.b);
   }

   private void e(int var1) {
      if (var1 == 0) {
         this.p.a.a(5).i().a = "Trợ giúp";
         this.p.a.a(8).i().a = "Nhấn nút 2, 4, 6, 8 để di chuyển#nNút 5: công kích, đối thoại, xác nhận#nNút 1: Xem nhiệm vụ#nNút 9: lựa chọn sủng vật cưỡi#nNút 0: Xem bản đồ#nNút mềm trái: menu hệ thống#nNút mềm phải: menu trò chơi";

         for (int var2 = 0; var2 < 28; var2++) {
            this.p.a.a(var2 + 9).a(false);
         }
      } else if (var1 > 0) {
         this.p.a.a(8).i().a = "";

         for (int var3 = 0; var3 < 14; var3++) {
            this.p.a.a(9 + (var3 << 1)).a(true);
            this.p.a.a(9 + (var3 << 1) + 1).a(true);
            if ((var1 - 1) * 14 + var3 < 26) {
               this.p.a.a(9 + (var3 << 1)).i().m = new c.g();
               this.p.a.a(9 + (var3 << 1)).i().m.a(0);
               this.p.a.a(9 + (var3 << 1)).i().m.a = 2;
               this.p.a.a(9 + (var3 << 1)).i().m.a(325, false, (byte)-2);
               this.p.a.a(9 + (var3 << 1)).i().m.a((var1 - 1) * 14 + var3 + 1);
               if ((var1 - 1) * 14 + var3 <= 10) {
                  this.p.a.a(9 + (var3 << 1) + 1).i().a = a.a.c(var3 + 311);
               } else {
                  this.p.a.a(9 + (var3 << 1) + 1).i().a = a.a.c(333 + ((var1 - 1) * 14 + var3 - 11));
               }
            } else {
               this.p.a.a(9 + (var3 << 1)).a(false);
               this.p.a.a(9 + (var3 << 1) + 1).a(false);
            }
         }
      }

      this.p.a.a(39).i().a = var1 + 1 + "/3";
   }

   public final void p() {
      if (this.o.g(16400)) {
         this.b--;
         if (this.b <= 0) {
            this.b = 0;
         }

         this.e(this.b);
      } else if (this.o.g(32832)) {
         this.b++;
         if (this.b >= 2) {
            this.b = 2;
         }

         this.e(this.b);
      } else {
         if (this.o.g(262144)) {
            this.o.a((byte)0);
            this.p.a("/data/ui/help1.ui");
         }
      }
   }

   public final void q() {
      this.p.a("/data/ui/help.ui", 257, this);
      this.p.a.a(5).i().a = "Quan tại";
      this.p.a.a(8).i().a = "Tên trò chơi: Sủng vật Vương quốc - Liệt hỏa#nViệt hóa: BIGAME";
      this.p.a.a(6).a(true);
      this.p.a.a(7).a(false);

      for (int var1 = 9; var1 < 13; var1++) {
         this.p.a.a(var1).a(false);
      }
   }

   public final void r() {
      if (this.o.g(262144)) {
         this.o.a((byte)0);
         this.p.a("/data/ui/help.ui");
      }
   }

   public final void s() {
      this.p.a("/data/ui/help.ui", 257, this);
      this.p.a.a(5).i().a = "Tùy chọn";
      this.p.a.a(8).i().a = "";
      this.p.a.a(6).a(false);
      this.p.a.a(7).a(true);

      for (int var1 = 9; var1 < 13; var1++) {
         this.p.a.a(var1).a(true);
      }

      this.aW();
   }

   private void aW() {
      for (int var1 = 1; var1 < 4; var1++) {
         if (var1 <= game.f.B().r) {
            this.p.a.a(var1 + 9).i().j = -2148;
         } else {
            this.p.a.a(var1 + 9).i().j = -8540732;
         }
      }
   }

   public final void t() {
      if (this.o.g(16400)) {
         game.f.B().G();
         this.aW();
      } else if (this.o.g(32832)) {
         game.f.B().F();
         this.aW();
      } else {
         if (this.o.g(131072)) {
            game.g.B().k = game.f.B().r;
            this.o.a((byte)0);
            this.p.a("/data/ui/help.ui");
         }
      }
   }

   public final void u() {
      this.p.a("/data/ui/menu.ui", 336, this);
   }

   public final void v() {
      this.p.a("/data/ui/menu1.ui", 336, this);
   }

   public final void w() {
      this.p.a("/data/ui/menu1.ui");
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            this.p.a.a(var2).a(false);
            return;
         case 1:
            this.p.a.a(8).a(false);
            this.p.a.a(9).a(false);
            return;
         case 2:
            this.p.a.a(10).a(false);
            this.p.a.a(11).a(false);
            return;
         case 3:
            this.p.a.a(12).a(false);
            this.p.a.a(13).a(false);
            return;
         case 4:
            for (int var7 = 0; var7 < 2; var7++) {
               if (this.p.a.a(var7 + 16).i().m == null) {
                  this.p.a.a(var7 + 16).i().m = new c.g();
                  this.p.a.a(var7 + 16).i().m.a = 2;
                  this.p.a.a(var7 + 16).i().m.a(0);
                  this.p.a.a(var7 + 16).i().m.a(336, false, (byte)0);
                  if (var7 == 0) {
                     this.p.a.a(var7 + 16).i().m.a(8);
                  } else {
                     this.p.a.a(var7 + 16).i().m.a(10);
                  }
               }
            }

            return;
         case 5:
            this.p.a.a(16).a(false);
            this.p.a.a(17).a(false);

            for (int var6 = 0; var6 < 2; var6++) {
               this.p.a.a(var6 + 16).l();
               if (this.p.a.a(var6 + 18).i().m == null) {
                  this.p.a.a(var6 + 18).i().m = new c.g();
                  this.p.a.a(var6 + 18).i().m.a = 2;
                  this.p.a.a(var6 + 18).i().m.a(0);
                  this.p.a.a(var6 + 18).i().m.a(336, false, (byte)0);
                  if (var6 == 0) {
                     this.p.a.a(var6 + 18).i().m.a(8);
                  } else {
                     this.p.a.a(var6 + 18).i().m.a(11);
                  }
               }
            }

            return;
         case 6:
            this.p.a.a(19).a(false);
            this.p.a.a(19).l();
            if (this.p.a.a(20).i().m == null) {
               this.p.a.a(20).i().m = new c.g();
               this.p.a.a(20).i().m.a = 2;
               this.p.a.a(20).i().m.a(0);
               this.p.a.a(20).i().m.a(336, false, (byte)0);
               this.p.a.a(20).i().m.a(12);
               return;
            }
            break;
         case 7:
            this.p.a.a(20).a(false);
            this.p.a.a(20).l();
            return;
         case 8:
            for (int var5 = 0; var5 < 2; var5++) {
               if (this.p.a.a(var5 + 21).i().m == null) {
                  this.p.a.a(var5 + 21).i().m = new c.g();
                  this.p.a.a(var5 + 21).i().m.a = 2;
                  this.p.a.a(var5 + 21).i().m.a(0);
                  this.p.a.a(var5 + 21).i().m.a(336, false, (byte)0);
                  if (var5 == 0) {
                     this.p.a.a(var5 + 21).i().m.a(7);
                  } else {
                     this.p.a.a(var5 + 21).i().m.a(13);
                  }
               }
            }

            return;
         case 9:
            this.p.a.a(21).a(false);
            this.p.a.a(22).a(false);

            for (int var4 = 0; var4 < 2; var4++) {
               this.p.a.a(var4 + 21).l();
               if (this.p.a.a(var4 + 23).i().m == null) {
                  this.p.a.a(var4 + 23).i().m = new c.g();
                  this.p.a.a(var4 + 23).i().m.a = 2;
                  this.p.a.a(var4 + 23).i().m.a(0);
                  this.p.a.a(var4 + 23).i().m.a(336, false, (byte)0);
                  if (var4 == 0) {
                     this.p.a.a(var4 + 23).i().m.a(7);
                  } else {
                     this.p.a.a(var4 + 23).i().m.a(14);
                  }
               }
            }

            return;
         case 10:
            this.p.a.a(24).a(false);
            this.p.a.a(24).l();
            if (this.p.a.a(25).i().m == null) {
               this.p.a.a(25).i().m = new c.g();
               this.p.a.a(25).i().m.a = 2;
               this.p.a.a(25).i().m.a(0);
               this.p.a.a(25).i().m.a(336, false, (byte)0);
               this.p.a.a(25).i().m.a(15);
               return;
            }
            break;
         case 11:
            this.p.a.a(25).a(false);
            this.p.a.a(25).l();
            return;
         case 12:
            if (this.p.a.a(26).i().m == null) {
               this.p.a.a(26).i().m = new c.g();
               this.p.a.a(26).i().m.a = 2;
               this.p.a.a(26).i().m.a(0);
               this.p.a.a(26).i().m.a(336, false, (byte)0);
               this.p.a.a(26).i().m.a(5);
               return;
            }
            break;
         case 13:
            this.p.a.a(26).a(false);
            this.p.a.a(26).l();
            if (this.p.a.a(27).i().m == null) {
               this.p.a.a(27).i().m = new c.g();
               this.p.a.a(27).i().m.a = 2;
               this.p.a.a(27).i().m.a(0);
               this.p.a.a(27).i().m.a(336, false, (byte)0);
               this.p.a.a(27).i().m.a(5);
               return;
            }
            break;
         case 14:
            return;
         case 15:
            if (this.p.a.a(28).i().m == null) {
               this.p.a.a(28).i().m = new c.g();
               this.p.a.a(28).i().m.a = 2;
               this.p.a.a(28).i().m.a(0);
               this.p.a.a(28).i().m.a(336, false, (byte)0);
               this.p.a.a(28).i().m.a(6);
               return;
            }
            break;
         case 16:
            this.p.a.a(28).a(false);
            this.p.a.a(28).l();
            if (this.p.a.a(29).i().m == null) {
               this.p.a.a(29).i().m = new c.g();
               this.p.a.a(29).i().m.a = 2;
               this.p.a.a(29).i().m.a(0);
               this.p.a.a(29).i().m.a(336, false, (byte)0);
               this.p.a.a(29).i().m.a(6);
               return;
            }
            break;
         case 17:
            this.p.a.a(29).a(false);
            this.p.a.a(29).l();
            if (this.p.a.a(30).i().m == null) {
               this.p.a.a(30).i().m = new c.g();
               this.p.a.a(30).i().m.a = 2;
               this.p.a.a(30).i().m.a(0);
               this.p.a.a(30).i().m.a(336, false, (byte)0);
               this.p.a.a(30).i().m.a(6);
               return;
            }
            break;
         case 18:
         case 19:
            this.p.a.a(30).a(false);
            this.p.a.a(30).l();
            if (this.p.a.a(31).i().m == null) {
               this.p.a.a(31).i().m = new c.g();
               this.p.a.a(31).i().m.a = 2;
               this.p.a.a(31).i().m.a(0);
               this.p.a.a(31).i().m.a(336, false, (byte)0);
               this.p.a.a(31).i().m.a(6);
               return;
            }
            break;
         case 20:
            a.a.f.a().c(16777215, 2);
            a.a.f.a().g = 85;
            return;
         case 21:
         case 22:
         case 23:
            this.p.a.a(18).a(false);
            this.p.a.a(18).l();
            this.p.a.a(23).a(false);
            this.p.a.a(23).l();
            this.p.a.a(27).a(false);
            this.p.a.a(27).l();
            this.p.a.a(31).a(false);
            this.p.a.a(31).l();
            this.p.a.a(14).a(false);
            this.p.a.a(15).a(false);
            return;
         case 24:
            a.a.f.a().c(16777215, 1);
            a.a.f.a().g = 255;
            if (this.p.a.a(32).i().m == null) {
               this.p.a.a(32).i().m = new c.g();
               this.p.a.a(32).i().m.a = 2;
               this.p.a.a(32).i().m.a(0);
               this.p.a.a(32).i().m.a(336, false, (byte)0);
               return;
            }
            break;
         case 25:
            this.p.a.a(32).a(false);
            this.p.a.a(32).l();

            for (int var3 = 0; var3 < 5; var3++) {
               if (this.p.a.a(var3 + 33).i().m == null) {
                  this.p.a.a(var3 + 33).i().m = new c.g();
                  this.p.a.a(var3 + 33).i().m.a = 2;
                  this.p.a.a(var3 + 33).i().m.a(336, false, (byte)0);
                  if (var3 == 0) {
                     this.p.a.a(var3 + 33).i().m.a(0);
                  } else if (var3 == 1) {
                     this.p.a.a(var3 + 33).i().m.a(8);
                  } else if (var3 == 2) {
                     this.p.a.a(var3 + 33).i().m.a(5);
                  } else if (var3 == 3) {
                     this.p.a.a(var3 + 33).i().m.a(7);
                  } else if (var3 == 4) {
                     this.p.a.a(var3 + 33).i().m.a(6);
                  }
               }
            }

            return;
         case 26:
            game.f.B().q = a.a.d.b(game.f.B().q, var2);
            return;
         case 27:
            if (var2 > 38) {
               this.p.a.a(var2 - 1).a(false);
               this.p.a.a(var2 - 1).l();
            }

            if (this.p.a.a(var2).i().m == null) {
               this.p.a.a(var2).i().m = new c.g();
               this.p.a.a(var2).i().m.a = 2;
               this.p.a.a(var2).i().m.a(4);
               this.p.a.a(var2).i().m.a(336, false, (byte)0);
               return;
            }
            break;
         case 28:
            if (var2 > 43) {
               this.p.a.a(var2 - 1).a(false);
               this.p.a.a(var2 - 1).l();
            }

            if (this.p.a.a(var2).i().m == null) {
               this.p.a.a(var2).i().m = new c.g();
               this.p.a.a(var2).i().m.a = 2;
               this.p.a.a(var2).i().m.a(1);
               this.p.a.a(var2).i().m.a(336, false, (byte)0);
            }
      }
   }

   public final void x() {
      this.p.a("/data/ui/help1.ui", 257, this);
      this.p.a("/data/ui/gamesystem.ui");
      this.r = 0;
      this.p.a.a(6).a(true);
      this.p.a.a(7).a(false);
      this.e(this.r);
   }

   public final void y() {
      if (this.o.g(16400)) {
         this.r--;
         if (this.r <= 0) {
            this.r = 0;
         }

         this.e(this.r);
      } else if (this.o.g(32832)) {
         this.r++;
         if (this.r >= 2) {
            this.r = 2;
         }

         this.e(this.r);
      } else {
         if (this.o.g(262144)) {
            this.o.a((byte)13);
            this.p.a("/data/ui/help1.ui");
         }
      }
   }

   public final void z() {
      this.s();
      this.p.a("/data/ui/gamesystem.ui");
   }

   public final void A() {
      if (this.o.g(16400)) {
         this.p.a.b(2);
         game.f.B().G();
         if (game.l.B().W != null) {
            game.l.B().W.b(game.f.B().r);
         }

         this.aW();
      } else if (this.o.g(32832)) {
         this.p.a.b(3);
         game.f.B().F();
         if (game.l.B().W != null) {
            game.l.B().W.b(game.f.B().r);
         }

         this.aW();
      } else {
         if (this.o.g(131072)) {
            this.o.a((byte)13);
            this.p.a("/data/ui/help.ui");
         }
      }
   }

   public final void B() {
      this.p.a("/data/ui/petstate.ui", 257, this);
      this.f = 0;
      if (this.q.P.size() > 6) {
         ((c.b)this.p.a.a(0)).a.a(1);
      } else {
         ((c.b)this.p.a.a(0)).a.a(-1);
      }

      this.p.a.a(2).i().a = "Ngân hàng Sủng vật";
      this.p.a.a(75).a(false);
      this.p.a.a(76).a(false);
      this.aX();
   }

   private void aX() {
      ((c.b)this.p.a.a(0)).a.a = this.q.P.size();
      this.v = ((c.b)this.p.a.a(0)).a.e;
      this.h = ((c.b)this.p.a.a(0)).a.f;
      if (this.q.P.size() >= 6) {
         ((c.b)this.p.a.a(0)).a.d = 6;
      } else {
         ((c.b)this.p.a.a(0)).a.d = this.q.P.size();
      }

      if (this.h >= this.q.P.size()) {
         this.h = this.q.P.size() - 1;
         ((c.b)this.p.a.a(0)).a.f = this.h;
      }

      if (this.v > 0 && this.h - this.v < 5) {
         this.v--;
         ((c.b)this.p.a.a(0)).a.e = this.v;
      }

      for (int var1 = 0; var1 < 6; var1++) {
         if (this.v + var1 < this.q.P.size()) {
            int[] var2 = (int[])this.q.P.elementAt(this.v + var1);
            if (var1 == 0) {
               this.p.a.a(14 + var1 * 6).i().a = "" + (this.v + var1 + 1);
            } else {
               this.p.a.a(15 + var1 * 6).i().a = "" + (this.v + var1 + 1);
            }

            this.p.a.a(16 + var1 * 6).i().a = "#P" + var2[6] * 100 / game.i.a(var2[0], var2[1], var2[4], 1);
            this.p.a.a(17 + var1 * 6).i().a = "#P" + game.i.a((short)var2[7], (short)var2[1]);
         } else {
            this.p.a.a(16 + var1 * 6).i().a = "#P0";
            this.p.a.a(17 + var1 * 6).i().a = "#P0";
         }
      }

      int[] var4 = null;
      if (this.q.P.size() > 0) {
         this.p.a.a(64).a(true);
         var4 = (int[])this.q.P.elementAt(this.h);
      } else {
         this.p.a.a(64).a(false);
      }

      if (var4 != null) {
         if (this.p.a.a(48).i().m != null) {
            this.p.a.a(48).i().m.c();
         } else {
            this.p.a.a(48).i().m = new c.g();
            this.p.a.a(48).i().m.a(0);
            this.p.a.a(48).i().m.a = 3;
         }

         this.p.a.a(48).i().m.a(a.b.c.a((byte)0, (short)var4[0], (byte)17), false, (byte)-1);
         this.p.a.a(51).i().a = a.a.c(a.b.c.a((byte)0, (short)var4[0], (byte)0));
         this.p.a.a(52).i().a = a.a.c(365 + a.b.c.a((byte)0, (short)var4[0], (byte)1));
         if (a.b.c.a((byte)0, (short)var4[0], (byte)19) == -1) {
            this.p.a.a(62).i().a = "";
         } else if (a.b.c.c[0][a.b.c.a((byte)0, (short)var4[0], (byte)19)][2] == 1 || a.b.c.c[0][a.b.c.a((byte)0, (short)var4[0], (byte)19)][2] == 2) {
            this.p.a.a(62).i().a = "Có thể tiến hóa";
         } else if (a.b.c.c[0][a.b.c.a((byte)0, (short)var4[0], (byte)19)][2] == 3) {
            this.p.a.a(62).i().a = "Có thể dị hoá";
         }

         this.p.a.a(61).i().a = game.i.y(var4[0]);
         if (this.p.a.a(59).i().m == null) {
            this.p.a.a(59).i().m = new c.g();
            this.p.a.a(59).i().m.a(0);
            this.p.a.a(59).i().m.a = 2;
            this.p.a.a(59).i().m.a(258, false, (byte)-1);
         }

         if (var4[2] != -1) {
            this.p.a.a(59).i().m.a(a.b.c.c[3][var4[2]][1]);
            this.p.a.a(60).i().a = a.a.c(a.b.c.c[3][var4[2]][0]);
         } else {
            this.p.a.a(59).i().m.a(0);
            this.p.a.a(60).i().a = "";
         }

         this.p.a.a(65).i().a = "" + var4[1];
         this.p.a.a(66).i().a = "" + game.i.a(var4[0], var4[1], var4[4], 2);
         this.p.a.a(67).i().a = "" + game.i.a(var4[0], var4[1], var4[4], 3);
         this.p.a.a(68).i().a = "" + game.i.a(var4[0], var4[1], var4[4], 4);
         int var6 = var4[4];
         int var5 = a.b.c.a((byte)0, (short)var4[0], (byte)4) - 1;

         for (int var3 = 0; var3 < 5; var3++) {
            this.p.a.a(74 - var3).a(true);
            this.p.a.a(74 - var3).i().m.a = 3;
            if (var3 > var5) {
               this.p.a.a(74 - var3).a(false);
            } else if (var6 > 0) {
               this.p.a.a(74 - var3).i().m.a((byte)14, (byte)-1);
               var6--;
            } else {
               this.p.a.a(74 - var3).i().m.a((byte)16, (byte)-1);
            }
         }

         if (this.b == 1) {
            this.p.a.a(64).i().a = "Lấy ra";
            return;
         }

         if (this.b == 2) {
            this.p.a.a(64).i().a = "Phóng sinh";
         }
      }
   }

   public final void C() {
      if (this.f == 0 && this.o.g(4100)) {
         this.p.a.b(0);
         this.aX();
      } else if (this.f == 0 && this.o.g(8448)) {
         this.p.a.b(1);
         this.aX();
      }

      if (this.f == 0) {
         if (this.o.g(196640)) {
            if (this.b == 1) {
               if (this.q.B >= 6) {
                  this.p.a("/data/ui/msgwarm.ui", 257, this);
                  this.a("Ba lô Sủng vật đã đủ", "Nhấn nút 5 tiếp tục");
                  this.f = 1;
               } else {
                  if (this.q.P.size() <= 0) {
                     return;
                  }

                  this.q.r(this.h);
                  if (this.q.P.size() <= 0) {
                     this.o.a((byte)16);
                     this.p.a("/data/ui/petstate.ui");
                  } else {
                     this.aX();
                  }
               }
            } else if (this.b == 2) {
               if (this.q.P.size() <= 0) {
                  return;
               }

               int[] var1 = (int[])this.q.P.elementAt(this.h);
               if (a.b.c.a((byte)0, (short)var1[0], (byte)22) == 2) {
                  this.f = 2;
                  this.H();
                  this.a("Thần thú không thể phóng sinh", "Nhấn nút 5 tiếp tục");
               } else {
                  this.f = 1;
                  this.p.a("/data/ui/msgconfirm.ui", 257, this);
                  this.b("Bạn muốn phóng sinh sủng vật này?", "Xác nhận");
               }
            }
         } else if (this.o.g(786432)) {
            this.o.a((byte)16);
            this.p.a("/data/ui/petstate.ui");
         }
      } else if (this.f > 0) {
         if (this.o.g(196640) && this.b == 1 || this.o.g(131072) && this.b == 2 && this.f == 1 || this.o.g(196640) && this.b == 2 && this.f == 2) {
            if (this.b == 1) {
               this.p.a("/data/ui/msgwarm.ui");
               this.f = 0;
            } else if (this.b == 2) {
               if (this.f == 1) {
                  this.p.a("/data/ui/msgconfirm.ui");
                  int[] var2 = (int[])this.q.P.elementAt(this.h);
                  this.q.m(var2[2]);
                  this.q.q(this.h);
                  this.aX();
               } else if (this.f == 2) {
                  this.I();
               }

               this.f = 0;
            }
         } else if (this.o.g(786432)) {
            if (this.b == 1) {
               return;
            }

            this.p.a("/data/ui/msgconfirm.ui");
            this.f = 0;
         }
      }

      this.g = true;
   }

   public final void D() {
      this.aU();
      this.p.a("/data/ui/shop.ui", 257, this);
      this.b = 0;
      this.p.a.a(5).i().a = "Ngân hàng Sủng vật";
      this.p.a.a(6).i().a = "Gởi lại";
      this.p.a.a(7).i().a = "Lấy ra";
      this.p.a.a(9).i().a = "Phóng sinh";
   }

   public final void E() {
      if (this.o.g(4100)) {
         this.p.a.b(0);
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
      } else if (this.o.g(196640)) {
         switch (this.b) {
            case 0:
               this.c = 0;
               this.o.a((byte)7);
               this.p.a("/data/ui/shop.ui");
               return;
            case 1:
               this.o.a((byte)15);
               this.p.a("/data/ui/shop.ui");
               return;
            case 2:
               this.o.a((byte)15);
               this.p.a("/data/ui/shop.ui");
               return;
            case 3:
               game.e.q = true;
               this.p.a("/data/ui/shop.ui");
               this.o.a((byte)0);
         }
      } else {
         if (this.o.g(262144)) {
            game.e.q = true;
            this.p.a("/data/ui/shop.ui");
            this.o.a((byte)0);
         }
      }
   }

   public final void F() {
      this.aU();
      this.p.a("/data/ui/shop.ui", 257, this);
      this.b = 0;
   }

   public final void G() {
      this.o.q();
      if (!a.a.a(this.b, 0) && !this.j() && this.f == 0 && this.o.g(4100) && this.aY()) {
         this.p.a.b(0);
      } else if (!a.a.a(this.b, 0) && !this.j() && this.f == 0 && this.o.g(8448) && this.aY()) {
         this.p.a.b(1);
      } else if (this.aY() && !this.j() && a.a.s() && this.o.g(196640)) {
         if (a.a.p() && !a.a.a(this.b, 0)) {
            return;
         }

         switch (this.b) {
            case 0:
               this.o.r();
               this.o.a((byte)2);
               this.p.a("/data/ui/shop.ui");
               break;
            case 1:
               this.o.a((byte)3);
               this.p.a("/data/ui/shop.ui");
               break;
            case 2:
               if (this.f == 0) {
                  if (game.j.p().B() == -1) {
                     this.f = 6;
                     this.H();
                     this.a("Toàn bộ trạng thái đã đầy, không cần khôi phục", "Nhấn nút 5 tiếp tục");
                  } else if (!a.a.i) {
                     this.f = 3;

                     for (int var1 = 0; var1 < this.q.B; var1++) {
                        this.q.A[var1].J();
                     }

                     this.b("Ba lô sủng vật trạng thái toàn bộ khôi phục");
                  } else {
                     k var2 = this;
                     this.p.a("/data/ui/msgRecover.ui", 257, var2);
                     var2.p.a.a(4).i().a = "Có khôi phục trạng thái ba lô sủng vật không?";
                     var2.p.a.a(5).i().a = "Cần tiền tài: ";
                     var2.p.a.a(6).i().a = "" + game.j.p().B();
                     var2.p.a.a(8).i().a = "" + game.j.p().F();
                     this.p.a("/data/ui/shop.ui");
                     this.f = 1;
                  }
               } else if (this.f == 1) {
                  int var3 = game.j.p().B();
                  if (!game.j.p().u(var3)) {
                     this.f = 2;
                     this.H();
                     this.a("Kim tiền chưa đủ", "Nhấn nút 5 tiếp tục");
                  } else {
                     this.f = 3;
                     game.j.p().s(-var3);

                     for (int var4 = 0; var4 < this.q.B; var4++) {
                        this.q.A[var4].J();
                     }

                     this.b("Ba lô sủng vật trạng thái toàn bộ khôi phục");
                  }

                  this.p.a("/data/ui/msgRecover.ui");
               } else {
                  if (this.f == 2 && a.a.i) {
                     this.o.a((byte)102);
                  }

                  this.f = 0;
                  this.I();
               }
               break;
            case 3:
               game.e.q = true;
               this.p.a("/data/ui/shop.ui");
               this.o.a((byte)0);
         }
      } else if (!this.j() && this.o.g(262144) && a.a.t() && this.aY()) {
         if (this.f == 1) {
            this.p.a("/data/ui/shop.ui", 257, this);
            this.p.a("/data/ui/msgRecover.ui");
            this.b = 0;
            this.f = 0;
         } else if (this.f == 0) {
            game.e.q = true;
            this.p.a("/data/ui/shop.ui");
            this.o.a((byte)0);
         }
      }

      if (this.f == 3 && this.aA()) {
         this.f = 4;
         this.p.a("/data/ui/shop.ui", 257, this);
         this.K();
         this.a("Đang lưu...");
         this.M();
      } else if (this.f == 4 && ((l)this.o).I()) {
         this.a("Lưu thành công");
         this.f = 5;
      } else if (this.f == 5) {
         this.L();
         this.f = 0;
         this.b = 0;
      }

      this.f();
      this.g = true;
   }

   public final void a(int var1, byte var2) {
      this.p.a("/data/ui/shopbuy.ui", 257, this);
      this.b = 0;
      this.f = 0;
      ((c.b)this.p.a.a(0)).a.a = a.b.c.c[var1].length;
      ((c.b)this.p.a.a(0)).a.a(1);
      this.p.a.a(5).i().a = "Mua";
      if (this.o instanceof l) {
         this.p.a.a(57).a(true);
         this.p.a.a(58).a(true);
         this.p.a.a(57).i().a = "Mua sắm";
         this.p.a.a(58).i().a = "Quay lại";
         this.p.a.a(39).a(false);
         this.p.a.a(40).a(false);
      } else if (this.o instanceof game.a) {
         this.p.a.a(57).a(false);
         this.p.a.a(58).a(false);
         this.p.a.a(39).a(true);
         this.p.a.a(40).a(true);
         this.p.a.a(39).i().a = "Mua sắm";
         this.p.a.a(40).i().a = "Quay lại";
      }

      this.b(var1, var2);
   }

   private void b(int var1, byte var2) {
      this.v = ((c.b)this.p.a.a(0)).a.e;
      this.h = ((c.b)this.p.a.a(0)).a.f;

      for (int var3 = 0; var3 < 5; var3++) {
         if (this.p.a.a(var3 + 51).i().m == null) {
            this.p.a.a(var3 + 51).i().m = new c.g();
            this.p.a.a(var3 + 51).i().m.a(0);
            this.p.a.a(var3 + 51).i().m.a = 2;
            this.p.a.a(var3 + 51).i().m.a(258, false, (byte)-1);
         }

         short[] var10001 = a.b.c.c[var1][this.v + var3];
         this.p.a.a(var3 + 51).i().m.a(var10001[1]);
         this.p.a.a(14 + var3 * 5).i().a = a.a.c(a.b.c.c[var1][this.v + var3][0]);
         if (this.o instanceof l) {
            if (this.j == 1 || this.j == 3) {
               this.p.a.a(15 + var3 * 5).i().a = "" + a.b.c.c[var1][this.v + var3][3];
            } else if (this.j == 2) {
               if (a.b.c.c[var1][this.v + var3][4] == 0) {
                  this.p.a.a(15 + var3 * 5).i().a = "" + a.b.c.c[var1][this.v + var3][3] * 3 / 2;
               } else {
                  this.p.a.a(15 + var3 * 5).i().a = "" + a.b.c.c[var1][this.v + var3][3];
               }
            }
         } else if (var2 == 0 && var1 == 4 && this.v + var3 == 0) {
            this.p.a.a(15 + var3 * 5).i().a = "" + a.b.c.c[var1][this.v + var3][3];
         } else {
            this.p.a.a(15 + var3 * 5).i().a = "" + (a.b.c.c[var1][this.v + var3][3] << 1);
         }

         if (a.b.c.c[var1][this.v + var3][4] == 0) {
            this.p.a.a(var3 + 45).i().m.a(84);
         } else if (a.b.c.c[var1][this.v + var3][4] == 1) {
            this.p.a.a(var3 + 45).i().m.a(83);
         } else if (a.b.c.c[var1][this.v + var3][4] == 2) {
            this.p.a.a(var3 + 45).i().m.a(74);
         }
      }

      this.p.a.a(56).i().a = a.a.c(a.b.c.c[var1][this.h][2]);
      this.p.a.a(43).i().a = "" + this.q.G();
      this.p.a.a(44).i().a = "" + this.q.F();
      this.p.a.a(38).b(102 + this.h * 84 / a.b.c.c[var1].length, this.p.a.a());
   }

   public final void a(byte var1, byte var2) {
      this.o.q();
      if (!a.a.a(this.b, 0) && this.f <= 1 && this.o.g(4100) && !this.j()) {
         this.p.a.b(0);
         if (this.f == 0) {
            this.b((int)var1, var2);
         }
      } else if (!a.a.a(this.b, 0) && this.f <= 1 && this.o.g(8448) && !this.j()) {
         this.p.a.b(1);
         if (this.f == 0) {
            this.b((int)var1, var2);
         }
      } else if (this.f == 1 && this.o.g(16400) && this.c > 0 && !this.j()) {
         this.c--;
         if (this.c <= 0) {
            this.c = 99 - this.q.a(this.h, var2);
         }

         this.a(this.c, this.c * a.b.c.c[var1][this.h][3], a.b.c.c[var1][this.h][4], var1);
      } else if (this.f == 1 && this.o.g(32832) && !this.j()) {
         this.c++;
         if (this.c > 99 - this.q.a(this.h, var2)) {
            this.c = 1;
         }

         this.a(this.c, this.c * a.b.c.c[var1][this.h][3], a.b.c.c[var1][this.h][4], var1);
      } else if (a.a.s() && this.o.g(196640) && !this.j()) {
         if (a.a.p() && !a.a.a(this.b, 0)) {
            return;
         }

         if (a.b.c.c[var1][this.h][4] == 2) {
            if (this.f == 0) {
               if (a.a.i) {
                  if (!this.q.a(this.h, 1, (byte)0)) {
                     this.f = 3;
                     this.H();
                     this.a("Đạo cụ đã đủ", "Nhấn nút 5 tiếp tục");
                  } else {
                     this.o.a((byte)101);
                  }
               } else {
                  this.f = 3;
                  this.p.a("/data/ui/msgwarm.ui", 257, this);
                  this.a("Công năng còn chưa mở", "Nhấn nút 5 tiếp tục");
               }
            } else {
               this.f = 0;
               this.p.a("/data/ui/msgwarm.ui");
            }
         } else if (var2 == 2 && this.h < 12) {
            this.c = 1;
            if (this.q.a(this.h, this.c, var2)) {
               if (this.f == 0) {
                  this.r = 0;
                  this.b(var1, var2);
               } else if (this.f > 0) {
                  if (a.a.i) {
                     if (this.f == 4) {
                        this.o.a((byte)104);
                     } else if (this.f == 3) {
                        this.o.a((byte)102);
                     }
                  }

                  this.f = 0;
                  this.p.a("/data/ui/msgwarm.ui");
               }
            } else if (this.f == 0) {
               this.f = 2;
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Đạo cụ này đã đủ", "Nhấn nút 5 tiếp tục");
            } else {
               this.o.r();
               this.f = 0;
               this.p.a("/data/ui/msgwarm.ui");
               this.b((int)var1, var2);
            }
         } else if (this.q.a(this.h, this.c, var2)) {
            if (this.f == 0) {
               this.f = 1;
               this.p.a("/data/ui/msgyn.ui", 257, this);
               this.c = 1;
               this.r = 0;
               this.a(this.c, this.c * a.b.c.c[var1][this.h][3], a.b.c.c[var1][this.h][4], var1);
            } else if (this.f == 1) {
               this.b(var1, var2);
            } else if (this.f == 2) {
               game.l.B().Z.G();
               this.f = 0;
               this.c = 0;
               this.p.a("/data/ui/msgwarm.ui");
               this.b((int)var1, var2);
            } else {
               if (a.a.i) {
                  if (this.f == 4) {
                     this.p.a("/data/ui/msgyn.ui");
                     this.o.a((byte)104);
                  } else if (this.f == 3) {
                     this.p.a("/data/ui/msgyn.ui");
                     this.o.a((byte)102);
                  }
               }

               this.f = 0;
               this.c = 0;
               this.p.a("/data/ui/msgwarm.ui");
            }
         } else if (this.f == 0) {
            this.f = 2;
            this.p.a("/data/ui/msgwarm.ui", 257, this);
            this.a("Đạo cụ này đã đủ", "Nhấn nút 5 tiếp tục");
         } else {
            this.f = 0;
            this.p.a("/data/ui/msgwarm.ui");
         }
      } else if (this.o.g(262144) && !this.j() && a.a.t()) {
         if (this.f == 0) {
            if (this.o instanceof l) {
               if (this.j == 1) {
                  this.o.a((byte)1);
               } else if (this.j == 2) {
                  this.o.a((byte)14);
               } else if (this.j == 3) {
                  this.o.a((byte)27);
               }

               this.p.a("/data/ui/shopbuy.ui");
            } else {
               this.p.a("/data/ui/shopbuy.ui");
               this.o.a((byte)20);
            }
         } else if (this.f == 1) {
            this.f = 0;
            this.c = 0;
            this.p.a("/data/ui/msgyn.ui");
         }
      }

      this.f();
   }

   private void b(byte var1, byte var2) {
      if ((!(this.o instanceof l) || this.j != 1 && this.j != 3 || !this.q.b((int)this.h, (int)(this.c * a.b.c.c[var1][this.h][3]), (int)var1))
         && (
            this.j != 2
               || (a.b.c.c[var1][this.h][4] != 0 || !this.q.b((int)this.h, (int)(this.c * a.b.c.c[var1][this.h][3] * 3 / 2), (int)var1))
                  && (a.b.c.c[var1][this.h][4] == 0 || !this.q.b((int)this.h, (int)(this.c * a.b.c.c[var1][this.h][3]), (int)var1))
         )) {
         if (this.o instanceof game.a && this.q.b((int)this.h, (int)(this.c * a.b.c.c[var1][this.h][3] << 1), (int)var1)) {
            if (this.r == 0) {
               this.q.c(this.h, this.c, var2);
               if (a.b.c.c[var1][this.h][4] == 0) {
                  this.q.s(-this.c * a.b.c.c[var1][this.h][3] << 1);
               } else {
                  this.q.v(-this.c * a.b.c.c[var1][this.h][3] << 1);
               }

               this.p.a("/data/ui/msgwarm.ui", 257, this);
               if (var1 == 3 && this.h == 17) {
                  this.a("Đã thành công mua sắm #2" + a.a.c(a.b.c.c[var1][this.h][0]) + " * " + 5 * this.c, "Nhấn nút 5 tiếp tục");
               } else {
                  this.a("Đã thành công mua sắm #2" + a.a.c(a.b.c.c[var1][this.h][0]) + " * " + this.c, "Nhấn nút 5 tiếp tục");
               }

               this.f = 2;
               this.c = 1;
            } else {
               this.f = 0;
            }

            this.p.a("/data/ui/msgyn.ui");
         } else {
            if (this.r == 0) {
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               if (a.b.c.c[var1][this.h][4] == 0) {
                  this.f = 3;
                  this.a("Kim tiền chưa đủ", "Nhấn nút 5 tiếp tục");
               } else {
                  this.f = 4;
                  this.a("Số lượng Huy hiệu chưa đủ", "Nhấn nút 5 tiếp tục");
               }

               label104:
               if (this.o instanceof l) {
                  int var3;
                  if (this.j != 1 && this.j != 3) {
                     if (this.j != 2) {
                        break label104;
                     }

                     if (a.b.c.c[var1][this.h][4] == 0) {
                        var3 = this.c * a.b.c.c[var1][this.h][3] * 3 / 2;
                     } else {
                        var3 = this.c * a.b.c.c[var1][this.h][3];
                     }
                  } else {
                     var3 = this.c * a.b.c.c[var1][this.h][3];
                  }

                  this.a(new int[]{var1, var2, this.h, a.b.c.c[var1][this.h][4], var3, this.c});
               } else if (this.o instanceof game.a) {
                  int var4 = this.c * a.b.c.c[var1][this.h][3] << 1;
                  this.a(new int[]{var1, var2, this.h, a.b.c.c[var1][this.h][4], var4, this.c});
               }
            } else {
               this.f = 0;
            }

            this.p.a("/data/ui/msgyn.ui");
         }
      } else {
         if (this.r == 0) {
            this.q.c(this.h, this.c, var2);
            if (a.b.c.c[var1][this.h][4] == 0) {
               if (this.j == 1 || this.j == 3) {
                  this.q.s(-this.c * a.b.c.c[var1][this.h][3]);
               } else if (this.j == 2) {
                  this.q.s(-this.c * a.b.c.c[var1][this.h][3] * 3 / 2);
               }
            } else if (this.j == 1 || this.j == 3) {
               this.q.v(-this.c * a.b.c.c[var1][this.h][3]);
            } else if (this.j == 2) {
               this.q.v(-this.c * a.b.c.c[var1][this.h][3]);
            }

            this.p.a("/data/ui/msgwarm.ui", 257, this);
            if (var1 == 3 && this.h == 17) {
               this.a("Đã thành công mua sắm #2" + a.a.c(a.b.c.c[var1][this.h][0]) + " * " + 5 * this.c, "Nhấn nút 5 tiếp tục");
            } else {
               this.a("Đã thành công mua sắm #2" + a.a.c(a.b.c.c[var1][this.h][0]) + " * " + this.c, "Nhấn nút 5 tiếp tục");
            }

            this.f = 2;
            this.c = 1;
         } else {
            this.f = 0;
         }

         this.p.a("/data/ui/msgyn.ui");
      }
   }

   private void a(int[] var1) {
      if (this.B == null) {
         this.B = new Vector();
      } else {
         this.B.removeAllElements();
      }

      this.B.addElement(var1);
   }

   private void a(int var1, int var2, int var3, int var4) {
      if (var4 == 3 && this.h == 17) {
         this.p.a.a(9).i().a = "" + var1 * 5;
      } else {
         this.p.a.a(9).i().a = "" + var1;
      }

      if (this.o instanceof l) {
         if (this.j == 1 || this.j == 3) {
            this.p.a.a(11).i().a = "" + var2;
         } else if (this.j == 2) {
            if (var3 == 0) {
               this.p.a.a(11).i().a = "" + var2 * 3 / 2;
            } else {
               this.p.a.a(11).i().a = "" + var2;
            }
         }
      } else {
         this.p.a.a(11).i().a = "" + (var2 << 1);
      }

      if (var3 == 0) {
         this.p.a.a(12).i().m.a(84);
      } else {
         if (var3 == 1) {
            this.p.a.a(12).i().m.a(83);
         }
      }
   }

   public final void H() {
      this.p.a("/data/ui/msgwarm.ui", 257, this);
   }

   public final void I() {
      this.p.a("/data/ui/msgwarm.ui");
   }

   public final boolean J() {
      return !this.p.b("/data/ui/msgwarm.ui");
   }

   public final void a(String var1, String var2) {
      this.p.a.a(6).i().a = var2;
      this.p.a.a(7).i().a = var1;
   }

   public final void K() {
      this.p.a("/data/ui/msgtip.ui", 257, this);
   }

   public final void L() {
      this.p.a("/data/ui/msgtip.ui");
   }

   private boolean aY() {
      return !this.p.b("/data/ui/msgtip.ui");
   }

   public final void a(String var1) {
      this.p.a.a(2).i().a = var1;
   }

   public final void M() {
      this.p.a.a(3).a(false);
      this.p.a.a(4).a(false);
   }

   public final void N() {
      if (this.f == 0) {
         if (this.o.g(196640)) {
            this.f = 1;
            this.a("Đang lưu...");
            this.M();
            return;
         }

         if (this.o.g(262144)) {
            if (a.a.i) {
               this.b = 5;
            } else {
               this.b = 4;
            }

            this.o.a((byte)6);
            this.p.a("/data/ui/msgtip.ui");
            this.f = 0;
            return;
         }
      } else if (this.f == 1) {
         if (((l)this.o).I()) {
            this.a("Lưu thành công");
            this.f = 2;
            return;
         }
      } else if (this.f == 2) {
         this.p.a("/data/ui/msgtip.ui");
         this.p.a("/data/ui/gamemenu.ui");
         this.o.a((byte)0);
         this.f = 0;
      }
   }

   private void b(String var1, String var2) {
      this.p.a.a(2).i().a = var2;
      this.p.a.a(4).i().a = var1;
   }

   public final void O() {
      this.p.a("/data/ui/shopbuy.ui", 257, this);
      this.b = 0;
      this.f = 0;
      this.p.a.a(5).i().a = "Bán ra";
      this.p.a.a(39).i().a = "";
      this.p.a.a(40).i().a = "";
      this.p.a.a(57).i().a = "Bán đi";
      this.p.a.a(58).i().a = "Quay lại";
      this.q.y();
      this.aZ();
   }

   private void aZ() {
      if (this.q.T.size() > 5) {
         ((c.b)this.p.a.a(0)).a.a(1);
      } else {
         ((c.b)this.p.a.a(0)).a.a(0);
      }

      ((c.b)this.p.a.a(0)).a.a = this.q.T.size();
      this.v = ((c.b)this.p.a.a(0)).a.e;
      this.h = ((c.b)this.p.a.a(0)).a.f;
      if (this.h >= this.q.T.size()) {
         this.h = this.q.T.size() - 1;
         ((c.b)this.p.a.a(0)).a.f = this.h;
      }

      if (this.v > 0 && this.h - this.v < 4) {
         this.v--;
         ((c.b)this.p.a.a(0)).a.e = this.v;
      }

      for (int var1 = 0; var1 < 5; var1++) {
         if (this.v + var1 < this.q.T.size()) {
            int var2 = ((int[])this.q.T.elementAt(this.v + var1))[0];
            if (this.p.a.a(var1 + 51).i().m == null) {
               this.p.a.a(var1 + 51).i().m = new c.g();
               this.p.a.a(var1 + 51).i().m.a(0);
               this.p.a.a(var1 + 51).i().m.a = 2;
               this.p.a.a(var1 + 51).i().m.a(258, false, (byte)-1);
            }

            this.p.a.a(var1 + 51).i().m.a(a.b.c.c[4][var2][1]);
            this.p.a.a(14 + var1 * 5).i().a = a.a.c(a.b.c.c[4][var2][0]);
            this.p.a.a(15 + var1 * 5).i().a = "" + a.b.c.c[4][var2][3] / 2;
            if (a.b.c.c[4][var2][4] == 0) {
               this.p.a.a(var1 + 45).i().m.a(84);
            } else if (a.b.c.c[4][var2][4] == 1) {
               this.p.a.a(var1 + 45).i().m.a(83);
            } else if (a.b.c.c[4][var2][4] == 2) {
               this.p.a.a(var1 + 45).i().m.a(74);
            }
         } else {
            if (this.p.a.a(var1 + 51).i().m != null) {
               this.p.a.a(var1 + 51).i().m.c();
            }

            this.p.a.a(14 + var1 * 5).i().a = "";
            this.p.a.a(15 + var1 * 5).i().a = "";
            this.p.a.a(var1 + 45).i().m.a(86);
         }
      }

      if (this.q.T.size() > 0) {
         this.p.a.a(56).i().a = a.a.c(a.b.c.c[4][((int[])this.q.T.elementAt(this.h))[0]][2]);
      } else {
         this.p.a.a(56).i().a = "";
      }

      if (this.q.T.size() > 0) {
         this.p.a.a(43).i().a = "" + this.q.G();
         this.p.a.a(44).i().a = "" + this.q.F();
         this.p.a.a(38).b(102 + this.h * 84 / this.q.T.size(), this.p.a.a());
      }
   }

   public final void P() {
      if (this.o.g(4100)) {
         this.p.a.b(0);
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
      } else if (this.f == 1 && this.o.g(16400) && this.c > 0) {
         int[] var3 = (int[])this.q.T.elementAt(this.h);
         this.c--;
         if (this.c <= 0) {
            this.c = this.q.a(var3[0], (byte)0);
         }

         this.a(this.c, this.c * a.b.c.c[4][var3[0]][3] / 2, a.b.c.c[4][var3[0]][4], 4);
      } else if (this.f == 1 && this.o.g(32832)) {
         int[] var2 = (int[])this.q.T.elementAt(this.h);
         this.c++;
         if (this.c > this.q.a(var2[0], (byte)0)) {
            this.c = 1;
         }

         this.a(this.c, this.c * a.b.c.c[4][var2[0]][3] / 2, a.b.c.c[4][var2[0]][4], 4);
      } else {
         if (this.o.g(196640) && this.q.T.size() > 0) {
            int[] var1 = (int[])this.q.T.elementAt(this.h);
            if (this.f == 0) {
               this.f = 1;
               this.p.a("/data/ui/msgyn.ui", 257, this);
               this.c = 1;
               this.r = 0;
               this.a(this.c, this.c * a.b.c.c[4][var1[0]][3] / 2, a.b.c.c[4][var1[0]][4], 4);
               return;
            }

            if (this.r != 0) {
               this.p.a("/data/ui/msgyn.ui");
               this.f = 0;
               return;
            }

            this.q.d(var1[0], this.c, (byte)0);
            this.q.s(this.c * a.b.c.c[4][var1[0]][3] / 2);
         } else {
            if (!this.o.g(262144)) {
               return;
            }

            if (this.f == 0) {
               this.o.a((byte)1);
               this.p.a("/data/ui/shopbuy.ui");
               this.b = 1;
               ((c.b)this.p.a.a(0)).a.f = this.b;
               return;
            }
         }

         this.f = 0;
         this.p.a("/data/ui/msgyn.ui");
         this.q.y();
         this.aZ();
      }
   }

   public final void Q() {
      this.p.a("/data/ui/record.ui", 257, this);
      this.p.a("/data/ui/gamemenu.ui");
      this.p.a.a(14).i().a = "" + (this.q.B + this.q.P.size());
      this.p.a.a(17).i().a = "" + this.q.G;
      this.p.a.a(20).i().a = "" + this.q.I;
      this.p.a.a(26).i().a = "" + this.q.H;
      int var1 = 0;

      for (byte var2 = 0; var2 < this.q.C.length; var2++) {
         if (this.q.b(var2, (byte)0) == 2) {
            var1++;
         }
      }

      this.p.a.a(29).i().a = "" + var1;
      long var4 = game.f.B().n + game.f.B().o - game.f.B().p;
      c.i var10000 = this.p.a.a(31).i();
      game.l.B();
      var10000.a = game.l.a(var4)[1];
      ((c.b)this.p.a.a(0)).b.f = this.c;
      this.b = 0;
      this.f = 0;
      this.g = true;
   }

   public final void R() {
      if (this.o.g(16400)) {
         this.p.a.b(2);
         this.g = true;
      } else if (this.o.g(32832)) {
         this.p.a.b(3);
         this.g = true;
      } else if (this.o.g(196640)) {
         if (this.f == 0) {
            switch (this.c) {
               case 0:
                  if (game.j.p().l(5)) {
                     this.o.a((byte)11);
                  } else {
                     this.H();
                     this.a("Không đạt được sủng vật sách tranh đạo cụ", "Nhấn nút 5 tiếp tục");
                     this.f = 1;
                  }
                  break;
               case 1:
                  this.o.a((byte)12);
            }
         } else {
            this.f = 0;
            this.I();
         }
      } else if (this.o.g(262144) && this.f == 0) {
         if (a.a.i) {
            this.b = 3;
         } else {
            this.b = 2;
         }

         this.o.a((byte)6);
         this.p.a("/data/ui/record.ui");
      }

      this.g = true;
   }

   public final void S() {
      this.p.a("/data/ui/petmap.ui", 257, this);
      this.p.a("/data/ui/record.ui");
      this.b = 0;
      this.c = 0;
      this.f = 0;
      ((c.b)this.p.a.a(0)).a.a(1);
      this.bb();
      this.g = true;
   }

   private void ba() {
      ((c.b)this.p.a.a(0)).a.e = 0;
      ((c.b)this.p.a.a(0)).a.f = 0;
   }

   private void bb() {
      ((c.b)this.p.a.a(0)).a.a = this.q.Y[this.b];
      this.v = ((c.b)this.p.a.a(0)).a.e;
      this.h = ((c.b)this.p.a.a(0)).a.f;
      int var1 = a.b.c.c[0][this.q.X[this.b] + this.h][17];
      if (this.q.a((byte)this.b, this.h + this.q.X[this.b]) > 0) {
         this.p.a.a(21).a(true);
         if (this.p.a.a(21).i().m != null) {
            this.p.a.a(21).i().m.c();
         } else {
            this.p.a.a(21).i().m = new c.g();
            this.p.a.a(21).i().m.a(0);
            this.p.a.a(21).i().m.a = 3;
         }

         this.p.a.a(21).i().m.a(var1, false, (byte)-1);
         this.p.a.a(21).i().m.a((byte)1);
      } else {
         this.p.a.a(21).a(false);
      }

      var1 = 0;

      for (int var2 = 0; var2 < this.q.Y[this.b]; var2++) {
         if (this.q.a((byte)this.b, this.q.X[this.b] + var2) == 2) {
            var1++;
         }
      }

      for (int var4 = 0; var4 < 5; var4++) {
         if (this.p.a.a(var4 + 44).i().m == null) {
            this.p.a.a(var4 + 44).i().m = new c.g();
            this.p.a.a(var4 + 44).i().m.a(102);
            this.p.a.a(var4 + 44).i().m.a = 2;
            this.p.a.a(var4 + 44).i().m.a(257, false, (byte)-1);
         }

         if (this.q.a((byte)this.b, var4 + this.v + this.q.X[this.b]) == 2) {
            this.p.a.a(var4 + 44).i().m.a(101);
         } else {
            this.p.a.a(var4 + 44).i().m.a(102);
         }

         this.p.a.a(24 + (var4 << 2) + 3).i().a = a.a.c(a.b.c.c[0][this.q.X[this.b] + var4 + this.v][0]);
      }

      this.p.a.a(20).i().a = a.a.c(365 + this.b) + var1 + "/" + this.q.Y[this.b];
      this.p.a.a(23).b(99 + (this.h << 6) / this.q.Y[this.b], this.p.a.a());
   }

   public final void T() {
      if (this.o.g(4100)) {
         this.p.a.b(0);
         this.bb();
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
         this.bb();
      } else if (this.o.g(16400)) {
         this.p.a.b(2);
         this.ba();
         this.bb();
      } else if (this.o.g(32832)) {
         this.p.a.b(3);
         this.ba();
         this.bb();
      } else if (!this.o.g(196640) && this.o.g(786432)) {
         if (this.o.b == 8) {
            this.o.a((byte)8);
         } else {
            this.c = 0;
            this.o.a((byte)9);
         }

         this.p.a("/data/ui/petmap.ui");
      }

      this.g = true;
   }

   public final void U() {
      this.p.a("/data/ui/task.ui", 257, this);
      this.p.a("/data/ui/gamemenu.ui");
      ((c.b)this.p.a.a(0)).b.f = this.b;
      this.c = 0;
      this.r = 0;
      this.bc();
      this.bd();
   }

   private void bc() {
      switch (this.b) {
         case 0:
            if (game.e.G >= game.e.E.length / 2 - 1) {
               int var10001 = game.e.E.length;
               ((c.b)this.p.a.a(0)).a.a = var10001 / 2;
               ((c.b)this.p.a.a(0)).a.f = game.e.E.length / 2 - 1;
            } else {
               ((c.b)this.p.a.a(0)).a.a = game.e.G + 1;
               ((c.b)this.p.a.a(0)).a.f = game.e.G;
            }

            this.p.a.a(36).i().a = "";
            this.h = game.e.G;
            this.v = game.e.G - 4;
            if (this.h <= 0) {
               this.h = 0;
            }

            if (this.v <= 0) {
               this.v = 0;
            }

            ((c.b)this.p.a.a(0)).a.e = this.v;
            this.p.a.a(37).i().a = "Đầu mối chính hoàn thành độ: ";
            if (game.e.G >= game.e.E.length / 2) {
               this.p.a.a(38).i().a = game.e.E[game.e.E.length - 1];
            } else {
               this.p.a.a(38).i().a = game.e.E[game.e.E.length / 2 + game.e.G];
            }

            int var3 = game.e.G * 1000 / (game.e.E.length / 2);
            if (!a.a.i) {
               int var5;
               if ((var5 = var3 % 10) == 0) {
                  var5 = 1;
               }

               this.p.a.a(38).i().a = var3 / 50 + "." + var5 + "%";
            } else {
               this.p.a.a(38).i().a = var3 / 10 + "." + var3 % 10 + "%";
            }

            if (game.e.G > 4) {
               ((c.b)this.p.a.a(0)).a.a(1);
            } else {
               ((c.b)this.p.a.a(0)).a.a(0);
            }

            this.p.a.a(8).i().g = 11290624;
            break;
         case 1:
            ((c.b)this.p.a.a(0)).a.a = game.e.H;
            ((c.b)this.p.a.a(0)).a.f = 0;
            ((c.b)this.p.a.a(0)).a.e = 0;
            this.p.a.a(36).i().a = "";
            this.p.a.a(37).i().a = "Chi nhánh hoàn thành độ: ";
            int var1 = 0;

            for (int var2 = 0; var2 < game.e.F.length; var2++) {
               if (game.e.F[var2][1] == 3) {
                  var1++;
               }
            }

            int var4 = var1 * 1000 / (game.e.D.length / 2);
            this.p.a.a(38).i().a = var4 / 10 + "." + var4 % 10 + "%";
            if (game.e.H > 5) {
               ((c.b)this.p.a.a(0)).a.a(1);
            } else {
               ((c.b)this.p.a.a(0)).a.a(0);
            }

            this.p.a.a(9).i().g = 11290624;
      }

      this.bd();
   }

   private void bd() {
      this.v = ((c.b)this.p.a.a(0)).a.e;
      this.h = ((c.b)this.p.a.a(0)).a.f;

      for (int var1 = 0; var1 < 5; var1++) {
         if (this.b == 0) {
            if (game.e.G > 0) {
               if (this.v + var1 < game.e.G) {
                  this.p.a.a(10 + var1 * 5 + 2).i().a = "" + (var1 + this.v + 1);
                  this.p.a.a(10 + var1 * 5 + 3).i().a = game.e.E[this.v + var1];
                  this.p.a.a(10 + var1 * 5 + 4).i().a = "Hoàn thành";
               } else if (this.v + var1 == game.e.G && this.v + var1 <= game.e.E.length / 2 - 1) {
                  this.p.a.a(10 + var1 * 5 + 2).i().a = "" + (var1 + this.v + 1);
                  this.p.a.a(10 + var1 * 5 + 3).i().a = game.e.E[this.v + var1];
                  this.p.a.a(10 + var1 * 5 + 4).i().a = "";
               } else {
                  this.p.a.a(10 + var1 * 5 + 2).i().a = "";
                  this.p.a.a(10 + var1 * 5 + 3).i().a = "";
                  this.p.a.a(10 + var1 * 5 + 4).i().a = "";
                  this.p.a.a(36).i().a = "";
               }
            } else {
               this.p.a.a(12).i().a = "1";
               this.p.a.a(13).i().a = game.e.E[0];
               this.p.a.a(14).i().a = "";
            }
         } else if (this.b == 1) {
            if (this.v + var1 < game.e.H) {
               this.p.a.a(10 + var1 * 5 + 2).i().a = "" + (var1 + this.v + 1);
               this.p.a.a(10 + var1 * 5 + 3).i().a = game.e.D[game.e.F[this.v + var1][0]];
               if (game.e.F[this.v + var1][1] == 3) {
                  this.p.a.a(10 + var1 * 5 + 4).i().a = "Hoàn thành";
               } else {
                  this.p.a.a(10 + var1 * 5 + 4).i().a = "";
               }
            } else {
               this.p.a.a(10 + var1 * 5 + 2).i().a = "";
               this.p.a.a(10 + var1 * 5 + 3).i().a = "";
               this.p.a.a(10 + var1 * 5 + 4).i().a = "";
            }
         }
      }

      switch (this.b) {
         case 0:
            this.p.a.a(36).i().a = game.e.E[game.e.E.length / 2 + this.h];
            break;
         case 1:
            if (game.e.H > 0) {
               this.p.a.a(36).i().a = game.e.D[game.e.D.length / 2 + game.e.F[this.h][0]];
            }
      }

      if (((c.b)this.p.a.a(0)).a.a > 0) {
         this.p.a.a(40).b(104 + (this.h << 6) / ((c.b)this.p.a.a(0)).a.a, this.p.a.a());
      }
   }

   public final void V() {
      if (this.o.g(4100)) {
         this.p.a.b(0);
         this.bd();
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
         this.bd();
      } else if (this.o.g(16400)) {
         this.p.a.b(2);
         this.bc();
      } else if (this.o.g(32832)) {
         this.p.a.b(3);
         this.bc();
      } else if (this.o.g(983072)) {
         if (a.a.i) {
            this.b = 4;
         } else {
            this.b = 3;
         }

         this.p.a("/data/ui/task.ui");
         if (this.o.b == 0) {
            this.b = 0;
            this.o.a((byte)0);
         } else if (this.o.b == 33) {
            this.o.a((byte)33);
         } else {
            this.o.a((byte)6);
         }
      } else {
         if (this.o.g(10)) {
            this.p.a("/data/ui/task.ui");
            this.o.a((byte)0);
         }
      }
   }

   public final void W() {
      this.p.a("/data/ui/badge.ui", 257, this);
      this.p.a("/data/ui/record.ui");
      this.b = 0;
      this.f = 0;

      for (int var1 = 0; var1 < 8; var1++) {
         if (this.q.C[var1][0] != 0) {
            this.p.a.a(var1 + 25).i().m.a(var1 + 46);
         }
      }

      this.be();
   }

   private void be() {
      this.p.a.a(13).i().a = a.a.c(a.b.c.c[2][this.b][0]);
      this.p.a.a(14).i().a = a.a.c(a.b.c.c[2][this.b][2 + this.q.b((byte)this.b, (byte)1)]);
      if (this.q.b((byte)this.b, (byte)0) == 0) {
         this.p.a.a(16).i().a = "Chưa đạt";
      } else {
         this.p.a.a(16).i().a = "Đã đạt được";
         this.q.b((byte)this.b, (byte)1);
         this.p.a.a(33).i().a = "";
      }
   }

   public final void X() {
      if (this.o.g(4100)) {
         this.p.a.b(0);
         this.be();
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
         this.be();
      } else if (this.o.g(16400)) {
         this.p.a.b(2);
         this.be();
      } else if (this.o.g(32832)) {
         this.p.a.b(3);
         this.be();
      } else {
         if (this.o.g(786432)) {
            if (this.o.b == 8) {
               this.o.a((byte)8);
            } else {
               this.c = 1;
               this.o.a((byte)9);
            }

            this.p.a("/data/ui/badge.ui");
         }
      }
   }

   public final void a(int var1) {
      this.p.a("/data/ui/smsTip.ui", 257, this);
      if (this.p.a.a(6).i().m == null) {
         this.p.a.a(6).i().m = new c.g();
         this.p.a.a(6).i().m.a = 2;
         this.p.a.a(6).i().m.a(-1);
         this.p.a.a(6).i().m.a(257, false, (byte)-1);
         this.p.a.a(6).i().m.a(var1 + 46);
      }

      this.p.a.a(7).i().a = a.a.c(var1 + 187) + ":" + a.a.c(var1 + 195);
      this.p.a.a(8).i().a = a.a.c(377);
   }

   public final void Y() {
      this.p.a("/data/ui/smsTip.ui");
   }

   public final void Z() {
      this.b = 0;
      this.f(this.c);
   }

   private void f(int var1) {
      int var3 = var1;
      i[] var2 = this.q.A;
      k var5 = this;
      this.p.a("/data/ui/petstate.ui", 257, var5);
      var5.g(var3);
      var5.f = 0;
      if (var5.o instanceof l) {
         for (int var4 = 0; var4 < 6; var4++) {
            if (var2[var4] != null) {
               var5.p.a.a(16 + var4 * 6).i().a = "#P" + var2[var4].M();
               var5.p.a.a(17 + var4 * 6).i().a = "#P" + var2[var4].P();
            } else {
               var5.p.a.a(16 + var4 * 6).i().a = "#P0";
               var5.p.a.a(17 + var4 * 6).i().a = "#P0";
            }
         }

         if (var5.o.b == 16) {
            var5.p.a.a(64).i().a = "Gởi lại";
         }

         var5.p.a.a(75).a(false);
         var5.p.a.a(76).a(false);
      } else if (var5.o instanceof game.a) {
         for (int var6 = 0; var6 < 6; var6++) {
            if (var6 < ((game.a)var5.o).p.length && var2[((game.a)var5.o).p[var6]] != null) {
               var5.p.a.a(16 + var6 * 6).i().a = "#P" + var2[((game.a)var5.o).p[var6]].M();
               var5.p.a.a(17 + var6 * 6).i().a = "#P" + var2[((game.a)var5.o).p[var6]].P();
            } else {
               var5.p.a.a(16 + var6 * 6).i().a = "#P0";
               var5.p.a.a(17 + var6 * 6).i().a = "#P0";
            }
         }

         var5.p.a.a(63).a(false);
         var5.p.a.a(64).a(false);
         if (var5.o.b == 4) {
            var5.p.a.a(75).i().a = "Sử dụng";
         } else if (var5.o.a == 5) {
            var5.p.a.a(75).i().a = "Xuất chiến";
         }
      }

      ((c.b)var5.p.a.a(0)).a.a = var5.q.B;
      ((c.b)var5.p.a.a(0)).a.d = var5.q.B;
      ((c.b)var5.p.a.a(0)).a.f = var3;
      var5.g = true;
   }

   private void a(i[] var1, int var2) {
      if (var1[var2] != null) {
         if (this.p.a.a(48).i().m != null) {
            this.p.a.a(48).i().m.c();
         } else {
            this.p.a.a(48).i().m = new c.g();
            this.p.a.a(48).i().m.a(0);
            this.p.a.a(48).i().m.a = 3;
         }

         this.p.a.a(48).i().m.a(var1[var2].D, false, (byte)-1);
         this.p.a.a(51).i().a = a.a.c(var1[var2].j((byte)0));
         this.p.a.a(52).i().a = a.a.c(365 + var1[var2].j((byte)1));
         if (var1[var2].j((byte)19) == -1) {
            this.p.a.a(62).i().a = "";
         } else if (a.b.c.c[0][var1[var2].j((byte)19)][2] == 1 || a.b.c.c[0][var1[var2].j((byte)19)][2] == 2) {
            this.p.a.a(62).i().a = "Có thể tiến hóa";
         } else if (a.b.c.c[0][var1[var2].j((byte)19)][2] == 3) {
            this.p.a.a(62).i().a = "Có thể dị hoá";
         }

         this.p.a.a(61).i().a = var1[var2].U();
         if (this.o instanceof game.a) {
            this.p.a.a(64).i().a = "Xuất chiến";
         } else if (this.o instanceof l) {
            this.p.a.a(64).i().a = "Xác nhận";
         }

         if (this.p.a.a(59).i().m == null) {
            this.p.a.a(59).i().m = new c.g();
            this.p.a.a(59).i().m.a(0);
            this.p.a.a(59).i().m.a = 2;
            this.p.a.a(59).i().m.a(258, false, (byte)-1);
         }

         i var10000 = var1[var2];
         byte var4 = 5;
         if (var10000.d[var4] != -1) {
            short[][] var10001 = a.b.c.c[3];
            i var10002 = var1[var2];
            var4 = 5;
            short[] var12 = var10001[var10002.d[var4]];
            this.p.a.a(59).i().m.a(var12[1]);
            c.i var10 = this.p.a.a(60).i();
            var10001 = a.b.c.c[3];
            var10002 = var1[var2];
            var4 = 5;
            var10.a = a.a.c(var10001[var10002.d[var4]][0]);
         } else {
            this.p.a.a(59).i().m.a(0);
            this.p.a.a(60).i().a = "";
         }

         this.p.a.a(65).i().a = "" + var1[var2].t();
         this.p.a.a(66).i().a = "" + var1[var2].a((byte)2);
         this.p.a.a(67).i().a = "" + var1[var2].a((byte)3);
         this.p.a.a(68).i().a = "" + var1[var2].a((byte)4);
         var10000 = var1[var2];
         var4 = 0;
         int var3 = var10000.e[var4];
         int var5 = a.b.c.a((byte)0, (short)var1[var2].r(), (byte)4) - 1;

         for (int var6 = 0; var6 < 5; var6++) {
            this.p.a.a(74 - var6).a(true);
            this.p.a.a(74 - var6).i().m.a(257, false, (byte)-1);
            this.p.a.a(74 - var6).i().m.a = 3;
            if (var6 > var5) {
               this.p.a.a(74 - var6).a(false);
            } else if (var3 > 0) {
               this.p.a.a(74 - var6).i().m.a((byte)14, (byte)-1);
               var3--;
            } else {
               this.p.a.a(74 - var6).i().m.a((byte)16, (byte)-1);
            }
         }
      }
   }

   private void g(int var1) {
      if (this.o instanceof l) {
         this.a(this.q.A, var1);
      } else {
         if (this.o instanceof game.a) {
            this.a(this.q.A, ((game.a)this.o).p[var1]);
         }
      }
   }

   public final void aa() {
      if (this.f == 0) {
         if (!a.a.a(this.b, 0) && !this.j() && this.o.g(4100)) {
            this.p.a.b(0);
         } else if (!a.a.a(this.b, 0) && !this.j() && this.o.g(8448)) {
            this.p.a.b(1);
         } else if (a.a.s() && !this.j() && this.o.g(196640)) {
            if (a.a.p() && !a.a.a(this.b, 0)) {
               return;
            }

            if (this.o instanceof game.a) {
               int var1;
               if ((var1 = ((game.a)this.o).l(this.b)) == 0) {
                  this.f = 2;
                  this.p.a("/data/ui/msgwarm.ui", 257, this);
                  this.a("Sủng vật này không thể tham chiến", "Nhấn nút 5 tiếp tục");
                  this.p.a("/data/ui/petsetting.ui");
               } else if (var1 == 1) {
                  this.f = 2;
                  this.p.a("/data/ui/msgwarm.ui", 257, this);
                  this.a("Sủng vật này đã đặt ở vị trí chiến đấu", "Nhấn nút 5 tiếp tục");
                  this.p.a("/data/ui/petsetting.ui");
               } else if (var1 == -1) {
                  ((game.a)this.o).e(((game.a)this.o).q, 0);
                  this.a = 0;
                  this.o.a((byte)15);
                  this.p.a("/data/ui/petsetting.ui");
                  this.p.a("/data/ui/petstate.ui");
               }
            } else if (this.o instanceof l) {
               if (this.o.b == 16) {
                  if (this.q.A()) {
                     if (this.q.i(this.b)) {
                        this.q.m(this.q.A[this.b].b((byte)5));
                        this.q.A[this.b].a((byte)5, (short)-1);
                        this.q.b(this.q.A[this.b].Q());
                        this.q.n(this.b);
                        if (this.b >= this.q.B) {
                           this.b--;
                        }

                        this.f(this.b);
                     } else {
                        this.f = 1;
                        this.p.a("/data/ui/msgwarm.ui", 257, this);
                        this.a("Ba lô phải lưu ít nhất 1 sủng vật", "Nhấn nút 5 tiếp tục");
                     }
                  } else {
                     this.f = 1;
                     this.p.a("/data/ui/msgwarm.ui", 257, this);
                     this.a("Ngân hàng đã đầy, không thể gởi lại", "Nhấn nút 5 tiếp tục");
                  }
               } else if (this.o.b == 6 || this.o.b == 0) {
                  this.c = 0;
                  this.o.r();
                  this.f = 1;
                  this.p.a("/data/ui/petsetting.ui", 257, this);
                  ((c.b)this.p.a.a(0)).a.f = this.c;
                  if (this.q.A[this.b].S() == 2) {
                     this.p.a.a(9).i().a = "Dị hoá";
                     ((c.b)this.p.a.a(0)).a.a = 6;
                     ((c.b)this.p.a.a(0)).a.d = 6;
                  } else if (this.q.A[this.b].S() == 1) {
                     this.p.a.a(9).i().a = "Tiến hóa";
                     ((c.b)this.p.a.a(0)).a.a = 6;
                     ((c.b)this.p.a.a(0)).a.d = 6;
                  } else {
                     this.p.a.a(9).i().a = "";
                     ((c.b)this.p.a.a(0)).a.a = 5;
                     ((c.b)this.p.a.a(0)).a.d = 5;
                  }
               } else if (this.o.b == 27) {
                  if ((this.d != 1 || this.q.A[this.b].S() != 1) && (this.d != 2 || this.q.A[this.b].S() != 2)) {
                     this.f = 4;
                     this.H();
                     if (this.d == 1) {
                        this.a("Sủng vật này không thể tiến hóa", "Nhấn nút 5 tiếp tục");
                     } else if (this.d == 2) {
                        this.a("Sủng vật này không thể dị hoá", "Nhấn nút 5 tiếp tục");
                     } else {
                        this.a("Không thể vào hóa cùng dị hoá", "Nhấn nút 5 tiếp tục");
                     }
                  } else {
                     this.bl();
                  }
               }
            }
         } else if (game.e.t() && !this.j() && this.o.g(262144)) {
            if (this.o instanceof l) {
               if (this.o.b == 16) {
                  this.o.a((byte)16);
               } else if (this.o.b == 6) {
                  if (a.a.i) {
                     this.b = 1;
                  } else {
                     this.b = 0;
                  }

                  this.o.a((byte)6);
               } else if (this.o.b == 27) {
                  this.o.a((byte)27);
               } else if (this.o.b == 0) {
                  this.o.a((byte)23);
               }

               this.p.a("/data/ui/petstate.ui");
            } else if (this.o instanceof game.a) {
               if (((game.a)this.o).b == 7 || ((game.a)this.o).b == 13) {
                  return;
               }

               this.p.a("/data/ui/petstate.ui");
               game.a.B().u = false;
               this.a = 0;
               this.o.a((byte)20);
            }
         }
      } else if (this.f == 1) {
         if (!a.a.a(this.c, 0) && !this.j() && this.o.g(4100)) {
            this.p.a.b(0);
         } else if (!a.a.a(this.c, 0) && !this.j() && this.o.g(8448)) {
            this.p.a.b(1);
         } else if (a.a.s() && !this.j() && this.o.g(196640)) {
            if (a.a.p() && !a.a.a(this.c, 0)) {
               return;
            }

            if (this.o.b == 16) {
               this.o.a((byte)16);
               this.p.a("/data/ui/msgwarm.ui");
               this.p.a("/data/ui/petstate.ui");
               this.f = 0;
            } else if (this.o.b == 6 || this.o.b == 0) {
               switch (this.c) {
                  case 0:
                     this.bh();
                     break;
                  case 1:
                     if (!this.q.A[this.b].T()) {
                        this.f = 2;
                        this.p.a("/data/ui/msgwarm.ui", 257, this);
                        this.a("Sủng vật này không thể tham chiến", "Nhấn nút 5 tiếp tục");
                        this.p.a("/data/ui/petsetting.ui");
                        this.b = 0;
                     } else if (this.b == 0) {
                        this.f = 2;
                        this.b = 0;
                        this.p.a("/data/ui/msgwarm.ui", 257, this);
                        this.a("Sủng vật này đã xuất chiến", "Nhấn nút 5 tiếp tục");
                        this.p.a("/data/ui/petsetting.ui");
                     } else {
                        this.q.p(this.b);
                        this.f = 0;
                        this.b = 0;
                        this.f(this.b);
                        this.p.a("/data/ui/petsetting.ui");
                        ((c.b)this.p.a.a(0)).a.f = 0;
                        ((c.b)this.p.a.a(0)).a.e = 0;
                     }
                     break;
                  case 2:
                     this.o.r();
                     this.bf();
                     break;
                  case 3:
                     if (a.b.c.a((byte)0, (short)this.q.A[this.b].r(), (byte)22) == 2) {
                        this.f = 3;
                        this.H();
                        this.p.a("/data/ui/petsetting.ui");
                        this.a("Thần thú không thể phóng sinh", "Nhấn nút 5 tiếp tục");
                     } else {
                        this.f = 2;
                        this.p.a("/data/ui/msgconfirm.ui", 257, this);
                        this.p.a("/data/ui/petsetting.ui");
                        this.b("Bạn muốn phóng sinh sủng vật này?", "Xác nhận");
                     }
                     break;
                  case 4:
                     this.bj();
                     break;
                  case 5:
                     this.o.r();
                     this.bl();
               }
            }
         } else if (game.e.t() && !this.j() && this.o.g(262144)) {
            if (this.o.b == 16) {
               return;
            }

            this.f = 0;
            this.p.a("/data/ui/petsetting.ui");
         }
      } else if (this.f >= 2) {
         if (this.o instanceof game.a) {
            if (this.o.g(196640)) {
               this.f = 0;
               this.p.a("/data/ui/msgwarm.ui");
            }
         } else if (this.o.b == 6 || this.o.b == 0) {
            switch (this.c) {
               case 0:
                  this.bn();
                  break;
               case 1:
                  if (this.o.g(196640)) {
                     this.f = 0;
                     this.p.a("/data/ui/msgwarm.ui");
                  }
                  break;
               case 2:
                  this.bm();
                  break;
               case 3:
                  if (this.o.g(131072) && this.f == 2 || this.o.g(196640) && this.f == 3) {
                     if (this.f == 2) {
                        if (this.q.i(this.b)) {
                           this.q.m(this.q.A[this.b].b((byte)5));
                           this.q.A[this.b].a((byte)5, (short)-1);
                           this.q.n(this.b);
                           if (this.b >= this.q.B) {
                              this.b--;
                           }

                           this.f(this.b);
                           ((l)this.o).Z.G();
                           this.p.a("/data/ui/msgconfirm.ui");
                           this.f = 0;
                        } else {
                           this.f = 3;
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Ba lô phải lưu ít nhất 1 sủng vật", "Nhấn nút 5 tiếp tục");
                           this.p.a("/data/ui/msgconfirm.ui");
                        }
                     } else {
                        this.f = 0;
                        this.p.a("/data/ui/msgwarm.ui");
                     }
                  } else if (this.o.g(786432) && this.f <= 2) {
                     this.f = 0;
                     this.p.a("/data/ui/msgconfirm.ui");
                  }
                  break;
               case 4:
                  this.bo();
                  break;
               case 5:
                  this.bp();
            }
         } else if (this.f <= 3) {
            this.bp();
         } else if (this.f == 4 && this.o.g(196640)) {
            this.f = 0;
            this.p.a("/data/ui/msgwarm.ui");
         }
      }

      this.g = true;
      this.g();
   }

   private void bf() {
      this.f = 2;
      this.r = 0;
      this.p.a("/data/ui/choice.ui", 257, this);
      this.p.a("/data/ui/petsetting.ui");
      this.p.a("/data/ui/petstate.ui");
      this.p.a.a(8).i().a = "Vật phẩm trang sức";
      this.p.a.a(9).i().a = "Trạng thái";
      if (this.o instanceof l) {
         this.p.a.a(5).a(false);
         this.p.a.a(6).a(false);
         this.p.a.a(59).a(true);
         this.p.a.a(60).a(true);
         this.p.a.a(59).i().a = "Mang theo";
      } else {
         this.p.a.a(5).a(true);
         this.p.a.a(6).a(true);
         this.p.a.a(59).a(false);
         this.p.a.a(60).a(false);
         this.p.a.a(5).i().a = "Mang theo";
      }

      this.bg();
      this.g = true;
   }

   private void bg() {
      if (this.q.M.size() > 5) {
         ((c.b)this.p.a.a(0)).a.a(1);
      } else {
         ((c.b)this.p.a.a(0)).a.a(0);
      }

      ((c.b)this.p.a.a(0)).a.a = this.q.M.size();
      this.v = ((c.b)this.p.a.a(0)).a.e;
      this.h = ((c.b)this.p.a.a(0)).a.f;
      if (this.h >= this.q.M.size()) {
         this.h = this.q.M.size() - 1;
         ((c.b)this.p.a.a(0)).a.f = this.h;
      }

      if (this.v > 0 && this.h - this.v < 4) {
         this.v--;
         ((c.b)this.p.a.a(0)).a.e = this.v;
      }

      if (this.q.M.size() > 0) {
         i var10000 = this.q.A[this.b];
         byte var4 = 5;
         if (var10000.d[var4] == ((int[])this.q.M.elementAt(this.h))[0]) {
            if (this.o instanceof l) {
               this.p.a.a(59).i().a = "Dỡ xuống";
            } else {
               this.p.a.a(5).i().a = "Dỡ xuống";
            }
         } else if (this.o instanceof l) {
            this.p.a.a(59).i().a = "Mang theo";
         } else {
            this.p.a.a(5).i().a = "Mang theo";
         }

         for (int var1 = 0; var1 < 5; var1++) {
            if (this.v + var1 < this.q.M.size()) {
               int[] var2 = (int[])this.q.M.elementAt(this.v + var1);
               if (this.p.a.a(var1 + 54).i().m == null) {
                  this.p.a.a(var1 + 54).i().m = new c.g();
                  this.p.a.a(var1 + 54).i().m.a(0);
                  this.p.a.a(var1 + 54).i().m.a = 2;
                  this.p.a.a(var1 + 54).i().m.a(258, false, (byte)-1);
               }

               this.p.a.a(var1 + 54).i().m.a(a.b.c.c[3][var2[0]][1]);
               this.p.a.a(13 + var1 * 5).i().a = a.a.c(a.b.c.c[3][var2[0]][0]);
               var10000 = game.j.p().A[this.b];
               var4 = 5;
               if (var10000.d[var4] == var2[0]) {
                  this.p.a.a(14 + var1 * 5).i().a = "Đã mang theo";
               } else if (var2[1] == 1) {
                  this.p.a.a(14 + var1 * 5).i().a = "Bị mang theo";
               } else {
                  this.p.a.a(14 + var1 * 5).i().a = "";
               }
            } else {
               if (this.p.a.a(var1 + 54).i().m != null) {
                  this.p.a.a(var1 + 54).i().m.c();
               }

               this.p.a.a(13 + var1 * 5).i().a = "";
               this.p.a.a(14 + var1 * 5).i().a = "";
            }
         }

         if (this.q.M.size() > 0) {
            this.p.a.a(53).i().a = a.a.c(a.b.c.c[3][((int[])this.q.M.elementAt(this.h))[0]][2]);
         } else {
            this.p.a.a(53).i().a = "";
         }

         if (this.q.M.size() > 0) {
            this.p.a.a(51).b(98 + this.h * 62 / this.q.M.size(), this.p.a.a());
         } else {
            this.p.a.a(51).b(98, this.p.a.a());
         }
      }
   }

   private void bh() {
      this.f = 2;
      this.r = 0;
      this.p.a("/data/ui/choice.ui", 257, this);
      this.p.a("/data/ui/petsetting.ui");
      this.p.a("/data/ui/petstate.ui");
      this.p.a.a(8).i().a = "Đạo cụ";
      this.p.a.a(9).i().a = "Số lượng";
      if (this.o instanceof l) {
         this.p.a.a(5).a(false);
         this.p.a.a(6).a(false);
         this.p.a.a(59).a(true);
         this.p.a.a(60).a(true);
         this.p.a.a(59).i().a = "Sử dụng";
      } else {
         this.p.a.a(5).a(true);
         this.p.a.a(6).a(true);
         this.p.a.a(59).a(false);
         this.p.a.a(60).a(false);
         this.p.a.a(5).i().a = "Sử dụng";
      }

      this.bi();
      this.g = true;
   }

   private void bi() {
      if (this.q.K.size() > 5) {
         ((c.b)this.p.a.a(0)).a.a(1);
      } else {
         ((c.b)this.p.a.a(0)).a.a(0);
      }

      ((c.b)this.p.a.a(0)).a.a = this.q.K.size();
      this.v = ((c.b)this.p.a.a(0)).a.e;
      this.h = ((c.b)this.p.a.a(0)).a.f;
      if (this.h >= this.q.K.size()) {
         this.h = this.q.K.size() - 1;
         ((c.b)this.p.a.a(0)).a.f = this.h;
      }

      if (this.v > 0 && this.h - this.v < 4) {
         this.v--;
         ((c.b)this.p.a.a(0)).a.e = this.v;
      }

      for (int var1 = 0; var1 < 5; var1++) {
         if (this.v + var1 < this.q.K.size()) {
            int[] var2 = (int[])this.q.K.elementAt(this.v + var1);
            if (this.p.a.a(var1 + 54).i().m == null) {
               this.p.a.a(var1 + 54).i().m = new c.g();
               this.p.a.a(var1 + 54).i().m.a(0);
               this.p.a.a(var1 + 54).i().m.a = 2;
               this.p.a.a(var1 + 54).i().m.a(258, false, (byte)-1);
            }

            this.p.a.a(var1 + 54).i().m.a(a.b.c.c[4][var2[0]][1]);
            this.p.a.a(13 + var1 * 5).i().a = a.a.c(a.b.c.c[4][var2[0]][0]);
            this.p.a.a(14 + var1 * 5).i().a = "" + var2[1];
         } else {
            if (this.p.a.a(var1 + 54).i().m != null) {
               this.p.a.a(var1 + 54).i().m.c();
            }

            this.p.a.a(13 + var1 * 5).i().a = "";
            this.p.a.a(14 + var1 * 5).i().a = "";
         }
      }

      if (this.q.K.size() > 0) {
         this.p.a.a(53).i().a = a.a.c(a.b.c.c[4][((int[])this.q.K.elementAt(this.h))[0]][2]);
      } else {
         this.p.a.a(53).i().a = "";
      }

      if (this.q.K.size() > 0) {
         this.p.a.a(51).b(98 + this.h * 80 / this.q.K.size(), this.p.a.a());
      } else {
         this.p.a.a(51).b(98, this.p.a.a());
      }
   }

   private void bj() {
      this.f = 2;
      this.r = 0;
      this.p.a("/data/ui/skill.ui", 257, this);
      this.p.a("/data/ui/petsetting.ui");
      this.p.a("/data/ui/petstate.ui");
      this.p.a.a(12).i().a = a.a.c(this.q.A[this.b].j((byte)0));
      this.p.a.a(14).i().a = "" + this.q.A[this.b].t();
      if (this.p.a.a(16).i().m != null) {
         this.p.a.a(16).i().m.c();
      } else {
         this.p.a.a(16).i().m = new c.g();
         this.p.a.a(16).i().m.a(0);
         this.p.a.a(16).i().m.a = 3;
      }

      this.p.a.a(16).i().m.a(this.q.A[this.b].D, false, (byte)-1);
      int var1 = this.q.A[this.b].F();

      for (int var2 = 0; var2 < var1; var2++) {
         this.p.a.a(var2 + 18).i().a = a.a.c(a.b.c.c[1][this.q.A[this.b].t(var2)][1]);
      }

      this.bk();
      this.g = true;
   }

   private void bk() {
      if (this.q.A[this.b].t(this.r) != -1) {
         String[] var1 = new String[]{"Nhất định", "Nhất định"};
         this.p.a.a(9).i().a = a.a.a(a.b.c.c[1][this.q.A[this.b].t(this.r)][2], var1);
      } else {
         this.p.a.a(9).i().a = "";
      }
   }

   private void bl() {
      this.f = 2;
      this.r = 0;
      this.p.a("/data/ui/evolve.ui", 257, this);
      this.p.a("/data/ui/petsetting.ui");
      this.p.a("/data/ui/petstate.ui");
      if (this.p.a.a(10).i().m == null) {
         this.p.a.a(10).i().m = new c.g();
         this.p.a.a(10).i().m.a(0);
         this.p.a.a(10).i().m.a = 3;
      }

      this.p.a.a(10).i().m.a(this.q.A[this.b].D, false, (byte)-1);
      short var1 = (short)(a.b.c.a((byte)0, (byte)this.q.A[this.b].r(), (byte)20) + 12);
      short var2 = a.b.c.a((byte)0, (byte)this.q.A[this.b].r(), (byte)21);
      this.p.a.a(38).i().a = a.a.c(a.b.c.a((byte)0, (byte)this.q.A[this.b].r(), (byte)0));
      this.p.a.a(40).i().a = "" + this.q.A[this.b].t();
      this.p.a.a(45).i().a = a.a.c(a.b.c.a((byte)3, var1, (byte)0));
      this.p.a.a(46).i().a = this.q.a(var1, (byte)2) + "/" + var2;
      var1 = a.b.c.a((byte)0, (byte)this.q.A[this.b].r(), (byte)19);
      i var7;
      (var7 = new i()).a(var1, (byte)this.q.A[this.b].t(), (short)-1, (byte)-1, (short)-1, (byte)-1);

      for (int var6 = 0; var6 < 4; var6++) {
         c.i var10000 = this.p.a.a(var6 + 19).i();
         StringBuffer var10001 = new StringBuffer();
         i var10002 = this.q.A[this.b];
         byte var4 = (byte)(var6 + 1);
         var10000.a = var10001.append(var10002.d[var4]).toString();
         var10000 = this.p.a.a(var6 + 31).i();
         var10001 = new StringBuffer();
         var4 = (byte)(var6 + 1);
         var10000.a = var10001.append(var7.d[var4]).toString();
      }

      this.g = true;
   }

   private void bm() {
      if (!a.a.a(this.b, 0) && !this.j() && this.f == 2 && this.o.g(4100)) {
         this.p.a.b(0);
         this.bg();
      } else if (!a.a.a(this.b, 0) && !this.j() && this.f == 2 && this.o.g(8448)) {
         this.p.a.b(1);
         this.bg();
      } else if (a.a.s() && !this.j() && this.o.g(196640) && this.q.M.size() > 0) {
         if (!a.a.p() || a.a.a(this.b, 0)) {
            if (this.f == 2) {
               int[] var1 = (int[])this.q.M.elementAt(this.h);
               i var10000 = this.q.A[this.b];
               byte var3 = 5;
               if (var10000.d[var3] == var1[0]) {
                  i var10001 = this.q.A[this.b];
                  var3 = 5;
                  this.q.m(var10001.d[var3]);
                  var10000 = this.q.A[this.b];
                  byte var4 = -1;
                  var3 = 5;
                  var10000.d[var3] = var4;
                  this.bg();
                  this.H();
                  this.a("Thành công dỡ xuống", "Nhấn nút 5 tiếp tục");
               } else {
                  this.q.f(var1[0], this.b);
                  this.bg();
                  this.H();
                  this.a("Thành công mang theo", "Nhấn nút 5 tiếp tục");
               }

               this.f = 3;
            } else {
               this.f = 2;
               this.o.r();
               this.f(this.b);
               this.I();
               this.p.a("/data/ui/choice.ui");
            }
         }
      } else {
         if (game.e.t() && !this.j() && this.f == 2 && this.o.g(262144)) {
            this.f(this.b);
            this.p.a("/data/ui/choice.ui");
         }
      }
   }

   private void bn() {
      if (this.f == 2 && this.o.g(4100)) {
         this.p.a.b(0);
      } else if (this.f == 2 && this.o.g(8448)) {
         this.p.a.b(1);
      } else {
         if (this.o.g(196640)) {
            if (this.q.K.size() <= 0) {
               return;
            }

            if (this.f == 2) {
               this.f = 3;
               int[] var1;
               switch ((var1 = (int[])this.q.K.elementAt(this.r))[0]) {
                  case 13:
                  case 14:
                     this.p.a("/data/ui/msgwarm.ui", 257, this);
                     this.a("Đạo cụ này không thể sử dụng", "Nhấn nút 5 tiếp tục");
                     return;
                  default:
                     switch (this.q.A[this.b].x(var1[0])) {
                        case 0:
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Sủng vật này đã tử vong, không thể sử dụng", "Nhấn nút 5 tiếp tục");
                           return;
                        case 1:
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Sủng vật này không có, không thể sử dụng", "Nhấn nút 5 tiếp tục");
                           return;
                        case 2:
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Máu đầy, không cần sử dụng", "Nhấn nút 5 tiếp tục");
                           return;
                        case 3:
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Kỹ năng giá trị đã đầy, không cần sử dụng", "Nhấn nút 5 tiếp tục");
                           return;
                        case 4:
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Trên người đều bị lợi hiệu quả", "Nhấn nút 5 tiếp tục");
                           return;
                        case 5:
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Trong hưng phấn, không thể dùng", "Nhấn nút 5 tiếp tục");
                           return;
                        case 6:
                        default:
                           this.q.A[this.b].w(var1[0]);
                           this.f(this.b);
                           this.f = 4;
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Thành công sử dụng đạo cụ", "Nhấn nút 5 tiếp tục");
                           this.p.a("/data/ui/choice.ui");
                           return;
                        case 7:
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Máu và tinh khí đều đã đầy, không cần sử dụng", "Nhấn nút 5 tiếp tục");
                           return;
                        case 8:
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Sủng vật đã chết, không thể sử dụng", "Nhấn nút 5 tiếp tục");
                           return;
                     }
               }
            }

            if (this.f == 3) {
               this.f = 2;
               this.p.a("/data/ui/msgwarm.ui");
               return;
            }

            if (this.f == 4) {
               this.f = 0;
               this.p.a("/data/ui/msgwarm.ui");
               return;
            }
         } else if (this.f == 2 && this.o.g(262144)) {
            this.f(this.b);
            this.p.a("/data/ui/choice.ui");
         }
      }
   }

   private void bo() {
      if (this.o.g(4100)) {
         this.p.a.b(0);
         this.bk();
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
         this.bk();
      } else if (this.o.g(16400)) {
         this.p.a.b(2);
         this.bk();
      } else if (this.o.g(32832)) {
         this.p.a.b(3);
         this.bk();
      } else {
         if (this.o.g(262144)) {
            this.f(this.b);
            this.p.a("/data/ui/skill.ui");
         }
      }
   }

   private void bp() {
      if (game.l.x != null) {
         if (!game.l.x.j()) {
            short var9 = a.b.c.a((byte)0, (byte)this.q.A[this.b].r(), (byte)19);
            String var11 = a.a.c(a.b.c.a((byte)0, var9, (byte)0));
            k var10 = this;
            short var13 = a.b.c.a((byte)0, (byte)var10.q.A[var10.b].r(), (byte)19);
            short var15 = a.b.c.a((byte)0, var13, (byte)17);
            a.b.c.a((byte)0, (byte)var10.q.A[var10.b].r(), (byte)21);
            var10.p.a.a(10).a(true);
            var10.p.a.a(10).i().m.a(var15, false, (byte)-1);
            var10.p.a.a(38).i().a = a.a.c(a.b.c.a((byte)0, var13, (byte)0));
            i var16 = new i();
            short var5 = a.b.c.a((byte)0, var13, (byte)3);
            int var6 = -1;
            i var10000 = var10.q.A[var10.b];
            byte var8 = 0;
            if (var10000.d[var8] >= var5) {
               var10000 = var10.q.A[var10.b];
               var8 = 0;
               var6 = (byte)var10000.d[var8];
            }

            int var10002 = var10.q.A[var10.b].t();
            i var10003 = var10.q.A[var10.b];
            var8 = 5;
            short var25 = var10003.d[var8];
            i var10004 = var10.q.A[var10.b];
            var8 = 6;
            var16.a(var13, var10002, var25, (byte)var10004.e[var8], var6, (byte)-1);
            var8 = 1;
            var16.a(var16.d[var8], var10.q.A[var10.b].A(), var10.q.A[var10.b].F);
            var16.b(var10.q.A[var10.b].R());
            var10.q.a((byte)var10.q.A[var10.b].j((byte)1), var13, (byte)2);
            var10.q.A[var10.b].a(var16.Q());
            var5 = (short)(a.b.c.a((byte)0, (byte)var10.q.A[var10.b].r(), (byte)20) + 12);
            var15 = a.b.c.a((byte)0, (byte)var10.q.A[var10.b].r(), (byte)21);
            var13 = a.b.c.a((byte)0, (byte)var10.q.A[var10.b].r(), (byte)19);
            var6 = var10.q.a(var5, (byte)2);
            if (var13 == -1) {
               var10.p.a.a(42).i().a = "";
               var10.p.a.a(45).i().a = "";
               var10.p.a.a(46).i().a = "";
            } else {
               var10.p.a.a(45).i().a = a.a.c(a.b.c.a((byte)3, var5, (byte)0));
               var10.p.a.a(46).i().a = var6 + "/" + var15;
            }

            if (this.q.A[this.b].S() == 2) {
               this.f = 3;
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Dị hoá thành #2" + var11, "Nhấn nút 5 tiếp tục");
            } else {
               this.f = 3;
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Tiến hóa thành #2" + var11, "Nhấn nút 5 tiếp tục");
            }

            game.l.x = null;
         }
      } else {
         if (a.a.s() && !this.j() && this.o.g(196640)) {
            if (this.f == 2) {
               short var1 = (short)(a.b.c.a((byte)0, (byte)this.q.A[this.b].r(), (byte)20) + 12);
               short var2 = a.b.c.a((byte)0, (byte)this.q.A[this.b].r(), (byte)21);
               short var3;
               if ((var3 = a.b.c.a((byte)0, (byte)this.q.A[this.b].r(), (byte)19)) == -1) {
                  this.f = 3;
                  this.H();
                  this.a("Không thể lại tiến hóa hoặc dị hoá", "Nhấn nút 5 tiếp tục");
                  return;
               }

               short var4 = a.b.c.a((byte)0, var3, (byte)17);
               if (this.q.A[this.b].t() >= game.i.u[a.b.c.a((byte)0, var3, (byte)2) - 1]) {
                  if (this.q.a(var1, (byte)2) >= var2) {
                     this.p.a.a(10).a(false);
                     game.l.x = new a.a.b();
                     short[] var12 = new short[]{0, 0, 10, 116, 164, this.q.A[this.b].D, 0, 0, var4, 0, 0};
                     game.l.x.a(var12);
                     game.l.x.d(true);
                     game.l.x.a();
                     this.q.d(var1, var2, (byte)2);
                     return;
                  }

                  this.f = 3;
                  this.p.a("/data/ui/msgwarm.ui", 257, this);
                  if (this.q.A[this.b].S() == 2) {
                     this.a("Tài liệu chưa đủ, không thể dị hoá", "Nhấn nút 5 tiếp tục");
                     return;
                  }

                  this.a("Tài liệu chưa đủ, không thể tiến hóa", "Nhấn nút 5 tiếp tục");
                  return;
               }

               this.f = 3;
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Còn chưa tới" + game.i.u[a.b.c.a((byte)0, var3, (byte)2) - 1] + " cấp, không thể vào hóa", "Nhấn nút 5 tiếp tục");
               return;
            }

            if (this.f == 3) {
               if (this.o.b == 6 || this.o.b == 0) {
                  this.f = 2;
                  this.p.a("/data/ui/msgwarm.ui");
                  this.o.r();
                  return;
               }

               if (this.o.b == 27) {
                  this.f(this.b);
                  this.f = 0;
                  this.c = 0;
                  this.p.a("/data/ui/msgwarm.ui");
                  this.p.a("/data/ui/evolve.ui");
                  return;
               }
            }
         } else if (this.f < 3 && this.o.g(262144) && !this.j() && a.a.t()) {
            this.f = 0;
            this.f(this.b);
            this.p.a("/data/ui/evolve.ui");
         }
      }
   }

   public final void ab() {
      this.p.a("/data/ui/bag.ui", 257, this);
      this.b = 0;
      this.bq();
      this.p.a.b(5);
      this.p.a.a(14).i().a = "Vật phẩm";
      this.b = 0;
   }

   private void bq() {
      ((c.b)this.p.a.a(8 + this.b * 39)).a.e = 0;
      ((c.b)this.p.a.a(8 + this.b * 39)).a.f = 0;
      this.br();
   }

   private void br() {
      switch (this.b) {
         case 0:
            this.bs();
            break;
         case 1:
            k var4 = this;
            if (this.q.M.size() > 5) {
               ((c.b)var4.p.a.a(47)).a.a(1);
            } else {
               ((c.b)var4.p.a.a(47)).a.a(0);
            }

            ((c.b)var4.p.a.a(47)).a.a = var4.q.M.size();
            var4.v = ((c.b)var4.p.a.a(47)).a.e;
            var4.h = ((c.b)var4.p.a.a(47)).a.f;
            var4.p.a.a(7).a(false);

            for (int var2 = 0; var2 < 5; var2++) {
               if (var4.v + var2 < var4.q.M.size()) {
                  int[] var3 = (int[])var4.q.M.elementAt(var4.v + var2);
                  if (var4.p.a.a(59 + var2 * 5).i().m == null) {
                     var4.p.a.a(59 + var2 * 5).i().m = new c.g();
                     var4.p.a.a(59 + var2 * 5).i().m.a(0);
                     var4.p.a.a(59 + var2 * 5).i().m.a = 2;
                     var4.p.a.a(59 + var2 * 5).i().m.a(258, false, (byte)-1);
                  }

                  if (var4.p.a.a(59 + var2 * 5).i().i == null) {
                     var4.p.a.a(59 + var2 * 5).i().i = new c.g();
                     var4.p.a.a(59 + var2 * 5).i().i.a(0);
                     var4.p.a.a(59 + var2 * 5).i().i.a = 2;
                     var4.p.a.a(59 + var2 * 5).i().i.a(258, false, (byte)-1);
                  }

                  var4.p.a.a(59 + var2 * 5).i().m.a(a.b.c.c[3][var3[0]][1]);
                  var4.p.a.a(59 + var2 * 5).i().i.a(a.b.c.c[3][var3[0]][1]);
                  var4.p.a.a(60 + var2 * 5).i().a = a.a.c(a.b.c.c[3][var3[0]][0]);
                  if (var3[1] == 1) {
                     var4.p.a.a(61 + var2 * 5).i().a = "Đã mang theo";
                  } else {
                     var4.p.a.a(61 + var2 * 5).i().a = "";
                  }
               } else {
                  if (var4.p.a.a(59 + var2 * 5).i().m != null) {
                     var4.p.a.a(59 + var2 * 5).i().m.c();
                  }

                  var4.p.a.a(60 + var2 * 5).i().a = "";
                  var4.p.a.a(61 + var2 * 5).i().a = "";
               }
            }

            if (var4.q.M.size() > 0) {
               var4.p.a.a(85).i().a = a.a.c(a.b.c.c[3][((int[])var4.q.M.elementAt(var4.h))[0]][2]);
            } else {
               var4.p.a.a(85).i().a = "";
            }

            if (var4.q.M.size() > 0) {
               var4.p.a.a(84).b(127 + var4.h * 72 / var4.q.M.size(), var4.p.a.a());
            } else {
               var4.p.a.a(84).b(127, var4.p.a.a());
            }
            break;
         case 2:
            this.bt();
            break;
         case 3:
            this.bu();
            if (this.h < 0 || this.q.O.size() <= 0) {
               return;
            }

            int[] var1 = (int[])this.q.O.elementAt(this.h);
            this.p.a.a(164).a(false);
            this.p.a.a(165).a(false);
            switch (var1[0]) {
               case 0:
                  if (this.q.l(var1[0])) {
                     this.p.a.a(7).a(true);
                     this.p.a.a(7).i().a = "Ấp trứng";
                     this.p.a.a(164).a(true);
                     this.p.a.a(165).a(true);
                     if (this.q.J == 0) {
                        this.p.a.a(164).i().a = "#P" + game.l.A * 100 / 10;
                        this.p.a.a(165).i().a = game.l.A + "/10";
                     } else {
                        this.p.a.a(164).i().a = "#P" + game.l.A * 100 / 30;
                        this.p.a.a(165).i().a = game.l.A + "/30";
                     }
                  } else {
                     this.p.a.a(7).a(false);
                  }
                  break;
               case 1:
               case 2:
               case 3:
               case 4:
                  this.p.a.a(7).a(false);
                  break;
               case 5:
               case 6:
               case 10:
                  this.p.a.a(7).i().a = "Mở ra";
                  break;
               case 7:
               case 8:
               case 9:
                  this.p.a.a(7).i().a = "Sử dụng";
            }
      }

      this.g = true;
   }

   private void bs() {
      int var1;
      if ((var1 = this.q.L.size() + this.q.K.size()) > 5) {
         ((c.b)this.p.a.a(8)).a.a(1);
      } else {
         ((c.b)this.p.a.a(8)).a.a(0);
      }

      ((c.b)this.p.a.a(8)).a.a = var1;
      this.v = ((c.b)this.p.a.a(8)).a.e;
      this.h = ((c.b)this.p.a.a(8)).a.f;
      this.p.a.a(7).a(true);
      this.p.a.a(7).i().a = "Sử dụng";

      for (int var2 = 0; var2 < 5; var2++) {
         if (this.v + var2 < var1) {
            int[] var3;
            if (this.v + var2 < this.q.L.size()) {
               var3 = (int[])this.q.L.elementAt(this.v + var2);
            } else {
               var3 = (int[])this.q.K.elementAt(this.v + var2 - this.q.L.size());
            }

            if (this.p.a.a(18 + var2 * 5).i().m == null) {
               this.p.a.a(18 + var2 * 5).i().m = new c.g();
               this.p.a.a(18 + var2 * 5).i().m.a(0);
               this.p.a.a(18 + var2 * 5).i().m.a = 2;
               this.p.a.a(18 + var2 * 5).i().m.a(258, false, (byte)-1);
            }

            if (this.p.a.a(18 + var2 * 5).i().i == null) {
               this.p.a.a(18 + var2 * 5).i().i = new c.g();
               this.p.a.a(18 + var2 * 5).i().i.a(0);
               this.p.a.a(18 + var2 * 5).i().i.a = 2;
               this.p.a.a(18 + var2 * 5).i().i.a(258, false, (byte)-1);
            }

            this.p.a.a(18 + var2 * 5).i().m.a(a.b.c.c[4][var3[0]][1]);
            this.p.a.a(18 + var2 * 5).i().i.a(a.b.c.c[4][var3[0]][1]);
            this.p.a.a(19 + var2 * 5).i().a = a.a.c(a.b.c.c[4][var3[0]][0]);
            this.p.a.a(20 + var2 * 5).i().a = "" + var3[1];
         } else {
            if (this.p.a.a(18 + var2 * 5).i().m != null) {
               this.p.a.a(18 + var2 * 5).i().m.c();
            }

            this.p.a.a(19 + var2 * 5).i().a = "";
            this.p.a.a(20 + var2 * 5).i().a = "";
         }
      }

      if (var1 > 0) {
         if (this.h < this.q.L.size()) {
            this.p.a.a(46).i().a = a.a.c(a.b.c.c[4][((int[])this.q.L.elementAt(this.h))[0]][2]);
         } else {
            this.p.a.a(46).i().a = a.a.c(a.b.c.c[4][((int[])this.q.K.elementAt(this.h - this.q.L.size()))[0]][2]);
         }
      } else {
         this.p.a.a(46).i().a = "";
      }

      if (var1 > 0) {
         this.p.a.a(43).b(127 + this.h * 72 / var1, this.p.a.a());
      } else {
         this.p.a.a(43).b(127, this.p.a.a());
      }
   }

   private void bt() {
      if (this.q.N.size() > 5) {
         ((c.b)this.p.a.a(86)).a.a(1);
      } else {
         ((c.b)this.p.a.a(86)).a.a(0);
      }

      ((c.b)this.p.a.a(86)).a.a = this.q.N.size();
      this.v = ((c.b)this.p.a.a(86)).a.e;
      this.h = ((c.b)this.p.a.a(86)).a.f;
      this.p.a.a(7).a(false);

      for (int var1 = 0; var1 < 5; var1++) {
         if (this.v + var1 < this.q.N.size()) {
            int[] var2 = (int[])this.q.N.elementAt(this.v + var1);
            if (this.p.a.a(98 + var1 * 5).i().m == null) {
               this.p.a.a(98 + var1 * 5).i().m = new c.g();
               this.p.a.a(98 + var1 * 5).i().m.a(0);
               this.p.a.a(98 + var1 * 5).i().m.a = 2;
               this.p.a.a(98 + var1 * 5).i().m.a(258, false, (byte)-1);
            }

            if (this.p.a.a(98 + var1 * 5).i().i == null) {
               this.p.a.a(98 + var1 * 5).i().i = new c.g();
               this.p.a.a(98 + var1 * 5).i().i.a(0);
               this.p.a.a(98 + var1 * 5).i().i.a = 2;
               this.p.a.a(98 + var1 * 5).i().i.a(258, false, (byte)-1);
            }

            this.p.a.a(98 + var1 * 5).i().m.a(a.b.c.c[3][var2[0]][1]);
            this.p.a.a(98 + var1 * 5).i().i.a(a.b.c.c[3][var2[0]][1]);
            if (var2[0] == 17) {
               this.p.a.a(99 + var1 * 5).i().a = "Chìa khóa vàng";
            } else {
               this.p.a.a(99 + var1 * 5).i().a = a.a.c(a.b.c.c[3][var2[0]][0]);
            }

            this.p.a.a(100 + var1 * 5).i().a = "" + var2[1];
         } else {
            if (this.p.a.a(98 + var1 * 5).i().m != null) {
               this.p.a.a(98 + var1 * 5).i().m.c();
            }

            this.p.a.a(99 + var1 * 5).i().a = "";
            this.p.a.a(100 + var1 * 5).i().a = "";
         }
      }

      if (this.q.N.size() > 0) {
         this.p.a.a(124).i().a = a.a.c(a.b.c.c[3][((int[])this.q.N.elementAt(this.h))[0]][2]);
      } else {
         this.p.a.a(124).i().a = "";
      }

      if (this.q.N.size() > 0) {
         this.p.a.a(123).b(127 + this.h * 72 / this.q.N.size(), this.p.a.a());
      } else {
         this.p.a.a(123).b(127, this.p.a.a());
      }
   }

   private void bu() {
      if (this.q.O.size() > 5) {
         ((c.b)this.p.a.a(125)).a.a(1);
      } else {
         ((c.b)this.p.a.a(125)).a.a(0);
      }

      ((c.b)this.p.a.a(125)).a.a = this.q.O.size();
      this.v = ((c.b)this.p.a.a(125)).a.e;
      this.h = ((c.b)this.p.a.a(125)).a.f;

      for (int var1 = 0; var1 < 5; var1++) {
         if (this.v + var1 < this.q.O.size()) {
            int[] var2 = (int[])this.q.O.elementAt(this.v + var1);
            if (this.p.a.a(137 + var1 * 5).i().m == null) {
               this.p.a.a(137 + var1 * 5).i().m = new c.g();
               this.p.a.a(137 + var1 * 5).i().m.a(0);
               this.p.a.a(137 + var1 * 5).i().m.a = 2;
               this.p.a.a(137 + var1 * 5).i().m.a(258, false, (byte)-1);
            }

            if (this.p.a.a(137 + var1 * 5).i().i == null) {
               this.p.a.a(137 + var1 * 5).i().i = new c.g();
               this.p.a.a(137 + var1 * 5).i().i.a(0);
               this.p.a.a(137 + var1 * 5).i().i.a = 2;
               this.p.a.a(137 + var1 * 5).i().i.a(258, false, (byte)-1);
            }

            this.p.a.a(137 + var1 * 5).i().m.a(a.b.c.c[5][var2[0]][1]);
            this.p.a.a(137 + var1 * 5).i().i.a(a.b.c.c[5][var2[0]][1]);
            this.p.a.a(138 + var1 * 5).i().a = a.a.c(a.b.c.c[5][var2[0]][0]);
            switch (var2[0]) {
               case 0:
                  if (this.q.l(var2[0])) {
                     this.p.a.a(163).i().a = a.a.c(a.b.c.c[5][var2[0]][2]);
                     if (game.l.B().O()) {
                        this.p.a.a(139 + var1 * 5).i().a = "Hoàn thành";
                     } else {
                        this.p.a.a(139 + var1 * 5).i().a = "1 cái";
                     }
                  } else {
                     this.p.a.a(163).i().a = a.a.c(634);
                     this.p.a.a(139 + var1 * 5).i().a = "0 cái";
                  }
                  break;
               default:
                  this.p.a.a(139 + var1 * 5).i().a = "";
            }
         } else {
            if (this.p.a.a(137 + var1 * 5).i().m != null) {
               this.p.a.a(137 + var1 * 5).i().m.c();
            }

            this.p.a.a(138 + var1 * 5).i().a = "";
            this.p.a.a(139 + var1 * 5).i().a = "";
         }
      }

      if (this.q.O.size() > 0) {
         int var3;
         if ((var3 = ((int[])this.q.O.elementAt(this.h))[0]) != 0) {
            this.p.a.a(163).i().a = a.a.c(a.b.c.c[5][var3][2]);
            this.p.a.a(7).a(true);
         }

         if (var3 == 0) {
            if (((int[])this.q.O.elementAt(this.h))[1] == 1) {
               this.p.a.a(7).i().a = "Đóng cửa";
            } else {
               this.p.a.a(7).i().a = "Mở ra";
            }
         } else if (var3 <= 0 && var3 > 4) {
            if (var3 == 10) {
               this.p.a.a(7).i().a = "Gia tốc";
            } else {
               this.p.a.a(7).i().a = "Sử dụng";
            }
         } else if (this.q.u == var3 - 1) {
            this.p.a.a(7).i().a = "Triệu hồi";
         } else {
            this.p.a.a(7).i().a = "Triệu hoán";
         }
      } else {
         this.p.a.a(163).i().a = "";
         this.p.a.a(7).a(false);
      }

      if (this.q.O.size() > 0) {
         this.p.a.a(162).b(127 + this.h * 72 / this.q.O.size(), this.p.a.a());
      } else {
         this.p.a.a(162).b(127, this.p.a.a());
      }
   }

   public final void ac() {
      if (this.f == 0 && this.o.g(4100)) {
         this.p.a.b(0);
         this.g(this.c);
      } else if (this.f == 0 && this.o.g(8448)) {
         this.p.a.b(1);
         this.g(this.c);
      } else if (this.o.g(196640)) {
         this.bx();
      } else {
         if (this.f == 0 && this.o.g(262144)) {
            this.o.a((byte)8);
            this.p.a("/data/ui/petstate.ui");
         }
      }
   }

   public final void ad() {
      if (this.o.g(4100)) {
         this.p.a.b(0);
         this.g(this.b);
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
         this.g(this.b);
      } else if (this.o.g(196640)) {
         this.q.f(this.s, this.b);
         this.o.a((byte)8);
      } else {
         if (this.o.g(262144)) {
            this.o.a((byte)8);
            this.p.a("/data/ui/petstate.ui");
         }
      }
   }

   public final void ae() {
      if (this.o.g(4100)) {
         this.p.a.b(0);
         this.g(this.b);
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
         this.g(this.b);
      } else {
         if (this.o.g(196640)) {
            if (this.f == 0) {
               if (this.q.A[this.b].t() < 50) {
                  this.p.a("/data/ui/msgwarm.ui", 257, this);
                  this.a("Chỉ có thể cho 50 cấp sủng vật sử dụng", "Nhấn nút 5 tiếp tục");
                  this.f = 2;
                  return;
               }

               if (this.q.e(this.s, this.b)) {
                  this.p.a("/data/ui/msgwarm.ui", 257, this);
                  this.a("Sử dụng thành công", "Nhấn nút 5 tiếp tục");
                  this.f = 1;
                  return;
               }
            } else {
               if (this.f == 1) {
                  this.f = 0;
                  this.o.a((byte)8);
                  this.p.a("/data/ui/msgwarm.ui");
                  this.p.a("/data/ui/petstate.ui");
                  return;
               }

               if (this.f == 2) {
                  this.f = 0;
                  this.p.a("/data/ui/msgwarm.ui");
                  return;
               }
            }
         } else if (this.o.g(262144) && this.f == 0) {
            this.o.a((byte)8);
            this.p.a("/data/ui/petstate.ui");
         }
      }
   }

   public final void af() {
      this.o.q();
      if (this.f == 0 && this.o.g(16400) && !this.j() && !a.a.a(this.b, 1)) {
         this.p.a.b(7);
         this.p.a.b(2);
         this.p.a.b(5);
         this.bq();
         this.o.r();
      } else if (this.f == 0 && this.o.g(32832) && !this.j() && !a.a.a(this.b, 1)) {
         this.p.a.b(7);
         this.p.a.b(3);
         this.p.a.b(5);
         this.bq();
         this.o.r();
      } else if (this.f == 0 && this.o.g(4100) && !this.j() && !a.a.a(this.h, 0)) {
         this.p.a.b(0);
      } else if (this.f == 0 && this.o.g(8448) && !this.j() && !a.a.a(this.h, 0)) {
         this.p.a.b(1);
      } else if (this.o.g(196640) && !this.j() && a.a.s()) {
         if (this.f == 0) {
            if (a.a.p() && !a.a.a(this.h, 0)) {
               return;
            }

            label208:
            switch (this.b) {
               case 0:
                  int[] var5;
                  if (this.h >= this.q.L.size()) {
                     if (this.q.K.size() <= 0) {
                        return;
                     }

                     var5 = (int[])this.q.K.elementAt(this.h - this.q.L.size());
                  } else {
                     var5 = (int[])this.q.L.elementAt(this.h);
                  }

                  switch (var5[0]) {
                     case 0:
                     case 1:
                     case 2:
                     case 3:
                        if (this.f == 0) {
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Không thể sử dụng", "Nhấn nút 5 tiếp tục");
                           this.f = 1;
                        } else {
                           this.p.a("/data/ui/msgwarm.ui");
                           this.f = 0;
                        }
                        break label208;
                     case 4:
                     case 5:
                     case 6:
                     case 7:
                     case 8:
                     case 9:
                     case 10:
                     case 11:
                     case 12:
                     default:
                        this.s = var5[0];
                        this.o.a((byte)17);
                        this.p.a("/data/ui/bag.ui");
                        break label208;
                     case 13:
                        if (this.f == 0) {
                           if (this.q.y <= 0) {
                              if (game.l.B().p == 3 && game.l.B().q == 7) {
                                 this.H();
                                 this.a("Nơi này không cách nào sử dụng tránh quái hoàn", "Nhấn nút 5 tiếp tục");
                                 this.f = 1;
                              } else if (this.q.b(var5[0], 1, (byte)0)) {
                                 this.q.d(var5[0], 1, (byte)0);
                                 this.q.y = a.b.c.c[4][var5[0]][6];
                                 this.q.x = 0;
                                 int var7 = this.q.L.size() + this.q.K.size();
                                 if (this.h >= var7) {
                                    this.h = var7 - 1;
                                    ((c.b)this.p.a.a(8)).a.f = this.h;
                                 }

                                 if (this.v > 0 && this.h - this.v < 4) {
                                    this.v--;
                                    ((c.b)this.p.a.a(8)).a.e = this.v;
                                 }

                                 this.bs();
                                 this.H();
                                 this.q.b(1);
                                 this.a("Thành công sử dụng đạo cụ, cũng có thời gian ngắn tránh quái hiệu quả", "Nhấn nút 5 tiếp tục");
                                 this.f = 1;
                              }
                           } else {
                              this.H();
                              this.a("Đã có được thời gian ngắn tránh quái hiệu quả", "Nhấn nút 5 tiếp tục");
                              this.f = 1;
                           }
                        }
                        break label208;
                     case 14:
                        if (this.f == 0) {
                           if (this.q.l(0) && (this.q.J == 0 && game.l.A < 10 || this.q.J > 0 && game.l.A < 30)) {
                              if (this.q.b(var5[0], 1, (byte)0)) {
                                 if (this.q.J == 0) {
                                    game.l.A = 10;
                                 } else {
                                    game.l.A = 30;
                                 }

                                 this.q.d(var5[0], 1, (byte)0);
                                 int var6 = this.q.L.size() + this.q.K.size();
                                 if (this.h >= var6) {
                                    this.h = var6 - 1;
                                    ((c.b)this.p.a.a(8)).a.f = this.h;
                                 }

                                 if (this.v > 0 && this.h - this.v < 4) {
                                    this.v--;
                                    ((c.b)this.p.a.a(8)).a.e = this.v;
                                 }

                                 this.bs();
                                 this.p.a("/data/ui/msgwarm.ui", 257, this);
                                 this.a("Thành công sử dụng, tranh thủ thời gian đi ấp trứng trứng sủng vật a!", "Nhấn nút 5 tiếp tục");
                                 this.f = 1;
                              }
                           } else {
                              this.p.a("/data/ui/msgwarm.ui", 257, this);
                              this.a("Không có trứng có thể ấp trứng", "Nhấn nút 5 tiếp tục");
                              this.f = 1;
                           }
                        }
                        break label208;
                  }
               case 3:
                  int[] var1;
                  switch ((var1 = (int[])this.q.O.elementAt(this.h))[0]) {
                     case 0:
                        if (this.q.l(var1[0])) {
                           if (game.l.B().O()) {
                              if (this.q.z() == 2) {
                                 this.H();
                                 this.a("Không gian không đủ, hãy thanh lý lại không gian ấp trứng", "Nhấn nút 5 tiếp tục");
                                 this.f = 1;
                              } else {
                                 game.l.A = 0;
                                 if (game.l.B().Z.n[game.l.e(4, 5)] != null) {
                                    game.l.B().Z.n[game.l.e(4, 5)][15] = 4;
                                    if (game.l.B().p == 4 && game.l.B().q == 5) {
                                       game.l.B().Z.l[15].a((byte)4);
                                    }
                                 }

                                 this.q.k(var1[0]);
                                 this.bu();
                                 this.H();
                                 this.a("Ấp trứng thành công", "Nhấn nút 5 tiếp tục");
                                 this.f = 2;
                              }
                           } else {
                              this.H();
                              this.a("Vẫn chưa thể ấp trứng", "Nhấn nút 5 tiếp tục");
                              this.f = 1;
                           }
                        }
                     case 1:
                     case 2:
                     case 3:
                     case 4:
                     default:
                        break;
                     case 5:
                        this.o.a((byte)11);
                        this.p.a("/data/ui/bag.ui");
                        break;
                     case 6:
                        this.o.a((byte)12);
                        this.p.a("/data/ui/bag.ui");
                        break;
                     case 7:
                     case 8:
                     case 9:
                        this.s = var1[0];
                        this.o.a((byte)19);
                        this.p.a("/data/ui/bag.ui");
                        break;
                     case 10:
                        this.o.a((byte)24);
                        this.p.a("/data/ui/bag.ui");
                  }
            }
         } else if (this.f == 1 || this.f == 2) {
            if (this.f != 2) {
               this.o.r();
               this.f = 0;
            } else {
               if (this.q.J == 0) {
                  byte var8 = this.h(58);
                  this.q.a((short)58);
                  if (var8 == 0) {
                     this.c("Ấp trứng tìm được #2" + a.a.c(a.b.c.c[0][58][0]) + "#0 để vào ba lô");
                  } else if (var8 == 1) {
                     this.c("Ấp trứng tìm được #2" + a.a.c(a.b.c.c[0][58][0]) + "#0 để vào ngân hàng");
                  } else {
                     this.c("Không có không gian, đã phóng sinh");
                  }
               } else {
                  int var9 = a.e.a(new int[]{76, 52, 28, 4, 0}, a.e.a(100));
                  short[] var2 = new short[]{0, 56, 58, 95, 72};
                  byte var3 = this.h(var2[var9]);
                  int var4 = 0;

                  while (var4 < this.q.J && this.q.S[var4] != var2[var9]) {
                     var4++;
                  }

                  if (var4 >= this.q.J) {
                     this.q.a(var2[var9]);
                  }

                  if (var3 == 0) {
                     this.c("Ấp trứng tìm được #2" + a.a.c(a.b.c.c[0][var2[var9]][0]) + "#0 để vào ba lô");
                  } else if (var3 == 1) {
                     this.c("Ấp trứng tìm được #2" + a.a.c(a.b.c.c[0][var2[var9]][0]) + "#0 để vào ngân hàng");
                  } else {
                     this.c("Không có không gian, đã phóng sinh");
                  }
               }

               this.f = 3;
            }

            this.I();
         }
      } else if (this.f == 0 && this.o.g(262144) && !this.j() && a.a.t()) {
         if (a.a.i) {
            this.b = 2;
         } else {
            this.b = 1;
         }

         this.o.a((byte)6);
         this.p.a("/data/ui/bag.ui");
      }

      if (this.f == 3 && !this.j()) {
         this.o.r();
         this.br();
         this.f = 0;
      }

      this.f();
      this.g = true;
   }

   private byte h(int var1) {
      int[][] var2 = new int[][]{{60, 20, 0}, {75, 50, 20, 0}};
      byte var3 = -1;
      byte var4 = 0;
      if (a.b.c.c[0][var1][4] == 5) {
         if (a.b.c.c[0][var1][3] == 2) {
            var3 = 1;
            var4 = 2;
         } else if (a.b.c.c[0][var1][3] == 3) {
            var3 = 0;
            var4 = 3;
         }
      }

      int var5 = a.b.c.c[0][var1][1] * 10;
      short var6 = a.b.c.c[1][var5][5];
      byte var7 = this.q.z();
      if (var3 == -1) {
         if (var7 == 0) {
            this.q.a(var1, 5, (short)-1, (byte)2, (short)-1, (byte)-1, new int[]{1, var5, var6});
         } else if (var7 == 1) {
            int var8 = a.e.b(a.b.c.c[0][var1][3], a.b.c.c[0][var1][3]);
            this.q.a(var1, 5, (short)-1, (byte)2, (byte)var8, (byte)-1, game.i.b(var1, 5, var8), 0, -1, new int[]{1, var5, var6});
         }
      } else {
         var4 = (byte)(var4 + (byte)a.e.a(var2[var3], a.e.a(100)));
         if (var7 == 0) {
            this.q.a(var1, 5, (short)-1, (byte)2, var4, (byte)-1, new int[]{1, var5, var6});
         } else if (var7 == 1) {
            this.q.a(var1, 5, (short)-1, (byte)2, var4, (byte)-1, game.i.b(var1, 5, var4), 0, -1, new int[]{1, var5, var6});
         }
      }

      return var7;
   }

   public final void ag() {
      this.aU();
      this.p.a("/data/ui/ride.ui", 257, this);
      this.b = 0;
      this.bv();
   }

   private void bv() {
      for (int var1 = 0; var1 < 4; var1++) {
         if (this.p.a.a(var1 + 4).i().m == null) {
            this.p.a.a(var1 + 4).i().m = new c.g();
            this.p.a.a(var1 + 4).i().m.a(0);
            this.p.a.a(var1 + 4).i().m.a = 3;
            this.p.a.a(var1 + 4).i().m.a(260, false, (byte)-1);
         }

         if (this.p.a.a(var1 + 16).i().m == null) {
            this.p.a.a(var1 + 16).i().m = new c.g();
            this.p.a.a(var1 + 16).i().m.a(131);
            this.p.a.a(var1 + 16).i().m.a = 2;
            this.p.a.a(var1 + 16).i().m.a(257, false, (byte)0);
         }

         if (this.q.f(var1)) {
            if (this.b == var1) {
               this.p.a.a(var1 + 4).i().m.a((byte)var1, (byte)-1);
               if (this.b == 0) {
                  this.p.a.a(var1 + 8).i().a = "Lục đi điểu";
               } else if (this.b == 1) {
                  this.p.a.a(var1 + 8).i().a = "Hư không hành giả";
               } else if (this.b == 2) {
                  this.p.a.a(var1 + 8).i().a = "Hải âu";
               } else if (this.b == 3) {
                  this.p.a.a(var1 + 8).i().a = "Nham sơn long";
               }
            } else {
               this.p.a.a(var1 + 4).i().m.a((byte)(var1 + 8), (byte)-1);
               this.p.a.a(var1 + 8).i().a = "";
            }

            if (!this.q.g(var1)) {
               this.p.a.a(var1 + 16).a(true);
            } else {
               this.p.a.a(var1 + 16).a(false);
            }
         } else {
            this.p.a.a(var1 + 16).a(false);
            this.p.a.a(var1 + 4).i().m.a((byte)(var1 + 4), (byte)-1);
            this.p.a.a(var1 + 8).i().a = "";
         }
      }
   }

   public final void ah() {
      if (!this.j() && this.o.g(16400)) {
         this.p.a.b(2);
      } else if (!this.j() && this.o.g(32832)) {
         this.p.a.b(3);
      } else if (!this.j() && this.o.g(512)) {
         this.p.a("/data/ui/ride.ui");
         this.o.a((byte)0);
      } else if (!this.j() && this.o.g(196640)) {
         if (this.q.f(this.b)) {
            if (this.q.g(this.b)) {
               this.q.h(this.b);
               this.p.a("/data/ui/ride.ui");
               this.o.a((byte)0);
            } else {
               this.b("Nơi này không thể sử dụng sủng vật cưỡi");
            }
         } else {
            this.b("Chưa có sủng vật cưỡi này");
         }
      } else if (!this.j() && this.o.g(262144)) {
         this.p.a("/data/ui/ride.ui");
         this.o.a((byte)0);
      }

      this.f();
      this.g = true;
   }

   public final void a(i var1, i var2) {
      this.p.a("/data/ui/battle.ui", 257, this);
      this.a = 0;
      this.e = 0;
      this.a(var1, false);
      this.b(var2, false);
      k var3 = this;
      this.p.a.a(59).i().a = "100%";
      var3.p.a.a(58).i().a = "100%";
      ((game.a)var3.o).D();
      this.p.a("/data/ui/world.ui");
   }

   public final void b(i var1, i var2) {
      if (var1.a(var2) == 0) {
         if (var1.s() == 0) {
            this.p.a.a(59).i().a = "300%";
            this.p.a.a(58).i().a = "60%";
         } else {
            this.p.a.a(59).i().a = "60%";
            this.p.a.a(58).i().a = "300%";
         }
      } else if (var1.a(var2) == 1) {
         if (var1.s() == 0) {
            this.p.a.a(59).i().a = "60%";
            this.p.a.a(58).i().a = "300%";
         } else {
            this.p.a.a(59).i().a = "300%";
            this.p.a.a(58).i().a = "60%";
         }
      } else {
         this.p.a.a(59).i().a = "100%";
         this.p.a.a(58).i().a = "100%";
      }
   }

   public final void a(i var1, i var2, i var3, int var4, int var5) {
      if (var1.a(var2) == 0) {
         if (var3.s() == 0) {
            if ((var4 = var4 * (200 / var5)) == var5 && var4 != 200) {
               var4 = 200;
            }

            this.p.a.a(59).i().a = var4 + 100 + "%";
            return;
         }

         if (var3.s() == 1) {
            if ((var4 = var4 * (40 / var5)) == var5 && var4 != 40) {
               var4 = 40;
            }

            this.p.a.a(58).i().a = 100 - var4 + "%";
            return;
         }
      } else if (var1.a(var2) == 1) {
         if (var3.s() == 0) {
            if ((var4 = var4 * (40 / var5)) == var5 && var4 != 40) {
               var4 = 40;
            }

            this.p.a.a(59).i().a = 100 - var4 + "%";
            return;
         }

         if (var3.s() == 1) {
            if ((var4 = var4 * (200 / var5)) == var5 && var4 != 200) {
               var4 = 200;
            }

            this.p.a.a(58).i().a = var4 + 100 + "%";
            return;
         }
      } else {
         this.p.a.a(59).i().a = "100%";
         this.p.a.a(58).i().a = "100%";
      }
   }

   public final void a(i var1, i var2, int var3, int var4) {
      this.C = this.D = 0;
      if (var1.a(var2) == 0) {
         this.C += var3 * (200 / var4);
         if (this.C == var4 && this.C != 200) {
            this.C = 200;
         }

         this.p.a.a(59).i().a = 100 + this.C + "%";
         this.D += var3 * (40 / var4);
         if (this.D == var4 && this.D != 40) {
            this.D = 40;
         }

         this.p.a.a(58).i().a = 100 - this.D + "%";
      } else if (var1.a(var2) == 1) {
         this.C += var3 * (40 / var4);
         if (this.C == var4 && this.C != 40) {
            this.C = 40;
         }

         this.p.a.a(59).i().a = 100 - this.C + "%";
         this.D += var3 * (200 / var4);
         if (this.D == var4 && this.D != 200) {
            this.D = 200;
         }

         this.p.a.a(58).i().a = 100 + this.D + "%";
      } else {
         this.p.a.a(59).i().a = "100%";
         this.p.a.a(58).i().a = "100%";
      }
   }

   public final boolean a(i var1, boolean var2) {
      int var3 = 0;
      if (this.E == 0) {
         int var10000 = var1.O();
         byte var7 = 1;
         if ((var3 = Math.abs(var10000 - var1.e[var7]) / 11) <= 1) {
            var3 = 1;
         }
      }

      int var4 = var1.O();
      byte var9 = 1;
      short var5 = var1.e[var9];
      if (var4 != var5) {
         this.F++;
         if (this.F < 4) {
            if (var2) {
               this.p.a.a(55).i().a = "#P" + var1.M();
               this.p.a.a(11).i().a = "#P" + var1.N();
            } else {
               this.p.a.a(55).i().a = "#P" + var1.N();
               this.p.a.a(11).i().a = "#P" + var1.M();
            }

            return false;
         }
      }

      this.E += var3;
      if (var2) {
         if ((var4 = var4 + this.E) >= var5) {
            var4 = var5;
         }

         var1.u(var4);
         this.p.a.a(41).i().a = "#P" + var1.M();
         this.p.a.a(11).i().a = "#P" + var1.N();
         this.p.a.a(55).i().a = "#P" + var1.N();
      } else {
         if ((var4 = var4 - this.E) <= var5) {
            var4 = var5;
         }

         var1.u(var4);
         this.p.a.a(41).i().a = "#P" + var1.N();
         this.p.a.a(55).i().a = "#P" + var1.M();
         this.p.a.a(11).i().a = "#P" + var1.M();
      }

      c.i var11 = this.p.a.a(38).i();
      StringBuffer var10001 = new StringBuffer().append(var1.O()).append("/");
      var9 = 1;
      var11.a = var10001.append(var1.d[var9]).toString();
      this.p.a.a(9).i().a = "#P" + var1.P();
      this.p.a.a(40).i().a = var1.A() + "/" + var1.v();
      this.p.a.a(12).i().a = a.a.c(var1.j((byte)0));
      this.p.a.a(13).i().a = "lv" + var1.t();
      this.p.a.a(17).i().m.a(94 + var1.j((byte)1));
      if (var4 == var5) {
         this.E = 0;
         this.F = 0;
         this.k = 0;
         return true;
      } else {
         return false;
      }
   }

   public final void a(i var1) {
      for (int var2 = 0; var2 < 6; var2++) {
         if (this.p.a.a(var2 + 26).i().m == null) {
            this.p.a.a(var2 + 26).i().m = new c.g();
            this.p.a.a(var2 + 26).i().m.a = 2;
            this.p.a.a(var2 + 26).i().m.a(0);
            this.p.a.a(var2 + 26).i().m.a(325, false, (byte)0);
         }

         if (this.p.a.a(var2 + 43).i().m == null) {
            this.p.a.a(var2 + 43).i().m = new c.g();
            this.p.a.a(var2 + 43).i().m.a = 2;
            this.p.a.a(var2 + 43).i().m.a(145);
            this.p.a.a(var2 + 43).i().m.a(257, false, (byte)0);
         }

         this.p.a.a(var2 + 43).i().m.a(145);
         this.p.a.a(var2 + 26).i().m.a(0);
      }

      for (int var3 = 0; var3 < 3; var3++) {
         if (var1.y[0][var3] != -1 && var1.w[var1.y[0][var3]][0] > 0) {
            short[] var10002 = var1.w[var1.y[0][var3]];
            this.p.a.a(43 + this.k).i().m.a(134 + var10002[0]);
            this.p.a.a(26 + this.k).i().m.a(var1.y[0][var3] + 12);
            this.k++;
         }

         if (var1.y[1][var3] != -1 && var1.x[var1.y[1][var3]][0] > 0) {
            short[] var4 = var1.x[var1.y[1][var3]];
            this.p.a.a(43 + this.k).i().m.a(134 + var4[0]);
            this.p.a.a(26 + this.k).i().m.a(var1.y[1][var3] + 1);
            this.k++;
         }
      }
   }

   private void g(i var1) {
      this.p.a.a(11).i().a = "#P" + var1.M();
      c.i var10000 = this.p.a.a(38).i();
      StringBuffer var10001 = new StringBuffer().append(var1.O()).append("/");
      byte var3 = 1;
      var10000.a = var10001.append(var1.d[var3]).toString();
      this.p.a.a(16).i().a = "lv" + var1.t();
   }

   public final boolean b(i var1, boolean var2) {
      int var3 = 0;
      if (this.E == 0) {
         int var10000 = var1.O();
         byte var7 = 1;
         if ((var3 = Math.abs(var10000 - var1.e[var7]) / 11) <= 1) {
            var3 = 1;
         }
      }

      int var4 = var1.O();
      byte var9 = 1;
      short var5 = var1.e[var9];
      if (var4 != var5) {
         this.F++;
         if (this.F < 4) {
            if (var2) {
               this.p.a.a(56).i().a = "#P" + var1.M();
               this.p.a.a(14).i().a = "#P" + var1.N();
            } else {
               this.p.a.a(56).i().a = "#P" + var1.N();
               this.p.a.a(14).i().a = "#P" + var1.M();
            }

            return false;
         }
      }

      this.E += var3;
      if (var2) {
         if ((var4 = var4 + this.E) >= var5) {
            var4 = var5;
         }

         var1.u(var4);
         this.p.a.a(42).i().a = "#P" + var1.M();
         this.p.a.a(14).i().a = "#P" + var1.N();
         this.p.a.a(56).i().a = "#P" + var1.N();
      } else {
         if ((var4 = var4 - this.E) <= var5) {
            var4 = var5;
         }

         var1.u(var4);
         this.p.a.a(42).i().a = "#P" + var1.N();
         this.p.a.a(14).i().a = "#P" + var1.M();
         this.p.a.a(56).i().a = "#P" + var1.M();
      }

      c.i var11 = this.p.a.a(39).i();
      StringBuffer var10001 = new StringBuffer().append(var1.O()).append("/");
      var9 = 1;
      var11.a = var10001.append(var1.d[var9]).toString();
      if (this.q.a((byte)var1.j((byte)1), var1.r()) == 2) {
         this.p.a.a(19).i().m.a(101);
      } else {
         this.p.a.a(19).i().m.a(102);
      }

      this.p.a.a(15).i().a = a.a.c(var1.j((byte)0));
      this.p.a.a(16).i().a = "lv" + var1.t();
      this.p.a.a(18).i().m.a(94 + var1.j((byte)1));
      if (var4 == var5) {
         this.E = 0;
         this.F = 0;
         this.k = 0;
         return true;
      } else {
         return false;
      }
   }

   public final void b(i var1) {
      for (int var2 = 0; var2 < 6; var2++) {
         if (this.p.a.a(var2 + 32).i().m == null) {
            this.p.a.a(var2 + 32).i().m = new c.g();
            this.p.a.a(var2 + 32).i().m.a = 2;
            this.p.a.a(var2 + 32).i().m.a(0);
            this.p.a.a(var2 + 32).i().m.a(325, false, (byte)0);
         }

         if (this.p.a.a(var2 + 49).i().m == null) {
            this.p.a.a(var2 + 49).i().m = new c.g();
            this.p.a.a(var2 + 49).i().m.a = 2;
            this.p.a.a(var2 + 49).i().m.a(145);
            this.p.a.a(var2 + 49).i().m.a(257, false, (byte)0);
         }

         this.p.a.a(var2 + 49).i().m.a(145);
         this.p.a.a(var2 + 32).i().m.a(0);
      }

      for (int var3 = 0; var3 < 3; var3++) {
         if (var1.y[0][var3] != -1 && var1.w[var1.y[0][var3]][0] > 0) {
            short[] var10002 = var1.w[var1.y[0][var3]];
            this.p.a.a(49 + this.k).i().m.a(134 + var10002[0]);
            this.p.a.a(32 + this.k).i().m.a(var1.y[0][var3] + 12);
            this.k++;
         }

         if (var1.y[1][var3] != -1 && var1.x[var1.y[1][var3]][0] > 0) {
            short[] var4 = var1.x[var1.y[1][var3]];
            this.p.a.a(49 + this.k).i().m.a(134 + var4[0]);
            this.p.a.a(32 + this.k).i().m.a(var1.y[1][var3] + 1);
            this.k++;
         }
      }
   }

   public final void ai() {
      this.a = 0;
      this.x = null;
      this.p.a("/data/ui/battle.ui");
   }

   public final void aj() {
      ((c.b)this.p.a.a(0)).b.f = this.a;
      this.p.a.a(20 + this.a).a(true);
   }

   public final void c(i var1) {
      this.f = 0;
      this.a(var1, false);
      this.aj();
   }

   public final void d(i var1) {
      ((game.a)this.o).q();
      if (!a.a.a(this.a, 1) && this.f == 0 && !this.j() && this.o.g(16400)) {
         this.p.a.b(2);
      } else if (!a.a.a(this.a, 1) && this.f == 0 && !this.j() && this.o.g(32832)) {
         this.p.a.b(3);
      } else if (!this.j() && this.o.g(196640)) {
         switch (this.a) {
            case 0:
               this.p.a.a(20 + this.a).a(false);
               this.o.a((byte)3);
               break;
            case 1:
               if (((game.a)this.o).l == 2) {
                  this.b("Trận chiến này không cho bắt sủng vật");
               } else if (this.q.z() == 2) {
                  this.b("Không gian không đủ, không cách nào bắt được");
               } else {
                  this.b = 0;
                  this.p.a.a(20 + this.a).a(false);
                  ((game.a)this.o).r();
                  this.o.a((byte)21);
               }
               break;
            case 2:
               if (this.f == 0) {
                  if (var1.p(2)) {
                     this.p.a("/data/ui/msgwarm.ui", 257, this);
                     this.a("Trạng thái bị quấn, không thể sử dụng đạo cụ", "Nhấn nút 5 tiếp tục");
                     this.f = 1;
                  } else {
                     this.p.a.a(20 + this.a).a(false);
                     this.o.a((byte)4);
                  }
               } else {
                  this.p.a("/data/ui/msgwarm.ui");
                  this.f = 0;
               }
               break;
            case 3:
               if (this.f == 0) {
                  if (var1.p(2)) {
                     this.p.a("/data/ui/msgwarm.ui", 257, this);
                     this.a("Trạng thái bị quấn, không thể đổi sủng vật", "Nhấn nút 5 tiếp tục");
                     this.f = 1;
                  } else {
                     this.p.a.a(20 + this.a).a(false);
                     ((game.a)this.o).q = ((game.a)this.o).o[((game.a)this.o).s];
                     game.a.B().u = true;
                     this.o.a((byte)5);
                  }
               } else {
                  this.p.a("/data/ui/msgwarm.ui");
                  this.f = 0;
               }
               break;
            case 4:
               this.p.a.a(20 + this.a).a(false);
               this.o.a((byte)11);
               break;
            case 5:
               if (this.f == 0) {
                  if (var1.p(2)) {
                     this.p.a("/data/ui/msgwarm.ui", 257, this);
                     this.a("Trạng thái bị quấn, không thể chạy trốn", "Nhấn nút 5 tiếp tục");
                     this.f = 1;
                  } else if (((game.a)this.o).l <= 0 && game.e.v) {
                     boolean var3 = false;
                     if (((game.a)this.o).r.t() > ((game.a)this.o).n[0].t()) {
                        var3 = true;
                     } else if (((game.a)this.o).r.t() == ((game.a)this.o).n[0].t()) {
                        if (a.e.a(100) <= 95) {
                           var3 = true;
                        }
                     } else {
                        int var2 = ((game.a)this.o).n[0].t() - ((game.a)this.o).r.t();
                        if ((var2 = 95 - var2 * 10) <= 15) {
                           var2 = 15;
                        }

                        if (a.e.a(100) < var2) {
                           var3 = true;
                        }
                     }

                     if (var3) {
                        this.p.a.a(20 + this.a).a(false);
                        game.f.B().a((byte)10);
                     } else {
                        this.f = 2;
                        this.b("Chạy trốn thất bại");
                     }
                  } else {
                     this.p.a.a(20 + this.a).a(false);
                     this.f = 3;
                     this.b("Trận chiến này không thể trốn chạy");
                  }
               } else {
                  this.p.a("/data/ui/msgwarm.ui");
                  this.f = 0;
               }
         }
      }

      this.f();
      if (this.f >= 2 && this.aA()) {
         if (this.f == 2) {
            ((game.a)this.o).r.K = true;
            ((game.a)this.o).s++;
            this.o.a((byte)1);
         } else {
            this.p.a.a(20 + this.a).a(true);
         }

         this.f = 0;
      }
   }

   public final void e(i var1) {
      this.p.a("/data/ui/choiceskill.ui", 257, this);
      ((c.b)this.p.a.a(0)).a.a = var1.F();
      if (this.e >= var1.F()) {
         this.e = var1.F() - 1;
      }

      if (var1.F() > 5) {
         ((c.b)this.p.a.a(0)).a.a(1);
      } else {
         ((c.b)this.p.a.a(0)).a.a(-1);
      }

      this.p.a.a(5).i().a = "Sử dụng";
      ((c.b)this.p.a.a(0)).a.f = this.e;
      this.h(var1);
      this.f = 0;
   }

   private void h(i var1) {
      this.v = ((c.b)this.p.a.a(0)).a.e;
      this.h = ((c.b)this.p.a.a(0)).a.f;
      int var2 = var1.F();

      for (int var3 = 0; var3 < 5; var3++) {
         if (var3 >= var2) {
            this.p.a.a(13 + var3 * 5).i().a = "";
            this.p.a.a(14 + var3 * 5).i().a = "";
         } else {
            this.p.a.a(13 + var3 * 5).i().a = a.a.c(a.b.c.c[1][var1.t(this.v + var3)][1]);
            this.p.a.a(14 + var3 * 5).i().a = var1.z[this.v + var3] + "/" + a.b.c.c[1][var1.t(this.v + var3)][5];
         }
      }

      this.i(var1.A[this.e]);
      this.p.a.a(51).b(98 + this.h * 80 / var2, this.p.a.a());
   }

   private void i(int var1) {
      this.p.a.a(53).i().a = a.a.c(a.b.c.c[1][var1][2]);
   }

   public final void f(i var1) {
      if (this.aB()) {
         if (this.f == 0 && this.o.g(4100)) {
            this.p.a.b(0);
            this.h(var1);
         } else if (this.f == 0 && this.o.g(8448)) {
            this.p.a.b(1);
            this.h(var1);
         } else if (this.o.g(196640)) {
            if (this.f == 0) {
               if (var1.s(this.e)) {
                  this.p.a("/data/ui/choiceskill.ui");
                  ((game.a)this.o).d(var1.A[this.e]);
                  int var10000 = ((game.a)this.o).k;
                  ((game.a)this.o).getClass();
                  if (var10000 == 0) {
                     ((game.a)this.o).G();
                  } else {
                     this.o.a((byte)6);
                  }
               } else {
                  this.f = 1;
                  this.p.a("/data/ui/msgwarm.ui", 257, this);
                  this.a("Kỹ năng giá trị chưa đủ", "Nhấn nút 5 tiếp tục");
               }
            } else {
               this.f = 0;
               this.p.a("/data/ui/msgwarm.ui");
               if (var1.p(2) && var1.s() == 0) {
                  boolean var2 = false;

                  for (int var3 = 0; var3 < var1.z.length; var3++) {
                     if (var1.z[var3] != 0) {
                        var2 = true;
                     }
                  }

                  if (!var2) {
                     this.p.a("/data/ui/choiceskill.ui");
                     this.c("Không có kỹ năng giá trị, không cách nào chiến đấu");
                     ((game.a)this.o).F();
                  }
               }
            }
         } else if (this.o.g(262144) && this.f == 0) {
            this.p.a("/data/ui/choiceskill.ui");
            this.o.a((byte)20);
         }
      }

      this.g();
   }

   public final void ak() {
      this.f = 0;
      this.p.a("/data/ui/choice.ui", 257, this);
      this.p.a.a(8).i().a = "Pokemon ball";
      this.p.a.a(9).i().a = "Tỉ lệ bắt";
      this.p.a.a(5).i().a = "Sử dụng";
      ((c.b)this.p.a.a(0)).a.f = this.b;
      ((c.b)this.p.a.a(0)).a.a(0);
      ((c.b)this.p.a.a(0)).a.a = this.q.L.size();

      for (int var1 = 0; var1 < this.q.L.size(); var1++) {
         int[] var2 = (int[])this.q.L.elementAt(var1);
         if (this.p.a.a(var1 + 54).i().m == null) {
            this.p.a.a(var1 + 54).i().m = new c.g();
            this.p.a.a(var1 + 54).i().m.a(0);
            this.p.a.a(var1 + 54).i().m.a = 2;
            this.p.a.a(var1 + 54).i().m.a(258, false, (byte)-1);
         }

         this.p.a.a(var1 + 54).i().m.a(a.b.c.c[4][var2[0]][1]);
         this.p.a.a(13 + var1 * 5).i().a = a.a.c(a.b.c.c[4][var2[0]][0]);
         this.p.a.a(14 + var1 * 5).i().a = ((game.a)this.o).m(var2[0]) + "%";
      }

      this.p.a.a(59).a(false);
      this.p.a.a(60).a(false);
      this.bw();
   }

   private void bw() {
      int[] var1 = (int[])this.q.L.elementAt(this.b);
      this.p.a.a(53).i().a = "Số lượng: " + var1[1] + " cái ";
   }

   public final void al() {
      this.o.q();
      if (!a.a.a(this.b, 0) && this.f == 0 && this.o.g(4100) && !this.j()) {
         this.p.a.b(0);
         this.bw();
      } else if (!a.a.a(this.b, 0) && this.f == 0 && this.o.g(8448) && !this.j()) {
         this.p.a.b(1);
         this.bw();
      } else if (this.o.g(196640) && !this.j() && a.a.s()) {
         if (a.a.p() && !a.a.a(this.b, 0)) {
            return;
         }

         game.e.w = true;
         if (this.f == 0) {
            int[] var1 = (int[])this.q.L.elementAt(this.b);
            if (!this.q.b(var1[0], 1, (byte)0)) {
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Số lượng Pokemon ball không đủ", "Nhấn nút 5 tiếp tục");
               this.f = 1;
            } else {
               this.f = 0;
               game.a.v = (byte)var1[0];
               this.o.r();
               this.q.d(var1[0], 1, (byte)0);
               this.o.a((byte)17);
               this.p.a("/data/ui/choice.ui");
            }
         } else if (this.f == 1) {
            if (a.a.i && ((int[])this.q.L.elementAt(this.b))[0] == 0) {
               this.p.a("/data/ui/choice.ui");
               this.o.a((byte)101);
            }

            this.f = 0;
            this.p.a("/data/ui/msgwarm.ui");
         }
      } else if (game.e.t() && this.f == 0 && this.o.g(262144) && !this.j()) {
         this.p.a("/data/ui/choice.ui");
         this.o.a((byte)20);
      }

      this.g();
   }

   public final void am() {
      this.s = 0;
      this.f = 0;
      this.b = 0;
      this.p.a("/data/ui/choice.ui", 257, this);
      this.p.a.a(8).i().a = "Đạo cụ";
      this.p.a.a(9).i().a = "Số lượng";
      this.p.a.a(5).i().a = "Sử dụng";
      this.p.a.a(59).a(false);
      this.p.a.a(60).a(false);
      this.bi();
   }

   public final void an() {
      if (this.f == 0 && this.o.g(4100)) {
         this.p.a.b(0);
      } else if (this.f == 0 && this.o.g(8448)) {
         this.p.a.b(1);
      } else {
         if (this.o.g(196640)) {
            if (this.q.K.size() <= 0) {
               return;
            }

            this.s = ((int[])this.q.K.elementAt(this.h))[0];
            if (this.f == 0) {
               switch (a.b.c.c[4][this.s][5]) {
                  case 7:
                  case 8:
                  case 9:
                  case 10:
                     this.p.a("/data/ui/msgwarm.ui", 257, this);
                     this.a("Trong chiến đấu không thể sử dụng", "Nhấn nút 5 tiếp tục");
                     this.f = 1;
                     return;
                  default:
                     this.o.a((byte)16);
                     this.p.a("/data/ui/choice.ui");
                     return;
               }
            }

            if (this.f == 1) {
               this.p.a("/data/ui/msgwarm.ui");
               this.f = 0;
               return;
            }
         } else if (this.f == 0 && this.o.g(262144)) {
            this.p.a("/data/ui/choice.ui");
            this.o.a((byte)20);
         }
      }
   }

   private void bx() {
      if (this.f == 0) {
         this.f = 1;
         int var1;
         if (this.o instanceof l) {
            var1 = this.q.A[this.c].x(this.s);
         } else {
            var1 = this.q.A[((game.a)this.o).p[this.c]].x(this.s);
         }

         switch (var1) {
            case 0:
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Sủng vật này đã tử vong, không thể sử dụng", "Nhấn nút 5 tiếp tục");
               return;
            case 1:
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Sủng vật này không có, không thể sử dụng", "Nhấn nút 5 tiếp tục");
               return;
            case 2:
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Máu đầy, không cần sử dụng", "Nhấn nút 5 tiếp tục");
               return;
            case 3:
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Kỹ năng giá trị đã đầy, không cần sử dụng", "Nhấn nút 5 tiếp tục");
               return;
            case 4:
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Trên người đều bị lợi hiệu quả", "Nhấn nút 5 tiếp tục");
               return;
            case 5:
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Trong hưng phấn, không thể dùng", "Nhấn nút 5 tiếp tục");
               return;
            case 6:
            default:
               if (this.q.b(this.s, 1, (byte)0)) {
                  if (this.o instanceof l) {
                     this.q.A[this.c].w(this.s);
                  } else {
                     ((game.a)this.o).r.K = true;
                     this.q.A[((game.a)this.o).p[this.c]].w(this.s);
                  }

                  this.f(this.c);
                  this.f = 1;
                  this.l = true;
                  this.p.a("/data/ui/msgwarm.ui", 257, this);
                  this.a("Thành công sử dụng đạo cụ", "Nhấn nút 5 tiếp tục");
                  return;
               }

               this.f = 2;
               this.H();
               this.a("Không có đạo này cụ, hãy mua sắm", "Nhấn nút 5 tiếp tục");
               return;
            case 7:
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Máu và tinh khí đều đã đầy, không cần sử dụng", "Nhấn nút 5 tiếp tục");
               return;
            case 8:
               this.p.a("/data/ui/msgwarm.ui", 257, this);
               this.a("Sủng vật đã chết, không thể sử dụng", "Nhấn nút 5 tiếp tục");
         }
      } else if (this.f == 1) {
         this.f = 0;
         this.p.a("/data/ui/msgwarm.ui");
      } else {
         if (this.f == 2) {
            this.f = 0;
            this.p.a("/data/ui/msgwarm.ui");
            this.p.a("/data/ui/petstate.ui");
            if (this.o instanceof l) {
               this.o.a((byte)8);
               return;
            }

            if (game.a.B().r.equals(((game.a)this.o).n(this.c))) {
               this.g(((game.a)this.o).o(this.c));
            }

            if (((game.a)this.o).r.K) {
               ((game.a)this.o).s++;
               ((game.a)this.o).a((byte)1);
               return;
            }

            ((game.a)this.o).a((byte)4);
         }
      }
   }

   public final void ao() {
      if (this.f == 0 && this.o.g(4100)) {
         this.p.a.b(0);
      } else if (this.f == 0 && this.o.g(8448)) {
         this.p.a.b(1);
      } else if (this.o.g(196640)) {
         this.bx();
      } else {
         if (this.f == 0 && this.o.g(262144)) {
            if (this.l) {
               if (game.a.B().r.equals(((game.a)this.o).n(this.c))) {
                  this.g(((game.a)this.o).o(this.c));
               }

               if (((game.a)this.o).r.K) {
                  ((game.a)this.o).s++;
                  ((game.a)this.o).a((byte)1);
               } else {
                  ((game.a)this.o).a((byte)4);
               }

               this.p.a("/data/ui/petstate.ui");
               return;
            }

            ((game.a)this.o).a((byte)4);
            this.p.a("/data/ui/petstate.ui");
         }
      }
   }

   public final void b(int var1, int var2) {
      if (this.i >= game.a.t.size()) {
         this.i = 0;
         game.f.B().a((byte)10);
      } else {
         label21:
         while (true) {
            i var3 = (i)game.a.t.elementAt(this.i);

            while (this.i < game.a.t.size() && var3.u()) {
               this.i++;
               if (this.i < game.a.t.size()) {
                  continue label21;
               }
            }

            this.G = var1;
            this.H = var2;
            var3.c();
            var3.b(var1, var2);
            this.w = 0;
            return;
         }
      }
   }

   public final void ap() {
      if (this.i >= game.a.t.size()) {
         this.i = 0;
         game.f.B().a((byte)10);
      } else {
         if (this.w <= 0) {
            this.I += 8;
         }

         i var1;
         int var2 = (var1 = (i)game.a.t.elementAt(this.i)).B() + this.I;
         int var3 = var1.v();
         int var4 = var1.A();
         if (var2 >= var3) {
            var2 = var3;
         } else if (var2 >= var4) {
            var2 = var4;
         }

         if (this.o.g(196640)) {
            if (var4 >= var3) {
               var2 = var3;
               this.p.a.a(40).i().a = var2 + "/" + var2;
               this.p.a.a(9).i().a = "#P" + var1.v(var2);
               var1.j(0);
               this.w = 0;
               ((game.a)this.o).a((byte)22);
            } else if (var2 < var4) {
               this.I = 0;
               var2 = var4;
               var1.j(var2);
               this.p.a.a(40).i().a = var2 + "/" + var1.v();
               this.p.a.a(9).i().a = "#P" + var1.v(var2);
            } else {
               this.p.a.a(40).i().a = var4 + "/" + var1.v();
               this.p.a.a(9).i().a = "#P" + var1.v(var4);
               var1.j(var2);
               this.i++;

               while (this.i < game.a.t.size() && ((i)game.a.t.elementAt(this.i)).u()) {
                  this.i++;
               }

               if (this.i >= game.a.t.size()) {
                  this.i = 0;
                  game.f.B().a((byte)10);
               } else {
                  ((i)game.a.t.elementAt(this.i)).b(this.G, this.H);
               }

               this.w = 0;
               this.I = 0;
            }
         } else {
            this.p.a.a(40).i().a = var2 + "/" + var1.v();
            this.p.a.a(9).i().a = "#P" + var1.v(var2);
            i var6 = var1;
            k var5 = this;
            this.p.a.a(12).i().a = a.a.c(var6.j((byte)0));
            var5.p.a.a(13).i().a = "lv" + var6.t();
            var5.p.a.a(17).i().m.a(94 + var6.j((byte)1));
            if (var2 >= var3) {
               var1.j(0);
               ((game.a)this.o).a((byte)22);
            } else {
               if (var2 < var4) {
                  return;
               }

               this.w++;
               var1.j(var2);
               if (this.w >= 10) {
                  this.i++;

                  while (this.i < game.a.t.size() && ((i)game.a.t.elementAt(this.i)).u()) {
                     this.i++;
                  }

                  if (this.i >= game.a.t.size()) {
                     this.i = 0;
                     game.f.B().a((byte)10);
                  } else {
                     ((i)game.a.t.elementAt(this.i)).b(this.G, this.H);
                  }

                  this.w = 0;
               }
            }

            this.I = 0;
         }
      }
   }

   public final void aq() {
      i var1 = (i)game.a.t.elementAt(this.i);
      String[] var2 = new String[4];

      for (int var3 = 0; var3 < 4; var3++) {
         StringBuffer var10002 = new StringBuffer();
         byte var5 = (byte)(var3 + 1);
         var2[var3] = var10002.append(var1.d[var5]).toString();
      }

      var1.w();
      this.g(var1);
      this.p.a("/data/ui/levelUp.ui", 257, this);

      for (int var6 = 0; var6 < 4; var6++) {
         this.p.a.a(var6 + 19).i().a = var2[var6];
      }

      if (var1.F() < 5 && var1.F() < var1.t() / 10 + 1) {
         this.x = var1.G();
         this.p.a.a(51).i().a = "Có thể học tập kỹ năng mới";
      } else {
         this.p.a.a(51).i().a = "";
      }

      this.p.a.a(38).i().a = a.a.c(a.b.c.c[0][var1.r()][0]);
      this.p.a.a(40).i().a = "" + var1.t();
      if (this.p.a.a(10).i().m == null) {
         this.p.a.a(10).i().m = new c.g();
         this.p.a.a(10).i().m.a = 3;
         this.p.a.a(10).i().m.a(0);
         this.p.a.a(10).i().m.a(var1.D, false, (byte)-1);
      }

      for (int var7 = 0; var7 < 4; var7++) {
         c.i var10000 = this.p.a.a(var7 + 31).i();
         StringBuffer var10001 = new StringBuffer();
         byte var8 = (byte)(var7 + 1);
         var10000.a = var10001.append(var1.d[var8]).toString();
      }
   }

   public final void ar() {
      this.J++;
      if (this.J > 40) {
         this.J = 0;
         if (this.x != null) {
            ((game.a)this.o).a((byte)23);
         } else if (this.i + 1 >= game.a.t.size()) {
            if (((i)game.a.t.elementAt(this.i)).A() > 0) {
               this.o.a((byte)8);
            } else {
               this.i = 0;
               game.f.B().a((byte)10);
            }

            this.p.a("/data/ui/levelUp.ui");
         } else {
            this.o.a((byte)8);
            this.p.a("/data/ui/levelUp.ui");
         }
      }

      if (this.o.g(196640)) {
         this.J = 0;
         if (this.x != null) {
            this.o.a((byte)23);
            return;
         }

         if (this.i + 1 >= game.a.t.size()) {
            if (((i)game.a.t.elementAt(this.i)).A() > 0) {
               this.o.a((byte)8);
            } else {
               this.i = 0;
               game.f.B().a((byte)10);
            }

            this.p.a("/data/ui/levelUp.ui");
            return;
         }

         this.o.a((byte)8);
         this.p.a("/data/ui/levelUp.ui");
      }
   }

   public final void as() {
      this.p.a("/data/ui/choiceskill.ui", 257, this);
      this.p.a("/data/ui/levelUp.ui");
      this.b = 0;
      this.f = 0;
      ((c.b)this.p.a.a(0)).a.a = this.x.length;
      if (this.x.length > 5) {
         ((c.b)this.p.a.a(0)).a.a(1);
      } else {
         ((c.b)this.p.a.a(0)).a.a(-1);
      }

      if (this.p.a.a(5).i().m == null) {
         this.p.a.a(5).i().m = new c.g();
         this.p.a.a(5).i().m.a = 3;
         this.p.a.a(5).i().m.a(0);
         this.p.a.a(5).i().m.a(257, false, (byte)-1);
      }

      this.p.a.a(5).i().m.a((byte)11, (byte)-1);
      this.p.a.a(6).a(false);
      this.by();
      if (!game.l.N) {
         this.b("Có thể nhấn #1nút mềm trái#0 để học tập kỹ năng");
         game.l.N = true;
      }
   }

   private void by() {
      this.v = ((c.b)this.p.a.a(0)).a.e;
      this.h = ((c.b)this.p.a.a(0)).a.f;

      for (int var1 = 0; var1 < 5; var1++) {
         if (var1 >= this.x.length) {
            this.p.a.a(13 + var1 * 5).i().a = "";
            this.p.a.a(14 + var1 * 5).i().a = "";
         } else {
            this.p.a.a(13 + var1 * 5).i().a = a.a.c(a.b.c.c[1][this.x[this.v + var1]][1]);
            this.p.a.a(14 + var1 * 5).i().a = "" + a.b.c.c[1][this.x[this.v + var1]][5];
         }
      }

      this.i(this.x[this.h]);
      this.p.a.a(51).b(98 + this.h * 62 / this.x.length, this.p.a.a());
   }

   public final void at() {
      if (!this.j() && this.o.g(4100) && this.f == 0) {
         this.p.a.b(0);
         this.by();
      } else if (!this.j() && this.o.g(8448) && this.f == 0) {
         this.p.a.b(1);
         this.by();
      } else if (!this.j() && this.f == 0 && (this.o.g(131072) || this.o.a(40, 228, 45, 20)) || this.f == 1 && this.o.g(196640)) {
         if (this.f == 0) {
            this.f = 1;
            this.p.a("/data/ui/msgwarm.ui", 257, this);
            this.a("Học tập" + a.a.c(a.b.c.c[1][this.x[this.b]][1]), "Nhấn nút 5 tiếp tục");
         } else if (this.f == 1) {
            i var1;
            (var1 = (i)game.a.t.elementAt(this.i)).g((byte)this.x[this.h]);
            this.x = null;
            if (this.i + 1 >= game.a.t.size() && var1.A() <= 0) {
               this.i = 0;
               game.f.B().a((byte)10);
            } else {
               this.o.a((byte)8);
            }

            this.p.a("/data/ui/msgwarm.ui");
            this.p.a("/data/ui/choiceskill.ui");
         }
      }

      this.f();
   }

   public final void au() {
      this.f = 0;
      this.b("Ba lô sủng vật đều thăng 5 cấp");
   }

   public final void av() {
      if (this.f == 0) {
         if (this.aA()) {
            this.f = 1;
            if (game.l.O.size() <= 0) {
               this.o.a((byte)14);
            }
         }
      } else if (this.f == 1) {
         this.p.a("/data/ui/bodyShop.ui");
         this.bz();
         this.g = true;
      } else {
         k var1 = this;
         label89:
         if (this.f >= 3) {
            if (var1.f == 5) {
               var1.f = 6;
               var1.K();
               var1.a("Đang lưu...");
               var1.M();
            } else if (var1.f == 6) {
               game.l.Q = 2;
               game.l.F();
               if (((l)var1.o).H()) {
                  var1.a("Lưu thành công");
                  var1.f = 7;
               }
            } else if (var1.f == 7) {
               var1.p.a("/data/ui/msgtip.ui");
               var1.f = 0;
               if (var1.o.b == 14) {
                  var1.o.a((byte)14);
               } else {
                  var1.o.a((byte)0);
               }
               break label89;
            }

            if (!var1.j() && var1.o.g(4100) && var1.f == 3) {
               var1.p.a.b(0);
               var1.by();
            } else if (!var1.j() && var1.o.g(8448) && var1.f == 3) {
               var1.p.a.b(1);
               var1.by();
            } else if (!var1.j() && var1.f == 3 && (var1.o.g(131072) || var1.o.a(40, 228, 45, 20)) || var1.f == 4 && var1.o.g(196640)) {
               if (var1.f == 3) {
                  var1.f = 4;
                  var1.p.a("/data/ui/msgwarm.ui", 257, var1);
                  var1.a("Học tập" + a.a.c(a.b.c.c[1][var1.x[var1.h]][1]), "Nhấn nút 5 tiếp tục");
               } else if (var1.f == 4) {
                  ((i)game.l.O.elementAt(var1.i)).g((byte)var1.x[var1.h]);
                  var1.x = null;
                  var1.i++;
                  if (var1.i >= game.l.O.size()) {
                     var1.i = 0;
                     var1.f = 5;
                  } else {
                     var1.bz();
                  }

                  var1.p.a("/data/ui/msgwarm.ui");
                  var1.p.a("/data/ui/choiceskill.ui");
               }
            }
         } else if (var1.o.g(196640)) {
            k var2 = var1;
            var1.p.a("/data/ui/choiceskill.ui", 257, var2);
            var2.p.a("/data/ui/levelUp.ui");
            var2.b = 0;
            var2.f = 3;
            ((c.b)var2.p.a.a(0)).a.a = var2.x.length;
            if (var2.x.length > 5) {
               ((c.b)var2.p.a.a(0)).a.a(1);
            } else {
               ((c.b)var2.p.a.a(0)).a.a(-1);
            }

            if (var2.p.a.a(5).i().m == null) {
               var2.p.a.a(5).i().m = new c.g();
               var2.p.a.a(5).i().m.a = 3;
               var2.p.a.a(5).i().m.a(0);
               var2.p.a.a(5).i().m.a(257, false, (byte)-1);
            }

            var2.p.a.a(5).i().m.a((byte)11, (byte)-1);
            var2.p.a.a(6).a(false);
            var2.by();
            var1.g = true;
         }
      }

      this.f();
   }

   private void bz() {
      this.f = 2;
      i var1 = (i)game.l.O.elementAt(this.i);
      this.p.a("/data/ui/levelUp.ui", 257, this);

      for (int var2 = 0; var2 < 4; var2++) {
         this.p.a.a(var2 + 19).i().a = "" + var1.i((int)((byte)(var2 + 1 - 1)));
      }

      if (var1.F() < 5 && var1.F() < var1.t() / 10 + 1) {
         this.x = var1.G();
         this.p.a.a(51).i().a = "Nhấn nút 5 học tập kỹ năng mới";
      } else {
         this.p.a.a(51).i().a = "";
      }

      this.p.a.a(38).i().a = a.a.c(a.b.c.c[0][var1.r()][0]);
      this.p.a.a(40).i().a = "" + var1.t();
      if (this.p.a.a(10).i().m == null) {
         this.p.a.a(10).i().m = new c.g();
         this.p.a.a(10).i().m.a = 3;
         this.p.a.a(10).i().m.a(0);
         this.p.a.a(10).i().m.a(var1.D, false, (byte)-1);
      }

      for (int var5 = 0; var5 < 4; var5++) {
         c.i var10000 = this.p.a.a(var5 + 31).i();
         StringBuffer var10001 = new StringBuffer();
         byte var4 = (byte)(var5 + 1);
         var10000.a = var10001.append(var1.d[var4]).toString();
      }
   }

   public final void aw() {
      this.p.a("/data/ui/npcEnemy.ui", 296, this);
      if (this.p.a.a(1).i().m == null) {
         this.p.a.a(1).i().m = new c.g();
         this.p.a.a(1).i().m.a = 2;
         this.p.a.a(1).i().m.a(296, false, (byte)0);
         this.p.a.a(1).i().m.a(0);
      }

      this.p.a.a(36).a(false);
   }

   private void a(int var1, int var2, int var3) {
      if (var3 != -1 && this.p.a.a(var3).i().m != null) {
         this.p.a.a(var3).a(false);
      }

      if (this.p.a.a(var1).i().m == null) {
         this.p.a.a(var1).i().m = new c.g();
         this.p.a.a(var1).i().m.a = 2;
         this.p.a.a(var1).i().m.a(296, false, (byte)0);
         this.p.a.a(var1).i().m.a(0);
      }

      this.p.a.a(var1).i().m.a(var2);
   }

   public final void c(int var1, int var2) {
      switch (var1) {
         case 0:
            this.p.a.a(1).i().m.a(var2);
            return;
         case 1:
            for (int var9 = 2; var9 < 4; var9++) {
               if (this.p.a.a(var9).i().m == null) {
                  this.p.a.a(var9).i().m = new c.g();
                  this.p.a.a(var9).i().m.a = 2;
                  this.p.a.a(var9).i().m.a(0);
               }

               if (var9 % 2 == 1) {
                  this.p.a.a(var9).i().m.a(0, false, (byte)-1);
               } else if (game.l.E == -1) {
                  if (game.l.F == -1) {
                     this.p.a.a(var9).i().m.a(game.l.B().n[8].a.a, false, (byte)-1);
                  } else {
                     this.p.a.a(var9).i().m.a(game.l.B().n[game.l.F].a.a, false, (byte)-1);
                  }
               } else {
                  this.p.a.a(var9).i().m.a(game.l.B().n[game.l.E].a.a, false, (byte)-1);
               }

               this.p.a.a(var9).i().m.a(1);
            }

            this.p.a.a(1).i().m.a(var2);
            return;
         case 2:
            for (int var8 = 2; var8 < 4; var8++) {
               if (this.p.a.a(var8).i().m != null) {
                  this.p.a.a(var8).a(false);
               }

               if (this.p.a.a(var8 + 32).i().m == null) {
                  this.p.a.a(var8 + 32).i().m = new c.g();
                  this.p.a.a(var8 + 32).i().m.a = 2;
                  this.p.a.a(var8 + 32).i().m.a(0);
               }

               if (var8 % 2 == 1) {
                  this.p.a.a(var8 + 32).i().m.a(0, false, (byte)-1);
               } else if (game.l.E == -1) {
                  if (game.l.F == -1) {
                     this.p.a.a(var8 + 32).i().m.a(game.l.B().n[8].a.a, false, (byte)-1);
                  } else {
                     this.p.a.a(var8 + 32).i().m.a(game.l.B().n[game.l.F].a.a, false, (byte)-1);
                  }
               } else {
                  this.p.a.a(var8 + 32).i().m.a(game.l.B().n[game.l.E].a.a, false, (byte)-1);
               }

               this.p.a.a(var8 + 32).i().m.a(1);
            }

            this.p.a.a(1).i().m.a(var2);
            return;
         case 3:
            for (int var7 = 2; var7 < 4; var7++) {
               if (this.p.a.a(var7 + 32).i().m != null) {
                  this.p.a.a(var7 + 32).a(false);
               }

               if (this.p.a.a(var7 + 2).i().m == null) {
                  this.p.a.a(var7 + 2).i().m = new c.g();
                  this.p.a.a(var7 + 2).i().m.a = 2;
                  this.p.a.a(var7 + 2).i().m.a(0);
               }

               if (var7 % 2 == 1) {
                  this.p.a.a(var7 + 2).i().m.a(0, false, (byte)-1);
               } else if (game.l.E == -1) {
                  if (game.l.F == -1) {
                     this.p.a.a(var7 + 2).i().m.a(game.l.B().n[8].a.a, false, (byte)-1);
                  } else {
                     this.p.a.a(var7 + 2).i().m.a(game.l.B().n[game.l.F].a.a, false, (byte)-1);
                  }
               } else {
                  this.p.a.a(var7 + 2).i().m.a(game.l.B().n[game.l.E].a.a, false, (byte)-1);
               }

               this.p.a.a(var7 + 2).i().m.a(1);
            }

            this.p.a.a(1).i().m.a(var2);
            this.K = game.a.B().H();
            this.L = this.q.B;
            if (var2 - 3 < this.K) {
               this.a(6, 6, -1);
            }

            if (var2 - 3 < this.L) {
               this.a(18, 6, -1);
               return;
            }
            break;
         case 4:
            if (var2 - 3 < this.K) {
               this.a(6 + (var2 - 3 << 1), 6, 6 + (var2 - 4 << 1));
            } else {
               this.a(6 + (var2 - 3 << 1), 5, 6 + (var2 - 4 << 1));
            }

            if (var2 - 4 < this.K) {
               this.a(7 + (var2 - 4 << 1), 6, 6 + (var2 - 4 << 1));
            } else {
               this.a(7 + (var2 - 4 << 1), 5, 6 + (var2 - 4 << 1));
            }

            if (var2 - 4 < this.L) {
               this.a(19 + (var2 - 4 << 1), 6, 18 + (var2 - 4 << 1));
            } else {
               this.a(19 + (var2 - 4 << 1), 5, 18 + (var2 - 4 << 1));
            }

            if (var2 - 3 < this.L) {
               this.a(18 + (var2 - 3 << 1), 6, 18 + (var2 - 4 << 1));
               return;
            }

            this.a(18 + (var2 - 3 << 1), 5, 18 + (var2 - 4 << 1));
            return;
         case 5:
            if (var2 - 4 < this.K) {
               this.a(7 + (var2 - 4 << 1), 6, 6 + (var2 - 4 << 1));
            } else {
               this.a(7 + (var2 - 4 << 1), 5, 6 + (var2 - 4 << 1));
            }

            if (var2 - 4 < this.L) {
               this.a(19 + (var2 - 4 << 1), 6, 18 + (var2 - 4 << 1));
               return;
            }

            this.a(19 + (var2 - 4 << 1), 5, 18 + (var2 - 4 << 1));
            return;
         case 6:
            this.a(30, 8, -1);
            this.a(31, 7, -1);
            return;
         case 7:
            this.a(32, 8, 30);
            this.a(33, 7, 31);
            return;
         case 8:
            this.p.a.a(36).a(true);
            return;
         case 9:
            this.p.a.a(36).a(false);
            return;
         case 10:
            this.a(1, 4, 32);
            this.a(1, 4, 33);

            for (int var5 = 4; var5 < 6; var5++) {
               this.p.a.a(var5).a(false);
            }

            for (byte var6 = 7; var6 < 19; var6 += 2) {
               this.p.a.a(var6).a(172 + 17 * (var6 - 7) / 2, this.p.a.a());
               this.p.a.a(var6 + 12).a(-30 + 17 * (var6 - 7) / 2, this.p.a.a());
            }

            return;
         case 11:
            for (int var3 = 4; var3 < 6; var3++) {
               this.p.a.a(var3).a(false);
            }

            for (byte var4 = 7; var4 < 19; var4 += 2) {
               this.p.a.a(var4).a(false);
               this.p.a.a(var4 + 12).a(false);
            }

            this.a(1, 0, -1);
      }
   }

   private void e(String var1) {
      if (this.p.a.a(1).i().m == null) {
         this.p.a.a(1).i().m = new c.g();
         this.p.a.a(1).i().m.a(0);
         this.p.a.a(1).i().m.a = 3;
         this.p.a.a(1).i().m.a(257, false, (byte)-2);
      }

      this.p.a.a(1).i().m.a((byte)9, (byte)-2);
      this.p.a.a(2).i().a = var1;
      this.u = 0;
   }

   public final void ax() {
      this.p.a("/data/ui/openbox.ui", 257, this);
      this.e("Không có cái chìa khóa, có thể đến tài liệu cửa hàng mua sắm");
   }

   public final void ay() {
      this.p.a("/data/ui/openbox.ui", 257, this);
      this.e("Đạo cụ đã đủ");
   }

   public final void a(String var1, int var2) {
      this.p.a("/data/ui/openbox.ui", 257, this);
      this.e(var1 + " x " + var2);
   }

   public final void b(String var1) {
      this.p.a("/data/ui/openbox.ui", 257, this);
      this.e(var1);
   }

   public final void az() {
      if (this.p.b("/data/ui/openbox.ui")) {
         this.p.a("/data/ui/openbox.ui");
      }
   }

   public final boolean aA() {
      return !this.p.b("/data/ui/openbox.ui");
   }

   public final void c(String var1) {
      this.p.a("/data/ui/taskTip.ui", 257, this);
      String var2 = var1;
      k var3 = this;
      if (this.p.a.a(1).i().m == null) {
         var3.p.a.a(1).i().m = new c.g();
         var3.p.a.a(1).i().m.a(0);
         var3.p.a.a(1).i().m.a = 3;
         var3.p.a.a(1).i().m.a(257, false, (byte)-2);
      }

      var3.p.a.a(1).i().m.a((byte)10, (byte)-2);
      var3.p.a.a(2).i().a = var2;
      var3.u = 0;
   }

   public final boolean aB() {
      return !this.p.b("/data/ui/taskTip.ui");
   }

   public final void aC() {
      this.c = 0;
      this.f = 0;
      this.p.a("/data/ui/bodyShop.ui", 257, this);
      this.bA();
   }

   private void bA() {
      String var1 = "";
      switch (this.c) {
         case 0:
            var1 = "Tùy thời mua sắm các loại đạo cụ, già trẻ không gạt.";
            break;
         case 1:
            int[] var4 = new int[]{2, 1, 2};
            var1 = a.a.c(602) + a.a.a(604, var4);
            break;
         case 2:
            int[] var3 = new int[]{2, 1, 2};
            var1 = a.a.c(603) + a.a.a(604, var3);
            break;
         case 3:
            int[] var2 = new int[]{2, 1, 2};
            var1 = a.a.c(601) + a.a.a(604, var2);
      }

      this.p.a.a(11).i().a = var1;
      if (this.c > 0) {
         this.o.c((byte)0);
         this.bB();
      }
   }

   private void bB() {
      switch (this.c) {
         case 1:
            this.o.b((byte)3);
            return;
         case 2:
            this.o.b((byte)4);
            return;
         case 3:
            this.o.b((byte)2);
      }
   }

   public final void aD() {
      switch (this.c) {
         case 0:
            if (this.o.g(4100) && this.f == 0) {
               this.p.a.b(0);
               this.bA();
               return;
            }

            if (this.o.g(8448) && this.f == 0) {
               this.p.a.b(1);
               this.bA();
               return;
            }

            if (this.o.g(196640)) {
               this.o.a((byte)26);
               this.p.a("/data/ui/bodyShop.ui");
               return;
            }

            if (this.o.g(786432)) {
               this.b = 0;
               this.o.a((byte)6);
               this.p.a("/data/ui/bodyShop.ui");
               return;
            }
            break;
         default:
            switch (this.o.x()) {
               case 0:
                  if (this.o.g(4100) && this.f == 0) {
                     this.p.a.b(0);
                     this.bA();
                     return;
                  }

                  if (this.o.g(8448) && this.f == 0) {
                     this.p.a.b(1);
                     this.bA();
                     return;
                  }

                  if (this.f == 0 && this.o.g(131072) || this.f == 1 && this.o.g(65568)) {
                     if (this.f != 0) {
                        this.f = 0;
                        this.p.a("/data/ui/msgwarm.ui");
                        return;
                     }

                     this.bB();
                     if (this.o.v() == 3) {
                        if (game.l.R != null) {
                           game.l.R.removeAllElements();
                        }

                        int var1 = 0;

                        while (var1 < game.j.p().B && game.j.p().A[var1].t() >= 50) {
                           var1++;
                        }

                        if (var1 >= game.j.p().B) {
                           this.f = 1;
                           this.p.a("/data/ui/msgwarm.ui", 257, this);
                           this.a("Trong ba lô sủng vật đều đã max level", "Nhấn nút 5 tiếp tục");
                           return;
                        }
                     }

                     if (this.o.y() > 1) {
                        this.o.c((byte)1);
                        return;
                     }

                     if (this.p.a.a(11).i().b()) {
                        this.o.e(1);
                        return;
                     }
                  } else if (this.o.g(786432) && this.f == 0) {
                     this.b = 0;
                     this.o.a((byte)6);
                     this.p.a("/data/ui/bodyShop.ui");
                     return;
                  }
                  break;
               case 1:
                  if (this.o.g(131072)) {
                     this.o.f(1);
                     return;
                  }

                  if (this.o.g(262144)) {
                     this.o.f(2);
                     return;
                  }
                  break;
               case 2:
                  if (this.bC() && this.o.g(917504)) {
                     if (this.o.w()) {
                        if (this.o.v() == 3) {
                           this.o.a((byte)25);
                        }

                        this.o.c((byte)5);
                     } else {
                        this.o.c((byte)1);
                     }

                     this.f = 0;
                     return;
                  }
                  break;
               case 3:
                  if (this.o.g(393216)) {
                     this.o.f(1);
                  }
            }
      }
   }

   private boolean bC() {
      if (this.f == 0) {
         this.f = 1;
         this.K();
         this.a("Đang lưu...");
         this.M();
      } else if (this.f == 1) {
         if (this.o.v() == 3) {
            if (game.l.B().I()) {
               this.a("Lưu thành công");
               this.f = 2;
            }
         } else if (game.l.B().J()) {
            this.a("Lưu thành công");
            this.f = 2;
         }
      } else if (this.f == 2) {
         this.p.a("/data/ui/msgtip.ui");
         this.f = 3;
      } else if (this.f == 3) {
         return true;
      }

      return false;
   }

   public final void aE() {
      this.p.a("/data/ui/dialog.ui", 257, this);
      this.p.a.a(12).a(false);
      this.p.a.a(13).a(false);
   }

   public final void a(String var1, String var2, int var3, int var4) {
      this.p.a("/data/ui/dialog.ui", 257, this);
      a.e.a(var2, a.a.o(), this.p.a.a(14).e(), a.a.m(), true, (byte)-1, this.o.c.b);
      a.e.d(this.p.a.a(14).f());
      this.p.a.a(14).i().a = a.e.e(1);
      game.l.D = (byte)var3;
      game.l.C = (byte)var4;
      this.p.a.a(8).a(false);
      this.p.a.a(11).a(false);
      this.p.a.a(12).a(true);
      this.p.a.a(13).a(true);
      if (var3 == -1) {
         this.p.a.a(12).a(false);
         this.p.a.a(13).a(false);
      }

      switch (var3) {
         case 0:
            if (var4 != -1) {
               if (this.p.a.a(11).i().m == null) {
                  this.p.a.a(11).i().m = new c.g();
                  this.p.a.a(11).i().m.a = 3;
                  this.p.a.a(11).i().m.a(0);
                  this.p.a.a(11).i().m.a(323, false, (byte)-2);
               }

               this.p.a.a(11).a(true);
               this.p.a.a(11).i().m.a((byte)(var3 + (var4 << 1)), (byte)-2);
            }

            this.p.a.a(13).a(false);
            this.p.a.a(12).i().a = var1;
            return;
         case 1:
            if (var4 != -1) {
               if (this.p.a.a(8).i().m == null) {
                  this.p.a.a(8).i().m = new c.g();
                  this.p.a.a(8).i().m.a = 3;
                  this.p.a.a(8).i().m.a(0);
                  this.p.a.a(8).i().m.a(323, false, (byte)-2);
               }

               this.p.a.a(8).a(true);
               this.p.a.a(8).i().m.a((byte)(var3 + (var4 << 1)), (byte)-2);
            }

            this.p.a.a(12).a(false);
            this.p.a.a(13).i().a = var1;
      }
   }

   public final void b(int var1) {
      this.p.a.a(14).i().a = a.e.e(var1);
   }

   public final void aF() {
      this.p.a("/data/ui/dialog.ui");
   }

   public final boolean d(int var1, int var2) {
      if (var2 == -1) {
         return true;
      }

      switch (var1) {
         case 0:
            if (this.p.a.a(11).i().m.a().f()) {
               return true;
            }
            break;
         case 1:
            if (this.p.a.a(8).i().m.a().f()) {
               return true;
            }
      }

      this.g = true;
      return false;
   }

   public final void a(int var1, int var2, String[] var3, String var4) {
      this.b = 0;
      this.p.a(this.M[var1], 257, this);
      ((c.b)this.p.a.a(0)).a.a = var2;
      switch (var1) {
         case 0:
            for (int var7 = 0; var7 < var3.length; var7++) {
               this.p.a.a(var7 + 12).i().a = var3[var7];
            }

            return;
         case 1:
            this.p.a.a(5).i().a = var4;

            for (int var6 = 0; var6 < var3.length; var6++) {
               this.p.a.a(9 + (var6 << 2)).i().a = var3[var6];
            }

            return;
         case 2:
            this.p.a.a(10).a(false);
            this.p.a.a(8).i().a = "Trò chơi";
            this.p.a.a(9).i().a = "Xác nhận";

            for (int var5 = 0; var5 < var3.length; var5++) {
               this.p.a.a(var5 + 5).i().a = var3[var5];
            }
      }
   }

   public final int c(int var1) {
      if (this.o.g(4100)) {
         this.p.a.b(0);
         this.b = this.y[0];
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
         this.b = this.y[0];
      } else if (this.o.g(196640)) {
         int var2 = var1;
         k var3 = this;
         this.p.a(var3.M[var2]);
         return this.b;
      }

      return -1;
   }

   public final void a(int[] var1, int[] var2, String[] var3, String[] var4) {
      this.b = 0;
      this.p.a("/data/ui/taskOption.ui", 257, this);

      for (int var5 = 0; var5 < var4.length; var5++) {
         this.p.a.a(var5 + 17).i().a = var4[var5];
      }

      for (int var6 = 0; var6 < var1.length; var6++) {
         if (this.p.a.a((var6 << 1) + 13).i().m == null) {
            this.p.a.a((var6 << 1) + 13).i().m = new c.g();
            this.p.a.a((var6 << 1) + 13).i().m.a = 2;
            if (var1[var6] >= 3 && var1[var6] < 5) {
               this.p.a.a((var6 << 1) + 13).i().m.a(-1);
               this.p.a.a((var6 << 1) + 13).i().m.a(257, false, (byte)0);
            } else {
               this.p.a.a((var6 << 1) + 13).i().m.a(0);
               this.p.a.a((var6 << 1) + 13).i().m.a(258, false, (byte)0);
            }
         }

         switch (var1[var6]) {
            case 0:
               this.p.a.a((var6 << 1) + 13).i().m.a(a.b.c.c[4][var2[var6]][1]);
               this.p.a.a((var6 << 1) + 14).i().a = var3[var6];
               break;
            case 1:
               this.p.a.a((var6 << 1) + 13).i().m.a(a.b.c.c[3][var2[var6]][1]);
               this.p.a.a((var6 << 1) + 14).i().a = var3[var6];
               break;
            case 2:
               this.p.a.a((var6 << 1) + 13).i().m.a(a.b.c.c[5][var2[var6]][1]);
               this.p.a.a((var6 << 1) + 14).i().a = var3[var6];
               break;
            case 3:
               this.p.a.a((var6 << 1) + 13).i().m.a(84);
               this.p.a.a((var6 << 1) + 14).i().a = var3[var6];
               break;
            case 4:
               this.p.a.a((var6 << 1) + 13).i().m.a(83);
               this.p.a.a((var6 << 1) + 14).i().a = var3[var6];
            case 5:
            default:
               break;
            case 6:
               this.p.a.a(21).i().a = "#2" + a.a.c(a.b.c.a((byte)0, (short)var2[var6], (byte)0)) + " #0" + var3[var6];
         }
      }
   }

   public final int aG() {
      if (this.o.g(4100)) {
         this.p.a.b(0);
         this.b = this.y[0];
      } else if (this.o.g(8448)) {
         this.p.a.b(1);
         this.b = this.y[0];
      } else {
         if (this.o.g(196640)) {
            this.p.a("/data/ui/taskOption.ui");
            return this.b;
         }

         if (this.o.g(262144)) {
            this.p.a("/data/ui/taskOption.ui");
            return 1;
         }
      }

      return -1;
   }

   public final void aH() {
      this.bE();
      this.c("Có dùng 10000 kim tiền để khôi phục trạng thái của tất cả sủng vật trong ba lô không?", "Tại chỗ sống lại");
   }

   private void bD() {
      byte var1 = -1;
      if (game.l.B().p == 9) {
         var1 = (byte)game.l.B().q;
      }

      if (var1 == -1) {
         game.l.B();
         if (game.l.G()) {
            game.l.B().c();
            this.q.z = false;
            game.f.B().a((byte)9);
         } else {
            game.f.B().a((byte)7);
         }
      } else {
         for (int var2 = 0; var2 < this.q.B; var2++) {
            this.q.A[var2].l(1);
            this.q.A[var2].u(1);
            this.q.A[var2].c();
         }

         game.l.E = -1;
         if (game.l.B().q == 0) {
            short[] var5 = new short[]{15, 194, 433, 16, 142, 357, 17, 97, 268, 18, 183, 224};

            for (int var3 = 0; var3 < game.l.B().n.length; var3++) {
               for (int var4 = 0; var4 < var5.length / 3; var4++) {
                  if (game.l.B().n[var3].J == var5[var4 * 3]) {
                     game.l.B().n[var3].b(var5[var4 * 3 + 1], var5[var4 * 3 + 2]);
                  }
               }
            }
         }

         game.l.B().p = this.m[var1 << 2];
         game.l.B().q = this.m[(var1 << 2) + 1];
         game.j.p().b(this.m[(var1 << 2) + 2], this.m[(var1 << 2) + 3]);
         short var10001 = this.m[(var1 << 2) + 2];
         game.j.p().b.b(var10001, this.m[(var1 << 2) + 3]);
         j var10000 = game.j.p();
         byte var6 = 2;
         var10000.o = var6;
         game.f.B().a((byte)10);
      }
   }

   public final void aI() {
      if (!this.o.g(196640)) {
         if (this.f == 0 && this.o.g(786432)) {
            this.bD();
            this.bF();
         }
      } else if (this.f == 0) {
         if (!this.q.u(10000)) {
            this.H();
            this.a("Kim tiền chưa đủ", "Nhấn nút 5 tiếp tục");
            this.f = 1;
         } else {
            this.q.s(-10000);

            for (int var4 = 0; var4 < this.q.B; var4++) {
               this.q.A[var4].J();
               i var10000 = this.q.A[var4];
               i var10001 = this.q.A[var4];
               byte var3 = 1;
               var10000.u(var10001.e[var3]);
            }

            game.a.B().C();
            this.o.a((byte)0);
            this.bF();
         }
      } else {
         for (int var1 = 0; var1 < this.q.B; var1++) {
            this.q.A[var1].l(1);
            this.q.A[var1].u(1);
            this.q.A[var1].c();
         }

         if (a.a.i) {
            this.o.a((byte)102);
         } else {
            this.bD();
         }

         this.I();
      }
   }

   public final void d(int var1) {
      this.o.b((byte)0);
      this.o.c((byte)0);
      this.bE();
      int[] var2 = new int[]{4, 1, 4};
      String var3 = a.a.c(599) + a.a.a(604, var2);
      this.c(var3, "Kích hoạt trò chơi");
   }

   public final void aJ() {
      this.o.b((byte)1);
      this.o.c((byte)0);
      this.bE();
      int[] var1 = new int[]{2, 1, 2};
      String var2 = a.a.c(600) + a.a.a(604, var1);
      this.c(var2, "Mua sắm tất trúng cầu");
   }

   public final void aK() {
      this.f = 0;
      this.o.b((byte)4);
      this.o.c((byte)0);
      this.bE();
      int[] var1 = new int[]{2, 1, 2};
      String var2 = a.a.c(603) + a.a.a(604, var1);
      this.c(var2, "Mua huy hiệu");
   }

   public final void aL() {
      this.f = 0;
      this.o.b((byte)2);
      this.o.c((byte)0);
      this.bE();
      int[] var1 = new int[]{2, 1, 2};
      String var2 = a.a.c(601) + a.a.a(604, var1);
      this.c(var2, "Mua kim tiền");
   }

   private void bE() {
      this.p.a("/data/ui/smsInfo.ui", 257, this);
      if (this.o instanceof l) {
         this.p.a.a(6).a(true);
         this.p.a.a(7).a(true);
         this.p.a.a(10).a(false);
         this.p.a.a(11).a(false);
      } else {
         this.p.a.a(6).a(false);
         this.p.a.a(7).a(false);
         this.p.a.a(10).a(true);
         this.p.a.a(11).a(true);
         this.p.a.a(10).i().a = "Xác nhận";
         this.p.a.a(11).i().a = "Quay lại";
      }
   }

   private void c(String var1, String var2) {
      this.p.a.a(8).i().a = var1;
      this.p.a.a(5).i().a = var2;
   }

   private void bF() {
      this.p.a("/data/ui/smsInfo.ui");
   }

   public final void aM() {
      if (!this.p.c("/data/ui/smsTip.ui")) {
         this.p.a("/data/ui/smsTip.ui", 257, this);
      }

      for (int var1 = 0; var1 < 3; var1++) {
         this.p.a.a(var1 + 6).a(false);
      }

      this.g = true;
   }

   public final void d(String var1) {
      this.g = true;
      this.p.a.a(5).i().a = var1;
   }

   public final void aN() {
      this.p.a("/data/ui/smsTip.ui");
   }

   public final void aO() {
      switch (this.o.x()) {
         case 0:
            if (!this.o.g(16400) && !this.o.g(32832)) {
               if (this.o.g(131072)) {
                  if (this.o.y() > 1) {
                     this.o.c((byte)1);
                     return;
                  }

                  this.o.e(1);
                  return;
               }

               if (this.o.g(786432)) {
                  this.bF();
                  this.o.c((byte)5);
                  this.o.a(this.o.b);
                  return;
               }
            }
            break;
         case 1:
            if (this.o.g(131072)) {
               this.o.f(1);
               return;
            }

            if (this.o.g(262144)) {
               this.o.f(2);
               return;
            }
            break;
         case 2:
            boolean var1 = false;
            if (this.o.a != 100) {
               var1 = true;
            } else {
               if (this.w >= this.N.length && this.aA()) {
                  var1 = true;
               } else if (this.aA()) {
                  this.b(this.N[this.w]);
                  this.w++;
               }

               this.f();
            }

            if (var1 && this.bC() && this.o.g(917504)) {
               this.w = 0;
               if (this.o.w()) {
                  this.bF();
                  this.aN();
                  this.o.a(this.o.b);
               } else {
                  this.o.c((byte)5);
               }

               this.f = 0;
               return;
            }
            break;
         case 3:
            if (this.o.g(393216)) {
               this.o.f(1);
            }
      }
   }

   public final void a(byte var1, int var2, int var3) {
      this.c = 0;
      this.Q = var1;
      this.R = (byte)var2;
      switch (var2) {
         case 0:
            this.p.a("/data/ui/wharf1.ui", 257, this);
            this.p.a.a(8).i().a = a.a.c(var3);

            for (int var5 = 0; var5 < this.O[var1].length; var5++) {
               this.p.a.a(var5 + 5).i().a = a.a.c(this.O[var1][var5]);
            }
            break;
         case 1:
            this.p.a("/data/ui/wharf2.ui", 257, this);
            this.p.a.a(10).i().a = a.a.c(var3);

            for (int var4 = 0; var4 < this.O[var1].length; var4++) {
               this.p.a.a(var4 + 5).i().a = a.a.c(this.O[var1][var4]);
            }
      }

      this.p.a.a(5 + this.O[var1].length).i().a = "Không ra hàng";
   }

   public final void aP() {
      if (this.o.g(4100) && !this.j()) {
         this.p.a.b(0);
      } else if (this.o.g(8448) && !this.j()) {
         this.p.a.b(1);
      } else if (this.o.g(196640) && !this.j()) {
         if (this.c == this.P[this.Q].length / 9) {
            switch (this.R) {
               case 0:
                  this.p.a("/data/ui/wharf1.ui");
                  break;
               case 1:
                  this.p.a("/data/ui/wharf2.ui");
            }

            if (game.l.E != -1 && game.l.B().n[game.l.E].v() == 0) {
               game.l.B().a((byte)13, game.l.B().n[game.l.E].j, game.l.B().n[game.l.E].k - 40, game.l.B().n[game.l.E]);
            }

            this.o.a((byte)0);
         } else {
            label56: {
               short var10001 = this.P[this.Q][this.c * 9 + 6];
               short[] var10002 = this.P[this.Q];
               if (game.l.B().Z.n[game.l.e(var10001, var10002[this.c * 9 + 7])] != null) {
                  var10001 = this.P[this.Q][this.c * 9 + 6];
                  var10002 = this.P[this.Q];
                  if (game.l.B().Z.n[game.l.e(var10001, var10002[this.c * 9 + 7])][this.P[this.Q][this.c * 9 + 8]] == 3) {
                     game.l.B().p = this.P[this.Q][this.c * 9];
                     game.l.B().q = this.P[this.Q][this.c * 9 + 1];
                     game.l.B().r = this.P[this.Q][this.c * 9 + 2];
                     game.l.B().s = this.P[this.Q][this.c * 9 + 3];
                     game.l.G = (byte)this.P[this.Q][this.c * 9 + 4];
                     game.l.B().t = -1;
                     game.b.B().d((byte)this.P[this.Q][this.c * 9 + 5]);
                     this.o.a((byte)29);
                     switch (this.R) {
                        case 0:
                           this.p.a("/data/ui/wharf1.ui");
                           break label56;
                        case 1:
                           this.p.a("/data/ui/wharf2.ui");
                        default:
                           break label56;
                     }
                  }
               }

               this.b("Đường thủy chưa mở");
            }
         }
      } else if (this.o.g(262144) && !this.j()) {
         if (game.l.E != -1 && game.l.B().n[game.l.E].v() == 0) {
            game.l.B().a((byte)13, game.l.B().n[game.l.E].j, game.l.B().n[game.l.E].k - 40, game.l.B().n[game.l.E]);
         }

         switch (this.R) {
            case 0:
               this.p.a("/data/ui/wharf1.ui");
               break;
            case 1:
               this.p.a("/data/ui/wharf2.ui");
         }

         this.o.a((byte)0);
      }

      this.f();
   }

   public final void aQ() {
      this.b = 0;
      this.p.a("/data/ui/shopbuy.ui", 257, this);
      this.b = 0;
      this.f = 0;
      ((c.b)this.p.a.a(0)).a.a = 1;
      ((c.b)this.p.a.a(0)).a.a(0);
      this.p.a.a(41).a(false);
      this.p.a.a(43).a(false);
      this.p.a.a(5).i().a = "Mua";
      this.p.a.a(57).a(true);
      this.p.a.a(58).a(true);
      this.p.a.a(57).i().a = "Mua sắm";
      this.p.a.a(58).i().a = "Quay lại";
      this.p.a.a(39).a(false);
      this.p.a.a(40).a(false);
      k var1 = this;
      this.v = ((c.b)var1.p.a.a(0)).a.e;
      var1.h = ((c.b)var1.p.a.a(0)).a.f;
      if (var1.p.a.a(51).i().m == null) {
         var1.p.a.a(51).i().m = new c.g();
         var1.p.a.a(51).i().m.a(0);
         var1.p.a.a(51).i().m.a = 2;
         var1.p.a.a(51).i().m.a(258, false, (byte)-1);
      }

      var1.p.a.a(51).i().m.a(a.b.c.c[5][0][1]);
      var1.p.a.a(14).i().a = a.a.c(a.b.c.c[5][0][0]);
      var1.p.a.a(15).i().a = "5000";
      var1.p.a.a(45).i().m.a(84);
      var1.p.a.a(56).i().a = "Ấp trứng ra sủng vật";
      var1.p.a.a(44).i().a = "" + var1.q.F();
      var1.p.a.a(38).b(102 + var1.h * 84 / a.b.c.c[5].length, var1.p.a.a());
   }

   private void bG() {
      this.p.a("/data/ui/shopbuy.ui");
   }

   public final int aR() {
      if (this.o.g(196640)) {
         if (this.f == 0) {
            if (this.q.u(5000)) {
               if (this.q.l(0)) {
                  this.H();
                  this.a("Đã có trứng sủng vật, không cần mua sắm", "Nhấn nút 5 tiếp tục");
                  this.f = 2;
               } else {
                  this.q.e(0, -1);
                  this.H();
                  this.a("Đã thành công mua sắm #2 trứng sủng vật", "Nhấn nút 5 tiếp tục");
                  this.f = 2;
               }
            } else {
               this.H();
               this.a("Kim tiền chưa đủ", "Nhấn nút 5 tiếp tục");
               this.f = 1;
            }
         } else if (this.f > 0) {
            this.I();
            if (this.f == 1) {
               this.o.a((byte)102);
            } else if (this.f == 2) {
               game.e.z = 0;
               this.bG();
               this.o.a((byte)0);
            }
         }
      } else if (this.o.g(262144) && this.f == 0) {
         game.e.z = 1;
         this.bG();
         this.o.a((byte)0);
      }

      return -1;
   }

   public final void aS() {
      this.p.a("/data/ui/wharf2.ui", 257, this);
      ((c.b)this.p.a.a(0)).a.f = this.d;
      this.f = 0;
      this.p.a.a(10).i().a = "Tiện lợi điếm";
      this.p.a.a(12).i().a = "Tiến vào";

      for (int var1 = 0; var1 < this.S.length; var1++) {
         this.p.a.a(var1 + 5).i().a = this.S[var1];
      }
   }

   public final void aT() {
      if (this.o.g(4100) && !this.j()) {
         this.p.a.b(0);
      } else if (this.o.g(8448) && !this.j()) {
         this.p.a.b(1);
      } else if (this.o.g(196640) && !this.j()) {
         if (this.f == 0) {
            switch (this.d) {
               case 0:
                  this.p.a("/data/ui/wharf2.ui");
                  this.o.a((byte)31);
                  return;
               case 1:
               case 2:
                  game.l.B();
                  if (game.l.U) {
                     this.p.a("/data/ui/wharf2.ui");
                     this.c = 0;
                     this.o.a((byte)7);
                     return;
                  }

                  this.H();
                  this.f = 1;
                  this.a("Công năng theo đạo học sau mở ra", "Nhấn nút 5 tiếp tục");
                  return;
               case 3:
                  this.p.a("/data/ui/wharf2.ui");
                  this.o.a((byte)32);
                  return;
               case 4:
                  this.p.a("/data/ui/wharf2.ui");
                  this.o.a((byte)0);
            }
         } else {
            this.f = 0;
            this.I();
            this.g = true;
         }
      } else {
         if (this.o.g(262144) && this.f == 0 && !this.j()) {
            this.p.a("/data/ui/wharf2.ui");
            this.o.a((byte)0);
         }
      }
   }

   public final void a(int[] var1, int[] var2) {
      this.y = var1;
      if (this.o instanceof l) {
         switch (((l)this.o).a) {
            case 0:
               return;
            case 1:
               int[] var26 = var1;
               this.b = var26[0];
               return;
            case 2:
            case 26:
            case 32:
               this.c(var1);
               return;
            case 3:
               int[] var25 = var1;
               k var9 = this;
               if (this.f != 0) {
                  var9.r = var25[0];
                  return;
               }

               var9.b = var25[0];
               var9.aZ();
               break;
            case 4:
               return;
            case 5:
               int[] var24 = var1;
               k var8 = this;
               this.b = var24[1];
               var8.bv();
               return;
            case 6:
               int[] var23 = var1;
               k var7 = this;
               this.b = var23[0];
               if (!a.a.i) {
                  var7.p.a.a(14).i().a = a.a.c(606 + var7.b);
                  return;
               }

               var7.p.a.a(14).i().a = a.a.c(605 + var7.b);
               break;
            case 7:
               this.b(var1);
               return;
            case 8:
               int[] var22 = var1;
               k var6 = this;
               if (var22[0] >= 0) {
                  var6.c = var22[0];
               }

               if (var22[1] >= 0) {
                  var6.b = var22[1];
               }

               var6.br();
               return;
            case 9:
               int[] var21 = var1;
               this.c = var21[1];
               return;
            case 10:
               int[] var20 = var1;
               k var5 = this;
               this.b = var20[1];
               switch (var5.b) {
                  case 0:
                     var5.c = var20[0];
                     return;
                  case 1:
                     var5.r = var20[0];
                  default:
                     return;
               }
            case 11:
               int[] var19 = var1;
               k var4 = this;
               this.c = var19[0];
               var4.b = var19[1];
               return;
            case 12:
               int[] var18 = var1;
               this.b = var18[1];
               return;
            case 13:
               if (this.f == 0) {
                  this.b = var1[0];
                  return;
               }

               this.c = var1[0];
               return;
            case 14:
               int[] var17 = var1;
               this.c = var17[0];
               return;
            case 15:
               int[] var16 = var1;
               this.c = var16[0];
               return;
            case 16:
               int[] var15 = var1;
               this.b = var15[0];
               return;
            case 17:
            case 18:
            case 19:
               int[] var14 = var1;
               this.c = var14[0];
               return;
            case 20:
               this.c = var1[1];
               return;
            case 24:
               int[] var13 = var1;
               this.c = var13[0];
               return;
            case 27:
               this.d = var1[0];
            case 21:
            case 22:
            case 23:
            case 25:
            case 29:
            case 30:
            case 31:
            default:
               return;
            case 28:
               int[] var3 = var1;
               this.c = var3[0];
               return;
         }
      } else if (this.o instanceof game.a) {
         switch (((game.a)this.o).a) {
            case 2:
               return;
            case 3:
               int[] var32 = var1;
               this.e = var32[0];
               return;
            case 4:
               int[] var31 = var1;
               k var12 = this;
               this.b = var31[0];
               var12.bi();
               return;
            case 5:
               this.b(var1);
               return;
            case 6:
               return;
            case 7:
               return;
            case 8:
               return;
            case 9:
               return;
            case 10:
               return;
            case 11:
               this.c(var1);
               return;
            case 12:
               return;
            case 13:
               return;
            case 14:
               return;
            case 15:
               return;
            case 16:
               int[] var30 = var1;
               k var11 = this;
               this.c = var30[0];
               var11.g(var11.c);
               return;
            case 17:
               return;
            case 18:
               return;
            case 19:
               return;
            case 20:
               int[] var29 = var1;
               k var10 = this;
               this.a = var29[1];
               var10.p.a.a(20 + var10.a).a(true);
               return;
            case 21:
               int[] var27 = var1;
               this.b = var27[0];
            case 23:
               int[] var28 = var1;
               this.b = var28[0];
            case 22:
         }
      }
   }

   private void b(int[] var1) {
      if (this.f == 0) {
         this.b = var1[0];
         this.g(this.b);
      } else if (this.f == 1) {
         this.c = var1[0];
      } else {
         if (this.f == 2) {
            this.r = var1[0];
            switch (this.c) {
               case 0:
                  this.bi();
            }
         }
      }
   }

   private void c(int[] var1) {
      if (this.f == 0) {
         this.b = var1[0];
      } else {
         this.r = var1[0];
      }
   }
}
