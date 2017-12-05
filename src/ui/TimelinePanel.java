package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JPanel;

import ui.datasets.timeline.Event;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class TimelinePanel extends JPanel {

	/**
	 * List with all the events to display on the timeline. Using the view side dataset {@link ui.datasets.timeline.Event}
	 */
	private List<Event> events; 
	/**
	 * Height of the TimelinePanel
	 */
	private int panelHeight;
	/**
	 * Width of the TimelinePanel
	 */
	private int panelWidth;
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
	 */
	public TimelinePanel(int panelWidth, int panelHeight) {
		super();	
		blue = new Color(29, 84, 173);
		this.events = new ArrayList<Event>();
		this.panelHeight = (int)(panelHeight);
		this.panelWidth = 2000;
		
	}
	
	/**
	 * Get The Y1 value of the timeline
	 * @return int Y1 value of the timeline
	 */
	private int getTimelineY1(){
		return this.panelHeight/2; 
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
		return (int) (this.panelHeight*(3.0/7.0)); 
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
			y1 = this.getTimelineX1()-(this.getRectangleWidth()/2); 
			break; 
		case "down":
			y1 = this.getTimelineX1()-(this.getRectangleWidth()/2)+this.getTimelineEventStripeHeight()*2+this.getRectangleHeight()+1; 
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
		return (int) (this.panelHeight*(1.0/7.0)/2); 
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
		return this.panelWidth/this.getEventsPerYear().size(); 
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
				y1 = this.getTimelineEventStripeY1() +20; 
				break; 
			case "down": 
				y1 = this.getTimelineEventStripeY1() -10; 
				break; 
			default: 
				y1 = this.getTimelineEventStripeY1() +10; 
		}
			
		return y1; 
	}
	
	
	
	/**
	 * Get Data as a map ordered by year (key) where the value is a list of the events in that year
	 * @return {@link Map}&lt;{@link Integer},{@link List}&lt;{@link ui.datasets.timeline.Event}&gt;&gt;
	 */
	private Map<Integer, List<Event>> getEventsPerYear(){
		//Use of Treemap to achieve sorted values
		Map<Integer, List<Event>> eventsPerYear= new TreeMap<Integer, List<Event>>();
		for(Event event : this.events){
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
			int year = Integer.parseInt(sdf2.format(event.startDate));
			if(eventsPerYear.containsKey(year)){
				eventsPerYear.get(year).add(event);
			}else{
				List<Event> newYearList = new ArrayList<Event>();
				newYearList.add(event);
				eventsPerYear.put(year, newYearList);
			}
		}		
		return eventsPerYear; 
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
			
		 
		boolean isOdd = false; 
		int i = 0;
		for (Map.Entry<Integer, List<Event>> entry : this.getEventsPerYear().entrySet())
		{
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
				g2.drawString(String.valueOf(entry.getKey()), this.getYearLabelX1(i)-15, this.getYearLabelY1("down"));
				
				
				for(int event_i=0; event_i<entry.getValue().size(); event_i++){
					//Draw text in rectangle
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateString = sdf1.format(entry.getValue().get(event_i).startDate);
					g2.drawString(dateString+" : "+entry.getValue().get(event_i).title, this.getRectangleX1(i)+10, this.getRectangleY1("down")+event_i*20+20);			
				}
				
				
				
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
					g2.drawString(String.valueOf(entry.getKey()), this.getYearLabelX1(i)-15, this.getYearLabelY1("up"));
					
					for(int event_i=0; event_i<entry.getValue().size(); event_i++){
						
						
						
						//Draw text in rectangle
						SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
						String dateString = sdf1.format(entry.getValue().get(event_i).startDate);
						g2.drawString(dateString+" : "+entry.getValue().get(event_i).title, this.getRectangleX1(i)+10, this.getRectangleY1("up")+event_i*20+20);			
					}
					
				}
		    
		    
		    i++;
		    if(isOdd == false){
		    	isOdd = true; 
		    }
		    else{
		    	isOdd = false;
		    }
		}
	}

	/**
	 * Set a new {@link List}&lt;{@link ui.datasets.timeline.Event}&gt;
	 * @param events New {@link List}&lt;{@link ui.datasets.timeline.Event}&gt;
	 */
	public void setEvents(List<Event> events) {
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
	 * @return {@link List}&lt;{@link ui.datasets.timeline.Event}&gt; The List of events in specified year
	 */
	public List<Event> getEventYearByCoordinates(int x, int y){
		boolean isOdd = false; 
		int i = 0;
		for (Map.Entry<Integer, List<Event>> entry : this.getEventsPerYear().entrySet())
		{
			int xMinValue =this.getRectangleX1(i); 
	    	int xMaxValue = this.getRectangleX1(i)+this.getRectangleWidth(); 
			int yMinValue = 0; 
			int yMaxValue = 0; 
			
		    if (isOdd) {
		    	yMinValue = this.getRectangleY1("down"); 
		    	yMaxValue = this.getRectangleY1("down")+this.getRectangleHeight(); 
		    }else{
		    	yMinValue = this.getRectangleY1("up"); 
		    	yMaxValue = this.getRectangleY1("up")+this.getRectangleHeight(); 
		    }
		    
		    if(x>=xMinValue && x<=xMaxValue && y>=yMinValue && y<=yMaxValue){
		    	return  entry.getValue(); 
		    }
		  
	    i++;
	    if(isOdd == false){
	    	isOdd = true; 
	    }
	    else{
	    	isOdd = false;
	    }
	  
	}
		 return null; 
	}
	
	/**
	 * Color a rectangle at specified coordinates
	 */
	public void colorRectangleWithcoordinates(){
		g2.setColor(Color.RED);
		RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(
				this.getRectangleX1(0),
				this.getRectangleY1("up"), 
				this.getRectangleWidth(),
				this.getRectangleHeight(), 
				25, 
				25);
		g2.draw(roundedRectangle);
		g2.setColor(Color.BLACK);
	}
	
}
