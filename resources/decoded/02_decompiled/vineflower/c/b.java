package c;

import javax.microedition.lcdui.Graphics;

public final class b implements f {
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private byte[][] i;
   private i j;
   private int k;
   private byte l;
   private l m;
   private f[] n;
   public l a;
   public l b;
   private boolean o = true;

   public b() {
      this.c = -1;
      this.d = 0;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = 0;
      this.j = new i();
      this.m = null;
      this.n = new f[60];
      this.a = null;
      this.b = null;
      this.k = -1;
      this.i = null;
      this.l = 9;
      this.o = true;
   }

   public final void a(boolean var1) {
      this.o = var1;
   }

   public final void a(byte[][] var1) {
      this.i = var1;
   }

   public final byte[][] a() {
      return this.i;
   }

   public final void a(Graphics var1, boolean var2, boolean var3, f var4, int[] var5) {
      if (this.o) {
         for (int var6 = 0; var6 < this.n.length && this.n[var6] != null; var6++) {
            if (this.n[var6].g() != null) {
               boolean var7 = false;
               int var8;
               if ((var8 = a.e.a(var5)) > 0 && var5[var8 - 1] == this.c) {
                  var7 = true;
               }

               this.n[var6].g().a(var1, this.n[var6].b(), var7, var5, var3, var4);
            } else {
               this.n[var6].a(var1, var2, var3, var4, var5);
            }
         }
      }
   }

   public final void a(boolean var1, boolean var2, f var3, int[] var4) {
      for (int var5 = 0; var5 < this.n.length && this.n[var5] != null; var5++) {
         if (this.n[var5].g() != null) {
            if (a.e.a(var4) > 0) {
               ;
            }

            this.n[var5].g().a(this.n[var5].b(), var4, var2, var3);
         } else {
            this.n[var5].a(var1, var2, var3, var4);
         }
      }
   }

   public final int b() {
      return this.c;
   }

   public final void a(int var1) {
      this.c = var1;
   }

   public final int c() {
      return this.d;
   }

   public final void a(int var1, f var2) {
      this.d = var1;
      this.a(var2);
   }

   public final int d() {
      return this.e;
   }

   public final void b(int var1, f var2) {
      this.e = var1;
      this.a(var2);
   }

   public final int e() {
      return this.f;
   }

   public final void c(int var1, f var2) {
      this.f = var1;
      this.a(var2);
   }

   public final int f() {
      return this.g;
   }

   public final void d(int var1, f var2) {
      this.g = var1;
      this.a(var2);
   }

   public final l g() {
      return this.m;
   }

   public final void a(l var1) {
      this.m = var1;
   }

   public final f[] h() {
      return this.n;
   }

   public final i i() {
      return this.j;
   }

   public final void a(i var1) {
      this.j = var1;
   }

   public final int j() {
      return this.h;
   }

   public final void b(int var1) {
      this.h = var1;
   }

   public final int k() {
      return this.k;
   }

   public final void c(int var1) {
      this.k = var1;
   }

   public final void a(f var1) {
      if (var1 != null) {
         if (this.k > 0 && this.l != 9) {
            f var2 = a.e.a(var1, this.k);
            switch (this.l) {
               case 0:
                  this.d = var2.c();
                  this.e = var2.d();
                  break;
               case 1:
                  this.d = var2.c() + (var2.e() - this.f) / 2;
                  this.e = var2.d();
                  this.f = var2.e();
                  break;
               case 2:
                  this.d = var2.c() + (var2.e() - this.f);
                  this.e = var2.d();
                  break;
               case 3:
                  this.d = var2.c();
                  this.e = var2.d() + (var2.f() - this.g) / 2;
                  this.g = var2.f();
                  break;
               case 4:
                  this.d = var2.c();
                  this.e = var2.d();
                  this.f = var2.e();
                  this.g = var2.f();
                  break;
               case 5:
                  this.d = var2.c() + (var2.e() - this.f);
                  this.e = var2.d() + (var2.f() - this.g) / 2;
                  this.g = var2.f();
                  break;
               case 6:
                  this.d = var2.c();
                  this.e = var2.d() + (var2.f() - this.g);
                  break;
               case 7:
                  this.d = var2.c() + (var2.e() - this.f) / 2;
                  this.e = var2.d() + (var2.f() - this.g);
                  this.f = var2.e();
                  break;
               case 8:
                  this.d = var2.c() + (var2.e() - this.f);
                  this.e = var2.d() + (var2.f() - this.g);
            }
         }

         if (this.n != null) {
            for (int var3 = 0; var3 < this.n.length && this.n[var3] != null; var3++) {
               this.n[var3].a(var1);
            }
         }
      }
   }

   public final void l() {
      if (this.b != null) {
         this.b.a();
         this.b = null;
      }

      if (this.a != null) {
         this.a.a();
         this.a = null;
      }

      if (this.n != null) {
         for (int var1 = 0; var1 < this.n.length; var1++) {
            if (this.n[var1] != null) {
               this.n[var1].l();
            }

            this.n[var1] = null;
         }

         this.n = null;
      }

      if (this.m != null) {
         this.m = null;
      }

      if (this.i != null) {
         this.i = null;
      }

      if (this.j != null) {
         this.j.c();
         this.j = null;
      }
   }
}
