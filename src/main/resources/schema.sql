DROP TABLE IF EXISTS quiz;
DROP TABLE IF EXISTS userList;

CREATE TABLE IF NOT EXISTS quiz (
        quizId INTEGER PRIMARY KEY AUTO_INCREMENT,
        quizQuestionSent VARCHAR(2550) NOT NULL,
        quizRightOrBad boolean NOT NULL,
        quizCommentary VARCHAR(2550) NOT NULL
);

CREATE TABLE IF NOT EXISTS userList (
        userId INTEGER PRIMARY KEY AUTO_INCREMENT,
        email VARCHAR(255) NOT NULL,
        username VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        roleName VARCHAR(255) NOT NULL
);