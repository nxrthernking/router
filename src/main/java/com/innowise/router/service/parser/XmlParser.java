package com.innowise.router.service.parser;

import com.innowise.router.dto.Report;
import com.innowise.router.dto.XmlReportList;
import com.innowise.router.exception.InvalidFileException;
import com.innowise.router.mapper.XmlFileMapper;
import com.innowise.router.validator.XMLValidator;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service("XML")
public class XmlParser implements FileParser {

    private final XmlFileMapper xmlFileMapper;

    @Override
    @SneakyThrows
    public List<Report> parse(byte[] content) {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlReportList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        XmlReportList xmlReportList = (XmlReportList) unmarshaller.
                unmarshal(new ByteArrayInputStream(content));
        XMLValidator xmlValidator = new XMLValidator();
        if(!xmlValidator.validate(xmlReportList))
            throw new InvalidFileException("Invalid XML-file!");
        return xmlFileMapper.mapToReportList(xmlReportList.getXmlReports());
    }

}
