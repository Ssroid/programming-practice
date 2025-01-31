package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.dto.BoardFileDTO;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) throws IOException {
        if(boardDTO.getBoardFile().get(0).isEmpty()) {
            boardDTO.setFileAttached(0);
            boardRepository.save(boardDTO);
        } else {
            boardDTO.setFileAttached(1);
            // 게시글 저장 후 id값 활용을 위해 리턴 받음.
            BoardDTO saveBoard = boardRepository.save(boardDTO);
            // 파일들 마다 받기
            for (MultipartFile boardFile : boardDTO.getBoardFile()) {
                // 파일 이름 가져오기
                String originFileName = boardFile.getOriginalFilename();
                System.out.println("originFileName = " + originFileName);
                // 저장용 이름 만들기
                System.out.println(System.currentTimeMillis());
                String storedFileName = System.currentTimeMillis() + "-" + originFileName;
                System.out.println("storedFileName = " + storedFileName);
                // BoardFileDTO 셋팅
                BoardFileDTO boardFileDTO = new BoardFileDTO();
                boardFileDTO.setOriginFileName(originFileName);
                boardFileDTO.setStoredFileName(storedFileName);
                boardFileDTO.setBoardId(saveBoard.getId());
                // 파일 저장용 폴더에 파일 저장 처리
                String savePath = "C:/Users/Public/Downloads/" + storedFileName;
                boardFile.transferTo(new File(savePath));
                boardRepository.saveFile(boardFileDTO);
            }
        }
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void boardUpdate(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public List<BoardFileDTO> findFile(Long id) {
        return boardRepository.findFile(id);
    }
}
