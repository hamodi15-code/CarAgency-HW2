package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddCarTypeDialog extends JDialog implements ItemListener, ActionListener {

    private CarAgencyPanel panel;
    private JButton OkType;

    private static final String[] Types = {"Frigate", "Jeep", "SpyGlider", "ToyGlider", "Amphibious", "Bicycle", "CruiseShip"};
    private static final int NUMOFTYPES = 7;

    private JRadioButton[] Select1;

    public AddCarTypeDialog(CarAgencyPanel panel, String title) {
        super(new JFrame(), title, true);
        this.panel = panel;
        setSize(700, 350);
        setLayout(new BorderLayout());
        GetVehicleType();
    }

    //Printing all existing types in a car dealership so that the user can choose the type he wants
    public void GetVehicleType() {
        JPanel vehicleChoice = new JPanel();
        vehicleChoice.setLayout(new GridLayout(4, 3, 15, 20));
        vehicleChoice.setBorder(BorderFactory.createTitledBorder("Choose the Vehicle Type:"));
        ButtonGroup vehicleType = new ButtonGroup();
        Select1 = new JRadioButton[NUMOFTYPES]; ;
        // make the types as a group of buttons
        for (int i = 0; i < NUMOFTYPES; i++) {
            Select1[i] = new JRadioButton(Types[i], false);
            Select1[i].addItemListener(this);
            vehicleType.add(Select1[i]);
            vehicleChoice.add(Select1[i]);
        }
        OkType = new JButton("ok");
        OkType.addActionListener(this);
        vehicleChoice.add(OkType);
        add(vehicleChoice);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        for (int i = 0; i < NUMOFTYPES; i++) {
            if (Select1[i].isSelected()) {
               panel.ChosenType = Types[i];
                break;

            }
        }
    }
    // Go through all the details entered by the user to create an instance of the appropriate vehicle and update the existing list of vehicles
    @Override
    public void actionPerformed(ActionEvent e) {

       if(e.getSource() == OkType) //the user typed on the "Ok" button
        {
            setVisible(false);

        }
    }

}
