#CIRCUIT BREAKER PATTERN - 
	So basically in a micro-service architecture, many services are dependent on each other. What will happen if some
	services fail or throw some exception, the exception will be propagated to upstream and it will come to the end user.
	This pattern prevents this problem by providing the default behavior of the services in case of such failures.
	
	Netflix Hystrix implements this pattern and gives us a solution. In the main class we will use the annotation,
	@EnableCircuitBreaker. Hystix will search for any method annotated with @HystrixCommand and it can only be used in 
	a class which is a @Service or @Component.
	
	@Service
	public class HystrixService{
		@Autowired
		private ServiceProxy proxy;
		
		@HystrixCommand(fallbackMethod = "fallbackEmployee")
		public Employee findEmployee(int id){
			return proxy.retrieveEmployee(id);
		}
		
		public Employee fallbackEmployee(int id){}
	}
	
	Note - The fallback method should have the same return type and arguments as of the method of which it is a fallback. This 
		method will give the default behavior of the API which we are expsoing with the method. 
	