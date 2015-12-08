package com.example.ali.loginregister;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangshuzhe on 11/23/15.
 */
public class DatabaseManager {
    private static DatabaseManager ourInstance = new DatabaseManager();

    public static DatabaseManager getInstance() {
        return ourInstance;
    }

    private DatabaseManager() {
    }

    //private Book[] book;
    private List<Book> book = new ArrayList<Book>();
    boolean search_done = false;
    boolean userFound = false;

    public boolean addBook(String Owner_name, String Title, String Author, String Description, String Price, String Owner_Email, String Owner_Phone) {
        String url_select = "http://john-shuzhe.byethost13.com/PostBook.php";
        //final URL url = new URL("http://john-shuzhe.byethost13.com/demo.php");

        final HttpClient httpClient = new DefaultHttpClient();
        final HttpPost httpPost = new HttpPost(url_select);

        final ArrayList<NameValuePair> namePaires = new ArrayList<NameValuePair>();
        namePaires.add(new BasicNameValuePair("Owner_name", Owner_name));
        namePaires.add(new BasicNameValuePair("Title", Title));
        namePaires.add(new BasicNameValuePair("Author", Author));
        namePaires.add(new BasicNameValuePair("Description", Description));
        namePaires.add(new BasicNameValuePair("Price", Price));
        namePaires.add(new BasicNameValuePair("Owner_Email", Owner_Email));
        namePaires.add(new BasicNameValuePair("Owner_Phone", Owner_Phone));


        class addBook_task extends AsyncTask<String, String, Void>
        {
            InputStream is = null ;
            String result = "";
            protected void onPreExecute() {

            }
            @Override
            protected Void doInBackground(String... params) {

                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(namePaires));

                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    HttpEntity httpEntity = httpResponse.getEntity();

                    //read content
                    is =  httpEntity.getContent();


                } catch (Exception e) {

                    Log.e("log_tag", "Error in http connection " + e.toString());
                    //Toast.makeText(MainActivity.this, "Please Try Again", Toast.LENGTH_LONG).show();
                }


                return null;

            }
            protected void onPostExecute(Void v) {

                // ambil data dari Json database

            }
        }

        new addBook_task().execute();
        return true;

    }



    public boolean addUser(String name, String username, String password, String email) {
        String url_select = "http://john-shuzhe.byethost13.com/addUser.php";
        //final URL url = new URL("http://john-shuzhe.byethost13.com/demo.php");

        final HttpClient httpClient = new DefaultHttpClient();
        final HttpPost httpPost = new HttpPost(url_select);

        final ArrayList<NameValuePair> namePaires = new ArrayList<NameValuePair>();
        namePaires.add(new BasicNameValuePair("name", name));
        namePaires.add(new BasicNameValuePair("username", username));
        namePaires.add(new BasicNameValuePair("password", password));
        namePaires.add(new BasicNameValuePair("email", email));


        class addUser_task extends AsyncTask<String, String, Void>
        {
            InputStream is = null ;
            String result = "";
            protected void onPreExecute() {

            }
            @Override
            protected Void doInBackground(String... params) {

                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(namePaires));

                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    HttpEntity httpEntity = httpResponse.getEntity();

                    //read content
                    is =  httpEntity.getContent();


                } catch (Exception e) {

                    Log.e("log_tag", "Error in http connection " + e.toString());
                    //Toast.makeText(MainActivity.this, "Please Try Again", Toast.LENGTH_LONG).show();
                }


                return null;

            }
            protected void onPostExecute(Void v) {

                // ambil data dari Json database

            }
        }

        new addUser_task().execute();
        return true;

    }






           public List<Book> searchBook(String book_title)
           {
            //This fn. is receiving the book's name that user entered.
               // U need to search the book in the database and return the book's title and the price.
               String url_select = "http://john-shuzhe.byethost13.com/SearchBook.php";
               search_done = false;

               //final URL url = new URL("http://john-shuzhe.byethost13.com/demo.php");
               final HttpClient httpClient = new DefaultHttpClient();
               final HttpPost httpPost = new HttpPost(url_select);

               final ArrayList<NameValuePair> namePaires = new ArrayList<NameValuePair>();
               namePaires.add(new BasicNameValuePair("Title", book_title));


               class searchBook_task extends AsyncTask<String, String, Void>
               {
                   InputStream is = null ;
                   String result = "";
                   protected void onPreExecute() {

                   }
                   @Override
                   protected Void doInBackground(String... params) {

                       try {
                           httpPost.setEntity(new UrlEncodedFormEntity(namePaires));

                           HttpResponse httpResponse = httpClient.execute(httpPost);
                           HttpEntity httpEntity = httpResponse.getEntity();

                           //read content
                           is =  httpEntity.getContent();


                       } catch (Exception e) {

                           Log.e("log_tag", "Error in http connection " + e.toString());
                           //Toast.makeText(MainActivity.this, "Please Try Again", Toast.LENGTH_LONG).show();
                       }

                       try {
                           BufferedReader br = new BufferedReader(new InputStreamReader(is));
                           StringBuilder sb = new StringBuilder();
                           String line = "";
                           while((line=br.readLine())!=null)
                           {
                               sb.append(line+"\n");
                           }
                           is.close();
                           result=sb.toString();

                       } catch (Exception e) {
                           // TODO: handle exception
                           Log.e("log_tag", "Error converting result "+e.toString());
                       }

                       try {
                           JSONArray Jarray = new JSONArray(result);
                           book.clear();
                           for(int i=0;i<Jarray.length();i++) {
                               JSONObject Jasonobject = null;
                               //text_1 = (TextView)findViewById(R.id.txt1);
                               Jasonobject = Jarray.getJSONObject(i);

                               //get an output on the screen
                               //String id = Jasonobject.getString("id");
                               String Owner_name = Jasonobject.getString("Owner_name");
                               String Title = Jasonobject.getString("Title");
                               String Author = Jasonobject.getString("Author");
                               String Description = Jasonobject.getString("Description");
                                   String Price = Jasonobject.getString("Price");
                               String Owner_Email = Jasonobject.getString("Owner_Email");
                               String Owner_Phone = Jasonobject.getString("Owner_Phone");
                               String db_detail = "";
                               book.add(new Book(Owner_name, Title, Author, Description, Price, Owner_Email, Owner_Phone));
                               search_done = true;
                           }

                       } catch (Exception e) {
                           // TODO: handle exception
                           Log.e("log_tag", "Error parsing data "+e.toString());
                       }
                       return null;

                   }
                   protected void onPostExecute(Void v) {

                       // ambil data dari Json database


                   }
               }
               try {
                   AsyncTask task = new searchBook_task().execute();
                   //task.execute();
                   task.get();
               }
               catch(Exception e){

               }
               return book;



           }


    public boolean searchUser(final String userName, final String password)
    {

        String url_select = "http://john-shuzhe.byethost13.com/searchUser.php";

        final HttpClient httpClient = new DefaultHttpClient();
        final HttpPost httpPost = new HttpPost(url_select);

        final ArrayList<NameValuePair> namePaires = new ArrayList<NameValuePair>();
        namePaires.add(new BasicNameValuePair("UserName", userName));
        namePaires.add(new BasicNameValuePair("Password", password));

        search_done = false;

        class searchUser_task extends AsyncTask<String, String, Void>
        {
            InputStream is = null ;
            String result = "";
            protected void onPreExecute() {

            }
            @Override
            protected Void doInBackground(String... params) {

                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(namePaires));

                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    HttpEntity httpEntity = httpResponse.getEntity();
                    System.out.println(httpEntity);

                    //read content
                    is =  httpEntity.getContent();


                } catch (Exception e) {

                    Log.e("log_tag", "Error in http connection " + e.toString());
                    //Toast.makeText(MainActivity.this, "Please Try Again", Toast.LENGTH_LONG).show();
                }

                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    StringBuilder sb = new StringBuilder();
                    String line = "";
                    while((line=br.readLine())!=null)
                    {
                        sb.append(line+"\n");
                    }
                    is.close();
                    result=sb.toString();

                } catch (Exception e) {
                    // TODO: handle exception
                    Log.e("log_tag", "Error converting result "+e.toString());
                }

                try {
                    System.out.println("Search: ");
                    System.out.println(result);
                    JSONArray Jarray = new JSONArray(result);

                    for(int i=0;i<Jarray.length();i++) {
                        JSONObject Jasonobject = null;
                        //text_1 = (TextView)findViewById(R.id.txt1);
                        Jasonobject = Jarray.getJSONObject(i);

                        //get an output on the screen
                        //String id = Jasonobject.getString("id");
                        String db_user_name = Jasonobject.getString("username");
                        String db_pass = Jasonobject.getString("password");
                        if(userName.equals(db_user_name) && password.equals(db_pass)){
                            userFound = true;
                            System.out.println("user found"+db_user_name);
                            System.out.println("pwd found"+db_pass);
                            search_done = true;
                            i = Jarray.length()+1;
                        }
                    }

                } catch (Exception e) {
                    // TODO: handle exception
                    Log.e("log_tag", "Error parsing data "+e.toString());
                }
                return null;

            }
            protected void onPostExecute(Void v) {
                // ambil data dari Json database
            }
        }
        try {
            AsyncTask task = new searchUser_task().execute();
            //task.execute();
            task.get();
        }
        catch(Exception e){

        }
        return userFound;
    }

public void deleteEntry(String book1)
{
    // This function is receiving the book's title that the user bought from the Reservation Manager Activity.
    //This function would delete the corresponding entry from the database.
}

}
