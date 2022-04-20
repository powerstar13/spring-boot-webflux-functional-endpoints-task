# REST API에 반응하는 local 웹 서버 앱 구축

## Github Repository Link

`현재 접근하신 레포지토리는 SayHello Server 입니다.`

### [SayHello Server](https://github.com/powerstar13/spring-boot-webflux-functional-endpoints-task)
- Server port = 8080
### [InfoService Server](https://github.com/powerstar13/spring-boot-msa-info-service-task)
- Server port = 8081

## Spec

1. Spring 5+ Or SpringBoot 2+
2. Java 8+
3. WebFlux
4. Functional Endpoint
5. WebClient

## SayHello Server Request

`GET localhost:8080/hello?name=$name`

## SayHello Server Response

`application/json`
- 직업 데이터가 추가 되었다.
```json
{
    "to": "$name", 
    "job": "BE",
    "message": "hello $name"
}
```

## InfoService Server Request

`GET localhost:8081/info-service/job?name=$name`

## InfoService Server Response

`application/json`
```json
{ 
    "job": "BE"
}
```

# 생성된 파일 및 패키지 위치

1. resources
   1. application.yml
```java
// HelloMessageResponse
// HelloMessageResponseFactory
package study.webflux.functionalendpointtask.application.hello.response;

// HelloApplicationService
// HelloApplicationServiceTest >>> TEST
package study.webflux.functionalendpointtask.application.hello;

// BadRequestResponse
package study.webflux.functionalendpointtask.presentation.shared.response;

// HelloHandler
// HelloHandlerTest >>> TEST
package study.webflux.functionalendpointtask.presentation.webFlux;

// WebFluxConfig
package study.webflux.functionalendpointtask.infrastructure.config;

// HelloMessageResponseFactoryImpl
package study.webflux.functionalendpointtask.infrastructure.dto;

// WebClientService
// WebClientServiceTest >>> TEST
package study.webflux.functionalendpointtask.infrastructure.webClient;

// PersonJobResponse
package study.webflux.functionalendpointtask.infrastructure.webClient.response;
```
