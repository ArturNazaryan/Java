package PhoneBookBDG;

import java.io.*;

import java.util.Scanner;



public class PhoneBook {
    public static void main(String[] args) {
        MainManu();
    }


    public static void callContact(String name) {
        System.out.println("Colling" + " " + name);
    }

    public static void saveContact(String name, long number) {

        File contact = new File("Contacts.txt");
        try {
            PrintWriter art = new PrintWriter(new FileWriter(contact, true));
            art.println(name + "-" + number);
            art.close();

            if (!contact.createNewFile())
                System.out.println("Contact saved as" + " " + name + " with " + number + " number");
            else System.out.println("Sorry this contact is already exist");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void findContact(String name) {
        System.out.println("Sorry " + name + "dos not exist in phonebook");
        try (Scanner in = new Scanner(new File("contacts.txt"))) {


            String[] s;
            boolean Contact = false;
            while (in.hasNextLine()) {
                s = in.nextLine().split("-");
                if (s[0].equals(name)) {

                    System.out.println("In phonebook " + name + "saved with this" + s[1] + "number");
                    Contact = true;

                } else if (!Contact) {
                    System.out.println(name + " dos not exist in phonebook");
                }


            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void MainManu() {

        Scanner in = new Scanner(System.in);

        do {
            System.out.println("WELCOME TO PHONEBOOK");
            System.out.println("1. Call Contact");
            System.out.println("2. Save Contact");
            System.out.println("3. Find Contact");
            System.out.println("4. Remove Contact");

            int choice = in.nextInt();
            in.nextLine();
            String name;

            switch (choice) {
                case 1 -> {
                    System.out.println("Firstname, Lastname");
                    name = in.nextLine();
                    callContact(name);
                }
                case 2 -> {
                    System.out.println("Enter contact Firstname and Lastname");
                    name = in.nextLine();
                    System.out.println("Enter contact phone number");
                    long number = in.nextLong();
                    in.nextLine();
                    saveContact(name, number);
                }
                case 3 -> {
                    System.out.println("search from contact");
                    findContact(in.nextLine());
                }
                case 4 -> {
                    System.out.println("Please enter Contact name for deleting");
                    name = in.nextLine();
                    System.out.println("Are You sure you want to delete " + name + "contact:  (Y/N)" );

                }
            }

            System.out.println("Do You want to continue ?  Y/N ");
        } while ('Y' != in.next().toLowerCase().charAt(0));
    }
}

