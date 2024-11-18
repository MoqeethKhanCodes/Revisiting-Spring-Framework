package org.moqeeth.controller;

import org.moqeeth.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/")
    public String homepage() {
        return "index";
    }

    @PostMapping("/create")
    public String createFile(@RequestParam("filename") String fileName, Model model) {
        try {
            String message = fileService.createFile(fileName);
            model.addAttribute("message", message);
        } catch (IOException ioException) {
            model.addAttribute("message", "Error creating file: " + ioException.getMessage());
        }

        return "index";
    }

    @PostMapping("/read")
    public String readFile(@RequestParam("filename") String content, Model model) {
        try {
            String fileContent = fileService.readFile(content);
            model.addAttribute("content", fileContent);
        } catch (IOException ioException) {
            model.addAttribute("message", "Error creating file: " + ioException.getMessage());
        }

        return "index";
    }

    @PostMapping("/write")
    public String writeFile(@RequestParam("filename") String fileName, @RequestParam("content") String content, Model model) {
        try {
            String message = fileService.writeFile(fileName, content);
            model.addAttribute("message", message);
        } catch (IOException ioException) {
            model.addAttribute("message", "Error creating file: " + ioException.getMessage());
        }
        return "index";
    }

    @PostMapping("/rename")
    public String renameFile(@RequestParam("oldName") String oldFileName, @RequestParam("newName") String newFileName, Model model) {
        try {
            String message = fileService.renameFile(oldFileName, newFileName);
            model.addAttribute("message", message);
        } catch (IOException ioException) {
            model.addAttribute("message", "Error creating file: " + ioException.getMessage());
        }
        return "index";
    }

    @PostMapping("/delete")
    public String deleteFile(@RequestParam("filename") String deleteFileName, Model model) {
        try {
            String message = fileService.deleteFile(deleteFileName);
            model.addAttribute("message", message);
        } catch (IOException ioException) {
            model.addAttribute("message", "Error creating file: " + ioException.getMessage());
        }
        return "index";
    }

}
