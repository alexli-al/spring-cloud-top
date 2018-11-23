package com.cloud.dog.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;
import java.util.Map;

/**
 * @description
 * @auther dogbro
 * @date 2018-11-23 14:31
 */
@Configurable
public class DruidConfig {


    /**
     * 配置druid监控
     * 配置一个管理后台的servlet
     * 访问地址：http://localhost:2223/druid/
     * @return
     */
    @Bean
    public ServletRegistrationBean startViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //属性见：com.alibaba.druid.support.http.ResourceServlet
        servletRegistrationBean.addInitParameter("username","admin'");
        servletRegistrationBean.addInitParameter("password","123456");
        servletRegistrationBean.addInitParameter("deny","");
        servletRegistrationBean.addInitParameter("allow", "");
        return servletRegistrationBean;
    }

    /**
     * 配置一个web监控的filter
     * @return
     */
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        //属性见：com.alibaba.druid.support.http.WebStatFilter
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.jpeg,*.png,*.css,*.css,*.ico,*,/druid/*");
        return filterRegistrationBean;
    }

}
