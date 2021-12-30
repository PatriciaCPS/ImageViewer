
package View.persistence.files;

import Model.Image;
import View.persistence.ImageLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        return new Image() {
            @Override
            public String name() {
                return files[current].getName();
            }

            @Override
            public InputStream stream() {
                try {
                    return new BufferedInputStream
                            (new FileInputStream(files[current]));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FileImageLoader.class.getName()).
                            log(Level.SEVERE, null, ex);
                    return null;
                }
            }
        };
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
