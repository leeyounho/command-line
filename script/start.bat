rem Go to the directory where the current script is located
set DIRNAME=%~dp0
rem Remove the trailing backslash for consistency
set DIRNAME=%DIRNAME:~0,-1%

set CLASSPATH=%DIRNAME%\config;%DIRNAME%\lib\*

java -cp "%CLASSPATH%;%DIRNAME%\command-line.jar" com.samsung.main.AppMain
