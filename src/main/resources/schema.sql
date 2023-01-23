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
        userId INTEGER,
        username VARCHAR(255),
        questionAll INTEGER,
        civilQuestionAll INTEGER,
        criminalQuestionAll INTEGER,
        pointAll INTEGER,
        pointCivilLaw INTEGER,
        pointCriminalLaw INTEGER,
        CONSTRAINT fk_userId FOREIGN KEY (userId) REFERENCES userList (userId),
        CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES userList (username)
);