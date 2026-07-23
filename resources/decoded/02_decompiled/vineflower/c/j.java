package c;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class j {
   private static j c;
   private Hashtable d = new Hashtable();
   private Vector e = new Vector();
   private Vector f = new Vector();
   public c a;
   public d b = new d();

   private j() {
   }

   public static j a() {
      if (c == null) {
         c = new j();
      }

      return c;
   }

   public final void b() {
      if (c != null) {
         j var1 = c;
         Enumeration var2 = c.d.elements();

         while (var2.hasMoreElements()) {
            ((c)var2.nextElement()).c();
         }

         var1.d.clear();
         var1.e.removeAllElements();
      }

      this.a = null;
      System.gc();
   }

   public final void a(Graphics var1) {
      if (this.e != null) {
         for (int var2 = 0; var2 < this.e.size(); var2++) {
            ((c)this.e.elementAt(var2)).a(var1);
         }
      }

      var1.setClip(0, 0, a.a.g(), a.a.h());
   }

   public final void c() {
      if (this.a != null) {
         this.a.b();
      }
   }

   public final void a(String var1, int var2, c.a var3) {
      c var4;
      if ((var4 = (c)this.d.get(var1)) != null) {
         if (!var1.equals("/data/ui/dialog.ui")) {
            this.d.remove(var1);
         }

         this.e.removeElement(var4);
         if (!var1.equals("/data/ui/dialog.ui")) {
            var4.c();
            var4 = null;
         }

         if (var1.equals("/data/ui/dialog.ui")) {
            this.e.addElement(var4);
            this.a = var4;
            this.f.addElement(var1);
         }
      }

      if (var4 == null) {
         (var4 = new c(var3)).a(this.b);
         var4.a(var1, var2, false);
         this.d.put(var1, var4);
         this.e.addElement(var4);
         this.a = var4;
         this.f.addElement(var1);
      }
   }

   public final void a(String var1) {
      c var2;
      if ((var2 = (c)this.d.get(var1)) != null) {
         if (this.a.equals(var2)) {
            this.a = null;
         }

         if (!var1.equals("/data/ui/dialog.ui")) {
            this.d.remove(var1);
         }

         this.e.removeElement(var2);
         this.f.removeElement(var1);
         if (!var1.equals("/data/ui/dialog.ui")) {
            var2.c();
         }
      }

      if (this.d.size() > 0 && this.e.size() > 0) {
         this.a = (c)this.e.lastElement();
      }
   }

   public final boolean b(String var1) {
      return this.f.size() > 0 && this.f.lastElement().equals(var1);
   }

   public final boolean c(String var1) {
      return this.f.size() > 0 && this.f.contains(var1);
   }

   public final c d(String var1) {
      return (c)this.d.get(var1);
   }
}
