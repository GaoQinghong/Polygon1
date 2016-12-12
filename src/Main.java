
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MainDecomposition mainDecom = new MainDecomposition();
            mainDecom.decomposition();
            int n = mainDecom.n;
            System.out.println("n="+n);
            System.out.println("最优三角的权重 ："+mainDecom.t[0][n-1]);
            mainDecom.track(0,n-1,mainDecom.mid);
    }
}
