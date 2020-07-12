#Eureka Naming Server, is an application that holds information about all the other services. Each
	micro-service gets registered itself with the Eureka server with it's port and IP address. 
	
#Need of Eureka Server?
 - Suppose we have one producer service and we have one consumer service, now the load increases and 
   producer service has 5 instances running. We would be required to configure all the instances in consumer
   service manually. We want this to happen dynamically. That's where Eureka Naming Server comes into picture.
   
#Whenever a new instance of a micro-service comes up, it registers itself automatically with the 
   Eureka Naming Server, this is known as Service Registry.
   
#Whenever a service wants to connect with another service, it first contacts eureka server,
   from there it gets the instance of that service and then connects to it, thi sis called
   Service Discovery.
   
#We will create a separate application that will act as our Eureka Server, inside the main class
   we will add the annotation, @EnableEurekaSever. 
   
#We don't want our server application to register itself so inside the application.properties - 
	
	eureka.client.register-with-eureka=false
	eureka.client.fetch-registry=false   
   
#Eureka Server by default runs on the port 8761.   
	