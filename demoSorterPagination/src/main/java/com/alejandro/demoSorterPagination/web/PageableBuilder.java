package com.alejandro.demoSorterPagination.web;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableBuilder {
    public Pageable generatePageable(Integer page, Integer size, String sort, String order) {
        if(order.equals("asc")) {
            return PageRequest.of(page-1, size, Sort.by(sort).ascending());
        }
        return PageRequest.of(page-1, size, Sort.by(sort).descending());
    }
}
