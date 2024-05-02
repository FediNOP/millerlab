package org.example.millerlab.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.example.millerlab.MeetingRepo;
import org.example.millerlab.dto.Meeting;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingRepo meetingRepo;

    @GetMapping("/")
    public String showSignUpForm(Model model, @Param("keyword") String keyword) {
        try {
            if (StringUtils.isEmpty(keyword)) {
                model.addAttribute("meetingList", meetingRepo.findAll());
            } else {
                List<Meeting> meetings = meetingRepo.findByInvestorContainsIgnoreCase(keyword);
                model.addAttribute("meetingList", meetings);
            }
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "meetings";
    }

    @GetMapping("/new")
    public String addMeeting(Model model) {
        Meeting meeting = new Meeting();

        model.addAttribute("meeting", meeting);

        return "meeting-form";
    }

    @PostMapping("/save")
    public String saveMeeting(Meeting meeting, RedirectAttributes redirectAttributes) {
        try {
            meetingRepo.save(meeting);

            redirectAttributes.addFlashAttribute("message", "Заседание успешно создан!");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Meeting meeting = meetingRepo.findById(id).get();

            model.addAttribute("meeting", meeting);

            return "meeting-form";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {

            meetingRepo.deleteById(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/";
    }

}
