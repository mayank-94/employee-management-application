#FeignClient helps in writing web services clients easier. It basically reduces the client side code. It also
	provides an integration with ribbon which is a client side load balancer.
	
#In the main class we will add the annotation, @EnableFeignClients

#Then we will create an interface which will act as a proxy to the API it wants to connect to.
	example - 

	@FeignClient(name="employee-system" , url="localhost:8080")
	public interface ServiceProxy{
		@GetMapping(path="/employees/{id}")
		public Employee retrieveEmployee(@PathVariable("id") int id);
	}
	
	In the method we created inside the service, the path needs to exactly same as of the service wit which we want to connect to.
	We don't need to provide url, if our micro-services are registered to Eureka Server as Client.