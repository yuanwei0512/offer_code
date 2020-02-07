package com.hyw.cart;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/11/29 9:38
 * Description：TODO
 */
public class MyTest {

    public static void main(String[] args) throws IOException {

        FileChannel channel = FileChannel.open(Paths.get("D:\\idea\\study_996\\targetPath\\study.txt"));

        FileLock fileLock = channel.tryLock();

        ByteBuffer allocate = ByteBuffer.allocate(1024);



    }
}
