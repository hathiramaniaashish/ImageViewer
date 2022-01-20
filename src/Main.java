
import imageviewer.controller.MainFrame;
import imageviewer.model.Image;
import imageviewer.persistence.FileImagerLoader;
import java.io.File;

public class Main {
    
    public static void main(String[] args) {
        File file = new File("images");
        FileImagerLoader loader = new FileImagerLoader(file);
        Image image = loader.load();
        MainFrame mainFrame = new MainFrame(loader);
        mainFrame.getImageDisplay().show(image);
    }
}
