package com.alejandro.demoSorterPagination.web.response;

import java.io.Serializable;

public class Pagination implements Serializable {
    private final Integer page;
    private final Integer totalPage;
    private final Integer totalElement;
    private final boolean next;
    private final boolean previous;

    public Pagination(Integer page,
                      Integer totalPage,
                      Integer totalElement,
                      boolean next,
                      boolean previous) {
        this.page = page;
        this.totalPage = totalPage;
        this.totalElement = totalElement;
        this.next = next;
        this.previous = previous;
    }

    public static Pagination newPagination(Integer page,
                                           Integer totalPage,
                                           Integer totalElement,
                                           boolean next,
                                           boolean previous) {
        return new Pagination(page, totalPage, totalElement, next, previous);
    }

    public Integer getPage() {
        return page;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getTotalElement() {
        return totalElement;
    }

    public boolean isNext() {
        return next;
    }

    public boolean isPrevious() {
        return previous;
    }
}
