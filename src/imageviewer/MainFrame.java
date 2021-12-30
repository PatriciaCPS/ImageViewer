
package imageviewer;

import View.persistence.ImageLoader;
import imageviewer.viewUI.Swing.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
    SwingImageDisplay imageDisplay;
    final ImageLoader imageLoader;
    
    public MainFrame(ImageLoader imageLoader){
        this.imageLoader = imageLoader;
        
        this.setTitle("Image Viewer");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.getContentPane().add(image());
        this.getContentPane().add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }
    private Component image(){
     SwingImageDisplay swingImageDisplay = new SwingImageDisplay();
     this.imageDisplay = swingImageDisplay;
     return swingImageDisplay;
     
    }
    
    public SwingImageDisplay getImageDisplay(){
    return this.imageDisplay;
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }
    
    private JButton prevButton(){
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
        
    }

    private ActionListener prevImage() {
        return (ActionEvent e) -> {
            imageDisplay.show(imageLoader.prev());
        };
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }
    
    private ActionListener nextImage() {
        return (ActionEvent e) -> {
            imageDisplay.show(imageLoader.next());
        };
    }
    
    private JPanel imageDisplay(){
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }
    
    
}
