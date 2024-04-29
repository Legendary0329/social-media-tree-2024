import java.util.*;

public class Node{
    String name;
    LinkedHashSet<Node> following;
    LinkedHashSet<Node> followers;
    Node next;

    public Node (String name){
        this.name = name;
        this.following = new LinkedHashSet<Node>();
        this.followers = new LinkedHashSet<Node>();
    }
}