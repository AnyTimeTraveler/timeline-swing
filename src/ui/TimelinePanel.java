package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.border.LineBorder;

import model.Event;

public class TimelinePanel extends JPanel{
	
	//testing purposes only 
	List<Event> events = new ArrayList<Event>();
	private Graphics2D g2; 
	//Start position timeline on screen
			private double timelineStartPosX;
			//Preferred total Width timeline (offset from timelineX1)
			private double timelineEndPosX;
			//Hight position on screen of timeline
			private double timelineHeightPosY; 
			
			//start position first event line
			private double eventStartPosX;
			//Start position height event line
			private double eventHeightPosY; 
			//Draw line for one event depending on number of events in DB
			private double eventOffset;
			private double eventVerticalStripeHeight; 
			
			//Width Rectangle (equally wide as one event on timeline)
			private double RectangleWitdh; 
			private double rectangleStartPosX;
			private double rectangleHeightPosY1; 
			private double rectangleHeight; 
			
	public TimelinePanel (){
		super(); 
		setData();
		timelineEndPosX = 2000.0;
		eventOffset = (timelineEndPosX/this.events.size());
		timelineStartPosX = eventOffset*0.75+0.00;
		eventVerticalStripeHeight = 100; 
		timelineHeightPosY =eventVerticalStripeHeight*2; 
		eventStartPosX = timelineStartPosX;
		eventHeightPosY = timelineHeightPosY; 
		RectangleWitdh = (eventOffset*2)*0.75; 
		rectangleStartPosX = timelineStartPosX-(RectangleWitdh/2);
		rectangleHeightPosY1 = timelineHeightPosY; 
		rectangleHeight = eventVerticalStripeHeight; 
	}
	
	private void setData(){
		List<Event> newEvents = new ArrayList<Event>();
		Event e1 = new Event("Title1", "desc", "121212", "121212"); 
		Event e2 = new Event("Title1", "desc", "121212", "121212"); 
		Event e3 = new Event("Title1", "desc", "121212", "121212"); 
		Event e4 = new Event("Title1", "desc", "121212", "121212"); 
		newEvents.add(e1); 
		newEvents.add(e2); 
		newEvents.add(e3); 
		newEvents.add(e4);
		newEvents.add(e1); 
		newEvents.add(e2); 
		newEvents.add(e3); 
		newEvents.add(e4);
		newEvents.add(e1); 
		newEvents.add(e2); 
		newEvents.add(e3); 
		newEvents.add(e4);
		this.events = newEvents; 
	}
	
	@Override
	    public Dimension getPreferredSize() {
			int w =(int) ((timelineEndPosX-timelineStartPosX)+RectangleWitdh)+50;
			int h = (int) (timelineHeightPosY+this.eventVerticalStripeHeight+this.rectangleHeight)+50;
	        return new Dimension(w, h);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		
		AffineTransform restoreTransform = g2.getTransform();
		
		// Set timeline color
		g2.setColor(Color.BLACK);
		
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
	


