package com.tiantian.tangshi;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * Author：tiantian
 * Created：2019/3/18
 */
public class TestHtmlUnit {
    public static void main(String[] args) {
        try(WebClient webClient=new WebClient(BrowserVersion.CHROME)){
            webClient.getOptions().setJavaScriptEnabled(false);//不执行js文件
            HtmlPage htmlPage=webClient.getPage("https://www.gushiwen.org/");
            HtmlElement bodeElement =htmlPage.getBody();
            String text=bodeElement.asXml();//asText可取出文本，若是asXml，打印出的是代码（结构）
            System.out.println(text);
            HtmlDivision domElement=(HtmlDivision) htmlPage.getElementById("contson1ab1f8a83f5b");//强转
//            String divContent=domElement.asText();
//            System.out.println(divContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
