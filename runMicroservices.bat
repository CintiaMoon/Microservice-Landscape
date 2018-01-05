REM ############# START SPRING CLOUD CONFIGURATION SERVER #############
cd Landscape-Config-Server
start mvn spring-boot:run
REM ############# START SPRING CLOUD CONFIGURATION SERVER #############


REM ############# START NETFLIX EUREKA REGISTRY SERVERS #############
cd ..
timeout /t 30
cd Landscape-Eureka-Server
start mvn spring-boot:run

rem timeout /t 30
rem start mvn spring-boot:run -Dspring.profiles.active=secondary

rem timeout /t 30
rem start mvn spring-boot:run -Dspring.profiles.active=tertiary


REM ############# START NETFLIX EUREKA REGISTRY SERVERS #############


REM ############# START MICROSERVICE PRIVATE #############
cd ..
cd Landscape-Private-Service
timeout /t 30
start mvn spring-boot:run


REM ############# START MICROSERVICE PUBLIC #############
cd ..
cd Landscape-Public-Service
timeout /t 30
start mvn spring-boot:run

cd ..

REM ############# CHECK EUREKA #############
timeout /t 20
Start http://localhost:8761/

