import java.io.*;

public class Analysis{
    public static void main (String[] args){
        //collects the input of filename
        String filename = args[0];
        BufferedReader reader = null;

        try{
            //create fileReader object to open file
            FileReader filereader = new FileReader(filename);
            // create a bufferedreader to read from filereader
            reader = new BufferedReader(filereader);
            String line;

            while ((line = reader.readLine()) != null){

            } 
        } catch (IOException e){
            //handle IO exceptions
            e.printStackTrace();
        } finally {
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
