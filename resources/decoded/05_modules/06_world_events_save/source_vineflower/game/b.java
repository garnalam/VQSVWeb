package game;

import javax.microedition.lcdui.Graphics;

public final class b extends a.a {
   private a.a.g l;
   private a.a.h m = null;
   private static game.b n = null;
   private a.b.d o = null;
   private a.b.b p = null;
   private boolean q = false;
   private byte r = 0;
   public boolean k = false;

   public static game.b B() {
      if (n == null) {
         n = new game.b();
      }

      return n;
   }

   public b() {
      this.p = new a.b.b();
      this.o = new a.b.d();
      this.m = new a.a.h();
      this.l = new a.a.g();
   }

   public final void C() {
      this.q = false;
   }

   public final void a() {
      if (this.q) {
         switch (this.r) {
            case 0:
               byte var4 = 0;
               a.a.g var3 = this.l;
               this.l.a(this.l.d[var4]);
               if (this.l.k - this.o.b > h()) {
                  this.k = true;
               }
               break;
            case 2:
               byte var2 = 0;
               a.a.g var1 = this.l;
               this.l.a(this.l.d[var2]);
               if (this.l.k - this.o.b < 0) {
                  this.k = true;
               }
         }

         this.m.b();
      }
   }

   public final void a(Graphics var1) {
      this.m.a(var1);
   }

   public final boolean b() {
      game.b var1 = this;
      this.l.d = new short[3];
      byte var4 = 5;
      byte var3 = 0;
      a.a.g var2 = var1.l;
      var1.l.d[var3] = var4;
      var1.l.a(343, false);
      var1.d(var1.r);
      var1.l.c();
      var1.m.a(var1.l);
      var1 = this;
      this.o.a(101);
      var1.m.a(var1.o);
      var1 = this;
      this.p.a(var1.l, g(), h(), true);
      var1.m.a(var1.p);
      var1.m.b();
      return true;
   }

   public final void c() {
      this.l = null;
      this.m = null;
      n = null;
      this.o = null;
      this.p = null;
   }

   public final void a(byte var1) {
      this.b = this.a;
      switch (var1) {
         case 1:
            a.a.f.a().c(0, 13);
            a.a.f.a().a(5, 1, g(), 30, 30);
            break;
         case 2:
            game.b var2 = this;
            this.k = false;
            var2.q = true;
            break;
         case 3:
            this.k = false;
            a.a.f.a().c(0, 12);
            a.a.f.a().a(5, 1, g(), 30, 30);
      }

      this.a = var1;
   }

   public final void d(byte var1) {
      this.r = var1;
      short var3 = var1;
      a.a.g var2 = this.l;
      this.l.o = (byte)var3;
      short var4 = (short)(g() >> 1);
      var3 = 0;
      switch (var1) {
         case 0:
            var4 = (short)(g() >> 1);
            var3 = 10;
            break;
         case 2:
            var4 = (short)(g() >> 1);
            var3 = (short)(h() - 10);
      }

      this.l.b(var4, var3);
      this.l.a(var1, (byte)-1, false);
   }
}
