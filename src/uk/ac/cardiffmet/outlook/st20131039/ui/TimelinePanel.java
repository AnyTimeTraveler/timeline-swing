package uk.ac.cardiffmet.outlook.st20131039.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class TimelinePanel extends JPanel {

	/**
	 * Json String with all the events to display on the timeline.
	 */
	private String events; 
	
	/**
	 * Height of the TimelinePanel
	 */
	private int panelHeight;
	
	/**
	 * Width of the TimelinePanel
	 */
	private int panelWidth;
	
	/**
	 * Height of timeline
	 */
	private int timelineHeight; 
	
	/**
	 * Color of the border of the timeline
	 */
	private Color blue; 
	
	/**
	 * Timeline graphics
	 */
	private Graphics2D g2;
	
	/**
	 * Initialises params and set default config
	 * @param panelWidth Width of the TimelinePanel
	 * @param panelHeight Height of the TimelinePanel
	 * @param events All events to display
	 */
	public TimelinePanel(int panelWidth, int panelHeight, String events) {
		super();	
		blue = new Color(29, 84, 173);
		this.panelHeight = panelHeight;
		this.panelWidth = 2000;
		this.timelineHeight = panelHeight-100; 
		this.events = events; 
	}
	
	/**
	 * Get The Y1 value of the timeline
	 * @return int Y1 value of the timeline
	 */
	private int getTimelineY1(){
		return this.timelineHeight/2+(this.panelHeight-this.timelineHeight)/2; 
	}
	
	/**
	 * Get The Y2 value of the timeline
	 * @return int Y2 value of the timeline
	 */
	private int getTimelineY2(){
		return this.getTimelineY1(); 
	}
	
	/**
	 * Get The X1 value of the timeline
	 * @return int X1 value of the timeline
	 */
	private int getTimelineX1(){
		return this.getRectangleWidth()/2; 
	}
	
	/**
	 * Get The X2 value of the timeline
	 * @return int X2 value of the timeline
	 */
	private int getTimelineX2(){
		return panelWidth + this.getRectangleWidth()/2; 
	}
	
	/**
	 * Get The width value of the rectangle. This is based on the width of the event
	 * @return int width value of the rectangle
	 */
	private int getRectangleWidth(){
		return this.getEventWidth(); 
	}
	
	/**
	 * Get The height value of the rectangle.
	 * @return int height value of the rectangle
	 */
	private int getRectangleHeight(){
		//rectangle rectangles equals 3/7th of timeline.
		return (int) (this.timelineHeight*(3.0/7.0)); 
	}
	
	/**
	 * Get The X1 value of the rectangle. This is based on the order the the events
	 * @param eventSequenceNumber number of event in array
	 * @return int X1 value of the rectangle
	 */
	private int getRectangleX1(int eventSequenceNumber){
		return eventSequenceNumber*this.getEventWidth(); 
	}
	
	/**
	 * Get The Y1 value of the rectangle. This is based on the position of the event
	 * @param direction up or down depending on position in array
	 * @return int Y1 value of the rectangle
	 */
	private int getRectangleY1(String direction){
		int y1; 
		switch(direction){
		case "up":
			y1 = this.getTimelineX1()-(this.getRectangleWidth()/2)+(this.panelHeight-this.timelineHeight)/2; 
			break; 
		case "down":
			y1 = this.getTimelineX1()-(this.getRectangleWidth()/2)+this.getTimelineEventStripeHeight()*2+this.getRectangleHeight()+(this.panelHeight-this.timelineHeight)/2+1; 
			break;
		default: 
			y1 =  this.getTimelineX1()-(this.getRectangleWidth()/2); 
		}
		return y1; 
	}
	
	/**
	 * Get the height of the vertical stripe of one event
	 * @return int height of the vertical stripe of one event
	 */
	private int getTimelineEventStripeHeight(){
		//The timeline between the 2 rectangles equals 1/7th of timeline. The horizontal stripe is negligible
		return (int) (this.timelineHeight*(1.0/7.0)/2); 
	}
	
	/**
	 * Get The X1 value of the stripe. This is based on the order the the events
	 * @param eventSequenceNumber position of event in array
	 * @return int X1 value of the stripe
	 */
	private int getTimelineEventStripeX1(int eventSequenceNumber){
		return this.getTimelineX1()+eventSequenceNumber*this.getEventWidth(); 
	}
	
	/**
	 * Get The X2 value of the stripe. This is based on the order the the events
	 * @param eventSequenceNumber The position of event in array
	 * @return int X2 value of the stripe
	 */
	private int getTimelineEventStripeX2(int eventSequenceNumber){
		return this.getTimelineEventStripeX1(eventSequenceNumber);
	}

	/**
	 * Get The Y1 value of the stripe
	 * @return int Y1 value of the stripe
	 */
	private int getTimelineEventStripeY1(){
		return this.getTimelineY1(); 
	}

	/**
	 * Get The Y1 value of the stripe
	 * @param direction up or down depending on position in array
	 * @return int Y1 value of the stripe
	 */
	private int getTimelineEventStripeY2(String direction){
		int y2; 
		switch(direction){
		case "down":
			y2 = this.getTimelineEventStripeY1() + this.getTimelineEventStripeHeight();
			break; 
		case "up":
			y2 = this.getTimelineEventStripeY1() - this.getTimelineEventStripeHeight();
			break; 
		default: 
			y2 = 0;  
		}
		return y2; 
	}
	
	/**
	 * Get width of one event
	 * @return int width of one event
	 */
	private int getEventWidth(){
		JsonElement root = new JsonParser().parse(this.events);
		int size = root.getAsJsonObject().entrySet().size(); 
		return this.panelWidth/size; 
	}
	
	/**
	 * Get The X1 value of the label
	 * @param eventSequenceNumber The position of event in array
	 * @return int X1 value of the label
	 */
	private int getYearLabelX1(int eventSequenceNumber){
		return this.getTimelineEventStripeX1(eventSequenceNumber);
	}
	
	/**
	 * Get The Y1 value of the label
	 * @param direction up or down depending on position in array
	 * @return int Y1 value of the label
	 */
	private int getYearLabelY1(String direction){
		int y1; 
		switch(direction){ 
			case "up": 
				y1 = this.getTimelineEventStripeY1(); 
				break; 
			case "down": 
				y1 = this.getTimelineEventStripeY1(); 
				break; 
			default: 
				y1 = this.getTimelineEventStripeY1(); 
		}
			
		return y1; 
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(this.panelWidth, this.panelHeight);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g2 = (Graphics2D) g;
		
		// Set timeline color
		g2.setColor(this.blue);
		 g2.setStroke(new BasicStroke(4.0f));

		//Draw horizontal Timeline line
		g2.draw(new Line2D.Double(this.getTimelineX1(), this.getTimelineY1(), this.getTimelineX2(), this.getTimelineY2()));

		JsonElement root = new JsonParser().parse(this.events);
		boolean isOdd = false; 
		int i = 0;
		for (Map.Entry<String,JsonElement> entry : root.getAsJsonObject().entrySet()) {
		{
			System.out.println("#loop = "+i);
			if (isOdd) {
		    
		    	//Draw vertical stripe
				g2.draw(new Line2D.Double(this.getTimelineEventStripeX1(i), this.getTimelineEventStripeY1(),
						this.getTimelineEventStripeX2(i), this.getTimelineEventStripeY2("down")));
			
		    	
		    	//Draw Rectangle
				RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(
						this.getRectangleX1(i),
						this.getRectangleY1("down"), 
						this.getRectangleWidth(),
						this.getRectangleHeight(), 
						25, 
						25);
				g2.draw(roundedRectangle);
		    
				//Draw year
				Font fontToReset = g2.getFont(); 
				g.setFont(new Font("Arial", Font.BOLD, 20)); 
				int yearWidth = g2.getFontMetrics().stringWidth(String.valueOf(entry.getKey())); 
				int yearPaddingBottom = 20; 
				g2.drawString(String.valueOf(entry.getKey()), this.getYearLabelX1(i)-yearWidth/2, this.getYearLabelY1("down")-yearPaddingBottom);
				g2.setFont(fontToReset);
				
				g2.setFont(new Font("default", Font.BOLD, 16));
			for(int index = 0;index< entry.getValue().getAsJsonArray().size(); index++){
					JsonArray array =  entry.getValue().getAsJsonArray(); 
					String date = array.get(index).getAsJsonObject().get("startDate").toString().substring(1, array.get(index).getAsJsonObject().get("startDate").toString().length() - 12);
					String title = array.get(index).getAsJsonObject().get("title").toString().substring(1, array.get(index).getAsJsonObject().get("title").toString().length() - 1);
					String dateString = date +" : " + title; 
			
					g2.drawString(dateString, this.getRectangleX1(i)+15, this.getRectangleY1("down")+index*20+25);
			 }
				g2.setFont(fontToReset);
				}else{
					//Draw vertical stripe
					g2.draw(new Line2D.Double(this.getTimelineEventStripeX1(i), this.getTimelineEventStripeY1(),
							this.getTimelineEventStripeX2(i), this.getTimelineEventStripeY2("up")));
				
			    	
			    	//Draw Rectangle
					RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(
							this.getRectangleX1(i),
							this.getRectangleY1("up"), 
							this.getRectangleWidth(),
							this.getRectangleHeight(), 
							25, 
							25);
					g2.draw(roundedRectangle);
					
			    
					//Draw year
					Font fontToReset = g2.getFont(); 
					Font yearFont = new Font("Arial", Font.BOLD, 20); 
					g2.setFont(yearFont); 
					int yearWidth = g2.getFontMetrics().stringWidth(String.valueOf(entry.getKey()));
					int yearHeight = (int) yearFont.createGlyphVector(g2.getFontRenderContext(), String.valueOf(entry.getKey())).getVisualBounds().getHeight();
					int yearPaddingBottom = 20; 
					g2.drawString(String.valueOf(entry.getKey()), this.getYearLabelX1(i)-yearWidth/2, this.getYearLabelY1("up")+yearPaddingBottom+yearHeight);
					g2.setFont(fontToReset);
					//Draw text in rectangles
					g2.setFont(new Font("default", Font.BOLD, 16));
				for(int index = 0;index< entry.getValue().getAsJsonArray().size(); index++){
						JsonArray array =  entry.getValue().getAsJsonArray(); 
						String date = array.get(index).getAsJsonObject().get("startDate").toString().substring(1, array.get(index).getAsJsonObject().get("startDate").toString().length() - 12);
						String title = array.get(index).getAsJsonObject().get("title").toString().substring(1, array.get(index).getAsJsonObject().get("title").toString().length() - 1);
						String dateString = date +" : " + title; 
						
						g2.drawString(dateString, this.getRectangleX1(i)+15, this.getRectangleY1("up")+index*20+25);
				 }
				g2.setFont(fontToReset);
					
				}
		    
		    //Increment loop
		    i++;
		    
		    //Toggle odd
		    if(isOdd == false){
		    	isOdd = true; 
		    }
		    else{
		    	isOdd = false;
		    }
		}
		}
	}

	/**
	 * Set new Json String of events
	 * @param events Json of all events 
	 */
	public void setEvents(String events) {
		this.events = events;
	}
	
	/**
	 * Add an {@link MouseListener} to the TimelinePanel
	 * @param timelineEventMouseListener The Mouse Listener for the TimelinePanel
	 */
	public void addTimelineEventActionListener(MouseListener timelineEventMouseListener){
		this.addMouseListener(timelineEventMouseListener);
	}
	
	/**
	 * Get Event that is associated with coordinates on the Panel
	 * @param x X coordinate on TimelinePanel
	 * @param y Y coordinate on TimelinePanel
	 * @return int year
	 */
	public int getEventYearByCoordinates(int x, int y){
		boolean isOdd = false; 
		int i = 0;
		JsonElement root = new JsonParser().parse(this.events);
		for (Map.Entry<String,JsonElement> entry : root.getAsJsonObject().entrySet()) {
			int xMinValue =this.getRectangleX1(i); 
	    	int xMaxValue = this.getRectangleX1(i)+this.getRectangleWidth(); 
			int yMinValue = 0; 
			int yMaxValue = 0; 
			
			//Check odd to know whether coordinate is situated above or under timeline
		    if (isOdd) {
		    	yMinValue = this.getRectangleY1("down"); 
		    	yMaxValue = this.getRectangleY1("down")+this.getRectangleHeight(); 
		    }else{
		    	yMinValue = this.getRectangleY1("up"); 
		    	yMaxValue = this.getRectangleY1("up")+this.getRectangleHeight(); 
		    }
		    
		    if(x>=xMinValue && x<=xMaxValue && y>=yMinValue && y<=yMaxValue){
		    	return  Integer.parseInt(entry.getKey()); 
		    }
		    
		    //Increment loop
		    i++;
		    
		    //Toggle odd
		    if(isOdd == false){
		    	isOdd = true; 
		    }
		    else{
		    	isOdd = false;
		    }
		}
		return 0; 
	}
}
