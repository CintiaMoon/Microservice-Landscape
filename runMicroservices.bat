REM ############# START SPRING CLOUD CONFIGURATION SERVER #############
cd Landscape-Config-Server
start mvn spring-boot:run
REM ############# START SPRING CLOUD CONFIGURATION SERVER #############


REM ############# START NETFLIX EUREKA REGISTRY SERVERS #############
cd ..
timeout /t 30
cd Landscape-Eureka-Server
start mvn spring-boot:run

REM For this part of the project, I will not be using multiple profiles for Eureka yet
rem timeout /t 30
rem start mvn spring-boot:run -Dspring.profiles.active=secondary

rem timeout /t 30
rem start mvn spring-boot:run -Dspring.profiles.active=tertiary

REM ############# START NETFLIX EUREKA REGISTRY SERVERS #############


REM ############# START ZUUL SERVER #############
cd ..
cd Landscape-Edge-Server
timeout /t 20
start mvn spring-boot:run
REM ############# START ZUUL SERVER  #############

REM ############# START HYSTRIX DASHBOARD #############
cd ..
cd Landscape-Hystrix-Dashboard
timeout /t 30
start mvn spring-boot:run
REM ############# START HYSTRIX DASHBOARD #############


REM ############# START MICROSERVICE PRIVATE #############
cd ..
cd Landscape-Private-Service
timeout /t 20
start mvn spring-boot:run
REM ############# START MICROSERVICE PRIVATE #############

REM ############# START MICROSERVICE PUBLIC #############
cd ..
cd Landscape-Public-Service
timeout /t 20
start mvn spring-boot:run -Dspring.profiles.active=dev
REM ############# START MICROSERVICE PUBLIC #############
cd ..

REM ############# CHECK EUREKA #############
timeout /t 20
Start http://localhost:8761/

REM ############# CHECK HYSTRIX #############
Start http://localhost:7979/hystrix
REM use stream http://localhost:8050/hystrix.stream


