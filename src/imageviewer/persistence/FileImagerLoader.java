package imageviewer.persistence;

import imageviewer.model.Image;
import imageviewer.model.ProxyImage;
import java.io.File;
import java.io.FileFilter;

public class FileImagerLoader implements ImageLoader {
    
    private final File[] files;
    private int current;

    public FileImagerLoader(File folder) {
        this.current = 0;
        this.files = folder.listFiles(imageTypes());
    }

    private FileFilter imageTypes() {
        return (File pathname) -> pathname.getName().endsWith(".jpg");
    }

    @Override
    public Image load() {
        return new ProxyImage(files[current]);
    }

    @Override
    public Image next() {
        if (current == files.length - 1) {
            current = 0;
        } else {
            current++;
        }
        return load();
    }

    @Override
    public Image prev() {
        if (current == 0) {
            current = files.length - 1;
        } else {
            current--;
        }
        return load();
    }
    
}
