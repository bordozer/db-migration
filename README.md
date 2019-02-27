# Liquibase database migration example

Liquibase database migration example
  
### Prerequisites

```
- Java 8 or later
- Gradle version > 4.6
- https://github.com/bordozer/sca-parent (should be installed to local maven repo)
```

### Installing

````` 
$ git clone https://github.com/bordozer/db-migration
$ cd db-migration
`````
Build application (linux)
`````
$ ./gradlew clean build
`````
or windows
`````
$ gradlew.bat clean build
`````
Run application

`````
$ java -jar build/libs/dbmigration.war
`````
open in browser
```
http://localhost:9009/users/
```

## Authors

* **Borys Lukianov**

