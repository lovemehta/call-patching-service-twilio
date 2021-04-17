// package com.nutripal.cps.controller;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
// import com.nutripal.cps.enums.CpsError;
// import com.nutripal.cps.response.BaseResponse;
// import com.nutripal.cps.response.ServiceResponse;
// import com.nutripal.cps.service.CallingService;
//
//
// @RestController
// @CrossOrigin(origins = "*", allowedHeaders = "*")
// @RequestMapping("/v1/callback")
// public class CallbackController {
//
// @Autowired
// private CallingService callingService;
//
// @RequestMapping(value = "/record", method = RequestMethod.POST)
// public ServiceResponse<BaseResponse> recordDataCallbackMethod() {
//
// if (callCreationDto.getRecord() == null) {
// callCreationDto.setRecord(Boolean.FALSE);
// }
//
// String response = callingService.tryToCallTwilioUsing(callCreationDto.getTo(),
// callCreationDto.getFrom(), callCreationDto.getFromNumberType(), callCreationDto.getRecord(),
// callCreationDto.getDataWebhookUrl());
//
// return new ServiceResponse<BaseResponse>(new BaseResponse(CpsError.NO_ERROR, response));
// }
//
//
// @RequestMapping(value = "/data", method = RequestMethod.POST)
// public ServiceResponse<BaseResponse> callDataCallbackMethod() {
//
// if (callCreationDto.getRecord() == null) {
// callCreationDto.setRecord(Boolean.FALSE);
// }
//
// String response = callingService.tryToCallTwilioUsing(callCreationDto.getTo(),
// callCreationDto.getFrom(), callCreationDto.getFromNumberType(), callCreationDto.getRecord(),
// callCreationDto.getDataWebhookUrl());
//
// return new ServiceResponse<BaseResponse>(new BaseResponse(CpsError.NO_ERROR, response));
// }
// }
//
