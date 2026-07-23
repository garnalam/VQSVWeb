import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Vector;

public class b extends DataInputStream {
   private String a;
   private static Vector b = new Vector();

   private b(InputStream var1, String var2) {
      super(var1);
      this.a = var2;
   }

   public static InputStream a(String var0) {
      InputStream var1;
      if ((var1 = b.class.getResourceAsStream(var0)) != null) {
         var1 = new b(var1, var0);
         b.addElement(var1);
         if (b.size() > 10) {
            System.out.println("current size: " + b.size());

            for (int var6 = 0; var6 < b.size(); var6++) {
               b var2 = (b)b.elementAt(var6);

               try {
                  if (var2.available() == 0) {
                     System.out.println("auto close1: " + var2.a);
                     var2.close();
                     var6--;
                  }
               } catch (Exception var4) {
               }
            }

            System.out.println("new size: " + b.size());
            if (b.size() > 10) {
               b var7 = (b)b.elementAt(0);

               try {
                  System.out.println("auto close2: " + var7.a);
                  var7.close();
               } catch (Exception var3) {
               }
            }
         }
      }

      return var1;
   }

   public void close() {
      b.removeElement(this);

      try {
         super.close();
      } catch (Exception var1) {
         System.out.println("close error");
      }
   }
}
