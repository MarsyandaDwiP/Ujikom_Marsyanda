/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry.style;

/**
 *
 * @author KIMSUL
 */
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author maulana.net
 */
public class buttonRounded extends JTextField{
  public buttonRounded (){
        super();
        setBorder(new EmptyBorder(4,4,4,4));
    }
  @Override
    protected void paintComponent(final Graphics g){
        if (isOpaque()){
            setOpaque(false);
        }
        final RoundRectangle2D.Double round = new RoundRectangle2D.Double(0,0, getWidth(), getHeight(), getHeight(), getHeight());
        final Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint paint = new GradientPaint(0,0, Color.white, 0, getHeight(), Color.white);
        g2.setPaint(paint);
        g2.fill(round);
     
        g2.setPaint(paint);
        g2.fill(round);
        g2.setColor(Color.white);
        g2.draw(round);
        super.paintComponent(g);
    }
} 