package study.webflux.functionalendpointtask.application.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import study.webflux.functionalendpointtask.application.hello.response.HelloMessageResponse;
import study.webflux.functionalendpointtask.application.hello.response.HelloMessageResponseFactory;
import study.webflux.functionalendpointtask.infrastructure.webClient.WebClientService;
import study.webflux.functionalendpointtask.infrastructure.webClient.response.PersonJobResponse;

@Service
@RequiredArgsConstructor
public class HelloApplicationService {

    private final WebClientService webClientService;
    private final HelloMessageResponseFactory helloMessageResponseFactory;

    /**
     * 전달된 이름으로 Hello 메시지 보내기
     * @param name : 이름
     * @return Mono<HelloMessageResponse> : 작성된 message
     */
    public Mono<HelloMessageResponse> helloMessage(String name) {

        Mono<PersonJobResponse> personJobResponseMono = webClientService.callInfoServiceJob(name);

        return helloMessageResponseFactory.HelloMessageResponseBuilder(name, personJobResponseMono);
    }
}
