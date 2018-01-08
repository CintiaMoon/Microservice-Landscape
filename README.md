## Microservices architecture based on Spring Cloud

This project is a microservices project based on frameworks such as Spring Boot, Spring Cloud, Spring Oauth2 and Spring Cloud Netflix.

### Components

- **Service Discovery Server (Netflix Eureka)**: Service Discovery Server Netflix Eureka allows micro services to register themselves at runtime as they appear in the system landscape.

- **Dynamic Routing and Load Balancer (Netflix Ribbon)**: It uses the information available in Eureka to locate appropriate service instances. If more than one instance is found, Ribbon will apply load balancing to spread the requests over the available instances.

-**Edge Server (Netflix Zuul)**: It prevents any unauthorized external requests pass through. Zuul uses Ribbon to lookup available services and routes the external request to an appropriate service instance.

localhost:7979/hystrix


URLs for the microservices (Without ZUUL)
---------------------------
curl -s localhost:8050/message/enable-CB
curl localhost:8050/message/client-message

URLs for the microservices (With ZUUL)
------------------------------------------
http://localhost:9090/api/landscape-public-service/message/client-message	Service auto registered from Eureka (when ignoredServices: '*' is enabled, it won't work)

http://localhost:9090/api/Public-Service-by-address/message/client-message	Service registered by address
http://localhost:9090/api/Public-Service-by-service/message/client-message	Service registered by Eureka service id
http://localhost:9090/routes?format=details 								Display all available Routes (services)


Useful Resources
------------------------------------
Tool used for drawing the landscape: https://www.draw.io/
https://www.slideshare.net/OrkhanGassymov/spring-cloud-why-how-what