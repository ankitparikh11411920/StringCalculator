public class StringCalculator {

    public int add(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        if(s.startsWith("//")){
            char delimeter = s.charAt(2);
            String value = s.substring(4);
            String[] arr = value.split(String.valueOf(delimeter));
            int sum = 0;
            for(String number : arr){
                sum += Integer.parseInt(number);
            }
            return sum;
        }
        if(s.contains(",") ||  s.contains("\n")){
            s = s.replaceAll("\n",",");
            String[] numbers = s.split(",");
            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
            return sum;
        }
        return Integer.parseInt(s);
    }
}
