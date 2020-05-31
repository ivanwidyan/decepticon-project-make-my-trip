# Decepticon Project - Make My Trip

This is a Serenity project that created to test [Make My Trip Page](http://makemytrip.com/) gives examples on how to run
API using UI automation which use two test runner which is JUnit and Cucumber 4.

## Running Locally
First you need to clone the project and open it.

To run the project you can either run it directly from the `CucumberRunner` for running it using Cucumber 4 or `JUnitRunner` to run it using JUnit. 
Or you can use Maven command `mvn clean verify` to run it. But to check the scenario and business flow, using Cucumber 4 runner is better because it's using Behavior Driven Development.

By default, the UI automation will run on Chrome and Cucumber 4 so you need to override it from the Maven goal if you want to use other configuration.
```json
mvn clean verify -Drunner.class=CucumberRunner -Dcustomdriver.browserName=chrome
```

You can change the `customdriver.browserName` value to either `chrome`, `firefox`, and `MicrosoftEdge`.

The configuration can also be changed on `serenity.properties` file.

We are using Web Driver Manager to implement the Driver for UI automation. So no need to worry about the Driver version anymore.

## Running on Headspin UI
The configuration can be seen in `serenity.properties`. First you need to change the `webdriver.provided.mydriver` config to `com.decepticon.driver.CustomRemoteDriver`.

![3](https://user-images.githubusercontent.com/12959761/83355862-3f3e0700-a38c-11ea-9b5e-5e9e7e201a6c.jpg)

After that you need to also change the desired capabilites configuration to match the configuration with Headspin Automation Configuration.
You change it from these configs:

- `customdriver.browserName` it is used to determine what browser you want to use in the Headspin UI.
- `customdriver.browserVersion` it is used to match the browser version you want to use. But it can be left blank also.
- `customdriver.width=1920` this config to create the width you want in the Headspin.
- `customdriver.height=1080` this config to create the height you want in the Headspin.
- `customdriver.remoteUrl` this needs to be filled with the Headspin hub URL that you want to connect.

After finishing the config you can either run it using `CucumberSecondRunner` directly or using Maven goal.

Below is the full example of Maven goal for running the UI automation in Headspin UI.

```
 mvn clean verify -Drunner.class=CucumberSecondRunner -Dwebdriver.provided.mydriver=com.decepticon.driver.CustomRemoteDriver -Dcustomdriver.browserName=chrome -Dcustomdriver.width=1920 -Dcustomdriver.height=1080 -Dcustomdriver.remoteUrl=https://dev-nz-akl-0.headspin.io:9092/v0/b62f619b47b742d6942a1dff468c41d6/wd/hub
```

## Generating Report
To generate report you must use the Maven goal `mvn clean verify` as the baseline. Because we use Serenity report and it is generated
when the maven goal has `verify` lifecycle.

The report can be found under `\target\site\serenity\index.html`.

![image](https://user-images.githubusercontent.com/12959761/83355713-765fe880-a38b-11ea-9cd7-ca0c57e40db4.png)

## Capture Screenshot
From the business scenarios implementation, there are two steps that we need to capture the page.
First we need capure the hotel name on search page and capture the room details on the room page.
After running the UI test automation the screenshots can be found under `\target\decepticon\report\data\ss`.

![1590937615694](https://user-images.githubusercontent.com/12959761/83355760-a7401d80-a38b-11ea-91cb-2b5921765602.png)
![1590937628954](https://user-images.githubusercontent.com/12959761/83355764-a9a27780-a38b-11ea-9839-94217b055958.png)

## Challenges & Solutions

These are our top challenges that we found when working on this project:
- **Webdriver version problem**: Our solution is creating our custom driver that use Webdriver manager.
- **Serenity remote browser can't connect to Hidespin**: Our solution is creating our custom remote driver that pass the needed Desired capabilites.
- **Dynamic filter min price**: Our solution is finding the right offset and increasing the slider until it matches the requested min price.
- **Dynamic scroll to select the hotel**: Our solution is to go to the end page when the list hotel is not bigger than the requested hotel order number.
- **Assertions across pages**: Our solution is create data class to gather all needed data and use it for assertion in the booking summary page.
- **Need to have dynamic test data**: We implement Cucumber 4 so the test data can changed easily.
- **Same xpath for some elements**: We use String xpath that can be changed to make it dynamic locators.
