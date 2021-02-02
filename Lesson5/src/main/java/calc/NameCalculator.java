package calc;

import model.Client;

/////////////////
//    Task 4   //
/////////////////
public class NameCalculator implements Calculator<Client, String> {
    @Override
    public String getValue(Client element) {
        return element.getName();
    }

    @Override
    public int compare(String t1, String t2) {
        return t1.compareTo(t2);
    }
}
