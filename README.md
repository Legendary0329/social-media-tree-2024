# SOCIAL-NETWORK PROJECT #
This program allows user to input a text file with a list of names and build a network tree with the names provided.

The STRUCTURE of the text file SHOULD BE the following (or check the test text files): david lewis javier harry 

Each line in the text file represents a person and the people they follow. Specifically, the first name on each line is a person in the network and any remaining names on the line are the people in the network whom they follow (you may assume no person follows themselves). therefore, in the example file: david follows lewis, javier and harry.

This program gives you the density of the graph; the person who has the most followers; the person who follows the most people; the number of people at 2 degree separation of the first name in the file; the average of the number of followers each person in the network has; and the person who is most well connected.

To compile this set of code, download the zip. this file will contain some test text files and its corresponding answer files along with 4 different java files containing the program.

As this project is programmed in java, to compile the program type "javac *.java" in your terminal/shell and to run the executable type "java Analysis (your text file)" in your termianl.
For example: "java Analysis plain.txt", the output of different task will be printed on your terminal.  
