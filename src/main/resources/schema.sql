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
        history_username VARCHAR(255) NOT NULL,
        questionAll INTEGER default 0,
        civilQuestionAll INTEGER default 0,
        criminalQuestionAll INTEGER default 0,
        pointAll INTEGER default 0,
        pointCivilLaw INTEGER default 0,
        pointCriminalLaw INTEGER default 0,
        CONSTRAINT fk_userId FOREIGN KEY (history_userId) REFERENCES userList (userId),
        CONSTRAINT fk_username FOREIGN KEY (history_username) REFERENCES userList(username)
);