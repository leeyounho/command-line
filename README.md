## Overview
- picocli 기반으로 java CLI Program을 만들기 위해 사용하는 template project.  
- 기본적인 database 연결, thread pool, logging, cli 관련 template class 정의되어 있음.

## Dependencies
- DI: dagger2
- ORM: hibernate
- logging: log4j2
- util: guava, sshj, tablesaw 등

## Component/Subcomponent 추가 방법
- [AppComponent.java](src%2Fmain%2Fjava%2Fcom%2Fyounho%2Fdi%2Fcomponent%2FAppComponent.java) 에 추가
