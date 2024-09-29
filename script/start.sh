#!/bin/bash

# Go to the directory where the current script is located
DIRNAME="$( dirname "${BASH_SOURCE[0]}" )"

CLASSPATH=${DIRNAME}/config:${DIRNAME}/lib/*

java -Xms1024m -Xmx1024m -cp "$CLASSPATH:${DIRNAME}/command-line.jar" com.younho.main.AppMain
