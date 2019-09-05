package com.tiantian.tangshianalyze.config;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Author：tiantian
 * Created：2019/3/19
 */
@Data
public class ConfigProperties {
    private String crawlerBase;
    private String crawlerPath;
    private boolean crawlerDetail;

    private String dbUsername;
    private String dbPassword;
    private String dbUrl;
    private String dbDiverclass;

    private boolean enableConsole;
    public ConfigProperties(){
        //从外部文件去加载
        InputStream inputStream=ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties");
        Properties p=new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.crawlerBase= String.valueOf(p.get("crawler.base"));
        this.crawlerPath= String.valueOf(p.get("crawler.path"));
        this.crawlerDetail= Boolean.parseBoolean(String.valueOf(p.get("crawler.detail")));
        this.dbUsername= String.valueOf(p.get("db.username"));
        this.dbPassword= String.valueOf(p.get("db.password"));
        this.dbUrl= String.valueOf(p.get("db.url"));
        this.dbDiverclass= String.valueOf(p.get("db.driver_class"));

        this.enableConsole=Boolean.valueOf(String.valueOf(p.getProperty("config.enable_console","false")));
    }
}
