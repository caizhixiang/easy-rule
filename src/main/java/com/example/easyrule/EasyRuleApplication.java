package com.example.easyrule;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.jeasy.rules.mvel.MVELRuleFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class EasyRuleApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(EasyRuleApplication.class, args);
//    }


    public static void main(String[] args) throws FileNotFoundException {

        List<RulesDto> list = new ArrayList<>();
        RulesDto rulesDto = new RulesDto();
        rulesDto.setName("fizzbuzz rule");
        rulesDto.setDescription("ceshixccesdlfjalsdfsdj");
        rulesDto.setCondition("number % 5 == 0 && number % 7 == 0");
        rulesDto.setActions("System.out.println(\"----------------------------buzz\")");
        rulesDto.setPriority(0);

        list.add(rulesDto);
        RulesDto rulesDto1 = new RulesDto();
        rulesDto1.setName("fizzbuzz rule1");
        rulesDto1.setDescription("ceshixccesdlfjalsdfsdj1");
        rulesDto1.setCondition("number % 2 == 0");
        rulesDto1.setActions("System.out.println(\"-----------------\")");
        rulesDto1.setPriority(1);

        list.add(rulesDto1);
        // create a rules engine
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);


        Rules rules = MyRuleFactory.createRulesFrom(list);
        // fire rules
        Facts facts = new Facts();
        for (int i = 1; i <= 100; i++) {
            facts.put("number", i);
            fizzBuzzEngine.fire(rules, facts);
            System.out.println();
        }
    }
}
