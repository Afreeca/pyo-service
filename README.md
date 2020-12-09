# ITV PYO platform

### Assumptions:
    * pyo-service is an Internal tools used by ITV departments
    * The advertising team has access to the list of Breaks and existing campaigns with their Ids(breaksId, campaignId)

---
---

### Requirement
    * Docker
        * https://docs.docker.com/get-docker/
    * Docker-compose 
        * https://docs.docker.com/compose/install/

1. Before running the service we need to satisfy the dependency by running the database.
    * As a container using docker-compose
        * `docker-compose -f _dev_/mysql.yml`
    * As a container using docker(in case you don't have docker-compose installed)
        * `docker run \
          --detach \
          --name=pyoDB \
          --env="MYSQL_ROOT_PASSWORD=root" \
          --env="MYSQL_DATABASE=pyo-service" \
          --env="MYSQL_ROOT_PASSWORD=123itv456" \
          --publish 3308:3306 \
          mysql`
    
---
---

### Running the application locally from the command line using gradle

In the base directory (containing gradlew) build and run the service application

2. Now you have two options:
   1. Run the service as a springboot application using gradle
* `./gradlew bootRun`

* Alternative, you can use an IDEA like Intellij to import and run the project

---
---

### Usage/Testing
2. Access the swagger documentation describing the API and all the expected request datatype and more
    * You can use Curl. but Postman would be the best option
    * https://www.postman.com/
      * There is a postman COllection `_dev_/itv-pyo.postman_collection.json` ready to be imported 
    
---
---

### Documentation
2. Access the swagger documentation describing the API and all the expected request datatype and more
    *  Go to your browser and type:
        * http://localhost:9000/swagger-ui.html
    
## Authors
Adilson Mendes
