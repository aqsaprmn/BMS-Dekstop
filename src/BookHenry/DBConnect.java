/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookHenry;

import Model.Author;
import Model.Inventory;
import Model.Branch;
import Model.Books;
import Model.Publisher;
import Model.Wrote;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import javafx.collections.*;
import java.sql.*;

/**
 *
 * @author aqsha.permana
 */
public class DBConnect {
    
    Connection conn = null;
    
    public static Connection getConnection(){
          try {
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbo" , "root" , "");
//          JOptionPane.showMessageDialog(null, "Connection Database Success");
          return conn;
          }catch (Exception ex){
              JOptionPane.showMessageDialog(null, ex);
              return null;
          }
    }
    
    public static ObservableList<Inventory> getDataInventory(){
        Connection conn = getConnection();
        ObservableList<Inventory> listInventory = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM inventory");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listInventory.add(new Inventory(
                        rs.getString("BookCode"), 
                        Integer.parseInt(rs.getString("BranchNum")) , 
                        Integer.parseInt(rs.getString("OnHand"))));
            }
        }   catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        } 
        return listInventory;
    }
public static ObservableList<Branch> getDataBranch(){
        
        Connection conn = getConnection();
        ObservableList<Branch> listBranch = FXCollections.observableArrayList();
            
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM branch");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                listBranch.add(new Branch(
                        Integer.parseInt(rs.getString("BranchNum")),
                        Integer.parseInt(rs.getString("NumEmployess")),
                        rs.getString("BranchName"),
                        rs.getString("BranchLocation")
                        ));
            }
            
        }   catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        } 
        
        
        return listBranch;
    }

public static ObservableList<Books> getDataBooks(){
        
        Connection conn = getConnection();
        ObservableList<Books> listBooks = FXCollections.observableArrayList();
            
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM book");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                listBooks.add(new Books(
                        rs.getString("BookCode"),
                        rs.getString("Title"),
                        rs.getString("PublisherCode"),
                        rs.getString("Type"),
                        rs.getString("Paperback"),
                        rs.getInt("Price")
                        ));
            }
            
//            JOptionPane.showMessageDialog(null, "Data sukses"); 
            
        }   catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        } 
        
        return listBooks;
        
        
        
    }
    

public static ObservableList<Publisher> getDataPublisher(){
        
        Connection conn = getConnection();
        ObservableList<Publisher> listPublisher = FXCollections.observableArrayList();
            
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM publisher");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listPublisher.add(new Publisher(
                        rs.getString("PublisherCode"),
                        rs.getString("PublisherName"),
                        rs.getString("City")
                        ));
                        
                        
            }
            
        }   catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        } 
        
        
        return listPublisher;
    }
public static ObservableList<Author> getDataAuthor(){
        
        Connection conn = getConnection();
        ObservableList<Author> listAuthor = FXCollections.observableArrayList();
            
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM author");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                listAuthor.add(new Author(
                        Integer.parseInt(rs.getString("AuthorNum")),
                        rs.getString("AuthorLast"),
                        rs.getString("AuthorFirst")
                        ));
                        
                        
            }
            
        }   catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        } 
        
        
        return listAuthor;
    }

public static ObservableList<Wrote> getDataWrote(){
        
        Connection conn = getConnection();
        ObservableList<Wrote> listWrote = FXCollections.observableArrayList();
            
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM wrote");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                listWrote.add(new Wrote(
                        rs.getString("BookCode"),
                        Integer.parseInt(rs.getString("AuthorNum")),
                        Integer.parseInt(rs.getString("Squence"))
                        ));
                        
                        
            }
            
        }   catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        } 
        
        
        return listWrote;
    }

}
