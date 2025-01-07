package com.upc.webworksbackend.controller;

import com.upc.webworksbackend.dto.CommentProfileDto;
import com.upc.webworksbackend.dto.CommentProfileSummaryDto;
import com.upc.webworksbackend.serviceinterface.CommentProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/webworks/commentProfile")
@CrossOrigin
public class CommentProfileController {

    final CommentProfileService commentProfileService;

    public CommentProfileController(CommentProfileService commentProfileService) {
        this.commentProfileService = commentProfileService;
    }

    @PostMapping("/user/addComment")
    public ResponseEntity<Integer> addCommentProfile(@RequestBody CommentProfileDto commentProfileDto) {
        return new ResponseEntity<>(commentProfileService.addCommentProfile(commentProfileDto), HttpStatus.CREATED);
    }

    @GetMapping("/user/getCommentProfileByUser/{idUser}")
    public ResponseEntity<List<CommentProfileSummaryDto>> getCommentProfileByUser(@PathVariable Integer idUser) {
        return new ResponseEntity<>(commentProfileService.listCommentProfilesByUserId(idUser), HttpStatus.OK);
    }
}
