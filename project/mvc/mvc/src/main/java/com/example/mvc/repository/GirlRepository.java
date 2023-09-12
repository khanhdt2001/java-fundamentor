package com.example.mvc.repository;

import com.example.mvc.model.Girl;

public interface GirlRepository {
    Girl getGirlByName(String name);
}
