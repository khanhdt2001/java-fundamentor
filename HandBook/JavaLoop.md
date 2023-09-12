# Java loop
| Comparison       | for loop                                                               | while loop                                                                | do-while loop                                                                     |
|------------------|------------------------------------------------------------------------|---------------------------------------------------------------------------|------------------------------------------------------------------------------------|
| **Introduction** | The Java for loop is a control flow statement that iterates a part of the program multiple times. | The Java while loop is a control flow statement that executes a part of the program repeatedly based on a given boolean condition. | The Java do-while loop is a control flow statement that executes a part of the program at least once, and further execution depends on a given boolean condition. |
| **When to use**  | If the number of iterations is fixed, it is recommended to use a for loop. | If the number of iterations is not fixed, it is recommended to use a while loop. | If the number of iterations is not fixed, and you must execute the loop at least once, it is recommended to use a do-while loop. |
| **Syntax**        | ```java for(init; condition; incr/decr){ // code to be executed }```  | ```java while(condition){ // code to be executed }```                  | ```java do{ // code to be executed } while(condition);```                        |
| **Example**      | ```java //for loop for(int i=1; i<=10; i++){ System.out.println(i); }``` | ```java //while loop int i=1; while(i<=10){ System.out.println(i); i++; }``` | ```java //do-while loop int i=1; do{ System.out.println(i); i++; } while(i<=10);```  |
| **Syntax for infinite loop** | ```java for(;;){ // code to be executed }``` | ```java while(true){ // code to be executed }``` | ```java do{ // code to be executed } while(true);``` |


