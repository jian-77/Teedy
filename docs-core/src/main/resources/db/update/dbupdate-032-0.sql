create table T_USER_REGISTRATION (ID_C varchar(36) not null, USERNAME_C varchar(50) not null, PASSWORD_C varchar(60) not null, CHECKED_B bit not null default 0,CREATEDATE_D datetime not null, primary key (ID_C));

insert into T_USER(USE_ID_C, USE_IDROLE_C, USE_USERNAME_C, USE_PASSWORD_C, USE_EMAIL_C, USE_CREATEDATE_D, USE_PRIVATEKEY_C) values('user1', 'user', 'user1', '$2y$10$xg0EEKVUehutDI1m6qQhVeFz7SMQMl1jQzjf2KkVsR2c7aV2vyyjK', 'guest@localhost', NOW(), 'GuestPk');
-- Update the database version
update T_CONFIG set CFG_VALUE_C = '32' where CFG_ID_C = 'DB_VERSION';