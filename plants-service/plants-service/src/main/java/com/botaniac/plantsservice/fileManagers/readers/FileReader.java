package com.botaniac.plantsservice.fileManagers.readers;

import java.io.InputStream;

public interface FileReader<T> {
    T readFile(InputStream inputStream);
}
