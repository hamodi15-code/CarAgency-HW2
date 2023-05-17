package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class ChooseVehicleDialog extends JDialog implements MouseListener, ActionListener{

    private CarAgencyPanel panel;
    private JButton Ok;
    private int index;
    private  JTextField Text1;
    private JFrame frame;
    private int ImageNum=panel.ImageList.size();
    JLabel[] label;
    public ChooseVehicleDialog(CarAgencyPanel panel,String Title)
    {
        super(new JFrame(), Title, true);
        this.panel = panel;
        setSize(700, 350);
        setLayout(new BorderLayout());
        setImageList();

    }
    public void setImageList() {
        int rows = ImageNum/3;
        JPanel ImagePanel = new JPanel();
        label = new JLabel[ImageNum];
        for (int i=0;i<ImageNum;i++)
        {
            label[i] = new JLabel();
        }
        ImagePanel.setLayout(new GridLayout(rows, 3, 15, 20));
        //
        for (int i = 0; i < ImageNum; i++)
        {
            label[i].setIcon(panel.ImageList.get(i));
            label[i].addMouseListener(this);
            label[i].setToolTipText(panel.VehiclesList.get(i).toString());
            ImagePanel.add(label[i]);
        }
        add(ImagePanel,BorderLayout.NORTH);
    }
    public void OperationPanel()
    {
        JPanel Menu = new JPanel();
        Menu.setLayout(new GridLayout(1,3,8,0));
        JButton TestDrive = new JButton("Test Drive");
        JButton PurchaseVehicle = new JButton("Purchase Vehicle");
        Menu.add(TestDrive);
        Menu.add(PurchaseVehicle);
        TestDrive.addActionListener(e->TestPanel());
        PurchaseVehicle.addActionListener(e-> BuyFunction());
        add(Menu,BorderLayout.SOUTH);
        setVisible(true);

    }

    public void BuyFunction() {
        panel.ImageList.remove(index);
        panel.VehiclesList.remove(index);
        JOptionPane.showMessageDialog(null,"Successfully Purchased !");
        setVisible(false);
    }

    public void TestPanel() {
        setVisible(false);
        dispose();
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2,0,0));
        JLabel label = new JLabel("Enter The Distance:");
        panel.add(label);
        Text1 = new JTextField();
        panel.add(Text1);
        JPanel OkPlace = new JPanel();
        Ok= new JButton("ok");
        Ok.addActionListener(this);
        OkPlace.add(Ok);
        frame.add(OkPlace,BorderLayout.SOUTH);
        frame.add(panel,BorderLayout.CENTER);
        frame.setSize(700, 350);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Ok){
            double distance= Double.parseDouble((Text1.getText()));
            this.panel.VehiclesList.get(index).move(distance);
            frame.setVisible(false);
            JOptionPane.showMessageDialog(null,"Distance Updated Successfully !");
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < ImageNum; i++)
        {
           if(e.getSource()==label[i])
           {
               index =i;
               OperationPanel();
           }
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
