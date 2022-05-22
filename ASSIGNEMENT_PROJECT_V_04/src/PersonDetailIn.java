import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public  class PersonDetailIn extends Person {//CLASS PERSON_DETAIL_IN


    //CONSTRUCTOR

    public PersonDetailIn(String lastName, String surname, String nationalID, String gender, String dateOfBith) throws SQLException {
        super(lastName, surname, nationalID, gender, dateOfBith);





}






    //METHOD ONE GET PERSON DETAILS



    public void getPersonDetail(){


        /*
        PLAN
        -------
        * ASL USER TO ENTER :
        *
        * HIS/HER LASTNAME
        * HIS/HER SURNAME
        * NATIONAL ID
        * DATE OF BIRTH
        * GENDER
        *
        * */



        try

        {



        Scanner PersonInput = new Scanner(System.in);//Scanner for Person input

        System.out.println("==================================================");
        System.out.println("Enter you Lastname\n");   String lastNameIn = PersonInput.next();
        System.out.println("==================================================\n");
        setLastName(lastNameIn);

        System.out.println("\n==================================================");
        System.out.println("Enter you Surname");   String surNameIn = PersonInput.next();
        System.out.println("==================================================\n");
        setSurname(surNameIn);

        System.out.println("\n==================================================");
        System.out.println("Enter your Date of birth ");   String dateOfBirth= PersonInput.next();
        System.out.println("==================================================\n");
        setDateOfBirth(dateOfBirth);

        System.out.println("\n==================================================");
        System.out.println("Enter your National ID");   String nationalIDin = PersonInput.next();
        setNationalID(nationalIDin);
        System.out.println("==================================================\n");

        System.out.println("\n==================================================");
        System.out.println("Enter your Gender");   String genderIn= PersonInput.next();
        System.out.println("==================================================\n");
        setGender(genderIn);



        System.out.println("\n==================================================");
        System.out.println("Your name is "+getLastName() +" "+ getSurname());
        System.out.println("Your were born on the "+ getDateOfBirth());
        System.out.println("==================================================\n");


        System.out.println("\n\n==========================");
        System.out.println(" NEXT STEP --->");
        System.out.println("==========================\n\n");





        //INSERTION INTO THE DATABASE ------>>>>















            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY_MANAGEMENT_SYSTEM_V5", "root", "dankibwika18072001");

            String insertSql = "INSERT INTO person (" +
                    "lastName , surname, nationalID,gender, dateOfBith ) VALUES ('" + getLastName() +"','" + getSurname() + "','" + getNationalID() +"','"
            + getGender() +"','" + getDateOfBirth()+"')";
            PreparedStatement prepStat = conn.prepareStatement(insertSql);

            int updateRowCount = prepStat.executeUpdate();


            if (updateRowCount > 0) {

                System.out.println( "=================================");
                System.out.println( "RECORDED AND INSERTED ");
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

    //REMEMBER TO FIX THE BUG IN YOUR CODE !!!!!!!!!!!!!!!!!!!!!!!!!!!! ON IMPORTING DATA FROM THE PERSONDETAILS CLASS TO THE USER IN ORDER
//    FOR THEM TO BE DISPLAYED

}