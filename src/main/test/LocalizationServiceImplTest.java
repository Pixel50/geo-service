import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalizationServiceImplTest {

    private final LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @Test
    void testLocaleForRussia() {
        String result = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", result);
    }

    @Test
    void testLocaleForUSA() {
        String result = localizationService.locale(Country.USA);
        assertEquals("Welcome", result);
    }
}