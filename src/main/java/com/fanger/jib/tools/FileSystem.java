package com.fanger.jib.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class FileSystem {

    private static Logger logger = LoggerFactory.getLogger(FileSystem.class);

    public static List<Model> getAllJavaModels(String path) {
        List<Model> result = new ArrayList<Model>();
        traverseFolder(path, result);
        return result;
    }

    private static void traverseFolder(String path, List<Model> result) {
        File file = new File(path);
        if (file.exists()) {
            if (!file.getName().equals("build") && !file.getName().equals(".gradle")
                    && !file.getName().equals(".settings") && !file.getName().equals(".git")
                    && !file.getName().equals("out") && !file.getName().equals("bin")
                    && !file.getName().equals(".sencha")) {
                File[] files = file.listFiles();
                if (null == files || files.length == 0) {
                    return;
                } else {
                    for (File file2 : files) {
                        if (file2.isDirectory()) {
                            traverseFolder(file2.getAbsolutePath(), result);
                        } else {
                            if (file2.getName().endsWith(".java")) {
                                logger.info(file2.getPath());
                                try {
                                    result.add(new Model(file2.getAbsolutePath(), readByNIO(file2.getPath())));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static String readByNIO(String file) throws IOException {
        FileInputStream fin = new FileInputStream(file);
        // 获取通道
        FileChannel fc = fin.getChannel();
        int size = (int) fc.size();
        ByteBuffer buffer = ByteBuffer.allocate(size);
        // 读取数据到缓冲区
        fc.read(buffer);
        buffer.flip();
        StringBuilder s = new StringBuilder();
        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            s.append((char)b);
        }
        fin.close();
        return s.toString();
    }

}
