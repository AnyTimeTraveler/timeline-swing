package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
	/**
	 * {@link List} of all {@link ui.datasets.Actor}
	 */
	private String actors; 
	/**
	 * Initialise fields and set config setting
	 */
	public NewActorPanel(String actors){
		super(); 
		this.actors = actors; 
		this.actorNameLabel = new JLabel("Actor name"); 
		this.actorNameField = new JTextField(); 
		String[] actorsArray = getActorNames(actors);   
		   JList list = new JList(actorsArray);
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
        int[] select = {19, 20, 22};
        list.setSelectedIndices(select);
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints(); 
 
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
        this.saveActorButton = new JButton("Save actor"); 
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

	public void setActors(String actors){
		this.actors = actors; 
	}
	public String getNewActorData(){
		return "{name:"+this.actorNameField.getText()+" }"; 
	}
}
