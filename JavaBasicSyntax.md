# Java Basic Syntax 
Java program is an object-oriented programming language, that means java is the collection of objects, and these objects communicate through method calls to each other to work together. Here is a brief discussion on the Classes and Objects, Method, Instance variables, syntax, and semantics of Java.

1. Class: The class is a blueprint (plan) of the instance of a class (object). It can be defined as a logical template that share common properties and methods.
    - Alice is an object of the “Human” class.
    - Class name should be in upper cammel case.
    > class MyJavaProgram    

2. Object: The object is an instance of a class. It is an entity that has behavior and state.
    - Dog, Cat, Monkey etc. are the object of “Animal” class.
3. Method: The behavior of an object is the method.
    - Method name should be in lowwer cammel case 
    > public void employeeRecords() 

4. Instance variables: Every object has its own unique set of instance variables. The state of an object is generally created by the values that are assigned to these instance variables.


Access Modifiers 
- Access Modifiers: default, public, protected, private.
- Non-access Modifiers: final, abstract, static, transient, synchronized, volatile, native.

| Access Modifier | Within Class | Within Package | Outside Package by subclass only | Outside Package |
|-----------------|--------------|-----------------|----------------------------------|-----------------|
| Private         | Yes          | No             | No                               | No              |
| Default         | Yes          | Yes            | No                               | No              |
| Protected       | Yes          | Yes            | Yes                              | No              |
| Public          | Yes          | Yes            | Yes                              | Yes             |

Java keywords
- Keywords or Reserved words are the words in a language that are used for some internal process or represent some predefined actions. These words are therefore not allowed to use as variable names or objects. 

| Keyword      | Keyword      | Keyword      | Keyword     |
|--------------|--------------|--------------|-------------|
| abstract     | assert       | boolean      | break       |
| byte         | case         | catch        | char        |
| class        | const        | continue     | default     |
| do           | double       | else         | enum        |
| extends      | final        | finally      | float       |
| for          | goto         | if           | implements  |
| import       | instanceof   | int          | interface   |
| long         | native       | new          | package     |
| private      | protected    | public       | return      |
| short        | static       | strictfp     | super       |
| switch       | synchronized | this         | throw       |
| throws       | transient    | try          | void        |
| volatile     | while        |              |             |

## Java variables
In Java, there are three types of variables:
- Local Variables are a variable that are declared inside the body of a method. A local variable cannot be defined with "static" keyword.
- Instance Variables are defined without the STATIC keyword .They are defined Outside a method declaration. They are Object specific and are known as instance variables.
- Static Variables initialized only once, at the start of the program execution. These variables should be initialized first, before the initialization of any instance variables.
```
 class Sample {
    static int a = 1; //static variable  
    int data = 99; //instance variable  
    void method() {
        int b = 90; //local variable  
    }
}
```

**Data Types in Java** are defined as specifiers that allocate different sizes and types of values that can be stored in the variable or an identifier.
- Primitive Data Types :- which include integer, character, boolean, and float
- Non-primitive Data Types :- which include classes, arrays and interfaces.

| Data Type | Default Value | Default Size |
|-----------|---------------|--------------|
| boolean   | false         | 1 bit        |
| char      | '\u0000'      | 2 bytes      |
| byte      | 0             | 1 byte       |
| short     | 0             | 2 bytes      |
| int       | 0             | 4 bytes      |
| long      | 0L            | 8 bytes      |
| float     | 0.0f          | 4 bytes      |
| double    | 0.0d          | 8 bytes      |


Java Variable Type Conversion & Type Casting
- Variable of smaller capacity is be assigned to another variable of bigger capacity.
- Variable of larger capacity is be assigned to another variable of smaller capacity
```
class Demo {
 public static void main(String args[]) {
  byte x;
  int a = 270;
  double b = 128.128;
  System.out.println("int converted to byte");
  x = (byte) a;
  System.out.println("a and x " + a + " " + x);
  System.out.println("double converted to int");
  a = (int) b;
  System.out.println("b and a " + b + " " + a);
  System.out.println("\ndouble converted to byte");
  x = (byte)b;
  System.out.println("b and x " + b + " " + x);
 }
}
```
