package Swing;

import javax.swing.*;
import java.awt.*;

class EmployeeManagementSystem{

    //Stack variable at Global Scope for storing Object reference
    JFrame frmMain;
    JPanel pnlcrud,pnlnavig;

    JLabel lblename, lblesalary, lbleaddr,lbleid;
    JTextField txtename, txtesalary, txteaddr,txteid;

    JButton btninsert, btnupdate, btndelete, btnsearch;
    JButton btnfirst, btnlast, btnnext, btnprev;

    void CreateGUI(){

        // We will create the parent window for the project
        frmMain = new JFrame();

        //Now we Will Create instances of labels and text fields to be hosted
        //directly into the frame
        lblename = new JLabel();
        lblename.setText("Name : ");
        txtename = new JTextField(10);

        lbleid = new JLabel();
        lbleid.setText("ID : ");
        txteid = new JTextField(5);

        lblesalary = new JLabel("Salary: ");
        txtesalary = new JTextField(10);

        lbleaddr = new JLabel("Address: ");
        txteaddr = new JTextField(10);

        //Deciding Orientation or layout for Jframe
//        frmMain.setLayout(new FlowLayout());
        frmMain.setLayout(new GridLayout(3,2));

        // Now we will have to add components i.e, labels,textfields into the container i.e, frame
        frmMain.add(lbleid);
        frmMain.add(txteid);
        frmMain.add(lblename);
        frmMain.add(txtename);
        frmMain.add(lblesalary);
        frmMain.add(txtesalary);
        frmMain.add(lbleaddr);
        frmMain.add(txteaddr);


        frmMain.setSize(700,500);
        frmMain.setTitle("EMS Version 1.0");
        frmMain.setVisible(true);

    }
    void DatabaseOps(){

    }
}


public class TestProjectWindowApp {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.CreateGUI();
    }
}
/*
* 1.Create the container and subcontainers
* 2.Create The components
* 3.Decide the layout
* 4.Add the components into the containers
* 5.Perform Even Handling on Commponents
* 6.Go for Database Operation
* */