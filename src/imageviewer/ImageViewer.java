
package imageviewer;

import Model.Image;
import View.persistence.files.FileImageLoader;
import java.io.File;


public class ImageViewer {

    public static void main(String[] args) {
        
       File file = new File("C:\\Users\\lacue\\Desktop\\carpeta prueba");
       FileImageLoader loader = new FileImageLoader(file);
       Image image = loader.load();
       MainFrame mainFrame= new MainFrame(loader);
       mainFrame.getImageDisplay().show(image);
            
    }
    
}
