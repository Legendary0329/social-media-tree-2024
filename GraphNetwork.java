public class GraphNetwork{
    Node headNode;

    public GraphNetwork(){}

    //add person to the graph 
    public void addNode (String person){
       Node node = new Node(person);
       node.next = headNode;
       headNode = node;
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

    public void addFollowers(String name){
        Node node = findNode(name);
        node.followers++;
    }
}