import java.util.*;

public class Node{
    String name;
    LinkedHashSet<Node> edges;
    Node next;

    public Node (String name){
        this.name = name;
        this.edges = new LinkedHashSet<Node>();
    }
}