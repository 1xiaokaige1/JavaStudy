package com.xiaokaige.subclass;

/**
 * @author: zk
 * Date: 2021/9/28
 * Time: 16:24
 */
public class Manager extends Employee {
    private Double bonus;

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public Double getSalary() {
        return super.getSalary() + bonus;
    }
}
