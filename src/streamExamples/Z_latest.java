package streamExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/* Let's start with a building block pre-requisite:
 * 
 * 🧩🧩 1. When a Variable Stores What It Should
    ______________________________________________
        Here’s a normal case — everything works fine:
        
        String animal = "Zebra";   // animal variable now points to a real String object created in memory.
        System.out.println(animal);  // ✅ prints: Zebra
        System.out.println(animal.length());  // ✅ prints: 5
        
        💡 Explanation

The variable animal is of type String.

The "Zebra" literal creates a real String object in memory.

animal now points to that object’s location.

When you call .length(), Java can go to that memory location, read the string, and return its length.

 
 * 🧩🧩 2. When a Variable Stores null
    _____________________________________________
        Now, watch what happens when we don’t assign anything real:
        
        String animal = null;   // animal points to nothing (no string object is created in memory).
        System.out.println(animal);   // ✅ prints: null
        System.out.println(animal.length());  // ❌ crash: NullPointerException

💥 Error Output: Exception in thread "main" java.lang.NullPointerException

      💡 Why it crashes:

- animal doesn’t point to any String object created in memory.

- You asked for animal.length(), but there’s no object to get the length from.

- So the JVM throws a NullPointerException — literally saying:

- “You tried to use an object reference that is null.”
________________________________________________________________________________________________________
                                              🧠 Visual Analogy
| Variable                   | Points To                         | Safe to Use?  | Example                                         |
| -------------------------- | --------------------------------- | ------------  | ----------------------------------------------- |
| `String animal = "Zebra";` | 🟩 A real String object in memory | ✅ Yes        | `animal.length()` works                         |
| `String animal = null;`    | ⛔ Nothing                        | ❌ No         | `animal.length()` throws `NullPointerException` |

 * 
 * 🧩🧩 3. Avoiding This with Optional
 * ________________________________________
 * Instead of doing this:-
 * 
 * String animal = null;

 * 
 * You do:-
 * 
 * Optional<String> animal = Optional.empty();  // safe container, empty inside

 * 
 * Then you can safely check:
 * 
 * if (animal.isPresent()) {
    System.out.println(animal.get());
} else {
    System.out.println("No animal found.");
}

✅ No crash, even though it’s empty.
That’s the power of Optional: it replaces null with a safe, explicit “empty” object.

*************** This is the reason ✅ Why Optional Was Invented ************
Where, Before Java 8, developers often wrote:

String result = getAnimal();
if (result != null) {
    System.out.println(result.toUpperCase());
}

where If they forgot that 'if statement', result could be null, boom 💥 — NullPointerException.
But now with Optional, you’re forced to handle that possibility explicitly:


// Suppose getAnimal() might return null — we wrap it in Optional
Optional<String> result = Optional.ofNullable(getAnimal());

// Safely unwrap it with a fallback value if it's empty
String animal = result.orElse("Unknown");

// Now safely use the value without risking NullPointerException
System.out.println(animal.toUpperCase());


____________________________________________________________________________________________________________________________________________________
____________________________________________________________________________________________________________________________________________________
Now Let’s explore how a variable that starts with a real value can later become null, often leading to a NullPointerException if we’re not careful:

🧩 1. A Normal Flow — Value Is Assigned and Used Safely
_______________________________________________________
public class AnimalExample {
    public static void main(String[] args) {
        String foundAnimal = findAnimal("lion");
        System.out.println(foundAnimal.toUpperCase());  // ✅ prints: LION
    }

    static String findAnimal(String name) {
        // Pretend we have a database of animals
        if (name.equalsIgnoreCase("lion")) {
            return "lion";
        } else {
            return null;   // No such animal found
        }
    }
}

🧠 Explanation

When findAnimal("lion") is called → the method returns "lion".

So foundAnimal stores a real String → "lion".

The .toUpperCase() call works fine.


🧩 2. The Moment It Breaks — Variable Becomes null
____________________________________________________
Now change the input to something the method doesn’t know:

public class AnimalExample {
    public static void main(String[] args) {
        String foundAnimal = findAnimal("zebra");
        System.out.println(foundAnimal.toUpperCase());  // ❌ NullPointerException
    }

    static String findAnimal(String name) {
        if (name.equalsIgnoreCase("lion")) {
            return "lion";
        } else {
            return null;   // "zebra" not found
        }
    }
}

💥 What happens

findAnimal("zebra") returns null.

So foundAnimal now stores null.

Calling .toUpperCase() on it = trying to access a method on nothing.
Java crashes with:

Exception in thread "main" java.lang.NullPointerException

🧠 Step-by-Step Variable States
| Line                  | Code             | Value in `foundAnimal` | Result                |
| --------------------- | ---------------- | ---------------------- | --------------------- |
| `findAnimal("lion")`  | returns `"lion"` | `"lion"`               | Safe                  |
| `findAnimal("zebra")` | returns `null`   | `null`                 | ❌ Crash when using it |

🧩 3. Fixing It the Old Way (Before Optional)
______________________________________________
Developers would protect against it manually:

String foundAnimal = findAnimal("zebra");

if (foundAnimal != null) {
    System.out.println(foundAnimal.toUpperCase());
} else {
    System.out.println("No animal found.");
}

✅ No crash.
But you have to remember to check for null every single time — which is error-prone.

🧩 4. Fixing It the Modern Way (With Optional)
_______________________________________________
static Optional<String> findAnimal(String name) {
    if (name.equalsIgnoreCase("lion")) {
        return Optional.of("lion");
    } else {
        return Optional.empty();
    }
}

Now the main method:

public static void main(String[] args) {
    Optional<String> foundAnimal = findAnimal("zebra");

    foundAnimal.ifPresentOrElse(
        a -> System.out.println(a.toUpperCase()),
        () -> System.out.println("No animal found.")
    );
}

✅ Output:  No animal found.

No crash.
The code forces you to handle the “empty” case.

🔍 Summary Mental Model
| Concept                | Meaning                                                          | Example                                                  |
| ---------------------- | ---------------------------------------------------------------- | -------------------------------------------------------- |
| Value stored normally  | Variable points to a real object                                 | `"lion"`                                                 |
| Value becomes `null`   | Variable points to *nothing*                                     | `null`                                                   |
| `NullPointerException` | You try to call a method or access data through a null reference | `foundAnimal.toUpperCase()` when `foundAnimal` is `null` |
| `Optional`             | Safe wrapper that makes “no value” explicit                      | `Optional.empty()`                                       |

so before the implementation of the 'Optional' wrapper:
	in the case of, for example, the .findFirst() method, one could get Null value if no data is found.
	In this case, the NullPointerException would be thrown if a method is applied to Null (instead of the data that is found)
	.In order to fix this, Java developers tweaked the .findFirst() method so that it returns Optional wrapper class around the intended 
	data type (String, WebElement, etc.)

“Before Java 8, developers had to guard against null with repetitive if-statements to avoid NullPointerExceptions. Java 8 introduced Optional, 
a wrapper that represents a value that may or may not be present. If absent, it doesn’t hold null but instead becomes an empty Optional, 
which is safer and forces the developer to explicitly handle the case of no value.”

**************************************************************************************************************************************************
**************************************************************************************************************************************************
Where does that fit into Selenium Automation ?

Answer: There exists the Java Stream method .findFirst() which returns, according to editor's suggestions,
        an Optional wrapper class around the intended data type.
        For example:
        
         Optional<WebElement> wantedElement_productBoxBorder = elements_ProductBoxBorders.stream()
                 .filter(s -> productNameBox(s).getText().equalsIgnoreCase("iphone 13 pro"))
                 .findFirst();
                 
         So if an element is found, it will be stored as a WebElement in the "wantedElement_productBoxBorder" variable.
                                    If not, then "wantedElement_productBoxBorder" will store nothing at all.
         This is where one should seize the opportunity by chaining the following method:
         .orElseThrow(() -> new NoSuchElementException("Product not found"));
         
         So that we have:
         
         WebElement wantedElement_productBoxBorder = elements_ProductBoxBorders.stream()
                 .filter(s -> productNameBox(s).getText().equalsIgnoreCase("iphone 13 pro"))
                 .findFirst()
                 .orElseThrow(() -> new NoSuchElementException("Product not found"));
         
         Which reads:
         If the first element is found, then it will be stored as a WebElement data type into the variable  "wantedElement_productBoxBorder"
         and if no element exists, then throw the compiler error/exception that is 'NoSuchElementException' with the msg "Product not found"
         
         And this is what is EXACTLY sought after in Automation testing.
         
         Additional note: for the last snippet above: 100!
         “If .filter() finds no matching elements, the downstream pipeline operates on an empty stream, which leads .findFirst() 
         to return an empty Optional. Then .orElseThrow(...) ensures an exception is thrown instead of silently returning null.”
**************************************************************************************************************************************************
*************************************************************************************************************************************************
 */
public class Z_latest {

	public static void main(String[] args) {
		
		List<String> animals= Arrays.asList("Spider", "Fish", "Snail");
		
		Optional<String> chosenAnimal= animals.stream().filter(s->s.startsWith("S")).findFirst(); //.findFirst() method returns Optional.
		//'Optional' means'chosenAnimal' may store a value or is empty.
		// Optional<T> is a wrapper (container) class that may or may not hold a single non-null value of type T. 
	
		
		chosenAnimal.stream().forEach(s->System.out.println(s)); // output: Spider
		System.out.println(chosenAnimal);  // output: Optional[Spider] 
		System.out.println("============");  // output: Optional[Spider]
		
		
		Optional<String> selectedAnimal= animals.stream().filter(s->s.startsWith("z")).findFirst();
		selectedAnimal.stream().forEach(s->System.out.println(s)); // output: nothing/ not even an empty space, as if this line wasn't written in the first place)
		System.out.println(selectedAnimal);  // output: Optional.empty
		
		/* I decided to continue with these examples instead:
		 * 
		 * 🧩 1. The “Classic” (Old) Way — Risk of null

           Before Java 8, you’d probably write something like this:
           
           import java.util.*;

public class ClassicSearch {
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("lion", "tiger", "elephant");

        String foundAnimal = findAnimalStartingWith(animals, "z");
        System.out.println(foundAnimal.toUpperCase());  // ❌ possible NullPointerException
    }

    static String findAnimalStartingWith(List<String> animals, String prefix) {
        for (String a : animals) {
            if (a.startsWith(prefix)) {
                return a;
            }
        }
        return null;  // nothing found
    }
}


💥 What happens:

-"zebra" not found → method returns null.

-Variable foundAnimal now holds null.

-Calling .toUpperCase() → ❌ NullPointerException.

🧠 State of foundAnimal
| Scenario    | Value     | Safe to use? |
| ----------- | --------- | ------------ |
| Found match | `"zebra"` | ✅            |
| No match    | `null`    | ❌ (danger)   |


🧩 2. Streams + findFirst() — The Modern Way

Now, with Java Streams, you can rewrite the same logic declaratively:
		 * 
		 * 
		 * import java.util.*;
import java.util.stream.*;

public class StreamSearch {
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("lion", "tiger", "elephant");

        Optional<String> foundAnimal = animals.stream()
            .filter(a -> a.startsWith("z"))
            .findFirst();  // returns Optional<String>

        System.out.println(foundAnimal);
    }
}
🧠 What happens:

- .findFirst() never returns null.

- It returns an Optional<String> — either:

        Optional[<value>] if a match is found, or

        Optional.empty if no match is found.

So you’re always guaranteed a real object, never null.

✅ Example outputs:  Optional.empty       or    Optional[zebra]


🧩 3. Unwrapping Optional Safely

You can safely unwrap it in several ways:
foundAnimal.ifPresent(a -> System.out.println(a.toUpperCase()));

or provide a fallback:
System.out.println(foundAnimal.orElse("No animal found").toUpperCase());

or be strict:
String animal = foundAnimal.orElseThrow(() ->
    new NoSuchElementException("No animal starting with z"));
    
    All three are null-safe — none will cause a NullPointerException.
    
    
    ⚙️ 4. Why Optional Was the Perfect Choice Here

Streams can produce:

  - 0 matching elements,

  - 1 matching element,

  - or many (but we stop at the first).

Because .findFirst() might find nothing, it needs a way to represent “no result” without returning null.
That’s exactly what Optional was created for.

🧠 Summary Mental Model
| Step             | Before Java 8                  | After Java 8 (Streams + Optional) |
| ---------------- | ------------------------------ | --------------------------------- |
| Return type      | `String`                       | `Optional<String>`                |
| “No result” case | return `null`                  | return `Optional.empty()`         |
| Caller behavior  | Must check for `null` manually | Must unwrap Optional explicitly   |
| NPE risk         | ⚠️ High                        | ✅ Eliminated                      |


🧩 Example Recap in One Line

String animal = animals.stream()
    .filter(a -> a.startsWith("z"))
    .findFirst()
    .orElse("No animal found");
    
    ✅ Safe, clean, no null, no try/catch, no if (x != null) needed.

_______________________________________________________________________________________________________________________________
_______________________________________________________________________________________________________________________________
_______________________________________________________________________________________________________________________________
	
		
		// try to fit this somewhere in the Java Streams files examples
		
		/* The terminal operations could be:
		 * 
		 * 1- .forEach(s->System.out.println(s)) // for on-screen display of the outcome of the aggregate operations
		 * 
		 * 2- .collect(Collectors.toList())    // The return type is a list of something (list of webElements or String, etc.)
		 * // what's used in real-time where the new collection (that finished undergoing the aggregate operations) is sent
		 *   to the backend for example.
		 *   
		 *   However, if you want the return type to be a single variable instead of a collection class
		 *   such as (such as WebElement, String, etc.), then use:
		 *   
		 * 3-  .findFirst().orElseThrow(() -> new nameOfTheExceptionHere ("your custom error msg to include"));
		 * 
		 *    // Example:
		 *    findFirst().orElseThrow(() -> new NoSuchElementException("Product not found"));
		 *    
		 *    Notes: 
		 *    A- There also exists .findAny() in addition to the .findFirst().
		 *    B- If you do not want an exception to be thrown then use  .findFirst().orElse(null);
		 *    
		 *    
		 ************************   Let's examine a practical example/ code snippet:  ************************ 
		 *    Example 1:
		 *    
		 *    
		 *    List<WebElement> elements_ProductBoxBorders= driver.findElements(By.cssSelector("div.card"));
		 *    
		 *    WebElement wantedElement_productBoxBorder = elements_ProductBoxBorders.stream()
                 .filter(s -> productNameBox(s).getText().equalsIgnoreCase("iphone 13 pro"))
                 .findFirst()
                 .orElseThrow(() -> new NoSuchElementException("Product not found"));

		 *    
		 *    Example 2:
		 *    
		 *    
		 *   List<WebElement> elements_ProductBoxBorders= driver.findElements(By.cssSelector("div.card"));   
		 *           
		 *   WebElement wantedElement_productBoxBorder = elements_ProductBoxBorders.stream()
               .filter(s -> productNameBox(s).getText().equalsIgnoreCase("iphone 13 pro"))
               .findFirst()
               .orElse(null);
               
               
  If you look in the editor's suggestion for the .findFirst() method, you will see;
                
  .findFirst() return Optional: <WebElement> - Stream
               
   Explanation:
 * 
 * - The .findFirst() method returns an Optional<WebElement>, which may or may not contain a value.
 *   • If a matching element is found, the Optional contains that element.
 *   • If no match is found, it returns an empty Optional.
 *
 * - The .orElse(null) call safely unwraps the Optional:
 *   • If the Optional contains a value → that WebElement is assigned to wantedElement_productBoxBorder.
 *   • If the Optional is empty → null is assigned to wantedElement_productBoxBorder (no exception is thrown).
 *
 * - Alternatively, using:
 *       .orElseThrow(() -> new NoSuchElementException("Product not found"));
 *   • will throw a NoSuchElementException instead of returning null.
 *   • This is often preferred in testing, where failing fast provides clearer feedback that the element was not found.
 */



	}

}
