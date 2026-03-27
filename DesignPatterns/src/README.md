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
-  
		
 
 