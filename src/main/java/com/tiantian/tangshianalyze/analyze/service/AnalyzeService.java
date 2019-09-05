package com.tiantian.tangshianalyze.analyze.service;

import com.tiantian.tangshianalyze.analyze.model.AuthorCount;
import com.tiantian.tangshianalyze.analyze.model.WordCount;

import java.util.List;

/**
 * Author：tiantian
 * Created：2019/3/19
 */
public interface AnalyzeService {
    //分析唐诗中作者的创作数量
    List<AuthorCount> analyzeAuthorCount();
    //词云分析
    List<WordCount> analyzeWoldCloud();
}
