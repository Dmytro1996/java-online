public class Point{
    private int x;
    private int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int[] getXYPair(){
        int[] result={x,y};
        return result;
    }
    public double distance(int x, int y){
        return Math.sqrt(Math.pow(this.x-x,2)+Math.pow(this.y-y,2));
    }
    public double distance(Point point){
        return Math.sqrt(Math.pow(this.x-point.getXYPair()[0],2)+Math.pow(this.y-point.getXYPair()[1],2));
    }
    public double distance(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }
}