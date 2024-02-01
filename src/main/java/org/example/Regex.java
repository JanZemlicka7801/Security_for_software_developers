package org.example;

public class Regex {
    public static void main(String[] args) {
        //match bob Bob mob Mob Rob rob
        String word1 = "[brmBRM]ob";
        //names followed by one or more numbers
        String word2 = "[brm]ob[0-9]+";
        //capital D followed by two zeros and 6 other numbers
        String word3 = "D00[0-9]{6}";
        //start with 42 followed by anything
        String word4 = "42.*";
        //optional - followed by one or more numbers followed by dot followed by one or more numbers
        String word5 = "-?[0-9]+(\\.[0-9]+)?";
        //starts with 08 and followed by 3 5 6 7 9 followed by any 7 numbers
        String word6 = "08[35679][0-9]{7}";
        //irish mobile improvement 00353 or +353
        String word7 = "((00|\\+)353|0)8[35679][0-9]{7}";
        //
        String word8 = "";
    }
}
