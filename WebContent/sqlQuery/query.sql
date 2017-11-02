DROP DATABASE IF EXISTS  report_search;
CREATE DATABASE report_search;
-- Bảng tài khoản --
DROP TABLE IF EXISTS account;
CREATE TABLE account(
    account_id int PRIMARY KEY AUTO_INCREMENT,
	username varchar(10) UNIQUE,
    password varchar(10) NOT NULL,
    permission tinyint(1) DEFAULT 0,
    email varchar(50) NOT NULL,
    fullname varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci 
);
INSERT INTO account(`username`, `password`, `permission`, `email`, `fullname`) VALUES('danh', '12345', 1, 'abc@gmail.com', 'Danh Nguyễn');
INSERT INTO account(`username`, `password`, `permission`, `email`, `fullname`) VALUES('abcd', '12345', 0, 'abc@gmail.com', 'Nguyễn Danh');
INSERT INTO account(`username`, `password`, `permission`, `email`, `fullname`) VALUES('12345', '12345', 0, 'abc@gmail.com', 'Danh Văn Nguyễn');
-- Bảng lưu thông tin danh mục --
DROP TABLE IF EXISTS category;
CREATE TABLE category(
	category_id int PRIMARY KEY AUTO_INCREMENT,
    category_name varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci
);
INSERT INTO category(`category_name`) VALUES('Kinh tế');
INSERT INTO category(`category_name`) VALUES('Khoa học xã hội');
INSERT INTO category(`category_name`) VALUES('Khoa học tự nhiên');
INSERT INTO category(`category_name`) VALUES('Công nghệ thông tin');
INSERT INTO category(`category_name`) VALUES('Y khoa - dược');
-- Bảng lưu thông tin bài báo cáo
DROP TABLE IF EXISTS report;
CREATE TABLE report(
	report_id int PRIMARY KEY AUTO_INCREMENT,
    account_id int NOT NULL,
    category_id int NOT NULL,
    reportname varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci ,
    description text CHARACTER SET utf8 COLLATE utf8_unicode_ci ,
    number_of_view int DEFAULT 0,
    number_of_download int DEFAULT 0,
    CONSTRAINT FK1 FOREIGN KEY(account_id) REFERENCES account(account_id) on UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK2 FOREIGN KEY(category_id) REFERENCES category(category_id) on UPDATE CASCADE ON DELETE CASCADE
);

-- Bảng phiên bản cho mỗi báo cáo --
DROP TABLE IF EXISTS version;
CREATE TABLE version(
	version_id int PRIMARY KEY AUTO_INCREMENT,
    report_id int NOT NULL,
    date_of_post datetime DEFAULT CURRENT_TIMESTAMP,
    document_file_code varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    picture_cover_file_code varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    extension varchar(4) NOT NULL,
    version int DEFAULT 1,
    active tinyint(1) DEFAULT 0,
    CONSTRAINT FK3 FOREIGN KEY(report_id) REFERENCES report(report_id) on UPDATE CASCADE ON DELETE CASCADE
);
-- INSERT INTO report(account_id, category_id, reportname, description) VALUES(1, 1, 'Mẫu báo cáo 00', 'thử');
-- INSERT INTO report(account_id, category_id, reportname, description) VALUES(1, 2, 'Mẫu báo cáo 01', 'thử');
-- INSERT INTO report(account_id, category_id, reportname, description) VALUES(1, 3, 'Mẫu báo cáo 02', 'thử');
-- INSERT INTO version(report_id, extension, document_file_code, picture_cover_file_code) VALUES(1, '.docx','1_V1', '1_V1');
-- INSERT INTO version(report_id, extension, document_file_code, picture_cover_file_code) VALUES(2, '.docx', '2_V1', '2_V1');
-- INSERT INTO version(report_id, extension, document_file_code, picture_cover_file_code) VALUES(3, '.docx', '3_V1', '3_V1');