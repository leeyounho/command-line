#!/bin/bash

# 현재 스크립트가 있는 디렉토리로 이동
cd "$(dirname "$0")"

# 클래스패스로 사용할 lib 폴더 내 모든 JAR 파일 설정
CLASSPATH=./config:./lib/*

# your-project.jar에서 메인 클래스를 실행 (com.example.Main을 실제 메인 클래스 경로로 변경)
java -cp "$CLASSPATH:command-line.jar" com.example.Main
