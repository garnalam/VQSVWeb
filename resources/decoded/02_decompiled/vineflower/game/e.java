package game;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class e extends a.a {
   public static byte k;
   private static e I = null;
   private l J;
   private j K;
   private a.a L;
   public b.a[] l;
   private Vector M;
   private byte N = -1;
   public byte m = -1;
   public byte[][] n;
   private int O = 0;
   public int o = -1;
   private static Vector P;
   public static Vector p;
   private d Q = game.d.a();
   public static boolean q = false;
   public static boolean r = true;
   public static boolean s = false;
   public static boolean t = false;
   public boolean u = true;
   public static boolean v = true;
   public static boolean w;
   public boolean x = true;
   public byte y = 0;
   public static byte z = -1;
   private short[] R;
   private byte[] S;
   private short[] T;
   private short[] U;
   private short[][] V;
   private short[][] W;
   private short[] X;
   private short[] Y;
   public byte A = 0;
   public static Image B;
   private String[] Z = new String[]{"ikon_1", "ikon_2", "ikon_3", "ikon_4", "ikon_5"};
   private int aa;
   private int ab;
   private int ac;
   private int ad = 0;
   private int ae = 0;
   private byte[] af;
   private String[] ag;
   private int[] ah;
   private int[] ai;
   private String[] aj = null;
   private a.a.g ak = null;
   private int al = -1;
   private Calendar am = null;
   private int[] an;
   public byte C = 0;
   public static String[] D;
   public static String[] E;
   private int ao = 0;
   public static short[][] F = null;
   public static byte G = 0;
   public static byte H = 0;
   private static byte[][] ap;
   private static byte[][] aq;

   public e() {
      if (this.J == null) {
         this.J = game.l.B();
      }

      if (this.K == null) {
         this.K = game.j.p();
      }

      if (this.n == null) {
         this.n = new byte[127][];
      }

      if (F == null) {
         F = new short[200][2];
      }

      if (this.am == null) {
         this.am = Calendar.getInstance(TimeZone.getDefault());
      }

      String[][] var1;
      D = new String[(var1 = a.e.c(a.e.a("/data/script/bTask.mid"))).length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         System.arraycopy(var1[var2], 0, D, var2, var1[var2].length);
      }

      E = new String[(var1 = a.e.c(a.e.a("/data/script/mTask.mid"))).length];

      for (int var5 = 0; var5 < var1.length; var5++) {
         System.arraycopy(var1[var5], 0, E, var5, var1[var5].length);
      }

      InputStream var4;
      ap = a.e.b(var4 = a.e.a("/data/script/bqTask.mid"));
      aq = a.e.b(var4);
   }

   public static e B() {
      if (I == null) {
         I = new e();
      }

      return I;
   }

   public final void a(a.a var1) {
      if (this.L != null) {
         this.L = null;
      }

      this.L = var1;
   }

   public final void a() {
      if (this.l != null) {
         a.a.f.a().d();
         this.Q.d();
         e var1 = this;

         for (int var2 = 0; var2 < var1.l.length; var2++) {
            if (var1.l[var2].a() == 0 || var1.l[var2].a() == 4) {
               boolean var4;
               label217: {
                  b.b var3 = var1.l[var2].d();
                  var4 = false;
                  switch (var3.a()) {
                     case 13:
                        if (!a.e.a(var3.b()[0], var3.b()[1], var3.b()[2], var3.b()[3], var1.K.j, var1.K.k, var1.K.a.k())) {
                           break label217;
                        }

                        var1.K.a((byte)0, var1.K.o);
                        break;
                     case 15:
                        if (var1.n[game.l.e(var3.b()[0], var3.b()[1])] != null
                           && (var1.n[game.l.e(var3.b()[0], var3.b()[1])][var3.b()[2]] == 3 || var1.n[game.l.e(var3.b()[0], var3.b()[1])][var3.b()[2]] == 4)) {
                           var4 = true;
                        }
                        break label217;
                     case 16:
                        if (var3.b()[0] != game.l.E) {
                           break label217;
                        }

                        s = true;
                        if (!t) {
                           break label217;
                        }

                        var1.K.a((byte)0, var1.K.o);
                        t = false;
                        break;
                     case 43:
                        if (game.l.e(var3.b()[2], var3.b()[3]) == game.l.e(var1.J.p, var1.J.q) && var3.b()[4] == game.l.E && var1.a(var3)) {
                           s = true;
                           if (t && var1.l(-1) == -1) {
                              int var19 = var2;
                              e var14 = var1;
                              int var20 = 0;

                              byte var10001;
                              while (true) {
                                 if (var20 >= var14.l.length) {
                                    var10001 = -1;
                                    break;
                                 }

                                 b.b var8;
                                 if (var14.l[var20].a() != 3
                                    && var19 != var20
                                    && (var8 = var14.l[var20].d()).a() == 43
                                    && game.l.e(var8.b()[2], var8.b()[3]) == game.l.e(var14.J.p, var14.J.q)
                                    && var8.b()[4] == game.l.E
                                    && var14.a(var8)) {
                                    var10001 = (byte)var20;
                                    break;
                                 }

                                 var20++;
                              }

                              if (var2 >= var10001) {
                                 var4 = true;
                                 s = false;
                                 var1.K.a((byte)0, var1.K.o);
                                 if (var3.b()[1] == 1) {
                                    F[H][0] = var3.b()[0];
                                 }
                              }
                           }
                        }
                        break label217;
                     case 44:
                        if (game.l.e(var3.b()[2], var3.b()[3]) == game.l.e(var1.J.p, var1.J.q) && var3.b()[4] == game.l.E && var1.b(var3)) {
                           s = true;
                           if (t && var2 >= var1.l(var2)) {
                              s = false;
                              var4 = true;
                              var1.K.a((byte)0, var1.K.o);
                           }
                        }
                        break label217;
                     case 57:
                        if (var1.K.q != null && ((h)var1.K.q).u == 0 && ((h)var1.K.q).w == 11 && ((h)var1.K.q).J == var3.b()[3] && t) {
                           if (var1.J.n[var3.b()[0]].j == var3.b()[1] && var1.J.n[var3.b()[0]].k == var3.b()[2]) {
                              ((h)var1.K.q).a((byte)0);
                           } else {
                              var4 = true;
                           }

                           t = false;
                        }
                        break label217;
                     case 59:
                        int[] var13 = new int[a.e.a(var3.c()[0], ',').length];

                        int var18;
                        for (var18 = 0; var18 < var13.length; var18++) {
                           var13[var18] = a.e.b(a.e.a(var3.c()[0], ',')[var18]);
                           if (var1.J.n[var13[var18]].i() == 0) {
                              break;
                           }
                        }

                        if (var18 >= var13.length) {
                           var4 = true;
                        }
                        break label217;
                     case 61:
                        int[] var12 = new int[a.e.a(var3.c()[0], ',').length];

                        int var17;
                        for (var17 = 0; var17 < var12.length; var17++) {
                           var12[var17] = a.e.b(a.e.a(var3.c()[0], ',')[var17]);
                           if (var1.J.n[var12[var17]].i() == 0) {
                              break;
                           }
                        }

                        if (var17 >= var12.length) {
                           var1.K.a((byte)0, var1.K.o);
                           var4 = true;
                        }
                        break label217;
                     case 69:
                        if (var3.b()[0] != game.l.E) {
                           break label217;
                        }
                        break;
                     case 73:
                        String[] var11 = a.e.a(var3.c()[1], ',');
                        String[] var16 = a.e.a(var3.c()[0], ',');
                        int var10 = 0;

                        while (var10 < var11.length && var1.K.a(a.e.d(var16[var10]), (int)a.e.d(var11[var10])) >= 2) {
                           var10++;
                        }

                        if (var10 >= var11.length) {
                           var4 = true;
                        }
                        break label217;
                     case 75:
                        if (var1.K.M.size() <= 0) {
                           break label217;
                        }
                        break;
                     case 78:
                        byte[] var5 = a.e.e(var3.c()[0]);
                        byte[] var6 = a.e.e(var3.c()[1]);
                        byte[] var9 = a.e.e(var3.c()[2]);
                        int var7 = 0;

                        while (
                           var7 < var9.length
                              && var1.n[game.l.e(var5[var7], var6[var7])] != null
                              && (var1.n[game.l.e(var5[var7], var6[var7])][var9[var7]] == 3 || var1.n[game.l.e(var5[var7], var6[var7])][var9[var7]] == 4)
                        ) {
                           var7++;
                        }

                        if (var7 >= var9.length) {
                           var4 = true;
                        }
                        break label217;
                     case 79:
                        if (var1.n[game.l.e(var3.b()[0], var3.b()[1])] == null
                           || var1.n[game.l.e(var3.b()[0], var3.b()[1])][var3.b()[2]] != 3
                           || var1.K.l(0)
                           || game.l.E != var3.b()[3]) {
                           break label217;
                        }

                        s = true;
                        if (!t) {
                           break label217;
                        }

                        t = false;
                        break;
                     case 86:
                        if (var1.n[game.l.e(var3.b()[0], var3.b()[1])] == null || var1.n[game.l.e(var3.b()[0], var3.b()[1])][var3.b()[2]] != 3) {
                           break label217;
                        }
                  }

                  var4 = true;
               }

               if (var4) {
                  var1.N = (byte)var2;
                  var1.l[var2].b((byte)0);
                  var1.M.addElement(var1.l[var2]);
                  byte var15;
                  if ((var15 = game.l.a(var1.N, (byte)0)) != -1) {
                     var1.m = var1.N;
                     var1.J.W.a(var15, 1);
                     game.l.Y = true;
                  }

                  var1.l[var2].a((byte)1);
               }
            }
         }

         this.J();
      }
   }

   public static void b(Graphics var0) {
      if (P != null) {
         for (int var1 = 0; var1 < P.size(); var1++) {
            a.a.g var2;
            a.a.g var10000 = var2 = (a.a.g)P.elementAt(var1);
            a.b.a var3 = var10000.q;
            var3 = var2.q;
            var10000.b(var10000.q.j, var2.q.k - 40);
            var2.a(var0, a.b.d.a().a, a.b.d.a().b);
         }
      }

      if (p != null) {
         for (int var4 = 0; var4 < p.size(); var4++) {
            ((a.a.g)p.elementAt(var4)).a(var0, a.b.d.a().a, a.b.d.a().b);
         }
      }
   }

   public final void C() {
      if (P != null) {
         for (int var1 = 0; var1 < P.size(); var1++) {
            a.a.g var2;
            (var2 = (a.a.g)P.elementAt(var1)).a();
            if (var2.a.f()) {
               var2.d();
               P.removeElementAt(var1);
               var1--;
            }
         }
      }

      if (p != null) {
         for (int var3 = 0; var3 < p.size(); var3++) {
            ((a.a.g)p.elementAt(var3)).a();
         }
      }

      if (this.ak != null) {
         this.ak.a();
      }
   }

   public final void a(Graphics var1) {
      a.a.f.a().a(var1);
      Graphics var3 = var1;
      e var2 = this;
      if (B != null) {
         var3.setColor(0);
         var3.fillRect(0, 0, g(), h());
         var3.drawImage(B, var2.aa, var2.ab, 20);
      }

      if (var2.ak != null && var2.al == game.l.e(var2.J.p, var2.J.q)) {
         var2.ak.a(var3, a.b.d.a().a, a.b.d.a().b);
      }

      this.Q.a(var1);
   }

   public final boolean b() {
      return true;
   }

   public final boolean a(DataInputStream var1, int var2, int var3, int var4, String[] var5) {
      try {
         this.l = new b.a[var4];
         this.M = new Vector();
         P = new Vector();
         int var6 = var2 << 8 | var3;
         if (this.n[game.l.v[var2] + var3] == null) {
            this.n[game.l.v[var2] + var3] = new byte[var4];
         }

         this.N = -1;
         this.m = -1;

         for (byte var7 = 0; var7 < var4; var7++) {
            this.l[var7] = new b.a();
            this.l[var7].a(var1, var7, var6, var5);
            this.l[var7].a(this.n[game.l.v[var2] + var3][var7]);
         }
      } catch (IOException var8) {
         System.out.println(" ex = " + var8.toString() + " event init ");
      }

      this.G();
      return false;
   }

   public final void D() {
      this.K = null;
      this.J = null;
      this.n = null;
      F = null;
      this.am = null;
      I = null;
   }

   public final void c() {
      if (P != null) {
         P.removeAllElements();
         P = null;
      }

      if (p != null) {
         p.removeAllElements();
         p = null;
      }

      this.l = null;
      this.R = null;
      this.S = null;
      this.T = null;
      this.U = null;
      this.V = null;
      this.W = null;
      this.X = null;
      this.Y = null;
      B = null;
      this.af = null;
      this.ag = null;
   }

   public final void a(byte var1) {
   }

   private byte l(int var1) {
      for (int var2 = 0; var2 < this.l.length; var2++) {
         b.b var3;
         if (this.l[var2].a() != 3
            && var1 != var2
            && (var3 = this.l[var2].d()).a() == 44
            && game.l.e(var3.b()[2], var3.b()[3]) == game.l.e(this.J.p, this.J.q)
            && var3.b()[4] == game.l.E
            && this.b(var3)) {
            return (byte)var2;
         }
      }

      return -1;
   }

   private static void m(int var0) {
      for (int var1 = 0; var1 < H; var1++) {
         if (F[var1][0] == var0) {
            F[var1][1] = 3;
            return;
         }
      }
   }

   private static int n(int var0) {
      for (int var1 = 0; var1 < H; var1++) {
         if (F[var1][0] == var0) {
            return var1;
         }
      }

      return -1;
   }

   private void J() {
      this.ao++;
      int var1 = 0;

      while (var1 < this.M.size()) {
         b.a var2;
         label1125: {
            b.b var3;
            switch ((var3 = (var2 = (b.a)this.M.elementAt(var1)).c()).a()) {
               case 0:
               case 15:
               case 26:
               case 27:
               case 28:
               case 43:
               case 44:
               case 57:
               case 59:
               case 61:
               case 68:
               case 69:
               case 73:
               case 75:
               case 78:
               case 79:
               case 86:
               default:
                  break label1125;
               case 1:
                  if (var2.a() != 5) {
                     a.a.f.a().c(0, 9);
                     this.Q.a(var3.b()[1], var3.b()[2]);
                     this.Q.a((byte)(var3.b()[0] / 10 - 1), var3.c()[0], var3.b()[0] % 10);
                     this.Q.a(true);
                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!game.d.a || !this.L.g(65537) && !this.L.a(80, 294, 80, 18)) {
                     break label1125;
                  }

                  this.Q.b();
                  if (game.d.b) {
                     break label1125;
                  }

                  a.a.f.a().a = -1;
                  this.Q.c();
                  break;
               case 2:
                  if (var3.b()[0] == -1) {
                     this.K.c();
                     this.K.a((byte)0, a.e.d(a.e.a(var3.c()[1], ',')[0]));
                     break label1125;
                  }

                  int var33 = 0;

                  while (true) {
                     if (var33 >= var3.b()[0]) {
                        break label1125;
                     }

                     this.J.n[a.e.c(a.e.a(var3.c()[0], ',')[var33])].d(a.e.d(a.e.a(var3.c()[1], ',')[var33]));
                     if (this.J.n[a.e.c(a.e.a(var3.c()[0], ',')[var33])].w == 1) {
                        this.J.n[a.e.c(a.e.a(var3.c()[0], ',')[var33])].a((byte)0);
                     }

                     this.J.n[a.e.c(a.e.a(var3.c()[0], ',')[var33])].c();
                     var33++;
                  }
               case 3:
                  if (var3.b()[0] == -1) {
                     this.K.d();
                     break label1125;
                  }

                  int var51 = 0;

                  while (true) {
                     if (var51 >= var3.b()[0]) {
                        break label1125;
                     }

                     short var32 = a.e.c(a.e.a(var3.c()[0], ',')[var51]);
                     this.J.n[var32].d();
                     var51++;
                  }
               case 4:
                  if (var2.a() != 5) {
                     this.K.a((byte)0, this.K.o);
                     this.J.d.a(var3.c()[0], var3.c()[1], var3.b()[1], var3.b()[0]);
                     var2.a((byte)5);
                  } else if (this.J.d.d(var3.b()[1], var3.b()[0]) && this.L.g(196640)) {
                     game.l.B().D();
                     if (a.e.b < a.e.b()) {
                        a.e.c();
                        this.J.d.b(a.e.b);
                     } else {
                        if (game.l.E != -1 && this.J.n[game.l.E].a.a <= 85 && this.J.n[game.l.E].v() == 0) {
                           game.l.B().a((byte)13, game.l.B().n[game.l.E].j, game.l.B().n[game.l.E].k - 40, game.l.B().n[game.l.E]);
                        }

                        s = false;
                        t = false;
                        this.J.d.aF();
                        var2.a((byte)1);
                     }
                  }
                  break label1125;
               case 5:
                  a.a.g var31;
                  (var31 = new a.a.g()).a(259, false);
                  var31.g();
                  var31.a((byte)var3.b()[2], (byte)-1, true);
                  if (var3.b()[0] == 0) {
                     var31.b(this.K.m(), this.K.n() - this.K.a.b(this.K.i(), this.K.o)[3]);
                     var31.a(this.K);
                  } else if (var3.b()[0] == 1) {
                     if (var3.b()[3] == 0 && var3.b()[4] == 0) {
                        var31.b(this.J.n[var3.b()[1]].m(), this.J.n[var3.b()[1]].n());
                        var31.a(this.J.n[var3.b()[1]]);
                     } else {
                        var31.b(var3.b()[3], var3.b()[4]);
                     }
                  }

                  var31.c();
                  P.addElement(var31);
                  break label1125;
               case 6:
                  this.n[game.l.v[this.J.p] + this.J.q][var2.b()] = 3;
                  game.l.B().p = var3.b()[0];
                  game.l.B().q = var3.b()[1];
                  if (var3.b()[3] == 1) {
                     this.J.t = var3.b()[2];
                  } else {
                     this.J.t = -1;
                  }

                  game.f.B().a((byte)22);
                  break label1125;
               case 7:
                  if (var2.a() != 5) {
                     this.R = new short[var3.b()[0]];

                     for (int var30 = 0; var30 < this.R.length; var30++) {
                        this.R[var30] = a.e.c(a.e.a(var3.c()[0], ',')[var30]);
                        byte var50 = a.e.d(a.e.a(var3.c()[2], ',')[var30]);
                        if (this.R[var30] == -1) {
                           this.K.a(a.e.d(a.e.a(var3.c()[1], ',')[0]), var50);
                        } else {
                           this.J.n[this.R[var30]].d(var50);
                           this.J.n[this.R[var30]].a(a.e.d(a.e.a(var3.c()[1], ',')[var30]));
                        }
                     }

                     this.O = 0;
                     var2.a((byte)5);
                     break label1125;
                  }

                  for (int var29 = 0; var29 < this.R.length; var29++) {
                     if (this.R[var29] == -1) {
                        if (this.K.b()) {
                           this.K.a((byte)0, this.K.o);
                           this.O++;
                        }
                     } else if (this.J.n[this.R[var29]].b()) {
                        this.J.n[this.R[var29]].a((byte)0);
                        this.O++;
                     }
                  }

                  if (this.O < this.R.length) {
                     break label1125;
                  }

                  this.O = 0;
                  break;
               case 8:
                  this.K.c();
                  game.l.E = -1;
                  this.K.b(var3.b()[0], var3.b()[1]);
                  this.K.b.b(var3.b()[0], var3.b()[1]);
                  this.K.a((byte)0, this.K.o);
                  break label1125;
               case 9:
                  if (var2.a() != 5) {
                     boolean var28 = false;
                     if (var3.b()[0] == 12 || var3.b()[0] == 13) {
                        a.a.f.a().c(0, var3.b()[0]);
                        a.a.f.a().a(var3.b()[1], var3.b()[2], var3.b()[3], var3.b()[4], var3.b()[5]);
                     } else if (var3.b()[0] == 10) {
                        a.a.f.a().c(0, var3.b()[0]);
                        a.a.f.a().d(var3.b()[1], var3.b()[2]);
                     } else if (var3.b()[0] == 15 || var3.b()[0] == 14) {
                        a.a.f.a().c(0, var3.b()[0]);
                        a.a.f.a().a(this.Z[var3.b()[1]], var3.b()[2], var3.b()[3], var3.b()[4]);
                     } else if (var3.b()[0] == 16) {
                        if (var3.b()[1] == 0) {
                           String[] var46 = new String[]{"star0", "star1", "star2", "star3"};
                           a.a.f.a().a(16, 0, (byte)var3.b()[2], (byte)7, game.l.w, var46);
                        } else if (var3.b()[1] == 1) {
                           String[] var47 = new String[]{"fire0", "fire1", "fire2"};
                           a.a.f.a().a(16, 0, (byte)var3.b()[2], (byte)0, null, var47);
                        } else if (var3.b()[1] == 2) {
                           String[] var48 = new String[]{"fire0", "fire1", "fire2"};
                           a.a.f.a().a(17, 0, (byte)var3.b()[2], (byte)0, null, var48);
                        } else {
                           var28 = true;
                           a.a.f.a().a(-1, 0, (byte)var3.b()[2], (byte)0, null, null);
                           var2.a((byte)1);
                        }
                     } else if (var3.b()[0] == 17) {
                        a.a.f.a().c(var3.b()[1], var3.b()[0]);
                        a.a.f.a().a(var3.b()[2], var3.b()[3], var3.b()[4], var3.b()[5]);
                     } else {
                        int var49 = var3.b()[1] << 24 | var3.b()[2] << 16 | var3.b()[3] << 8 | var3.b()[4];
                        a.a.f.a().c(var49, var3.b()[0]);
                     }

                     if (!var28) {
                        var2.a((byte)5);
                     }
                     break label1125;
                  }

                  if (a.a.f.a().e && (var3.b()[0] == 12 || var3.b()[0] == 13)) {
                     var2.a((byte)1);
                     break label1125;
                  }

                  if (var3.b()[0] != 16 && !a.a.f.a().d) {
                     break label1125;
                  }
                  break;
               case 10:
                  if (var2.a() != 5) {
                     if (var3.b()[0] == -1) {
                        this.S = new byte[1];
                        this.K.d(a.e.d(a.e.a(var3.c()[1], ',')[0]));
                        this.K.a((byte)0, this.K.o);
                        this.K.b((byte)0, a.e.d(a.e.a(var3.c()[2], ',')[0]));
                        this.S[0] = a.e.d(a.e.a(var3.c()[3], ',')[0]);
                     } else {
                        this.R = new short[var3.b()[0]];
                        this.S = new byte[var3.b()[0]];

                        for (int var27 = 0; var27 < this.R.length; var27++) {
                           this.R[var27] = a.e.c(a.e.a(var3.c()[0], ',')[var27]);
                           if (this.R[var27] != -1) {
                              this.J.n[this.R[var27]].d(a.e.d(a.e.a(var3.c()[1], ',')[var27]));
                              this.J.n[this.R[var27]].b((byte)0, a.e.d(a.e.a(var3.c()[2], ',')[var27]));
                              this.J.n[this.R[var27]].a((byte)0);
                           } else {
                              this.K.d(a.e.d(a.e.a(var3.c()[1], ',')[var27]));
                              this.K.b((byte)0, a.e.d(a.e.a(var3.c()[2], ',')[var27]));
                              this.K.a((byte)0, this.K.o);
                           }

                           this.S[var27] = a.e.d(a.e.a(var3.c()[3], ',')[var27]);
                        }
                     }

                     this.O = 0;
                     var2.a((byte)5);
                     break label1125;
                  }

                  if (var3.b()[0] == -1) {
                     if (this.K.i() == 0) {
                        this.K.a((byte)1, this.K.o);
                        break label1125;
                     }

                     this.S[0]--;
                     if (this.S[0] > 0) {
                        break label1125;
                     }

                     this.K.a((byte)0, this.K.o);
                     if (this.K.Q[0] != 2 && this.K.Q[1] != 2) {
                        this.K.b((byte)0, (short)4);
                     } else {
                        this.K.b((byte)0, (short)8);
                     }

                     var2.a((byte)1);
                     break label1125;
                  }

                  for (int var26 = 0; var26 < this.R.length; var26++) {
                     if ((this.R[var26] == -1 || this.J.n[this.R[var26]].i() != 0) && (this.R[var26] != -1 || this.K.i() != 0)) {
                        this.S[var26]--;
                        if (this.S[var26] <= 0) {
                           this.O++;
                           this.S[var26] = 0;
                           if (this.R[var26] != -1) {
                              this.J.n[this.R[var26]].a((byte)0);
                              this.J.n[this.R[var26]].b((byte)0, (short)4);
                           } else {
                              this.K.a((byte)0, this.K.o);
                              if (this.K.Q[0] != 2 && this.K.Q[1] != 2) {
                                 this.K.b((byte)0, (short)4);
                              } else {
                                 this.K.b((byte)0, (short)8);
                              }
                           }
                        }
                     } else if (this.S[var26] > 0) {
                        if (this.R[var26] != -1) {
                           this.J.n[this.R[var26]].a((byte)3);
                        } else {
                           this.K.a((byte)1, this.K.o);
                        }
                     }
                  }

                  if (this.O < this.R.length) {
                     break label1125;
                  }
                  break;
               case 11:
                  if (var2.a() != 5) {
                     boolean var25 = false;
                     if (var3.b()[6] == 0) {
                        var25 = true;
                     }

                     a.b.b.a().a(var3.b()[7]);
                     if (var3.b()[2] == 1) {
                        a.b.b.a().a(var3.b()[4], var3.b()[5], var3.b()[0], var3.b()[1], var25);
                     } else if (var3.b()[2] == 0) {
                        if (var3.b()[3] == -1) {
                           a.b.b.a().a(this.K, var3.b()[0], var3.b()[1], var25);
                        } else {
                           a.b.b.a().a(this.J.n[var3.b()[3]], var3.b()[0], var3.b()[1], var25);
                        }
                     }

                     this.K.a((byte)0, this.K.o);
                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!a.b.b.a().b()) {
                     break label1125;
                  }
                  break;
               case 12:
                  this.O++;
                  if (var2.a() != 5) {
                     var2.a((byte)5);
                     break label1125;
                  }

                  if (this.O < var3.b()[0]) {
                     break label1125;
                  }

                  this.O = 0;
                  break;
               case 13:
                  if (a.e.a(var3.b()[0], var3.b()[1], var3.b()[2], var3.b()[3], this.K.j, this.K.k, this.K.a.k())) {
                     var2.a((byte)1);
                     this.K.a((byte)0, this.K.o);
                  } else {
                     var2.a((byte)6);
                  }
                  break label1125;
               case 14:
                  var2.a((byte)3);
                  break label1125;
               case 16:
                  if (var3.b()[0] == game.l.E) {
                     s = true;
                     if (t) {
                        t = false;
                        var2.a((byte)2);
                     }
                  } else {
                     var2.a((byte)6);
                  }
                  break label1125;
               case 17:
                  if (var2.a() != 5) {
                     if (var3.b()[0] == 0) {
                        if (this.K.a(var3.b()[1], var3.b()[2], (byte)0)) {
                           short var23 = a.b.c.c[4][var3.b()[1]][0];
                           this.L.d.a("Đạt được: " + a.a.c(var23), var3.b()[2]);
                           this.K.c(var3.b()[1], var3.b()[2], (byte)0);
                        } else {
                           this.L.d.b("Ba lô đã đủ đạo cụ này");
                        }
                     } else if (this.K.b(var3.b()[1], var3.b()[2], (byte)0)) {
                        short var24 = a.b.c.c[4][var3.b()[1]][0];
                        this.L.d.a("Mất: " + a.a.c(var24), var3.b()[2]);
                        this.K.d(var3.b()[1], var3.b()[2], (byte)0);
                     }

                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!this.L.d.aA()) {
                     break label1125;
                  }
                  break;
               case 18:
                  if (var2.a() != 5) {
                     if (var3.b()[0] == 0) {
                        if (this.K.a(var3.b()[1], var3.b()[2], (byte)2)) {
                           short var21 = a.b.c.c[3][var3.b()[1]][0];
                           this.L.d.a("Đạt được: " + a.a.c(var21), var3.b()[2]);
                           this.K.c(var3.b()[1], var3.b()[2], (byte)2);
                        } else {
                           this.L.d.b("Ba lô đã đủ đạo cụ này");
                        }
                     } else if (var3.b()[0] == 1) {
                        short var22 = a.b.c.c[3][var3.b()[1]][0];
                        this.L.d.a("Mất: " + a.a.c(var22), var3.b()[2]);
                        this.K.d(var3.b()[1], var3.b()[2], (byte)2);
                     }

                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!this.L.d.aA()) {
                     break label1125;
                  }
                  break;
               case 19:
                  if (var2.a() != 5) {
                     short var20 = a.b.c.c[5][var3.b()[0]][0];
                     this.L.d.a("Đạt được: " + a.a.c(var20), var3.b()[1]);
                     int var45;
                     if ((var45 = this.K.d(var3.b()[0], var3.b()[1])) != -1) {
                        if (var45 == 1) {
                           this.L.d.b("Ba lô đã đủ loại đạo cụ này");
                        } else {
                           this.K.c(var3.b()[0], var3.b()[1]);
                        }
                     } else if (var3.b()[0] == 0) {
                        this.K.e(var3.b()[0], -1);
                     } else {
                        this.K.j(var3.b()[0]);
                     }

                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!this.L.d.aA()) {
                     break label1125;
                  }
                  break;
               case 20:
                  if (var2.a() != 5) {
                     if (var3.b()[0] == 1) {
                        this.L.d.b("Mất: " + var3.c()[0]);
                        this.K.U[var3.b()[1]] = false;
                     } else {
                        this.L.d.b("Đạt được: " + var3.c()[0]);
                        this.K.U[var3.b()[1]] = true;
                     }

                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!this.L.d.aA()) {
                     break label1125;
                  }
                  break;
               case 21:
                  game.l.H = false;
                  game.l.I = var3.b()[2];
                  if (var3.b()[1] == 1) {
                     game.l.J = var3.b()[3];
                     game.l.K = var3.b()[4];
                     game.l.L = var3.b()[5];
                     game.l.M = var3.b()[6];
                  }
                  break label1125;
               case 22:
                  game.l.H = true;
                  game.l.G = (byte)var3.b()[1];
                  game.l.B().r = var3.b()[2];
                  game.l.B().s = var3.b()[3];
                  game.l.L = var3.b()[4];
                  game.l.M = var3.b()[5];
                  game.l.B().t = -1;
                  break label1125;
               case 23:
                  this.n[game.l.e(var3.b()[0], var3.b()[1])][var3.b()[2]] = 3;
                  if (var3.b()[0] == this.J.p && var3.b()[1] == this.J.q) {
                     this.l[var3.b()[2]].a((byte)3);
                     if (this.M.size() > 0) {
                        this.M.removeElement(this.l[var3.b()[2]]);
                        var1--;
                     }
                  }
                  break label1125;
               case 24:
                  if (var2.a() != 5) {
                     a.a.f.a().c(0, 11);
                     a.a.f.a().a(var3.b()[0], var3.b()[1], var3.b()[2]);
                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!a.a.f.a().d) {
                     break label1125;
                  }
                  break;
               case 25:
                  r = var3.b()[0] == 0;
                  break label1125;
               case 29:
                  if (var2.a() != 5) {
                     short var19 = var3.b()[0];
                     if (var3.b()[0] == -1) {
                        var19 = 1;
                     }

                     this.R = new short[var19];
                     this.X = new short[var19];
                     this.Y = new short[var19];
                     this.T = new short[var19];
                     this.U = new short[var19];

                     for (int var44 = 0; var44 < this.R.length; var44++) {
                        this.R[var44] = a.e.c(a.e.a(var3.c()[0], ',')[var44]);
                        this.X[var44] = a.e.c(a.e.a(var3.c()[1], ',')[var44]);
                        this.Y[var44] = a.e.c(a.e.a(var3.c()[2], ',')[var44]);
                        this.T[var44] = a.e.c(a.e.a(var3.c()[3], ',')[var44]);
                        this.U[var44] = a.e.c(a.e.a(var3.c()[4], ',')[var44]);
                     }

                     var2.a((byte)5);
                     break label1125;
                  }

                  boolean var18 = true;

                  for (int var76 = 0; var76 < this.R.length; var76++) {
                     if (this.T[var76] > 0 || this.U[var76] > 0) {
                        var18 = false;
                        this.T[var76]--;
                        this.U[var76]--;
                        if (var3.b()[0] == -1) {
                           int var42 = this.K.m() + this.X[var76];
                           int var66 = this.K.n() + this.Y[var76];
                           this.K.b(var42, var66);
                           if (this.K.b != null) {
                              this.K.b.b(var42, var66);
                           }
                        } else {
                           int var43 = this.J.n[this.R[var76]].m() + this.X[var76];
                           int var67 = this.J.n[this.R[var76]].n() + this.Y[var76];
                           this.J.n[this.R[var76]].b(var43, var67);
                           if (this.J.n[this.R[var76]].b != null) {
                              this.J.n[this.R[var76]].b.b(var43, var67);
                           }
                        }
                     }
                  }

                  if (var18) {
                     var2.a((byte)1);
                  }
                  break label1125;
               case 30:
                  if (var2.a() != 5) {
                     this.R = new short[var3.b()[0]];
                     String[] var17 = a.e.a(var3.c()[2], ',');

                     for (int var40 = 0; var40 < this.R.length; var40++) {
                        this.R[var40] = a.e.c(var17[var40]);
                     }

                     String[][] var41 = new String[this.R.length][];
                     String[][] var65 = new String[this.R.length][];

                     for (int var74 = 0; var74 < var65.length; var74++) {
                        var41[var74] = a.e.a(a.e.a(var3.c()[0], '#')[var74], ',');
                        var65[var74] = a.e.a(a.e.a(var3.c()[1], '#')[var74], ',');
                     }

                     this.V = new short[this.R.length][];
                     this.W = new short[this.R.length][];

                     for (int var75 = 0; var75 < this.R.length; var75++) {
                        this.V[var75] = new short[var41[var75].length];
                        this.W[var75] = new short[var65[var75].length];

                        for (int var82 = 0; var82 < this.V[var75].length; var82++) {
                           this.V[var75][var82] = a.e.c(var41[var75][var82]);
                           this.W[var75][var82] = a.e.c(var65[var75][var82]);
                        }
                     }

                     this.O = 0;
                     var2.a((byte)5);
                     break label1125;
                  }

                  for (int var16 = 0; var16 < this.R.length; var16++) {
                     this.J.n[this.R[var16]].b(this.V[var16][this.O], this.W[var16][this.O]);
                  }

                  this.O++;
                  if (this.O < this.V[0].length) {
                     break label1125;
                  }
                  break;
               case 31:
                  if (var2.a() != 5) {
                     if (var3.b()[0] == 0) {
                        if (var3.b()[1] == 0) {
                           this.K.s(var3.b()[2]);
                           this.L.d.b("Đạt được: " + var3.b()[2] + " kim tiền");
                        } else if (var3.b()[1] == 1) {
                           this.K.v(var3.b()[2]);
                           this.L.d.b("Đạt được: " + var3.b()[2] + "Huy hiệu");
                        }
                     } else if (var3.b()[0] == 1) {
                        if (var3.b()[1] == 0) {
                           this.K.s(-var3.b()[2]);
                           this.L.d.b("Mất: " + var3.b()[2] + " kim tiền");
                        } else if (var3.b()[1] == 1) {
                           this.K.v(-var3.b()[2]);
                           this.L.d.b("Mất: " + var3.b()[2] + " huy hiệu");
                        }
                     }

                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!this.J.d.aA()) {
                     break label1125;
                  }
                  break;
               case 32:
                  this.J.D();
                  game.a.B().k = var3.b()[0];
                  game.a.B().l = (byte)var3.b()[1];
                  this.J.N();
                  this.K.a((byte)0, this.K.o);
                  var2.a((byte)1);
                  byte var15;
                  if ((var15 = game.l.a(var2.b(), (byte)1)) != -1) {
                     this.J.W.a(var15, 1);
                  } else {
                     this.J.W.a(4, 1);
                  }

                  game.f.B().a((byte)12);
                  break label1125;
               case 33:
                  if ((k = (byte)var3.b()[0]) == 2) {
                     k = 1;
                     a.b.d.a().c();
                     int var39 = 0;

                     while (true) {
                        if (var39 >= game.l.B().n.length) {
                           break label1125;
                        }

                        if (this.J.n[var39].k()) {
                           this.J.n[var39].p();
                        }

                        var39++;
                     }
                  }

                  if (k != 3) {
                     break label1125;
                  }

                  k = 0;
                  a.b.d.a().c();
                  int var38 = 0;

                  while (true) {
                     if (var38 >= game.l.B().n.length) {
                        break label1125;
                     }

                     if (this.J.n[var38].k()) {
                        game.l.B().n[var38].p();
                     }

                     var38++;
                  }
               case 34:
                  if (var2.a() != 5) {
                     B = a.e.b("/data/tex/", this.Z[var3.b()[0]]);
                     this.aa = var3.b()[1];
                     this.ab = var3.b()[2];
                     this.ac = var3.b()[3];
                     this.O = var3.b()[4];
                     var2.a((byte)5);
                     break label1125;
                  }

                  this.O--;
                  this.ab = this.ab - this.ac;
                  if (this.O > 0) {
                     break label1125;
                  }

                  this.O = 0;
                  break;
               case 35:
                  if (var2.a() == 5) {
                     int var37;
                     if ((var37 = this.L.d.c(this.ae)) != -1) {
                        var2.b((byte)(this.af[var37] - 2));
                        var2.a((byte)1);
                     }
                     break label1125;
                  }

                  this.ad = var3.b()[0];
                  this.ae = var3.b()[1];
                  this.ag = a.e.a(var3.c()[0], ',');
                  this.af = new byte[a.e.a(var3.c()[1], ',').length];
                  String var36 = var3.c()[2];

                  for (int var64 = 0; var64 < this.af.length; var64++) {
                     this.af[var64] = a.e.d(a.e.a(var3.c()[1], ',')[var64]);
                  }

                  this.L.d.a(this.ae, this.ad, this.ag, var36);
                  var2.a((byte)5);
                  break label1125;
               case 36:
                  if (var2.a() != 5) {
                     byte var35 = this.K.z();
                     if (var3.b()[0] == 0) {
                        if (var35 == 0) {
                           this.K
                              .a(var3.b()[1], var3.b()[2], (short)-1, (byte)var3.b()[4], (byte)var3.b()[3], (byte)-1, new int[]{1, var3.b()[5], var3.b()[6]});
                        } else if (var35 == 1) {
                           this.L.d.b("Ba lô đã đủ, đã để vào ngân hàng");
                           short var63 = game.i.b(var3.b()[1], var3.b()[2], var3.b()[3]);
                           this.K
                              .a(
                                 var3.b()[1],
                                 var3.b()[2],
                                 (short)-1,
                                 (byte)var3.b()[4],
                                 (byte)var3.b()[3],
                                 (byte)-1,
                                 var63,
                                 0,
                                 0,
                                 new int[]{1, var3.b()[5], var3.b()[6]}
                              );
                        } else {
                           this.L.d.b("Không có không gian, đã phóng sinh");
                        }
                     } else if (var3.b()[0] == 1) {
                        this.K.o(var3.b()[1]);
                     }

                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!this.L.d.aA()) {
                     break label1125;
                  }
                  break;
               case 37:
                  game.a.B().a(new int[][]{{var3.b()[0], var3.b()[1], var3.b()[2]}});
                  break label1125;
               case 38:
                  s = false;

                  for (int var62 = 0; var62 < a.e.a(var3.c()[0], ',').length; var62++) {
                     if (a.e.d(a.e.a(var3.c()[0], ',')[var62]) == game.l.E) {
                        s = true;
                        if (t) {
                           game.l.E = -1;
                           byte var5 = a.e.d(a.e.a(var3.c()[1], ',')[var62]);
                           var2.b((byte)(var5 - 1));
                           game.l.B().D();
                           s = false;
                           t = false;
                        }
                        break;
                     }
                  }

                  var2.a((byte)6);
                  break label1125;
               case 39:
                  int var61 = 0;

                  while (true) {
                     if (var61 >= this.K.B) {
                        break label1125;
                     }

                     this.K.A[var61].J();
                     var61++;
                  }
               case 40:
                  if (var2.a() != 5) {
                     this.L.d.c(var3.c()[0]);
                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!this.L.d.aB()) {
                     break label1125;
                  }
                  break;
               case 41:
                  var2.b((byte)(var3.b()[0] - 2));
                  break label1125;
               case 42:
                  var2.a((byte)4);
                  break label1125;
               case 45:
                  if (var2.a() != 5) {
                     this.L.d.c(var3.c()[0]);
                     G = (byte)var3.b()[0];
                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!this.L.d.aB()) {
                     break label1125;
                  }
                  break;
               case 46:
                  if (var2.a() != 5) {
                     this.L.d.K();
                     this.L.d.a(var3.c()[0]);
                     var2.a((byte)5);
                     break label1125;
                  }

                  if (this.L.d.f == 0) {
                     if (this.L.g(196640)) {
                        this.L.d.f = 1;
                        this.L.d.a("Đang lưu...");
                        this.L.d.M();
                     } else if (this.L.g(262144)) {
                        var2.a((byte)1);
                        this.L.d.L();
                        this.L.d.f = 0;
                     }
                     break label1125;
                  }

                  if (this.L.d.f == 1) {
                     this.n[game.l.e(this.J.p, this.J.q)][var2.b()] = 3;
                     if (((l)this.L).I()) {
                        this.L.d.a("Lưu thành công");
                        this.L.d.f = 2;
                     }
                     break label1125;
                  }

                  if (this.L.d.f != 2) {
                     break label1125;
                  }

                  this.L.d.L();
                  this.L.d.f = 0;
                  break;
               case 47:
                  if (this.y != -1) {
                     var2.b((byte)(var3.b()[this.y] - 2));
                  }
                  break label1125;
               case 48:
                  if (var2.a() != 5) {
                     this.Q.a(var3.b()[1], var3.b()[2]);
                     this.Q.a((byte)(var3.b()[0] / 10 - 1), var3.c()[0], var3.b()[0] % 10);
                     if (var3.b()[5] == 1) {
                        this.Q.a(true);
                     }

                     this.Q.b(var3.b()[3], var3.b()[4]);
                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!this.Q.e()) {
                     var2.a((byte)1);
                     break label1125;
                  }

                  if (!game.d.a || !this.L.g(1) && !this.L.a(80, 294, 80, 18)) {
                     break label1125;
                  }

                  this.Q.b();
                  if (game.d.b) {
                     break label1125;
                  }

                  a.a.f.a().a = -1;
                  this.Q.c();
                  break;
               case 49:
                  if (var2.a() == 5) {
                     int var60;
                     if ((var60 = this.L.d.aG()) != -1) {
                        if (var60 == 0 && var2.d().b()[1] == 1) {
                           F[H][1] = 1;
                           H++;
                        }

                        var2.b((byte)(this.af[var60] - 2));
                        var2.a((byte)1);
                     }
                     break label1125;
                  }

                  this.ah = new int[2];
                  this.ai = new int[2];
                  this.aj = new String[2];
                  this.ag = new String[2];

                  for (int var58 = 0; var58 < 2; var58++) {
                     this.ah[var58] = var3.b()[var58 << 1];
                     this.ai[var58] = var3.b()[(var58 << 1) + 1];
                     this.aj[var58] = var3.c()[var58];
                  }

                  this.af = new byte[a.e.a(var3.c()[2], ',').length];

                  for (int var59 = 0; var59 < this.af.length; var59++) {
                     this.af[var59] = a.e.d(a.e.a(var3.c()[2], ',')[var59]);
                     this.ag[var59] = a.e.a(var3.c()[3], ',')[var59];
                  }

                  this.L.d.a(this.ah, this.ai, this.aj, this.ag);
                  var2.a((byte)5);
                  break label1125;
               case 50:
                  if (var3.b()[0] == 0) {
                     this.K.v();
                  } else {
                     this.K.u();
                  }
                  break label1125;
               case 51:
                  this.J.d.aE();
                  this.Q.a(var3.b()[1], var3.b()[2]);
                  this.Q.a((byte)(var3.b()[0] / 10 - 1), var3.c()[0], var3.b()[0] % 10);
                  this.Q.b(var3.b()[3], var3.b()[4]);
                  break label1125;
               case 52:
                  if (var3.b()[0] == 0) {
                     this.u = true;
                  } else {
                     this.u = false;
                  }

                  if (var3.b()[1] == 0) {
                     v = true;
                  } else {
                     v = false;
                  }
                  break label1125;
               case 53:
                  if (var2.a() != 5) {
                     if (var3.b()[1] == 0) {
                        this.K.b((byte)var3.b()[0], (byte)var3.b()[1], (byte)2);

                        for (int var57 = 0; var57 < game.l.B().n.length; var57++) {
                           if (game.l.B().n[var57].u == 0 && game.l.B().n[var57].w == 1) {
                              game.l.B().n[var57].w();
                           }
                        }
                     } else if (var3.b()[1] == 1) {
                        this.K.b((byte)var3.b()[0], (byte)var3.b()[1], (byte)1);
                     }

                     this.L.d.a(var3.b()[0]);
                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!this.J.g(65537) && !this.L.a(94, 200, 60, 18)) {
                     break label1125;
                  }

                  this.L.d.Y();
                  break;
               case 54:
                  short var56;
                  int[][] var73 = new int[var56 = var3.b()[0]][3];

                  for (int var81 = 0; var81 < var56; var81++) {
                     var73[var81][0] = a.e.b(a.e.a(var3.c()[0], ',')[var81]);
                     var73[var81][1] = a.e.b(a.e.a(var3.c()[1], ',')[var81]);
                     var73[var81][2] = a.e.b(a.e.a(var3.c()[2], ',')[var81]);
                  }

                  game.a.B().a(var73);
                  break label1125;
               case 55:
                  if (var3.b()[0] == 0) {
                     if (this.ak == null) {
                        this.ak = new a.a.g();
                        this.ak.a(340, false);
                        this.ak.c();
                        this.al = game.l.e(var3.b()[3], var3.b()[4]);
                     }

                     this.ak.b(var3.b()[1], var3.b()[2]);
                  } else if (var3.b()[0] == 1 && this.ak != null) {
                     this.ak.d();
                     this.ak = null;
                     this.al = -1;
                  }
                  break label1125;
               case 56:
                  short var55 = var3.b()[1];
                  if (var3.b()[0] == 0) {
                     int var72 = 0;

                     while (true) {
                        if (var72 >= var55) {
                           break label1125;
                        }

                        short var80 = a.e.c(a.e.a(var3.c()[0], ',')[var72]);
                        byte var14 = a.e.d(a.e.a(var3.c()[1], ',')[var72]);
                        this.J.n[var80].d(var14);
                        if (this.J.n[var80].w == 1) {
                           this.J.n[var80].a((byte)0);
                        }

                        this.J.n[var80].c();
                        this.J.a(var80, 1, (byte)1, true);
                        this.J.a(var80, 2, var14, true);
                        this.J.n[var80].t();
                        var72++;
                     }
                  }

                  if (var3.b()[0] != 1) {
                     break label1125;
                  }

                  int var71 = 0;

                  while (true) {
                     if (var71 >= var55) {
                        break label1125;
                     }

                     short var79 = a.e.c(a.e.a(var3.c()[0], ',')[var71]);
                     if (this.J.n[var79].w == 1) {
                        this.J.n[var79].a((byte)0);
                     }

                     this.J.n[var79].d();
                     this.J.a(var79, 1, (byte)0, true);
                     this.J.n[var79].t();
                     var71++;
                  }
               case 58:
                  if (((h)this.K.q).i() == 1 && ((h)this.K.q).a.f()) {
                     ((h)this.K.q).a((byte)0);
                     this.J.n[var3.b()[0]].b(var3.b()[1], var3.b()[2]);
                     if ((h)this.J.n[var3.b()[0]].q != null) {
                        ((h)this.J.n[var3.b()[0]].q).s();
                        this.J.n[var3.b()[0]].a(null);
                     }
                  }
                  break label1125;
               case 60:
                  if (var2.a() != 5) {
                     this.R = new short[var3.b()[0]];

                     for (int var54 = 0; var54 < this.R.length; var54++) {
                        this.R[var54] = a.e.c(a.e.a(var3.c()[0], ',')[var54]);
                        this.J.n[this.R[var54]].a(a.e.d(a.e.a(var3.c()[1], ',')[var54]));
                        if (this.J.n[this.R[var54]].u == 0 && this.J.n[this.R[var54]].w == 6 && this.J.n[this.R[var54]].i() == 2) {
                           game.l.B().l.a(game.l.B().n[this.R[var54]], 2);
                        }
                     }

                     this.O = 0;
                     var2.a((byte)5);
                     break label1125;
                  }

                  for (int var53 = 0; var53 < this.R.length; var53++) {
                     if (this.J.n[this.R[var53]].b()) {
                        this.O++;
                     }
                  }

                  if (this.O < this.R.length) {
                     break label1125;
                  }

                  this.O = 0;
                  break;
               case 62:
                  int[] var52 = new int[a.e.a(var3.c()[0], ',').length];
                  int var78 = -1;
                  var2.a((byte)6);

                  for (int var70 = 0; var70 < var52.length; var70++) {
                     var52[var70] = a.e.b(a.e.a(var3.c()[0], ',')[var70]);
                     if (this.J.n[var52[var70]].i() == 2) {
                        var78 = var52[var70];
                        break;
                     }
                  }

                  if (var78 < 0) {
                     break label1125;
                  }

                  if (var78 == var3.b()[0]) {
                     var2.b((byte)(var3.b()[1] - 2));
                     var2.a((byte)1);
                     break label1125;
                  }

                  var2.b((byte)(var3.b()[2] - 2));
                  break;
               case 63:
                  if (var3.b()[0] == 0) {
                     this.K.h(var3.b()[1]);
                  } else {
                     this.K.t();
                  }

                  this.x = var3.b()[2] != 0;
                  break label1125;
               case 64:
                  if (var3.b()[0] == 0) {
                     this.J.l(var3.b()[1]);
                     if (var3.b()[2] == -1) {
                        this.J.a(this.K);
                     } else {
                        this.J.a(this.J.n[var3.b()[2]]);
                     }
                  } else {
                     this.J.E();
                  }
                  break label1125;
               case 65:
                  if (var2.a() != 5 && !i) {
                     this.L.a((byte)100);
                     var2.a((byte)5);
                     break label1125;
                  }

                  if (i) {
                     var2.b((byte)(var3.b()[0] - 2));
                  } else {
                     var2.b((byte)(var3.b()[1] - 2));
                  }
                  break;
               case 66:
                  a.a.f = (byte)var3.b()[0];
                  a.a.b(0, 3);
                  break label1125;
               case 67:
                  game.l.F = var3.b()[0];
                  break label1125;
               case 70:
                  if (var2.a() != 5) {
                     q = false;
                     this.o = var3.b()[0];
                     switch (var3.b()[0]) {
                        case 0:
                        case 1:
                           this.J.a((byte)1);
                           break;
                        case 2:
                           this.J.a((byte)16);
                     }

                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!q) {
                     break label1125;
                  }

                  this.o = -1;
                  break;
               case 71:
                  if (this.K.G >= var3.b()[0]) {
                     var2.b((byte)(var3.b()[1] - 2));
                  } else {
                     var2.b((byte)(var3.b()[2] - 2));
                  }
                  break label1125;
               case 72:
                  String[] var6 = a.e.a(var3.c()[0], ',');
                  String[] var69 = a.e.a(var3.c()[1], ',');
                  a.a.g[] var77 = new a.a.g[var6.length];
                  int var13 = 0;

                  while (true) {
                     if (var13 >= var6.length) {
                        break label1125;
                     }

                     var77[var13] = new a.a.g();
                     var77[var13].a(259, false);
                     var77[var13].g();
                     if (a.e.b(var6[var13]) == -1) {
                        var77[var13].a(a.e.d(var69[var13]), (byte)-1, true);
                        var77[var13].c();
                        var77[var13].b(this.K.m(), this.K.n() - 40);
                        var77[var13].a(this.K);
                     } else {
                        var77[var13].a(a.e.d(var69[var13]), (byte)-1, true);
                        var77[var13].c();
                        var77[var13].b(this.J.n[a.e.b(var6[var13])].m(), this.J.n[a.e.b(var6[var13])].n() - 40);
                        var77[var13].a(this.J.n[a.e.b(var6[var13])]);
                     }

                     P.addElement(var77[var13]);
                     var13++;
                  }
               case 74:
                  if (((int[])this.K.L.elementAt(0))[1] > 0) {
                     var2.b((byte)(var3.b()[0] - 2));
                  } else {
                     var2.b((byte)(var3.b()[1] - 2));
                  }
                  break label1125;
               case 76:
                  this.n[game.l.v[this.J.p] + this.J.q][var2.b()] = 3;
                  game.l.B().p = var3.b()[0];
                  game.l.B().q = var3.b()[1];
                  game.l.B().t = -1;
                  this.J.a((byte)29);
                  break label1125;
               case 77:
                  this.n[game.l.e(var3.b()[0], var3.b()[1])][var3.b()[2]] = 4;
                  if (var3.b()[0] == this.J.p && var3.b()[1] == this.J.q) {
                     this.l[var3.b()[2]].a((byte)4);
                  }
                  break label1125;
               case 80:
                  if (var2.a() != 5) {
                     if (var3.b()[0] == 0) {
                        this.O = 0;
                        this.A = 4;
                     } else if (var3.b()[0] == 1) {
                        game.f.B().m = game.f.B().l;
                        long var68;
                        if (a.e.a(var68 = game.f.B().m - game.f.B().k)[2] <= 60L) {
                           byte var11;
                           if ((var11 = this.K.z()) == 0) {
                              this.L.d.b("Đạt được #2Lục hành điểu");
                              this.K.a(54, 5, (short)-1, (byte)2, (short)-1, (byte)-1, new int[]{1, 30, 45});
                           } else if (var11 == 1) {
                              this.L.d.b("Đạt được #2Lục hành điểu#0 ba lô đã đủ, đã để vào ngân hàng");
                              var11 = a.e.b(a.b.c.c[0][54][3], a.b.c.c[0][54][3]);
                              this.K.a(54, 5, (short)-1, (byte)2, (byte)var11, (byte)-1, 0, 0, 0, new int[]{1, 30, 45});
                           } else {
                              this.L.d.b("Không có không gian, đã phóng sinh");
                           }
                        } else if (a.e.a(var68)[2] <= 65L) {
                           this.K.s(1000);
                           this.L.d.b("Thưởng 1000 kim");
                        } else if (a.e.a(var68)[2] <= 130L) {
                           this.K.s(750);
                           this.L.d.b("Thưởng 750 kim");
                        } else if (a.e.a(var68)[2] <= 200L) {
                           this.K.s(600);
                           this.L.d.b("Thưởng 600 kim");
                        }

                        game.f.B().l = 0L;
                        game.f.B().k = 0L;
                     }

                     var2.a((byte)5);
                     break label1125;
                  }

                  if (var3.b()[0] == 0) {
                     this.O++;
                     if (this.A > 0) {
                        if (this.O / 10 != 0 && this.O % 10 == 0) {
                           this.A--;
                        }
                        break label1125;
                     }

                     this.A = 0;
                     game.f.B().k = System.currentTimeMillis();
                     game.f.B().l = game.f.B().k;
                     game.f.B().m = 0L;
                  } else {
                     if (var3.b()[0] != 1 || !this.L.d.aA()) {
                        break label1125;
                     }

                     if (this.C == 0) {
                        this.an = this.H();
                     }

                     this.C++;
                  }
                  break;
               case 81:
                  if (var3.b()[0] == 0) {
                     if (this.K.u(var3.b()[1])) {
                        var2.b((byte)(var3.b()[2] - 2));
                     } else {
                        var2.b((byte)(var3.b()[3] - 2));
                     }
                  } else if (var3.b()[0] == 1) {
                     if (this.K.x(var3.b()[1])) {
                        var2.b((byte)(var3.b()[2] - 2));
                     } else {
                        var2.b((byte)(var3.b()[3] - 2));
                     }
                  }
                  break label1125;
               case 82:
                  short var7 = var3.b()[0];
                  byte[] var8 = a.e.e(var3.c()[0]);
                  int var10 = 0;

                  while (true) {
                     if (var10 >= var7) {
                        break label1125;
                     }

                     this.J.n[var8[var10]].t();
                     this.J.n[var8[var10]].u();
                     var10++;
                  }
               case 83:
                  if (var2.a() != 5) {
                     this.L.a((byte)30);
                     var2.a((byte)5);
                     break label1125;
                  }

                  var2.b((byte)(var3.b()[z] - 2));
                  break;
               case 84:
                  if (var2.a() != 5) {
                     int[] var4 = null;
                     if (var3.b()[2] == 1) {
                        var4 = new int[]{this.C, 5 - this.C};
                     } else if (var3.b()[2] == 0) {
                        var4 = new int[]{this.K.J, this.K.S.length - this.K.J};
                     }

                     String var9 = a(var3.c()[1], var4);
                     this.J.d.a(var3.c()[0], var9, var3.b()[1], var3.b()[0]);
                     var2.a((byte)5);
                  } else if (this.J.d.d(var3.b()[1], var3.b()[0]) && this.L.g(196640)) {
                     game.l.B().D();
                     if (a.e.b < a.e.b()) {
                        a.e.c();
                        this.J.d.b(a.e.b);
                     } else {
                        if (game.l.E != -1 && this.J.n[game.l.E].a.a <= 85 && this.J.n[game.l.E].v() == 0) {
                           game.l.B().a((byte)13, game.l.B().n[game.l.E].j, game.l.B().n[game.l.E].k - 40, game.l.B().n[game.l.E]);
                        }

                        s = false;
                        t = false;
                        this.J.d.aF();
                        var2.a((byte)1);
                     }
                  }
                  break label1125;
               case 85:
                  if (this.C >= 0 && this.C < 5) {
                     var2.b((byte)(var3.b()[0] - 2));
                     break label1125;
                  }

                  var2.b((byte)(var3.b()[1] - 2));
                  break label1125;
               case 87:
                  if (var2.a() != 5) {
                     if (var3.b()[0] == 0) {
                        this.K
                           .a(
                              var3.b()[7],
                              var3.b()[1],
                              var3.b()[2],
                              (short)-1,
                              (byte)var3.b()[4],
                              (byte)var3.b()[3],
                              (byte)-1,
                              new int[]{1, var3.b()[5], var3.b()[6]}
                           );
                     } else if (var3.b()[0] == 1) {
                        this.K.o(var3.b()[1]);
                     }

                     var2.a((byte)5);
                     break label1125;
                  }

                  if (!this.L.d.aA()) {
                     break label1125;
                  }
                  break;
               case 88:
                  if (this.K.z() == 2) {
                     var2.b((byte)(var3.b()[0] - 2));
                  } else {
                     var2.b((byte)(var3.b()[1] - 2));
                  }
            }

            var2.a((byte)1);
         }

         if (var2.a() != 5 && var2.a() != 6) {
            var2.e();
         }

         if (var2.a() != 3 && var2.a() != 4) {
            var1++;
         } else {
            t = false;
            this.M.removeElement(var2);
            int var34 = game.l.e(var2.f()[0], var2.f()[1]);
            if (this.n[var34] != null) {
               this.n[var34][var2.b()] = var2.a();
            }

            if (var2.a() == 3 && var2.d().a() == 44 && var2.d().b()[1] == 1) {
               m(var2.d().b()[0]);
            }

            this.G();
            if (game.l.Y) {
               this.J.W.a(game.l.X, 1);
            }

            game.l.Y = false;
         }
      }
   }

   public final byte E() {
      return this.N;
   }

   public final boolean F() {
      if (this.l == null) {
         return false;
      }

      for (int var1 = 0; var1 < this.M.size(); var1++) {
         b.a var2;
         if ((var2 = (b.a)this.M.elementAt(var1)).a() != 2 && var2.a() != 6) {
            return true;
         }
      }

      return false;
   }

   private boolean a(b.b var1) {
      boolean var2 = false;
      if (var1.b()[7] == -1
         || var1.b()[7] != -1 && this.n[game.l.e(var1.b()[5], var1.b()[6])] != null && this.n[game.l.e(var1.b()[5], var1.b()[6])][var1.b()[7]] == 3) {
         label58:
         switch (var1.b()[8]) {
            case 0:
               if (!this.K.U[var1.b()[9]]) {
                  return var2;
               }
               break;
            case 1:
               return true;
            case 2:
               if (this.K.P.size() + this.K.B < var1.b()[9]) {
                  return var2;
               }

               for (int var3 = 0; var3 < this.K.B; var3++) {
                  if (this.K.A[var3].t() == var1.b()[10]) {
                     var2 = true;
                     break;
                  }
               }

               if (var2) {
                  return var2;
               }

               for (int var4 = 0; var4 < this.K.P.size(); var4++) {
                  if (((int[])this.K.P.elementAt(var4))[1] == var1.b()[10]) {
                     break label58;
                  }
               }

               return var2;
            case 3:
               if (this.K.G < var1.b()[9]) {
                  return var2;
               }
               break;
            case 4:
               if (this.K.a((byte)var1.b()[9], var1.b()[10]) != 2) {
                  return var2;
               }
               break;
            case 5:
               if (G <= var1.b()[9]) {
                  return var2;
               }
               break;
            case 6:
               if (G != var1.b()[9]) {
                  return var2;
               }
         }

         var2 = true;
      }

      return var2;
   }

   private boolean b(b.b var1) {
      boolean var2 = false;
      if (var1.b()[7] == -1
         || var1.b()[7] != -1 && this.n[game.l.e(var1.b()[5], var1.b()[6])] != null && this.n[game.l.e(var1.b()[5], var1.b()[6])][var1.b()[7]] == 3) {
         switch (var1.b()[8]) {
            case 0:
               if (this.K.a((byte)var1.b()[9], var1.b()[10]) == 2) {
                  var2 = true;
               }
               break;
            case 1:
               if (this.K.U[var1.b()[9]]) {
                  var2 = true;
               }
               break;
            case 2:
            case 4:
               if (this.n[game.l.e(var1.b()[5], var1.b()[6])] != null && this.n[game.l.e(var1.b()[5], var1.b()[6])][var1.b()[7]] == 3) {
                  var2 = true;
               }
               break;
            case 3:
               if (this.K.b(var1.b()[9], var1.b()[10], (byte)0)) {
                  var2 = true;
               }
               break;
            case 5:
               if (this.K.G >= var1.b()[9]) {
                  var2 = true;
               }
               break;
            case 6:
               byte[] var5 = new byte[]{0, 1, 2, 3};

               for (int var3 = 0; var3 < this.K.B; var3++) {
                  for (int var4 = 0; var4 < var5.length; var4++) {
                     if (var5[var4] != -1 && var5[var4] == a.b.c.a((byte)0, (short)this.K.A[var3].r(), (byte)1)) {
                        var5[var4] = -1;
                        break;
                     }
                  }
               }

               int var6 = 0;

               while (var6 < var5.length && var5[var6] == -1) {
                  var6++;
               }

               if (var6 >= var5.length) {
                  var2 = true;
               }
         }
      }

      return var2;
   }

   public final void G() {
      if (p == null) {
         p = new Vector();
      }

      p.removeAllElements();
      Vector var2 = new Vector();

      for (int var3 = 0; var3 < aq.length; var3++) {
         if (game.l.e(aq[var3][0], aq[var3][1]) == game.l.e(game.l.B().p, game.l.B().q) && (this.l[aq[var3][2]].a() == 0 || this.l[aq[var3][2]].a() == 4)) {
            b.b var1 = this.l[aq[var3][2]].d();
            if (!var2.contains("" + var1.b()[4])) {
               if (this.b(var1)) {
                  a.a.g var4;
                  (var4 = new a.a.g()).a(259, false);
                  var4.a((byte)1, (byte)-1, true);
                  var4.b(this.J.n[var1.b()[4]].j, this.J.n[var1.b()[4]].k - 40);
                  this.J.n[var1.b()[4]].f((byte)1);
                  h var6 = this.J.n[var1.b()[4]];
                  var4.q = var6;
                  var4.c();
                  p.addElement(var4);
                  var2.addElement("" + var1.b()[4]);
               } else {
                  int var9 = n(var1.b()[0]);
                  if (var1.b()[1] == 0
                        && this.n[game.l.e(ap[var3][0], ap[var3][1])][ap[var3][2]] == 3
                        && this.n[game.l.e(aq[var3][0], aq[var3][1])][aq[var3][2]] != 3
                     || var1.b()[1] == 1 && var9 != -1 && F[var9][1] == 1) {
                     a.a.g var10;
                     (var10 = new a.a.g()).a(259, false);
                     var10.a((byte)15, (byte)-1, true);
                     var10.b(this.J.n[var1.b()[4]].j, this.J.n[var1.b()[4]].k - 40);
                     this.J.n[var1.b()[4]].f((byte)1);
                     h var12 = this.J.n[var1.b()[4]];
                     var10.q = var12;
                     var10.c();
                     p.addElement(var10);
                     var2.addElement("" + var1.b()[4]);
                  }
               }
            }
         }
      }

      for (int var8 = 0; var8 < ap.length; var8++) {
         if (game.l.e(ap[var8][0], ap[var8][1]) == game.l.e(game.l.B().p, game.l.B().q) && (this.l[ap[var8][2]].a() == 0 || this.l[ap[var8][2]].a() == 4)) {
            b.b var7 = this.l[ap[var8][2]].d();
            if (!var2.contains("" + var7.b()[4]) && this.a(var7)) {
               a.a.g var11;
               (var11 = new a.a.g()).a(259, false);
               var11.a((byte)7, (byte)-1, true);
               var11.b(this.J.n[var7.b()[4]].j, this.J.n[var7.b()[4]].k - 40);
               this.J.n[var7.b()[4]].f((byte)1);
               h var13 = this.J.n[var7.b()[4]];
               var11.q = var13;
               var11.c();
               p.addElement(var11);
            }
         }
      }
   }

   public final int[] H() {
      int[] var1;
      (var1 = new int[4])[0] = this.am.get(1);
      var1[1] = this.am.get(2);
      var1[2] = this.am.get(5);
      var1[3] = this.am.get(11);
      return this.an;
   }

   public final int[] I() {
      return this.an;
   }

   public final void a(int[] var1) {
      this.an = var1;
   }
}
