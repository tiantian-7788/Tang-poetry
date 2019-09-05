package com.tiantian.tangshianalyze.analyze.dao.impl;

import com.tiantian.tangshianalyze.analyze.dao.AnalyzeDao;
import com.tiantian.tangshianalyze.analyze.entity.PoetryInfo;
import com.tiantian.tangshianalyze.analyze.model.AuthorCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author：tiantian
 * Created：2019/3/19
 */
public class AnalyzeDaoImpl implements AnalyzeDao {
    private final Logger logger=LoggerFactory.getLogger(AnalyzeDaoImpl.class);
    private final DataSource dataSource;

    public AnalyzeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<AuthorCount> analyzeAuthorCount() {
        List<AuthorCount> datas=new ArrayList<>();
        //try()自动关闭
        String sql="select count(*) as count,author from poetry_info group by author;";
        try (Connection connection =dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()){
                AuthorCount authorCount = new AuthorCount();
                authorCount.setAuthor(rs.getString("author"));
                authorCount.setCount(rs.getInt("count"));
                datas.add(authorCount);
            }
        } catch (SQLException e) {
            logger.error("Database query occur exception{}.",e.getMessage());
        }
        return datas;
    }

    @Override
    public List<PoetryInfo> queryAllPoetryInfo() {
        List<PoetryInfo> datas = new ArrayList<>();
        String sql = "select title, dynasty , author, content from poetry_info;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()) {
                PoetryInfo poetryInfo = new PoetryInfo();
                poetryInfo.setTitle(rs.getString("title"));
                poetryInfo.setDynasty(rs.getString("dynasty"));
                poetryInfo.setAuthor(rs.getString("author"));
                poetryInfo.setContent(rs.getString("content"));
                //ORM  mybatis Spring-Data-JDBC hibernate JOOQ TopLink   dbUtils
                datas.add(poetryInfo);
            }
        } catch (SQLException e) {
            logger.error("Database query occur exception{}.",e.getMessage());
        }
        return datas;
    }
}
