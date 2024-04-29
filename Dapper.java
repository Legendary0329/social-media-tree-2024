public class Dapper
{
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
    public int secDegreeRelation(GraphNetwork network){ 
        //get the input file's first name
        Node firstName = network.findNode(network.headNode.name);

        System.out.println(network.headNode.name);

        if (firstName != null){
            //get followers of the first name
            Node[] degree1 = network.getFollowers(firstName.name);
            System.out.println("Number of first-degree followers of " + degree1.length);
        
            //count the followers of the first name's followers
            int degree2 = 0;

            for (int i=0; i<degree1.length; i++){
                int followersCount = network.countFollwers(degree1[i]);
                System.out.println("Followers of " + degree1[i].name + ": " + followersCount);
                degree2 += followersCount;
            }

            return degree2;
        } else {
            return 0;
        }
    }

}