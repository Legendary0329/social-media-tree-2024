public class Dapper
{
    public double density(GraphNetwork network){
        int numNodes = network.countNode(network);
        int numEdges = network.countEdges(network);

        double density = (double) numEdges / (numNodes*(numNodes -1));
        
        return density;
    }

}