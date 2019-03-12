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
import com.example.bitbucket.domain.models.Statement;

import javax.inject.Singleton;

@Singleton
public class StatementEntityToStatementsMapper extends Mapper<Statement, StatementEntity> {
    @Override
    public StatementEntity map(Statement value) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public Statement reverseMap(StatementEntity value) {
        Statement statement = new Statement();
        statement.setFrom(value.getFrom());
        statement.setTo(value.getTo());
        statement.setDateTime(value.getDateTime());
        statement.setCredit(value.getCredit());
        statement.setDebit(value.getDebit());
        statement.setDetails(value.getDetails());
        statement.setStatus(value.getStatus());
        statement.setTransactionID(value.getTransactionID());
        statement.setCurrencyCode(value.getCurrencyCode());
        statement.setReference(value.getReference());
        return statement;
    }


}

