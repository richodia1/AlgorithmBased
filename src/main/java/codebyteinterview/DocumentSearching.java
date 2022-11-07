package codebyteinterview;

public class DocumentSearching {



//["I am a man going to school going home", "I am a man going to school then going home",
//"This is a goat going home"]

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        String[] toTestDoc = {"I am going going a man going to school going home", "I am a man going to school then going going home"};
        int result = index(toTestDoc, "going");
//"This is a goat going home"]

        System.out.println("The result index is : "+result);
    }
    static int index(String[] document, String word){
        // Srearch by worlds
        if(document == null){
            return -1;
        }
        int maxCount = 0;
        int indexOfFreq = 0;
        for(int i = 0; i < document.length; i++){
            int result = searchIfWordFound(document[i],word);
            if(result > maxCount){
                maxCount = result;
                indexOfFreq = i;
            }
        }
        return indexOfFreq;
    }
    static int searchIfWordFound(String sentence, String word){
        String[] words = sentence.split(" ");
        int count = 0;
        for(int i = 0; i < words.length; i++){

            if(words[i].equals(word)){

                count +=1;
            }
        }
        return count;
    }
}
