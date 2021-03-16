package com.innowise.router.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.compress.utils.FileNameUtils;

@UtilityClass
public class FileUtils {
    public String getFileExtension(String filename){
        return FileNameUtils.getExtension(filename);
    }
}
