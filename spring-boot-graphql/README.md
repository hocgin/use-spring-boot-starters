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