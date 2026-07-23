package a.b;

public class a {
   public short[] d;
   public short[] e;
   protected boolean f;
   protected boolean g;
   protected boolean h;
   protected byte i;
   public int j;
   public int k;
   public int l;
   public int m;
   public byte n;
   public byte o;
   public byte p;
   public a.b.a q;
   public int r;
   public int s;
   public int t;
   private short a = 10;
   private int[][] b;
   private boolean c = false;

   public final void a(byte var1, short var2) {
      this.d[var1] = var2;
   }

   public final void b(byte var1, short var2) {
      this.e[var1] = var2;
   }

   public final short b(byte var1) {
      return this.d[var1];
   }

   public final short c(byte var1) {
      return this.e[var1];
   }

   public void h() {
      for (byte var1 = 0; var1 < this.d.length; var1++) {
         byte var3 = var1;
         short var4 = this.d[var3];
         var3 = var1;
         this.e[var3] = var4;
      }
   }

   public final byte i() {
      return this.i;
   }

   public final void b(boolean var1) {
      this.f = var1;
   }

   public final boolean j() {
      return this.f;
   }

   public final void c(boolean var1) {
      this.g = var1;
   }

   public final boolean k() {
      return this.g;
   }

   public final void d(boolean var1) {
      this.h = var1;
   }

   public final boolean l() {
      return this.h;
   }

   public final void c(int var1) {
      this.j = var1;
   }

   public void b(int var1, int var2) {
      this.j = var1;
      this.k = var2;
   }

   public final void d(byte var1) {
      this.o = var1;
   }

   public final int m() {
      return this.j;
   }

   public final int n() {
      return this.k;
   }

   public final void d(int var1) {
      this.j += var1;
   }

   public final void e(int var1) {
      this.k += var1;
   }

   public void a(int var1, int var2) {
      this.j += var1;
      this.k += 4;
   }

   public final boolean a(int var1, int var2, int var3) {
      if (this.j == var2 && this.k == var3) {
         return true;
      }

      int var4;
      if ((var4 = a.e.a(this.j, this.k, var2, var3)) < var1) {
         this.j = var2;
         this.k = var3;
      } else {
         this.d((var2 - this.j) * var1 / var4);
         this.e((var3 - this.k) * var1 / var4);
      }

      return false;
   }

   public final void a(g var1, g var2) {
      if (this.c) {
         if (this.q.i != 0) {
            this.b[0][0] = this.q.j;
            this.b[0][1] = this.q.k;
            this.b[0][2] = var1.b;
            this.b[0][3] = this.q.o;

            for (int var5 = this.a; var5 > 0; var5--) {
               this.b[var5][0] = this.b[var5 - 1][0];
               this.b[var5][1] = this.b[var5 - 1][1];
               this.b[var5][2] = this.b[var5 - 1][2];
               this.b[var5][3] = this.b[var5 - 1][3];
               if (var5 % this.a == 0) {
                  this.b(this.b[var5][0], this.b[var5][1]);
                  if (this.b[var5][3] == 3) {
                     var2.a((byte)this.b[var5][2], (byte)1, false);
                  } else {
                     var2.a((byte)this.b[var5][2], (byte)this.b[var5][3], false);
                  }

                  byte var4 = (byte)this.b[var5][3];
                  this.o = var4;
               }
            }
         }
      }
   }

   public final void e(byte var1) {
      this.c = true;
      this.b = new int[this.a + 1][4];

      for (int var2 = 0; var2 < this.a + 1; var2++) {
         this.b[var2][0] = this.q.j;
         this.b[var2][1] = this.q.k;
         this.b[var2][3] = this.q.o;
      }

      if (var1 >= 0) {
         for (int var3 = 0; var3 < this.a + 1; var3++) {
            this.b[var3][2] = var1;
         }
      }

      switch (this.q.o) {
         case 0:
            this.b[10][1] = this.b[10][1] - this.a;
            break;
         case 1:
            this.b[10][0] = this.b[10][0] - this.a;
            break;
         case 2:
            this.b[10][1] = this.b[10][1] + this.a;
            break;
         case 3:
            this.b[10][0] = this.b[10][0] + this.a;
      }

      this.b(this.b[10][0], this.b[10][1]);
   }

   public final boolean o() {
      return this.c;
   }

   public final void a(a.b.a var1) {
      this.q = var1;
   }
}
