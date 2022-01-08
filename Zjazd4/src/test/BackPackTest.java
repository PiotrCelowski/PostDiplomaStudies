package test;
import backpack.*;

class BackpackTest {
    public static void main(String args[]){
        Backpack b = new Backpack(0.100, 0.5, 40, 50);
        b.add(new Thing("Ball", 1, 3));
        b.add(new Thing("Torch", 0.5, 1));
        b.add(new Box("Box1", 5, 0.1,0.5,0.5));
        b.printContent();
        b.remove(2);
        b.printContent();
        System.out.println(b.getWeight());
        // Extension start here
        Backpack small = new Backpack(0.01, 0.1, 5, 10);
        small.add(new Box("Box2",3,0.2,0.2,0.2));
        //small.add(new Box("Box3",1,0.1,0.2,0.2));
        b.add(small);
        b.printContent();
    }
}
/* Expected output
Backpack (0.1 kg, 0.5 l) with
1: Ball (1 kg, 3 l)
2: Torch (0.5 kg, 1 l)
3: Box1 (5 kg, 25 l)
Total: 5.6 kg 29.5 l
Backpack (0.1 kg, 0.5 l) with
1: Ball (1 kg, 3 l)
2: Box1 (5 kg, 25 l)
Total: 5.1 kg 28.5 l
5.1
Backpack (0.1 kg, 0.5 l) with
1: Ball (1 kg, 3 l)
2: Box1 (5 kg, 25 l)
3: Backpack (0.01 kg, 0.1 l) with
1: Box2 (3 g, 8 l)
Total: 3.01 kg, 8.1 l
Total: 5.1 kg 28.5 l

*/
