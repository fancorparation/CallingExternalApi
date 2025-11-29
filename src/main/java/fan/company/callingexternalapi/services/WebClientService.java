package fan.company.callingexternalapi.services;

import fan.company.callingexternalapi.entity.Post;
import fan.company.callingexternalapi.payload.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebClientService {

    private final WebClient webClient;

    public List<PostDto> getPosts() {
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(PostDto.class)
                .collectList()
                .block();
    }

    public PostDto getPost(Integer id) {
        return webClient.get()
                .uri("/posts/" + id)
                .retrieve()
                .bodyToMono(PostDto.class)
                .block();
    }

    public Post createPost(PostDto dto) {
        Post post = Post.builder()
                .userId(dto.getUserId())
                .title(dto.getTitle())
                .body(dto.getBody())
                .build();


        return webClient
                .post()
                .uri("/posts")
                .body(BodyInserters.fromValue(post))
                .retrieve()
                .bodyToMono(Post.class)
                .block();
    }
}
