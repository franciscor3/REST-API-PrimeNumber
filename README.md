# REST-API-PrimeNumber
REST API web service to obtain Prime numbers between 2 and the number given as a parameter
It is a GET method to optain the list of prime numbers



In order to be able to run the web service it needs to have:

- Java 17
- Maven 3


HOW TO INSTALL THE API 

If you have the based tech mentioned before you would need to:

1) Clone this reporitory
2) Go to the folder in the console and run the command  ' mvn clean install ' 
3) All the dependencies and libraries will be installed and its unit test will run automatically
4) After the project is build, run the command ' mvn spring-boot:run ' to initialize the web service
5) Go to the browser and type: localhost:8080/primes/10 you will see a reponse in the content type that it is accepted.

For choosing the algorithms you need to add the optional parameter: 
   - ?algorithm=1 for Brute Force
   - ?algorithm=2 for Sieve of Erastosthene 
  
It is a default 'Square Root', in case another value of the parameter or no parameter.



