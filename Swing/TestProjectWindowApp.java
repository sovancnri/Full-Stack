package Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.*;

class EmployeeManagementSystem implements ActionListener {

    Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;


    //Stack variable at Global Scope for storing Object reference
    JFrame frmMain;
    JPanel pnlcrud,pnlnavig;

    JLabel lblename, lblesalary, lbleaddr,lbleid;
    JTextField txtename, txtesalary, txteaddr,txteid;

    JButton btninsert, btnupdate, btndelete, btnsearch,btnclear;
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
        frmMain.setLayout(new FlowLayout());
        //frmMain.setLayout(new GridLayout(3,2));

        // Now we will have to add components i.e, labels,textfields into the container i.e, frame
        frmMain.add(lbleid);
        frmMain.add(txteid);
        frmMain.add(lblename);
        frmMain.add(txtename);
        frmMain.add(lblesalary);
        frmMain.add(txtesalary);
        frmMain.add(lbleaddr);
        frmMain.add(txteaddr);

        //Now we will create panels and respective components for crud and navig
        //panel and then we will add panel to frame

        //Lets begin with crud panel
        pnlcrud = new JPanel();
        pnlcrud.setBorder(BorderFactory.createTitledBorder("CRUD Operations"));

        btninsert = new JButton();
        btninsert.addActionListener(this);
        btninsert.setText("Insert");
        btnupdate = new JButton();
        btnupdate.addActionListener(this);
        btnupdate.setText("Update");

        btnsearch = new JButton("Search");
        btnsearch.addActionListener(this);

        btndelete = new JButton("Delete");
        btndelete.addActionListener(this);

        btnupdate = new JButton("Update");
        btnupdate.addActionListener(this);

        btnclear = new JButton("Clear");
        btnclear.addActionListener(this);

        //Now host crud buttons in crud panel and then host crud panel in framMain
        pnlcrud.add(btninsert);
        pnlcrud.add(btnupdate);
        pnlcrud.add(btndelete);
        pnlcrud.add(btnsearch);
        pnlcrud.add(btnclear);

        frmMain.add(pnlcrud);

        // Lets Begin with Navigation Panel
        pnlnavig = new JPanel();
        pnlnavig.setBorder(BorderFactory.createTitledBorder("Navigation"));

        btnfirst = new JButton();
        btnfirst.addActionListener(this);
        btnfirst.setText("<<");
        btnlast = new JButton();
        btnlast.addActionListener(this);
        btnlast.setText(">>");

        btnprev = new JButton("<");
        btnprev.addActionListener(this);

        btnnext = new JButton(">");
        btnnext.addActionListener(this);

        /*btnupdate = new JButton("Update");

        btnclear = new JButton("Clear");*/

        //Now host crud buttons in crud panel and then host crud panel in framMain
        pnlnavig.add(btnfirst);
        pnlnavig.add(btnprev);
        pnlnavig.add(btnnext);
        pnlnavig.add(btnlast);

        frmMain.add(pnlnavig);


        //Event Handling (i.e Make the program do something on clicking the buttons)


        frmMain.setSize(700,500);
        frmMain.setTitle("EMS Version 1.0");
        frmMain.setVisible(true);

    }

    //JDBC and SQL with Oracle
    void DatabaseOps(){
        //Step 1 - Loading the driver
        try {
            Class.forName("oracle.jdbc.OracleDriver");  // Establishing the connection or a handshake
            System.out.println("Driver Loaded");                                                    //between OracleDriver class and our .java file
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Step 2 : Establishing the connectivity
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:9500:xe", "nriems", "nriems");

            System.out.println("Connection got established");

            //Step 3 : Create a sql query
            String msgsql = "select * from tblnriems";

            // Step 4 : Statement need to be taken care of as messenger
            stmt = con.createStatement();

            //Step 5 : Now we send sql as message from .java file to oracle
            // and will receive the table back here
            rs = stmt.executeQuery(msgsql);     //A view and points to the column name

            // Move the pointer to the actual row ahead of column heading
            rs.next();

            // Retrieve the info for columns for a given record or row
            int eid = rs.getInt("empid");
            String en = rs.getString("empname");
            int es = rs.getInt("empsal");
            String ed = rs.getString("empaddress");

            //Showing the value retrieved from column of the row of a table
            txteid.setText(Integer.toString(eid));
            txtename.setText(en);
            txtesalary.setText(Integer.toString(es));
            txteaddr.setText(ed);








            /*Step 6 : Now we will retrieve the details of one record at a time
            and will get it displayed on the console and then later in the
            respective textfield

            Strp 7
            rs.next();//Now it points to the first row*/
            /*while(rs.next()){
                //Step 8 : Fetch all the column value row after row
                int eid = rs.getInt("empid");
                String en = rs.getString("empname");
                int es = rs.getInt("empsal");
                String ed = rs.getString("empaddress");

                //Step 9 : Showing the value at console
                System.out.println(eid + " " + en + " " + es + " " + ed);
            }*/
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent componentref) {

        if(componentref.getActionCommand() == "Insert"){
            System.out.println("Insert button got the click action or event");
        }else if(componentref.getActionCommand() == "Update"){
            System.out.println("Update button got the click action or event");
        }else if(componentref.getActionCommand() == "Delete"){
            System.out.println("Delete button got the click action or event");
        }else if(componentref.getActionCommand() == "Search"){
            System.out.println("Search button got the click action or event");
        } else if (componentref.getActionCommand() == "Clear") {
            System.out.println("Clear button got the click action or event");
        }else if (componentref.getActionCommand() == "First") {
            System.out.println("First button got the click action or event");
        }else if (componentref.getActionCommand().equals(">")) {
            System.out.println("Next button got the click action or event");
        }else if (componentref.getActionCommand() == ">>") {
            System.out.println("Last button got the click action or event");
        }else if (componentref.getActionCommand() == "<") {
            System.out.println("Previous button got the click action or event");
        }else if (componentref.getActionCommand() == "<<") {
            System.out.println("First button got the click action or event");
        }

    }
}


public class TestProjectWindowApp {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.CreateGUI();
        ems.DatabaseOps();
    }
}
/*
Steps Front End GUI Development:
* 1.Create the container and subcontainers
* 2.Create The components
* 3.Decide the layout
* 4.Add the components into the containers
* 5.Perform Event Handling on Components and Subscription and Delegation
* 6.Go for Database Operation
* *******************************************************************
Common Steps From Back End Connectivity Using JDBC API (java.sql.*;):

1. Load the driver (jar) i.e, how we change and inform .java file which
backend database technology to work with

2. Establishing the connectivity between front end gui and backend database
using the Connection and DriverManager of java.sql.*;

3. Now we will build select or insert query and get it fired from front end gui
to backend database and for this you need a messenger i.e, Statement

4. Once the required table will be fetched by Statement, we will have to store
here in .java file and for that we will create a virtual table which will be
object of ResultSet from java.sql.*;

5. The fucntions of ResultSet, thereafter will help us to perform crud and
navigation operations.


* */