import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Analysis{
    
    public static void main (String[] args){
        String[] people;
        //collects the input of filename
        String filename = args[0];
        BufferedReader reader = null;
        GraphNetwork network = new GraphNetwork();
        Dapper dapper = new Dapper();
        //use try to catch some potential exceptions
        try{
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                people = line.split("\\s+");
                //check if the first name if its already a node
                if (!network.checkNode(people[0])){
                    network.addNode(people[0]);
                }

                for(int i=1; i<people.length; i++){
                    if (network.checkNode(people[i])){
                        //if its already in the network, people[0] follows people[1]
                        network.addFollowing(people[0], people[i]);
                        network.addFollowers(people[i]);

                    }else{
                        network.addNode(people[i]);
                        network.addFollowing(people[0], people[i]);
                        network.addFollowers(people[i]);
                    }
                }
            }

            //tasks:
            //task 1:
            double density = dapper.density(network);
            System.out.println("The density of the graph is " + density);

            //task 2:
            String mostFollowers = dapper.mostFollowers(network);
            System.out.println("The person who has the most followers is " + mostFollowers);

        } catch (IOException e){
            //handle IO exceptions (file not found)
            e.printStackTrace();
        //ensure the reader is closed no matter what
        } finally {
            if (reader != null){
                try{
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        }
    }
}
