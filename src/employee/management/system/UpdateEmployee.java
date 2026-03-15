package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfname, taddress, tphone, temail, tsalary, teducation, tdesignation;
    JLabel tname, tdob, taadhar, tempid;

    JButton updateBtn, back;

    String number;

    UpdateEmployee(String number){

        this.number = number;

        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(300,30,400,40);
        heading.setFont(new Font("Serif",Font.BOLD,25));
        add(heading);

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        add(name);

        tname = new JLabel();
        tname.setBounds(200,150,150,30);
        add(tname);

        // Father Name
        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,150,30);
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        add(tfname);

        // DOB
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        add(dob);

        tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        add(tdob);

        // Salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        add(tsalary);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        add(taddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        add(temail);

        // Education
        JLabel education = new JLabel("Education");
        education.setBounds(400,300,150,30);
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600,300,150,30);
        add(teducation);

        // Designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        add(tdesignation);

        // Aadhar
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400,350,150,30);
        add(aadhar);

        taadhar = new JLabel();
        taadhar.setBounds(600,350,150,30);
        add(taadhar);

        // Employee ID
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(200,400,150,30);
        tempid.setForeground(Color.RED);
        add(tempid);

        // Database Fetch
        try{
            conn c = new conn();
            String query = "select * from employee where empId = '"+number+"'";
            ResultSet rs = c.statement.executeQuery(query);

            while(rs.next()){
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tdob.setText(rs.getString("dob"));
                taddress.setText(rs.getString("address"));
                tsalary.setText(rs.getString("salary"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                taadhar.setText(rs.getString("aadhar"));
                tempid.setText(rs.getString("empId"));
                tdesignation.setText(rs.getString("designation"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        // Update Button
        updateBtn = new JButton("Update");
        updateBtn.setBounds(450,550,150,40);
        updateBtn.addActionListener(this);
        add(updateBtn);

        // Back Button
        back = new JButton("Back");
        back.setBounds(250,550,150,40);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==updateBtn){

            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try{
                conn c = new conn();

                String query = "update employee set fname='"+fname+"', salary='"+salary+"', address='"+address+"', phone='"+phone+"', email='"+email+"', education='"+education+"', designation='"+designation+"' where empId='"+number+"'";

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Employee Updated Successfully");

                setVisible(false);
                new View_Employee();

            }catch(Exception ex){
                ex.printStackTrace();
            }

        }else{
            setVisible(false);
            new View_Employee();
        }
    }

    public static void main(String[] args){
        new UpdateEmployee("1");
    }
}