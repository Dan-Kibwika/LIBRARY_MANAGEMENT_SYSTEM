import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Lecturer  extends  Shelf {//Student class starts

    private String studentNumber, studentFaculty;

    public Lecturer(String[] categoryName, int shelfNumber, int count, String studentNumber, String studentFaculty) {
        super(categoryName, shelfNumber, count);
        this.studentNumber = studentNumber;
        this.studentFaculty = studentFaculty;
    }
//getters and setters 
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentFaculty() {
        return studentFaculty;
    }

    public void setStudentFaculty(String studentFaculty) {
        this.studentFaculty = studentFaculty;
    }


    public void enterStudentDetails() throws FileNotFoundException {

        InsertBook importBook = new InsertBook(getCategoryName(), 0, 0, "", "", "","");
        Scanner studentInput = new Scanner(System.in);

        System.out.println("\n==================================================");
        System.out.println("Enter your Department name ");
        System.out.println("==================================================\n");
        studentFaculty = studentInput.next();


        System.out.println("\n==================================================");
        System.out.println("Well done you're all set , What's your next step ? ");
        System.out.println("*  ENTER [1] FOR BORROW A BOOK* \n" +
                "ENTER [2] FOR RETURNING A BOOK\n" +
                "ENTER [3] FOR ASSISTANCE \n" +
                "ENTER [4] TO EXIT");
        System.out.println("\n==================================================\n");




        int response = studentInput.nextInt();

        //IF THE STUDENT ENTERS 1 BORROW BOOK ------->>>>>>>>
        if(response==1) {//IF 1 STARTS BORROW BOOK

            System.out.println("\n==================================================");
            System.out.println("Enter the name of the BOOK ");

            String bookNameIn = studentInput.next();
            System.out.println("==================================================\n");

            importBook.setBookName(bookNameIn);

            System.out.println("\n==================================================");
            System.out.println("WOULD YOU LIKE TO READ THE BOOK? Y/N");
            System.out.println("==================================================\n");

            String responseBook = studentInput.next().toLowerCase();

            if (responseBook.equals("y")||responseBook.equals("yes")) {//IF 2 STARTS
                System.out.println("\n==================================================");
                System.out.println("Contents of the BOOK ");
                System.out.println("==================================================\n");


                try { //try  to read the file
                    //DISPLAY BOOK CONTENT

                    File InClassFile = new File(importBook.getBookName());
                    Scanner IndexScanner = new Scanner(InClassFile);
                    while (IndexScanner.hasNextLine()) {  System.out.println(IndexScanner.nextLine()); }
                }
                catch (Exception e) {
                    System.out.println("\n==================================================");
                    System.out.println("Book doesn't exist ");
                    System.out.println("==================================================\n");
                }//catch error if the file doesn't exist



            }//end if2
            else{
                System.out.println("\n============================================================================================");
                System.out.println("YOU HAVE BORROWED THE "+importBook.getBookName()+" You have 7 days to return the Book ");
                System.out.println("==============================================================================================\n");
            }//end else2

        } //endif1


        //IF 2 THE STUDENT ENTERS [2] FOR RETURNING A BOOK-------------->>>>>>>>

        else if (response==2){//else if 2
            System.out.println("\n==================================================");
            System.out.println("Enter the name of the BOOK ");
            System.out.println("==================================================\n");

            String bookNameIn = studentInput.next();
            importBook.setBookName(bookNameIn);

            File bookExist = new File(bookNameIn);
            if(bookExist.exists()){//

                System.out.println("\n=====================================================================");
                System.out.println("COMPLETED SUCCESSFULY BOOK "+bookNameIn+" HAS BEEN RETURNED ");
                System.out.println("=======================================================================");
            }
            else {
                System.out.println("\n===============================================================================================");
                System.out.println("ERROR: YOU DIDN'T BORROW "+bookNameIn+" \n THE BOOKS DOESN'T APPEAR IN YOUR CURRENT ACCOUNT");
                System.out.println("=================================================================================================");
            }

        }//close else if 2


        else if(response==3){//else if 3 IS STUDENT ENTER [3] FOR  ASSISTANCE DISPLAY ALL THE BOOKS AVAILABLE

            System.out.println("\n======================================================================");
            System.out.println("HI THERE WE CURRENTLY HAVE SOME COOL BOOKS IN STOCK FOR YOU ");
            System.out.println("========================================================================\n");


//THIS LINE BELLOW DISPLAYS THE REPOSITORY WHERE THE BOOK ARE STORED

            String pathName = "C:\\Users\\dan\\OneDrive\\Desktop\\dan doss\\Science courses\\NUST\\3 TH SEMESTER\\PRG611S\\ASSIGNMENT\\ASSIGNEMENT_PROJECT_V_04";

            //create  a File object
            File path = new File(pathName);

            //Print out the name
            System.out.println("\n==========================================================================================================================");
            System.out.println(" the path is "+path.getAbsolutePath());
            System.out.println("===========================================================================================================================\n");


            //list all the files and directory


            String[]list = path.list();
            System.out.println("\n==================================================");
            System.out.println("LIST OF BOOKS YOU CAN READ");
            System.out.println("==================================================\n");

            //traverse array and print list

            for( int i= 0; i< list.length; i++){

                System.out.println("\n==================================================");
                System.out.println(list[i]);
                System.out.println("==================================================\n");
            }



        }//End else if 3


        else{
            for(int i = 0; i<1;i++){
                System.out.println("\n==================================================");
                System.out.println("Exit");
                System.out.println("==================================================");
                break;
            }

        }



    }//Student class ends









    static class test7 {
        public static void main(String[] args) throws FileNotFoundException {
            Lecturer LctIn = new Lecturer(args, 0, 0, "", "");
            LctIn.enterStudentDetails();
        }
    }
}
