package fan.company.callingexternalapi.services;


import fan.company.callingexternalapi.entity.Post;
import fan.company.callingexternalapi.payload.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "PostClient", url = "https://jsonplaceholder.typicode.com")
@Component
public interface OpenFeignInterface {

    @GetMapping("/posts")
    List<PostDto> getAllPosts();

    @GetMapping("/posts/{id}")
    PostDto getPostById(@PathVariable("id") Integer id);

    @PostMapping("/posts")
    Post createPost(@RequestBody PostDto postDto);

}
