
package imageviewer.viewUI.Swing;

import Model.Image;
import imageviewer.viewUI.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay{

    private Image image;
    
    public SwingImageDisplay(){
        super(new BorderLayout());
    }
  
    @Override 
    public void show(Image image) {
        this.image= image;
        this.repaint();
    }
    @Override
    public void paint(Graphics g) {
        if(image== null) return;try {
            g.drawImage(imageOf(image),
                    0,
                    0,
                    this.getWidth(),
                    this.getHeight(),
                    null);
        } catch (IOException ex) {
            Logger.getLogger(SwingImageDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
} 
    
    private BufferedImage imageOf(Image image) throws IOException{
        try{
            return ImageIO.read(image.stream());
        } catch(IOException ex){
            Logger.getLogger(SwingImageDisplay.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Image current() {
        return image;
    }
    
}
