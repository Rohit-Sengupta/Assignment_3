public class DoublyLinkedList {

    private class Node {

        private Vocab item;
        private Node next;
        private Node previous;

        private Node(Vocab item, Node next, Node previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }

    }
    
    private Node head;

    public DoublyLinkedList() {
        head = null;
    }

    
    /** 
     * Used to find the size of the Linked List
     * @return Int corresponding to the size of the Linked List
     */
    public int size() {
        int count = 0;
        Node node = head;

        while(node != null) {
            count++;
            node = node.next;
        }

        return count;
    }
    
    /**
     * Prints to the console the Vocab topic selected by the index parameter. One indexed.
     * @param index
     */
    public void outputVocabTopic(int index) {
    	System.out.println(nodeAtIndex(index).item.getTopic());
    }
    //To get the topic as a string
    public String getVocabTopic(int index) {
    	return nodeAtIndex(index).item.getTopic();
    }

    /**
     * Prints to the console the Vocab object selected by the index parameter. One indexed.
     * @param index
     */
    public void outputVocab(int index) {
    	nodeAtIndex(index).item.outputVocab();
    }

    public Vocab getVocab(int index){
        return nodeAtIndex(index).item;
    }


    
    /**
     * Add a node at the head position of the Linked List. 
     * Works with an empty Linked List, contrary to insertNode(), and otherwise has the same functionality as insert node with index parameter equal to one.
     * @param item
     */
    /**

     * Add a node at the head position of the Linked List. 

     * Works with an empty Linked List, contrary to insertNode(), and otherwise has the same functionality as insert node with index parameter equal to one.

     * @param item

     */

    public void addToStart(Vocab item) {

    	Node addedNode = new Node(item, head, null);

    	

    	if(head != null) {

    		head.previous = addedNode;

    	}

    	

    	head = addedNode;

    }

    /**
     * Inserts a node at the selected index. It can be the absolute beginning of the list or at size() + 1. One indexed.
     * @param index
     * @param item
     * @return True if successful, false otherwise
     */
    public boolean insertNode(int index, Vocab item) {
        Node node = head;
        int currentIndex = 0;

        while(true) {
            currentIndex++;

            if(currentIndex == index) {
                Node addedNode = new Node(item, node, node.previous);

                if(node.previous == null) {
                    node.previous = addedNode;
                    head = addedNode;
                }

                else {
                    node.previous.next = addedNode;
                    node.previous = addedNode;
                }

                return true;
            }

            else  {
                if(node.next == null) break;

                node = node.next;
            }
        }

        if(currentIndex + 1 == index) {
            node.next = new Node(item, null, node);
        }

        return false;
    }

    /**
     * Deletes Node at position index. One indexed.
     * @param index
     * @return True if successful, false otherwise
     */
    public void deleteNode(int index) {
    	Node node = nodeAtIndex(index);
    	
        if(node.next == null && node.previous == null) {
            head = null;
        }

        else if(node.previous == null) {
            head = node.next;
            head.previous = null;
        }

        else if(node.next == null) {
        	node.previous.next = null;
        }

        else {
        	node.previous.next = node.next;
        	node.next.previous = node.previous;
        }
    }

    /**
     * Used to find if a topic contains a given word
     * @param word
     * @return Int corresponding to the position of the node with the Vocab object containing the word. returns -1 if the word cannot be found
     */
    public int find(String word) {
        int i = 1;

        while(nodeAtIndex(i) != null) {

            if(nodeAtIndex(i).item.words.contains(word)) {
                return i;
            }

            i++;
        }

        return -1;
    }

    public boolean checkVocab(String word, int index){
        int i = index;

   

            if(nodeAtIndex(i).item.words.contains(word)) {
                return true;
            }
            else{

        return false;}


    } 
    public int findSL(char c) {
        int j = size();
    
        for (int i = 1; i <= j; i++) {
            if (nodeAtIndex(i) != null) {
                if (nodeAtIndex(i).item.words.contains_SL(c)) {
                    return i;
                }
            }
        }
    
        return -1; 
    }
    


    /**
  	 * Used to save a Vocabulary bank to a file
     * @return String that can be written to a file
     */
    public String writeList() {
        String returnString = "";
        int i = 1;

        while(nodeAtIndex(i) != null) {
        	returnString += "\n"+"#" + nodeAtIndex(i).item.getTopic() + "\n";
        	returnString += nodeAtIndex(i).item.words.writeList();
        	
        	i++;
        }
        
        return returnString;
    }
    
    /**
     * Used to find how big the Linked List of a vocab object is
     * @param index
     * @return Int representing how many words are contained in a vocab object
     */
    public int sizeOfVocab(int index) {
    	return nodeAtIndex(index).item.words.size();
    }
    
    /**
     * Used to modify a word stored in a vocab object's Linked List
     * @param vocabIndex
     * @param wordIndex
     * @param newWord
     */
    public void changeWord(int vocabIndex, int wordIndex, String newWord) {
    	nodeAtIndex(vocabIndex).item.words.modifyItem(wordIndex, newWord);
    }
    
    /**
     * Used to remove a word in a vocab object at position wordIndex
     * @param vocabIndex
     * @param wordIndex
     */
    public void removeWord(int vocabIndex, int wordIndex) {
    	nodeAtIndex(vocabIndex).item.words.removeItem(wordIndex);
    }
    
    public String getWordAtPosition(int vocabIndex, int wordIndex) {
    	return nodeAtIndex(vocabIndex).item.words.getItem(wordIndex); 	
    }

    /**
     * Checks if the Linked List is empty
     * @return True if empty, false otherwise
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Clears the Linked List
     */
    public void clear() {
        head = null;
    }
    
    /**
     * Used to find the node at the given index
     * @param index
     * @return Node at index
     */
    private Node nodeAtIndex(int index) {
    	Node node = head;
        int currentIndex = 0;

        while(node != null) {
        	currentIndex++;

            if(currentIndex == index) {
                return node;
            }

            else node = node.next;
        }
        
        return node;
    }
    
}
