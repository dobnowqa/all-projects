set projectPath=C:\framework\eclipse-workspace\dob
cd\
cd %projectPath%
set classpath=%projectPath%\bin;C:\framework\selenium_lib\*;
java org.testng.TestNG testng.xml
pause



