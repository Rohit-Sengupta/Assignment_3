import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
public class driver {
	public static DoublyLinkedList DL = new DoublyLinkedList();
	
	
	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	int choice;
    boolean L=true;

    while (L) {
        printMenu();
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You chose to browse a topic.");
                int no_vocabs = DL.size();
                for (int i = 1; i < (no_vocabs + 1); i++) {
                    System.out.println(i + " " + DL.getVocabTopic(i));
                }
                System.out.println("0 To Exit");

                System.out.print("Enter Your Choice: ");
                int choice2=scanner.nextInt();
                if(choice2==0){
                    System.out.println("Exiting...");

                break;
                }
                else{
                    DL.outputVocab(choice2);
                    System.err.println("");
                }
                

                break;
            case 2:
            System.out.println("You chose to insert a new topic before another one.");
            no_vocabs = DL.size();
            for (int i = 1; i < (no_vocabs + 1); i++) {
                System.out.println(i + " " + DL.getVocabTopic(i));
            }
            System.out.println("0 To Exit");
            
            System.out.print("Enter Your Choice: ");
            choice2 = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            if (choice2 == 0) {
                System.out.println("Exiting...");

                break;
            } else {
                System.out.print("Enter a topic name:");
                String topicname = scanner.nextLine();
                System.out.println(topicname);
                Vocab v = new Vocab(topicname);
                
                System.out.println("Enter a word - to quit press Enter:");
                String word="temp";

        while (!word.isEmpty()) {

            word = scanner.nextLine();
            

            if(word!=""){v.words.addToStart(word);}
        }
        DL.insertNode(choice2, v);
            }
            break;
            case 3:
                System.out.println("You chose to insert a new topic after another one.");
            no_vocabs = DL.size();
            for (int i = 1; i < (no_vocabs + 1); i++) {
                System.out.println(i + " " + DL.getVocabTopic(i));
            }
            System.out.println("0 To Exit");
            
            System.out.print("Enter Your Choice: ");
            choice2 = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            if (choice2 == 0) {
                System.out.println("Exiting...");

                break;
            } else {
                System.out.print("Enter a topic name:");
                String topicname = scanner.nextLine();
                System.out.println(topicname);
                Vocab v = new Vocab(topicname);
                
                System.out.println("Enter a word - to quit press Enter:");
                String word="temp";

        while (!word.isEmpty()) {

            word = scanner.nextLine();
            

            if(word!=""){v.words.addToStart(word);}
        }
        choice2=choice2+1;
        DL.insertNode(choice2, v);
    }
    break;
            case 4:
                System.out.println("You chose to remove a topic.");
                no_vocabs = DL.size();
                for (int i = 1; i < (no_vocabs + 1); i++) {
                    System.out.println(i + " " + DL.getVocabTopic(i));
                }
                System.out.println("0 To Exit");

                System.out.print("Enter Your Choice: ");
                choice2=scanner.nextInt();
                if(choice2==0){
                    System.out.println("Exiting...");

                break;
                }
                else{
                    DL.deleteNode(choice2);
                    System.err.println("Deleted topic");
                }

                break;
            case 5:
            System.out.println("You chose to modify a topic.");
            no_vocabs = DL.size();
            for (int i = 1; i < (no_vocabs + 1); i++) {
                System.out.println(i + " " + DL.getVocabTopic(i));
            }
            System.out.println("0 To Exit");
        
            System.out.print("Enter Your Choice: ");
            choice2 = Integer.parseInt(scanner.next()); // Read integer input directly
            if(choice2==0){
                System.out.println("Exiting...");

            break;
            }
        
            modifyprint();
        
            System.out.print("Enter Your Choice: ");
            char choice3 = scanner.next().charAt(0); // Read a single character
            scanner.nextLine(); // Consume the newline character
        
            switch (choice3) {
                case 'a':
                    System.out.print("Type a word and press Enter, or press Enter to end input:");
                    String word = scanner.nextLine();
                    if (!word.isEmpty()) {
                        if(!DL.checkVocab(word,choice2)){
                        DL.getVocab(choice2).words.addToStart(word);}
                        else{
                            System.out.println("sorry, the word:'"+word+"' is alreay listed");
                        }
                    }
                    break;
                case 'r':

                DL.outputVocab(choice2);

                System.out.print("\nType a word and press Enter, or press Enter to end input:");
                    word = scanner.nextLine();
                    if (!word.isEmpty()) {
                        if(DL.checkVocab(word,choice2)){
                            int nomber=DL.getVocab(choice2).words.findwordindex(word);
                            if(nomber!=0){
                                DL.removeWord(choice2, nomber);
                                System.out.println("Deleted!");
                            }}
                      
                        else{
                            System.out.println("sorry, the word:'"+word+"' is not listed");
                        }
                    }
                    break;
                case 'c':
                DL.outputVocab(choice2);

                System.out.print("\nType the word you want to change and press Enter, or press Enter to end input:");
                    word = scanner.nextLine();
                    if (!word.isEmpty()) {
                        if(DL.checkVocab(word,choice2)){
                            int nomber=DL.getVocab(choice2).words.findwordindex(word);
                            if(nomber!=0){

                                System.out.print("\nType a new word and press Enter, or press Enter to end input:");
                                String newword = scanner.nextLine();
                                if(!newword.isEmpty()){
                                DL.changeWord(choice2, nomber,newword);
                                System.out.println("Changed!");}
                            }}
                      
                        else{
                            System.out.println("sorry, the word:'"+word+"' is not listed");
                        }
                    }
                    break;
                case '0':
                    // Exit
                    break;
                default:
                    // Handle invalid input
                    break;
            }
            break;


               
            case 6:
            System.out.println("You chose to search topics for a word.");
            System.out.print("Type a word you want to search and press Enter, or press Enter to end input:");
            scanner.nextLine(); // Consume the newline character
            String word = scanner.nextLine();
            if (!word.isEmpty()) {
                int num = DL.find(word);
                if (num != -1) {
                    System.out.print("\nThis word is in this topic:");
                    DL.outputVocabTopic(num);
                }
            }
                break;
            case 7:
                System.out.println("You chose to load from a file.");
                scanner.nextLine();
                System.out.print("\nPlease enter Filename:");
                String choiceidc=scanner.nextLine();
                fileHandle(choiceidc);
                System.out.println("Files loaded");
                break;
            case 8:
                System.out.println("You chose to show all words starting with a given letter.");
                System.out.print("Enter Your Choice: ");
                choice3 = scanner.next().charAt(0);
                scanner.nextLine();
                int s = DL.size();
                for (int i = 1; i <= s; i++) { 
                    int k = DL.sizeOfVocab(i);
                    for (int j = 1; j <= k; j++) { 
                        word = DL.getWordAtPosition(i, j);
                        if (!word.isEmpty() && word.charAt(0) == choice3) {
                            System.out.print(word+", ");
                        }
                    }
                }
                System.out.print("\n");
                break;
            case 9:
            System.out.println("You chose to save to file.");
            String output = DL.writeList();
            String path = "src\\files\\output.txt"; 
            try {
                Files.write(Paths.get(path), output.getBytes()); 
                System.out.println("File saved successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while saving the file: " + e.getMessage());
            }
            break;
            case 0:
                System.out.println("Exiting...");
                scanner.close();
                L=false;
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }
    }



    //Functions

    public static void modifyprint(){
            System.out.println("-----------------------------");
            System.out.println("Modify Topics Menu");
            System.out.println("-----------------------------");
            System.out.println("a add a word");
            System.out.println("r remove a word");
            System.out.println("c change a word");
            System.out.println("0 Exit");
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
					}
	 public static void fileHandle(String path){
            try {
                if(!path.contains(".txt")){
                    path=path+".txt";
                }
                Scanner in = new Scanner(new FileInputStream("src\\files\\"+path));

                processLines(in, DL);
                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("No input files available");
            }
        }
    
        private static void processLines(Scanner in, DoublyLinkedList DL) {
            Vocab currentVocab = null;
    
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains("#")) {
					line=line.replace("#","");
                    if (currentVocab != null) {
                        DL.addToStart(currentVocab);
                    }
					
                    currentVocab = new Vocab(line);
                } else {
                    if (currentVocab != null) {
                        currentVocab.words.addToStart(line);
                    }
                }
            }
            if (currentVocab != null) {
                DL.addToStart(currentVocab);
            }
        }

        
}


