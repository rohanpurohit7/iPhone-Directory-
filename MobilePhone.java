package com.Rohan;

import java.util.ArrayList;

/**
 * Created by Rohan on 12/22/2016.
 */
public class MobilePhone {

    private  ArrayList <String> MobilePhone = new ArrayList<>();

    public ArrayList<String> getMobilePhone() {
        return MobilePhone;
    }

    public void addContact (Contact Mycontact){
        MobilePhone.add(Mycontact.getName() + Mycontact.getContactNumber());
    }

    public void printDirectory (){
        System.out.println("You have " + MobilePhone.size() + " items in your directory list.");
        for (int i = 0; i < MobilePhone.size(); i++) {
            System.out.println((i + 1) + ". " + MobilePhone.get(i));
        }
    }

    public void modifyDirectoryContact(String currentContact,String newContact) { // overloaded method
        int position = findContact(currentContact);
        if (position >= 0) {
            modifyDirectoryContact(position, newContact);
            System.out.println("Modified old contact" + currentContact+ "set " + newContact + " at position " + (position + 1));

        }}

        private void modifyDirectoryContact(int position, String newContact) {
            MobilePhone.set(position, newContact);
        }



    public void removeDirectoryContact(String item) { // overloaded method
        int position = findContact(item);
        if (position >= 0) {
            removeDirectoryContact(position);
            System.out.println(item + " was removed from the directory list.");
        }
    }

    private void removeDirectoryContact(int position) {
        MobilePhone.remove(position);
    }

    private int findContact(String searchItem) {
        return MobilePhone.indexOf(searchItem);}

    public boolean onFile(String searchItem){
        int position = findContact(searchItem);
        if (position>=0){
            return true;
        }else{
            return false;
        }
    }
}

