



#Java 基础相关的东西



#JVM 数据结构


栈，堆，程序计数器，方法区(java8 元空间)

本地方法栈


栈：

1. 程序代码执行的 ，本地变量

2. 栈帧（局部变量表，返回地址，操作数栈，动态链接） ，线程独有

3. StackoverflowError , outOfMemoryError

方法区

1. 类的相关 属性方法,常量，静态变量

堆：

1. 实例

2. 线程共享

程序计数器：

1.每个线程一个

2.记录了 线程 下一条指令执行的位置



##Error 跟 Exception. throwable


Error:

outOfMemory ,stackoverflow


Exception: 可检查 和 不可检查

可检查异常: 文件操作类， 时间转换

不可检查的异常：NullPoint ,ArrayIndex



classLoader 双亲委派机制

1.rt.jar bootrap
2.ext.jar extensionClassLoader
3.AppClassLoader


类的加载机制与过程：

编译阶段、加载阶段、运行阶段

五个步骤：

1.加载。2.验证 3.准备 (初始化0值) 4.解析 5.初始化。 （默认值）

装载，链接，初始化


垃圾回收算法：

1.复制算法

2.标记 清除 算法

3.分代收集



Eden空间 ，  survivor（from,to）, old 老年底。


miniGc:eden空间不足

magorGC: 

fullGc:

1. 对象空间担保，老年代连续空间 大于 新生代对象空间总和

2. 大对象进入老年代，空间不足

3. 显示调用system.gc


JDK的自动拆装箱

1.基础类型和包装类型 自动转换

2.使用场景：  集合对象 需要是Object类。 


Servlet 是一个java接口，

处理 请求-相应的模型，init方法 ， service 方法，destroy方法


网络通信 BIO,NIO,AIO


BIO 同步阻塞

NIO 同步非阻塞

AIO 异步非阻塞


NIO (选择器，缓冲区，线程,channel通道)

异步响应模型，http长连接， 后端线程池，队列





