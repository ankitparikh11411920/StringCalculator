public class StringCalculator {
    static int calledCount = 0;

    public int add(String s) {
        calledCount++;
        if (s.isEmpty()) {
            return 0;
        }
        if (s.startsWith("//")) {
            char delimeter = s.charAt(2);
            String value = s.substring(4);
            String[] numbers = value.split(String.valueOf(delimeter));
            return sum(numbers);
        }
        if (s.contains(",") || s.contains("\n")) {
            s = s.replaceAll("\n", ",");
            String[] numbers = s.split(",");
            return sum(numbers);

        }
        return Integer.parseInt(s);
    }

    int getCalledCount() {
        return calledCount;
    }

    int sum(String[] array) {
        int sum = 0;
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