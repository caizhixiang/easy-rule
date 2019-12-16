package com.example.easyrule;

import org.ho.yaml.Yaml;
import org.ho.yaml.YamlStream;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MyRuleFactory {
    public List<RulesDto> rulesDtos = null;

    public MyRuleFactory() {

    }

    public static Rules createRulesFrom(List<RulesDto> list) {
        Rules rules = new Rules(new Rule[0]);
        for (RulesDto dto : list) {
            rules.register(create(dto));
        }

        return rules;
    }


    static MVELRule create(RulesDto dto) {
        MVELRule mvelRule = (new MVELRule()).name(dto.name).description(dto.description).priority(dto.priority).when(dto.condition);

        mvelRule.then(dto.actions);

        return mvelRule;
    }
}
