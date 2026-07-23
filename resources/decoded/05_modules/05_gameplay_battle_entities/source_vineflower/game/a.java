package game;

import java.io.InputStream;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class a extends a.a {
   private final byte[] y = new byte[]{2, 4};
   private static game.a z;
   private static j A;
   private byte B = 0;
   public int k;
   public byte l;
   private byte C;
   public Image m;
   private int[][] D;
   public i[] n;
   private byte[] E;
   public byte[] o;
   public byte[] p;
   private byte[] F;
   public byte q = 0;
   public i r;
   private Vector G;
   public byte s;
   private boolean H;
   private static Vector I;
   public static Vector t;
   private boolean J;
   public boolean u;
   private boolean K;
   private boolean L;
   private boolean M;
   private byte N;
   private byte[] O;
   private byte[] P;
   private byte Q;
   private int R;
   private a.a.b S;
   private byte T = 0;
   private byte U = 0;
   private byte V = 0;
   private byte W = 0;
   private boolean X;
   private boolean Y;
   private byte[] Z;
   private int[] aa;
   private boolean ab;
   private byte ac;
   private byte ad;
   private byte ae;
   private byte[] af;
   private byte[][] ag;
   private byte[] ah;
   private byte[] ai;
   private byte[][] aj = new byte[][]{{3, 5, 13}, {0, 1, 2, 3, 8, 9, 10}};
   private a.a.g ak;
   private boolean al;
   public static byte v = 0;
   private a.a.g[] am;
   private static short[][] an;
   private static short[][][] ao;
   public static byte[][][] w;
   private static byte[][] ap;
   public static short[][] x;
   private static byte[][] aq;
   private static byte[][] ar;
   private static byte[][] as;
   private int at;
   private int au;
   private int av;
   private int aw;
   private int ax;
   private int ay;
   private String az = null;
   private static Image[] aA;
   private static short[][] aB;
   private Vector aC = new Vector();
   private Vector aD = new Vector();
   private int aE;
   private boolean aF;
   private int aG;
   private byte[] aH;
   private byte[] aI;
   private byte[] aJ;

   public static game.a B() {
      if (z == null) {
         z = new game.a();
      }

      return z;
   }

   public a() {
      new Vector();
      new Vector();
      this.aE = 0;
      this.aF = false;
      this.aG = 0;
      this.aH = new byte[]{10, 11, 12, 13, 15};
      this.aI = new byte[]{10, 12, 13, 14, 15, 16};
      this.aJ = new byte[]{105, 100, 80, 60, 40, 20, 5};
      if (this.G == null) {
         this.G = new Vector();
      }

      if (I == null) {
         I = new Vector();
      }

      if (t == null) {
         t = new Vector();
      }
   }

   public final void c() {
      this.G.removeAllElements();

      for (int var1 = 0; var1 < this.p.length; var1++) {
         this.n(var1).D();
         this.n(var1).E();
         this.n(var1).G = 0;
         this.n(var1).e(false);
         this.n(var1).H.removeAllElements();
         this.n(var1).I.removeAllElements();
         i var10000 = this.n(var1);
         i var10001 = this.n(var1);
         byte var3 = 1;
         var10000.u(var10001.e[var3]);
      }

      I.removeAllElements();
      t.removeAllElements();

      for (int var4 = 0; var4 < this.n.length; var4++) {
         if (this.n[var4] != null) {
            this.n[var4].d();
            this.n[var4] = null;
         }
      }

      for (int var5 = 0; var5 < aA.length; var5++) {
         if (aA[var5] != null) {
            aA[var5] = null;
         }
      }

      aA = null;
      if (this.ak != null) {
         this.ak.a.b();
         this.ak = null;
      }

      if (this.am != null) {
         for (int var6 = 0; var6 < this.am.length; var6++) {
            this.am[var6].a.b();
            this.am[var6] = null;
         }

         this.am = null;
      }

      this.F = null;
      this.s = 0;
      this.R = 0;
      this.r = null;
      this.H = false;
      this.J = false;
      this.S = null;
      this.n = null;
      this.m = null;
      this.E = null;
      this.o = null;
      this.O = null;
      this.P = null;
      this.af = null;
      this.Z = null;
      aq = null;
      ar = null;
      game.l.B = 0;
      an = null;
      ao = null;
      w = null;
      ap = null;
      x = null;
      aB = null;
      aq = null;
      ar = null;
      as = null;
      this.d.ai();
   }

   public final boolean b() {
      this.d();
      this.F = new byte[2];
      A = game.j.p();
      this.p = new byte[A.B];
      int var1 = 0;

      for (int var2 = 0; var2 < A.B; var2++) {
         this.p[var2] = (byte)var2;
         if (this.n(var2) != null && this.n(var2).T()) {
            var1++;
         }

         this.n(var2).j(this.n(var2).A());
      }

      if (var1 == 1 && this.k == 1) {
         this.n = new i[3];
      } else {
         this.n = new i[this.y[this.k]];
      }

      an = a.e.a(a.e.a("/data/script/pos.mid"));
      InputStream var4 = a.e.a("/data/script/cpos.mid");
      ao = new short[3][][];

      for (int var10 = 0; var10 < 3; var10++) {
         ao[var10] = a.e.a(var4);
      }

      InputStream var5 = a.e.a("/data/script/layer.mid");
      w = new byte[15][][];

      for (int var11 = 0; var11 < w.length; var11++) {
         w[var11] = a.e.b(var5);
      }

      ap = a.e.b(a.e.a("/data/script/effect.mid"));
      x = a.e.a(a.e.a("/data/script/speffect.mid"));
      aB = a.e.a(a.e.a("/data/script/blood.mid"));
      InputStream var6;
      aq = a.e.b(var6 = a.e.a("/data/script/bufDebuf.mid"));
      ar = a.e.b(var6);
      as = a.e.b(var6);
      if (this.k == 0) {
         if (this.l == 1) {
            this.C = 2;
         } else {
            this.C = 0;
         }
      } else {
         this.C = 1;
      }

      this.am = new a.a.g[this.n.length + 2];

      for (int var12 = 0; var12 < this.am.length; var12++) {
         this.am[var12] = new a.a.g();
         this.am[var12].a(294, false);
         if (var12 == this.n.length + 1) {
            this.am[var12].a((byte)2, (byte)-1, false);
            if (this.k == 0) {
               this.am[var12].c();
            }
         } else if (var12 == this.n.length) {
            this.am[var12].a((byte)1, (byte)-1, false);
            this.am[var12].c();
            this.am[var12].c(false);
         } else {
            this.am[var12].a((byte)0, (byte)-1, false);
            this.am[var12].b(ao[this.C][var12][2], ao[this.C][var12][3]);
            this.am[var12].c();
         }
      }

      this.O = new byte[this.n.length];
      this.P = new byte[this.n.length];
      this.r(this.n.length);
      int var13 = 0;

      for (int var7 = 0; var7 < this.n.length; var7++) {
         if (this.k == 0) {
            if (var7 <= 0) {
               switch (this.l) {
                  case 0:
                  case 1:
                     this.q(var7);
                     break;
                  case 2:
                     this.q(var7);
               }
            } else {
               while (!this.n(this.p[var13]).T()) {
                  var13++;
               }

               this.e(var7, var13);
               I.addElement(this.n(this.p[var13]));
               this.f(0, var13);
            }
         } else if (var7 <= 1) {
            switch (this.l) {
               case 0:
               case 1:
                  this.q(var7);
                  break;
               case 2:
                  this.q(var7);
            }
         } else {
            while (!this.n(this.p[var13]).T()) {
               var13++;
            }

            this.e(var7, var13);
            I.addElement(this.n(this.p[var13]));
            this.f(var7 - 2, var13);
            var13++;
         }
      }

      this.Q();
      aA = new Image[3];

      for (int var8 = 0; var8 < aA.length; var8++) {
         aA[var8] = a.e.b("/data/tex/", "blood_" + var8);
      }

      for (int var9 = 0; var9 < A.B; var9++) {
         i var10000 = A.A[var9];
         i var10001 = A.A[var9];
         byte var3 = 1;
         var10000.B = var10001.e[var3];
      }

      this.a((byte)0);
      e();
      return true;
   }

   public final void C() {
      int var1 = 0;

      for (int var2 = 0; var2 < A.B; var2++) {
         if (this.n(var2) != null && this.n(var2).T()) {
            var1++;
         }

         this.n(var2).j(this.n(var2).A());
      }

      i[] var5;
      if (this.k == 0) {
         var5 = new i[1];
      } else {
         var5 = new i[2];
      }

      for (byte var3 = 0; var3 < this.n.length; var3++) {
         if (this.n[var3].s() == 1) {
            var5[var3] = this.n[var3];
         }
      }

      if (var1 == 1 && this.k == 1) {
         this.n = new i[3];
      } else {
         this.n = new i[this.y[this.k]];
      }

      this.am = new a.a.g[this.n.length + 2];

      for (int var6 = 0; var6 < this.am.length; var6++) {
         this.am[var6] = new a.a.g();
         this.am[var6].a(294, false);
         if (var6 == this.n.length + 1) {
            this.am[var6].a((byte)2, (byte)-1, false);
            if (this.k == 0) {
               this.am[var6].c();
            }
         } else if (var6 == this.n.length) {
            this.am[var6].a((byte)1, (byte)-1, false);
            this.am[var6].c();
            this.am[var6].c(false);
         } else {
            this.am[var6].a((byte)0, (byte)-1, false);
            this.am[var6].b(ao[this.C][var6][2], ao[this.C][var6][3]);
            this.am[var6].c();
         }
      }

      this.O = new byte[this.n.length];
      this.P = new byte[this.n.length];
      this.R = 0;
      this.r(this.n.length);
      int var7 = 0;

      for (int var4 = 0; var4 < this.n.length; var4++) {
         if (this.k == 0) {
            if (var4 <= 0) {
               this.n[var4] = var5[var4];
            } else {
               while (!this.n(this.p[var7]).T()) {
                  var7++;
               }

               this.e(var4, var7);
               I.addElement(this.n(this.p[var7]));
               this.f(0, var7);
            }
         } else if (var4 <= 1) {
            this.n[var4] = var5[var4];
         } else {
            while (!this.n(this.p[var7]).T()) {
               var7++;
            }

            this.e(var4, var7);
            I.addElement(this.n(this.p[var7]));
            this.f(var4 - 2, var7);
            var7++;
         }
      }

      this.Q();
   }

   public final void D() {
      if (this.k == 1) {
         int var1 = 0;

         while (((i)this.G.elementAt(var1)).s() != 0 || ((i)this.G.elementAt(var1)).s() == 0 && !((i)this.G.elementAt(var1)).T()) {
            var1++;
         }

         if (this.n[0].T()) {
            this.d.b(this.n[this.o[var1]], this.n[0]);
            return;
         }

         this.d.b(this.n[this.o[var1]], this.n[1]);
      }
   }

   public final void E() {
      this.d = game.k.a();
      this.d.a(this);
      this.c = c.j.a();
      if (this.k == 0) {
         this.d.a(this.n[1], this.n[0]);
      } else {
         this.d.a(this.n[2], this.n[0]);
      }
   }

   public final void e(int var1, int var2) {
      this.n[var1] = this.n(this.p[var2]);
      this.n[var1].e(true);
      this.n[var1].f(0);
      i var10000 = this.n[var1];
      byte var3 = 0;
      var10000.o = var3;
      this.n[var1].b(ao[this.C][var1][0], ao[this.C][var1][1]);
      this.n[var1].c();
   }

   private void q(int var1) {
      this.n[var1] = new i();
      this.n[var1].a(this.D[this.F[0]][0], this.D[this.F[0]][1], (short)-1, (byte)2, (short)this.D[this.F[0]][2], (byte)-1);
      this.n[var1].f(1);
      i var10000 = this.n[var1];
      byte var3 = 1;
      var10000.o = var3;
      this.n[var1].b(ao[this.C][var1][0], ao[this.C][var1][1]);
      short var2 = a.b.c.c[0][this.D[this.F[0]][0]][1];
      this.n[var1].g((byte)(var2 * 10));
      this.n[var1].H();
      this.n[var1].c();
      A.a((byte)this.n[var1].j((byte)1), this.n[var1].r(), (byte)1);
      this.F[0]++;
   }

   private void I() {
      this.U = this.T;
      this.Z = ap[this.r.E];
      if (this.Z[this.U * 7 + 1] == 1) {
         this.S = new a.a.b();
         short var1;
         short var4;
         short var5;
         short var10;
         short var13;
         if (this.Z[this.U * 7] == 0) {
            i var2;
            var1 = (short)(var2 = (i)this.r.q).j;
            i var9;
            var10 = (short)(var9 = (i)this.r.q).k;
            var13 = (short)((i)this.r.q).r();
            var13 = a.b.c.c[0][var13][17];
            var4 = ((i)this.r.q).q();
            var5 = ((i)this.r.q).o;
         } else {
            i var11 = this.r;
            var1 = (short)this.r.j;
            i var12 = this.r;
            var10 = (short)this.r.k;
            var13 = (short)this.r.r();
            var13 = a.b.c.c[0][var13][17];
            var4 = this.r.q();
            var5 = this.r.o;
         }

         short[] var6;
         short[] var7 = new short[(var6 = x[this.Z[this.U * 7 + 2]]).length + 5];
         System.arraycopy(var6, 1, var7, 6, var6.length - 1);
         short[] var8;
         System.arraycopy(var8 = new short[]{var6[0], var1, var10, var13, var4, var5}, 0, var7, 0, var8.length);
         this.S.a(var7);
         this.S.d(true);
      } else if (this.Z[this.U * 7] == 0) {
         ((i)this.r.q).a((short)this.Z[this.U * 7 + 2], this.Z[this.U * 7 + 3]);
      } else {
         this.r.a((short)this.Z[this.U * 7 + 2], this.Z[this.U * 7 + 3]);
      }

      this.T++;
   }

   private boolean a(i var1) {
      while (!this.b(var1)) {
         for (int var2 = 0; var2 < this.aj[this.ah[this.ae << 1]].length; var2++) {
            if (this.aj[this.ah[this.ae << 1]][var2] == this.ah[(this.ae << 1) + 1]) {
               return false;
            }
         }

         if (this.ah[this.ae << 1] == 0) {
            var1.o(this.ah[(this.ae << 1) + 1]);
            var1.d(this.ah[(this.ae << 1) + 1], this.ai[this.ae]);
         } else if (this.ah[this.ae << 1] == 1) {
            var1.q(this.ah[(this.ae << 1) + 1]);
            var1.c(this.ah[(this.ae << 1) + 1], this.ai[this.ae]);
         }

         if (var1.s() == 0) {
            this.d.a(var1, false);
            this.d.a(var1);
         } else {
            this.d.b(var1, this.aF);
            this.d.b(var1);
         }

         this.ae++;
         this = this;
      }

      return true;
   }

   private void J() {
      i var1 = (i)this.G.elementAt(this.s);
      this.ad = this.ac;
      this.af = this.ag[this.ae];
      if (this.af[this.ad << 2] == 1) {
         this.S = new a.a.b();
         short var2 = (short)var1.j;
         short var3 = (short)var1.k;
         short var4 = (short)var1.r();
         var4 = a.b.c.c[0][var4][17];
         short var5 = var1.q();
         short var8 = var1.o;
         short[] var6;
         short[] var7 = new short[(var6 = x[this.af[(this.ad << 2) + 1]]).length + 5];
         System.arraycopy(var6, 1, var7, 6, var6.length - 1);
         short[] var9;
         System.arraycopy(var9 = new short[]{var6[0], var2, var3, var4, var5, var8}, 0, var7, 0, var9.length);
         this.S.a(var7);
         this.S.d(true);
      } else {
         var1.a((short)this.af[(this.ad << 2) + 1], this.af[(this.ad << 2) + 2]);
      }

      this.ac++;
   }

   private void a(i var1, boolean var2) {
      if (!var1.T()) {
         var1.D();
         var1.E();
         this.d.b(var1);
         this.h(var1);
         this.F[1]++;
      }

      if (this.F[1] >= this.D.length) {
         W();
         this.a((byte)8);
      } else if (!var1.T()) {
         for (int var3 = 0; var3 < this.n.length; var3++) {
            if (this.n[var3].m(11) && this.n[this.n[var3].w[11][1]].equals(var1)) {
               this.n[var3].n(11);
            }
         }

         if (this.F[0] < this.D.length) {
            this.q(this.o[this.s]);
            this.q = this.o[this.s];
            this.a((byte)15);
         } else {
            this.s++;
            this.L();
         }
      } else {
         if (var2) {
            this.a((byte)2);
         }
      }
   }

   private void b(i var1, boolean var2) {
      int var3 = 0;

      while (var3 < this.p.length && !this.n(this.p[var3]).T()) {
         var3++;
      }

      if (var3 >= this.p.length) {
         this.a((byte)9);
      } else if (!var1.T()) {
         for (int var4 = 0; var4 < this.n.length; var4++) {
            if (this.n[var4].m(11) && this.n[this.n[var4].w[11][1]].equals(var1)) {
               this.n[var4].n(11);
            }
         }

         var1.D();
         var1.E();
         this.d.a(var1);
         I.removeElement(var1);
         t.removeElement(var1);
         var1.C = 0;
         var1.e(false);
         var1.G = 0;
         if (this.P()) {
            this.q = this.o[this.s];
            this.a((byte)5);
         } else {
            this.s++;
            this.L();
         }
      } else {
         if (var2) {
            if (var1.p(9)) {
               this.a((byte)2);
               return;
            }

            this.a((byte)20);
         }
      }
   }

   private boolean b(i var1) {
      if (this.ae >= this.ag.length) {
         this.ae = 0;
         this.ad = this.ac = 0;
         this.ag = null;
         this.ah = null;
         this.ai = null;
         this.S = null;
         if (this.a == 12) {
            this.a(var1, true);
         } else if (this.a == 13) {
            this.b(var1, true);
         }

         return true;
      } else {
         return false;
      }
   }

   private void c(i var1) {
      this.ae++;
      if (!this.b(var1)) {
         if (this.a(var1)) {
            return;
         }

         this.ad = this.ac = 0;
         this.J();
         if (this.a == 12) {
            if (this.g(var1) == 2) {
               this.ae = 0;
               this.ag = null;
               this.ah = null;
               this.ai = null;
            }

            this.a(var1, false);
            return;
         }

         if (this.a == 13) {
            if (this.g(var1) == 1) {
               this.ae = 0;
               this.ag = null;
               this.ah = null;
               this.ai = null;
            }

            this.b(var1, false);
         }
      }
   }

   private void K() {
      i var1;
      label102:
      if ((var1 = (i)this.G.elementAt(this.s)).v != null) {
         if (var1.v.j()) {
            a.a.b var6 = var1.v;
            if (!var1.v.b.f()) {
               if (this.af[(this.ad << 2) + 3] != -1 && var1.v.a((int)this.af[(this.ad << 2) + 3]) && this.ac < this.af.length / 4) {
                  this.J();
               }
               break label102;
            }

            var1.v.b();
            var1.v = null;
            if (this.ac > this.af.length / 4 - 1) {
               if (this.S == null) {
                  this.L = true;
               }
               break label102;
            }

            this.J();
            if (var1.v == null) {
               break label102;
            }
         }

         var1.v.a();
      }

      if (this.S != null && !this.S.j()) {
         this.S.a();
         var1.c(false);
      }

      if (this.S != null && this.S.j() && !this.S.d()) {
         this.S = null;
         var1.c(true);
         if (this.ac > this.af.length / 4 - 1) {
            this.L = true;
         } else {
            this.J();
         }
      }

      if (this.L) {
         i var2 = var1;
         game.a var8 = this;
         boolean var3 = false;
         int var4 = var2.O();
         int var5 = 0;
         if (!var8.aF) {
            if (var8.ah[var8.ae << 1] == 0) {
               var5 = var2.o(var8.ah[(var8.ae << 1) + 1]);
               var2.d(var8.ah[(var8.ae << 1) + 1], var8.ai[var8.ae]);
            } else if (var8.ah[var8.ae << 1] == 1) {
               var2.q(var8.ah[(var8.ae << 1) + 1]);
               var2.c(var8.ah[(var8.ae << 1) + 1], var8.ai[var8.ae]);
            }

            byte var7 = 1;
            if (var2.e[var7] < var4) {
               StringBuffer var10001 = new StringBuffer();
               var7 = 1;
               var8.a(var10001.append(var2.e[var7] - var4).toString(), (byte)0, 0, var2.s(), var2.j, var2.k, 9, 12);
            }

            if (var5 > 0) {
               var8.a("+" + var5, (byte)0, 2, var2.s(), var2.j, var2.k, 9, 12);
            }

            var8.aF = true;
            var8.d.k = 0;
            if (var2.s() == 0) {
               var8.d.a(var2);
            } else {
               var8.d.b(var2);
            }
         }

         boolean var9 = var8.S();
         if (var2.s() == 0) {
            byte var11 = 1;
            if (var4 < var2.e[var11]) {
               if (var8.d.a(var2, true) && var9) {
                  var8.aF = false;
                  var3 = true;
                  var8.c(var2);
               }
            } else if (var8.d.a(var2, false) && var9) {
               var8.aF = false;
               var3 = true;
               var8.c(var2);
            }
         } else {
            byte var12 = 1;
            if (var4 < var2.e[var12]) {
               if (var8.d.b(var2, true) && var9) {
                  var8.aF = false;
                  var3 = true;
                  var8.c(var2);
               }
            } else if (var8.d.b(var2, false) && var9) {
               var8.aF = false;
               var3 = true;
               var8.c(var2);
            }
         }

         if (var3) {
            this.L = false;
         }
      }
   }

   private void r(int var1) {
      this.E = new byte[var1];
      this.o = new byte[var1];

      for (int var2 = 0; var2 < this.E.length; var2++) {
         this.E[var2] = (byte)var2;
      }
   }

   private void e(byte var1) {
      switch (var1) {
         case 0:
            this.ak.a(var1, (byte)0, true);
            break;
         case 1:
            this.n[0].c(false);
            short var5 = a.b.c.c[0][((i)this.r.q).r()][17];
            i var8;
            i var9;
            short[] var6 = new short[]{
               8, (short)(var8 = (i)this.r.q).j, (short)(var9 = (i)this.r.q).k, var5, 0, ((i)this.r.q).o, 0, 9, 1, 3, 0, 10, 0, 0, 7, 0, -10, 4, 0, -20
            };
            this.S = new a.a.b();
            this.S.a(var6);
            this.S.d(true);
            this.S.a();
            this.ak.a(var1, (byte)-2, true);
            break;
         case 2:
            this.ak.a(var1, (byte)0, true);
            break;
         case 3:
            this.ak.a(var1, (byte)-2, true);
            break;
         case 4:
            short var2 = a.b.c.c[0][((i)this.r.q).r()][17];
            i var3;
            i var7;
            short[] var4 = new short[]{
               8,
               (short)(var3 = (i)this.r.q).j,
               (short)(var7 = (i)this.r.q).k,
               var2,
               0,
               ((i)this.r.q).o,
               0,
               8,
               1,
               4,
               1,
               4,
               0,
               -20,
               6,
               0,
               -12,
               8,
               0,
               -4,
               10,
               0,
               0
            };
            this.S = new a.a.b();
            this.S.a(var4);
            this.S.d(true);
            this.S.a();
            this.ak.a((byte)1, (byte)-2, true);
      }

      this.B = var1;
   }

   private void a(int var1, boolean var2) {
      this.am[this.n.length + 1].c(var2);
      this.am[this.n.length + 1].b(an[this.k][(var1 << 2) + 2], an[this.k][(var1 << 2) + 3]);
   }

   private void b(int var1, boolean var2) {
      this.am[this.n.length].c(var2);
      this.am[this.n.length].b(an[this.k][(var1 << 2) + 2], an[this.k][(var1 << 2) + 3]);
   }

   public final void a(byte var1) {
      this.b = this.a;
      this.a = (byte)var1;
      switch (var1) {
         case 0:
            this.s = 0;

            while (((i)this.G.elementAt(this.s)).s() != 0) {
               this.s++;
            }
            break;
         case 1:
            if (this.s >= this.G.size()) {
               this.s = 0;
            }

            for (this.r = (i)this.G.elementAt(this.s); this.r.K || !this.r.T(); this.r = (i)this.G.elementAt(this.s)) {
               this.s++;
               if (this.r.K) {
                  this.r.K = false;
               }

               if (this.s >= this.G.size()) {
                  this.H = true;
                  this.s = 0;
                  break;
               }
            }

            if (this.r.p(2) && this.r.s() == 0) {
               boolean var8 = false;

               for (int var10 = 0; var10 < this.r.z.length; var10++) {
                  if (this.r.z[var10] != 0) {
                     var8 = true;
                  }
               }

               if (!var8) {
                  this.d.c("Không còn tinh lực, không cách nào chiến đấu");
                  this.s++;
                  if (this.s >= this.G.size()) {
                     this.H = true;
                     this.s = 0;
                     return;
                  }
               }

               return;
            }
            break;
         case 2:
            return;
         case 3:
            this.d.e((i)this.G.elementAt(this.s));
            return;
         case 4:
            this.d.am();
            return;
         case 5:
            this.d.c = 0;
            this.d.Z();
            return;
         case 6:
            this.N = 0;
            this.d.b((i)this.r.H.elementAt(this.N), false);
            this.d.b(this.r, (i)this.r.H.elementAt(this.N));
            this.d.b((i)this.r.H.elementAt(this.N));
            this.a(Integer.parseInt((String)this.r.I.elementAt(this.N)), true);
            return;
         case 7:
            if (this.r.s() == 0) {
               this.d.a(this.r, false);
               this.d.a(this.r);
            } else {
               this.d.b(this.r, false);
               this.d.b(this.r);
            }

            if (((i)this.r.q).s() == 1) {
               this.d.b((i)this.r.q, false);
               this.d.b((i)this.r.q);
            } else {
               this.d.a((i)this.r.q, false);
               this.d.a((i)this.r.q);
            }

            this.K = false;
            this.L = false;
            this.I();
            if (this.O()) {
               this.aa = this.r.b((i)this.r.q);
            }

            switch (this.r.E) {
               case 52:
               case 58:
                  if (a.e.a(100) > 30) {
                     this.ab = false;
                     break;
                  }
               default:
                  this.ab = true;
            }

            if (this.Z[this.U * 7] == 0) {
               this.r.a((byte)1, true);
               return;
            }

            this.r.a((byte)0, true);
            return;
         case 8:
            game.l.B().Z.y = 0;

            for (int var9 = 0; var9 < I.size(); var9++) {
               var1 = ((i)I.elementAt(var9)).B - ((i)I.elementAt(var9)).c((byte)1);
               if (i) {
                  var1 = var1 % 20 / 100;
               } else {
                  var1 = var1 % 50 / 100;
               }

               if (var1 > 0) {
                  ((i)I.elementAt(var9)).l(var1);
                  ((i)I.elementAt(var9)).u(((i)I.elementAt(var9)).c((byte)1));
               }
            }

            this.am[0].b(an[0][6], an[0][7]);
            this.d.b(an[0][4], an[0][5]);
            return;
         case 9:
            this.N();
            return;
         case 10:
            return;
         case 11:
            this.d.a(4, (byte)0);
            return;
         case 12:
         case 13:
            if (this.r.s() == 0) {
               this.d.a(this.r, false);
               this.d.a(this.r);
            } else {
               this.d.b(this.r, false);
               this.d.b(this.r);
            }

            i var5;
            if ((var5 = (i)this.G.elementAt(this.s)).m(13) || var5.m(14)) {
               var5.D();
            }

            this.ag = new byte[var5.r(0) + var5.r(1)][];
            this.ah = new byte[this.ag.length << 1];
            this.ai = new byte[this.ag.length];
            int var2 = 0;

            for (int var11 = 0; var11 < 3; var11++) {
               if (var5.y[0][var11] != -1) {
                  this.ai[var2] = (byte)var11;
                  this.ag[var2] = aq[as[0][var5.y[0][var11]]];
                  this.ah[var2 << 1] = 0;
                  this.ah[(var2 << 1) + 1] = var5.y[0][var11];
                  var2++;
               }
            }

            for (int var12 = 0; var12 < 3; var12++) {
               if (var5.y[1][var12] != -1) {
                  this.ai[var2] = (byte)var12;
                  this.ag[var2] = ar[as[1][var5.y[1][var12]]];
                  this.ah[var2 << 1] = 1;
                  this.ah[(var2 << 1) + 1] = var5.y[1][var12];
                  var2++;
               }
            }

            this.ad = this.ac = 0;
            if (!this.a(var5)) {
               this.J();
               return;
            }
            break;
         case 14:
            return;
         case 15:
            this.d.a = 0;
            this.J = true;
            this.R = this.q;
            this.P[this.R] = 0;
            this.G.setElementAt(this.n[this.q], this.E[this.q]);
            this.n[this.q].K = true;
            this.b(this.q, false);
            this.s++;
            return;
         case 16:
            this.d.c = 0;
            this.d.l = false;
            this.d.Z();
            return;
         case 17:
            this.r.a(this.n[0]);
            this.ak = new a.a.g();
            this.ak.a(269, false);
            this.ak.b(this.r.m(), this.r.n());
            this.ak.c();
            this.e((byte)0);
            this.al = false;
            int var3 = this.m(v);
            if (a.e.a(100) < var3) {
               this.al = true;
            } else {
               this.al = false;
            }

            if (f == 0 && g == 5) {
               this.al = false;
            }

            this.d.f = 0;
            return;
         case 18:
            return;
         case 19:
         case 25:
         case 26:
         case 27:
         case 28:
         case 29:
         case 30:
         case 31:
         case 32:
         case 33:
         case 34:
         case 35:
         case 36:
         case 37:
         case 38:
         case 39:
         case 40:
         case 41:
         case 42:
         case 43:
         case 44:
         case 45:
         case 46:
         case 47:
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
         case 58:
         case 59:
         case 60:
         case 61:
         case 62:
         case 63:
         case 64:
         case 65:
         case 66:
         case 67:
         case 68:
         case 69:
         case 70:
         case 71:
         case 72:
         case 73:
         case 74:
         case 75:
         case 76:
         case 77:
         case 78:
         case 79:
         case 80:
         case 81:
         case 82:
         case 83:
         case 84:
         case 85:
         case 86:
         case 87:
         case 88:
         case 89:
         case 90:
         case 91:
         case 92:
         case 93:
         case 94:
         case 95:
         case 96:
         case 97:
         case 98:
         case 99:
         case 100:
         case 103:
         default:
            break;
         case 20:
            this.r = (i)this.G.elementAt(this.s);

            for (int var4 = 0; var4 < this.n.length; var4++) {
               if (this.n[var4].s() == 1 && this.n[var4].T()) {
                  this.d.b(this.n[var4], false);
                  this.d.b(this.n[var4]);
               }
            }

            this.b(this.o[this.s], true);
            this.d.c(this.r);
            if (this.n[0].T()) {
               this.d.b(this.r, this.n[0]);
               return;
            }

            this.d.b(this.r, this.n[1]);
            return;
         case 21:
            this.r.a(this.n[0]);
            this.d.ak();
            return;
         case 22:
            this.d.aq();
            return;
         case 23:
            this.d.as();
            return;
         case 24:
            this.d.aH();
            return;
         case 101:
            this.d.aJ();
            break;
         case 102:
            this.d.aL();
            return;
         case 104:
            this.d.aK();
            return;
      }
   }

   public final void a() {
      if (this.j) {
         this.A();
         switch (this.a) {
            case 0:
               this.Q++;
               this.O[this.R] = this.P[this.R];
               this.n[this.R].b(ao[this.C][this.R][this.P[this.R] << 2], ao[this.C][this.R][(this.P[this.R] << 2) + 1]);
               this.am[this.R].b(ao[this.C][this.R][(this.P[this.R] << 2) + 2], ao[this.C][this.R][(this.P[this.R] << 2) + 3]);
               if (this.k == 1 && this.P[this.R] > ao[this.C][this.R].length / 4 - 3 && this.R % 2 == 0 && this.P.length > this.R + 1) {
                  this.P[this.R + 1]++;
                  this.O[this.R + 1] = this.P[this.R + 1];
                  this.n[this.R + 1].b(ao[this.C][this.R + 1][this.P[this.R + 1] << 2], ao[this.C][this.R + 1][(this.P[this.R + 1] << 2) + 1]);
                  this.am[this.R + 1].b(ao[this.C][this.R + 1][(this.P[this.R + 1] << 2) + 2], ao[this.C][this.R + 1][(this.P[this.R + 1] << 2) + 3]);
               }

               if (this.k == 0) {
                  this.d.a(this.n[1], this.n[0], this.n[this.R], this.P[this.R] + 1, ao[this.C][this.R].length / 4);
               }

               if (this.Q > 1) {
                  this.P[this.R]++;
                  this.Q = 0;
               }

               if (this.P[this.R] > ao[this.C][this.R].length / 4 - 1) {
                  this.P[this.R] = (byte)(ao[this.C][this.R].length / 4 - 1);
                  this.O[this.R] = this.P[this.R];
                  this.R++;
                  if (this.R > this.n.length - 1) {
                     this.R = this.n.length - 1;
                     this.a((byte)20);
                  }
               }
               break;
            case 1:
               if (this.d.aB()) {
                  if (this.r.s() == 1 && this.l == 0 && (this.r.r() == 33 || this.r.r() == 59) && this.r.c((byte)1) < this.r.b((byte)1)) {
                     this.a((byte)10);
                     return;
                  }

                  if (!this.H) {
                     if (this.r.s() == 1) {
                        if (d(this.r)) {
                           this.a((byte)12);
                        } else {
                           this.a((byte)2);
                        }
                     } else {
                        this.a((byte)2);
                     }
                  } else {
                     if (this.J) {
                        this.Q();
                        this.s = 0;
                        this.J = false;
                     }

                     this.s = 0;

                     while (((i)this.G.elementAt(this.s)).s() != 0 || ((i)this.G.elementAt(this.s)).s() == 0 && !((i)this.G.elementAt(this.s)).T()) {
                        this.s++;
                     }

                     if (d((i)this.G.elementAt(this.s))) {
                        this.a((byte)13);
                     } else {
                        this.a((byte)20);
                     }

                     this.H = false;
                  }
               }

               this.d.g();
               this.am[this.n.length].a();
               break;
            case 2:
               if (this.r.s() == 1) {
                  byte var5 = (byte)e(this.r);
                  if (this.r.p(9)) {
                     this.f(this.r);
                  } else {
                     boolean var11 = true;
                     if (game.i.a(var5, (byte)9) == 0 && this.r.p(8) && a.e.a(100) > a.b.c.a((byte)1, var5, (byte)8)) {
                        this.f(this.r);
                        var11 = false;
                     }

                     if (var11) {
                        this.d(var5);
                     }
                  }

                  int var12 = a.e.a(this.r.H.size());
                  i var16 = (i)this.r.H.elementAt(var12);
                  this.r.J = Byte.parseByte((String)this.r.I.elementAt(var12));
                  this.r.a(var5, var16);
                  this.d.b(this.r, var16);
                  this.a((byte)7);
               } else if (this.r.p(9)) {
                  this.f(this.r);
                  int var6 = a.e.a(this.r.H.size());
                  i var13 = (i)this.r.H.elementAt(var6);
                  this.r.J = Byte.parseByte((String)this.r.I.elementAt(var6));
                  byte var17 = (byte)e(this.r);
                  this.r.a(var17, var13);
                  this.d.b(this.r, var13);
                  this.a((byte)7);
               } else {
                  boolean var7 = true;
                  if (game.i.a(this.r.I(), (byte)9) == 0 && this.r.p(8) && a.e.a(100) > a.b.c.a((byte)1, this.r.I(), (byte)8)) {
                     this.f(this.r);
                     var7 = false;
                  }

                  if (var7) {
                     if ((i)this.r.q != null && !((i)this.r.q).T()) {
                        for (int var14 = 0; var14 < this.r.H.size(); var14++) {
                           if (((i)this.r.H.elementAt(var14)).T()) {
                              this.r.J = Byte.parseByte((String)this.r.I.elementAt(var14));
                              this.r.a(this.r.I(), (i)this.r.H.elementAt(var14));
                           }
                        }
                     } else {
                        this.r.a(this.r.I(), (i)this.r.q);
                     }
                  }

                  this.d.b(this.r, (i)this.r.q);
                  this.a((byte)7);
               }
               break;
            case 3:
               this.d.f((i)this.G.elementAt(this.s));
               break;
            case 4:
               this.d.an();
               break;
            case 5:
               this.d.aa();
               break;
            case 6:
               if (this.g(4100)) {
                  if (this.k == 1) {
                     this.N--;
                     if (this.N <= 0) {
                        this.N = 0;
                     }

                     this.a(Integer.parseInt((String)this.r.I.elementAt(this.N)), true);
                     this.d.b((i)this.r.H.elementAt(this.N), false);
                     this.d.b(this.r, (i)this.r.H.elementAt(this.N));
                     this.d.b((i)this.r.H.elementAt(this.N));
                  }
               } else if (this.g(8448)) {
                  if (this.k == 1) {
                     this.N++;
                     if (this.N >= this.r.H.size() - 1) {
                        this.N = (byte)(this.r.H.size() - 1);
                     }

                     this.a(Integer.parseInt((String)this.r.I.elementAt(this.N)), true);
                     this.d.b((i)this.r.H.elementAt(this.N), false);
                     this.d.b(this.r, (i)this.r.H.elementAt(this.N));
                     this.d.b((i)this.r.H.elementAt(this.N));
                  }
               } else if (this.g(16400)) {
                  if (this.k == 1) {
                     this.N--;
                     if (this.N <= 0) {
                        this.N = 0;
                     }

                     this.a(Integer.parseInt((String)this.r.I.elementAt(this.N)), true);
                     this.d.b((i)this.r.H.elementAt(this.N), false);
                     this.d.b(this.r, (i)this.r.H.elementAt(this.N));
                     this.d.b((i)this.r.H.elementAt(this.N));
                  }
               } else if (this.g(32832)) {
                  if (this.k == 1) {
                     this.N++;
                     if (this.N >= this.r.H.size() - 1) {
                        this.N = (byte)(this.r.H.size() - 1);
                     }

                     this.a(Integer.parseInt((String)this.r.I.elementAt(this.N)), true);
                     this.d.b((i)this.r.H.elementAt(this.N), false);
                     this.d.b(this.r, (i)this.r.H.elementAt(this.N));
                     this.d.b((i)this.r.H.elementAt(this.N));
                  }
               } else if (this.g(196640)) {
                  this.G();
               } else if (this.g(786432)) {
                  this.a(Integer.parseInt((String)this.r.I.elementAt(this.N)), false);
                  this.a((byte)3);
               }

               this.am[this.n.length].a();
               this.am[this.n.length + 1].a();
               break;
            case 7:
               if (this.r.v != null) {
                  if (this.r.q() == 0) {
                     if (this.r.v.j()) {
                        if (this.r.v.c()) {
                           this.r.v.b();
                           this.r.v = null;
                           if (this.T <= this.Z.length / 7 - 1 && !this.T()) {
                              this.I();
                              if (this.r.v != null) {
                                 this.r.v.a();
                              }

                              if (this.S != null) {
                                 this.X = true;
                              }
                           } else {
                              this.L = true;
                              this.M = true;
                           }
                        } else if (this.Z[this.U * 7 + 4] != -1 && this.r.v.a((int)this.Z[this.U * 7 + 4])) {
                           this.r.v.b();
                           if (this.T < this.Z.length / 7 - 1 || this.T()) {
                              this.I();
                              if (this.S != null) {
                                 this.X = true;
                              }
                           }
                        } else if (this.Z[this.U * 7 + 5] != -1 && this.r.v.a((int)this.Z[this.U * 7 + 5])) {
                           this.r.a(this.Z[this.U * 7 + 6], true);
                        }
                     } else {
                        this.Y = false;
                        this.r.v.a();
                     }
                  } else if (this.r.q() == 1 && this.r.b()) {
                     this.r.a((byte)0, true);
                  }
               } else if (((i)this.r.q).v != null) {
                  if (((i)this.r.q).v.j()) {
                     if (((i)this.r.q).v.c()) {
                        ((i)this.r.q).v.b();
                        if (this.T <= this.Z.length / 7 - 1 && !this.T()) {
                           if (this.Z[this.T * 7] == 1) {
                              ((i)this.r.q).a((byte)2, true);
                           } else {
                              this.V = 0;
                              ((i)this.r.q).v = null;
                              this.I();
                              if (((i)this.r.q).v != null) {
                                 ((i)this.r.q).v.a();
                              }

                              if (this.S != null) {
                                 this.X = true;
                              }
                           }
                        } else {
                           ((i)this.r.q).a((byte)2, true);
                        }
                     } else {
                        if (this.Z[this.U * 7 + 5] != -1) {
                           this.V = this.U;
                        }

                        if (this.Z[this.V * 7 + 5] != -1 && ((i)this.r.q).v.a((int)this.Z[this.V * 7 + 5])) {
                           ((i)this.r.q).a(this.Z[this.V * 7 + 6], true);
                           this.V = 0;
                        }

                        if (this.Z[this.U * 7 + 4] != -1 && ((i)this.r.q).v.a((int)this.Z[this.U * 7 + 4])) {
                           this.I();
                           if (this.S != null) {
                              this.X = true;
                           }
                        }
                     }
                  } else if ((this.r.q() != 1 || !this.r.b()) && !this.Y) {
                     if (((i)this.r.q).q() == 2 && ((i)this.r.q).b()) {
                        this.K = true;
                        ((i)this.r.q).v = null;
                        if (this.T <= this.Z.length / 7 - 1 && !this.T()) {
                           this.I();
                           if (this.S != null) {
                              this.X = true;
                           }
                        } else {
                           this.L = true;
                        }
                     }
                  } else {
                     this.r.a((byte)0, true);
                     ((i)this.r.q).v.a();
                     this.Y = false;
                  }
               }

               if (this.S != null && !this.S.j() && (this.r.q() == 1 && this.r.b() || this.X || this.r.q() == 0)) {
                  if (this.U == 0) {
                     this.Y = true;
                  }

                  this.r.a((byte)0, true);
                  this.S.a();
                  this.W = this.U;
                  if (this.Z[this.U * 7] == 0) {
                     ((i)this.r.q).c(false);
                  } else {
                     this.r.c(false);
                  }
               }

               if (this.S != null && this.S.j() && !this.S.d()) {
                  this.S = null;
                  this.X = false;
                  if (this.Z[this.W * 7] == 0) {
                     ((i)this.r.q).c(true);
                  } else {
                     this.r.c(true);
                  }

                  if (((i)this.r.q).v == null && this.r.v == null) {
                     if (this.T <= this.Z.length / 7 - 1 && !this.T()) {
                        if (this.Z[this.T * 7] == 1) {
                           this.K = true;
                        }

                        this.I();
                        if (this.S != null) {
                           this.X = true;
                        }
                     } else {
                        if (this.Z[this.U * 7] == 0) {
                           this.K = true;
                        }

                        this.M = true;
                        this.L = true;
                     }
                  }

                  this.W = 0;
               }

               if (this.K) {
                  this.M = false;
                  if (this.U() && (((i)this.r.q).T() || this.c((i)this.r.q, true))) {
                     this.M = true;
                     this.K = false;
                  }
               }

               if (this.M && this.L && this.M()) {
                  this.M = false;
                  this.L = false;
               }
               break;
            case 8:
               this.d.ap();
            case 9:
            case 14:
            case 18:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 103:
            default:
               break;
            case 10:
               if (!this.d.j() && this.c(this.r, false)) {
                  this.d.c(c(a.b.c.c[0][this.r.r()][0]) + "Chạy trốn");
               }

               if (this.d.g()) {
                  game.f.B().a((byte)10);
               }
               break;
            case 11:
               this.d.a((byte)4, (byte)0);
               break;
            case 12:
            case 13:
               this.K();
               break;
            case 15:
               if (this.k == 0) {
                  this.d.a(this.n[1], this.n[0], this.P[this.R] + 1, ao[this.C][this.R].length / 4);
               }

               if (this.Q > 0) {
                  this.P[this.R]++;
                  this.Q = 0;
               } else {
                  this.Q++;
                  if (this.P[this.R] > ao[this.C][this.R].length / 4 - 3) {
                     this.O[this.R] = this.P[this.R];
                  }

                  this.n[this.R].b(ao[this.C][this.R][this.P[this.R] << 2], ao[this.C][this.R][(this.P[this.R] << 2) + 1]);
               }

               if (this.P[this.R] > ao[this.C][this.R].length / 4 - 1) {
                  this.O[this.R] = this.P[this.R] = (byte)(ao[this.C][this.R].length / 4 - 1);
                  boolean var4 = true;
                  if (this.u) {
                     while (this.s < this.G.size() && (!((i)this.G.elementAt(this.s)).T() || ((i)this.G.elementAt(this.s)).s() != 0)) {
                        this.s++;
                     }

                     if (this.s >= this.G.size()) {
                        this.s = 0;
                        this.a((byte)1);
                     } else if (d((i)this.G.elementAt(this.s))) {
                        this.a((byte)13);
                     } else {
                        var4 = false;
                        this.a((byte)20);
                     }

                     this.u = false;
                  } else {
                     if (this.k == 0) {
                        this.s = (byte)this.G.size();
                     }

                     if (this.s >= this.G.size()) {
                        for (int var9 = 0; var9 < this.n.length; var9++) {
                           this.n[var9].K = false;
                        }

                        if (this.J) {
                           this.Q();
                           this.J = false;
                        }

                        if (this.b != 12 && this.b != 13) {
                           boolean var10 = false;
                           if (this.r.m(12) && this.r.L[12] == 2) {
                              this.r.L[12]--;
                              if (!((i)this.r.q).T()) {
                                 var10 = true;
                                 this.r.L[12]--;
                              } else {
                                 this.s--;
                                 this.a((byte)2);
                              }
                           } else {
                              int var15 = a.e.a(100);
                              if ((this.r.E == 63 || this.r.E == 69) && var15 <= a.b.c.c[1][this.r.E][8] && ((i)this.r.q).T()) {
                                 this.s--;
                                 this.a((byte)2);
                              } else {
                                 var10 = true;
                              }
                           }

                           if (var10) {
                              this.s = 0;

                              while (((i)this.G.elementAt(this.s)).s() != 0 || ((i)this.G.elementAt(this.s)).s() == 0 && !((i)this.G.elementAt(this.s)).T()) {
                                 this.s++;
                              }

                              if (d((i)this.G.elementAt(this.s))) {
                                 this.a((byte)13);
                              } else {
                                 var4 = false;
                                 this.a((byte)20);
                              }
                           }
                        } else {
                           this.s = 0;

                           while (((i)this.G.elementAt(this.s)).s() != 0 || ((i)this.G.elementAt(this.s)).s() == 0 && !((i)this.G.elementAt(this.s)).T()) {
                              this.s++;
                           }

                           if (d((i)this.G.elementAt(this.s))) {
                              this.a((byte)13);
                           } else {
                              var4 = false;
                              this.a((byte)20);
                           }
                        }
                     } else if (this.b != 13 && this.b != 12) {
                        boolean var2;
                        label738: {
                           var2 = false;
                           if (this.r.m(12) && this.r.L[12] == 2) {
                              this.r.L[12]--;
                              if (((i)this.r.q).T()) {
                                 this.s--;
                                 this.a((byte)2);
                                 break label738;
                              }

                              this.r.L[12]--;
                           } else {
                              int var3 = a.e.a(100);
                              if ((this.r.E == 63 || this.r.E == 69) && var3 <= a.b.c.c[1][this.r.E][8] && ((i)this.r.q).T()) {
                                 this.s--;
                                 this.a((byte)2);
                                 break label738;
                              }
                           }

                           var2 = true;
                        }

                        if (var2) {
                           this.a((byte)1);
                        }
                     } else {
                        this.a((byte)1);
                     }
                  }

                  if (var4) {
                     this.D();
                     if (this.n[this.q].s() == 0) {
                        this.d.a(this.n[this.q], false);
                        this.d.a(this.n[this.q]);
                     } else {
                        this.d.b(this.n[this.q], false);
                        this.d.b(this.n[this.q]);
                     }
                  }
               }
               break;
            case 16:
               this.d.ao();
               break;
            case 17:
               if (this.d.f == 0) {
                  if (this.B == 0 && this.ak.b()) {
                     this.e((byte)1);
                  } else if (this.B == 1 && this.ak.b()) {
                     if (!this.S.d()) {
                        this.e((byte)2);
                     }
                  } else if (this.B == 2 && this.ak.b()) {
                     if (this.al) {
                        this.e((byte)3);
                     } else {
                        this.e((byte)4);
                     }
                  } else if (this.B == 3 && this.ak.b()) {
                     byte var1;
                     if ((var1 = A.z()) == 0) {
                        this.d.f = 1;
                        this.d.b("Bắt thành công #2" + a.a.c(a.b.c.c[0][((i)this.r.q).r()][0]));
                        A.a(((i)this.r.q).Q());
                     } else if (var1 == 1) {
                        this.d.f = 2;
                        this.d.b("Bắt thành công #2" + a.a.c(a.b.c.c[0][((i)this.r.q).r()][0]));
                        A.b(((i)this.r.q).Q());
                     } else {
                        this.d.f = 1;
                        this.d.b("Không còn không gian, sủng vật này đã phóng sinh");
                     }
                  } else if (this.B == 4 && this.ak.b() && !this.S.d()) {
                     this.S = null;
                     this.n[0].c(true);
                     this.ak.d();
                     this.r.K = true;
                     if (this.al) {
                        this.d.b("Ngân hàng và Ba lô đều đã đầy");
                        this.d.f = 3;
                     } else {
                        this.s++;
                        this.a((byte)1);
                     }
                  }

                  this.ak.a();
               } else {
                  if (this.d.aA()) {
                     if (this.d.f == 3) {
                        this.d.f = 0;
                        this.r.K = true;
                        this.s++;
                        this.a((byte)1);
                     } else if (this.d.f == 2) {
                        this.d.b("Sủng vật ba lô đã đủ, đã để vào ngân hàng");
                        this.d.f = 4;
                     } else if (this.d.f == 4 || this.d.f == 1) {
                        this.d.f = 0;
                        game.l.B().Z.y = -1;
                        this.q();
                        game.f.B().a((byte)10);
                     }
                  }

                  this.d.f();
               }
               break;
            case 19:
               if (this.g(786432)) {
                  this.a((byte)18);
               }
               break;
            case 20:
               this.am[this.n.length].a();
               this.d.d(this.r);
               break;
            case 21:
               this.d.al();
               break;
            case 22:
               this.d.ar();
               break;
            case 23:
               this.d.at();
               break;
            case 24:
               this.d.aI();
               break;
            case 101:
            case 102:
            case 104:
               this.d.aO();
         }

         for (int var8 = 0; var8 < this.n.length; var8++) {
            this.n[var8].p();
         }

         this.c.c();
      }
   }

   private void b(Graphics var1) {
      var1.setColor(16777215);

      for (int var2 = 0; var2 < this.n.length; var2++) {
         this.n[var2].a(var1);
      }
   }

   private void a(Graphics var1, boolean var2, int var3, int var4) {
      for (int var5 = 0; var5 < this.n.length; var5++) {
         this.am[var5].a(var1, 0, 0);
      }

      if (var2) {
         this.am[this.n.length].a(var1, 0, 0);
         if (this.k == 1) {
            this.am[this.n.length + 1].a(var1, 0, 0);
         }
      }
   }

   private void a(String var1, byte var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      this.az = var1;
      this.at = var5;
      this.au = var6;
      this.ax = var3;
      this.ay = var4;
      this.av = var7;
      this.aw = var8;
      this.aD.addElement(this.az);
      this.aC.addElement(new int[]{var2, this.ax, this.ay, -1, this.av, this.aw});
   }

   private void c(Graphics var1) {
      for (int var4 = 0; var4 < this.aC.size(); var4++) {
         int[] var2 = (int[])this.aC.elementAt(var4);
         String var3 = (String)this.aD.elementAt(var4);
         switch (var2[0]) {
            case 0:
               if (var2[2] == 0) {
                  a(var1, aA[var2[1]], var3, this.at + aB[var2[0]][var2[3] << 1] + 30, this.au + aB[var2[0]][(var2[3] << 1) + 1] - 30, var2[4], var2[5], 1);
               } else {
                  a(var1, aA[var2[1]], var3, this.at - aB[var2[0]][var2[3] << 1] - 30, this.au + aB[var2[0]][(var2[3] << 1) + 1] - 30, var2[4], var2[5], 1);
               }
               break;
            case 1:
               if (var2[2] == 0) {
                  a.e.a(var1, var3, 16704699, this.at - 10, this.au + aB[var2[0]][(var2[3] << 1) + 1] - 30, 17, 17, this.c.b, 2);
               } else {
                  a.e.a(var1, var3, 16704699, this.at + 10, this.au + aB[var2[0]][(var2[3] << 1) + 1] - 30, 17, 17, this.c.b, 2);
               }
         }
      }
   }

   public final void a(Graphics var1) {
      if (this.j) {
         if (this.m != null) {
            var1.drawImage(this.m, 0, 0, 20);
         } else {
            var1.setColor(0);
            var1.fillRect(0, 0, a.a.g(), a.a.h());
         }

         switch (this.a) {
            case 0:
               this.a(var1, false, 0, 0);
               this.b(var1);
               break;
            case 1:
            case 10:
               this.a(var1, false, 0, 0);
               this.b(var1);
               break;
            case 2:
               this.a(var1, false, 0, 0);
               this.b(var1);
               break;
            case 3:
               var1.setColor(16777215);
               break;
            case 4:
               var1.setColor(16777215);
               break;
            case 5:
               var1.setColor(16777215);
               var1.drawString(c(a.b.c.c[0][this.n(this.p[0]).r()][0]), g() >> 1, 200, 17);
               break;
            case 6:
               if (this.k == 1) {
                  this.a(var1, true, 0, 0);
               } else {
                  this.a(var1, false, 0, 0);
               }

               this.b(var1);
               break;
            case 7:
               this.a(var1, false, 0, 0);
               if (this.S != null) {
                  this.S.a(var1, 0, 0);
               }

               this.b(var1);
               this.c(var1);
               break;
            case 8:
               this.am[0].a(var1, 0, 0);
               if (this.d.i < t.size()) {
                  ((i)t.elementAt(this.d.i)).a(var1);
               }
            case 9:
            case 11:
            case 14:
            case 16:
            case 18:
            case 19:
            case 21:
            default:
               break;
            case 12:
            case 13:
               this.a(var1, false, 0, 0);
               if (this.S != null) {
                  this.S.a(var1, 0, 0);
               }

               this.b(var1);
               this.c(var1);
               break;
            case 15:
               this.a(var1, false, 0, 0);
               this.b(var1);
               break;
            case 17:
               this.a(var1, false, 0, 0);
               this.b(var1);
               if (this.S != null && this.S.a((byte)8)) {
                  this.S.a(var1, 0, 0);
                  this.ak.a(var1, 0, 0);
               } else {
                  this.ak.a(var1, 0, 0);
               }
               break;
            case 20:
               this.a(var1, true, 0, 0);
               this.b(var1);
         }

         this.c.a(var1);
      }
   }

   public final void F() {
      this.s++;
      if (this.s < this.G.size()) {
         while (((i)this.G.elementAt(this.s)).s() != 0 || ((i)this.G.elementAt(this.s)).s() == 0 && !((i)this.G.elementAt(this.s)).T()) {
            this.s++;
            if (this.s >= this.G.size()) {
               break;
            }
         }
      }

      if (this.s >= this.G.size()) {
         this.a((byte)1);
      } else if (d((i)this.G.elementAt(this.s))) {
         this.a((byte)13);
      } else {
         this.a((byte)20);
      }
   }

   private void L() {
      if (this.s < this.G.size()) {
         this.a((byte)1);
      } else {
         if (this.J) {
            this.Q();
            this.J = false;
         }

         for (int var1 = 0; var1 < this.G.size(); var1++) {
            ((i)this.G.elementAt(var1)).K = false;
         }

         this.s = 0;

         while (((i)this.G.elementAt(this.s)).s() != 0 || ((i)this.G.elementAt(this.s)).s() == 0 && !((i)this.G.elementAt(this.s)).T()) {
            this.s++;
         }

         if (d((i)this.G.elementAt(this.s))) {
            this.a((byte)13);
         } else {
            this.a((byte)20);
         }
      }
   }

   private boolean M() {
      if (!this.V()) {
         return false;
      }

      this.T = 0;
      this.U = 0;
      int var2 = 0;

      while (var2 < this.p.length && !this.n(this.p[var2]).T()) {
         var2++;
      }

      if ((((i)this.r.q).s() != 1 || ((i)this.r.q).T()) && (this.r.s() != 1 || this.r.T())) {
         if (((i)this.r.q).s() == 0 && !((i)this.r.q).T() || this.r.s() == 0 && !this.r.T()) {
            ((i)this.r.q).D();
            ((i)this.r.q).E();
            this.d.a((i)this.r.q);
            I.removeElement((i)this.r.q);
            t.removeElement((i)this.r.q);
            ((i)this.r.q).C = 0;
            ((i)this.r.q).e(false);
            ((i)this.r.q).G = 0;
         }
      } else {
         ((i)this.r.q).D();
         ((i)this.r.q).E();
         this.d.b((i)this.r.q);
         this.h((i)this.r.q);
         this.F[1]++;
      }

      byte var1;
      if (var2 >= this.p.length) {
         var1 = 2;
      } else if (this.F[1] >= this.D.length) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      switch (var1) {
         case 0:
            boolean var4 = false;
            if (((i)this.r.q).T() && this.r.T()) {
               var4 = true;
            } else {
               for (int var3 = 0; var3 < this.n.length; var3++) {
                  if (this.n[var3].m(11) && this.n[this.n[var3].w[11][1]].equals((i)this.r.q)) {
                     this.n[var3].n(11);
                  }
               }

               if ((((i)this.r.q).s() != 1 || ((i)this.r.q).T()) && (this.r.s() != 1 || this.r.T())) {
                  if (!this.P()) {
                     var4 = true;
                  } else {
                     if (this.r.s() == 0 && !this.r.T()) {
                        this.q = this.o[this.s];
                     } else {
                        this.q = this.r.J;
                     }

                     this.a((byte)5);
                  }
               } else if (this.F[0] >= this.D.length) {
                  var4 = true;
               } else {
                  if (this.r.s() == 1 && !this.r.T()) {
                     this.q = this.o[this.s];
                  } else {
                     this.q = this.r.J;
                  }

                  this.q(this.q);
                  this.a((byte)15);
               }
            }

            if (var4) {
               if (this.r.m(12) && this.r.L[12] == 2) {
                  this.r.L[12]--;
                  if (!((i)this.r.q).T()) {
                     this.r.L[12]--;
                     this.s++;
                     this.L();
                  } else {
                     this.a((byte)2);
                  }
               } else {
                  int var6 = a.e.a(100);
                  if ((this.r.E == 63 || this.r.E == 69) && var6 <= a.b.c.c[1][this.r.E][8]) {
                     if (!((i)this.r.q).T()) {
                        this.r.L[12]--;
                        this.s++;
                        this.L();
                     } else {
                        this.a((byte)2);
                     }
                  } else {
                     this.s++;
                     this.L();
                  }
               }
            }
            break;
         case 1:
            W();
            this.a((byte)8);
            break;
         case 2:
            this.a((byte)9);
      }

      if (A.b((byte)5, (byte)0) == 2 && A.b((byte)5, (byte)1) == 1) {
         for (int var5 = 0; var5 < this.n.length; var5++) {
            if (this.n[var2].s() == 0 && this.n[var2].T()) {
               this.n[var2].z();
            }
         }
      }

      return true;
   }

   private void N() {
      if (game.l.B().Z.u) {
         this.a((byte)24);
      } else {
         for (int var1 = 0; var1 < A.B; var1++) {
            A.A[var1].l(1);
            A.A[var1].u(1);
            A.A[var1].c();
         }

         game.f.B().a((byte)10);
      }

      game.l.B().Z.y = 1;
      game.l.B().Z.u = true;
   }

   private static boolean d(i var0) {
      return var0.r(0) > 0 || var0.r(1) > 0;
   }

   private boolean O() {
      return this.r.s() != ((i)this.r.q).s() || this.r.p(8);
   }

   private static int e(i var0) {
      byte var1 = var0.A[0];
      int[] var2 = new int[]{50, 20, 15, 10, 5, 5, 5, 5, 5, 5};
      int var3 = a.e.a(100);

      for (int var4 = 0; var4 < var0.A.length; var4++) {
         if (var0.A[var4] != -1 && var0.z[var4] > 0 && var3 < var2[var4]) {
            var1 = var0.A[var4];
         }
      }

      return var1;
   }

   public final void d(byte var1) {
      this.r.H.removeAllElements();
      this.r.I.removeAllElements();
      switch (game.i.a(var1, (byte)9)) {
         case 0:
            for (int var3 = 0; var3 < this.n.length; var3++) {
               if (this.n[var3].s() != this.r.s() && this.n[var3].T()) {
                  this.r.H.addElement(this.n[var3]);
                  this.r.I.addElement("" + var3);
               }
            }
         default:
            return;
         case 1:
            for (int var2 = 0; var2 < this.n.length; var2++) {
               if (this.n[var2].s() == this.r.s() && this.n[var2].T()) {
                  this.r.H.addElement(this.n[var2]);
                  this.r.I.addElement("" + var2);
               }
            }
      }
   }

   private void f(i var1) {
      var1.H.removeAllElements();
      var1.I.removeAllElements();

      for (int var2 = 0; var2 < this.n.length; var2++) {
         if (this.n[var2].T() && !this.n[var2].equals(var1)) {
            var1.H.addElement(this.n[var2]);
            var1.I.addElement("" + var2);
         }
      }
   }

   public final void G() {
      i var10000 = this.r;
      i var2 = (i)this.r.H.elementAt(this.N);
      var10000.q = var2;
      this.r.J = Byte.parseByte((String)this.r.I.elementAt(this.N));
      this.r.h(((i)this.G.elementAt(this.s)).A[this.d.e]);
      this.a(Integer.parseInt((String)this.r.I.elementAt(this.N)), false);
      this.F();
   }

   private int g(i var1) {
      if (!var1.T()) {
         if (var1.s() == 0) {
            if (this.P()) {
               return 1;
            }
         } else if (this.F[0] < this.D.length) {
            return 2;
         }
      }

      return 0;
   }

   private boolean P() {
      int var1 = 0;

      for (int var2 = 0; var2 < A.B; var2++) {
         if (this.n(var2).T() && !this.n(var2).L()) {
            var1++;
         }
      }

      return var1 > 0;
   }

   private void f(int var1, int var2) {
      byte var3 = this.p[var2];
      this.p[var2] = this.p[var1];
      this.p[var1] = var3;
   }

   public final int l(int var1) {
      if (!this.n(this.p[var1]).T()) {
         return 0;
      }

      if (this.n(this.p[var1]).L()) {
         return 1;
      }

      byte var2 = this.p[var1];
      var1--;

      while (var1 >= 0) {
         this.p[var1 + 1] = this.p[var1];
         var1--;
      }

      this.p[0] = var2;
      var1 = 0;

      while (var1 < I.size() && !I.elementAt(var1).equals(this.n(this.p[0]))) {
         var1++;
      }

      if (var1 >= I.size()) {
         I.addElement(this.n(this.p[0]));
      }

      this.n(this.p[0]).K = true;
      this.n(this.p[0]).e(true);
      this.r.e(false);
      this.r.G = 0;

      for (int var5 = 0; var5 < this.n.length; var5++) {
         if (this.n[var5].m(11) && this.n[this.n[var5].w[11][1]].equals(this.r)) {
            this.n[var5].n(11);
         }
      }

      return -1;
   }

   private void Q() {
      this.G.removeAllElements();
      int var2 = -1;

      for (int var3 = 0; var3 < this.E.length - 1; var3++) {
         for (int var4 = var3 + 1; var4 < this.E.length; var4++) {
            i var10000 = this.n[var3];
            byte var6 = 4;
            short var18 = var10000.d[var6];
            i var10001 = this.n[var4];
            var6 = 4;
            if (var18 < var10001.d[var6]) {
               byte var1 = this.E[var3];
               this.E[var3] = this.E[var4];
               this.E[var4] = var1;
            }
         }
      }

      for (int var9 = 0; var9 < this.E.length; var9++) {
         if (this.n[var9].f((byte)7)) {
            var2 = var9;
            this.E[var9] = 0;
            break;
         }
      }

      if (var2 != -1) {
         int var10 = 1;
         int[] var13 = new int[this.E.length - 1];

         for (int var5 = 0; var5 < this.E.length; var5++) {
            if (var5 != var2) {
               var13[var10 - 1] = var5;
               this.E[var5] = (byte)var10;
               var10++;
            }
         }

         for (int var14 = 0; var14 < var13.length - 1; var14++) {
            for (int var8 = var14 + 1; var8 < var13.length; var8++) {
               i var19 = this.n[var13[var14]];
               byte var16 = 4;
               short var20 = var19.d[var16];
               i var21 = this.n[var13[var8]];
               var16 = 4;
               if (var20 < var21.d[var16]) {
                  byte var7 = this.E[var13[var14]];
                  this.E[var13[var14]] = this.E[var13[var8]];
                  this.E[var13[var8]] = var7;
               }
            }
         }
      }

      for (int var11 = 0; var11 < this.E.length; var11++) {
         this.o[this.E[var11]] = (byte)var11;
      }

      for (int var12 = 0; var12 < this.o.length; var12++) {
         this.G.addElement(this.n[this.o[var12]]);
      }
   }

   private void R() {
      if (this.r.f((byte)10)) {
         i var10000 = (i)this.r.q;
         byte var2 = 1;
         if (var10000.e[var2] <= a.b.c.c[3][10][5]) {
            var10000 = (i)this.r.q;
            short var3 = a.b.c.c[3][10][5];
            var2 = 1;
            var10000.e[var2] = var3;
         }
      }

      i var7 = (i)this.r.q;
      byte var5 = 1;
      if (var7.e[var5] <= 0) {
         ((i)this.r.q).a((byte)3, true);
      } else {
         ((i)this.r.q).a((byte)0, true);
      }
   }

   private boolean c(i var1, boolean var2) {
      if (this.l == 0 && var2) {
         if (var1.M != null && !var1.M.j()) {
            return true;
         }
      } else {
         var2 = var1.j;
         if (var1.s() == 0) {
            this.aE -= 10;
         } else {
            this.aE += 10;
         }

         var2 += this.aE;
         if (Math.abs(this.aE) >= 100) {
            var1.d();
            this.aE = 0;
            return true;
         }

         var1.b(var2, var1.k);
      }

      return false;
   }

   private boolean S() {
      int var1;
      for (var1 = 0; var1 < this.aC.size(); var1++) {
         int[] var2;
         (var2 = (int[])this.aC.elementAt(var1))[3]++;
         if (var2[3] >= aB[var2[0]].length / 2) {
            this.aC.removeElementAt(var1);
            this.aD.removeElementAt(var1);
            var1--;
         }
      }

      return var1 <= 0;
   }

   private boolean T() {
      if (this.aa != null) {
         return this.aa[2] != -1 ? false : this.Z[this.Z.length - 1] == this.T;
      } else {
         return !this.ab;
      }
   }

   private boolean U() {
      if (a.b.c.c[1][this.r.E][3] == 0) {
         this.d.k = 0;
         if (((i)this.r.q).s() == 0) {
            this.d.a((i)this.r.q);
         } else {
            this.d.b((i)this.r.q);
         }

         ((i)this.r.q).a((byte)0, true);
         return true;
      } else {
         if (((i)this.r.q).q() == 3) {
            return true;
         }

         if (!this.aF) {
            int var1 = this.r.t();
            if (this.r.s() == 0 && A.b((byte)4, (byte)0) == 2 && A.b((byte)4, (byte)1) == 1) {
               var1 += a.b.c.c[2][4][6];
            }

            if (this.r.m(4)) {
               var1 = ((i)this.r.q).t() - (var1 - this.r.x[4][1]) << 1;
            } else {
               var1 = ((i)this.r.q).t() - var1 << 1;
            }

            if (this.r.f((byte)9)) {
               var1 = 0;
            }

            if (var1 <= 0) {
               var1 = 0;
            } else if (var1 >= 20) {
               var1 = 20;
            }

            if (a.e.a(100) >= var1) {
               ((i)this.r.q).k(this.aa[0]);
               if (this.r.f((byte)10)) {
                  i var10000 = (i)this.r.q;
                  byte var2 = 1;
                  if (var10000.e[var2] <= a.b.c.c[3][10][5]) {
                     var10000 = (i)this.r.q;
                     short var3 = a.b.c.c[3][10][5];
                     var2 = 1;
                     var10000.e[var2] = var3;
                  }
               }

               if (this.aa[1] == 1) {
                  i var5;
                  i var6;
                  this.a("-" + this.aa[0], (byte)0, 1, ((i)this.r.q).s(), (var5 = (i)this.r.q).j, (var6 = (i)this.r.q).k, 15, 19);
               } else {
                  i var7;
                  i var8;
                  this.a("-" + this.aa[0], (byte)0, 0, ((i)this.r.q).s(), (var7 = (i)this.r.q).j, (var8 = (i)this.r.q).k, 9, 12);
               }

               if (this.aa[2] != -1) {
                  i var9;
                  i var10;
                  this.a(a.a.c(a.b.c.c[7][this.aa[2]][0]), (byte)1, 0, ((i)this.r.q).s(), (var9 = (i)this.r.q).j, (var10 = (i)this.r.q).k, 9, 12);
               }
            } else {
               i var11;
               i var12;
               this.a("Né tránh", (byte)1, 0, ((i)this.r.q).s(), (var11 = (i)this.r.q).j, (var12 = (i)this.r.q).k, 9, 12);
            }

            this.aF = true;
            this.d.k = 0;
            if (((i)this.r.q).s() == 0) {
               this.d.a((i)this.r.q);
            } else {
               this.d.b((i)this.r.q);
            }
         }

         boolean var13 = this.S();
         if (((i)this.r.q).s() == 0) {
            if (this.d.a((i)this.r.q, false) && var13) {
               this.R();
               this.aF = false;
               return true;
            }
         } else if (this.d.b((i)this.r.q, false) && var13) {
            this.R();
            this.aF = false;
            return true;
         }

         return false;
      }
   }

   private boolean a(i var1, boolean var2, int var3) {
      if (var1.s() == 0) {
         byte var4 = 1;
         if (var3 < var1.e[var4]) {
            if (this.d.a(var1, true) && var2) {
               this.aF = false;
               return true;
            }
         } else if (this.d.a(var1, false) && var2) {
            this.aF = false;
            return true;
         }
      } else {
         byte var5 = 1;
         if (var3 < var1.e[var5]) {
            if (this.d.b(var1, true) && var2) {
               this.aF = false;
               return true;
            }
         } else if (this.d.b(var1, false) && var2) {
            this.aF = false;
            return true;
         }
      }

      return false;
   }

   private boolean V() {
      if (!this.aF) {
         int var1 = 0;
         if (a.b.c.c[1][this.r.E][9] == 0) {
            this.aG = this.r.O();
         } else {
            this.aG = ((i)this.r.q).O();
         }

         byte var2 = this.r.E;
         switch (this.r.E) {
            case 11:
            case 17:
               var1 = (short)(this.r.C() * a.b.c.c[1][var2][8] / 100);
               byte var24 = 1;
               i var7 = this.r;
               this.r.u(this.r.e[var24]);
               if (var1 <= 0) {
                  var1 = 1;
               }

               this.r.l(var1);
               break;
            case 21:
            case 27:
            case 42:
            case 48:
            case 62:
            case 68:
               this.r.a((byte)a.b.c.c[1][var2][7], -1, var2);
               break;
            case 52:
            case 58:
               if (this.ab) {
                  var1 = this.aa[0] * a.b.c.c[1][var2][8] / 100;
                  byte var5 = 1;
                  i var4 = this.r;
                  this.r.u(this.r.e[var5]);
                  this.r.l(this.aa[0] * a.b.c.c[1][var2][8] / 100);
               }
            case 64:
               this.r.a((byte)a.b.c.c[1][var2][7], this.r.J, var2);
               break;
            default:
               if (a.b.c.c[1][var2][6] == 1) {
                  var1 = ((i)this.r.q).a((byte)a.b.c.c[1][var2][7], -1, var2);
               }
         }

         byte var3 = (byte)a.b.c.c[1][var2][6];
         if (a.b.c.c[1][this.r.E][9] == 0) {
            if (this.r.f((byte)8) && a.e.a(100) <= a.b.c.c[3][8][5]) {
               byte var25 = 1;
               i var8 = this.r;
               this.r.u(this.r.e[var25]);
               this.r.l((short)(this.aa[0] * a.b.c.c[3][8][6] / 100));
            }

            if (((i)this.r.q).m(2)) {
               int var9 = this.aa[0] * ((i)this.r.q).w[2][2] / 100;
               this.r.k(var9);
            }

            short var10;
            if (((i)this.r.q).m(5) && (var10 = this.r.L[5]) > 0) {
               this.r.k(var10);
               this.r.L[5] = 0;
            }

            byte var26 = 1;
            i var11 = this.r;
            if (this.r.e[var26] < this.aG) {
               StringBuffer var10001 = new StringBuffer();
               var26 = 1;
               i var12 = this.r;
               String var28 = var10001.append(this.r.e[var26] - this.aG).toString();
               int var10004 = this.r.s();
               i var13 = this.r;
               i var14 = this.r;
               this.a(var28, (byte)0, 0, var10004, this.r.j, this.r.k, 9, 12);
            } else if (var1 > 0) {
               String var29 = "+" + var1;
               int var31 = this.r.s();
               i var15 = this.r;
               i var16 = this.r;
               this.a(var29, (byte)0, 2, var31, this.r.j, this.r.k, 9, 12);
            }
         } else if (var1 > 0) {
            i var17;
            i var18;
            this.a("+" + var1, (byte)0, 2, ((i)this.r.q).s(), (var17 = (i)this.r.q).j, (var18 = (i)this.r.q).k, 9, 12);
         }

         if (var3 == 1) {
            short var19 = a.b.c.c[1][var2][7];
            switch (var2) {
               case 21:
               case 27:
               case 42:
               case 48:
               case 62:
               case 64:
               case 68:
                  String var30 = a.a.c(a.b.c.c[6][var19][0]);
                  int var32 = this.r.s();
                  i var22 = this.r;
                  i var23 = this.r;
                  this.a(var30, (byte)1, 2, var32, this.r.j, this.r.k, 9, 12);
                  break;
               default:
                  i var20;
                  i var21;
                  this.a(a.a.c(a.b.c.c[6][var19][0]), (byte)1, 2, ((i)this.r.q).s(), (var20 = (i)this.r.q).j, (var21 = (i)this.r.q).k, 9, 12);
            }
         }

         if (a.b.c.c[1][this.r.E][9] == 0) {
            this.d.k = 0;
            if (this.r.s() == 0) {
               this.d.a(this.r);
            } else {
               this.d.b(this.r);
            }
         } else {
            this.d.k = 0;
            if (((i)this.r.q).s() == 0) {
               this.d.a((i)this.r.q);
            } else {
               this.d.b((i)this.r.q);
            }
         }

         this.aF = true;
      }

      boolean var6 = this.S();
      return ((i)this.r.q).s() == this.r.s() && !this.r.p(9) ? this.a((i)this.r.q, var6, this.aG) : this.a(this.r, var6, this.aG);
   }

   private static void W() {
      for (int var0 = 0; var0 < t.size(); var0++) {
         if (((i)t.elementAt(var0)).T()) {
            ((i)t.elementAt(var0)).g(((i)t.elementAt(var0)).C);
            ((i)t.elementAt(var0)).C = 0;
            ((i)t.elementAt(var0)).e(false);
         } else {
            t.removeElementAt(var0);
            var0--;
         }
      }

      if (A.b((byte)0, (byte)0) == 2 && A.b((byte)0, (byte)1) == 1) {
         for (int var3 = 0; var3 < A.B; var3++) {
            if (A.A[var3].T()) {
               i var10000 = A.A[var3];
               i var10001 = A.A[var3];
               byte var2 = 1;
               var10000.u(var10001.e[var2] + a.b.c.c[0][A.A[var3].r()][5] * a.b.c.c[2][0][6] / 100);
               A.A[var3].l(a.b.c.c[0][A.A[var3].r()][5] * a.b.c.c[2][0][6] / 100);
            }
         }
      }
   }

   private void h(i var1) {
      int var2;
      int var10000 = ((var2 = var1.t()) << 1) * var2 + 50;
      int var3 = 0;
      int var9 = var10000 * this.aH[var1.d[var3] - 1] / 10 + 400;
      int[] var4 = new int[var3 = I.size()];
      i var5 = null;
      byte var6 = 0;

      for (int var8 = 0; var8 < var3; var8++) {
         if ((var5 = (i)I.elementAt(var8)).t() - var2 >= 6) {
            var6 = this.aJ[6];
         } else if (var5.t() - var2 > 0) {
            var6 = this.aJ[var5.t() - var2];
         } else if (var5.t() == var2) {
            var6 = this.aJ[1];
         } else if (var5.t() < var2) {
            var6 = this.aJ[0];
         }

         int var7 = var9 / var3 * this.aI[var3 - 1] * var6 / 1000;
         if (var5.f((byte)5)) {
            var7 = var7 * (a.b.c.c[3][5][5] + 100) / 100;
         }

         var5.C += var7;
         var4[var8] = var7;
         if (!t.contains(var5)) {
            t.addElement(var5);
         }
      }

      for (int var14 = 0; var14 < A.B; var14++) {
         if (this.n(var14).T() && !I.contains(this.n(var14))) {
            if (A.b((byte)7, (byte)0) == 2) {
               if (var5.t() - var2 >= 6) {
                  var6 = this.aJ[6];
               } else if (var5.t() - var2 > 0) {
                  var6 = this.aJ[var5.t() - var2];
               } else if (var5.t() == var2) {
                  var6 = this.aJ[1];
               } else if (var5.t() < var2) {
                  var6 = this.aJ[0];
               }

               int var12 = var9 / var3 * this.aI[var3 - 1] * var6 / 3000;
               this.n(var14).C += var12;
               this.n(var14).c();
               if (!t.contains(this.n(var14))) {
                  t.addElement(this.n(var14));
               }
            } else if (this.n(var14).f((byte)6)) {
               if (var5.t() - var2 >= 6) {
                  var6 = this.aJ[6];
               } else if (var5.t() - var2 > 0) {
                  var6 = this.aJ[var5.t() - var2];
               } else if (var5.t() == var2) {
                  var6 = this.aJ[1];
               } else if (var5.t() < var2) {
                  var6 = this.aJ[0];
               }

               int var13 = var9 / var3 * this.aI[var3 - 1] * var6 / 1000;
               this.n(var14).C += var13;
               this.n(var14).c();
               if (!t.contains(this.n(var14))) {
                  t.addElement(this.n(var14));
               }
            }
         }
      }

      for (int var10 = 0; var10 < I.size(); var10++) {
         i var15;
         if (!(var15 = (i)I.elementAt(var10)).L()) {
            I.removeElement(var15);
         }
      }

      if (A.l(0)) {
         if (A.J == 0) {
            if (var5.t() >= 30 && ++game.l.A >= 10) {
               game.l.A = 10;
               return;
            }
         } else if (var5.t() >= 40 && ++game.l.A >= 30) {
            game.l.A = 30;
         }
      }
   }

   public final int m(int var1) {
      if (var1 == 0) {
         return 100;
      }

      byte var2 = 0;
      if (((i)this.r.q).m(1)) {
         var2 = 1;
      }

      if (((i)this.r.q).m(2)) {
         var2 = 2;
      }

      if (((i)this.r.q).m(10)) {
         var2 = 3;
      }

      if (this.r.f((byte)11)) {
         var2 = 4;
      }

      int var3 = 1;
      i var10000 = (i)this.r.q;
      byte var6 = 1;
      short var4 = var10000.e[var6];
      var10000 = (i)this.r.q;
      var6 = 1;
      short var5 = var10000.d[var6];
      if (var4 <= var5 * 15 / 100) {
         var3 = 85;
      } else if (var4 <= var5 * 50 / 100) {
         var3 = 45;
      } else if (var4 <= var5) {
         var3 = 20;
      }

      var3 = var3 * a.b.c.c[4][var1][6] / 100;
      int[] var13 = new int[]{110, 100, 95, 80, 70};
      i var10002 = (i)this.r.q;
      var6 = 0;
      var3 = var3 * var13[var10002.d[var6] - 1] / 100;
      int[] var14 = new int[]{10, 11, 12, 12, 12};
      var3 = var3 * var14[var2] / 10;
      if (this.r.f((byte)11)) {
         var3 = var3 * (100 + a.b.c.c[3][11][5]) / 100;
      }

      int[] var7 = new int[]{1000, 500, 1, 1000};
      var3 = var3 * var7[a.b.c.c[0][((i)this.r.q).r()][22]] / 1000;
      if (((i)this.r.q).t() >= 20) {
         byte[] var8 = new byte[]{0, 15, 35, 65};
         if (var3 >= var8[var1]) {
            var3 = var8[var1];
         }
      }

      if (var3 >= 100) {
         var3 = 100;
      } else if (var3 <= 0) {
         var3 = 1;
      }

      return var3;
   }

   public final i n(int var1) {
      return var1 > this.p.length - 1 ? null : A.A[var1];
   }

   public final i o(int var1) {
      return var1 > this.p.length - 1 ? null : A.A[this.p[var1]];
   }

   public final void a(int[][] var1) {
      this.D = var1;
   }

   public final int H() {
      return this.D.length;
   }

   public final int p(int var1) {
      return this.D[0][0];
   }

   public final void q() {
      switch (f) {
         case 0:
            if (g == 0) {
               if (this.r != null) {
                  i var9 = this.n[0];
                  byte var6 = 1;
                  int var4 = var9.d[var6] * 50 / 100;
                  var9 = this.n[0];
                  var6 = 1;
                  if (var9.e[var6] <= var4) {
                     b(0, 1);
                     g++;
                     this.d.c("Di Lặc thỏ thỏ đã bị thương, nhanh sử dụng #2 phong ấn cầu #1 tiến hành bắt được a");
                  }

                  return;
               }
            } else if (g == 1) {
               if (this.d.aB()) {
                  g++;
                  this.d.a = 1;
                  b(2, 1);
                  b(1, 1);
                  this.d.aj();
                  this.d.c("Hãy nhấn #2nút 5");
                  return;
               }
            } else {
               if (g == 3) {
                  g++;
                  b(2, 0);
                  b(1, 1);
                  this.d.c("Hãy lựa chọn phong ấn cầu");
                  return;
               }

               if (g == 5) {
                  g++;
                  this.d.c("Đáng tiếc đã bắt trượt, thử dùng loại xịn #2Tất trúng cầu#1 xem sao!");
                  return;
               }

               if (g == 6) {
                  if (this.d.aB()) {
                     b(1, 0);
                     this.d.a = 1;
                     this.d.aj();
                     this.d.b = 0;
                     g++;
                     this.a((byte)21);
                     return;
                  }
               } else if (g == 8) {
                  b(1, -1);
                  b(0, 0);
                  f = -1;
                  g = 0;
                  return;
               }
            }
            break;
         case 2:
            if (g == 0) {
               b(0, 0);
               g++;
               this.d.c("Tranh thủ thời gian lựa chọn #2Tất trúng cầu#1 để bắt sủng vật");
               return;
            }

            if (g == 2) {
               if (this.r != null) {
                  i var10000 = this.n[0];
                  byte var3 = 1;
                  int var1 = var10000.d[var3] * 50 / 100 + 2;
                  var10000 = this.n[0];
                  var3 = 1;
                  if (var10000.e[var3] <= var1) {
                     g--;
                     this.d.c("Lựa chọn #2Tất trúng cầu#1 để bắt sủng vật");
                  }
               }

               if (A.a((byte)1, 29) == 2) {
                  f = -1;
                  g = 0;
                  return;
               }
            }
            break;
         case 5:
            if (g == 0) {
               this.d.a = 1;
               g++;
               this.d.aj();
               this.d.c("Tranh thủ thời gian lựa chọn #2Tất trúng cầu#1 để bắt sủng vật");
            }
      }
   }

   public final void r() {
      switch (f) {
         case 0:
            if (g == 2 || g == 4 || g == 7) {
               g++;
               return;
            }
            break;
         case 5:
            if (g == 1) {
               g++;
               b(1, 0);
               b(0, 1);
               return;
            }

            if (g == 2) {
               b(0, 0);
               f = -1;
               g = 0;
            }
      }
   }
}
