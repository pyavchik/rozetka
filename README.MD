# Registration test example using Selenium with Java, JUnit and Maven
This is a sample project to demonstrate Page Object model framework
JUnit is used as test framework.

Steps:
registration rozetka.com.ua
api e-mail verification
email assertion in profile

Dependency
Java
Maven

###libraries used
Selenium<br>
JUnit

### Steps to clone execute the tests
```
git clone https://github.com/pyavchik/rozetka
cd rozetka
mvn clean test -Dbrowser=chrome_docker
mvn clean test -Dbrowser=chrome_mac
mvn clean test -Dbrowser=firefox_mac
mvn clean test -Dbrowser=chrome_windows
```