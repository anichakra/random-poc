package me.anichakra.poc.random.beanio;

import org.beanio.StreamFactory;
import org.beanio.builder.StreamBuilder;
import org.beanio.stream.csv.CsvRecordParserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
	public static final String CSV_CONTACT="contacts";
	@Bean ("contact")
	public StreamFactory getCsvFactoryForContact() {
	// create a BeanIO StreamFactory
			StreamFactory factory = StreamFactory.newInstance();
			// create a new StreamBuilder and define its layout
			StreamBuilder builder = new StreamBuilder(CSV_CONTACT).format("delimited").parser(new CsvRecordParserFactory())
					.addRecord(Contact.class);
			factory.define(builder);
			return factory;
	}
}
