



2022-06-20 面试记录.

分布式的KV数据库, 底层存储该如何设计，写多读少。


1.hashMap的存储方式？


写多读少： 链表的数据结构

读多写少： 数组


数组+链表



90%的 数据是有序的， %10的数据是无序的，用什么算法 处理。


排序算法有哪些：

https://blog.csdn.net/qq_45974648/article/details/123233702

https://www.runoob.com/w3cnote/shell-sort.html


冒泡排序： o(n方)

快速排序:  

选择排序:

插入排序：

希尔排序：

插入排序的升级版，对于有一定顺序的 序列，速度很快，测试下来100000级别的 ，是插入排序的500倍。

上面题目基本是这个答案，希尔排序。

归并排序


2022-06-30 面试记录 古茗


分布式事务处理。


分表分库，如何解决用户的散列问题。



2022-07-03

1.调度任务系统怎么设计 ，存在任务的相互依赖..

addTask;addDependceny;


2.数组的旋转。


http 跟 https之间的区别，https是怎么交互的？

https://www.cnblogs.com/wqhwe/p/5407468.html

http: 不安全，内容没有加密。

https：CA 证书签名， 证书机构颁发证书，下发给客户端 证书和公共密钥。 

1.用户访问https网站 .SSL 协议

2.返回客户端 证书以及公共密钥。

3.用户确认证书和安全级别，生成回话密钥，跟公共密钥一起加密 ，传送给服务端。

4.服务端使用私有密钥，揭秘内容，得到回话密钥。

5.使用此会话密钥进行通信。 

https的中转?


mysql的 异步复制，半同步复制， 并行复制？


异步复制：

1. binlog  , binlog 同步到 从服务器的 relay log .  sql单线程读取执行。 有数据延迟

半同步复制：

1. 数据同步到relay log以后，发送响应给事务处理，返回给客户端。

并行复制：

1.mysql 5.6  库级别的 并发执行。

2.mysql 5.7  一组事务提交可并发执行 (commitlog 相同， sequence_num不同的)


https://zhuanlan.zhihu.com/p/373576459




2022-07-05 面试


当前系统稳定性 最大的考验是什么？


数据倾斜问题，这个没回答好，忘记了。


全链路的数据一致性问题。

支付超时以后的 后续处理流程，到底该是什么样的？
资金的异步回调，到底需要如何处理？


系统的难点是什么？

1. 长链路的数据一致性


资源释放，底层未完全释放， 仍然有计量数据产生，但是无法计费。 






挑战点是什么？

亮点是什么？

虚商生态业务

1.业务初始化
2.业务复杂化，业务扩展，spi交互
3.业务规则收敛，业务简单化
4.openapi服务，提高被集成效率



多租户的数据问题。

人  买家，卖家。 

货  是否有不同

场  官网，物流云的网站，


数据倾斜问题？

1.账号的生成规则不可控。

2.大账号查询订单的问题。



2022-07-27

1. CDN的原理
   1. 智能DNS(localdns,rootDns,aliyunDns(cname记录,a记录))

2. 物联网的架构
   1. 

3. 普遍的架构设计的套路是什么样的，有哪些关键性的因素?
   1. https://www.zhihu.com/question/395652253/answer/1959672118
   2. Grokking the System Design Interview
   3. https://www.zhihu.com/search?hybrid_search_extra=%7B%22sourceType%22%3A%22answer%22%2C%22sourceId%22%3A1959672118%7D&hybrid_search_source=Entity&q=Grokking%20the%20System%20Design%20Interview&search_source=Entity&type=content
4. JDK的最新变化
   1. java8 java11 最新 java18

5. http http2.0 http3.0
   1. http1.0
      1. html语言文件
      2. 短连接

   2. http1.1
      1. .css,.js等文件
      2. host头处理
      3. 长连接

   3. http1.x（google的SPDY,这个基本被淘汰了）
      1. 客户端取缓存
      2. 多路复用，设置请求优先级
      3. head压缩
      4. 引入了https, SSL or TLS 协议

   4. http2.0(https://www.jianshu.com/p/42ca44202ca4)
      1. 1.1是基于文本来解析的，2.0是通过二进制来解析的。这就导致了1.1不能多路复用，因为判断不了 ，哪个消息文本对应哪个请求。服务器读取消息是循环读取，直到读取到空行。2.0用streamId来标识请求和消息的对应关系。
      2. 多路复用，1.1是多个请求串行执行，2.0是并行执行。
      3. header压缩方式不同。 （静态索引，动态索引）
      4. 主动推送page.index相关的 js 和 css文件，不需客户端再发起。 顺序很重要，要先于正常请求之前把相关数据推送给客户端，防止客户端重复发起请求。

   5. http3.0
   6. 总结：
      1. 1.1到2.0的进步，是解决哪些问题？
         1. 多路复用的并行问题，请求的限制
         2. header内容多，且基本一样，需要优化方案
         3. 使用二进制 流+帧，解决请求并行问题
         4. 服务端主动推送js ,css等相关资源，有一定顺序
         5. stream请求可以设置优先级，保证重要请求优先执行
         6. https://juejin.cn/post/6844903667569541133
         7. 本质都是加快传输效率

6. TCP UDP



2022-08-09

1.metaq消息消费的问题

	如何保证高可用
	如何保证消息不被重复消费
	如何保证消息的顺序




2022-08-17

##java锁的相关实现

##spring的事务

##多线程通信打印

##Dubbo相关源码

##spring 如何解决启动时的循环依赖问题

##线程的 锁机制如何实现的synchronized

##物联网 区块链

##抽象类能使用synchronized关键字吗？ 

不能，synchronized 跟实现细节有关

4个java 编译是几个.class文件

这个看java文件里 有几个class类，一个java文件有4个class类（包含interface）,则会编译生成4个.class文件。























