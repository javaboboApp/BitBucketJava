/*
 * Copyright (C) 2016 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bitbucket.data.repository.datasource.mapper;


import com.example.bitbucket.data.entites.StatementEntity;
import com.example.bitbucket.data.entites.TransactionEntity;
import com.example.bitbucket.domain.models.Statement;
import com.example.bitbucket.domain.models.Transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TransactionEntityToTransactionMapper extends Mapper<Transaction, TransactionEntity> {


    private final StatementEntityToStatementsMapper statementEntityToStatementsMapper;

    @Inject
    public TransactionEntityToTransactionMapper(StatementEntityToStatementsMapper statementEntityToStatementsMapper) {
        this.statementEntityToStatementsMapper = statementEntityToStatementsMapper;
    }

    @Override
    public TransactionEntity map(Transaction value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Transaction reverseMap(TransactionEntity transactionEntity) {
        Transaction transaction = new Transaction();
        transaction.setCulture(transactionEntity.getCulture());
        transaction.setStatus(transactionEntity.getStatus());
        transaction.setStatements(statementEntityToStatementsMapper.reverseMap(transactionEntity.getResult().getStatements()));
        return transaction;
    }


}

