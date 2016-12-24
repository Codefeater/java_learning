## Files.io.File

File类只用于表示文件（目录）的信息（名称，大小等），不能用于文件内容的访问

API : isFile,isDirectory，exists,mkdir,createNewFile,
## RandomAccessFile
Java提供对文件内容的访问，既可以读文件，也可以写文件，RandomAccessFile支持随机访问文件，可以访问文件的任意位置
1. Java文件打开方式：“rw”读写，“r” 只读
RandomAccessFile raf = new RandomAessFile(file ,"rw")
2. 写方法
  raf.write(int)  -->只写一个字节（后8位），指针指向下一个位置
3. 读方法
  int b = raf.read() ----> 读一个字节
4. 文件最后一定要关闭

API:getFilePointer

-----------------
##  Java IO
1. 字节流
  1). InputStream抽象了应用程序读取数据的方式
      OutputStream抽象了应用程序写出数据的方式
  2). EOF = End 读取 -1 就读到结尾
  3). 输入流
    int b = in.read(),读取一个字节无符号填充到int低八位
    in.read(byte[] buf) 读取数据填充到字节数组buf
  4). 输出流
    out.write(int b) 写出一个byte到流，b的低八位
    out.write(byte[] buf) 将buf字节数组写入到到流
  5). FileInputStream ---具体在文件上实现了读取数据
