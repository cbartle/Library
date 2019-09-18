package com.cbartley.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        TextView title = findViewById(R.id.displayTitle);
        TextView author = findViewById(R.id.displayAuthor);

        title.setText(getIntent().getStringExtra("Title"));
        author.setText(getIntent().getStringExtra("Author"));





    }
}
