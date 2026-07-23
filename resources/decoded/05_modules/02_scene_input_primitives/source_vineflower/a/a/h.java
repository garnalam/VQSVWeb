package a.a;

import game.j;
import game.l;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class h {
   private a.b.d a;
   private Vector b;
   private Vector c = new Vector();
   private Vector d;
   private a.b.b e;

   public h() {
      this.b = new Vector();
      this.d = new Vector();
   }

   public final void a(a.b.d var1) {
      this.a = var1;
   }

   public final void a(a.b.a var1) {
      switch (var1.t) {
         case 0:
            this.b.addElement(var1);
            return;
         case 1:
            this.c.addElement(var1);
            return;
         case 2:
            this.d.addElement(var1);
      }
   }

   public final void b(a.b.a var1) {
      switch (var1.t) {
         case 0:
            this.b.removeElement(var1);
            return;
         case 1:
            this.c.removeElement(var1);
            return;
         case 2:
            this.d.removeElement(var1);
      }
   }

   public final void a(a.b.a var1, int var2) {
      this.b(var1);
      this.d.addElement(var1);
   }

   public final void a(a.b.b var1) {
      this.e = var1;
   }

   public final void a() {
      this.a = null;
      this.e = null;
      this.c.removeAllElements();
      this.b.removeAllElements();
      this.d.removeAllElements();
   }

   public final void b() {
      this.e.c();
      this.a.a(this.e.j, this.e.k);
      this.a.d();

      for (int var1 = 0; var1 < this.b.size(); var1++) {
         for (int var2 = 0; var2 < this.b.size() - var1 - 1; var2++) {
            if (((a.b.a)this.b.elementAt(var2)).k > ((a.b.a)this.b.elementAt(var2 + 1)).k) {
               Object var3 = this.b.elementAt(var2);
               this.b.setElementAt(this.b.elementAt(var2 + 1), var2);
               this.b.setElementAt(var3, var2 + 1);
            }
         }
      }

      for (int var4 = 0; var4 < this.b.size(); var4++) {
         ((g)this.b.elementAt(var4)).a();
      }

      for (int var5 = 0; var5 < this.c.size(); var5++) {
         for (int var9 = 0; var9 < this.c.size() - var5 - 1; var9++) {
            if (((a.b.a)this.c.elementAt(var9)).k > ((a.b.a)this.c.elementAt(var9 + 1)).k) {
               Object var11 = this.c.elementAt(var9);
               this.c.setElementAt(this.c.elementAt(var9 + 1), var9);
               this.c.setElementAt(var11, var9 + 1);
            }
         }
      }

      for (int var6 = 0; var6 < this.c.size(); var6++) {
         ((g)this.c.elementAt(var6)).a();
         if (this.c.elementAt(var6) instanceof game.h) {
            if (((game.h)this.c.elementAt(var6)).H != null && ((game.h)this.c.elementAt(var6)).H.j()) {
               ((game.h)this.c.elementAt(var6)).H.a();
            } else if (((game.h)this.c.elementAt(var6)).I != null && ((game.h)this.c.elementAt(var6)).I.j()) {
               ((game.h)this.c.elementAt(var6)).I.a();
            }
         }
      }

      for (int var7 = 0; var7 < this.d.size(); var7++) {
         for (int var10 = 0; var10 < this.d.size() - var7 - 1; var10++) {
            if (((a.b.a)this.d.elementAt(var10)).k > ((a.b.a)this.d.elementAt(var10 + 1)).k) {
               Object var12 = this.d.elementAt(var10);
               this.d.setElementAt(this.d.elementAt(var10 + 1), var10);
               this.d.setElementAt(var12, var10 + 1);
            }
         }
      }

      for (int var8 = 0; var8 < this.d.size(); var8++) {
         ((g)this.d.elementAt(var8)).a();
      }
   }

   public final void a(Graphics var1) {
      for (int var2 = 0; var2 < this.c.size(); var2++) {
         ((g)this.c.elementAt(var2)).b(var1, this.a.a, this.a.b);
      }

      this.a.a(var1, 1);
      this.a.a(var1, 2);

      for (int var3 = 0; var3 < this.d.size(); var3++) {
         if (((g)this.d.elementAt(var3)).l()) {
            ((g)this.d.elementAt(var3)).a(var1, this.a.a, this.a.b);
         }
      }

      if (l.B().m.Q[2] == 2) {
         for (int var4 = 0; var4 < this.c.size(); var4++) {
            if (((g)this.c.elementAt(var4)).l()) {
               if (this.c.elementAt(var4) instanceof j) {
                  continue;
               }

               ((g)this.c.elementAt(var4)).a(var1, this.a.a, this.a.b);
            }

            if (this.c.elementAt(var4) instanceof game.h && ((game.h)this.c.elementAt(var4)).w == 14) {
               ((game.h)this.c.elementAt(var4)).c(var1, this.a.a, this.a.b);
            }

            if (this.c.elementAt(var4) instanceof game.h) {
               if (((game.h)this.c.elementAt(var4)).H != null && ((game.h)this.c.elementAt(var4)).H.k()) {
                  ((game.h)this.c.elementAt(var4)).H.a(var1, this.a.a, this.a.b);
               } else if (((game.h)this.c.elementAt(var4)).I != null && ((game.h)this.c.elementAt(var4)).I.k()) {
                  ((game.h)this.c.elementAt(var4)).I.a(var1, this.a.a, this.a.b);
               }
            }
         }

         if (a.b.d.a().a(0, j.p().j, j.p().k) != 1 && l.B().m.b != null && l.B().m.k()) {
            l.B().m.b.a(var1, this.a.a, this.a.b);
         }

         l.B().m.a(var1, this.a.a, this.a.b);
      } else {
         for (int var5 = 0; var5 < this.c.size(); var5++) {
            if (((g)this.c.elementAt(var5)).l()) {
               if (((g)this.c.elementAt(var5)).b != null && ((g)this.c.elementAt(var5)).k()) {
                  ((g)this.c.elementAt(var5)).b.a(var1, this.a.a, this.a.b);
               }

               ((g)this.c.elementAt(var5)).a(var1, this.a.a, this.a.b);
            }

            if (this.c.elementAt(var5) instanceof game.h && ((game.h)this.c.elementAt(var5)).w == 14) {
               ((game.h)this.c.elementAt(var5)).c(var1, this.a.a, this.a.b);
            }

            if (this.c.elementAt(var5) instanceof game.h) {
               if (((game.h)this.c.elementAt(var5)).H != null && ((game.h)this.c.elementAt(var5)).H.k()) {
                  ((game.h)this.c.elementAt(var5)).H.a(var1, this.a.a, this.a.b);
               } else if (((game.h)this.c.elementAt(var5)).I != null && ((game.h)this.c.elementAt(var5)).I.k()) {
                  ((game.h)this.c.elementAt(var5)).I.a(var1, this.a.a, this.a.b);
               }
            }
         }
      }

      this.a.a(var1, 3);

      for (int var6 = 0; var6 < this.b.size(); var6++) {
         if (((g)this.b.elementAt(var6)).l()) {
            ((g)this.b.elementAt(var6)).a(var1, this.a.a, this.a.b);
         }
      }
   }

   public final void b(Graphics var1) {
      l.B();
      l.b(var1);
      this.a.a(var1, 1);
      this.a.a(var1, 2);

      for (int var2 = 0; var2 < this.d.size(); var2++) {
         if (((g)this.d.elementAt(var2)).l() && this.d.elementAt(var2) instanceof game.h && ((game.h)this.d.elementAt(var2)).w == 0) {
            ((g)this.d.elementAt(var2)).a(var1, this.a.a, this.a.b);
         }
      }

      for (int var4 = 0; var4 < this.c.size(); var4++) {
         if (((g)this.c.elementAt(var4)).l() && this.c.elementAt(var4) instanceof game.h && ((game.h)this.c.elementAt(var4)).w == 0) {
            ((g)this.c.elementAt(var4)).a(var1, this.a.a, this.a.b);
         }
      }

      this.a.a(var1, 3);

      for (int var5 = 0; var5 < this.b.size(); var5++) {
         if (((g)this.b.elementAt(var5)).l() && this.b.elementAt(var5) instanceof game.h && ((game.h)this.b.elementAt(var5)).w == 0) {
            ((g)this.b.elementAt(var5)).a(var1, this.a.a, this.a.b);
         }
      }

      for (int var6 = 0; var6 < a.a.g() / a.b.c.f.getWidth(); var6++) {
         for (int var3 = 0; var3 < a.a.h() / a.b.c.f.getHeight(); var3++) {
            var1.drawImage(a.b.c.f, var6 * a.b.c.f.getWidth(), var3 * a.b.c.f.getHeight(), 20);
         }
      }
   }
}
