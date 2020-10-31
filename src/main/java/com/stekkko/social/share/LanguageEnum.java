package com.stekkko.social.share;
/**
 * Enum mapping language with id of dropdown specifying type of code highlights in http://pastie.org
 *
 * @author Tomasz Dziurko
 */

public enum LanguageEnum {

    OBJECTIVE_C_PLUS_PLUS("objc"),
    ACTION_SCRIPT("actionscript"),
    RUBY("ruby"),
    DIFF("diff"),
    PLAIN_TEXT("gettext"),
    C_PLUS_PLUS("cpp"),
    CSS("css"),
    JAVA("java"),
    JAVASCRIPT("javascript"),
    COFFESCRIPT("coffeescript"),
    BASH_SHELL("bash"),
    SQL("sql"),
    PHP("php"),
    PYTHON("python"),
    SWIFT("swift"),
    C_MAKE("cmake"),
    MXML("mxml"),
    HTML5("html5"),
    PROPERTIES("properties"),

    PERL("perl"),
    YAML("yaml"),
    C_SHARP("csharp"),
    GO("go"),

    HASKELL("haskell"),
    SCALA("scala"),
    PASCAL("pascal"),
    RUST("rust"),
    CLOJURE("clojure"),

    ;
    //TODO some languages still need to be added

    private LanguageEnum(String format) {
        this.dropdownId = format;
    }

    private String dropdownId;

    public String getDropdownId() {
        return dropdownId;
    }
}