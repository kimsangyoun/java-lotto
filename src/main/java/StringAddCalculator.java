import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 역할 : 문자열을 덧셈해주는 객체..
 */
public class StringAddCalculator {

    private static final String SPLIT_TEXT_REGX = ",|:";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    private StringAddCalculator() {

    }

    public static int splitAndSum(String parameter) {
        int result = 0;

        if(validate(parameter)) {
            return 0;
        }

        String[] paramArray = splitText(parameter);

        for (int i = 0; i < paramArray.length; i++) {
            result = calculate(result , Integer.parseInt(paramArray[i]));
        }
        return result;
    }

    public static String[] splitText(String text) {
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return tokens;
        }
        return text.split(SPLIT_TEXT_REGX);
    }

    public static int calculate(int currNum, int otherNum) {
        if (otherNum < 0) {
            throw new RuntimeException();
        }
        return currNum + otherNum;
    }

    public static boolean validate(String parameter) {

        if (parameter == null || parameter.isEmpty()) {
            return false;
        }
        return true;
    }
}
