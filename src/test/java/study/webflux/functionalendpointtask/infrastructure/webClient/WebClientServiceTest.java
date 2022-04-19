package study.webflux.functionalendpointtask.infrastructure.webClient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import study.webflux.functionalendpointtask.infrastructure.webClient.response.PersonJobResponse;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebClientServiceTest {

    @Autowired
    private WebClientService webClientService;

    /**
     * WebClient 사용하여 직업 정보 조회 통신 검증
     */
    @Test
    void callInfoServiceJob() {

        String name = "홍준성";

        Mono<PersonJobResponse> response = webClientService.callInfoServiceJob(name)
            .log();

        StepVerifier.create(response)
            .assertNext(personJobResponse ->
                assertEquals("BE", personJobResponse.getJob()) // 직업 정보 검증
            )
            .verifyComplete();
    }
}