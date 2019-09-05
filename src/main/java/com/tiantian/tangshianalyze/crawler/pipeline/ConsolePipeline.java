package com.tiantian.tangshianalyze.crawler.pipeline;

import com.tiantian.tangshianalyze.crawler.common.Page;

import java.util.Map;

/**
 * Author：tiantian
 * Created：2019/3/19
 */
public class ConsolePipeline implements Pipeline {
    @Override
    public void pipeline(final Page page) {
        Map<String,Object> data=page.getDataset().getData();
        //存储
        System.out.println(data);
    }
}
