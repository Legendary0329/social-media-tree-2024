import java.util.*;

public class Dapper{
    //task 1
    public double density(GraphNetwork network){
        int numNodes = network.countNode();
        int numEdges = network.countEdges();

        //formula to calculate density
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
            //if the result of the compare is negative that means it comes before in an alphabetic order.
            if ((numFollowers > max) || ((numFollowers == max) && (mostFollowers != null && mostFollowers.compareTo(node.name) > 0))){
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
            int numFollowing = node.following.size();
            if ((numFollowing > max) || numFollowing == max && (mostFollowings != null && mostFollowings.compareTo(node.name) > 0)){
                max = numFollowing;
                mostFollowings = node.name;
            }
            node = node.next;
        }

        return mostFollowings;
    }

    //task 4: only find degree 2s of the first name of the input file
    public int secDegreeRelation(GraphNetwork network) { 
        // Get the input file's first name
        Node firstName = network.findNode(network.headNode.name);
    
        if (firstName != null) {
            // Get followers of the first name
            Node[] degree1 = network.getFollowers(firstName.name);
            int numPeople = 0;
            Node[] degree2 = new Node[network.countNode()];
            
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
                                // Count the followers of the first name's followers
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
    
    //for task 4, check if the node is in array
    private boolean isInArray (Node node, Node[] array){
        for (int i=0; i<array.length; i++){
            if (array[i] == node){
                return true;
            }
        }
        return false;
    }

    //task 5:s
    public void medianValue (GraphNetwork network){
        Node node = network.headNode;
        int[] numFollowers = new int[network.countNode()];
        int count = 0;

        //collect each person's followers in the grpah into array numFollowers
        while (node != null){
            numFollowers[count] = network.countFollwers(node);
            count++;
            node = node.next;
        }

        //sort the number of followers of each person in an increasing order
        Arrays.sort(numFollowers,0,count);

        //if number of people in the networl is even
        if ((count%2) == 0){
            int[] even = new int[2];
            even[0] = numFollowers[count/2];
            even[1] = numFollowers[(count/2)+1]; 
            float result = (even[0] + even[1])/2;
            System.out.println("there is 2 median values, their average is " + result);
        } else {
            System.out.println("the median value for the the number of followers in the network is " + numFollowers[count/2]);
        }
    }

    //task 6:
    public String mostInfluential(GraphNetwork network) {
        Node node = network.headNode;
        String mostInfluentialName = null;
        int maxFollowers = 0;

        while (node != null){
            //find the depth of each person
            int count = depth(node, network, new HashSet<>());
            //if the node is more influential, substitute the node
            if (count > maxFollowers){
                maxFollowers = count;
                mostInfluentialName = node.name;
            }
            node = node.next;
        }
    
        return mostInfluentialName;
    }
    
    //for task 6: //recursive method: until the current node has no followers
    private int depth(Node node, GraphNetwork network, Set<String> visited) {
        //check if the node is already viisted
        if (visited.contains(node.name)){
            return 0;
        }
        //if not add the node into the set
        visited.add(node.name);
        int count = 1;

        //get the followers of the node
        Node[] followers = network.getFollowers(node.name);
        for (int j=0; j<followers.length; j++){
            //go through every follower and check if it has already been iterated
            if (followers != null && !visited.contains(followers[j].name)){
                //add the counts of followers of ndoe and folloewrs of node's follower and so on
                count += depth(followers[j], network, visited);
            }
        }
        
        return count;
    }
}