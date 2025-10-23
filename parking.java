class Car {
    String car;
    String carRegNo;
    int slotIndex;
    public Car(String car, String carRegNo){
        this.car = car;
        this.carRegNo = carRegNo;
        this.slotIndex = -1;
    }
    public String toString(){
        return car + "(" + carRegNo + ") Slot:" + slotIndex;
    }
}

class Node {
    Car data;
    Node next;
    public Node(Car data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    public void add(Car data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public int search(String num){
        Node temp = head;
        while(temp != null){
            if(temp.data.carRegNo.equals(num))
                return temp.data.slotIndex;
            temp = temp.next;
        }
        return -1;
    }
    public void delete(Car car){
        if(head == null) return;
        Node temp = head;
        Node prev = null;
        while(temp != null && temp.data != car){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null) return;
        if(prev == null) head = temp.next;
        else prev.next = temp.next;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " | ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class parkingLot {
    int TOTAL_SLOTS = 100;
    LinkedList carHistory = new LinkedList();
    LinkedList activeCars = new LinkedList();
    boolean slots[] = new boolean[TOTAL_SLOTS];

    public void park(Car car){
        if(overflow(slots)){
            System.out.println("Parking is full!");
            return;
        }
        car.slotIndex = priorityParking(car);
        activeCars.add(car);
        carHistory.add(car);
        System.out.println(car.carRegNo + " parked at slot " + (car.slotIndex + 1));
    }

    public int searchByCarNumber(String carNo){
        int slotIndex = activeCars.search(carNo);
        if(slotIndex == -1) System.out.println("Car not found!");
        return slotIndex + 1;
    }

    private int priorityParking(Car car) {
        for (int i = 0; i < TOTAL_SLOTS; i++){
            if(!slots[i]){
                slots[i] = true;
                return i;
            }
        }
        return -1;
    }

    public void exit(Car car){
        if(car.slotIndex == -1){
            System.out.println("Car not parked!");
            return;
        }
        slots[car.slotIndex] = false;
        activeCars.delete(car);
        System.out.println(car.carRegNo + " exited from slot " + (car.slotIndex + 1));
    }

    private boolean overflow(boolean[] slots) {
        for (boolean slot : slots)
            if(!slot) return false;
        return true;
    }

    public void parkVIP(Car car){
        for (int i = 60; i < 70 && i < TOTAL_SLOTS; i++){
            if(!slots[i]){
                slots[i] = true;
                car.slotIndex = i;
                activeCars.add(car);
                carHistory.add(car);
                System.out.println("VIP " + car.carRegNo + " parked at slot " + (i + 1));
                return;
            }
        }
        System.out.println("No VIP slot available!");
    }

    public void multipleFloorParking(Car car, int floors, int slotsPerFloor){
        boolean[][] multiSlots = new boolean[floors][slotsPerFloor];
        outer:
        for(int f = 0; f < floors; f++){
            for(int s = 0; s < slotsPerFloor; s++){
                if(!multiSlots[f][s]){
                    multiSlots[f][s] = true;
                    System.out.println(car.carRegNo + " parked at Floor " + (f+1) + ", Slot " + (s+1));
                    break outer;
                }
            }
        }
    }


    public void displayLogs(){
        System.out.println("\nActive Cars:");
        activeCars.display();
        System.out.println("History:");
        carHistory.display();
    }
}

public class parking {
    public static void main(String args[]){
        parkingLot lot = new parkingLot();

        Car c1 = new Car("Toyota", "TN01A1234");
        Car c2 = new Car("Honda", "TN01B5678");
        Car c3 = new Car("BMW", "VIP001");

        lot.park(c1);
        lot.park(c2);
        lot.parkVIP(c3);

        System.out.println("Search TN01A1234 -> Slot: " + lot.searchByCarNumber("TN01A1234"));

        lot.exit(c1);

        Car c4 = new Car("Hyundai", "TN02C4321");
        lot.multipleFloorParking(c4, 3, 10);

        lot.displayLogs();
    }
}