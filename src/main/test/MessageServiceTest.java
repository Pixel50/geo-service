import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MessageSenderImplTest {

    private GeoService geoService;
    private LocalizationService localizationService;
    private MessageSenderImpl messageSender;

    @BeforeEach
    void setUp() {
        geoService = Mockito.mock(GeoService.class);
        localizationService = Mockito.mock(LocalizationService.class); /ce
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    void testSendMessageToRussianIP() {

        String russianIp = "172.0.32.11";
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, russianIp);

        Location moscowLocation = new Location("Moscow", Country.RUSSIA, null, 0);
        when(geoService.byIp(russianIp)).thenReturn(moscowLocation);
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");


        String result = messageSender.send(headers);

        assertEquals("Добро пожаловать", result);
    }

    @Test
    void testSendMessageToAmericanIP() {

        String americanIp = "96.44.183.149";
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, americanIp);


        Location newYorkLocation = new Location("New York", Country.USA, null, 0);
        when(geoService.byIp(americanIp)).thenReturn(newYorkLocation);
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");


        String result = messageSender.send(headers);


        assertEquals("Welcome", result);
    }
}