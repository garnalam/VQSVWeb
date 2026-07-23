package game;

import java.util.Vector;

public final class j extends a.a.g {
   private static j Z;
   public int u;
   private int aa;
   private int ab;
   public byte v;
   private int ac;
   private boolean ad;
   public int w;
   private int ae;
   private int af;
   public int x;
   public int y;
   public boolean z;
   public i[] A;
   public int B;
   public byte[][] C;
   public byte[][] D;
   public byte[][] E;
   public byte[] F;
   public byte G;
   public byte H;
   public byte I;
   public byte J;
   public Vector K;
   public Vector L;
   public Vector M;
   public Vector N;
   public Vector O;
   public Vector P;
   public byte[] Q;
   public byte[] R;
   public short[] S;
   public Vector T;
   public boolean[] U;
   public static boolean V;
   public Vector W;
   private int ag;
   private int ah;
   public int[] X = new int[]{0, 16, 32, 48, 64, 76, 88};
   public int[] Y = new int[]{16, 16, 16, 16, 12, 12, 12};
   private static byte[][] ai = new byte[][]{{9, 2, 9, 3, 0}};
   private static short[][] aj = new short[][]{{0, 3, 112, 256}};
   private Vector ak = null;

   public static j p() {
      if (Z == null) {
         Z = new j();
      }

      return Z;
   }

   public final void q() {
      this.B = 0;
      Z = null;
   }

   public j() {
      this.d = new short[3];
      this.e = new short[3];
      this.A = new i[6];
      this.C = new byte[8][2];
      this.U = new boolean[21];
      this.K = new Vector();
      this.L = new Vector();
      int[] var1 = new int[]{0, 0, 1};
      this.L.addElement(var1);
      this.M = new Vector();
      this.N = new Vector();
      this.O = new Vector();
      this.P = new Vector();
      this.W = new Vector();
      this.D = new byte[7][];
      this.F = new byte[7];
      this.E = new byte[7][];
      this.S = new short[]{-1, -1, -1, -1, -1};

      for (int var3 = 0; var3 < this.E.length; var3++) {
         this.E[var3] = new byte[this.Y[var3]];

         for (int var2 = 0; var2 < this.E[var3].length; var2++) {
            this.E[var3][var2] = -1;
         }
      }

      this.D[0] = new byte[16];
      this.D[1] = new byte[16];
      this.D[2] = new byte[16];
      this.D[3] = new byte[16];
      this.D[4] = new byte[12];
      this.D[5] = new byte[12];
      this.D[6] = new byte[12];
      this.Q = new byte[4];
      this.R = new byte[4];
      this.v = 0;

      for (int var4 = 0; var4 < 8; var4++) {
         this.C[var4][0] = 0;
         this.C[var4][1] = 0;
      }

      for (int var5 = 0; var5 < 4; var5++) {
         this.Q[var5] = 0;
      }

      this.ag = 1000;
      this.ah = 0;
      this.u = -1;
      this.z = false;
   }

   public final void a(short[] var1) {
      if (this.u == -1) {
         this.a(0, false);
      }

      this.j = var1[0];
      this.k = var1[1];
      this.h(this.u);
      super.a.c();
      this.a((byte)0, (byte)var1[2]);
      short var4 = var1[3];
      byte var3 = 0;
      super.d[var3] = var4;
      var4 = var1[4];
      var3 = 1;
      super.d[var3] = var4;
      var4 = var1[5];
      var3 = 2;
      super.d[var3] = var4;
      if (this.u == -1) {
         this.h();
      }

      this.t = 1;
      this.ae = var1[6];
      this.af = var1[7];
      this.w = this.D();
      if (this.v == 1) {
         this.a((int)0, (int)107, true);
      }

      if (this.b == null) {
         this.b = new a.a.g();
         this.b.a(337, false);
      }

      this.b.b(this.j, this.k);
      if (this.a.a == 4) {
         this.b.a((byte)0, (byte)0, false);
      } else {
         this.b.a((byte)1, (byte)0, false);
      }

      this.b.c();
      Object var7 = null;
      super.q = (a.b.a)var7;
      this.z = true;
   }

   public final void r() {
      if (this.o() && this.q.i() != 0) {
         this.a(((a.a.g)this.q).a, this.a);
      } else {
         switch (this.i) {
            case 0:
               if (this.Q[2] != 2 && this.N()) {
                  this.a((byte)3, this.o);
                  return;
               }
               break;
            case 1:
               if (this.Q[2] != 2) {
                  game.l.E = this.J();
                  if (this.K() && this.L()) {
                     this.a(this.aa);
                     if (this.ab < 8) {
                        this.ab = this.ab + this.aa;
                     } else {
                        this.ab = 4;
                     }

                     this.O();
                     return;
                  }

                  this.ab = 0;
                  return;
               }

               int var3 = this.k;
               int var21 = this.j;
               j var14 = this;
               boolean var10000;
               switch (this.o) {
                  case 0:
                     var10000 = a.b.d.a().b(var21, var3 - 25 + var14.aa);
                     break;
                  case 1:
                     var10000 = a.b.d.a().b(var21 + var14.aa, var3 - 25);
                     break;
                  case 2:
                     var10000 = a.b.d.a().b(var21, var3 - 25 - var14.aa);
                     break;
                  case 3:
                     var10000 = a.b.d.a().b(var21 - var14.aa, var3 - 25);
                     break;
                  default:
                     var10000 = false;
               }

               if (!var10000) {
                  game.l.E = this.J();
                  int var22 = null;
                  super.q = var22;

                  for (int var15 = 0; var15 < game.l.B().n.length; var15++) {
                     this.y(var15);
                  }

                  var22 = 0;
                  this.a(super.e[var23]);
                  if (this.ab < 8) {
                     byte var24 = 0;
                     this.ab = this.ab + super.e[var24];
                  } else {
                     this.ab = 4;
                  }

                  this.O();
                  return;
               }
               break;
            case 2:
               if (this.K() && this.L()) {
                  this.a(this.aa);
                  if (this.ab < 8) {
                     this.ab = this.ab + this.aa;
                  } else {
                     this.ab = 4;
                  }

                  this.O();
                  return;
               }

               this.ab = 0;
               return;
            case 3:
            default:
               break;
            case 4:
               return;
            case 5:
               if (this.ac < 16) {
                  switch (this.n) {
                     case 0:
                     case 2:
                        if (this.n == 2) {
                           if (this.k > ((h)this.q).n() - 16) {
                              this.a((int)this.n, (int)4);
                           }
                        } else if (this.k < ((h)this.q).n() - 16) {
                           this.a((int)this.n, (int)4);
                        }

                        if (this.l > ((h)this.q).m()) {
                           if (this.j <= ((h)this.q).m()) {
                              this.c(((h)this.q).m());
                           } else {
                              this.a(3, 4);
                           }
                        } else if (this.l < ((h)this.q).m()) {
                           if (this.j >= ((h)this.q).m()) {
                              this.c(((h)this.q).m());
                           } else {
                              this.a(1, 4);
                           }
                        }
                        break;
                     case 1:
                     case 3:
                        if (this.n == 3) {
                           h var6;
                           if (this.j > (var6 = (h)this.q).j) {
                              this.a((int)this.n, (int)4);
                           }
                        } else {
                           h var7;
                           if (this.j < (var7 = (h)this.q).j) {
                              this.a((int)this.n, (int)4);
                           }
                        }

                        h var8;
                        if (this.m > (var8 = (h)this.q).k - 16) {
                           if (this.k <= (var8 = (h)this.q).k - 16) {
                              int var19 = (var8 = (h)this.q).k - 16;
                              super.k = var19;
                           } else {
                              this.a(2, 4);
                           }
                        } else if (this.m < (var8 = (h)this.q).k - 16) {
                           if (this.k >= (var8 = (h)this.q).k - 16) {
                              int var20 = (var8 = (h)this.q).k - 16;
                              super.k = var20;
                           } else {
                              this.a(0, 4);
                           }
                        }
                  }

                  if (this.ac % 4 == 3) {
                     this.a((byte)1, (byte)-1, false);
                  } else {
                     this.a((byte)(this.ac % 4), (byte)-1, false);
                  }

                  this.d((byte)(this.ac % 4));
                  this.ac++;
                  return;
               }

               byte var5 = 0;

               for (int var17 = 0; var17 < ai.length; var17++) {
                  byte[] var10001 = ai[var17];
                  if (game.l.B().p == var10001[0]) {
                     var10001 = ai[var17];
                     if (game.l.B().q == var10001[1]) {
                        game.l.B().p = ai[var17][2];
                        game.l.B().q = ai[var17][3];
                        var5 = ai[var17][4];
                        break;
                     }
                  }
               }

               for (int var18 = 0; var18 < aj[var5].length / 4; var18++) {
                  if (((h)this.q).J >= aj[var5][var18 << 2] && ((h)this.q).J <= aj[var5][(var18 << 2) + 1]) {
                     game.l.B().r = aj[var5][(var18 << 2) + 2];
                     game.l.B().s = aj[var5][(var18 << 2) + 3];
                     break;
                  }
               }

               V = true;
               game.l.B().t = -1;
               game.f.B().a((byte)9);
               return;
            case 6:
               if (this.M()) {
                  this.a(this.b((byte)2));
                  return;
               }

               this.a(this.c((byte)1));
               this.a((byte)0, this.o);
               return;
            case 7:
               if (((h)this.q).A == 0) {
                  if (this.ac < 7) {
                     this.a(4);
                     this.ac++;
                     return;
                  }

                  if (this.ac == 7) {
                     if (this.o == 3) {
                        this.a((byte)1, (byte)-1, false);
                     } else {
                        this.a(this.o, (byte)-1, false);
                     }

                     this.d(this.o);
                     ((h)this.q).r();
                     this.ac++;
                     return;
                  }
               } else if (((h)this.q).A == 2) {
                  if (this.ac < 8 && this.ac > 0) {
                     this.a(4);
                     this.ac--;
                     return;
                  }

                  if (this.ac == 8) {
                     this.a((byte)7, this.o);
                     this.ac--;
                     return;
                  }

                  ((h)this.q).A = 0;
                  ((h)this.q).a(null);
                  this.a((a.b.a)null);
                  this.a((byte)0, this.o);
                  return;
               }
               break;
            case 8:
               if (this.ac < 16) {
                  if (this.ac % 4 == 3) {
                     this.a((byte)1, (byte)-1, false);
                  } else {
                     this.a((byte)(this.ac % 4), (byte)-1, false);
                  }

                  this.d((byte)(this.ac % 4));
                  this.ac++;
                  return;
               }

               int var4 = game.l.B().n[game.l.B().t].j - game.l.B().n[game.l.B().t].j % this.b((byte)2);
               int var16 = game.l.B().n[game.l.B().t].k - game.l.B().n[game.l.B().t].k % this.b((byte)2);
               this.b(var4, var16);
               this.b.b(var4, var16);
               this.a((byte)0, game.l.B().n[game.l.B().t].D);
               this.a(32);
               a.b.b.a().a(8);
               a.b.b.a().a(false);
               return;
            case 9:
               if (this.ac < 16) {
                  if (this.ac % 4 == 3) {
                     this.a((byte)1, (byte)-1, false);
                  } else {
                     this.a((byte)(this.ac % 4), (byte)-1, false);
                  }

                  this.d((byte)(this.ac % 4));
                  this.ac++;
                  return;
               }

               int var1 = game.l.B().n[game.l.B().t].j - game.l.B().n[game.l.B().t].j % this.b((byte)2);
               int var2 = game.l.B().n[game.l.B().t].k - game.l.B().n[game.l.B().t].k % this.b((byte)2);
               this.b(var1, var2);
               this.b.b(var1, var2);
               this.a((byte)10, this.o);
               a.b.b.a().a(8);
               a.b.b.a().a(false);
               return;
            case 10:
               if (this.ac > 0) {
                  if (this.ac % 4 == 3) {
                     this.a((byte)1, (byte)-1, false);
                  } else {
                     this.a((byte)(this.ac % 4), (byte)-1, false);
                  }

                  this.d((byte)(this.ac % 4));
                  this.ac--;
                  return;
               }

               this.a((byte)0, game.l.B().n[game.l.B().t].D);
               this.a(32);
         }
      }
   }

   public final void a(byte var1, byte var2) {
      while (true) {
         switch (var1) {
            case 0:
               if (this.Q[2] != 2 && this.N()) {
                  var1 = 3;
                  this = this;
                  continue;
               }

               if (var2 == 3) {
                  this.a((byte)1, (byte)-1, false);
               } else {
                  this.a(var2, (byte)-1, false);
               }

               var2 = var2;
               super.o = var2;
               break;
            case 1:
               if (this.Q[2] != 2 && this.N()) {
                  var1 = 2;
                  this = this;
                  continue;
               }

               if (super.a.g() < 6) {
                  if (var2 == 3) {
                     this.a((byte)4, (byte)-1, var2);
                  } else {
                     this.a((byte)(var2 + 3), (byte)-1, var2);
                  }
               } else {
                  if (var2 == 3) {
                     this.a((byte)(var1 * 3 + 1), (byte)-1, false);
                  } else {
                     this.a((byte)(var1 * 3 + var2), (byte)-1, false);
                  }

                  var2 = var2;
                  super.o = var2;
               }
               break;
            case 2:
               if (this.N()) {
                  if (super.a.g() < 9) {
                     if (var2 == 3) {
                        this.a((byte)7, (byte)-1, var2);
                     } else {
                        this.a((byte)(var2 + 6), (byte)-1, var2);
                     }
                  } else if (var2 == 3) {
                     this.a((byte)(var1 * 3 + 1), (byte)-1, false);
                  } else {
                     this.a((byte)(var1 * 3 + var2), (byte)-1, false);
                  }
               } else if (var2 == 3) {
                  this.a((byte)(this.i * 3 + 1), (byte)-1, false);
               } else {
                  this.a((byte)(this.i * 3 + var2), (byte)-1, false);
               }

               var2 = var2;
               super.o = var2;
               break;
            case 3:
               if (var2 == 3) {
                  this.a((byte)(var1 * 3 + 1), (byte)-1, false);
               } else {
                  this.a((byte)(var1 * 3 + var2), (byte)-1, false);
               }

               var2 = var2;
               super.o = var2;
               break;
            case 4:
               this.a((byte)(var1 * 3), (byte)-2, false);
               var2 = var2;
               super.o = var2;
               this.ab = 0;
               break;
            case 5:
               this.ac = 0;
               int var4 = var2;
               super.n = (byte)var4;
               int var5 = this.k;
               var4 = this.j;
               j var3 = this;
               super.l = var4;
               var3.m = var5;
               if (var2 == 3) {
                  this.a((byte)1, (byte)-1, false);
               } else {
                  this.a(var2, (byte)-1, false);
               }

               var2 = var2;
               super.o = var2;
               break;
            case 6:
               if (var2 == 3) {
                  this.a((byte)1, (byte)-1, false);
               } else {
                  this.a(var2, (byte)-1, false);
               }

               var2 = var2;
               super.o = var2;
               break;
            case 7:
               if (var2 == 3) {
                  this.a((byte)4, (byte)-1, false);
               } else {
                  this.a((byte)(var2 + 3), (byte)-1, false);
               }

               var2 = var2;
               super.o = var2;
               break;
            case 8:
            case 9:
               this.ac = 0;
               var2 = var2;
               super.o = var2;
         }

         this.i = var1;
         if (this.i != 0 && this.i != 1) {
            if (game.l.B().y != null) {
               game.l.B().y.b(false);
            }
         } else if (game.l.B().y != null) {
            game.l.B().y.b(true);
            return;
         }

         return;
      }
   }

   public final boolean f(int var1) {
      return this.Q[var1] != 0;
   }

   public final boolean g(int var1) {
      return this.R[var1] != 1;
   }

   public final boolean s() {
      return this.u != 2 || a.b.d.a().a(0, this.j + 7, this.k + 7) == 0 && a.b.d.a().a(0, this.j - 8, this.k - 8) == 0;
   }

   public final void h(int var1) {
      if (var1 != -1) {
         this.Q[var1] = 2;
         this.a.b();
         this.a(var1 + 1, false);
         super.a.c();
         this.a((byte)0, this.o);
         if (this.v == 1) {
            this.a((int)1, (int)107, true);
         }

         if ((this.Q[var1] != 2 || var1 != 0) && (this.Q[var1] != 2 || var1 != 1)) {
            byte var7 = 4;
            byte var5 = 0;
            super.e[var5] = var7;
         } else {
            byte var4 = 8;
            byte var3 = 0;
            super.e[var3] = var4;
         }

         if (this.Q[2] == 2 && game.l.B().y != null) {
            game.l.B().y.d();
         }

         this.u = var1;
         byte var6 = 0;
         this.aa = super.e[var6];
      }
   }

   public final void t() {
      this.a.b();
      this.a(0, false);
      super.a.c();

      for (int var1 = 0; var1 < 4; var1++) {
         if (this.Q[var1] == 2) {
            this.Q[var1] = 1;
         }
      }

      if (this.v == 1) {
         this.a((int)0, (int)107, true);
      }

      if (game.l.B().y != null) {
         game.l.B().y.c();
      }

      byte var2 = 0;
      short var3 = super.d[var2];
      var2 = 0;
      super.e[var2] = var3;
      this.u = -1;
   }

   public final void u() {
      this.v = 1;
      boolean var1 = false;

      for (int var2 = 0; var2 < 4; var2++) {
         if (this.Q[var2] == 2) {
            var1 = true;
            break;
         }
      }

      if (var1) {
         this.a((int)1, (int)107, true);
      } else {
         this.a((int)0, (int)107, true);
      }
   }

   public final void v() {
      this.v = 0;
      boolean var1 = false;

      for (int var2 = 0; var2 < 4; var2++) {
         if (this.Q[var2] == 2) {
            var1 = true;
            break;
         }
      }

      if (var1) {
         this.a((int)1, (int)100, true);
      } else {
         this.a((int)0, (int)100, true);
      }
   }

   private short J() {
      for (short var1 = 0; var1 < game.l.B().n.length; var1++) {
         if (game.l.B().n[var1].k()) {
            if ((
                  game.l.B().n[var1].a.a <= 85
                     || game.l.B().n[var1].a.a == 226
                     || game.l.B().n[var1].a.a == 92
                     || game.l.B().n[var1].a.a == 102
                     || game.l.B().n[var1].a.a == 137
               )
               && game.l.B().n[var1].u == 0
               && (game.l.B().n[var1].w == 1 || game.l.B().n[var1].w == 18)
               && this.a(game.l.B().n[var1], this.a.k(), game.l.B().n[var1].a.k())) {
               if (game.l.B().n[var1].v() == 0) {
                  game.l.B().a((byte)13, game.l.B().n[var1].j, game.l.B().n[var1].k - 40, game.l.B().n[var1]);
                  if (game.l.B().n[var1].H != null) {
                     game.l.B().n[var1].H.d();
                  }
               } else if (game.l.B().n[var1].v() == 1) {
                  game.l.B().a((byte)13, game.l.B().n[var1].j, game.l.B().n[var1].k - 40, game.l.B().n[var1]);
                  if (game.e.p != null && game.e.p.size() > 0) {
                     for (int var2 = 0; var2 < game.e.p.size(); var2++) {
                        if (((a.a.g)game.e.p.elementAt(var2)).q.equals(game.l.B().n[var1])) {
                           ((a.a.g)game.e.p.elementAt(var2)).d();
                           break;
                        }
                     }
                  }
               } else {
                  game.l.B().a((byte)13, game.l.B().n[var1].j, game.l.B().n[var1].k - 40, game.l.B().n[var1]);
                  if (game.l.B().n[var1].x != 0) {
                     game.l.B().n[var1].x();
                  }
               }

               return var1;
            }

            if (game.l.B().n[var1].u == 2 && this.a(game.l.B().n[var1], this.a.k(), game.l.B().n[var1].a.k())) {
               game.l.B().m(var1);
            }
         }
      }

      game.l.B().D();
      game.e.s = false;
      return -1;
   }

   private boolean y(int var1) {
      switch (game.l.B().n[var1].u) {
         case 3:
            short[] var2;
            short var3 = (var2 = game.l.B().n[var1].a.k())[0];
            short var4 = var2[1];
            short var5 = (short)(var2[2] + 16);
            short var6 = (short)(var2[3] + 16);
            if (game.l.B().n[var1].v && this.a(game.l.B().n[var1], this.a.k(), new short[]{var3, var4, var5, var6})) {
               h var7 = game.l.B().n[var1];
               super.q = var7;
            }
         default:
            return true;
      }
   }

   private boolean K() {
      Object var4 = null;
      super.q = (a.b.a)var4;
      boolean var1 = true;
      if (this.ak != null) {
         this.ak.removeAllElements();
      }

      for (int var2 = 0; var2 < game.l.B().n.length; var2++) {
         this.y(var2);
         if (game.l.B().n[var2].v && this.a(game.l.B().n[var2], this.a.k(), game.l.B().n[var2].a.k())) {
            switch (game.l.B().n[var2].u) {
               case 0:
                  switch (game.l.B().n[var2].w) {
                     case 0:
                        return false;
                     case 1:
                     case 2:
                     case 3:
                     case 12:
                     case 13:
                     default:
                        continue;
                     case 4:
                     case 11:
                        if (game.l.B().n[var2].i() != 2 && game.l.B().n[var2].k()) {
                           var4 = game.l.B().n[var2];
                           super.q = (a.b.a)var4;
                           return false;
                        }
                        continue;
                     case 5:
                        if (game.l.B().n[var2].i() != 2) {
                           if (this.C[5][0] == 2) {
                              var4 = game.l.B().n[var2];
                              super.q = (a.b.a)var4;
                           }

                           return false;
                        }
                     case 6:
                        if (game.l.B().n[var2].i() != 2) {
                           if (this.Q[3] != 2) {
                              if (this.C[2][0] == 2) {
                                 var4 = game.l.B().n[var2];
                                 super.q = (a.b.a)var4;
                                 if (this.ak == null) {
                                    this.ak = new Vector();
                                 }

                                 this.ak.addElement(game.l.B().n[var2]);
                                 game.l.B().n[var2].f(20);
                              }

                              var1 = false;
                           } else {
                              game.l.B().n[var2].a((byte)1);
                              game.l.B().l.a(game.l.B().n[var2], 2);
                           }
                        }
                        continue;
                     case 7:
                        if (game.l.B().n[var2].i() != 2) {
                           if (this.Q[3] != 2) {
                              if (this.C[1][0] == 2) {
                                 var4 = game.l.B().n[var2];
                                 super.q = (a.b.a)var4;
                                 if (this.ak == null) {
                                    this.ak = new Vector();
                                 }

                                 this.ak.addElement(game.l.B().n[var2]);
                                 game.l.B().n[var2].f(30);
                              }

                              var1 = false;
                           } else {
                              game.l.B().n[var2].a((byte)1);
                              game.l.B().l.a(game.l.B().n[var2], 2);
                           }
                        }
                        continue;
                     case 8:
                        if (game.l.B().n[var2].k()) {
                           if ((h)game.l.B().n[var2].q != null && ((h)game.l.B().n[var2].q).C > ((h)game.l.B().n[var2].q).B) {
                              return false;
                           }

                           for (int var5 = 0; var5 < game.l.B().n.length; var5++) {
                              if (game.l.B().n[var5].v
                                 && !game.l.B().n[var5].equals(game.l.B().n[var2])
                                 && game.l.B().n[var5].u == 0
                                 && (game.l.B().n[var5].w == 8 || game.l.B().n[var5].w == 11)) {
                                 switch (this.o) {
                                    case 0:
                                       if (a.e.a(
                                          game.l.B().n[var2].j,
                                          game.l.B().n[var2].k + 8,
                                          game.l.B().n[var5].j,
                                          game.l.B().n[var5].k,
                                          game.l.B().n[var2].a.k(),
                                          game.l.B().n[var5].a.k()
                                       )) {
                                          return false;
                                       }
                                       break;
                                    case 1:
                                       if (a.e.a(
                                          game.l.B().n[var2].j + 8,
                                          game.l.B().n[var2].k,
                                          game.l.B().n[var5].j,
                                          game.l.B().n[var5].k,
                                          game.l.B().n[var2].a.k(),
                                          game.l.B().n[var5].a.k()
                                       )) {
                                          return false;
                                       }
                                       break;
                                    case 2:
                                       if (a.e.a(
                                          game.l.B().n[var2].j,
                                          game.l.B().n[var2].k - 8,
                                          game.l.B().n[var5].j,
                                          game.l.B().n[var5].k,
                                          game.l.B().n[var2].a.k(),
                                          game.l.B().n[var5].a.k()
                                       )) {
                                          return false;
                                       }
                                       break;
                                    case 3:
                                       if (a.e.a(
                                          game.l.B().n[var2].j - 8,
                                          game.l.B().n[var2].k,
                                          game.l.B().n[var5].j,
                                          game.l.B().n[var5].k,
                                          game.l.B().n[var2].a.k(),
                                          game.l.B().n[var5].a.k()
                                       )) {
                                          return false;
                                       }
                                 }
                              }
                           }

                           game.l.B().n[var2].a((byte)1);
                           h var18 = game.l.B().n[var2];
                           var4 = this.o;
                           var18.o = (byte)var4;
                           return false;
                        }
                        continue;
                     case 9:
                        if (a.b.d.a().a(0, this.j, this.k) == 2 || a.b.d.a().a(0, this.j, this.k) == 1) {
                           return false;
                        }

                        if (this.o == 3 || this.o == 1) {
                           this.ac = 0;
                           this.a((byte)7, this.o);
                           h var17 = game.l.B().n[var2];
                           var4 = this;
                           var17.q = (a.b.a)var4;
                           var4 = game.l.B().n[var2];
                           super.q = (a.b.a)var4;
                           return false;
                        }
                        continue;
                     case 10:
                        if (a.b.d.a().a(0, this.j, this.k) == 2 || a.b.d.a().a(0, this.j, this.k) == 1) {
                           return false;
                        }

                        if (this.o == 0 || this.o == 2) {
                           this.ac = 0;
                           this.a((byte)7, this.o);
                           h var10000 = game.l.B().n[var2];
                           var4 = this;
                           var10000.q = (a.b.a)var4;
                           var4 = game.l.B().n[var2];
                           super.q = (a.b.a)var4;
                           return false;
                        }
                        continue;
                     case 14:
                        return false;
                     case 15:
                        if (game.l.B().n[var2].i() != 2) {
                           if (this.U[6]) {
                              var4 = game.l.B().n[var2];
                              super.q = (a.b.a)var4;
                              return false;
                           }

                           game.l.B().n[var2].a((byte)1);
                           game.l.B().l.a(game.l.B().n[var2], 2);
                        }
                        continue;
                     case 16:
                        var4 = game.l.B().n[var2];
                        super.q = (a.b.a)var4;
                        continue;
                  }
               case 1:
                  if (game.l.B().n[var2].w == 3) {
                     return false;
                  }
               case 2:
               default:
                  break;
               case 3:
                  return false;
            }
         }
      }

      return var1;
   }

   private boolean L() {
      byte var7 = 0;
      this.aa = super.e[var7];
      int var1 = this.j - 8;
      int var2 = this.k - 8;
      int var3 = this.j + 7;
      int var4 = this.k + 7;
      byte[] var5 = new byte[]{-1, -1, -1, -1, -1};
      switch (this.o) {
         case 2:
            if (a.b.d.a().b(this.j, var2 - this.aa)) {
               return false;
            }

            var5[0] = a.b.d.a().a(0, var1, var2 - this.aa);
            var5[1] = a.b.d.a().a(0, var3, var2 - this.aa);
            var5[2] = a.b.d.a().a(0, this.j, var2 - this.aa);
            if (this.a(var5[0]) || this.a(var5[1])) {
               if (!this.a(var5[0])) {
                  var7 = 1;
                  this.aa = super.e[var7];
                  return this.c(var5[1], (byte)1);
               }

               if (!this.a(var5[1])) {
                  var7 = 1;
                  this.aa = super.e[var7];
                  return this.c(var5[0], (byte)3);
               }

               return this.c(var5[2], (byte)2);
            }

            if (a.b.d.a().a(0, this.j, this.k) == 3) {
               return false;
            }

            var5[0] = a.b.d.a().a(0, this.j - 16, var2 - this.aa);
            var5[1] = a.b.d.a().a(0, this.j + 16, var2 - this.aa);
            var5[3] = a.b.d.a().a(0, this.j - 16, this.k);
            var5[4] = a.b.d.a().a(0, this.j + 16, this.k);
            var7 = 1;
            this.aa = super.e[var7];
            if (!this.a(var5[0])) {
               return this.c(var5[1], (byte)1);
            }

            if (!this.a(var5[1])) {
               return this.c(var5[0], (byte)3);
            }

            if (this.a(var5[4])) {
               return this.c(var5[1], (byte)1);
            }

            if (this.a(var5[3])) {
               return this.c(var5[0], (byte)3);
            }
         case 0:
            if (a.b.d.a().b(this.j, var4 + this.aa)) {
               return false;
            }

            var5[0] = a.b.d.a().a(0, var1, var4 + this.aa);
            var5[1] = a.b.d.a().a(0, var3, var4 + this.aa);
            var5[2] = a.b.d.a().a(0, this.j, var4 + this.aa);
            if (this.a(var5[0]) || this.a(var5[1])) {
               if (!this.a(var5[0])) {
                  var7 = 1;
                  this.aa = super.e[var7];
                  return this.c(var5[1], (byte)1);
               }

               if (!this.a(var5[1])) {
                  var7 = 1;
                  this.aa = super.e[var7];
                  return this.c(var5[0], (byte)3);
               }

               return this.c(var5[2], (byte)0);
            }

            if (a.b.d.a().a(0, this.j, this.k) == 3) {
               return false;
            }

            var5[0] = a.b.d.a().a(0, var1 - 16, var4 + this.aa);
            var5[1] = a.b.d.a().a(0, var3 + 16, var4 + this.aa);
            var5[3] = a.b.d.a().a(0, this.j - 16, this.k);
            var5[4] = a.b.d.a().a(0, this.j + 16, this.k);
            var7 = 1;
            this.aa = super.e[var7];
            if (!this.a(var5[0])) {
               return this.c(var5[1], (byte)1);
            }

            if (!this.a(var5[1])) {
               return this.c(var5[0], (byte)3);
            }

            if (this.a(var5[4])) {
               return this.c(var5[1], (byte)1);
            }

            if (this.a(var5[3])) {
               return this.c(var5[0], (byte)3);
            }
         case 3:
            if (a.b.d.a().b(var1 - this.aa, this.k)) {
               return false;
            }

            var5[0] = a.b.d.a().a(0, var1 - this.aa, var2);
            var5[1] = a.b.d.a().a(0, var1 - this.aa, var4);
            var5[2] = a.b.d.a().a(0, var1 - this.aa, this.k);
            if (this.a(var5[0]) || this.a(var5[1])) {
               if (!this.a(var5[0])) {
                  var7 = 1;
                  this.aa = super.e[var7];
                  return this.c(var5[1], (byte)0);
               }

               if (!this.a(var5[1])) {
                  var7 = 1;
                  this.aa = super.e[var7];
                  return this.c(var5[0], (byte)2);
               }

               return this.c(var5[2], (byte)3);
            }

            if (a.b.d.a().a(0, this.j, this.k) == 3) {
               return false;
            }

            var5[0] = a.b.d.a().a(0, var1 - this.aa, var2 - 16);
            var5[1] = a.b.d.a().a(0, var1 - this.aa, var4 + 16);
            var5[3] = a.b.d.a().a(0, this.j, this.k - 16);
            var5[4] = a.b.d.a().a(0, this.j, this.k + 16);
            var7 = 1;
            this.aa = super.e[var7];
            if (!this.a(var5[0])) {
               return this.c(var5[1], (byte)0);
            }

            if (!this.a(var5[1])) {
               return this.c(var5[0], (byte)2);
            }

            if (this.a(var5[4])) {
               return this.c(var5[1], (byte)0);
            }

            if (this.a(var5[3])) {
               return this.c(var5[0], (byte)2);
            }
         case 1:
            if (a.b.d.a().b(var3 + this.aa, this.k)) {
               return false;
            }

            var5[0] = a.b.d.a().a(0, var3 + this.aa, var2);
            var5[1] = a.b.d.a().a(0, var3 + this.aa, var4);
            var5[2] = a.b.d.a().a(0, var3 + this.aa, this.k);
            if (this.a(var5[0]) || this.a(var5[1])) {
               if (!this.a(var5[0])) {
                  var7 = 1;
                  this.aa = super.e[var7];
                  return this.c(var5[1], (byte)0);
               }

               if (!this.a(var5[1])) {
                  var7 = 1;
                  this.aa = super.e[var7];
                  return this.c(var5[0], (byte)2);
               }

               return this.c(var5[2], (byte)1);
            }

            if (a.b.d.a().a(0, this.j, this.k) == 3) {
               return false;
            }

            var5[0] = a.b.d.a().a(0, var3 + this.aa, var2 - 16);
            var5[1] = a.b.d.a().a(0, var3 + this.aa, var4 + 16);
            var5[3] = a.b.d.a().a(0, this.j, this.k - 16);
            var5[4] = a.b.d.a().a(0, this.j, this.k + 16);
            var7 = 1;
            this.aa = super.e[var7];
            if (!this.a(var5[0])) {
               return this.c(var5[1], (byte)0);
            }

            if (!this.a(var5[1])) {
               return this.c(var5[0], (byte)2);
            }

            if (this.a(var5[4])) {
               return this.c(var5[1], (byte)0);
            }

            if (this.a(var5[3])) {
               return this.c(var5[0], (byte)2);
            }
      }

      return true;
   }

   private boolean a(byte var1) {
      switch (var1) {
         case 1:
            return false;
         case 2:
            if (this.C[3][0] != 2) {
               return false;
            }

            return true;
         default:
            return true;
      }
   }

   public final boolean a(h var1, short[] var2, short[] var3) {
      if (var3 == null) {
         return false;
      }

      switch (this.o) {
         case 0:
            if (var1.w == 14) {
               byte var12 = 0;
               return a(var1, var3, var2, this.j, this.k + super.e[var12]);
            }

            byte var11 = 0;
            if (a.e.a(this.j, this.k + super.e[var11], var1.j, var1.k, var2, var3)) {
               return true;
            }
            break;
         case 1:
            if (var1.w == 14) {
               byte var10 = 0;
               return a(var1, var3, var2, this.j + super.e[var10], this.k);
            }

            byte var9 = 0;
            if (a.e.a(this.j + super.e[var9], this.k, var1.j, var1.k, var2, var3)) {
               return true;
            }
            break;
         case 2:
            if (var1.w == 14) {
               byte var8 = 0;
               return a(var1, var3, var2, this.j, this.k - super.e[var8]);
            }

            byte var7 = 0;
            if (a.e.a(this.j, this.k - super.e[var7], var1.j, var1.k, var2, var3)) {
               return true;
            }
            break;
         case 3:
            if (var1.w == 14) {
               byte var6 = 0;
               return a(var1, var3, var2, this.j - super.e[var6], this.k);
            }

            byte var5 = 0;
            if (a.e.a(this.j - super.e[var5], this.k, var1.j, var1.k, var2, var3)) {
               return true;
            }
      }

      return false;
   }

   private static boolean a(h var0, short[] var1, short[] var2, int var3, int var4) {
      switch (var0.a.g()) {
         case 0:
            if (a.e.a(var0.j + var1[0], var0.k + var1[1], var1[2], var1[3] + (var0.B << 4), var3, var4, var2)) {
               return true;
            }
            break;
         case 1:
            if (a.e.a(var0.j + var1[0], var0.k + var1[1], var1[2] + (var0.B << 4), var1[3], var3, var4, var2)) {
               return true;
            }
            break;
         case 2:
            if (a.e.a(var0.j + var1[0], var0.k + var1[1] - (var0.B << 4), var1[2], var1[3] + (var0.B << 4), var3, var4, var2)) {
               return true;
            }
            break;
         case 3:
            if (a.e.a(var0.j + var1[0] - (var0.B << 4), var0.k + var1[1], var1[2] + (var0.B << 4), var1[3], var3, var4, var2)) {
               return true;
            }
      }

      return false;
   }

   private boolean M() {
      boolean var1 = true;
      switch (this.o) {
         case 0:
            var1 = this.a(a.b.d.a().a(0, this.j, this.k + 16));
            break;
         case 1:
            var1 = this.a(a.b.d.a().a(0, this.j + 16, this.k));
            break;
         case 2:
            var1 = this.a(a.b.d.a().a(0, this.j, this.k - 16));
            break;
         case 3:
            var1 = this.a(a.b.d.a().a(0, this.j - 16, this.k));
      }

      return var1 && a.b.d.a().a(0, this.j, this.k) != 3 ? false : var1;
   }

   private boolean N() {
      boolean var1 = true;
      switch (this.o) {
         case 0:
            a.b.d var8 = a.b.d.a();
            byte var5 = 0;
            var1 = this.a(var8.a(0, this.j, this.k + super.e[var5]));
            break;
         case 1:
            a.b.d var7 = a.b.d.a();
            byte var4 = 0;
            var1 = this.a(var7.a(0, this.j + super.e[var4], this.k));
            break;
         case 2:
            a.b.d var6 = a.b.d.a();
            byte var3 = 0;
            var1 = this.a(var6.a(0, this.j, this.k - super.e[var3]));
            break;
         case 3:
            a.b.d var10001 = a.b.d.a();
            byte var2 = 0;
            var1 = this.a(var10001.a(0, this.j - super.e[var2], this.k));
      }

      return var1 && a.b.d.a().a(0, this.j, this.k) != 2 ? false : var1;
   }

   private boolean c(byte var1, byte var2) {
      switch (var1) {
         case -1:
         case 0:
            this.a((byte)1, var2);
            break;
         case 1:
            if (a.b.d.a().a(0, this.j, this.k) == 2) {
               this.a((byte)2, var2);
            }

            return false;
         case 2:
            if (!this.a((byte)2)) {
               return false;
            }

            this.a((byte)2, var2);
            break;
         case 3:
            this.a((byte)6, var2);
         case 4:
      }

      return true;
   }

   public final void w() {
      if (((h)this.q).i() == 1) {
         game.l.B().d.az();
         game.l.B().d.b("Bảo rương này đã trống");
      } else if (((h)this.q).w == 0) {
         ((h)this.q).a((byte)1);
         if (this.a(((h)this.q).G, ((h)this.q).E, (byte)((h)this.q).F)) {
            this.c(((h)this.q).G, ((h)this.q).E, (byte)((h)this.q).F);
            String var2 = null;
            if (((h)this.q).F == 0) {
               var2 = a.a.c(a.b.c.c[4][((h)this.q).G][0]);
            } else if (((h)this.q).F == 2) {
               var2 = a.a.c(a.b.c.c[3][((h)this.q).G][0]);
            }

            game.l.B().d.a("Đạt được: " + var2, ((h)this.q).E);
         } else {
            game.l.B().d.ay();
         }

         this.a((byte)0, this.o);
      } else {
         if (((h)this.q).w == 1) {
            if (this.b(17, 1, (byte)2)) {
               ((h)this.q).a((byte)1);
               this.d(17, 1, (byte)2);
               if (this.a(((h)this.q).G, ((h)this.q).E, (byte)((h)this.q).F)) {
                  this.c(((h)this.q).G, ((h)this.q).E, (byte)((h)this.q).F);
                  String var1 = null;
                  if (((h)this.q).F == 0) {
                     var1 = a.a.c(a.b.c.c[4][((h)this.q).G][0]);
                  } else if (((h)this.q).F == 2) {
                     var1 = a.a.c(a.b.c.c[3][((h)this.q).G][0]);
                  }

                  game.l.B().d.a("Đạt được: " + var1, ((h)this.q).E);
               } else {
                  game.l.B().d.ay();
               }
            } else {
               game.l.B().d.ax();
            }

            this.a((byte)0, this.o);
         }
      }
   }

   public final boolean x() {
      if (this.q == null) {
         return false;
      }

      if (((h)this.q).i() != 0) {
         return false;
      }

      game.e.t = true;
      if (((h)this.q).w == 7 || ((h)this.q).w == 6) {
         for (int var1 = 0; var1 < this.ak.size(); var1++) {
            h var2;
            (var2 = (h)this.ak.elementAt(var1)).a((byte)1);
            var2.y();
         }

         this.ak.removeAllElements();
      } else if (((h)this.q).w != 16) {
         ((h)this.q).a((byte)1);
      }

      return true;
   }

   private static boolean a(int var0, int var1, Vector var2) {
      for (int var4 = 0; var4 < var2.size(); var4++) {
         int[] var3;
         if ((var3 = (int[])var2.elementAt(var4))[0] == var0) {
            if (var3[1] < 99) {
               return true;
            }

            return false;
         }
      }

      return var1 <= 99;
   }

   private static boolean b(int var0, int var1, Vector var2) {
      for (int var4 = 0; var4 < var2.size(); var4++) {
         int[] var3;
         if ((var3 = (int[])var2.elementAt(var4))[0] == var0) {
            if (var3[1] - var1 >= 0) {
               return true;
            }

            return false;
         }
      }

      return false;
   }

   private static boolean c(int var0, int var1, Vector var2) {
      for (int var4 = 0; var4 < var2.size(); var4++) {
         int[] var3;
         if ((var3 = (int[])var2.elementAt(var4))[0] == var0) {
            var3[1] += var1;
            if (var3[1] >= 99) {
               var3[1] = 99;
            }

            return true;
         }
      }

      int[] var5 = new int[]{var0, var1, 0};
      var2.addElement(var5);
      return false;
   }

   private static boolean d(int var0, int var1, Vector var2) {
      for (int var4 = 0; var4 < var2.size(); var4++) {
         int[] var3;
         if ((var3 = (int[])var2.elementAt(var4))[0] == var0) {
            var3[1] -= var1;
            if (var3[1] <= 0 && var3[2] == 0) {
               var2.removeElementAt(var4);
            }

            return true;
         }
      }

      return false;
   }

   public final boolean i(int var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < this.B; var3++) {
         if (var3 != var1 && this.A[var3].T()) {
            var2++;
         }
      }

      return var2 > 0;
   }

   public final boolean a(int var1, int var2, byte var3) {
      switch (var3) {
         case 0:
            if (a.b.c.c[4][var1][5] == 0) {
               return a(var1, var2, this.L);
            }

            return a(var1, var2, this.K);
         case 2:
            if (var1 >= 12) {
               return a(var1, var2, this.N);
            } else {
               var2 = var1;
               j var4 = this;

               for (int var6 = 0; var6 < var4.M.size(); var6++) {
                  if (((int[])var4.M.elementAt(var6))[0] == var2) {
                     return false;
                  }
               }

               return true;
            }
         default:
            return false;
      }
   }

   public final boolean b(int var1, int var2, byte var3) {
      switch (var3) {
         case 0:
            if (a.b.c.c[4][var1][5] == 0) {
               return b(var1, var2, this.L);
            }

            return b(var1, var2, this.K);
         case 2:
            return b(var1, var2, this.N);
         default:
            return false;
      }
   }

   public final boolean c(int var1, int var2, byte var3) {
      switch (var3) {
         case 0:
            if (a.b.c.c[4][var1][5] == 0) {
               return c(var1, var2, this.L);
            }

            return c(var1, var2, this.K);
         case 2:
            if (var1 >= 12) {
               if (var1 == 17) {
                  return c(var1, var2 * 5, this.N);
               }

               return c(var1, var2, this.N);
            }

            var2 = var1;
            j var4 = this;
            int[] var6 = new int[]{var2, 0, 0};
            var4.M.addElement(var6);
            return true;
         default:
            return false;
      }
   }

   public final boolean d(int var1, int var2, byte var3) {
      switch (var3) {
         case 0:
            if (a.b.c.c[4][var1][5] == 0) {
               return d(var1, var2, this.L);
            }

            return d(var1, var2, this.K);
         case 2:
            return d(var1, var2, this.N);
         default:
            return false;
      }
   }

   public final int a(int var1, byte var2) {
      switch (var2) {
         case 0:
            if (a.b.c.c[4][var1][5] == 0) {
               for (int var7 = 0; var7 < this.L.size(); var7++) {
                  int[] var5;
                  if ((var5 = (int[])this.L.elementAt(var7))[0] == var1) {
                     return var5[1];
                  }
               }
            } else {
               for (int var8 = 0; var8 < this.K.size(); var8++) {
                  int[] var6;
                  if ((var6 = (int[])this.K.elementAt(var8))[0] == var1) {
                     return var6[1];
                  }
               }
            }
            break;
         case 2:
            for (int var3 = 0; var3 < this.N.size(); var3++) {
               int[] var4;
               if ((var4 = (int[])this.N.elementAt(var3))[0] == var1) {
                  return var4[1];
               }
            }
      }

      return 0;
   }

   public final void y() {
      if (this.T == null) {
         this.T = new Vector();
      } else {
         this.T.removeAllElements();
      }

      for (int var1 = 0; var1 < this.L.size(); var1++) {
         int[] var2 = (int[])this.L.elementAt(var1);
         if (a.b.c.c[4][var2[0]][4] == 0) {
            this.T.addElement(var2);
         }
      }

      for (int var3 = 0; var3 < this.K.size(); var3++) {
         int[] var4 = (int[])this.K.elementAt(var3);
         if (a.b.c.c[4][var4[0]][4] == 0) {
            this.T.addElement(var4);
         }
      }
   }

   public final boolean j(int var1) {
      int[] var2;
      if (var1 == 0) {
         var2 = new int[]{var1, 0, 0};
      } else {
         var2 = new int[]{var1, 1, 0};
         if (var1 == 1 || var1 == 2 || var1 == 3 || var1 == 4) {
            this.Q[var1 - 1] = 1;
         }
      }

      this.O.addElement(var2);
      return true;
   }

   public final void c(int var1, int var2) {
      for (int var4 = 0; var4 < this.O.size(); var4++) {
         int[] var3;
         if ((var3 = (int[])this.O.elementAt(var4))[0] == var1) {
            var3[2] += var2;
            if (var3[2] >= 99) {
               var3[2] = 99;
            }

            return;
         }
      }

      int[] var5 = new int[]{var1, 0, var2};
      this.O.addElement(var5);
   }

   public final int d(int var1, int var2) {
      if (0 >= this.O.size()) {
         return var2 > 99 ? 1 : -1;
      } else {
         int[] var3;
         if ((var3 = (int[])this.O.elementAt(0))[0] == var1 && (var1 == 7 || var1 == 9 || var1 == 8)) {
            return var3[1] + var2 <= 99 ? 0 : 1;
         } else {
            return -1;
         }
      }
   }

   public final boolean e(int var1, int var2) {
      int var4 = 0;

      while (var4 < this.O.size()) {
         int[] var3;
         if ((var3 = (int[])this.O.elementAt(var4))[0] != var1 || var1 != 7 && var1 != 9 && var1 != 8) {
            if (var3[0] != var1 || var3[1] != 0) {
               var4++;
               continue;
            }

            this.O.setElementAt(new int[]{var3[0], 1, var3[2]}, var4);
            break;
         }

         this.A[var2].i((byte)var1);
         if (var3[2] > 0) {
            var3[2]--;
            this.O.setElementAt(new int[]{var3[0], 0, var3[2]}, var4);
         } else if (var3[2] <= 0) {
            this.O.removeElementAt(var4);
         }

         return true;
      }

      return false;
   }

   public final void k(int var1) {
      for (int var3 = 0; var3 < this.O.size(); var3++) {
         int[] var2;
         if ((var2 = (int[])this.O.elementAt(var3))[0] == var1 && var2[1] == 1) {
            this.O.setElementAt(new int[]{var2[0], 0, var2[2]}, var3);
            return;
         }
      }
   }

   public final boolean l(int var1) {
      for (int var2 = 0; var2 < this.O.size(); var2++) {
         int[] var3;
         if ((var3 = (int[])this.O.elementAt(var2))[0] == var1 && var3[1] == 1) {
            return true;
         }
      }

      return false;
   }

   public final boolean m(int var1) {
      if (var1 == -1) {
         return false;
      }

      for (int var2 = 0; var2 < this.M.size(); var2++) {
         int[] var3;
         if ((var3 = (int[])this.M.elementAt(var2))[0] == var1) {
            var3[1] = 0;
            return true;
         }
      }

      return false;
   }

   public final void f(int var1, int var2) {
      i var10000 = this.A[var2];
      byte var6 = 5;
      if (var10000.d[var6] >= 0) {
         i var10001 = this.A[var2];
         var6 = 5;
         this.m(var10001.d[var6]);
         var10000 = this.A[var2];
         byte var3 = -1;
         var6 = 5;
         var10000.d[var6] = var3;
      }

      int var4 = var1;
      j var7 = this;
      int var5 = 0;

      while (true) {
         if (var5 >= var7.M.size()) {
            var25 = false;
            break;
         }

         int[] var19;
         if ((var19 = (int[])var7.M.elementAt(var5))[0] == var4 && var19[1] == 1) {
            var25 = true;
            break;
         }

         var5++;
      }

      if (var25) {
         this.m(var1);
         boolean var8 = false;

         for (int var13 = 0; var13 < this.B; var13++) {
            var10000 = this.A[var13];
            var6 = 5;
            if (var10000.d[var6] == var1) {
               var10000 = this.A[var13];
               byte var9 = -1;
               var6 = 5;
               var10000.d[var6] = var9;
               var8 = true;
               break;
            }
         }

         if (!var8) {
            for (int var14 = 0; var14 < this.P.size(); var14++) {
               int[] var10;
               if ((var10 = (int[])this.P.elementAt(var2))[2] == var1) {
                  var10[2] = -1;
                  break;
               }
            }
         }
      }

      var4 = var1;
      var7 = this;
      var5 = 0;

      while (true) {
         if (var5 >= var7.M.size()) {
            boolean var29 = false;
            break;
         }

         int[] var22;
         if ((var22 = (int[])var7.M.elementAt(var5))[0] == var4) {
            var22[1] = 1;
            boolean var28 = true;
            break;
         }

         var5++;
      }

      var10000 = this.A[var2];
      short var12 = (short)var1;
      var6 = 5;
      var10000.d[var6] = var12;
   }

   public final byte z() {
      if (this.B < 6) {
         return 0;
      } else {
         return (byte)(this.P.size() < 100 ? 1 : 2);
      }
   }

   public final boolean A() {
      return this.P.size() < 100;
   }

   public final void a(int var1, int var2, short var3, byte var4, short var5, byte var6, int[] var7) {
      this.A[this.B] = new i();
      this.A[this.B].a(var1, var2, (short)-1, var4, var5, (byte)-1);
      this.A[this.B].b(var7);
      this.a((byte)this.A[this.B].j((byte)1), var1, (byte)2);
      this.B++;
   }

   public final void a(int var1, int var2, int var3, short var4, byte var5, short var6, byte var7, int[] var8) {
      this.A[this.B] = new i();
      System.arraycopy(this.A, var1, this.A, var1 + 1, this.B - var1);
      this.A[var1] = null;
      this.A[var1] = new i();
      this.A[var1].a(var2, var3, (short)-1, var5, var6, (byte)-1);
      this.A[var1].b(var8);
      this.B++;
   }

   public final void a(int[] var1) {
      this.A[this.B] = new i();
      this.A[this.B].a(var1[0], var1[1], (short)var1[2], (byte)var1[3], (short)var1[4], (byte)var1[5]);
      this.A[this.B].a((short)var1[6], var1[7], var1[8]);
      int[] var2 = new int[var1.length - 9];

      for (int var3 = 0; var3 < var2.length; var3++) {
         var2[var3] = var1[var3 + 9];
      }

      this.A[this.B].b(var2);
      this.a((byte)this.A[this.B].j((byte)1), var1[0], (byte)2);
      this.B++;
   }

   public final void n(int var1) {
      for (this.A[var1] = null; var1 < this.B - 1; var1++) {
         this.A[var1] = this.A[var1 + 1];
         this.A[var1 + 1] = null;
      }

      this.B--;
   }

   public final void o(int var1) {
      for (int var2 = 0; var2 < this.B; var2++) {
         if (this.A[var2].r() == var1) {
            this.n(var2);
            return;
         }
      }
   }

   public final int B() {
      int[] var1 = new int[this.B];

      for (int var2 = 0; var2 < this.B; var2++) {
         i var10002 = this.A[var2];
         byte var4 = 1;
         short var7 = var10002.d[var4];
         i var10003 = this.A[var2];
         var4 = 1;
         var1[var2] = var7 - var10003.e[var4];
      }

      int var5 = var1[0];

      for (int var3 = 1; var3 < var1.length; var3++) {
         if (var5 < var1[var3]) {
            var5 = var1[var3];
         }
      }

      return var5 == 0 ? -1 : var5;
   }

   public final void p(int var1) {
      i var2 = this.A[var1];

      while (var1 > 0) {
         this.A[var1] = this.A[var1 - 1];
         var1--;
      }

      this.A[0] = var2;
   }

   public final void a(int var1, int var2, short var3, byte var4, short var5, byte var6, int var7, int var8, int var9, int[] var10) {
      int[] var11;
      (var11 = new int[9 + var10.length])[0] = var1;
      var11[1] = var2;
      var11[2] = -1;
      var11[3] = var4;
      var11[4] = var5;
      var11[5] = -1;
      var11[6] = var7;
      var11[7] = 0;
      var11[8] = var9;
      System.arraycopy(var10, 0, var11, 9, var10.length);
      this.P.addElement(var11);
      this.a((byte)a.b.c.c[0][var1][1], var1, (byte)2);
   }

   public final void b(int[] var1) {
      this.P.addElement(var1);
      this.a((byte)a.b.c.c[0][var1[0]][1], var1[0], (byte)2);
   }

   public final void q(int var1) {
      this.P.removeElementAt(var1);
   }

   public final void r(int var1) {
      i[] var10000 = this.A;
      int var10001 = this.B;
      int var3 = var1;
      j var2 = this;
      i var4 = new i();
      int[] var7 = (int[])var2.P.elementAt(var3);
      var4.a(var7[0], var7[1], (short)var7[2], (byte)var7[3], (short)var7[4], (byte)var7[5]);
      var4.a((short)var7[6], var7[7], var7[8]);
      int[] var6 = new int[var7.length - 9];

      for (int var5 = 0; var5 < var6.length; var5++) {
         var6[var5] = var7[var5 + 9];
      }

      var4.b(var6);
      var10000[var10001] = var4;
      this.B++;
      this.q(var1);
   }

   public final void a(short var1) {
      this.S[this.J] = var1;
      this.J++;
   }

   public final void b(byte var1, byte var2, byte var3) {
      this.C[var1][var2] = var3;
      if (this.C[0][0] == 2) {
         a.a.f.a().a(a.b.c.a((byte)2, (short)0, (byte)5) / 2, a.b.c.a((byte)2, (short)0, (byte)5) / 2);
      }
   }

   public final byte b(byte var1, byte var2) {
      return this.C[var1][var2];
   }

   public final void a(byte var1, int var2, byte var3) {
      int var6 = var2;
      byte var5 = var1;
      j var4 = this;
      int var7 = 0;

      boolean var10000;
      while (true) {
         if (var7 >= var4.F[var5]) {
            var10000 = true;
            break;
         }

         if (var4.E[var5][var7] == var6) {
            var10000 = false;
            break;
         }

         var7++;
      }

      if (var10000) {
         this.E[var1][this.F[var1]] = (byte)var2;
         this.F[var1]++;
         if (var3 == 2) {
            this.G++;
            if (a.b.c.c[0][var2][22] == 2) {
               this.H++;
            } else if (a.b.c.c[0][var2][22] == 1) {
               this.I++;
            }
         }

         this.D[var1][var2 - this.X[var1]] = var3;
      } else {
         if (this.a(var1, var2) <= 1) {
            if (var3 == 2) {
               this.G++;
               if (a.b.c.c[0][var2][22] == 2) {
                  this.H++;
               } else if (a.b.c.c[0][var2][22] == 1) {
                  this.I++;
               }
            }

            this.D[var1][var2 - this.X[var1]] = var3;
         }
      }
   }

   public final byte a(byte var1, int var2) {
      return this.D[var1][var2 - this.X[var1]];
   }

   public final void C() {
      this.ad = true;
   }

   public final int D() {
      return game.l.B().p == 4 && game.l.B().q == 1 ? a.e.b(4, 8) : a.e.b(this.ae, this.af);
   }

   private void O() {
      if (!game.l.B().Z.F() && game.e.G != 0) {
         this.x--;
         if (this.x <= 0) {
            game.l.B().e(false);
            this.x = 0;
         }

         this.y--;
         if (this.y == 0) {
            this.a.a(0);
            this.y = -1;
         }

         if (game.l.B().C() && this.y <= 0) {
            if (this.ad && this.w > 0 && this.Q[1] != 2 && this.Q[3] != 2) {
               this.w--;
            }
         }
      }
   }

   public final boolean E() {
      return this.w <= 0;
   }

   public final int F() {
      return this.ag;
   }

   public final void s(int var1) {
      this.ag += var1;
   }

   public final void t(int var1) {
      this.ag = 0;
   }

   public final boolean u(int var1) {
      return this.ag >= var1;
   }

   public final int G() {
      return this.ah;
   }

   public final void v(int var1) {
      this.ah += var1;
   }

   public final void w(int var1) {
      this.ah = 0;
   }

   public final boolean x(int var1) {
      return this.ah >= var1;
   }

   public final boolean b(int var1, int var2, int var3) {
      return a.b.c.c[var3][var1][4] == 0 ? this.u(var2) : this.x(var2);
   }

   public final void H() {
      this.a(68, 7, (short)-1, (byte)2, (short)2, (byte)-1, new int[]{1, 40, 45});
      this.j(0);
   }

   public final boolean a(int var1, boolean var2) {
      super.a(var1, var2);
      if (this.y > 0) {
         this.a.a(1);
      }

      return true;
   }

   public final void I() {
      this.a((byte)0, this.o);
   }
}
