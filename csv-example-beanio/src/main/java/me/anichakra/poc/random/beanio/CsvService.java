package me.anichakra.poc.random.beanio;

import java.io.File;
import java.io.InputStreamReader;

import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class CsvService {
	@Autowired
	@Qualifier("contact")
	private StreamFactory factory;

	public void readWriteCsv() {

		// create a BeanReader to read from "input.csv"

		BeanReader in = factory.createReader(BeanConfiguration.CSV_CONTACT,
				new InputStreamReader(this.getClass().getResourceAsStream("/input.csv")));
		// create a BeanWriter to write to "output.csv"
		BeanWriter out = factory.createWriter(BeanConfiguration.CSV_CONTACT, new File("output.csv"));

		Object record = null;

		while ((record = in.read()) != null) {
			Contact contact = (Contact) record;
			System.out.println(contact);
			out.write(record);
		}

		in.close();

		out.flush();
		out.close();
	}

}
