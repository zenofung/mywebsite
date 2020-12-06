package com.website.company.controller;


import com.website.company.entity.Message;
import com.website.company.service.*;
import com.website.company.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping("/add")
    @ResponseBody
    Response<Message> addMessage(Message message) {
        Response<Message> response = new Response<>();
        if (messageService.addMessage(message) == 1) {
            response.setResult(message);
            response.setCode(Code.SUCCESSED);
            response.setMsg("提交成功!");
        } else {
            response.setCode(Code.FAILED);
            response.setMsg("留言失败");
            response.setResult(message);
        }
        return response;
    }

    @GetMapping("/getList")
    ResponseList<Message> getList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        return messageService.getList(page, rows);
    }

    @GetMapping("/get")
    ResponseBo get(@RequestParam("id") Integer id) {
        try {
            Message message = messageService.selectById(id);
            return ResponseBo.ok(message);
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @GetMapping("/delete")
    ResponseBo delete(@RequestParam("id") Integer id) {
        try {
            messageService.deleteMessage(id);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    ResponseBo save(@RequestBody Message message) {
        if (message.getId() == null) {
            try {
                messageService.addMessage(message);
                return ResponseBo.ok("操作成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                messageService.updateById(message);
                return ResponseBo.ok("操作成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }
}
