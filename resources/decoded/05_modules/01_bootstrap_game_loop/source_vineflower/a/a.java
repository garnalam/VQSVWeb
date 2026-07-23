package a;

import c.j;
import game.GameMIDLet;
import game.k;
import game.l;
import game.m;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public abstract class a extends c implements e.a.a.a.b.a, e.b.a.a.a {
   private static short k;
   private static short l;
   private static int m;
   private static Font n;
   private static Font o;
   private static int p;
   public byte a;
   public byte b;
   public j c;
   public k d;
   private static boolean q = false;
   public static boolean e = false;
   public static byte f = -1;
   public static byte g = 0;
   private static byte[][] r = new byte[7][3];
   private static Timer s;
   private static TimerTask t;
   private static boolean u = false;
   public static boolean h;
   public static boolean i = false;
   private byte v;
   private static byte[] w = new byte[]{0, 0, 0, 0, 0};
   private e.b.a.a.b x = null;
   private byte y;
   private byte z;
   private byte A;
   private String[] B = new String[]{"01", "02", "03", "04", "05"};
   private byte[][] C = new byte[][]{{4, 1, 0}, {2, 1, 1}, {2, 1, 2}, {2, 1, 3}, {2, 1, 4}};
   private String[][] D = new String[][]{
      {
            "Kích hoạt trò chơi",
            "Bạn muốn khám phá bí mật của vương quốc sủng vật, dẫn dắt thú yêu chiến đấu, tiến hóa, ấp trứng? Chỉ cần 1 tin nhắn 15000đ để kích hoạt trò chơi, chỉ nhắn tin 1 lần cho tất cả các lượt chơi. Bạn có muốn nhắn tin không?"
      },
      {"Tất trúng cầu", "Chỉ cần nhắn 1 tin nhắn 10000đ, bạn sẽ sở hữu 1 tất trúng cầu, tỷ lệ 100% bắt được sủng vật? Bạn có muốn nhắn tin không?"},
      {"Mua kim tiền", "Kiếm tiền vất vả, vật phẩm đắt đỏ? Chỉ cần nhắn 1 tin nhắn 10000đ bạn sẽ đạt được 10000 kim tiền. Bạn có muốn nhắn tin không?"},
      {
            "Mua đẳng cấp",
            "Thăng cấp chậm chạp, kẻ địch lại quá mạnh? Chỉ cần 1 tin nhắn 10000đ, tất cả sủng vật trong ba lô của bạn đều được thăng lên 5 cấp. Bạn có muốn nhắn tin không?"
      },
      {"Mua huy hiệu", "Kiếm huy hiệu khó khăn? Chỉ cần 1 tin nhắn 10000đ, bạn sẽ đạt được 10 huy hiệu. Bạn có muốn nhắn tin không?"}
   };
   private e.a.a.a.b.b E;

   public abstract void a();

   public abstract void a(Graphics var1);

   public abstract boolean b();

   public abstract void c();

   public abstract void a(byte var1);

   public final void d() {
      if (!q) {
         if (s == null || t == null) {
            s = new Timer();
            t = new a.b();
         }

         s.schedule(t, 10L, 200L);
         q = true;
      }
   }

   protected static void e() {
      if (t != null) {
         t.cancel();
         t = null;
      }

      if (s != null) {
         s.cancel();
         s = null;
         System.gc();
      }

      q = false;
      u = true;
   }

   public static void a(boolean var0) {
      u = false;
   }

   public static boolean f() {
      return u;
   }

   public static void a(short var0, short var1) {
      k = var0;
      l = var1;
   }

   public static short g() {
      return k;
   }

   public static short h() {
      return l;
   }

   public static short i() {
      return (short)(k / 2);
   }

   public static short j() {
      return (short)(l / 2);
   }

   public static void a(int var0) {
      m = 66;
   }

   public static int k() {
      return m;
   }

   public static void b(int var0) {
      p = var0;
   }

   public static int l() {
      return p;
   }

   public static Font m() {
      if (n == null) {
         n = Font.getFont(0, 0, 8);
      }

      return n;
   }

   public static Font n() {
      if (o == null) {
         o = Font.getFont(0, 0, 16);
      }

      return o;
   }

   public static int o() {
      return n.getHeight();
   }

   public static String c(int var0) {
      return var0 == 0 ? "" : a.b.c.d[var0];
   }

   public static String a(int var0, int[] var1) {
      if (var0 == 0) {
         return "";
      }

      int var2 = 0;
      String var3 = "";
      int var4;
      if ((var4 = c(var0).indexOf("%s", 0)) == -1) {
         return c(var0);
      }

      int var5;
      for (var5 = 0; var4 != -1; var4 = c(var0).indexOf("%s", var5)) {
         var3 = var3 + c(var0).substring(var5, var4) + var1[var2];
         var2++;
         var5 = var4 + 2;
      }

      return var3 + c(var0).substring(var5);
   }

   public static String a(String var0, int[] var1) {
      if (var0.equals("")) {
         return "";
      }

      int var2 = 0;
      String var3 = "";
      int var4;
      if ((var4 = var0.indexOf("%s", 0)) == -1) {
         return var0;
      }

      int var5;
      for (var5 = 0; var4 != -1; var4 = var0.indexOf("%s", var5)) {
         var3 = var3 + var0.substring(var5, var4) + var1[var2];
         var2++;
         var5 = var4 + 2;
      }

      return var3 + var0.substring(var5);
   }

   public static String a(int var0, String[] var1) {
      if (var0 == 0) {
         return "";
      }

      int var2 = 0;
      String var3 = "";
      int var4;
      if ((var4 = c(var0).indexOf("%s", 0)) == -1) {
         return c(var0);
      }

      int var5;
      for (var5 = 0; var4 != -1; var4 = c(var0).indexOf("%s", var5)) {
         var3 = var3 + c(var0).substring(var5, var4) + var1[var2];
         var2++;
         var5 = var4 + 2;
      }

      return var3 + c(var0).substring(var5);
   }

   public static void a(Graphics var0, Image var1, String var2, int var3, int var4, int var5, int var6, int var7) {
      for (int var9 = 0; var9 < var2.length(); var9++) {
         char var8;
         if (Character.isDigit(var8 = var2.charAt(var9))) {
            var8 = (char)(var8 - '0');
         } else {
            switch (var8) {
               case '+':
                  var8 = '\n';
                  break;
               case '-':
                  var8 = '\n';
            }
         }

         var0.drawRegion(var1, var8 * var5, 0, var5, var6, 0, var3 - ((var2.length() - 1 - (var9 << 1)) * var5 >> 1), var4, 20);
      }
   }

   public static boolean p() {
      return f != -1;
   }

   public void q() {
   }

   public void r() {
   }

   public static boolean s() {
      return f == -1 ? true : r[f][0] == 1;
   }

   public static boolean t() {
      return f == -1 ? true : r[f][0] == 2;
   }

   public static boolean a(int var0, int var1) {
      if (f == -1) {
         return false;
      } else if (var1 != r[f][2]) {
         return true;
      } else {
         return r[f][1] == -1 ? true : r[f][1] == var0;
      }
   }

   public static void b(int var0, int var1) {
      if (f != -1) {
         if (var1 == -1) {
            r[f][2] = 0;
         }

         r[f][var0] = (byte)var1;
      }
   }

   public static byte d(int var0) {
      return f == -1 ? -1 : r[f][1];
   }

   public static void u() {
      b(1, -1);
      b(0, 0);
      f = -1;
      g = 0;
   }

   public final void b(boolean var1) {
      if (this.v == 4) {
         if (var1) {
            a.a var3 = this;
            this.z++;
            w[var3.y]++;
            System.out.println(" curNum = " + var3.z + " tolNum = " + var3.A);
            if (var3.z >= var3.A) {
               switch (var3.y) {
                  case 0:
                     i = true;
                     game.j.p().s(2000);
                     game.j.p().c(1, 5, (byte)0);
                     game.j.p().c(4, 5, (byte)0);
                     game.j.p().c(11, 2, (byte)0);
                     game.j.p().v(5);
                     game.e.B().n[game.l.e(9, 0)][5] = 3;
                     game.e.B().l[5].a((byte)3);
                     break;
                  case 1:
                     game.j.p().c(0, 1, (byte)0);
                     break;
                  case 2:
                     game.j.p().s(10000);
                     break;
                  case 3:
                     game.l.Q = 0;
                     if (game.l.P == null) {
                        game.l.P = new Vector();
                     }

                     if (game.l.O == null) {
                        game.l.O = new Vector();
                     }

                     game.l.P.removeAllElements();
                     game.l.O.removeAllElements();

                     for (int var2 = 0; var2 < game.j.p().B; var2++) {
                        if (game.j.p().A[var2].t() == 50) {
                           game.j.p().A[var2].K();
                        } else {
                           game.j.p().A[var2].y();
                           if (game.j.p().A[var2].t() + 5 >= 50) {
                              game.j.p().A[var2].h(50 - game.j.p().A[var2].t());
                           } else {
                              game.j.p().A[var2].h(5);
                           }

                           game.j.p().A[var2].J();
                           if (game.j.p().A[var2].F() < 5 && game.j.p().A[var2].F() < game.j.p().A[var2].t() / 10 + 1) {
                              game.l.O.addElement(game.j.p().A[var2]);
                              game.l.P.addElement("" + var2);
                           }
                        }
                     }

                     if (game.l.O.size() <= 0) {
                        game.l.Q = 2;
                     } else {
                        game.l.Q = 1;
                     }
                     break;
                  case 4:
                     game.j.p().v(10);
               }
            }

            var3.c((byte)2);
            return;
         }

         this.c((byte)3);
      }
   }

   private boolean B() {
      if (this.x == null) {
         try {
            this.x = new e.b.a.a.b(this);
            this.x.a("sms://");
         } catch (ClassNotFoundException var1) {
            return false;
         }
      }

      switch (this.y) {
         case 0:
            this.l(this.y);
            break;
         case 1:
            this.l(this.y);
            break;
         case 2:
            this.l(this.y);
            break;
         case 3:
            this.l(this.y);
            break;
         case 4:
            this.l(this.y);
      }

      return true;
   }

   public final boolean b(byte var1) {
      this.y = var1;
      switch (var1) {
         case 0:
            this.A = 1;
            break;
         case 1:
            this.A = 1;
            break;
         case 2:
            this.A = 1;
            break;
         case 3:
            this.A = 1;
            break;
         case 4:
            this.A = 1;
      }

      this.z = 0;
      return true;
   }

   public final void c(byte var1) {
      while (true) {
         if (var1 != 5 && var1 != 0) {
            this.d.aM();
         }

         switch (var1) {
            case 1:
               System.out.println(" " + a(513, new int[]{this.A, this.z}));
               this.d.d(a(513, new int[]{this.A, this.z}));
               break;
            case 2:
               if (this.w()) {
                  if (this.y == 0) {
                     this.d.d(c(515) + c(633));
                  } else {
                     this.d.d(c(515));
                  }
               } else {
                  this.d.d(c(516));
                  System.out.println(" " + c(516));
               }
               break;
            case 3:
               System.out.println(" " + c(516));
               this.d.d(c(516));
               break;
            case 4:
               System.out.println(" " + c(514));
               this.d.d(c(514));
               break;
            case 5:
               e = false;
               this.d.aN();
         }

         this.v = var1;
         if (var1 != 5) {
            return;
         }

         var1 = 0;
         this = this;
      }
   }

   public final int v() {
      return this.y;
   }

   public final boolean w() {
      return this.z >= this.A;
   }

   public final byte x() {
      return this.v;
   }

   public final byte y() {
      return this.A;
   }

   public final void e(int var1) {
      e = true;
      if (var1 == 1) {
         this.c((byte)4);
         if (!this.B()) {
            this.c((byte)3);
            return;
         }
      } else if (var1 == 2) {
         this.c((byte)5);
      }
   }

   public final void f(int var1) {
      switch (this.v) {
         case 1:
            this.e(var1);
            return;
         case 3:
            if (var1 == 1 || var1 == 2) {
               this.c((byte)5);
            }
         case 2:
         case 4:
      }
   }

   private void l(int var1) {
      a.a(GameMIDLet.a);
      a.a(var1);
      this.C[var1][0] = 1;
      this.E = new e.a.a.a.b.b(GameMIDLet.a, game.m.a, "", "", this.B[var1], null, this.C[var1][0], this.D[var1][0], a.c[var1], "");
      Display.getDisplay(GameMIDLet.a).setCurrent(this.E);
      this.E.a(this);
   }

   public final void c(boolean var1) {
      this.b(var1);
   }
}
