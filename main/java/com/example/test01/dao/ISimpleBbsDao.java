package com.example.test01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test01.domain.SimpleBbsDto;

@Mapper // 까먹지 말고 먼저쓰기. mybatis로 만들고 있으면!!!
public interface ISimpleBbsDao {
	
	public List<SimpleBbsDto> getList();

}
