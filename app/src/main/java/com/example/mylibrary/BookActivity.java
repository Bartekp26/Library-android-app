package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private TextView txtBookName, txtAuthor, txtPages, txtDescription;
    private Button btnAddToCurrentlyReading, btnAddToWantToRead, btnAddToAlreadyRead, btnAddToFavourite;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();
        
        Intent intent = getIntent();

        if(null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1){
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if(null != incomingBook){
                    setData(incomingBook);
                }
            }
        }
    }


    private void initViews(){
        txtBookName = findViewById(R.id.txtBookName);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtPages = findViewById(R.id.txtPages);
        txtDescription = findViewById(R.id.txtDescription);

        btnAddToCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToRead);
        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyRead);
        btnAddToFavourite = findViewById(R.id.btnFavourite);

        bookImage = findViewById(R.id.bookImage);
    }

    private void setData(Book book){
        txtBookName.setText(book.getTitle());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDescription());
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(bookImage);
    }

}