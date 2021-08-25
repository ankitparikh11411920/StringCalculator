public class StringCalculator {

    public int add(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        if(s.startsWith("//")){
            char delimeter = s.charAt(2);
            String value = s.substring(4);
            String[] numbers = value.split(String.valueOf(delimeter));
            return sum(numbers);
        }
        if(s.contains(",") ||  s.contains("\n")){
            s = s.replaceAll("\n",",");
            String[] numbers = s.split(",");
            return sum(numbers);

        }
        return Integer.parseInt(s);
    }
    int sum(String[] array){
        int sum = 0;
        for(String number : array){
            try{
                if(Integer.parseInt(number) < 0){
                    throw new InvalidNumberException(number);
                }else{
                    sum += Integer.parseInt(number);
                }
            }catch(InvalidNumberException exc){
                return 0;
            }
        }
        return sum;
    }
}
class InvalidNumberException extends Exception{
    InvalidNumberException(String number){
        System.out.println("negatives not allowed");
        System.out.println(number);
    }
}