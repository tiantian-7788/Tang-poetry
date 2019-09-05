package com.tiantian.tangshianalyze.crawler.common;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Author：tiantian
 * Created：2019/3/19
 */
@Data
public class Page {
    /**
     * 数据网站的根地址
     * 比如：https//so.GuShiWen.org
     */
    private final String base;
    /**
     * 具体网页的路径
     */
    private final String path;
    /**
     * 网页DOM对象
     */
    private HtmlPage htmlPage;
    /**
     * 子页面对象集合
     */
    private Set<Page> subPage = new HashSet<>();
    /**
     * 是否详情页面
     */
    private final boolean Detail;
    /**
     * 数据对象
     */
    private DataSet dataset = new DataSet();
    public  String getUrl(){
        return this.base+this.path;
    }
}
