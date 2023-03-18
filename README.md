# scheduler

DDDplus Layered Architecture

```
scheduler-api 系统对外暴露服务的声明
      |
scheduler-facade 系统对外暴露服务的实现
      |
scheduler-application UseCase层
      |
    +-------------------+
    |                   |
scheduler-domain <-- scheduler-infrastructure
    |
scheduler-spec
```
