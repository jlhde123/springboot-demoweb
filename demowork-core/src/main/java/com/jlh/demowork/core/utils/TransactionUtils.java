package com.jlh.demowork.core.utils;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 事务工具
 */
public class TransactionUtils {

    private DataSourceTransactionManager dataSourceTransactionManager;

    public TransactionUtils(DataSourceTransactionManager dataSourceTransactionManager) {
        this.dataSourceTransactionManager = dataSourceTransactionManager;
    }

    /**
     * @param transactionDefinition 事务隔离等级
     * @param callbackFunction 回调方法
     * @param <T>
     * @return
     */
    public <T> T exec(int transactionDefinition,CallbackFunction<T> callbackFunction){
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(transactionDefinition);
        TransactionStatus status = dataSourceTransactionManager.getTransaction(def); // get
        try {
            T call = callbackFunction.call();
            dataSourceTransactionManager.commit(status);
            return call;
        }catch (Exception e){
            dataSourceTransactionManager.rollback(status);
            throw new RuntimeException(e);
        }
    }

    public <T> T exec(CallbackFunction<T> callbackFunction){
        return exec(TransactionDefinition.PROPAGATION_REQUIRED,callbackFunction);
    }



}
