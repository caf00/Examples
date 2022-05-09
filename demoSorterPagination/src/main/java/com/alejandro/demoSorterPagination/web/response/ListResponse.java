package com.alejandro.demoSorterPagination.web.response;

import java.util.List;

public class ListResponse <T> extends Pagination{
    List<T> list;

    public ListResponse(Integer page,
                        Integer total,
                        Integer totalElement,
                        boolean next,
                        boolean previous,
                        List<T> list) {
        super(page, total, totalElement, next, previous);
        this.list = list;
    }

    public static <T> ListResponse<T> newListResponse(Integer page,
                                                      Integer total,
                                                      Integer totalElement,
                                                      boolean next,
                                                      boolean previous,
                                                      List<T> list) {
        return new ListResponse<>(page, total, totalElement, next, previous, list);
    }

    public List<T> getList() {
        return list;
    }
}
