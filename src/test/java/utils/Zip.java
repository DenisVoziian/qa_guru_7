package utils;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Zip {
    public static void unzip(String path, String unzipPath) throws ZipException {
        ZipFile zipFile = new ZipFile(path);
        zipFile.extractAll(unzipPath);
    }
}
