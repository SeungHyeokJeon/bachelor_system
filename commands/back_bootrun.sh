#!/bin/sh

# change working directory
current_path=`pwd`
cd ../backend
# rm -rf ./build/generated
./gradlew clean && ./gradlew bootrun

# return to origin path
cd $current_path