package Graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * Facilita la carga de recursos
 */
public class Loader {

    public static BufferedImage ImageLoader(String path) throws IOException {

        return ImageIO.read(Loader.class.getResource(path));

    }
    
    public static Font loadFont(String path,int size) throws FontFormatException, IOException{
        return Font.createFont(Font.TRUETYPE_FONT,Loader.class.getResourceAsStream(path)).deriveFont(Font.PLAIN,size);
    }
    
    public static Clip loadSound(String path) throws LineUnavailableException, UnsupportedAudioFileException, IOException{
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(Loader.class.getResource(path)));
        return clip;
    }
}
