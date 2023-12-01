package com.leaf4.app.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MemberVO {

	private int memNo;            /* 회원 번호 */
	private String memId;         /* 회원 아이디 */
	private String memPass;       /* 회원 비밀번호 */
	private String memName;       /* 회원 이름 */
	private String memZip;        /* 우편번호 */
	private String memAdd1;       /* 주소 */
	private String memAdd2;       /* 상세주소 */
	private String memHp;         /* 연락처 */
	private String memMail;       /* 이메일 */
	private int memMileage;       /* 마일리지 */
	private String memDelYn;     /* 탈퇴여부 */
	private String Agree;		 /* 개인정보 동의*/
	private String regDate;       /* 등록일  */
	private String UpDateTime;    /* 업데이트일  */

}
