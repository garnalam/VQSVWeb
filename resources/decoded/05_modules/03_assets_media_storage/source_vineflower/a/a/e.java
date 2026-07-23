package a.a;

import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;
import javax.microedition.media.control.VolumeControl;

public final class e {
   private byte[] a = new byte[]{0, 20, 40, 60, 80, 100};
   private String b = "";
   private byte[][] c = new byte[][]{{2, 2, 0}, {(byte)(this.a.length - 1), (byte)(this.a.length - 1), 1}, {-1, -1, -1}, {0, 0, 0}};
   private int d = 0;
   private int e = 0;
   private Player[] f;
   private short g;
   private Player[] h;
   private static final String[] i = new String[]{"audio/x-tone-seq", "audio/midi", "audio/x-wav", "audio/amr"};
   private VolumeControl j = null;
   private byte k = 0;
   private PlayerListener l = new i(this);
   private PlayerListener m = this.l;

   public e(int var1, int var2, byte var3, String var4) {
      if (this.f == null) {
         this.g = 7;
         this.f = new Player[7];
      }

      this.k = 0;
      this.b = var4;
   }

   public final void a() {
      if (this.f != null) {
         for (int var1 = 0; var1 < this.f.length; var1++) {
            this.f[var1] = null;
         }
      }

      if (this.h != null) {
         for (int var2 = 0; var2 < this.h.length; var2++) {
            this.h[var2] = null;
         }
      }

      this.f = null;
      this.h = null;
   }

   private static Player a(String var0, int var1) {
      try {
         var0.getClass();
         InputStream var3;
         Player var4;
         (var4 = Manager.createPlayer(var3 = b.a(var0), i[var1])).realize();
         var4.prefetch();
         var4.setLoopCount(-1);
         var3.close();
         return var4;
      } catch (Exception var2) {
         var2.printStackTrace();
         return null;
      }
   }

   public final void a(byte[] var1) {
      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var1[var2] != -1 && this.f[var1[var2]] == null) {
            this.f[var1[var2]] = a(this.b + var1[var2] + ".mid", 1);
         }
      }
   }

   private void a(Player var1, int var2, int var3, boolean var4, boolean var5) {
      if (var1 != null) {
         try {
            if (this.c[0][var2] != 0) {
               if (this.k == 1) {
                  if (var5) {
                     var1.addPlayerListener(this.l);
                  } else {
                     var1.addPlayerListener(this.m);
                  }
               }

               var1.prefetch();
               if (var1.getState() == 300) {
                  var1.setLoopCount(var3);
                  if (!var4) {
                     var1.setMediaTime(0L);
                  }

                  this.a(var1, this.a[this.c[0][var2]]);
                  var1.start();
                  return;
               }
            } else {
               var1.stop();
            }

            return;
         } catch (Exception var6) {
         }
      }
   }

   private void a(Player var1, boolean var2) {
      if (var1 != null) {
         try {
            var1.stop();
            if (this.k == 1) {
               if (var2) {
                  var1.removePlayerListener(this.l);
                  return;
               }

               var1.removePlayerListener(this.m);
            }

            return;
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      }
   }

   private void a(Player var1, int var2) {
      try {
         this.j = (VolumeControl)var1.getControl("VolumeControl");
         if (var2 == 0) {
            this.a(1);
         } else {
            this.j.setLevel(var2);
            if (a(var1)) {
               var1.start();
            }
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   public final void a(byte var1) {
      if (this.f != null) {
         for (int var3 = 0; var3 < this.f.length; var3++) {
            Player var2;
            if ((var2 = this.f[var3]) != null) {
               var2.deallocate();
               var2.close();
            }
         }
      }
   }

   private static boolean a(Player var0) {
      try {
         var0.prefetch();
         if (var0.getState() == 300) {
            return true;
         }
      } catch (Exception var1) {
      }

      return false;
   }

   public final void b(byte var1) {
      if (var1 >= this.a.length) {
         var1 = (byte)(this.a.length - 1);
      }

      this.c[2][1] = (byte)this.d;
      this.c[0][1] = var1;
      this.c[0][0] = var1;
      if (this.f != null && this.f[this.d] != null) {
         this.a(this.f[this.d], this.a[this.c[0][1]]);
      }

      if (this.h != null) {
         for (int var2 = 0; var2 < this.h.length; var2++) {
            if (this.h[var2] != null) {
               this.a(this.h[var2], this.a[this.c[0][0]]);
            }
         }
      }
   }

   public final void a(int var1, int var2) {
      this.e = this.d;
      this.d = var1;
      if (var1 >= 0 && var1 < this.g) {
         if (this.c[2][1] == -1 || var1 != this.c[2][1]) {
            int var3 = 1;
            if (this.c[0][var3] == 0) {
               return;
            }

            this.a(1);
            if (this.e != var1 && this.f[this.e] != null) {
               this.f[this.e] = null;
            }

            if (this.f[var1] == null) {
               this.f[var1] = a(this.b + var1 + ".mid", 1);
            }

            byte var5 = 1;
            byte var4 = -1;
            var3 = var1;
            e var6 = this;
            this.a((int)var5);
            var6.c[2][var5] = (byte)var3;
            var6.c[3][var5] = (byte)var4;
            this.a(this.f[var1], 1, -1, false, true);
            return;
         }
      } else if (var1 == -2 || var1 == -1) {
         this.a(1);
         return;
      }
   }

   private void a(int var1) {
      switch (var1) {
         case 0:
            if (this.c[2][0] >= 0) {
               this.a(this.h[this.c[2][0]], false);
               return;
            }
            break;
         case 1:
            if (this.c[2][1] >= 0) {
               this.a(this.f[this.c[2][1]], true);
            }
         case 2:
      }
   }

   public final void b() {
      this.a(0);
      this.a(1);
   }

   public final void c() {
      e var1 = this;
      if (this.c[2][1] != -1) {
         var1.a(var1.f[var1.c[2][1]], 1, var1.c[3][1], var1.k == 0, true);
      }

      if (var1.c[2][0] != -1) {
         var1.a(var1.h[var1.c[2][0]], 0, var1.c[3][0], var1.k == 0, false);
      }
   }

   static byte[][] a(e var0) {
      return var0.c;
   }
}
