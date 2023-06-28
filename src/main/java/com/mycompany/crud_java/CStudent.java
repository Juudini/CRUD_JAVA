/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_java;

import com.mysql.cj.jdbc.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Juud
 */
public class CStudent {
int codigo;
    String studentName;
    String studentLastName;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }
    public void insertStudent(JTextField paramName, JTextField paramLastName) {
    setStudentName(paramName.getText());
    setStudentLastName(paramLastName.getText());
    
    CConnection objectConnect = new CConnection();
    
    String request = "INSERT INTO student (name, last_name) VALUES (?, ?)";
    
    try {
        CallableStatement cs = (CallableStatement) objectConnect.stablishConnection().prepareCall(request);
        
        cs.setString(1, getStudentName());
        cs.setString(2, getStudentLastName());
        cs.execute();
        
        JOptionPane.showMessageDialog(null, "The student was inserted correctly");
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, "The student was not inserted correctly, error: " + e.toString());
    }
}

    public void showStudent(JTable paramTablaStudent){
    CConnection objectConnect = new CConnection();
    
    DefaultTableModel model = new DefaultTableModel();
    
    TableRowSorter<TableModel> OrderTable = new TableRowSorter<TableModel> (model);
    paramTablaStudent.setRowSorter(OrderTable);
    
    String sql="";
    
    model.addColumn("Id");
    model.addColumn("Name");
    model.addColumn("Last Name");
    
    paramTablaStudent.setModel(model);
    
    sql="SELECT * FROM student;";
    String[] data = new String [3];
    Statement st;
        try {
            st= objectConnect.stablishConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            data[0] = rs.getString(1);
            data[1] = rs.getString(2);
            data[2] = rs.getString(3);
        
            model.addRow(data);
        }
        paramTablaStudent.setModel(model);
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"The records cannot be displayed"+ e.toString());
        }
    }
    
    public void selectStudent(JTable paramTablaStudent, JTextField paramId, JTextField paramName, JTextField paramLastName) {

        try {
            int row = paramTablaStudent.getSelectedRow();
            if (row >= 0) {
                paramId.setText(paramTablaStudent.getValueAt(row, 0).toString());
                paramName.setText(paramTablaStudent.getValueAt(row, 1).toString());
                paramLastName.setText(paramTablaStudent.getValueAt(row, 2).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Row not selected");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selection error, error:" + e.toString());

        }

    }
    
    public void modifyStudent(JTextField paramCodigo, JTextField paramName, JTextField paramLastName) {
    setCodigo(Integer.parseInt(paramCodigo.getText()));
    setStudentName(paramName.getText());
    setStudentLastName(paramLastName.getText());

    CConnection objectConnect = new CConnection();

    String request = "UPDATE student SET name = ?, last_name = ? WHERE id = ?;";

    try {
        CallableStatement cs = (CallableStatement) objectConnect.stablishConnection().prepareCall(request);

        cs.setString(1, getStudentName());
        cs.setString(2, getStudentLastName());
        cs.setInt(3, getCodigo());

        cs.execute();

        JOptionPane.showMessageDialog(null, "Modified Successfully");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error. Not modified, error: " + e.toString());
    }
}
    public void deleteStudent(JTextField paramCodigo){
    
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        
        CConnection objectConnect = new CConnection();
        
        String request = "DELETE FROM student WHERE student.id = ?;";
        
        try {
        CallableStatement cs = (CallableStatement) objectConnect.stablishConnection().prepareCall(request);
        cs.setInt(1, getCodigo());
        cs.execute();

        JOptionPane.showMessageDialog(null, "Deleted Successfully");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error. Not deleted, error: " + e.toString());
    }
        
    }

}
