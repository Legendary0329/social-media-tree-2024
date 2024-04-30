public class GraphNetwork{
    Node headNode;

    public GraphNetwork(){}

    //add person to the graph 
    public void addNode (String person){
        Node newNode = new Node(person);
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node current = headNode;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
     }

    //where is person in the garph
    public Node findNode(String person){
        Node node = headNode;
        while (node !=null){
            if (node.name.equals(person)){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    //person1 follows person2
    public void addFollowing(String person1, String person2){
        Node src = findNode(person1);
        Node dst = findNode(person2);

        if (src != null && dst != null){
            //person1 follows person2
            src.following.add(dst);
        }
    }

    //person1 is a follower of person2
    public void addFollowers(String person1, String person2){
        Node src = findNode(person1);
        Node dst = findNode(person2);

        if (src != null && dst != null){
            dst.followers.add(src);
        }
    }

    //check if the name is already a node
    public boolean checkNode(String person){
        Node node = headNode;
        while (node !=null){
            if (node.name.equals(person)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //count how many person is in the network
    public int countNode(){
        int count = 0;
        Node node = headNode;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    //count how many edges in the whole network
    public int countEdges(){
        int count = 0;
        Node node = headNode;
        while (node != null) {
            count += node.following.size();
            node = node.next;
        }
        return count;
    }

    //get who the first person in the input follows
    public Node[] getFollowers(String name){
        Node node = findNode(name);
        Node[] numNeighbors = null;

        if (node != null){
            numNeighbors = node.followers.toArray(new Node[node.followers.size()]);
        }
        
        return numNeighbors;
    }

    public int countFollwers(Node node){
        int count = 0;
        if (node != null) {
            count += node.followers.size();
        }
        return count;
    }
}