package fan.company.callingexternalapi.services;

import fan.company.callingexternalapi.entity.Post;
import fan.company.callingexternalapi.payload.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpenFeignService {

    private final OpenFeignInterface openFeignInterface;

    public List<PostDto> getPosts() {
        return openFeignInterface.getAllPosts();
    }

    public PostDto getPost(Integer id) {
        return openFeignInterface.getPostById(id);
    }

    public Post createPost(PostDto dto) {
        return openFeignInterface.createPost(dto);
    }
}
