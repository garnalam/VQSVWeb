package c;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public final class i {
   public String a;
   private int[] n;
   private int o;
   public int b;
   public int c;
   public boolean d;
   public int e;
   public int f;
   public int g;
   private boolean p = false;
   private int q = 0;
   public byte h = -1;
   public g i;
   public int j;
   public int k;
   public int l;
   public g m;
   private k r = null;
   private String s = "";
   private boolean[] t = new boolean[]{false, false};

   public i() {
      this.a = "";
      this.n = new int[2];
      this.n[1] = this.n[0] = 0;
      this.o = 2;
      this.b = 4;
      this.c = 4;
      this.d = false;
      this.e = 16777215;
      this.f = 16777215;
      this.g = 16777215;
      this.i = null;
      this.j = 16777215;
      this.k = 16777215;
      this.l = 16777215;
      this.m = null;
      this.p = false;
      this.h = -1;
      this.q = 0;
   }

   private static void a(Graphics var0, k var1, int var2) {
      if (var0 != null && var2 >> 24 != 0) {
         var0.setColor(var2);
         var0.fillRect(var1.a, var1.b, var1.c, var1.d);
      }
   }

   public final void a(k var1) {
      this.r = var1;
   }

   public final void a() {
      this.n[1] = -this.r.d;
      this.n[0] = -this.r.c / 2;
      this.t[0] = this.t[1] = false;
   }

   public final boolean b() {
      return this.t[1];
   }

   private void a(Graphics var1, k var2, String var3, int var4, int var5, boolean var6, byte var7, d var8, byte var9) {
      if (var1 != null && var4 >> 24 != 0) {
         if (var3.startsWith("#P") && var3.length() > 2) {
            boolean var10 = false;
            int var11 = 0;

            try {
               var11 = Integer.parseInt(var3.substring(2).trim());
            } catch (Exception var12) {
               var10 = true;
            }

            if (!var10 && var11 >= 0 && var11 <= 100) {
               int var13 = var11 * var2.c / 100;
               var1.setColor(var4);
               var1.fillRect(var2.a + 1, var2.b + 1, var13 - 1, var2.d - 1);
               return;
            }
         }

         Font var14 = Font.getFont(0, 0, 8);
         if (!this.s.equals(var3)) {
            this.n[1] = -var2.d;
            this.n[0] = -var2.c / 2;
         }

         this.s = var3;
         a.e.a(var1, var3, var4, var2.a, var2.b, var14.getHeight(), var2.c, var2.d, var14, var6, var5, this.n, this.o, var7, var8, var9, this.t);
      }
   }

   private static void b(Graphics var0, k var1, int var2) {
      if (var0 != null && var2 >> 24 != 0) {
         var0.setColor(var2);
         var0.drawRect(var1.a, var1.b, var1.c, var1.d);
      }
   }

   public final void a(Graphics var1, int var2, int var3, int var4, int var5, boolean var6, byte var7, byte var8, d var9) {
      if (this.p != var6 || this.q == 0) {
         this.q = -1;
         this.p = var6;
      }

      k var10 = new k(var2, var3, var4, var5);
      this.r = var10;
      var1.setClip(0, 0, a.a.g(), a.a.h());
      if (var6) {
         a(var1, this.r, this.e);
         b(var1, this.r, this.f);
         if (this.i != null) {
            this.i.a(var1, this.r, this.c);
         }

         this.a(var1, this.r, this.a, this.g, this.b, this.d, var7, var9, var8);
      } else {
         a(var1, this.r, this.j);
         b(var1, this.r, this.k);
         if (this.m != null) {
            this.m.a(var1, this.r, this.c);
         }

         this.a(var1, this.r, this.a, this.l, this.b, this.d, var7, var9, var8);
      }
   }

   public final void c() {
      if (this.i != null) {
         this.i.c();
         this.i = null;
      }

      if (this.m != null) {
         this.m.c();
         this.m = null;
      }
   }
}
