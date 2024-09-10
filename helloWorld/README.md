# Build
mvn clean package && docker build -t firstjavaee/helloWorld .

# RUN

docker rm -f helloWorld || true && docker run -d -p 8080:8080 -p 4848:4848 --name helloWorld firstjavaee/helloWorld 