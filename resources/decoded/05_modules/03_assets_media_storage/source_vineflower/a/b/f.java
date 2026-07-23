package a.b;

public final class f {
   private static h[] a;

   public static void a(int var0) {
      a = new h[1000];
   }

   public static h b(int var0) {
      if (a[var0] == null) {
         a[var0] = new h();
         byte[] var1 = new byte[20000];
         int[] var2 = new int[]{0};
         a.e.a(var1, "/data/spr/spr_" + var0 + "_all(r)", 0);
         a[var0].b = a.e.a(var1, var2);
         a[var0].e = a.e.b(var1, var2);
         a[var0].f = a.e.b(var1, var2);
         a[var0].d = a(a.e.a(var1, var2), a[var0].e.length);
         a[var0].c = a(a.e.a(var1, var2), a[var0].e.length);
      }

      a[var0].a++;
      return a[var0];
   }

   private static short[][] a(short[] var0, int var1) {
      if (var0 == null) {
         return null;
      }

      short[][] var3 = new short[var1][];

      for (int var2 = 0; var2 < var0.length / 5; var2++) {
         var3[var0[var2 * 5]] = a.e.a(var3[var0[var2 * 5]], new short[]{var0[var2 * 5 + 1], var0[var2 * 5 + 2], var0[var2 * 5 + 3], var0[var2 * 5 + 4]});
      }

      return var3;
   }

   public static void c(int var0) {
      a[var0].a--;
      if (a[var0].a <= 0) {
         a[var0].a = 0;
      }
   }

   public static boolean d(int var0) {
      if (a[var0].a <= 0) {
         a[var0].a = 0;
         a[var0] = null;
         return true;
      } else {
         return false;
      }
   }
}
