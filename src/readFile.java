import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaoqinghong on 2016/12/10.
 */
public class readFile {
    String filename;
    public readFile(String filename){
        this.filename = filename;
    }
    public polygon read(){
        int i = 0;
        List<vertice> vertices = new ArrayList<vertice>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            String data = null;
            while ((data = bf.readLine())!=null){        //逐个读取文件中的点坐标，然后添加到list中
                vertice vertices1 = new vertice();
                String[] da = data.split(" ");
                vertices1.x = Float.parseFloat(da[0]);
                vertices1.y = Float.parseFloat(da[1]);
                vertices1.label = i;
                vertices.add(vertices1);                 //所有点都添加到list中
                i++;
            }
        }catch (Exception e){
            System.out.print("~file reading failed~");
        }
        polygon polygon = new polygon(i,vertices);        //点坐标vertices获取完毕,与点个数一起传值给多边形polygon的构造函数
        return polygon;


    }

}
