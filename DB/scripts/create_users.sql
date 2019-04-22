drop table USERS_DB.USERS;
create table USERS_DB.USERS
(
  ID        integer     not null,
  USER_NAME VARCHAR(30) not null,
  USER_PASW VARCHAR(30) not null,
  constraint USERS_PK   primary key (ID)
);
DROP SEQUENCE USERS_DB.USER_ID ;
create sequence USERS_DB.USER_ID;

select USERS_DB.USER_ID.nextval from dual;


drop table USERS_DB.ROLE;
create table USERS_DB.ROLE
(
  ID        INTEGER     not null,
  ROLE_NAME VARCHAR(30) not null,
  constraint ROLE_PK    primary key (ID)
);
DROP SEQUENCE USERS_DB.ROLE_ID ;
create sequence USERS_DB.ROLE_ID;

select USERS_DB.ROLE_ID.nextval from dual;

drop table USERS_DB.USER_ROLES;
create table USERS_DB.USER_ROLES
(
  USER_ID   INTEGER     not null,
  ROLE_ID   INTEGER     not null,
  constraint USER_ROLES_ROLE_ID_FK   foreign key (ROLE_ID) references ROLE,
  constraint USER_ROLES_USERS_ID_FK  foreign key (USER_ID) references USERS
);

DROP SEQUENCE USERS_DB.USER_ROLE_ID ;
create sequence USERS_DB.USER_ROLE_ID;

select USERS_DB.USER_ROLE_ID.nextval from dual;
