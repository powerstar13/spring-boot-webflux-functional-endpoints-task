package study.webflux.functionalendpointtask.presentation.webFlux;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import study.webflux.functionalendpointtask.application.hello.response.HelloMessageResponse;
import study.webflux.functionalendpointtask.infrastructure.config.WebFluxConfig;
import study.webflux.functionalendpointtask.presentation.shared.response.BadRequestResponse;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloHandlerTest {

    private WebTestClient webTestClient;

    @Autowired
    private WebFluxConfig webFluxConfig;
    @Autowired
    private HelloHandler helloHandler;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient
            .bindToRouterFunction( // WebFluxConfig에서 작성한 router를 WebTestClient에 바인딩해준다.
                webFluxConfig.routerBuilder(helloHandler)
            )
            .build();
    }

    /**
     * helloName Test
     * isOk
     */
    @Test
    void helloName() {
        String name = "홍준성";

        // 바인딩된 클라이언트를 이용하여 routerBuilder에 존재하는 라우팅 엔드포인트에 요청을 보내면, 핸들러 로직을 수행 후 응답을 반환한다.
        webTestClient
            .get()
            .uri("/hello?name=" + name)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk()
            .expectBody(HelloMessageResponse.class)
            .value(helloMessageResponse ->
                assertAll(() -> {
                    assertEquals(name, helloMessageResponse.getTo()); // to 검증
                    assertEquals("BE", helloMessageResponse.getJob()); // job 검증
                    assertEquals("hello " + name, helloMessageResponse.getMessage()); // message 검증
                })
            );
    }

    /**
     * helloName Test
     * isBadRequest
     */
    @Test
    void helloName_isBlank() {
        // 이름을 전송하지 않았을 경우 BadRequest 검증
        String name = "";

        // 바인딩된 클라이언트를 이용하여 routerBuilder에 존재하는 라우팅 엔드포인트에 요청을 보내면, 핸들러 로직을 수행 후 응답을 반환한다.
        webTestClient
            .get()
            .uri("/hello?name=" + name)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isBadRequest()
            .expectBody(BadRequestResponse.class)
            .value(badRequestResponse ->
                assertAll(() -> {
                    assertEquals("name", badRequestResponse.getField()); // field 검증
                    assertEquals("이름을 입력해 주세요.", badRequestResponse.getMessage()); // message 검증
                })
            );
    }
}