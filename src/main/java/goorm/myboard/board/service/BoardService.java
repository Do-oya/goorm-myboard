package goorm.myboard.board.service;

import goorm.myboard.board.db.BoardEntity;
import goorm.myboard.board.db.BoardRepository;
import goorm.myboard.board.model.BoardRequest;
import goorm.myboard.board.model.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepositoy;

    public BoardResponse create(BoardRequest boardRequest) {
        var entity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();

        var saveEntity = boardRepositoy.save(entity);

        return BoardResponse.builder()
                .boardId(saveEntity.getId())
                .status(saveEntity.getStatus())
                .build();
    }
}
