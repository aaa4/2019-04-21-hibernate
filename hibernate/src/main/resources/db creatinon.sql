
/*
Отредактировано 21.04.2019.
*/

DROP TABLE IF EXISTS subjects_students;
DROP TABLE IF EXISTS subjects;
DROP TABLE IF EXISTS STUDENTS;
DROP TABLE IF EXISTS INSTRUCTOR;
DROP TABLE IF EXISTS INSTRUCTOR_DETAILS;
DROP TABLE IF EXISTS topic;
DROP TABLE IF EXISTS acc;

create table if not exists acc
(
  acc_id        serial primary key ,
  acc_user_name varchar(200)

);
create table if not exists topic
(
  topic_id      serial primary key,
  topic_title   varchar(200),
  topic_content text,
  topic_acc_id  int,
  constraint fk_topic_acc_id
    foreign key(topic_acc_id)
      references acc(acc_id)
);



create table if not exists instructor_details
(
  instructor_details_id serial primary key,
  youtube_channel       varchar(200)
);

create table if not exists instructor
(
  instructor_id         serial primary key,
  name                  varchar(50),
  age                   int,
  instructor_details_id int,
  constraint fk_instructor_detail
    foreign key (instructor_details_id)
      references instructor_details (instructor_details_id)
);


create table if not exists students
(
  student_id    serial primary key,
  student_name  varchar(60),
  student_age   int,
  instructor_id int,
  constraint fk_student
    foreign key (instructor_id)
      references instructor (instructor_id)

);

create table if not exists subjects
(
  subject_id   serial primary key,
  subject_name varchar(100)
);

create table if not exists subjects_students
(
  student_id int,
  subject_id int,
  constraint fk_student_id
    foreign key (student_id)
      references students (student_id),
  constraint fk_subject
    foreign key (subject_id)
      references subjects (subject_id)


);

