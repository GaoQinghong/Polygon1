/**
 * Created by gaoqinghong on 2016/12/10.
 */
public class MainDecomposition {
    readFile read = new readFile("/Users/gaoqinghong/Desktop/polygon.txt");
    polygon polygon= read.read();                                             //获取到已经初始化的多边形polygon
    int n = polygon.n ;                       //保存 点 个数
    double[][] t = new double[n][n];          //保存多边形vi-1 vk vj  之间的最佳权值
    int[][] mid = new int[n][n];               //保存vi-1 vj最优三角剖分的中间点


    public double[][] weight(){                   //两点之间的权重计算
        double[][] weight = new double[n][n];
        for(int i = 0;i < n;i++){
           for(int j=0;j< n ;j++){
               weight[i][j] = Math.sqrt(Math.pow(polygon.vertices.get(i).x-polygon.vertices.get(j).x,2)+Math.pow(polygon.vertices.get(i).y-polygon.vertices.get(j).y,2));
           }
        }
        return weight;
    }
    public double get_weight(int i,int j,int k){       //返回三角权重
        double[][] weight = new double[n][n];
        weight = weight();
        double wei= 0.0;
        wei =  weight[i][j]+weight[i][k]+weight[j][k];
        return wei;

    }


    public void decomposition(){            //计算任意两点之间的最优权重矩阵
        for(int i=0;i<n;i++){
            t[i][i]=0;
            if(i<n-1) t[i][i+1]=0;
        }

        for(int r = 2; r < n; r++)
        {
            for(int i=0;i<n-r;i++){
                int j = i+r;
                t[i][j]= 10000000000.0;                                   //初始化一个最大的值
                int midnum = 0;
                for(int k=i+1;k<j;k++){
                    if((t[i][k]+t[k][j]+get_weight(i,k,j))<t[i][j]){
                        t[i][j] = t[i][k]+t[k][j]+get_weight(i,k,j);
                        midnum = polygon.vertices.get(k).label;            //把中间点的位置用midnum记录下来


                    }
                }
                mid[i][j] = midnum;
            }
        }
    }

    public void  track(int i, int j, int[][] mid){
        if(Math.abs(i-j) <= 1) return;
        track(i,mid[i][j],mid);
        track(mid[i][j],j,mid);
        System.out.println("V"+i+" V"+mid[i][j]+" V"+j);

    }
}
