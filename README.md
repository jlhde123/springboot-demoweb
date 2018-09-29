# springboot-demoweb

#### 项目介绍
springboot的项目模版 jdk1.8 (完善中)<br/>
有多个端时克隆web项目即可

#### 软件架构
1.  springboot、mybatis、redis、mysql
2.  返回值处理机制
3.  异常处理机制
4.  分页插件

#### 使用说明

1.  运行 DemoworkWebApplication 即可 spring.profiles.active:dev 为测试 prod为生产 <br/>
2.  分页可使用Paghelp 以及 PageRequestDTO
3.  所有异常基于ServerException 所有状态码基于 ServerStatusEnums
4.  对redis缓存的操作基于RedisManager

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request
