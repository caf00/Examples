package com.alejandro.paginationexample.response;

import com.alejandro.paginationexample.entity.Animal;

import java.util.List;

public class AnimalResponse {
    private List<Animal> data;
    private boolean first;
    private boolean last;
    private int totalPage;
    private int numberElement;
    private int numberPage;
    private int nextPage;
    private int prevPage;
    private boolean empty;

    public AnimalResponse(List<Animal> data,
                          boolean first,
                          boolean last,
                          int totalPage,
                          int numberElement,
                          int numberPage,
                          boolean empty) {
        this.data = data;
        this.first = first;
        this.last = last;
        this.totalPage = totalPage;
        this.numberElement = numberElement;
        this.numberPage = numberPage;
        this.empty = empty;
        this.setNextPrev();
    }

    public List<Animal> getData() {
        return data;
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isLast() {
        return last;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public int getNumberElement() {
        return numberElement;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public boolean isEmpty() {
        return empty;
    }

    private void setNextPrev() {
        this.nextPage = (!this.last) ? this.numberPage + 1 : this.numberPage;
        this.prevPage = (!this.first) ? this.numberPage -1 : this.numberPage;
    }
}
