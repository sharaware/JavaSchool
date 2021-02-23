import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tasks {
    public static void main(String[] args) {
        //1.Создать лист из своих объектов (10-15 элементов в списке). Добавить, удалить и т.д.
        System.out.println("=============== Task 1 ================");
        List<Integer> powersOfTwo = new ArrayList<>();
        int pow = 1;
        for (int i = 0; i < 15; i++) {
            powersOfTwo.add(pow);
            pow *= 2;
        }
        System.out.println(powersOfTwo);
        Iterator<Integer> iterator = powersOfTwo.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() > 1024) {
                iterator.remove();
            }
        }
        System.out.println(powersOfTwo);
        System.out.println(Stream.iterate(0, i -> ++i)
                .limit(15)
                .map(i -> 1 << i)
                .collect(Collectors.toList()));
        System.out.println(Stream.iterate(0, i -> ++i)
                .map(i -> 1 << i)
                .takeWhile(i -> i <= 1024)
                .collect(Collectors.toList()));


        //2.Добавить дубли в список (1 - несколько раз один и тот же объект, 2 - дубль должен быть новым
        // объектом с теми же параметрами, что уже имеет один из существующих в списке)
        System.out.println("=============== Task 2 ================");
        ArrayList<NoEquals> neList = new ArrayList<>();
        NoEquals el1 = new NoEquals("val1");
        NoEquals el2 = new NoEquals("val1");
        neList.add(el1);
        neList.add(el1);
        neList.add(el2);
        System.out.println(neList);

        //3. Вывести список элементов в читабельном виде.
        //4. Создать неповторяющееся упорядоченное множество с использованием компаратора и перенести
        // значения из созданного листа.
        System.out.println("=============== Task 3-4 ================");
        neList.add(new NoEquals("val3"));
        neList.add(new NoEquals("some val"));
        Set<NoEquals> set = new TreeSet<>(new NoEqualsCompare());
        set.addAll(neList);
        System.out.println(set);

        //5. Обход дерева с помощью forEach и iterator (подсчет или конкатинация из объектов коллекции
        // используя условие, например "все начинаются с буквы", "больше какого-то значения")
        System.out.println("=============== Task 5 ================");
        Set<Book> books = getMyBooks();
        long cnt = 0;
        for (Book book : books) {
            if (book.getPageCount() > 300)
                cnt++;
        }
        System.out.println("В списке " + cnt + " книг, в которых больше 300 страниц");
        cnt = books.stream().filter(b -> b.getPageCount() > 300).count();
        System.out.println("В списке " + cnt + " книг, в которых больше 300 страниц");
        Iterator<Book> bookIterator = books.iterator();
        cnt = 0;
        while (bookIterator.hasNext()) {
            if (bookIterator.next().getAuthor().getName().startsWith("Л"))
                cnt++;
        }
        System.out.println("В списке " + cnt + " книг, имя автора которых начинается с буквы Л");
        cnt = books.stream().filter(b -> b.getAuthor().getName().startsWith("Л")).count();
        System.out.println("В списке " + cnt + " книг, имя автора которых начинается с буквы Л");

        //6. Удалить третий элемент из множества.
        System.out.println("=============== Task 6 ================");
        System.out.println("before:");
        for (Book book : books)
            System.out.println(book);
        bookIterator = books.iterator();
        if (books.size() >= 3) {
            bookIterator.next();
            bookIterator.next();
            bookIterator.next();
            bookIterator.remove();
        } else {
            System.out.println("Во множестве нет 3 елементов");
        }
        System.out.println("after:");
        for (Book book : books)
            System.out.println(book);

        //7. Из существующей коллекции объектов создать ассоциативную карту,
        // где ключ - объект, а значение - коллекция
        System.out.println("=============== Task 7 ================");
        Map<Author, ArrayList<Book>> bookMap = new HashMap<>();
        for (Book book : books) {
            Author author = book.getAuthor();
            if (!bookMap.containsKey(author)) {
                bookMap.put(author, new ArrayList<>());
            }
            bookMap.get(author).add(book);
        }
        System.out.println(bookMap);
        System.out.println(books.stream().collect(Collectors.groupingBy(Book::getAuthor)));


        //8. Из существующей карты создать другую, в которой ключ остается прежним,
        // а значение - вычисленное значение чего-либо из коллекции для ключа
        // (по нескольким вариантам значений)
        System.out.println("=============== Task 8 ================");
        Map<Author, Integer> pageCnt = new HashMap<>();
        for (Map.Entry<Author, ArrayList<Book>> entry : bookMap.entrySet()) {
            int sum = 0;
            for (Book book : entry.getValue()) {
                sum += book.getPageCount();
            }
            pageCnt.put(entry.getKey(), sum);
        }
        System.out.println(pageCnt);
        System.out.println(books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.summingInt(Book::getPageCount))));
    }

    static TreeSet<Book> getMyBooks() {
        TreeSet<Book> books = new TreeSet<>();
        Author leo = new Author("Лев", "Толстой");
        books.add(new Book(leo, "Война и мир", 1300));
        books.add(new Book(leo, "Анна Каренина", 800));
        Author ernest = new Author("Эрнест", "Хемингуэй");
        books.add(new Book(ernest, "По ком звонит колокол", 400));
        books.add(new Book(ernest, "Старик и море", 64));
        books.add(new Book(new Author("Антуан", "де Сент-Экзюпери"),
                "Маленький принц", 200));
        return books;
    }
}
