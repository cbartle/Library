package com.cbartley.library;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddBookFragment  extends Fragment {

    private View view;

    private EditText title;
    private EditText author;
    private Spinner genres;
    private Button addButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.add_book_fragment, container, false);

        title = (EditText) view.findViewById(R.id.title);
        author = (EditText) view.findViewById(R.id.author);
        genres = (Spinner) view.findViewById(R.id.genres);
        genres.setAdapter(new ArrayAdapter<Genre>(getContext(), android.R.layout.simple_spinner_item, Genre.values()));
        addButton = view.findViewById(R.id.addbook);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHandler = new DBHelper(getContext());

                //int id = Integer.parseInt(studentid.getText().toString());

                String name = title.getText().toString();
                String auth = author.getText().toString();
                Genre genre = Genre.get(genres.getSelectedItem().toString());


                Book book = new Book(name, auth, genre);

                dbHandler.addHandler(book);

                author.setText("");

                title.setText("");
            }
        });

        // get the reference of Button
        return view;
    }
}
