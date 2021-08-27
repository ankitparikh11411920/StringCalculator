import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static int calledCount = 0;

    public int add(String s) {
        calledCount++;
        if (s.isEmpty()) {
            return 0;
        }
        if (s.startsWith("//")) {
            String value;
            if (s.contains("[") && s.contains("]")) {
                List<String> delimeters = new ArrayList<>();
                Pattern pattern = Pattern.compile("\\[(.*?)]");
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    delimeters.add(matcher.group(1));
                }
                int last_index = s.lastIndexOf("]");
                value = s.substring(last_index + 2);
                for (String delimeter : delimeters) {
                    value = value.replace(delimeter, ",");
                }
            } else {
                value = s.substring(4);
                value = value.replace(String.valueOf(s.charAt(2)), ",");
            }
            return sum(value);
        }
        if (s.contains(",") || s.contains("\n")) {
            s = s.replace("\n", ",");
            return sum(s);
        }
        return Integer.parseInt(s);
    }

    int getCalledCount() {
        return calledCount;
    }

    //helper function to make code more readable
    int sum(String numbers) {
        int sum = 0;
        String[] array = numbers.split(",");
        for (String number : array) {
            if (Integer.parseInt(number) <= 1000) {
                try {
                    if (Integer.parseInt(number) < 0) {
                        throw new InvalidNumberException(array);
                    } else {
                        sum += Integer.parseInt(number);
                    }
                } catch (InvalidNumberException exc) {
                    return 0;
                }
            }
        }
        return sum;
    }
}

class InvalidNumberException extends Exception {
    InvalidNumberException(String[] numbers) {
        System.out.println("negatives not allowed");
        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                System.out.println(number);
            }
        }
    }
}