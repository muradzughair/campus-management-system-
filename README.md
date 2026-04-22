# Campus Management System


## Features and Abstract Data Types

The system includes six essential features, each implemented using a carefully selected Abstract Data Type (ADT) to ensure efficient data handling and user interaction.

* **1. Lost & Found Tracking**
  * **ADT**: Linked List
  * **Description**: Allows dynamic insertion and removal of lost item records without the need to resize or shift elements. 
* **2. Room Booking**
  * **ADT**: Priority Queue (via Sorted Linked List)
  * **Description**: Encapsulates requests as `RoomRequest` objects and places them in order of priority. The system always accesses the highest-priority booking first.
* **3. Campus Navigation**
  * **ADT**: Graph (Adjacency List)
  * **Description**: Models campus building connections and utilizes Dijkstra's algorithm to calculate and print the shortest path between buildings.
* **4. Undo/Redo System**
  * **ADT**: Stack
  * **Description**: Employs two custom Stack objects (`undoStack` and `redoStack`) to provide last-in-first-out (LIFO) logic for command history navigation.
* **5. Event Registration**
  * **ADT**: Queue
  * **Description**: Preserves the order in which students register for events, ensuring fair and sequential processing using first-in-first-out (FIFO) logic.
* **6. Student Locker Allocation**
  * **ADT**: Binary Search Tree (BST)
  * **Description**: Manages locker assignments by student ID, offering efficient insertion, search, and deletion operations while maintaining sorted access.

---

## System Architecture

The application is structured with a clear separation of concerns, adhering to object-oriented programming principles such as information hiding and encapsulation.

* **User Interface**: The main class responsible for user interaction is `User_interface_code`. It provides a console-based menu built using a switch-case structure and the `Scanner` class to read inputs.
* **Encapsulation**: Each data structure is a self-contained class with private internal data, accessed only via public methods (e.g., `getStudentId()`, `getPriority()`). 
* **Error Handling**: The system manages runtime errors, such as `InputMismatchException`, using try-catch blocks. Upon catching an error, the system clears the scanner input and provides warnings to re-enter choices, preventing crashes.

---

## Complexity Evaluation

Below is the time and space complexity breakdown for the core operations of each feature.

| Feature | ADT Used | Key Methods | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| **Lost & Found** | Linked List | `addItem()`<br>`displayItems()` | O(n)<br>O(n) | O(1)<br>O(1) |
| **Room Booking** | Sorted Linked List | `addRequest()`<br>`displayRequests()` | O(n)<br>O(n) | O(1)<br>O(1) |
| **Orientation Help** | Graph (Adjacency List) | `addEdge()`<br>`dijkstra()` | O(1)<br>O((V + E) log V) | O(1) per edge<br>O(V) |
| **Undo/Redo** | Stack (Linked List) | `performAction()`<br>`undo()`, `redo()` | O(1)<br>O(1) | O(1)<br>O(1) |
| **Event Registration** | Queue (Linked List) | `register()`<br>`processRegistration()` | O(1)<br>O(1) | O(1)<br>O(1) |
| **Locker Allocation** | Binary Search Tree | `insert()`<br>`search()`<br>`delete()` | O(log n) avg / O(n) worst<br>O(log n) avg / O(n) worst<br>O(log n) avg / O(n) worst | O(h)<br>O(h)<br>O(h) |

*(Note: V = Vertices, E = Edges, h = height of tree)*

---

## Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher.

### Installation and Execution
1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile the Java files. Ensure all package structures (`feature_one`, `feature_two`, etc.) are maintained.
   ```bash
   javac user_code/User_interface_code.java
