package com.example.test01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test01.domain.SimpleBbsDto;

@Mapper // 까먹지 말고 먼저쓰기. mybatis로 만들고 있으면!!!
public interface ISimpleBbsDao {
	
	public List<SimpleBbsDto> getList(); // 구현체는 mapper에 만든다.
	public SimpleBbsDto getDto(@Param("id") String id); // 파라미터로 받으면 문자열이니까 String id 로 쓴다.
	public void write(String writer, String title, String content); // 구현체는 mapper에 만든다.

	public void write2(String writer, String title, String content);
	//public void write2(@Param("writer") String writer, @Param("title") String title, @Param("content") String content); // 파라미터 이름을 지정해주고 싶을땐 이렇게 쓴다.
	
	public void write3(@Param("dto") SimpleBbsDto dto);
	
	public void delete(@Param("id") String id);

}
