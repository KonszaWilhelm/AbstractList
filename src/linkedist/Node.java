package linkedist;

public class Node implements Comparable {


    private Node previousNode;
    private Node nextNode;
    private Object value;

    public Node(Node previousNode, Node nextNode, Object value) {
        this.previousNode = previousNode;
        this.nextNode = nextNode;
        this.value = value;
    }

    public Node(Object value) {
        this.previousNode = null;
        this.nextNode = null;
        this.value = value;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public Node getPreviousNode() {
        return this.previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Object getValue() {
        return this.value;
    }


    @Override
    public int compareTo(Object o) {
        if (this.getValue().equals(o)) {
            return 0;
        } else
            return -1;
    }

    @Override
    public String toString() {
        return getValue() + "";
    }

}
