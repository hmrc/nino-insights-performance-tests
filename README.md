# nino-insights-performance-tests
Performance test suite for `nino-insights` services, using [performance-test-runner](https://github.com/hmrc/performance-test-runner) under the hood.

##NOTE: The tests rely on the test data in the [ninos.csv](src/test/resources/data/ninos.csv) file.
## Running the tests

Prior to executing the tests ensure you have:

* Docker - to start mongo container
* Installed/configured service manager

If you don't have mongodb installed locally you can run it in docker using the following command

    docker run -d --rm --name mongodb -p 27017-27019:27017-27019 mongo:4

If you don't have postgres installed locally you can run it in docker using the following command

    docker run -d --rm --name postgresql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres:10.14

Run the `./start_services.sh` script to start the services locally

#### Smoke test

It might be useful to try the journey with one user to check that everything works fine before running the full performance test
```
./run_tests.sh
```
or use this command below:
```
sbt -Dperftest.runSmokeTest=true -DrunLocal=true gatling:test
```
or use
```
sbt -DrunLocal=true gatling:test
```

#### Run the performance test

To run a full performance test against staging environment, implement a job builder and run the test **only** from Jenkins.

### Scalafmt
 This repository uses [Scalafmt](https://scalameta.org/scalafmt/), a code formatter for Scala. The formatting rules configured for this repository are defined within [.scalafmt.conf](.scalafmt.conf).

 To apply formatting to this repository using the configured rules in [.scalafmt.conf](.scalafmt.conf) execute:

 ```
 sbt scalafmtAll
 ```

 To check files have been formatted as expected execute:

 ```
 sbt scalafmtCheckAll scalafmtSbtCheck
 ```

[Visit the official Scalafmt documentation to view a complete list of tasks which can be run.](https://scalameta.org/scalafmt/docs/installation.html#task-keys)


## Logging

The template uses [logback.xml](src/test/resources) to configure log levels. The default log level is *WARN*. This can be updated to use a lower level for example *TRACE* to view the requests sent and responses received during the test.
