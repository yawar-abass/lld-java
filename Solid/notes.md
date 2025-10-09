# SOLID Principles in Java

The **SOLID principles** are a set of five software design principles intended to make software designs more understandable, flexible, and maintainable.  
They were introduced by **Robert C. Martin (Uncle Bob).**

---

## 1. Single Responsibility Principle (SRP)

> **A class should have only one reason to change.**

Each class should be responsible for a single functionality. This helps make the code more modular and easier to maintain.

### ❌ Bad Example
```java
class Invoice {
    public void calculateTotal() {
        // logic for total calculation
    }

    public void printInvoice() {
        // logic for printing
    }

    public void saveToDatabase() {
        // logic for saving to DB
    }
}
```

**Problem:**
- The `Invoice` class has multiple responsibilities: calculation, printing, and persistence.

### ✅ Good Example
```java
class Invoice {
    public void calculateTotal() {
        // logic for total calculation
    }
}

class InvoicePrinter {
    public void print(Invoice invoice) {
        // printing logic
    }
}

class InvoiceRepository {
    public void save(Invoice invoice) {
        // DB save logic
    }
}
```

**Benefits:**
- Each class has a single reason to change.
- Better separation of concerns.

---

## 2. Open/Closed Principle (OCP)

> **Software entities should be open for extension but closed for modification.**

You should be able to extend a class’s behavior without modifying its existing code.

### ❌ Bad Example
```java
class Discount {
    public double getDiscount(String type) {
        if (type.equals("DIWALI")) {
            return 0.2;
        } else if (type.equals("NEWYEAR")) {
            return 0.3;
        } else {
            return 0.0;
        }
    }
}
```

**Problem:**
- Adding a new discount type requires changing the class every time.

### ✅ Good Example
```java
interface DiscountStrategy {
    double getDiscount();
}

class DiwaliDiscount implements DiscountStrategy {
    public double getDiscount() {
        return 0.2;
    }
}

class NewYearDiscount implements DiscountStrategy {
    public double getDiscount() {
        return 0.3;
    }
}

class DiscountContext {
    private DiscountStrategy strategy;

    public DiscountContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double getDiscount() {
        return strategy.getDiscount();
    }
}
```

**Benefits:**
- Easily add new discount types by creating new classes.
- No modification to existing logic.

---

## 3. Liskov Substitution Principle (LSP)

> **Objects of a superclass should be replaceable with objects of a subclass without breaking the application.**

### ❌ Bad Example
```java
class Bird {
    void fly() {
        System.out.println("Flying...");
    }
}

class Ostrich extends Bird {
    void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly!");
    }
}
```

**Problem:**
- `Ostrich` violates LSP because it changes expected behavior.

### ✅ Good Example
```java
interface Bird {
    void eat();
}

interface FlyingBird extends Bird {
    void fly();
}

class Sparrow implements FlyingBird {
    public void eat() {
        System.out.println("Eating grains...");
    }

    public void fly() {
        System.out.println("Flying high...");
    }
}

class Ostrich implements Bird {
    public void eat() {
        System.out.println("Eating plants...");
    }
}
```

**Benefits:**
- Subtypes can replace parent types without unexpected behavior.

---

## 4. Interface Segregation Principle (ISP)

> **No client should be forced to depend on methods it does not use.**

### ❌ Bad Example
```java
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() {
        System.out.println("Robot working...");
    }

    public void eat() {
        // Not applicable
        throw new UnsupportedOperationException("Robot doesn't eat!");
    }
}
```

**Problem:**
- `Robot` is forced to implement a method it doesn't need.

### ✅ Good Example
```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() {
        System.out.println("Human working...");
    }

    public void eat() {
        System.out.println("Human eating...");
    }
}

class Robot implements Workable {
    public void work() {
        System.out.println("Robot working...");
    }
}
```

**Benefits:**
- Classes only implement what they actually need.
- Interfaces remain small and focused.

---

## 5. Dependency Inversion Principle (DIP)

> **Depend on abstractions, not on concrete implementations.**

### ❌ Bad Example
```java
class Keyboard {}
class Monitor {}

class Computer {
    private Keyboard keyboard;
    private Monitor monitor;

    public Computer() {
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
    }
}
```

**Problem:**
- `Computer` is tightly coupled with `Keyboard` and `Monitor`.

### ✅ Good Example
```java
interface IKeyboard {}
interface IMonitor {}

class WiredKeyboard implements IKeyboard {}
class LEDMonitor implements IMonitor {}

class Computer {
    private IKeyboard keyboard;
    private IMonitor monitor;

    public Computer(IKeyboard keyboard, IMonitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}
```

**Benefits:**
- High-level modules are independent of low-level modules.
- Easier to test and modify.

---

## 🧠 Summary

| Principle | Meaning | Key Idea |
|------------|----------|-----------|
| **S** | Single Responsibility | One class → One responsibility |
| **O** | Open/Closed | Open for extension, closed for modification |
| **L** | Liskov Substitution | Subtypes must be substitutable for base types |
| **I** | Interface Segregation | Keep interfaces small and focused |
| **D** | Dependency Inversion | Depend on abstractions, not concretions |

---
