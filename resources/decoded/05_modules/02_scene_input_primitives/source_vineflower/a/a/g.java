package a.a;

import game.l;
import javax.microedition.lcdui.Graphics;

public class g extends a.b.a {
   public a.b.g a;
   public g b = null;
   protected boolean c;

   public g() {
      this.a = new a.b.g();
   }

   public boolean a(int var1, boolean var2) {
      return this.a.a(var1, var2);
   }

   public final void a(int var1, int var2, boolean var3) {
      this.a.a(var1, var2, true);
   }

   public final boolean a(byte var1, byte var2, boolean var3) {
      return this.a.a(var1, var2, var3);
   }

   public final void a(byte var1, byte var2, byte var3) {
      this.a.a(var1, (byte)-1);
      var2 = var3;
      super.o = var2;
   }

   public final boolean a() {
      return !this.g ? false : this.a.e();
   }

   public final boolean b() {
      return this.a.f();
   }

   public final void a(Graphics var1, int var2, int var3) {
      if (this.g) {
         if (this.o == 3) {
            this.a.a(var1, this.j - var2, this.k - var3, (byte)1);
         } else {
            this.a.a(var1, this.j - var2, this.k - var3, (byte)0);
         }
      }
   }

   public final void b(Graphics var1, int var2, int var3) {
      if (this.c) {
         if (this.o == 3) {
            this.a.a(var1, this.j - var2, this.k - var3, (byte)3);
         } else {
            this.a.a(var1, this.j - var2, this.k - var3, (byte)4);
         }
      }
   }

   public void c() {
      this.b(true);
      this.c(true);
      this.d(true);
   }

   public void d() {
      this.b(false);
      this.c(false);
      this.d(false);
   }

   public final void e() {
      if (this.b != null) {
         this.b.d();
      }
   }

   public final void a(boolean var1) {
      this.c = var1;
   }

   public void a(int var1) {
      switch (this.o) {
         case 0:
            this.e(var1);
            break;
         case 1:
            this.d(var1);
            break;
         case 2:
            this.e(-var1);
            break;
         case 3:
            this.d(-var1);
      }

      if (this.b != null) {
         this.b.b(this.j, this.k);
      }
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            this.e(4);
            break;
         case 1:
            this.d(4);
            break;
         case 2:
            this.e(-4);
            break;
         case 3:
            this.d(-4);
      }

      if (this.b != null) {
         this.b.b(this.j, this.k);
      }
   }

   public final void f() {
      if (this.a.i()) {
         this.d(true);
      } else if (a.e.a(game.l.B().k.a, game.l.B().k.b, a.a.g(), a.a.h(), this.j, this.k, this.a.j())) {
         this.d(true);
      } else {
         this.d(false);
      }
   }

   public final void g() {
      this.a.c();
   }

   public final void b(int var1) {
      this.a.a(var1);
   }
}
