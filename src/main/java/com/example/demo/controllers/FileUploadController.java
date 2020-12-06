package com.example.demo.controllers;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    private String RUTA_UPLOAD = this.getClass().getClassLoader().getResource("").getPath() +"static/profiles/";
    private String RUTA_UPLOAD2 = "E:/Programas Estudio/DesktopGitHub/Repositorios locales/AulaVirtual/src/main/resources/static/profiles/";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file")MultipartFile file) throws IOException{
        if (file==null || file.isEmpty()){
            System.out.println("vacio");
        }
        StringBuilder builder = new StringBuilder();
        builder.append(RUTA_UPLOAD2);
        builder.append(file.getOriginalFilename());

        byte[] fileBytes = file.getBytes();
        Path path = Paths.get(builder.toString());
        Files.write(path, fileBytes);

        System.out.println("Cargado bien");
        return "redirect:/";
    }

    /*@RequestMapping(value = "/test", method = RequestMethod.GET)
    public String index(){
        return "upload";
    }*/
}
