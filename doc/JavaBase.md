



https://www.cnblogs.com/wangjzh/p/5258254.html 


1.Java集合 IO 多线程 网络基础框架  ,分布式 缓存 消息 搜索等机制
2.Spring Mybatis Cache Rpc JVM等机制，熟练使用设计模式
3.高可用 高扩展  高性能 


Java集合相关：

HashMap：

	数组和链表。  扩容机制 ，为什么是0.75

	ConcurrentHashMap: 方法锁是锁在 链表上的

HashTable

	整个put 方法 直接使用 synchronized关键字


HashMap跟HashTable

	扩容的方法不一样 ,hashMap 新增了bit位的，索引为 oldIndex+ 16（扩容的长度）,老的是头插法，需要链表反转
	hash的方法不一样  &. 和 %
	数组长度也不一样。

	HashMap 1.8 数据结构变了，解决链表的冲突问题。红黑树(链表元素>8 长度>64)

HashSet:

LinkedHashMap:

双链表

TreeMap:

红黑树,不能为null


List相关的：

ArrayList:  扩容是 靠 copy数组，扩大1.5倍

LinkedList: 链表

vector

CopyOnWriteArrayList：

懒加载机制

加锁 ，复制数组，修改数据，更改指针


##java关键字 

1.viloent

可见性，指令重排，不保证原子性

2.transient

序列化相关 。静态变量




