package yuri.elearning.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuri.elearning.server.service.PurchaseService;

@Api(tags = "购买API")
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @ApiOperation("购买课程")
    @PostMapping("/purchase")
    @ResponseBody
    public ResponseEntity<String> purchaseCourse(@RequestParam("uid") Integer userId,
                                                 @RequestParam("cid") Integer courseId) {
        return purchaseService.purchaseCourse(userId, courseId);
    }
}
