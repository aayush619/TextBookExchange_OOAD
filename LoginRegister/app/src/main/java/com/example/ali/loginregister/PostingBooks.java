package com.example.ali.loginregister;

import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PostingBooks extends AppCompatActivity implements View.OnClickListener{


    Button Post;
    EditText txt_title,txt_author,txt_description,txt_price,txt_email,txt_phone;
    String owner_name,title,author,description,price,owner_email,owner_phone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting_books);

        txt_title = (EditText) findViewById(R.id.text_Title);
        txt_author = (EditText) findViewById(R.id.text_Author);
        txt_description = (EditText) findViewById(R.id.text_Description);
        txt_price = (EditText) findViewById(R.id.text_Price);
        txt_phone = (EditText) findViewById(R.id.text_phone);
        txt_email = (EditText) findViewById(R.id.text_Email);
        Post = (Button) findViewById(R.id.button);
        Post.setOnClickListener(this);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button) {
            Toast.makeText(PostingBooks.this, "Submitting", Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(this, Db_connection.class);
            //startActivity(intent);
            owner_name = ThisUser.username;
            title = txt_title.getText().toString();
            author = txt_author.getText().toString();
            description = txt_description.getText().toString();
            price = txt_price.getText().toString();
            owner_email = txt_email.getText().toString();
            owner_phone = txt_phone.getText().toString();


            Book book = new Book(owner_name,title,author,description,price
                    ,owner_email,owner_phone);
            book.addBook();
            finish();
        }

    }

}
