package java11demo.java11;

import java.nio.charset.Charset;
import java.util.Base64;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java11demo.Weather;

public class MyApp {
	public static void main(String[] args) {
		Weather rochester = new Weather();
		rochester.setCity("Rochester");
		rochester.setState("Minnesota");
		rochester.setCountry("USA");
		rochester.setForecast("SUPER DUPER COLD");

		// Convert my Rochester object to XML
		writeXML(rochester);

		// Ecode/decode my forcast
		String encodedForcast = encode(rochester.getForecast());
		decode(encodedForcast);
	}

	public static void writeXML(Weather weather) {
		try {
			JAXBContext context = JAXBContext.newInstance(Weather.class);

			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshaller.marshal(weather, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static String encode(String originalString) {
		Base64.Encoder encoder = Base64.getEncoder();
		String encodedString = encoder.encodeToString(originalString.getBytes());
		System.out.println("Original String: " + originalString);
		System.out.println("Encoded String: " + encodedString);
		System.out.println("============================================");
		return encodedString;
	}

	public static String decode(String encodedString) {
		String decodedString = "";
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		decodedString = new String(decodedBytes, Charset.forName("UTF-8"));
		System.out.println("Encoded String: " + encodedString);
		System.out.println("Decoded String: " + decodedString);
		System.out.println("============================================");
		return decodedString;
	}
}
