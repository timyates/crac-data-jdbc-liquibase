### Test Micronaut 4 with Liquibase, Data-JDBC and MySQL

To run:

1. Create a docker network "db" for the database to run in

```bash
docker network create db
```

2. Start the database

```bash
docker run -d --name mysqlhost -p 3306:3306 --network db -e MYSQL_ROOT_PASSWORD=mysql mysql
```

3. Create the CRaC checkpointed image

```bash
./gradlew dockerBuildCrac
```

4. You can then start the app with

```bash
docker run --privileged --network db -p 8080:8080 demo:latest
```