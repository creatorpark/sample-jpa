DROP TABLE IF EXISTS user_pk;
CREATE TABLE user_pk (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , name              VARCHAR(20)     NOT NULL                 COMMENT '이름'
  , password          VARCHAR(20)     NOT NULL                 COMMENT '패스워드'
  , PRIMARY KEY (id)
) COMMENT = '사용자';

DROP TABLE IF EXISTS address_pk;
CREATE TABLE address_pk (
    id                BIGINT UNSIGNED NOT NULL                 COMMENT 'SEQ_ID'
  , state             VARCHAR(20)     NOT NULL                 COMMENT '주'
  , city              VARCHAR(20)     NOT NULL                 COMMENT '도시'
  , PRIMARY KEY (id)
  , CONSTRAINT address_pk_fk FOREIGN KEY (id)
    REFERENCES user_pk (id) 
    ON DELETE CASCADE ON UPDATE NO ACTION
) COMMENT = '주소';
