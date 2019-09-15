package com.cbartley.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    private List<Book> books;
    private Context context;

    public BookAdapter(Context context, List<Book> books) {
        super(context, -1, books);
        this.books = books;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View view = convertView;

        if(view == null){

            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            view = vi.inflate(R.layout.book_list,parent, false);
        }

        Book currentBook= books.get(position);

        TextView title = view.findViewById(R.id.row_title);
        title.setText(currentBook.GetTitle());

        TextView author = view.findViewById(R.id.row_author);
        author.setText(currentBook.GetAuthor());

        return view;
    }

}
