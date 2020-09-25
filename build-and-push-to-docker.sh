./gradew clean build
docker build -t spring-with-hibernate .
# docker images
docker tag <imageID> anishpanthi/springbootapp:0.0.1
docker push anishpanthi/springbootapp
docker-compose up -d
docker ps
