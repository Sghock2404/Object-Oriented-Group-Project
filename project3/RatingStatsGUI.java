package project3;

//import java.util.Set;
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
        proceedButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                String selection = (String) dropDown.getSelectedItem();
                JOptionPane.showMessageDialog(RatingStatsGUI.this, "You selected option " + selectedIndex);

            }
        });

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
