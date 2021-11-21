import java.util.Scanner;

import static java.lang.System.out;

public class Email {


    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private String email;
    private int defaultMailBoxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "tldrcompany.com";

    //Constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        out.println("Email created " + this.firstName + " " + this.lastName);

        //Call a method asking for the department - return the department
        this.department = setDepartment();
        out.println("Department: " + this.department);

        //Call a method that return a random password
        this.password = randomPassword(defaultPasswordLength);
        out.println("Your random password is: " + this.password);

        //Combine elements to generate email address
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"."+ companySuffix;
        out.println("Your email is " + email);
    }


    //Ask for the department
    private String setDepartment() {
        out.print("Enter the department\n 1 for Sales \n 2 for Development \n 3 for Accounting \n 0 for none \n Enter department code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice ==1 ) {
            return "sales";
        } else if (departmentChoice ==2 ) {
            return "development";
        } else if (departmentChoice == 3) {
            return "accounting";
        } else {
            return"";
        }
    }


    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char [] password = new char [length];
        for (int i =0; i < length; i++){
           int rand =  (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
        }
        return new String (password);
    }


    //Set the mailbox capacity
    public void setDefaultMailBoxCapacity(int capacity){
        this.defaultMailBoxCapacity = capacity;
    }


    //Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }


    //Change password
    public void changePassword (String password){
        this.password = password;
    }

    //Get mailbox capacity
    public int getDefaultMailBoxCapacity(){
        return defaultMailBoxCapacity;
    }

    //Get alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    //Get password
    public String getPassword() {
        return password;
    }

}
