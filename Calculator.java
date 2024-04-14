package Try;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }
    public static String parse(String expression) throws Exception {
        String sign;
        String result;
        int a;
        int b;
        boolean isRoman;
        String[] input = expression.split("[+\\-*/]");
        if (input.length != 2) throw new Exception();
        sign = check(expression);
        if (sign == null) throw new Exception();
        if (Roman.isRoman(input[0]) && Roman.isRoman(input[1])) {
            a = Roman.romanToArabian(input[0]);
            b = Roman.romanToArabian(input[1]);
            isRoman = true;
        }
        else if (!Roman.isRoman(input[0]) && !Roman.isRoman(input[1])) {
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            isRoman = false;
        }
        else {
            throw new Exception();
        }
        if (a > 10 || b > 10) {
            throw new Exception();
        }
        int arabian = calc(a, b, sign);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception();
            }
            result = Roman.arabToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }
    static String check(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }
    static int calc(int a, int b, String sign) {
        return switch (sign) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}
class Roman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String find) {
        for (int i = 0; i < romanArray.length; i++) {
            if (find.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int romanToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String arabToRoman(int arabian) {
        return romanArray[arabian];
    }

}