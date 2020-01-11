# multi-currency-money

## 第一章、多币种资金
原始报表：

| 票据     | 股份 | 股价        | 合计          |
| -------- | ---- | ----------- | ------------- |
| IBM      | 1000 | 25      | 25000     |
| Novartis | 400  | 100 | 40000 |
|          |      | 合计        | 65000     |

多币种报表:

| 票据     | 股份 | 股价        | 合计          |
| -------- | ---- | ----------- | ------------- |
| IBM      | 1000 | 25美元      | 25000美元     |
| Novartis | 400  | 150瑞士法郎 | 60000瑞士法郎 |
|          |      | 合计        | 65000美元     |

汇率：

| 源币种 | 股份 | 股价        |
| -------- | ---- | ----------- |
| IBM      | 1000 | 1.5    |

需求：产生上述经过修订的多币种报表。

需求分析，要产生上述的多币种报表，需要实现两个功能：
* 在假设已经给定汇率的情况下，要能对两种不同币种的金额进行相加，并将其转换为某一种币种
* 要能将某一金额（每股股价）与另一个数（股数）想乘，并得到一个总金额。

todoList:
- [ ] 当瑞士法郎与美元的兑换率为2:1的时候，5美元+10瑞士法郎=10美元
- [x] 5美元*2=10美元
- [ ] 将"amount"定义为私有
- [ ] Dolla类有副作用吗？在为Dollar对象施加一个操作后，Dollar对象发生了改变。
- [ ] 钱数必须为整数？

## 变质的对象

todoList:
- [ ] 当瑞士法郎与美元的兑换率为2:1的时候，5美元+10瑞士法郎=10美元
- [x] 5美元*2=10美元
- [ ] 将"amount"定义为私有
- [x] Dolla类有副作用吗？在为Dollar对象施加一个操作后，Dollar对象发生了改变。
- [ ] 钱数必须为整数？

将一种感觉（例如，对副作用的厌恶）转化为一个测试程序（例如，对一个Dollar对象连乘两次）是测试驱动开发中的常见方式。从使用者的角度出发，想想使用者会怎么使用Dollar对象，然后根据对应的测试用例重构代码。