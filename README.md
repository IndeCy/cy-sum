# java-cas-sum

## 使用jpa实现 cas对数据库数据进行修改

# 要点1
jpa的repository接口注解使用读已提交 『@Transactional(isolation = Isolation.READ_COMMITTED)』

# 要点2
jpa的注解重复异常捕获是DataIntegrityViolationException

# 要点3
传入的查询实体只能以【唯一索引的条件为实体条件】

# 要点4
确保异常时的重试次数可控
