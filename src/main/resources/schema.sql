DROP TABLE IF EXISTS precedent;
DROP TABLE IF EXISTS userQuizHistory;
DROP TABLE IF EXISTS quiz;
DROP TABLE IF EXISTS userList;

CREATE TABLE IF NOT EXISTS quiz (
        quizId INTEGER PRIMARY KEY AUTO_INCREMENT,
        quizQuestionSent VARCHAR(2550) NOT NULL,
        quizRightOrBad boolean NOT NULL,
        quizCommentary VARCHAR(2550) NOT NULL,
        quizCategory VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS userList (
        userId INTEGER PRIMARY KEY AUTO_INCREMENT,
        email VARCHAR(255) NOT NULL,
        username VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        roleName VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS userQuizHistory (
        history_userId INTEGER,
        history_username VARCHAR(255),
        questionAll INTEGER default 0,
        civilQuestionAll INTEGER default 0,
        criminalQuestionAll INTEGER default 0,
        pointAll INTEGER default 0,
        pointCivilLaw INTEGER default 0,
        pointCriminalLaw INTEGER default 0,
        CONSTRAINT fk_userId FOREIGN KEY (history_userId) REFERENCES userList (userId)
);

CREATE TABLE IF NOT EXISTS precedent (
        precedent_id INTEGER PRIMARY KEY AUTO_INCREMENT,
        precedent_category VARCHAR(40),
        precedent_title VARCHAR(120),
        precedent_number VARCHAR(120),
        precedent_subtitle VARCHAR(120),
        precedent_overview VARCHAR(1000),
        precedent_plClaim VARCHAR(1000),
        precedent_deClaim VARCHAR(1000),
        precedent_judgement VARCHAR(1000)
);