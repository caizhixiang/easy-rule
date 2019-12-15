package com.example.easyrule;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.jeasy.rules.mvel.MVELRuleFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;

//@SpringBootApplication
public class EasyRuleApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(EasyRuleApplication.class, args);
//    }





    public static void main(String[] args) throws FileNotFoundException {

        GeneratorYAML.writeYml();
        // create a rules engine
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);

        // create rules   C:\java\easy-rule\src\main\resources\fizzbuzz.yml
        Rules rules = MyRuleFactory.createRulesFrom(new FileReader("C:\\java\\easy-rule\\src\\main\\resources\\testYaml.yml"));
        // fire rules
        Facts facts = new Facts();
        for (int i = 1; i <= 100; i++) {
            facts.put("number", i);
            fizzBuzzEngine.fire(rules, facts);
            System.out.println();
        }
    }
}
