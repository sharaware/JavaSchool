# JavaSchool
## Lesson1
Задачи:
1.	Напишите программу, которая выводит строку «Hello World!»  в консоль.
2.	В переменных a и b хранятся два натуральных числа. Напишите программу, выводящую на экран результат деления a на b с остатком.
Пример работы программы (a = 21, b = 8): « 21 / 8 = 2 и 5 в остатке »
3.	Напишите программу, которая вычислит простые числа в пределах от 2 до 100.
4.	Выведите на экран первые n членов последовательности Фибоначчи, где n запрашивается у пользователя посредством консоли (2 < n < 100).
5.	Напишите программу, которая объявляет массив целых чисел (10-20 чисел) и реализует алгоритм сортировки заданного массива (на ваш выбор).
## Lesson2
Задача:
Реализовать программу консольную оболочку Shell
1) Программа предоставляет набор команд. Команды вводятся с консоли. time, date, exit.
2) Каждая команда реализуется классом имплементирующим интерфейс Command.
3) Интерфейс должен описывать методы для получения имени и исполнения команды.

4) Для чтения с консоли пользуемся классом Scanner: 
`Scanner in = new Scanner(System.in);`
    nextLine(): считывает всю введенную строку


5) Для работы с датой/временем исследуем класс LocalDateTime: 
https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html

6) Интерфейс Command может определять вызов двух методов:

    getName() – возвращает имя команды. 
    
    execute()  - выполнение команды.

На старте в программе инициализируется массив с набором команд, которые может исполнять программа Shell.

## Lesson3
Дописать реализацию метода get (получение объекта), разобраться с приведением типа к/от Object.

Кусок кода с лекции:
```
package ru.sbrf.demo;

/*
  root
    |
    +-------+      +-----+     
    | data  |      | data|     
    | next  |--->  | next| --> null
    +-------+      +-----+     
 */

class Node {
    public Node(Object data) {
        this.data = data;
    }
    Object data;
    Node next;
}

public class LList {
    private Node root;

    public void add(Object item) {
        Node tmpItem = new Node(item);
        Node lastItem = findLast();

        if (lastItem != null) {
            lastItem.next = tmpItem;
        } else {
            root = tmpItem;
        }
    }

    public Object get(int id) {
        // TODO
        return null;
    }

    public int size() {
        int size = 0;

        if (root == null)
            return 0;
        else {
            size = 1;

            Node current = root;
            while (current.next != null) {
                size++;
                current = current.next;
            }
        }

        return size;
    }


    Node findLast() {
        if (root == null)
            return null;
        else {
            Node current = root;

            while (current.next != null) {
                current = current.next;
            }

            return current;
        }
    }
}
```

## Lesson4
Домашнее задание
1. Создать лист из своих объектов (10-15 элементов в списке). Добавить, удалить и т.д.
2. Добавить дубли в список (1 - несколько раз один и тот же объект, 2 - дубль должен быть новым объектом с теми же параметрами, что уже имеет один из существующих в списке)
3. Вывести список элементов в читабельном виде.
4. Создать неповторяющееся упорядоченное множество с использованием компаратора и перенести значения из созданного листа. 
5. Обход дерева с помощью forEach и iterator (подсчет или конкатинация из объектов коллекции используя условие, например "все начинаются с буквы", "больше какого-то значения")
6. Удалить третий элемент из множества.
7. Из существующей коллекции объектов создать ассоциативную карту, где ключ - объект, а значение - коллекция
8. Из существующей карты создать другую, в которой ключ остается прежним, а значение - вычисленное значение чего-либо из коллекции для ключа (по нескольким вариантам значений)


## Lesson5
Домашнее задание
1.	Создать класс model.Client, у которого будет поле имя. Создать класса model.Client, в котором должны быть все поля и свойства model.Client, а так же реализован идентификатор клиента. На основе класса с идентификатором создать потомка с реализацией сколько потратил.  В отдельном классе создать метод, которые будут принимать коллекции, элементами которой могут быть классы, которые содержат данные о клиенте (т.е. как минимум предыдущие три класса).  Создать метод, который принимает коллекцию, элементы которой могут быть только model.Client и созданный ранее класс с идентификатором.
2.	Создать интерфейс или класс с обобщенным(и) типом(типами) - имя придумать самостоятельно.
3.	Добавить методы в интерфейс. Например, max, sort, middle и т.д., которые будут принимать коллекцию с обобщенным типом интерфейса..
4.	Имплементировать интерфейс - создать несколько классов, которые реализуют методы интерфейса. Один ищет клиента с максимальным количеством букв в имени, и сортирует в выбранном вами порядке по имени и т.д. Другой ищет, кто больше всех потратил, сортирует, ищет среднее потраченное всеми клиентами и т.д. В отдельном классе вызвать реализованные методы с выводом результата.
5.	Переписать код из предыдущего урока, так что бы все реализации вычислений - среднего, максимального и т.д. были реализованы в обобщенных классах. Должен быть единый интерфейс, но при этом, для каждого вычисления отдельный класс. В отдельном классе вызвать реализованные методы с выводом результата.


## Lesson6
Домашнее задание
1. Создать свой класс исключение, наследник Exception
Реализовать два поля: code, description, инициализация в конструкторе
   * code целочисленное, при создании инициализировать любое произвольное число
   * description строка, предназначено для описания бизнес ошибки, при создании инициализировать либым значением,
   * В конструкторе реализовать вызов родительского конструктора с аргументом message, т.е. у вас один конструктор с тремя параметрами
2. В коде из предыдущего задания, на ваше усмотрение сдалть проверку и бросать исключение
3. В качестве обработки исключения вывести в System.out code, description, message, после вызвать printStackTrace
4. В одном из методов бросать unchecked исключение, например IllegalArgumentException
5. Запустить приложение с заведомо ошибочным алгоритмом, т.е. что бы при вызове метода, который бросает ваше исключение, было брошено и обработано, после вызов метода, который генерирует unchecked исключение, запустить программу


## Lesson7
Написать консольное приложение которое будет выводить в консоль всю информацию о ваших классах и полях
что нужно
- по возможности взять все классы, которые были у вас написаны до текущего задания
- создать экземпляры для каждого из них (можно скопировать из предыдущих работ так же)
- реализовать метод(ы) которые бы на вход получали некий Object и выводили в консоль абсолютно всю информацию о данном объекте используя Reflection API:
   - дерево классов наследников, если есть, иначе ничего не выводить
   - список реализуемых интерфейсов
   - список конструкторов с параметрами
   - список всех полей, в том числе приватных, включая их тип
   - список всех методов
   - если поле класса является не примитивным, а например любой другой произвольный класс, то по нему так же необходимо вывести всю информацию, если это коллекция то достаточно просто вывести имя коллекции и Generic, то же самое и для методов

пример
class ru.sber.pt.SomeClass
```
--- parents:
--- ru.sber.pt.ParentClass
--- interfaces:
---- ru.sber.pt.SomeInterface
---- fields:
---- fieldName: value java.lang.String
---- fieldNames: java.util.List<String>
```

и все в таком же духе

## Lesson8

Задание: создать мультимодульный проект на Maven/Gradle, на ваше усмотрение, со всеми
сделанными на данный момент ДЗ. Последующие задания также желательно добавлять туда.

## Lesson9
Домашнее задание по сегодняшнему занятию в файле readme в репозитории https://github.com/JavaSchool2020/topic10-testing. Там же код для домашнего задания

Модуль testing-example - примеры тестов, которые разбирали на занятии.  
Модуль homework - домашнее задание

### Домашнее задание:
+ Logging
1. В классах StudentPrinter и NumberOfStudentsPrinter дописать методы и добавить логирование (описание нужного функционала и уровня логирования указано в TODO)
2. Настроить логирование (файл конфигурации) так, чтобы в файл лога student.log попадали только логи класса StudentPrinter, при этом должны писаться только логи уровня info и выше (info, warn,error, fatal)
3. Настроить логирование (файл конфигурации) так, чтобы в файл лога numberOfStudent.log попадали только логи класса NumberOfStudentsPrinter, при этом должны писаться только логи уровня info и ниже (info, debug,trace)  
   Для 2 и 3 задания изменения в сами классы вносить нельзя

+ Testing  
  Для класса RemoteFileHandler написать тесты для методов handleRequest, handleResponse, handleError. Необходимо проверить все значимые кейсы. Покрытие для методов должно быть 100%.  
  Обратите внимание на другие классы в пакете. Их реальные методы вызываться не должны
  
## Lesson10

Задание:
1. Сделать рефакторинг существующего кода коллекций (из предыдущих заданий) с итерациями на потоки.
2. Проверить работу stream с parallel() - ускорится ли обработка?
3. Заменить Comparator на функциональный интерфейс.
4. Заменить, где целесообразно на лямбда.