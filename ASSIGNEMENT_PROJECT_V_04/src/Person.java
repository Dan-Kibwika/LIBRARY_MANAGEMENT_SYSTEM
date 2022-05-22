import java.util.Scanner;

public class Person {




    //ATTRIBUTES
    private  String LastName , Surname, nationalID,gender, dateOfBirth;

//CONSTRUCTOR
    public Person(String lastName, String surname, String nationalID, String gender, String dateOfBith) {
        this.LastName = lastName;
        this.Surname = surname;
        this.nationalID = nationalID;
        this.gender = gender;
        this.dateOfBirth = dateOfBith;
    }

    public Person() {

    }


    //GETTERS AND SETTERS

    public String getLastName() {return LastName;}
    public void setLastName(String lastName) {LastName = lastName;}

    public String getSurname() {return Surname;}
    public void setSurname(String surname) {Surname = surname;}

    public String getNationalID() {return nationalID;}
    public void setNationalID(String nationalID) {this.nationalID = nationalID;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public String getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}
}


//PERSON DETAIL IN IS A SUBCLASS OF PERSON WHICH MEANS THERE IS COMPOSITION


//class test10 {
//    public static void main(String []args){
//        User userIn = new User("","");
//        PersonDetailIn personIn = new PersonDetailIn("","","","","");
//        personIn.getPersonDetail();
//        userIn.generateKey();
//
//
//    }

