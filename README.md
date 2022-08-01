# Demoblaze automation project - TheoremOne-Assessments
# Getting started

## Project structure
```
QA-TheoremOne-Assessments/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── demoblaze/
│   │   │       ├── choices
│   │   │       ├── config
│   │   │       ├── factories
│   │   │       └── pages/
│   │   │           └── Homepage.java
│   │   └── resources/
│   │       ├── config/properties
│   │       └── .csv files
│   └── test/
│       └── java/
│           └── test.java
├── dockerfile
├── docker-compose.yml
└── pom.xml
```
Clone the repository and below are few dependencies which are required for the project to run:
- [x] Java 8 or 11 or higher (preferably Java 11)
    - [AdoptOpenJdk official site](https://adoptopenjdk.net/)
    - [Installation procedure for windows/linux/mac](https://adoptopenjdk.net/installation.html)
- [x] Maven 3.8.5 or greater (preferably Maven 3.10.1)
    - [Maven official site](https://maven.apache.org/download.cgi)
    - [Tutorial to install maven in windows/linux/mac](https://maven.apache.org/install.html)
- [x] Docker latest
    - [Installation instructions for windows/linux/mac](https://docs.docker.com/engine/install/)
- [x] Docker compose
    - [Installation instructions for windows/linux/mac](https://docs.docker.com/compose/install/)
## Maven dependecies
```
        <java.version>11</java.version>
        <maven.compiler.source>${java.version}</maven.compiler.source>
        <maven.compiler.target>${java.version}</maven.compiler.target>
        <maven.compiler.plugin>3.10.1</maven.compiler.plugin>
        <maven.surefire.plugin>3.0.0-M7</maven.surefire.plugin>
        <maven.site.plugin>3.12.0</maven.site.plugin>
        <junit.jupiter.version>5.8.2</junit.jupiter.version>
        <selenium.java.version>4.1.1</selenium.java.version>
        <selenium.server.version>4.0.0-alpha-2</selenium.server.version>
        <selenium.htmlunit.driver.version>2.52.0</selenium.htmlunit.driver.version>
        <webdrivermanager.version>5.0.3</webdrivermanager.version>
        <typesafe.version>1.4.2</typesafe.version>
        <lombok.version>1.18.22</lombok.version>
        <slf4j.version>2.0.0-alpha7</slf4j.version>
        <log4j.core>2.17.2</log4j.core>
        <webdrivermanager.version>5.0.2</webdrivermanager.version>
```
## Maven dependencies can be downloaded through below any one command
```
mvn dependency:resolve
-OR-
mvn install
-OR-
mvn package
```
## Run tests on local
- To run the test open the terminal from the project execute:
- `mvn clean test` or `mvn clean -Dgroups=smokeTest test`

## Running a docker compose
To see the output and the magic, just run below command and make sure that all prerequisites with regards to dependencies are completed
```
docker compose up -- build
-OR-
`docker-compose up -d`
```

## Creating a docker image
```
docker image build -t demoblaze . -f Dockerfile
docker container run demoblaze
```
## Run tests on Grid
```
docker-compose up -d
mvn clean -DHOST=host.docker.selenium.grid -DBROWSER=chrome test

- For more options please chekck `src/main/resources/.conf` files 
  [-DHOST] Host choices are: "host.localhost", "host.docker.container", "host.docker.selenium.grid"
  [-BROWSER]Browser choices are: "chrome", "firefox", "edge"
- Grid VNC viewer password is `secret`
```
## Running project using github actions
- Automated workflow runs on:push 
- 
### Run manual workflows [selenoid/seleniumgrid, docker]
- To run workflow:
  ##### Run project on Selenoid/SeleniumGrid
    - Go to `Actions` tab [Project/Actions]
    - Select workflow [CBH-selenium-grid]
    - Select `main` branch click on `Run workflow`

  #### Run project using docker for cross-browser testing
    - Go to `Actions` tab [Project/Actions]
    - Select workflow [CBH-docker-chrome]
    - Select `main` branch click on `Run workflow`

## TestData
  ### New Product
  - You can add/update/remove/ product for the test.
  - To change the product for test, Go to --> src/main/resources/product.csv

  ### Valid user for login
  - You can add/update/remove/ user for the test.
  - To change the product for test, Go to --> src/main/resources/testdata.csv

  ### Valid user for checkout
  - You can add/update/remove/ product for the test.
  - To change the product for test, Go to --> src/main/resources/testuser.csv

#### Reference:
- [Docker](https://docs.docker.com/)
- [Maven Documentation](https://maven.apache.org/guides/getting-started/)
- [Selenoid Server](https://github.com/marketplace/actions/starting-selenoid-server-aerokube-selenoid-within-actions)
