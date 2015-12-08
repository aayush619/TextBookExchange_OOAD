package com.example.ali.loginregister;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class ResultActivity extends AppCompatActivity {

//    RelativeLayout resultlayout;
//    TextView BookTitle;
//    TextView Price;
//    Button buy;
//    private String title;
//    private String pri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar ();
        bar.setTitle("Search Result");
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });




//        Bundle extras = getIntent().getExtras();
//        Book[] book = (Book[]) extras.getSerializable("book");
//        System.out.println(book[0].getOwner_name());
//        BookTitle.setText(book[0].getTitle()+" "+book[0].getAuthor()+" "+book[0].getOwner_name());
//        Price.setText(book[0].getPrice());
//    Price.setText(pri);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        buy = (Button) resultlayout.findViewById(R.id.buttonBuy);
//        buy.setOnClickListener(this);
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        final AlertDialog.Builder alert = new AlertDialog.Builder(ResultActivity.this);
//        alert.setTitle("CONFIRMATION!!");
//        alert.setMessage("Are you sure you want to buy this book");
//
//        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(), "Please contact the seller aayushgrover.dx@gmail.com within next 2 days", Toast.LENGTH_LONG).show();
//                 ReservationManager.Reserve(title);
//
//            }
//        });
//
//        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(), "Sorry to not meet up your needs", Toast.LENGTH_LONG).show();
//            }
//        });
//    }


}
