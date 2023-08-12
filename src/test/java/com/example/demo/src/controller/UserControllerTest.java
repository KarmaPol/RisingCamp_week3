package com.example.demo.src.controller;

import com.example.demo.src.domain.user.UserRepository;
import com.example.demo.src.domain.user.model.Users;
import com.example.demo.src.domain.user.req.SignupReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(RestDocumentationExtension.class)
class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    @DisplayName("회원 가입 테스트")
    void test1() throws Exception {

        SignupReq signupReq = SignupReq.builder()
                .name("abc2311@abc.test")
                .password("1234")
                .address("서울")
                .phoneNumber("010-1234-1234")
                .build();

        String json = objectMapper.writeValueAsString(signupReq);

        this.mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk());
//                .andDo(document("post-users",
////                        pathParameters(
////                                parameterWithName("userID").description("유저 ID")
////                        ),
//                        requestFields(
//                                fieldWithPath("userId").description("").isIgnored(),
//                                fieldWithPath("name").description("유저 설정 ID"),
//                                fieldWithPath("password").description("비밀번호"),
//                                fieldWithPath("phoneNumber").description("전화번호"),
//                                fieldWithPath("address").description("주소")
//                        )
//                ));

        Assertions.assertEquals(1L, userRepository.count() );
    }

    @Test
    @DisplayName("회원 가입 에러 터지나 테스트")
    void test2() throws Exception {

        SignupReq signupReq = SignupReq.builder()
                .name("abc2311")
                .password("1234")
                .address("서울")
                .phoneNumber("010-1234-1234")
                .build();

        String json = objectMapper.writeValueAsString(signupReq);

        this.mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest());
//                .andDo(document("post-users",
////                        pathParameters(
////                                parameterWithName("userID").description("유저 ID")
////                        ),
//                        requestFields(
//                                fieldWithPath("userId").description("").isIgnored(),
//                                fieldWithPath("name").description("유저 설정 ID"),
//                                fieldWithPath("password").description("비밀번호"),
//                                fieldWithPath("phoneNumber").description("전화번호"),
//                                fieldWithPath("address").description("주소")
//                        )
//                ));
    }

    @Test
    @DisplayName("회원 리스트 조회")
    void test3() throws Exception {
        // given
        Users user1 = Users.builder()
                .name("김경훈")
                .password("1234")
                .address("서울")
                .phoneNumber("010-1234-1234")
                .build();

        Users user2 = Users.builder()
                .name("김경훈2")
                .password("1234")
                .address("서울")
                .phoneNumber("010-1234-1234")
                .build();

        Users user3 = Users.builder()
                .name("김경훈3")
                .password("1234")
                .address("서울")
                .phoneNumber("010-1234-1234")
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        // expected
        this.mockMvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Matchers.is(3)));
//                .andDo(document("post-users",
////                        pathParameters(
////                                parameterWithName("userID").description("유저 ID")
////                        ),
//                        requestFields(
//                                fieldWithPath("userId").description("").isIgnored(),
//                                fieldWithPath("name").description("유저 설정 ID"),
//                                fieldWithPath("password").description("비밀번호"),
//                                fieldWithPath("phoneNumber").description("전화번호"),
//                                fieldWithPath("address").description("주소")
//                        )
//                ));
    }
}