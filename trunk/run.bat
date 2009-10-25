
echo on

call setenv


echo Running Application ...
echo on
"%JAVA_HOME%\bin\java.exe" -cp %CLASSPATH%  controller.MainController

echo on
