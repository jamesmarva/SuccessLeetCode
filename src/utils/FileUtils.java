package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.11.2 17:13
 */
public class FileUtils {

    public static String bufferedStreamReadFile(String absolutePath) throws IOException {
//        Files.deleteIfExists(Paths.get("dest.txt"));
        StringBuilder res = new StringBuilder();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(absolutePath))) {
            byte[] buffer = new byte[8192];
            int len = 0;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                res.append(new String(buffer, 0, len));
            }
        }
        return res.toString();
    }

    public static List<String> getListOfStringBufferedStreamReadFile(String absolutePath)  throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(absolutePath))) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            return reader.lines().collect(Collectors.toList());
        }
    }
}
