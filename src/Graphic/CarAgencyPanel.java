package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CarAgencyPanel extends JPanel {
    public String ChosenType;
    public static final ArrayList<Vehicle> VehiclesList = new ArrayList<>(); //List of all the Vehicles,
    public static final ArrayList<ImageIcon> ImageList =new ArrayList<>();// List for the vehicles images;
    public CarAgencyPanel(){
        this.setLayout(new BorderLayout());
        createMenuBar();

    }
    public class VehicleImage
    {
        public static final ArrayList<Vehicle> VehiclesList1 = new ArrayList<>(); //List of all the Vehicles,
        public static final ArrayList<ImageIcon> ImageList1 =new ArrayList<>();// List for the vehicles images;
    }

    private void createMenuBar() {
        JLabel label=new JLabel();
        ImageIcon image = new ImageIcon("back1.png");
        label.setIcon(image);
        this.add(label);
        JPanel mainMenu = new JPanel();
        mainMenu.setLayout(new GridLayout(1,5,8,0));
        JButton AddVehicle = new JButton("Add Vehicle");
        JButton ChooseVehicle = new JButton("choose exist Vehicle");
        JButton ResetKM = new JButton("Reset KM For All Vehicles");
        JButton ResetFlag = new JButton("Reset Flag For All Vehicles");
        JButton exit = new JButton("Exit");
        AddVehicle.setForeground(new Color(161,109,63));
        ChooseVehicle.setForeground(new Color(161,109,63));
        ResetKM.setForeground(new Color(161,109,63));
        ResetFlag.setForeground(new Color(161,109,63));
        exit.setForeground(new Color(161,109,63));

        //activate the main menu
        mainMenu.add(AddVehicle);
        AddVehicle.addActionListener(e -> ConnectToAddCarDialog());
        mainMenu.add(ChooseVehicle);
        ChooseVehicle.addActionListener(e ->
            ConnectToChooseVehicleDialog());
        mainMenu.add(ResetKM);
        ResetKM.addActionListener(e -> {
            ResetKMFunction();
        });
        mainMenu.add(ResetFlag);
        ResetFlag.addActionListener(e ->ConnectToFlagChangeDialog ());
        mainMenu.add(exit);
        exit.addActionListener(e -> System.exit(0));
        this.add(mainMenu,BorderLayout.NORTH);
    }

    public void ResetKMFunction() {
        if(VehiclesList.size()==0)
        {
            JOptionPane.showMessageDialog(null,"No Vehicles Registered In Car Agency !");
            return;
        }
        // Go through the  list of vehicles and reset the kilometer.
        for (int i = 0; i< VehiclesList.size(); i++)
        {
            VehiclesList.get(i).resetKilometrage();
        }
        JOptionPane.showMessageDialog(null,"Reset KM for All Vehicles successfully !");
    }

    public void ConnectToFlagChangeDialog() {
        if(VehiclesList.size()==0)
        {
            JOptionPane.showMessageDialog(null,"No Vehicles Registered In Car Agency !");
            return;
        }
        FlagChangeDialog flagChange = new FlagChangeDialog(this,"Flag Changing ");
        flagChange.setVisible(true);
    }

    public void ConnectToChooseVehicleDialog() {
        if(VehiclesList.size()==0)
        {
            JOptionPane.showMessageDialog(null,"No Vehicles Registered In Car Agency !");
            return;
        }
        ChooseVehicleDialog chooseVehicle = new ChooseVehicleDialog(this,"Choose Vehicle");
        chooseVehicle.setVisible(true);

    }

    public void ConnectToAddCarDialog() {
        AddCarTypeDialog CarType = new AddCarTypeDialog(this,"Choose car type:");
        CarType.setVisible(true);
        CarType.dispose();
        AddCarDetailsDilog CarDetails = new AddCarDetailsDilog(this, "Details");
        CarDetails.setVisible(true);
        CarDetails.dispose();
    }
}
