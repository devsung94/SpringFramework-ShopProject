package com.leaf4.login.dao;

import org.apache.ibatis.annotations.Mapper;

import com.leaf4.member.vo.MemberVO;


@Mapper
public interface ILoginDao {
	public MemberVO getMember(String memId);
	public int insertMember(MemberVO member);
}
