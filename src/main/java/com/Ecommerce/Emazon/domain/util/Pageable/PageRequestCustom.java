package com.Ecommerce.Emazon.domain.util.Pageable;

public class PageRequestCustom {

    private int page;
    private int size;
    private boolean ascending; //true para ascendente

    public PageRequestCustom(int page, int size, boolean ascending) {
        this.page = page;
        this.size = size;
        this.ascending = ascending;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public boolean isAscending() {
        return ascending;
    }
}
