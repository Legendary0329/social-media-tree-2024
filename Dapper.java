public class Dapper
{
    public double density(GraphNetwork network){
        int numNodes = network.countNode();
        int numEdges = network.countEdges();

        double density = (double) numEdges / (numNodes*(numNodes -1));
        
        return density;
    }

    public String mostFollowers(GraphNetwork network){
        Node node = network.headNode;
        String[] names = new String[network.countNode()];
        int i=0;
        String mostFollowers = null;
        int max = 0;

        while(node != null){
            names[i] = node.name;

            if (node.followers >= max){
                max = node.followers;
                mostFollowers = names[i];
            }
            node = node.next;
            i++;
        }

        return mostFollowers;
    }
}