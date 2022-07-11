package com.example.demo.controller;

import com.example.demo.entity.BoardEntity;
import com.example.demo.repo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor //Autowired역활
@RequestMapping(value = "/board")
public class BoardController {

    private final BoardRepository boardRepository;

    /**
     * 게시글 조회
     * @return
     */
    @GetMapping("list")
    public List<BoardEntity> findAllBoard(){

        return boardRepository.findAll();
    }

    /**
     * 게시글 등록
     * @return
     */
    @PostMapping("reg")
    public BoardEntity reg(String id, String content) {
        final BoardEntity board = BoardEntity.builder()
                .id(id)
                .content(content)
                .build();
        return boardRepository.save(board);
    }

    /**
     * 게시글 번호로 게시글 삭제
     */
    @DeleteMapping
    public void delete(@RequestParam Long board_seq) {
        boardRepository.deleteById(board_seq);
    }

    /**
     * 게시글 번호로 게시글 수정
     */
    @PutMapping(value = "/{board_seq}")
    public BoardEntity update(@PathVariable Long board_seq, @RequestParam String id, @RequestParam String content) {
        Optional<BoardEntity> board = boardRepository.findById(board_seq);
        board.get().setId(id);
        board.get().setContent(content);
        return boardRepository.save(board.get());
    }
}
