import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class GenericPriorityList<T extends Comparable<T>> implements Iterator<T> {

    private List<T> orderedList;
    private int index;

    public <T extends Comparable<T>> GenericPriorityList() {
        this.orderedList = new ArrayList<>();
        this.index = 0;
    }

    public GenericPriorityList(List<? extends T> container) {
        this.orderedList = new ArrayList<>();
        container.stream().forEach(el -> this.push(el));
        this.index = 0;
    }

    public void push(T element) {
        int index = findPlace(element);
        orderedList.add(index, element);
    }

    private int findPlace(T element) {
        for(T currentElement : orderedList) {
            if(currentElement.compareTo(element) == 1 || currentElement.compareTo(element) == 0) {
                return orderedList.indexOf(currentElement);
            }
        }
        return orderedList.size();
    }

    public void pop() {
        if(orderedList.size() < 1) {
            return;
        }
        orderedList.remove(0);
    }

    public T top() {
        if(orderedList.size() < 1) {
            return null;
        }
        return orderedList.get(0);
    }

    public int size() {
        return orderedList.size();
    }

    public List<T> getOrderedList() {
        return orderedList;
    }

    @Override
    public String toString() {
        return orderedList.stream()
                .map(element -> element.toString())
                .reduce("",
                        (string1, string2) -> string1 + "\n" + string2);
    }

    public int getIndex() {
        return index;
    }

    private void incrementIndex() {
        this.index++;
    }

    @Override
    public boolean hasNext() {
        return this.getIndex() < this.getOrderedList().size();
    }

    @Override
    public T next() {
        T element = this.getOrderedList().get(this.getIndex());
        incrementIndex();
        return element;
    }

    @Override
    public void remove() {
        remove(this.getOrderedList().get(this.getIndex()));
    }

    private void remove(T element) {
        this.orderedList.remove(element);
        System.out.println("Element " + element.toString() + " was removed.");
    }

    private void decrementIndex() {
        this.index--;
    }

    public static class Utils {
        public static void print(GenericPriorityList priorityList) {
            System.out.println(priorityList.toString());
        }
    }

    public Iterator<T> iterator() {
        return this;
    }

    private void zeroIndex() {
        this.index = 0;
    }

    public static void main(String[] args) {
//        GenericPriorityList<Double> list = new GenericPriorityList<Double>();
//        list.push(5.0);
//        list.push(4.0);
//        list.push(3.0);
//
//        while(list.size() >0) {
//            System.out.println(" > "+ list.top());
//            list.pop();
//        }
//
//        GenericPriorityList<Double> list1 = new GenericPriorityList<Double>();
//        list1.push(2.0);  list1.push(3.0);
//        GenericPriorityList.Utils.print(list1);
//
//        GenericPriorityList<Double> list2 = new GenericPriorityList<Double>();
//        list2.push(2.0);
//        list2.push(3.0);
//        for (Iterator<Double> it = list2; it.hasNext(); ) {
//            Double elem = it.next();
//            System.out.println(">"+ elem);
//        }
//        list2.zeroIndex();
//        // usuwanie całej listy
//        for( Iterator<Double> it = list2.iterator(); it.hasNext(); ){
//            it.remove();
//        }

        ArrayList<Double> v = new ArrayList<Double>();
        v.add(5.0);
        v.add(4.0);
        v.add(9.0);
        GenericPriorityList<Double> list = new GenericPriorityList<Double>(v);
        Utils.print(list);
    }
}
