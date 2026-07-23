/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Font
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public final class ae {
    private static int b(String string, int n2) {
        int n3 = 0;
        int n4 = 0;
        while (n4 < string.length()) {
            char c2 = string.charAt(n4);
            if (c2 == '\n') {
                return n4 + 1;
            }
            if ((n3 += u.b(c2)) > n2) {
                return n4;
            }
            ++n4;
        }
        return 0;
    }

    public static int b(String string) {
        return u.b(string);
    }

    public static int[] b(Graphics graphics, String string, Font font, int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8 = 0;
        n5 = 0;
        while (true) {
            if ((n7 = t.b(string, n2)) == 0) break;
            String string2 = string.charAt(n7 - 1) == '\n' ? string.substring(0, n7 - 1) : string.substring(0, n7);
            if (n8 >= n4 && n6 < n3) {
                u.b(graphics, string2, 5, n6, 0);
                n6 = n6 + u.b + 5;
            }
            if (n6 >= n3) {
                ++n5;
            }
            ++n8;
            string = string.substring(n7, string.length());
        }
        u.b(graphics, string, 5, n6, 0);
        return new int[]{n6, n5};
    }
}

