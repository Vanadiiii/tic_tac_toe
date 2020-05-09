package box;

import org.intellij.lang.annotations.Language;

public class SomeClass {
    @Language("SQL")
    String query = "SELECT * from AUTO";
    @Language("XPath")
    String xPath = "//body/*[@class = 'myClass']";

    public boolean matchRegex(String str, @Language("Regexp") String regexp) {
        return str.matches(regexp);
    }
}
