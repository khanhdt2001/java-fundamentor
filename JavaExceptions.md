# Exceptions in Java
Exception Handling in Java is one of the effective means to handle runtime errors so that the regular flow of the application can be preserved.

Major reasons why an exception Occurs
- Invalid user input
- Device failure
- Loss of network connection
- Physical limitations (out-of-disk memory)
- Code errors
- Opening an unavailable file

Errors represent irrecoverable conditions such as Java virtual machine (JVM) running out of memory, memory leaks, stack overflow errors, library incompatibility, infinite recursion, etc. Errors are usually beyond the control of the programmer, and we should not try to handle errors.

## Difference between Error and Exception
- Error: An Error indicates a serious problem that a reasonable application should not try to catch.
- Exception: Exception indicates conditions that a reasonable application might try to catch.

## Types of Exceptions
Java defines several types of exceptions that relate to its various class libraries. Java also allows users to define their own exceptions.
![alt text](https://github.com/khanhdt2001/java-fundamentor/blob/main/images/Exceptions-in-Java.png?raw=true)

1. Built-in Exceptions: <br>
Built-in exceptions are the exceptions that are available in Java libraries. These exceptions are suitable to explain certain error situations.
    - Checked Exceptions: Checked exceptions are called compile-time exceptions because these exceptions are checked at compile-time by the compiler.
    - Unchecked Exceptions: The unchecked exceptions are just opposite to the checked exceptions. The compiler will not check these exceptions at compile time. In simple words, if a program throws an unchecked exception, and even if we didn’t handle or declare it, the program would not give a compilation error.

2. User-Defined Exceptions: <br>
Sometimes, the built-in exceptions in Java are not able to describe a certain situation. In such cases, users can also create exceptions, which are called ‘user-defined Exceptions’. 
The advantages of Exception Handling in Java are as follows:
- Provision to Complete Program Execution
- Easy Identification of Program Code and Error-Handling Code
- Propagation of Errors
- Meaningful Error Reporting
- Identifying Error Types

```
// Define a custom exception by extending Exception class
class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            int age = 15;

            // Check if age is below the minimum allowed age
            if (age < 18) {
                throw new MyCustomException("Age is below 18, not eligible.");
            } else {
                System.out.println("Age is eligible: " + age);
            }
        } catch (MyCustomException e) {
            // Handle the custom exception
            System.err.println("Custom Exception: " + e.getMessage());
        }
    }
}

```

## Methods to print the Exception information:
1. printStackTrace() <br>
This method prints exception information in the format of the Name of the exception: description of the exception, stack trace.
```
//program to print the exception information using printStackTrace() method

import java.io.*;

class GFG {
	public static void main (String[] args) {
	int a=5;
	int b=0;
		try{
		System.out.println(a/b);
		}
	catch(ArithmeticException e){
		e.printStackTrace();
	}
	}
}
```
2. toString() <br>
The toString() method prints exception information in the format of the Name of the exception: description of the exception.
```
//program to print the exception information using toString() method

import java.io.*;

class GFG1 {
	public static void main (String[] args) {
	int a=5;
	int b=0;
		try{
		System.out.println(a/b);
		}
	catch(ArithmeticException e){
		System.out.println(e.toString());
	}
	}
}
```

3. getMessage() <br>
The getMessage() method prints only the description of the exception.
```
//program to print the exception information using getMessage() method

import java.io.*;

class GFG1 {
	public static void main (String[] args) {
	int a=5;
	int b=0;
		try{
		System.out.println(a/b);
		}
	catch(ArithmeticException e){
		System.out.println(e.getMessage());
	}
	}
}
```
## How Does JVM Handle an Exception?
Default Exception Handling: **Whenever inside a method, if an exception has occurred, the method creates an Object known as an Exception Object and hands it off to the run-time system(JVM)**. The exception object contains the name and description of the exception and the current state of the program where the exception has occurred. Creating the Exception Object and handling it in the run-time system is called throwing an Exception. **There might be a list of the methods that had been called to get to the method where an exception occurred. This ordered list of methods is called Call Stack**. Now the following procedure will happen. 
- The run-time system searches the call stack to find the method that contains a block of code that can handle the occurred exception. The block of the code is called an Exception handler.
- The run-time system starts searching from the method in which the exception occurred and proceeds through the call stack in the reverse order in which methods were called.
- If it finds an appropriate handler, then it passes the occurred exception to it. An appropriate handler means the type of exception object thrown matches the type of exception object it can handle.
- If the run-time system searches all the methods on the call stack and couldn’t have found the appropriate handler, then the run-time system handover the Exception Object to the default exception handler, which is part of the run-time system. This handler prints the exception information in the following format and terminates the program abnormally.

### Need for try-catch clause(Customized Exception Handling)
```
try {
    // block of code to monitor for errors
    // the code you think can raise an exception
} catch (ExceptionType1 exOb) {
    // exception handler for ExceptionType1
} catch (ExceptionType2 exOb) {
    // exception handler for ExceptionType2
}
// optional
finally {  // block of code to be executed after try block ends 
}
```
# <span style="color: red;">Programer must aware err and able to find err type to catch it </span>