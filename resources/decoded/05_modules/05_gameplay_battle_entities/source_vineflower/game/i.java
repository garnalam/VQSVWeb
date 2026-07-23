package game;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class i extends a.a.g {
   private static short[] N = new short[]{90, 95, 100, 110, 125};
   public static final byte[] u = new byte[]{12, 30, 5};
   a.a.b v;
   short[][] w;
   short[][] x;
   byte[][] y;
   private byte[] O;
   short[] z;
   byte[] A;
   private byte P;
   private short[] Q;
   protected int B = 0;
   private int R;
   private int S = 0;
   private int T = 0;
   protected int C = 0;
   private int U = 0;
   protected short D;
   private byte V = 0;
   private int W = 0;
   private byte X;
   protected byte E;
   private int Y = 0;
   private boolean Z;
   protected short F;
   protected byte G;
   protected Vector H = new Vector();
   protected Vector I = new Vector();
   public byte J = 0;
   protected boolean K;
   protected short[] L;
   protected a.a.b M = null;
   private byte aa = 0;

   public i() {
      this.d = new short[23];
      this.e = new short[23];
      this.z = new short[5];
      this.A = new byte[5];
      this.Q = new short[4];

      for (int var1 = 0; var1 < this.A.length; var1++) {
         this.A[var1] = -1;
      }

      this.L = new short[16];
      this.w = new short[16][5];
      this.x = new short[11][5];
      this.y = new byte[][]{{-1, -1, -1}, {-1, -1, -1}};
      this.O = new byte[2];
      this.c = false;
   }

   public final void a(int var1, int var2, short var3, byte var4, short var5, byte var6) {
      this.W = var1;
      this.U = var2;
      if (var5 == -1) {
         short var7 = (short)a.e.b(a.b.c.c[0][this.W][3], a.b.c.c[0][this.W][3]);
         byte var9 = 0;
         super.d[var9] = var7;
      } else {
         short var22 = var5;
         byte var10 = 0;
         super.d[var10] = var22;
      }

      int var10002 = a.b.c.c[0][this.W][5] + a.b.c.c[0][this.W][6] * var2 + a.b.c.c[0][this.W][7];
      byte var11 = 0;
      short var23 = (short)(var10002 * N[super.d[var11] - 1] / 100);
      var11 = 1;
      super.d[var11] = var23;
      var10002 = a.b.c.c[0][this.W][8] + a.b.c.c[0][this.W][9] * var2 + a.b.c.c[0][this.W][10];
      var11 = 0;
      var23 = (short)(var10002 * N[super.d[var11] - 1] / 100);
      var11 = 2;
      super.d[var11] = var23;
      var10002 = a.b.c.c[0][this.W][11] + a.b.c.c[0][this.W][12] * var2 / 10 + a.b.c.c[0][this.W][13];
      var11 = 0;
      var23 = (short)(var10002 * N[super.d[var11] - 1] / 100);
      var11 = 3;
      super.d[var11] = var23;
      var10002 = a.b.c.c[0][this.W][14] + a.b.c.c[0][this.W][15] * var2 / 10 + a.b.c.c[0][this.W][16];
      var11 = 0;
      var23 = (short)(var10002 * N[super.d[var11] - 1] / 100);
      var11 = 4;
      super.d[var11] = var23;
      var23 = var3;
      var11 = 5;
      super.d[var11] = var23;
      var23 = var4;
      var11 = 6;
      super.d[var11] = var23;
      this.i(var6);
      this.h();
      this.D = a.b.c.c[0][this.W][17];
      i var8 = this;
      var11 = 1;
      this.u(var8.e[var11]);
   }

   public final void a(int[] var1) {
      this.a(var1[0], var1[1], (short)var1[2], (byte)var1[3], (short)var1[4], (byte)var1[5]);
      this.V();
      this.a((short)var1[6], var1[7], var1[8]);
      int[] var2 = new int[var1.length - 9];

      for (int var3 = 0; var3 < var2.length; var3++) {
         var2[var3] = var1[var3 + 9];
      }

      this.b(var2);
   }

   public final void a(short var1, int var2, int var3) {
      this.V();
      short var5 = var1;
      byte var4 = 1;
      super.e[var4] = var5;
      var4 = 1;
      this.u(super.e[var4]);
      this.T = var2;
      this.F = (byte)var3;
   }

   public final void c() {
      super.c();
      if (this.a == null) {
         this.a = new a.b.g();
      }

      this.a.a(this.D, false);
      this.a((byte)0, true);
   }

   public final void d() {
      super.d();
      if (this.a != null) {
         this.a.b();
         this.a = null;
      }
   }

   public final void a(short var1, byte var2) {
      byte var3 = this.o;
      this.v = null;
      this.v = new a.a.b();
      this.v.a(new short[]{var1, var2, var3});
      this.v.b(this.j, this.k);
      if (var1 == 20 && var2 == 3 || var1 == 22 && var2 == 4) {
         int[] var4 = this.a.b(0, var3);
         this.v.b(this.j, this.k - var4[3]);
      }

      this.v.d(true);
   }

   private void z(int var1) {
      this.M = new a.a.b();
      short[] var3;
      short[] var2 = new short[(var3 = game.a.x[var1]).length + 5];
      System.arraycopy(var3, 1, var2, 6, var3.length - 1);
      short[] var4;
      System.arraycopy(var4 = new short[]{var3[0], (short)super.j, (short)super.k, a.b.c.c[0][this.W][17], 0, this.o}, 0, var2, 0, var4.length);
      this.M.a(var2);
      this.M.d(true);
   }

   public final void a(byte var1, boolean var2) {
      label30:
      switch (var1) {
         case 0:
            this.a.a(var1, (byte)-1, true);
            break;
         case 1:
            this.a.a(var1, (byte)0, true);
            switch (this.W) {
               case 0:
                  this.z(27);
                  break label30;
               case 10:
                  this.aa = 1;
                  this.z(28);
                  break label30;
               case 60:
               case 61:
                  this.z(22);
                  break label30;
               case 62:
                  this.z(24);
                  break label30;
               case 67:
                  this.aa = 1;
                  this.z(30);
                  break label30;
               case 68:
                  this.aa = 1;
                  this.z(31);
                  break label30;
               case 70:
                  this.aa = 1;
                  this.z(29);
                  break label30;
               case 71:
                  this.aa = 1;
                  this.z(32);
                  break label30;
               case 72:
                  this.aa = 1;
                  this.z(33);
                  break label30;
               case 75:
                  this.z(20);
                  break label30;
               case 87:
                  this.z(21);
                  break label30;
               case 91:
                  this.z(26);
                  break label30;
               case 92:
                  this.z(25);
                  break label30;
               case 97:
               case 98:
                  this.z(23);
               default:
                  break label30;
            }
         case 2:
            this.a.a(var1, (byte)0, true);
            break;
         case 3:
            if (game.a.B().l == 0) {
               this.d();
               i var5 = this;
               short[] var3 = new short[]{16, 0, 0, 4};
               var5.M = new a.a.b();
               short[] var4 = new short[var3.length + 5];
               System.arraycopy(var3, 1, var4, 6, var3.length - 1);
               short[] var6;
               System.arraycopy(var6 = new short[]{var3[0], (short)var5.j, (short)var5.k, a.b.c.c[0][var5.W][17], 0, var5.o}, 0, var4, 0, var6.length);
               var5.M.a(var4);
               var5.M.d(true);
               var5.M.a();
            }
            break;
         case 4:
            this.a.a(var1, (byte)-1, true);
      }

      this.V = var1;
   }

   public final void p() {
      this.a();
      if (this.v != null) {
         this.v.d();
      }

      if (this.M != null) {
         this.M.d();
      }
   }

   public final void a(Graphics var1) {
      if (this.M != null && this.V == 1) {
         switch (this.W) {
            case 0:
               if (this.a.b(5)) {
                  this.M.a();
               }
               break;
            case 10:
               if (this.a.b(5)) {
                  this.M.a();
               }
               break;
            case 60:
            case 61:
               if (this.a.b(3)) {
                  this.M.a();
               }
               break;
            case 62:
               if (this.a.b(8)) {
                  this.M.a();
               }
               break;
            case 67:
               if (this.a.b(1)) {
                  this.M.a();
               }
               break;
            case 68:
               if (this.a.b(3)) {
                  this.M.a();
               }
               break;
            case 70:
               if (this.a.b(9)) {
                  this.M.a();
               }
               break;
            case 71:
               if (this.a.b(7)) {
                  this.M.a();
               }
               break;
            case 72:
               if (this.a.b(4)) {
                  this.M.a();
               }
               break;
            case 75:
               if (this.a.b(15)) {
                  this.M.a();
               }
               break;
            case 87:
               if (this.a.b(1)) {
                  this.M.a();
               }
               break;
            case 91:
               if (this.a.b(2)) {
                  this.M.a();
               }
               break;
            case 92:
               if (this.a.b(4)) {
                  this.M.a();
               }
               break;
            case 97:
            case 98:
               if (this.a.b(8)) {
                  this.M.a();
               }
         }
      }

      if (this.M != null && this.aa == 0) {
         this.M.a(var1, 0, 0);
      }

      if (this.v != null && game.a.w[this.v.a - 20][this.v.b.g()][this.v.b.h()] == 0) {
         this.v.a(var1, 0, 0);
      }

      Graphics var3 = var1;
      i var2 = this;
      if (this.g) {
         var2.a.a(var3, var2.j, var2.k, var2.o);
      }

      if (this.M != null && this.aa == 1) {
         this.M.a(var1, 0, 0);
      }

      if (this.v != null && game.a.w[this.v.a - 20][this.v.b.g()][this.v.b.h()] == 1) {
         this.v.a(var1, 0, 0);
      }
   }

   public final byte q() {
      return this.V;
   }

   public final int r() {
      return this.W;
   }

   public final void f(int var1) {
      this.Y = var1;
   }

   public final int s() {
      return this.Y;
   }

   public final int t() {
      return this.U;
   }

   public final boolean u() {
      return this.U == 50;
   }

   protected final void g(int var1) {
      if (this.U < 50) {
         this.T += var1;
         if (this.T < 0) {
            this.T = 0;
         }
      }
   }

   public final int v() {
      return this.U >= 50 ? A(50) : A(this.U + 1);
   }

   public final void w() {
      this.U++;
      this.g(-A(this.U));
      this.K();

      for (int var1 = 0; var1 < this.A.length; var1++) {
         if (this.A[var1] != -1) {
            this.z[var1] = a.b.c.c[1][this.A[var1]][5];
         }
      }

      this.W();
   }

   public final void h(int var1) {
      this.U += var1;
      this.K();
      this.W();
   }

   private static int A(int var0) {
      return var0 * 15 * var0 - 200;
   }

   private void V() {
      if (game.j.p().b((byte)1, (byte)0) == 2 && game.j.p().b((byte)1, (byte)1) == 1) {
         byte var3 = 1;
         short var1 = (short)(super.d[var3] * a.b.c.c[2][1][6] / 100);
         var3 = 1;
         var1 = (short)(super.d[var3] + var1);
         var3 = 1;
         super.d[var3] = var1;
      }

      if (game.j.p().b((byte)2, (byte)0) == 2 && game.j.p().b((byte)2, (byte)1) == 1) {
         byte var9 = 3;
         short var5 = (short)(super.d[var9] * a.b.c.c[2][2][6] / 100);
         var9 = 3;
         var5 = (short)(super.d[var9] + var5);
         var9 = 3;
         super.d[var9] = var5;
      }
   }

   private void W() {
      int var10002 = a.b.c.c[0][this.W][5] + a.b.c.c[0][this.W][6] * this.U + a.b.c.c[0][this.W][7];
      byte var2 = 0;
      short var3 = (short)(var10002 * N[super.d[var2] - 1] / 100);
      var2 = 1;
      super.d[var2] = var3;
      var10002 = a.b.c.c[0][this.W][8] + a.b.c.c[0][this.W][9] * this.U + a.b.c.c[0][this.W][10];
      var2 = 0;
      var3 = (short)(var10002 * N[super.d[var2] - 1] / 100);
      var2 = 2;
      super.d[var2] = var3;
      var10002 = a.b.c.c[0][this.W][11] + a.b.c.c[0][this.W][12] * this.U / 10 + a.b.c.c[0][this.W][13];
      var2 = 0;
      var3 = (short)(var10002 * N[super.d[var2] - 1] / 100);
      var2 = 3;
      super.d[var2] = var3;
      var10002 = a.b.c.c[0][this.W][14] + a.b.c.c[0][this.W][15] * this.U / 10 + a.b.c.c[0][this.W][16];
      var2 = 0;
      var3 = (short)(var10002 * N[super.d[var2] - 1] / 100);
      var2 = 4;
      super.d[var2] = var3;
      this.h();
      var2 = 1;
      this.u(super.e[var2]);
   }

   public static short b(int var0, int var1, int var2) {
      return (short)((a.b.c.c[0][var0][5] + a.b.c.c[0][var0][6] * var1 + a.b.c.c[0][var0][7]) * N[var2 - 1] / 100);
   }

   public final void x() {
      for (int var1 = 0; var1 < this.Q.length; var1++) {
         int var10003 = this.U - 5;
         byte var3 = 0;
         this.Q[var1] = a(this.W, var10003, super.d[var3], var1 + 1);
      }
   }

   public final void y() {
      for (int var1 = 0; var1 < this.Q.length; var1++) {
         byte var3 = (byte)(var1 + 1);
         this.Q[var1] = super.d[var3];
      }
   }

   public final short i(int var1) {
      return this.Q[var1];
   }

   public final void z() {
      if (this.G < 20) {
         this.G++;
         byte var2 = 2;
         short var10002 = super.d[var2];
         var2 = 2;
         short var3 = (short)(var10002 + super.d[var2] * this.G / 100);
         var2 = 2;
         super.e[var2] = var3;
         var2 = 3;
         var10002 = super.d[var2];
         var2 = 3;
         var3 = (short)(var10002 + super.d[var2] * this.G / 100);
         var2 = 3;
         super.e[var2] = var3;
         var2 = 4;
         var10002 = super.d[var2];
         var2 = 4;
         var3 = (short)(var10002 + super.d[var2] * this.G / 100);
         var2 = 4;
         super.e[var2] = var3;
      }
   }

   public final int A() {
      return this.T;
   }

   public final void j(int var1) {
      this.S = var1;
   }

   public final int B() {
      return this.S;
   }

   public final int C() {
      i var2;
      if ((var2 = (i)this.q).Y == 0 && game.j.p().b((byte)4, (byte)0) == 2) {
         byte var3 = 3;
         var2 = this.q;
         short var1 = (short)(this.q.d[var3] * (100 + a.b.c.c[2][4][5]) / 100);
         var1 = var1;
         var3 = 3;
         var2 = this.q;
         this.q.e[var3] = var1;
      }

      int var5;
      if (((i)this.q).f((byte)2)) {
         byte var13 = 2;
         short var10000 = super.e[var13];
         var13 = 3;
         var2 = this.q;
         var5 = var10000 - this.q.e[var13] * (100 + a.b.c.c[3][2][5]) / 100;
      } else {
         byte var15 = 2;
         short var23 = super.e[var15];
         var15 = 3;
         var2 = this.q;
         var5 = var23 - this.q.e[var15];
      }

      if (this.f((byte)0)) {
         byte var17 = 1;
         int var24 = super.e[var17];
         short var10001 = a.b.c.c[3][0][5];
         var17 = 1;
         if (var24 <= var10001 * super.d[var17] / 100) {
            var17 = 2;
            var24 = super.e[var17] * (100 + a.b.c.c[3][0][6]) / 100;
            var17 = 3;
            var2 = this.q;
            var5 = var24 - this.q.e[var17];
         }
      } else if (this.f((byte)1)) {
         byte var21 = 2;
         int var26 = super.e[var21] * (100 + a.b.c.c[3][1][5]) / 100;
         var21 = 3;
         var2 = this.q;
         var5 = var26 - this.q.e[var21];
      }

      return var5;
   }

   public final int a(byte var1) {
      byte var4 = var1;
      int var2 = super.d[var4];
      switch (var1) {
         case 2:
            if (this.f((byte)0)) {
               var4 = 1;
               short var10000 = super.e[var4];
               short var10001 = a.b.c.c[3][0][5];
               var4 = 1;
               if (var10000 <= var10001 * super.d[var4] / 100) {
                  var4 = 2;
                  var2 = super.d[var4] * (100 + a.b.c.c[3][0][6]) / 100;
               }
            } else if (this.f((byte)1)) {
               var4 = 2;
               var2 = super.d[var4] * (100 + a.b.c.c[3][1][5]) / 100;
            }
            break;
         case 3:
            if (this.f((byte)2)) {
               var4 = 3;
               var2 = super.e[var4] * (100 + a.b.c.c[3][2][5]) / 100;
            }
         case 4:
      }

      return var2;
   }

   public final void k(int var1) {
      int var2 = var1;
      if (var1 <= 0) {
         var2 = 1;
      }

      byte var3 = 1;
      this.u(super.e[var3]);
      var3 = 1;
      short var4 = (short)(super.e[var3] - var2);
      var3 = 1;
      super.e[var3] = var4;
      var3 = 1;
      if (super.e[var3] <= 0) {
         byte var5 = 0;
         var3 = 1;
         super.e[var3] = var5;
      }
   }

   public final void l(int var1) {
      byte var3 = 1;
      short var4 = (short)(super.e[var3] + var1);
      var3 = 1;
      super.e[var3] = var4;
      var3 = 1;
      short var10000 = super.e[var3];
      var3 = 1;
      if (var10000 >= super.d[var3]) {
         var3 = 1;
         var4 = super.d[var3];
         var3 = 1;
         super.e[var3] = var4;
      }
   }

   private void B(int var1) {
      for (int var2 = 0; var2 < this.A.length; var2++) {
         if (this.A[var2] != -1) {
            this.z[var2] = (short)(this.z[var2] + var1);
            if (this.z[var2] >= a.b.c.c[1][this.A[var2]][5]) {
               this.z[var2] = a.b.c.c[1][this.A[var2]][5];
            }
         }
      }
   }

   public final boolean m(int var1) {
      return this.w[var1][4] == 1;
   }

   public final int a(byte var1, int var2, int var3) {
      short var4 = 0;
      if (var1 == -1) {
         return 0;
      }

      label34:
      switch (var1) {
         case 0:
            short[] var53 = this.w[var1];
            byte var42 = 3;
            var53[1] = (short)(super.d[var42] * a.b.c.c[6][var1][3] / 100);
            this.w[var1][2] = (short)(a.b.c.c[6][var1][4] * this.C() / 100);
            var42 = 3;
            short var15 = (short)(super.d[var42] + this.w[var1][1]);
            var42 = 3;
            super.e[var42] = var15;
            break;
         case 1:
            short[] var52 = this.w[var1];
            byte var39 = 3;
            var52[1] = (short)(super.d[var39] * a.b.c.c[6][var1][3] / 100);
            this.w[var1][2] = a.b.c.c[6][var1][4];
            var39 = 3;
            short var14 = (short)(super.d[var39] - this.w[var1][1]);
            var39 = 3;
            super.e[var39] = var14;
            break;
         case 2:
            short[] var51 = this.w[var1];
            byte var36 = 3;
            var51[1] = (short)(super.d[var36] * a.b.c.c[6][var1][3] / 100);
            this.w[var1][2] = a.b.c.c[6][var1][4];
            var36 = 3;
            short var13 = (short)(super.d[var36] + this.w[var1][1]);
            var36 = 3;
            super.e[var36] = var13;
            break;
         case 3:
            short[] var50 = this.w[var1];
            byte var34 = 1;
            var50[1] = (short)(super.d[var34] * a.b.c.c[6][var1][3] / 100);
            var4 = this.w[var1][1];
            var34 = 1;
            this.u(super.e[var34]);
            this.l(this.w[var1][1]);
            break;
         case 4:
            this.L[4] = (short)var3;
            short[] var49 = this.w[var1];
            byte var31 = 3;
            var49[1] = (short)(super.d[var31] * a.b.c.c[1][var3][8] / 100);
            var31 = 3;
            short var12 = (short)(super.d[var31] + this.w[var1][1]);
            var31 = 3;
            super.e[var31] = var12;
            break;
         case 5:
            this.w[var1][1] = a.b.c.c[6][var1][3];
            break;
         case 6:
            this.w[var1][1] = a.b.c.c[6][var1][3];
            this.w[var1][2] = a.b.c.c[6][var1][4];
            break;
         case 7:
            this.L[7] = (short)var3;
            short[] var48 = this.w[var1];
            byte var28 = 4;
            var48[1] = (short)(super.d[var28] * a.b.c.c[1][var3][8] / 100);
            var28 = 4;
            short var11 = (short)(super.d[var28] + this.w[var1][1]);
            var28 = 4;
            super.e[var28] = var11;
            break;
         case 8:
            this.w[var1][1] = a.b.c.c[6][var1][3];
            break;
         case 9:
            short[] var46 = this.w[var1];
            byte var22 = 4;
            var46[1] = (short)(super.d[var22] * a.b.c.c[6][var1][3] / 100);
            var46 = this.w[var1];
            var22 = 3;
            var46[2] = (short)(super.d[var22] * a.b.c.c[6][var1][4] / 100);
            var22 = 4;
            short var9 = (short)(super.d[var22] + this.w[var1][1]);
            var22 = 4;
            super.e[var22] = var9;
            var22 = 3;
            var9 = (short)(super.d[var22] - this.w[var1][2]);
            var22 = 3;
            super.e[var22] = var9;
            break;
         case 10:
            short[] var45 = this.w[var1];
            byte var19 = 2;
            var45[1] = (short)(super.d[var19] * a.b.c.c[6][var1][3] / 100);
            var19 = 2;
            short var8 = (short)(super.d[var19] + this.w[var1][1]);
            var19 = 2;
            super.e[var19] = var8;
            break;
         case 11:
            this.w[var1][1] = (short)var2;
            i var16 = game.a.B().n[var2];
            int var5 = 0;

            while (true) {
               byte var18 = 0;
               if (var5 >= var16.O[var18]) {
                  var16.E();
                  break label34;
               }

               this.a(var16.y[0][var5], var16.w[var16.y[0][var5]][1], game.a.B().n[var2].L[var5]);
               var5++;
            }
         case 12:
            this.L[12] = 1;
            break;
         case 13:
            short[] var10000 = this.w[var1];
            byte var7 = 1;
            var10000[1] = (short)(super.d[var7] * a.b.c.c[6][var1][3] / 100);
            var4 = this.w[var1][1];
            var7 = 1;
            this.u(super.e[var7]);
            this.l(this.w[var1][1]);
            this.D();
            break;
         case 14:
            this.D();
            break;
         case 15:
            this.w[var1][1] = (short)(var2 * a.b.c.c[6][var1][3]);
      }

      this.a(0, var1);
      this.w[var1][0] = a.b.c.c[6][var1][2];
      this.w[var1][4] = 1;
      return var4;
   }

   public final void n(int var1) {
      this.w[var1][4] = 0;

      for (byte var5 = 2; var5 <= 4; var5++) {
         byte var3 = var5;
         short var4 = super.d[var3];
         var3 = var5;
         super.e[var3] = var4;
      }
   }

   public final int o(int var1) {
      short var2 = 0;
      switch (var1) {
         case 0:
         case 5:
         case 6:
         case 8:
         case 14:
         case 15:
         default:
            break;
         case 1:
            byte var28 = 3;
            short var13 = (short)(super.d[var28] - this.w[var1][1]);
            var28 = 3;
            super.e[var28] = var13;
            break;
         case 2:
            byte var26 = 3;
            short var12 = (short)(super.d[var26] + this.w[var1][1]);
            var26 = 3;
            super.e[var26] = var12;
            break;
         case 3:
            var2 = this.w[var1][1];
            byte var25 = 1;
            this.u(super.e[var25]);
            this.l(this.w[var1][1]);
            break;
         case 4:
            byte var23 = 3;
            short var11 = (short)(super.e[var23] + this.w[var1][1]);
            var23 = 3;
            super.e[var23] = var11;
            break;
         case 7:
            byte var21 = 4;
            short var10 = (short)(super.d[var21] + this.w[var1][1]);
            var21 = 4;
            super.e[var21] = var10;
            break;
         case 9:
            byte var17 = 4;
            short var8 = (short)(super.d[var17] + this.w[var1][1]);
            var17 = 4;
            super.e[var17] = var8;
            var17 = 3;
            var8 = (short)(super.d[var17] - this.w[var1][2]);
            var17 = 3;
            super.e[var17] = var8;
            break;
         case 10:
            byte var15 = 2;
            short var7 = (short)(super.d[var15] + this.w[var1][1]);
            var15 = 2;
            super.e[var15] = var7;
            break;
         case 11:
            short[] var10001 = this.w[11];
            i var6 = game.a.B().n[var10001[1]];
            int var3 = 0;

            while (true) {
               byte var14 = 0;
               if (var3 >= var6.O[var14]) {
                  var6.E();
                  return var2;
               }

               byte var30 = var6.y[0][var3];
               short var10002 = var6.w[var6.y[0][var3]][1];
               short[] var10004 = this.w[11];
               this.a(var30, var10002, game.a.B().n[var10004[1]].L[var3]);
               var3++;
            }
         case 12:
            this.L[12] = 2;
            break;
         case 13:
            var2 = this.w[var1][1];
            byte var5 = 1;
            this.u(super.e[var5]);
            this.l(this.w[var1][1]);
      }

      return var2;
   }

   public final boolean p(int var1) {
      return this.x[var1][4] == 1;
   }

   public final void D() {
      for (int var1 = 0; var1 < 11; var1++) {
         if (this.x[var1][4] == 1) {
            this.C(var1);
         }
      }

      for (int var2 = 0; var2 < 3; var2++) {
         this.e(1, var2);
      }
   }

   public final void E() {
      for (int var1 = 0; var1 < 16; var1++) {
         if (this.w[var1][4] == 1) {
            this.n(var1);
         }
      }

      for (int var2 = 0; var2 < 3; var2++) {
         this.e(0, var2);
      }
   }

   private void C(int var1) {
      this.x[var1][4] = 0;

      for (byte var5 = 2; var5 <= 4; var5++) {
         byte var3 = var5;
         short var4 = super.d[var3];
         var3 = var5;
         super.e[var3] = var4;
      }
   }

   private void e(int var1, int var2) {
      this.y[var1][var2] = -1;
      if (this.O[var1] > 0) {
         this.O[var1]--;
      }
   }

   public final void q(int var1) {
      switch (var1) {
         case 0:
            short var8 = this.x[0][1];
            short var7 = a.b.c.c[1][this.x[0][3]][8];
            this.k(var8 / var7);
            if (!this.T()) {
               this.a((byte)3, true);
            }

            return;
         case 1:
            return;
         case 2:
            return;
         case 3:
            if (this.x[var1][0] <= 1) {
               short var2 = this.x[var1][1];
               short var6 = a.b.c.c[1][this.x[var1][3]][8];
               this.k(var2 * var6 / 100);
               if (!this.T()) {
                  this.a((byte)3, true);
               }

               return;
            }
            break;
         case 4:
            return;
         case 5:
            byte var10 = 4;
            short var5 = (short)(super.d[var10] - this.x[var1][1]);
            var10 = 4;
            super.e[var10] = var5;
            return;
         case 6:
            return;
         case 7:
            byte var3 = 3;
            short var4 = (short)(super.d[var3] - this.x[var1][1]);
            var3 = 3;
            super.e[var3] = var4;
         case 8:
         case 9:
         case 10:
      }
   }

   public final void c(int var1, int var2) {
      if (this.p(var1)) {
         if (this.x[var1][0] > 0) {
            this.x[var1][0]--;
         }

         if (this.x[var1][0] <= 0) {
            this.C(var1);
            this.e(1, var2);
         }
      }
   }

   public final void d(int var1, int var2) {
      if (this.m(var1)) {
         if (this.w[var1][0] > 0) {
            this.w[var1][0]--;
         }

         if (this.w[var1][0] <= 0) {
            this.n(var1);
            this.e(0, var2);
         }
      }
   }

   private void a(int var1, byte var2) {
      int var3;
      for (var3 = 0; var3 < 3; var3++) {
         if (this.y[var1][var3] == -1) {
            int var4;
            for (var4 = 0; var4 < 3; var4++) {
               if (this.y[var1][var4] == var2) {
                  return;
               }
            }

            if (var4 >= 3) {
               this.y[var1][var3] = var2;
               if (this.O[var1] < 3) {
                  this.O[var1]++;
               }
               break;
            }
         }
      }

      if (var3 >= 3) {
         this.y[var1][0] = var2;
      }
   }

   public final byte r(int var1) {
      return this.O[var1];
   }

   public final boolean f(byte var1) {
      byte var3 = 5;
      return super.d[var3] == var1;
   }

   public final int F() {
      return this.P;
   }

   public final int[] G() {
      int[] var1 = null;
      Vector var2 = new Vector();
      short var4 = a.b.c.c[0][this.W][18];
      short var5 = a.b.c.c[0][this.W][1];
      int var6 = this.X();

      for (int var7 = var5 * 10; var7 < var5 * 10 + 10; var7++) {
         short var10000 = a.b.c.c[1][var7][4];
         int var3 = 0;
         if (var10000 <= a.b.c.c[8][var4][var6]) {
            var3 = 0;

            while (var3 < this.A.length && var7 != this.A[var3]) {
               var3++;
            }

            if (var3 >= this.A.length) {
               var2.addElement(String.valueOf(var7));
            }
         }
      }

      if (var2.size() > 0) {
         var1 = new int[var2.size()];

         for (int var9 = 0; var9 < var1.length; var9++) {
            var1[var9] = Integer.parseInt((String)var2.elementAt(var9));
         }
      }

      return var1;
   }

   public final void g(byte var1) {
      for (int var2 = 0; var2 < this.A.length; var2++) {
         if (this.A[var2] == -1) {
            this.A[var2] = var1;
            this.P++;
            this.z[var2] = a.b.c.c[1][var1][5];
            return;
         }
      }
   }

   public final void H() {
      int var1 = a.b.c.c[0][this.W][1];
      if (this.U <= 5) {
         var1 *= 10;
         boolean var8 = true;

         for (int var9 = 0; var9 < this.A.length; var9++) {
            if (var1 == this.A[var9]) {
               var8 = false;
               break;
            }
         }

         if (var8) {
            this.g((byte)var1);
         }
      } else if (this.P < this.X() + 1) {
         int[] var2;
         int var3 = (var2 = this.G()).length;

         for (int var4 = 0; var4 < var2.length; var4++) {
            var1 = a.e.a(var3);
            this.g((byte)var2[var1]);
            if (this.P >= this.U / 10 + 1) {
               break;
            }

            while (var1 < var3 - 1) {
               var2[var1] = var2[var1 + 1];
               var1++;
            }

            var3--;
         }
      }
   }

   public final boolean s(int var1) {
      return var1 == -1 ? false : this.z[var1] > 0;
   }

   public final void a(byte var1, i var2) {
      i var3 = var2;
      super.q = var3;
      this.E = var1;

      for (int var4 = 0; var4 < this.A.length; var4++) {
         if (this.A[var4] == var1) {
            this.z[var4]--;
            if (this.m(12) && this.L[12] == 1) {
               this.z[var4]++;
            }

            if (this.m(8)) {
               this.z[var4]--;
            }
         }
      }
   }

   public final void b(int[] var1) {
      this.P = (byte)var1[0];

      for (int var2 = 0; var2 < var1[0]; var2++) {
         this.A[var2] = (byte)var1[var2 + 1];
         this.z[var2] = (short)var1[var1[0] + 1 + var2];
      }
   }

   public final byte t(int var1) {
      return var1 <= this.A.length - 1 && var1 >= 0 ? this.A[var1] : -1;
   }

   public static short a(byte var0, byte var1) {
      return a.b.c.c[1][var0][var1];
   }

   private int X() {
      int[] var1 = new int[]{5, 10, 20, 30, 40};
      int var2 = 0;

      for (int var3 = 0; var3 < var1.length; var3++) {
         if (this.U >= var1[var3]) {
            var2 = var3;
         }
      }

      return var2;
   }

   public final void h(byte var1) {
      this.E = var1;
   }

   public final byte I() {
      return this.E;
   }

   public final void h() {
      this.V();
      super.h();
      byte var2 = 1;
      this.u(super.d[var2]);
   }

   public final void J() {
      for (int var1 = 0; var1 < this.A.length; var1++) {
         if (this.A[var1] != -1) {
            this.z[var1] = a.b.c.c[1][this.A[var1]][5];
         }
      }

      this.h();
      this.c();
   }

   public final void K() {
      if (game.l.R == null) {
         game.l.R = new Vector();
      }

      short var1;
      if ((var1 = a.b.c.a((byte)0, (short)this.W, (byte)19)) != -1) {
         short var2 = a.b.c.a((byte)0, (short)this.W, (byte)21);
         int var3 = a.b.c.a((byte)0, (short)this.W, (byte)20) + 12;
         boolean var4 = false;
         if (!game.l.U && this.S() > 0 && this.U >= u[a.b.c.a((byte)0, var1, (byte)2) - 1] && game.j.p().a(var3, (byte)2) >= var2) {
            var4 = true;
         } else if (this.S() > 0 && this.U >= u[a.b.c.a((byte)0, var1, (byte)2) - 1]) {
            var4 = true;
         }

         if (var4) {
            int[] var6 = new int[]{this.W, a.b.c.c[0][this.W][0]};
            game.l.R.addElement(var6);
            game.l.V[0] = (byte)this.U;
            game.l.V[1] = (byte)this.W;
            game.l.S = 0;
         }
      }
   }

   public final void i(byte var1) {
      this.X = var1;
      switch (var1) {
         case 7:
            byte var15 = 2;
            short var26 = (short)(super.d[var15] * 90 / 100);
            var15 = 2;
            super.d[var15] = var26;
            var15 = 4;
            var26 = (short)(super.d[var15] + 7);
            var15 = 4;
            super.d[var15] = var26;
            var15 = 1;
            var26 = (short)(super.d[var15] * 80 / 100);
            var15 = 1;
            super.d[var15] = var26;
            return;
         case 8:
            byte var9 = 2;
            short var23 = (short)(super.d[var9] * 130 / 100);
            var9 = 2;
            super.d[var9] = var23;
            var9 = 4;
            var23 = (short)(super.d[var9] + -2);
            var9 = 4;
            super.d[var9] = var23;
            var9 = 1;
            var23 = (short)(super.d[var9] * 80 / 100);
            var9 = 1;
            super.d[var9] = var23;
            return;
         case 9:
            byte var2 = 2;
            short var3 = (short)(super.d[var2] * 90 / 100);
            var2 = 2;
            super.d[var2] = var3;
            var2 = 4;
            var3 = (short)(super.d[var2] + -2);
            var2 = 4;
            super.d[var2] = var3;
            var2 = 1;
            var3 = (short)(super.d[var2] * 130 / 100);
            var2 = 1;
            super.d[var2] = var3;
      }
   }

   public final boolean L() {
      return this.Z;
   }

   public final void e(boolean var1) {
      this.Z = var1;
   }

   public final int j(byte var1) {
      return a.b.c.c[0][this.W][var1];
   }

   public static short a(int var0, int var1, int var2, int var3) {
      switch (var3) {
         case 1:
            return (short)((a.b.c.c[0][var0][5] + a.b.c.c[0][var0][6] * var1 + a.b.c.c[0][var0][7]) * N[var2 - 1] / 100);
         case 2:
            return (short)((a.b.c.c[0][var0][8] + a.b.c.c[0][var0][9] * var1 + a.b.c.c[0][var0][10]) * N[var2 - 1] / 100);
         case 3:
            return (short)((a.b.c.c[0][var0][11] + a.b.c.c[0][var0][12] * var1 / 10 + a.b.c.c[0][var0][13]) * N[var2 - 1] / 100);
         case 4:
            return (short)((a.b.c.c[0][var0][14] + a.b.c.c[0][var0][15] * var1 / 10 + a.b.c.c[0][var0][16]) * N[var2 - 1] / 100);
         default:
            return 0;
      }
   }

   public final int M() {
      byte var2 = 1;
      int var10000 = super.e[var2] * 100;
      var2 = 1;
      return var10000 / super.d[var2];
   }

   public final int N() {
      int var10000 = this.R * 100;
      byte var2 = 1;
      return var10000 / super.d[var2];
   }

   public final int O() {
      return this.R;
   }

   public final void u(int var1) {
      byte var3 = 1;
      if (var1 >= super.d[var3]) {
         var3 = 1;
         this.R = super.d[var3];
      } else {
         this.R = var1;
      }
   }

   public final int P() {
      return this.T * 100 / this.v();
   }

   public final int v(int var1) {
      return var1 * 100 / this.v();
   }

   public static int a(short var0, short var1) {
      if (var1 >= 50) {
         var1 = 37300;
      } else {
         var1 = var1 * 15 * var1 - 200;
      }

      return var0 * 100 / var1;
   }

   public final int[] Q() {
      int[] var1;
      (var1 = new int[9 + (this.P << 1) + 1])[0] = this.W;
      var1[1] = this.U;
      byte var2 = 5;
      var1[2] = super.d[var2];
      var2 = 6;
      var1[3] = super.e[var2];
      var2 = 0;
      var1[4] = super.d[var2];
      var1[5] = this.X;
      var2 = 1;
      var1[6] = super.e[var2];
      var1[7] = this.T;
      var1[8] = this.F;
      var1[9] = this.P;

      for (int var7 = 0; var7 < this.P; var7++) {
         var1[var7 + 10] = this.A[var7];
         var1[10 + var1[9] + var7] = this.z[var7];
      }

      return var1;
   }

   public final int[] R() {
      int[] var1;
      (var1 = new int[(this.P << 1) + 1])[0] = this.P;

      for (int var2 = 0; var2 < this.P; var2++) {
         var1[var2 + 1] = this.A[var2];
         var1[var1[0] + var2 + 1] = this.z[var2];
      }

      return var1;
   }

   public final int S() {
      if (this.j((byte)19) == -1) {
         return 0;
      } else if (a.b.c.c[0][this.j((byte)19)][2] == 1) {
         return 1;
      } else if (a.b.c.c[0][this.j((byte)19)][2] == 2) {
         return 1;
      } else {
         return a.b.c.c[0][this.j((byte)19)][2] == 3 ? 2 : 0;
      }
   }

   public final void w(int var1) {
      switch (a.b.c.c[4][var1][5]) {
         case 1:
            byte var14 = 1;
            short var8 = (short)(super.d[var14] * a.b.c.c[4][var1][6] / 100 + a.b.c.c[4][var1][7]);
            var14 = 1;
            this.u(super.e[var14] + var8);
            this.l(var8);
            break;
         case 2:
            short var10 = a.b.c.c[4][var1][6];
            this.B(var10);
            break;
         case 3:
            byte var12 = 1;
            short var7 = (short)(super.d[var12] * a.b.c.c[4][var1][6] / 100 + a.b.c.c[4][var1][7]);
            short var9 = a.b.c.c[4][var1][8];
            var12 = 1;
            this.u(super.e[var12] + var7);
            this.l(var7);
            this.B(var9);
            break;
         case 4:
            this.c();
            byte var11 = 1;
            short var6 = (short)(super.d[var11] * a.b.c.c[4][var1][6] / 100 + a.b.c.c[4][var1][7]);
            short var3 = a.b.c.c[4][var1][8];
            this.u(var6);
            this.l(var6);
            this.B(var3);
            break;
         case 5:
            this.D();
            break;
         case 6:
            byte var2 = 2;
            byte var5 = 6;
            super.e[var5] = var2;
      }

      game.j.p().d(var1, 1, (byte)0);
   }

   public final int x(int var1) {
      if (!this.T() && a.b.c.c[4][var1][5] != 4) {
         return 8;
      }

      switch (a.b.c.c[4][var1][5]) {
         case 0:
            return 6;
         case 1:
            byte var11 = 1;
            short var13 = super.d[var11];
            var11 = 1;
            if (var13 == super.e[var11]) {
               return 2;
            }
            break;
         case 2:
            byte var6 = this.P;

            for (int var7 = 0; var7 < var6; var7++) {
               if (this.z[var7] < a(this.A[var7], (byte)5)) {
                  return -1;
               }
            }

            return 3;
         case 3:
            byte var5 = -1;
            byte var8 = 1;
            short var10000 = super.d[var8];
            var8 = 1;
            if (var10000 == super.e[var8] || !this.T()) {
               var5 = 2;
            }

            byte var2 = this.P;

            for (int var10 = 0; var10 < var2; var10++) {
               if (this.z[var10] < a(this.A[var10], (byte)5)) {
                  return -1;
               }
            }

            if (var5 == 2) {
               return 7;
            }
            break;
         case 4:
            if (this.T()) {
               return 1;
            }
            break;
         case 5:
            for (int var4 = 0; var4 < this.x.length; var4++) {
               if (this.p(var4)) {
                  return -1;
               }
            }

            return 4;
         case 6:
            byte var3 = 6;
            if (super.e[var3] >= 2) {
               return 5;
            }
      }

      return -1;
   }

   public final boolean T() {
      byte var2 = 1;
      return super.e[var2] > 0;
   }

   public final byte a(i var1) {
      short var2;
      short var3;
      boolean var5;
      boolean var6;
      label114: {
         var2 = a.b.c.c[0][this.W][1];
         var3 = a.b.c.c[0][var1.W][1];
         short var4 = a.b.c.c[0][this.W][22];
         short var7 = a.b.c.c[0][var1.W][22];
         var5 = false;
         var6 = false;
         if (var4 != 2 || var7 != 2) {
            if (var4 == 2 && var7 != 2) {
               var5 = true;
               break label114;
            }

            if (var4 != 2 && var7 == 2) {
               var6 = true;
               break label114;
            }
         }

         var5 = true;
         var6 = true;
      }

      if (!var5
         || (var2 != 0 || var3 != 1)
            && (var2 != 1 || var3 != 2)
            && (var2 != 2 || var3 != 3)
            && (var2 != 3 || var3 != 0)
            && (var2 != 5 || var3 != 6)
            && (var2 != 6 || var3 != 4)
            && (var2 != 4 || var3 != 5)) {
         return (byte)(!var6
               || (var3 != 0 || var2 != 1)
                  && (var3 != 1 || var2 != 2)
                  && (var3 != 2 || var2 != 3)
                  && (var3 != 3 || var2 != 0)
                  && (var3 != 5 || var2 != 6)
                  && (var3 != 6 || var2 != 4)
                  && (var3 != 4 || var2 != 5)
            ? -1
            : 1);
      } else {
         return 0;
      }
   }

   public final int[] b(i var1) {
      byte var2 = 0;
      int var3 = 5;
      int var4 = this.C();
      short var5 = a.b.c.c[0][this.W][1];
      if (this.D == game.j.p().X[var5] + game.j.p().Y[var5] - 1) {
         var3 = 30;
      }

      byte var9 = 4;
      var3 += super.e[var9] / 2;
      if (this.f((byte)4)) {
         var3 += a.b.c.c[3][4][5];
      }

      if (a.e.a(100) <= var3) {
         var4 = var4 * 3 / 2;
         var2 = 1;
      }

      int var14 = (byte)a.b.c.c[1][this.E][7];
      int var11 = -1;
      int var6 = var4;
      switch (this.E) {
         case 0:
         case 6:
         case 10:
         case 11:
         case 12:
         case 13:
         case 16:
         case 17:
         case 18:
         case 19:
         case 20:
         case 26:
         case 30:
         case 31:
         case 32:
         case 33:
         case 36:
         case 37:
         case 38:
         case 39:
         case 40:
         case 46:
         case 50:
         case 51:
         case 52:
         case 54:
         case 55:
         case 56:
         case 57:
         case 58:
         case 60:
         case 61:
         case 63:
         case 66:
         case 68:
         case 69:
            var4 = var4 * a.b.c.c[1][this.E][3] / 100;
            break;
         case 1:
         case 7:
            var4 = var4 * a.b.c.c[1][this.E][3] / 100 + var4 / a.b.c.c[1][this.E][8];
            break;
         case 2:
         case 8:
         case 22:
         case 28:
         case 41:
         case 47:
            var4 = var4 * a.b.c.c[1][this.E][3] / 100;
            var11 = a.b.c.c[1][this.E][8];
            break;
         case 3:
         case 9:
            if (var1.p(0)) {
               var4 = var4 * a.b.c.c[1][this.E][8] / 100;
            } else {
               var4 = var4 * a.b.c.c[1][this.E][3] / 100;
            }
            break;
         case 4:
         case 5:
         case 14:
         case 15:
         case 21:
         case 24:
         case 25:
         case 27:
         case 34:
         case 35:
         case 42:
         case 44:
         case 45:
         case 48:
         case 62:
         case 64:
         case 65:
         case 67:
         default:
            var14 = -1;
            break;
         case 23:
         case 29:
            if (var1.p(1)) {
               var4 = var4 * a.b.c.c[1][this.E][8] / 100;
            } else {
               var4 = var4 * a.b.c.c[1][this.E][3] / 100;
            }
            break;
         case 43:
         case 49:
            var4 = var4 * a.b.c.c[1][this.E][3] / 100;
            var1.E();
            break;
         case 53:
         case 59:
            var9 = 1;
            int var10000 = super.e[var9] * 100;
            var9 = 1;
            int var7 = var10000 / super.d[var9];
            var4 = var4 * (a.b.c.c[1][this.E][8] - var7) / 100;
      }

      if (var6 <= 0) {
         var6 = 1;
      }

      short var10002 = (short)var6;
      short var10003 = this.E;
      short var8 = (short)var11;
      short var20 = var10003;
      short var17 = var10002;
      var14 = (byte)var14;
      i var12 = var1;
      byte var30;
      if (var14 == -1) {
         var30 = -1;
      } else {
         label153: {
            if (var12.f((byte)3)) {
               if (a.e.a(100) > var8 * (100 - a.b.c.c[3][3][5]) / 100) {
                  var30 = -1;
                  break label153;
               }
            } else {
               if (var12.m(14)) {
                  var30 = -1;
                  break label153;
               }

               if (var8 != -1 && a.e.a(100) > var8) {
                  var30 = -1;
                  break label153;
               }
            }

            switch (var14) {
               case 0:
                  var12.x[var14][1] = var17;
               case 1:
               case 2:
               case 8:
               case 9:
               case 10:
               default:
                  break;
               case 3:
                  var12.x[var14][1] = var17;
                  break;
               case 4:
                  var12.x[var14][1] = a.b.c.c[1][var20][8];
                  break;
               case 5:
                  short[] var32 = var12.x[var14];
                  var9 = 4;
                  var32[1] = (short)(var12.d[var9] * a.b.c.c[1][var20][8] / 100);
                  var9 = 4;
                  var17 = (short)(var12.d[var9] - var12.x[var14][1]);
                  var9 = 4;
                  var12.e[var9] = var17;
                  break;
               case 6:
                  var12.x[var14][1] = a.b.c.c[1][var20][8];
                  break;
               case 7:
                  short[] var31 = var12.x[var14];
                  var9 = 3;
                  var31[1] = (short)(var12.d[var9] * a.b.c.c[1][var20][8] / 100);
                  var9 = 3;
                  var17 = (short)(var12.d[var9] - var12.x[var14][1]);
                  var9 = 3;
                  var12.e[var9] = var17;
            }

            var12.a(1, var14);
            if (var12.Y == 0 && game.j.p().b((byte)6, (byte)0) == 2 && game.j.p().b((byte)6, (byte)1) == 1) {
               var12.x[var14][0] = (short)(a.b.c.c[7][var14][2] / 2);
            } else {
               var12.x[var14][0] = a.b.c.c[7][var14][2];
            }

            var12.x[var14][3] = var20;
            var12.x[var14][4] = 1;
            var30 = var14;
         }
      }

      byte var21 = var30;
      if (this.m(0) && this.w[0][0] == 0) {
         var4 += this.w[0][2];
      }

      if (this.m(1)) {
         var4 += var4 * this.w[1][2] / 100;
      }

      if (this.p(6)) {
         var4 -= var4 * this.x[6][1] / 100;
      }

      if (var1.m(6) && a.e.a(100) <= this.w[6][1]) {
         var4 = var4 * this.w[6][2] / 100;
      }

      if (this.m(8)) {
         var4 += var4 * this.w[8][1] / 100;
      }

      if (this.Y == 0 && game.j.p().b((byte)3, (byte)0) == 2 && game.j.p().b((byte)3, (byte)1) == 1 && game.l.ab == 2) {
         var4 += var4 * a.b.c.c[2][3][5] / 100;
      }

      if (this.Y == 0 && game.j.p().b((byte)6, (byte)0) == 2) {
         var4 += var4 * a.b.c.c[2][6][5] / 100;
      }

      if (this.a(var1) == 0) {
         var4 *= 3;
      } else if (this.a(var1) == 1) {
         var4 = var4 * 60 / 100;
      }

      if (var4 <= 0) {
         var4 = 1;
      } else {
         var11 = a.e.a(100);
         var14 = (var4 << 1) / 100;
         if (var11 > 50) {
            if (var14 <= 0) {
               var4++;
            }
         } else if (var14 <= 0) {
            var4--;
         }

         if (var4 <= 0) {
            var4 = 1;
         }
      }

      if (var1.m(5) && a.e.a(100) <= var1.w[5][1]) {
         this.L[5] = (short)var4;
         return new int[]{var4, var2, var21};
      } else {
         return new int[]{var4, var2, var21};
      }
   }

   public final String U() {
      String[] var1 = new String[]{"Mộc hệ", "Thổ hệ", "Thủy hệ", "Hỏa hệ", "Quỷ hệ", "Phong hệ", "Điện hệ"};
      short var2 = a.b.c.c[0][this.W][1];
      return var1[var2];
   }

   public static String y(int var0) {
      String[] var1 = new String[]{"Mộc hệ", "Thổ hệ", "Thủy hệ", "Hỏa hệ", "Quỷ hệ", "Phong hệ", "Điện hệ"};
      short var2 = a.b.c.c[0][var0][1];
      return var1[var2];
   }
}
