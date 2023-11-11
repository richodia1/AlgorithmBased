package codility;
import java.io.*;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class ContactsSolution {
    public static void main(String[] args) throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        for (int i = 0; i < queriesRows; i++) {
            queries.add(Arrays.asList(bufferedReader.readLine().trim().split(" ")));
        }

        List<Integer> result = contacts(queries);


    }
    public static List<Integer> contacts(List<List<String>> queries) {
        List<Integer> result = new ArrayList<>();
        Contacts contactsTrie = new Contacts();

        for (List<String> query : queries) {
            String operation = query.get(0);
            String name = query.get(1);

            if (operation.equals("add")) {
                contactsTrie.addContact(name);
            } else if (operation.equals("find")) {
                result.add(contactsTrie.findPartial(name));
            }
        }

        return result;
    }
    static class Contacts {
        private TrieNode root;
        public Contacts(){
            this.root = new TrieNode();
        }
        public int findPartial(String partial){
            TrieNode node = root;
            for(char c : partial.toCharArray()){
                if(!node.children.containsKey(c))
                    return 0;
                node = node.children.get(c);
            }
            return node.count;
        }
        public  void addContact(String name){
            TrieNode node = root;
            for(char c : name.toCharArray()){
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
                node.count++;
            }
            node.isEndOfWord = true;
        }
    }
   static class TrieNode{
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        int count;
        public TrieNode(){
            this.children = new HashMap<>();
            this.isEndOfWord = false;
            this.count = 0;
        }
    }
}







