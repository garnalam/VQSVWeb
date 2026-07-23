package a.b;

import game.l;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Image;

public class c {
   public static short[][] a;
   public static short[][] b;
   public static short[][][] c;
   public static String[] d;
   private static b.a[] g;
   public static int[][] e;
   public static Image f;
   private static Image[] h;
   private static byte[] i;
   private static int j;

   public static void a() {
      String var0 = null;
      a = a.e.a(a.e.a("/data/script/sprite.mid"));
      var0 = "/data/mod/modInfo.mid";

      try {
         "".getClass();
         InputStream var9 = b.a(var0);
         DataInputStream var1;
         byte var2;
         b = new short[var2 = (var1 = new DataInputStream(var9)).readByte()][];

         for (int var3 = 0; var3 < var2; var3++) {
            byte var4 = var1.readByte();
            b[var3] = new short[var4];

            for (int var5 = 0; var5 < var4; var5++) {
               short var6 = var1.readShort();
               b[var3][var5] = var6;
            }
         }

         var1.close();
         var9.close();
      } catch (IOException var7) {
         var7.printStackTrace();
      }

      c("/data/script/chs.mid");
      a("/data/script/npcDialog.mid");
      c();
      d("/data/event/worldEvt.mid");
      b("/data/script/db.mid");
      f = a.e.b("/data/tex/", "bk");
   }

   private static void a(String var0) {
      String[][] var2;
      l.aa = new String[(var2 = a.e.c(a.e.a(var0))).length];

      for (int var1 = 0; var1 < var2.length; var1++) {
         System.arraycopy(var2[var1], 0, l.aa, var1, var2[var1].length);
      }
   }

   public static short a(byte var0, short var1, byte var2) {
      return c[var0][var1][var2];
   }

   private static void b(String var0) {
      InputStream var2 = a.e.a(var0);
      c = new short[9][][];

      for (int var1 = 0; var1 < 9; var1++) {
         c[var1] = a.e.a(var2);
      }
   }

   private static void c(String var0) {
      String[][] var4;
      d = new String[(var4 = a.e.c(a.e.a(var0))).length];
      StringBuffer var1 = new StringBuffer();

      for (int var2 = 0; var2 < var4.length; var2++) {
         var1.delete(0, var1.length());

         for (int var3 = 0; var3 < var4[var2].length; var3++) {
            var1.append(var4[var2][var3]);
         }

         d[var2] = var1.toString();
      }
   }

   private static void c() {
      e = new int[4][];

      for (int var0 = 0; var0 < 4; var0++) {
         e[var0] = a.e.a(a.e.b("/data/tex/", "tex_" + var0));
      }
   }

   private static void d(String var0) {
      try {
         "".getClass();
         InputStream var9 = b.a(var0);
         DataInputStream var1;
         short var2 = (var1 = new DataInputStream(var9)).readShort();
         String[] var3 = null;
         if (var2 > 0) {
            var3 = new String[var2];

            for (int var4 = 0; var4 < var2; var4++) {
               byte var5 = var1.readByte();
               StringBuffer var6 = new StringBuffer();

               for (int var7 = 0; var7 < var5; var7++) {
                  var6.append((char)(var1.read() << 8 | var1.read()));
               }

               var3[var4] = var6.toString();
            }
         }

         if ((var2 = var1.readByte()) > 0) {
            g = new b.a[var2];

            for (byte var11 = 0; var11 < var2; var11++) {
               g[var11] = new b.a();
               g[var11].a(var1, var11, -1, var3);
            }
         }

         var1.close();
         var9.close();
      } catch (Exception var8) {
      }
   }

   public static void a(int var0) {
      j = 50000;
      h = new Image[50000];
      i = new byte[j];
   }

   public static Image b(int var0) {
      if (h[var0] == null) {
         h[var0] = a.e.b("/data/img/", "img_" + var0);
      }

      i[var0]++;
      return h[var0];
   }

   public static void c(int var0) {
      i[var0]--;
      if (i[var0] <= 0) {
         i[var0] = 0;
      }
   }

   public static boolean d(int var0) {
      i[var0]--;
      if (i[var0] <= 0) {
         i[var0] = 0;
         h[var0] = null;
         return true;
      } else {
         return false;
      }
   }

   public static void b() {
      for (int var0 = 0; var0 < j; var0++) {
         i[var0] = 0;
         h[var0] = null;
      }
   }
}
