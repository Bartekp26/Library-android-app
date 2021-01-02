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

        // Dan Brown
        allBooks.add(new Book(1, "Angels & Demons", "Dan Brown", 616, "https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/DaVinciCode.jpg/220px-DaVinciCode.jpg",
                "Mystery thriller novel", "Following the murder of a physicist, Father Silvano Bentivoglio, a symbolist, Robert Langdon, and a scientist, Vittoria Vetra, are on an adventure involving a secret brotherhood, the Illuminati. Clues lead them all around the Vatican, including the four altars of science, Earth, Air, Fire and Water."));

        allBooks.add(new Book(2, "The Da Vinci Code", "Dan Brown", 489, "https://www.taniaksiazka.pl/images/popups/D37/9788375088489.jpg",
                "Mystery thriller novel", "The Da Vinci Code follows symbologist Robert Langdon and cryptologist Sophie Neveu after a murder in the Louvre Museum in Paris causes them to become involved in a battle between the Priory of Sion and Opus Dei over the possibility of Jesus Christ and Mary Magdalene having had a child together."));

        allBooks.add(new Book(3, "The Lost Symbol", "Dan Brown", 671, "https://upload.wikimedia.org/wikipedia/en/0/07/LostSymbol.jpg",
                "Mystery thriller novel", "The Lost Symbol is a 2009 novel written by American writer Dan Brown. It is a thriller set in Washington, D.C., after the events of The Da Vinci Code, and relies on Freemasonry for both its recurring theme and its major characters."));

        allBooks.add(new Book(4, "Inferno", "Dan Brown", 609, "https://upload.wikimedia.org/wikipedia/en/thumb/b/bb/Inferno-cover.jpg/200px-Inferno-cover.jpg",
                "Mystery thriller novel", "In the novel Inferno by Dan Brown, Harvard professor Robert Langdon is recruited by the World Health Organization (WHO) to help locate a deadly pathogen. The virus is believed to have been created by Bertrand Zobrist, a Transhumanist who thought that the world was in danger of collapse because of overpopulation."));

        allBooks.add(new Book(5, "Origin", "Dan Brown", 456, "https://upload.wikimedia.org/wikipedia/en/thumb/6/67/Origin_%28Dan_Brown_novel_cover%29.jpg/220px-Origin_%28Dan_Brown_novel_cover%29.jpg",
                "Mystery thriller novel", "Origin is a 2017 mystery thriller novel by American author Dan Brown and the fifth installment in his Robert Langdon series, following Inferno. The book was released on October 3, 2017 by Doubleday. The book is predominantly set in Spain and features minor sections in Sharjah and Budapest."));

        // J.K. Rowling
        allBooks.add(new Book(6, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", 223, "https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Harry_Potter_and_the_Philosopher%27s_Stone_Book_Cover.jpg/220px-Harry_Potter_and_the_Philosopher%27s_Stone_Book_Cover.jpg",
                "Fantasy novel", "Featuring vivid descriptions and an imaginative story line, it followed the adventures of the unlikely hero Harry Potter, a lonely orphan who discovers that he is actually a wizard and enrolls in the Hogwarts School of Witchcraft and Wizardry. The book received numerous awards, including the British Book Award."));

        allBooks.add(new Book(7, "Harry Potter and the Chamber of Secrets", "J.K. Rowling", 251, "https://upload.wikimedia.org/wikipedia/en/thumb/5/5c/Harry_Potter_and_the_Chamber_of_Secrets.jpg/220px-Harry_Potter_and_the_Chamber_of_Secrets.jpg",
                "Fantasy novel", "Its story follows Harry Potter's second year at Hogwarts School of Witchcraft and Wizardry as the Heir of Salazar Slytherin opens the Chamber of Secrets, unleashing a monster that petrifies the school's denizens."));

        allBooks.add(new Book(8, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 317, "https://upload.wikimedia.org/wikipedia/en/thumb/a/a0/Harry_Potter_and_the_Prisoner_of_Azkaban.jpg/220px-Harry_Potter_and_the_Prisoner_of_Azkaban.jpg",
                "Fantasy novel", "The book follows Harry Potter, a young wizard, in his third year at Hogwarts School of Witchcraft and Wizardry. Along with friends Ronald Weasley and Hermione Granger, Harry investigates Sirius Black, an escaped prisoner from Azkaban, the wizard prison, believed to be one of Lord Voldemort's old allies."));

        allBooks.add(new Book(9, "Harry Potter and the Goblet of Fire", "J.K. Rowling", 636, "https://upload.wikimedia.org/wikipedia/en/thumb/b/b6/Harry_Potter_and_the_Goblet_of_Fire_cover.png/220px-Harry_Potter_and_the_Goblet_of_Fire_cover.png",
                                  "Fantasy novel", "That same year, Hogwarts is hosting The Triwizard Tournament, a magical tournament between three well-known schools of magic : Hogwarts, Beauxbatons, and Durmstrang. The contestants have to be above the age of seventeen, and are chosen by a magical object called The Goblet of Fire."));

        allBooks.add(new Book(10, "Harry Potter and the Order of the Phoenix", "J.K. Rowling", 766, "https://upload.wikimedia.org/wikipedia/en/thumb/7/70/Harry_Potter_and_the_Order_of_the_Phoenix.jpg/220px-Harry_Potter_and_the_Order_of_the_Phoenix.jpg",
                "Fantasy novel", "Rowling and the fifth novel in the Harry Potter series. It follows Harry Potter's struggles through his fifth year at Hogwarts School of Witchcraft and Wizardry, including the surreptitious return of the antagonist Lord Voldemort, O.W.L. exams, and an obstructive Ministry of Magic."));

        allBooks.add(new Book(11, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", 607, "https://upload.wikimedia.org/wikipedia/en/thumb/b/b5/Harry_Potter_and_the_Half-Blood_Prince_cover.png/220px-Harry_Potter_and_the_Half-Blood_Prince_cover.png",
                "Fantasy novel", "In Harry Potter's (Daniel Radcliffe's) sixth year at Hogwarts School of Witchcraft, he finds a book marked mysteriously, This book is the property of the Half Blood Prince, which helps him excel at Potions class and teaches him a few dark and dangerous ones along the way."));

        allBooks.add(new Book(12, "Harry Potter and the Deathly Hallows", "J.K. Rowling", 607, "https://upload.wikimedia.org/wikipedia/en/a/a9/Harry_Potter_and_the_Deathly_Hallows.jpg",
                "Fantasy novel", "The novel chronicles the events directly following Harry Potter and the Half-Blood Prince (2005) and the final confrontation between the wizards Harry Potter and Lord Voldemort. Deathly Hallows shattered sales records upon release, surpassing marks set by previous titles of the Harry Potter series."));
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

    public Book getBookById(int id){
        for(Book b: allBooks){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }
}
