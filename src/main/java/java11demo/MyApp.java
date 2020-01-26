package java11demo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MyApp {
	public static void main(String[] args) {
		Weather rst = new Weather();
		rst.setCity("Rochester");
		rst.setState("Minnesota");
		rst.setCountry("USA");
		rst.setForecast("SUPER DUPER COLD");

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Weather.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(rst, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
