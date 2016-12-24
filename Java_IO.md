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
  
  6). FileOutputStream 实现了向文件中写出byte数据的方法

  7). DataOutputStream/DataInputStream   
      对“流”功能的扩展，更加方便读取int,long,字符等类型的数据  
      DataOutputStream  
        writeInt()/writeDouble()/WriteUTF()  
        
  8). 待缓冲的字节流  
      BufferedInputStream/BufferedOutputStream  
      这来那个刘类为IO提供了带缓冲的操作，一般打开文件进行写入或读取操作是，都会加上缓冲，这种流模式提高了IO的性能，从应用程序中把输入放入文件，相当
      于将一缸水倒入另外一个缸中   
      
      FileOutputStream   --> write()方法相当于一滴一滴将水转移出去
      DataOutputStream   --> writeXXX() 方法方便一些  
      BufferedOutputStream   --> write方法更方便

## 字符流
 1) 编码问题 
  
 2)认识文本和文本文件 
 
 java的文本(char)是16位无符号整数，是字符的unicode编码（双字节编码)
    文件是byte byte byte ...的数据序列  
    文本文件是文本(char)序列按照某种编码方案(utf-8,utf-16be,gbk)序列化为byte的存储结果  
    
 3)字符流(Reader Writer)---->操作的是文本文本文件
  字符的处理，一次处理一个字符
  字符的底层任然是基本的字节序列
  字符流的基本实现
     InputStreamReader   完成byte流解析为char流,按照编码解析
     OutputStreamWriter  提供char流到byte流，按照编码处理  

     FileReader/FileWriter
   字符流的过滤器
     BufferedReader   ---->readLine 一次读一行
     BufferedWriter/PrintWriter   ---->写一行    


  3.对象的序列化，反序列化
  1)对象序列化，就是将Object转换成byte序列，反之叫对象的反序列化 
  2)序列化流(ObjectOutputStream),是过滤流----writeObject
     反序列化流(ObjectInputStream)---readObject

  3)序列化接口(Serializable)
     对象必须实现序列化接口 ，才能进行序列化，否则将出现异常
     这个接口，没有任何方法，只是一个标准

  4) transient关键字
      private void writeObject(java.io.ObjectOutputStream s)
              throws java.io.IOException
    private void readObject(java.io.ObjectInputStream s)
              throws java.io.IOException, ClassNotFoundException

     分析ArrayList源码中序列化和反序列化的问题

  5)序列化中 子类和父类构造函数的调用问题
