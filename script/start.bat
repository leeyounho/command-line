REM 클래스패스로 사용할 lib 폴더 내 모든 JAR 파일 설정
set CLASSPATH=.\config;.\lib\*;

REM your-project.jar 실행
java -cp "%CLASSPATH%;command-line.jar" com.samsung.main.AppMain

pause