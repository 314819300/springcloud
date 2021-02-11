package com.jt.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.springcloud.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User>{
	
}
