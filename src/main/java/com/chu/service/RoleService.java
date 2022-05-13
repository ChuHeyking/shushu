package com.chu.service;

import com.chu.domain.Kv2;
import com.chu.domain.KvPageFather;
import com.chu.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

    //KvPageFather<Role> findByPage(KvPageFather<Role> kvPageFather);

    Map<String,List<String>> findType();

    KvPageFather<Role> findByCondition(KvPageFather<Role> kvPageFather);

    //void update();
}
