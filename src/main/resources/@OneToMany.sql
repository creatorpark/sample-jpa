DROP TABLE IF EXISTS team;
CREATE TABLE team (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , name              VARCHAR(20)     NOT NULL                 COMMENT '이름'
  , PRIMARY KEY (id)
) COMMENT = '팀';

DROP TABLE IF EXISTS player;
CREATE TABLE player (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , team_id           BIGINT UNSIGNED NOT NULL                 COMMENT 'TEAM_ID'
  , name              VARCHAR(20)     NOT NULL                 COMMENT '이름'
  , uniform_number    VARCHAR(20)     NOT NULL                 COMMENT '유니폼넘버'
  , PRIMARY KEY (id)
  , CONSTRAINT player_fk FOREIGN KEY (team_id)
    REFERENCES team (id) 
) COMMENT = '선수';