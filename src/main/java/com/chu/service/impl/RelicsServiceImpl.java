package com.chu.service.impl;

import com.chu.dao.RelicsDao;
import com.chu.domain.KvPageFather;
import com.chu.domain.Relics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("relicsService")
public class RelicsServiceImpl extends FindServiceImpl<Relics> {

    @Autowired
    private RelicsDao relicsDao;

    @Override
    public Map<String, List<String>> findType(KvPageFather<Relics> kvPageFather) {
        super.setFindDao(relicsDao);
        return super.findType(kvPageFather);
    }

    @Override
    public KvPageFather<Relics> findByCondition(KvPageFather<Relics> kvPageFather) {
        super.setFindDao(relicsDao);
        return super.findByCondition(kvPageFather);
    }
}
