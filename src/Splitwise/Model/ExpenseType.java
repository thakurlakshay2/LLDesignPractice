package Splitwise.Model;

import java.util.HashMap;

public enum ExpenseType {
    EQUAL("EQUAL"),
    EXACT("EXACT"),
    PERCENT("PERCENT");

    private final String expense;

    ExpenseType(String s){
        this.expense=s;
    }
    public String toString(){
        return this.expense;
    }

    private static final HashMap<String,ExpenseType> map=new HashMap<>(values().length,1);
}
