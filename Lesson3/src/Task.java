public class Task {
    public static void main(String[] args) {
        LList list = new LList();
        list.add("one");
        list.add(2);
        list.add(3.14);
        Person son = new Person("Jesus", 33);
        list.add(son);

        for (int i = list.size() - 1; i >= 0 ; i--) {
            System.out.println(list.get(i));
        }

        //cast to type
        Person ret = (Person) list.get(3);
        System.out.println("Name: " + ret.name + ", age: " + ret.age);

        list.get(50);
    }
}

class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String  toString() {
        return name + " was " + age;
    }
}