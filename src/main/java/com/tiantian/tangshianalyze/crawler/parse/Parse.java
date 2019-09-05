package com.tiantian.tangshianalyze.crawler.parse;

import com.tiantian.tangshianalyze.crawler.common.Page;

/**
 * Author：tiantian
 * Created：2019/3/19
 */
public interface Parse {
    /**
     * 解析页面
     * @param page
     */
    void parse(final Page page);
}
