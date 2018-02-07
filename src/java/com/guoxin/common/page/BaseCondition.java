
package com.guoxin.common.page;

public class BaseCondition {
    protected static final Integer DEFAULT_PAGESIZE = new Integer(10);
    
    private Integer pageSize;        //每页显示条数
    private Integer pageNum;         //当前页码
    private Integer limit;           //分页起点
    private Integer offset;          //分页偏移量
    private String orderBys;         //排序规则

	public BaseCondition(){
	    
	}

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
    
    public String getOrderBys() {
        return orderBys;
    }
    public void setOrderBys(String orderBys) {
        this.orderBys = orderBys;
    }

    //根据当前页码及每页显示条数计算出limit offset
    public void setLimitOffset(){
        if(this.pageSize == null || this.pageSize.intValue() == 0){
            this.pageSize = DEFAULT_PAGESIZE;
        }
        if(this.pageNum == null || this.pageNum.intValue() == 0 || this.pageNum.intValue() == 1){
            this.limit = 0;
        }else{
            this.limit = (this.pageNum.intValue() - 1) * this.pageSize;
        }
        this.offset = this.pageSize;
    }

}
