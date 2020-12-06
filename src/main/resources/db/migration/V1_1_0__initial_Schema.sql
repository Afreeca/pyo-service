SET sql_mode = '';

SET GLOBAL default_storage_engine = 'InnoDB';

CREATE TABLE if NOT EXISTS break(
    id BIGINT NOT NULL,
    broadcast_date DATE NOT NULL,
    start_time INT NOT NULL,
    duration INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(broadcast_date, start_time)
)engine=innodb;

CREATE TABLE if NOT EXISTS campaign(
    id BIGINT NOT NULL,
    advertiser_id VARCHAR(100) NOT NULL,
    spot_length INT NOT NULL,
    demographic VARCHAR(25) NOT NULL,
    target_tvr INT NOT NULL,
    pyo_percentage INT NOT NULL,
    PRIMARY KEY(id)
)engine=innodb;

CREATE TABLE if NOT EXISTS break_campaign(
    id BIGINT AUTO_INCREMENT NOT NULL,
    break_id BIGINT NOT NULL,
    campaign_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(break_id, campaign_id),
    FOREIGN KEY(break_id) REFERENCES break(id),
    FOREIGN KEY(campaign_id) REFERENCES campaign(id)
)engine=innodb;


