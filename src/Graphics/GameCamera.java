
package Graphics;

import Display.Handler;
import GameObject.GameObject;
import Graphics.Tiles.Tile;

/**
 * Se encarga de la camara
 */
public class GameCamera {

    private float xOffset, yOffset;
    private Handler handler;
    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        
    }

    /**
     * No mostrar nada fuera del limite de mapa
     */
    public void checkBlankSpace() {  

        if (xOffset < 0) {
            xOffset = 0;

        }else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }
            
        if (yOffset < 0) {
            yOffset = 0;
        }else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){
            yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        }
    }
    

    /**
     * Movimiento de la camara
     * @param xAmt
     * @param yAmt 
     */
    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
       checkBlankSpace();
    }

    /**
     * Centra la camara en el jugador
     * @param e 
     */
    public void centerOnPlayer(GameObject e) {
        xOffset = (float) (e.getPosition().getX() - handler.getGame().getWidth() / 2) + e.getWidth()/2;
        yOffset = (float) (e.getPosition().getY() - handler.getGame().getHeight() / 2+ e.getHeight()/2);
        checkBlankSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
