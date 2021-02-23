package calc;

import java.util.*;

/////////////////
//  Task 2,3   //
/////////////////

public interface Calculator<T, V> {
    default V max(Collection<? extends T> collection) {
        Optional<? extends T> res = collection.stream().max((a,b) -> compare(getValue(a), getValue(b)));
        return res.map(this::getValue).orElse(null);
    }

    default List<T> sort(Collection<? extends T> collection) {
        List<T> list = new ArrayList<>(collection);
        list.sort((a,b) -> compare(getValue(a), getValue(b)));
        return list;
    }

    V getValue(T element);

    int compare(V t1, V t2);
}
