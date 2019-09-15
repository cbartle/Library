package com.cbartley.library;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookList extends Fragment {


    View view;
    private List<Book> books;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.content_title_page, container, false);

        listView = view.findViewById(R.id.dataSet);

        DBHelper dbHandler = new DBHelper(getContext());

        books = dbHandler.loadHandler();

        ArrayList<String> bookTitles = new ArrayList<>();

        for (Book book: books) {
            bookTitles.add(book.GetTitle());
        }
        BookAdapter adapter = new BookAdapter(getContext(), books);

        listView.setAdapter(adapter);


        // get the reference of Button
        return view;
    }

}
