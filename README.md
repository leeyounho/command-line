## 용도
- java CLI Program 용도의 template project  
- database 연결, thread pool, logging, cli 관련 template class 정의됨

## Component/Subcomponent 추가
- [AppComponent.java](src%2Fmain%2Fjava%2Fcom%2Fyounho%2Fdi%2Fcomponent%2FAppComponent.java) 에 추가

## PicoCommand 추가 방법
1. [picocli](src%2Fmain%2Fjava%2Fcom%2Fyounho%2Fcommand%2Fpicocli) 아래 class 추가  
2. [PicoCommandModule.java](src%2Fmain%2Fjava%2Fcom%2Fyounho%2Fdi%2Fmodule%2Fcommand%2FPicoCommandModule.java) 에 bind method 추가  
