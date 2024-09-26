package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add("mango");
        str.add("guava");
        str.add("mango");
        str.add("guava");
        str.add("mango");
        str.add("guava");
        str.add("banana");
        str.add("banana");
        str.add("apple");
        str.add("apple");
        str.add("grapes");
        str.add("grapes");
        str.add("lichi");
        str.add("lichi");
        str.add("guava");
        HashMap<String,Integer> hm = new HashMap<>();

        for(int i=0;i< str.size();i++){
            if(hm.containsKey(str.get(i))) {
                hm.put(str.get(i),hm.get(str.get(i))+1);
            }
            else{
                hm.put(str.get(i),1);
            }
        }
        int max = 0;
        for(String key: hm.keySet()){
            int a = hm.get(key);
            if(a>max){
                max = a;
            }
        }
        for(String key: hm.keySet()){
            if(hm.get(key)== max){
                System.out.print(key);
            }
        }




    }
}