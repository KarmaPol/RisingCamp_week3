//package com.example.demo.src.config;
//
//import com.example.demo.src.domain.login.UserSession;
//import com.example.demo.src.exception.model.UnauthorizedException;
//import org.springframework.core.MethodParameter;
//import org.springframework.web.bind.support.WebDataBinderFactory;
//import org.springframework.web.context.request.NativeWebRequest;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.ModelAndViewContainer;
//
//public class AuthResolver implements HandlerMethodArgumentResolver {
//
//    @Override
//    public boolean supportsParameter(MethodParameter parameter) {
//        return parameter.getParameterType().equals(UserSession.class);
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//
//        String jws = webRequest.getHeader("Authorization");
//
//        if(jws == null || jws.equals("")){
//            throw new UnauthorizedException();
//        }
//
//
//    }
//}
