package Controller;

import Model.History;
import Model.Logs;
import Model.Product;
import Model.User;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLite {
    
    public int DEBUG_MODE = 0;
    String driverURL = "jdbc:sqlite:" + "database.db";
    
    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(driverURL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/createNewDatabase] Database database.db created.");
                }
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/createNewDatabase] " + ex);
            }
        }
    }
    
    public void createHistoryTable() {
        String sql = "CREATE TABLE IF NOT EXISTS history (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL,\n"
            + " name TEXT NOT NULL,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/createHistoryTable] Table history in database.db created.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/createHistoryTable] " + ex);
            }
        }
    }
    
    public void createLogsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS logs (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " event TEXT NOT NULL,\n"
            + " username TEXT NOT NULL,\n"
            + " desc TEXT NOT NULL,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/createLogsTable] Table logs in database.db created.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/createLogsTable] " + ex);
            }
        }
    }
     
    public void createProductTable() {
        String sql = "CREATE TABLE IF NOT EXISTS product (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " name TEXT NOT NULL UNIQUE,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " price REAL DEFAULT 0.00\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/createProductTable] Table product in database.db created.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/createProductTable] " + ex);
            }
            
        }
    }
     
    public void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL UNIQUE,\n"
            + " password TEXT NOT NULL,\n"
            + " role INTEGER DEFAULT 2,\n"
            + " locked INTEGER DEFAULT 0\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/createUserTable] Table users in database.db created.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/createUserTable] " + ex);
            }
        }
    }
    
    public void dropHistoryTable() {
        String sql = "DROP TABLE IF EXISTS history;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/dropHistoryTable] Table history in database.db dropped.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println(ex);
            }
        }
    }
    
    public void dropLogsTable() {
        String sql = "DROP TABLE IF EXISTS logs;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/dropLogsTable] Table logs in database.db dropped.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/dropLogsTable] " + ex);
            }
        }
    }
    
    public void dropProductTable() {
        String sql = "DROP TABLE IF EXISTS product;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/dropProductTable] Table product in database.db dropped.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/dropProductTable] " + ex);
            }
        }
    }
    
    public void dropUserTable() {
        String sql = "DROP TABLE IF EXISTS users;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/dropUserTable] Table users in database.db dropped.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/dropUserTable] " + ex);
            }
        }
    }
    
    public void addHistory(String username, String name, int stock, String timestamp) {
        String sql = "INSERT INTO history(username,name,stock,timestamp) VALUES('" + username + "','" + name + "','" + stock + "','" + timestamp + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/addHistory] Added [" + username + "] entry in purchase history.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/addHistory] " + ex);
            }
        }
    }
    
    public void addLogs(String event, String username, String desc, String timestamp) {
        String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES('" + event + "','" + username + "','" + desc + "','" + timestamp + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/addLogs] Added [" + username + "] log entry.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/addLogs] " + ex);
            }
        }
    }
    
    public void addProduct(String name, int stock, double price) {
        String sql = "INSERT INTO product(name,stock,price) VALUES('" + name + "','" + stock + "','" + price + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/addProduct] Added [" + name + "] to product list.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/addProduct] " + ex);
            }
        }
    }
    
    /* See new addUser()
    public void addUser(String username, String password) {
        String sql = "INSERT INTO users(username,password) VALUES('" + username + "','" + password + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/addUser] Added [" + username + "] to users list.");
            }
//      PREPARED STATEMENT EXAMPLE
//      String sql = "INSERT INTO users(username,password) VALUES(?,?)";
//      PreparedStatement pstmt = conn.prepareStatement(sql)) {
//      pstmt.setString(1, username);
//      pstmt.setString(2, password);
//      pstmt.executeUpdate();
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/addUser] " + ex);
            }
        }
    }
    // */
    
    public ArrayList<History> getHistory(int role, String searchText, int filtered){
        String sql = "SELECT id, username, name, stock, timestamp FROM history";
        
        // Filtered list applies to Client-level users by default
        // Filtering on Manager-level is only when a username is specified
        if (role == 2 && (role == 4 && filtered == 1)) {
            sql += " WHERE username = '" + searchText + "' OR name = '" + searchText + "';";
        } 
        
        ArrayList<History> histories = new ArrayList<History>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                histories.add(new History(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/getHistory] " + ex);
            }
        }
        
        if (this.DEBUG_MODE == 1) {
            System.out.println("[SQLite/getHistory] Records from history table successfully retrieved.");
        }
        
        return histories;
    }
    
    public ArrayList<Logs> getLogs(){
        String sql = "SELECT id, event, username, desc, timestamp FROM logs";
        ArrayList<Logs> logs = new ArrayList<Logs>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                logs.add(new Logs(rs.getInt("id"),
                                   rs.getString("event"),
                                   rs.getString("username"),
                                   rs.getString("desc"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/getLogs] " + ex);
            }
        }
        
        if (this.DEBUG_MODE == 1) {
            System.out.println("[SQLite/getLogs] Records from logs table successfully retrieved.");
        }
        
        return logs;
    }
    
    public ArrayList<Product> getProduct(){
        String sql = "SELECT id, name, stock, price FROM product";
        
        ArrayList<Product> products = new ArrayList<Product>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                // Filter out products marked as 'deleted'
                String name = rs.getString("name");
                if (name.charAt(name.length() - 1) != '*') {
                products.add(new Product(rs.getInt("id"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getFloat("price")));
                }
                
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/getProduct] " + ex);
            }
        }
        
        if (this.DEBUG_MODE == 1) {
            System.out.println("[SQLite/getProduct] Records from products table successfully retrieved.");
        }
        
        return products;
    }
    
    public ArrayList<User> getUsers(){
        String sql = "SELECT id, username, password, role, locked FROM users";
        ArrayList<User> users = new ArrayList<User>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                // Filter out users marked as 'deleted'
                String username = rs.getString("username");
                if (username.charAt(username.length() - 1) != '*') {
                    users.add(new User(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("password"),
                                   rs.getInt("role"),
                                   rs.getInt("locked")));
                }
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/getUsers] " + ex);
            }
        }
        
        if (this.DEBUG_MODE == 1) {
            System.out.println("[SQLite/getUsers] Records from users table successfully retrieved.");
        }
        
        return users;
    }
    
    public void addUser(String username, String password, int role) {
        String sql = "INSERT INTO users(username,password,role) VALUES('" + username + "','" + password + "','" + role + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/addUser] Added [" + username + "] to users table.");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/addUser] " + ex);
            }
        }
    }
    
    /* See deleteUser() method
    public void removeUser(String username) {
        String sql = "DELETE FROM users WHERE username='" + username + "';";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("User " + username + " has been deleted.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    // */
    
    public Product getProduct(String name){
        String sql = "SELECT name, stock, price FROM product WHERE name='" + name + "';";
        Product product = null;
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            product = new Product(rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getFloat("price"));
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/getProduct] " + ex);
            }
        }
        
        if (this.DEBUG_MODE == 1) {
            System.out.println("[SQLite/getProduct] Successfuly retrieved [" + name + "].");
        }
        
        return product;
    }
    
    public void purchaseProduct(String name, int numPurchased, String timestamp) {
        Product product = this.getProduct(name);
        
        if ((product.getStock() - numPurchased) >= 0) {
            // Reduce stock by number of products purchased
            String sql = "UPDATE product SET stock = stock - " + numPurchased + " WHERE name='" + name + "';";
            try (Connection conn = DriverManager.getConnection(driverURL);
                Statement stmt = conn.createStatement()){
                stmt.execute(sql);
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/purchaseProduct] Successfully purchased " + numPurchased + "of [" + name + "].");
                }
            } catch (Exception ex) {
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/purchaseProduct] " + ex);
                }
            }
        }
    }    
        
    public void editProduct(String oldName, String newName, int newStock, float newPrice){
        Product product = this.getProduct(oldName);
        
        if (product != null) {
            String sql = "UPDATE product SET name = '" + newName + "', stock = " + newStock + ", price = " + newPrice + " WHERE name = '" + oldName + "';";
            try (Connection conn = DriverManager.getConnection(driverURL);
                Statement stmt = conn.createStatement()){
                stmt.execute(sql);
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/editProduct] Product [" + oldName + "] successfully modified.");
                }
            } catch (Exception ex) {
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/editProduct] " + ex);
                }
            }
        }
    }
    
    public void deleteProduct(String name) {
        Product product = this.getProduct(name);
        
        String newName = name + '*';
        
        if (product != null) {
            String sql = "UPDATE product SET name = '" + newName + "' WHERE name = '" + name + "';";
            try (Connection conn = DriverManager.getConnection(driverURL);
                Statement stmt = conn.createStatement()){
                stmt.execute(sql);
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/deleteProduct] Product [" + name + "] marked for deletion.");
                }
            } catch (Exception ex) {
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/deleteProduct] " + ex);
                }
            }
        }
    }
    
    public void editUserRole(String username, int newRole) {
        String sql = "UPDATE users SET role = " + newRole + " WHERE username = '" + username + "';";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/editUserRole] Successful role change for User [" + username + "].");
            }
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/editUserRole]" + ex);
            }
        }
    }
    
    public User getUser(String username){
        String sql = "SELECT username, password FROM users WHERE username='" + username + "';";
        User user = null;
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            user = new User(rs.getString("username"), rs.getString("password"));
        } catch (Exception ex) {
            if (this.DEBUG_MODE == 1) {
                System.out.println("[SQLite/getUser] " + ex);
            }
        }
        
        if (this.DEBUG_MODE == 1) {
            System.out.println("[SQLite/getUser] Succesfully retrieved User [" + username + "].");
        }
        
        return user;
    }
    
    public void deleteUser(String username) {
        User user = this.getUser(username);
        
        String newUsername = username + '*';
        
        if (user != null) {
            String sql = "UPDATE users SET username = '" + newUsername + "', role = 1 WHERE username = '" + username + "';";
            try (Connection conn = DriverManager.getConnection(driverURL);
                Statement stmt = conn.createStatement()){
                stmt.execute(sql);
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/deleteUser] User [" + username + "] marked for deletion.");
                }
            } catch (Exception ex) {
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/deleteUser] " + ex);
                }
            }
        }
    }
    
    public void setLockState(String username, int newLockState) {
        User user = this.getUser(username);
        
        if (user != null) {
            String sql = "UPDATE users SET locked = " + newLockState + " WHERE username = '" + username + "';";
            try (Connection conn = DriverManager.getConnection(driverURL);
                Statement stmt = conn.createStatement()){
                stmt.execute(sql);
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/setLockState] Lock state changed for User [" + username + "].");
                }
            } catch (Exception ex) {
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/setLockState] " + ex);
                }
            }
        }
    }
    
    public void changePassword(String username, String newPass) {
        User user = this.getUser(username);
        
        if (user != null) {
            String sql = "UPDATE users SET password = '" + newPass + "' WHERE username = '" + username + "';";
            try (Connection conn = DriverManager.getConnection(driverURL);
                Statement stmt = conn.createStatement()){
                stmt.execute(sql);
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/changePassword] Changed password for User [" + username + "].");
                }
            } catch (Exception ex) {
                if (this.DEBUG_MODE == 1) {
                    System.out.println("[SQLite/changePassword] " + ex);
                }
            }
        }
    }
    
}