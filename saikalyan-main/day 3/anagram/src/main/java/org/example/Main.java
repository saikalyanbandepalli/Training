package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
HashMap<String, ArrayList<String>> methods(String[] arr){
    HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (String s : arr) {
String str = s.toLowerCase();
char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
String str2 = new String(sorted);
            if (!hm.containsKey(str2)) {
        hm.put(str2, new ArrayList<String>());
        }
        hm.get(str2).add(s);
        }


        }


public class Main {
    public static void main(String[] args) {
        String arr[] = new String[]{
                "Aeroplane", "z900", "stop", "WomanHitler", "SpaceX", "onedummy",
                "ElevenPlusTwo", "erapolnea", "xscpae", "TwelvePlusOne", "tops",
                "earanploa", "xaspec", "Funeral", "motherinlaw", "pots", "realfun",
                "dmeyneou", "enaroeapl", "90z0", "post", "dummyone"
        };

        HashMap<String, ArrayList<String>> hms = methods(arr);
        System.out.println("One string from each anagram group:");
        for (ArrayList<String> group : hms.values()) {
            if (group.size() > 1) {
                System.out.println(group.get(0));
            }
        }

    }
}
