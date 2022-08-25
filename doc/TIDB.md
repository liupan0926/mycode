





### 数据库



#### TIDB

https://docs.pingcap.com/zh/tidb/stable/tikv-overview

计算和存储分离的架构

数据容灾,raft 数据同步协议;传统是双机房提供服务，异地机房不提供服务，提供数据存储容灾能力。



##### raft协议与paxos算法

Raft协议

1. 领导者 leader，follow

2. Term,选举定时器

3. 领导者心跳，定时器周期，心跳周期 < 定时器周期。心跳没了，定时器周期到了以后，优先的节点被选为领袖.

4. 同时选择两个领袖后（A,B），会重新发起投票，一般是节点C 定时器在前，会优先成为候选者，开始接受投票。 

   AB两个节点重置计时器,更新自己的term。

5. 数据同步流程： 先提交，leader同步日志给follow,同步成功以后，返回通知。 leader开始更新本地数据，并通知follow,同时返回client。

6. 数据复制。 nextIndex, term值。节点大半机器的logIndex一样，则代表leader数据是最新的，覆盖其他不一致的follow的数据。使用nextIndex和term找到不一致的地方，索引后面的值一并覆盖掉。



##### 分布式锁

Redis

1.setEx ，加上value 代表是我加的锁， 过期时间防止 当机。

2.守护进程，业务还没执行完时， 刷新锁的过期时间，让业务继续执行。



##### RPC



##### IO

####同步IO

1.BIO
2.NIO
3.IO多路复用

####异步IO

1.AIO






