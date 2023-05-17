package Graphic;

import vehicle.Amphibious;
import vehicle.MarineVehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlagChangeDialog extends JDialog implements MouseListener {
    private CarAgencyPanel panel;
    private ImageIcon Israel, USA, Germany, Italy, Greece, Somalia, Pirate;
    public FlagChangeDialog(CarAgencyPanel panel, String title )
    {
        super(new JFrame(),title,true);
        this.panel = panel;
        setSize(700,350);
        setLayout(new BorderLayout());
        FlagChange();
    }

    public void FlagChange() {

            JPanel FlagPanel = new JPanel();
            FlagPanel.setLayout(new GridLayout(3, 3, 30, 10));
            FlagPanel.setBorder(BorderFactory.createTitledBorder("Choose the new flag:"));
            Israel = new ImageIcon("israel.jpg");
            USA = new ImageIcon("usa.jpg");
            Germany = new ImageIcon("germany.jpg");
            Italy = new ImageIcon("italy.jpg");
            Greece = new ImageIcon("greece.jpg");
            Somalia = new ImageIcon("somalia.jpg");
            Pirate = new ImageIcon("pirate.jpg");
            Israel.setDescription("Israel");
            USA.setDescription("USA");
            Germany.setDescription("Germany");
            Italy.setDescription("Italy");
            Greece.setDescription("Greece");
            Somalia.setDescription("Somalia");
            Pirate.setDescription("Pirate");

            JLabel label1 = new JLabel(Israel);
            JLabel label2 = new JLabel(USA);
            JLabel label3 = new JLabel(Germany);
            JLabel label4 = new JLabel(Italy);
            JLabel label5 = new JLabel(Greece);
            JLabel label6 = new JLabel(Somalia);
            JLabel label7 = new JLabel(Pirate);

            label1.addMouseListener(this);
            label2.addMouseListener(this);
            label3.addMouseListener(this);
            label4.addMouseListener(this);
            label5.addMouseListener(this);
            label6.addMouseListener(this);
            label7.addMouseListener(this);


            FlagPanel.add(label1);
            FlagPanel.add(label2);
            FlagPanel.add(label3);
            FlagPanel.add(label4);
            FlagPanel.add(label5);
            FlagPanel.add(label6);
            FlagPanel.add(label7);
            add(FlagPanel);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean DoesMarineExist =false;

        for (int i = 0; i< panel.VehiclesList.size(); i++)
        {
            if((panel.VehiclesList.get(i) instanceof MarineVehicle) ||(panel.VehiclesList.get(i) instanceof Amphibious))
            {
                if( e.getSource()==Israel)
                {
                    ((MarineVehicle)panel.VehiclesList.get(i)).setCountryFlag(Israel.getDescription());
                }

                else if( e.getSource()==USA)
                {
                    ((MarineVehicle)panel.VehiclesList.get(i)).setCountryFlag(USA.getDescription());
                }

                else if( e.getSource()==Germany)
                {
                    ((MarineVehicle)panel.VehiclesList.get(i)).setCountryFlag(Germany.getDescription());
                }

                else if( e.getSource()==Italy)
                {
                    ((MarineVehicle)panel.VehiclesList.get(i)).setCountryFlag(Italy.getDescription());
                }

                else if( e.getSource()==Greece)
                {
                    ((MarineVehicle)panel.VehiclesList.get(i)).setCountryFlag(Greece.getDescription());
                }

                else if( e.getSource()==Somalia)
                {
                    ((MarineVehicle)panel.VehiclesList.get(i)).setCountryFlag(Somalia.getDescription());
                }

                else
                {
                    ((MarineVehicle)panel.VehiclesList.get(i)).setCountryFlag(Pirate.getDescription());
                }
                DoesMarineExist = true;
                setVisible(false);

            }
        }
        if(DoesMarineExist==false)
        {
            JOptionPane.showMessageDialog(null,"No Marine Vehicles In Car Agency");
            setVisible(false);
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
