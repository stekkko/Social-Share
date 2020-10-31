package com.stekkko.social.share;

import java.util.HashMap;
import java.util.Map;

/**
 * Class mapping file extensions with LanguageEnum
 *
 * @author Tomasz Dziurko
 */
public class LanguageMap {

    private Map<String, LanguageEnum> fileExtensionToLanguage = new HashMap<>();

    public LanguageMap() {

        fileExtensionToLanguage.put("java", LanguageEnum.JAVA);
        fileExtensionToLanguage.put("js", LanguageEnum.JAVASCRIPT);
        fileExtensionToLanguage.put("coffee", LanguageEnum.COFFESCRIPT);
        fileExtensionToLanguage.put("sql", LanguageEnum.SQL);
        fileExtensionToLanguage.put("scala", LanguageEnum.SCALA);
        fileExtensionToLanguage.put("html", LanguageEnum.HTML5);
        fileExtensionToLanguage.put("htm", LanguageEnum.HTML5);
        fileExtensionToLanguage.put("xhtml", LanguageEnum.HTML5);
        fileExtensionToLanguage.put("xml", LanguageEnum.MXML);
        fileExtensionToLanguage.put("css", LanguageEnum.CSS);
        fileExtensionToLanguage.put("hs", LanguageEnum.HASKELL);
        fileExtensionToLanguage.put("diff", LanguageEnum.DIFF);
        fileExtensionToLanguage.put("pl", LanguageEnum.PERL);
        fileExtensionToLanguage.put("swift", LanguageEnum.SWIFT);
        fileExtensionToLanguage.put("mm", LanguageEnum.OBJECTIVE_C_PLUS_PLUS);
        fileExtensionToLanguage.put("", LanguageEnum.PLAIN_TEXT);

        fileExtensionToLanguage.put("properties", LanguageEnum.PROPERTIES);
        fileExtensionToLanguage.put("php", LanguageEnum.PHP);
        fileExtensionToLanguage.put("sh", LanguageEnum.BASH_SHELL);
        fileExtensionToLanguage.put("py", LanguageEnum.PYTHON);
        fileExtensionToLanguage.put("c", LanguageEnum.C_PLUS_PLUS);
        fileExtensionToLanguage.put("cpp", LanguageEnum.C_PLUS_PLUS);


        //TODO add more file extensions mapped to correct languages
    }

    public String getLanguageDropdownIdFor(String fileExtension) {
        LanguageEnum languageEnum = fileExtensionToLanguage.get(fileExtension.toLowerCase());

        if(languageEnum == null) {
            return LanguageEnum.PLAIN_TEXT.getDropdownId();
        }
        else {
            return languageEnum.getDropdownId();
        }
    }
}