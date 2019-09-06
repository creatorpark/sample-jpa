DROP TABLE IF EXISTS book;
CREATE TABLE book (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , name              VARCHAR(20)     NOT NULL                 COMMENT '제목'
  , PRIMARY KEY (id)
) COMMENT = '책';

DROP TABLE IF EXISTS publisher;
CREATE TABLE publisher (
    id                SERIAL          NOT NULL                 COMMENT 'SEQ_ID'
  , name              VARCHAR(20)     NOT NULL                 COMMENT '출판사이름'
  , PRIMARY KEY (id)
) COMMENT = '출판사';

DROP TABLE IF EXISTS book_publisher_details;
CREATE TABLE book_publisher_details (
    book_id           BIGINT UNSIGNED NOT NULL                 COMMENT 'BOOK_ID'
  , publisher_id      BIGINT UNSIGNED NOT NULL                 COMMENT 'PUBLISHER_ID'
  , contract_date     VARCHAR(100)    NULL                     COMMENT '계약일'
  , PRIMARY KEY (book_id, publisher_id)
  , CONSTRAINT book_publisher_fk1 FOREIGN KEY (book_id)
    REFERENCES book(id)
  , CONSTRAINT book_publisher_fk2 FOREIGN KEY (publisher_id)
    REFERENCES publisher(id)    
) COMMENT = '책_출판사_디테일';
