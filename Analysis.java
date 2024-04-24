import java.io.*;

public class Analysis{
    private String[][] network;

    public static void main (String[] args){
        //collects the input of filename
        String filename = args[0];
        BufferedReader reader = null;

        //use try to catch some potential exceptions
        try{
            //create fileReader object to open file
            FileReader filereader = new FileReader(filename);
            // create a bufferedreader to read from filereader
            reader = new BufferedReader(filereader);
            String line = reader.readLine();
            int numPerson=0;

            while (line!=null){
                for (int i=0; i< line.length(); i++){
                    char c =  line.charAt(i);
                    if (c == ' '){
                        numPerson++;
                    }
                }
                line = reader.readLine(); //read the next line       
            }
        } catch (IOException e){
            //handle IO exceptions (file not found)
            e.printStackTrace();
        
        } finally {//code to be always executed
            try{
                //close the bufferedreader
                if (reader != null){
                    reader.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
