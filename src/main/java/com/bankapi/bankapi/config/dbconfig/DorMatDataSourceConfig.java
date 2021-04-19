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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.Serializable;

@Configuration
@MapperScan(basePackages = "com.bankapi.bankapi.dao.dormatdao",sqlSessionFactoryRef = "DorMatSqlSessionFactory")
public class DorMatDataSourceConfig  {

    /**
     *  获取DorMat的数据源
     * @return
     */
    @Bean(name = "DorMatSource")
    @ConfigurationProperties(prefix = "spring.datasource.dormat")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 返回DorMat数据库的会话工厂
     * @param ds
     * @return
     * @throws Exception
     */
    @Bean(name = "DorMatSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("DorMatSource") DataSource ds) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ds);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/dormatmapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 返回DorMat数据库的会话模板
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "DorMatSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate1(@Qualifier("DorMatSqlSessionFactory") SqlSessionFactory sessionFactory) throws Exception {
        return new SqlSessionTemplate(sessionFactory);
    }

    /**
     * 返回DorMat数据库的事务
     *
     * @param ds
     * @return
     */
    @Bean(name = "DorMatTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("DorMatSource") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

}
