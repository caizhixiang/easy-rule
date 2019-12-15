package com.example.easyrule;

import lombok.Data;

@Data
public class RulesDto {
    public String name;
    public String description;
    public int priority;
    public String condition;
    public String actions;
}
