package com.leaf4.app.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ItemVO {
	private String search_Name;      /* 검색어 */

	private int itemNo;              /* 상품번호 */
	private String itemName;         /* 상품명  */
	private int itemCate;      	     /* 상품카테고리  */
	private String itemPrice;        /* 상품금액  */
	private String itemDel;          /* 상품삭제여부  */
	private String wrDatetime;       /* 등록일  */
	private String upDatetime;       /* 업데이트일  */
	
	
}
