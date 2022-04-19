package study.webflux.functionalendpointtask.application.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import study.webflux.functionalendpointtask.application.hello.response.HelloMessageResponse;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloApplicationServiceTest {

    @Autowired
    private HelloApplicationService helloApplicationService;

    @Test
    void helloMessage() {

        String name = "홍준성";

        Mono<HelloMessageResponse> result = helloApplicationService.helloMessage(name)
            .log()
            .doOnNext(helloMessageResponse -> {
                System.out.println("to >>> " + helloMessageResponse.getTo()); // to 값 출력
                System.out.println("message >>> " + helloMessageResponse.getMessage()); // message 값 출력
            });

        StepVerifier.create(result)
            .expectSubscription()
            .assertNext(helloMessageResponse ->
                assertAll(() -> {
                    assertEquals(name, helloMessageResponse.getTo()); // to 검증
                    assertEquals("hello " + name, helloMessageResponse.getMessage()); // message 검증
                })
            )
            .verifyComplete();
    }
}