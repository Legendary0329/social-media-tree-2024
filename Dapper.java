public class Dapper
{
    public float density(GraphNetwork network){
        int numNodes = network.countNode(network);
        int numEdges = network.countEdges(network);

        float density = numEdges / (numNodes*(numNodes -1));
        
        return density;
    }

}