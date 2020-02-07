/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.db;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

class SimpleDB {

public static void main(String[] args) {
    JTextField name = new JTextField("");
    JTextField address = new JTextField("");
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Name:"));
    panel.add(name);
    panel.add(new JLabel("Address:"));
    panel.add(address);
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
   int result = JOptionPane.showConfirmDialog(null, panel, "Test",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
        try{
        String sql = "INSERT INTO SIMPLEDB"
        +"(name, address)"
        +"VALUES (?,?)";
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/Sudip [ on APP]","","");
        pst = con.prepareStatement(sql);
        pst.setString(1,name.getText());
        pst.setString(2,address.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "inserted successfully");
 
}
catch(SQLException | HeadlessException ex){
JOptionPane.showMessageDialog(null, ex);
}
    } else {
        System.out.println("Cancelled");
    }
}
}