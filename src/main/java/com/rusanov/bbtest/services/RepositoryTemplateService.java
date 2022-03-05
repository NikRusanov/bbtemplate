package com.rusanov.bbtest.services;

import com.cdancy.bitbucket.rest.domain.commit.Commit;
import com.cdancy.bitbucket.rest.domain.file.RawContent;
import com.cdancy.bitbucket.rest.features.FileApi;
import com.rusanov.bbtest.models.CsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class RepositoryTemplateService implements TemplateService{
    @Autowired
    FileApi fileApi;
    @Autowired
    CsTemplate template;
    @Override
    public void createStandardTemplate() {
        String projectKey = "TEST";
        String repoKey = "test";
        try {
            template.init();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Map<String, String> filesWithContent = template.getFilesWithContent();
        System.out.println("stop");
        filesWithContent.forEach((filePath, value) -> {
            Commit commit = fileApi.updateContent(projectKey, repoKey, filePath, "develop", value, "message", null, null);

            //TODO error handlers
            commit.errors().forEach(System.out::println);
        });
    }
}
