package backpack;

import java.util.ArrayList;

public class Backpack extends Thing {
    private double initialWeight;
    private double initialVolume;
    private double occupiedVolume;
    private double occupiedWeight;
    private double maxWeight = 100;

    private ArrayList<Thing> things = new ArrayList<>();

    public Backpack(double weight, double height, int width, int depth) {
        super("Backpack", weight, height * width * depth * 1000);
        this.initialWeight = weight;
        this.initialVolume = height * width * depth * 1000;
        this.occupiedWeight = 0;
        this.occupiedVolume = 0;
    }

    public void add(Thing thing) {
        if(checkVolume(thing) && checkWeight(thing)) {
            things.add(thing);
            occupiedWeight += thing.getWeight();
            occupiedVolume += thing.getVolume();
        } else {
            System.out.println("No more place in the backpack!");
        }
    }

    public void remove(int index) {
        if(index < things.size()) {
            occupiedVolume -= things.get(index).getVolume();
            occupiedWeight -= things.get(index).getWeight();
            things.remove(index);
        } else {
            System.out.println("No thing with this index.");
        }
    }

    private boolean checkWeight(Thing thing) {
        double thingWeight = thing.getWeight();

        if(thingWeight > (maxWeight - occupiedWeight)) {
            return false;
        }
        return true;
    }

    private boolean checkVolume(Thing thing) {
        double thingVolume = thing.getVolume();

        if(thingVolume > (this.initialVolume - this.occupiedVolume)) {
            return false;
        }
        return true;
    }

    public double getInitialVolume() {
        return Math.round(initialVolume * 100.0) / 100.0;
    }

    public double getInitialWeight() {
        return Math.round(initialWeight * 100.0) / 100.0;
    }

    @Override
    public double getWeight() {
        return Math.round(occupiedWeight * 100.0) / 100.0;
    }

    @Override
    public double getVolume() {
        return Math.round(occupiedVolume * 100.0) / 100.0;
    }

    public void printContent() {
        System.out.println(this.getName() + " (" +  this.getInitialWeight() + "kg, " + this.getInitialVolume() + "l) ");
        things.forEach(item -> System.out.println(item.getName() + " (" + item.getWeight() + "kg, " + item.getVolume() + "l) "));
        System.out.println("Total: " + this.getWeight() + "kg " + this.getVolume() + "l");
    }
}
