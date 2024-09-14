#!/bin/sh
mvn clean package && docker build -t firstjavaee/learningCdi .
docker rm -f learningCdi || true && docker run -d -p 8080:8080 -p 4848:4848 --name learningCdi firstjavaee/learningCdi 
