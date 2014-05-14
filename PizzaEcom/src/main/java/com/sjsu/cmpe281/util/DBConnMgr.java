package com.sjsu.cmpe281.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.sjsu.cmpe281.constants.PizzaStoreConstants;

/**
 * 
 * @author <a href="Bhargav@leantaas.com">Bhargav</a>
 */
public class DBConnMgr {
    private static DBConnMgr DBConnMgrInstance;
    Connection               conn = null;
    /* initialize config file hook */
	private PropertyLoader pl = PropertyLoader.createPropertyLoaderObj();
	Properties    prop = pl.createConfigFileHook();

    protected DBConnMgr() {
    }

    public static DBConnMgr getDBConnMgr() {
        if (DBConnMgrInstance == null)
            DBConnMgrInstance = new DBConnMgr();
        return DBConnMgrInstance;
    }

    public Connection getConnection() {

//        String url = prop.getProperty("jdbc:mysql://localhost:3306/");
//        String driver = prop.getProperty("com.mysql.jdbc.Driver");
//        String userName = prop.getProperty("root");
//        String password = prop.getProperty("leantaas");
//        String dbName = prop.getProperty("test");
        
        //String url = "jdbc:mysql://ec2-54-203-9-163.us-west-2.compute.amazonaws.com:3306/";
        String url="jdbc:mysql://ec2-54-214-119-8.us-west-2.compute.amazonaws.com:3306/";
        String driver = "com.mysql.jdbc.Driver";
//        String userName = "pizzastore_u";
//        String password = "cmpe281";
        String userName = "pizzastore_u";
        String password = "cmpe281";
        String dbName = "pizzastore";

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
    
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
