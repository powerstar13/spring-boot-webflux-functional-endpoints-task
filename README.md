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