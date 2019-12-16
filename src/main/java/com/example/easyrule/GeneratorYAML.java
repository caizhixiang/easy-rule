package com.example.easyrule;

import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GeneratorYAML {
    public static void writeYml() {
        List<RulesDto> list = new ArrayList<>();
        RulesDto rulesDto = new RulesDto();
        rulesDto.setName("fizzbuzz rule");
        rulesDto.setDescription("ceshixccesdlfjalsdfsdj");
        rulesDto.setCondition("number % 5 == 0 && number % 7 == 0");
        rulesDto.setActions("\"System.out.println(\\\"buzz\\\")\"");
        rulesDto.setPriority(0);

        list.add(rulesDto);
        RulesDto rulesDto1 = new RulesDto();
        rulesDto1.setName("fizzbuzz rule1");
        rulesDto1.setDescription("ceshixccesdlfjalsdfsdj1");
        rulesDto1.setCondition("number % 2 == 0");
        rulesDto1.setActions("\"System.out.println(\\\"-----------------\\\")\"");
        rulesDto1.setPriority(1);

        list.add(rulesDto1);



        File dumpFile = new File(System.getProperty("user.dir")+"/src/main/resources/testYaml.yml");
        try {
            Yaml.dump(list, dumpFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void readYml(){
        File file = new File(System.getProperty("user.dir"), "/src/com/neunn/monitor/web/utils/generates/ymlfiles/testYaml.yml");
        try {
            // 读取文件内容 (输入流)
            FileInputStream out = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(out);
            int ch = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((ch = isr.read()) != -1) {
                stringBuilder.append((char) ch);
            }

            System.out.println(stringBuilder);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


}


