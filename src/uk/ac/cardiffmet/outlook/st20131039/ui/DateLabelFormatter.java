package uk.ac.cardiffmet.outlook.st20131039.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

/**
* @author  Jeroen Vandevenne
* @version 1.0
* @see <a href="http://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component">http://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component</a>
*/
public class DateLabelFormatter extends AbstractFormatter {

	/**
	 *	Format for the date
	 */
	  private SimpleDateFormat dateFormatter; 

	  /**
	   * Initialises {@link dateFormatter}
	   */
	  public DateLabelFormatter(){
		  dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
	  }
	  
	  /**
	   * Returns an object (calendar)  from the date String if the correct string is given. 
	   * @throws ParseException exception
	   */
	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    
	    /**
	     * Returns a string when an object (calendar) is given 
	     * @throws ParseException exception
	     */
	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        } 
	        return "";
	    }
}
