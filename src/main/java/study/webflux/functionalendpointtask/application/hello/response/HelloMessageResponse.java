package study.webflux.functionalendpointtask.application.hello.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloMessageResponse {

    private String to;
    private String message;
}
