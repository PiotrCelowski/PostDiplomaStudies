package backpack;

public class Thing {
    protected double weight;
    protected double volume;
    protected String name;
    /**
     * Creates thing.
     * @param name name of the object
     * @param weight weight in kilos
     * @param volume volume in liters
     */
    public Thing(String name, double weight, double volume){
        if(name != null)
            this.name = name;
        else
            this.name = "";
        this.weight = Math.max(weight, 0.0);
        this.volume = Math.max(volume, 0.0);
    }
    /**
     * @return weight in kilos
     */
    public double getWeight(){
        return weight;
    }
    /**
     * @return volume in liters
     */
    public double getVolume(){
        return volume;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        return name + " (" + weight + " kg, " + volume + " l)";
    }
}
