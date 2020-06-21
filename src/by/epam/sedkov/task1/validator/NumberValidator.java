package by.epam.sedkov.task1.validator;

public class NumberValidator {

    public static boolean isPrime(int number) {
        if (number > 0) {
            for (int j = 2; j < number - 1; j++) {
                if (number % j == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isFibonacciNumber(int number) {
        double resOne = 5 * Math.pow(number, 2) + 4;
        double resTwo = 5 * Math.pow(number, 2) - 4;
        boolean isOne = Math.sqrt(resOne) % 1 == 0;
        boolean isTwo = Math.sqrt(resTwo) % 1 == 0;
        return (isOne || isTwo);
    }

    public static boolean isDifferentThreeDigit(int number) {
        if (number / 100 > 1 && number / 1000 < 1) {
            int digitOne = number % 10;
            int digitTwo = number / 10 % 10;
            int digitThree = number / 100 % 10;
            return (digitOne != digitTwo) && (digitOne != digitThree) && (digitTwo != digitThree);
        } else {
            return false;
        }
    }

}
