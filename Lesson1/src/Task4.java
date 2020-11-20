import java.math.BigInteger;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько чисел Фибоначчи выводить?");
        int fibCnt;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Введите целое число");
                scanner.next();
            }
            fibCnt = scanner.nextInt();
            if (fibCnt < 1) {
                System.out.println("Число должно быть больше или равно 1");
            }
        } while (fibCnt < 1);

        BigInteger n1 = new BigInteger("1");//100 чисел из условия не влезают в long
        BigInteger n2 = new BigInteger("1");
        BigInteger tmp;
        System.out.println(n1);
        if(fibCnt == 1) {
            return;
        }
        System.out.println(n2);
        if(fibCnt == 2) {
            return;
        }
        for(int i = 3; i <= fibCnt; i++) {
            tmp = n2;
            n2 = n2.add(n1);
            n1 = tmp;
            System.out.println(n2);
        }
    }
}
