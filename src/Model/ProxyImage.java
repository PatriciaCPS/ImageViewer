
package Model;

import View.persistence.RealImage;
import View.persistence.files.FileImageLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.AccessCounter;


public class ProxyImage implements Image {

    private final Image realImage;

    public ProxyImage(File file) {
        this.realImage= new RealImage(file.getName(),this.getStream(file));
    }
    
       private InputStream getStream(File file) {
     try{
        return new BufferedInputStream(new FileInputStream(file));
     }   catch(FileNotFoundException ex){
         Logger.getLogger(FileImageLoader.class.getName()).
                 log(Level.SEVERE,null, ex);
         return null;
     }
    }
    
    @Override
    public String name() {
        return this.realImage.name();
    }

    @Override
    public InputStream stream() {
        Integer count = AccessCounter.getInstance().increment(this.name());
        System.out.println("Se ha accedido al fichero de nombre "+this.name() +
                ": " + count + " veces ");
        return this.realImage.stream();
    }
    
}
