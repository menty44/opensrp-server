package org.opensrp.web.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.awt.peer.LightweightPeer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONException;
import org.opensrp.connector.openmrs.service.OpenmrsUserService;

import org.opensrp.dashboard.domain.DashboardLocation;
import org.opensrp.dashboard.domain.LocationTag;
import org.opensrp.dashboard.dto.DashboardLocationDTO;
import org.opensrp.dashboard.dto.LocationTagDTO;
import org.opensrp.dashboard.dto.PrivilegeDTO;
import org.opensrp.dashboard.dto.RoleDTO;
import org.opensrp.dashboard.dto.UserDTO;

import org.opensrp.service.LocationService;
import org.opensrp.dashboard.service.DashboardLocationService;
import org.opensrp.dashboard.service.LocationTagService;
import org.opensrp.dashboard.service.PrivilegeService;
import org.opensrp.dashboard.service.RoleService;
import org.opensrp.dashboard.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class AclController {

	private RoleService roleService;
		
	private OpenmrsUserService openmrsUserService;
	private PrivilegeService privilegeService;
	private UsersService userService;
	private DashboardLocationService dashboardLocationService;
	private LocationTagService locationTagService;
	private static Logger logger = LoggerFactory.getLogger(AclController.class);

	@Autowired
	public AclController(RoleService roleService, 
			OpenmrsUserService openmrsUserService, PrivilegeService privilegeService,
			UsersService userService, DashboardLocationService dashboardLocationService,
			LocationTagService locationTagService) {
		this.roleService = roleService;
		
		this.openmrsUserService = openmrsUserService;		
		this.privilegeService = privilegeService;
		this.userService = userService;
		this.dashboardLocationService = dashboardLocationService;
		this.locationTagService = locationTagService;
	}

	
	
	@RequestMapping(headers = { "Accept=application/json" }, method = POST, value = "/add-privilege")
	public ResponseEntity<String> addPrivilege(@RequestBody PrivilegeDTO privilegeDTO) {
		logger.info("request received for creating privilege with name- " + privilegeDTO.getName());
		String message = privilegeService.addPrivilege(privilegeDTO);		
		//return new ResponseEntity<>(message,OK);
		return new ResponseEntity<>(message,OK);
		//return "1";
	}
	
	@RequestMapping(method = GET, value = "/privilege-by-name")
	@ResponseBody
	public PrivilegeDTO getPrivilegeByName(@RequestParam String privilegeName) {
		logger.info("requeset reached with - " + privilegeName );
		return privilegeService.getPrivilegeByName(privilegeName);
	}
	
	@RequestMapping(method = GET, value = "/all-privileges")
	@ResponseBody
	public ArrayList<PrivilegeDTO> getPrivileges() {
		logger.info("getting all privileges " );
		return privilegeService.getAllPrivileges();
	}
	
	@RequestMapping(headers = { "Accept=application/json" }, method = POST, value = "/edit-privilege")
	public ResponseEntity<String> editPrivilege(@RequestBody PrivilegeDTO privilegeDTO) {
		logger.info("received status - " + privilegeDTO.getStatus());
		String message = privilegeService.editPrivilege(privilegeDTO);		
		return new ResponseEntity<>(message,OK);
	}
	
	@RequestMapping(headers = { "Accept=application/json" }, method = POST, value = "/add-role")
	public ResponseEntity<String> addRole(@RequestBody RoleDTO roleDTO) {
		logger.info("create request received for role - " + roleDTO.getName());
		/*List<PrivilegeDTO> privileges = roleDTO.getPrivileges();
		for(int i = 0 ; i < privileges.size(); i++){
			logger.info("Privilege name - " + privileges.get(i).getName() + " - id - " + privileges.get(i).getId());
		}*/
		String message = roleService.addRole(roleDTO);//privilegeService.addPrivilege(privilegeDTO);		
		return new ResponseEntity<>(message,OK);
		//return new ResponseEntity<>("1",OK);
		//return "1";
	}
	
	@RequestMapping(headers = { "Accept=application/json" }, method = POST, value = "/edit-role")
	public ResponseEntity<String> editRole(@RequestBody RoleDTO roleDTO) {
		logger.info("create request received for role - " + roleDTO.getName());
		String message = roleService.editRole(roleDTO);//privilegeService.addPrivilege(privilegeDTO);		
		return new ResponseEntity<>(message,OK);
		//return new ResponseEntity<>("1",OK);
		//return "1";
	}
	
	@RequestMapping(method = GET, value = "role-by-name")
	@ResponseBody
	public RoleDTO getRoleByName(@RequestParam String roleName) {
		logger.info("requeset reached with - " + roleName );
		return roleService.getRoleByName(roleName);
	}
	
	@RequestMapping(headers = { "Accept=application/json" }, method = POST, value = "/add-user")
	public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
		logger.info("create request received for user - " + userDTO.getName());
		
		String message = userService.addUser(userDTO);		
		return new ResponseEntity<>(message,OK);
	}
	
	@RequestMapping(headers = { "Accept=application/json" }, method = POST, value = "/edit-user")
	public ResponseEntity<String> editUser(@RequestBody UserDTO userDTO) {
		logger.info("update request received for user - " + userDTO.getUserName());
		
		String message = userService.editUser(userDTO);		
		return new ResponseEntity<>(message,OK);
	}
	
	@RequestMapping( method = GET, value = "/valid-username")
	@ResponseBody
	public ResponseEntity<String> isUsernameAvailable(@RequestParam String userName) {
		logger.info("check if user with name -" + userName + " exists.");
		String message = userService.ifUserExists(userName);		
		return new ResponseEntity<>(message,OK);
	}
	
	@RequestMapping(headers = { "Accept=application/json" }, method = POST, value = "/add-location-tag")
	public ResponseEntity<String> addLocationTag(@RequestBody LocationTagDTO locationTagDTO) {
		logger.info("create request received for locationTag - " + locationTagDTO.getName());
		
		String message = locationTagService.addLocationTag(locationTagDTO);		
		return new ResponseEntity<>(message,OK);
	}
	
	@RequestMapping(headers = { "Accept=application/json" }, method = POST, value = "/edit-location-tag")
	public ResponseEntity<String> editLocationTag(@RequestBody LocationTagDTO locationTagDTO) {
		logger.info("edit request received for locationTag - " + locationTagDTO.getName());
		
		String message = locationTagService.editLocationTag(locationTagDTO);		
		return new ResponseEntity<>(message,OK);
	}
	
	@RequestMapping( method = DELETE, value = "/delete-location-tag")
	public ResponseEntity<String> deleteLocationTag(@RequestParam String locationTagId) {
		logger.info("delete request received for locationTag with Id- " + locationTagId);
		
		String message = locationTagService.deleteLocationTag(locationTagId);		
		return new ResponseEntity<>(message,OK);
	}
	
	@RequestMapping(headers = { "Accept=application/json" }, method = POST, value = "/add-dashboard-location")
	public ResponseEntity<String> addDashboardLocation(@RequestBody DashboardLocationDTO dashboardLoactionDTO) {
		logger.info("create request received for dashboardLocation - " + dashboardLoactionDTO.getName() + " with parentId" + dashboardLoactionDTO.getParentId());
		
		String message = dashboardLocationService.addDashboardLocation(dashboardLoactionDTO);		
		return new ResponseEntity<>(message,OK);
	}
	
	@RequestMapping(headers = { "Accept=application/json" }, method = POST, value = "/edit-dashboard-location")
	public ResponseEntity<String> editDashboardLocation(@RequestBody DashboardLocationDTO dashboardloactionDTO) {
		logger.info("edit request received for dashboardLocation with id- " + dashboardloactionDTO.getId());
		
		String message = dashboardLocationService.editDashboardLocation(dashboardloactionDTO);
		return new ResponseEntity<>(message,OK);
	}
	
	@RequestMapping( method = DELETE, value = "/delete-dashboard-location")
	public ResponseEntity<String> deleteDashboardLocation(@RequestParam String dashboardLocationId) {
		logger.info("delete request received for dashboardLocation with id - " + dashboardLocationId);
		
		String message = dashboardLocationService.deleteDashboardLocation(dashboardLocationId);		
		return new ResponseEntity<>(message,OK);
	}
	
	@RequestMapping( method = GET, value = "/get-children-locations")
	@ResponseBody
	public List<DashboardLocationDTO> getChildrenLocations(@RequestParam String dashboardLocationId) {
		logger.info("fetch request for children locations of id -" + dashboardLocationId);
		List<DashboardLocationDTO> childrenLocations = dashboardLocationService.getChildrenLocations(dashboardLocationId);
		//return new ResponseEntity<>(childrenLocations,OK);
		return childrenLocations;
	}
	
	@RequestMapping( method = GET, value = "/get-upazillas")
	@ResponseBody
	public List<DashboardLocationDTO> getUpazillas() {
		List<DashboardLocationDTO> upazillas = dashboardLocationService.getUpazillas();
		return upazillas;
	}
	
	@RequestMapping( method = GET, value = "/get-all-location-tags")
	@ResponseBody
	public List<LocationTagDTO> getAllLocationTags() {
		List<LocationTagDTO> allLocationTags = locationTagService.getAllLocationTags();
		return allLocationTags;
	}
	
	@RequestMapping( method = GET, value = "/get-locations-by-parent-and-tag")
	@ResponseBody
	public List<DashboardLocationDTO> getDashboardLocationsByParentAndTag(@RequestParam String parentLocationId, @RequestParam String tagId) {
		logger.info("fetch request for locations wiht parent -" + parentLocationId + " and tag- " + tagId);
		List<DashboardLocationDTO> locations = dashboardLocationService.getDashboardLocationsByParentAndTag(parentLocationId, tagId);
		//return new ResponseEntity<>(childrenLocations,OK);
		return locations;
	}
	
	@RequestMapping( method = GET, value = "/get-children-locations-of-root")
	@ResponseBody
	public List<DashboardLocationDTO> getChildrenLocationsOfRoot() {
		List<DashboardLocationDTO> locations = dashboardLocationService.getChildrenLocationsOfRoot();
		//return new ResponseEntity<>(childrenLocations,OK);
		return locations;
	}
}