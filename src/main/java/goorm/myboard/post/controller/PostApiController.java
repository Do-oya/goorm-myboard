package goorm.myboard.post.controller;

import goorm.myboard.post.model.PostRequest;
import goorm.myboard.post.model.PostResponse;
import goorm.myboard.post.model.PostViewRequest;
import goorm.myboard.post.model.PostViewResponse;
import goorm.myboard.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping
    public PostResponse create(
            @Valid @RequestBody PostRequest postRequest
    ){
        return postService.create(postRequest);
    }

    @PostMapping("/view")
    public PostViewResponse view(
            @Valid @RequestBody PostViewRequest postViewRequest
    ){
        return postService.view(postViewRequest);
    }
}
