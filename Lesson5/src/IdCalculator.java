/////////////////
//    Task 4   //
/////////////////
public class IdCalculator implements Calculator<FullClient, Integer> {

    @Override
    public Integer getValue(FullClient element) {
        return element.getId();
    }

    @Override
    public int compare(Integer t1, Integer t2) {
        return t1 - t2;
    }
}
