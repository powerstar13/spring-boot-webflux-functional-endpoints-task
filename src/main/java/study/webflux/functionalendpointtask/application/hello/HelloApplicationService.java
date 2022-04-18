package study.webflux.functionalendpointtask.application.hello;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import study.webflux.functionalendpointtask.application.hello.response.HelloMessageResponse;

@Service
public class HelloApplicationService {

    /**
     * 전달된 이름으로 Hello 메시지 보내기
     * @param name : 이름
     * @return Mono<HelloMessageResponse> : 작성된 message
     */
    public Mono<HelloMessageResponse> helloMessage(String name) {

        return Mono.just(
            HelloMessageResponse.builder()
                .to(name)
                .message("Hello " + name)
                .build()
        );
    }
}
