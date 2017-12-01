package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import model.Event;

public class TimelinePanel extends JPanel{
	
	//testing purposes only 
	List<Event> events = new ArrayList<Event>();
	
	public TimelinePanel (){
		super(); 
		this.setBackground(Color.YELLOW);
		Event e1 = new Event("Title1", "desc", "121212", "121212"); 
		Event e2 = new Event("Title1", "desc", "121212", "121212"); 
		Event e3 = new Event("Title1", "desc", "121212", "121212"); 
		Event e4 = new Event("Title1", "desc", "121212", "121212"); 
		events.add(e1); 
		events.add(e2); 
		events.add(e3); 
		events.add(e4);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		AffineTransform restoreTransform = g2.getTransform();
		
		// Draw axis lines
		g2.setColor(Color.BLACK);
		
		//Start position timeline on screen
		double timelineStartPosX = 200.00;
		//Preferred total Width timeline (offset from timelineX1)
		double timelineEndPosX = 1000.0;
		//Hight position on screen of timeline
		double timelineHeightPosY =500.0; 
		
		//start position first event line
		double eventStartPosX = timelineStartPosX;
		//Start position height event line
		double eventHeightPosY = timelineHeightPosY; 
		//Draw line for one event depending on number of events in DB
		double eventOffset = (timelineEndPosX/this.events.size());
		double eventVerticalStripeHeight = 200; 
		
		//Width Rectangle (equally wide as one event on timeline)
		double RectangleWitdh = (eventOffset*2)*0.75; 
		double rectangleStartPosX = timelineStartPosX-(RectangleWitdh/2);
		double rectangleHeightPosY1 = timelineHeightPosY; 
		double rectangleHeight = eventVerticalStripeHeight; 
		
		for(int i = 0;i<events.size() ; i++){
			//Draw line for every event depending on preferred width of timeline
			g2.draw(new Line2D.Double(eventStartPosX+i*eventOffset,eventHeightPosY,eventStartPosX + (i+1)*eventOffset , eventHeightPosY ));
			
			
			//If event index
			if(i==0 || i%2 == 0){
			System.out.println("W = "+RectangleWitdh);
			System.out.println("StartX = "+rectangleStartPosX);
			System.out.println("H Y1 = "+rectangleHeightPosY1);
			System.out.println("H Y2 = "+rectangleHeight);
			RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float((int) (rectangleStartPosX+i*eventOffset), (int) (rectangleHeightPosY1-2*eventVerticalStripeHeight), (int) RectangleWitdh, (int) rectangleHeight, 100, 100);
	        
			g2.draw(roundedRectangle); 
			int textX = (int) (rectangleStartPosX+i*eventOffset)+30;
			int textY = (int) (rectangleHeightPosY1-eventVerticalStripeHeight);
			g2.drawString("Title : "+events.get(i).getTitle(), textX , textY -140 );
			g2.drawString("Description : "+events.get(i).getDescription(), textX , textY-110 );
			g2.drawString("Start Date : "+events.get(i).getStartDate(), textX , textY -80);
			g2.drawString("End Date : "+events.get(i).getEndDate(), textX , textY -50);
		
			g2.draw(new Line2D.Double(eventStartPosX+i*eventOffset,eventHeightPosY,eventStartPosX + i*eventOffset , eventHeightPosY -eventVerticalStripeHeight));
			}else{
				g2.draw(new Line2D.Double(eventStartPosX+i*eventOffset,eventHeightPosY,eventStartPosX + i*eventOffset , eventHeightPosY +eventVerticalStripeHeight));
				RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float((int) (rectangleStartPosX+i*eventOffset), (int) (rectangleHeightPosY1+eventVerticalStripeHeight), (int) RectangleWitdh, (int) rectangleHeight, 100, 100);  		
				g2.draw(roundedRectangle);
				int textX = (int) (rectangleStartPosX+i*eventOffset)+30;
				int textY = (int) (rectangleHeightPosY1+eventVerticalStripeHeight);
				g2.drawString("Title : "+events.get(i).getTitle(), textX , textY +50 );
				g2.drawString("Description : "+events.get(i).getDescription(), textX , textY+80 );
				g2.drawString("Start Date : "+events.get(i).getStartDate(), textX , textY +110);
				g2.drawString("End Date : "+events.get(i).getEndDate(), textX , textY +140);
			}
		}
		
		
		// Draw axis labels
		Font F = new Font("Arial", Font.PLAIN, 18);
		g2.setFont(F);
		
		
		
		// Restore transformation (since we don't want everything else rotated!)
		g2.setTransform(restoreTransform);
		

	}
}
	


