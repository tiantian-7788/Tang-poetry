package com.tiantian.tangshianalyze.crawler.parse;

import com.gargoylesoftware.htmlunit.html.*;
import com.tiantian.tangshianalyze.crawler.common.Page;
import com.tiantian.tangshianalyze.analyze.entity.PoetryInfo;

/**
 * 详情页面解析
 * Author：tiantian
 * Created：2019/3/19
 */
public class DataPageParse implements Parse{
    @Override
    public void parse(final Page page) {
        if (!page.isDetail()) {
            return;
        }
        HtmlPage htmlPage = page.getHtmlPage();
        HtmlPage body = page.getHtmlPage();
        //标题
        String titlePath = "//div[@class='cont']/h1/text()";
        DomText titleDom = (DomText) body.getByXPath(titlePath).get(0);
        String title = titleDom.asText();
        //作者
        String authorPath = "//div[@class='cont']/p/a[2]";
        HtmlAnchor authorDom = (HtmlAnchor) body.getByXPath(authorPath).get(0);
        String author = authorDom.asText();
        //朝代
        String dynastyXpath = "//div[@class='cont']/p/a[1]";
        HtmlAnchor dynastyDom = (HtmlAnchor) body.getByXPath(dynastyXpath).get(0);
        String dynasty = dynastyDom.asText();
        //正文
        String contentPath = "//div[@class='cont']/div[@class='contson']";
        HtmlDivision contentDom = (HtmlDivision) body.getByXPath(contentPath).get(0);
        String content = contentDom.asText();

        page.getDataset().putData("title", title);
        page.getDataset().putData("dynasty", dynasty);
        page.getDataset().putData("author", author);
        page.getDataset().putData("content", content);
        //更多的数据
        page.getDataset().putData("url",page.getUrl());
    }
}

