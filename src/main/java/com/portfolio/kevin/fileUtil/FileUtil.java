package com.portfolio.kevin.fileUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileUtil {

    public static void writeToFile(String content) {
        try{
            String filePath = "C:\\Users\\KeBeanZ\\Desktop\\output-online-resume\\contact_me_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + "_output.txt";
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
