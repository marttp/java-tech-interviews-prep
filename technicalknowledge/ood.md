# Object-Oriented Design (OOD)

## 1. The Four Pillars of OOP

### a. Encapsulation
Encapsulation is the bundling of data (attributes) and methods that operate on the data into a single unit (a class). It also involves restricting direct access to some of an object's components, which is a means of preventing unintended interference and misuse of the methods.

*   **Access Modifiers**: `public`, `protected`, `private`.
*   **Getters and Setters**: Provide controlled access to the attributes of a class.

### b. Abstraction
Abstraction is the concept of hiding the complex implementation details and showing only the essential features of the object. It helps in reducing programming complexity and effort.

*   **Abstract Classes**: A class that cannot be instantiated and is meant to be subclassed. It can have both abstract and concrete methods.
*   **Interfaces**: A contract that defines a set of methods that a class must implement.

### c. Inheritance
Inheritance is a mechanism in which one object acquires all the properties and behaviors of a parent object. It represents an "is-a" relationship.

*   **`extends` keyword**: Used to inherit from a class.
*   **`implements` keyword**: Used to implement an interface.
*   **Method Overriding**: A subclass provides a specific implementation of a method that is already provided by its parent class.

### d. Polymorphism
Polymorphism is the ability of an object to take on many forms. It allows us to perform a single action in different ways.

*   **Method Overloading (Compile-time Polymorphism)**: A class has multiple methods having same name but different in parameters.
*   **Method Overriding (Runtime Polymorphism)**: A subclass has the same method as declared in the parent class.

## 2. SOLID Principles
SOLID is an acronym for five design principles intended to make software designs more understandable, flexible, and maintainable.

### a. Single Responsibility Principle (SRP)
A class should have only one reason to change.

### b. Open/Closed Principle (OCP)
Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

### c. Liskov Substitution Principle (LSP)
Subtypes must be substitutable for their base types.

### d. Interface Segregation Principle (ISP)
Clients should not be forced to depend on interfaces they do not use.

### e. Dependency Inversion Principle (DIP)
High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

## 3. Common Design Patterns

### a. Creational Patterns
These patterns provide ways to create objects while hiding the creation logic, rather than instantiating objects directly using the `new` operator.

*   **Singleton**: Ensures a class has only one instance and provides a global point of access to it.
*   **Factory Method**: Defines an interface for creating an object, but lets subclasses alter the type of objects that will be created.
*   **Abstract Factory**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
*   **Builder**: Separates the construction of a complex object from its representation so that the same construction process can create different representations.
*   **Prototype**: Specifies the kinds of objects to create using a prototypical instance, and creates new objects by copying this prototype.

### b. Structural Patterns
These patterns concern class and object composition. They explain how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient.

*   **Adapter**: Allows objects with incompatible interfaces to collaborate.
*   **Bridge**: Lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.
*   **Composite**: Lets you compose objects into tree structures and then work with these structures as if they were individual objects.
*   **Decorator**: Lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.
*   **Facade**: Provides a simplified interface to a library, a framework, or any other complex set of classes.
*   **Flyweight**: Lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
*   **Proxy**: Lets you provide a substitute or placeholder for another object.

### c. Behavioral Patterns
These patterns are concerned with algorithms and the assignment of responsibilities between objects.

*   **Chain of Responsibility**: Lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
*   **Command**: Turns a request into a stand-alone object that contains all information about the request.
*   **Interpreter**: Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.
*   **Iterator**: Lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).
*   **Mediator**: Lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.
*   **Memento**: Lets you save and restore the previous state of an object without revealing the details of its implementation.
*   **Observer**: Lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.
*   **State**: Lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.
*   **Strategy**: Lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.
*   **Template Method**: Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.
*   **Visitor**: Lets you separate algorithms from the objects on which they operate.
