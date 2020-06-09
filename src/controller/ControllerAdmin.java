/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.AddNewMovie;
import View.AddNewScheduleMovie;
import View.AddNewStaff;
import View.UpdateAccount;
import View.UpdateFoodsDrinks;
import View.UpdateMovie;
import View.ViewAddNewFoodsDrinks;
import View.ViewAdmin;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Account;
import model.FoodAndDrink;
import model.Movie;
import model.MovieSchedule;
import modelDao.adminDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerAdmin {
    private ViewAddNewFoodsDrinks vanfd ;
    private ViewAdmin viewadmin;
    private AddNewScheduleMovie ansm;
    private UpdateFoodsDrinks uFaD;
    private UpdateMovie uM;
    private UpdateAccount uA;
    private AddNewStaff ans;    
    private AddNewMovie anM;
    private JTable movieScheduleTable;
    private JTable moviesTable;
    private JTable foodJTable;
    private JTable accountTable;
    private JTabbedPane tabbed;
    private JTextField searchBar;
    private JButton searchBtn;
    private JButton deleteMovieBtn;
    private JButton deleteAccountBtn;
    private JButton deleteMovieSchedule;
    private JButton deleteFoodOrDrink;

    public ControllerAdmin() {
        viewadmin = new ViewAdmin();
        vanfd = new ViewAddNewFoodsDrinks();
        ansm = new AddNewScheduleMovie();
        uM= new UpdateMovie();
        uFaD = new UpdateFoodsDrinks();
        uA = new UpdateAccount();
        anM = new AddNewMovie();
        viewadmin.setVisible(true);
        generateMovieSchedule();
        generateMovie();
        generateFoodAnDrink();
        generateStaffAccount();
        search();
        deleteMovieSchedule();
        deleteAMovie();
        deleteAFoodAndDrink();
        deleteAnAccount();
        addMovie();
        addFoodAndDrink();
        addAccount();
        updateMovie();
        updateAnAcoount();
        updateAFoodAndDrink();
    }

    private void generateMovieSchedule() {
        adminDao aD = new adminDao();
        ArrayList<MovieSchedule> movieSchedules = aD.getAllMovieSchedule();
        movieScheduleTable = viewadmin.getMovieScheduleTable();
        movieScheduleTable.setModel(new DefaultTableModel(movieSchedules.size(), 4));
        String header[] = {"ID", "Title", "Schedule", "Movie ID"};

        for (int i = 0; i < movieScheduleTable.getColumnCount(); i++) {
            TableColumn column1 = movieScheduleTable.getTableHeader().getColumnModel().getColumn(i);

            column1.setHeaderValue(header[i]);
        }
        //TODO: add rows values
        for (int i = 0; i < movieScheduleTable.getRowCount(); i++) {
            movieScheduleTable.setValueAt(movieSchedules.get(i).getId(), i, 0);
            movieScheduleTable.setValueAt(aD.getSpecificMovie(movieSchedules.get(i).getMovieId()), i, 1);
            movieScheduleTable.setValueAt(movieSchedules.get(i).getMovieId(), i, 2);
            movieScheduleTable.setValueAt(movieSchedules.get(i).getMovieId(), i, 3);
        }
    }

    private void generateMovie() {
        adminDao aD = new adminDao();
        ArrayList<Movie> movies = aD.getAllMovie();
        moviesTable = viewadmin.getMovieTable();
        moviesTable.setModel(new DefaultTableModel(movies.size(), 3));

        String[] headers = {"ID", "Titel", "Image url"};
        for (int i = 0; i < moviesTable.getColumnCount(); i++) {
            TableColumn column1 = moviesTable.getTableHeader().getColumnModel().getColumn(i);

            column1.setHeaderValue(headers[i]);
        }
        //TODO: add rows values
        for (int i = 0; i < moviesTable.getRowCount(); i++) {
            moviesTable.setValueAt(movies.get(i).getMovieId(), i, 0);
            moviesTable.setValueAt(movies.get(i).getName(), i, 1);
            moviesTable.setValueAt(movies.get(i).getUrlImg(), i, 2);
        }
    }

    private void generateFoodAnDrink() {
        adminDao aD = new adminDao();
        foodJTable = viewadmin.getFoodAndDrink();
        ArrayList<FoodAndDrink> foodAndDrinks = aD.getAllFoodAndDrinks();
        foodJTable.setModel(new DefaultTableModel(foodAndDrinks.size(), 3));
        String[] headers = {"ID", "Name", "Price", "Quantity"};
        for (int i = 0; i < foodJTable.getColumnCount(); i++) {
            TableColumn column1 = foodJTable.getTableHeader().getColumnModel().getColumn(i);

            column1.setHeaderValue(headers[i]);
        }
        //TODO: add rows values
        for (int i = 0; i < foodJTable.getRowCount(); i++) {
            foodJTable.setValueAt(foodAndDrinks.get(i).getId(), i, 0);
            foodJTable.setValueAt(foodAndDrinks.get(i).getName(), i, 1);
            foodJTable.setValueAt(foodAndDrinks.get(i).getPrice(), i, 2);
            foodJTable.setValueAt(foodAndDrinks.get(i).getQuanity(), i, 3);

        }
    }

    private void generateStaffAccount() {
        adminDao aD = new adminDao();
        accountTable = viewadmin.getAccountTable();
        ArrayList<Account> accounts = aD.getAllAccounts();
        accountTable.setModel(new DefaultTableModel(accounts.size(), 4));
        String[] headers = {"ID", "Username", "Password", "Type"};
        for (int i = 0; i < accountTable.getColumnCount(); i++) {
            TableColumn column1 = accountTable.getTableHeader().getColumnModel().getColumn(i);

            column1.setHeaderValue(headers[i]);
        }
        //TODO: add rows values
        for (int i = 0; i < accountTable.getRowCount(); i++) {
            accountTable.setValueAt(accounts.get(i).getUserId(), i, 0);
            accountTable.setValueAt(accounts.get(i).getUsername(), i, 1);
            accountTable.setValueAt(accounts.get(i).getPassword(), i, 2);
            accountTable.setValueAt(accounts.get(i).getType(), i, 3);

        }
    }

    private void search() {
        searchBtn = viewadmin.getSearchBtn();
        tabbed = viewadmin.getTabbed();
        searchBtn.addActionListener((v1) -> {
            searchBar = viewadmin.getSearchBar();
            String result = searchBar.getText();
            int chosen = tabbed.getSelectedIndex();
            switch (chosen) {
                case 0:
                    getChosenMovieSchedule(Integer.parseInt(result));
                    System.out.println(chosen);
                    break;
                case 1:
                    getChosenMovie(Integer.parseInt(result));
                    System.out.println(chosen);
                    break;
                case 2:
                    getChosenFoodAndDrink(Integer.parseInt(result));
                    System.out.println(chosen);
                    break;
                case 3:
                    getChosenAccount(result);
                    System.out.println(chosen);
                    break;
                default:
                    break;
            }

        });
    }

    private void getChosenMovieSchedule(int chosen) {
        adminDao aD = new adminDao();
        MovieSchedule movieSchedule = aD.getSpecificMovieSchedule(chosen);
        movieScheduleTable.setModel(new DefaultTableModel(1, 4));
        String header[] = {"ID", "Title", "Schedule", "Movie ID"};

        for (int i = 0; i < movieScheduleTable.getColumnCount(); i++) {
            TableColumn column1 = movieScheduleTable.getTableHeader().getColumnModel().getColumn(i);
            column1.setHeaderValue(header[i]);
        }
        for (int i = 0; i < movieScheduleTable.getRowCount(); i++) {
            movieScheduleTable.setValueAt(movieSchedule.getId(), i, 0);
            movieScheduleTable.setValueAt(aD.getSpecificMovie(movieSchedule.getMovieId()), i, 1);
            movieScheduleTable.setValueAt(movieSchedule.getSchedule(), i, 2);
            movieScheduleTable.setValueAt(movieSchedule.getMovieId(), i, 3);
        }
    }

    private void getChosenMovie(int chosen) {
        adminDao aD = new adminDao();
        Movie movies = aD.getSpecificMovie(chosen);
        moviesTable = viewadmin.getMovieTable();
        moviesTable.setModel(new DefaultTableModel(1, 5));

        String[] headers = {"ID", "Title", "Image url"};
        for (int i = 0; i < moviesTable.getColumnCount(); i++) {
            TableColumn column1 = moviesTable.getTableHeader().getColumnModel().getColumn(i);
            column1.setHeaderValue(headers[i]);
        }
        for (int i = 0; i < moviesTable.getRowCount(); i++) {
            moviesTable.setValueAt(movies.getMovieId(), i, 0);
            moviesTable.setValueAt(movies.getName(), i, 1);
            moviesTable.setValueAt(movies.getUrlImg(), i, 2);
            ;
        }
    }

    private void getChosenFoodAndDrink(int chosen) {
        adminDao aD = new adminDao();
        foodJTable = viewadmin.getFoodAndDrink();
        FoodAndDrink foodAndDrinks = aD.getSpecificFoodAndDrink(chosen);
        foodJTable.setModel(new DefaultTableModel(1, 2));
        String[] headers = {"ID", "Name", "Price", "Quantity"};
        for (int i = 0; i < foodJTable.getColumnCount(); i++) {
            TableColumn column1 = foodJTable.getTableHeader().getColumnModel().getColumn(i);

            column1.setHeaderValue(headers[i]);
        }
        for (int i = 0; i < foodJTable.getRowCount(); i++) {
            foodJTable.setValueAt(foodAndDrinks.getId(), i, 0);
            foodJTable.setValueAt(foodAndDrinks.getName(), i, 1);
            foodJTable.setValueAt(foodAndDrinks.getPrice(), i, 2);
            foodJTable.setValueAt(foodAndDrinks.getQuanity(), i, 3);

        }
    }

    private void getChosenAccount(String chosen) {
        adminDao aD = new adminDao();
        accountTable = viewadmin.getAccountTable();
        Account accounts = aD.getSpecificAccount(chosen);
        accountTable.setModel(new DefaultTableModel(1, 4));
        String[] headers = {"ID", "Username", "Password", "Type"};
        for (int i = 0; i < accountTable.getColumnCount(); i++) {
            TableColumn column1 = accountTable.getTableHeader().getColumnModel().getColumn(i);

            column1.setHeaderValue(headers[i]);
        }
        for (int i = 0; i < accountTable.getRowCount(); i++) {
            accountTable.setValueAt(accounts.getUserId(), i, 0);
            accountTable.setValueAt(accounts.getUsername(), i, 1);
            accountTable.setValueAt(accounts.getPassword(), i, 2);
            accountTable.setValueAt(accounts.getType(), i, 3);

        }
    }

    private void addMovie() {
        adminDao ad = new adminDao();
        anM.getConfirmBtn().addActionListener((t)->{ 
            String title = anM.getTitleTextField().getText();
            String path = anM.getBrowseBtn().getText();
            Movie movie = new Movie();
            movie.setName(title);
            movie.setUrlImg(path);
            ad.insertAMovie(movie);
        });
    }

    private void addFoodAndDrink() {
        //TODO: add food and drink movie
        //MISSING: UI
       adminDao aD = new adminDao();
        vanfd.getoKBtn().addActionListener((ok) ->{
            String name = vanfd.getNameField().getText();
            double price = Double.parseDouble(vanfd.getPriceField().getText());
            FoodAndDrink food = new FoodAndDrink(name, price);
            aD.insertAFoodsAndDrinks(food);
        
        });
        vanfd.getCancelBtn().addActionListener((v)->{
            vanfd.dispose();
        });
    }

    private void addMovieSchedule() {
        //TODO: add movies Schedule
        
//         adminDao aD = new adminDao();
//         MovieSchedule mv = new MovieSchedule(schedule, 0);
//         aD.insertAMovieSchedule(movieSchedule);
    }

    private void addAccount() {
        //TODO: add account
        //MISSING: UI
         adminDao aD = new adminDao();
        ans.getAddBtn().addActionListener((v1) ->{
            
            try {
                 String username = ans.getUsername().getText();
                 String password = ans.getPassword().getText();
                 String hashPass = toHexString(password);
                 String type = ans.getAccountType().getSelectedItem().toString();
                 Account acc = new Account(username, hashPass,type);
                 aD.insertAnAccount(acc);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        });
       
    }

    private void updateMovie() {
        //TODO: update a movie
        //MISSING: UI
        adminDao aD = new adminDao();
        int iD = Integer.parseInt(uM.getSearchBtn().getText());
        ArrayList<Movie> movies = aD.getAllMovie();
        Movie mo = new Movie();
        for(Movie m: movies){
            if(m.getMovieId() == iD){
                mo.setMovieId(iD);
                mo.setName(m.getName());
                mo.setScheduleMovieId(m.getScheduleMovieId());
                mo.setUrlImg(m.getUrlImg());
                break;
            }
        }
        uM.getTitleField().setText(mo.getName());
        uM.getUpdateBtn().addActionListener((lis)->{
            String name = uM.getTitleField().getText();
            String path = uM.getBrowseBtn().getText();
            aD.updateAMovie(iD, name, path,mo.getScheduleMovieId());
        
        });
        
    }

    private void updateMovieSchedule() {
        //TODO: update a movie schedule
        //MISSING: UI
    }

    private void updateAFoodAndDrink() {
        //TODO: update a food or drink
        //MISSING: UI
        try{
        adminDao aD = new adminDao();
        int iD = Integer.parseInt(uFaD.getiDField().getText());
        uFaD.getSearchBtn().addActionListener((e2) -> { 
            FoodAndDrink fD = aD.getSpecificFoodAndDrink(iD);
            uFaD.getNameField().setText(fD.getName());
            uFaD.getPriceField().setText(String.valueOf(fD.getPrice()));
            uFaD.getQuantityField().setText(String.valueOf(fD.getQuanity()));
        
        });
        uFaD.getCancelBtn().addActionListener((e1)->{
            uFaD.dispose();
        });
        uFaD.getUpdateBtn().addActionListener((e) -> { 
            String name =  uFaD.getNameField().getText();
            double price = Double.parseDouble(uFaD.getPriceField().getText());
            int quantity = Integer.parseInt(uFaD.getQuantityField().getText());
            aD.updateAFoodsAndDrinks(iD, name, price, iD);
        });
        }catch(Exception e){
            //dialog
        }
    }

    private void updateAnAcoount() {
        //TODO: update an account
        //MISSING: UI
        uA.getSearchBtn().addActionListener((o) -> { 
            int iD = Integer.parseInt(uA.getiDField().getText());
            adminDao aD = new adminDao();
            ArrayList<Account> accounts = aD.getAllAccounts();
            for(Account acc : accounts){
                if(acc.getUserId() == iD){
                    uA.getUserNameField().setText(acc.getUsername());
                    uA.getPasswordField().setText(acc.getPassword());
                    uA.getRole().setSelectedItem(acc.getType());
                    break;
                }
            }
            
        });
        uA.getCancelBtn().addActionListener((v)-> { 
            uA.dispose();
        });
    }

    private void deleteAMovie() {
        adminDao aD = new adminDao();
        deleteMovieBtn = viewadmin.getDeleteBtn();
        deleteMovieBtn.addActionListener((v2) -> {
            tabbed = viewadmin.getTabbed();

            DefaultTableModel dtb = (DefaultTableModel) moviesTable.getModel();
            int selectedRowIndex = moviesTable.getSelectedRow();
            aD.deleteAMoive((int) dtb.getValueAt(selectedRowIndex, 0));

        });
    }

    private void deleteAnAccount() {
        adminDao aD = new adminDao();
        deleteAccountBtn = viewadmin.getDeleteStaff();
        deleteAccountBtn.addActionListener((v2) -> {
            tabbed = viewadmin.getTabbed();

            DefaultTableModel dtb = (DefaultTableModel) accountTable.getModel();
            int selectedRowIndex = accountTable.getSelectedRow();
            aD.deleteAnAccount((dtb.getValueAt(selectedRowIndex, 1)));

        });
    }

    private void deleteMovieSchedule() {
        adminDao aD = new adminDao();
        deleteMovieSchedule = viewadmin.getDeleteMovieSchedule();
        deleteMovieSchedule.addActionListener((v2) -> {
            tabbed = viewadmin.getTabbed();

            DefaultTableModel dtb = (DefaultTableModel) movieScheduleTable.getModel();
            int selectedRowIndex = movieScheduleTable.getSelectedRow();
            aD.deleteAMoiveSchedule((int) (dtb.getValueAt(selectedRowIndex, 0)));
        });
    }

    private void deleteAFoodAndDrink() {
        //TODO: delete food and drink
        adminDao aD = new adminDao();
        deleteFoodOrDrink = viewadmin.getDeleteFoodOrDrink();
        deleteFoodOrDrink.addActionListener((f)->{
             tabbed = viewadmin.getTabbed();
              DefaultTableModel dtb = (DefaultTableModel) foodJTable.getModel() ;
            int selectedRowIndex = foodJTable.getSelectedRow();
            aD.deleteAFoodsAndDrinks((int) (dtb.getValueAt(selectedRowIndex, 0)));
        });
    }
    /**
     *
     * @param s
     * @effects
     * @return hash-265 pass
     * @throws NoSuchAlgorithmException
     */
    private String toHexString(String s) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(s.getBytes(StandardCharsets.UTF_8));
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
