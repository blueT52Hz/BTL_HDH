import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LRUQueue {
    public static void main(String[] args) {
        int n = 10;
        int frameSize = 4;
        Scanner sc = new Scanner(System.in);
        int[] a = new int[n];
        for (int i=0;i<n;++i) {
            a[i] = sc.nextInt();
        }

        Queue<Integer> frame = new LinkedList<>();
        for (int i=0;i<n;++i) {
            if(frame.contains(a[i])) {
                frame.remove(a[i]);
                frame.add(a[i]);
            } else {
                if(frame.size()<frameSize) frame.add(a[i]);
                else {
                    frame.poll();
                    frame.add(a[i]);
                }
            }
            System.out.printf("Thêm trang số %d: ", a[i]);
            for (Integer page : frame.stream().toList()) {
                System.out.print(page + " ");
            }
            for (int ii = 0; ii<frameSize-frame.size();++ii) System.out.print("- ");
            System.out.println();
        }
    }
}
