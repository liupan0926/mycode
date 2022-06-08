


JVM 数据结构




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





classLoader 双亲委派机制

1.rt.jar bootrap
2.ext.jar extensionClassLoader
3.AppClassLoader


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





