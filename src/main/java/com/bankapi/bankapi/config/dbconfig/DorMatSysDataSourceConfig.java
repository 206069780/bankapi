package com.bankapi.bankapi.config.dbconfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.config.dbconfig
 * @ProjectName bankapi
 * @ClassName DataSource2Config
 * @Email fudaopin@gamil.com
 * @date 2021/4/19 下午3:30
 * @Description DORMAT数据库 配置类
 */
@Configuration
@MapperScan(basePackages = "com.bankapi.bankapi.dao.dormatsysdao", sqlSessionFactoryRef = "DorMatSqlSessionFactoryRef")
public class DorMatSysDataSourceConfig {


    /**
     * 数据库的会话模板
     * @param sqlSessionFactory
     * @return
     */
    @Bean("sqlSessionTemplate")

    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("DorMatSqlSessionFactoryRef") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 数据库会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */

    @Bean("DorMatSqlSessionFactoryRef")
    public SqlSessionFactory sqlSessionFactory (@Qualifier("DorMatDatasource") DataSource dataSource) throws Exception
    {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/dormatsysmapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 获取 DorMatDatasource 数据源
     * @return
     */
    @Bean("DorMatDatasource")

    @ConfigurationProperties("spring.datasource.dormatsys")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 获取 数据库 事务
     * @param dataSource
     * @return
     */
    @Bean

    public DataSourceTransactionManager transactionManager(@Qualifier("DorMatDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
