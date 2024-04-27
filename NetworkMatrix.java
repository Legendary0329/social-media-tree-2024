import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NetworkMatrix{
    private String[] followers;
    private String[][] network;
    String[] people = new String[1000];
    String[] node = new String[1000];
    private int numPeople = 0;

    public String[][] inPutFile (String filename) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            //counts how many people are in the network
            while ((line = reader.readLine()) != null) {
                numPeople++;
            }
            network = new String[numPeople][numPeople];
            node = new []

        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            //counts how many people are in the network
            while ((line = reader.readLine()) != null) {
                people = line.split("\\s+");
                node[numPeople]=
            }
        }



            //counts a person into array when encounter a space character of EACH LINE!
            people = line.split("\\s+");
            //store the first name of each line as a node
            node[numPeople] = people[0];
            network[0][numPeople] = people[0];

            for (int row=0; row<numPeople; row++){
                for (int col=0; col<numPeople; col++){
                    if (people[row].equals(node[row])){
                        //rows as who they are following
                        //cols as who are their followers
                        network[row+1][col] = "1";
                    } else {                        
                        network[row+1][col] = "0";
                    }
                }
            }
        }
        return network;
    }
}