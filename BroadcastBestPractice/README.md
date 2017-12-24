# Broadcast Receiver 最佳实践 —— 实现强制下线功能

1. BaseActivity 类继承 AppCompatActivity 类，并实现活动接收器相关逻辑
2. LoginActivity 类作为登录活动
3. MainActivity 类作为登录后的活动，并实现强制下线的 Intent 