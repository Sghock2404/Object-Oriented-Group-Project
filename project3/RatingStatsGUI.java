package project3;

import java.util.Set;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RatingStatsGUI extends JFrame {
    
    // I grabbed this template from zybooks and found a similar one from another website as well
    private JLabel promptLabel;
    private JButton proceedButton;
    private JComboBox<String> dropDown;
    private int selectedIndex;

    // This sets up the GUI Frame (constructor)
    RatingStatsGUI() {

        setTitle("RatingStats");

        // Creates a label with an option prompt "Select an option"
        promptLabel = new JLabel("Select an option:");
        add(promptLabel);

        // List of options for user to select from
        String[] selectOptions = new String[] {"1. Display computed statistics for specific dataID." + DataAnalysis.LINE_SEP
        , "2. Add new collection and compute statistics." + DataAnalysis.LINE_SEP
        , "0. Exit program." + DataAnalysis.LINE_SEP};

        // Create Dropdown Menu
        dropDown = new JComboBox<String>(selectOptions);
        setLayout(new FlowLayout());
        add(dropDown);

        // Create a proceed button
        proceedButton = new JButton();
        proceedButton.setText("Proceed");
        add(proceedButton);

        // Add event listener for dropDown menu
        dropDown.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JComboBox<String> combo = (JComboBox<String>) event.getSource();
                String selectedOption = (String) combo.getSelectedItem();

                DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo.getModel();
                selectedIndex = model.getIndexOf(selectedOption);
            }
        });

        // Add event listener for proceed button
        try {
            DatasetHandler dh = new DatasetHandler();
            Set<Dataset> datasets = dh.getDataSets();
            
    
            proceedButton.addActionListener(new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (selectedIndex == 0) {
                            if (datasets.size()<1){
                            String selection = (String) dropDown.getSelectedItem();
                            JOptionPane.showMessageDialog(RatingStatsGUI.this, "There is no data to select from, select another option");
                        }
                        else {
                            // printDB() from DatasetHandler
                        	JOptionPane.showMessageDialog(RatingStatsGUI.this, "dataID,RAW_FILE,RATINGS_NO,STAT_FILE" + 
                            DataAnalysis.LINE_SEP);
                    		
                            String selection = (String) dropDown.getSelectedItem();
                            //JOptionPane.showMessageDialog(RatingStatsGUI.this, "Please enter dataID from the list");
                            String newDataID = JOptionPane.showInputDialog(RatingStatsGUI.this, "Please enter dataID from the list" );
                            
                            if (!(dh.checkID(newDataID))){
                            JOptionPane.showMessageDialog(RatingStatsGUI.this, "dataID not in the current database, select another option");
                            	} else {
                            		boolean found = true;
                            		}
                            }
                     }
    
                    if (selectedIndex == 1) {
                        String selection = (String) dropDown.getSelectedItem();
                        //JOptionPane.showMessageDialog(RatingStatsGUI.this, "Please enter new unique dataID"); 
                        String newDataID = JOptionPane.showInputDialog(RatingStatsGUI.this,"Please enter new unique dataID");
                        if (!(dh.checkID(newDataID))){
                            String fileName = JOptionPane.showInputDialog(RatingStatsGUI.this,
                            "For new " + newDataID + " collection, what is the source file name?");
                            boolean check = dh.addCollection(newDataID,fileName);
                            boolean found = false;
                            if(check) {
                                
                                JOptionPane.showMessageDialog(RatingStatsGUI.this, "Collection " + newDataID + " added");
                                found = true;
                            }
                            else {
                                JOptionPane.showMessageDialog(RatingStatsGUI.this, "File not found! Try again.");
                               
                            }
                        } else{
                            
                            JOptionPane.showMessageDialog(RatingStatsGUI.this, 
                            newDataID + " is in the current database, displaying existing statistics.");
                        }
                    }
    
                    if (selectedIndex == 2) {
                        String selection = (String) dropDown.getSelectedItem();
                        JOptionPane.showMessageDialog(RatingStatsGUI.this, "Goodbye!"); 
                    }
            }
        });
    
        }catch(IOException e){
            System.out.println("Dataset path not found: " + e.getMessage());
            System.out.println("Please check the file and try again, exiting.");
        }
    }

    

    // Option indexes start from 0
    public int getSelectedIndex() {
        return selectedIndex;
    }

    public static void main(String [] args) {
		
        RatingStatsGUI frame = new RatingStatsGUI();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        int selection = frame.getSelectedIndex();
        System.out.println(selection);

    }
}