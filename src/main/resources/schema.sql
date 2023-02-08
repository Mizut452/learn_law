DROP TABLE IF EXISTS PreQuiz;
DROP TABLE IF EXISTS LawBoard_comment;
DROP TABLE IF EXISTS LawBoard;
DROP TABLE IF EXISTS precedent;
DROP TABLE IF EXISTS userQuizHistory;
DROP TABLE IF EXISTS quiz;
DROP TABLE IF EXISTS userList;

CREATE TABLE IF NOT EXISTS quiz (
        quizId SERIAL PRIMARY KEY,
        quizQuestionSent VARCHAR(2550) NOT NULL,
        quizRightOrBad INTEGER NOT NULL,
        quizCommentary VARCHAR(2550) NOT NULL,
        quizCategory VARCHAR(30),
        quizAuthor VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS userList (
        userId SERIAL PRIMARY KEY,
        email VARCHAR(255) NOT NULL,
        username VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        roleName VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS userQuizHistory (
        history_userId INTEGER REFERENCES userList(userID),
        history_username VARCHAR(255),
        questionAll INTEGER default 0,
        civilQuestionAll INTEGER default 0,
        criminalQuestionAll INTEGER default 0,
        copyrightQuestionAll INTEGER default 0,
        pointAll INTEGER default 0,
        pointCivilLaw INTEGER default 0,
        pointCriminalLaw INTEGER default 0,
        pointCopyrightLaw INTEGER default 0
);

CREATE TABLE IF NOT EXISTS precedent (
        precedent_id SERIAL PRIMARY KEY,
        precedent_category VARCHAR(255),
        precedent_title VARCHAR(120),
        precedent_number VARCHAR(120),
        precedent_subtitle VARCHAR(120),
        precedent_overview TEXT,
        precedent_claim TEXT,
        precedent_judgement TEXT
);

CREATE TABLE IF NOT EXISTS LawBoard (
        lawBoard_id SERIAL PRIMARY KEY,
        lawBoard_username VARCHAR(20),
        lawBoard_category VARCHAR(255),
        lawBoard_title VARCHAR(255),
        lawBoard_mainComment VARCHAR(300),
        lawBoard_comment VARCHAR(300),
        lawBoard_time VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS LawBoard_comment (
        boardParent_id INTEGER,
        comment_id SERIAL PRIMARY KEY,
        comment VARCHAR(300),
        comment_time VARCHAR(30),
        comment_username VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS PreQuiz (
        quizId SERIAL PRIMARY KEY,
        quizQuestionSent VARCHAR(2550),
        quizRightOrBad INTEGER,
        quizCommentary VARCHAR(2550),
        quizCategory VARCHAR(30),
        quizAuthor VARCHAR(30),
        quizGood INTEGER default 0
);
