## UI 界面
/graphiql

## 测试数据
### Query
```graphql
{
  findAll{
    id,
    title
  }
}
```
### Mutation
```graphql
mutation {
  addExample(title: "123") {
    title
  }
}
```

## 基础知识
### 基本语法
#### 视图定义语言(SDL)
```graphql
type Example {
  # 字段:类型, "!" 代表不为NULL, [] 表示数组
  name: String! 
  age: Int
  posts: [Post!]!
}
```

#### API 请求语法
- 查询
```graphql
# === query {}
{
    # 动作(请求参数) { 指定响应字段 }
    findExample(id: 2) {
        name,
        age,
        Post {
            title
        }
    }
}
```
- 删除/更新/增加
```graphql
mutation {
    # 动作(参数) { 指定响应字段 }
    newExample(name: "test", age: 1) {
        name,
        age
    }
}

```
- 订阅
> 订阅代表的是将数据推送出去的流的模式


### 定义视图(Schema)
- 