package common;

/*
В этом классе находится конфигурация проекта
*/
public class Config {

    public static final String PLATFORM_AND_BROWSER = "win_chrome";

    // Clear browser cookies after each iteration
    // if true -> cookie is clearing
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;

    // To keep browser open after suite
    // if true -> browser is closing;
    public static final Boolean HOLD_BROWSER_OPEN = true;
}
