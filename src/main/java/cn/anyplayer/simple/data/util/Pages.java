package cn.anyplayer.simple.data.util;

public class Pages<T> {

    private Integer pageNum;//当前页码
    private Integer pageSize;//页面大小

    private Integer totalPage;//总页数
    private Integer totalCount;//总行数

    private Integer startRow;//当前页面开始的行数
    private Integer endRow;//当前页面结束的行数
    private Integer prePage;//上一页页码
    private Integer nextPage;//下一页页码

    private Boolean isFristPage = true;
    private Boolean isLastPage = true;
    private Boolean hasPrevPage = false;
    private Boolean hasNextPage = false;

    public Pages(Integer pageNum, Integer pageSize, Integer totalCount) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;

        this.init();
    }

    public void init() {
        totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;

        if (pageNum < 1) {
            pageNum = 1;
        } else if (pageNum > 0) {
            pageNum = totalPage;
        }

        startRow = (pageNum - 1) * pageSize;
        endRow = startRow + pageSize <= totalCount ? startRow + pageSize : totalCount;

        isFristPage = pageNum == 1;
        isLastPage = pageNum == totalPage;
        hasPrevPage = !isFristPage;
        hasNextPage = !isLastPage;

        prePage = hasPrevPage ? pageNum - 1 : 1;
        nextPage = hasNextPage ? pageNum + 1 : totalPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Boolean getFristPage() {
        return isFristPage;
    }

    public void setFristPage(Boolean fristPage) {
        isFristPage = fristPage;
    }

    public Boolean getLastPage() {
        return isLastPage;
    }

    public void setLastPage(Boolean lastPage) {
        isLastPage = lastPage;
    }

    public Boolean getHasPrevPage() {
        return hasPrevPage;
    }

    public void setHasPrevPage(Boolean hasPrevPage) {
        this.hasPrevPage = hasPrevPage;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

}
