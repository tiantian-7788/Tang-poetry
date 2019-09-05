package com.tiantian.tangshianalyze.crawler.pipeline;

import com.tiantian.tangshianalyze.crawler.common.Page;

/**
 * Author：tiantian
 * Created：2019/3/19
 */
public interface Pipeline {
    /**
     * 管道处理page的数据
     * @param page
     */
    void pipeline(final Page page);
}
