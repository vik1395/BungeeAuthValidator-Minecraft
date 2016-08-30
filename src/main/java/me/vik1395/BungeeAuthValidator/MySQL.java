package me.vik1395.BungeeAuthValidator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL extends Database {
  private final String user;
  private final String database;
  private final String password;
  private final String port;
  private final String hostname;
  private Connection connection;
  
  public MySQL(String hostname, String port, String database, String username, String password)
  {
    this.hostname = hostname;
    this.port = port;
    this.database = database;
    this.user = username;
    this.password = password;
    this.connection = null;
  }
  
  public Connection openConnection()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql://" + this.hostname + ":" + this.port + "/" + this.database;
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      this.connection = DriverManager.getConnection(url, this.user, this.password);
    }
    catch (SQLException|InstantiationException|IllegalAccessException e)
    {
      System.out.println("Could not connect to MySQL server! because: " + e.getMessage());
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("JDBC Driver not found!");
      e.printStackTrace();
    }
    return this.connection;
  }
  
  public boolean checkConnection()
  {
    return this.connection != null;
  }
  
  public Connection getConnection()
  {
    return this.connection;
  }
  
  public void closeConnection()
  {
    if (this.connection != null) {
      try
      {
        this.connection.close();
      }
      catch (SQLException e)
      {
        System.out.println("Error closing the MySQL Connection!");
        e.printStackTrace();
      }
    }
  }
  
  public ResultSet querySQL(String query)
  {
    Connection c = null;
    if (checkConnection()) {
      c = getConnection();
    } else {
      c = openConnection();
    }
    Statement s = null;
    try
    {
      s = c.createStatement();
    }
    catch (SQLException e1)
    {
      e1.printStackTrace();
    }
    ResultSet ret = null;
    try
    {
      ret = s.executeQuery(query);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    closeConnection();
    
    return ret;
  }
  
  public void updateSQL(String update)
  {
    Connection c = null;
    if (checkConnection()) {
      c = getConnection();
    } else {
      c = openConnection();
    }
    Statement s = null;
    try
    {
      s = c.createStatement();
      s.executeUpdate(update);
    }
    catch (SQLException e1)
    {
      e1.printStackTrace();
    }
    closeConnection();
  }
}
