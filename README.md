# Implement EventStore

In this challenge, you will create a class that implements the `EventStore` 
interface.
 
```java
public interface EventStore {
    void insert(Event event);

    void removeAll(String type);

    EventIterator query(String type, long startTime, long endTime);
}
```

Your implementation should store events in memory, using any data structures 
you see fit for the task. The required behavior for the interface is described in the
provided code javadocs, please see `EventStore` and `EventIterator`
interfaces inside the `src/main/java` directory.
 
The implementation should be correct, fast, memory-efficient, and thread-safe. 
You may consider that insertions, deletions, queries, and iterations 
will happen frequently and concurrently. This will be a system hotspot. Optimize at will. 

We expect you to:
* Write tests;
* Provide some evidence of thread-safety;
* Justify design choices, arguing about costs 
  and benefits involved. You may write those as comments 
  inline or, if you wish, provide a separate document 
  summarizing those choices;
* Write all code and documentation in english.
  
You may use external libraries, but their use has to be 
properly justified as well.
 
This challenge is intentionally simple, we expect a simple,
elegant, and polished solution. There is no unique solution to this challenge. 
The intent is to evaluate candidate's coding proficiency and familiarity with 
tools and best practices.


## Solve this challenge

To solve this challenge, you may fork this repository, then 
send us a link with your implementation. Alternatively, if you do not want to have this repo on
your profile (we totally get it), send us a 
[git patch file](https://www.devroom.io/2009/10/26/how-to-create-and-apply-a-patch-with-git/) 
with your changes.

If you are already in the hiring process, you may send it to 
 whoever is your contact at Intelie. If you wish to apply for a job at 
 Intelie, please send your solution to [trabalhe@intelie.com.br](mailto:trabalhe@intelie.com.br).


## Wrote by vitor

I using principles S.O.L.I.D to make this structure.
In the first, I write dependenci use with various technologies using the same structure.

Example: I just change TextFile class to another database with the same structure, and I don`t change nothing more in the code, Just change when I call the MainEvent class

## Dependencies resolve
```java
public MainEvent( EventStore newEvent ) 
        {
        this.newEvent = newEvent;
        }
```
I chose using constructor this way because, I begin using Postgres SQL or MySQL, I just change the way I call this function

Example:
```java
public static void main(String[] args)  
        {
        MainEvent mainEvent = new MainEvent(new TextFile("eventFile")); 
        // I just change this new TextFile to another class with implements EventStore interface
        }
```

## why using menu to access file not http access

I chose using menu to access because is easier testing the functions, but when I want to switch to http I just change the main to new Routes with access the MainEvent