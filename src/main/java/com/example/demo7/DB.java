package com.example.demo7;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class DB
{
    private final static String dburl = "jdbc:mysql://localhost:3306/lort?serverTimezone=CET";
    private final static String dbuname = "root";
    private final static String dbpassword = "mikkel405";
    private final static String dbdriver = "com.mysql.cj.jdbc.Driver";

    public void loadDriver(String dbdriver)
    {
        try
        {
            Class.forName(dbdriver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        Connection con = null;
        try
        {
           con = DriverManager.getConnection(dburl, dbuname, dbpassword);
        }
        catch (SQLException e)
        {
          e.printStackTrace();
        }

        return con;
    }

    public String insert(Bruger bruger)
    {
        loadDriver(dbdriver);
        Connection con = getConnection();
        String result = "data entered succesfully";
        String sql = "insert into lort.User values(?,?)";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bruger.getName());
            ps.setString(2,bruger.getPassword());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Data not entered");
        }
        return result;
    }


    public List<Bruger> receive()
    {
        List<Bruger> brugerList = new ArrayList<>();
        loadDriver(dbdriver);
        Connection con = getConnection();
        Statement stmt = null;
        try
        {
            stmt = con.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        String sql = " SELECT * FROM lort.User";
        try
        {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                String userName = rs.getString("userName");
                String password = rs.getString("password");

                Bruger bruger = new Bruger(userName,password);
                brugerList.add(bruger);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return brugerList;
    }
}