package com.bankapi.bankapi.controller;

import com.bankapi.bankapi.model.dormat.*;
import com.bankapi.bankapi.model.dormatsys.*;
import com.bankapi.bankapi.sevice.iml.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.controller
 * @program: bankapi
 * @className: MainController
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-18  22:42
 * @description: TODO
 **/

@Controller
@RequestMapping(value = "user")
public class MainController {

    @Autowired
    UserServiceIml userServiceIml;

    @Autowired
    DepartmentServiceIml departmentServiceIml;

    @ResponseBody
    @RequestMapping(value = "getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userServiceIml.findAllUsers();
    }

    @ResponseBody
    @RequestMapping(value = "getalldepartment", method = RequestMethod.GET)
    public List<Department> getDepartmentServiceIml() {
        return departmentServiceIml.getDepartmentList();
    }

    @RequestMapping(value = "UID", method = RequestMethod.GET)
    @ResponseBody
    public String UID() {
        Long uid = System.currentTimeMillis();
        if (uid % 2 == 0) {
            return "public static final Long serialVersionUID =" + uid + "L;";
        } else {
            return "public static final Long serialVersionUID =" + "-" + uid + "L;";
        }

    }

    @Autowired
    UserStockRoomServiceIml userStockRoomServiceIml;

    @ResponseBody
    @RequestMapping(value = "getUserStockRoom", method = RequestMethod.GET)
    public List<UserStockRoom> getUserStockRooms() {
        return userStockRoomServiceIml.getUserStockRooms();
    }

    @Autowired
    RoleServiceIml roleServiceIml;

    @ResponseBody
    @RequestMapping(value = "getAllRoles", method = RequestMethod.GET)
    public List<Role> getAllRoles() {
        return roleServiceIml.getALlRoles();
    }

    @Autowired
    RoleMenuServiceIml roleMenuServiceIml;

    @ResponseBody
    @RequestMapping(value = "getRoleMune", method = RequestMethod.GET)
    public List<RoleMenu> getReolMenus() {
        return roleMenuServiceIml.getRoles();
    }

    @Autowired
    DataDictionaryServiceIml dataDictionaryServiceIml;

    @RequestMapping(value = "getDataDictionary", method = RequestMethod.GET)
    @ResponseBody
    public List<DataDictionary> getRequestMethod() {
        return dataDictionaryServiceIml.getDataDictionary();
    }

    @Autowired
    MenuServiceIml menuServiceIml;

    @RequestMapping(method = RequestMethod.GET, value = "getMenus")
    @ResponseBody
    public List<Menu> getMenus() {
        return menuServiceIml.getMenuList();
    }

    @Autowired
    UserRoleServiceIml userRoleServiceIml;

    @ResponseBody
    @RequestMapping(value = "getUserRole", method = RequestMethod.GET)
    public List<UserRole> getUserRoles() {

        return userRoleServiceIml.getUserRoleList();
    }

    @Autowired
    ApprovalProcessTaskBatchServiceIml approvalProcessTaskBatchServiceIml;

    @RequestMapping(value = "getApprovalProcessTasks", method = RequestMethod.GET)
    @ResponseBody
    public List<ApprovalProcessTaskBatch> getApprovalProcessTasks() {
        return approvalProcessTaskBatchServiceIml.getApprovalProcessTasks();
    }

    @Autowired
    ApprovalProcessEventDaoServiceIml approvalProcessEventDaoServiceIml;

    @ResponseBody
    @RequestMapping(value = "getApprovalProcessEvents", method = RequestMethod.GET)
    public List<ApprovalProcessEvent> getApprovalProcessEvents() {
        return approvalProcessEventDaoServiceIml.getApprovalProcessEvents();
    }

    @Autowired
    BatchImportConstraintServiceIml batchImportConstraintServiceIml;

    @ResponseBody
    @RequestMapping(value = "getBatchImportConstraints", method = RequestMethod.GET)
    public List<BatchImportConstraint> getBatchImportConstraint() {
        return batchImportConstraintServiceIml.getBatchImportConstraints();
    }

    @Autowired
    SubsidyItemServiceIml subsidyItemServiceIml;

    @RequestMapping(value = "getSubsidyItems", method = RequestMethod.GET)
    @ResponseBody
    public List<SubsidyItem> getSubsidyItems() {
        return subsidyItemServiceIml.getSubsidyItems();
    }

    @Autowired
    LocalIndicatorAllocationServiceIml localIndicatorAllocationServiceIml;

    @RequestMapping(value = "getLocalIndicatorAllocationList", method = RequestMethod.GET)
    @ResponseBody
    public List<LocalIndicatorAllocation> getLocalIndicatorAllocationList(){
       return localIndicatorAllocationServiceIml.getAllocation();
    }

}
