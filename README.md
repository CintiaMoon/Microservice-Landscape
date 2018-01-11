*## Microservices architecture based on Spring Cloud

This project is a microservices project based on frameworks such as Spring Boot, Spring Cloud, Spring Oauth2 and Spring Cloud Netflix.

### Components

- **Service Discovery Server (Netflix Eureka)**: Service Discovery Server Netflix Eureka allows micro services to register themselves at runtime as they appear in the system landscape.

- **Dynamic Routing and Load Balancer (Netflix Ribbon)**: It uses the information available in Eureka to locate appropriate service instances. If more than one instance is found, Ribbon will apply load balancing to spread the requests over the available instances.

-**Edge Server (Netflix Zuul)**: It prevents any unauthorized external requests pass through. Zuul uses Ribbon to lookup available services and routes the external request to an appropriate service instance.

localhost:7979/hystrix

## Url to check configuration
http://localhost:8888/Landscape-Composite-Service/dev

URLs for the microservices (Without ZUUL)
---------------------------
curl localhost:8050/message/delayed-response
curl localhost:8060/user/all

## URL with Ribbon (Without ZUUL)
curl http://localhost:8050/all

To refresh the variables loaded from properties (Composite-Service):
curl -v -d {} localhost:8050/refresh


----------------------------------------------
URLs for the microservices (With ZUUL)
------------------------------------------
http://localhost:9090/api/Landscape-User-service/message/delayed-response	Service auto registered from Eureka (when ignoredServices: '*' is enabled, it won't work)

http://localhost:9090/api/Composite-Service-by-address/all



-- Services that show Hystrix
http://localhost:9090/api/Composite-Service-by-address/message/delayed-response	Service registered by address
http://localhost:9090/api/Composite-Service-by-service/message/delayed-response	Service registered by Eureka service id
http://localhost:9090/routes?format=details 								Display all available Routes (services)


Useful Resources
------------------------------------
Tool used for drawing the landscape: https://www.draw.io/
https://www.slideshare.net/OrkhanGassymov/spring-cloud-why-how-what