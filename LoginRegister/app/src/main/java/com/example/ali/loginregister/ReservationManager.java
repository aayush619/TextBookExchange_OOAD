package com.example.ali.loginregister;

/**
 * Created by Aayush on 11/28/2015.
 */
public class ReservationManager {

    private static ReservationManager ourInstance = new ReservationManager();

    public static ReservationManager getInstance() {
        return ourInstance;
    }

    private ReservationManager() {
    }

       public static void Reserve(Book book)
       {
           DatabaseManager dm = DatabaseManager.getInstance();
           dm.ReserveBook(book);
       }

}
