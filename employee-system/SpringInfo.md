#Spring Boot is a spring module which aims to simplify the spring framework. It helps in developing stand alone Java
	applications. It has embedded server in it. It feature AutoConfiguration solves the problem of manual configuration
	of beans in XML file, so classes that are present in class-path are automatically configured by spring boot.

	
#Spring Boot runs on port 8080 by default, but it can be overridden using property server.port


#SpringApplication.run() - It bootstraps the spring application from the main method as a stand alone application
	and creates Application context that loads beans. It also runs the embedded tomcat server.

	
#Spring Beans are Java object that are managed by spring container. Spring container is responsible for instantiating, 
	configuring and assembling the beans. It also manages the life cycle of the beans.

	
#SpringFramework provides two IOC container implementations i.e BeanFactory and ApplicationContext. BeanFactory does 
	lazy loading, it loads the beans on demand whereas ApplicationContext does eager loading, it loads all the beans
	on startup. 


#Spring Boot Dependency Management is used to manage dependencies and configurations automatically without
	specifying the versions of dependencies.	


#ApplicationContext is an interface that maintains the registry of beans and their dependencies. The getBean() method
	is used to find the bean, it's return type is Object, we need to type it into the desired bean.

 	  
#By default, spring framework searches for application.properties or application.yml file in the class-path.


#Dependency Injection is the feature by which Spring framework find the beans, searches for their dependencies and
	autowires them using @Autowired.


#REST HTTP STATUS CODES
 - 200 : Successful Get/OK
 - 201 : Successful Post/CREATED
 - 204 : Successful Delete/NO_CONTENT
 - 404 : Resource Not Found/NOT_FOUND
 - 400 : Bad Request/BAD_REQUEST
 - 403 : Forbidden/FORBIDDEN
 - 401 : UnAuthorized/UNAUTHORIED
 - 500 : Internal Server Error/INTERNAL_SERER_ERROR
 
 
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
 	

#@GetMapping is a short hand of @Requestmapping(method = RequestMethod.Get)

 	
#ResponseEntity represents the HTTP response, it is used to add headers and specific status codes for the particular
	HTTP Method.
	
	
#HttpHeaders : It represents HTTP Request and Response headers. It maps String name with the value. We can use
	HttpServletResponse or ResponseEntity to add headers.
	
 		@GetMapping(path="/servlet-response")
		public String usingServletResponse(HttpServletResponse response){
			response.addHeader("Header-Name", "Servlet Response Header");
			return "Servlet Response";
		}
		
		@GetMapping(path="/response-entity")
		public ResponseEntity<String> usingResponseEntity(){
			HttpHeaders header = new HttpHeaders();
			header.add("Header-Name", "Response Entity Header");
			return new ResponseEntity<String>("ResponseEntity", header, HttpStatus.OK);
		}
		 		
 	
#SPRING BOOT ACTUATOR :
 
It is a production ready feature. It helps in managing and monitor our application using http endpoints. 
By default, it runs on the same port as our application, but we can override it using the property. 
It runs on the path /actuator, but we can override it using the property.
As endpoints expose sensitive information, we need to make sure which endpoints we want to expose.
 
 - management.server.port
 - management.endpoints.web.base-path
 - management.endpoints.web.exposure.include=info, metric, health
 
 - shutdown : It is an endpoint that lets you gracefully shutdown the application. By default it is disabled.
 	management.endpoint.shutdown.enabled=true 
 

#SPRING BOOT DEVTOOLS :
 
 It is a feature used in development, in production it is disabled by default. Applications that uses this feature
 are automatically restarted as soon as files on class path change.
 

#API Versioning : 
 - URI Version : using different URIs
 
 		- http://localhost:8080/v1/users
 		- http://localhost:8080/v2/users
 		
 - Request Parameter Version : using params attribute
 		
 		- @GetMapping(value="/users", params="version1")
 		- http://localhost:8080/users?version1
 		- @GetMapping(value="/users", params="version2")
 		- http://localhost:8080/users?version2
 		
 - Header Version : using headers attribute 
 
 		- @GetMaping(value="/users", headers="X-API-VERSION=1")
 		- @GetMaping(value="/users", headers="X-API-VERSION=2")
 		
 - MediaType Version : using produces attribute and Accept header while hitting request
 
 		- @GetMapping(value="/users", produces="application/mycompany.app-v1+json")
 		- @GetMapping(value="/users", produces="application/mycompany.app-v2+json")
 	
