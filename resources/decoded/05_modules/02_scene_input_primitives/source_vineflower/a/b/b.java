package a.b;

public final class b extends a.b.a {
   private static a.b.b b;
   public byte a = -1;
   private int c;
   private int u;
   private int v;
   private boolean w = true;

   public b() {
      this.a = 0;
   }

   public static a.b.b a() {
      if (b == null) {
         b = new a.b.b();
      }

      return b;
   }

   public final void a(int var1) {
      this.v = var1;
   }

   public final void a(boolean var1) {
      this.w = false;
   }

   public final void a(int var1, int var2, int var3, int var4, boolean var5) {
      this.a = 0;
      this.w = var5;
      if (this.w) {
         this.j = var1;
         this.k = var2;
      } else {
         var3 = var2;
         var2 = var1;
         a.b.b var6 = this;
         super.r = var2;
         var6.s = var3;
      }
   }

   public final void a(a.b.a var1, int var2, int var3, boolean var4) {
      this.a = 1;
      a.b.a var5 = var1;
      super.q = var5;
      this.w = var4;
      if (this.w) {
         this.j = this.q.j;
         this.k = this.q.k;
      }
   }

   public final boolean b() {
      return this.w;
   }

   public final void c() {
      switch (this.a) {
         case 0:
            if (!this.w && this.a(this.v, this.r, this.s)) {
               this.w = true;
               return;
            }
            break;
         case 1:
            if (this.w) {
               this.j = this.q.j;
               this.k = this.q.k;
               return;
            }

            if (this.a(this.v, this.q.j, this.q.k)) {
               this.w = true;
               return;
            }
            break;
         case 2:
            if (this.w) {
               return;
            }

            if (this.c > 0) {
               this.c--;
               return;
            }

            if (this.j == ((Object[])null)[0] && this.k == ((Object[])null)[1]) {
               if (this.u < ((Object[])null).length) {
                  this.u++;
                  this.c = ((Object[])null)[5];
                  return;
               }

               this.w = true;
               return;
            }

            this.a(((Object[])null)[2], ((Object[])null)[0], ((Object[])null)[1]);
      }
   }
}
