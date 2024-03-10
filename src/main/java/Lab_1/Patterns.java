package Lab_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Patterns {
    /**
     * Checks if the input string contains only alphabetical characters (both uppercase and lowercase).
     *
     * @param word The input string to be checked.
     * @return true if the input string contains only alphabetical characters, false otherwise.
     */
    public static boolean word(String word) {
        String questionPattern = "[a-zA-Z]+";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    /**
     * Checks if the input string is a binary number (contains only '0' and '1' characters).
     *
     * @param word The input string to be checked.
     * @return true if the input string is a binary number, false otherwise.
     */
    public static boolean binaryNumber(String word){
        String questionPattern = "[01]+";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    /**
     * Checks if the input string represents either "Saturday" or "Sunday".
     *
     * @param word The input string to be checked.
     * @return true if the input string represents "Saturday" or "Sunday", false otherwise.
     */
    public static boolean saturdaySunday(String word){
        String questionPattern = "S(un|atur)day";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    /**
     * Checks if the input string follows the pattern "[Dd]00[0-9]{6}".
     *
     * @param word The input string to be checked.
     * @return true if the input string follows the specified pattern, false otherwise.
     */
    public static boolean dNumber(String word){
        String questionPattern = "[Dd]00[0-9]{6}";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    /**
     * Checks if the input string matches the pattern of a valid email address.
     *
     * @param word The input string to be checked.
     * @return true if the input string is a valid email address, false otherwise.
     */
    public static boolean emailAddress(String word){
        String questionPattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    /**
     * Checks if the input string meets the criteria for a strong password.
     * It should contain at least one uppercase letter, one lowercase letter, one digit,
     * and one special character, with a total length of 12 characters.
     *
     * @param word The input string to be checked.
     * @return true if the input string is a strong password, false otherwise.
     */
    public static boolean password(String word){
        String questionPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{12}$";

        Pattern pattern = Pattern.compile(questionPattern);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }
}