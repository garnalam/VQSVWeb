package game;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class GameMIDLet extends MIDlet {
   private Display b;
   private m c;
   public static GameMIDLet a;

   public GameMIDLet() {
      a = this;
      this.b = Display.getDisplay(this);
      this.c = m.a(this);
      this.b.setCurrent(this.c);
   }

   public void startApp() {
   }

   public void pauseApp() {
   }

   public void destroyApp(boolean var1) {
      this.c = null;
      System.gc();
      if (var1) {
         this.notifyDestroyed();
      }
   }
}
