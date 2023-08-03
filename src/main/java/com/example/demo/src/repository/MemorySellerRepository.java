package com.example.demo.src.repository;

import com.example.demo.src.domain.Seller;
import com.example.demo.src.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemorySellerRepository extends MemoryUserRepository implements SellerRepository{

}