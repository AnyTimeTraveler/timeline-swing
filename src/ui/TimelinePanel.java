package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class TimelinePanel extends JPanel{
	
	public TimelinePanel (){
		super(); 
		this.setBackground(Color.YELLOW);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		AffineTransform restoreTransform = g2.getTransform();
		
		// Draw axis lines
		g2.setColor(Color.BLACK);
		g2.draw(new Line2D.Double(40.0, 280.0, 560.0, 280.0));
		
		
		// Draw axis labels
		Font F = new Font("Arial", Font.PLAIN, 18);
		g2.setFont(F);
		
		
		
		// Restore transformation (since we don't want everything else rotated!)
		g2.setTransform(restoreTransform);
		

	}
}
	


