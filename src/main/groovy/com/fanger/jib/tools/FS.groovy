package com.fanger.jib.tools

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class FS {

    private static Logger logger = LoggerFactory.getLogger(FS.class)

    static Model[] getAllJavaModels(String path) {
        def result = new ArrayList<Model>()
        traverseFolder(path, result)
        return result
    }

    static void traverseFolder(String path, List<Model> result) {
        File file = new File(path)
        if (file.exists()) {
            if (!file.name.equals("build") && !file.name.equals(".gradle")
                    && !file.name.equals(".settings") && !file.name.equals(".git")
                    && !file.name.equals("out") && !file.name.equals("bin")
                    && !file.name.equals(".sencha")) {
                File[] files = file.listFiles()
                if (null == files || files.length == 0) {
                    return
                } else {
                    for (File file2 : files) {
                        if (file2.isDirectory()) {
                            traverseFolder(file2.getAbsolutePath(), result)
                        } else {
                            if (file2.name.endsWith(".java")) {
                                logger.info(file2.path)
                                result.add(new Model(file2.getAbsolutePath(), file2.getText("utf-8")))
                            }
                        }
                    }
                }
            }
        }
    }

}
