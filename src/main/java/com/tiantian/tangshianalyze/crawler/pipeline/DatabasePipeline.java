package com.tiantian.tangshianalyze.crawler.pipeline;

import com.tiantian.tangshianalyze.crawler.common.Page;
import com.tiantian.tangshianalyze.analyze.entity.PoetryInfo;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Author：tiantian
 * Created：2019/3/19
 */
public class DatabasePipeline implements Pipeline{
    private final org.slf4j.Logger logger=LoggerFactory.getLogger(DatabasePipeline.class);
    private final DataSource dataSource;

    public DatabasePipeline(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void pipeline(final Page page) {
        String dynasty=(String) page.getDataset().getData("dynasty");
        String author=(String) page.getDataset().getData("author");
        String title=(String) page.getDataset().getData("title");
        String content=(String) page.getDataset().getData("content");
        //修改对象
        String sql="insert into poetry_info(title, dynasty, author, content) VALUES (?,?,?,?)";
        try (Connection connection=dataSource.getConnection();
             PreparedStatement statement=connection.prepareStatement(sql);
        ){
            statement.setString(1,title);
            statement.setString(2,dynasty);
            statement.setString(3,author);
            statement.setString(4,content);
            statement.executeUpdate();
        }catch (SQLException e){
            logger.error("Database insert occur exception{}",e.getMessage());

        }
    }
}

