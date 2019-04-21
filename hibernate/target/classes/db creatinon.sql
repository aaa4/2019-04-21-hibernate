DROP TABLE IF EXISTS INSTRUCTOR;
DROP TABLE IF EXISTS INSTRUCTOR_DETAILS;

create table if not exists instructor_details
(
  instructor_details_id serial   primary key ,
  youtube_channel      varchar(200)
);


create table if not exists instructor
(
  instructor_id         serial primary key,
  name                 varchar(50),
  age                  int,
  instructor_details_id int  ,
  constraint fk_instructor_detail
    foreign key (instructor_details_id)
      references instructor_details (instructor_details_id)
);


