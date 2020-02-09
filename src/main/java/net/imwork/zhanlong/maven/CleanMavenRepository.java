package net.imwork.zhanlong.maven;

import java.io.File;

/**
 * @author 昝海龙
 * 清除maven仓库中错误文件或空文件夹
 *
 */
public class CleanMavenRepository
{
    /**
     * root: 仓库根目录,此处为本地maven仓库的绝对路径
     */
    //static String rootDirectory = "D:\\java_studying\\repository";

//    public static void main(String[] args) {
//        File file = new File(root);
//        File[] files = file.listFiles();
//        if (files != null && files.length > 0) {
//            for (File f : files) {
//                clearRepository(f);
//            }
//        }
//    }
    public static void clean()
    {
        String rootDirectory = "D:\\java_studying\\repository";
        System.out.println("清除目录:" + rootDirectory);
        File file = new File(rootDirectory);
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                clearRepository(f);
            }
        }
    }
    /**
     *
     * @param rootDirectory
     */
    public static void clean(String rootDirectory ) {

        if (rootDirectory == null || rootDirectory.isEmpty())
        {
            return;
        }
        System.out.println("清除目录:" + rootDirectory);
        rootDirectory = "d:\\repository\\" + rootDirectory;

        File file = new File(rootDirectory);
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                clearRepository(f);
            }
        }
    }



    private static boolean clearRepository(File file) {
        boolean isHaveJar = false;
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File aFile : files) {
                // 判断是否为jar文件
                if (aFile.getName().endsWith(".jar")) {
                    isHaveJar = true;
                }
                // 判断是否为文件夹
                if (aFile.isDirectory()) {
                    // 是文件夹则判断其内部是否包含jar文件
                    boolean isNextHaveJar = clearRepository(aFile);
                    if (isNextHaveJar) {
                        isHaveJar = true;
                    }
                }
            }
        }
        if (!isHaveJar) {
            System.out.println("Delete The File: " + file.getName());
            delete(file);
        }
        return isHaveJar;
    }

    /**
     * 删除文件或文件夹
     * @param file 要删除的文件或文件夹
     */
    private static void delete(File file) {
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File aFile : files) {
                if (aFile.isDirectory()) {
                    delete(aFile);
                }
                aFile.delete();
            }
        } else {
            file.delete();
        }
    }
}

