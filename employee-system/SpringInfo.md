#Spring Boot is a spring module which aims to simplify the spring framework. It helps in developing stand alone Java
	applications. It has embedded server in it. It feature AutoConfiguration solves the problem of manual configuration
	of beans in XML file, so classes that are present in class-path are automatically configured by spring boot.
	
#Spring Boot runs on port 8080 by default, but it can be overridden using property server.port

#SpringApplication.run() - It bootstraps the spring application from the main method as a stand alone application
	and creates Application context that loads beans.
	
#Spring Beans are Java object that are managed by spring container. Spring container is responsible for instantiating, 
	configuring and assembling the beans. It also manages the life cycle of the beans.
	
#SpringFramework provides two IOC container implementations i.e BeanFactory and ApplicationContext. BeanFactory does 
	lazy loading, it loads the beans on demand whereas ApplicationContext does eager loading, it loads all the beans
	on startup. 
	
#ApplicationContext is an interface that maintains the registry of beans and their dependencies. The getBean() method
	is used to find the bean, it's return type is Object, we need to type it into the desired bean.
 	  
#By default, spring framework searches for application.properties or application.yml file in the class-path.

#Dependency Injection is the feature by which Spring framework find the beans, searches for their dependencies and
	autowires them using @Autowired.

#REST HTTP STATUS CODES
 - 200 : Successful Get
 - 201 : Successful Post
 - 204 : Successful Delete
 - 404 : Resource Not Found
 - 400 : Bad Request
 - 401 : Forbidden
 - 500 : Internal Server Error
 
 #Few Important Annotations:
 - @SpringBootApplication : Marks the entry point of the application, it is composed of @Configuration, 
	@ComponentScan and @EnableAutoConfiguration.
 
 - @Component : Any class annotated with this means, it will be auto scanned during class path scanning
 	and it will be registered in the context as bean.
 	
 - @ComponentScan : It tells the spring boot which package to scan, with no attributes it scans the default
 	package and all of it's sub-packages.
 	
 - @Configuration : Use this configuration on top of any class that contains one or more @Bean method, and that
 	should be processed spring container to generate bean definitions.
 	
 - @ConfigurationProperties : It is used to externalize configurations and easy access to properties or yaml files.
 
 - @Autowired : It is used to inject dependencies.
 
 - @Qualifier : When you have more than  one bean of the same type and you want to choose a particular bean.
 
 - @Order : It defines the sorting order of the beans. Spring will inject the auto-wired beans of the same type
 	in their sorting order. They need to be Autowired as a List or Array.
 	
 - @Primary : When you have more than one bean of the same type and you want to set any one bean as the default bean.
 	If we don't do that, the spring compiler will get confuse that which bean to auto-wire and it will throw an exception.
 
 - @Repository : It means the class or interface will provide a mechanism for update, delete, storage or retrieval of 
 	objects, basically it will deal with the database.
 	
 - @Service : It means the bean holds some business logic, it is used to annotate service layer.
 
Note - Service and Repository are special forms of Component, used for specific purpose.

 - @ResponseStatus : It marks a method and an exception class with a status code that needs to be returned as a response.
 
 - @RequestBody : It basically maps http request body on to the java object, de-serialization of http request body on to
 	the java object is performed by HTTPMessageConvertor.
 	
 - @RestController : A controller is anything that send response back to the user, the response is sent back in JSON
 	or XML format. It is used to create RESTful controller so that we can use Http methods.
 	@GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMaping
 	
 - @PathVariable is used to extract a part of the URI and @RequestParam is used to extract query parameter, like anything
 	that comes after ? in the request.

 - @ControllerAdvice : It provides centralized exception handler across the application on RequestMapping methods
 	using the annotation @ExceptionHandler.
 	
#ResponseEntity represents the HTTP response, it is used to add headers and specific status codes for the particular
	HTTP Method.
 	
#SPRING BOOT ACTUATOR :
 
It is a production ready feature. It helps in managing and monitor our application using http endpoints. 
By default, it runs on the same port as our application, but we can override it using the property. 
It runs on the path /actuator, but we can override it using the property.
As endpoints expose sensitive information, we need to make sure which endpoints we want to expose.
 
 - management.server.port
 - management.endpoints.web.base-path
 - management.endpoints.web.exposure.include=info, metric, health
 
 #SPRING BOOT DEVTOOLS :
 
 It is a feature used in development, in production it is disabled by default. Applications that uses this feature
 are automatically restarted as soon as files on class path change.
 	
