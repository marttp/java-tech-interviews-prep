# Object-Oriented Design (OOD)

## 1. The Four Pillars of OOP (4 เสาหลักของ OOP)

### a. Encapsulation (การห่อหุ้มข้อมูล)

Encapsulation คือการรวบรวมข้อมูล (Attributes) และเมธอด (Methods) ที่ทำงานกับข้อมูลนั้นเข้าไว้ด้วยกันในหน่วยเดียว (Class) นอกจากนี้ยังรวมถึงการจำกัดการเข้าถึงโดยตรงต่อองค์ประกอบบางอย่างของวัตถุ ซึ่งเป็นการป้องกันการรบกวนโดยไม่ตั้งใจและการใช้งานเมธอดในทางที่ผิด

- **Access Modifiers**: `public`, `protected`, `private`
- **Getters and Setters**: ให้การเข้าถึงข้อมูลของคลาสอย่างมีการควบคุม

```java
public class BankAccount {
    private double balance; // Private attribute: ซ่อนข้อมูลบัญชี

    public BankAccount(double initialBalance) {
        if (initialBalance > 0) {
            this.balance = initialBalance;
        }
    }

    // Public method: ให้คนภายนอกฝากเงินได้
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Public getter: ให้ดูยอดเงินได้ แต่แก้ไขโดยตรงไม่ได้
    public double getBalance() {
        return balance;
    }
}
```

### b. Abstraction (ความเป็นนามธรรม)

Abstraction คือแนวคิดในการซ่อนรายละเอียดการทำงานที่ซับซ้อน และแสดงเฉพาะคุณสมบัติที่สำคัญของวัตถุเท่านั้น ช่วยลดความซับซ้อนและความพยายามในการเขียนโปรแกรม

- **Abstract Classes**: คลาสที่ไม่สามารถสร้าง Instance ได้โดยตรง ออกแบบมาเพื่อให้คลาสอื่นสืบทอด (Subclass) สามารถมีได้ทั้งเมธอดที่เป็น abstract และ concrete
- **Interfaces**: ข้อตกลง (Contract) ที่กำหนดชุดของเมธอดที่คลาสต้องนำไป Implement

```java
// Abstract Class
abstract class Shape {
    String color;
    abstract double area(); // Abstract method: ลูกหลานต้องไปเขียนเอง

    public void display() { // Concrete method
        System.out.println("This is a shape.");
    }
}

// Interface
interface Drawable {
    void draw();
}

class Circle extends Shape implements Drawable {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
```

### c. Inheritance (การสืบทอดคุณสมบัติ)

Inheritance เป็นกลไกที่วัตถุหนึ่งได้รับคุณสมบัติและพฤติกรรมทั้งหมดมาจากวัตถุแม่ (Parent object) โดยแทนความสัมพันธ์แบบ "is-a" (เป็น)

- **`extends` keyword**: ใช้เพื่อสืบทอดจากคลาส
- **`implements` keyword**: ใช้เพื่อ Implement อินเทอร์เฟซ
- **Method Overriding**: คลาสลูกทำการเขียนทับการทำงานของเมธอดที่มีอยู่แล้วในคลาสแม่

```java
class Vehicle {
    void move() {
        System.out.println("Vehicle is moving");
    }
}

class Car extends Vehicle { // Car "is-a" Vehicle
    @Override
    void move() {
        System.out.println("Car is driving on road");
    }
}
```

### d. Polymorphism (การพ้องรูป)

Polymorphism คือความสามารถของวัตถุในการมีได้หลายรูปแบบ อนุญาตให้เรากระทำการสิ่งเดียวกันในรูปแบบที่แตกต่างกันได้

- **Method Overloading (Compile-time Polymorphism)**: คลาสมีหลายเมธอดชื่อเหมือนกัน แต่พารามิเตอร์ต่างกัน
- **Method Overriding (Runtime Polymorphism)**: คลาสลูกมีเมธอดชื่อและพารามิเตอร์เหมือนกับที่ประกาศในคลาสแม่

```java
class Calculator {
    // Overloading
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}

class Animal {
    void sound() { System.out.println("Animal makes a sound"); }
}

class Dog extends Animal {
    // Overriding
    @Override
    void sound() { System.out.println("Dog barks"); }
}

// Usage
Animal myDog = new Dog();
myDog.sound(); // Output: Dog barks (Runtime Polymorphism)
```

## 2. SOLID Principles

SOLID เป็นตัวย่อของหลักการออกแบบ 5 ประการที่มีจุดมุ่งหมายเพื่อให้การออกแบบซอฟต์แวร์เข้าใจง่าย ยืดหยุ่น และบำรุงรักษาได้ง่าย

### a. Single Responsibility Principle (SRP)

คลาสควรมีเหตุผลเดียวเท่านั้นในการเปลี่ยนแปลง (ทำหน้าที่เพียงอย่างเดียว)

```java
// Bad: คลาสนี้ทำทั้งคำนวณเงินและพิมพ์ใบเสร็จ
class Invoice {
    void calculateTotal() { /*...*/ }
    void printInvoice() { /*...*/ }
}

// Good: แยกหน้าที่กันชัดเจน
class InvoiceCalculator {
    void calculateTotal() { /* calculation logic */ }
}

class InvoicePrinter {
    void printInvoice() { /* printing logic */ }
}
```

### b. Open/Closed Principle (OCP)

ซอฟต์แวร์ (Classes, Modules, Functions) ควรเปิดกว้างสำหรับการขยาย (Extension) แต่ปิดสำหรับการแก้ไข (Modification)

```java
// Good: เราสามารถเพิ่ม Shape ใหม่ๆ ได้โดยไม่ต้องแก้ code เดิมใน AreaCalculator
interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    public double width, height;
    public double calculateArea() { return width * height; }
}

class Circle implements Shape {
    public double radius;
    public double calculateArea() { return Math.PI * radius * radius; }
}
```

### c. Liskov Substitution Principle (LSP)

Subtypes ต้องสามารถใช้แทน Base types ได้โดยไม่ทำให้โปรแกรมทำงานผิดพลาด

```java
class Bird {
    void fly() { /*...*/ }
}

class Ostrich extends Bird {
    @Override
    void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly");
        // ผิดหลัก LSP เพราะ Ostrich ใช้แทน Bird ไม่ได้สมบูรณ์ (บินไม่ได้)
    }
}
// วิธีแก้: แยก Bird เป็น FlyingBird และ NonFlyingBird
```

### d. Interface Segregation Principle (ISP)

Clients ไม่ควรถูกบังคับให้พึ่งพา Interfaces ที่พวกเขาไม่ได้ใช้งาน

```java
// Bad: บังคับให้ Robot ต้อง Implement eat() ทั้งที่ไม่จำเป็น
interface Worker {
    void work();
    void eat();
}

// Good: แยก Interface ให้เล็กและเฉพาะเจาะจง
interface Workable {
    void work();
}
interface Eatable {
    void eat();
}

class Robot implements Workable {
    public void work() { /*...*/ }
}
```

### e. Dependency Inversion Principle (DIP)

High-level modules ไม่ควรพึ่งพา Low-level modules ทั้งคู่ควรพึ่งพา Abstractions (เช่น Interfaces)

```java
// Bad: Switch ต้องรู้จัก LightBulb โดยตรง
class LightBulb {
    void turnOn() { /*...*/ }
}
class Switch {
    LightBulb bulb; // Dependency on concrete class
}

// Good: Switch พึ่งพา Interface และใช้ Dependency Injection (DI)
interface Switchable {
    void turnOn();
}

class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("LightBulb: Bulb turned on...");
    }
}

class Switch {
    private Switchable device; // Dependency on abstraction

    // Constructor Injection: ส่ง dependency เข้ามาผ่าน Constructor
    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}

// Usage Example
// Switchable bulb = new LightBulb();
// Switch mySwitch = new Switch(bulb); // Inject dependency
// mySwitch.operate();
```
