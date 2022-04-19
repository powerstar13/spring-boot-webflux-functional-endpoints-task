package study.webflux.functionalendpointtask.presentation.webFlux;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import study.webflux.functionalendpointtask.application.hello.HelloApplicationService;
import study.webflux.functionalendpointtask.application.hello.response.HelloMessageResponse;
import study.webflux.functionalendpointtask.presentation.shared.response.BadRequestResponse;

import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class HelloHandler {

    private final HelloApplicationService helloApplicationService;

    /**
     * [Functional Endpoints]
     * `name` 파라미터를 추출해서 Response 반환하기
     * @param request : 이름
     * @return Mono<ServerResponse> : 전달된 이름으로 메시지 전송
     */
    public Mono<ServerResponse> helloName(ServerRequest request) { // Request와 Response만 명시하면 된다.

        String name = request.queryParam("name").orElse(null); // Request에서 name 필드 추출

        if (StringUtils.isBlank(name)) { // 이름 유효성 검사
            return badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(new BadRequestResponse("name", "이름을 입력해 주세요.")), BadRequestResponse.class);
        }

        Mono<HelloMessageResponse> response = helloApplicationService.helloMessage(name);

        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(response, HelloMessageResponse.class);
    }
}
