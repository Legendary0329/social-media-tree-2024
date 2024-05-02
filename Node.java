import java.util.*;

public class Node{
    String name;
    LinkedHashSet<Node> following;
    LinkedHashSet<Node> followers;
    int levelOfInfluence;
    Node next;

    public Node (String name){
        this.name = name;
        this.following = new LinkedHashSet<Node>();
        this.followers = new LinkedHashSet<Node>();
        this.levelOfInfluence = 0;
    }
}