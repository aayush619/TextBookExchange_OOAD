package com.example.ali.loginregister;

import java.util.List;

/**
 * Created by Aayush on 11/28/2015.
 */
public class Searchmanager {
    private static Searchmanager ourInstance = new Searchmanager();

    public static Searchmanager getInstance() {
        return ourInstance;
    }

    private Searchmanager() {
    }

    public List<Book> searchResult(String book)
    {
        DatabaseManager ds = DatabaseManager.getInstance();
        return ds.searchBook(book);
    }

    public boolean searchUser(String userName, String password)
    {
        DatabaseManager ds = DatabaseManager.getInstance();
        return ds.searchUser(userName, password);
    }
    public void getUser(String UserName){
        DatabaseManager ds = DatabaseManager.getInstance();
        ds.getUser(UserName);
    }
}
