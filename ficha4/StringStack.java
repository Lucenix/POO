package com.poo.ficha4;

import java.util.ArrayList;
import java.util.Objects;

public class StringStack {
    private ArrayList<String> stack;
    private int sp;

    public StringStack(ArrayList<String> stack, int sp) {
        this.setStack(stack);
        this.setSp(sp);
    }

    public StringStack(StringStack s) {
        this.sp = (s.getSp());
        this.stack = (s.getStack());
    }

    @Override
    public StringStack clone() {
        return new StringStack(this);
    }

    public ArrayList<String> getStack() {
        return new ArrayList<String>(stack);
    }

    public void setStack(ArrayList<String> stack) {
        this.stack = new ArrayList<>(stack);
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringStack that = (StringStack) o;
        return sp == that.sp &&
                stack.equals(that.stack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stack, sp);
    }

    @Override
    public String toString() {
        return "StringStack{" +
                "stack=" + stack +
                ", sp=" + sp +
                '}';
    }

    String top() {
        String r;
        if (sp>0)
            r = stack.get(sp-1);
        else
            r = "";
        return r;
    }

    void push(String s) {
        stack.set(sp++, s);
    }

    void pop() {
        if (sp>0)
            sp--;
    }

    boolean empty() {
        return sp == 0;
    }

    int length() {
        return sp;
    }
}
