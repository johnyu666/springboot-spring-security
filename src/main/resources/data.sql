 -- 密码是 123
insert into SYS_USER (username,password) values ("john","{bcrypt}$2a$10$jnNsYMd9TEeHlezI/JoMrO6G3dNgmWb0GTDPJmJKXpwqXkt7PdjSi");
 -- 密码是 234
insert into SYS_USER (username,password) values ("tom","{bcrypt}$2a$10$yP3hadkOcr.bMdRZI15sR.8g6YOahgk.vfV32m65nKa9gfRvFfpS6");
-- 角色
insert into SYS_ROLE (name) values ("ADMIN");
 insert into SYS_ROLE (name) values ("USER");
-- 授权（代码中：在SysUser的getAuthorities()方法中体现）
insert into SYS_USER_ROLES (SYS_USER_ID,ROLES_ID ) values (1,1);
insert into SYS_USER_ROLES (SYS_USER_ID,ROLES_ID ) values (2,2);

use test3;
select * from SYS_USER;