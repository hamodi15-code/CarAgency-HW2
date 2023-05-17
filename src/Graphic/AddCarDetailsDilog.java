package Graphic;

import vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddCarDetailsDilog extends JDialog implements ActionListener,MouseListener {
    private CarAgencyPanel panel;
    private JButton OkDetails;
    private String ChosenModelName,ChosenPowerSourceInformation,ChosenRoadType,ChosenCountryFlag;
    private int ChosenMaxSpeed,ChosenAverageFuel,ChosenEngineLife,ChosenMaxPassengers,ChosenNumOfWheels;
    private ImageIcon Image1, Image2;
    private JLabel label1,label2;

    private JCheckBox IsSailWithWind;
    private  JTextField Text1,Text2,Text3,Text4,Text5,Text6;
    public AddCarDetailsDilog(CarAgencyPanel panel, String title) {
        super(new JFrame(), title, true);
        this.panel = panel;
        setSize(700, 350);
        setLayout(new BorderLayout());
        GetVehicleDetails();
    }
    public void InitJeepPanel()
    {
        JPanel ImagePanel = new JPanel();
        ImagePanel.setLayout(new GridLayout(2,1,0,30));
        label1 = new JLabel();
        label2 = new JLabel();
        Image1 = new ImageIcon("jeep1.jpg");
        Image2 = new ImageIcon("jeep2.jpg");
        label1.setIcon(Image1);
        label2.setIcon(Image2);
        label1.addMouseListener(this);
        label2.addMouseListener(this);
        ImagePanel.add(label1);
        ImagePanel.add(label2);
        add(ImagePanel,BorderLayout.EAST);
        JPanel JeepPanel = new JPanel();
        JeepPanel.setLayout(new GridLayout(4,2,0,0));
        Text1 = new JTextField();
        Text2 = new JTextField();
        Text3 = new JTextField();
        Text4 = new JTextField();
        JeepPanel.add(new JLabel("Model name:"));
        JeepPanel.add(Text1);
        JeepPanel.add(new JLabel("Max speed:"));
        JeepPanel.add(Text2);
        JeepPanel.add(new JLabel("Average fuel:"));
        JeepPanel.add(Text3);
        JeepPanel.add(new JLabel("Average engine life:"));
        JeepPanel.add(Text4);
        JPanel OkPlace = new JPanel();
        OkDetails = new JButton("ok");
        OkDetails.addActionListener(this);
        OkPlace.add(OkDetails);
        add(OkPlace,BorderLayout.SOUTH);
        add(JeepPanel,BorderLayout.WEST);
    }
    public void InitFrigatePanel()
    {
        JPanel ImagePanel = new JPanel();
        ImagePanel.setLayout(new GridLayout(2,1,30,30));
        label1 = new JLabel();
        label2 = new JLabel();
        Image1= new ImageIcon("frigate1.jpg");
        Image2 = new ImageIcon("frigate2.jpg");
        label1.setIcon(Image1);
        label2.setIcon(Image2);
        label1.addMouseListener(this);
        label2.addMouseListener(this);
        ImagePanel.add(label1);
        ImagePanel.add(label2);
        add(ImagePanel,BorderLayout.EAST);
        JPanel FrigatePanel = new JPanel();
        FrigatePanel.setLayout(new GridLayout(4,2,0,0));
        Text1 = new JTextField();
        Text2 = new JTextField();
        Text3 = new JTextField();
        FrigatePanel.add(new JLabel("Model name:"));
        FrigatePanel.add(Text1);
        FrigatePanel.add(new JLabel("Max Passengers:"));
        FrigatePanel.add(Text2);
        FrigatePanel.add(new JLabel("Max Speed:"));
        FrigatePanel.add(Text3);
        FrigatePanel.add(new JLabel("Sail With Wind :"));
        IsSailWithWind = new JCheckBox();
        FrigatePanel.add(IsSailWithWind);
        JPanel OkPlace = new JPanel();
        OkDetails = new JButton("ok");
        OkDetails.addActionListener(this);
        OkPlace.add(OkDetails);
        add(OkPlace,BorderLayout.SOUTH);
        add(FrigatePanel,BorderLayout.WEST);
    }
    public void InitSpyGliderPanel()
    {
        JPanel ImagePanel = new JPanel();
        ImagePanel.setLayout(new GridLayout(2,1,30,30));
        label1 = new JLabel();
        label2 = new JLabel();
        Image1= new ImageIcon("spyglider1.jpg");
        Image2 = new ImageIcon("spyglider2.jpg");
        label1.setIcon(Image1);
        label2.setIcon(Image2);
        label1.addMouseListener(this);
        label2.addMouseListener(this);
        ImagePanel.add(label1);
        ImagePanel.add(label2);
        add(ImagePanel,BorderLayout.EAST);
        JPanel SpyGliderPanel = new JPanel();
        SpyGliderPanel.setLayout(new GridLayout(1,2,0,0));
        Text1 = new JTextField();
        SpyGliderPanel.add(new JLabel("Power Source Information:"));
        SpyGliderPanel.add(Text1);
        JPanel OkPlace = new JPanel();
        OkDetails = new JButton("ok");
        OkDetails.addActionListener(this);
        OkPlace.add(OkDetails);
        add(OkPlace,BorderLayout.SOUTH);
        add(SpyGliderPanel,BorderLayout.WEST);
    }
    public void InitToyGliderPanel()
    {
        JPanel ImagePanel = new JPanel();
        ImagePanel.setLayout(new GridLayout(1,2,0,0));
        label1 = new JLabel();
        label2 = new JLabel();
        Image1= new ImageIcon("toyglider1.jpg");
        Image2 = new ImageIcon("toyglider2.jpg");
        label1.setIcon(Image1);
        label2.setIcon(Image2);
        label1.addMouseListener(this);
        label2.addMouseListener(this);
        ImagePanel.add(label1);
        ImagePanel.add(label2);
        add(ImagePanel,BorderLayout.CENTER);
        // default details for this type
       JPanel OkPlace = new JPanel();
       OkDetails = new JButton("ok");
       OkDetails.addActionListener(this);
       OkPlace.add(OkDetails);
       add(OkPlace,BorderLayout.SOUTH);
    }
    public void InitBicyclePanel()
    {
        JPanel ImagePanel = new JPanel();
        ImagePanel.setLayout(new GridLayout(2,1,30,30));
        label1 = new JLabel();
        label2 = new JLabel();
        Image1= new ImageIcon("bicycle1.jpg");
        Image2 = new ImageIcon("bicycle2.jpg");
        label1.setIcon(Image1);
        label2.setIcon(Image2);
        label1.addMouseListener(this);
        label2.addMouseListener(this);
        ImagePanel.add(label1);
        ImagePanel.add(label2);
        add(ImagePanel,BorderLayout.EAST);
        JPanel BicyclePanel = new JPanel();
        BicyclePanel.setLayout(new GridLayout(4,2,0,0));
        Text1 = new JTextField();
        Text2 = new JTextField();
        Text3 = new JTextField();
        Text4 = new JTextField();
        BicyclePanel.add(new JLabel("Model name:"));
        BicyclePanel.add(Text1);
        BicyclePanel.add(new JLabel("Max Passengers:"));
        BicyclePanel.add(Text2);
        BicyclePanel.add(new JLabel("Max Speed:"));
        BicyclePanel.add(Text3);
        BicyclePanel.add(new JLabel("Road Type:"));
        BicyclePanel.add(Text4);
        JPanel OkPlace = new JPanel();
        OkDetails = new JButton("ok");
        OkDetails.addActionListener(this);
        OkPlace.add(OkDetails);
        add(OkPlace,BorderLayout.SOUTH);
        add(BicyclePanel,BorderLayout.WEST);
    }
    public void InitAmphibiousPanel()
    {
        JPanel ImagePanel = new JPanel();
        ImagePanel.setLayout(new GridLayout(2,1,30,30));
        label1 = new JLabel();
        label2 = new JLabel();
        Image1= new ImageIcon("amphibious1.jpg");
        Image2 = new ImageIcon("amphibious2.jpg");
        label1.setIcon(Image1);
        label2.setIcon(Image2);
        label1.addMouseListener(this);
        label2.addMouseListener(this);
        ImagePanel.add(label1);
        ImagePanel.add(label2);
        add(ImagePanel,BorderLayout.EAST);
        JPanel AmphibiousPanel = new JPanel();
        AmphibiousPanel.setLayout(new GridLayout(6,2,0,0));
        Text1 = new JTextField();
        Text2 = new JTextField();
        Text3 = new JTextField();
        Text4 = new JTextField();
        Text5 = new JTextField();
        AmphibiousPanel.add(new JLabel("Model name:"));
        AmphibiousPanel.add(Text1);
        AmphibiousPanel.add(new JLabel("Max Passengers:"));
        AmphibiousPanel.add(Text2);
        AmphibiousPanel.add(new JLabel("Max Speed:"));
        AmphibiousPanel.add(Text3);
        AmphibiousPanel.add(new JLabel("Num of Wheels:"));
        AmphibiousPanel.add(Text4);
        AmphibiousPanel.add(new JLabel("Sail With Wind :"));
        IsSailWithWind = new JCheckBox();
        AmphibiousPanel.add(IsSailWithWind);
        AmphibiousPanel.add(new JLabel("country Flag:"));
        AmphibiousPanel.add(Text5);
        JPanel OkPlace = new JPanel();
        OkDetails = new JButton("ok");
        OkDetails.addActionListener(this);
        OkPlace.add(OkDetails);
        add(OkPlace,BorderLayout.SOUTH);
        add(AmphibiousPanel,BorderLayout.WEST);
    }
    public void InitCruiseShipPanel()
    {
        JPanel ImagePanel = new JPanel();
        ImagePanel.setLayout(new GridLayout(2,1,30,30));
        label1 = new JLabel();
        label2 = new JLabel();
        Image1= new ImageIcon("cruiseship1.jpg");
        Image2 = new ImageIcon("cruiseship2.jpg");
        label1.setIcon(Image1);
        label2.setIcon(Image2);
        label1.addMouseListener(this);
        label2.addMouseListener(this);
        ImagePanel.add(label1);
        ImagePanel.add(label2);
        add(ImagePanel,BorderLayout.EAST);
        JPanel CruiseShipPanel = new JPanel();
        CruiseShipPanel.setLayout(new GridLayout(6,2,0,0));
        Text1 = new JTextField();
        Text2 = new JTextField();
        Text3 = new JTextField();
        Text4 = new JTextField();
        Text5 = new JTextField();
        Text6 = new JTextField();
        CruiseShipPanel.add(new JLabel("Model name:"));
        CruiseShipPanel.add(Text1);
        CruiseShipPanel.add(new JLabel("Max Passengers:"));
        CruiseShipPanel.add(Text2);
        CruiseShipPanel.add(new JLabel("Max Speed:"));
        CruiseShipPanel.add(Text3);
        CruiseShipPanel.add(new JLabel("country Flag:"));
        CruiseShipPanel.add(Text4);
        CruiseShipPanel.add(new JLabel("Average Fuel:"));
        CruiseShipPanel.add(Text5);
        CruiseShipPanel.add(new JLabel("Average Engine Life:"));
        CruiseShipPanel.add(Text6);
        JPanel OkPlace = new JPanel();
        OkDetails = new JButton("ok");
        OkDetails.addActionListener(this);
        OkPlace.add(OkDetails);
        add(OkPlace,BorderLayout.SOUTH);
        add(CruiseShipPanel,BorderLayout.WEST);
    }
    public void GetVehicleDetails() {

        switch (panel.ChosenType)
        {
            case "Jeep": {
                InitJeepPanel();
                break;

            }
            case "Frigate":{
                InitFrigatePanel();
                break;
            }
            case"SpyGlider": {
                InitSpyGliderPanel();
                break;
            }
            case "ToyGlider": {
                InitToyGliderPanel();
                break;
            }
            case"Bicycle":{
                InitBicyclePanel();
                break;
            }
            case  "Amphibious":{
                InitAmphibiousPanel();
                break;
            }
            case "CruiseShip": {
                InitCruiseShipPanel();
                break;
            }
            default:{
                throw new IllegalArgumentException("sorry you need to enter a valid Type");
            }
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String Type = panel.ChosenType;

        if(e.getSource() == OkDetails && (Type=="Jeep")){
            // convert the text field to the appropriate type.
            ChosenModelName=Text1.getText();
            ChosenMaxSpeed= Integer.parseInt(Text2.getText());
            ChosenAverageFuel=Integer.parseInt(Text3.getText());
            ChosenEngineLife=Integer.parseInt(Text4.getText());
            panel.VehiclesList.add(new Jeep(ChosenModelName,ChosenMaxSpeed,ChosenAverageFuel,ChosenEngineLife));
            setVisible(false);
            JOptionPane.showMessageDialog(null,"Jeep was added successfully !");

        }
        else if(e.getSource() == OkDetails && (Type=="Frigate")){
            // convert the text field to the appropriate type.
            ChosenModelName=Text1.getText();
            ChosenMaxPassengers= Integer.parseInt(Text2.getText());
            ChosenMaxSpeed=Integer.parseInt(Text3.getText());
            panel.VehiclesList.add(new Frigate(ChosenModelName,ChosenMaxPassengers,ChosenMaxSpeed,  IsSailWithWind.isSelected()));
            setVisible(false);
            JOptionPane.showMessageDialog(null,"Frigate was added successfully !");

        }
        else if(e.getSource() == OkDetails && (Type=="SpyGlider")){
            ChosenPowerSourceInformation=Text1.getText();
            panel.VehiclesList.add(new SpyGlider(ChosenPowerSourceInformation));
            setVisible(false);
            JOptionPane.showMessageDialog(null,"Spy Glider was added successfully !");

        }
        else if(e.getSource() == OkDetails && (Type=="ToyGlider")){
            panel.VehiclesList.add(new ToyGlider());
            setVisible(false);
            JOptionPane.showMessageDialog(null,"Toy Glider was added successfully !");

        }

        else if(e.getSource() == OkDetails && (Type=="Bicycle")){
            // convert the text field to the appropriate type.
            ChosenModelName=Text1.getText();
            ChosenMaxPassengers= Integer.parseInt(Text2.getText());
            ChosenMaxSpeed=Integer.parseInt(Text3.getText());
            ChosenRoadType=(Text4.getText());
            panel.VehiclesList.add(new Bicycle(ChosenModelName,ChosenMaxPassengers,ChosenMaxSpeed,ChosenRoadType));
            setVisible(false);
            JOptionPane.showMessageDialog(null,"Bicycle was added successfully !");

        }
       else if(e.getSource() == OkDetails && (Type=="Amphibious")){
            // convert the text field to the appropriate type.
            ChosenModelName=Text1.getText();
            ChosenMaxPassengers= Integer.parseInt(Text2.getText());
            ChosenMaxSpeed=Integer.parseInt(Text3.getText());
            ChosenNumOfWheels=Integer.parseInt(Text4.getText());
            ChosenCountryFlag = Text5.getText();
            panel.VehiclesList.add(new Amphibious(ChosenModelName,ChosenMaxPassengers,ChosenMaxSpeed,ChosenNumOfWheels,IsSailWithWind.isSelected(),ChosenCountryFlag));
            setVisible(false);
            JOptionPane.showMessageDialog(null,"Amphibious was added successfully !");

        }
        else {
            // convert the text field to the appropriate type.
            ChosenModelName=Text1.getText();
            ChosenMaxPassengers= Integer.parseInt(Text2.getText());
            ChosenMaxSpeed=Integer.parseInt(Text3.getText());
            ChosenCountryFlag=(Text4.getText());
            ChosenAverageFuel= Integer.parseInt(Text5.getText());
            ChosenEngineLife= Integer.parseInt(Text6.getText());
            panel.VehiclesList.add(new CruiseShip(ChosenModelName,ChosenMaxPassengers,ChosenMaxSpeed,ChosenCountryFlag,ChosenAverageFuel,ChosenEngineLife));
            setVisible(false);
            JOptionPane.showMessageDialog(null,"Cruise Ship was added successfully !");

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == label1)
        {
            panel.ImageList.add((ImageIcon) label1.getIcon());
        }
        else if (e.getSource()==label2)
        {
            panel.ImageList.add((ImageIcon) label2.getIcon());
        }
        else
        {

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

