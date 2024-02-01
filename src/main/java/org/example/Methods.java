package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Methods {
    public boolean question1(String word) {
        String questionPattern = "[a-zA-Z]+";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    public boolean question2(String word){
        String questionPattern = "[01]+";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    public boolean question3(String word){
        String questionPattern = "S(un|atur)day";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    public boolean question4(String word){
        String questionPattern = "D00[0-9]{6}";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    public boolean question5(String word){
        String questionPattern = "08[35679][0-9]{7}";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    //password needs to have at least
    //capital letters, lowercase letters, numbers and special character
    //of the 12 characters length
    public boolean question6(String word){
        String questionPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{12}$";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    //valid email address
    public boolean question7(String word){
        String questionPattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }
}