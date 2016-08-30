package me.vik1395.BungeeAuthValidator;

import java.sql.Connection;

public abstract class Database
{
  public abstract Connection openConnection();
  
  public abstract boolean checkConnection();
  
  public abstract Connection getConnection();
  
  public abstract void closeConnection();
}
