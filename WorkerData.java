package assessment.worker;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkerData implements Details{
    public static Statement getStatement(){
        Connection con = null;
        Statement st =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/rowdysouji","root","password");
            st = con.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return st;
    }


    @Override
    public void displayDepartment() throws RemoteException {
        try{
            String sql = "select distinct department from workerData";
            ResultSet rs = getStatement().executeQuery(sql);
            System.out.println("Unique Departments are : ");
            while (rs.next()){
             System.out.println(rs.getString(1));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void usingAlias() throws RemoteException {
        String sql=null;
        try{
            sql = "select upper(concat(first_name,\" \",last_name)) as FULL_NAME from workerData";
            System.out.println("The Full names are");
            ResultSet rs = getStatement().executeQuery(sql);
            while (rs.next()){
              System.out.println(rs.getString(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void usingInstr() throws RemoteException {
        String sql = null;
        try {
            sql = "Select INSTR(binary first_name, 'a') from workerData where first_name = 'Amithabh'";
            ResultSet rs = getStatement().executeQuery(sql);
            System.out.println("a is at position : ");
            while (rs.next()){
                System.out.println(rs.getInt(1));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
