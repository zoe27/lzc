CREATE TABLE customer(
  customer_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '用户ID',
  login_name VARCHAR(20) NOT NULL COMMENT '登录名',
  password CHAR(32) NOT NULL COMMENT '密码',
  PRIMARY KEY pk_customerid(customer_id)
) ENGINE = innodb COMMENT '用户表';

CREATE TABLE customer_inf(
  customer_inf_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '用户信息ID',
  customer_id INT UNSIGNED NOT NULL COMMENT 'customer表的自增ID',
  customer_name VARCHAR(20) NOT NULL COMMENT '用户真实姓名',
  identity_card_no VARCHAR(20) COMMENT '证件号码',
  mobile_phone INT UNSIGNED COMMENT '手机号',
  customer_email VARCHAR(50) COMMENT '邮箱',
  gender CHAR(1) COMMENT '性别',
  birthday DATETIME COMMENT '生日',
  PRIMARY KEY pk_customerinfid(customer_inf_id)
) ENGINE = innodb COMMENT '用户信息表';

CREATE TABLE customer_addr(
  customer_addr_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '用户地址ID',
  customer_id INT UNSIGNED NOT NULL COMMENT 'customer表的自增ID',
  zip INT NOT NULL COMMENT '邮编',
  address VARCHAR(200) NOT NULL COMMENT '具体的地址门牌号',
  is_default INT NOT NULL COMMENT '是否默认',
  PRIMARY KEY pk_customeraddid(customer_addr_id)
) ENGINE = innodb COMMENT '用户地址表';

CREATE TABLE product(
  product_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '商品ID',
  product_core CHAR(16) NOT NULL COMMENT '商品编码',
  product_name VARCHAR(20) NOT NULL COMMENT '商品名称',
  price DECIMAL(8,2) NOT NULL COMMENT '商品销售价格',
  descript VARCHAR(500) NOT NULL COMMENT '商品描述',
  indate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品录入时间',
  PRIMARY KEY pk_productid(product_id)
) ENGINE = innodb COMMENT '商品信息表';

CREATE TABLE product_comment(
  comment_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '商品评论ID',
  product_id INT UNSIGNED NOT NULL COMMENT '商品ID',
  order_id BIGINT UNSIGNED NOT NULL COMMENT '订单ID',
  customer_id INT UNSIGNED NOT NULL COMMENT '用户ID',
  title VARCHAR(50) NOT NULL COMMENT '评论标题',
  content VARCHAR(300) NOT NULL COMMENT '评论内容',
  audit_time TIMESTAMP NOT NULL COMMENT '评论时间',
  PRIMARY KEY pk_commentid(comment_id)
) ENGINE = innodb COMMENT '商品评论表';

CREATE TABLE order_inf(
  order_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '订单ID',
  order_sn INT UNSIGNED NOT NULL COMMENT '订单编号',
  customer_id INT UNSIGNED NOT NULL COMMENT '下单人ID',
  shipping_comp_name VARCHAR(10) COMMENT '快递公司名称',
  shipping_sn VARCHAR(50) COMMENT '快递单号',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  shipping_time DATETIME COMMENT '发货时间',
  receive_time DATETIME COMMENT '收货时间',
  order_status INT NOT NULL DEFAULT 0 COMMENT '订单状态',
  PRIMARY KEY pk_orderid(order_id)
)ENGINE = innodb COMMENT '订单表';
