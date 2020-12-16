package com.djc.scene.controller;

import com.djc.scene.domain.result.ErrorResult;
import com.djc.scene.domain.result.ResultCode;
import com.djc.scene.domain.result.ResultJson;
import com.djc.scene.dto.UserDto;
import com.djc.scene.dto.IOSCertDto;
import com.djc.scene.facade.SceneFacade;
import com.djc.scene.validator.SceneValidator;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.validation.Valid;
import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class SceneController {
    @Resource
    private SceneFacade sceneFacade;

    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new SceneValidator());
    }

    @RequestMapping( value = "/upload",method = RequestMethod.POST)
    public ResultJson uploadFile(MultipartFile file, @Valid IOSCertDto iosCertDto, BindingResult result){
        if(result.hasErrors()){
            List<ErrorResult> errorResults = this.errorList(result.getAllErrors());
            return ResultJson.failed(errorResults,ResultCode.BAD_REQUEST);
        }
        String certDate = sceneFacade.saveConfig(file,iosCertDto);
        return  ResultJson.success(certDate);
    }

    @RequestMapping( value = "/user/get",method = RequestMethod.POST)
    public ResultJson getUser(@RequestBody @Valid UserDto userDto, BindingResult result){
        if(result.hasErrors()){
            List<ErrorResult> errorResults = this.errorList(result.getAllErrors());
            return ResultJson.failed(errorResults,ResultCode.BAD_REQUEST);
        }
        return ResultJson.success(sceneFacade.obtainUser(userDto));
    }

    @RequestMapping( value = "/user/save",method = RequestMethod.POST)
    public ResultJson saveUser(@RequestBody @Valid UserDto userDto, BindingResult result){
        if(result.hasErrors()){
            List<ErrorResult> errorResults = this.errorList(result.getAllErrors());
            return ResultJson.failed(errorResults,ResultCode.BAD_REQUEST);
        }
        try{
            sceneFacade.saveUser(userDto);
            return ResultJson.success();
        }catch(Exception e) {
            return ResultJson.failed(ResultCode.BAD_REQUEST,e.getMessage());
        }
    }

    private List<ErrorResult> errorList(List<ObjectError> objectErrors){
        List<ErrorResult> errorResults = new ArrayList<>();
        Iterator<ObjectError> iterator = objectErrors.iterator();
        while(iterator.hasNext()){
            FieldError fieldError = (FieldError) iterator.next();
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            ErrorResult errorResult = new ErrorResult(fieldName,errorMessage);
            errorResults.add(errorResult);
        }
        return errorResults;
    }
}
