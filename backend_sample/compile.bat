@echo off
Set app_name=restsample
FOR %%i IN (init,build,run) DO ( IF %%i==run ( "%JAVA_HOME%\bin\java.exe" -jar  ./build/libs/%app_name%-0.0.1-SNAPSHOT.jar ) ELSE ( .\gradlew %%i ) )