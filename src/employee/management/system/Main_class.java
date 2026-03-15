package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame implements ActionListener {

    JButton add, view, remove;

    Main_class(){

        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);

        // Heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,450,40);
        heading.setFont(new Font("SansSerif",Font.BOLD,25));
        heading.setForeground(Color.WHITE);
        img.add(heading);

        // Add Employee Button
        add = new JButton("Add Employee");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        img.add(add);

        // View Employee Button
        view = new JButton("View Employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.addActionListener(this);
        img.add(view);

        // Remove Employee Button
        remove = new JButton("Remove Employee");
        remove.setBounds(440,370,150,40);
        remove.setForeground(Color.WHITE);
        remove.setBackground(Color.BLACK);
        remove.addActionListener(this);
        img.add(remove);

        setSize(1120,630);
        setLocation(250,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == add){
            new AddEmployee();
            setVisible(false);
        }

        if(e.getSource() == view){
            new View_Employee();
            setVisible(false);
        }

        if(e.getSource() == remove){
            new RemoveEmployee();
            setVisible(false);
//            JOptionPane.showMessageDialog(null,"Remove Employee Page Not Created Yet");
        }
    }

    public static void main(String[] args){
        new Main_class();
    }
}