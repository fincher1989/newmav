drop table USERS_DB.USERS;

create table USERS_DB.USERS
(
  ID        integer     not null,
  USER_NAME VARCHAR(30) not null,
  USER_PASW VARCHAR(30) not null,
  constraint USERS_PK
    primary key (ID)
);
DROP SEQUENCE USERS_DB.USER_ID ;

create sequence USERS_DB.USER_ID;
select USERS_DB.USER_ID.nextval from dual;


drop table USERS_DB.ROLE;

create table USERS_DB.ROLE
(
  ID        INTEGER     not null,
  ROLE_NAME VARCHAR(30) not null,
  constraint ROLE_PK
    primary key (ID)
);

drop table USERS_DB.USER_ROLES;

create table USERS_DB.USER_ROLES
(
  ID        INTEGER     not null,
  USER_ID   INTEGER     not null,
  ROLE_ID   INTEGER     not null,
  constraint UR_PK
    primary key (ID)
);
