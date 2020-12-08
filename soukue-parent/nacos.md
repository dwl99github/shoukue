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

### docker加速器 - daocloud

```
# curl -sSL https://get.daocloud.io/daotools/set_mirror.sh | sh -s http://f1361db2.m.daocloud.io
查看配置  /etc/docker/daemon.json
```

查看登录信息：cat /root/.docker/config.json

### docker部署：centos+nacos+jdk+

```
1.拉取镜像
[root@vmware ~]# docker images
REPOSITORY                       TAG                 IMAGE ID            CREATED             SIZE
daocloud.io/centos               7                   7e6257c9f8d8        3 months ago        203MB
2.创建容器挂载目录
# mkdir /usr/local/soft
3.创建centos容器，关联挂载目录：
# docker run -it --name centos7-1204 -v /usr/bin:/usr/pbin -v /usr/sbin:/usr/psbin -v /home:/phome -v /usr/local/soft:/usr/local/soft daocloud.io/centos:7 /bin/bash
=========================
1.通过Dockerfile构建
[root@vmware ~]# docker build -t nacos01:centos7 .
2.以构建的镜像创建容器
3、通过  docker inspect 可查看容器挂载目录在宿主机的映射目录，将jdk-8u131-linux-x64.rpm拷贝到挂载目录，安装jdk        # rpm -ivh jdk-8u131-linux-x64.rpm
```

```dockerfile
# Install a centos7, filename=Dockerfile

FROM daocloud.io/centos:7
MAINTAINER dwl

ENV PATH=$PATH:/usr/local/bin:/usr/pbin:/usr/psbin:/phome
VOLUME ["/usr/local/soft"]
WORKDIR /usr/local/soft

#RUN echo "" >> /etc/mongodb.conf

#CMD ["/usr/bin/mongod", "--config", "/etc/mongodb.conf"]
```

### docker 配置 ssh

```
1、安装ssh  略
2、https://www.cnblogs.com/wu-wu/p/13665615.html
```

### 配置免密登录ssh

```
# ssh-keygen -t rsa
# cd /root/.ssh/
# cp id_rsa.pub authorized_keys
# ssh-copy-id -i 172.17.0.2
# ssh 172.17.0.2  #连接成功
```

### docker push

```
推送镜像的规范是：docker push 注册用户名/镜像名
tag命令修改为规范的镜像：
# docker tag centos7:nacos-ssh dwl99/centos7:nacos-ssh
# docker push dwl99/centos7:nacos-ssh

```

### docker 配置自动启动nacos，nacos指定ip

### docker compose



### docker network