package a.a;

import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;

final class i implements PlayerListener {
   private final e a;

   i(e var1) {
      this.a = var1;
   }

   public final void playerUpdate(Player var1, String var2, Object var3) {
      if (e.a(this.a)[0][1] != 0) {
         if (var2.equals("deviceUnavailable")) {
            try {
               var1.stop();
               return;
            } catch (Exception var4) {
               return;
            }
         }

         if (var2.equals("deviceAvailable") || var2.equals("volumeChanged")) {
            try {
               var1.start();
               return;
            } catch (Exception var5) {
            }
         }
      }
   }
}
