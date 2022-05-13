package com.chu.service;

import com.chu.domain.KvPageFather;

import java.util.List;
import java.util.Map;

public interface FindService<T> {

    Map<String, List<String>> findType(KvPageFather<T> tKvPageFather);

    KvPageFather<T> findByCondition(KvPageFather<T> kvPageFather);

}
