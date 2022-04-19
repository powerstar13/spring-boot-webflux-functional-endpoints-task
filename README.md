# REST API에 반응하는 local 웹 서버 앱 구축

## Spec

1. Spring 5+ Or SpringBoot 2+
2. Java 8+
3. WebFlux
4. Functional Endpoint

## Request

`GET localhost:8080/hello?name=$name`

## Response

`application/json`

```json
{
	"to": "$name",
	"message": "hello $name"
}
```

# 생성된 파일의 패키지 위치

```java
// HelloMessageResponse
package study.webflux.functionalendpointtask.application.hello.response;

// BadRequestResponse
package study.webflux.functionalendpointtask.presentation.shared.response;

// HelloApplicationService
package study.webflux.functionalendpointtask.application.hello;

// HelloApplicationServiceTest >>> TEST
package study.webflux.functionalendpointtask.application.hello;

// HelloHandler
package study.webflux.functionalendpointtask.presentation.webFlux;

// WebFluxConfig
package study.webflux.functionalendpointtask.infrastructure.config;

// HelloHandlerTest >>> TEST
package study.webflux.functionalendpointtask.presentation.webFlux;
```
