DROP TABLE IF EXISTS quiz;

CREATE TABLE IF NOT EXISTS quiz (
        quizId INTEGER PRIMARY KEY AUTO_INCREMENT,
        quizQuestionSent VARCHAR(2550) NOT NULL,
        quizRightOrBad boolean NOT NULL,
        quizCommentary VARCHAR(2550) NOT NULL
);

CREATE TABLE IF NOT EXISTS userList (
        id INTEGER PRIMARY KEY AUTO_INCREMENT,
        mailAddress VARCHAR(255) NOT NULL,
        username VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL
);

CREATE TABLE roles(
        id INTEGER PRIMARY KEY,
        name VARCHAR(32) NOT NULL
);

CREATE TABLE user_role(
        user_id INTEGER,
        role_id INTEGER,
        CONSTRAINT pk_user_role PRIMARY KEY (user_id, role_id),
        CONSTRAINT fk_user_role_user_id FOREIGN KEY (user_id) REFERENCES login_user(id),
        CONSTRAINT fk_user_role_role_id FOREIGN KEY (role_id) REFERENCES roles(id)
);

