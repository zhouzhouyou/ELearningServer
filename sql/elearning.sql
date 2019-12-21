drop table if exists type;
drop table if exists category;
drop table if exists purchase;
drop table if exists lesson ;
drop table if exists course;
drop table if exists user;

create table user
(
    id       integer primary key auto_increment,
    name     varchar(10) not null unique,
    password varchar(20) not null,
    money    double      not null
);

insert into user (name, password, money)
values ('zzy', 'zzy', 100);
insert into user (name, password, money)
values ('ckf', 'ckf', 100);

create table course
(
    id          integer primary key auto_increment,
    name        varchar(10)  not null,
    description varchar(100) not null,
    syllabus    varchar(50)  not null,
    teacher     varchar(10)  not null,
    cost        double       not null,
    cover       varchar(50)
);

insert into course (name, description, syllabus, teacher, cost, cover)
VALUES ('计算机科学', '讲述计算机的科学', '大约16周，讲述从...到...', 'A老师', 16.5, null);
insert into course (name, description, syllabus, teacher, cost, cover)
VALUES ('计算机网络', '计算机网络', '8周', 'B老师', 50, null);
insert into course (name, description, syllabus, teacher, cost, cover)
VALUES ('生命与科学', '其实什么都不讲', '8周', 'C老师', 0, null);
insert into course (name, description, syllabus, teacher, cost, cover)
values ('诗词鉴赏', '唐诗宋词', '16周', 'D老师', 19, null);
insert into course (name, description, syllabus, teacher, cost, cover)
values ('绘画', '画画', '摸鱼16周', 'E老师', 20, null);

create table lesson
(
    id      integer primary key auto_increment,
    title   varchar(20)  not null,
    time    date         not null,
    content varchar(100) not null,
    cid     integer      not null,
    video   varchar(50),
    foreign key (cid) references course (id) on delete cascade
);

insert into lesson (time, title, content, cid)
VALUES ('2019-12-29', '计算机与宇宙辐射', '其实没什么关系1', 1);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-30', '计算机与宇宙辐射2', '其实没什么关系2', 1);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-31', '计算机与宇宙辐射3', '其实没什么关系3', 1);
insert into lesson (time, title, content, cid)
VALUES ('2020-1-1', '计算机与宇宙辐射4', '其实没什么关系4', 1);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-21', '网络与宇宙辐射', '其实没什么关系5', 2);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-22', '网络与宇宙辐射2', '其实没什么关系6', 2);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-25', '网络与宇宙辐射3', '其实没什么关系7', 2);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-29', '网络与宇宙辐射4', '其实没什么关系8', 2);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-20', '什么是生命与科学', '其实没什么关系9', 3);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-21', '什么是生命与科学2', '其实没什么关系10', 3);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-24', '什么是生命与科学3', '其实没什么关系11', 3);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-25', '什么是生命与科学4', '其实没什么关系12', 3);
insert into lesson (time, title, content, cid)
VALUES ('2020-1-1', '唐诗', '唐诗~', 4);
insert into lesson (time, title, content, cid)
VALUES ('2020-1-2', '唐诗2', '唐诗~~', 4);
insert into lesson (time, title, content, cid)
VALUES ('2020-1-6', '宋词', '宋词~', 4);
insert into lesson (time, title, content, cid)
VALUES ('2020-1-7', '宋词2', '宋词~~', 4);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-23', '两点透视', '从入门到放弃1', 5);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-24', '三点透视', '从入门到放弃2', 5);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-25', '如何摸鱼', '从入门到放弃3', 5);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-28', '如何摸鱼2', '从入门到放弃4', 5);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-29', '如何摸鱼3', '从入门到放弃5', 5);
insert into lesson (time, title, content, cid)
VALUES ('2019-12-30', '如何摸鱼4', '从入门到放弃6', 5);

create table purchase
(
    uid integer,
    cid integer,
    foreign key (uid) references user (id),
    foreign key (cid) references course (id)
);

insert into purchase
values (1, 1);
insert into purchase
values (1, 2);
insert into purchase
values (1, 3);
insert into purchase
values (2, 4);
insert into purchase
values (2, 5);
insert into purchase
values (2, 2);

create table category
(
    id          integer primary key auto_increment,
    name        varchar(10) unique ,
    description varchar(100)
);

insert into category (name, description)
values ('计算机', '计算机类');
insert into category (name, description)
values ('自然科学', 'biology');
insert into category (name, description)
values ('艺术', 'art');

create table type
(
    course   integer,
    category integer,
    foreign key (course) references course (id),
    foreign key (category) references category (id)
);

insert into type values (1, 1);
insert into type values (2, 1);
insert into type values (3, 2);
insert into type values (4, 3);
insert into type values (5, 3);