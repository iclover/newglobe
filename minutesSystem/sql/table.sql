-- Create table
create table USERINFO
(
  user_id       number(10) not null,
  user_name     varchar2(200) not null,
  user_password varchar2(200) not null,
  user_type     varchar2(10),
  is_valid      varchar2(10) default 1,
  create_time   date,
  operate_time  date
)
;
-- Add comments to the table 
comment on table USERINFO
  is '系统用户信息表';
-- Add comments to the columns 
comment on column USERINFO.user_id
  is '用户ID';
comment on column USERINFO.user_name
  is '用户名';
comment on column USERINFO.user_password
  is '用户密码';
comment on column USERINFO.user_type
  is '用户类型，
1：项目经理；
2：程序员；
';
comment on column USERINFO.is_valid
  is '是否有效  ''1''有效  ''0''无效 默认1';
comment on column USERINFO.create_time
  is '创建时间';
comment on column USERINFO.operate_time
  is '更新时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table USERINFO
  add constraint PK_USERINFO_USER_ID primary key (USER_ID);
alter table USERINFO
  add constraint UK_USERINFO_USER_NAME unique (USER_NAME);