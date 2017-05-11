package com.zslin.basic.tools;

import org.springframework.data.domain.Sort;

/**
 * Created by zsl-pc on 2016/9/26.
 */
public class SortTools {

    public static Sort basicSort() {
        return basicSort("desc", "id");
    }

    public static Sort basicSort(String orderType, String orderField) {
        Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
        return sort;
    }
}
