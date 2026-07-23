package game;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class l extends a.a {
   private static l ac;
   public a.b.d k;
   private a.b.b ad;
   public a.a.h l;
   public j m;
   public h[] n;
   public Vector o;
   private int ae;
   public int p;
   public int q;
   private int af;
   public short r;
   public short s;
   public int t;
   public String u;
   public static int[] v = new int[]{0, 2, 9, 17, 25, 38, 45, 47, 60, 67, 75, 90};
   public static Image w = null;
   private static Image ag = null;
   public static a.a.b x = null;
   private static a.b.e[] ah = new a.b.e[10];
   private static byte[][][] ai = null;
   private static short[][][] aj = null;
   private static boolean[][] ak = null;
   private static String[] al;
   private static short[][] am;
   private static Vector an = new Vector();
   private static Vector ao = new Vector();
   private static Vector ap = new Vector();
   private static Vector aq = new Vector();
   public a.a.g y;
   private a.a.g ar;
   public a.a.g z;
   public static int A = 0;
   public static byte B = 0;
   public static byte C;
   public static byte D;
   public static short E = -1;
   public static short F = -1;
   public static byte G = 0;
   public static boolean H = false;
   public static int I = -1;
   public static int J = 0;
   public static int K = 0;
   public static int L = g();
   public static int M = h();
   private static byte[] as = new byte[]{9, 10, 11};
   private int[] at;
   private int[] au;
   private short[] av;
   private static String[] aw = new String[]{
      "PK6_RMS_ACTOR",
      "PK6_RMS_WORLD",
      "PK6_RMS_EVENT",
      "PK6_RMS_RMS",
      "PK6_RMS_SMS",
      "PK6_RMS_CNTSMS",
      "PK6_RMS_GOLD",
      "PK6_RMS_POKPET",
      "PK6_RMS_CONITEM",
      "PK6_RMS_PETBALL"
   };
   public static boolean N = false;
   public static Vector O = null;
   public static Vector P;
   public static byte Q;
   public static Vector R = null;
   public static byte S = 0;
   public static boolean T = false;
   protected static boolean U = false;
   public static byte[] V = new byte[2];
   private Image[] ax;
   public a.a.e W;
   private static byte[][] ay = null;
   public static byte X = -1;
   public static boolean Y;
   private static byte[] az = null;
   private static byte aA = -1;
   public e Z;
   public static String[] aa;
   private int aB;
   private String aC;
   private byte aD;
   private byte aE;
   private byte aF;
   private byte aG;
   private int aH;
   private int aI;
   private int aJ;
   private int aK;
   private boolean aL;
   private a.a.g aM;
   private a.a.g[] aN;
   private int aO;
   private int[] aP;
   private int[] aQ;
   private int[] aR;
   private int[][] aS;
   private int[] aT;
   public static byte ab = -1;
   private boolean aU;
   private boolean[] aV;
   private byte[] aW;
   private byte aX;
   private byte aY;
   private boolean aZ;

   public static l B() {
      if (ac == null) {
         ac = new l();
      }

      return ac;
   }

   public l() {
      game.d.a();
      this.o = new Vector();
      this.p = 0;
      this.q = 0;
      this.af = 0;
      this.r = 224;
      this.s = 496;
      this.t = -1;
      this.u = "Gỗ thô";
      this.y = null;
      this.ar = null;
      this.z = null;
      this.at = new int[]{21, 35, 50, 0, 45};
      this.au = new int[]{9, 0, 20, 3, 9, 1, 17, 1, 9, 2, 9, 4, 9, 6, 86, 5, 9, 6, 58, 6, 9, 5, 21, 2, 9, 4, 3, 0};
      this.av = new short[]{1, 5, 0, 616, 3, 6, 0, 617, 4, 0, 0, 618, 5, 2, 0, 619, 6, 0, 1, 620};
      this.W = null;
      this.aB = 0;
      this.aC = "Ngoại trừ tiến hóa, sủng vật còn có thể dị hoá, dị hoá sau sủng vật đem càng cụ tính công kích. Mặt khác từng chủ thành liên minh huấn luyện sư cũng sẽ cung cấp tiến hóa cùng dị hoá phục vụ, ngươi có thể thường đi xem.";
      this.aL = false;
      this.aM = null;
      this.aN = null;
      this.aO = 8;
      this.aP = new int[]{2, 1, 73, 158, 3, 3, 216, 165, 4, 5, 161, 338, 5, 3, 111, 385, 5, 5, 112, 124, 6, 1, 140, 100, 7, 2, 48, 58};
      this.aQ = new int[]{1, 5, 265, 113, 3, 6, 281, 192, 4, 0, 24, 144, 5, 2, 88, 175, 6, 0, 55, 190};
      this.aR = new int[]{
         16735795, 5708544, 5693667, 28273, 7796622, 1924393, 16774529, 7760896, 3291479, 10268671, 2038828, 13341951, 4443391, 16777215, 1862959, 13886935
      };
      this.aS = new int[][]{
         {
               0,
               0,
               1,
               0,
               386,
               5,
               5,
               5,
               0,
               1,
               1,
               387,
               5,
               5,
               0,
               5,
               1,
               2,
               388,
               5,
               5,
               0,
               10,
               1,
               3,
               389,
               5,
               5,
               5,
               10,
               1,
               4,
               390,
               5,
               5,
               10,
               10,
               1,
               5,
               391,
               5,
               5,
               10,
               15,
               1,
               6,
               392,
               5,
               5,
               10,
               20,
               -1,
               -1,
               518,
               5,
               5
         },
         {
               0,
               0,
               -1,
               -1,
               517,
               5,
               5,
               0,
               5,
               2,
               0,
               393,
               5,
               5,
               0,
               10,
               2,
               1,
               394,
               5,
               5,
               0,
               15,
               2,
               2,
               395,
               5,
               5,
               5,
               10,
               2,
               3,
               396,
               5,
               5,
               5,
               5,
               2,
               4,
               397,
               5,
               5,
               5,
               15,
               2,
               5,
               398,
               5,
               5,
               5,
               20,
               2,
               6,
               399,
               5,
               5,
               5,
               25,
               2,
               7,
               400,
               5,
               5
         },
         {
               15,
               0,
               -1,
               -1,
               518,
               5,
               5,
               15,
               5,
               3,
               0,
               401,
               5,
               5,
               15,
               10,
               3,
               1,
               402,
               5,
               5,
               10,
               10,
               3,
               2,
               403,
               5,
               5,
               10,
               15,
               3,
               3,
               404,
               5,
               5,
               5,
               15,
               3,
               4,
               405,
               5,
               5,
               0,
               15,
               3,
               5,
               406,
               5,
               5,
               15,
               15,
               3,
               6,
               407,
               5,
               5,
               15,
               20,
               3,
               7,
               408,
               5,
               5
         },
         {
               0,
               15,
               4,
               0,
               409,
               5,
               5,
               5,
               15,
               4,
               1,
               410,
               5,
               5,
               10,
               15,
               4,
               5,
               414,
               5,
               5,
               10,
               20,
               4,
               6,
               415,
               5,
               5,
               15,
               20,
               4,
               7,
               416,
               5,
               5,
               20,
               20,
               4,
               8,
               417,
               5,
               5,
               15,
               15,
               4,
               9,
               418,
               5,
               5,
               20,
               15,
               4,
               10,
               419,
               5,
               5,
               15,
               10,
               4,
               11,
               420,
               5,
               5,
               15,
               5,
               4,
               12,
               421,
               5,
               5,
               0,
               10,
               4,
               2,
               411,
               5,
               5,
               5,
               10,
               4,
               3,
               412,
               5,
               5,
               10,
               10,
               4,
               4,
               413,
               5,
               5,
               15,
               0,
               -1,
               -1,
               524,
               5,
               5
         },
         {
               10,
               5,
               5,
               0,
               422,
               5,
               5,
               5,
               5,
               5,
               1,
               423,
               5,
               5,
               0,
               5,
               5,
               2,
               424,
               5,
               5,
               5,
               0,
               5,
               3,
               425,
               5,
               5,
               15,
               5,
               5,
               4,
               426,
               5,
               5,
               20,
               5,
               5,
               5,
               427,
               5,
               5,
               18,
               0,
               5,
               6,
               428,
               5,
               5,
               10,
               10,
               -1,
               -1,
               522,
               5,
               5
         },
         {0, 5, 6, 0, 429, 5, 5, 0, 0, 6, 1, 430, 5, 5},
         {
               5,
               15,
               7,
               0,
               431,
               5,
               5,
               5,
               10,
               7,
               1,
               432,
               5,
               5,
               5,
               5,
               7,
               2,
               433,
               5,
               5,
               0,
               5,
               7,
               3,
               434,
               5,
               5,
               0,
               0,
               7,
               4,
               435,
               5,
               5,
               0,
               10,
               7,
               5,
               436,
               5,
               5,
               0,
               15,
               7,
               6,
               437,
               5,
               5,
               10,
               5,
               7,
               7,
               438,
               5,
               5,
               10,
               0,
               7,
               8,
               439,
               5,
               5,
               15,
               0,
               7,
               9,
               440,
               5,
               5,
               15,
               5,
               7,
               10,
               441,
               5,
               5,
               10,
               10,
               7,
               11,
               442,
               5,
               5,
               10,
               15,
               7,
               12,
               443,
               5,
               5
         },
         {
               5,
               10,
               8,
               0,
               444,
               5,
               5,
               5,
               15,
               8,
               1,
               445,
               5,
               5,
               0,
               15,
               8,
               2,
               446,
               5,
               5,
               0,
               10,
               8,
               3,
               447,
               5,
               5,
               0,
               5,
               8,
               4,
               448,
               5,
               5,
               5,
               5,
               8,
               5,
               449,
               5,
               5,
               5,
               0,
               8,
               6,
               450,
               5,
               5
         }
      };
      this.aT = new int[]{3, 5, 2, 6, 4, 5, 5, 5, 5, 3, 1, 2, 4, 4, 2, 4};
      this.aU = false;
      this.aV = new boolean[]{false, false, false, false, false, false, false};
      this.aW = new byte[]{10, 15, 20, 30, 40, 50, 100};
      this.aZ = false;
      this.k = a.b.d.a();
      this.ad = a.b.b.a();
      this.l = new a.a.h();
   }

   public final boolean C() {
      return am[v[this.p] + this.q][2] != -1;
   }

   public static byte a(byte var0, byte var1) {
      if (aA != -1) {
         for (int var2 = 0; var2 < aA; var2++) {
            if (az[var2 * 3] == var0) {
               switch (var1) {
                  case 0:
                     return az[var2 * 3 + 1];
                  case 1:
                     return az[var2 * 3 + 2];
               }
            }
         }
      }

      return -1;
   }

   public final boolean b() {
      try {
         this.d();
         if (ah == null) {
            ah = new a.b.e[10];
         }

         for (int var2 = 0; var2 < ah.length; var2++) {
            if (ah[var2] == null) {
               ah[var2] = new a.b.e(aw[var2], 1);
            }
         }

         this.Z = game.e.B();
         this.Z.a(this);
         this.m = game.j.p();
         V[0] = V[1] = -1;
         if (game.e.k != 0) {
            a.b.c.b();
         }

         if (ai == null) {
            ai = new byte[127][][];
            aj = new short[127][][];
            ak = new boolean[127][2];
         }

         if (!this.m.z) {
            if (h) {
               this.R();
               this.T();
            }

            V();
         }

         this.a(this.p, this.q, "/data/event/");
         a.a.f.b();
         l var1 = this;
         am = a.e.a(a.e.a("/data/script/petArea.mid"));
         if (var1.C()) {
            int[] var14 = new int[am[v[var1.p] + var1.q].length - 5];

            for (int var3 = 0; var3 < var14.length; var3++) {
               var14[var3] = am[v[var1.p] + var1.q][var3 + 5];
            }

            for (int var21 = 0; var21 < var14.length / 4; var21++) {
               int[] var6 = new int[4];
               switch (var14[(var21 << 2) + 1]) {
                  case 0:
                     System.arraycopy(var14, var21 << 2, var6, 0, var6.length);
                     an.addElement(var6);
                     break;
                  case 1:
                     System.arraycopy(var14, var21 << 2, var6, 0, var6.length);
                     ao.addElement(var6);
                     break;
                  case 2:
                     System.arraycopy(var14, var21 << 2, var6, 0, var6.length);
                     ap.addElement(var6);
                  case 3:
                  default:
                     break;
                  case 4:
                     System.arraycopy(var14, var21 << 2, var6, 0, var6.length);
                     aq.addElement(var6);
               }
            }
         }

         var1 = this;
         byte[][] var10000 = ay = a.e.b(a.e.a("/data/script/media.mid"));
         int var4 = var1.q;
         int var22 = var1.p;
         byte var15;
         if ((var15 = var10000[v[var22] + var4][0]) == -1) {
            Y = false;
         } else {
            var4 = var1.q;
            var22 = var1.p;
            if (var1.Z.n[v[var22] + var4][var15] == 3) {
               Y = false;
            } else {
               Y = true;
            }
         }

         var4 = var1.q;
         var22 = var1.p;
         X = ay[v[var22] + var4][1];
         var4 = var1.q;
         var22 = var1.p;
         int var32 = v[var22] + var4;
         byte[] var16;
         if ((aA = ay[e(var1.p, var1.q)][3]) == -1) {
            if (!var1.C()) {
               (var16 = new byte[1])[0] = X;
            } else {
               (var16 = new byte[2])[0] = X;
               var16[1] = X;
            }
         } else {
            if (!var1.C()) {
               var16 = new byte[(aA << 1) + 1];

               for (int var26 = 0; var26 < aA; var26++) {
                  var16[var26 << 1] = ay[e(var1.p, var1.q)][4 + var26 * 3 + 1];
                  var16[(var26 << 1) + 1] = ay[e(var1.p, var1.q)][4 + var26 * 3 + 2];
               }

               var16[aA << 1] = X;
            } else {
               var16 = new byte[(aA << 1) + 2];

               for (int var27 = 0; var27 < aA; var27++) {
                  var16[var27 << 1] = ay[e(var1.p, var1.q)][4 + var27 * 3 + 1];
                  var16[(var27 << 1) + 1] = ay[e(var1.p, var1.q)][4 + var27 * 3 + 2];
               }

               var16[aA << 1] = X;
               var16[(aA << 1) + 1] = 4;
            }

            az = new byte[aA * 3];
            System.arraycopy(ay[e(var1.p, var1.q)], 4, az, 0, aA * 3);
         }

         if (var1.W == null) {
            var1.W = new a.a.e(7, -1, (byte)0, "/data/sound/");
         }

         var1.W.a(var16);
         var1.W.b(game.f.B().r);
         var1 = this;
         InputStream var17 = a.e.a("/data/script/petRide.mid");
         var1.m.R = a.e.b(var17)[v[var1.p] + var1.q];
         if (var1.m.u >= 0 && !var1.m.g(var1.m.u)) {
            var1.m.t();
         }

         var1.aD = var1.m.R[4];
         var1.aE = -1;

         for (byte var18 = 0; var18 < var1.aP.length / 4; var18++) {
            if (var1.p == var1.aP[var18 << 2] && var1.q == var1.aP[(var18 << 2) + 1]) {
               var1.aE = var18;
               break;
            }
         }

         var1.aF = -1;

         for (byte var19 = 0; var19 < var1.aQ.length / 4; var19++) {
            if (var1.p == var1.aQ[var19 << 2] && var1.q == var1.aQ[(var19 << 2) + 1]) {
               var1.aF = var19;
               break;
            }
         }

         var1 = this;
         w = null;
         short[][] var20 = a.e.a(a.e.a("/data/script/backPic.mid"));

         for (int var28 = 0; var28 < var20.length; var28++) {
            if (var20[var28][0] == var1.p && var20[var28][1] == var1.q) {
               if (var20[var28][2] == 0) {
                  w = a.e.b("/data/img/", "img_" + var20[var28][3]);
               } else if (var20[var28][2] == 1) {
                  a.a.b(var20[var28][3] << 16 | var20[var28][4] << 8 | var20[var28][5]);
               }
               break;
            }

            a.a.b(2996676);
         }

         ag = a.e.b("/data/tex/", "gold");
         a.e.b("/data/img/", "img_10023");
         if (this.m.x > 0) {
            this.e(true);
         }

         var1 = this;
         this.u = c(384 + v[var1.p] + var1.q);
         var1.k.a(var1.ae);
         var1.k.a(0, 0);
         var1.l.a(var1.k);
         this.ae();
         if (H) {
            game.e.r = false;
            this.ad();
            var1 = this;
            this.ad.a(var1.m, L, M, true);
            var1.l.a(var1.ad);
            var1.l.b();
         } else {
            if (!this.m.z) {
               short[] var12 = new short[]{this.r, this.s, G, 4, 4, 8, 40, 100, 0};
               this.m.a(var12);
               this.m.H();
            }

            if (I == -1) {
               this.ad.a(J, K, L, M, true);
               this.l.a(this.ad);
               this.l.b();
            } else {
               this.ad.a(this.n[I], L, M, true);
               this.l.a(this.ad);
               this.l.b();
            }

            this.m.a(false);
            H = true;
         }

         this.P();
         if (this.p == 3 && this.q == 7) {
            if (this.m.y > 0) {
               this.m.y = 0;
               this.m.b(0);
            }

            this.ax = new Image[4];

            for (int var13 = 0; var13 < this.ax.length; var13++) {
               this.ax[var13] = a.e.b("/data/tex/", "down" + var13);
            }

            this.m.t();
            this.m.h(0);
         }

         if (this.p == 5 && this.q == 6 || this.p == 4 && (this.q == 3 || this.q == 4)) {
            if (this.m.C[0][0] == 2) {
               a.a.f.a().a((byte)0, this.ad.m(), this.ad.n() - this.at[this.m.u + 1], g(), h(), 110, 110);
            } else {
               a.a.f.a().a((byte)0, this.ad.m(), this.ad.n() - this.at[this.m.u + 1], g(), h(), 50, 50);
            }
         } else {
            a.a.f.a().a((byte)-1);
         }

         this.d = game.k.a();
         this.d.a(this);
         this.c = c.j.a();
         this.Z.G();
         this.Z.a();
         T = true;
         this.a((byte)0);
         if (game.e.k == 2) {
            game.e.k = 0;
         }

         if (!Y) {
            this.W.a(X, 1);
         }

         e();
      } catch (Exception var5) {
         a.a.a.a(var5, "init");
      }

      return true;
   }

   private void P() {
      for (int var1 = 0; var1 < this.n.length; var1++) {
         this.n[var1].f();
         this.l.a(this.n[var1]);
      }
   }

   public final void a(byte var1, int var2, int var3, a.a.g var4) {
      if (this.z == null) {
         this.z = new a.a.g();
         this.z.a(259, false);
         this.z.a.a((byte)13, (byte)-1);
         this.l.a(this.z);
         a.a.g var5 = this.z;
         this.z.a.c();
         this.z.t = 0;
         this.z.c();
      }

      this.z.b(var2, var3);
      a.a.g var7 = var4;
      a.a.g var6 = this.z;
      this.z.q = var7;
   }

   public final void D() {
      if (this.z != null) {
         this.l.b(this.z);
         this.z = null;
      }
   }

   public final void l(int var1) {
      if (this.y == null) {
         this.y = new a.a.g();
         this.y.a(var1, false);
         a.a.g var2 = this.y;
         this.y.a.c();
         this.y.t = 1;
      }
   }

   public final void a(a.a.g var1) {
      if (this.y != null) {
         this.ar = var1;
         a.a.g var3 = var1;
         a.a.g var2 = this.y;
         this.y.q = var3;
         this.y.e(var1.a.g());
         this.y.c();
         this.l.a(this.y);
         if (w != null) {
            this.y.a(true);
         } else {
            this.y.a(false);
         }
      }
   }

   public final void E() {
      if (this.y != null) {
         this.l.b(this.y);
         this.y = null;
      }
   }

   private boolean a(j var1) {
      try {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         DataOutputStream var3 = new DataOutputStream(var2);
         if (this.p == 9) {
            var3.writeShort(super.d.m[(this.q << 2) + 2]);
            var3.writeShort(super.d.m[(this.q << 2) + 3]);
            var3.writeByte(2);
         } else if (this.p == 3 && this.q == 7) {
            var3.writeShort(240);
            var3.writeShort(40);
            var3.writeByte(0);
         } else {
            var3.writeShort(var1.j);
            var3.writeShort(var1.k);
            var3.writeByte(var1.o);
         }

         for (int var4 = 0; var4 < var1.C.length; var4++) {
            for (int var5 = 0; var5 < var1.C[var4].length; var5++) {
               var3.writeByte(var1.C[var4][var5]);
            }
         }

         for (int var12 = 0; var12 < var1.Q.length; var12++) {
            var3.writeByte(var1.Q[var12]);
         }

         for (int var13 = 0; var13 < var1.D.length; var13++) {
            for (int var24 = 0; var24 < var1.D[var13].length; var24++) {
               var3.writeByte(var1.D[var13][var24]);
            }
         }

         for (int var14 = 0; var14 < var1.F.length; var14++) {
            var3.writeByte(var1.F[var14]);
         }

         for (int var15 = 0; var15 < var1.E.length; var15++) {
            for (int var25 = 0; var25 < var1.E[var15].length; var25++) {
               var3.writeByte(this.m.E[var15][var25]);
            }
         }

         var3.writeByte(this.m.I);
         var3.writeByte(this.m.H);
         var3.writeByte(this.m.G);
         var3.writeByte(this.m.J);

         for (int var16 = 0; var16 < this.m.S.length; var16++) {
            var3.writeByte(this.m.S[var16]);
         }

         if (!this.H()) {
            return false;
         }

         if (!this.aa()) {
            return false;
         }

         if (!this.Y()) {
            return false;
         }

         var3.writeInt(var1.M.size());

         for (int var17 = 0; var17 < var1.M.size(); var17++) {
            int[] var26 = (int[])var1.M.elementAt(var17);
            var3.writeInt(var26.length);

            for (int var6 = 0; var6 < var26.length; var6++) {
               var3.writeInt(var26[var6]);
            }
         }

         var3.writeInt(var1.N.size());

         for (int var18 = 0; var18 < var1.N.size(); var18++) {
            int[] var27 = (int[])var1.N.elementAt(var18);
            var3.writeInt(var27.length);

            for (int var31 = 0; var31 < var27.length; var31++) {
               var3.writeInt(var27[var31]);
            }
         }

         var3.writeInt(var1.O.size());

         for (int var19 = 0; var19 < var1.O.size(); var19++) {
            int[] var28 = (int[])var1.O.elementAt(var19);
            var3.writeInt(var28.length);

            for (int var32 = 0; var32 < var28.length; var32++) {
               var3.writeInt(var28[var32]);
            }
         }

         for (int var20 = 0; var20 < var1.U.length; var20++) {
            var3.writeBoolean(var1.U[var20]);
         }

         if (!this.W()) {
            return false;
         }

         if (P == null) {
            P = new Vector();
         }

         var3.writeByte(P.size());

         for (int var21 = 0; var21 < P.size(); var21++) {
            String var29 = (String)P.elementAt(var21);
            var3.writeByte(a.e.d(var29));
         }

         for (int var22 = 0; var22 < this.aV.length; var22++) {
            var3.writeBoolean(this.aV[var22]);
         }

         if (this.y == null) {
            var3.writeByte(-1);
         } else {
            var3.writeByte(this.y.a.a);
         }

         var3.write(this.m.v);
         var3.writeInt(A);
         var3.writeBoolean(U);
         long var9 = game.f.B().n + game.f.B().o - game.f.B().p;
         var3.writeLong(var9);
         var3.writeByte(this.m.u);
         var3.writeInt(var1.P.size());

         for (int var23 = 0; var23 < var1.P.size(); var23++) {
            int[] var33 = (int[])var1.P.elementAt(var23);
            var3.writeInt(var33.length);

            for (int var30 = 0; var30 < var33.length; var30++) {
               var3.writeInt(var33[var30]);
            }
         }

         ah[0].a(var2);
         var2.close();
         var3.close();
         return true;
      } catch (Exception var11) {
         System.out.println(" savePlayer ex = " + var11);
         return false;
      }
   }

   private boolean b(j var1) {
      try {
         ByteArrayInputStream var2 = new ByteArrayInputStream(ah[0].a(0));
         DataInputStream var3 = new DataInputStream(var2);
         this.r = var3.readShort();
         this.s = var3.readShort();
         short var4 = var3.readByte();

         for (int var5 = 0; var5 < var1.C.length; var5++) {
            for (int var6 = 0; var6 < var1.C[var5].length; var6++) {
               var1.C[var5][var6] = var3.readByte();
            }
         }

         for (int var11 = 0; var11 < var1.Q.length; var11++) {
            var1.Q[var11] = var3.readByte();
         }

         for (int var12 = 0; var12 < var1.D.length; var12++) {
            for (int var21 = 0; var21 < var1.D[var12].length; var21++) {
               var1.D[var12][var21] = var3.readByte();
            }
         }

         for (int var13 = 0; var13 < var1.F.length; var13++) {
            var1.F[var13] = var3.readByte();
         }

         for (int var14 = 0; var14 < var1.E.length; var14++) {
            for (int var22 = 0; var22 < var1.E[var14].length; var22++) {
               this.m.E[var14][var22] = var3.readByte();
            }
         }

         this.m.I = var3.readByte();
         this.m.H = var3.readByte();
         this.m.G = var3.readByte();
         this.m.J = var3.readByte();

         for (int var15 = 0; var15 < this.m.S.length; var15++) {
            this.m.S[var15] = var3.readByte();
         }

         this.ac();
         this.ab();
         this.Z();
         int var16 = var3.readInt();
         var1.M.removeAllElements();

         for (int var23 = 0; var23 < var16; var23++) {
            int[] var7 = new int[var3.readInt()];

            for (int var8 = 0; var8 < var7.length; var8++) {
               var7[var8] = var3.readInt();
            }

            var1.M.addElement(var7);
         }

         var16 = var3.readInt();
         var1.N.removeAllElements();

         for (int var24 = 0; var24 < var16; var24++) {
            int[] var31 = new int[var3.readInt()];

            for (int var35 = 0; var35 < var31.length; var35++) {
               var31[var35] = var3.readInt();
            }

            var1.N.addElement(var31);
         }

         var16 = var3.readInt();
         var1.O.removeAllElements();

         for (int var25 = 0; var25 < var16; var25++) {
            int[] var32 = new int[var3.readInt()];

            for (int var36 = 0; var36 < var32.length; var36++) {
               var32[var36] = var3.readInt();
            }

            var1.O.addElement(var32);
         }

         for (int var26 = 0; var26 < var1.U.length; var26++) {
            var1.U[var26] = var3.readBoolean();
         }

         this.X();
         if (O == null) {
            O = new Vector();
         }

         O.removeAllElements();
         byte var19;
         int[] var33 = new int[var19 = var3.readByte()];

         for (int var27 = 0; var27 < var19; var27++) {
            var33[var27] = var3.readByte();
            if (this.m.A[var33[var27]] != null) {
               this.m.A[var33[var27]].x();
               O.addElement(this.m.A[var33[var27]]);
            }
         }

         for (int var28 = 0; var28 < this.aV.length; var28++) {
            this.aV[var28] = var3.readBoolean();
         }

         byte var29;
         if ((var29 = var3.readByte()) != -1) {
            this.l(var29);
         }

         var1.v = var3.readByte();
         A = var3.readInt();
         U = var3.readBoolean();
         f var10000 = game.f.B();
         var10000.n = var10000.n + var3.readLong();
         var1.u = var3.readByte();
         var1.a(new short[]{this.r, this.s, (short)var4, 4, 4, 8, 40, 100, 0});
         if ((var29 = var3.readInt()) > 0) {
            var1.P.removeAllElements();

            for (int var10 = 0; var10 < var29; var10++) {
               var33 = new int[var3.readInt()];

               for (int var20 = 0; var20 < var33.length; var20++) {
                  var33[var20] = var3.readInt();
               }

               var1.P.addElement(var33);
            }
         }

         var2.close();
         var3.close();
         return true;
      } catch (Exception var9) {
         System.out.println(" loadPlayer ex = " + var9);
         return false;
      }
   }

   private boolean Q() {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         DataOutputStream var2;
         (var2 = new DataOutputStream(var1)).writeInt(this.p);
         var2.writeInt(this.q);

         for (int var3 = 0; var3 < ai.length; var3++) {
            if (ai[var3] == null) {
               var2.writeShort(-1);
            } else {
               var2.writeShort(ai[var3].length);

               for (int var4 = 0; var4 < ai[var3].length; var4++) {
                  if (ai[var3][var4] == null) {
                     var2.writeByte(-1);
                  } else {
                     var2.writeByte(ai[var3][var4].length);

                     for (int var5 = 0; var5 < ai[var3][var4].length; var5++) {
                        var2.writeByte(ai[var3][var4][var5]);
                     }
                  }
               }
            }
         }

         for (int var7 = 0; var7 < aj.length; var7++) {
            if (aj[var7] == null) {
               var2.writeShort(-1);
            } else {
               var2.writeShort(aj[var7].length);

               for (int var8 = 0; var8 < aj[var7].length; var8++) {
                  if (aj[var7][var8] == null) {
                     var2.writeByte(-1);
                  } else {
                     var2.writeByte(aj[var7][var8].length);

                     for (int var9 = 0; var9 < aj[var7][var8].length; var9++) {
                        var2.writeShort(aj[var7][var8][var9]);
                     }
                  }
               }
            }
         }

         ah[1].a(var1);
         var1.close();
         var2.close();
         return true;
      } catch (IOException var6) {
         return false;
      }
   }

   private boolean R() {
      try {
         ByteArrayInputStream var1 = new ByteArrayInputStream(ah[1].a(0));
         DataInputStream var2 = new DataInputStream(var1);
         this.p = var2.readInt();
         this.q = var2.readInt();

         for (int var4 = 0; var4 < ai.length; var4++) {
            short var3;
            if ((var3 = var2.readShort()) == -1) {
               ai[var4] = null;
            } else {
               ai[var4] = new byte[var3][];

               for (int var5 = 0; var5 < ai[var4].length; var5++) {
                  byte var7;
                  if ((var7 = var2.readByte()) == -1) {
                     ai[var4][var5] = null;
                  } else {
                     ai[var4][var5] = new byte[var7];

                     for (int var8 = 0; var8 < ai[var4][var5].length; var8++) {
                        ai[var4][var5][var8] = var2.readByte();
                     }
                  }
               }
            }
         }

         for (int var12 = 0; var12 < aj.length; var12++) {
            short var9;
            if ((var9 = var2.readShort()) == -1) {
               aj[var12] = null;
            } else {
               aj[var12] = new short[var9][];

               for (int var13 = 0; var13 < aj[var12].length; var13++) {
                  byte var10;
                  if ((var10 = var2.readByte()) == -1) {
                     aj[var12][var13] = null;
                  } else {
                     aj[var12][var13] = new short[var10];

                     for (int var11 = 0; var11 < aj[var12][var13].length; var11++) {
                        aj[var12][var13][var11] = var2.readShort();
                     }
                  }
               }
            }
         }

         var1.close();
         var2.close();
         return true;
      } catch (IOException var6) {
         System.out.println(" sceneId ex = " + var6);
         return false;
      }
   }

   private boolean S() {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         DataOutputStream var2 = new DataOutputStream(var1);

         for (int var3 = 0; var3 < this.Z.n.length; var3++) {
            if (this.Z.n[var3] == null) {
               var2.writeByte(-1);
            } else {
               var2.writeByte(this.Z.n[var3].length);

               for (int var4 = 0; var4 < this.Z.n[var3].length; var4++) {
                  var2.writeByte(this.Z.n[var3][var4]);
               }
            }
         }

         var2.writeByte(game.e.G);
         var2.writeByte(game.e.H);

         for (int var6 = 0; var6 < game.e.H; var6++) {
            var2.writeShort(game.e.F[var6][0]);
            var2.writeShort(game.e.F[var6][1]);
         }

         int[] var7;
         if ((var7 = this.Z.I()) == null) {
            var2.writeByte(-1);
         } else {
            var2.writeByte(var7.length);

            for (int var8 = 0; var8 < var7.length; var8++) {
               var2.writeInt(var7[var8]);
            }

            var2.writeByte(this.Z.C);
         }

         ah[2].a(var1);
         var1.close();
         var2.close();
         return true;
      } catch (IOException var5) {
         return false;
      }
   }

   private boolean T() {
      try {
         ByteArrayInputStream var1 = new ByteArrayInputStream(ah[2].a(0));
         DataInputStream var2 = new DataInputStream(var1);

         for (int var4 = 0; var4 < this.Z.n.length; var4++) {
            byte var3;
            if ((var3 = var2.readByte()) == -1) {
               this.Z.n[var4] = null;
            } else {
               this.Z.n[var4] = new byte[var3];

               for (int var8 = 0; var8 < this.Z.n[var4].length; var8++) {
                  this.Z.n[var4][var8] = var2.readByte();
               }
            }
         }

         game.e.G = var2.readByte();
         game.e.H = var2.readByte();

         for (int var10 = 0; var10 < game.e.H; var10++) {
            game.e.F[var10][0] = var2.readShort();
            game.e.F[var10][1] = var2.readShort();
         }

         byte var11;
         if ((var11 = var2.readByte()) != -1) {
            int[] var9 = new int[var11];
            int[] var5 = this.Z.H();

            for (int var6 = 0; var6 < var11; var6++) {
               var9[var6] = var2.readInt();
            }

            this.Z.a(var9);
            boolean var12 = false;
            if (var5[0] > var9[0] || var5[1] > var9[1] || var5[2] > var9[2] || var5[3] - var9[3] >= 20) {
               var12 = true;
            }

            this.Z.C = var2.readByte();
            if (var12) {
               this.Z.C = 0;
            }
         }

         H = true;
         var1.close();
         var2.close();
         return true;
      } catch (IOException var7) {
         return false;
      }
   }

   public static boolean F() {
      try {
         ByteArrayOutputStream var0 = new ByteArrayOutputStream();
         DataOutputStream var1 = new DataOutputStream(var0);
         h = true;
         var1.writeBoolean(h);
         var1.writeBoolean(H);
         var1.writeBoolean(N);
         var1.writeByte(Q);
         ah[3].a(var0);
         var0.close();
         var1.close();
         return true;
      } catch (IOException var2) {
         return false;
      }
   }

   public static boolean G() {
      if (ah[3] == null) {
         ah[3] = new a.b.e(aw[3], 1);
      }

      try {
         ByteArrayInputStream var0 = new ByteArrayInputStream(ah[3].a(0));
         DataInputStream var1;
         h = (var1 = new DataInputStream(var0)).readBoolean();
         H = var1.readBoolean();
         N = var1.readBoolean();
         Q = var1.readByte();
         var0.close();
         var1.close();
         return true;
      } catch (IOException var2) {
         h = false;
         System.out.println(" isHaveSms = " + h);
         return false;
      }
   }

   private static boolean U() {
      try {
         ByteArrayOutputStream var0 = new ByteArrayOutputStream();
         DataOutputStream var1;
         (var1 = new DataOutputStream(var0)).writeBoolean(i);
         ah[4].a(var0);
         var0.close();
         var1.close();
         return true;
      } catch (IOException var2) {
         return false;
      }
   }

   private static boolean V() {
      try {
         ByteArrayInputStream var0 = new ByteArrayInputStream(ah[4].a(0));
         DataInputStream var1;
         i = (var1 = new DataInputStream(var0)).readBoolean();
         var0.close();
         var1.close();
         return true;
      } catch (IOException var2) {
         return false;
      }
   }

   private boolean W() {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         DataOutputStream var2;
         (var2 = new DataOutputStream(var1)).writeInt(this.m.F());
         var2.writeInt(this.m.G());
         ah[6].a(var1);
         var1.close();
         var2.close();
         return true;
      } catch (IOException var3) {
         return false;
      }
   }

   private boolean X() {
      try {
         ByteArrayInputStream var1 = new ByteArrayInputStream(ah[6].a(0));
         DataInputStream var2 = new DataInputStream(var1);
         this.m.t(0);
         this.m.w(0);
         this.m.s(var2.readInt());
         this.m.v(var2.readInt());
         var1.close();
         var2.close();
         return true;
      } catch (IOException var3) {
         return false;
      }
   }

   private boolean Y() {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         DataOutputStream var2;
         (var2 = new DataOutputStream(var1)).writeInt(this.m.L.size());

         for (int var3 = 0; var3 < this.m.L.size(); var3++) {
            int[] var4 = (int[])this.m.L.elementAt(var3);
            var2.writeInt(var4.length);

            for (int var5 = 0; var5 < var4.length; var5++) {
               var2.writeInt(var4[var5]);
            }
         }

         ah[9].a(var1);
         var1.close();
         var2.close();
         return true;
      } catch (IOException var6) {
         return false;
      }
   }

   private boolean Z() {
      try {
         ByteArrayInputStream var1 = new ByteArrayInputStream(ah[9].a(0));
         DataInputStream var2;
         int var3 = (var2 = new DataInputStream(var1)).readInt();
         this.m.L.removeAllElements();

         for (int var4 = 0; var4 < var3; var4++) {
            int[] var5 = new int[var2.readInt()];

            for (int var6 = 0; var6 < var5.length; var6++) {
               var5[var6] = var2.readInt();
            }

            this.m.L.addElement(var5);
         }

         var1.close();
         var2.close();
         return true;
      } catch (IOException var7) {
         return false;
      }
   }

   private boolean aa() {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         DataOutputStream var2;
         (var2 = new DataOutputStream(var1)).writeInt(this.m.K.size());

         for (int var3 = 0; var3 < this.m.K.size(); var3++) {
            int[] var4 = (int[])this.m.K.elementAt(var3);
            var2.writeInt(var4.length);

            for (int var5 = 0; var5 < var4.length; var5++) {
               var2.writeInt(var4[var5]);
            }
         }

         ah[8].a(var1);
         var1.close();
         var2.close();
         return true;
      } catch (IOException var6) {
         return false;
      }
   }

   private boolean ab() {
      try {
         ByteArrayInputStream var1 = new ByteArrayInputStream(ah[8].a(0));
         DataInputStream var2;
         int var3 = (var2 = new DataInputStream(var1)).readInt();
         this.m.K.removeAllElements();

         for (int var4 = 0; var4 < var3; var4++) {
            int[] var5 = new int[var2.readInt()];

            for (int var6 = 0; var6 < var5.length; var6++) {
               var5[var6] = var2.readInt();
            }

            this.m.K.addElement(var5);
         }

         var1.close();
         var2.close();
         return true;
      } catch (IOException var7) {
         return false;
      }
   }

   public final boolean H() {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         DataOutputStream var2;
         (var2 = new DataOutputStream(var1)).writeByte(this.m.B);

         for (int var3 = 0; var3 < this.m.B; var3++) {
            int[] var4 = this.m.A[var3].Q();
            var2.writeInt(var4.length);

            for (int var5 = 0; var5 < var4.length; var5++) {
               var2.writeInt(var4[var5]);
            }
         }

         ah[7].a(var1);
         var1.close();
         var2.close();
         return true;
      } catch (IOException var6) {
         return false;
      }
   }

   private boolean ac() {
      try {
         ByteArrayInputStream var1 = new ByteArrayInputStream(ah[7].a(0));
         DataInputStream var2;
         byte var3 = (var2 = new DataInputStream(var1)).readByte();

         for (int var4 = 0; var4 < this.m.B; var4++) {
            this.m.A[var4] = null;
         }

         this.m.B = 0;

         for (int var8 = 0; var8 < var3; var8++) {
            int[] var5 = new int[var2.readInt()];

            for (int var6 = 0; var6 < var5.length; var6++) {
               var5[var6] = var2.readInt();
            }

            this.m.a(var5);
         }

         var1.close();
         var2.close();
         return true;
      } catch (IOException var7) {
         return false;
      }
   }

   public final boolean I() {
      if (!this.a(this.m)) {
         return false;
      } else if (!this.Q()) {
         return false;
      } else if (!this.S()) {
         return false;
      } else {
         return !F() ? false : U();
      }
   }

   public final boolean J() {
      if (!U()) {
         return false;
      } else {
         return !this.W() ? false : this.Y();
      }
   }

   public static void K() {
      ai = null;
      aj = null;

      for (int var0 = 0; var0 < 10; var0++) {
         if (var0 != 4 && ah[var0] != null) {
            ah[var0].a();
            ah[var0] = null;
         }
      }

      ah = null;
   }

   public final boolean L() {
      this.Z.a(this);
      this.d.a(this);
      game.e.r = false;
      T = true;
      this.a((byte)0);
      if (Y) {
         this.W.a(a(this.Z.m, (byte)0), 1);
      } else {
         this.W.a(X, 1);
      }

      this.c.a("/data/ui/battle.ui");
      return true;
   }

   private void ad() {
      if (!this.m.z) {
         if (h) {
            this.b(this.m);
         } else {
            short[] var1 = new short[]{this.r, this.s, G, 4, 4, 8, 40, 100, 0};
            this.m.a(var1);
         }
      } else if (this.t >= 0) {
         byte var3 = 2;
         j var2 = this.m;
         int var4 = this.n[this.t].j - this.n[this.t].j % this.m.d[var3];
         var3 = 2;
         var2 = this.m;
         int var7 = this.n[this.t].k - this.n[this.t].k % this.m.d[var3];
         this.m.b(var4, var7);
         this.m.b.b(var4, var7);
         this.m.a((byte)0, this.n[this.t].D);
         if (this.n[this.t].a.a == 222) {
            this.m.a(24);
         } else {
            this.m.a(32);
         }
      } else {
         short[] var5 = new short[]{this.r, this.s, G, 4, 4, 8, 40, 100, 0};
         this.m.a(var5);
      }

      this.l.a(this.m);
      this.m.C();
      this.m.c();
      this.a((a.a.g)this.m);
      if (w != null) {
         this.m.a(false);
      } else {
         this.m.a(true);
      }
   }

   private void ae() {
      for (int var1 = 0; var1 < this.n.length; var1++) {
         if (this.n[var1].u == 0 && this.n[var1].w == 14) {
            h var2;
            (var2 = this.n[var1]).B = 0;

            while (true) {
               byte var10001 = var2.a.g();
               int var10002 = 16 * (var2.B + 1);
               boolean var3 = false;
               int var5 = var10002;
               byte var4 = var10001;
               h var7 = var2;
               byte var6 = 0;
               switch (var4) {
                  case 0:
                     var6 = a.b.d.a().a(0, var7.j, var7.k + var5);
                     break;
                  case 1:
                     var6 = a.b.d.a().a(0, var7.j + var5, var7.k);
                     break;
                  case 2:
                     var6 = a.b.d.a().a(0, var7.j, var7.k - var5);
                     break;
                  case 3:
                     var6 = a.b.d.a().a(0, var7.j - var5, var7.k);
               }

               if (var6 != 0) {
                  var2.C = var2.B;
                  var2.B = 0;
                  break;
               }

               var2.B++;
            }
         }
      }
   }

   private void a(int var1, int var2, String var3) {
      var3 = var3 + "scene_" + var1 + ".mid";

      try {
         "".getClass();
         InputStream var17 = b.a(var3);
         DataInputStream var4;
         short var5;
         short[] var6 = new short[var5 = (var4 = new DataInputStream(var17)).readShort()];

         for (int var7 = 0; var7 < var5; var7++) {
            var6[var7] = var4.readShort();
         }

         short var24 = 0;

         for (int var18 = 0; var18 < var2; var18++) {
            var24 += var6[var18];
         }

         var4.skipBytes(var24);
         var5 = var4.readShort();
         String[] var23 = null;
         if (var5 > 0) {
            var23 = new String[var5];

            for (int var25 = 0; var25 < var5; var25++) {
               short var8 = var4.readShort();
               StringBuffer var9 = new StringBuffer();

               for (int var10 = 0; var10 < var8; var10++) {
                  var9.append((char)(var4.read() << 8 | var4.read() & 0xFF));
               }

               var23[var25] = var9.toString();
            }
         }

         short var26 = var4.readByte();
         StringBuffer var29 = new StringBuffer();

         for (int var32 = 0; var32 < var26; var32++) {
            var29.append((char)(var4.read() << 8 | var4.read() & 0xFF));
         }

         this.ae = var4.readShort();
         al = null;
         var4.readShort();
         short var55 = var4.readShort();
         boolean[] var20 = new boolean[2];
         int var11 = var2;
         int var33 = var1;
         if (ai[v[var33] + var11] == null) {
            var11 = var2;
            var33 = var1;
            ai[v[var33] + var11] = new byte[var55][3];
            var20[0] = true;
         }

         if (this.p == 9) {
            var11 = var2;
            var33 = var1;
            aj[v[var33] + var11] = null;
         }

         var11 = var2;
         var33 = var1;
         if (aj[v[var33] + var11] == null) {
            var11 = var2;
            var33 = var1;
            aj[v[var33] + var11] = new short[var55][2];
            var20[1] = true;
         }

         if (var55 > 0) {
            this.n = new h[var55];

            for (int var27 = 0; var27 < var55; var27++) {
               try {
                  this.n[var27] = new h();
                  short[] var30;
                  (var30 = new short[var4.readShort()])[0] = var4.readByte();
                  var30[1] = var4.readShort();
                  var30[2] = var4.readShort();
                  var30[3] = var4.readShort();
                  var30[4] = var4.readShort();
                  var30[5] = var4.readByte();
                  var30[6] = var4.readByte();
                  switch (var30[0]) {
                     case 0:
                        var30[7] = var4.readByte();
                        var30[8] = var4.readByte();
                        var30[9] = var4.readByte();
                        var30[10] = var4.readByte();
                        var30[11] = var4.readShort();
                        var30[12] = var4.readShort();
                        if (var20[0]) {
                           var11 = var2;
                           var33 = var1;
                           ai[v[var33] + var11][var27][0] = (byte)var30[2];
                           var11 = var2;
                           var33 = var1;
                           ai[v[var33] + var11][var27][1] = (byte)var30[5];
                        } else {
                           if (var30[6] != 7 && var30[6] != 6) {
                              var11 = var2;
                              var33 = var1;
                              var30[2] = ai[v[var33] + var11][var27][0];
                           }

                           var11 = var2;
                           var33 = var1;
                           var30[5] = ai[v[var33] + var11][var27][1];
                        }

                        if (var20[1]) {
                           var11 = var2;
                           var33 = var1;
                           aj[v[var33] + var11][var27][0] = var30[3];
                           var11 = var2;
                           var33 = var1;
                           aj[v[var33] + var11][var27][1] = var30[4];
                        } else {
                           var11 = var2;
                           var33 = var1;
                           var30[3] = aj[v[var33] + var11][var27][0];
                           var11 = var2;
                           var33 = var1;
                           var30[4] = aj[v[var33] + var11][var27][1];
                        }

                        this.n[var27].a(var30, var27);
                        if (!var20[0]) {
                           if (var30[6] == 1) {
                              if (var30[6] != 7 && var30[6] != 6) {
                                 var11 = var2;
                                 var33 = var1;
                                 var30[2] = ai[v[var33] + var11][var27][0];
                              }

                              h var10000 = this.n[var27];
                              var11 = var2;
                              var33 = var1;
                              byte var76 = ai[v[var33] + var11][var27][2];
                              var10000.o = var76;
                              this.n[var27].a((byte)var30[2]);
                           }
                        } else {
                           var11 = var2;
                           var33 = var1;
                           ai[v[var33] + var11][var27][2] = this.n[var27].o;
                        }
                        break;
                     case 1:
                        var30[7] = var4.readByte();
                        var30[8] = var4.readShort();
                        var30[9] = var4.readShort();
                        var30[10] = var4.readShort();
                        if (var20[0] && var30[6] == 3) {
                           var11 = var2;
                           var33 = var1;
                           ai[v[var33] + var11][var27][0] = (byte)var30[2];
                           var11 = var2;
                           var33 = var1;
                           ai[v[var33] + var11][var27][1] = (byte)var30[5];
                        }

                        if (var30[6] == 3) {
                           var11 = var2;
                           var33 = var1;
                           var30[2] = ai[v[var33] + var11][var27][0];
                           var11 = var2;
                           var33 = var1;
                           var30[5] = ai[v[var33] + var11][var27][1];
                        }

                        this.n[var27].a(var30, var27);
                        break;
                     case 2:
                        var30[7] = var4.readShort();
                        if (var30[7] == 1) {
                           var30[8] = var4.readByte();
                           var30[9] = var4.readByte();
                           var30[10] = var4.readByte();
                           var30[11] = var4.readByte();
                           var30[12] = var4.readByte();
                        }

                        this.n[var27].a(var30, var27);
                        break;
                     case 3:
                        var30[7] = var4.readByte();
                        var30[8] = var4.readByte();
                        var30[9] = var4.readByte();
                        var30[10] = var4.readShort();
                        var30[11] = var4.readShort();
                        if (var20[0]) {
                           var11 = var2;
                           var33 = var1;
                           ai[v[var33] + var11][var27][0] = (byte)var30[2];
                        } else {
                           var11 = var2;
                           var33 = var1;
                           var30[2] = ai[v[var33] + var11][var27][0];
                        }

                        this.n[var27].a(var30, var27);
                  }
               } catch (Exception var12) {
                  System.out.println(" k = " + var27 + " e = " + var12);
               }
            }

            al = new String[var26 = var4.readShort()];

            for (int var31 = 0; var31 < var26; var31++) {
               StringBuffer var14 = new StringBuffer();
               byte var15 = var4.readByte();

               for (int var21 = 0; var21 < var15; var21++) {
                  var14.append((char)(var4.readByte() << 8 | var4.readByte() & 0xFF));
               }

               al[var31] = var14.toString();
            }
         }

         this.aB = 1;
         var5 = var4.readShort();
         this.aB = 2;
         if (var5 > 0) {
            this.Z.a(var4, this.p, this.q, var5, var23);
         }

         var4.close();
         var17.close();
      } catch (Exception var13) {
         System.out.println(" initRoom = " + var13 + " bug = " + this.aB);
      }
   }

   public final void c() {
      this.l.a();
      this.k.b();
      if (this.n != null) {
         for (int var1 = 0; var1 < this.n.length; var1++) {
            h var2;
            (var2 = this.n[var1]).e();
            if (var2.b != null) {
               var2.b.a.b();
               var2.b = null;
            }

            var2.a.b();
            var2.a = null;
            if (var2.H != null) {
               var2.H.a.b();
               var2.H = null;
            }

            if (var2.I != null) {
               var2.I.a.b();
               var2.I = null;
            }

            var2.J = -1;
            this.n[var1] = null;
         }

         this.n = null;
      }

      w = null;
      ag = null;
      am = null;
      ay = null;
      this.o.removeAllElements();
      an.removeAllElements();
      ap.removeAllElements();
      aq.removeAllElements();
      ao.removeAllElements();
      if (R != null) {
         R.removeAllElements();
         R = null;
      }

      this.c.b();
      this.Z.c();
      E = -1;
      a.a.f.c();
   }

   public final void a(byte var1) {
      this.b = this.a;
      switch (var1) {
         case 0:
            u();
            if (!game.e.r) {
               if (T) {
                  this.d.c();
               } else {
                  this.d.d();
               }
            }

            this.m.a((byte)0, this.m.o);
            break;
         case 1:
            this.d.j = 1;
            this.d.F();
            break;
         case 2:
            if (E != -1 && this.n[E] != null && this.n[E].a.a == 24) {
               this.d.a(4, (byte)0);
            } else if (E != -1 && this.n[E] != null && this.n[E].a.a == 20) {
               this.d.a(3, (byte)2);
            }
            break;
         case 3:
            this.d.O();
         case 4:
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
         case 103:
         default:
            break;
         case 5:
            this.d.ag();
            break;
         case 6:
            this.d.k();
            break;
         case 7:
            this.d.c = 0;
            this.d.Z();
            break;
         case 8:
            this.d.ab();
            break;
         case 9:
            this.d.Q();
            break;
         case 10:
            this.d.U();
            break;
         case 11:
            this.d.S();
            break;
         case 12:
            this.d.W();
            break;
         case 13:
            this.d.m();
            break;
         case 14:
            this.d.aC();
            break;
         case 15:
            this.d.B();
            break;
         case 16:
            this.d.D();
            break;
         case 17:
            this.d.l = false;
         case 18:
         case 19:
            this.d.c = 0;
            this.d.Z();
            break;
         case 20:
            this.d.x();
            break;
         case 21:
            this.d.z();
            break;
         case 22:
            this.d.K();
            this.d.a("Có lưu dữ liệu không?");
            break;
         case 23:
            if (this.b == 7) {
               this.d.a("", this.aC, -1, -1);
            } else if (this.n != null) {
               if (this.n[E].a.a == 68) {
                  this.d.a(al[this.n[E].z], "Muốn lên thuyền đi đâu?", 1, -1);
               } else if (this.n[E].y < 0) {
                  this.d.a(al[this.n[E].z], aa[0], 1, -1);
               } else {
                  this.d.a(al[this.n[E].z], aa[this.n[E].y], 1, -1);
               }
            }

            this.m.a((byte)0, this.m.o);
            break;
         case 24:
            this.d.h();
            break;
         case 25:
            this.d.au();
            break;
         case 26:
            this.d.j = 2;
            this.d.a(4, (byte)0);
            break;
         case 27:
            this.d.aS();
            break;
         case 28:
            byte var7 = 0;

            while (var7 < this.av.length / 4 && (this.av[var7 << 2] != this.p || this.av[(var7 << 2) + 1] != this.q)) {
               var7++;
            }

            this.d.a(var7, this.av[(var7 << 2) + 2], this.av[(var7 << 2) + 3]);
            break;
         case 29:
            a.a.f.a().c(0, 2);
            break;
         case 30:
            this.d.aQ();
            break;
         case 31:
            this.d.f = 0;
            l var2 = this;
            byte var3 = 0;
            var2.ai();
            if (var2.aY >= var2.aX) {
               var3 = 1;
            }

            this.aZ = (boolean)var3;
            if (this.aZ) {
               if (this.aX == this.aW.length - 1) {
                  this.d.a(al[this.n[E].z], c(613), 1, -1);
               } else if (this.aX == this.aW.length - 2) {
                  this.d.a(al[this.n[E].z], c(612), 1, -1);
               } else {
                  int[] var4 = new int[]{this.aW[this.aX], this.aW[this.aX + 1]};
                  this.d.a(al[this.n[E].z], a(611, var4), 1, -1);
               }
            } else if (this.aX < this.aW.length) {
               String var10001 = al[this.n[E].z];
               var3 = this.aW[this.aX];
               short var5 = 614;
               int var6;
               this.d
                  .a(
                     var10001,
                     (var6 = a.a.c(614).indexOf("%s")) == -1 ? a.a.c(614) : a.a.c(614).substring(0, var6) + var3 + a.a.c(614).substring(var6 + 2),
                     1,
                     -1
                  );
            } else {
               this.d.a(al[this.n[E].z], c(615), 1, -1);
            }
            break;
         case 32:
            this.d.j = 3;
            this.d.a(3, (byte)2);
            break;
         case 100:
            this.d.d(0);
            break;
         case 101:
            this.d.aJ();
            break;
         case 102:
            this.d.aL();
            break;
         case 104:
            this.d.aK();
      }

      this.d.g = true;
      this.a = var1;
      this.z();
   }

   public final void a() {
      if (this.j) {
         this.A();
         switch (this.a) {
            case 0:
               this.af();
               break;
            case 1:
               this.d.G();
               break;
            case 2:
               if ((E == -1 || this.n[E] == null || this.n[E].a.a != 24) && this.Z.o != 0) {
                  if (E != -1 && this.n[E] != null && this.n[E].a.a == 20 || this.Z.o == 1) {
                     this.d.a((byte)3, (byte)2);
                  }
               } else {
                  this.d.a((byte)4, (byte)0);
               }
               break;
            case 3:
               this.d.P();
               break;
            case 4:
               if (this.aL) {
                  if (this.aH == this.aJ && this.aI == this.aK) {
                     this.aL = false;
                  }

                  int var4;
                  if ((var4 = a.e.a(this.aH, this.aI, this.aJ, this.aK)) < this.aO) {
                     this.aH = this.aJ;
                     this.aI = this.aK;
                  } else {
                     this.aH = this.aH + (this.aJ - this.aH) * this.aO / var4;
                     this.aI = this.aI + (this.aK - this.aI) * this.aO / var4;
                  }
               }

               if (!this.aL) {
                  if (this.i(16400)) {
                     if (this.aH < 0) {
                        this.aH = this.aH + this.aO;
                     }
                  } else if (this.i(32832)) {
                     if (this.aH + (this.aT[this.aD << 1] << 4) * 5 > g()) {
                        this.aH = this.aH - this.aO;
                     }
                  } else if (this.i(4100)) {
                     if (this.aI < 0) {
                        this.aI = this.aI + this.aO;
                     }
                  } else if (this.i(8448)) {
                     if (this.aI + (this.aT[(this.aD << 1) + 1] << 3) * 5 > h() - 30) {
                        this.aI = this.aI - this.aO;
                     }
                  } else if (this.g(262145) || this.a(0, 270, g(), 30)) {
                     game.a.B().m = null;
                     this.a((byte)0);
                  }
               }

               this.aM.a();

               for (int var5 = 0; var5 < this.aN.length; var5++) {
                  this.o(var5);
                  this.aN[var5].a();
               }
               break;
            case 5:
               this.d.ah();
               break;
            case 6:
               this.d.l();
               break;
            case 7:
               this.d.aa();
               this.q();
               break;
            case 8:
               this.d.af();
               break;
            case 9:
               this.d.R();
               break;
            case 10:
               this.d.V();
               break;
            case 11:
               this.d.T();
               break;
            case 12:
               this.d.X();
               break;
            case 13:
               this.d.n();
               break;
            case 14:
               this.d.aD();
               break;
            case 15:
               this.d.C();
               break;
            case 16:
               this.d.E();
               break;
            case 17:
               this.d.ac();
               break;
            case 18:
               this.d.ad();
               break;
            case 19:
               this.d.ae();
               break;
            case 20:
               this.d.y();
               break;
            case 21:
               this.d.A();
               break;
            case 22:
               this.d.N();
               break;
            case 23:
               l var1 = this;
               if (this.d.d(D, C) && var1.g(196640)) {
                  if (a.e.b < a.e.b()) {
                     a.e.c();
                     var1.d.b(a.e.b);
                  } else {
                     label229: {
                        var1.d.aF();
                        if (var1.b != 7) {
                           if (var1.n[E].a.a <= 85) {
                              byte var3 = var1.n[E].n;
                              var1.n[E].o = var3;
                           }

                           var1.n[E].a((byte)0);
                           var1.m.a((byte)0, var1.m.o);
                           if (var1.n[E].a.a == 24 || var1.n[E].a.a == 20) {
                              var1.a((byte)1);
                              break label229;
                           }

                           if (var1.n[E].a.a == 25) {
                              var1.a((byte)16);
                              break label229;
                           }

                           if (var1.n[E].a.a == 68) {
                              var1.a((byte)28);
                              break label229;
                           }

                           if (E != -1) {
                              B().a((byte)13, B().n[E].j, B().n[E].k - 40, B().n[E]);
                           }
                        }

                        var1.a((byte)0);
                     }
                  }
               }

               var1.l.b();
               break;
            case 24:
               this.d.i();
               break;
            case 25:
               this.d.av();
               break;
            case 26:
               this.d.a((byte)4, (byte)0);
               break;
            case 27:
               this.d.aT();
               break;
            case 28:
               this.d.aP();
               break;
            case 29:
               a.a.f.a().d();
               if (a.a.f.a().d) {
                  a.a.f.a().a = -1;
                  game.f.B().a((byte)23);
               }
               break;
            case 30:
               this.d.aR();
               break;
            case 31:
               this.ag();
               break;
            case 32:
               this.d.a((byte)3, (byte)2);
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
            case 103:
            default:
               break;
            case 100:
            case 101:
            case 102:
            case 104:
               this.d.aO();
         }

         if (this.a == 0 && !this.Z.F() && S == 0 && R != null && R.size() > 0) {
            if (this.af >= R.size()) {
               R.removeAllElements();
               this.af = 0;
               S = 1;
            } else if (this.d.aA()) {
               int[] var6 = (int[])R.elementAt(this.af);
               String var2 = "Tiến hóa";
               if (a.b.c.c[0][a.b.c.a((byte)0, (short)var6[0], (byte)19)][2] == 3) {
                  var2 = "Dị hoá";
               }

               if (!U && V[0] != -1) {
                  if (this.af == R.size() - 1) {
                     this.d.H();
                     this.d.a("Nhấn #2" + c(var6[1]) + "#0 đạt tới có thể" + var2 + " điều kiện", "Nhấn nút 5 tiếp tục");
                  } else {
                     this.d.b("#2" + c(var6[1]) + "#0 có thể" + var2);
                  }
               } else {
                  this.d.b("#2" + c(var6[1]) + "#0 có thể" + var2);
               }

               this.af++;
            }
         }

         this.c.c();
         if (x != null) {
            x.d();
         }
      }
   }

   public static void b(Graphics var0) {
      if (w == null) {
         var0.setColor(l());
         var0.fillRect(0, 0, g(), h());
      } else {
         int var1 = w.getWidth();

         for (int var2 = 0; var2 < a.a.g() / var1; var2++) {
            var0.drawImage(w, var2 * var1, 0, 20);
         }
      }
   }

   private void o(int var1) {
      switch (var1) {
         case 0:
            if (this.aI >= 0) {
               this.aN[var1].d();
               return;
            }

            this.aN[var1].c();
            return;
         case 1:
            if (this.aI + (this.aT[(this.aD << 1) + 1] << 3) * 5 <= h()) {
               this.aN[var1].d();
               return;
            }

            this.aN[var1].c();
            return;
         case 2:
            if (this.aH >= 0) {
               this.aN[var1].d();
               return;
            }

            this.aN[var1].c();
            return;
         case 3:
            if (this.aH + (this.aT[this.aD << 1] << 4) * 5 <= g()) {
               this.aN[var1].d();
               return;
            } else {
               this.aN[var1].c();
            }
      }
   }

   public final void a(Graphics var1) {
      if (this.a == 4) {
         Graphics var14 = var1;
         l var13 = this;
         var14.drawImage(game.a.B().m, 0, 0, 20);
         int[] var19;
         int var11 = (var19 = var13.aS[var13.aD]).length;
         int var6 = var13.aG * 7;

         for (byte var15 = 0; var15 < var11; var15 += 7) {
            if (var13.p == var19[var15 + 2] && var13.q == var19[var15 + 3]) {
               var14.setColor(188, 122, 255);
            } else {
               var14.setColor(var13.aR[var13.aD << 1]);
            }

            var14.fillRoundRect(var13.aH + (var19[var15] << 4), var13.aI + (var19[var15 + 1] << 3), var19[var15 + 5] << 4, var19[var15 + 6] << 3, 12, 12);
            var14.setColor(0);
            var14.drawRoundRect(var13.aH + (var19[var15] << 4), var13.aI + (var19[var15 + 1] << 3), var19[var15 + 5] << 4, var19[var15 + 6] << 3, 12, 12);
            if (var15 == var6) {
               var13.aM.b(var13.aH + (var19[var15] << 4) + 16 * var19[var15 + 5] / 2, var13.aI + (var19[var15 + 1] << 3) + 8 * var19[var15 + 6] / 2 + 20);
               var13.aM.a(var14, 0, 0);
            }

            String[] var23;
            int var8 = (var23 = game.n.a(a.a.c(var19[var15 + 4]), var19[var15 + 5] << 4)).length;

            for (int var9 = 0; var9 < var8; var9++) {
               a.e.a(
                  var14,
                  var23[var9],
                  var13.aR[(var13.aD << 1) + 1],
                  var13.aH + (var19[var15] << 4) + 16 * var19[var15 + 5] / 2,
                  var13.aI + (var19[var15 + 1] << 3) + 8 * var19[var15 + 6] / 2 + (var9 - var8 / 2) * (game.n.a + 1),
                  17,
                  17,
                  var13.c.b,
                  -1
               );
            }
         }

         var14.setColor(65280);
         int var12 = var13.o.size();
         a.b.d var27 = a.b.d.a();

         for (int var28 = 0; var28 < var12; var28++) {
            h var10;
            int var16 = ((var10 = (h)var13.o.elementAt(var28)).j * var19[var6 + 5] << 4) / var27.c + (var19[var6] << 4) + var13.aH;
            int var24 = (var10.k * var19[var6 + 6] << 3) / var27.d + (var19[var6 + 1] << 3) + var13.aI;
            if (var10.i() != 0 && ((h)var13.o.elementAt(var28)).i() != 1) {
               var14.fillRect(var16, var24 - 5, 3, 9);
            } else {
               var14.fillRect(var16, var24 - 2, 9, 3);
            }
         }

         if (var13.aE != -1) {
            int var17 = (var13.aP[(var13.aE << 2) + 2] * var19[var6 + 5] << 4) / var27.c + (var19[var6] << 4) + var13.aH;
            int var25 = (var13.aP[(var13.aE << 2) + 3] * var19[var6 + 6] << 3) / var27.d + (var19[var6 + 1] << 3) + var13.aI;
            var14.setColor(16711680);
            var14.fillRect(var17, var25, 6, 6);
         }

         if (var13.aF != -1) {
            int var18 = (var13.aQ[(var13.aF << 2) + 2] * var19[var6 + 5] << 4) / var27.c + (var19[var6] << 4) + var13.aH;
            int var26 = (var13.aQ[(var13.aF << 2) + 3] * var19[var6 + 6] << 3) / var27.d + (var19[var6 + 1] << 3) + var13.aI;
            var14.setColor(2758133);
            var14.fillRect(var18, var26, 6, 6);
         }

         for (int var29 = 0; var29 < var13.aN.length; var29++) {
            var13.aN[var29].a(var14, 0, 0);
         }

         var14.setColor(1862801);
         var14.fillRect(0, a.a.h() - 30, a.a.g(), 30);
         var14.setColor(65280);
         var14.fillRect(15, a.a.h() - 22, 16, 16);
         game.n.a(var14, "Cửa ra vào", 35, a.a.h() - 18);
         var14.setColor(2758133);
         var14.fillRect(90, a.a.h() - 22, 16, 16);
         game.n.a(var14, "Bến tàu", 110, a.a.h() - 18);
         var14.setColor(16711680);
         var14.fillRect(150, a.a.h() - 22, 16, 16);
         game.n.a(var14, "Cửa Đạo quán", 168, a.a.h() - 18);
      } else {
         if (this.a == 0 || this.a == 23 || this.d.g) {
            b(var1);
            a.a.f.a().b(var1);
            this.l.a(var1);
            a.a.f.a().c(var1);
            if (this.d.g) {
               this.d.g = false;
            }
         }

         if (a.a.f.a().h != -1) {
            if (this.ad.q instanceof j) {
               a.a.f var10000 = a.a.f.a();
               a.b.b var7 = this.ad;
               int var10001 = this.ad.j - a.b.d.a().a;
               var7 = this.ad;
               var10000.b(var10001, this.ad.k - a.b.d.a().b - this.at[this.m.u + 1]);
            } else {
               a.a.f var30 = a.a.f.a();
               a.b.b var21 = this.ad;
               int var31 = this.ad.j - a.b.d.a().a;
               var21 = this.ad;
               var30.b(var31, this.ad.k - a.b.d.a().b - 20);
            }

            a.a.f.a().a(var1, 0, 0);
         }

         game.e.b(var1);
         this.c.a(var1);
         if (x != null) {
            x.a(var1, 0, 0);
         }

         Graphics var3 = var1;
         l var2 = this;

         for (int var4 = 0; var4 < var2.m.W.size(); var4++) {
            int[] var5 = (int[])var2.m.W.elementAt(var4);
            a.e.a(var3, "+" + var5[0], 16704699, var5[1] + 12 - var2.k.a, var5[2] - var5[3] - var2.k.b, 17, 17, var2.c.b, 2);
            var3.drawImage(ag, var5[1] - var2.k.a - 6, var5[2] - var5[3] - var2.k.b, 20);
         }

         if (!this.d.j() && !p()) {
            this.Z.a(var1);
         }

         if (this.p == 3 && this.q == 7 && this.a == 0) {
            if (this.Z.A > 0) {
               if (this.ax != null) {
                  var1.drawImage(this.ax[this.Z.A - 1], g() >> 1, h() >> 1, 3);
                  return;
               }
            } else if (game.f.B().l != 0L) {
               var1.setColor(896);
               var1.setFont(n());
               var1.drawString(a(game.f.B().l - game.f.B().k)[0], 10, 40, 20);
            }
         }
      }
   }

   private void af() {
      if (!this.Z.F() && this.m.i() < 5 && !this.d.j() && this.d.J()) {
         if (this.i(4100)) {
            this.m.a((byte)1, (byte)2);
         } else if (this.i(8448)) {
            this.m.a((byte)1, (byte)0);
         } else if (this.i(16400)) {
            this.m.a((byte)1, (byte)3);
         } else if (this.i(32832)) {
            this.m.a((byte)1, (byte)1);
         }

         if (this.g(65568)) {
            if (E != -1) {
               this.m.a((byte)0, this.m.o);
               if (game.e.s) {
                  game.e.t = true;
                  game.e.s = false;
               } else {
                  if (this.n[E].a.a <= 85) {
                     this.n[E].n = this.n[E].o;
                     switch (this.m.o) {
                        case 0:
                           h var18 = this.n[E];
                           byte var9 = 2;
                           var18.o = var9;
                           break;
                        case 1:
                           h var17 = this.n[E];
                           byte var8 = 3;
                           var17.o = var8;
                           break;
                        case 2:
                           h var16 = this.n[E];
                           byte var7 = 0;
                           var16.o = var7;
                           break;
                        case 3:
                           h var10000 = this.n[E];
                           byte var2 = 1;
                           var10000.o = var2;
                     }

                     this.n[E].a((byte)0);
                  }

                  if (this.n[E].a.a == 17) {
                     this.d.d = 0;
                     this.a((byte)27);
                  } else {
                     this.a((byte)23);
                  }
               }

               B().D();
            } else if ((h)this.m.q != null && ((h)this.m.q).u == 3) {
               this.m.w();
            } else {
               this.m.x();
            }
         }

         if (this.h(61780)) {
            this.m.a((byte)0, this.m.o);
         }

         if (this.g(262144)) {
            this.r();
            this.d.b = 0;
            this.a((byte)6);
         } else if (this.g(131072)) {
            this.d.b = 0;
            this.a((byte)13);
         } else if (this.g(1)) {
            l var1 = this;
            boolean var10 = true;

            for (int var3 = 0; var3 < as.length; var3++) {
               if (as[var3] == var1.p) {
                  var10 = false;
                  break;
               }
            }

            if (var10) {
               for (byte var12 = 0; var12 < var1.aS[var1.aD].length / 7; var12++) {
                  if (var1.aS[var1.aD][var12 * 7 + 2] == var1.p && var1.aS[var1.aD][var12 * 7 + 3] == var1.q) {
                     var1.aG = var12;
                     break;
                  }
               }

               var1.aJ = (g() >> 1) - (var1.aS[var1.aD][var1.aG * 7] << 4) - 40;
               var1.aK = (h() >> 1) - (var1.aS[var1.aD][var1.aG * 7 + 1] << 3) - 20;
               var1.aL = true;
               if (var1.aM == null) {
                  var1.aM = new a.a.g();
                  var1.aM.a(0, false);
                  var1.aM.a((byte)3, (byte)-1, false);
                  var1.aM.c();
               }

               if (var1.aN == null) {
                  var1.aN = new a.a.g[4];

                  for (byte var13 = 0; var13 < var1.aN.length; var13++) {
                     var1.aN[var13] = new a.a.g();
                     var1.aN[var13].a(223, false);
                     if (var13 <= 1) {
                        var1.aN[var13].b(g() >> 1, 20 + var13 * (h() - 20));
                     } else {
                        var1.aN[var13].b(10 + var13 % 2 * (g() - 20), h() >> 1);
                     }

                     var1.aN[var13].a(var13, (byte)-1, false);
                     var1.o(var13);
                  }
               }

               game.a.B().m = Image.createImage(a.a.g(), a.a.h());
               Graphics var14 = game.a.B().m.getGraphics();
               var1.m.a((byte)0, var1.m.o);
               var1.l.b(var14);
               var1.a((byte)4);
            } else {
               var1.d.b("Khu này không có bản đồ");
            }
         } else if (this.g(2)) {
            this.d.b = 0;
            this.a((byte)10);
         } else if (this.g(8)) {
            this.d.b = 1;
            this.a((byte)10);
         } else {
            label168:
            if (this.g(512)) {
               l var4 = this;
               if (this.p != 3 || var4.q != 7) {
                  if (var4.m.u >= 0 && var4.Z.x) {
                     if (var4.m.s()) {
                        var4.m.t();
                     }

                     boolean var21 = false;
                     break label168;
                  }

                  if (var4.Z.x) {
                     var4.a((byte)5);
                     boolean var20 = true;
                     break label168;
                  }
               }

               boolean var19 = false;
            }
         }
      }

      this.m.r();

      for (int var5 = 0; var5 < this.n.length; var5++) {
         this.n[var5].q();
      }

      if (this.y != null && this.y.j()) {
         this.y.a(this.ar.a, this.y.a);
      }

      this.m.p = this.m.o;
      this.l.b();
      this.M();
      if (Q == 1 && i) {
         this.a((byte)25);
      }

      if (!this.Z.F() && !this.d.J() && !U && V[0] != -1 && this.g(65568)) {
         f = 4;
         U = true;
         this.d.c = 0;
         this.a((byte)7);
         this.d.I();
      }

      if (!this.d.j() && B == 0 && this.O()) {
         this.d.b("Có thể tiến hành sản xuất trứng sủng vật");
         B = 1;
      }

      this.Z.C();
      this.d.e();
      l var6 = this;

      for (int var11 = 0; var11 < var6.m.W.size(); var11++) {
         int[] var15;
         (var15 = (int[])var6.m.W.elementAt(var11))[3] += 5;
         if (var15[3] > 30) {
            var6.m.W.removeElementAt(var11);
            var11--;
         }
      }

      if (!this.d.j()) {
         this.Z.a();
         this.q();
      }
   }

   private void ag() {
      if (this.d.d(D, C) && !this.d.j() && this.g(196640)) {
         if (a.e.b < a.e.b()) {
            a.e.c();
            this.d.b(a.e.b);
         } else {
            this.d.aF();
            if (this.n[E].a.a <= 85) {
               byte var2 = this.n[E].n;
               this.n[E].o = var2;
            }

            this.n[E].a((byte)0);
            this.m.a((byte)0, this.m.o);
            this.d.f = 1;
            if (this.aZ) {
               this.aV[this.aX] = true;
               if (this.aX < this.aW.length - 1) {
                  this.m.v(1);
                  this.d.b("Đạt được 1 huy hiệu");
               } else if (this.m.b((byte)7, (byte)0) == 0) {
                  this.d.b("Đạt được hoàng kim huy hiệu");
                  this.m.b((byte)7, (byte)0, (byte)2);
                  game.e.G = (byte)(game.e.E.length / 2);
               }
            }
         }
      }

      this.d.f();
      if (this.d.f == 1 && this.d.aA()) {
         this.d.d = 0;
         this.a((byte)27);
      }

      this.l.b();
   }

   private boolean a(int[] var1) {
      int var2 = -1;
      if (var1[2] != -1) {
         var2 = a.e.b(var1[2], var1[3]);
      }

      if (!this.C()) {
         return false;
      }

      int var3 = a.e.b(am[v[this.p] + this.q][3], am[v[this.p] + this.q][4]);
      this.m.a((byte)a.b.c.c[0][var1[0]][1], var1[0], (byte)1);
      game.a.B().a(new int[][]{{var1[0], var3, var2}});
      return true;
   }

   public final void m(int var1) {
      int var2 = 0;

      while (true) {
         int var4 = this.q;
         int var3 = this.p;
         if (var2 >= (am[v[var3] + var4].length - 5) / 4) {
            return;
         }

         var4 = this.q;
         var3 = this.p;
         if (var1 == am[v[var3] + var4][5 + (var2 << 2) + 4]) {
            int[] var5 = new int[4];
            var4 = this.q;
            var3 = this.p;
            System.arraycopy(am[v[var3] + var4], 5 + (var2 << 2), var5, 0, var5.length);
            this.a(var5);
            this.ah();
            return;
         }

         var2++;
      }
   }

   public final void e(boolean var1) {
      if (this.aU != var1) {
         if (this.C()) {
            this.aU = var1;
            int var3 = 0;

            while (true) {
               int var4 = this.q;
               int var2 = this.p;
               if (var3 >= (am[v[var2] + var4].length - 5) / 4) {
                  return;
               }

               var4 = this.q;
               var2 = this.p;
               short var6 = am[v[var2] + var4][5 + (var3 << 2) + 4];
               if (var1) {
                  this.n[var6].c();
               } else {
                  this.n[var6].d();
               }

               var3++;
            }
         }
      }
   }

   public final void M() {
      if (this.m.E()) {
         boolean var10000;
         label46: {
            l var1 = this;
            byte var2 = a.b.d.a().a(0, game.j.p().j, game.j.p().k);
            int[] var3 = null;
            ab = var2;
            switch (var2) {
               case 0:
                  if (an.size() <= 0) {
                     var10000 = false;
                     break label46;
                  }

                  var3 = (int[])an.elementAt(a.e.a(an.size()));
                  break;
               case 1:
                  if (ao.size() <= 0) {
                     var10000 = false;
                     break label46;
                  }

                  var3 = (int[])ao.elementAt(a.e.a(ao.size()));
                  break;
               case 2:
                  if (ap.size() <= 0) {
                     var10000 = false;
                     break label46;
                  }

                  var3 = (int[])ap.elementAt(a.e.a(ap.size()));
                  break;
               case 3:
                  var10000 = false;
                  break label46;
               case 4:
                  if (aq.size() <= 0) {
                     var10000 = false;
                     break label46;
                  }

                  var3 = (int[])aq.elementAt(a.e.a(aq.size()));
            }

            var10000 = var1.a(var3);
         }

         if (!var10000) {
            this.m.w = this.m.D();
            return;
         }

         if (this.p == 3 && this.q == 7) {
            game.e.v = false;
         } else {
            game.e.v = true;
         }

         this.ah();
      }
   }

   public final void N() {
      game.a.B().m = Image.createImage(a.a.g(), a.a.h());
      Graphics var1 = game.a.B().m.getGraphics();
      this.l.b(var1);
   }

   private void ah() {
      game.a.B().k = 0;
      game.a.B().l = 0;
      this.N();
      this.m.a((byte)0, this.m.o);
      this.m.w = this.m.D();
      game.f.B().a((byte)12);
      this.W.a(4, 1);
   }

   public static int e(int var0, int var1) {
      return v[var0] + var1;
   }

   public final void a(int var1, int var2, byte var3, boolean var4) {
      int var6 = this.q;
      int var5 = this.p;
      if (ai[v[var5] + var6] != null) {
         var6 = this.q;
         var5 = this.p;
         if (ai[v[var5] + var6][var1] != null) {
            var6 = this.q;
            var5 = this.p;
            ak[v[var5] + var6][0] = var4;
            var6 = this.q;
            var5 = this.p;
            ai[v[var5] + var6][var1][var2] = var3;
         }
      }
   }

   public final void a(int var1, int var2, int var3) {
      int var5 = this.q;
      int var4 = this.p;
      if (aj[v[var4] + var5] != null) {
         var5 = this.q;
         var4 = this.p;
         if (aj[v[var4] + var5][var1] != null) {
            var5 = this.q;
            var4 = this.p;
            aj[v[var4] + var5][var1][var2] = (short)var3;
         }
      }
   }

   public final boolean n(int var1) {
      for (int var2 = 0; var2 < this.au.length / 4; var2++) {
         if (this.au[var2 << 2] == this.p
            && this.au[(var2 << 2) + 1] == this.q
            && var1 == this.au[(var2 << 2) + 2]
            && this.m.C[this.au[(var2 << 2) + 3]][0] == 2) {
            return true;
         }
      }

      return false;
   }

   public final boolean O() {
      return this.m.J == 0 && A >= 10 || this.m.J > 0 && A >= 30;
   }

   private void ai() {
      this.aX = (byte)this.aV.length;

      for (int var1 = 0; var1 < this.aV.length; var1++) {
         if (!this.aV[var1]) {
            this.aX = (byte)var1;
            break;
         }
      }

      boolean var3 = false;

      for (int var2 = this.aW.length - 1; var2 >= 0; var2--) {
         if (this.m.G >= this.aW[var2]) {
            this.aY = (byte)var2;
            var3 = true;
            break;
         }
      }

      if (!var3) {
         this.aY = -1;
      }
   }

   public final void q() {
      switch (f) {
         case 1:
            if (g == 0) {
               b(0, 1);
               if (i) {
                  b(1, 1);
               } else {
                  b(1, 0);
               }

               g++;
               this.a((byte)6);
               return;
            }

            if (g == 1) {
               g++;
               this.d.c("Hãy lựa chọn #2Sủng vật");
               return;
            }

            if (g == 3) {
               b(1, 0);
               String var3 = c(a.b.c.c[0][this.m.A[a.a.d(1)].r()][0]);
               g++;
               this.d.c("Hãy lựa chọn #2" + var3);
               return;
            }

            if (g == 4) {
               if (this.d.aB() && a.a.a(this.d.b, 0)) {
                  g++;
                  this.d.c("Hãy nhấn #2nút 5");
                  return;
               }
            } else {
               if (g == 6) {
                  g++;
                  this.d.c("Hãy lựa chọn #2Vật phẩm trang sức");
                  return;
               }

               if (g == 8) {
                  b(1, 0);
                  g++;
                  this.d.c("Nhấn #2nút 5#1 trang thượng vật phẩm trang sức");
                  return;
               }

               if (g == 10) {
                  this.d.c("Nhấn #2nút mềm phải#0 để quay lại");
                  b(1, -1);
                  b(0, 2);
                  g++;
                  return;
               }
            }
         case 2:
         case 5:
         default:
            break;
         case 3:
            if (g == 0) {
               g++;
               b(1, 0);
               b(0, 1);
               this.a((byte)1);
               return;
            }

            if (g == 1) {
               if (a(this.d.b, 0)) {
                  g++;
                  this.d.c("Hãy nhấn vào mục #2Mua sắm");
                  return;
               }
            } else {
               if (g == 3) {
                  g++;
                  this.d.c("Trước tiên hãy mua #2Hồng sắc ốc biển#1");
                  return;
               }

               if (g == 4) {
                  if (this.d.aB()) {
                     b(1, 1);
                     g++;
                     return;
                  }
               } else if (g == 5) {
                  if (a(this.d.b, 0)) {
                     g++;
                     this.d.c("Nhấn #2nút 5#1 mua sắm");
                     return;
                  }
               } else if (g == 7) {
                  this.d.c("Hãy nhấn #2nút mềm phải#1 để quay lại");
                  b(1, -1);
                  b(0, 2);
                  g++;
                  return;
               }
            }
            break;
         case 4:
            if (g == 0) {
               b(0, 1);

               for (int var1 = 0; var1 < this.m.B; var1++) {
                  if (this.m.A[var1].t() == V[0] && this.m.A[var1].r() == V[1]) {
                     b(1, var1);
                     break;
                  }
               }

               g++;
               String var2 = c(a.b.c.a((byte)0, (short)this.m.A[a.a.d(1)].r(), (byte)0));
               this.d.c("Hãy lựa chọn #2" + var2 + "#0 tiến hành tiến hóa");
               return;
            }

            if (g == 1) {
               if (a(this.d.b, 0) && this.d.aB()) {
                  g++;
                  this.d.c("Hãy nhấn #2nút 5#0 để tiếp tục");
                  return;
               }
            } else if (g == 3) {
               if (a(this.d.c, 0)) {
                  g++;
                  this.d.c("Nhấn #2nút 5#0 để vào mục Tiến hóa");
                  return;
               }
            } else if (g == 5) {
               g++;
               this.d.c("Nhấn #2nút mềm trái#0 để Tiến hóa");
               return;
            }
            break;
         case 6:
            if (g == 0) {
               g++;
               b(0, 1);
               if (i) {
                  b(1, 2);
               } else {
                  b(1, 1);
               }

               this.a((byte)6);
               return;
            }

            if (g == 1) {
               g++;
               this.d.c("Hãy lựa chọn #2Ba lô#0");
               return;
            }

            if (g == 2) {
               if (this.d.aB() && a(this.d.b, 0)) {
                  this.d.c("Nhấn #2nút mềm trái#0 vào Tuyển hạng");
                  g++;
                  return;
               }
            } else {
               if (g == 4) {
                  g++;
                  this.d.c("Hãy sử dụng #2Gia tốc dược#0");
                  return;
               }

               if (g == 5) {
                  if (this.d.aB() && a(this.d.h, 0)) {
                     g++;
                     this.d.c("Nhấn #2nút mềm trái#0 sử dụng");
                     return;
                  }
               } else {
                  if (g == 7) {
                     g++;
                     b(0, 3);
                     b(2, 1);
                     b(1, 3);
                     this.d.c("Hãy lựa chọn #2Đặc thù đạo cụ#0 ấp trứng trứng sủng vật");
                     return;
                  }

                  if (g == 9) {
                     if (this.d.aB() && a(this.d.h, 0)) {
                        b(0, 1);
                        this.d.c("Nhấn #2nút mềm trái#0 để Ấp trứng");
                        g++;
                        return;
                     }
                  } else if (g == 11) {
                     g++;
                     b(0, 2);
                     b(1, -1);
                     this.d.c("Nhấn #2nút mềm phải#0 để quay lại");
                  }
               }
            }
      }
   }

   public final void r() {
      switch (f) {
         case 1:
            if (g == 2 || g == 7) {
               g++;
               return;
            }

            if (g == 5) {
               b(1, 2);
               g++;
               return;
            }

            if (g == 9) {
               g++;
               int var2 = this.q;
               int var3 = this.p;
               this.Z.n[v[var3] + var2][this.Z.E()] = 3;
               if (this.Z.l != null) {
                  this.Z.l[this.Z.E()].a((byte)3);
                  return;
               }
            }
         case 2:
         case 5:
         default:
            break;
         case 3:
            if (g == 6 || g == 2) {
               g++;
               return;
            }
            break;
         case 4:
            if (g == 2) {
               b(1, 5);
               g++;
               return;
            }

            if (g == 4) {
               g++;
               return;
            }

            if (g == 6) {
               this.d.c("Nhấn #2nút mềm phải#0 để quay lại");
               b(1, -1);
               b(0, 2);
               g++;
               return;
            }
            break;
         case 6:
            if (g == 3) {
               for (int var1 = 0; var1 < this.m.K.size() + this.m.L.size(); var1++) {
                  if (var1 >= this.m.L.size()) {
                     if (this.m.K.size() <= 0) {
                        break;
                     }

                     if (((int[])this.m.K.elementAt(var1 - this.m.L.size()))[0] == 14) {
                        b(1, var1);
                        break;
                     }
                  }
               }

               g++;
               return;
            }

            if (g == 6 || g == 10) {
               g++;
               return;
            }

            if (g == 8 && a(this.d.b, 1)) {
               this.d.c("Hãy lựa chọn #2Trứng sủng vật#0 để ấp trứng");
               b(2, 0);
               b(1, 0);
               g++;
            }
      }
   }

   protected static String[] a(long var0) {
      String[] var2;
      (var2 = new String[2])[1] = var2[0] = "0'00\"000";
      long var3 = var0 % 1000L;
      long var11;
      long var5 = (var11 = var0 / 1000L) % 60L;
      long var7 = (var0 = var11 / 60L) % 60L;
      long var9 = var0 / 60L;
      String var15;
      if (var3 < 10L) {
         var15 = "00" + var3;
      } else if (var3 < 100L) {
         var15 = "0" + var3;
      } else {
         var15 = "" + var3;
      }

      String var4;
      if (var5 < 10L) {
         var4 = "0" + var5 + "\"";
      } else {
         var4 = var5 + "\"";
      }

      String var13 = var0 + "'";
      var2[0] = var13 + var4 + var15;
      String var1 = var9 + "'";
      String var14 = var7 + "\"";
      if (var5 < 10L) {
         var4 = "0" + var5;
      } else {
         var4 = "" + var5;
      }

      var2[1] = var1 + var14 + var4;
      return var2;
   }
}
