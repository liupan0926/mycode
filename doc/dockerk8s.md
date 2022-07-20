# ##docker and k8s







##### docker 的优点

```
虚拟化技术 && docker
虚拟化占有系统资源多
docker 更轻量
```



##### docker安装使用教程

https://www.runoob.com/docker/docker-container-usage.html



##### docker相关命令

```
镜像相关命令
docker images
docker pull tomcat
docker rmi imagesId

容器相关命令：

docker ps -a

-i -t 交互命令
docker run -d --name tomcat8081 -p 8080:8080 --rm tomcat
docker stop $(docker ps -a -q)
docker rm 
docker start
docker container ls -a

docker 进入容器
docker exec -it tomcat8081 bash
mkdir ROOT
echo 'tggg'>> index.html
cat index.html

文件拷贝
docker cp id:/usr/local/tomcat /Desktop

查看日志
docker logs

docker logs --tail=5 tomcat8081

docker logs -f -t --since="2020-12-1" --tail=10 tomcat8081




```

