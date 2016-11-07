# khawkfcm

A FCM middleware web service

Run using ./gradlew clean build tomcatRunWar

N.B.
you will need to create \src\main\webapp\WEB-INF\apiKey.xml with the following format :-

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:jdbc="http://www.springframework.org/schema/jdbc"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
       http://www.springframework.org/schema/mvc
       http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context-3.2.xsd">
	<bean id="api_key" class="java.lang.String">
		<constructor-arg value="yourKey" />
	</bean>
</beans>

you should replace "yourKey" with the correct API key before attemting to run the project.
