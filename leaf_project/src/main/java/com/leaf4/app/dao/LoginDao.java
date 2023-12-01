package com.leaf4.app.dao;

import org.apache.ibatis.annotations.Mapper;

import com.leaf4.app.vo.MemberVO;

@Mapper
public interface LoginDao {
	public MemberVO getMember(String memId);
	public int insertMember(MemberVO member);
}
