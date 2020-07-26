#Distributed Tracing With Zipkin and Sleuth - 
	So in a micro-service architecture there are multiple calls to each service, even a single user action 
	may trigger a chain of services. So if a defect arises how will you find out which service has caused
	problem or where would you exactly look into? That's where distributed tracing comes into picture.
	
	It provides a centralized place where we can see what's happening with a particular request. Spring Cloud Sleuth
	and Zipkin Server help us achieving this problem. Spring Sleuth provides us tracing capabilities by generating
	and attaching a trace id and span id onto requests logs and they can be exported to zipkin for visualizing and analysing 
	purpose. To use sleuth and zipkin, we need to add the dependencies in all the applications- 
		<spring-cloud-starter-sleuth>
		<spring-cloud-starter-zipkin>
	
		#Trace id represents the whole journey of the request.
		#Span id represents the individual hop from one service to another.
		
	#So the question comes how many requests we need to trace, we don't want to overwhelm our logging infrastructure.
	By default the threshold is set for 10%. But we can override it using the property - 
	
		#spring.sleuth.sampler.probability=0.2 
		
	#Zipkin can be started as a server - 
		java -jar zipkin.jar
	By default, zipkin runs on the port 9411, so now if we hit any url of our application, the zipkin will have a trace.  
		
	