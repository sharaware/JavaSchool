package calc;

import java.util.*;

/////////////////
//  Task 2,3   //
/////////////////

public interface Calculator<T, V> {
    default V max(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            return null;
        }
        V maxVal = null;
        for (T next : collection) {
            if (maxVal == null || compare(getValue(next), maxVal) > 0) {
                maxVal = getValue(next);
            }
        }
        return maxVal;
    }

    default List<T> sort(Collection<? extends T> collection) {
        List<T> list = new ArrayList<>(collection);
        list.sort((a,b) -> compare(getValue(a), getValue(b)));
        return list;
    }

    V getValue(T element);

    int compare(V t1, V t2);
}
