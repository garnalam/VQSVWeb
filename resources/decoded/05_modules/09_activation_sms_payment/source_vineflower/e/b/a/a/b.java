package e.b.a.a;

import java.io.IOException;
import javax.microedition.io.Connector;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

public final class b implements Runnable {
   private e.b.a.a.a a = null;
   private String b;
   private boolean c = false;
   private Thread d = null;

   public b() {
      Class.forName("javax.wireless.messaging.Message");
      this.a = null;
      if (this.d == null) {
         this.d = new Thread(this);
         this.d.start();
      }
   }

   public b(e.b.a.a.a var1) {
      Class.forName("javax.wireless.messaging.Message");
      this.a = var1;
      if (this.d == null) {
         this.d = new Thread(this);
         this.d.start();
      }
   }

   public final synchronized void a(String var1) {
      this.b = var1;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public final void run() {
      while (true) {
         synchronized (this) {
            try {
               this.wait();
            } catch (Exception var20) {
            }

            int var2;
            String var27;
            if ((var2 = null.length()) >= 3 && null.substring(0, 3) == "+86") {
               var27 = null.substring(3);
            } else if (var2 > 0 && null.substring(0, 1) == "+") {
               var27 = null.substring(1);
            } else {
               var27 = null;
            }

            MessageConnection var3 = null;

            try {
               String var28 = this.b + var27;
               boolean var19 = false /* VF: Semaphore variable */;

               label196: {
                  try {
                     var19 = true;
                     TextMessage var4;
                     (var4 = (TextMessage)(var3 = (MessageConnection)Connector.open(var28)).newMessage("text")).setAddress(var28);
                     var4.setPayloadText(null);
                     var3.send(var4);
                     var19 = false;
                     break label196;
                  } catch (Exception var21) {
                     System.out.println(var21.getMessage());
                     var19 = false;
                  } finally {
                     if (var19) {
                        if (var3 != null) {
                           var3.close();
                        }

                        if (this.a != null) {
                           this.a.b(false);
                        }
                     }
                  }

                  if (var3 != null) {
                     var3.close();
                  }

                  if (this.a != null) {
                     this.a.b(false);
                  }
                  continue;
               }

               if (var3 != null) {
                  var3.close();
               }

               if (this.a != null) {
                  this.a.b(true);
               }
            } catch (IOException var23) {
               System.out.println(var23.getMessage());
            } catch (Exception var24) {
               System.out.println(var24.getMessage());
            } finally {
               this.c = false;
            }
         }
      }
   }
}
