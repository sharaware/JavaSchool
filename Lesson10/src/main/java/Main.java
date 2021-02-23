import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.iterate(new BigInteger[]{BigInteger.ONE, BigInteger.ONE}, b -> new BigInteger[]{b[1], b[0].add(b[1])})
                .limit(100).map(b -> b[0]).forEach(System.out::println);

        long start = System.currentTimeMillis();
        int res = IntStream.range(1, 1000000).mapToObj(BigInteger.TWO::pow).parallel().mapToInt(BigInteger::bitLength).sum();
        long finish = System.currentTimeMillis();
        System.out.println("parallel = " + (finish - start));

        start = System.currentTimeMillis();
        res = IntStream.range(1, 1000000).mapToObj(BigInteger.TWO::pow).mapToInt(BigInteger::bitLength).sum();
        finish = System.currentTimeMillis();
        System.out.println("non parallel = " + (finish - start));
    }
}
