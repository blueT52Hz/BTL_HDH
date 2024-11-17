import java.util.*;

public class LRUMap {
    public static void main(String[] args) {
        int n = 10;
        int frameSize = 4;
        Scanner sc = new Scanner(System.in);
        int[] a = new int[n];
        for (int i=0;i<n;++i) {
            a[i] = sc.nextInt();
        }
        Map<Integer, Integer> counter = new TreeMap<>();
        ArrayList<Integer> frame = new ArrayList<>();
        for (int i=0;i<n;++i) {
            if(frame.contains(a[i])) {
                counter.put(a[i], i);
            } else {
                if (frame.size()<frameSize) {
                    frame.add(a[i]);
                    counter.put(a[i], i);
                } else {
                    ArrayList<Integer> frameCopy = (ArrayList<Integer>) frame.clone();
                    Collections.sort(frameCopy, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer a, Integer b) {
                            return counter.get(a).compareTo(counter.get(b));
                        }
                    });
                    frame.set(frame.indexOf(frameCopy.getFirst()), a[i]);
                    counter.put(a[i], i);
                }
            }
            System.out.printf("Thêm trang %d: ", a[i]);
            for (Integer page : frame) System.out.print(page + " ");
            for (int ii = 0; ii<frameSize-frame.size();++ii) System.out.print("- ");
            System.out.println();
        }
    }
}
