public class Vocab {

    public SinglyLinkedList words = new SinglyLinkedList();
    private String topic;

    public Vocab(String topic) {
        this.topic = topic;
    }

    /**
     * Used to print the vocab object to the console
     */
    public void outputVocab() {
        System.out.println("topic: " + topic);
        words.outputList();
    }

    /**
     * Getter method for topic
     * @return String topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Setter method for topic
     * @param topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }
    
}
