package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.dto.Group;
import com.ssafy.ssafit.dto.Groupcreate;
import com.ssafy.ssafit.dto.Inviteuser;
import com.ssafy.ssafit.dto.Linktable;
import com.ssafy.ssafit.dto.User;
import com.ssafy.ssafit.service.GroupService;
import com.ssafy.ssafit.service.LinktableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "그룹 컨트롤러")
@RequestMapping("/api-group")
public class GroupController {

	@Autowired
	private GroupService groupService;
	@Autowired
	private LinktableService linktableService;

	// 1. 해당 유저에 맞는 그룹 가져오기
	@ApiOperation(value = "그룹 목록")
	@GetMapping("/group")
	public ResponseEntity<?> list(int userid) {
		List<Group> listgroup = groupService.getGroupList(userid);
		if (listgroup == null || listgroup.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Group>>(listgroup, HttpStatus.OK);
	}

	// 2. 그룹 하나 가져오기
	@ApiOperation(value = "그룹 하나 선택!")
	@GetMapping("/group/{groupid}")
	public ResponseEntity<Group> regist(@PathVariable int groupid) {
		Group group = groupService.getGroup(groupid);
		return new ResponseEntity<Group>(group, HttpStatus.OK);
	}

	//3. 그룹 수정
	@ApiOperation(value = "정보 수정")
	@PutMapping("/group")
	public ResponseEntity<Void> update(Group group) {
		groupService.modifyGroup(group);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	//4. 그룹네임으로 검색
	@ApiOperation(value = "그룹네임으로 검색")
	@GetMapping("/search")
	public ResponseEntity<?> search(String groupname) {
		List<Group> groups = groupService.searchGroup(groupname);
		if (groups == null || groups.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
	}
	
	//5. 그룹 등록하기
	@ApiOperation(value="그룹 등록하기")
	@PostMapping("/group")
	public ResponseEntity<Integer> signup(@RequestBody Groupcreate g) {
		
		Group group = new Group(g.getId(),g.getName(),g.getPassword(),g.getDetail(),g.getNotice(),g.getMaster());
		int userid = g.getUserid();
		int result = groupService.registGroup(group);
		int lastnum = groupService.getlastGroup();
		Linktable linktable = new Linktable(0,userid,lastnum);
		linktableService.registLinktable(linktable);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	//6. 그룹에 유저 추가하기! 
	@ApiOperation(value="그룹에 유저 추가하기 ")
	@PostMapping("/invite")
	public ResponseEntity<Integer> inviteuser(@RequestBody Inviteuser i) {
		System.out.println(i);
		User user = new User(i.getId(),i.getPassword(),i.getNickname(),i.getUser_id(),i.getHeight(),i.getWeight(),i.getExp());
		int groupid = i.getGroupid();
		System.out.println(user);
		System.out.println(groupid);
		Linktable linktable = new Linktable(0,user.getId(),groupid);
		linktableService.registLinktable(linktable);
		return new ResponseEntity<Integer>(groupid, HttpStatus.CREATED);
	}
	

}
