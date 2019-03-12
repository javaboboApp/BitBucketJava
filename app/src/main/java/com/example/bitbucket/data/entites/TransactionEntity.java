package com.example.bitbucket.data.entites;


import java.util.List;


public class TransactionEntity {

    private String culture;
    private String status;
    private Result result;

   public class Result {
        private List<StatementEntity> statements;

        public List<StatementEntity> getStatements() {
            return statements;
        }


    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
