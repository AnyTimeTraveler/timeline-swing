package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class NewActorPanel extends JPanel{

	/**
	 * Label for event title
	 */
	private JLabel actorNameLabel; 
	private JTextField actorNameField; 
	private JButton saveActorButton;
	private String actors; 
	private JList list; 
	
	/**
	 * Initialise fields and set config setting
	 */
	public NewActorPanel(String actors){
		super(); 
		this.actorNameLabel = new JLabel("Actor name"); 
		this.actorNameField = new JTextField();
		System.out.println("EERST  =   "+this.actors);
		this.actors = actors; 
		System.out.println("TWEEDE  ===   "  + actors);
		this.saveActorButton = new JButton("Save actor"); 
			
		//Construct List of actors
				String[] actorsArray = getActorNames(this.actors);   
				list = new JList(actorsArray);
				   list.setSelectionModel(new DefaultListSelectionModel() {
					    @Override
					    public void setSelectionInterval(int index0, int index1) {
					        if(super.isSelectedIndex(index0)) {
					            super.removeSelectionInterval(index0, index1);
					        }
					        else {
					            super.addSelectionInterval(index0, index1);
					        }
					    }
					});
		    
		        //Set layout
		        GridBagLayout gbl = new GridBagLayout();
		        this.setLayout(gbl);
		        GridBagConstraints gbc = new GridBagConstraints(); 
		 
		        
		        //Add components to panel
		        gbc.weightx = 1; 
		        gbc.weighty = 1; 
		        gbc.gridx = 0; 
		        gbc.gridy = 0; 
		        this.add(this.actorNameLabel, gbc);
		        gbc.fill = GridBagConstraints.BOTH; 
		        gbc.gridx = 0; 
		        gbc.gridy = 1; 
		        this.add(this.actorNameField, gbc); 
		        gbc.fill = GridBagConstraints.NONE; 
		        gbc.gridx = 0; 
		        gbc.gridy = 2; 
		        this.add(this.saveActorButton, gbc); 
		     
		        gbc.fill = GridBagConstraints.BOTH; 
		        gbc.gridx = 0; 
		        gbc.gridy = 3; 
		        this.add(new JScrollPane(list), gbc); 

				
				
	
	
	}	
	
	
	private String[] getActorNames(String actorList){
		JsonElement root = new JsonParser().parse(actorList);
		JsonElement actorsJsonElement = root.getAsJsonArray(); 
	 
		String[] result = new String[root.getAsJsonArray().size() ]; 
		for(int index = 0;index< root.getAsJsonArray().size(); index++){
			result[index] = actorsJsonElement.getAsJsonArray().get(index).getAsJsonObject().get("name").getAsString(); 
		}
		return result; 
	}


	public void addSaveActorButtonActionListener(ActionListener saveActorButtonActionListener){
		this.saveActorButton.addActionListener(saveActorButtonActionListener); 
	}

	public String getNewActorData(){
		return "{name:"+this.actorNameField.getText()+" }"; 
	}
	
	public void setActors(String actors){
		this.actors = actors; 
		DefaultListModel listModel=new DefaultListModel();
		String[] actorsArray = getActorNames(actors); 
		for(int i = 0;i<actorsArray.length ; i++){
		listModel.addElement(actorsArray[i]);
		}
		this.list.setModel(listModel);
	}
}
