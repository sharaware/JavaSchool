import org.javaschool.lesson11.task1.MyResource;
import org.javaschool.lesson11.task1.MyThread;
import org.javaschool.lesson11.task2.Task2Thread;
import org.javaschool.lesson11.task3.ConsumerThread;
import org.javaschool.lesson11.task3.ProducerThread;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Task2
        Thread task2 = new Thread(new Task2Thread());
        task2.setName("Interrupted thread");
        task2.start();
        Thread.sleep(5000);
        task2.interrupt();

        //Task3
        Queue<Integer> queue = new LinkedList<>();
        Thread producer = new Thread(new ProducerThread(queue));
        Thread consumer = new Thread(new ConsumerThread(queue));

        producer.start();
        Thread.sleep(3000);
        consumer.start();
        Thread.sleep(30000);
        producer.interrupt();
        consumer.interrupt();

        //Task1
        MyResource resA = new MyResource("string A");
        MyResource resB = new MyResource("string B");
        Thread thread1 = new Thread(new MyThread(resA, resB));
        Thread thread2 = new Thread(new MyThread(resB, resA));
        //deadlock here
        thread1.start();
        thread2.start();
    }
}
