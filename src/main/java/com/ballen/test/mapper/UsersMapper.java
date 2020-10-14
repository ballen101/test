package com.ballen.test.mapper;

import com.ballen.test.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UsersMapper {
    Users selectByCid (int cid);
}
