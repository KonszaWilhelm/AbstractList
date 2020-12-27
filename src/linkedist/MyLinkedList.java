package linkedist;

public class MyLinkedList {

    Node first;
    Node last;
    int size;


    public void add(Object obj) {

        Node curr;
        //if no nodes add as first node
        if (first == null) {
            first = new Node(obj);
        }
        //else parse until we get to end of list
        else {
            if (!checkIfPresent(obj)) {
                curr = first;
                while (curr.getNextNode() != null) {
                    curr = curr.getNextNode();
                }
                last = curr;
                //add obj as last.nextNode
                last.setNextNode(new Node(last, null, obj));
            } else
                System.out.println("Item \"" + obj.toString() + "\" already present");

        }

    }

    public void remove(Object obj) {

        Node curr = first;
        Node prev;
        if (first == null) {
            System.out.println("Empty list");
        } else if (curr.getValue() == obj) {
            if (curr.getNextNode() != null) {
                first = curr.getNextNode();
                System.out.println("\"" + obj.toString() + "\" " + "removed from the list.");
            }
        } else if (checkIfPresent(obj)) {
            while (curr.getValue() != obj) {
                curr = curr.getNextNode();
            }
            if (curr.getNextNode() == null) {
                prev = curr.getPreviousNode();
                prev.setNextNode(null);
                curr.setPreviousNode(null);
                System.out.println("\"" + obj.toString() + "\" " + "removed from the list.");

            } else if (curr.getNextNode() != null) {
                prev = curr.getPreviousNode();
                prev.setNextNode(curr.getNextNode());
                curr.getNextNode().setPreviousNode(prev);
                System.out.println("\"" + obj.toString() + "\" " + "removed from the list.");

            }

        } else
            System.out.println("\"" + obj + "\"" + " not present");


    }

    public int getSize() {
        Node curr = first;
        size = 0;
        if (first.getValue() == null) {
            return size;
        } else {
            size++;
            while (curr.getNextNode() != null) {
                curr = curr.getNextNode();
                size++;
            }
        }


        return size;
    }

    public boolean checkIfPresent(Object object) {
        Node curr = first;
        if (first != null) {
            while (curr.getValue() != object && curr.getNextNode() != null) {
                curr = curr.getNextNode();
            }
            if (curr.getValue() == object) {
                return true;
            }

        }
        return false;

    }

    public Node getNode(int i) {
        Node temp;
        int counter = 0;


        if (i > getSize() - 1) {
            System.out.println("Index out of bounds");
            return null;
        } else if (first != null && i >= 0) {
            temp = first;

            while (i != counter && temp.getNextNode() != null) {
                temp = temp.getNextNode();
                counter++;

                if (i == counter) {
                    return temp;
                }
            }
        }

        return null;
    }

    public Node getNode(Object obj) {
        Node temp;
        if (checkIfPresent(obj)) {
            temp = first;
            while (temp.getNextNode() != null && temp.getValue() != obj) {
                temp = temp.getNextNode();
            }
            return temp;
        } else
            System.out.println("Not present");

        return null;
    }


    @Override
    public String toString() {
        Node curr = first;
        StringBuilder sb = new StringBuilder();
        while (curr.getNextNode() != null) {
            sb.append(curr + ", ");
            curr = curr.getNextNode();
        }
        sb.append(curr);
        return sb.toString();
    }
}
