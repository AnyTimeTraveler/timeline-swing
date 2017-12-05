package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;
/**
* @author  Jeroen Vandevenne
* @version 1.0
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
	
	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	
}
