
public class SinglyLinkedList {

    private class Node {

        private String item;
        private Node link;

        private Node(String item, Node link) {
            this.item = item;
            this.link = link;
        }

    }

    private Node head;
    
    public SinglyLinkedList() {
        head = null;
    }
    
    /**
     * Add a node containing the string passed as item at the head position of the Linked List
     * @param item
     */
    public void addToStart(String item) {
        head = new Node(item, head);
    }

    /**
     * Used to check if the Linked List contains a word
     * @param item
     * @return True if the word is present, false otherwise
     */
    public boolean contains(String item) {
        return (find(item) != null);
    }

    public boolean contains_SL(char item){
        return (find_SL(item) != null);
    }

    private Node find_SL(char target) {
    	int i = 1;

        while(nodeAtIndex(i) != null) {
            char m=nodeAtIndex(i).item.charAt(0);


            if(m==(target)) {
                return nodeAtIndex(i);
            }

            i++;
        }

        return null;
    }



    /**
     * Used to check if a word is present in the list
     * @param target
     * @return Node in which the word can be found
     */
    private Node find(String target) {
    	int i = 1;

        while(nodeAtIndex(i) != null) {

            if(nodeAtIndex(i).item.equals(target)) {
                return nodeAtIndex(i);
            }

            i++;
        }

        return null;
    }

    public int findwordindex(String target) {
    	int i = 1;
        boolean L=true;

        while(L) {

            if(nodeAtIndex(i).item.equals(target)) {
                
                return i;
                }

            i++;
        }

        return 0;
    }
    
    /**
     * Used to write the list to a file.
     * @return String that contains items on seperate lines
     */
    public String writeList() {
    	Node node = head;
    	String returnString = "";

        while(node != null) {
        	returnString += node.item + "\n";

            node = node.link;
        }
        
        return returnString;
    }

    /**
     * Prints the list to the console. Numbered starting from 1
     */
    public void outputList() {
        Node node = head;
        int topicNumber = 0;

        while(node != null) {
            topicNumber++;
            System.out.print(topicNumber + " : " + node.item + "\t");

            if(topicNumber % 4 == 0) {
                System.out.println();
            }

            node = node.link;
        }
    }
    
    /**
     * Used to modify an item in the list at position index. One indexed
     * @param index
     * @param item
     */
    public void modifyItem(int index, String item) {
    	nodeAtIndex(index).item = item;
    }
    
    /**
     * Used to remove item at position index
     * @param index
     */
    public void removeItem(int index) {
    	if(index == 1) {
    		head = head.link;
    	}
    	
    	else if(index == size()) {
    		nodeAtIndex(size() - 1).link = null;
    	}
    	
    	else {
    		nodeAtIndex(index - 1).link = nodeAtIndex(index - 1).link.link;
    	}
    }
    
    /**
     * Used to find the size of the LinkedList
     * @return int representing the size of the Linked List
     */
    public int size() {
    	Node node = head;
        int count = 0;

        while(node != null) {
        	count++;

            node = node.link;
        }
        
        return count;
    }

    /**
     * Used to check if the Linked List is empty
     * @return True if empty, false otherwise
     */
    public boolean isEmpty() {
        return (head == null);
    }
    
    /**
     * Used to find the node at position index
     * @param index
     * @return Node found at position index
     */
    private Node nodeAtIndex(int index) {
    	Node node = head;
        int currentIndex = 0;

        while(node != null) {
        	currentIndex++;

            if(currentIndex == index) {
                return node;
            }

            else node = node.link;
        }
        
        return node;
    }
    
    public String getItem(int index) {
    	return nodeAtIndex(index).item;
    }

}
