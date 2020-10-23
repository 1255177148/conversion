package com.hezhan.conversion.controller;

import com.hezhan.conversion.util.ConversionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author hezhan
 * @Date 2020/10/21 16:23
 */
@Api(value = "pdf和word互转", tags = "pdf和word互转")
@RestController
@RequestMapping("/api/conversion")
public class ConversionController {

    @Autowired
    private ConversionUtil conversionUtil;

    @ApiOperation(value = "word转pdf", notes = "word转pdf", httpMethod = "POST")
    @ApiImplicitParam(name = "file", value = "word文件", dataType = "__file", paramType = "form")
    @PostMapping("/pdf")
    public void toPdf(@RequestParam("file") MultipartFile file,
                      HttpServletResponse response) throws Exception {
        conversionUtil.toPdf(response, file);
    }

    @ApiOperation(value = "pdf转doc", notes = "pdf转doc", httpMethod = "POST")
    @ApiImplicitParam(name = "file", value = "pdf文件", dataType = "__file", paramType = "form")
    @PostMapping("/doc")
    public void toDoc(@RequestParam("file") MultipartFile file,
                      HttpServletResponse response) throws Exception {
        conversionUtil.toDoc(response, file);
    }
}
