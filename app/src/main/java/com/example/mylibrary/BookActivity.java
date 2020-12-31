package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    private TextView txtBookName, txtAuthor, txtPages, txtDescription;
    private Button btnAddToCurrentlyReading, btnAddToWantToRead, btnAddToAlreadyRead, btnAddToFavourite;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        //TODO: Get the data from recycler view
        Book book = new Book(1, "Angels & Demons", "Dan Brown", 616, "https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/DaVinciCode.jpg/220px-DaVinciCode.jpg",
                "Mystery thriller novel", "Angels & Demons is a 2009 American mystery thriller film directed by Ron Howard and written by Akiva Goldsman and David Koepp, based on Dan Brown's 2000 novel of the same title. It is the sequel to the 2006 film The Da Vinci Code, also directed by Howard, and the second installment in the Robert Langdon film series. However, the novel version was published first and acts as a prequel to The Da Vinci Code novel. Filming took place in Rome, Italy, and the Sony Pictures Studios in Culver City, California. Tom Hanks reprises his role as Professor Robert Langdon, while Ayelet Zurer stars as Dr. Vittoria Vetra, a CERN scientist joining Langdon in the quest to recover a missing vial of antimatter from a mysterious Illuminati terrorist. Producer Brian Grazer, composer Hans Zimmer and screenwriter Akiva Goldsman also return, with David Koepp coming on board to help the latter.");

        setData(book);
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