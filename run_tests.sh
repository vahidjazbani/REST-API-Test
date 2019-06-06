#!/bin/bash
docker build -t test_runner .
docker run -t test_runner ./gradlew -i integrationTest
