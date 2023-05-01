## desafio-tecnologia-unica // tecnologia-unica challenge

***

## Project Description

[Desafio Técnico - Automação.pdf](https://github.com/joaomcruz/desafio-tecnologia-unica/files/11365599/Desafio.Tecnico.-.Automacao.pdf)

***

## Which technologies were used to create this project ?

I used Java + Selenium + Cucumber to create the test cases. 
The design patterns applied on this project are Page Object Modeling and Driver Factory.
TestNG/JUnit was used as well.

***

## How to install and run the project 

1 - Make sure you have java JDK and maven installed on your computer . If you don't have any of them, please find attached the necessary resources in order to have both of them . If you don't have java JDK yet, I recommend you installing the LTS (Long Term Support) version

java/jdk tutorial : https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/
maven tutorial : https://www.baeldung.com/install-maven-on-windows-linux-mac

2 - Once you have both of them, copy and paste the following code on your gitbash to clone this repo :

for SSH : `git clone git@github.com:joaomcruz/desafio-tecnologia-unica.git`  
for HTTPS: `git clone https://github.com/joaomcruz/desafio-tecnologia-unica.git`

3 - Now that you have the project on your computer, open it with your prefered IDE (I recommend using IntelliJ because of the language/dependency manager ).

4 - With the project open , find `pom.xml ` file and make sure it downloads all the dependencies that are there. On Intellij a small icon with the Maven symbol appears. If you click on it , it will automatically download everything tha

5 - Done, the project is ready to run.

***

## How to use the project

1 - I created some customizations for this project , such as : It's possible to choose between running the tests on chrome or firefox. All you have to do is : Go to the `config.properties` file, and write the browser you would like the tests to run . Chrome is set by default, but it's up to you whether or not to use chrome for the tests. 

2 - On the `Global_Variables` there is a constant called `SCREENSHOT_PATH` . If you want to change the path which the screenshots are going to be saved, just change that .

3 - In order to run the tests , you have to trigger the `MainRunner` class.
This class has some customizable settings , being them the following :

- I added tags to the feature files . By default , the tag that is being used inside the `tag` is going to run all the tests there. If you want to run only one of the test scenario all you have to do is change the tag on the `MainRunner` class to match the tag of the scenario you want to run.

- It is also possible to run the tests in parallel. By default, this feature is turned off, but if you want to test it out , just change the statement of the  `@DataProvider(parallel = false)` to `@DataProvider(parallel = true)` . Save it and it's ready to run the tests in parallel.

- The `monochrome` option can also be changed to false. I recommend leaving as it is, since it's just a log formatter. Making really easy and better to understand the output of the tests.

- `dryRun` feature can also be changed to true (it is false by default) . This feature is responsible for running the tests in headed/headless mode. Being false the headed one .

- `plugin` is a feature that creates beautiful reports. Being one of them in HTML and the other one in JSON (good for CD/CI ) . Those are also customizable. If you don't want to generate these reports, you can remove the feature.

- DO NOT TOUCH the `features` and `glue` words. Those are responsible for linking the feature files with the step definitions files.


**


