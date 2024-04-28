import java.util.*;

public class Node{
    String name;
    LinkedHashSet<Node> following;
    int followers;
    Node next;

    public Node (String name){
        this.name = name;
        this.following = new LinkedHashSet<Node>();
        this.followers = 0;
    }
}