# Method in Java

Types of Method
- Predefined Method, predefined methods are the method that is already defined in the Java class libraries is known as predefined methods
- User-defined Method

## Static Method
A method that has static keyword is known as **static** method. In other words. The main advantage of a static method is that we can call it without creating an object, it can access static data members and also change the value of it. It is used to create an instance method. It is invoked by using the class name
```
public class MathUtils {

    public static int staticVar = 42;

    public static void printStaticVar() {
        System.out.println("Static variable: " + staticVar);
    }

    // This is a static method
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = MathUtils.add(5, 3); // Calling the static method without creating an instance
        System.out.println("The sum is: " + result);
        
        printStaticVar();
    }
}
```

## Instance Method
The method of the class is known as an instance method. It is a non-static method defined in the class. Before calling or invoking the instance method, it is necessary to create an object of its class.

```
public class InstanceMethodExample {
    int s; // This is an instance (non-static) variable

    // This is an instance (non-static) method
    public int add(int a, int b) {
        s = a + b; // Calculate the sum and store it in the instance variable 's'
        return s;  // Return the sum
    }

    public static void main(String[] args) {
        // Creating an object of the class
        InstanceMethodExample obj = new InstanceMethodExample();
        
        // Invoking the instance method 'add' using the object 'obj'
        System.out.println("The sum is: " + obj.add(12, 13));
    }
}

```
Instance method has 2 type 
- Accessor Method: The method(s) that reads the instance variable(s) is known as the accessor method. Known as getters.
- Mutator Method: The method(s) read the instance variable(s) and also modify the values. Known as setters or modifiers.

```
public class Student {
    private int roll;   // Private instance variable 'roll'
    private String name; // Private instance variable 'name'

    // Public accessor method for 'roll' variable
    public int getRoll() {
        return roll;
    }

    // Public mutator method for 'roll' variable
    public void setRoll(int roll) {
        this.roll = roll;
    }

    // Public accessor method for 'name' variable
    public String getName() {
        return name;
    }

    // Public mutator method for 'name' variable
    public void setName(String name) {
        this.name = name;
    }

    // Public method to display student information
    public void display() {
        System.out.println("Roll no.: " + roll);
        System.out.println("Student name: " + name);
    }
}

```
## Abstract Method
The method that does not has method body is known as abstract method. It always declares in the abstract class.
```
// Abstract class 'Demo'
abstract class Demo {
    // Abstract method declaration
    abstract void display();
}

// Concrete class 'MyClass' that extends 'Demo'
public class MyClass extends Demo {
    // Method implementation for the abstract 'display' method
    void display() {
        System.out.println("Abstract method?");
    }

    public static void main(String args[]) {
        // Creating an object of the concrete class 'MyClass'
        Demo obj = new MyClass();

        // Invoking the 'display' method, which is overridden in 'MyClass'
        obj.display();
    }
}

```