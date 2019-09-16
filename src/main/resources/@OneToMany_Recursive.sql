DROP TABLE IF EXISTS team_bi;
CREATE TABLE common_code (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , code              INT             NOT NULL                 COMMENT 'CODE'
  , parent            BIGINT UNSIGNED NOT NULL                 COMMENT 'CODE'
  , PRIMARY KEY (id)
) COMMENT = '팀';
