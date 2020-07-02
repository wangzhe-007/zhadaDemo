CREATE TABLE role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  rolename varchar(32) NOT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 ;

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(32) NOT NULL ,
  password varchar(128) NOT NULL ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 ;

CREATE TABLE user_role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY user_id (user_id,role_id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ;


insert into role values(1,'admin');

insert into role values(2,'teacher');

insert into role values(3,'student');


insert into user_role values(1,1,1);

insert into user_role values(2,2,2);

insert into user_role values(3,3,3);

