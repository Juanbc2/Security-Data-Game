package Input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase encargada de leer las entradas por mouse
 */
public class Mouse extends MouseAdapter {

    public static int X, Y;
    public static boolean MLB;

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            MLB = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            MLB = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        X = me.getX();
        Y = me.getY();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        X = me.getX();
        Y = me.getY();
    }

}
