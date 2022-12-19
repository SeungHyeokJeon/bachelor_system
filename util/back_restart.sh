#!/bin/sh

# change working directory
current_path=`pwd`
cd ../backend
rm -rf ./build/generated
./gradlew init && ./gradlew build && docker-compose restart hs_back

# return to origin path
cd $current_path