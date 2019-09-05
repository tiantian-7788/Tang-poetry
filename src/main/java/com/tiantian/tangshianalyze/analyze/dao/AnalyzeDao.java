package com.tiantian.tangshianalyze.analyze.dao;

import com.tiantian.tangshianalyze.analyze.entity.PoetryInfo;
import com.tiantian.tangshianalyze.analyze.model.AuthorCount;

import java.util.List;

/**
 * Author：tiantian
 * Created：2019/3/19
 */
public interface AnalyzeDao {
    //分析唐诗中作者的创作数量
    List<AuthorCount> analyzeAuthorCount();


    //查询所有的诗文，提供给业务层进行分析
    List<PoetryInfo> queryAllPoetryInfo();

}
