@echo on

@REM change working directory
SET current_path=`pwd`
cd ../backend
@REM rmdir -s ./build/generated
./gradlew clean bootrun

@REM return to origin path
cd %current_path%