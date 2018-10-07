package com.example.versioning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VersionController {

    @RequestMapping(value = "api/v1/version")
    public String getVersionv1ByUrl(){
        return "v1 by Url";
    }

    @RequestMapping(value = "api/v2/version")
    public String getVersionv2ByUrl(){
        return "v2 by Url";
    }

    @RequestMapping(value = "api/version", produces = "application/v1")
    public String getVersionv1ByContentType(){
        return "v1 by ContentType";
    }

    @RequestMapping(value = "api/version", produces = "application/v2")
    public String getVersionv2ByContentType(){
        return "v2 by ContentType";
    }
}
