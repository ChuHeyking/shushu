package com.chu.util;

import com.chu.domain.KvPageFather;

public class PageUtil<T> {
    
    public KvPageFather<T> getKvPF(Integer count,KvPageFather<T> kvPageFather){
        kvPageFather.setTotalCount(count);
        double ceil = Math.ceil(((double) (count)) / ((double) (kvPageFather.getPer())));
        kvPageFather.setTotalPage((int)(ceil));
        if (kvPageFather.getPage()<1 || kvPageFather.getPage()>kvPageFather.getTotalPage()){
            kvPageFather.setPage(1);
        }
        Integer index = (kvPageFather.getPage()-1)*kvPageFather.getPer();
        kvPageFather.setIndex(index);
        return kvPageFather;
    }

}
