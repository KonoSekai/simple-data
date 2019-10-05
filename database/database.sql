--货币
DROP TABLE IF EXISTS currency;
CREATE TABLE currency (
  currency_id   BIGINT PRIMARY KEY  AUTO_INCREMENT NOT NULL,
  currency_name VARCHAR                            NOT NULL,
  currency_code VARCHAR                            NOT NULL,
  is_deleted    BOOLEAN  DEFAULT FALSE,
  gmt_create    DATETIME DEFAULT NOW(),
  gmt_modified  DATETIME DEFAULT NOW()
);
INSERT INTO currency (currency_name, currency_code)
VALUES ('人民币', 'CNY'),
       ('美元', 'USD'),
       ('日元', 'JPY'),
       ('欧元', 'EUR'),
       ('港币', 'HKD');
SELECT * FROM currency;