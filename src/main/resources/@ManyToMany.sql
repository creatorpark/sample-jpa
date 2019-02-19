DROP TABLE IF EXISTS post;
CREATE TABLE post (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , title             VARCHAR(20)     NOT NULL                 COMMENT '타이틀'
  , PRIMARY KEY (id)
) COMMENT = '포스트';

DROP TABLE IF EXISTS tag;
CREATE TABLE tag (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , name              VARCHAR(20)     NOT NULL                 COMMENT '태그명'
  , PRIMARY KEY (id)
) COMMENT = '태그';

DROP TABLE IF EXISTS post_tag_details;
CREATE TABLE post_tag_details (
    post_id           BIGINT UNSIGNED NOT NULL                 COMMENT 'POST_ID'
  , tag_id            BIGINT UNSIGNED NOT NULL                 COMMENT 'TAG_ID'
  , PRIMARY KEY (post_id, tag_id)
  , CONSTRAINT post_tag_details_fk1 FOREIGN KEY (post_id)
    REFERENCES post(id)
  , CONSTRAINT post_tag_details_fk2 FOREIGN KEY (tag_id)
    REFERENCES tag(id)    
) COMMENT = '포스트_태그_디테일';
