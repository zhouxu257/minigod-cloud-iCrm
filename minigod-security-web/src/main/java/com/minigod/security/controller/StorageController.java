package com.minigod.security.controller;

import com.minigod.security.helper.ImageStorageHelper;
import com.minigod.storage.helper.StorageHelper;
import com.minigod.storage.protocol.model.SysStorage;
import com.minigod.storage.service.SysStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象存储服务
 */
@RestController
@RequestMapping("/storage")
@Validated
@Slf4j
public class StorageController {
    @Autowired
    ImageStorageHelper imageStorageHelper;
    @Autowired
    private StorageHelper storageHelper;
    @Autowired
    private SysStorageService sysStorageService;


    private Map<String, String> createResult(SysStorage SysStorage) {
        Map<String, String> result = new HashMap<>();

        result.put("url", SysStorage.getUrl());
        return result;
    }

    @GetMapping("/file/{key:.+}")
    public ResponseEntity<Resource> fetch(@PathVariable String key) {
        SysStorage SysStorage = sysStorageService.findByKey(key);
        if (key == null) {
            return ResponseEntity.notFound().build();
        }
        if (key.contains("../")) {
            return ResponseEntity.badRequest().build();
        }
        String type = SysStorage.getType();
        MediaType mediaType = MediaType.parseMediaType(type);

        Resource file = storageHelper.loadAsResource(key);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(mediaType).body(file);
    }


//    @GetMapping("/file/**")
//    public ResponseEntity<Resource> fetch(HttpServletRequest  request) {
//
//        String path = request.getServletPath();
//
//        String regStr = "/file/";
//        String filePath = path.substring(path.indexOf(regStr) + regStr.length(), path.length());
//
//        Resource file = imageStorageHelper.loadImg(filePath);
//        if (file == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().body(file);
//    }
}
