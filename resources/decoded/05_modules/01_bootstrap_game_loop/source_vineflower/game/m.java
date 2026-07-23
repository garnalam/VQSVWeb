package game;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public final class m extends Canvas implements Runnable {
   private static m b = null;
   private static GameMIDLet c;
   private static a.d d;
   private f e;
   public static m a;
   private long f = 0L;
   private long g = 0L;
   private long h = 0L;
   private int i = 0;

   public static m a(GameMIDLet var0) {
      if (b == null) {
         b = new m(var0);
      }

      return b;
   }

   public static m a() {
      return b;
   }

   private m(GameMIDLet var1) {
      a = this;
      this.setFullScreenMode(true);
      c = var1;
      a.a.a(66);
      a.a.a((short)this.getWidth(), (short)this.getHeight());
      this.e = game.f.B();
      this.e.C();
      f var2 = this.e;
      if (d != null) {
         d.d(false);
         d = null;
      }

      if (var2 != null) {
         var2.d(true);
         d = var2;
      }

      new Thread(this).start();
   }

   protected final void hideNotify() {
      if (!a.a.e && this.e.D() > 1) {
         this.e.E();
      }
   }

   protected final void paint(Graphics var1) {
      if (this.e.D() > 1) {
         this.e.a(var1);
      }
   }

   public final void run() {
      while (this.e.D() > 1) {
         this.f = System.currentTimeMillis();
         this.e.a();
         this.repaint();
         this.serviceRepaints();
         this.g = System.currentTimeMillis();
         this.h = this.g - this.f;
         if (this.h > a.a.k()) {
            this.h = a.a.k();
         }

         try {
            Thread.sleep(a.a.k() - this.h);
         } catch (InterruptedException var1) {
         }
      }

      c.destroyApp(true);
   }

   protected final void keyPressed(int var1) {
      if (this.e != null) {
         this.e.j(var1);
      }
   }

   protected final void keyReleased(int var1) {
      if (this.e != null) {
         this.e.k(var1);
      }
   }

   protected final void pointerPressed(int var1, int var2) {
      this.i = 0;
      if (this.e.D() == 13) {
         if (a.e.a(var1, var2, 38, 225, 50, 40)) {
            this.i = -6;
         } else if (a.e.a(var1, var2, 150, 225, 50, 40)) {
            this.i = -7;
         }
      } else if (a.e.a(var1, var2, 0, 280, 40, 40)) {
         this.i = -6;
      } else if (a.e.a(var1, var2, 200, 280, 40, 40)) {
         this.i = -7;
      }

      this.keyPressed(this.i);
      if (this.e != null) {
         this.e.c(var1, var2);
      }
   }

   protected final void pointerReleased(int var1, int var2) {
      this.keyReleased(this.i);
      if (this.e != null) {
         this.e.d(var1, var2);
      }
   }
}
