package com.jt.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wangning
 * @create 2021-02-09 21:45
 */
@Data
@Accessors(chain = true)
@TableName
public class User implements Serializable {

	private static final long serialVersionUID = -3048838521908900102L;
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String name;
	private Integer age;
	private String sex;
}
