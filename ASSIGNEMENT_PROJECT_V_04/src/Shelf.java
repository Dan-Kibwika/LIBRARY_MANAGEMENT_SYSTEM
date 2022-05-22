import java.util.Arrays;
import java.util.Scanner;

public class Shelf {

    protected Scanner scanneShelf;
    private String[] CategoryName ; //Stock Books according to their Categories
    private  int ShelfNumber;     // each Category has a number by which is called
    private  int count ;           //count is set to increase or decrease the Number of Shelves




    //#######################################################
    //###SO LET GO INTO CODING NOW , FIRST BUILD  A CONSTRUCTOR --->
    //#######################################################

    public Shelf(String[] categoryName, int shelfNumber, int count) {
        setCategoryName(categoryName);
        ShelfNumber = shelfNumber;
        this.count = count;
    }


    //######################################################
    //###SECOND GENERATE GETTERS AND SETTERS FOR VALUES    #
    //#######################################################


    public String[] getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String[] categoryName) {
        CategoryName = categoryName;
    }

    public int getShelfNumber() {
        return ShelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        ShelfNumber = shelfNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //#######################################################
//THIRD  LET AKS THE USER WHO IN THIS CASE IS THE LIBRARIAN HOW MANY SHELF DOES IT WANT TO HAVE (ARRAYLIST)
//AND SET THEM WITH THEIR CATEGORIES
//#######################################################



    public void buildShelf(){  //**** NUMBER OF SHELF  FIRST METHOD****


        try {

            System.out.println("How many Shelf do you need ?");     //ask the Librarian about the Nmb of Shelf
            Scanner LibrarianInput = new Scanner(System.in);       //Scan only Librarian
            int numberOfShelf = LibrarianInput.nextInt();        //Numb of shelf
            setCount(numberOfShelf);




        }

        catch (Exception e){

            System.out.println("OOPS , Something went Wrong, try again ");
        }


        //We've got the number , let now get the Category




    }



    public void ShelfCategory(){ //*** SHELF CATEGORY Second Method


        try {
            Shelf importTheCount = new Shelf(getCategoryName(), 0, getCount());

            System.out.println("Enter the Category ");



            int i;


            for ( i = 0; i < importTheCount.getCount(); i++) {

                System.out.println(" Category " + i);
                Scanner LibrarianInput = new Scanner(System.in);

                setCategoryName(new String[getCount()]); //shelf array storing the Category of Shelf

                getCategoryName()[i] = LibrarianInput.next().toLowerCase();
                System.out.println(getCategoryName()[i]+"\n");

            }



        }


        catch (Exception e) {

            System.out.println("OOPS , Something went Wrong ");

        }
        finally {
            Shelf importTheCount = new Shelf(getCategoryName(), 0, getCount());



            System.out.println("Thank you , You're all set " +
                    "********************************************\n" +
                    " YOU HAVE "+getCount()+" SHELVES \n"+ Arrays.toString(importTheCount.getCategoryName())+
                    "******************************************");
        }

    }


//#############################################################################################
    //NOW THAT WE'RE DONE WITH THE SHELF LET GO TO THE BOOKS
    //########################################################################################






}








class  test {
    public static void main ( String[]args){

        Shelf importTheCount = new Shelf(args, 0, 0);
        importTheCount.buildShelf();
        importTheCount.ShelfCategory();


    }

}















//############################################################################################################################
/* PLAN

  The plan is to build a shelves which keeps Books.                                                                         #
   The Category of the Shelves are entered by the Librarian , So ...                                                        #

   -First we got the Shelves
   -Second we  Put Books inside
    -Third we set a Librarian who will be updating and Deleting Books , checking for who borrow and returne the Book
     -Kind of management

     AND FINALLY ADD CONSUMERS OR USER

     FIRST SHELF


 */