package com.tiantian.tangshianalyze;

import com.alibaba.druid.pool.DruidDataSource;
import com.tiantian.tangshianalyze.analyze.dao.AnalyzeDao;
import com.tiantian.tangshianalyze.analyze.dao.impl.AnalyzeDaoImpl;
import com.tiantian.tangshianalyze.analyze.service.AnalyzeService;
import com.tiantian.tangshianalyze.analyze.service.impl.AnalyzeServiceImpl;
import com.tiantian.tangshianalyze.config.ConfigProperties;
import com.tiantian.tangshianalyze.config.ObjectFactory;
import com.tiantian.tangshianalyze.crawler.Crawler;
import com.tiantian.tangshianalyze.crawler.common.Page;
import com.tiantian.tangshianalyze.crawler.parse.DataPageParse;
import com.tiantian.tangshianalyze.crawler.parse.DocumentParse;
import com.tiantian.tangshianalyze.crawler.pipeline.ConsolePipeline;
import com.tiantian.tangshianalyze.crawler.pipeline.DatabasePipeline;
import com.tiantian.tangshianalyze.web.WebController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import static spark.route.HttpMethod.get;

/**
 * 唐诗分析程序的主类
 * Author：tiantian
 * Created：2019/3/18
 */
public class TangShiAnalyzeApplication {
    private static final Logger LOGGER=LoggerFactory.getLogger(TangShiAnalyzeApplication.class);
    public static void main(String[] args) {

        WebController webController=ObjectFactory.getInstance().getObject(WebController.class);
        //运行web服务，提供接口
        LOGGER.info("Web Server launch...");
        webController.launch();

        //启动爬虫
        if(args.length==1&&args[0].equals("run-crawler")){
            Crawler crawler=ObjectFactory.getInstance().getObject(Crawler.class);
            LOGGER.info("Crawler started...");
            crawler.start();
        }
    }
}