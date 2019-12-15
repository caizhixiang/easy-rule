package com.example.easyrule;

import org.ho.yaml.Yaml;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MyRuleFactory extends MVELRuleFactory {
    public List<RulesDto> rulesDtos = null;

    public MyRuleFactory() {

    }

    public static Rules createRulesFrom(Reader rulesDescriptor)  {
        Rules rules = new Rules(new Rule[0]);

        File dumpFile = new File("C:\\java\\easy-rule\\src\\main\\resources\\testYaml.yml");
        RulesDto father = null;
        try {
//            father = (RulesDto) Yaml.loadType(dumpFile, RulesDto.class);
           Object o= Yaml.loadStream(rulesDescriptor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<RulesDto> ruleDefinition = new ArrayList<>();
        ruleDefinition.add(father);

        rules.register(create(father));

        return rules;
    }


    static MVELRule create(RulesDto dto) {
        MVELRule mvelRule = (new MVELRule()).name(dto.name).description(dto.description).priority(dto.priority).when(dto.condition);

        mvelRule.then(dto.actions);

        return mvelRule;
    }
}
