package fan.company.callingexternalapi.controllers;

import fan.company.callingexternalapi.entity.Post;
import fan.company.callingexternalapi.payload.PostDto;
import fan.company.callingexternalapi.services.OpenFeignService;
import fan.company.callingexternalapi.services.WebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/openFeignClient")
public class OpenFeignController {

    private final OpenFeignService openFeignService;

    @GetMapping("/getAllPosts")
    public HttpEntity<?> getAllPosts() {
        List<PostDto> posts = openFeignService.getPosts();
        return new HttpEntity<>(posts);
    }

    @GetMapping("/getPost/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Integer id) {
        PostDto post = openFeignService.getPost(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> post(@RequestBody PostDto dto) throws Exception {
        Post createdPost = openFeignService.createPost(dto);
        return ResponseEntity.ok(createdPost);
    }

}
