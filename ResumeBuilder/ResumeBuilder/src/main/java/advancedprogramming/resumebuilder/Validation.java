package advancedprogramming.resumebuilder;

import java.util.regex.Pattern;

/**
 *
 * @author tkex_
 */
public class Validation {

    public static boolean stringValidation(String in) {
        return Pattern.matches("[a-zA-Z ]+", in);
    }

    public static boolean numberValidation(String num) {
        return Pattern.matches("05\\d{8}", num);
    }

    public static boolean emailValidation(String email) {
        return Pattern.matches("[a-zA-Z_.-]+@([a-zA-Z.]{5,15})+[a-zA-Z]{2,5}", email);
    }

    public static boolean addressValidation(String address) {
        return Pattern.matches("[a-zA-Z0-9_,. -]+", address);
    }

}
