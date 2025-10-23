PARKING LOT MANAGEMENT SYSTEM (JAVA)
------------------------------------

This project is a simple Parking Lot Management System written in Java.
It demonstrates the use of object-oriented programming and linked lists 
to manage car parking operations.


FEATURES
--------

- Park a car into the parking lot.
- Search for a car using its registration number.
- Exit a car from the parking lot.
- Handle VIP parking with reserved slots.
- Simulate multiple-floor parking.
- Display both active and historical parking logs.


CLASSES OVERVIEW
----------------

1. Car
   Represents a car object with details such as name, registration number, and slot index.

2. Node
   A node structure used to create a linked list of cars.

3. LinkedList
   Custom linked list implementation for storing and managing cars in both active and historical records.

4. parkingLot
   The main class that manages parking operations such as adding, deleting, searching, and parking management.

5. parking (Main Class)
   Contains the main method for running and testing the parking lot system.


PROJECT STRUCTURE
-----------------

parking/
│
├── parking.java
│
├── Car.java
├── Node.java
├── LinkedList.java
└── parkingLot.java


HOW IT WORKS
------------

1. Parking a Car
   - Finds the first available slot.
   - Marks it as occupied.
   - Adds the car to both active and history lists.

2. Searching a Car
   - Searches for a car by its registration number.
   - Returns the slot number if found.

3. Exiting a Car
   - Frees the slot.
   - Removes the car from the active cars list.

4. VIP Parking
   - Allows cars to park in the range of slots 61–70 if available.

5. Multiple Floor Parking
   - Simulates parking across multiple floors using a 2D boolean array.

6. Logs
   - Displays current active cars and total history.


EXAMPLE OUTPUT
--------------

TN01A1234 parked at slot 1
TN01B5678 parked at slot 2
VIP VIP001 parked at slot 61
Search TN01A1234 -> Slot: 1
TN01A1234 exited from slot 1
TN02C4321 parked at Floor 1, Slot 1

Active Cars:
Honda(TN01B5678) Slot:1 | BMW(VIP001) Slot:60 |
History:
Toyota(TN01A1234) Slot:-1 | Honda(TN01B5678) Slot:1 | BMW(VIP001) Slot:60 | Hyundai(TN02C4321) Slot:-1 |


HOW TO COMPILE AND RUN
----------------------

Using Command Line:

1. Open the terminal or command prompt in the project directory.
2. Compile the file using:
   javac parking.java
3. Run the program using:
   java parking

Using IDE (VS Code, IntelliJ, etc.):

1. Open the project folder in the IDE.
2. Open the parking.java file.
3. Click the Run or Execute option to run the main method.


POSSIBLE IMPROVEMENTS
---------------------

- Add user menu for interactive input.
- Save logs to an external file.
- Implement a GUI for better visualization.
- Improve error handling and validation.


AUTHORS
-------

Logesh K
Aathithyan M
Amaresh S
Vijeshwar P
Dhiyaneshwaran A
Madhu mithaa P
Atchaya R
Shazia Ruhee R
Parking Lot Management System - Java Implementation
