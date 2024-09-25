#!/bin/bash

# Go to the directory where the current script is located
DIRNAME="$( dirname "${BASH_SOURCE[0]}" )"

CLASSPATH=${DIRNAME}/config:${DIRNAME}/lib/*

java -cp "$CLASSPATH:${DIRNAME}/command-line.jar" com.samsung.main.AppMain
