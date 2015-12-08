package com.example.ali.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultDetailActivity extends AppCompatActivity{

    public static Book chosenBook;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }


    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        public Button reserve_button;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_result_detail, container, false);
            reserve_button = (Button)rootView.findViewById(R.id.reserve_button);
            Intent intent = getActivity().getIntent();
            final View.OnClickListener Click = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.reserve_button:
                            ReservationManager RM = ReservationManager.getInstance();
                            RM.Reserve(chosenBook);


                            Toast.makeText(getActivity(), "Book Reserved", Toast.LENGTH_LONG).show();
                            ((TextView) getActivity().findViewById(R.id.reserve_status)).setText("You have reserved this book, you can contact seller by email: "
                                    + chosenBook.getOwner_Email() + " or phone: " + chosenBook.getOwner_Phone());
                            reserve_button.setVisibility(View.GONE);

                            break;
                    }
                }
            };
            if (intent != null && intent.hasExtra("chosenBook")) {
                chosenBook = (Book) intent.getSerializableExtra("chosenBook");
//                String chosenBook = intent.getStringExtra("chosenBook");
                ((TextView) rootView.findViewById(R.id.detail_title)).setText(chosenBook.getTitle());
                ((TextView) rootView.findViewById(R.id.detail_price)).setText(chosenBook.getPrice());
                ((TextView) rootView.findViewById(R.id.detail_user)).setText("Seller: " + chosenBook.getOwner_name());
                ((TextView) rootView.findViewById(R.id.detail_description)).setText("Description: " + chosenBook.getDescription());
                if(chosenBook.getTitle().equals(ThisUser.reservedBook1)||chosenBook.getTitle().equals(ThisUser.reservedBook2)){
                    ((TextView) rootView.findViewById(R.id.reserve_status)).setText("You have reserved this book, you can contact seller by email: "
                            +chosenBook.getOwner_Email()+" or phone: "+chosenBook.getOwner_Phone());
                    reserve_button.setVisibility(View.GONE);
                }
                else {
                    ((TextView) rootView.findViewById(R.id.reserve_status)).setText("You can reserve this book now.");
                    reserve_button.setVisibility(View.VISIBLE);
                }
            }
            reserve_button.setOnClickListener(Click);
            return rootView;
        }

    }

}
