package com.Rohan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone iphone = new MobilePhone();

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("0 to print choice options");
        System.out.println("1 to print list of directory contacts");
        System.out.println("2 to add contact to the iphone contact list");
        System.out.println("3 to modify contact details");
        System.out.println("4 to remove contact");
        System.out.println("5 to search for contact");
        System.out.println("6 to transfer contact list");
        System.out.println("7 to quit");
    }

    public static void addContact(String name, int contact) {
        System.out.print("Please enter contact details to add");
        System.out.println("\n Please enter name for the contact");
        name =scanner.nextLine();
        System.out.println("The name "+ name+ " has been entered in the directory." + "\n Please enter a number for the contact"+ name);
        contact = scanner.nextInt();
        System.out.println("The number for the contact "+ name +" has been updated to"+ contact);
        System.out.println("The new directory entry is "+ name + " " + contact);
        Contact Mycontact = new Contact (name,contact);
        iphone.addContact((Mycontact));
    }


    public static void modifyContact() {
        System.out.print("Please enter an contactName to modify");
        String contactName = (scanner.nextLine());
        scanner.nextLine();
        System.out.print("Enter replacementName: ");
        String replacementName = scanner.nextLine();
        iphone.modifyDirectoryContact(contactName, replacementName);// position is for array. itemNo is for user view of list
    }

    public static void removeContact() {
        System.out.print("Please enter an item name to remove");
        String itemName = (scanner.nextLine());
        scanner.nextLine();
        iphone.removeDirectoryContact(itemName);
    }

    public static void searchForContact() {
        System.out.print("Please enter Contact to search for : ");
        String searchItem = (scanner.nextLine());
        scanner.nextLine();
        if (iphone.onFile(searchItem)) {
            System.out.println("Found contact: " + searchItem + " in the list");
        } else {
            System.out.println("contact is not in the list");
        }
    }

    public static void transferContactList() {
        System.out.println("Now transferring DirectoryList");
        ArrayList<String> newList = new ArrayList<String>();
        newList.addAll(iphone.getMobilePhone()); // copty to newArrayList

        ArrayList<String> processedList = new ArrayList<String>(iphone.getMobilePhone()); // copy to arraylist

        String[] myArray = new String[iphone.getMobilePhone().size()];
        myArray = iphone.getMobilePhone().toArray(myArray);  // copy to a normal array  after specifyin size/
    }



    public static void main(String[] args) {


        boolean quit = false;
        int choice =0;
        printInstructions();
        while(! quit) {
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    iphone.printDirectory();
                    break;
                case 2:
                    addContact("Default Name", 123);
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                    transferContactList();
                    break;
                case 7:
                    quit = true;
                    break;

            }
        }}}