/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;

import DBConnect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Account;
import model.Admin;
import model.FoodAndDrink;
import model.Movie;
import model.MovieSchedule;
import model.Staff;

/**
 *
 * @author Admin
 */
public class adminDao {
    private final Connection con;

    public adminDao() {
        con = DBConnection.getConnection();
    }
    
    public ArrayList<Movie> getAllMovie() {
        String query = "SELECT * FROM movie";
        ArrayList<Movie> lstMovie = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String urlImg = rs.getString("URL");
                int scheduleId = rs.getInt("MOVIESCHEDULEID");
                Movie movie = new Movie(id, name, urlImg, scheduleId);
                lstMovie.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstMovie;
    }

    public Movie getSpecificMovie(int movieId) {
        Movie movie = null;
        String query = "SELECT * FROM movie WHERE ID = " + "\"" + movieId + "\"";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String urlImg = rs.getString("URL");
                int scheduleId = rs.getInt("MOVIESCHEDULEID");
                movie = new Movie(id, name, urlImg, scheduleId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movie;
    }

    public void insertAMovie(Movie movie) {
        String query = "INSERT INTO movie (ID,NAME,URL,MOVIESCHEDULEID) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, movie.getMovieId());
            ps.setString(2, movie.getName());
            ps.setString(3, movie.getUrlImg());
            ps.setInt(4, movie.getScheduleMovieId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAMovie(int movieId, String name, String url, int scheduleId) {
        String query = "UPDATE movie SET NAME = (" + "\"" + name + "\"" + "),URL = (" + "\"" + url + "\"" + "),MOVIESCHEDULEID = (" + "\"" + scheduleId + "\"" + ") WHERE ID = " + movieId + "";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteAMoive(int movieId) {
        boolean deleted = false;
        if (getSpecificMovie(movieId) != null) {
            String query = "DELETE FROM movie WHERE ID = " + movieId + "";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.execute();
                deleted = true;
            } catch (SQLException ex) {
                Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return deleted;
    }
    
    public ArrayList<MovieSchedule> getAllMovieSchedule() {
        String query = "SELECT * FROM movieSchedule";
        ArrayList<MovieSchedule> lstMovieSchedule = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String schedule = rs.getString("SCHEDULE");
                int movieId = rs.getInt("MOVIEID");
                MovieSchedule movieSchedule = new MovieSchedule(id, schedule, movieId);
                lstMovieSchedule.add(movieSchedule);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstMovieSchedule;
    }

    public MovieSchedule getSpecificMovieSchedule(int movieScheduleId) {
        MovieSchedule movieSchedule = null;
        String query = "SELECT * FROM movieSchedule WHERE ID = " + "\"" + movieScheduleId + "\"";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String schedule = rs.getString("SCHEDULE");
                int movieId = rs.getInt("MOVIEID");
                movieSchedule = new MovieSchedule(id, schedule, movieId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movieSchedule;
    }
    
    public void insertAMovieSchedule(MovieSchedule movieSchedule) {
        String query = "INSERT INTO movieSchedule (ID,SCHEDULE,MOVIEID) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, movieSchedule.getId());
            ps.setString(2, movieSchedule.getSchedule());
            ps.setInt(3, movieSchedule.getMovieId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateAMovieSchedule(int movieScheduleId, String schedule, String movieId) {
        String query = "UPDATE movie SET SCHEDULE = (" + "\"" + schedule + "\"" + "),MOVIEID = (" + "\"" + movieId + "\"" + ") WHERE ID = " + movieScheduleId + "";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteAMoiveSchedule(int movieScheduleId) {
        boolean deleted = false;
        if (getSpecificMovieSchedule(movieScheduleId) != null) {
            String query = "DELETE FROM movieSchedule WHERE ID = " + movieScheduleId + "";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.execute();
                deleted = true;
            } catch (SQLException ex) {
                Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return deleted;
    }
    
    public ArrayList<FoodAndDrink> getAllFoodAndDrinks() {
        String query = "SELECT * FROM foodAndDrink";
        ArrayList<FoodAndDrink> lstFoodAndDrinks = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                int quantity = rs.getInt("QUANTITY");
                FoodAndDrink food = new FoodAndDrink(id, name, price, quantity);
                lstFoodAndDrinks.add(food);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstFoodAndDrinks;
    }

    public FoodAndDrink getSpecificFoodAndDrink(int foodAndDrinkID) {
        FoodAndDrink food = null;
        String query = "SELECT * FROM foodAndDrink WHERE ID = " + "\"" + foodAndDrinkID + "\"";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                int quantity = rs.getInt("QUANTITY");
                food = new FoodAndDrink(id, name, price, quantity);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return food;
    }
    
    public void insertAFoodsAndDrinks(FoodAndDrink food) {
        String query = "INSERT INTO foodAndDrink VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, food.getId());
            ps.setString(2, food.getName());
            ps.setDouble(3, food.getPrice());
            ps.setInt(4, food.getQuanity());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateAFoodsAndDrinks(int foodId, String name, int price, int quantity) {
        String query = "UPDATE foodAndDrink SET NAME = (" + "\"" + name + "\"" + "),PRICE = (" + "\"" + price + "\"" + "),QUANTITY = (" + "\"" + quantity + "\"" + ") WHERE ID = " + foodId;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteAFoodsAndDrinks(int foodId) {
        boolean deleted = false;
        if (getSpecificMovieSchedule(foodId) != null) {
            String query = "DELETE FROM foodAndDrink WHERE ID = " + foodId + "";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.execute();
                deleted = true;
            } catch (SQLException ex) {
                Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return deleted;
    }
    
    public ArrayList<Account> getAllAccounts() {
        String query = "SELECT * FROM account";
        ArrayList<Account> lstAccount = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String type = rs.getString("TYPE");
                int userId = rs.getInt("ACCOUNTID");
                Account account = new Account(username, password, type, userId);
                lstAccount.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAccount;
    }

    public Account getSpecificAccount(String username) {
        Account account = new Account("","");
        String query = "SELECT * FROM account WHERE USERNAME = " + "\"" + username + "\"";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("PASSOWORD");
                String type = rs.getString("TYPE");
                account.setPassword(password);
                account.setUsername(username);
                account.setType(type);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }
    
    public void insertAnAccount(Account account) {
        String query = "INSERT INTO account (USERNAME,PASSWORD,TYPE,ACCOUNTID) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getType());
            ps.setInt(4, account.getUserId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateAnAccount(String username, String password, String type, int userId) {
        String query = "UPDATE account SET USERID= (" + "\"" + userId + "\"" + "),PASSWORD = (" + "\"" + password + "\"" + "),TYPE = (" + "\"" + type + "\"" + ") WHERE USERNAME = " + username;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteAnAccount(String username) {
        boolean deleted = false;
       
            String query = "DELETE FROM account WHERE USERNAME = " + "\"" + username + "\"";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.execute();
                deleted = true;
            } catch (SQLException ex) {
                Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        return deleted;
    }
    
    public ArrayList<Staff> getAllStaff() {
        String query = "SELECT * FROM staff";
        ArrayList<Staff> lstStaff = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String dob = rs.getString("DOB");
                String phone = rs.getString("PHONE");
                String acName = rs.getString("ACCOUNTNAME");
                Staff staff = new Staff(id, name, dob, phone, getSpecificAccount(acName));
                lstStaff.add(staff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstStaff;
    }

    public Staff getSpecificStaff(int Id) {
        Staff staff = null;
        String query = "SELECT * FROM staff WHERE ID = " + "\"" + Id + "\"";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String dob = rs.getString("DOB");
                String phone = rs.getString("PHONE");
                String acName = rs.getString("ACCOUNTNAME");
                staff = new Staff(id, name, dob, phone, getSpecificAccount(acName));
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staff;
    }

    public void insertAStaff(Staff staff) {
        String query = "INSERT INTO staff (ID,NAME,DOB,PHONE,ACCOUNTNAME) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, staff.getId());
            ps.setString(2, staff.getName());
            ps.setString(3, staff.getDob());
            ps.setString(4, staff.getPhoneNumber());
            ps.setString(5, staff.getAccount().getUsername());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAStaff(int Id, String name, String dob, String phone, Account acc) {
        String query = "UPDATE staff SET NAME = (" + "\"" + name + "\"" + "),DOB = (" + "\"" + dob + "\"" + "),PHONE = (" + "\"" + phone + "\"" + "),ACCOUNTNAME = (" + "\"" + acc.getUsername() + "\"" + ") WHERE ID = " + Id + "";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteAStaff(int Id) {
        boolean deleted = false;
        if (getSpecificStaff(Id) != null) {
            String query = "DELETE FROM staff WHERE ID = " + Id + "";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.execute();
                deleted = true;
            } catch (SQLException ex) {
                Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return deleted;
    }
    
        public ArrayList<Admin> getAllAdmin() {
        String query = "SELECT * FROM admin";
        ArrayList<Admin> lstAdmin = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String dob = rs.getString("DOB");
                String phone = rs.getString("PHONE");
                String acName = rs.getString("ACCOUNTNAME");
                Admin admin = new Admin(id, name, dob, phone, getSpecificAccount(acName));
                lstAdmin.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAdmin;
    }

    public Admin getSpecificAdmin(int Id) {
        Admin admin = null;
        String query = "SELECT * FROM admin WHERE ID = " + "\"" + Id + "\"";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String dob = rs.getString("DOB");
                String phone = rs.getString("PHONE");
                String acName = rs.getString("ACCOUNTNAME");
                admin = new Admin(id, name, dob, phone, getSpecificAccount(acName));
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin;
    }

    public void insertAAdmin(Admin admin) {
        String query = "INSERT INTO admin (ID,NAME,DOB,PHONE,ACCOUNTNAME) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, admin.getId());
            ps.setString(2, admin.getName());
            ps.setString(3, admin.getDob());
            ps.setString(4, admin.getPhoneNumber());
            ps.setString(5, admin.getAccount().getUsername());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAAdmin(int Id, String name, String dob, String phone, Account acc) {
        String query = "UPDATE admin SET NAME = (" + "\"" + name + "\"" + "),DOB = (" + "\"" + dob + "\"" + "),PHONE = (" + "\"" + phone + "\"" + "),ACCOUNTNAME = (" + "\"" + acc.getUsername() + "\"" + ") WHERE ID = " + Id + "";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteAAdmin(int Id) {
        boolean deleted = false;
        if (getSpecificAdmin(Id) != null) {
            String query = "DELETE FROM admin WHERE ID = " + Id + "";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.execute();
                deleted = true;
            } catch (SQLException ex) {
                Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return deleted;
    }
    
    public boolean login(Account a){      
        boolean isSuccessed = false;
        if(getSpecificAccount(a.getUsername())!=null){
            isSuccessed = true;
        }
        return isSuccessed;
    }
    
    public ArrayList<Account> getListAccount(){
        String query = "SELECT * FROM account";
        ArrayList<Account> accounts = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account("", "", "");
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setType(rs.getString("type"));
                accounts.add(acc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return accounts;
    }
}
