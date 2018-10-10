## spring cloud demo

功能|是否添加|备注
-|-|-
eureka|√|http://eureka.server.com:8888
config|√|http://localhost:9100
bus|√|配合config自动reload bean(/actuator/bus-refresh)
springboot-admin|√|http://localhost:9000
zipkin|√|http://ovirt-node1.trinasolar.com:9411/zipkin/
feign|√|
ribbon|√|feign自动实现
Sleuth|√|
hystrix|×|
swagger|×|
Security|×|
oauth2|×|
jwt|×|
TCC|×|
ELK|×|
gateway|√|
zookeeper|×|
data flow|×|
统一异常处理|×|
分布式全局锁|×|


### 其他服务
服务名称|备注
-|-
rabbitmq|http://ovirt-node1.trinasolar.com:15672

