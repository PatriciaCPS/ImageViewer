
import Model.Image;
import View.persistence.files.FileImageLoader;
import imageviewer.MainFrame;
import java.io.File;


public class Main {
   public static void main (String[] args){
       File file = new File("C:\\Users\\lacue\\Downloads");
       FileImageLoader loader = new FileImageLoader(file);
       Image image = loader.load();
       MainFrame mainFrame= new MainFrame(loader);
       mainFrame.getImageDisplay().show(image);
               
       
   }
}
