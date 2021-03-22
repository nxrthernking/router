package com.innowise.router.validator;

import com.innowise.router.dto.XmlReportList;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;


@Component
@Slf4j
public class XMLValidator {

    @SneakyThrows
    public void validate(XmlReportList reportList) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("schema/xml/schema.xsd"));
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlReportList.class);
        JAXBSource jaxbSource = new JAXBSource(jaxbContext, reportList);
        Validator validator = schema.newValidator();
        try {
            validator.validate(jaxbSource);
        } catch (SAXException e) {
            log.error(e.getMessage());
        }
    }


}
