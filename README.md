 simple-springboot-webapp-monolith

This is the same application as https://github.com/mane-ashok/simple-spring-webapp-monolith with the <b>spring boot</b>. Please refer to its https://github.com/mane-ashok/simple-spring-webapp-monolith/blob/main/README.md for the application details.(DRY principle)

<h3>Intent - compare spring application with the spring boot application and understand the difference and how spring boot eases the development</h3>

<h4>Lets list the differences between the spring and spring boot projects</h4>

<table>
<tr><th>Area</th><th>Difference</th><tr>

<tr><td>Dependency Management and packaging</td><td>It's really a cumbersome and time consuming to find out the required dependencies and compatible versions, you must have spent a lot of time figuring it out :). Spring boot makes it easy to add the dependencies via spring initializer (https://start.spring.io/), it has a curated list of dependencies along with the compatible versions which is taken care in the parent project (spring-boot-starter-parent). <br /><br/>
Each starter dependency in the spring boot pom.xml file encapsulates set of required dependencies, and you will see less dependencies in the pom.xml. Another notable difference is that the dependency versions are not mentoned in your spring boot pom.xml file and they are inherited through the parent project and you don't have to worry about it. If you are curious to know all the encapsulated dependencies and versions for your project, go to the pom.xml directory and execute - <b> mvn dependency:tree </b> command.<br/><br/>

Spring project uses maven-shade-plugin while spring boot project uses spring-boot-maven-plugin for packaging the single executable jar with all the the dependencies <br/><br/>
<b>spring project jar file size is -</b><br/><br/> ![image](https://user-images.githubusercontent.com/93635967/226104955-d22df2f8-14f6-4324-8e05-e04ea851eb12.png) <br/><br/>
<b>while spring boot project jar is -</b><br/><br/> ![image](https://user-images.githubusercontent.com/93635967/226104989-db2ee115-d885-4550-99a0-b67698b17bfe.png) <br/><br/>
<b>Spring project opend jar looks like this -</b><br/><br/> ![image](https://user-images.githubusercontent.com/93635967/226105918-de1de9c6-30ae-48af-afe1-2d89b0df2ead.png) <br/><br/>
It looks like shade plugin merged all the dependency jars along with application classes/objects together in a single jar <br/><br/>
<b>while spring boot project opened jar looks like this -</b><br/><br/> ![image](https://user-images.githubusercontent.com/93635967/226105996-9a73de7f-e6a7-4b8f-9729-22a92beaa11b.png)<br/><br/>
In spring boot jar, spring framework dependencies are inside org folder, BOOT-INF folder has application classess/objects plus all other dependencies in lib folder
<br/><br/>
<b>Spring project MANIFEST.MF file looks like this -</b><br/><br/>  ![image](https://user-images.githubusercontent.com/93635967/226106717-61a5fede-e17f-497b-8e7a-f700b0873207.png)
<br/><br/>
<b>while spring boot MANIFEST.MF is like this -</b><br/><br/> ![image](https://user-images.githubusercontent.com/93635967/226106646-529862a0-cc74-434a-b1ad-cebcbdb99e04.png) <br/><br/>
<b>Note: Spring boot jar packaging looks much better than the spring project jar, dependencies are nicely separated. Also, notice the Main-Class and Start-Class in spring boot manifest file. This means when you run spring boot jar the JarLauncher class gets triggered which must be taking care of executing @SpringBootApplication class ( Start-Class) with the required class-path set.</b>

<br/>
<br/>

Go and compare both the pom files.(https://github.com/mane-ashok/simple-spring-webapp-monolith/blob/main/pom.xml & https://github.com/mane-ashok/simple-springboot-webapp-monolith/blob/main/pom.xml)</td></tr>

<tr><td>Auto configuration</td><td> Once you have all the dependencies in place, in spring application you create your configuration class with @Configuration annotation and define all your required beans. Spring boot adds some value here and tries to figure out what beans your application might need depending upon the dependencies and property configuratoions in application.properties which is called auto configuration in spring boot. This is bit interesting, right? yes it is..:)<br /><br/>
In spring project you have 2 configuration classes - https://github.com/mane-ashok/simple-spring-webapp-monolith/blob/main/src/main/java/org/ashok/context/ApplicationConfiguration.java & https://github.com/mane-ashok/simple-spring-webapp-monolith/blob/main/src/main/java/org/ashok/context/WebSecurityConfiguration.java but in spring boot projectyou will see only https://github.com/mane-ashok/simple-springboot-webapp-monolith/blob/main/src/main/java/org/ashok/springboot/context/WebSecurityConfiguration.java <br /> <br/>
This means all the bean configurations defined in ApplicationConfiguration.java for spring project are taken care by spring boot auto configuration. However, in spring boot project you have additional properties configurations in application.properties as below <br/> <br/>

spring.datasource.driver-class-name=org.h2.Driver <br />
spring.datasource.url=jdbc:h2:~/myFirstH2Database <br />
spring.datasource.username=sa <br />
spring.datasource.password=sa <br />
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect <br />

spring.jpa.show-sql=true <br />
spring.jpa.generate-ddl=true <br />
spring.messages.basename=messages <br />
spring.mvc.static-path-pattern=/resources/** <br />
spring.web.resources.static-locations=classpath:/css/,classpath:/images/ <br /><br/>
<b>Note: Spring application created 86 beans while spring boot created 256 beans, this might add to the memory foot print. You will see all the beans created in the console logs. You may exclude the unnecessary beans in the @SpringBootApplication(exclude={...})</b> <br/>
</td></tr>

<tr><td>Application launcher class</td><td> In spring project you will see the https://github.com/mane-ashok/simple-spring-webapp-monolith/blob/main/src/main/java/org/ashok/AppLauncher.java class with some code in it ( go check it out). In spring boot project you have very simple java class class to launch the application - https://github.com/mane-ashok/simple-springboot-webapp-monolith/blob/main/src/main/java/org/ashok/springboot/SimpleSpringbootWebappMonolithApplication.java with @SpringBootApplication annotation, behind the scene the spring boot must be taking care of functionality/code like that of AppLauncher.java class in spring project, right? </td></tr>

<tr> <td>Any other major difference?</td><td> There is no other major difference in these 2 projects, go check it out :) </td></tr>
</table>

