import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class QuasiShell {
    public static void main(String[] args) {
        Command[] commands = {new Exit(), new Date(), new Time()};
        Scanner scanner = new Scanner(System.in);
        input: while(true){
            System.out.print("> ");
            String s = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(s);
            String cmd = st.nextToken();
            for (Command command : commands) {
                if (cmd.equals(command.getName())) {
                    command.execute();
                    continue input;
                }
            }
            System.out.println("Unknown command " + cmd + " supported only date, time, exit. Commands case-sensitive");
        }
    }
}

interface Command {
    String getName();
    void execute();
}

class Exit implements Command {

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}

class DateTime {
    protected static LocalDateTime getDateTime(){
        return LocalDateTime.now();
    }
}

class Date extends DateTime implements Command {
    @Override
    public String getName() {
        return "date";
    }

    @Override
    public void execute() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(getDateTime().toLocalDate().format(formatter));
    }
}

class Time extends DateTime implements Command {
    @Override
    public String getName() {
        return "time";
    }

    @Override
    public void execute() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(getDateTime().toLocalTime().format(formatter));
    }
}