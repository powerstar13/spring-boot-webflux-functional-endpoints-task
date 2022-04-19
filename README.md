# REST API에 반응하는 local 웹 서버 앱 구축

## Spec

1. Spring 5+ Or SpringBoot 2+
2. Java 8+
3. WebFlux
4. Functional Endpoint
5. WebClient

## Request

1. 외부 통신 : `GET localhost:8080/hello?name=$name`
2. 내부 통신 : `GET localhost:8081/info-service/job?name=$name`

## Response

`application/json`
- 직업 데이터가 추가 되었다.
```json
{
    "to": "$name", 
    "job": "",
    "message": "hello $name"
}
```

# 생성된 파일 및 패키지 위치

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
