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

public class TimelinePanel extends JPanel {

	List<Event> events = new ArrayList<Event>();

	private int timelineHeight = 450;
	private int timelineWidth = 2000;
	private Color blue = new Color(29, 84, 173);
	
	
	//Timeline Dimensions
	private int getTimelineY1(){
		return this.timelineHeight/2; 
	}
	
	private int getTimelineY2(){
		return this.getTimelineY1(); 
	}
	
	private int getTimelineX1(){
		return this.getRectangleWidth()/2; 
	}
	
	private int getTimelineX2(){
		return timelineWidth + this.getRectangleWidth()/2; 
	}
	
	//Rectangle Dimensions
	private int getRectangleWidth(){
		return this.getEventWidth(); 
	}
	
	private int getRectangleHeight(){
		//rectangle rectangles equals 3/7th of timeline.
		return (int) (this.timelineHeight*(3.0/7.0)); 
	}
	
	private int getRectangleX1(int eventSequenceNumber){
		return eventSequenceNumber*this.getEventWidth(); 
	}
	
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
	
	//Vertical event stripe dimensions
	private int getTimelineEventStripeHeight(){
		//The timeline between the 2 rectangles equals 1/7th of timeline. The horizontal stripe is negligible
		return (int) (this.timelineHeight*(1.0/7.0)/2); 
	}
	
	private int getTimelineEventStripeX1(int eventSequenceNumber){
		return this.getTimelineX1()+eventSequenceNumber*this.getEventWidth(); 
	}
	
	private int getTimelineEventStripeX2(int eventSequenceNumber){
		return this.getTimelineEventStripeX1(eventSequenceNumber);
	}

	private int getTimelineEventStripeY1(){
		return this.getTimelineY1(); 
	}
	
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
	
	private int getEventWidth(){
		return this.timelineWidth/this.getEventsPerYear().size(); 
	}
	
	//Year label position
	private int getYearLabelX1(int eventSequenceNumber){
		return this.getTimelineEventStripeX1(eventSequenceNumber);
	}
	
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
	
	
	
	//Transform data to arraylist with events per year
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
	
	
	
	
	
	
	
	private Graphics2D g2;
	
	private int panelHeight; 
	private int panelWidth; 
	
	public TimelinePanel(int panelWidth, int panelHeight) {
		super();	
		
		this.panelHeight = panelHeight; 
		this.panelWidth = 2000;
		this.timelineHeight = panelHeight; 
		
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(this.panelWidth, this.panelHeight);
	}

	@Override
	public void paintComponent(Graphics g) {
		getEventsPerYear();
		
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
					String dateString = sdf1.format(entry.getValue().get(event_i).getStartDate());
					g2.drawString(dateString+" : "+entry.getValue().get(event_i).getTitle(), this.getRectangleX1(i)+10, this.getRectangleY1("down")+event_i*20+20);			
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
						String dateString = sdf1.format(entry.getValue().get(event_i).getStartDate());
						g2.drawString(dateString+" : "+entry.getValue().get(event_i).getTitle(), this.getRectangleX1(i)+10, this.getRectangleY1("up")+event_i*20+20);			
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

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	public void addTimelineEventActionListener(MouseListener timelineEventMouseListener){
		this.addMouseListener(timelineEventMouseListener);
	}
	
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
