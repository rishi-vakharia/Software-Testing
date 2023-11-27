## To Create a general maven project:

mvn archetype:generate -DgroupId=mygroup -DartifactId=project -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4

Click enter

Click enter

cd project

mvn package

java -cp ./target/project-1.0-SNAPSHOT.jar mygroup.App

mvn test

## References:

* https://maven.apache.org/guides/getting-started/
* https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

## To setup PIT for mutation testing:

Add plugin to pom.xml

```xml
<plugin>
    <groupId>org.pitest</groupId>
    <artifactId>pitest-maven</artifactId>
    <version>LATEST</version>
</plugin>	
```

Run mutation coverage test:

```bash
mvn -DwithHistory test-compile org.pitest:pitest-maven:mutationCoverage
```

This will output an html report to **target/pit-reports/**.

## References:

* https://pitest.org/quickstart/maven/

## List of mutation operators in PIT:

* https://pitest.org/quickstart/mutators/

## Junit assert API reference:

* https://junit.org/junit4/javadoc/4.13/org/junit/Assert.html
