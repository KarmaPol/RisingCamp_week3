package com.example.demo.src.domain.post;

import com.example.demo.src.domain.post.model.Post;
import com.example.demo.src.domain.user.UserRepository;
import com.example.demo.src.domain.user.model.Users;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureWebMvc
class PostControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    @DisplayName("게시글 페이징 테스트")
//    @Transactional
    void test1() throws Exception {

        // given
        Users user = Users.builder().name("kkh@g.com").address("seoul").phoneNumber("12345").password("1234152").build();
        userRepository.save(user);

        Post post1 = Post.builder().itemId(0L).quantity(30).content("content").title("title").price(100).build();
        Post post2 = Post.builder().itemId(1L).quantity(30).content("content").title("title").price(100).build();
        Post post3 = Post.builder().itemId(2L).quantity(30).content("content").title("title").price(100).build();
        Post post4 = Post.builder().itemId(3L).quantity(30).content("content").title("title").price(100).build();
        Post post5 = Post.builder().quantity(30).itemId(4L).content("content").title("title").price(100).build();
        Post post6 = Post.builder().quantity(30).itemId(5L).content("content").title("title").price(100).build();
        Post post7 = Post.builder().quantity(30).itemId(6L).content("content").title("title").price(100).build();
        Post post8 = Post.builder().quantity(30).itemId(7L).content("content").title("title").price(100).build();
        Post post9 = Post.builder().itemId(8L).quantity(30).content("content").title("title").price(100).build();
        Post post10 = Post.builder().itemId(9L).quantity(30).content("content").title("title").price(100).build();
        Post post11 = Post.builder().itemId(10L).quantity(30).content("content").title("title").price(100).build();
        Post post12 = Post.builder().itemId(11L).quantity(30).content("content").title("title").price(100).build();
        Post post13 = Post.builder().itemId(12L).quantity(30).content("content").title("title").price(100).build();
        Post post14 = Post.builder().itemId(13L).quantity(30).content("content").title("title").price(100).build();
        Post post15 = Post.builder().itemId(14L).quantity(30).content("content").title("title").price(100).build();
        Post post16 = Post.builder().itemId(15L).quantity(30).content("content").title("title").price(100).build();

        post1.setUser(user);
        post2.setUser(user);
        post3.setUser(user);
        post4.setUser(user);
        post5.setUser(user);
        post6.setUser(user);
        post7.setUser(user);
        post8.setUser(user);
        post9.setUser(user);
        post10.setUser(user);
        post11.setUser(user);
        post12.setUser(user);
        post13.setUser(user);
        post14.setUser(user);
        post15.setUser(user);
        post16.setUser(user);

        List<Post> posts = Arrays.asList(post1, post2, post3, post4, post5, post6, post7,post8,post9,post10,post11,post12,post13,post14,post15,post16);
        postRepository.saveAllAndFlush(posts);

        mockMvc.perform(get("/posts?page=0&size=10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Matchers.is(10)));

        Assertions.assertEquals(postRepository.count(), 16);
    }
}