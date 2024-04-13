import java.util.Scanner;
public class driver {
	
	
	public static void main(String[] args) {
		
		printMenu();
	
	Scanner scanner = new Scanner(System.in);
	int choice;
    choice = scanner.nextInt();
    
    switch (choice) {
        case 1:
            System.out.println("You chose to browse a topic.");
            break;
        case 2:
            System.out.println("You chose to insert a new topic before another one.");
            break;
        case 3:
            System.out.println("You chose to insert a new topic after another one.");
            break;
        case 4:
            System.out.println("You chose to remove a topic.");
            break;
        case 5:
            System.out.println("You chose to modify a topic.");
            break;
        case 6:
            System.out.println("You chose to search topics for a word.");
            break;
        case 7:
            System.out.println("You chose to load from a file.");
            break;
        case 8:
            System.out.println("You chose to show all words starting with a given letter.");
            break;
        case 9:
            System.out.println("You chose to save to file.");
            break;
        case 0:
            System.out.println("Exiting...");
            break;
        default:
            System.out.println("Invalid choice!");
    }
    }
	public static void printMenu() 
    { 
    
    System.out.println("===========================");
    System.out.println("Vocabulary Control Center");
    System.out.println("===========================");
    System.out.println("1 browse a topic");
    System.out.println("2 insert a new topic before another one");
    System.out.println("3 insert a new topic after another one");
    System.out.println("4 remove a topic");
    System.out.println("5 modify a topic");
    System.out.println("6 search topics for a word");
    System.out.println("7 load from a file");
    System.out.println("8 show all words starting with a given letter");
    System.out.println("9 save to file");
    System.out.println("0 exit");
    System.out.println("===========================");
    System.out.print("Enter Your Choice: ");
}}

