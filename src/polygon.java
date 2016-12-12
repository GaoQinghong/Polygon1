import java.util.List;

/**
 * Created by gaoqinghong on 2016/12/10.
 */
public class polygon {                //多边形，点的个数和点的坐标构成
    int n;
    List<vertice> vertices;
    public polygon(int n, List<vertice> vertices){
        this.n = n;
        this.vertices = vertices;
    }
}
