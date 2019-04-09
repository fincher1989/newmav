drop table USERS_DB.USERS;

create table USERS_DB.USERS
(
  ID        INTEGER      not null,
  USER_NAME VARCHAR(30) not null,
  USER_PASW VARCHAR(30) not null,
  constraint USERS_PK
    primary key (ID)
);


