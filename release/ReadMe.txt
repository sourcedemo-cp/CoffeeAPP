This is steps to set up the App call name "CoffeeAPP":

1. Download and Install JDK 1.7:
	+ URL: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
	+ Select JDK for your OS.
	+Install.
2. Download and install Apache Ant:
	+ URL: http://mirrors.viethosting.vn/apache//ant/binaries/apache-ant-1.9.4-bin.zip
    + Extract downloaded file under [ANT_HOME] (E:/Aklero-Working/apache-ant)
    + Add [ANT_HOME] to path environment variables.	
3. Get code at Github:
	+ URL: https://github.com/sourcedemo-cp/CoffeeAPP.git
	+ Set class path for Project.
4. Install MySQL
	+ Download and install MySQL: 
		- URL: http://dev.mysql.com/downloads/mysql/
		- Select MySQL for your OS.
		- Install.
	+ Start MySQL.
5. Create Database:
	+ Create a database with name: "coffeeapp".
	+ run scripts in CoffeeAPP/dbscripts/CoffeeAPP.sql to "coffeeapp" database.
6. Change database properties your Database connection in CoffeeAPP/resources/jdbc.properties.
7. Deploye CoffeeAPP:
	+ Using CMD and go to CoffeeAPP/ant folder.
	+ type: ant in CMD to run ant default.
8. Test:
	+ Go to folder CoffeeAPP/dist/
	+ Double click on file: CoffeeAPP.jar to run.
	+ Type: 
		- username: c
		- password: 1
	+ And test the programe.	