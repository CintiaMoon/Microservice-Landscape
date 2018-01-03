## Microservices architecture based on Spring Cloud

This project is a microservices project based on frameworks such as Spring Boot, Spring Cloud, Spring Oauth2 and Spring Cloud Netflix.

### Components

- **Service Discovery Server (Netflix Eureka)**: Service Discovery Server Netflix Eureka allows micro services to register themselves at runtime as they appear in the system landscape.

- **Dynamic Routing and Load Balancer (Netflix Ribbon)**: It uses the information available in Eureka to locate appropriate service instances. If more than one instance is found, Ribbon will apply load balancing to spread the requests over the available instances.

-**Edge Server (Netflix Zuul)**: It prevents any unauthorized external requests pass through. Zuul uses Ribbon to lookup available services and routes the external request to an appropriate service instance.


