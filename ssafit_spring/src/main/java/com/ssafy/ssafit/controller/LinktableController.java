package com.ssafy.ssafit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.service.LinktableService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "링크테이블 컨트롤러")
@RequestMapping("/api-linktable")
public class LinktableController {
	
	@Autowired
	private LinktableService linktableService;

	//일단 사용할거 없어서 보류 
	//추가 기능 넣으면 쓸지도?? 아닐지도 
}
