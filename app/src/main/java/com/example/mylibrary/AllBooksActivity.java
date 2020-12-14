package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
        booksRecView.setLayoutManager(new GridLayoutManager(this, 2));
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "Yoda", "George Lucas", 541, "https://cdn.al.to/i/setup/images/prod/big/product-new-big,,2020/5/pr_2020_5_12_10_11_10_295_00.jpg",
                "Short description", "Long description"));

        adapter.setBooks(books);
    }
}