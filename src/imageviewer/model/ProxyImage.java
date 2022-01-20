package imageviewer.model;

import imageviewer.persistence.FileImagerLoader;
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
        this.realImage = new RealImage(file.getName(), getStream(file));
    }
    
    public InputStream getStream(File file) {
        try {
            return new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileImagerLoader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public String name() {
        return realImage.name();
    }

    @Override
    public InputStream stream() {
        Integer count = AccessCounter.getInstance().increment(name());
        System.out.printf("File '%s' accessed '%d' times\n", name(), count);
        return realImage.stream();
    }
    
}
