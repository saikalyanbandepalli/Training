package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str1 = new String("good morning every one");
        HashMap<String,Integer> hm = new HashMap<>();
        String str2[] = str1.split(" ");
        for(int i=0;i<str2.length;i++){
            String strr = str2[i];
            int l = strr.length();
            hm.put(str2[i],l);
        }
        for(Map.Entry<String,Integer> hms:hm.entrySet()){
            System.out.println(hms.getKey()+" "+hms.getValue());
        }

    }
}