package yuri.elearning.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import yuri.elearning.server.mapper.BookmarkMapper;
import yuri.elearning.server.mapper.DesignMapper;
import yuri.elearning.server.model.Bookmark;
import yuri.elearning.server.model.Design;
import yuri.elearning.server.util.RF;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class DesignService {
    private final BookmarkMapper bookmarkMapper;
    private final DesignMapper designMapper;

    @Autowired

    public DesignService(BookmarkMapper bookmarkMapper, DesignMapper designMapper) {
        this.bookmarkMapper = bookmarkMapper;
        this.designMapper = designMapper;
    }

    public ResponseEntity<List<Design>> selectAllDesigns() {
        List<Design> designs = designMapper.selectAll();
        return RF.success(designs);
    }

    public ResponseEntity<List<Design>> selectDesignsByUser(Integer uid) {
        List<Design> designs = designMapper.selectByUid(uid);
        return RF.success(designs);
    }

    public ResponseEntity<Design> selectDesign(Integer id) {
        Design design = designMapper.select(id);
        return RF.success(design);
    }

    public ResponseEntity<Integer> createDesign(String name, String p, String pl, String pd, String s, String sl, String sd, String tp, String ts, Integer uid) {
        Integer id = -1;
        Design design = new Design(id, name, p, pl, pd, s, sl, sd, tp, ts, uid);
        designMapper.insert(design);
        return RF.success(design.getId());
    }

    public ResponseEntity<Integer> deleteDesign(Integer id) {
        Integer count = designMapper.delete(id);
        if (count == 0)
            return RF.badRequest(count);
        else return RF.success(count);
    }

    public ResponseEntity<List<Design>> selectDesignsByBookmarkUid(Integer uid) {
        List<Bookmark> bookmarks = bookmarkMapper.select(uid);
        List<Design> designs = new ArrayList<>();
        bookmarks.forEach(bookmark -> designs.add(designMapper.select(bookmark.getDid())));
        return RF.success(designs);
    }

    public ResponseEntity<Integer> insertBookmark(Integer uid, Integer did) {
        Integer count = bookmarkMapper.insert(uid, did);
        return RF.success(count);
    }

    public ResponseEntity<Integer> deleteBookmark(Integer uid,Integer did) {
        Integer count = bookmarkMapper.delete(uid,did);
        if (count == 0)
            return RF.badRequest(count);
        else return RF.success(count);
    }
}
