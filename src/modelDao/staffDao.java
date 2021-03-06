/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;

import model.FoodAndDrink_Order;
import DBConnect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Account;
import model.ExtraOrder;
import model.FoodAndDrink;
import model.Movie;
import model.MovieSchedule;
import model.Order;
import model.Room;

/**
 *
 * @author Admin
 */
public class staffDao {

    private final Connection con;

    public staffDao() {
        con = DBConnection.getConnection();
    }
    
    //checked: oke
    public ArrayList<Movie> getAllMovie(){
        String query = "SELECT * FROM movie";
        
        ArrayList<Movie> listMovie = new ArrayList<>();
        
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("ID");
                String title = rs.getString("NAME");
                String genre = rs.getString("GENRE");
                String durationTime = rs.getString("DURATIONTIME");
                String thumbnail = rs.getString("THUMBNAIL");
                Movie m = new Movie(id, title, genre, durationTime, thumbnail);
                listMovie.add(m);
            }
        }catch(SQLException ex){
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMovie;
    }
    //checked: oke
    public Movie getSpecificMovie(int movieId){
        Movie movie = null;
        String query = "SELECT * FROM movie where id = " + movieId;
        
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int id = rs.getInt("ID");
                String nameMovie = rs.getString("NAME");
                String genre = rs.getString("GENRE");
                String durationTime = rs.getString("DURATIONTIME");
                String thumbnail = rs.getString("THUMBNAIL");
                movie = new Movie(id, nameMovie, genre, durationTime, thumbnail);
            }
        }catch(SQLException e){
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return movie;
    }
    
    //checked: oke
    public ArrayList<MovieSchedule> getAllMovieSchedule() {
        String query = "SELECT * FROM schedule";
        ArrayList<MovieSchedule> lstMovieSchedule = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String time = rs.getString("TIME");
                int movieId = rs.getInt("MOVIEID");
                MovieSchedule movieSchedule = new MovieSchedule(id, time, movieId);
                lstMovieSchedule.add(movieSchedule);
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstMovieSchedule;
    }
    
    //checked: oke
    public ArrayList<MovieSchedule>  getSpecificMovieSchedule(int mId) {
        ArrayList<MovieSchedule> listSchedule = new ArrayList<>();
        String query = "SELECT * FROM schedule WHERE MOVIEID = " + "\"" + mId + "\"";
        MovieSchedule movieSchedule = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String time = rs.getString("TIME");
                int movieId = rs.getInt("MOVIEID");
                movieSchedule = new MovieSchedule(id, time, movieId);
                listSchedule.add(movieSchedule);
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSchedule;
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

    public void updateAMovieSchedule(int movieScheduleId, String schedule, int movieId) {
        String query = "UPDATE movie SET SCHEDULE = (" + "\"" + schedule + "\"" + "),MOVIEID = (" + "\"" + movieId + "\"" + ") WHERE ID = " + movieScheduleId + "";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return deleted;
    }
    
    //checked: oke
    public ArrayList<Order> getAllOrder() {
        String query = "SELECT * FROM cinerma.order";
        ArrayList<Order> orders = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int orderId = rs.getInt("ID");
                int numOfTic = rs.getInt("NUMBERTICKET");
                double totalPrice = rs.getDouble("TOTALPRICE");
                int movieId = rs.getInt("MOVIEID");
                Order or = new Order(orderId,numOfTic, totalPrice, movieId);
                orders.add(or);
            }
        } catch (SQLException e) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return orders;
    }
    
    //check: oke
    public void insertFoodAndDrink_Order(FoodAndDrink_Order fo){
        String query = "INSERT INTO foodanddrink_order (ORDERID,FOODANDDRINKID, AMOUNT) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, fo.getOrderId());
            ps.setInt(2, fo.getFoodId());
            ps.setInt(3, fo.getQuanity());

            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Order getSpecificOrder(int orderId) {
        Order or = null;
        String query = "SELECT * FROM orders WHERE ORDERID = " + orderId;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int numOfTic = rs.getInt("NUMOFTICKET");
                double totalPrice = rs.getDouble("TOTALPRICE");
                MovieSchedule ms = getSpecificMovieSchedule(rs.getInt("MOVIESCHEDULEID"));
                ExtraOrder eo = getSpecificExtraOrder(rs.getInt("EXTRAORDERID"));
                int ro = rs.getInt("ROOMID");
                or = new Order(orderId, ms, eo, numOfTic, totalPrice, ro);
            }
        } catch (SQLException e) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return or;
    }

    //check: oke
    public void insertOrder(Order or) {
        String query = "INSERT INTO cinerma.order (NUMBERTICKET,TOTALPRICE,MOVIEID) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, or.getNumberTicket());
            ps.setDouble(2, or.getTotalPrice());
            ps.setInt(3, or.getMovieId());
            
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateOrder(int id, int numTic, double price, MovieSchedule movieS, ExtraOrder eo, int roomId) {
        String query = "UPDATE order SET NUMOFTICKET = (" + numTic + "),TOTALPRICE = (" + price + "),MOVIESCHEDULEID = (" + movieS.getId() + "),EXTRAORDERID = (" + eo.getExtraOrderId() + "),ROOMID = ("+roomId+") WHERE ORDERID = " + id;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateAMovieSchedule(movieS.getId(), movieS.getSchedule(), movieS.getMovieId());
        updateExtraOrder(eo);
    }

    public boolean deleteOrder(int id) {

        boolean isDeleted = false;

        String query = "DELETE FROM order WHERE ORDERID = " + id;

        try {
            deleteExtraOrder(getSpecificOrder(id).getExOrder().getExtraOrderId());
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isDeleted;
    }

    //checked: oke
    public ArrayList<Room> getAllRoom() {
        ArrayList<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM room";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                ArrayList<String> orderedSeat = splitString(rs.getString("ORDEREDSEAT"));
                int scheduleId = rs.getInt("SCHEDULEID");
                Room r = new Room(id, name, orderedSeat, scheduleId);
                rooms.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rooms;
    }

    public ArrayList<Room> getSpecificRoom(int scheduleId) {
        ArrayList<Room> rooms = new ArrayList<>();
        Room r = null;
        String query = "SELECT * FROM room WHERE SCHEDULEID = " + scheduleId;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                ArrayList<String> orderedSeat = splitString(rs.getString("ORDEREDSEAT"));
                int scheId = rs.getInt("SCHEDULEID");
                r = new Room(id, name, orderedSeat, scheId);
                rooms.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rooms;
    }
    
    public void  insertARoom(Room r){
        String text = "";
        ArrayList<String> lst = r.getSeats();
        for (int i = 0; i < lst.size(); i++) {
            if (i < lst.size() - 1) {
                text += lst.get(i) + ",";
            } else {
                text += lst.get(i);
            }
        }
        String query = "INSERT INTO room (ROOMID,ROOMNAME,SEATS) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, r.getRoomId());
            ps.setString(2, r.getRoomName());
            ps.setString(3, text);
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //check: 
    public void updateARoom(int roomId,String orderedSeats){
        //UPDATE `cinerma`.`room` SET `orderedSeat` = 'B-4,B-6' WHERE (`id` = '2');
        String query = "UPDATE cinerma.room SET orderedSeat = ? WHERE id = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, orderedSeats);
            ps.setInt(2, roomId);
            System.out.println(query);
            ps.execute();
        }catch(SQLException e){
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean login(Account a) {
        boolean isSuccessed = false;
        if (getSpecificAccount(a.getUsername()) != null) {
            isSuccessed = true;
        }
        return isSuccessed;
    }

    //utility functions
    private ArrayList<String> splitString(String str) {
        ArrayList<String> strs = new ArrayList<>();
        for (String a : str.split(" ")) {
            strs.add(a);
        }
        return strs;
    }

    private String getRawText(int extraOrderId) {
        String temp = "";
        String query = "SELECT * FROM extraOrder WHERE EXTRAORDERID = " + extraOrderId;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                temp = rs.getString("LSTEXTRAORDER");
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    private ExtraOrder getSpecificExtraOrder(int extraOrderId) {
        ExtraOrder eo;
        ArrayList<FoodAndDrink> fad = new ArrayList<>();
        ArrayList<Integer> extra = stringToInt(splitString(getRawText(extraOrderId)));
        extra.forEach((ex) -> {
            fad.add(getSpecificFoodAndDrink(ex));
        });
        eo = new ExtraOrder(extraOrderId, fad);
        return eo;
    }

    private void insertExtraOrder(ExtraOrder ex) {
        String text = "";
        ArrayList<FoodAndDrink> lst = ex.getListExtraOrder();
        for (int i = 0; i < lst.size(); i++) {
            if (i < lst.size() - 1) {
                text += lst.get(i).getId() + ",";
            } else {
                text += lst.get(i).getId();
            }
        }
        System.out.println(text+"a");
        String query = "INSERT INTO extraOrder (EXTRAORDERID, LSTEXTRAORDER) VALUES (?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,ex.getExtraOrderId());
            ps.setString(2,text);
            ps.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateExtraOrder(ExtraOrder ex) {
        String text = "";
        ArrayList<FoodAndDrink> lst = ex.getListExtraOrder();
        for (int i = 0; i < lst.size(); i++) {
            if (i < lst.size() - 1) {
                text += lst.get(i).getId() + ",";
            } else {
                text += lst.get(i).getId();
            }
        }
        String query = "UPDATE extraOrder SET LSTEXTRAORDER = (" + "\"" + text + "\"" + ") WHERE EXTRAORDERID = " + ex.getExtraOrderId();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException e) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteExtraOrder(int id) {
        String query = "DELETE FROM extraOrder WHERE EXTRAORDERID = " + id;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        } catch (SQLException e) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private ArrayList<Integer> stringToInt(ArrayList<String> a) {
        ArrayList<Integer> b = new ArrayList<>();
        a.forEach((c) -> {
            b.add(Integer.valueOf(c));
        });
        return b;
    }

    private ArrayList<String> intToString(ArrayList<Integer> a) {
        ArrayList<String> b = new ArrayList<>();
        a.forEach((c) -> {
            b.add(String.valueOf(c));
        });
        return b;
    }

    //check: oke
    public FoodAndDrink getSpecificFoodAndDrink(int foodAndDrinkID) {
        FoodAndDrink food = null;
        String query = "SELECT * FROM foodanddrink WHERE ID = " + "\"" + foodAndDrinkID + "\"";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                food = new FoodAndDrink(id, name, price);
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return food;
    }
    
    // changed: oke
    public Account getSpecificAccount(String username) {
        Account account = null;
        String query = "SELECT * FROM account WHERE USERNAME = " + "\"" + username + "\"";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("PASSOWORD");
                String type = rs.getString("TYPE");
                account = new Account(username, password, type);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }
    
    //checked: oke
    public ArrayList<FoodAndDrink> getAllFoodAndDrinks() {
        String query = "SELECT * FROM foodanddrink";
        ArrayList<FoodAndDrink> lstFoodAndDrinks = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                FoodAndDrink food = new FoodAndDrink(id, name, price);
                lstFoodAndDrinks.add(food);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstFoodAndDrinks;
    }
    
    //changed: oke
    public void updatePasswordAccount(String username, String password){
//        UPDATE ACCOUNT SET PASSOWORD = ("1234") WHERE USERNAME = "hieptv";
        String query = "UPDATE ACCOUNT SET PASSOWORD = ("+"\"" + password + "\"" + ") WHERE USERNAME = " + "\"" + username + "\"";
        System.out.println(query);
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
            
        }catch(SQLException e){
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
