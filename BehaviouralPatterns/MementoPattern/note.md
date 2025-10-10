# 🧩 Memento Design Pattern (Java)

## 📘 Definition
The **Memento Pattern** is a **Behavioral Design Pattern** that allows capturing and restoring an object's internal state **without violating encapsulation**.

It is mainly used to implement **undo/redo** functionality.

---

## 🧠 Participants
- **Originator** → The object whose state needs to be saved.
- **Memento** → Stores the internal state of the Originator.
- **Caretaker** → Manages and stores mementos but doesn’t modify them.

---

## 🧱 Structure

---

## 💡 Example (Java)

```java
// Memento
class Memento {
    private final String state;
    public Memento(String state) { this.state = state; }
    public String getState() { return state; }
}

// Originator
class Originator {
    private String state;
    public void setState(String state) { this.state = state; }
    public Memento saveToMemento() { return new Memento(state); }
    public void restoreFromMemento(Memento m) { this.state = m.getState(); }
    public String getState() { return state; }
}

// Caretaker
import java.util.*;
class Caretaker {
    private List<Memento> list = new ArrayList<>();
    public void add(Memento m) { list.add(m); }
    public Memento get(int index) { return list.get(index); }
}

// Demo
public class MementoDemo {
    public static void main(String[] args) {
        Originator o = new Originator();
        Caretaker c = new Caretaker();

        o.setState("State #1");
        c.add(o.saveToMemento());

        o.setState("State #2");
        c.add(o.saveToMemento());

        o.setState("State #3");
        System.out.println("Current State: " + o.getState());

        o.restoreFromMemento(c.get(0));
        System.out.println("Restored to: " + o.getState());
    }
}
```
Current State: State #3
Restored to: State #1
```