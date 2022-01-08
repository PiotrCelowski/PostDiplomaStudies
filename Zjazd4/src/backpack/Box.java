package backpack;

public class Box extends Thing{
    protected double height;
    protected double width;
    protected double depth;
    /**
     * Creates box.
     * @param name   name of the box
     * @param weight box weight in kilos
     * @param height box height in meters
     * @param width  box width in meters
     * @param depth  box depth in meters
     */
    public Box(String name, double weight,
               double height, double width, double depth){
        super(name, weight, height*width*depth * 1000);
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
    /**
     * @return height in meters.
     */
    public double getHeight(){
        return height;
    }
    /**
     * @return widht in meters.
     */
    public double getWidht(){
        return width;
    }
    /**
     * @return depth in meters.
     */
    public double getDepth(){
        return depth;
    }
}
