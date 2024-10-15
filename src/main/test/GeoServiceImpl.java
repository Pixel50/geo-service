import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GeoServiceImplTest {

    private final GeoServiceImpl geoService = new GeoServiceImpl();

    @Test
    void testByIpForRussianIP() {
        String russianIp = "172.0.32.11";
        Location location = geoService.byIp(russianIp);
        assertEquals(Country.RUSSIA, location.getCountry());
    }

    @Test
    void testByIpForAmericanIP() {
        String americanIp = "96.44.183.149";
        Location location = geoService.byIp(americanIp);
        assertEquals(Country.USA, location.getCountry());
    }
}