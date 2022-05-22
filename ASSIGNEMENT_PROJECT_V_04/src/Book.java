import jdk.jfr.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;

public class Book  extends Shelf { /*Actually, BOOKs inherites Some features from the Shelf like the Category of Book,
                       the number where it can  be found  , SO WE EXTEND THE CLASS SHELF INTO BOOKS */


    private String BookName;
    private String Book_edition ;
    private String Author ;
    private String Category;
    static int count;

    public Book(String[] categoryName, int shelfNumber, int count, String bookName, String book_edition, String author, String category) {
        super(categoryName, shelfNumber, count);
        BookName = bookName;
        Book_edition = book_edition;
        Author = author;
        Category = category;
    }

    /*PLAN

--FIRST WE CREATE BOOKS
--GIVE THEM AUTHORSNAMES  AND EDITION
--SECOND STORE THEM ACCORDING TO THEY CATEOGRY
--GET THE NUMBER OF EACH BOOKS

 */

// LET BUILD THE SETTERS AND GETTERS


    public String getBookName() {
        return BookName;
    }
    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBook_edition() {
        return Book_edition;
    }
    public void setBook_edition(String book_edition) {
        Book_edition = book_edition;
    }

    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }

    public String getCategory() {return Category;}
    public void setCategory(String category) {Category = category;}

//###########################################
    //# LET BUILD THE CONSTRUCTOR
    //###########################################


    public Book(String[] categoryName, int shelfNumber, int count, String bookName, String book_edition, String author) {
        super(categoryName, shelfNumber, count);
        BookName = bookName;
        Book_edition = book_edition;
        Author = author;
        Category = Category;
    }




    public void createBook(){//THIS METHOD IS ET ONLY FOR THE LIBRARIAN




        try{

            //Let import the count of the array and they array itslef from the Shelf class
            new Shelf(getCategoryName(), 0, 0);
            System.out.println("\n\n\n");

            try {
                System.out.println("What is the Category in WHich the Book should be set in ? ____ _____ ____ ");
                System.out.println("We got Love   *HISTORY*  *SELF-HELP* *SCIENCE*  *FICTION*");


                Scanner scanShelf = new Scanner(System.in);
                Category = scanShelf.next().toLowerCase();

                switch (Category){

                    case "history" -> System.out.println(" HISTORY, Enter the number of books ");
                    case "self-help" -> System.out.println("SELF-HELP , Enter the number of books ");
                    case "science" -> System.out.println("SCIENCE , Enter the number of books ");
                    case "fiction" -> System.out.println("FICTION , Enter the number of books ");

                }
                Scanner  LibrarianInput = new Scanner(System.in);//LIBRARIAN INPUT ON THE NUMBER OF BOOKS

                count = LibrarianInput.nextInt();//THE COUNT IS SET TO THE NUMBER OF BOOKS ENTERED ABOVE &&
                                                // LIBRARIAN INPUT ON THE NUMBER OF BOOKS

                System.out.println("You have selected "+Category+" enter the Book(s) name(s)");
            }
            catch (Exception e){
                System.out.println("SORRY THE CATEGORY DOESN'T EXIST");
            }
        }

        catch (Exception e){
            System.out.println("Something Went wrong try again!");
        }


    }

}










class  test2 {
    public static void main(String[] args) {

        Book ImportBook = new Book(args,0,0,"","","","");





        ImportBook.createBook();


    }
}
