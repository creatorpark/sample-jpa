DROP TABLE IF EXISTS team_bi;
CREATE TABLE team_bi (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , name              VARCHAR(20)     NOT NULL                 COMMENT '이름'
  , PRIMARY KEY (id)
) COMMENT = '팀';

DROP TABLE IF EXISTS player_bi;
CREATE TABLE player_bi (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , team_bi_id        BIGINT UNSIGNED NOT NULL                 COMMENT 'TEAM_ID'
  , name              VARCHAR(20)     NOT NULL                 COMMENT '이름'
  , uniform_number    VARCHAR(20)     NOT NULL                 COMMENT '유니폼넘버'
  , PRIMARY KEY (id)
  , CONSTRAINT player_fk FOREIGN KEY (team_bi_id)
    REFERENCES team_bi (id) 
) COMMENT = '선수';