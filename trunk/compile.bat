
call setenv

echo Removing old classes and its sub directories

rd .\classes /S /Q
echo Creating  new classes directories %CD%\classes
mkdir .\classes


echo Compiling.

"%JAVA_HOME%\bin\javac.exe" -cp %classpath% -d  .\classes     .\src\controller\*.java   .\src\gui\*.java  .\src\dao\*.java   .\src\dto\*.java      

echo Directory structure of created classes
%SYSTEMROOT%\system32\tree .\classes /F