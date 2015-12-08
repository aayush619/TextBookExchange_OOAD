package com.example.ali.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ResultFragment extends Fragment {
    private ArrayAdapter<String> mResultAdapter;
    private List<Book> bookList;

    public ResultFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Book[] books = (Book[]) getActivity().getIntent().getExtras().getSerializable("book");
        bookList = new ArrayList<Book>(Arrays.asList(books));
        List<String> bookStringList = new ArrayList<String>();
        for(int i =0; i < books.length; i++){
//            Log.v("Zhihao", "books: " + books[i].getTitle());
            bookStringList.add(books[i].getTitle()+"  "+books[i].getOwner_name());
        }
//        Log.v("Zhihao", "books: " + books[0].getTitle());


//        String data[] = {"Today-Sunny-88/63","Today-Sunny-88/63","Today-Sunny-88/63","Today-Sunny-88/63","Today-Sunny-88/63",
//                "Today-Sunny-88/63","Today-Sunny-88/63"};
//        List<String> bookList = new ArrayList<String>(Arrays.asList(data));

        mResultAdapter = new ArrayAdapter<String> (getActivity(),R.layout.list_item_result,
                R.id.list_item_result_textview, bookStringList);

        View rootView = inflater.inflate(R.layout.fragment_result, container, false);

        ListView listview = (ListView) rootView.findViewById(R.id.listview_result);
        listview.setAdapter(mResultAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text = mResultAdapter.getItem(i).toString();
                Book chosenBook = bookList.get(i);
//                Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
                Intent detailIntent = new Intent(getActivity(), ResultDetailActivity.class);
                detailIntent.putExtra("chosenBook", chosenBook);
                startActivity(detailIntent);
            }
        });

        return rootView;

    }
}
