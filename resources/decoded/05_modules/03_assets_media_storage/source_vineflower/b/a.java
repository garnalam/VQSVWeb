package b;

import java.io.DataInputStream;
import java.util.Vector;

public final class a {
   private b.b[] a;
   private byte b;
   private Vector c;
   private byte d;
   private byte e;
   private int f;

   public final void a(DataInputStream var1, byte var2, int var3, String[] var4) {
      this.b = (byte)var2;
      this.f = var3;
      var2 = var1.readShort();
      this.a = new b.b[var2];
      this.c = new Vector();

      for (int var7 = 0; var7 < var2; var7++) {
         this.a[var7] = new b.b();
         this.a[var7].a(var1, var4);
         this.c.addElement(this.a[var7]);
      }

      byte var6 = 0;
      this.e = var6;
   }

   public final byte a() {
      return this.e;
   }

   public final void a(byte var1) {
      this.e = var1;
   }

   public final byte b() {
      return this.b;
   }

   public final void b(byte var1) {
      this.d = var1;
   }

   public final b.b c() {
      return this.d >= this.c.size() ? null : (b.b)this.c.elementAt(this.d);
   }

   public final b.b d() {
      return (b.b)this.c.firstElement();
   }

   public final void e() {
      this.c();
      this.d++;
      if (this.d >= this.c.size()) {
         this.d = 0;
      }
   }

   public final int[] f() {
      if (this.f == -1) {
         return null;
      }

      int[] var1;
      (var1 = new int[2])[0] = this.f >> 8 & 0xFF;
      var1[1] = this.f & 0xFF;
      return var1;
   }
}
