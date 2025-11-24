package org.uv.tcswpractica02;

import java.sql.Connection;

public abstract class TransactionDB<T> {
    protected T pojoDB;
    protected TransactionDB(T pojoDB){
        this.pojoDB=pojoDB;
    }
    public abstract boolean execute(Connection con);
}
