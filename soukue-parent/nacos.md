## nacos

### 启动

```
1、创建mysql数据库 nacos
2、执行nacos脚本
3、命令启动：
startup.cmd -m standalone  #单机模式，默认为集群模式
```

## docker

### docker 搭建本地仓库

```
1. # docker pull registry  #下载registry镜像
2. # mkdir -p /opt/data/registry   #创建仓库挂载目录
3. # docker run -d -p 5000:5000 -v /opt/data/registry:/tmp/registry registry
4. http 访问，修改/etc/docker/daemon.json，没有则创建
{ "insecure-registries":["114.116.99.98:5000"] }
5.重启docker
# systemctl daemon-reload
# systemctl restart docker
6. 要push的镜像打上标签
# docker rename mybusybox 192.168.163.128:5000/mybusybox
# docker push 192.168.163.128:5000/mybusybox 
```

### daocloud加速器

```
# curl -sSL https://get.daocloud.io/daotools/set_mirror.sh | sh -s http://f1361db2.m.daocloud.io
```

### docker部署：centos+nacos+jdk+

```
[root@vmware ~]# docker images
REPOSITORY                       TAG                 IMAGE ID            CREATED             SIZE
daocloud.io/centos               7                   7e6257c9f8d8        3 months ago        203MB
创建容器挂载目录
# mkdir /usr/local/soft
创建centos容器，关联挂载目录：
# docker run -it --name centos7-1204 -v /usr/bin:/usr/pbin -v /usr/sbin:/usr/psbin -v /home:/phome -v /usr/local/soft:/usr/local/soft daocloud.io/centos:7 /bin/bash

```





