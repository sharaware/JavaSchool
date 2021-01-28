import model.ClientWithMoney;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class Lesson7 {
    static class Foo {
        private HashMap<Book, String> bookMap;
        public final Book myBook = new Book(new Author("Лев", "Толстой"), "Война и мир", 1300);
        protected static List<String> stringList;

        Foo() {
            bookMap = null;
        }

        Foo(String s) {
            bookMap = new HashMap<>();
            //stringList = new ArrayList<>();
            bookMap.put(myBook, s);
        }

        public List<String> getList() {
            return stringList;
        }

        public static void print(String... args){
            for (String arg : args) {
                System.out.println(arg);
            }
        }
    }
    public static void main(String[] args) {
        Foo foo = new Foo("book");

        ClientWithMoney client = new ClientWithMoney("me", 1, BigDecimal.valueOf(100));

        ClassPrinter.print(foo.getClass(), true);
        //ClassPrinter.print(client.getClass(), true);
    }
}
