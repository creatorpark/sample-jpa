DROP TABLE IF EXISTS team_uni_players;
DROP TABLE IF EXISTS team_uni;
DROP TABLE IF EXISTS player_uni;


CREATE TABLE team_uni (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , name              VARCHAR(20)     NOT NULL                 COMMENT '이름'
  , PRIMARY KEY (id)
) COMMENT = '팀';

CREATE TABLE player_uni (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , name              VARCHAR(20)     NOT NULL                 COMMENT '이름'
  , uniform_number    VARCHAR(20)     NOT NULL                 COMMENT '유니폼넘버'
  , PRIMARY KEY (id)
) COMMENT = '선수';

CREATE TABLE team_uni_players (
    team_uni_id       BIGINT UNSIGNED NOT NULL                 COMMENT 'TEAM_UNI_ID'
  , players_id        BIGINT UNSIGNED NOT NULL                 COMMENT 'PLAYER_UNI_ID'
  , PRIMARY KEY (team_uni_id, players_id)
  , CONSTRAINT team_player_fk1 FOREIGN KEY (team_uni_id)
    REFERENCES team_uni(id)
  , CONSTRAINT team_player_fk2 FOREIGN KEY (players_id)
    REFERENCES player_uni(id)    
) COMMENT = '팀-선수';
