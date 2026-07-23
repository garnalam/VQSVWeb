package d;

import java.lang.ref.WeakReference;

public class h {
   private Object[] a;
   private Object[] b;
   private int[] c;
   private int d;
   private boolean e;
   private boolean f;

   public void a(Object var1, Object var2) {
      g(var1);
      int var3 = this.c(var1);
      int var4;
      if ((var4 = this.a(var1, var3)) < 0) {
         var4 = this.b(var1, var3);
      }

      Object var7 = var2;
      var2 = var4;
      var1 = this;
      if (this.f) {
         var7 = e(var7);
      }

      var1.b[var2] = var7;
   }

   public Object a(Object var1) {
      g(var1);
      int var2 = this.c(var1);
      int var3;
      return (var3 = this.a(var1, var2)) >= 0 ? this.d(var3) : null;
   }

   public Object a(int var1) {
      return this.a(g.a(var1));
   }

   public Object b(Object var1) {
      int var2 = 0;
      if (var1 != null) {
         int var3 = this.c(var1);
         d.a.a((var2 = 1 + this.a(var1, var3)) > 0, "invalid key to 'next'");
      }

      while (var2 != this.a.length) {
         Object var4;
         if ((var4 = this.c(var2)) != null && this.d(var2) != null) {
            return var4;
         }

         var2++;
      }

      return null;
   }

   public int a() {
      int var1 = this.a.length;
      int var2 = 0;

      while (var2 < var1) {
         int var3;
         Integer var4 = g.a(var3 = var1 + var2 + 1 >> 1);
         if (this.a(var4) == null) {
            var1 = var3 - 1;
         } else {
            var2 = var3;
         }
      }

      return var2;
   }

   private static int b(int var0) {
      if (var0 < 4) {
         return 4;
      }

      int var2;
      int var10000 = --var0 | var0 >> 1 | (var2 = var0 | var0 >> 1) >> 2;
      return (var10000 | var10000 >> 4 | (var10000 | var10000 >> 4) >> 8 | (var10000 | var10000 >> 4 | (var10000 | var10000 >> 4) >> 8) >> 16) + 1;
   }

   private h() {
      h var1 = this;
      int var2 = b(4);
      var1.a = new Object[var2];
      var1.b = new Object[var2];
      var1.c = new int[var2];
      var1.d = var2;
   }

   public h(byte var1) {
      this();
   }

   private int c(Object var1) {
      int var2 = this.a.length;
      Object var3;
      Integer var4;
      return (
            (var3 = var1) instanceof Integer
               ? (var4 = (Integer)var3 == 0 ? 0 : var4.hashCode())
               : (var3 instanceof String ? var3.hashCode() : System.identityHashCode(var3))
         )
         & var2 - 1;
   }

   private static Object d(Object var0) {
      return !f(var0) ? var0 : ((WeakReference)var0).get();
   }

   private static Object e(Object var0) {
      return !f(var0) ? var0 : new WeakReference<>(var0);
   }

   private static boolean f(Object var0) {
      return var0 != null && !(var0 instanceof String) && !(var0 instanceof Integer) && !(var0 instanceof Boolean) && !(var0 instanceof d.b);
   }

   private Object c(int var1) {
      Object var2 = this.a[var1];
      return this.e ? d(var2) : var2;
   }

   private void a(int var1, Object var2) {
      if (this.e) {
         var2 = e(var2);
      }

      this.a[var1] = var2;
   }

   private Object d(int var1) {
      Object var2 = this.b[var1];
      return this.f ? d(var2) : var2;
   }

   private int a(Object var1, int var2) {
      Object var3;
      if ((var3 = this.c(var2)) == null) {
         return -1;
      }

      if (var1 instanceof Integer) {
         int var4 = (Integer)var1;

         while (true) {
            if (var3 instanceof Integer) {
               int var5 = (Integer)var3;
               if (var4 == var5) {
                  return var2;
               }
            }

            if ((var2 = this.c[var2]) == -1) {
               return -1;
            }

            var3 = this.c(var2);
         }
      } else if (var1 instanceof String) {
         while (!var1.equals(var3)) {
            if ((var2 = this.c[var2]) == -1) {
               return -1;
            }

            var3 = this.c(var2);
         }

         return var2;
      } else {
         while (var1 != var3) {
            if ((var2 = this.c[var2]) == -1) {
               return -1;
            }

            var3 = this.c(var2);
         }

         return var2;
      }
   }

   private int b(Object var1, int var2) {
      int var3;
      while ((var3 = (int)this.c(var2)) != null) {
         try {
            while (this.c(--this.d) != null) {
            }
         } catch (ArrayIndexOutOfBoundsException var10) {
            h var12 = this;
            var3 = this.e;
            boolean var4 = var12.f;
            var12.a(false, false);
            Object[] var5 = var12.a;
            Object[] var6 = var12.b;
            int var7 = var5.length;
            int var8 = 0;
            int var9 = var7;

            while (var9-- > 0) {
               if (var12.a[var9] != null && var12.b[var9] != null) {
                  var8++;
               }
            }

            var8 = 2 * b(var8);
            var12.a = new Object[var8];
            var12.b = new Object[var8];
            var12.c = new int[var8];
            var12.d = var8;
            var9 = var7;

            while (var9-- > 0) {
               Object var16;
               Object var18;
               if ((var16 = var5[var9]) != null && (var18 = var6[var9]) != null) {
                  var12.a(var16, var18);
               }
            }

            var12.a(var3, var4);
            var2 = this.c(var1);
            this = this;
            continue;
         }

         if ((var3 = this.c(var3)) == var2) {
            this.a(this.d, var1);
            this.c[this.d] = this.c[var2];
            return this.c[var2] = this.d;
         }

         this.a[this.d] = this.a[var2];
         this.b[this.d] = this.b[var2];
         this.c[this.d] = this.c[var2];
         this.a(var2, var1);
         this.c[var2] = -1;
         var1 = var3;

         while ((var3 = this.c[var1]) != var2) {
            var1 = var3;
         }

         this.c[var1] = this.d;
         return var2;
      }

      this.a(var2, var1);
      this.c[var2] = -1;
      return var2;
   }

   private static void g(Object var0) {
      d.a.a(var0 != null, "table index is nil");
   }

   public void a(boolean var1, boolean var2) {
      if (var1 != this.e) {
         this.a(this.a, var1);
         this.e = var1;
      }

      if (var2 != this.f) {
         this.a(this.b, var2);
         this.f = var2;
      }
   }

   private void a(Object[] var1, boolean var2) {
      for (int var3 = var1.length - 1; var3 >= 0; var3--) {
         Object var4 = var1[var3];
         var1[var3] = var2 ? e(var4) : d(var4);
      }
   }
}
