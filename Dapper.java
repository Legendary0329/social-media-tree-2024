import java.util.*;

public class Dapper{
    //task 1
    public double density(GraphNetwork network){
        int numNodes = network.countNode();
        int numEdges = network.countEdges();

        double density = (double) numEdges / (numNodes*(numNodes -1));
        
        return density;
    }

    //task 2
    public String mostFollowers(GraphNetwork network){
        Node node = network.headNode;
        String mostFollowers = null;
        int max = 0;

        while(node != null){
            int numFollowers = network.countFollwers(node);
            //if the result of the compare is negative that means the comes before in alphabetic order.
            if (numFollowers > max || (numFollowers == max && (mostFollowers != null && mostFollowers.compareTo(node.name) > 0))){
                max = numFollowers;
                mostFollowers = node.name;
            }
            node = node.next;
        }

        return mostFollowers;
    }

    //task 3
    public String highestFollowing(GraphNetwork network){
        Node node = network.headNode;
        String mostFollowings = null;
        int max = 0;

        while(node != null){
            if (node.following.size() > max){
                max = node.following.size();
                mostFollowings = node.name;
            }
            node = node.next;
        }

        return mostFollowings;
    }

    //task 4: only find degree 2s of the first name of the input
    public int secDegreeRelation(GraphNetwork network) { 
        // Get the input file's first name
        Node firstName = network.findNode(network.headNode.name);
    
        if (firstName != null) {
            // Get followers of the first name
            Node[] degree1 = network.getFollowers(firstName.name);
            
            // Count the followers of the first name's followers
            int numPeople = 0;
            //have to change the size of the array depending on the number of people in the network
            Node[] degree2 = new Node[100];
            
            for (int i = 0; i < degree1.length; i++) {
                // Get the followers of each with 1 degree separation
                Node[] verifiedDegree1 = network.getFollowers(degree1[i].name);
    
                //check overlapping names
                for (int j = 0; j < verifiedDegree1.length; j++) {
                    //neihter the first input name nor names that it's in degree1 array
                    if ((!isInArray(verifiedDegree1[j], degree1)) && (!verifiedDegree1[j].equals(firstName))) {
                        for (int k = 0; k < 100; k++) {
                            if (degree2[k] != null && degree2[k].equals(verifiedDegree1[j])) {
                                //if the the name already exists in the degree2 array
                                break;
                            } else if (degree2[k] == null) {
                                //if not, add it to the degree2 array
                                degree2[k] = verifiedDegree1[j];
                                numPeople++;
                                break;
                            }
                        }
                    }
                }
            }
            return numPeople;
        } else {
            return 0;
        }
    }
    
    private boolean isInArray (Node node, Node[] array){
        for (int i=0; i<array.length; i++){
            if (array[i] == node){
                return true;
            }
        }
        return false;
    }

    //task 5:
    public void medianValue (GraphNetwork network){
        Node node = network.headNode;
        int[] numFollowers = new int[network.countNode()];
        int count = 0;

        //collect each name's follwers into array
        while (node != null){
            numFollowers[count] = network.countFollwers(node);
            count++;
            node = node.next;
        }

        //sort in an increasing order
        Arrays.sort(numFollowers,0,count);

        //if number of people in the networl is even
        if ((count%2) == 0){
            int[] even = new int[2];
            even[0] = numFollowers[count/2];
            even[1] = numFollowers[(count/2)+1]; 
            float result = (even[0] + even[1])/2;
            System.out.println("the median value for the the number of followers in the network is " + result);
        } else {
            //medianValue = numFollowers[count/2]; 
            System.out.println("the median value for the the number of followers in the network is " + numFollowers[count/2]);
        }
    }

    //task 6:
    public String mostInfluential(GraphNetwork network) {
        Node node = network.headNode;
        String mostInfluentialName = null;
        int maxFollowers = 0;

        while (node != null){
            int count = depth(node, network, new HashSet<>());
            System.out.println(node.name + count);
            // the node is more influential, substitute the node
            if (count > maxFollowers){
                maxFollowers = count;
                mostInfluentialName = node.name;
            }
            node = node.next;
        }
    
        return mostInfluentialName;
    }
    
    private int depth(Node node, GraphNetwork network, Set<String> visited) {
        //recursive method:
        //check if the node is already viisted
        if (visited.contains(node.name)){
            return 0;
        }
        //if not add the node into the set
        visited.add(node.name);
        int count = 1;

        Node[] follwers = network.getFollowers(node.name);
        for (int j=0; j<follwers.length; j++){
            if (!visited.contains(follwers[j].name)){
                count += depth(follwers[j], network, visited);
            }
        }
        System.out.println(visited);

        return count;
    }
    

}