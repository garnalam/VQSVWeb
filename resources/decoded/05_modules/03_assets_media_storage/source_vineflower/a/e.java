package a;

import game.n;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class e {
   private static int c = 5;
   private static int d = 300;
   private static int[] e = null;
   private static Random f;
   private static int[][] g = new int[20][2];
   private static int[] h;
   private static int[] i = new int[]{1862801, 15673612, 12067264, 11689977, 16359727, 16711680, 255};
   private static char[] j = new char[]{'，', '。', '？', '！', '：', '；', '’', '”', '、'};
   private static int k = 0;
   public static String[] a;
   private static int l = 0;
   public static int b = 1;
   private static int m = 0;

   public static short[] a(short[] var0, short[] var1) {
      int var2 = 0;
      if (var0 != null) {
         var2 = var0.length;
      }

      short[] var3 = new short[var2 + var1.length];
      if (var0 != null) {
         System.arraycopy(var0, 0, var3, 0, var0.length);
      }

      System.arraycopy(var1, 0, var3, var2, var1.length);
      return var3;
   }

   public static void a(byte[] var0, String var1, int var2) {
      try {
         InputStream var4;
         if (var1.substring(0, 1).endsWith("/")) {
            new Object().getClass();
            var4 = b.a(var1);
         } else {
            new Object().getClass();
            var4 = b.a("/" + var1);
         }

         DataInputStream var5;
         (var5 = new DataInputStream(var4)).skip(0L);
         var5.read(var0, 0, var0.length);
         var5.close();
      } catch (Exception var3) {
         System.out.println("GameInf err at getStream()  :  " + var3);
      }
   }

   public static short[] a(byte[] var0, int[] var1) {
      short var2 = f(var0, var1);
      short var3 = f(var0, var1);
      if (var2 == 0) {
         return null;
      }

      short[] var6 = new short[var2 * var3];

      for (int var7 = 0; var7 < var6.length; var7++) {
         byte var4 = var0[var1[0]];
         var1[0]++;
         byte var5 = var0[var1[0]];
         var1[0]++;
         var6[var7] = (short)(var4 << 8 | var5 & 0xFF);
      }

      return var6;
   }

   public static short[][] b(byte[] var0, int[] var1) {
      short var3 = f(var0, var1);
      short var4 = f(var0, var1);
      if (var3 == 0) {
         return null;
      }

      short[][] var2 = new short[var3][];

      for (int var5 = 0; var5 < var3; var5++) {
         short var6 = f(var0, var1);
         var2[var5] = new short[var6 * var4];

         for (int var9 = 0; var9 < var2[var5].length; var9++) {
            byte var7 = var0[var1[0]];
            var1[0]++;
            byte var8 = var0[var1[0]];
            var1[0]++;
            var2[var5][var9] = (short)(var7 << 8 | var8 & 0xFF);
         }
      }

      return var2;
   }

   private static short f(byte[] var0, int[] var1) {
      return (short)((var0[var1[0]++] & 255) << 8 | var0[var1[0]++] & 0xFF);
   }

   public static InputStream a(String var0) {
      try {
         "".getClass();
         return b.a(var0);
      } catch (Exception var1) {
         return null;
      }
   }

   public static short[][] a(InputStream var0) {
      short[][] var1 = null;
      if (var0 == null) {
         return null;
      }

      try {
         DataInputStream var2;
         short var5;
         if ((var5 = (var2 = new DataInputStream(var0)).readShort()) >= 0) {
            var1 = new short[var5][];
         }

         for (int var3 = 0; var3 < var1.length; var3++) {
            short var6 = var2.readShort();
            var1[var3] = new short[var6];

            for (int var7 = 0; var7 < var1[var3].length; var7++) {
               var1[var3][var7] = var2.readShort();
            }
         }
      } catch (Exception var4) {
      }

      return var1;
   }

   public static byte[][] b(InputStream var0) {
      byte[][] var1 = null;
      if (var0 == null) {
         return null;
      }

      try {
         DataInputStream var2;
         short var5;
         if ((var5 = (var2 = new DataInputStream(var0)).readShort()) >= 0) {
            var1 = new byte[var5][];
         }

         for (int var3 = 0; var3 < var1.length; var3++) {
            short var6 = var2.readShort();
            var1[var3] = new byte[var6];

            for (int var7 = 0; var7 < var1[var3].length; var7++) {
               var1[var3][var7] = var2.readByte();
            }
         }
      } catch (Exception var4) {
      }

      return var1;
   }

   public static String[][] c(InputStream var0) {
      String[][] var1 = null;
      StringBuffer var2 = new StringBuffer();

      try {
         short var3;
         if ((var3 = (var0 = new DataInputStream(var0)).readShort()) == 0) {
            return null;
         }

         if (var3 > 0) {
            var1 = new String[var3][];
         }

         for (int var4 = 0; var4 < var1.length; var4++) {
            var3 = var0.readShort();
            var1[var4] = new String[var3];

            for (int var10 = 0; var10 < var1[var4].length; var10++) {
               int var5;
               if ((var5 = var0.readUnsignedByte()) == 255) {
                  var5 = var0.readShort();
               }

               for (int var6 = 0; var6 < var5; var6++) {
                  var2.append((char)var0.readShort());
               }

               var1[var4][var10] = var2.toString();
               var2 = new StringBuffer();
            }
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      return var1;
   }

   public static int a(int var0, int var1, int var2, int var3) {
      var0 = (var0 - var2) * (var0 - var2) + (var1 - var3) * (var1 - var3);
      var1 = 0;

      for (int var6 = 1073741824; var6 > 0; var6 >>= 2) {
         if (var0 >= var1 + var6) {
            var0 -= var1 + var6;
            var1 = (var1 >> 1) + var6;
         } else {
            var1 >>= 1;
         }
      }

      return var1;
   }

   public static int a(int var0, int var1) {
      if (e == null) {
         e = new int[d / c + 1];
         int var2 = c * c;

         for (int var3 = e.length - 1; var3 >= 0; var3--) {
            e[var3] = var3 * var3 * var2;
         }
      }

      if (var0 < 0) {
         return -1;
      }

      int var4;
      if (var0 <= e[30]) {
         if (var0 <= e[15]) {
            if (var0 <= e[5]) {
               var4 = 1;

               while (var4 <= 5 && var0 > e[var4]) {
                  var4++;
               }
            } else if (var0 <= e[10]) {
               var4 = 6;

               while (var4 <= 10 && var0 > e[var4]) {
                  var4++;
               }
            } else {
               var4 = 11;

               while (var4 <= 15 && var0 > e[var4]) {
                  var4++;
               }
            }
         } else if (var0 <= e[20]) {
            var4 = 16;

            while (var4 <= 20 && var0 > e[var4]) {
               var4++;
            }
         } else if (var0 <= e[25]) {
            var4 = 21;

            while (var4 <= 25 && var0 > e[var4]) {
               var4++;
            }
         } else {
            var4 = 26;

            while (var4 <= 30 && var0 > e[var4]) {
               var4++;
            }
         }
      } else if (var0 <= e[45]) {
         if (var0 <= e[35]) {
            var4 = 31;

            while (var4 <= 35 && var0 > e[var4]) {
               var4++;
            }
         } else if (var0 <= e[40]) {
            var4 = 36;

            while (var4 <= 40 && var0 > e[var4]) {
               var4++;
            }
         } else {
            var4 = 41;

            while (var4 <= 45 && var0 > e[var4]) {
               var4++;
            }
         }
      } else if (var0 <= e[50]) {
         var4 = 46;

         while (var4 <= 50 && var0 > e[var4]) {
            var4++;
         }
      } else if (var0 <= e[55]) {
         var4 = 51;

         while (var4 <= 55 && var0 > e[var4]) {
            var4++;
         }
      } else {
         var4 = 56;

         while (var4 <= 60 && var0 > e[var4]) {
            var4++;
         }
      }

      for (int var6 = (var4 = var4 * c) - c + 1; var6 <= var4; var6++) {
         if (var6 * var6 >= var0) {
            if (var1 == 0) {
               return var6;
            }

            if (var1 == 1) {
               return var6 - 1;
            }
         }
      }

      return -1;
   }

   public static int a(int var0) {
      if (f == null) {
         f = new Random(System.currentTimeMillis());
      }

      return f.nextInt(var0);
   }

   public static int b(int var0) {
      if (f == null) {
         f = new Random(System.currentTimeMillis());
      }

      return -2 + f.nextInt(4);
   }

   public static int b(int var0, int var1) {
      if (f == null) {
         f = new Random(System.currentTimeMillis());
      }

      return (f.nextInt() >>> 1) % (var1 - var0 + 1) + var0;
   }

   public static int a(int[] var0, int var1) {
      int var2 = 0;

      while (var2 < var0.length && var1 < var0[var2]) {
         var2++;
      }

      return var2;
   }

   public static boolean a(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if (var8 % 2 != 0) {
         var8 = var2;
         var2 = var3;
         var3 = var8;
      }

      return var0 + var2 >= var4 && var4 + var6 >= var0 && var1 + var3 > var5 && var5 + var7 > var1;
   }

   public static boolean a(int var0, int var1, int var2, int var3, int var4, int var5) {
      return var0 >= var2 && var0 <= var2 + var4 && var1 >= var3 && var1 <= var3 + 40;
   }

   public static boolean a(int var0, int var1, int var2, int var3, short[] var4, short[] var5) {
      return var0 + var4[0] + var4[2] >= var2 + var5[0]
         && var0 + var4[0] <= var2 + var5[0] + var5[2]
         && var1 + var4[1] <= var3 + var5[1] + var5[3]
         && var1 + var4[1] + var4[3] >= var3 + var5[1];
   }

   public static boolean a(int var0, int var1, int var2, int var3, int var4, int var5, short[] var6) {
      return var0 + var2 >= var4 + var6[0] && var0 <= var4 + var6[0] + var6[2] && var1 <= var5 + var6[1] + var6[3] && var1 + var3 >= var5 + var6[1];
   }

   public static boolean a(int var0, int var1, int var2, int var3, short[] var4) {
      return var0 >= var2 + var4[0] && var0 <= var2 + var4[0] + var4[2] && var1 <= var3 + var4[1] + var4[3] && var1 >= var3 + var4[1];
   }

   public static Image a(String var0, String var1) {
      try {
         return Image.createImage(var0 + var1 + ".png");
      } catch (Exception var3) {
         a.a.a.a(var3, var0 + var1 + ".png error!!");
         return null;
      }
   }

   public static Image b(String var0, String var1) {
      byte[] var2;
      return Image.createImage(var2 = g(var0 + var1 + ".mid"), 0, var2.length);
   }

   private static byte[] f(String var0) {
      byte[] var1 = null;

      try {
         int var2 = 0;
         int var4 = 0;
         "".getClass();
         InputStream var5 = b.a(var0);
         DataInputStream var6 = new DataInputStream(var5);
         ByteArrayOutputStream var7;
         (var7 = new ByteArrayOutputStream()).write(a(-1991225785L, 4));
         var7.write(a(218765834L, 4));
         var7.write(a(13L, 4));
         var7.write(a(1229472850L, 4));
         var7.write(a((long)var6.readInt(), 4));
         var7.write(a((long)var6.readInt(), 4));
         var7.write(var6.readByte());
         byte var10 = var6.readByte();
         g = new int[20][2];
         var7.write(var10);
         var7.write(a(0L, 3));
         var7.write(a(0L, 4));
         g[0][0] = 8;
         g[0][1] = 13;
         int var3 = 8 + g[0][1] + 12;
         var4++;
         if (var10 != 3) {
            if (var10 == 6) {
               var2 = var6.readInt();
            }
         } else {
            var2 = var6.readInt();
            var7.write(a((long)var2, 4));
            var7.write(a(1347179589L, 4));
            byte[] var11 = new byte[var2];

            for (int var8 = 0; var8 < var11.length; var8++) {
               var11[var8] = (byte)var6.read();
            }

            var7.write(var11);
            var7.write(a(0L, 4));
            g[1][0] = var3;
            g[1][1] = var2;
            var3 += g[1][1] + 12;
            var4++;
            if ((var2 = var6.readInt()) != 1951551059) {
               g[2][0] = var3;
               g[2][1] = var2;
               var4++;
            } else {
               int var12;
               if ((var12 = var6.read()) == 0) {
                  var12 = 256;
               }

               var7.write(a((long)var12, 4));
               var7.write(a(1951551059L, 4));
               int var24 = var6.read();

               for (int var16 = 0; var16 < var12; var16++) {
                  if (var16 == var24) {
                     var7.write(0);
                  } else {
                     var7.write(255);
                  }
               }

               var7.write(a(0L, 4));
               g[2][0] = var3;
               g[2][1] = var12;
               var3 += g[2][1] + 12;
               var4++;
               var2 = var6.readInt();
            }
         }

         var7.write(a((long)var2, 4));
         var7.write(a(1229209940L, 4));
         byte[] var13 = new byte[var2];

         for (int var25 = 0; var25 < var13.length; var25++) {
            var13[var25] = (byte)var6.read();
         }

         var7.write(var13);
         var7.write(a(0L, 4));
         g[var4][0] = var3;
         g[var4][1] = var2;
         var4++;
         var7.write(a(0L, 4));
         var7.write(a(1229278788L, 4));
         var7.write(a(-1371381630L, 4));
         var1 = var7.toByteArray();
         var5.close();
         var7.close();

         for (int var26 = 0; var26 < var4; var26++) {
            int var10001 = g[var26][0];
            var3 = g[var26][1];
            var2 = var10001;
            byte[] var14 = var1;
            var10001 = var2 + 4;
            int var23 = var3 + 4;
            int var22 = ~a(var1, var10001, var23);
            var14[var2 + 8 + var3] = (byte)(var22 >> 24);
            var14[var2 + 8 + var3 + 1] = (byte)(var22 >> 16);
            var14[var2 + 8 + var3 + 2] = (byte)(var22 >> 8);
            var14[var2 + 8 + var3 + 3] = (byte)var22;
         }
      } catch (Exception var9) {
      }

      return var1;
   }

   private static byte[] a(long var0, int var2) {
      byte[] var3 = new byte[var2];
      var2--;

      for (int var4 = 0; var2 >= 0; var4++) {
         var3[var4] = (byte)(var0 >> (var2 << 3) & 255L);
         var2--;
      }

      return var3;
   }

   private static int a(byte[] var0, int var1, int var2) {
      int var3 = -1;
      if (h == null) {
         h = new int[256];

         for (int var5 = 0; var5 < 256; var5++) {
            int var4 = var5;

            for (int var6 = 0; var6 < 8; var6++) {
               if ((var4 & 1) == 1) {
                  var4 = -306674912 ^ var4 >>> 1;
               } else {
                  var4 >>>= 1;
               }
            }

            h[var5] = var4;
         }
      }

      for (int var7 = var1; var7 < var2 + var1; var7++) {
         var3 = h[(var3 ^ var0[var7]) & 0xFF] ^ var3 >>> 8;
      }

      return var3;
   }

   public static int[] a(Image var0) {
      int var1 = var0.getWidth();
      int var2 = var0.getHeight();
      int[] var3 = new int[var1 * var2];
      var0.getRGB(var3, 0, var1, 0, 0, var1, var2);
      return var3;
   }

   public static Image a(int[] var0, int var1, int var2, boolean var3) {
      return Image.createRGBImage(var0, var1, var2, true);
   }

   public static boolean a() {
      return false;
   }

   public static int a(int[] var0) {
      int var1 = 0;

      for (int var2 = 0; var2 < var0.length; var2++) {
         if (var0[var2] == -1) {
            var1 = var2;
            break;
         }
      }

      return var1;
   }

   public static c.f a(c.f var0, int var1) {
      if (var0.b() == var1) {
         return var0;
      }

      for (int var2 = 0; var2 < var0.h().length && var0.h()[var2] != null; var2++) {
         if (var0.h()[var2].j() == 0) {
            c.f var3;
            if ((var3 = a((c.b)var0.h()[var2], var1)) != null) {
               return var3;
            }
         } else if (var0.h()[var2].b() == var1) {
            return var0.h()[var2];
         }
      }

      return null;
   }

   public static int[] c(int var0) {
      int[] var1 = new int[var0];

      for (int var2 = 0; var2 < var0; var2++) {
         var1[var2] = -1;
      }

      return var1;
   }

   public static void a(int[] var0, int var1, int var2) {
      if (0 < var0.length) {
         var1 = 0;

         for (int var3 = 0; var3 < var0.length; var3++) {
            if (var0[var3] == -1) {
               var1 = var3;
               break;
            }
         }

         for (int var5 = var1 + 0 - 1; var5 >= 0; var5--) {
            if (var5 + 0 + 1 < var0.length) {
               var0[var5 + 1] = var0[var5];
            }
         }

         var0[0] = var2;
      }
   }

   public static void b(byte[] var0, String var1, int var2) {
      try {
         var2 = 0;

         for (int var3 = 0; var3 < var1.length(); var3++) {
            if (var1.charAt(var3) != '/') {
               var2 = var3;
               break;
            }
         }

         String var8 = "/" + var1.substring(var2);
         new Object().getClass();
         InputStream var5 = b.a(var8);
         DataInputStream var6;
         (var6 = new DataInputStream(var5)).skip(0L);
         var6.read(var0, 0, var0.length);
         var6.close();
      } catch (Exception var4) {
         System.out.println("GameInf err at getStream()  :  " + var4);
      }
   }

   public static byte c(byte[] var0, int[] var1) {
      return (byte)var0[var1[0]++];
   }

   public static short d(byte[] var0, int[] var1) {
      return (short)((var0[var1[0]++] & 255) << 8 | var0[var1[0]++] & 0xFF);
   }

   public static int e(byte[] var0, int[] var1) {
      return (var0[var1[0]++] & 0xFF) << 24 | (var0[var1[0]++] & 0xFF) << 16 | (var0[var1[0]++] & 0xFF) << 8 | var0[var1[0]++] & 0xFF;
   }

   public static String a(byte[] var0) {
      char[] var1 = new char[var0.length >> 1];

      for (byte var2 = 0; var2 < var0.length; var2 += 2) {
         var1[var2 >> 1] = (char)(var0[var2] << 8 | var0[var2 + 1] & 0xFF);
      }

      return new String(var1);
   }

   public static void a(c.f var0, int var1, int var2, c.f var3) {
      var0.a(var0.c() + var1, var3);
      var0.b(var0.d() + var2, var3);
      if (var0.j() != 1 && var0.j() == 0) {
         for (int var4 = 0; var4 < var0.h().length && var0.h()[var4] != null; var4++) {
            a(var0.h()[var4], var1, var2, var3);
         }
      }
   }

   public static void a(
      Graphics var0,
      String var1,
      int var2,
      int var3,
      int var4,
      int var5,
      int var6,
      int var7,
      Font var8,
      boolean var9,
      int var10,
      int[] var11,
      int var12,
      byte var13,
      c.d var14,
      byte var15,
      boolean[] var16
   ) {
      if (var13 != -1 && var14 != null) {
         var5 = n.a;
      }

      int[] var22;
      (var22 = new int[1 + i.length])[0] = var2;

      for (int var18 = 1; var18 < var22.length; var18++) {
         var22[var18] = i[var18 - 1];
      }

      f var19 = a(var1, var5, var6, var9, var8, var13, var14);
      int var17 = 0;
      if (var19.d > 0) {
         if (var9) {
            if (var19.a[var19.d - 1][3] + var5 > var7) {
               var16[0] = true;
               if (var19.a[var19.d - 1][3] + var5 > var11[1]) {
                  var11[1] += var12;
               } else {
                  var11[1] = -var7;
                  var16[1] = true;
               }
            } else {
               var16[0] = var16[1] = true;
               var11[1] = 0;
            }
         } else {
            var17 = var8.stringWidth(var1);
            if (var13 != -1 && var14 != null) {
               var17 = n.a(var1);
            }

            if (var17 > var6) {
               var16[1] = true;
               if (var17 > var11[0]) {
                  var11[0] += var12;
                  if (var11[0] >= var17 - var6) {
                     var16[0] = true;
                  }
               } else {
                  var11[0] = -var6;
               }
            } else {
               var16[1] = var16[0] = true;
               var11[0] = 0;
            }
         }
      }

      for (int var20 = 0; var20 < var19.d; var20++) {
         if (var9) {
            var0.clipRect(var3, var4, var6, var7);
            a(
               var0,
               var1.substring(var19.a[var20][0], var19.a[var20][1]),
               var22[var19.a[var20][4]],
               var3 + var19.a[var20][2],
               var4 + var19.a[var20][3] - var11[1],
               20,
               var14
            );
            var0.clipRect(0, 0, a.a.g(), a.a.h());
         } else {
            var12 = 0;
            int var23 = 0;
            switch (var10) {
               case 0:
                  var12 = var3;
                  var23 = var4;
                  break;
               case 1:
                  var12 = var3 + (var6 - (var19.c + var19.b)) / 2;
                  var23 = var4;
                  break;
               case 2:
                  var12 = var3 + (var6 - (var19.c + var19.b));
                  var23 = var4;
                  break;
               case 3:
                  var12 = var3;
                  var23 = var4 + (var7 - var5) / 2;
                  break;
               case 4:
                  if (var17 > var6) {
                     var12 = var3;
                  } else {
                     var12 = var3 + (var6 - (var19.c + var19.b)) / 2;
                  }

                  var23 = var4 + (var7 - var5) / 2;
                  break;
               case 5:
                  var12 = var3 + (var6 - (var19.c + var19.b));
                  var23 = var4 + (var7 - var5) / 2;
                  break;
               case 6:
                  var12 = var3;
                  var23 = var4 + (var7 - var5);
                  break;
               case 7:
                  if (var17 > var6) {
                     var12 = var3;
                  } else {
                     var12 = var3 + (var6 - (var19.c + var19.b)) / 2;
                  }

                  var23 = var4 + (var7 - var5);
                  break;
               case 8:
                  var12 = var3 + (var6 - (var19.c + var19.b));
                  var23 = var4 + (var7 - var5);
            }

            var0.clipRect(var3, var4, var6, var7);
            a(
               var0,
               var1.substring(var19.a[var20][0], var19.a[var20][1]),
               var22[var19.a[var20][4]],
               var12 + var19.a[var20][2] - var11[0],
               var23 + var19.a[var20][3],
               20,
               var14
            );
            var0.clipRect(0, 0, a.a.g(), a.a.h());
         }
      }
   }

   private static f a(String var0, int var1, int var2, boolean var3, Font var4, byte var5, c.d var6) {
      f var7 = new f();
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      int var12 = var0.length() - 1;
      int var13 = var2 - n.b;

      for (int var14 = 0; var14 <= var12; var14++) {
         char var16;
         if ((var16 = var0.charAt(var14)) == '#' && var14 != var12) {
            if (var0.charAt(var14 + 1) == 'n') {
               var7.a[var7.d++] = new int[]{var8, var14, var9, var10, var11};
               var9 = 0;
               var10 += var1 + 1;
               var8 = var14 + 2;
            } else if (var0.charAt(var14 + 1) >= '0' && var0.charAt(var14 + 1) <= '7') {
               var7.c = var7.c + var7.b;
               var7.a[var7.d++] = new int[]{var8, var14, var9, var10, var11};
               int var17 = var4.charsWidth(var0.substring(var8, var14).toCharArray(), 0, var14 - var8);
               if (var5 != -1 && var6 != null) {
                  var17 = c.d.a(var0.substring(var8, var14), 0, var14 - var8);
               }

               var9 += var17;
               var11 = var0.charAt(var14 + 1) - '0';
               var8 = var14 + 2;
            }
         } else if (var14 - var8 >= 0) {
            int var15 = c.d.a(var0.substring(var8, var14 + 1), 0, var14 - var8 + 1);
            var7.b = var15;
            if (var3 && (var9 + var15 >= var2 || var16 == ' ' && var9 + var15 >= var13)) {
               var7.a[var7.d++] = new int[]{var8, var14, var9, var10, var11};
               var9 = 0;
               var10 += var1 + 1;
               var8 = var14;
            }
         }

         if (var14 == var12) {
            if (var14 == var8) {
               int var18;
               for (var18 = 0; var18 < j.length; var18++) {
                  if (var0.charAt(var14) == j[var18]) {
                     var7.a[var7.d - 1][1] = var14 + 1;
                     break;
                  }
               }

               if (var18 < j.length) {
                  continue;
               }
            } else if (var14 + 1 - var8 <= 0) {
               continue;
            }

            var7.a[var7.d++] = new int[]{var8, var14 + 1, var9, var10, var11};
         }
      }

      return var7;
   }

   private static void a(Graphics var0, String var1, int var2, int var3, int var4, int var5, c.d var6) {
      c.d.a(var1, var3, var4, 20, var2, var0);
   }

   public static void a(Graphics var0, String var1, int var2, int var3, int var4, int var5, int var6, c.d var7, int var8) {
      switch (var8) {
         case 0:
            if (var7 != null) {
               c.d.a(var1, var3 - 1, var4, 17, 8607289, var0);
               c.d.a(var1, var3 + 1, var4, 17, 8607289, var0);
            } else {
               var0.setColor(8607289);
               var0.drawString(var1, var3 - 1, var4, 17);
               var0.drawString(var1, var3 + 1, var4, 17);
            }
            break;
         case 1:
            if (var7 != null) {
               c.d.a(var1, var3, var4 - 1, 17, 8607289, var0);
               c.d.a(var1, var3, var4 + 1, 17, 8607289, var0);
            } else {
               var0.setColor(8607289);
               var0.drawString(var1, var3, var4 - 1, 17);
               var0.drawString(var1, var3, var4 + 1, 17);
            }
            break;
         case 2:
            if (var7 != null) {
               c.d.a(var1, var3, var4 - 1, 17, 8607289, var0);
               c.d.a(var1, var3, var4 + 1, 17, 8607289, var0);
               c.d.a(var1, var3 - 1, var4, 17, 8607289, var0);
               c.d.a(var1, var3 + 1, var4, 17, 8607289, var0);
            } else {
               var0.setColor(8607289);
               var0.drawString(var1, var3, var4 - 1, 17);
               var0.drawString(var1, var3, var4 + 1, 17);
               var0.drawString(var1, var3 - 1, var4, 17);
               var0.drawString(var1, var3 + 1, var4, 17);
            }
      }

      if (var7 != null) {
         c.d.a(var1, var3, var4, 17, var2, var0);
      } else {
         var0.setColor(var2);
         var0.drawString(var1, var3, var4, 17);
      }
   }

   public static void a(String var0, int var1, int var2, Font var3, boolean var4, byte var5, c.d var6) {
      f var9 = a(var0, var1, var2, true, var3, (byte)-1, var6);
      var2 = var9.d;
      int[][] var10 = var9.a;
      var0 = var0;
      b = 1;
      m = 0;
      String[] var12 = new String[50];
      var4 = 0;
      var5 = var10[0][3];
      int var15 = 0;

      for (int var7 = 0; var7 < var2; var7++) {
         if (var5 != var10[var7][3]) {
            var5 = var10[var7][3];
            var12[var4++] = var0.substring(var15, var10[var7][0]);
            var15 = var10[var7][0];
         }

         if (var7 == var2 - 1) {
            var12[var4++] = var0.substring(var15, var10[var7][1]);
            break;
         }
      }

      String[] var16 = new String[var4];
      System.arraycopy(var12, 0, var16, 0, var16.length);
      a = var16;
   }

   public static void d(int var0) {
      k = var0 / a.a.o();
   }

   public static String e(int var0) {
      StringBuffer var1 = new StringBuffer();

      for (int var2 = k * m; var2 < (var0 * k > a.length ? a.length : var0 * k); var2++) {
         var1.append(a[var2]);
      }

      m = var0;
      return var1.toString();
   }

   public static int b() {
      return a.length % k == 0 ? a.length / k : a.length / k + 1;
   }

   public static void c() {
      b++;
   }

   public static String[] a(String var0, char var1) {
      Vector var3 = new Vector();
      int var4 = 0;
      int var5 = 0;

      while (var4 != -1 && (var4 = var0.trim().indexOf(var1, var5)) != -1) {
         String var2 = var0.trim().substring(var5, var4);
         var5 = var4 + 1;
         var3.addElement(var2);
      }

      var3.addElement(var0.substring(var5));
      String[] var6 = new String[var3.size()];
      var3.copyInto(var6);
      return var6;
   }

   public static int b(String var0) {
      return Integer.parseInt(var0);
   }

   public static short c(String var0) {
      return Short.parseShort(var0);
   }

   public static byte d(String var0) {
      return Byte.parseByte(var0);
   }

   public static byte[] e(String var0) {
      String[] var4;
      byte[] var1 = new byte[(var4 = a(var0, ',')).length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         String var3;
         var1[var2] = Byte.parseByte(var3 = var4[var2]);
      }

      return var1;
   }

   public static long[] a(long var0) {
      long[] var2;
      (var2 = new long[3])[0] = var0 / 3600000L;
      var2[1] = var0 / 60000L;
      var2[2] = var0 / 1000L;
      return var2;
   }

   private static byte[] g(String var0) {
      try {
         if (var0.indexOf("img_") < 0) {
            return f(var0);
         }

         byte[] var1 = new byte[1024];
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         "".getClass();
         InputStream var5 = b.a(var0);

         int var3;
         while ((var3 = var5.read(var1)) > 0) {
            var2.write(var1, 0, var3);
         }

         return var2.toByteArray();
      } catch (Exception var4) {
         var4.printStackTrace();
         return null;
      }
   }
}
