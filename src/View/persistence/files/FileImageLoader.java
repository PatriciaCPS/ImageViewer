
package View.persistence.files;

import Model.Image;
import Model.ProxyImage;
import View.persistence.ImageLoader;
import java.io.File;
import java.io.FileFilter;


public class FileImageLoader implements ImageLoader {
    
    private final File[] files;
    private int current;
    
    public FileImageLoader(File folder){
        this.files = folder.listFiles(withImageExtensions());
        this.current=0;
            
    }
    private FileFilter withImageExtensions() {
        return  (File pathname) -> pathname.getName().endsWith(".jpg");
      
    }

    @Override
    public Image load() {      
        return new ProxyImage(this.files[this.current]);
    }

 
    @Override
    public Image next() {
        if (current == this.files.length-1){
            this.current=0;
        } else {
            this.current++;
        }
        return this.load();
    }

    @Override
    public Image prev() {
        if (current == 0){
            this.current=this.files.length-1;
        } else {
            this.current--;
        }
        return this.load();
    }
 

    
    
}
