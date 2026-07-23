package game;

import javax.microedition.lcdui.Graphics;

public final class h extends a.a.g {
   public byte u;
   public boolean v;
   public byte w;
   public byte x;
   public short y;
   public short z;
   private int K;
   private int L;
   private int M;
   private int N;
   public byte A;
   public int B;
   public int C;
   public byte D;
   private short O;
   private short P;
   private short Q;
   public short E;
   public short F;
   public short G;
   private boolean R;
   private byte[] S = new byte[]{2, 3, 0, 1};
   private byte T = 0;
   public a.a.g H;
   public a.a.g I;
   public short J = -1;
   private short[] U = new short[]{8, 9, 2, 96, 320, 0};

   public final void a(short[] var1, int var2) {
      this.J = (short)var2;
      this.u = (byte)var1[0];
      this.a.a(var1[1], false);
      this.a.c();
      this.w = (byte)var1[6];
      if (this.u == 0 && (this.w == 1 || this.w == 18)) {
         byte var4 = (byte)(var1[2] % 3);
         super.o = var4;
      }

      this.a((byte)var1[2]);
      this.j = var1[3];
      this.k = var1[4];
      if (var1[5] == 1) {
         this.c(true);
      } else {
         this.c(false);
      }

      switch (this.u) {
         case 0:
            this.t = (byte)var1[7];
            this.x = (byte)var1[8];
            h var5 = this;
            if (this.x != 0 && var5.H == null && var5.k()) {
               var5.H = new a.a.g();
               var5.H.a(259, false);
               a.a.g var3 = var5.H;
               var5.H.a.c();
               var5.H.a(var5.x, (byte)-1, true);
               var5.H.b(var5.j, var5.k - 40);
               h var7 = var5;
               var3 = var5.H;
               var5.H.q = var7;
            }

            var5.B();
            this.w();
            if (var1[9] == 0) {
               this.v = false;
            } else {
               this.v = true;
            }

            this.y = var1[11];
            this.z = var1[12];
            this.K = 0;
            this.M = a.e.b(20, 40);
            this.A = 0;
            if (this.w == 12) {
               this.o = 0;
            } else if (this.w == 13) {
               this.o = 1;
            }

            if (this.w == 3) {
               if (this.i == 4) {
                  this.o = 1;
               }
            } else if (this.w == 2) {
               if (this.i == 5) {
                  this.o = 2;
               } else if (this.i == 3) {
                  this.o = 0;
               }
            }

            if (this.w == 1 && this.a.a != 226 || this.w == 2 || this.w == 3 || this.w == 17) {
               if (this.b == null) {
                  this.b = new a.a.g();
                  this.b.a(337, false);
               }

               this.b.b(this.j, this.k);
               if (this.a.a == 4) {
                  this.b.a((byte)0, (byte)0, this.R);
               } else {
                  this.b.a((byte)1, (byte)0, this.R);
               }

               this.b.c();
            }
            break;
         case 1:
            if (var1[1] == 320) {
               this.t = 2;
            } else {
               this.t = 1;
            }

            if (this.k() && var1[0] > 0 && var1[0] <= 3) {
               game.l.B().o.addElement(this);
            }

            if (this.w == 3) {
               this.v = true;
            }

            this.D = (byte)var1[7];
            this.O = var1[8];
            this.P = var1[9];
            this.Q = var1[10];
            break;
         case 2:
            if (var1[7] == 0) {
               this.R = false;
            } else {
               this.R = true;
            }
            break;
         case 3:
            this.t = 1;
            this.E = var1[7];
            this.F = var1[8];
            switch (this.F) {
               case 9:
                  this.F = 1;
                  break;
               case 10:
                  this.F = 0;
                  break;
               case 11:
                  this.F = 2;
                  break;
               case 12:
                  this.F = 3;
            }

            this.G = var1[9];
            this.v = true;
      }

      this.d = new short[3];
      this.e = new short[3];
   }

   public final void p() {
      if (this.a != null) {
         this.a.d();
      }
   }

   public final void a(byte var1) {
      switch (this.u) {
         case 0:
            if (this.w == 8) {
               this.a((byte)0, (byte)-1, false);
               this.K = 0;
               this.i = var1;
               return;
            }

            if (this.w != 1 && this.w != 18) {
               this.a(var1, (byte)-1, false);
               this.i = var1;
               game.l.B().a(this.J, 0, this.i, true);
               return;
            }

            this.i = (byte)(var1 / 3);
            if (this.i == 0) {
               if (this.o == 3) {
                  this.a((byte)1, (byte)-1, false);
                  return;
               }

               this.a(this.o, (byte)-1, false);
               return;
            }

            if (this.i == 1) {
               if (this.o == 3) {
                  this.a((byte)(this.i * 3 + 1), (byte)-1, false);
                  return;
               }

               this.a((byte)(this.i * 3 + this.o), (byte)-1, false);
               return;
            }
            break;
         case 1:
            if (this.w == 0) {
               switch (var1) {
                  case 0:
                     this.a(var1, (byte)-1, false);
                     break;
                  case 1:
                     this.a(var1, (byte)-2, false);
                     break;
                  case 2:
                     this.a(var1, (byte)-1, false);
                     break;
                  case 3:
                     this.a(var1, (byte)-2, false);
               }
            } else {
               this.a(var1, (byte)-1, false);
               if (this.w == 3) {
                  game.l.B().a(this.J, 0, var1, true);
               }
            }

            this.i = var1;
            return;
         case 2:
            this.i = var1;
            return;
         case 3:
            this.a(var1, (byte)-2, false);
            this.i = var1;
            game.l.B().a(this.J, 0, this.i, true);
      }
   }

   public final void q() {
      switch (this.u) {
         case 0:
            this.z();
            break;
         case 1:
            if (this.w == 0) {
               if (this.i == 0 && a.e.a(game.j.p().j, game.j.p().k, this.j, this.k, game.j.p().a.k(), this.a.k())) {
                  this.a((byte)1);
               } else if (this.i == 2 && !a.e.a(game.j.p().j, game.j.p().k, this.j, this.k, game.j.p().a.k(), this.a.k())) {
                  this.a((byte)3);
               } else if (this.i == 1 && this.a.f()) {
                  this.a((byte)2);
               } else if (this.i == 3 && this.a.f()) {
                  this.a((byte)0);
               }
            }

            if (this.w == 0 && this.a.f() || this.w == 1 || this.w == 3 && this.i() == 2) {
               if (this.a.a == 320 && !this.k()) {
                  return;
               }

               if ((game.j.p().p == this.S[this.D] && this.a.a != 320 && this.a.a != 310 || this.a.a == 320 || this.a.a == 310)
                  && a.e.a(game.j.p().j, game.j.p().k, this.j, this.k, game.j.p().a.k(), this.a.j())) {
                  game.l.B().p = this.O;
                  game.l.B().q = this.P;
                  game.l.B().t = this.Q;
                  game.f.B().a((byte)9);
               }
            } else if (this.w == 2) {
               if ((game.j.p().p == this.S[this.D] && this.a.a != 320 || this.a.a == 320)
                  && a.e.a(game.j.p().j, game.j.p().k, this.j, this.k, game.j.p().a.k(), this.a.j())) {
                  for (int var1 = 0; var1 < this.U.length / 6; var1++) {
                     if (this.U[var1 * 6] == this.J && this.U[var1 * 6 + 1] == game.l.B().p && this.U[var1 * 6 + 2] == game.l.B().q) {
                        game.l.B().r = this.U[var1 * 6 + 3];
                        game.l.B().s = this.U[var1 * 6 + 4];
                        game.l.G = (byte)this.U[var1 * 6 + 5];
                        break;
                     }
                  }

                  game.l.B().p = this.O;
                  game.l.B().q = this.P;
                  game.l.B().t = -1;
                  game.f.B().a((byte)9);
               }
            } else if (this.w == 4
               && game.j.p().i() != 9
               && game.j.p().i() != 10
               && a.e.a(game.j.p().j, game.j.p().k, this.j, this.k, game.j.p().a.k(), this.a.j())) {
               game.j.p().b(this.j, this.k);
               game.j.p().b.b(this.j, this.k);
               game.j.p().a((byte)9, this.o);
               game.l.B().t = this.Q;
            }
         case 2:
         case 3:
      }

      this.f();
   }

   private void z() {
      switch (this.w) {
         case 1:
            if (this.i == 1) {
               byte var14 = 0;
               this.a(super.e[var14]);
               if (game.l.B().z != null && game.l.B().z.q.equals(this) && !game.j.p().a(this, game.j.p().a.k(), this.a.k())) {
                  game.l.B().D();
               }
            }

            if (game.l.B().z != null && game.l.B().z.q.equals(this) && (!this.k() || !game.j.p().a(this, game.j.p().a.k(), this.a.k()))) {
               game.l.E = -1;
               game.l.B().D();
            }

            if (this.H != null && this.k() && this.H.q.equals(this) && !game.j.p().a(this, game.j.p().a.k(), this.a.k())) {
               this.B();
            }

            if (game.e.p != null && game.e.p.size() > 0 && this.T == 1 && !game.j.p().a(this, game.j.p().a.k(), this.a.k())) {
               for (int var6 = 0; var6 < game.e.p.size(); var6++) {
                  if (((a.a.g)game.e.p.elementAt(var6)).q.equals(this)) {
                     ((a.a.g)game.e.p.elementAt(var6)).c();
                     return;
                  }
               }
            }
            break;
         case 2:
            if (this.A()) {
               byte[] var5 = new byte[]{0, 1, 2, 3, 5};
               this.a(var5[a.e.a(5)]);
               if (this.i == 3 || this.i == 0) {
                  byte var13 = 0;
                  super.o = var13;
               } else if (this.i == 5 || this.i == 2) {
                  byte var12 = 2;
                  super.o = var12;
               } else if (a.e.a(2) == 0) {
                  byte var10 = 3;
                  super.o = var10;
               } else {
                  byte var11 = 1;
                  super.o = var11;
               }
            }

            if (this.i == 3) {
               if (this.K >= 64) {
                  this.a((byte)0);
                  return;
               }

               this.a(4);
               this.K += 4;
               return;
            }

            if (this.i == 5) {
               if (this.K <= 0) {
                  this.a((byte)2);
                  return;
               }

               this.a(4);
               this.K -= 4;
               return;
            }
            break;
         case 3:
            if (this.A()) {
               byte[] var4 = new byte[]{0, 1, 2, 4};
               this.a(var4[a.e.a(4)]);
               if (this.i == 0) {
                  byte var2 = 0;
                  super.o = var2;
               } else if (this.i == 2) {
                  byte var7 = 2;
                  super.o = var7;
               } else if (a.e.a(2) == 0) {
                  byte var8 = 3;
                  super.o = var8;
               } else {
                  byte var9 = 1;
                  super.o = var9;
               }
            }

            if (this.i == 4) {
               if (this.o == 1) {
                  if (this.K >= 64) {
                     this.a((byte)0);
                     return;
                  }

                  this.a(4);
                  this.K += 4;
                  return;
               }

               if (this.o == 3) {
                  if (this.K <= 0) {
                     this.a((byte)2);
                     return;
                  }

                  this.a(4);
                  this.K -= 4;
                  return;
               }
            }
            break;
         case 4:
         case 5:
         case 6:
         case 7:
         case 15:
            if (this.I != null && this.k() && this.I.q.equals(this) && (this.i != 0 || !game.j.p().a(this, game.j.p().a.k(), this.a.k()))) {
               this.y();
            }

            if (this.i == 1 && this.a.f()) {
               this.a((byte)2);
               if (this.w == 6 && this.w == 7) {
                  game.l.B().a(this.J, 0, this.i, false);
               } else {
                  game.l.B().a(this.J, 0, this.i, true);
               }

               int var1;
               if ((this.w == 7 || this.w == 6) && (var1 = a.e.a(2)) > 0) {
                  game.j.p().s(var1);
                  int[] var3 = new int[]{var1, super.j, super.k - 20, 0};
                  game.j.p().W.addElement(var3);
               }

               game.e.t = false;
               return;
            }
            break;
         case 8:
            if (this.i == 1) {
               if (this.K < 2 && this.a(this.o, 8, (byte)0)) {
                  this.K++;
                  this.a(8);
                  this.t();
                  return;
               }

               this.a((byte)0);
               return;
            }
            break;
         case 9:
         case 10:
            if (this.A == 1) {
               if ((this.a.a == 302 || this.a.a == 298) && this.a(this.o, 4, (byte)1)) {
                  this.a(4);
                  ((a.a.g)this.q).a(4);
                  return;
               }

               if (this.a(this.o, 4, (byte)2)) {
                  this.a(4);
                  ((a.a.g)this.q).a(4);
                  return;
               }

               this.t();
               this.A = 2;
               this.a((byte)0);
               return;
            }
            break;
         case 11:
            return;
         case 12:
            if (this.k()) {
               if (!a.e.a(game.j.p().j, game.j.p().k, this.j, this.k, this.a.k())) {
                  if (this.a(this.o, 4, (byte)0)) {
                     this.a(4);
                     return;
                  }

                  if (this.o == 2) {
                     this.o = 0;
                     return;
                  }

                  this.o = 2;
                  return;
               }

               if (game.j.p().i() != 8) {
                  game.j.p().a((byte)8, this.o);
                  return;
               }
            }
            break;
         case 13:
            if (this.k()) {
               if (!a.e.a(game.j.p().j, game.j.p().k, this.j, this.k, this.a.k())) {
                  if (this.a(this.o, 4, (byte)0)) {
                     this.a(4);
                     return;
                  }

                  if (this.o == 3) {
                     this.o = 1;
                     return;
                  }

                  this.o = 3;
                  return;
               }

               if (game.j.p().i() != 8) {
                  game.j.p().a((byte)8, this.o);
                  return;
               }
            }
            break;
         case 14:
            this.s();
            if (this.N < 4) {
               this.N++;
               return;
            }

            this.N = 0;
            return;
         case 16:
            if (a.e.a(game.j.p().j, game.j.p().k, this.j, this.k, this.a.k()) && game.j.p().i() != 5) {
               game.j.p().a((byte)5, game.j.p().o);
               return;
            }
      }
   }

   public final void r() {
      if (this.w == 9) {
         this.a((byte)1);
         if ((this.a.a == 302 || this.a.a == 298) && this.a((byte)1, 4, (byte)1)) {
            byte var4 = 1;
            super.o = var4;
         } else if (this.a((byte)1, 4, (byte)2)) {
            byte var2 = 1;
            super.o = var2;
         } else {
            byte var3 = 3;
            super.o = var3;
         }
      } else if ((this.a.a == 302 || this.a.a == 298) && this.a((byte)2, 4, (byte)1)) {
         this.a((byte)2);
         byte var7 = 2;
         super.o = var7;
      } else if (this.a((byte)2, 4, (byte)2)) {
         this.a((byte)2);
         byte var5 = 2;
         super.o = var5;
      } else {
         this.a((byte)1);
         byte var6 = 0;
         super.o = var6;
      }

      this.A = 1;
   }

   public final void s() {
      this.B = 0;

      while (true) {
         boolean var14;
         label85: {
            byte var10001 = super.a.g();
            int var10002 = 16 * (this.B + 1);
            boolean var1 = false;
            int var3 = var10002;
            byte var2 = var10001;
            h var5 = this;
            byte var4 = 0;
            switch (var2) {
               case 0:
                  var4 = a.b.d.a().a(0, var5.j, var5.k + var3);

                  for (int var12 = 0; var12 < game.l.B().n.length; var12++) {
                     if (game.l.B().n[var12].w != var5.w
                        && game.l.B().n[var12].a.k() != null
                        && a.e.a(var5.j, var5.k + var3, game.l.B().n[var12].j, game.l.B().n[var12].k, game.l.B().n[var12].a.k())) {
                        h var17 = game.l.B().n[var12];
                        h var13 = var5;
                        var17.q = var13;
                        var14 = false;
                        break label85;
                     }
                  }
                  break;
               case 1:
                  var4 = a.b.d.a().a(0, var5.j + var3, var5.k);

                  for (int var10 = 0; var10 < game.l.B().n.length; var10++) {
                     if (game.l.B().n[var10].w != var5.w
                        && game.l.B().n[var10].a.k() != null
                        && a.e.a(var5.j + var3, var5.k, game.l.B().n[var10].j, game.l.B().n[var10].k, game.l.B().n[var10].a.k())) {
                        h var16 = game.l.B().n[var10];
                        h var11 = var5;
                        var16.q = var11;
                        var14 = false;
                        break label85;
                     }
                  }
                  break;
               case 2:
                  var4 = a.b.d.a().a(0, var5.j, var5.k - var3);

                  for (int var8 = 0; var8 < game.l.B().n.length; var8++) {
                     if (game.l.B().n[var8].w != var5.w
                        && game.l.B().n[var8].a.k() != null
                        && a.e.a(var5.j, var5.k - var3, game.l.B().n[var8].j, game.l.B().n[var8].k, game.l.B().n[var8].a.k())) {
                        h var15 = game.l.B().n[var8];
                        h var9 = var5;
                        var15.q = var9;
                        var14 = false;
                        break label85;
                     }
                  }
                  break;
               case 3:
                  var4 = a.b.d.a().a(0, var5.j - var3, var5.k);

                  for (int var6 = 0; var6 < game.l.B().n.length; var6++) {
                     if (game.l.B().n[var6].w != var5.w
                        && game.l.B().n[var6].a.k() != null
                        && a.e.a(var5.j - var3, var5.k, game.l.B().n[var6].j, game.l.B().n[var6].k, game.l.B().n[var6].a.k())) {
                        h var10000 = game.l.B().n[var6];
                        h var7 = var5;
                        var10000.q = var7;
                        var14 = false;
                        break label85;
                     }
                  }
            }

            var14 = var4 == 0;
         }

         if (!var14) {
            return;
         }

         this.B++;
      }
   }

   private boolean A() {
      this.L++;
      if (this.L >= this.M) {
         this.L = 0;
         this.M = a.e.b(20, 40);
         return true;
      } else {
         return false;
      }
   }

   private boolean a(byte var1, int var2, byte var3) {
      byte var4 = 0;
      switch (var1) {
         case 0:
            var4 = a.b.d.a().a(0, this.j, this.k + var2);
            break;
         case 1:
            var4 = a.b.d.a().a(0, this.j + var2 + this.a.k()[2] / 2, this.k);
            break;
         case 2:
            var4 = a.b.d.a().a(0, this.j, this.k - this.a.k()[3] - var2);
            break;
         case 3:
            var4 = a.b.d.a().a(0, this.j - var2 - this.a.k()[2] / 2, this.k);
      }

      return var4 == var3;
   }

   public final void c(Graphics var1, int var2, int var3) {
      switch (super.a.g()) {
         case 0:
            var1.setColor(65280);
            var1.fillRect(this.j - var2 - (this.N + 5) / 2, this.k - this.a.j()[3] - var3 + 20, this.N + 5, this.B + 1 << 4);
            var1.setColor(16777215);
            var1.fillRect(this.j - var2 - (this.N + 3) / 2, this.k - this.a.j()[3] - var3 + 20, this.N + 3, this.B + 1 << 4);
            return;
         case 1:
            var1.setColor(65280);
            var1.fillRect(this.j - var2 + 7, this.k - this.a.j()[3] - var3 - (this.N + 5) / 2 + 13, this.B << 4, this.N + 5);
            var1.setColor(16777215);
            var1.fillRect(this.j - var2 + 7, this.k - this.a.j()[3] - var3 - (this.N + 3) / 2 + 13, this.B << 4, this.N + 3);
         default:
            return;
         case 2:
            var1.setColor(65280);
            var1.fillRect(this.j - var2 - (this.N + 5) / 2, this.k - this.a.j()[3] - var3 - (this.B << 4) + 8, this.N + 5, this.B << 4);
            var1.setColor(16777215);
            var1.fillRect(this.j - var2 - (this.N + 3) / 2, this.k - this.a.j()[3] - var3 - (this.B << 4) + 8, this.N + 3, this.B << 4);
            return;
         case 3:
            var1.setColor(65280);
            var1.fillRect(this.j - var2 - 8 - (this.B << 4), this.k - this.a.j()[3] - var3 - (this.N + 5) / 2 + 13, this.B << 4, this.N + 5);
            var1.setColor(16777215);
            var1.fillRect(this.j - var2 - 8 - (this.B << 4), this.k - this.a.j()[3] - var3 - (this.N + 3) / 2 + 13, this.B << 4, this.N + 3);
      }
   }

   public final void t() {
      game.l.B().a(this.J, 0, this.j);
      game.l.B().a(this.J, 1, this.k);
   }

   public final void u() {
      byte var1 = 0;
      if (this.k()) {
         var1 = 1;
      }

      game.l.B().a(this.J, 1, var1, true);
      game.l.B().a(this.J, 0, this.i, true);
      game.l.B().a(this.J, 2, this.o, true);
   }

   public final void a(int var1) {
      super.a(var1);
   }

   public final void f(byte var1) {
      this.T = 1;
   }

   public final byte v() {
      return this.T;
   }

   public final void f(int var1) {
      if (this.I == null && this.k()) {
         this.I = new a.a.g();
         this.I.a(259, false);
         a.a.g var2 = this.I;
         this.I.a.c();
         this.I.a((byte)7, (byte)-1, true);
         this.I.b(this.j, this.k - var1);
         h var3 = this;
         var2 = this.I;
         this.I.q = var3;
      }

      h var4 = this;
      if (this.I != null) {
         var4.I.c();
      }
   }

   public final void w() {
      if (game.l.B().n(this.J)) {
         this.x();
      }
   }

   private void B() {
      if (this.H != null) {
         this.H.c();
      }
   }

   public final void d() {
      super.d();
      this.x();
      this.e();
      this.y();
   }

   public final void x() {
      if (this.H != null) {
         this.H.d();
      }
   }

   public final void y() {
      if (this.I != null) {
         this.I.d();
      }
   }

   public final void b(int var1, int var2) {
      super.b(var1, var2);
      if (this.b != null && this.b.k()) {
         this.b.b(var1, var2);
      }
   }
}
