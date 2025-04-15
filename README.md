<h1 align="center">智慧养老</h1>

> 仓库介绍



### 数据库结构

# 用户与权限相关表
```
CREATE TABLE role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '角色ID',
    name VARCHAR(30) NOT NULL COMMENT '角色名(如 admin, user, service)',
    description TEXT COMMENT '描述'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
    username VARCHAR(50) NOT NULL COMMENT '登录用户名',
    password VARCHAR(255) NOT NULL COMMENT '加密密码',
    real_name VARCHAR(50) COMMENT '真实姓名',
    phone VARCHAR(20) COMMENT '联系电话',
    avatar VARCHAR(255) COMMENT '头像路径',
    role_id BIGINT COMMENT '角色ID',
    status TINYINT DEFAULT 1 COMMENT '状态(0禁用/1启用)',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
# 养老机构信息表
```
CREATE TABLE nursing_home (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '机构ID',
    name VARCHAR(100) NOT NULL COMMENT '机构名称',
    address VARCHAR(255) COMMENT '地址',
    phone VARCHAR(20) COMMENT '联系电话',
    description TEXT COMMENT '机构介绍',
    longitude DOUBLE COMMENT '地图经度',
    latitude DOUBLE COMMENT '地图纬度',
    level VARCHAR(20) COMMENT '评级等级',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
# 服务与预约模块
```
CREATE TABLE service_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '服务项目ID',
    name VARCHAR(100) NOT NULL COMMENT '服务名称',
    description TEXT COMMENT '服务介绍',
    price DECIMAL(10,2) NOT NULL COMMENT '单次价格',
    home_id BIGINT NOT NULL COMMENT '所属机构ID',
    CONSTRAINT fk_service_home FOREIGN KEY (home_id) REFERENCES nursing_home(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE service_appointment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '预约ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    service_id BIGINT NOT NULL COMMENT '服务项目ID',
    appointment_time DATETIME NOT NULL COMMENT '预约时间',
    status TINYINT NOT NULL COMMENT '状态（0待处理，1已确认，2已完成，3已取消）',
    note TEXT COMMENT '备注说明',
    CONSTRAINT fk_appointment_user FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT fk_appointment_service FOREIGN KEY (service_id) REFERENCES service_item(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
# 公告与通知模块
```
CREATE TABLE announcement (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '公告ID',
    title VARCHAR(100) NOT NULL COMMENT '标题',
    content TEXT NOT NULL COMMENT '内容',
    type VARCHAR(20) NOT NULL COMMENT '类型（系统/社区/机构）',
    target_role VARCHAR(20) NOT NULL COMMENT '目标角色（all/admin/user等）',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

```
#  公益活动与新闻模块
```
CREATE TABLE activity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '活动ID',
    title VARCHAR(100) NOT NULL COMMENT '活动名称',
    content TEXT NOT NULL COMMENT '活动内容',
    place VARCHAR(100) COMMENT '地点',
    start_time DATETIME NOT NULL COMMENT '开始时间',
    end_time DATETIME NOT NULL COMMENT '结束时间',
    max_participants INT NOT NULL COMMENT '最多人数',
    created_at DATETIME NOT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE activity_enroll (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '报名ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    activity_id BIGINT NOT NULL COMMENT '活动ID',
    enrolled_at DATETIME NOT NULL COMMENT '报名时间',
    CONSTRAINT fk_enroll_user FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT fk_enroll_activity FOREIGN KEY (activity_id) REFERENCES activity(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE news (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '新闻ID',
    title VARCHAR(100) NOT NULL COMMENT '新闻标题',
    content TEXT NOT NULL COMMENT '新闻内容',
    published_at DATETIME NOT NULL COMMENT '发布时间',
    source VARCHAR(100) COMMENT '来源'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

#  健康档案模块
```
CREATE TABLE health_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '记录ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    date DATE NOT NULL COMMENT '日期',
    blood_pressure VARCHAR(20) NOT NULL COMMENT '血压（如120/80）',
    heart_rate INT NOT NULL COMMENT '心率',
    temperature DECIMAL(4,1) NOT NULL COMMENT '体温',
    remark TEXT COMMENT '备注说明',
    CONSTRAINT fk_healthrecord_user FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

# 日志与操作记录
```
CREATE TABLE login_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '日志ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    ip_address VARCHAR(45) COMMENT '登录IP',
    login_time DATETIME NOT NULL COMMENT '登录时间',
    user_agent TEXT COMMENT '设备信息',
    
    CONSTRAINT fk_loginlog_user FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
# 留言/评论模块（可选）
```
CREATE TABLE message_board (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '留言ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    content TEXT NOT NULL COMMENT '留言内容',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    reply TEXT COMMENT '管理员回复内容',

    CONSTRAINT fk_messageboard_user FOREIGN KEY (user_id) REFERENCES user(id)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
```


