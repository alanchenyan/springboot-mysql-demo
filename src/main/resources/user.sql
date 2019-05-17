
-- 建表语句

CREATE TABLE t_user(
  key_id VARCHAR(255) NOT NULL PRIMARY KEY,  -- id 统一命名为key_id
  user_name VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  phone VARCHAR(255) NOT NULL,
  deleted INT NOT NULL DEFAULT 0,  -- 逻辑删除标志默认值
  create_time	timestamp NULL default CURRENT_TIMESTAMP, -- 创建时间默认值
  update_time	timestamp NULL default CURRENT_TIMESTAMP -- 修改时间默认值
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4;

