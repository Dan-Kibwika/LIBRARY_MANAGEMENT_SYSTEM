import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBook {

    public void deleteBook () throws SQLException {


        try {


            System.out.println("Enter the name of the file ");
             Scanner userinput = new Scanner(System.in);
                 String fileName = userinput.next().toLowerCase();


                 System.out.println("Are you sure you want to delete " + fileName + ".txt ?");
                      String answer = userinput.next().toLowerCase();

                           if (answer.equals("yes") || answer.equals("y") || answer.equals("1")) {

                               File deleteFile = new File("C:\\Users\\dan\\OneDrive\\Desktop\\dan doss\\Science courses\\NUST\\3 TH SEMESTER\\PRG611S\\ASSIGNMENT\\ASSIGNEMENT_PROJECT_V_04\\" + fileName+".txt");


                if (deleteFile.delete()) {

                    System.out.println(fileName + ".txt was deleted !!!");


                    //SQL STATEMENT FOR REMOVING BOOK IN THE DATABASE
                    //==================================================================================


                    //DELETE  FROM book  WHERE  bookId = 1;
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY_MANAGEMENT_SYSTEM_V5", "root", "dankibwika18072001");


                    String deletetSql = "DELETE  FROM book  WHERE  bookName = "+fileName +" ";
                    PreparedStatement prepStat = conn.prepareStatement(deletetSql);


                    int updateRowCount = prepStat.executeUpdate();


                    if (updateRowCount > 0) {

                        System.out.println("=================================");
                        System.out.println("DELETION COMPLETED ");
                        System.out.println("=================================");


                    } else {
                        System.out.println("================================================");
                        System.out.println("Couldn't delete the "+fileName +" " );
                        System.out.println("================================================");

                    }

                }


                else {
                    System.out.println(fileName + ".txt was not deleted !!!");

                }

            }


        } catch (Exception e) {

            System.out.println("Error couldn't connect to the Database " + e);


        }






        }












    public void updateBook(){

        // UPDATE book
//  SET
//    book_edition = '2009', author= 'Alain', category ='Fiction', number = '20', bookName  ='Arthur'
//   WHERE bookId ='3'


    }

}

class try1{

    public static void main(String[]args) throws SQLException {


        DeleteBook deleteBook = new DeleteBook();
        deleteBook.deleteBook();


    }



}
