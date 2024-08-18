set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%\libAllure\aspectjweaver-1.9.20.jar" -classpath "%ProjectPath%out\production\hybrid-nopcommerce-framework;%ProjectPath%libAllure\*;%ProjectPath%libLog4J2\*;%ProjectPath%libExtent5\*;%ProjectPath%libReportsNG\*;%ProjectPath%libraries\*;" org.testng.TestNG "%ProjectPath%resources\nopCommerce.xml"
allure serve .\allure-results\
pause