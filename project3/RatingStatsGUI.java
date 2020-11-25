package project3;


//import java.util.Set;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class RatingStatsGUI {

    public static void main(String [] args) {
		
		String selection = "";
        JFrame frame = new JFrame();
	
		try{
			DatasetHandler dh = new DatasetHandler();
			String setup = "Loading the datasets from:" + DataAnalysis.LINE_SEP
            	+ "     data folder: " + dh.getFolderPath() + DataAnalysis.LINE_SEP
                + "     datasets available: " + dh.getDataSets() + DataAnalysis.LINE_SEP;
               

        final int FIELD_WIDTH = 20;
        final JTextField textField = new JTextField(FIELD_WIDTH);
        textField.setText(setup);
        dh.printDB();
			
        String[] selectOptions = new String[] {"Choose one of the following functions:" + DataAnalysis.LINE_SEP
            , "1. Display computed statistics for specific dataID." + DataAnalysis.LINE_SEP
            , "2. Add new collection and compute statistics." + DataAnalysis.LINE_SEP
            , "0. Exit program." + DataAnalysis.LINE_SEP};
        
            JComboBox<String> dropDown = new JComboBox<String>(selectOptions);

            frame.setLayout(new FlowLayout());
            frame.add(textField);
            frame.add(dropDown);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

        }catch(IOException e){
            System.out.println("Dataset path not found: " + e.getMessage());
            System.out.println("Please check the file and try again, exiting.");
        }   
        
       
    }	

    
}
