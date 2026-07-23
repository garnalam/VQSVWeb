package c;

import javax.microedition.lcdui.Graphics;

public final class h implements f {
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private i j;
   private int k;
   private byte l;
   private l m;
   private f[] n;
   public byte a = -1;
   public byte b = -1;
   d c;
   private boolean o = true;

   public h() {
      this.d = -1;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = 0;
      this.i = 1;
      this.j = new i();
      this.k = -1;
      this.m = null;
      this.n = null;
      this.l = 9;
      this.o = true;
   }

   public final void a() {
      k var1 = new k(this.e, this.f, this.g, this.h);
      this.j.a(var1);
      this.j.a();
   }

   public final void a(Graphics var1, boolean var2, boolean var3, f var4, int[] var5) {
      if (this.o) {
         if (this.j != null) {
            this.j.a(var1, this.e, this.f, this.g, this.h, var2, this.a, this.b, this.c);
         }
      }
   }

   public final void a(boolean var1, boolean var2, f var3, int[] var4) {
      if (this.j != null) {
         var2 = var1;
         i var5 = this.j;
         if (var2) {
            if (var5.i != null) {
               var5.i.b();
               return;
            }
         } else if (var5.m != null) {
            var5.m.b();
         }
      }
   }

   public final void a(boolean var1) {
      this.o = var1;
   }

   public final int b() {
      return this.d;
   }

   public final void a(int var1) {
      this.d = var1;
   }

   public final int c() {
      return this.e;
   }

   public final void a(int var1, f var2) {
      this.e = var1;
      this.a(var2);
   }

   public final int d() {
      return this.f;
   }

   public final void b(int var1, f var2) {
      this.f = var1;
      this.a(var2);
   }

   public final int e() {
      return this.g;
   }

   public final void c(int var1, f var2) {
      this.g = var1;
      this.a(var2);
   }

   public final int f() {
      return this.h;
   }

   public final void d(int var1, f var2) {
      this.h = var1;
      this.a(var2);
   }

   public final l g() {
      return this.m;
   }

   public final void a(l var1) {
      this.m = var1;
   }

   public final f[] h() {
      return null;
   }

   public final i i() {
      return this.j;
   }

   public final void a(i var1) {
      this.j = var1;
   }

   public final int j() {
      return this.i;
   }

   public final void b(int var1) {
      this.i = var1;
   }

   public final int k() {
      return this.k;
   }

   public final void c(int var1) {
      this.k = var1;
   }

   public final void a(f var1) {
      if (var1 != null && this.k > 0 && this.l != 9) {
         var1 = a.e.a(var1, this.k);
         switch (this.l) {
            case 0:
               this.e = var1.c();
               this.f = var1.d();
               return;
            case 1:
               this.e = var1.c() + (var1.e() - this.g) / 2;
               this.f = var1.d();
               this.g = var1.e();
               break;
            case 2:
               this.e = var1.c() + (var1.e() - this.g);
               this.f = var1.d();
               return;
            case 3:
               this.e = var1.c();
               this.f = var1.d() + (var1.f() - this.h) / 2;
               this.h = var1.f();
               return;
            case 4:
               this.e = var1.c();
               this.f = var1.d();
               this.g = var1.e();
               this.h = var1.f();
               return;
            case 5:
               this.e = var1.c() + (var1.e() - this.g);
               this.f = var1.d() + (var1.f() - this.h) / 2;
               this.h = var1.f();
               return;
            case 6:
               this.e = var1.c();
               this.f = var1.d() + (var1.f() - this.h);
               return;
            case 7:
               this.e = var1.c() + (var1.e() - this.g) / 2;
               this.f = var1.d() + (var1.f() - this.h);
               this.g = var1.e();
               return;
            case 8:
               this.e = var1.c() + (var1.e() - this.g);
               this.f = var1.d() + (var1.f() - this.h);
               return;
         }
      }
   }

   public final void l() {
      if (this.m != null) {
         this.m = null;
      }

      if (this.j != null) {
         this.j.c();
         this.j = null;
      }

      if (this.c != null) {
         this.c = null;
      }
   }
}
