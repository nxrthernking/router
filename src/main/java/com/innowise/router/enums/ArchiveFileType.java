package com.innowise.router.enums;

import com.innowise.router.dto.FileContent;
import com.innowise.router.services.archive.FileSignature;
import com.innowise.router.utils.ArchiveUtils;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public enum ArchiveFileType  {

    ZIP(FileSignature.HEAD_ZIP, ArchiveUtils::unzipZip),
    SEVEN_ZIP(FileSignature.HEAD_SEVEN_ZIP,ArchiveUtils::unzipSevenZip),
    RAR(FileSignature.HEAD_RAR,ArchiveUtils::unzipRar);

    private final byte[] signature;

    private final Function<byte[], List<FileContent>> unzipFunction;

    public static Optional<ArchiveFileType> of(byte[] fileContent){
        return Arrays.stream(ArchiveFileType.values())
                .filter(var -> FileSignature.signatureFound(fileContent,var.signature))
                .findFirst();
    }

    public List<FileContent> unzipToFileContentList(final byte[] content){
        return unzipFunction.apply(content);
    }


}
