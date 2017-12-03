package ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class TimelineScrollBar extends BasicScrollBarUI {
	
		@Override
	    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
			g.setColor(Color.BLUE);
	        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
	        paintDecreaseHighlight(g);
	        paintIncreaseHighlight(g);
	    }

	    @Override
	    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
	    	 if(thumbBounds.isEmpty() || !scrollbar.isEnabled())     {
	             return;
	         }

	         int w = 16;
	         int h = 16;

	         Graphics2D g2 = (Graphics2D) g;
	         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);

	         g.translate(thumbBounds.x, thumbBounds.y);

	         g2.setPaint(Color.RED);
	         g2.fill(new Ellipse2D.Double(2, 0, w-1, h-1));

	         g2.setPaint(Color.red);
	         g2.fill(new Ellipse2D.Double(6, 4, 7, 7));

	         g.translate(-thumbBounds.x, -thumbBounds.y);
	    }
}
