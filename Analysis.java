import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Analysis{
    
    public static void main (String[] args){
        String[] people;
        //collects the input of filenamebut 
        String filename = args[0];
        BufferedReader reader = null;
        GraphNetwork network = new GraphNetwork();
        Dapper dapper = new Dapper();
        //use try to catch some potential exceptions
        try{
            reader = new BufferedReader(new FileReader(filename));
            String line;
            String firstName = null;
            while ((line = reader.readLine()) != null) {
                people = line.split("\\s+");

                if (firstName == null){
                    firstName = people[0];
                }

                //check if the first name if its already a node
                if (!network.checkNode(people[0])){
                    network.addNode(people[0]);
                }

                for(int i=1; i<people.length; i++){
                    if (network.checkNode(people[i])){
                        //if its already in the network, people[0] follows people[1]
                        network.addFollowing(people[0], people[i]);
                        network.addFollowers(people[0], people[i]);

                    }else{ //if not add as a node and do the same
                        network.addNode(people[i]);
                        network.addFollowing(people[0], people[i]);
                        network.addFollowers(people[0], people[i]);
                    }
                }
            }

            reader.close();
            // reset the headnode for task 4
            if (firstName != null){
                network.headNode = network.findNode(firstName);
            }

            //tasks:
            //task 1:
            double density = dapper.density(network);
            System.out.println("The density of the graph is " + density);

            //task 2:
            String mostFollowers = dapper.mostFollowers(network);
            System.out.println("The person who has the most followers is " + mostFollowers);

            //task 3:
            String highestFollwoing = dapper.highestFollowing(network);
            System.out.println("The person who follows the highest number of people is " + highestFollwoing);

            //task 4:
            int degree2 = dapper.secDegreeRelation(network);
            System.out.println("the number of people at 2 degrees of separation of the first name in the file is " + degree2);

            //task 5:
            dapper.medianValue(network);

            //task 6:
            String person = dapper.mostInfluential(network);
            System.out.println("the most well connected person is " + person);

        } catch (IOException e){
            //handling IO exceptions (ex: file not found)
            e.printStackTrace();
        //ensure the reader is closed no matter what
        } finally {
            if (reader != null){
                try{
                    reader.close();
                } catch (IOException e) {
                    //if the file doesn't close
                    e.printStackTrace();
                } 
            }
        }
    }
}
