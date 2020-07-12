#As this is Eureka Client Service, so it will register itself with the Eureka.

#Inside the main method, we will add the annotation, @EnableDiscoveryClient.

#To register the cient with Eureka, inside the application.properties - 

	eureka.client.register-with-euraka=true
	eureka.client.fetch-registry=true
	eureka.client.service-url.default-zone=http://localhost:8761/eureka
	
#To turn off the Eureka level Logs - 

	logging.level.com.netflix.eureka=off
	logging.level.com.netflix.discovery=off