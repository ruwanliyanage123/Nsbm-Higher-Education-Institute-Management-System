package nsbm_higher_education.student; 
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

public class AddDashboardBackround implements Border{
    private BufferedImage image;
    
    public AddDashboardBackround(BufferedImage image){
        this.image = image;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        int x1 = x+(width-image.getWidth())/2;
        int y1 = y+(height-image.getHeight())/2;
        g.drawImage(image, x1, y1, null);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true; 
    }
}