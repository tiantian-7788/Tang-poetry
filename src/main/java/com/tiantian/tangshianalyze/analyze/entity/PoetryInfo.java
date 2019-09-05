package com.tiantian.tangshianalyze.analyze.entity;

import lombok.Data;

/**
 * Author：tiantian
 * Created：2019/3/19
 */
@Data
public class PoetryInfo {
    /**
     * 标题
     */
    private  String title;
    /**
     * 朝代
     */
    private  String dynasty;
    /**
     * 作者
     */
    private  String author;
    /**
     * 正文
     */
    private  String content;
}
