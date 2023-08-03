package com.example.demo.src.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    // 신규 카테고리 등록
    @PostMapping("/category")
    public void postCategory(){

    }

    // 특정 카테고리 전체 아이템 조회
    @GetMapping("/category/{categoryID}")
    public void getCategoryItem(){

    }

    // 카테고리 수정
    @PatchMapping("/category/{categoryID}")
    public void patchCategory(){

    }

    // 카테고리 삭제
    @DeleteMapping("/category/{categoryID}")
    public void deleteCategory(){

    }
}
