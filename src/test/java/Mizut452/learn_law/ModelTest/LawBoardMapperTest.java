package Mizut452.learn_law.ModelTest;

import Mizut452.learn_law.Mapper.LawBoardMapper;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoard;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardComment;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LawBoardMapperTest {
    @Autowired
    LawBoardMapper lawBoardMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void lawBoardAllメソッドで全て1件取得() {
        List<LawBoard> lawBoardList = lawBoardMapper.lawBoardAll();
        assertEquals(1, lawBoardList.size());
    }

    @Test
    void lawBoardByIdで特定の情報を取得() {
        LawBoard lawBoard = lawBoardMapper.lawBoardById(1);
        assertEquals("殺人罪について教えていただきたいです！", lawBoard.getLawBoard_mainComment());
        assertEquals("刑法", lawBoard.getLawBoard_category());
    }

    @Test
    void 掲示板を作る() {
        LawBoard lawBoard = new LawBoard();
        lawBoard.setLawBoard_username("top");
        lawBoard.setLawBoard_title("はじめまして");
        lawBoard.setLawBoard_category("刑法");
        lawBoard.setLawBoard_mainComment("はじめまして、刑法について質問があります。");

        lawBoardMapper.LAW_BOARD_Sync();
        lawBoardMapper.createThread(lawBoard);
        lawBoard = lawBoardMapper.lawBoardById(2);
        assertEquals("はじめまして", lawBoard.getLawBoard_title());

        assertEquals("刑法", lawBoard.getLawBoard_category());
    }

}
