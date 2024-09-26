package org.example;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;

public class test {

@BeforeEach
    void test() {
        HashMap<String, ArrayList<String>> result = ;

        assert result.size() == 13 : "Expected 13 groups of anagrams";

        assert result.containsKey("aeroplane") &&
                result.get("aeroplane").size() == 4 : "Expected";

    }



}
