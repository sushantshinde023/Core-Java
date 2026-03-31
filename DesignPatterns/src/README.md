# Design Patterns

- Design patterns are the template for already know problems

## Creational Design Pattern

- What is creational Design Pattern ?

  - A set of patterns to help manage the complexity of growing programming logic
  - Suppose we have class Invoice , now whenever we create invoice object we will use new Invoice() so many places.
  - What happens when we need to change the constructor ?
  - or what if we need a different configuration for different invoice type?
  - this will be tricky as our code is tightly coupled to invoice class and how invoice objects are created
  - so we have to change it everywhere
  - Creational design patterns provides solution for such problems
  - There are two main themes that are common to most creational pattern

    1. The first is that they encapsulate knowledge about which concrete class should be used
    2. The second one is that they conceal(Keep secret/Hide) how objects are created

  - Creational design pattern increases flexibility by decoupling object creation from its usage

### Avoiding Complex constructors(Builder Pattern)

  - One common problem is that we end up with large constructors where we have to pass in lots of different parameters
  - Suppose we have class that represents Person
  - A Person can have lots of different attributes like First name, Last Name, Middle Name, Email Address, Street Address,ID Number,Date of Birth
  - Among these some of the attributes are mandatory(first name, last name, date of birth) and others could be optional
  - So while creating we might want to create with name, date of birth and middle name But another time, we might want to create one with Just with first name, last name, email address and another time we might want to create with first name and last name, date of birth, middle name and email
  - So there are multiple combinations we could have
  - Let's assume that person object is immutable, we can't change it later
  - So how might the constructor of a person object look in Java code

```java
public Person(String firstName,String lastName,String middleName,String emailAddress,String phoneNumber,String streetAddress,Long idNumber,LocalDate dateOfBirth){
        ---
        ---
}
```

-Here we need to pass long list of parameter to the constructor and for the optional ones we don't want to pass we will pass null
-There are few problems with this
	- It's quite messy and it's easy to get things in wrong order
	- if we take look at when the constructors is called
	
Person person=new Person("John","Doe",null,null,1234567,null,null,LocalDate.of(1996,12,10));

- It's almost impossible to know what things are being passed in and it would be really easy to pass the wrong parameter in wrong place

- So What are the alternatives

  1. One option is to create different constructors for all different combinations but this isn't practical either, There would be lots of different constructors and that would be really hard to read
  2. It's also might not be possible if some of the arguments of the same type. Java won't know the difference between two different constructors that pass in three different strings for example

- The solution to this problem is Builder Pattern

  - In this pattern we have a separate class that's used to construct object using just the fields that we want and this class is called builder

  Director ---> Builder ---> ConcreteBuilder ---> Product(Person in this case)

  - In Traditional pattern there is an interface for the builder pattern and then the concrete implementation
  - The product is the class that would otherwise have the big constructor, so in this example it would be person
  - And the Director is the class that use the builder to create the object

  - In Java it's simplified to only have ConcreteBuilder without the interface

  Director ---> ConcreteBuilder ---> Product(Person in this case)
 - Before builder we create object for person like below
 
 		
		var person2= new Person("Jerome", null,"donaldson", null,null,"123456789"); 
		
 - So We can create Builder class as inner class , for which we are going to use builder. It will be a static class
 - For that static class we will create constructor with mandatory fields and for optional fields we will create methods whcih take argument as same type and return type whatever the class name in our case PersonBuilder
 
 - We will also have build method which will written the Product in our case person with all its parameter
 - refer /DesignPatterns/src/com/sushant/builder/pattern/Person.java
 
 - Next step instead of keeping constructor of Product class i.e. Person class we mark it as private and instead of passing all parameters to Person Constructor we will pass directly PersonBuilder object as parameter and while setting fields we will use lik
 
 Before
 
 ```java
 	private Person(String firstName, String middleName, String lastName, LocalDate dateOfBirth, String emailAddress,
			String phoneNumber) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		
		if(firstName== null || lastName ==null) {
			throw new IllegalArgumentException("Firstname and lastName must not be null");
		}
	}
	
	and build method before from PersonBuilder
	
	//after that we will have build method
		public Person build() {
			return new Person(firstName,middleName,lastName,dateOfBirth,emailAddress,phoneNumber);
		}
 ```
 
 After
 
  ```java
 private Person(PersonBuilder personBuilder) {
		super();
		this.firstName = personBuilder.firstName;
		this.middleName = personBuilder.middleName;
		this.lastName = personBuilder.lastName;
		this.dateOfBirth = personBuilder.dateOfBirth;
		this.emailAddress = personBuilder.emailAddress;
		this.phoneNumber = personBuilder.phoneNumber;
		
		if(firstName== null || lastName ==null) {
			throw new IllegalArgumentException("Firstname and lastName must not be null");
		}
	}
	build method after
	
	//after that we will have build method
		public Person build() {
			return new Person(this);
		}
		
//Object Creation

var person2=new Person.PersonBuilder("Jerome", "donaldson").phoneNumber("123456789").build();

```

### Singleton Pattern

- Why to use Singleton Pattern

- It is also sometimes known as an anti pattern because there are some issues which can be caused by using it
- But when used correctly there are situations
- Normally when we create class in java, we expect to instantiate many different objects of that class
- for example if we have class Car, we would probably have several places in our code where we create new Car object 
- but with singleton pattern we are preventing this from happening. We make sure there can only ever be one instance of that class

###### But why we want to do this ?

- Suppose we have resource that is shared across our application like database
- we might have class that controls access to the database, and in that case we would only want one object of that class
- Otherwise we could have a situation where multiple objects are trying to write to the same table using different instances of our DatabaseAccessor class
- so some examples of where it might make sense to use the singleton pattern are 
		1. controlling connection to a database
		2. Access to configuration files
		3. Access to hardware resources such as printer
		4. Loggers - well known use case


- One of the things to consider when implementing this pattern is Thread safety
- If we have multiple threads in our application, each one could create a new instance of singleton which defeats the point
- so this is something we will see
- One of the reason that people don't like the singleton pattern is that in object oriented programming a class should only do one thing that is Single Responsibility Principle from SOLID principle, but with the singleton class it does two things

	- It does whatever logic the class is supposed to do e.g. control access to a database
	- It also ensures only one instance is created

- Singletons are also make our code difficult to test because the objects that use the singleton are tightly coupled to the singleton object
- So sometimes we can use other solutions e.g. dependency injection instead of using the singleton pattern
- However if we have a use case where we want to have only one single instance of the class , the singleton pattern will allow us to do this
- make class final and create private constructor
- then create static instance like private static PrintSpooler INSTANCE;
- because we want to have single instance expose method to create new INSTANCE but create only if existing instance is null

 ```java
public static PrintSpooler getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new PrintSpooler();
		}
		
		return INSTANCE;
	}
	
```


### Prototype Pattern

- With prototype pattern , the interface at the top of the hierarchy defines a clone method and then Tree class also has clone method, this clone method means that we can copy the configuration of an existing objects without having to complicate the class hierarchy

- Think of the Sheep that was cloned.
- The prototype pattern essentially does this for java objects, so that similar objects don't have to be configured multimple times
- One thing to note that there is interface called Cloneable(The interface has no method and throws exceptions that must be handles) in java, One way to implement this pattern is to use this Cloneable interface
- However there are some issues with this interface that is worth knowing about.
		- firstly , it has no clone method, so using it doesn't really tell us much about what the implementing class is going to do and it's also a bit of hassle to implement.
		- we have to implement the interface and handle the exception it throws without any real benefits
	
- So for these reasons Cloneable interface is often avoided in java
- We will be using the approach called Copy constructor, which is bit simpler to implement
-  Prototype pattern removes duplicate code   	  
-  However the clone method is used to only create shallow copy of the pizza object, we have assumed that non of the pizza fields are going to change
- let's look at the drawbacks of shallow copy approach
-In OrderTracker class we have created Hawaiian pizza and cloned several time, but lets say that later on we want to change the flavor of the first pizza after we have cloned it

hawaiian.setName("hawaiian with extra cheese");

- this changes the the flavor for all of the cloned pizzas as well as for the original  pizza
- This is because the pizzaFlavor field for each cloned pizza is the same PizzaFlavor object, and if that's the functionality that we want then everything is fine and we don't need to change anything
- But if we want to avoid accidentally updating all of the cloned objects then deep copy needs to be made instead of shallow copy, so to fix this, we need to change our clone method


### Factory Method Pattern

- The factory method is a pattern that handles deciding which type of concrete class needs to be created by another class
- E.g. Imagine there's an application called a ticket machine which creates ticket for public transport. Initially the ticket machine might only create bus tickets, so thats straightforward to implement. We will have TicketMachine class and a Ticket class and TicketMachine creates Ticket objects.But later we might want to have ticket machine that sell different types of tickets, like train tickets. So in our code we might need to introduce a ticket interface with two concrete implementations called bus ticket and train ticket.The problem is that the TicketMachine class doesn't know in advance which ticket it needs to create. This is the problem that the factory method pattern solves.

- There are couple of different variations of this pattern
- One variation is to have a factory method inside creator, so in this case , the TicketMachine would have a createTicket methods that can return different types of tickets.
- createTicket method will take a parameter that would be type of ticket either bus or train and then it would return the correct concrete type based on that parameter
- The alternatives i sto create different types of ticket machine that are responsible for creating different types of tickets.
- so bus ticket machine will create bus tickets and train ticket machine creates Train ticket.
- Here TicketMachine class is a factory and tickets are the products
-Use the factory pattern when a class has to create instances of another class bu it doesn't know in advance what the concrete type of that class should be

### Abstract Factories Pattern

- Sometimes we have frameworks that use groups of classes together, and there might be different flavors of the framework that should be available for the clients using it to choose from
- This framework would be made up of family of classes
- E.g. Imagine a user interface that come in different color schemes. The framework to render the interface is made up of a family of objects. like there would be an interface called button and then concrete classes for each different color(Red and Blue) and same for other parts of interface like scrollbars and toolbars and so on. The user interface should be able to return the right objects to create the right color scheme. If the client wants a blue application, it should return a blue button a blue toolbar and a blue scrollbar and so on.

- There are few constraints that needs to be enforced to make this work

	1. They should be independent of how objects are created, so the user interface shouldn't be coupled to things like how button objects are created
	2. It should be configured with one of multiple families of objects. so for example the user interface should either use groups of blue objects or red objects
	3. The family of related objects should be used together, so they should either be all blue or all red.
	
- If we have a group of objects with different variations that should be used together like above case, the abstract factory pattern is good way to go 
- class Diagram for this pattern can look complex, because there are so many classes involved.

- So to implement above example we will have UIFactory interface which will have two concrete implementations RedUIFactory and BlueUIFactory. These would be responsible for creating all the different elements of UI e.g. the BlueUIFactory would create a blue button, blue toolbar and so on.RedUIFactory return red versions of these. The next part of the pattern is to have a factory that the overall application can use to determine which of these color scheme factories to use. The Application composite the color scheme at once and the factory will return the right one. So if the Application passes in red , it will use RedUIFactory and if it passes the blue, it will use the blue UI factory

- So this pattern  is essentially a factory of factories
- One Drawback is that there are lot of classes in this pattern implementation which can make it hard to keep track of. Each time when we add new color or new UI Element, there are lot of new classes to create
- The positive is this means that the application itself doesn't need to know anything about all the different families and how the objects are created behind the scene. It only needs to know  about the user interface factory and everything else is hidden and it turn the user interface factory only needs to know about its concrete implementations as they handles the actual creation of the UI objects like buttons,scrollbars etc
- Another nice thing about this pattern is that each part of it is quite easy to unit test, concrete classes are injected as dependencies which means they can easily be mocked
- Here there is tight coupling in buildBike method from BikeManufacturer class as we are using if else all we need to remember which type of bike and which type of parts we have to pass
- if we miss anything it will be mess
- to reduce coupling we will use abstract factories

## Structural Design Pattern

- Structural design patterns are all to do with how classes and objects are put together to form larger structure
- As these structures get bigger over time they can often get more complex, so these patterns are ways of tackling that complexity and simplifying these structures
- There are two different categories of structural design pattern

	1. Class Patterns - These focuses on classes
	2. Object Patterns - These focuses on Objects
	
- we can think of difference between class patterns and object patterns as the difference between "is-a" relationship and "has-a" relationship
- e.g. A car is a Vehicle and Car has engine
- Class patterns are concerned with is-a relationship. They are all to do with how classes are structured and interacts,and there is a particular focus on how inheritance is used to create structure.Several of these patterns make use of interfaces to define shared functionality
- Structural object patterns , on other hand,  are concerned with the "has-a" relationships. They are all about how to use objects, and structural patterns can allow you to change the behavior of individual object at runtime.

### Adapter Pattern

- The adapter pattern allow classes to work together when they normally wouldn't be able to.
- Imagine a plug adapter, if we have US plug and we travel to europe, we can't put our plug straight in the socket , we need an adapter and this allows the US plug and european plug socket to work together. This is the concept that the adapter pattern is all about
- Suppose we have two classes that can't normally work together because they have incompatible interfaces, and then we put an adapter in between them so that they can work together
- This is the pattern that's most often used when working with existing code, rather than writing new code. 
- If we are writing something new , we have to just make sure that the classes we wanted to communicate would be able to. But if we are working with existing code and we can't or don't want to change it , the adapter pattern can be nice solution
- One example where we have a legacy code base and we need to add some new features to it. we might not want to change the existing code base because we don't want to risk breaking something, especially if there are no tests or we might not even have access to it, if it's in a third party  library
- There are two different types of adapter pattern

	1. Class Adapter
	2. Object Adapter
	
- The object version is more common in java because the class version relies on multiple inheritance. This isn't technically possible in java because we can't have classes that extend more than one class but the version of this can be achieved by using interface.
- The object version of the pattern uses composition. This means that the adapter has an instance the adaptee as a field for that class, so that's the example of a hs a relationship
- The class version uses inheritance, so in this case the adapter is subclass of daptee, so that's an is-a relationship
- These two patterns can both be useful depending on the  specific use case

### Bridge Pattern

- The bridge pattern is all about using inheritance while maintaining flexibility
- When we inherit from other classes, those classes become quite closely coupled together, but what if we want the child classes to have more flexibility about how they are maintained?
- Let's say there is hierarchy of shapes. At the top Shape interface is there and below that there are the classes that extend shape like Circle,square etc. But then the different type of shape can also be of different colors. So there's a separate hierarchy with an interface called color and different implementations called red, blue etc.

- So how do we handle this ?
- One option would be to add new classes for all different shapes and all the different color combinations but this would quickly lead to the need for lots of new classes.
- The solution is to use the bridge pattern. In this pattern the shape interface has a color field, and this can be set for all the different objects. So that means we don't have to make all those extra classes.Instead when a new concrete shape is created  the color is set as field,
- So the main idea for bridge pattern is to use composition over inheritance
- In this case a shape has color rather than shape is a color.
- Use this pattern when we have a class hierarchy but we want to keep it flexible and allow the different concrete implementations to be configured in different ways.


### Composite Pattern

- The composite pattern allows you to trace objects and groups of objects in the same way.
- e.g. Lat's say you have checklist app that contains a checklist made up of to-do items. So there would be a class called Checklist and that class would contain a collection of To-Do Item objects and let's say i want to have a method that will tell me if a to-do item has been completed or not. And i also want to have the same method in the Checklist class. The checklist is complete if all of the to-do items in the checklist are also complete.
- The way i do this is with the Composite pattern. So you would have either an interface or an abstract class that both the composite and the parts of the composite both inherit. So in the Interface(TaskComplete) i could have method called boolean isComplete() the ToDo class can implement this and then in the Checklist class, it can also implement the same method. For each ToDo item in the list it can call this isComplete() method for each of those items

- So the composite pattern lets you treat objects and composites of objects in same way and it also means that the clients using the composites can ignore differences between the composites and its parts e.g. A client could use the isComplete() method for the checklist and also for the individual to-do items in the same way because they inherit from the same interface.


### The Decorator Pattern

- The Decorator pattern change the behavior of an object without having to create a new subclass for that behavior
- e.g. you have an app for creating rooms that are decorated in different styles. So you might start off with a blank EmptyRoom Class, but then you want to have a room with couch in it, so you would have a RoomWithCouch class. And then you might have a room with couch and table(RoomWithCouchAndTable) in it, so you would have a class representing a RoomWithCouchAndTable. and then there might be lots of different combinations for lots of different types of furniture. You can see that if i had different subclasses for all those furniture different combinations it would get out of  hand very quickly. 
- The solution is to use a decorator pattern. The first part of this pattern is that you have an interface at the top, so in this case a Room interface and then concrete implementation of that room interface. One Concrete implementation could be RoomImpl, which represents an empty room with no decoration. Next there's another interface or an abstract class underneath Room interface(which is base) called RoomDecorator. Then there are concrete implementations of this decorator class for each of the different decorations you want to have like RoomWithCouch,RoomWithLamp etc.
- These decorations take a concrete room object as an argument to  their constructor like

	var room =new RoomImpl();
	var roomWithSofa=new RoomWithSofa(room);
	
- And we can do this as many times as you want 

	var roomWithLamp=newRoomWIthLamp(room);
	var roomWithBed=newRoomWithBed(room);
	
- so in this case you will end up with room with sofa,lamp and bed
-So this design cuts down on number of classes we need because you don't need one for each different combination of declarations
- Each new object that's created can have its own specific functionality without affecting other objects.

- It allows for the dynamic addition of functionalities to objects without modifying their structure

### Facade Pattern

- The word facade can mean a deceptive outward appearance, and in this case it means that you have simple interface that hides the complexity of the code behind it. e.g. Think about when you write an email and click on send, there's a lot going on behind the scenes when we click on that send button , but most people aren't thinking about the technical things behind the scenes every time they send an email and we certainly don't need to know how email protocols work in order to send one. So in this example the send button is facade that hides the complexity of sending an email.
- Facades are needed in software because it's common to break large systems down into smaller parts, often with lots of dependencies between them . This is generally a good thing because it makes systems more reusable and easier to customize , but it can also make it harder to use. A client want to use a system like this would have to interact with all classes underneath. This means that it can make the most of the possible customizations, but sometimes the client might not care about those and still has to use all the classes anyway.
- So facade is used as a single , simpler interface to those complex systems e.g. RestTemplate → hides HTTP complexity , JdbcTemplate → hides JDBC boilerplate
- Then the client can just use this simple facade interface to do everything at once.
- As well as being simpler it helps to minimize the dependencies between the client and the subsystems. The other nice thing is that you don't have to use the facade if you don't want to just because it's there, you can directly access the classes or subsystems underneath if you want to.
- The facade pattern can be helpful when you want to provide a simple interface to a complex subsystem


### Flyweight Pattern

- The flyweight pattern is all about minimizing memory usage.  It does this by reusing  objects that have already been created rather than using new ones. Java String Pool is best example
- One example in which this pattern is used that is Word processor, when someone types a sentence each letter could be new object so if someone write long document there are going to lot of objects, But with the flyweight pattern, you have only one object for each letter, so one 'a' object, one 'b' object, and so on, and these can be reused.
- This way less memory is used for storing all the different letters as typed. The way this is usually implemented in java is that you have factory class with a map for example HashMap.Then when someone types the letter a, it checks if there's an object with the key 'a' inside the map. if not then creates one and puts it in map. If there's one already there, it reuses that one. The only thing that's different about each letter 'a' is it's position in that document. So the object has states, which is immutable for example the name of the letter. This immutable state should only be controlled through the factory and then there should be mutable states for example the position. 
- This is similar concept to cache, the idea is that if the data is already there and can be reused it should be.
- This is especially useful if it's computationally expensive to create new objects. So you should use this pattern when you want to save memory by reusing objects instead of creating new ones.

### Proxy Pattern

- In the proxy pattern , a proxy is a class that controls access to the functionality on another class
- E.g. imagine that you have a class that does some expensive setup when you create a new instance of it.When describing this pattern , this class is sometimes referred to as the Subject. So let's say for example that the first time the subject is used, it has lots of expensive calls to a database, and then later it does something with the data . This code might be in a third-party library,so you might not have access to it. In this case , you only want the expensive setup to happen once, the first time the object is created. After that , you just want to do the part where it processes the data.You don't really want the classes that call this code to have to implement the logic about only doing this setup once. So in this case , you would have a proxy object in between , and that controls access to the  class with the expensive setup. Then the client just calls the proxy.. It doesn't need to know about this complex setup.
- So the proxy can be used to only initialize objects on demand for optimization or for example if you only want people with certain privileges to be able to do something , the proxy could be used to control who performs a certain action.
- Another use case is when you have an object that resides in a  different address space , you could use proxy to hide that fact from client.
- A proxy controls access to another objects, which you might want to do for a number of different reasons.  
 
## Behavioral Design Pattern

- Behavioral design patterns are about how objects assign responsibilities between each other.
- They are concerned with how objects are connected , how they communicate with each other and how responsibilities are assigned between them. They are often to do with complex control flows.
- Like structural design pattern , there are some behavioral patterns that are focused on classes and some of that are focused on objects

	1. Class patterns
	2. Object patterns
	
-  Class behavioral patterns use inheritance to share behavior between different classes
-  Object patterns look at how objects can work together to get things done that couldn't be done by a single object on its own.
- Some other object patterns are more focused on encapsulating  behavior in a single object and then delegating requests to it.

### Chain of Responsibility Pattern

- The aim of the chain of responsibility pattern is to decouple the sender of request from the receiver of the request.
- E.g. you have a logger, sometimes you want the logger to print output to the console and sometimes you want it to write to a file. So when you have some code that logs something, at that point , it needs to know whether to write the log to the console or to a file. The chain of responsibility pattern can be used as a way of working out which one to send it to at runtime. for example it could first check if the logger is a type of logger  that prints to console . If it is , then it prints the log to the console and that's the end of chain. However the answer is no it could pass it along the chain and check if it's a logger that prints to a file, if it is then prints the log to the file and that's the end of chain.
- In this scenario, It's the responsibility of the  logger that prints to the console to pass it along the chain to the next possible option.
- One thing to be careful of is making sure you don't accidentally end up stuck in a circle. like if the file logger has a reference to the console logger as the next one to check  you would end up in an endless loop.If you have lots of links in the chain this could accidentally happen quite easily.
- The advantage of using this pattern is that it decouples the sender of the request from the receiver. E.g. The logger  doesn't need to know in advance if it is writing to the console or a file.
- One thing to consider is that there is no guarantee that the request is going to be handled. If it reaches the end of the chain and hasn't found an option that fits, then nothing will happen with the request

### Command Pattern

- Sometimes when writing software you need to issue a request, but you might not know in advance what's being requested or what's receiving the request
- So let's think about a real-world example. Imagine someone has written an app for buying and selling things online. The app could be used by lots of different companies selling different things. One example might be a restaurant using it to allow customers to order food online. Another company might use it for selling cloths online. In both the cases, user journey is pretty much the same. The customer is browsing online and they decide they want to order something.So the input their order into the app and that information gets passed from the app to the company. But when the app is being written, we can't say explicitly what kind of thing the customer is going to order. It might be a pizza or it might be pair of shoes. What exactly they are ordering is down to the different companies using the app. We also don't know what will happen after the order is sent, so there might be an immediate response saying the order is on its way or there might be some checks to see if it's in stock or there there might be reply saying that order will arrive in a month.
- The command pattern is a way of making requests when you don't know anything about what exactly is being request or what exactly is receiving it. It does this by encapsulating the request inside an object
-This might seem a bit counterintuitive when you are used to object-oriented design.
- Normally a command is something you would put in a method not a class, But this is useful way of decoupling the objects that invokes the command from the objects that know how to handle it and perform that command.
- So the command pattern is especially useful for commands that you might want to perform later on. for example, they are sometimes used to support undo and re-do operations and things like queuing or logging requests to be performed at different times.

### Interpreter Pattern

- Imagine a scenario where two people are trying to communicate but they don't speak same language. A translator or an interpreter can join them and translates everything they say to each other.
- The interpreter pattern is a way of translating one language into another.
- So if you think of Google Translate for example, it takes the input language and interpret it into a new language. There are many different and varied scenarios where the interpreter pattern might be used.
- It could be used to write custom regular expressions or even write your own compiler or it could  use it to translate human languages or parse SQL or even create simple calculator
- The idea of the interpreter pattern in Java is that if the same problem keeps coming up then you can express that problem as a sentence and interpret it.
- The interpreter defines a grammer for the language and then uses an abstract syntax tree to interpret it.
- This is quite complicated concept, so let's see what it actually looks like.
- The first component in the interpreter pattern is the context. If you are translating a sentence into another language, the context would be the sentence. So the context is often just a String. 
- The next part is an AbstractExpression ,which can be interface or an abstract class that defines a method used for interpreting the context. Each time the interpret method is called, the context is changed in some way.
- There are two different possible implementations of the AbstractExpression
	1. Terminal
	2. Non-terminal
	
- A non-terminal expression calls the interpret method, which alters the context and then it passes the context on  to another expression until it reaches the terminal expression.
- A terminal expression is the last time the interpret method gets called.
- For example if you are translating  a language the context could be "Hello World". The non-terminal operations translate each word into the correct word in the new language anad when it gets to some punctuation like a period or exclamation mark , it returns that and stops. This structure makes it easy to extend and implement the grammer. However the interpreter pattern works best when the grammer being interpreted is simple. Complex grammer can be difficult to maintain because you would need a new expression class for every new rule you introduce


### Iterator Pattern

- You have probably used the iterator pattern in java quite a lot. In fact may be even more than you realize.
- If you have ever used collections which you probably have is likely you have used the iterator pattern extensively.
- Below forEach loop is commonly used in java to iterate over a collection of objects and under the hood is actually using the iterator pattern

	for(String word : sentence){
		System.out.println(word);
	}
	
-  The collection interface implements another interface called iterable, which is what for each loop is using.
- One of the befits of the iterator pattern that's shown in the above example is that it doesn't matter what type of collection the sentence object is , it could be an ArrayList or a HashSet  or LinkedBlockingQueue or whatever as long as it's something that implements collection interface the for-each loop works same on all of them and it's relevant what the underlying structure looks like .
- Let's say i have list or collection like list of countries, i might want to traverse this list and access the items in it for some app that i'm making and there might be different ways i want to traverse it. For example i might want to skip all the countries in Europe or all of the countries with a certain population size and so on.I could add a load of methods to the List class to sort through the list in different ways, but i don't want to just add them all in there because it will turn into one big class with load of stuffing. I also don't know yet which kinds of iteration i need, so i might end up including loads of unused code.
- So this is where the iterator comes in. The Iterator is a separate object that takes all of the responsibility for moving along the lost and accessing the objects inside it
- It's responsible for keeping track of which elements have already been traversed.
- SO to Summarize, the iterator pattern provides a way to access the items in a list or collection of some type without exposing the underlying structure.
- In java there are interfaces called iterable and iterator which do a lot of heavy lifting for you.
- But it's also important to know how it works because you might want to write your own custom iterators and it will help you to understand how the iterator you use day-to-day work under the hood.
 
### Mediator Pattern

- The definition of mediator is someone who tries to make people come to an agreement when they are in conflicts
- They act as a neutral party who sits in between all of the others, so that they don't have to speak to each other directly
- As a another kind of analogy , imagine a restaurant the customers are at their table and they need to communicate what they want to eat. The chefs are in the kitchen and they need to know what to cook and then the meals need to be brought out to table. The owner of the restaurant needs to make a profit to run the restaurant, so money needs to be collected from the customers. Imagine how this would work if there was no waiter or waitress. The customer have to go to the kitchen to tell the chefs what they want. Then chefs should have to bring out the food to table and at the end of meal the owner would have to come into the restaurant to collect the payments.
- In this scenario, a waiter or waitress is like a mediator handling all of these interactions so that these groups of people don't have to interact with each other directly.
- so if we go back to coding and object -oriented design, you often end-up with large applications that have lots of different objects. We are told that classes should be small and self-contained, so you often have lots of different ones, which leads to lots of different objects. This is good thing as it means that each class is  focused on its one thing, and the behavior of the application as whole is split into small chunks. But one of the downsides that can occur is that you end up with a system with lots of different objects that all know about each other and are all interconnected. You might even endup with a situation where every object knows about every other objects. Apart from the fact that it might become a nightmare to understand  what's actually going on , this leads to tight coupling between objects, and changes to one might result in the need for changes to another.
- It might also make it difficult to reuse objects because they might have to communicate with so many other objects.
- The idea of mediator pattern is to have an object that sole purpose is to handle these interactions between all of the different objects.It sits in the middle of them all and handles the communications between them.
- This provides loose coupling between the objects and this makes the program simpler to understand and to maintain.

 