package com.app.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by lucky on 2018/1/11.
 */
public class DataSource {
    private HikariDataSource ds;

    /**
     * 初始化连接池
     *
     * @param minimum
     * @param Maximum
     */
    public void init(int minimum, int Maximum) {
        //连接池配置
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/spring_boot?serverTimezone=UTC&user=root&password=root&useUnicode=true&characterEncoding=utf8");
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 500);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        config.setConnectionTestQuery("SELECT 1");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setAutoCommit(true);
        //池中最小空闲链接数量
        config.setMinimumIdle(minimum);
        //池中最大链接数量
        config.setMaximumPoolSize(Maximum);
        ds = new HikariDataSource(config);

    }

    /**
     * 销毁连接池
     */
    public void shutdown() {
        ds.close();
    }

    /**
     * 从连接池中获取链接
     *
     * @return
     */
    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            ds.getHikariPoolMXBean().resumePool();
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        DataSource ds = new DataSource();
        ds.init(10, 50);
        Connection conn = ds.getConnection();

        conn.prepareStatement("").executeQuery();
        //......
        //最后关闭链接
        conn.close();
    }
}
