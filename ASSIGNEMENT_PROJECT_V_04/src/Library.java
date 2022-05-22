import javax.swing.plaf.nimbus.State;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Library  extends User{
    public Library(String lastName, String surname, String nationalID, String gender, String dateOfBith) throws SQLException {
        super(lastName, surname, nationalID, gender, dateOfBith);
    }

    public static void main(String[] args) throws IOException, SQLException {


            do {

                for (int i = 0; i < 1; i++) {

                    String response;

                    System.out.println("============================================================================================");
                    System.out.println("""

                                                        ───▄▀▀▀▄▄▄▄▄▄▄▀▀▀▄───
                                                        ───█▒▒░░░░░░░░░▒▒█───
                                                        ────█░░█░░░░░█░░█────
                                                        ─▄▄──█░░░▀█▀░░░█──▄▄─
                                                        █░░█─▀▄░░░░░░░▄▀─█░░█
                                                        █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
                                                        █░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
                                                        █░░║║║╠─║─║─║║║║║╠─░░█
                                                        █░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█

                            """);
                    System.out.println("============================================================================================\n\n");
                    System.out.println("==================================================");
                    System.out.println("[1] SIGN IN or SIGN UP[2] enter [1] or [2]");
                    System.out.println("==================================================\n\n");
                    System.out.println("       Enter    * EXIT *  to exit ");


                    Scanner userInput = new Scanner(System.in);
                    response = userInput.next();
                    System.out.println("\n");


                    switch (response) {
                        case "1" -> {


                            //SQL STRING CONNECTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY_MANAGEMENT_SYSTEM_V5", "root", "dankibwika18072001");
                            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                            User userIn = new User("", "", "", "", "");

                            System.out.println("==================================================");



                            System.out.println("Enter your LIBRARY ID CODE : ");
                            System.out.println("==================================================");


                            String keyId = userInput.next();

                            System.out.println("SIgn in as   a STUDENT , librarian or lecturer  or None ?");
                            String userIdentity = userInput.next();

                            if (userIdentity.equals("student")) { //check if the user exist


                                try {
//SELECT* FROM user WHERE userKey = '10012229'


                                    String slectSql = "SELECT* FROM user WHERE userKey = '" + keyId + "'";
                                    PreparedStatement prepStat = conn.prepareStatement(slectSql);

                                    ResultSet resultSetCount = prepStat.executeQuery();


                                    if (resultSetCount.next()) {

                                        System.out.println("=================================");
                                        Student studentIn = new Student(args, 0, 0, "", "");
                                        studentIn.enterStudentDetails();
                                        System.out.println("=================================");


                                    } else {
                                        System.out.println("================================================");
                                        System.out.println("THE DETAILS ENtered don't correspond to any of the Student registered. pls try again or register".toUpperCase());
                                        System.out.println("================================================");

                                    }


                                } catch (Exception e) {
                                    System.out.println("===================================================================================================");
                                    System.out.println("THERE WAS AN ERROR !!!  ".toUpperCase() + e);
                                    System.out.println("===================================================================================================");
                                }

                            }



                                //LECRURER IN >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


                            else if (userIdentity.equals("lecturer")) {

                                try {
//SELECT* FROM user WHERE userKey = '10012229'





//SQL STATEMENT ------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                                    String slectSql = "SELECT* FROM user WHERE userKey = '"+ keyId +"'";
                                    PreparedStatement prepStat = conn.prepareStatement(slectSql);

                                    ResultSet resultSetCount = prepStat.executeQuery();

///--------------------------------------------------------------------------------------------------------
                                    if (resultSetCount.next()) {

                                        System.out.println( "=================================");
                                        Lecturer lec = new Lecturer(new String[]{""}, 0, 0, "", "");
                                        lec.enterStudentDetails();

                                        System.out.println( "=================================");


                                    } else {
                                        System.out.println( "================================================");
                                        System.out.println("THE DETAILS ENtered don't correspond to any of the LECTURER registered. pls try again or register".toUpperCase());
                                        System.out.println( "================================================");

                                    }




                                }
                                catch (Exception e){
                                    System.out.println( "===================================================================================================");
                                    System.out.println("THERE WAS AN ERROR !!! ".toUpperCase() +e);
                                    System.out.println( "===================================================================================================");
                                }
                            }


                            //LIBRARIAN ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                            else if (userIdentity.equals("librarian")) {

                                   // Student studentIn = new Student(args, 0, 0, "", "");





                                try {
//SELECT* FROM user WHERE userKey = '10012229'



                                    String slectSql = "SELECT* FROM user WHERE userKey = '"+ keyId +"'";
                                    PreparedStatement prepStat = conn.prepareStatement(slectSql);

                                    ResultSet resultSetCount = prepStat.executeQuery();


                                    if (resultSetCount.next()) {

                                        System.out.println( "=================================");
                                        Librarian lib = new Librarian(new String[]{""},0,0,"","","");
                                        lib.ManageLibraryResources();
                                        System.out.println( "=================================");


                                    } else {
                                        System.out.println( "================================================");
                                        System.out.println( "YOU ARE NOT AUTHORIZED TO ACCESS THIS INTERFACE \n ONLY ADMIN CAN ACCESS THIS INTERFACE  !!! ");
                                        System.out.println( "================================================");

                                    }




                                }
                                catch (Exception e){
                                    System.out.println( "===================================================================================================");
                                    System.out.println("THERE WAS AN ERROR  !!! ".toUpperCase() +e);
                                    System.out.println( "===================================================================================================");
                                }

                                }// ends checking for client existence



//NONE ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                           else if (userIdentity.equals("none")) { //check if the user exist


                                try {
//SELECT* FROM user WHERE userKey = '10012229'


                                    String slectSql = "SELECT* FROM user WHERE userKey = '" + keyId + "'";
                                    PreparedStatement prepStat = conn.prepareStatement(slectSql);

                                    ResultSet resultSetCount = prepStat.executeQuery();


                                    if (resultSetCount.next()) {

                                        System.out.println("=================================");
                                        Student studentIn = new Student(args, 0, 0, "", "");
                                        studentIn.enterStudentDetails();
                                        System.out.println("=================================");


                                    } else {
                                        System.out.println("================================================");
                                        System.out.println("THE DETAILS ENtered don't correspond to any of the uSER registered. pls try again or register".toUpperCase());
                                        System.out.println("================================================");

                                    }


                                } catch (Exception e) {
                                    System.out.println("===================================================================================================");
                                    System.out.println("THERE WAS AN ERROR !!! ".toUpperCase() + e);
                                    System.out.println("===================================================================================================");
                                }


                            }



                                else {
                                    System.out.println("==================================================");
                                    System.out.println(keyId + " is not recorder , PLS register bellow ");
                                    System.out.println("==================================================");
                                }


                            }


                        

                        case "2" -> {//allow user to register

                            User userIn = new User("", "", "", "", "");
                            PersonDetailIn personIn = new PersonDetailIn("", "", "", "", "");
                            userIn.generatKey();

                        }

                    }//////


                }



            }

            while (true);

        }


    }



