DROP TABLE IF EXISTS user_fk;
CREATE TABLE user_fk (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , name              VARCHAR(20)     NOT NULL                 COMMENT '이름'
  , password          VARCHAR(20)     NOT NULL                 COMMENT '패스워드'
  , PRIMARY KEY (id)
) COMMENT = '사용자';

DROP TABLE IF EXISTS address_fk;
CREATE TABLE address_fk (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , user_id           BIGINT UNSIGNED NOT NULL                 COMMENT 'USER_ID'
  , state             VARCHAR(20)     NOT NULL                 COMMENT '주'
  , city              VARCHAR(20)     NOT NULL                 COMMENT '도시'
  , PRIMARY KEY (id)
  , CONSTRAINT address_fk FOREIGN KEY (user_id)
    REFERENCES user_fk (id) 
    ON DELETE CASCADE ON UPDATE NO ACTION
) COMMENT = '주소';