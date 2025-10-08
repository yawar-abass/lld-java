# UML (Unified Modeling Language)

UML (Unified Modeling Language) is a standardized way to visualize the design of a system.

---

## 1. Class Diagram

**Definition:**  
A class diagram represents the static structure of a system — showing classes, their attributes, methods, and the relationships between them.

**Example UML Notation:**
```
+ means public  
- means private  
# means protected
```

**UML Example:**
```
+----------------------+
|      Student         |
+----------------------+
| - name: String       |
| - age: int           |
+----------------------+
| + study(): void      |
| + showDetails(): void|
+----------------------+
```

**Code Example:**
```java
public class Student {
    private String name;
    private int age;

    public void study() {
        System.out.println(name + " is studying");
    }

    public void showDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

---

## 2. Association

**Definition:**  
Association represents a **relationship between two classes**, where one class uses another. It is a "uses-a" relationship.

**UML Example:**
```
Teacher  -------->  Student
```

**Java Example:**
```java
public class Student {
    String name;
}

public class Teacher {
    void teach(Student student) {
        System.out.println("Teaching " + student.name);
    }
}
```

---

## 3. Aggregation

**Definition:**  
Aggregation is a **special form of association** that represents a **"has-a" relationship** but with **independent lifecycles**.  
If one object is destroyed, the other can still exist.

**UML Example:**
```
Department ◇------> Teacher
```

**Java Example:**
```java
import java.util.List;

public class Teacher {
    String name;
}

public class Department {
    private List<Teacher> teachers;

    public Department(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
```

---

## 4. Composition (Strong Has-a Relationship)

**Definition:**  
Composition is a **strong form of aggregation** where the contained object **cannot exist without** the container object.

**UML Example:**
```
House ◆------> Room
```

**Java Example:**
```java
public class Room {
    private String name;

    public Room(String name) {
        this.name = name;
    }
}

public class House {
    private Room room;

    public House() {
        // Composition: Room created within House
        this.room = new Room("Living Room");
    }
}
```

---

## 5. Inheritance

**Definition:**  
Inheritance represents an **"is-a" relationship** between a base (superclass) and derived (subclass) class.

**UML Example:**
```
Animal  <|--  Dog
```

**Java Example:**
```java
public class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

public class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
```

---

## 6. Dependency

**Definition:**  
Dependency means one class **depends on another** because it **uses** it temporarily (like in a method parameter or local variable).

**UML Example:**
```
Car  ----->  Engine
```

**Java Example:**
```java
public class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

public class Car {
    void startCar(Engine engine) {  // Dependency
        engine.start();
        System.out.println("Car started");
    }
}
```

---

## 7. Realization

**Definition:**  
Realization represents the relationship between an **interface** and the **class that implements it**.

**UML Example:**
```
Payment <|.. CreditCardPayment
```

**Java Example:**
```java
interface Payment {
    void pay();
}

public class CreditCardPayment implements Payment {
    public void pay() {
        System.out.println("Payment done via Credit Card");
    }
}
```

---

