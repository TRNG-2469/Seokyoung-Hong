## Exercise 1: RosterApp 

I ran RosterApp with the provided code which induced a NullPointerException.

### Stack Trace:
```
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.startsWith(String)" because "studentNames[i]" is null
at RosterApp.main(RosterApp.java:9) 
```

### Prompt (Obviously, I replaced the placeholders with actual values):
My Java program crashes with a NullPointerException with this stack trace at line 9: [insert trace]. 
Here is my code: [insert code]. 
Explain the root cause of the error and provide a clean fix that enforces boundary validation 
checks instead of catching the exception.

### AI Response:
```
public class RosterApp {
public static void main(String[] args) {
String[] studentNames = new String[5];
studentNames[0] = "Alice";
studentNames[1] = "Bob";

        for (int i = 0; i < studentNames.length; i++) {
            if (studentNames[i] != null &&
                studentNames[i].startsWith("A")) {

                System.out.println("Student: " + studentNames[i]);
            }
        }
    }
}
```

### Evaluation:
The program now runs safely. This is because before trying to access studentNames[i] while the iteration is happening,
there is a boundary check to ensure that studentNames[i] is not null. This prevents the 
NullPointerException from occurring.

## Exercise 2: 

I ran AirportApp with the provided code which induced a ClassCastException.

### Stack Trace:
```
Exception in thread "main" java.lang.ClassCastException: class Airplane cannot be cast to class Car (Airplane and Car are in unnamed module of loader 'app')
at AirportApp.main(AirportApp.java:10)
```

### Prompt: 
My Java program crashes with a ClassCastException with this stack trace at line 10: [insert trace].
Here is my code: [insert code].
Explain the root cause of the error and provide a clean fix that enforces boundary validation
checks instead of catching the exception.

### AI Response:
```
class Vehicle {}
class Car extends Vehicle {}
class Airplane extends Vehicle {}

public class AirportApp {
    public static void main(String[] args) {
        Vehicle myVehicle = new Airplane();

        if (myVehicle instanceof Car) {
            Car myCar = (Car) myVehicle;
            System.out.println("Vehicle downcasted successfully.");
        } else {
            System.out.println("The vehicle is not a Car.");
        }
    }
}
```

### Evaluation: 
This program now works. Before downcasting, it checks if the myVehicle is actually an instance 
of a Car, thus being safe and preventing the ClassCastException from occurring. If not, it 
refuses to downcast and prints a message instead. 

## Exercise 3: Finance App 

I ran FinanceApp with the provided code which induced an ArithmeticException.

## Stack Trace: 
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
at FinancialApp.computeScore(FinancialApp.java:3)
at FinancialApp.main(FinancialApp.java:8)
```

## Prompt: 
My Java program crashes with an ArithmeticException with this stack trace at line 3 for method computeScore: [insert trace].
Here is my code: [insert code].
Explain the root cause of the error and provide a clean fix that enforces boundary validation
checks instead of catching the exception.

## AI Response: 
```
public class FinancialApp {

    public static double computeScore(int totalScore, int divisor) {
        if (divisor == 0) {
            System.out.println("Error: Divisor cannot be zero.");
            return 0.0;   // or another appropriate default value
        }

        return (double) totalScore / divisor;
    }

    public static void main(String[] args) {
        System.out.println("Processing report...");
        double value = computeScore(100, 0);
        System.out.println("Calculated Value: " + value);
    }
}
```

### Evaluation:
This program now works. Now it explicitly checks the divisor before performing the division operation. 
If the divisor is zero, it prints an error message and returns a default value, 
preventing the ArithmeticException from occurring.