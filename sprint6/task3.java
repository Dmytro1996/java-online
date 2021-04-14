import java.util.ArrayList;
import java.util.List;

class Rectang extends Square {
    private double height;
    
    public Rectang(double height, double width){
        super(width);
        this.height=height;
    }
    
    public double getPerimeter(){
        return 2*(getWidth()+height);
    }
}
class Square {
    private double width;
    
    public Square(double width){
        this.width=width;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getPerimeter(){
        return 4*width;
    }
}
public class MyUtils {
    public double sumPerimeter(List<?> firures) {
        double sumOfPerimeters=0;
        for(Object f:firures){
            if(f!=null){
                if(f instanceof Rectang){
                    sumOfPerimeters+=((Rectang)f).getPerimeter();
                    continue;
                }
                if(f instanceof Square){
                    sumOfPerimeters+=((Square)f).getPerimeter();
                }
            }
        }
        return sumOfPerimeters;
    }
}
