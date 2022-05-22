import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Librarian extends Book {
    public Librarian(String[] categoryName, int shelfNumber, int count, String bookName, String book_edition, String author) {
        super(categoryName, shelfNumber, count, bookName, book_edition, author);
    }

//    public void manageBook() throws IOException {
//
//        Librarian librarianIn = new Librarian(new String[]{""}, 0, 0, "", "", "");
//
//        Book ImportBook = new Book(getCategoryName(), 0, 0, "", "", "");
//        InsertBook insertion = new InsertBook(getCategoryName(), 0, 0, "", "", "");
//        ImportBook.createBook();
//        insertion.insertBooks();


        //class test8{


        public void ManageLibraryResources() throws IOException, SQLException {

            Scanner librarianInout = new Scanner(System.in);
            Librarian librarianIn = new Librarian(new String[]{""}, 0, 0, "", "", "");

            Book ImportBook = new Book(getCategoryName(), 0, 0, "", "", "");
            InsertBook insertion = new InsertBook(getCategoryName(), 0, 0, "", "", "","");
//            ImportBook.createBook();
//            insertion.insertBooks();






            System.out.println("WOULD YOU LIKE TO ADD BOOKS ? Y/N \n");

            String response = librarianInout.next().toLowerCase();

            if (response.equals("yes") || response.equals("y")) {

                ImportBook.createBook();
                insertion.insertBooks();


            }
              else {


                System.out.println(" WOULD YOU LIKE TO DELETE A BOOK ? CLICK [1] DELETE BOOK  and [2] VIEW THE BOOKS IN THE SHELVES ");

                String response1 = librarianInout.next();


                if (response1.equals("1")) {
                    //DELETE BOOK

                    DeleteBook deleteBookIn = new DeleteBook();
                    deleteBookIn.deleteBook();





                } else {
                    System.out.println("\n======================================================================");
                    System.out.println("LIBRARY MANAGEMENT SYSTEM");
                    System.out.println("========================================================================\n");


                    //THIS LINE BELLOW DISPLAYS THE REPOSITORY WHERE THE BOOK ARE STORED

                    String pathName = "C:\\Users\\dan\\OneDrive\\Desktop\\dan doss\\Science courses\\NUST\\3 TH SEMESTER\\PRG611S\\ASSIGNMENT\\ASSIGNEMENT_PROJECT_V_04";

                    //create  a File object
                    File path = new File(pathName);

                    //Print out the name
                    System.out.println("\n==========================================================================================================================");
                    System.out.println(" the path is " + path.getAbsolutePath());
                    System.out.println("===========================================================================================================================\n");


                    //list all the files and directory


                    String[] list = path.list();
                    System.out.println("\n==================================================");
                    System.out.println("LIST OF BOOKS ");
                    System.out.println("==================================================\n");

                    //traverse array and print list

                    for (int i = 0; i < list.length; i++) {

                        System.out.println("\n==================================================");
                        System.out.println(list[i]);
                        System.out.println("==================================================\n");
                    }


                }

            }// if


        }
        //INSERT INTO book( category,number,content) VALUES ( 'history', 1, ' content ')
    }


