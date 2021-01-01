package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favouriteBooks;

    private Utils() {
        if(null == allBooks){
            allBooks = new ArrayList<>();
            initData();
        }

        if(null == alreadyReadBooks){
            alreadyReadBooks = new ArrayList<>();
        }

        if(null == wantToReadBooks){
            wantToReadBooks = new ArrayList<>();
        }

        if(null == currentlyReadingBooks){
            currentlyReadingBooks = new ArrayList<>();
        }

        if(null == favouriteBooks){
            favouriteBooks = new ArrayList<>();
        }
    }

    private void initData() {

        allBooks.add(new Book(1, "Angels & Demons", "Dan Brown", 616, "https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/DaVinciCode.jpg/220px-DaVinciCode.jpg",
                "Mystery thriller novel", "Long description"));

        allBooks.add(new Book(2, "The Da Vinci Code", "Dan Brown", 489, "https://www.taniaksiazka.pl/images/popups/D37/9788375088489.jpg",
                "Mystery thriller novel", "Long description"));
    }

    public static Utils getInstance() {
        if (null != instance){
            return instance;
        } else {
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavouriteBooks() {
        return favouriteBooks;
    }
}
