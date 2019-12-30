package yuri.elearning.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yuri.elearning.server.model.Bookmark;
import yuri.elearning.server.model.Design;
import yuri.elearning.server.service.DesignService;

import java.util.List;

@Api("颜色（革命）API")
@RestController
@RequestMapping("/api/design")
public class DesignController {
    private final DesignService designService;

    @Autowired
    public DesignController(DesignService designService) {
        this.designService = designService;
    }

    @ApiOperation("获取所有设计")
    @PostMapping("/getAllDesigns")
    @ResponseBody
    public ResponseEntity<List<Design>> getAllDesigns() {
        return designService.selectAllDesigns();
    }

    @ApiOperation("获取单个用户所有设计")
    @PostMapping("/getUserDesigns")
    @ResponseBody
    public ResponseEntity<List<Design>> getUserDesigns(@RequestParam("uid") Integer uid) {
        return designService.selectDesignsByUser(uid);
    }

    @ApiOperation("按id获取单个设计")
    @PostMapping("/getDesignById")
    @ResponseBody
    public ResponseEntity<Design> getDesignById(@RequestParam("id") Integer id) {
        return designService.selectDesign(id);
    }

    @ApiOperation("创建一个设计")
    @PutMapping("/createDesign")
    @ResponseBody
    public ResponseEntity<Integer> createDesign(@RequestParam("name") String name,
                                                @RequestParam("p") String p,
                                                @RequestParam("pl") String pl,
                                                @RequestParam("pd") String pd,
                                                @RequestParam("s") String s,
                                                @RequestParam("sl") String sl,
                                                @RequestParam("sd") String sd,
                                                @RequestParam("tp") String tp,
                                                @RequestParam("ts") String ts,
                                                @RequestParam("uid") Integer uid
    ) {
        return designService.createDesign(name, p, pl, pd, s, sl, sd, tp, ts, uid);
    }

    @ApiOperation("删除一个设计")
    @DeleteMapping("/deleteDesign")
    @ResponseBody
    public ResponseEntity<Integer> deleteDesign(@RequestParam("id") Integer id) {
        return designService.deleteDesign(id);
    }

    @ApiOperation("获得用户的所有书签")
    @PostMapping("/getAllUserBookmark")
    @ResponseBody
    public ResponseEntity<List<Bookmark>> getAllUserBookmark(@RequestParam("uid") Integer uid) {
        return designService.selectBookmarksByUid(uid);
    }

    @ApiOperation("创建一个书签")
    @PutMapping("/createBookmark")
    @ResponseBody
    public ResponseEntity<Integer> createBookmark(@RequestParam("uid") Integer uid, @RequestParam("did") Integer did) {
        return designService.insertBookmark(uid, did);
    }

    @ApiOperation("删除一个书签")
    @DeleteMapping("/deleteBookmark")
    @ResponseBody
    public ResponseEntity<Integer> deleteBookmark(@RequestParam("uid") Integer uid,@RequestParam("did") Integer did){
        return designService.deleteBookmark(uid,did);
    }
}
