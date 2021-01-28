public class Something<T> {
    protected T val;

    public Something(T val) {
        this.val = val;
    }

    public T getValue() {
        return val;
    }
}
