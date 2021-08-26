import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void addEntry(ArrayList<Entry> addressBook){
//        This method adds a new entry to ArrayList addressBook

        Entry newEntry = new Entry();

        System.out.print("First Name: ");
        newEntry.setFirstName(scanner.next());

        System.out.print("Last Name: ");
        newEntry.setLastName(scanner.next());

        System.out.print("Phone Number: ");
        newEntry.setPhone(scanner.next());
        //checks for phone format
        while(newEntry.getPhone().length()!=10){
            System.out.print("Invalid phone number. Enter again: ");
            newEntry.setPhone(scanner.next());
        }

        System.out.print("Email Address: ");
        newEntry.setEmail(scanner.next());
        //checks for email format
        while(!newEntry.getEmail().contains("@")){
            System.out.print("Invalid email address. Enter again: ");
            newEntry.setEmail(scanner.next());
        }

        addressBook.add(newEntry);
        System.out.println("Added new entry!\n");

//        System.out.println(newEntry); This was used to test the method
    }

    public static void removeEntry(ArrayList<Entry> addressBook){
        System.out.print("Enter an entry's email to remove: ");
        boolean found = false;
        String email = scanner.next();
        for(Entry entry : addressBook){
            if(entry.getEmail().equals(email)){
                System.out.println("Deleted the following entry:");
                System.out.println(entry);
                addressBook.remove(entry);
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Entry not found!\n");
    }

    public static void search(ArrayList<Entry> addressBook){
        System.out.println("1) First Name");
        System.out.println("2) Last Name");
        System.out.println("3) Phone Number");
        System.out.println("4) Email Address");
        System.out.print("Choose a search type: ");
        int searchTypeNum;

        try{
            searchTypeNum = scanner.nextInt();
            if(!(searchTypeNum>=1&&searchTypeNum<=4)){
                System.out.println("Invalid search option.\n");
                return;
            }
        } catch(InputMismatchException e){

            System.out.println("Invalid search option.\n");
            scanner.nextLine();
            return;
        }


        System.out.print("Enter your search: ");
        String searchContent = scanner.next();

        //Search by type based on user's selection. may be optimized
        boolean found = false;
        switch (searchTypeNum){
            case 1:
                for(Entry entry : addressBook){
                    if(entry.getFirstName().contains(searchContent)) {
                        System.out.println(entry);
                        found = true;
                    }
                }
                if(!found) System.out.println("No results found!\n");
                break;
            case 2:
                for(Entry entry : addressBook){
                    if(entry.getLastName().contains(searchContent)) {
                        System.out.println(entry);
                        found = true;
                    }
                }
                if(!found) System.out.println("No results found!\n");
                break;
            case 3:
                for(Entry entry : addressBook){
                    if(entry.getPhone().contains(searchContent)) {
                        System.out.println(entry);
                        found = true;
                    }
                }
                if(!found) System.out.println("No results found!\n");
                break;
            case 4:
                for(Entry entry : addressBook){
                    if(entry.getEmail().contains(searchContent)) {
                        System.out.println(entry);
                        found = true;
                    }
                }
                if(!found) System.out.println("No results found!\n");
                break;
        }
    }

    public static void printBook(ArrayList<Entry> addressBook){
        if(addressBook.isEmpty()) {
            System.out.println("Address Book is empty!\n");
        } else{
            for(Entry entry : addressBook){
                System.out.println(entry);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Entry> addressBook = new ArrayList<>();
        File addressBookFile = new File("addressBookFile.txt");


        int action = 0;
        while(action!=6){
            System.out.print("1) Add an entry\n" +
                    "2) Remove an entry\n" +
                    "3) Search for a specific entry\n" +
                    "4) Print Address Book\n" +
                    "5) Delete Book\n" +
                    "6) Quit\n\n" +
                    "Please choose what you'd like to do with the database: ");


            action = scanner.nextInt();
            if(action==1){
                addEntry(addressBook);
            } else if(action==2){
                removeEntry(addressBook);
            } else if(action==3){
                search(addressBook);
            } else if(action==4){
                printBook(addressBook);
            } else if(action==5){
                addressBook.clear();
                System.out.println("Address book cleared!\n");
            } else if(action==6) {
                break;
            }
        }


    }


}
