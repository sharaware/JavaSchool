import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lesson5 {
    public static void main(String[] args) {
        /////////////////
        //    Task 1   //
        /////////////////
        System.out.println("=============== Task 1 ================");
        List<Client> clients = new ArrayList<>();
        clients.add(new ClientWithMoney("Elon Musk", 123, BigDecimal.valueOf(1000000000.01)));
        clients.add(new Client("Socrates"));
        clients.add(new FullClient("Adam", 1));

        List<FullClient> fullClients = new ArrayList<>();
        List<ClientWithMoney> richClients = new ArrayList<>();
        new Lesson5().noMoneyPlease(fullClients);
        //error
        //new Lesson5().noMoneyPlease(richClients);
        new Lesson5().noMoneyPlease(clients);
        System.out.println("clients:");
        new Lesson5().printClients(clients);
        System.out.println("Full clients:");
        new Lesson5().printClients(fullClients);

        /////////////////
        //    Task 2   //
        /////////////////

        System.out.println("=============== Task 2 ================");
        Something<String> some1 = new Something<>("Hello, generic!");
        Something<Collection<Client>> some2 = new Something<>(clients);
        new Lesson5().someInfo(some1);
        new Lesson5().someInfo(some2);

        /////////////////
        //    Task 4   //
        /////////////////
        System.out.println("=============== Task 4 ================");
        fullClients.add(new FullClient("Adam", 1));
        fullClients.add(new FullClient("Satan", 666));
        fullClients.add(new FullClient("Trinity", 3));
        int max = new IdCalculator().max(fullClients);
        System.out.println("Max id = " + max);
        System.out.println("Max name = " + new NameCalculator().max(fullClients));
        System.out.println("Sorted by ID:");
        for(FullClient client : new IdCalculator().sort(fullClients)) {
            System.out.println("ID = " + client.getId() + " name: " + client.getName());
        }
        System.out.println("Sorted by name:");
        for(Client client : new NameCalculator().sort(fullClients)) {
            System.out.println("Name: " + client.getName());
        }
    }

    public void printClients(Collection<? extends Client> clients) {
        for (Client client: clients) {
            System.out.println(client.getName());
        }
    }

    public void noMoneyPlease(Collection<? super FullClient> clients) {
        clients.add(new FullClient("Eva", 2));
    }

    public <T> void someInfo(Something<T> something) {
        System.out.println("Value class is " + something.getValue().getClass().getName());
    }
}
