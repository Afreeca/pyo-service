SET sql_mode = '';

SET GLOBAL default_storage_engine = 'InnoDB';

CREATE TABLE if NOT EXISTS break(
    break_id INT AUTO_INCREMENT PRIMARY KEY,
    broadcast_date DATE NOT NULL,
    start_time INT UNIQUE NOT NULL,
    duration INT NOT NULL,
    UNIQUE KEY (break_id, broadcast_date, start_time)
)engine=innodb;

CREATE TABLE if NOT EXISTS campaign(
    campaign_id INT AUTO_INCREMENT PRIMARY KEY,
    advertiser_id VARCHAR(100) NOT NULL,
    spot_length INT UNIQUE NOT NULL,
    demographic VARCHAR(25) NOT NULL,
    target_tvr INT NOT NULL,
    pyo_percentage INT NOT NULL
)engine=innodb;