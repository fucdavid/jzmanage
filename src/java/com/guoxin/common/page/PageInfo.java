// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PageInfo.java

package com.guoxin.common.page;

import com.guoxin.common.util.MathUtil;
import java.util.List;

public class PageInfo {

	protected static final Integer DEFAULT_PAGESIZE = new Integer(10);
	private Integer pageNum;
	private Integer pageSize;
	private Integer totalRows;
	private List items;

	public PageInfo(BaseCondition condition) {
	    condition.setLimitOffset();
		this.pageNum = condition.getPageNum();
		this.pageSize = condition.getPageSize();
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public Integer getNextPageNum() {
		Integer totalPages = getTotalPages();
		Integer pageNum = getPageNum();
		if (totalPages.intValue() == pageNum.intValue())
			return new Integer(0);
		else
			return MathUtil.addInteger(pageNum, new Integer(1));
	}

	public Integer getLastPageNum() {
		Integer totalPages = getTotalPages();
		Integer pageNum = getPageNum();
		if (totalPages.intValue() == pageNum.intValue())
			return new Integer(0);
		else
			return totalPages;
	}

	public Integer getPageNum() {
		if (getTotalRows().intValue() <= 0)
			return new Integer(0);
		if (pageNum == null || pageNum.intValue() <= 0)
			return new Integer(1);
		Integer totalPages = getTotalPages();
		if (totalPages.compareTo(pageNum) < 0)
			return totalPages;
		else
			return pageNum;
	}

	public int getFirstResult() {
		return (getPageNum().intValue() - 1) * getPageSize().intValue();
	}

	public Integer getFirstPageNum() {
		if (getTotalRows().intValue() > 0 && getPageNum().intValue() != 1)
			return new Integer(1);
		else
			return new Integer(0);
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		if (pageSize == null)
			return DEFAULT_PAGESIZE;
		else
			return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPrePageNum() {
		Integer pageNum = getPageNum();
		if (pageNum.intValue() > 1)
			return MathUtil.addInteger(pageNum, new Integer(-1));
		else
			return new Integer(0);
	}

	public Integer getTotalPages() {
		Integer pageSize = getPageSize();
		return new Integer((new Double(Math.ceil(getTotalRows().doubleValue()
				/ pageSize.doubleValue()))).intValue());
	}

	public Integer getTotalRows() {
		if (totalRows == null)
			return new Integer(0);
		else
			return totalRows;
	}

	public void setTotalRows(Integer totalNum) {
		totalRows = totalNum;
	}

	public Integer getPageRows() {
		Integer totalPages = getTotalPages();
		Integer pageNum = getPageNum();
		Integer pageSize = getPageSize();
		if (totalPages.intValue() == pageNum.intValue()) {
			Integer modValue = getTotalRows().intValue() % pageSize.intValue();
			if (modValue == 0) {
				return new Integer(modValue + 1);
			}else{
				return new Integer(modValue);
			}
		} else {
			return pageSize;
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("<pagelist totalpages=\"");
		sb.append(getTotalPages());
		sb.append("\" totalrecords=\"");
		sb.append(getTotalRows());
		sb.append("\" currentpage=\"");
		sb.append(getPageNum());
		sb.append("\" pagesize=\"");
		sb.append(getPageSize());
		sb.append("\" firstpage=\"");
		sb.append(getFirstPageNum());
		sb.append("\" prepage=\"");
		sb.append(getPrePageNum());
		sb.append("\" nextpage=\"");
		sb.append(getNextPageNum());
		sb.append("\" lastpage=\"");
		sb.append(getLastPageNum());
		sb.append("\" pagerecords=\"");
		sb.append(getPageRows());
		sb.append("\"/>");
		return sb.toString();
	}

}
