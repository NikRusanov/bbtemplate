package com.rusanov.bbtest.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@Data
@Component
public class CsTemplate {
    private final Map<String, String> filesWithContent = new HashMap<>();

    public void init() throws IOException {
        List<Path> result;
        try(Stream<Path> walk = Files.walk(Path.of("src/main/resources/cservice_template"))){
            result = walk.filter(Files::isRegularFile).collect(Collectors.toList());
        }
        for (Path path : result) {
            System.out.println(path);
            filesWithContent.put(path.toString(), getContent(path));
        }
    }
//TODO file parsing class;
// service name  setter class
// Generating class
    private String getContent(Path path) {
        StringBuilder sb = new StringBuilder();
        String filename = path.getFileName().toString();
        System.out.println("Filename:" + filename);
        if(filename.endsWith(".png")) {
            sb.append(pngToString(path));

        } else {
            try {
                BufferedReader reader = Files.newBufferedReader(path);
                reader.lines().forEach(line ->
                        sb.append(line).append("\n"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return  sb.toString();
    }

    private String pngToString(Path path) {
        BufferedImage bufferedImage = null;
        String result = "";
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            bufferedImage = ImageIO.read(path.toFile());

            ImageIO.write(bufferedImage, "png", baos);
            result = baos.toString(StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
