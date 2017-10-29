package com.epam.jf.dementyev.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово, состоящие из символов английского алфавита.
 * Необходимо найти слово, в котором число различных символов минимально.
 *
 * Символы верхнего и нижнего регистра считать различными.
 * Если таких слов несколько, найти первое из них.
 *
 * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
 * Наиболее эффективное с точки зрения скорости и потребляемой памяти решение - реализация с использованием битовых операций.
 * Желающие могут попробовать придумать, как их можно применить в этой задаче.
 */
public class Task4 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            int index = 0;
            int min = GetCountOfDifferentSymbol(args[0]);
            for (int i = 1; i < args.length; i++) {
                int count = GetCountOfDifferentSymbol(args[i]);
                if (count < min) {
                    min = count;
                    index = i;
                }
            }
            System.out.println(args[index]);
        }
    }

    private static int GetCountOfDifferentSymbol(String word) {
        int uppercase = 0;
        int lowercase = 0;
        for (char c: word.toCharArray()) {
            if (c >= 'A' && c <= 'Z')
                uppercase |= 1 << (c - 'A');
            else if (c >= 'a' && c <= 'z')
                lowercase |= 1 << (c - 'a');
        }
        return bitCounter(uppercase) + bitCounter(lowercase);
    }

    private static int bitCounter(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}