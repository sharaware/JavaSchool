public class Task3 {
    public static void main(String[] args) {
        int size = 100;
        int[] arr = new int[size];
        arr[0] = 1; arr[1] = 1;
        for(int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) {
                for(int j = 1; j <= (arr.length/i - (arr.length%i == 0 ? 1 : 0)); j++){
                    arr[i * j] = j == 1 ? 1 : -1;
                }
            }
        }
        int nl = 0;
        for (int i = 2; i < arr.length; i++) {
            if(arr[i] == 1) {
                System.out.print(i + "\t");
                nl++;
                if(nl%20 == 0)
                    System.out.println();
            }
        }
    }
}
