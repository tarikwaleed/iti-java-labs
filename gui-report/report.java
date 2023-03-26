package com.example.bdconnect;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.cj.jdbc.MysqlDataSource;

public class HelloApplication extends Application {
   static int lastRecoId=0;
   static String lastrecoName="";
   int nextRec=1;
   int prevRec=1;
    public boolean recordNew=false;
    @FXML
    private Label welcomeText;

    @FXML
    static private TextField idRecord;
    @FXML
    static private TextField nameRecord;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Properties props = new Properties();
        OutputStream output=null;
        try {
            output = new FileOutputStream("db.properties");
            props.setProperty("MYSQL_DB_URL","jdbc:mysql://localhost:3306/javaDB");
            props.setProperty("MYSQL_DB_USERNAME","root");
            props.setProperty("MYSQL_DB_PASSWORD","Dghar@123");
            props.store(output,null);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(HelloApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HelloApplication.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(output!=null)
            {
                try{
                    output.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }


        try{
            java.sql.Connection con = getmyDataSource().getConnection();
            if(con!=null){
                testDataSource();
                System.out.println("coonn done");
            }

        } catch (SQLException ex) {
            Logger.getLogger(HelloApplication.class.getName()).log(Level.SEVERE, null, ex);
        }

        launch();
    }


    public static DataSource getmyDataSource(){
        Properties props = new Properties();
        FileInputStream fis=null;
        MysqlDataSource mysqlDS=null;
        try{
            fis = new FileInputStream("db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        }catch(IOException e){
            e.printStackTrace();
        }
        return mysqlDS;
    }


    public static void testDataSource() {
        DataSource ds = null;
        ds = HelloApplication.getmyDataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from Student");
            while(rs.next()){
                System.out.println("author ID="+rs.getInt("id")+",author="+rs.getString("name"));
                lastRecoId=rs.getInt("id");
                lastrecoName=rs.getString("name");
            HelloApplication.passData(rs.getInt("id"), rs.getString("name"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     public static void passData(int id, String name){
        idRecord.setText(id+"");
        nameRecord.setText(name);
    }
    public void newRecord(){
        recordNew=true;
        idRecord.setText("");
        nameRecord.setText("");
    }
    public void updateRecord(){
        if (recordNew){
            DataSource ds = null;
            ds = HelloApplication.getmyDataSource();
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                con = ds.getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("insert into Student (name) values (nameRecord.getText());");
                System.out.println(rs);
            }catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(rs != null) rs.close();
                    if(stmt != null) stmt.close();
                    if(con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }else {
            DataSource ds = null;
            ds = HelloApplication.getmyDataSource();
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                con = ds.getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("update Student set name=nameRecord.getText() where  id = idRecord.getText();");
                System.out.println(rs);
            }catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(rs != null) rs.close();
                    if(stmt != null) stmt.close();
                    if(con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void DeleteRecord(){
    DataSource ds = null;
    ds = HelloApplication.getmyDataSource();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        con = ds.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("DELETE from Student where name = nameRecord.getText();");
        System.out.println(rs);
    }catch (SQLException e) {
        e.printStackTrace();
    }finally{
        try {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    public void getLastRecord(){
        HelloApplication.testDataSource();
        idRecord.setText(""+lastRecoId);
        nameRecord.setText(lastrecoName);
}
    public void getFirstecord(){
        DataSource ds = null;
        ds = HelloApplication.getmyDataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from Student where id=1");
            if (rs.next()){
                System.out.println("author ID="+rs.getInt("id")+",author="+rs.getString("name"));
                idRecord.setText(""+rs.getInt("id"));
                nameRecord.setText(rs.getString("name"));
                HelloApplication.passData(rs.getInt("id"), rs.getString("name"));
            }else {
                idRecord.setText("");
                nameRecord.setText("not found record");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void next(){
        DataSource ds = null;
        ds = HelloApplication.getmyDataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            nextRec++;
            rs = stmt.executeQuery("select * from Student where id =nextRec;");
            if(rs.next()){
                System.out.println("author ID="+rs.getInt("id")+",author="+rs.getString("name"));
                lastRecoId=rs.getInt("id");
                lastrecoName=rs.getString("name");
                HelloApplication.passData(rs.getInt("id"), rs.getString("name"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void previous(){
        DataSource ds = null;
        ds = HelloApplication.getmyDataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            nextRec--;
            rs = stmt.executeQuery("select * from Student where id =nextRec;");
            if (rs.next()){
                System.out.println("author ID="+rs.getInt("id")+",author="+rs.getString("name"));
                lastRecoId=rs.getInt("id");
                lastrecoName=rs.getString("name");
                HelloApplication.passData(rs.getInt("id"), rs.getString("name"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
