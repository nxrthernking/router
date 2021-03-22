package com.innowise.router.mapper;

import com.innowise.router.dto.Report;

import java.util.List;

public interface FileParser {

   List<Report> parse(final byte[] content);
}
