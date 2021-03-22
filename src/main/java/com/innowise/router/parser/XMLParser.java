package com.innowise.router.parser;

import com.innowise.router.dto.XMLReportList;
import com.innowise.router.validator.XMLValidator;
import lombok.SneakyThrows;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;

public class XMLParser {

    @SneakyThrows
    public XMLReportList parseFromXML(byte[] content) {
        JAXBContext jaxbContext = JAXBContext.newInstance(XMLReportList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        XMLReportList xmlReportList = (XMLReportList) unmarshaller.
                unmarshal(new ByteArrayInputStream(content));
        XMLValidator xmlValidator = new XMLValidator();
        xmlValidator.validate(xmlReportList);
        return xmlReportList;
    }
}
