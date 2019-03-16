package com.wishcart.wishcart.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@Slf4j
@RequiredArgsConstructor
public class DatabaseConfiguration {
   /* @NonNull
    private WishCartProperties wishCartProperties;

    @Bean
    public DataSource dataSource(WishCartProperties.Dbdetails configuration){
        return new HikariDataSource(configuration);
    }

    @Configuration
    static class JdbcConfig{
        @Bean
        @Primary
        public JdbcTemplate jdbcTemplate(DataSource dataSource){
            return new JdbcTemplate(dataSource);
        }
        @Bean
        public LobHandler lobHandler(){
            return new DefaultLobHandler();
        }
    }

    @Slf4j
    static class ProxyDatsource implements DataSource{
        private final String jdbcUrl;
        private final Properties driverProperties = new Properties();
        private final WishCartProperties.Dbdetails configuration;
        private Driver driver;
        public ProxyDatsource(WishCartProperties.Dbdetails configuration){
            this.configuration = configuration;
            this.jdbcUrl = configuration.getUrl();
            this.driver = new OracleDriver();
            driverProperties.setProperty("User", configuration.getUsername());
            driverProperties.setProperty("password", configuration.getPassword());
            for(Map.Entry<Object, Object> entry: configuration.getDataSourceProperties().entrySet()){
                driverProperties.setProperty(entry.getKey().toString(), entry.getValue().toString());
            }
        }

        @Override
        public Connection getConnection() throws SQLException {
            return getConnection(driverProperties);
        }

        @Override
        public Connection getConnection(String username, String password) throws SQLException {
           Properties properties = new Properties(driverProperties);
           properties.setProperty("User", username);
           properties.setProperty("password", password);
           return getConnection(properties);
        }

        public Connection getConnection(Properties driverProperties) throws SQLException {
            OracleConnection connection = (OracleConnection) driver.connect(jdbcUrl, driverProperties);
            return connection;
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            throw new SQLFeatureNotSupportedException();
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }

        @Override
        public PrintWriter getLogWriter() throws SQLException {
            throw new SQLFeatureNotSupportedException();
        }

        @Override
        public void setLogWriter(PrintWriter out) throws SQLException {
            throw new SQLFeatureNotSupportedException();
        }

        @Override
        public void setLoginTimeout(int seconds) throws SQLException {
            DriverManager.setLoginTimeout(seconds);
        }

        @Override
        public int getLoginTimeout() throws SQLException {
           return DriverManager.getLoginTimeout();
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return driver.getParentLogger();
        }
    }

    @Bean
    @Primary
    public DataSource datasource(){
        return createDatasource(wishCartProperties.getDbdetails());
    }
    private HikariDataSource createDatasource(WishCartProperties.Dbdetails configuration){
        configuration.setDriverClassName(configuration.getDriverClassName());
        configuration.setUrl(configuration.getJdbcUrl());
        configuration.setUsername(configuration.getUsername());
        configuration.setPassword(configuration.getPassword());
        configuration.setMaximumPoolSize(5);
        return new HikariDataSource(configuration);
    }

*/

}
