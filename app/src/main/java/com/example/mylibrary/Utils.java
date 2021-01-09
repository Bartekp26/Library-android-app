package com.example.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static final String ALL_BOOKS_KEY = "all_books";
    private static final String CURRENTLY_READING_BOOKS_KEY = "currently_reading_books";
    private static final String ALREADY_READ_BOOKS_KEY = "already_read_books";
    private static final String WANT_TO_READ_BOOKS_KEY = "want_to_read_books";
    private static final String FAVOURITE_BOOKS_KEY = "favourite_books";

    private static Utils instance;
    private SharedPreferences sharedPreferences;

    private Utils(Context context) {

        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        if(null == getAllBooks()){
            initData();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if(null == getCurrentlyReadingBooks()){
            editor.putString(CURRENTLY_READING_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

        if(null == getAlreadyReadBooks()){
            editor.putString(ALREADY_READ_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

        if(null == getWantToReadBooks()){
            editor.putString(WANT_TO_READ_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

        if(null == getFavouriteBooks()){
            editor.putString(FAVOURITE_BOOKS_KEY, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }

    private void initData() {

        ArrayList<Book> books = new ArrayList<>();

        // Dan Brown
        books.add(new Book(1, "Angels & Demons", "Dan Brown", 616, "https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/DaVinciCode.jpg/220px-DaVinciCode.jpg",
                "Mystery thriller novel", "Following the murder of a physicist, Father Silvano Bentivoglio, a symbolist, Robert Langdon, and a scientist, Vittoria Vetra, are on an adventure involving a secret brotherhood, the Illuminati. Clues lead them all around the Vatican, including the four altars of science, Earth, Air, Fire and Water."));

        books.add(new Book(2, "The Da Vinci Code", "Dan Brown", 489, "https://www.taniaksiazka.pl/images/popups/D37/9788375088489.jpg",
                "Mystery thriller novel", "The Da Vinci Code follows symbologist Robert Langdon and cryptologist Sophie Neveu after a murder in the Louvre Museum in Paris causes them to become involved in a battle between the Priory of Sion and Opus Dei over the possibility of Jesus Christ and Mary Magdalene having had a child together."));

        books.add(new Book(3, "The Lost Symbol", "Dan Brown", 671, "https://upload.wikimedia.org/wikipedia/en/0/07/LostSymbol.jpg",
                "Mystery thriller novel", "The Lost Symbol is a 2009 novel written by American writer Dan Brown. It is a thriller set in Washington, D.C., after the events of The Da Vinci Code, and relies on Freemasonry for both its recurring theme and its major characters."));

        books.add(new Book(4, "Inferno", "Dan Brown", 609, "https://upload.wikimedia.org/wikipedia/en/thumb/b/bb/Inferno-cover.jpg/200px-Inferno-cover.jpg",
                "Mystery thriller novel", "In the novel Inferno by Dan Brown, Harvard professor Robert Langdon is recruited by the World Health Organization (WHO) to help locate a deadly pathogen. The virus is believed to have been created by Bertrand Zobrist, a Transhumanist who thought that the world was in danger of collapse because of overpopulation."));

        books.add(new Book(5, "Origin", "Dan Brown", 456, "https://upload.wikimedia.org/wikipedia/en/thumb/6/67/Origin_%28Dan_Brown_novel_cover%29.jpg/220px-Origin_%28Dan_Brown_novel_cover%29.jpg",
                "Mystery thriller novel", "Origin is a 2017 mystery thriller novel by American author Dan Brown and the fifth installment in his Robert Langdon series, following Inferno. The book was released on October 3, 2017 by Doubleday. The book is predominantly set in Spain and features minor sections in Sharjah and Budapest."));

        // J.K. Rowling
        books.add(new Book(6, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", 223, "https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Harry_Potter_and_the_Philosopher%27s_Stone_Book_Cover.jpg/220px-Harry_Potter_and_the_Philosopher%27s_Stone_Book_Cover.jpg",
                "Fantasy novel", "Featuring vivid descriptions and an imaginative story line, it followed the adventures of the unlikely hero Harry Potter, a lonely orphan who discovers that he is actually a wizard and enrolls in the Hogwarts School of Witchcraft and Wizardry. The book received numerous awards, including the British Book Award."));

        books.add(new Book(7, "Harry Potter and the Chamber of Secrets", "J.K. Rowling", 251, "https://upload.wikimedia.org/wikipedia/en/thumb/5/5c/Harry_Potter_and_the_Chamber_of_Secrets.jpg/220px-Harry_Potter_and_the_Chamber_of_Secrets.jpg",
                "Fantasy novel", "Its story follows Harry Potter's second year at Hogwarts School of Witchcraft and Wizardry as the Heir of Salazar Slytherin opens the Chamber of Secrets, unleashing a monster that petrifies the school's denizens."));

        books.add(new Book(8, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 317, "https://upload.wikimedia.org/wikipedia/en/thumb/a/a0/Harry_Potter_and_the_Prisoner_of_Azkaban.jpg/220px-Harry_Potter_and_the_Prisoner_of_Azkaban.jpg",
                "Fantasy novel", "The book follows Harry Potter, a young wizard, in his third year at Hogwarts School of Witchcraft and Wizardry. Along with friends Ronald Weasley and Hermione Granger, Harry investigates Sirius Black, an escaped prisoner from Azkaban, the wizard prison, believed to be one of Lord Voldemort's old allies."));

        books.add(new Book(9, "Harry Potter and the Goblet of Fire", "J.K. Rowling", 636, "https://upload.wikimedia.org/wikipedia/en/thumb/b/b6/Harry_Potter_and_the_Goblet_of_Fire_cover.png/220px-Harry_Potter_and_the_Goblet_of_Fire_cover.png",
                                  "Fantasy novel", "That same year, Hogwarts is hosting The Triwizard Tournament, a magical tournament between three well-known schools of magic : Hogwarts, Beauxbatons, and Durmstrang. The contestants have to be above the age of seventeen, and are chosen by a magical object called The Goblet of Fire."));

        books.add(new Book(10, "Harry Potter and the Order of the Phoenix", "J.K. Rowling", 766, "https://upload.wikimedia.org/wikipedia/en/thumb/7/70/Harry_Potter_and_the_Order_of_the_Phoenix.jpg/220px-Harry_Potter_and_the_Order_of_the_Phoenix.jpg",
                "Fantasy novel", "Rowling and the fifth novel in the Harry Potter series. It follows Harry Potter's struggles through his fifth year at Hogwarts School of Witchcraft and Wizardry, including the surreptitious return of the antagonist Lord Voldemort, O.W.L. exams, and an obstructive Ministry of Magic."));

        books.add(new Book(11, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", 607, "https://upload.wikimedia.org/wikipedia/en/thumb/b/b5/Harry_Potter_and_the_Half-Blood_Prince_cover.png/220px-Harry_Potter_and_the_Half-Blood_Prince_cover.png",
                "Fantasy novel", "In Harry Potter's (Daniel Radcliffe's) sixth year at Hogwarts School of Witchcraft, he finds a book marked mysteriously, This book is the property of the Half Blood Prince, which helps him excel at Potions class and teaches him a few dark and dangerous ones along the way."));

        books.add(new Book(12, "Harry Potter and the Deathly Hallows", "J.K. Rowling", 607, "https://upload.wikimedia.org/wikipedia/en/a/a9/Harry_Potter_and_the_Deathly_Hallows.jpg",
                "Fantasy novel", "The novel chronicles the events directly following Harry Potter and the Half-Blood Prince (2005) and the final confrontation between the wizards Harry Potter and Lord Voldemort. Deathly Hallows shattered sales records upon release, surpassing marks set by previous titles of the Harry Potter series."));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
        editor.commit();
    }

    public static Utils getInstance(Context context) {
        if (null != instance){
            return instance;
        } else {
            instance = new Utils(context);
            return instance;
        }
    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getCurrentlyReadingBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getWantToReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getFavouriteBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVOURITE_BOOKS_KEY, null), type);
        return books;
    }

    public Book getBookById(int id){
        ArrayList<Book> books = getAllBooks();
        if(null != books){
            for(Book b: books){
                if(b.getId() == id){
                    return b;
                }
            }
        }

        return null;
    }

    public boolean addToCurrentlyReading(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS_KEY);
                editor.putString(CURRENTLY_READING_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToAlreadyRead(Book book){
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS_KEY);
                editor.putString(ALREADY_READ_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToWantToRead(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS_KEY);
                editor.putString(WANT_TO_READ_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToFavourite(Book book){
        ArrayList<Book> books = getFavouriteBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVOURITE_BOOKS_KEY);
                editor.putString(FAVOURITE_BOOKS_KEY, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }


    public boolean removeFromCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if (null != books){
            for (Book b: books) {
                if(b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS_KEY);
                        editor.putString(CURRENTLY_READING_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if (null != books){
            for (Book b: books) {
                if(b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS_KEY);
                        editor.putString(ALREADY_READ_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromWantToRead(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if (null != books){
            for (Book b: books) {
                if(b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS_KEY);
                        editor.putString(WANT_TO_READ_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromFavourite(Book book){
        ArrayList<Book> books = getFavouriteBooks();
        if (null != books){
            for (Book b: books) {
                if(b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVOURITE_BOOKS_KEY);
                        editor.putString(FAVOURITE_BOOKS_KEY, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
