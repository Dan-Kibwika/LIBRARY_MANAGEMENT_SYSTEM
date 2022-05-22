import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class User extends  PersonDetailIn {


    public User(String lastName, String surname, String nationalID, String gender, String dateOfBith) throws SQLException {
        super(lastName, surname, nationalID, gender, dateOfBith);
    }




public static void key_identifier(){



}
    public static void generatKey() throws SQLException {


        /*IN THIS CLASS WE GENEARATE A USER KEY NUMBER FOR THEM TO USE
         * the key is generated using the  2 first char of the id number( YY) , concatenate with the  two char of the date of birth
         * (DD) and finally we add a count for each particular user, YYDDXXXX
         *
         * STUDENT 1000
         * LECTURER 2000
         * NORMAL USER 3000
         * LIBRARIAN 4000
         * which increment according to the number of user registering */


//PLAN GET THE PERSON DETAILS AND MAKE THEM LIBRARIAN USERS


        /*OBJECT TO CALL ALL THE VARIABLE FROM THE PERSON CLASS
         *   ---> Person personIn = new Person ( ""); <---- */


        User userIn = new User("", "", "", "", "");
        PersonDetailIn personIn = new PersonDetailIn("", "", "", "", "");

        personIn.getPersonDetail();


        System.out.println("Your id is " + personIn.getNationalID());


        Scanner UserInput = new Scanner(System.in); //SCANER FOR USER PURPOSES

        //ASK THE USER TO IDENTIFY
        System.out.println("\n==================================================\n");
        System.out.println("Are you a   *LIBRARIAN*   *STUDENT*   *LECTURER*   *NONE* ");
        System.out.println("\n==================================================\n");


        String identifier = UserInput.next().toLowerCase();


        try {
            switch (identifier) {

                case "student" -> {

                    try {

                    int studentCount = 1000;
                    studentCount++;
                    String keyNumber = studentCount + "" + personIn.getNationalID().substring(0, 2) + personIn.getDateOfBirth().substring(0, 2);

                    System.out.println(personIn.getLastName().toUpperCase() + " " + personIn.getSurname().toUpperCase() + "\n");

                    System.out.println("\n==================================================");
                    System.out.println("Your User key is " + keyNumber);
                    System.out.println("Don't forget it !!!");
                    System.out.println("==================================================\n");









//INSERT DATA INTO THE DATABASE


                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY_MANAGEMENT_SYSTEM", "root", "");
                    String id = personIn.getNationalID();

                    String insertSql = "INSERT INTO  user  (" +
                            "status , userKey , nationalID ) VALUES ('" + identifier + "','"+ keyNumber +"','"+personIn.getNationalID()+"')";
                               PreparedStatement prepStat = conn.prepareStatement(insertSql);



                        int updateRowCount = prepStat.executeUpdate();


                    if (updateRowCount > 0) {

                        System.out.println( "=================================");
                        System.out.println( "HI YOU'RE ALL SET CHECK FOR THE FOLLOWING : "+
                                "Name :"  +personIn.getLastName().toUpperCase() + " " + personIn.getSurname().toUpperCase() +"\n" +
                                "Key user : "+keyNumber + "\n" +
                                "Status   : " +identifier +"\n" +
                                "ID number: " +personIn.getNationalID() +"\n" +
                                "Gender   : " +personIn.getGender() +"\n" +
                                "Date of birth : "+personIn.getDateOfBirth());


                        System.out.println( "=================================");


                    } else {
                        System.out.println( "================================================");
                        System.out.println( "Recorder but  and couldn't be   Inserted");
                        System.out.println( "================================================");

                    }

                }
        catch (Exception e ){

                    System.out.println("Error couldn't connect to the Database "+ e);


                }




            }

                case "lecturer" -> {



                    try {

                        int studentCount = 2000;
                        studentCount++;
                        String keyNumber = studentCount + "" + personIn.getNationalID().substring(0, 2) + personIn.getDateOfBirth().substring(0, 2);

                        System.out.println(personIn.getLastName().toUpperCase() + " " + personIn.getSurname().toUpperCase() + "\n");

                        System.out.println("\n==================================================");
                        System.out.println("Your User key is " + keyNumber);
                        System.out.println("Don't forget it !!!");
                        System.out.println("==================================================\n");









//INSERT DATA INTO THE DATABASE


                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY_MANAGEMENT_SYSTEM", "root", "");
                        String id = personIn.getNationalID();

                        String insertSql = "INSERT INTO  user  (" +
                                "status , userKey , nationalID ) VALUES ('" + identifier + "','"+ keyNumber +"','"+personIn.getNationalID()+"')";
                        PreparedStatement prepStat = conn.prepareStatement(insertSql);



                        int updateRowCount = prepStat.executeUpdate();


                        if (updateRowCount > 0) {

                            System.out.println( "=================================");
                            System.out.println( "HI YOU'RE ALL SET CHECK FOR THE FOLLOWING : "+
                                    "Name :"  +personIn.getLastName().toUpperCase() + " " + personIn.getSurname().toUpperCase() +"\n" +
                                    "Key user : "+keyNumber + "\n" +
                                    "Status   : " +identifier +"\n" +
                                    "ID number: " +personIn.getNationalID() +"\n" +
                                    "Gender   : " +personIn.getGender() +"\n" +
                                    "Date of birth : "+personIn.getDateOfBirth());


                            System.out.println( "=================================");


                        } else {
                            System.out.println( "================================================");
                            System.out.println( "Recorder but  and couldn't be   Inserted");
                            System.out.println( "================================================");

                        }

                    }
                    catch (Exception e ){

                        System.out.println("Error couldn't connect to the Database "+ e);


                    }



                }

                case "none" -> {

                    try {

                        int studentCount = 3000;
                        studentCount++;
                        String keyNumber = studentCount + "" + personIn.getNationalID().substring(0, 2) + personIn.getDateOfBirth().substring(0, 2);

                        System.out.println(personIn.getLastName().toUpperCase() + " " + personIn.getSurname().toUpperCase() + "\n");

                        System.out.println("\n==================================================");
                        System.out.println("Your User key is " + keyNumber);
                        System.out.println("Don't forget it !!!");
                        System.out.println("==================================================\n");









//INSERT DATA INTO THE DATABASE


                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY_MANAGEMENT_SYSTEM", "root", "");
                        String id = personIn.getNationalID();

                        String insertSql = "INSERT INTO  user  (" +
                                "status , userKey , nationalID ) VALUES ('" + identifier + "','"+ keyNumber +"','"+personIn.getNationalID()+"')";
                        PreparedStatement prepStat = conn.prepareStatement(insertSql);



                        int updateRowCount = prepStat.executeUpdate();


                        if (updateRowCount > 0) {

                            System.out.println( "=================================");
                            System.out.println( "HI YOU'RE ALL SET CHECK FOR THE FOLLOWING : "+
                                    "Name :"  +personIn.getLastName().toUpperCase() + " " + personIn.getSurname().toUpperCase() +"\n" +
                                    "Key user : "+keyNumber + "\n" +
                                    "Status   : " +identifier +"\n" +
                                    "ID number: " +personIn.getNationalID() +"\n" +
                                    "Gender   : " +personIn.getGender() +"\n" +
                                    "Date of birth : "+personIn.getDateOfBirth());


                            System.out.println( "=================================");


                        } else {
                            System.out.println( "================================================");
                            System.out.println( "Recorder but  and couldn't be   Inserted");
                            System.out.println( "================================================");

                        }

                    }
                    catch (Exception e ){

                        System.out.println("Error couldn't connect to the Database "+ e);


                    }



                }

                case "librarian" -> {

                    try {

                        int studentCount = 4000;
                        studentCount++;
                        String keyNumber = studentCount + "" + personIn.getNationalID().substring(0, 2) + personIn.getDateOfBirth().substring(0, 2);

                        System.out.println(personIn.getLastName().toUpperCase() + " " + personIn.getSurname().toUpperCase() + "\n");

                        System.out.println("\n==================================================");
                        System.out.println("Your User key is " + keyNumber);
                        System.out.println("Don't forget it !!!");
                        System.out.println("==================================================\n");









//INSERT DATA INTO THE DATABASE


                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY_MANAGEMENT_SYSTEM_V5", "root", "dankibwika18072001");
                        String id = personIn.getNationalID();

                        String insertSql = "INSERT INTO  user  (" +
                                "status , userKey , nationalID ) VALUES ('" + identifier + "','"+ keyNumber +"','"+personIn.getNationalID()+"')";
                        PreparedStatement prepStat = conn.prepareStatement(insertSql);



                        int updateRowCount = prepStat.executeUpdate();


                        if (updateRowCount > 0) {

                            System.out.println( "=================================");
                            System.out.println( "HI YOU'RE ALL SET CHECK FOR THE FOLLOWING : "+
                                    "Name :"  +personIn.getLastName().toUpperCase() + " " + personIn.getSurname().toUpperCase() +"\n" +
                                    "Key user : "+keyNumber + "\n" +
                                    "Status   : " +identifier +"\n" +
                                    "ID number: " +personIn.getNationalID() +"\n" +
                                    "Gender   : " +personIn.getGender() +"\n" +
                                    "Date of birth : "+personIn.getDateOfBirth());


                            System.out.println( "=================================");


                        } else {
                            System.out.println( "================================================");
                            System.out.println( "Recorder but  and couldn't be   Inserted");
                            System.out.println( "================================================");

                        }

                    }
                    catch (Exception e ){

                        System.out.println("Error couldn't connect to the Database "+ e);


                    }

                }
            }


        } catch (Exception e) {
            System.out.println("\n==================================================");
            System.out.println("OOPS, WE COULDN'T LOAD YOUR DETAILS , TRY AGAIN ");
            System.out.println("\n==================================================\n");
        }



        //INSERTION INTO THE DATABASE ------>>>>










}//method generate key word ends


}









    // class user ends


    class test10 {


        public static void main(String[] args) throws SQLException {

            User userIn = new User("", "", "", "", "");
            userIn.generatKey();

        }
    }
