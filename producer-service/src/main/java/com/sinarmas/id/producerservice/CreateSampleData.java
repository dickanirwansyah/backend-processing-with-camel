package com.sinarmas.id.producerservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@Service
public class CreateSampleData {

    @PostConstruct
    public void createData(){
        log.info("starting create data..");
        String dataValues[][] = {
                {"001", "Cocacola", String.valueOf(10000), "1"},
                {"002", "Fanta", String.valueOf(10000), "10"},
                {"003", "Sprite", String.valueOf(10000), "19"},
                {"004", "Air zamzam", String.valueOf(10000), "19"},
                {"005", "Mineral Water", String.valueOf(10000), "21"},
                {"006", "Aqua", String.valueOf(10000), "10"}
            };
        try {
            File csvFile = new File("C:/Users/Muhammad Dicka/Documents/dummy-folder/"+"file.csv");
            FileWriter fileWriter = new FileWriter(csvFile);

            for (String[] data: dataValues){
                StringBuilder stringBuilder = new StringBuilder();
                for (int i=0; i < data.length; i++){
                    stringBuilder.append("\"");
                    stringBuilder.append(data[i].replace("\"","\"\""));
                    stringBuilder.append("\"");
                    if (i != data.length - 1){
                        stringBuilder.append(',');
                    }
                }
                stringBuilder.append("\n");
                fileWriter.write(stringBuilder.toString());
            }
            fileWriter.close();
            log.info("success create & generate file csv..");
        } catch (IOException e) {
            log.error("error generate file csv because = {} ",e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
