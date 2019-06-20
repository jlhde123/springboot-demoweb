package com.jlh.demowork.core.config;

import com.jlh.demowork.core.utils.TransactionUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
public class TransactionConfiguration {

    @Bean
    public TransactionUtils transactionUtils(DataSourceTransactionManager dataSourceTransactionManager){
        return new TransactionUtils(dataSourceTransactionManager);
    }

}
