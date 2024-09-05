import java.util.Scanner;

public class Main {

   static Scanner s;
    static Database database;

    public static void main(String[] args) {
        database = new Database();
        System.out.println("Welcome to library management system");

        int choice;
        do {
           System.out.println( "1. Login\n" + "2. New user\n" + "3. Exit");
           s = new Scanner(System.in);
           choice = s.nextInt();
           switch (choice) {
               case 1:  login();
               break;
               case 2 : newuser();
               break;
          }
            }while( choice != 0 );


    }

    public static void login() {
        System.out.println("Enter phone number : ");
        String phonenumber = s.next();
        System.out.println("Enter email: ");
        String email = s.next();
        int n = database.login(phonenumber, email);

        if (n != -1){
         User user = database.getUser(n);
         user.menu();
        }
        else {
         System.out.println("user doesn't exist");
        }

    }
   private static void newuser() {

        System.out.println("Enter name: ");
        String name = s.next();
        System.out.println("Enter phone number: ");
        String phonenumber = s.next();
        System.out.println("Enter email: ");
        String email = s.next();
        System.out.println("1. Admin\n2. Normal User ");
        int n2 = s.nextInt();
        User user;

        if (n2 == 1) {
            user = new Admin(name, phonenumber, email);
        }
        else {
            user = new NormalUser(name, phonenumber, email);

        }
       user.menu();
       database.AddUser(user);


    }
}