# Decepticon Project

This is a Serenity project that created to test [Make My Trip Page](http://makemytrip.com/) gives examples on how to run
API using UI automation which use two test runner which is JUnity and Cucumber 4.

## Running Locally
To run the project you can either run it directly from the `CucumberRunner` test runner class 
or using maven command `mvn verify`.

By default the web automation will run on Chrome so you need to override the `driver` if you want to use other browser.
```json
$ mvn clean verify -Dwebdriver.driver=firefox
```