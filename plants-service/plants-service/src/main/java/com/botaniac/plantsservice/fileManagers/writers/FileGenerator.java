package com.botaniac.plantsservice.fileManagers.writers;

import java.io.File;

public interface FileGenerator<T> {
    File generateFile(T object);
}
