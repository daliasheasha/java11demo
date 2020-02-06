package java11demo.java08;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java11demo.Weather;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

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
			JAXBContext jaxbContext = JAXBContext.newInstance(Weather.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(weather, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static String encode(String originalString) {
		BASE64Encoder encoder = new BASE64Encoder();
		String encodedString = encoder.encode(originalString.getBytes());
		System.out.println("Original String: " + originalString);
		System.out.println("Encoded String: " + encodedString);
		System.out.println("============================================");
		return encodedString;
	}

	public static String decode(String encodedString) {
		String decodedString = "";
		try {
			byte[] decodedBytes = new BASE64Decoder().decodeBuffer(encodedString);
			decodedString = new String(decodedBytes, Charset.forName("UTF-8"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Encoded String: " + encodedString);
		System.out.println("Decoded String: " + decodedString);
		System.out.println("============================================");
		return decodedString;
	}
}
