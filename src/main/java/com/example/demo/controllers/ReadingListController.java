package com.example.demo.controllers;

import com.example.demo.beans.Book;
import com.example.demo.beans.interfaces.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {

    @Autowired
    private ReadingListRepository readingListRepository;

    @RequestMapping(value = "/{reader}",method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader")String reader, Model model){
      List<Book> readingList = readingListRepository.findByReader(reader);
      if(readingList != null && readingList.size()>0){
          model.addAttribute("books",readingList);
      }
        return "readingList";

    }

    @RequestMapping(value = "/{reader}",method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return  "redirect:/readingList/{reader}";
    }
}
