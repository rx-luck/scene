package com.djc.scene.dao;

import com.djc.scene.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User query(int id);
    void save(User user);
}
