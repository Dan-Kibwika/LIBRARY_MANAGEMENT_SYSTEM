import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;
public class InsertBook extends  Book {


    public InsertBook(String[] categoryName, int shelfNumber, int count, String bookName, String book_edition, String author, String category) {
        super(categoryName, shelfNumber, count, bookName, book_edition, author, category);
    }

    public void insertBooks() throws IOException {


        Scanner insertBookName = new Scanner(System.in);

        try {

            for (int i = 0; i < count; i++) {


                System.out.println("Enter the name of the book number " + i++);
                setBookName(insertBookName.next());

                File myFirstFile = new File(getBookName());


                if (myFirstFile.createNewFile()) {

                    System.out.println(myFirstFile.getName() + " has been created ");


//WRITE IN THE FILE

                    for (int e = 1; e < count; e++) {

                        System.out.println("Enter the name of the Author : ");
                        Scanner userInput = new Scanner(System.in);


                        String author = userInput.next();
                        setAuthor(author);


                        System.out.println("Enter the edition : ");
                        String edition = userInput.next();
                        setBook_edition(edition);




                        System.out.println("Enter the Content of the Book" + i);

                        Scanner contentScan = new Scanner(System.in);

                        FileWriter inputText = new FileWriter(getBookName());
                        inputText.write(contentScan.nextLine());
                        inputText.close();


                        //DISPLAY CONTENTS OF THE BOOKS

                        System.out.println("Contents of the BOOK ");

                    }


                } else {
                    System.out.println("File already exit ");
                }


                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY_MANAGEMENT_SYSTEM_V5", "root", "dankibwika18072001");

//INSERT INTO book( category,number,content) VALUES ( 'history', 1, ' content ')


                String insertSql = "INSERT INTO book (book_edition,author,category ,number,bookName )VALUES (" +
                        "'"+getBook_edition() +"','" + getAuthor() +"','" + getCategory() +"','" + getCount() + "','" + getBookName() +"')";

                PreparedStatement prepStat = conn.prepareStatement(insertSql);

                int updateRowCount = prepStat.executeUpdate();


                if (updateRowCount > 0) {

                    System.out.println("=================================");
                    System.out.println("BOOK DETAILS  \n: " +
                            "Book Name  :" + getBookName()+ "\n" +
                            "number: " +getCount()+ "\n" +
                            "Author: " +getAuthor() +"\n" +
                            "Category: "+getCategory() +"\n" +
                            "Edition : "+getBook_edition() );
                    System.out.println("=================================");


                } else {
                    System.out.println("================================================");
                    System.out.println("Recorder but  and couldn't be   Inserted");
                    System.out.println("================================================");

                }

            }
        }
                catch (Exception e) {
                System.out.println("\n==================================================");
                System.out.println("OOPS, WE COULDN'T LOAD THE BOOK'S DETAILS  , TRY AGAIN ");
                System.out.println("\n==================================================\n");
            }


        //-------------------------------------------------------------------------------------------------------


        try {
//DISPLAY BOOK CONTENT



             File InClassFile = new File(getBookName());

                Scanner IndexScanner = new Scanner(InClassFile);
                  while (IndexScanner.hasNextLine()){

                     System.out.println(IndexScanner.nextLine());

            }


//        } catch (Exception e) {
//            System.out.println("File  doesn't exist");
        }

        catch (Exception e){
            System.out.println("File not found, try again");

        }
    }
}









