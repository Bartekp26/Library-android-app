package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adapter = new BookRecViewAdapter(this);
        booksRecView= findViewById(R.id.booksRecView);

        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1, "Angels & Demons", "Dan Brown", 616, "https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/DaVinciCode.jpg/220px-DaVinciCode.jpg",
                "Mystery thriller novel", "Long description"));

        books.add(new Book(2, "The Da Vinci Code", "Dan Brown", 489, "https://www.taniaksiazka.pl/images/popups/D37/9788375088489.jpg",
                "Mystery thriller novel", "Long description"));


        adapter.setBooks(books);
    }
}