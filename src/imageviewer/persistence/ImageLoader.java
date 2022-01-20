package imageviewer.persistence;

import imageviewer.model.Image;

public interface ImageLoader {
    
    public Image load();
    public Image next();
    public Image prev();
    
}
