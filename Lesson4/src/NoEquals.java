import java.util.Comparator;

public class NoEquals {
    public String val;
    public NoEquals(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "NoEquals{" +
                "val='" + val + '\'' +
                '}';
    }
}

class NoEqualsCompare implements Comparator<NoEquals> {

    @Override
    public int compare(NoEquals o1, NoEquals o2) {
        return o1.val.compareTo(o2.val);
    }
}