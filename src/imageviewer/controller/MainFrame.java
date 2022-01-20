package imageviewer.controller;

import imageviewer.persistence.ImageLoader;
import imageviewer.ui.ImageDisplay;
import imageviewer.ui.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
    
    private ImageDisplay imageDisplay;
    final ImageLoader imageLoader;

    public MainFrame(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
        
        setTitle("Image Viewer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().add(imageDisplay());
        getContentPane().add(toolBar(), BorderLayout.SOUTH);
        setVisible(true);
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
    

    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay();
        imageDisplay = sid;
        return sid; 
    }

    private JPanel toolBar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;    }

    private ActionListener prevImage() {
        return e -> imageDisplay.show(imageLoader.prev());
    }

    private ActionListener nextImage() {
        return e -> imageDisplay.show(imageLoader.next());
    }
    
}
